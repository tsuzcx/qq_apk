package com.tencent.mobileqq.cmshow.engine.script.plugin;

import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GeneralEventPlugin$handleGetActionData$job$1
  implements Runnable
{
  GeneralEventPlugin$handleGetActionData$job$1(Argument paramArgument, QQAppInterface paramQQAppInterface) {}
  
  public final void run()
  {
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelArgument.b());
      long l = ((JSONObject)localObject).optLong("taskId");
      localObject = SpriteRscBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (JSONObject)localObject);
      if (localObject != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("errCode", 0);
        localJSONObject.put("ret", 0);
        localJSONObject.put("actionInfo", localObject);
        localJSONObject.put("taskId", l);
        if (QLog.isColorLevel())
        {
          GeneralEventPlugin.a();
          QLog.d("[cmshow][GeneralEventPlugin]", 2, new Object[] { "handleGetActionData ReqAction,", localJSONObject.toString() });
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelArgument.a("sc.script_notify_action_ready.local", localJSONObject.toString());
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      GeneralEventPlugin.a();
      QLog.e("[cmshow][GeneralEventPlugin]", 1, "handleGetActionData exception:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.GeneralEventPlugin.handleGetActionData.job.1
 * JD-Core Version:    0.7.0.1
 */