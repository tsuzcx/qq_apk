package com.tencent.vas.update.request;

import android.text.TextUtils;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.task.DownloadItemTask;
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
  private HashMap<String, DownloadItemTask> mTaskMaps = new HashMap();
  
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
      boolean bool = "silent_update".equalsIgnoreCase(paramString);
      if (bool) {
        localJSONObject1.put("force", 2);
      } else {
        localJSONObject1.put("force", 1);
      }
      paramString = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
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
        }
      }
      localJSONObject1.put("item_list", paramString);
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    if (VasUpdateWrapper.getLog().a())
    {
      paramArrayList = VasUpdateWrapper.getLog();
      paramString = new StringBuilder();
      paramString.append("batchGetUrl request content = ");
      paramString.append(localJSONObject1.toString());
      paramArrayList.a("VasUpdate_TaskBatchUrlReq", paramString.toString());
    }
    return localJSONObject1.toString();
  }
  
  public void addTask(String paramString, DownloadItemTask paramDownloadItemTask)
  {
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addTask itemId = ");
    localStringBuilder.append(paramString);
    localIVasLog.b("VasUpdate_TaskBatchUrlReq", localStringBuilder.toString());
    this.mTaskMaps.put(paramString, paramDownloadItemTask);
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
        DownloadItemTask localDownloadItemTask = (DownloadItemTask)((Map.Entry)localObject).getValue();
        localObject = localDownloadItemTask.a();
        if (localObject != null)
        {
          if (!TextUtils.isEmpty(((ItemUpdateVerPtr)localObject).mSrcMd5)) {
            if (localDownloadItemTask.a(((ItemUpdateVerPtr)localObject).mSrcMd5))
            {
              ((ItemUpdateVerPtr)localObject).mSrcMd5 = "";
              VasUpdateWrapper.getLog().b("VasUpdate_TaskBatchUrlReq", "getRequest item need Redownload , reset md5");
            }
            else
            {
              VasUpdateWrapper.getLog().b("VasUpdate_TaskBatchUrlReq", "getRequest item file has downloaded , check update status");
            }
          }
          str = ((ItemUpdateVerPtr)localObject).mFrom;
          localArrayList.add(localObject);
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
    if ((paramTaskBatchUrlRsp != null) && (paramTaskBatchUrlRsp.mUpdateList != null)) {
      paramTaskBatchUrlRsp = paramTaskBatchUrlRsp.mUpdateList.iterator();
    }
    while (paramTaskBatchUrlRsp.hasNext())
    {
      Object localObject1 = (UpdateUrlInfoPtr)paramTaskBatchUrlRsp.next();
      if (localObject1 != null)
      {
        Object localObject2 = (DownloadItemTask)this.mTaskMaps.get(((UpdateUrlInfoPtr)localObject1).mItemId);
        if (localObject2 != null)
        {
          ((DownloadItemTask)localObject2).a(paramInt, (UpdateUrlInfoPtr)localObject1);
        }
        else
        {
          localObject2 = VasUpdateWrapper.getLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("batch req handle pb response no match , itemId = ");
          localStringBuilder.append(((UpdateUrlInfoPtr)localObject1).mItemId);
          ((IVasLog)localObject2).b("VasUpdate_TaskBatchUrlReq", localStringBuilder.toString());
          continue;
          paramTaskBatchUrlRsp = this.mTaskMaps.entrySet().iterator();
          while (paramTaskBatchUrlRsp.hasNext())
          {
            localObject1 = (Map.Entry)paramTaskBatchUrlRsp.next();
            if ((localObject1 != null) && (((Map.Entry)localObject1).getValue() != null)) {
              ((DownloadItemTask)((Map.Entry)localObject1).getValue()).a(-1, null);
            }
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
        ((DownloadItemTask)localEntry.getValue()).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.request.TaskBatchUrlReq
 * JD-Core Version:    0.7.0.1
 */