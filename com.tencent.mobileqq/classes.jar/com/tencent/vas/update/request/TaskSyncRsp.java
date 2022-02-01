package com.tencent.vas.update.request;

import android.text.TextUtils;
import com.tencent.vas.update.entity.db.Preload;
import com.tencent.vas.update.entity.db.SyncItemRecord;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TaskSyncRsp
{
  public int mContinueFlag;
  public int mPollTime;
  public Preload mPreaload;
  public long mSeq;
  public int mSyncSwitch;
  public ArrayList<SyncItemRecord> mVcrList;
  
  public static TaskSyncRsp parseResponseJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      TaskSyncRsp localTaskSyncRsp = new TaskSyncRsp();
      paramString = new JSONObject(paramString);
      localTaskSyncRsp.mSeq = paramString.optLong("seq");
      localTaskSyncRsp.mPollTime = paramString.optInt("polltime");
      localTaskSyncRsp.mSyncSwitch = paramString.optInt("syncSwitch");
      localTaskSyncRsp.mContinueFlag = paramString.optInt("continueFlag");
      localTaskSyncRsp.mVcrList = SyncItemRecord.parseVcrList(paramString.optJSONArray("vcr_list"));
      localTaskSyncRsp.mPreaload = Preload.parseJsonToPreaload(paramString.optJSONObject("preload"));
      return localTaskSyncRsp;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TaskSyncRsp{mSeq=");
    localStringBuilder.append(this.mSeq);
    localStringBuilder.append(", mPollTime=");
    localStringBuilder.append(this.mPollTime);
    localStringBuilder.append(", mSyncSwitch=");
    localStringBuilder.append(this.mSyncSwitch);
    localStringBuilder.append(", mContinueFlag=");
    localStringBuilder.append(this.mContinueFlag);
    localStringBuilder.append(", mVcrListSize=");
    ArrayList localArrayList = this.mVcrList;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.request.TaskSyncRsp
 * JD-Core Version:    0.7.0.1
 */