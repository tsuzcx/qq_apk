package com.tencent.mtt.abtestsdk;

import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class ABTestApi$2
  implements OnUpdateExperimentsListener
{
  ABTestApi$2(String paramString, boolean paramBoolean, List paramList, GetExperimentListener paramGetExperimentListener) {}
  
  public void updateExperimentsFailed(int paramInt, String paramString)
  {
    ABTestLog.error("expose：" + this.val$isExpose + " get data unsuccessfully", new Object[0]);
    this.val$listener.getExperimentFailed(paramInt, paramString);
    this.val$listener.getExperimentSucceed(this.val$expEntities);
  }
  
  public void updateExperimentsSucceed(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.getJSONObject("data");
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        paramJSONObject = (String)localIterator.next();
        JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject(paramJSONObject);
        String str = localJSONObject.getString("expName");
        if (this.val$expName.equals(str))
        {
          ABTestLog.debug("expose：" + this.val$isExpose + "  get data successfully from network", new Object[0]);
          localObject = new RomaExpEntity(this.val$expName);
          ((RomaExpEntity)localObject).readJson(localJSONObject);
          ((RomaExpEntity)localObject).setLayerCode(paramJSONObject);
          this.val$expEntities.clear();
          this.val$expEntities.add(localObject);
          if (this.val$isExpose) {
            ABTestApi.reportExpExpose((RomaExpEntity)localObject);
          }
        }
      }
      this.val$listener.getExperimentSucceed(this.val$expEntities);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ABTestLog.error("expose：" + this.val$isExpose + "  " + paramJSONObject.getMessage(), new Object[0]);
      this.val$listener.getExperimentFailed(1007, "get res error");
      this.val$listener.getExperimentSucceed(this.val$expEntities);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTestApi.2
 * JD-Core Version:    0.7.0.1
 */