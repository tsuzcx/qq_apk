package com.tencent.vas.update.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.vas.update.VasUpdateSystem;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IDbManager.ItemInfo;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.entity.db.Preload;
import com.tencent.vas.update.entity.db.PreloadItem;
import com.tencent.vas.update.entity.db.SeqConfigEntity;
import com.tencent.vas.update.entity.db.SyncItemRecord;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskSyncReq
{
  private static final String TAG = "VasUpdate_TaskSyncReq";
  private HashMap<String, ItemLocalVerPrt> mArrayExistItem;
  private int mDLFrom;
  private SeqConfigEntity mSeqConfig;
  private int mSyncMode;
  
  public TaskSyncReq(int paramInt)
  {
    this.mDLFrom = paramInt;
    this.mArrayExistItem = new HashMap();
  }
  
  private void addLocalShouldUpdate(HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    Object localObject1 = VasUpdateWrapper.getDbManager().selectAllItem(1);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Object localObject2 = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getShouldUpdateList add table_should_update size = ");
      localStringBuilder.append(((List)localObject1).size());
      ((IVasLog)localObject2).d("VasUpdate_TaskSyncReq", localStringBuilder.toString());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IDbManager.ItemInfo)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ItemUpdateVerPtr.parseJsonToItemUpdateVerPrt(((IDbManager.ItemInfo)localObject2).content);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((ItemUpdateVerPtr)localObject2).mItemId)))
          {
            if (!((ItemUpdateVerPtr)localObject2).checkItemIsCurrentVersion())
            {
              VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "seq addLocalShouldUpdate item continue , version not fit");
            }
            else
            {
              ((ItemUpdateVerPtr)localObject2).mFrom = "silent_update";
              paramHashMap.put(((ItemUpdateVerPtr)localObject2).mItemId, localObject2);
            }
          }
          else {
            VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "addLocalShouldUpdate item = null or itemId = null ");
          }
        }
      }
    }
  }
  
  private void addPreloadItem(HashMap<String, ItemUpdateVerPtr> paramHashMap, int paramInt, ArrayList<PreloadItem> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (PreloadItem)paramArrayList.next();
      if (localObject1 != null)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        if ((!paramHashMap.containsKey(((PreloadItem)localObject1).mItemId)) && (!TextUtils.isEmpty(((PreloadItem)localObject1).mItemId)))
        {
          if (!isNetWorkValid(paramInt, ((PreloadItem)localObject1).mFlag))
          {
            localObject2 = VasUpdateWrapper.getLog();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("addPreloadItem network invalid , localNetType = ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" , mFlag = ");
            localStringBuilder.append(((PreloadItem)localObject1).mFlag);
            localStringBuilder.append(" , itemId = ");
            localStringBuilder.append(((PreloadItem)localObject1).mItemId);
            ((IVasLog)localObject2).e("VasUpdate_TaskSyncReq", localStringBuilder.toString());
          }
          else
          {
            localObject2 = new ItemUpdateVerPtr();
            ((ItemUpdateVerPtr)localObject2).mItemId = ((PreloadItem)localObject1).mItemId;
            ((ItemUpdateVerPtr)localObject2).mSrcMd5 = "";
            ((ItemUpdateVerPtr)localObject2).mDstMd5 = "";
            ((ItemUpdateVerPtr)localObject2).mFrom = "silent_update";
            ((ItemUpdateVerPtr)localObject2).mLastRunTime = 0L;
            ((ItemUpdateVerPtr)localObject2).mRunCount = 0;
            paramHashMap.put(((ItemUpdateVerPtr)localObject2).mItemId, localObject2);
            VasUpdateWrapper.getDbManager().updateItem(1, ((ItemUpdateVerPtr)localObject2).mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson((ItemUpdateVerPtr)localObject2));
            localObject1 = VasUpdateWrapper.getLog();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getShouldUpdateList preload item add , id = ");
            localStringBuilder.append(((ItemUpdateVerPtr)localObject2).mItemId);
            ((IVasLog)localObject1).i("VasUpdate_TaskSyncReq", localStringBuilder.toString());
          }
        }
        else
        {
          localObject2 = VasUpdateWrapper.getLog();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("addPreloadItem itemId = null , currentId = ");
          localStringBuilder.append(((PreloadItem)localObject1).mItemId);
          ((IVasLog)localObject2).e("VasUpdate_TaskSyncReq", localStringBuilder.toString());
        }
      }
    }
  }
  
  private void addSyncItemUpdate(HashMap<String, ItemUpdateVerPtr> paramHashMap, ArrayList<SyncItemRecord> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      SyncItemRecord localSyncItemRecord = (SyncItemRecord)localIterator.next();
      if (localSyncItemRecord != null)
      {
        long l = CommonUtil.sParseBidId(localSyncItemRecord.mItemId);
        paramArrayList = CommonUtil.sParseScid(localSyncItemRecord.mItemId);
        Object localObject = VasUpdateSystem.getInstance().getObserver(l);
        if (localObject == null)
        {
          paramArrayList = VasUpdateWrapper.getLog();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getShouldUpdateList currentItem not register , itemId = ");
          ((StringBuilder)localObject).append(localSyncItemRecord.mItemId);
          paramArrayList.e("VasUpdate_TaskSyncReq", ((StringBuilder)localObject).toString());
          VasUpdateWrapper.getDbManager().deleteItem(1, localSyncItemRecord.mItemId);
        }
        else
        {
          BusinessItemInfo localBusinessItemInfo = ((IBusinessCallback)localObject).getBusinessItemInfo(l, paramArrayList);
          if (localBusinessItemInfo == null)
          {
            paramArrayList = VasUpdateWrapper.getLog();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getShouldUpdateList getItemInfo fail , itemId = ");
            ((StringBuilder)localObject).append(localSyncItemRecord.mItemId);
            paramArrayList.e("VasUpdate_TaskSyncReq", ((StringBuilder)localObject).toString());
            VasUpdateWrapper.getDbManager().deleteItem(1, localSyncItemRecord.mItemId);
          }
          else
          {
            BusinessUpdateParams localBusinessUpdateParams = new BusinessUpdateParams(l, paramArrayList, "silent_update");
            if (localSyncItemRecord.mType == 2)
            {
              VasUpdateWrapper.getDbManager().deleteItem(0, localSyncItemRecord.mItemId);
              VasUpdateWrapper.getDbManager().deleteItem(1, localSyncItemRecord.mItemId);
              paramHashMap.remove(localSyncItemRecord.mItemId);
              ((IBusinessCallback)localObject).deleteFile(localBusinessUpdateParams, localBusinessItemInfo);
              paramArrayList = VasUpdateWrapper.getLog();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getShouldUpdateList item type delete , id = ");
              ((StringBuilder)localObject).append(localSyncItemRecord.mItemId);
              paramArrayList.e("VasUpdate_TaskSyncReq", ((StringBuilder)localObject).toString());
            }
            else
            {
              paramArrayList = null;
              String str = VasUpdateWrapper.getDbManager().selectItem(0, localSyncItemRecord.mItemId);
              if (!TextUtils.isEmpty(str)) {
                paramArrayList = ItemLocalVerPrt.parseJsonToItemLocalVerPrt(str);
              }
              if (paramArrayList == null)
              {
                paramArrayList = VasUpdateWrapper.getLog();
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("getShouldUpdateList local item doesn't match , id = ");
                ((StringBuilder)localObject).append(localSyncItemRecord.mItemId);
                paramArrayList.e("VasUpdate_TaskSyncReq", ((StringBuilder)localObject).toString());
              }
              else if (((paramArrayList.mMd5 != null) && (!paramArrayList.mMd5.equalsIgnoreCase(localSyncItemRecord.mMD5))) || (!((IBusinessCallback)localObject).isFileExist(localBusinessUpdateParams, localBusinessItemInfo)))
              {
                localObject = new ItemUpdateVerPtr();
                ((ItemUpdateVerPtr)localObject).mItemId = localSyncItemRecord.mItemId;
                if (paramArrayList != null) {
                  paramArrayList = paramArrayList.mMd5;
                } else {
                  paramArrayList = "";
                }
                ((ItemUpdateVerPtr)localObject).mSrcMd5 = paramArrayList;
                ((ItemUpdateVerPtr)localObject).mDstMd5 = localSyncItemRecord.mMD5;
                ((ItemUpdateVerPtr)localObject).mFrom = "silent_update";
                ((ItemUpdateVerPtr)localObject).mLastRunTime = 0L;
                ((ItemUpdateVerPtr)localObject).mRunCount = 0;
                ((ItemUpdateVerPtr)localObject).mAppVersion = localSyncItemRecord.mAppVersion;
                paramHashMap.put(((ItemUpdateVerPtr)localObject).mItemId, localObject);
                VasUpdateWrapper.getDbManager().updateItem(1, ((ItemUpdateVerPtr)localObject).mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson((ItemUpdateVerPtr)localObject));
                paramArrayList = VasUpdateWrapper.getLog();
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("getShouldUpdateList local item check need update , id = ");
                ((StringBuilder)localObject).append(localSyncItemRecord.mItemId);
                paramArrayList.i("VasUpdate_TaskSyncReq", ((StringBuilder)localObject).toString());
              }
            }
          }
        }
      }
    }
  }
  
  private String getRequestContent()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("seq", this.mSeqConfig.mSeq);
      localJSONObject.put("sync_mode", this.mSyncMode);
      localJSONObject.put("plver", this.mSeqConfig.mPreloadVer);
      localJSONObject.put("item_list", parseItemLocalVerList(this.mArrayExistItem));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sync getRequestContent = ");
    localStringBuilder.append(localJSONObject.toString());
    localIVasLog.e("VasUpdate_TaskSyncReq", localStringBuilder.toString());
    return localJSONObject.toString();
  }
  
  private HashMap<String, ItemUpdateVerPtr> getShouldUpdateList(@NonNull TaskSyncRsp paramTaskSyncRsp)
  {
    HashMap localHashMap = new HashMap();
    VasUpdateWrapper.getLog().d("VasUpdate_TaskSyncReq", "getShouldUpdateList");
    try
    {
      addLocalShouldUpdate(localHashMap);
      addSyncItemUpdate(localHashMap, paramTaskSyncRsp.mVcrList);
      int i = VasUpdateWrapper.getCommonManager().getNetType();
      paramTaskSyncRsp = this.mSeqConfig.mPreloadList;
      if ((paramTaskSyncRsp != null) && (paramTaskSyncRsp.size() > 0))
      {
        addPreloadItem(localHashMap, i, paramTaskSyncRsp);
        return localHashMap;
      }
    }
    catch (Throwable paramTaskSyncRsp)
    {
      paramTaskSyncRsp.printStackTrace();
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getShouldUpdateList exception msg = ");
      localStringBuilder.append(paramTaskSyncRsp.getMessage());
      localIVasLog.e("VasUpdate_TaskSyncReq", localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  private boolean isNetWorkValid(int paramInt1, int paramInt2)
  {
    if ((2 == paramInt1) && ((paramInt2 & 0x1) == 0)) {
      return false;
    }
    if ((5 == paramInt1) && ((paramInt2 & 0x2) == 0)) {
      return false;
    }
    if ((4 == paramInt1) && ((paramInt2 & 0x4) == 0)) {
      return false;
    }
    if ((3 == paramInt1) && ((paramInt2 & 0x8) == 0)) {
      return false;
    }
    return (6 != paramInt1) || ((paramInt2 & 0xE) != 0);
  }
  
  private void loadSeqConfig()
  {
    this.mSeqConfig = SeqConfigEntity.loadSeqConfig();
    if ((!TextUtils.isEmpty(this.mSeqConfig.mAppVer)) && (!this.mSeqConfig.mAppVer.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().getReportVersion())))
    {
      this.mSeqConfig.mAppVer = VasUpdateWrapper.getCommonManager().getReportVersion();
      SeqConfigEntity localSeqConfigEntity = this.mSeqConfig;
      localSeqConfigEntity.mPreloadVer = 0;
      SeqConfigEntity.saveSeqConfig(localSeqConfigEntity);
    }
  }
  
  private void notifyComplete(int paramInt, String paramString, HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task sync notifyComplete syncErrorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" message = ");
    localStringBuilder.append(paramString);
    localIVasLog.d("VasUpdate_TaskSyncReq", localStringBuilder.toString());
    VasUpdateSystem.getInstance().onTaskSyncTableComplete(this.mSeqConfig.mPollTime, this.mDLFrom, paramHashMap);
  }
  
  private JSONArray parseItemLocalVerList(HashMap<String, ItemLocalVerPrt> paramHashMap)
  {
    localJSONArray = new JSONArray();
    if (paramHashMap == null) {
      return localJSONArray;
    }
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        ItemLocalVerPrt localItemLocalVerPrt = (ItemLocalVerPrt)((Map.Entry)paramHashMap.next()).getValue();
        if (localItemLocalVerPrt != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("bid", CommonUtil.sParseBidId(localItemLocalVerPrt.mItemId));
          localJSONObject.put("scid", CommonUtil.sParseScid(localItemLocalVerPrt.mItemId));
          localJSONObject.put("version", localItemLocalVerPrt.mMd5);
          localJSONArray.put(localJSONObject);
        }
      }
      return localJSONArray;
    }
    catch (Throwable paramHashMap)
    {
      paramHashMap.printStackTrace();
    }
  }
  
  private void readLocalTable()
  {
    try
    {
      this.mArrayExistItem.clear();
      Object localObject = VasUpdateWrapper.getDbManager().selectAllItem(0);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          IDbManager.ItemInfo localItemInfo = (IDbManager.ItemInfo)((Iterator)localObject).next();
          if ((localItemInfo != null) && (!TextUtils.isEmpty(localItemInfo.content))) {
            this.mArrayExistItem.put(localItemInfo.itemId, ItemLocalVerPrt.parseJsonToItemLocalVerPrt(localItemInfo.content));
          }
          int i = this.mArrayExistItem.size();
          if (i > 1300) {}
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public String getRequest()
  {
    this.mSyncMode = 1;
    if (this.mSeqConfig == null) {
      loadSeqConfig();
    }
    if (this.mSeqConfig.mSeq == 0L)
    {
      this.mSyncMode = 0;
      readLocalTable();
    }
    return getRequestContent();
  }
  
  public void handlePbResponse(int paramInt, TaskSyncRsp paramTaskSyncRsp)
  {
    Object localObject = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sync handlePbResponse result = ");
    localStringBuilder.append(paramInt);
    ((IVasLog)localObject).d("VasUpdate_TaskSyncReq", localStringBuilder.toString());
    if ((paramInt == 0) && (paramTaskSyncRsp != null))
    {
      if ((paramTaskSyncRsp.mSyncSwitch & 0x1) != 0)
      {
        notifyComplete(2, "handlePbResponse syncSwitch close", null);
        return;
      }
      if ((paramTaskSyncRsp.mPreaload != null) && (paramTaskSyncRsp.mPreaload.mPreLoadVersion != this.mSeqConfig.mPreloadVer))
      {
        this.mSeqConfig.mPreloadVer = paramTaskSyncRsp.mPreaload.mPreLoadVersion;
        this.mSeqConfig.mPreloadList = paramTaskSyncRsp.mPreaload.mItemList;
        if (this.mSeqConfig.mPreloadVer == 0) {
          this.mSeqConfig.mPreloadList.clear();
        }
      }
      localObject = getShouldUpdateList(paramTaskSyncRsp);
      this.mSeqConfig.mSeq = paramTaskSyncRsp.mSeq;
      this.mSeqConfig.mAppVer = VasUpdateWrapper.getCommonManager().getReportVersion();
      this.mSeqConfig.mPollTime = paramTaskSyncRsp.mPollTime;
      SeqConfigEntity.saveSeqConfig(this.mSeqConfig);
      paramTaskSyncRsp = VasUpdateWrapper.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePbResponse listShouldUpdate count = ");
      localStringBuilder.append(((HashMap)localObject).size());
      paramTaskSyncRsp.i("VasUpdate_TaskSyncReq", localStringBuilder.toString());
      notifyComplete(0, "sync success", (HashMap)localObject);
      return;
    }
    VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "handlePbResponse error");
    notifyComplete(1, "handlePbResponse result != 0 or rsp = null", null);
  }
  
  public void onSendPbMsgError()
  {
    notifyComplete(3, "sync send pb error", null);
  }
  
  public void run()
  {
    loadSeqConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.request.TaskSyncReq
 * JD-Core Version:    0.7.0.1
 */