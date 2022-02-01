package com.tencent.mtt.abtestsdk.manager;

import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ClientManager$4
  implements OnUpdateExperimentsListener
{
  ClientManager$4(ClientManager paramClientManager, List paramList, GetExperimentListener paramGetExperimentListener) {}
  
  public void updateExperimentsFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get all exp data failed from network: ");
    localStringBuilder.append(paramString);
    ABTestLog.warn(localStringBuilder.toString(), new Object[0]);
    this.val$listener.getExperimentFailed(paramInt, paramString);
  }
  
  public void updateExperimentsSucceed(JSONObject paramJSONObject)
  {
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      this.val$expEntities.clear();
      ABTestLog.debug("get all exp data successfully from network", new Object[0]);
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        ExpEntity localExpEntity = new ExpEntity("");
        localExpEntity.readJson(localJSONObject);
        localExpEntity.setLayerCode(str);
        this.val$expEntities.add(localExpEntity);
      }
      this.val$listener.getExperimentSucceed(this.val$expEntities);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ABTestLog.error(paramJSONObject.getMessage(), new Object[0]);
      this.val$listener.getExperimentFailed(1007, "get res error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.manager.ClientManager.4
 * JD-Core Version:    0.7.0.1
 */