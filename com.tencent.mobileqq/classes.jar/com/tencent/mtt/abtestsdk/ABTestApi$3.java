package com.tencent.mtt.abtestsdk;

import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class ABTestApi$3
  implements OnUpdateExperimentsListener
{
  ABTestApi$3(List paramList, GetExperimentListener paramGetExperimentListener) {}
  
  public void updateExperimentsFailed(int paramInt, String paramString)
  {
    ABTestLog.warn("ABTestApi", new Object[] { "get all the data unsuccessfully from network" });
    this.val$listener.getExperimentFailed(paramInt, paramString);
    this.val$listener.getExperimentSucceed(this.val$expEntities);
  }
  
  public void updateExperimentsSucceed(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      Iterator localIterator = paramJSONObject.keys();
      this.val$expEntities.clear();
      ABTestLog.debug("get all the data successfully from network", new Object[0]);
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        RomaExpEntity localRomaExpEntity = new RomaExpEntity("");
        localRomaExpEntity.readJson(localJSONObject);
        localRomaExpEntity.setLayerCode(str);
        this.val$expEntities.add(localRomaExpEntity);
      }
      this.val$listener.getExperimentSucceed(this.val$expEntities);
    }
    catch (Exception paramJSONObject)
    {
      ABTestLog.error(paramJSONObject.getMessage(), new Object[0]);
      this.val$listener.getExperimentFailed(1007, "get res error");
      this.val$listener.getExperimentSucceed(this.val$expEntities);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTestApi.3
 * JD-Core Version:    0.7.0.1
 */