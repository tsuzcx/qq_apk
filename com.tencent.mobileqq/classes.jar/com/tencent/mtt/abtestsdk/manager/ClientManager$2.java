package com.tencent.mtt.abtestsdk.manager;

import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ClientManager$2
  implements OnUpdateExperimentsListener
{
  ClientManager$2(ClientManager paramClientManager, List paramList, GetExperimentListener paramGetExperimentListener) {}
  
  public void updateExperimentsFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errMsg: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("  errMsg: ");
    localStringBuilder.append(paramString);
    ABTestLog.warn(localStringBuilder.toString(), new Object[0]);
    this.val$listener.getExperimentFailed(paramInt, paramString);
  }
  
  public void updateExperimentsSucceed(JSONObject paramJSONObject)
  {
    try
    {
      localObject = paramJSONObject.keys();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switchAccountId: updateExperimentsSucceed: ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      ABTestLog.error(((StringBuilder)localObject).toString(), new Object[0]);
      this.val$listener.getExperimentFailed(1007, "get res error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.manager.ClientManager.2
 * JD-Core Version:    0.7.0.1
 */