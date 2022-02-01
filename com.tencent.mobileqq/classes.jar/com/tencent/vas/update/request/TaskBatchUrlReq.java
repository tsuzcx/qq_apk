package com.tencent.vas.update.request;

import android.text.TextUtils;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.task.BaseItemTask;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskBatchUrlReq
{
  private static final String TAG = "VasUpdate_TaskBatchUrlReq";
  private int mCurrentCookieId;
  private HashMap<String, BaseItemTask> mTaskMaps = new HashMap();
  
  private String getRequestContent(ArrayList<ItemUpdateVerPtr> paramArrayList, String paramString)
  {
    this.mCurrentCookieId = CommonUtil.generateCookieId();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("cookie", this.mCurrentCookieId);
      localJSONObject1.put("delta_mode", 1);
      localJSONObject1.put("storage_mode", 1);
      localJSONObject1.put("compress_mode", 1);
      localJSONObject1.put("from", paramString);
      if ("silent_update".equalsIgnoreCase(paramString))
      {
        localJSONObject1.put("force", 2);
        paramString = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            ItemUpdateVerPtr localItemUpdateVerPtr = (ItemUpdateVerPtr)paramArrayList.next();
            if (localItemUpdateVerPtr != null)
            {
              JSONObject localJSONObject2 = new JSONObject();
              long l = CommonUtil.sParseBidId(localItemUpdateVerPtr.mItemId);
              String str = CommonUtil.sParseScid(localItemUpdateVerPtr.mItemId);
              localJSONObject2.put("bid", l);
              localJSONObject2.put("scid", str);
              localJSONObject2.put("srcMd5", localItemUpdateVerPtr.mSrcMd5);
              localJSONObject2.put("dstMd5", localItemUpdateVerPtr.mDstMd5);
              paramString.put(localJSONObject2);
              continue;
              if (!VasUpdateWrapper.getLog().isColorLevel()) {
                break;
              }
            }
          }
        }
      }
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    for (;;)
    {
      VasUpdateWrapper.getLog().d("VasUpdate_TaskBatchUrlReq", "batchGetUrl request content = " + localJSONObject1.toString());
      return localJSONObject1.toString();
      localJSONObject1.put("force", 1);
      break;
      localJSONObject1.put("item_list", paramString);
    }
  }
  
  public void addTask(String paramString, BaseItemTask paramBaseItemTask)
  {
    VasUpdateWrapper.getLog().i("VasUpdate_TaskBatchUrlReq", "addTask itemId = " + paramString);
    this.mTaskMaps.put(paramString, paramBaseItemTask);
  }
  
  public int getCookieId()
  {
    return this.mCurrentCookieId;
  }
  
  public String getRequest()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mTaskMaps.entrySet().iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ((localObject != null) && (((Map.Entry)localObject).getValue() != null))
      {
        BaseItemTask localBaseItemTask = (BaseItemTask)((Map.Entry)localObject).getValue();
        localObject = localBaseItemTask.getItemUpdateVer();
        if (localObject != null)
        {
          if (!TextUtils.isEmpty(((ItemUpdateVerPtr)localObject).mSrcMd5))
          {
            if (!localBaseItemTask.checkSrcFileIsNeedReDownload(((ItemUpdateVerPtr)localObject).mSrcMd5)) {
              break label142;
            }
            ((ItemUpdateVerPtr)localObject).mSrcMd5 = "";
            VasUpdateWrapper.getLog().i("VasUpdate_TaskBatchUrlReq", "getRequest item need Redownload , reset md5");
          }
          for (;;)
          {
            str = ((ItemUpdateVerPtr)localObject).mFrom;
            localArrayList.add(localObject);
            break;
            label142:
            VasUpdateWrapper.getLog().i("VasUpdate_TaskBatchUrlReq", "getRequest item file has downloaded , check update status");
          }
        }
      }
    }
    return getRequestContent(localArrayList, str);
  }
  
  public int getTaskCount()
  {
    return this.mTaskMaps.size();
  }
  
  public void handlePbResponse(int paramInt, TaskBatchUrlRsp paramTaskBatchUrlRsp)
  {
    if ((paramTaskBatchUrlRsp != null) && (paramTaskBatchUrlRsp.mUpdateList != null))
    {
      paramTaskBatchUrlRsp = paramTaskBatchUrlRsp.mUpdateList.iterator();
      while (paramTaskBatchUrlRsp.hasNext())
      {
        UpdateUrlInfoPtr localUpdateUrlInfoPtr = (UpdateUrlInfoPtr)paramTaskBatchUrlRsp.next();
        if (localUpdateUrlInfoPtr != null)
        {
          BaseItemTask localBaseItemTask = (BaseItemTask)this.mTaskMaps.get(localUpdateUrlInfoPtr.mItemId);
          if (localBaseItemTask != null) {
            localBaseItemTask.handleGetUrlRsp(paramInt, localUpdateUrlInfoPtr);
          } else {
            VasUpdateWrapper.getLog().i("VasUpdate_TaskBatchUrlReq", "batch req handle pb response no match , itemId = " + localUpdateUrlInfoPtr.mItemId);
          }
        }
      }
    }
    this.mTaskMaps.clear();
  }
  
  public boolean hasContainsTask(String paramString)
  {
    return this.mTaskMaps.containsKey(paramString);
  }
  
  public void onSendPbMsgError()
  {
    Iterator localIterator = this.mTaskMaps.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry != null) && (localEntry.getValue() != null)) {
        ((BaseItemTask)localEntry.getValue()).onSendPbMsgError();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.request.TaskBatchUrlReq
 * JD-Core Version:    0.7.0.1
 */