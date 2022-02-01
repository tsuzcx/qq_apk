package com.tencent.mtt.abtestsdk.manager;

import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ClientManager$3
  implements OnUpdateExperimentsListener
{
  ClientManager$3(ClientManager paramClientManager, String paramString1, boolean paramBoolean, List paramList, long paramLong, String paramString2, GetExperimentListener paramGetExperimentListener) {}
  
  public void updateExperimentsFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expose：");
    localStringBuilder.append(this.val$isExpose);
    localStringBuilder.append(" get data unsuccessfully");
    ABTestLog.error(localStringBuilder.toString(), new Object[0]);
    long l1 = System.currentTimeMillis();
    long l2 = this.val$startRecordTime;
    this.this$0.reportBeaconApiEvent(this.val$apiName, false, l1 - l2);
    this.val$listener.getExperimentFailed(paramInt, paramString);
  }
  
  public void updateExperimentsSucceed(JSONObject paramJSONObject)
  {
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        JSONObject localJSONObject = paramJSONObject.getJSONObject((String)localObject);
        String str = localJSONObject.optString("expName");
        if (this.val$expName.equals(str))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("expose：");
          paramJSONObject.append(this.val$isExpose);
          paramJSONObject.append("  get data successfully from network");
          ABTestLog.debug(paramJSONObject.toString(), new Object[0]);
          paramJSONObject = new ExpEntity(this.val$expName);
          paramJSONObject.readJson(localJSONObject);
          paramJSONObject.setLayerCode((String)localObject);
          this.val$expEntities.clear();
          this.val$expEntities.add(paramJSONObject);
          if (this.val$isExpose) {
            this.this$0.reportExpExpose(paramJSONObject, "0");
          }
        }
      }
      l1 = System.currentTimeMillis();
      l2 = this.val$startRecordTime;
      this.this$0.reportBeaconApiEvent(this.val$apiName, true, l1 - l2);
      this.val$listener.getExperimentSucceed(this.val$expEntities);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("expose：");
      ((StringBuilder)localObject).append(this.val$isExpose);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      ABTestLog.error(((StringBuilder)localObject).toString(), new Object[0]);
      long l1 = System.currentTimeMillis();
      long l2 = this.val$startRecordTime;
      this.this$0.reportBeaconApiEvent(this.val$apiName, false, l1 - l2);
      this.val$listener.getExperimentFailed(1007, "get res error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.manager.ClientManager.3
 * JD-Core Version:    0.7.0.1
 */