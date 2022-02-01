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
import org.json.JSONException;
import org.json.JSONObject;

public class TaskSyncReq
{
  private static final String TAG = "VasUpdate_TaskSyncReq";
  private int mDLFrom;
  private SeqConfigEntity mSeqConfig;
  private int mSyncMode;
  
  public TaskSyncReq(int paramInt)
  {
    this.mDLFrom = paramInt;
  }
  
  private void addLocalShouldUpdate(HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    Object localObject1 = VasUpdateWrapper.getDbManager().selectAllItem(1);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      VasUpdateWrapper.getLog().d("VasUpdate_TaskSyncReq", "getShouldUpdateList add table_should_update size = " + ((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (IDbManager.ItemInfo)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ItemUpdateVerPtr.parseJsonToItemUpdateVerPrt(((IDbManager.ItemInfo)localObject2).content);
          if ((localObject2 == null) || (TextUtils.isEmpty(((ItemUpdateVerPtr)localObject2).mItemId)))
          {
            VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "addLocalShouldUpdate item = null or itemId = null ");
          }
          else if (!((ItemUpdateVerPtr)localObject2).checkItemIsCurrentVersion())
          {
            VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "seq addLocalShouldUpdate item continue , version not fit");
          }
          else
          {
            ((ItemUpdateVerPtr)localObject2).mFrom = "silent_update";
            paramHashMap.put(((ItemUpdateVerPtr)localObject2).mItemId, localObject2);
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
      PreloadItem localPreloadItem = (PreloadItem)paramArrayList.next();
      if (localPreloadItem != null) {
        if ((paramHashMap.containsKey(localPreloadItem.mItemId)) || (TextUtils.isEmpty(localPreloadItem.mItemId)))
        {
          VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "addPreloadItem itemId = null , currentId = " + localPreloadItem.mItemId);
        }
        else if (!isNetWorkValid(paramInt, localPreloadItem.mFlag))
        {
          VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "addPreloadItem network invalid , localNetType = " + paramInt + " , mFlag = " + localPreloadItem.mFlag + " , itemId = " + localPreloadItem.mItemId);
        }
        else
        {
          ItemUpdateVerPtr localItemUpdateVerPtr = new ItemUpdateVerPtr();
          localItemUpdateVerPtr.mItemId = localPreloadItem.mItemId;
          localItemUpdateVerPtr.mSrcMd5 = "";
          localItemUpdateVerPtr.mDstMd5 = "";
          localItemUpdateVerPtr.mFrom = "silent_update";
          localItemUpdateVerPtr.mLastRunTime = 0L;
          localItemUpdateVerPtr.mRunCount = 0;
          paramHashMap.put(localItemUpdateVerPtr.mItemId, localItemUpdateVerPtr);
          VasUpdateWrapper.getDbManager().updateItem(1, localItemUpdateVerPtr.mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(localItemUpdateVerPtr));
          VasUpdateWrapper.getLog().i("VasUpdate_TaskSyncReq", "getShouldUpdateList preload item add , id = " + localItemUpdateVerPtr.mItemId);
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
          VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "getShouldUpdateList currentItem not register , itemId = " + localSyncItemRecord.mItemId);
          VasUpdateWrapper.getDbManager().deleteItem(1, localSyncItemRecord.mItemId);
        }
        else
        {
          BusinessItemInfo localBusinessItemInfo = ((IBusinessCallback)localObject).getBusinessItemInfo(l, paramArrayList);
          if (localBusinessItemInfo == null)
          {
            VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "getShouldUpdateList getItemInfo fail , itemId = " + localSyncItemRecord.mItemId);
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
              VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "getShouldUpdateList item type delete , id = " + localSyncItemRecord.mItemId);
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
                VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "getShouldUpdateList local item doesn't match , id = " + localSyncItemRecord.mItemId);
              }
              else if (((paramArrayList.mMd5 != null) && (!paramArrayList.mMd5.equalsIgnoreCase(localSyncItemRecord.mMD5))) || (!((IBusinessCallback)localObject).isFileExist(localBusinessUpdateParams, localBusinessItemInfo)))
              {
                localObject = new ItemUpdateVerPtr();
                ((ItemUpdateVerPtr)localObject).mItemId = localSyncItemRecord.mItemId;
                if (paramArrayList != null) {}
                for (paramArrayList = paramArrayList.mMd5;; paramArrayList = "")
                {
                  ((ItemUpdateVerPtr)localObject).mSrcMd5 = paramArrayList;
                  ((ItemUpdateVerPtr)localObject).mDstMd5 = localSyncItemRecord.mMD5;
                  ((ItemUpdateVerPtr)localObject).mFrom = "silent_update";
                  ((ItemUpdateVerPtr)localObject).mLastRunTime = 0L;
                  ((ItemUpdateVerPtr)localObject).mRunCount = 0;
                  ((ItemUpdateVerPtr)localObject).mAppVersion = localSyncItemRecord.mAppVersion;
                  paramHashMap.put(((ItemUpdateVerPtr)localObject).mItemId, localObject);
                  VasUpdateWrapper.getDbManager().updateItem(1, ((ItemUpdateVerPtr)localObject).mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson((ItemUpdateVerPtr)localObject));
                  VasUpdateWrapper.getLog().i("VasUpdate_TaskSyncReq", "getShouldUpdateList local item check need update , id = " + localSyncItemRecord.mItemId);
                  break;
                }
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
      if (VasUpdateWrapper.getLog().isColorLevel()) {
        VasUpdateWrapper.getLog().i("VasUpdate_TaskSyncReq", "sync getRequestContent = " + localJSONObject.toString());
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
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
      if ((paramTaskSyncRsp != null) && (paramTaskSyncRsp.size() > 0)) {
        addPreloadItem(localHashMap, i, paramTaskSyncRsp);
      }
      return localHashMap;
    }
    catch (Throwable paramTaskSyncRsp)
    {
      paramTaskSyncRsp.printStackTrace();
      VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "getShouldUpdateList exception msg = " + paramTaskSyncRsp.getMessage());
    }
    return localHashMap;
  }
  
  private boolean isNetWorkValid(int paramInt1, int paramInt2)
  {
    if ((2 == paramInt1) && ((paramInt2 & 0x1) == 0)) {}
    while (((5 == paramInt1) && ((paramInt2 & 0x2) == 0)) || ((4 == paramInt1) && ((paramInt2 & 0x4) == 0)) || ((3 == paramInt1) && ((paramInt2 & 0x8) == 0)) || ((6 == paramInt1) && ((paramInt2 & 0xE) == 0))) {
      return false;
    }
    return true;
  }
  
  private void loadSeqConfig()
  {
    this.mSeqConfig = SeqConfigEntity.loadSeqConfig();
    if ((!TextUtils.isEmpty(this.mSeqConfig.mAppVer)) && (!this.mSeqConfig.mAppVer.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().getReportVersion())))
    {
      this.mSeqConfig.mAppVer = VasUpdateWrapper.getCommonManager().getReportVersion();
      this.mSeqConfig.mPreloadVer = 0;
      SeqConfigEntity.saveSeqConfig(this.mSeqConfig);
    }
  }
  
  private void notifyComplete(int paramInt, String paramString, HashMap<String, ItemUpdateVerPtr> paramHashMap)
  {
    VasUpdateWrapper.getLog().d("VasUpdate_TaskSyncReq", "task sync notifyComplete syncErrorCode = " + paramInt + " message = " + paramString);
    VasUpdateSystem.getInstance().onTaskSyncTableComplete(this.mSeqConfig.mPollTime, this.mDLFrom, paramHashMap);
  }
  
  public String getRequest()
  {
    this.mSyncMode = 1;
    if (this.mSeqConfig == null) {
      loadSeqConfig();
    }
    if (this.mSeqConfig.mSeq == 0L) {
      this.mSyncMode = 0;
    }
    return getRequestContent();
  }
  
  public void handlePbResponse(int paramInt, TaskSyncRsp paramTaskSyncRsp)
  {
    VasUpdateWrapper.getLog().d("VasUpdate_TaskSyncReq", "sync handlePbResponse result = " + paramInt);
    if ((paramInt != 0) || (paramTaskSyncRsp == null))
    {
      VasUpdateWrapper.getLog().e("VasUpdate_TaskSyncReq", "handlePbResponse error");
      notifyComplete(1, "handlePbResponse result != 0 or rsp = null", null);
      return;
    }
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
    HashMap localHashMap = getShouldUpdateList(paramTaskSyncRsp);
    this.mSeqConfig.mSeq = paramTaskSyncRsp.mSeq;
    this.mSeqConfig.mAppVer = VasUpdateWrapper.getCommonManager().getReportVersion();
    this.mSeqConfig.mPollTime = paramTaskSyncRsp.mPollTime;
    SeqConfigEntity.saveSeqConfig(this.mSeqConfig);
    VasUpdateWrapper.getLog().i("VasUpdate_TaskSyncReq", "handlePbResponse listShouldUpdate count = " + localHashMap.size());
    notifyComplete(0, "sync success", localHashMap);
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