package com.tencent.mtt.abtestsdk;

import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class ABTestApi$1
  implements OnUpdateExperimentsListener
{
  ABTestApi$1(List paramList, GetExperimentListener paramGetExperimentListener) {}
  
  public void updateExperimentsFailed(int paramInt, String paramString)
  {
    ABTestLog.warn("errMsg: " + paramString + "  errMsg: " + paramString, new Object[0]);
    this.val$listener.getExperimentFailed(paramInt, paramString);
  }
  
  public void updateExperimentsSucceed(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject((String)localIterator.next());
        RomaExpEntity localRomaExpEntity = new RomaExpEntity("");
        localRomaExpEntity.readJson(localJSONObject);
        this.val$expEntities.add(localRomaExpEntity);
      }
      this.val$listener.getExperimentSucceed(this.val$expEntities);
    }
    catch (Exception paramJSONObject)
    {
      ABTestLog.error("switchAccountId: updateExperimentsSucceed: " + paramJSONObject.getMessage(), new Object[0]);
      this.val$listener.getExperimentFailed(1007, "get res error");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTestApi.1
 * JD-Core Version:    0.7.0.1
 */