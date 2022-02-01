package com.tencent.mobileqq.cmshow.brickengine.script.task;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.BKScriptUtils;
import com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class BKInitSpriteTask
  extends InitSpriteTask
{
  public String a()
  {
    String str = a().toString();
    Object localObject = b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("if (typeof ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" == 'function') {\n    ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("('");
      localStringBuilder.append(str);
      localStringBuilder.append("');\n}");
      str = localStringBuilder.toString();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildScript:");
      ((StringBuilder)localObject).append(str);
      QLog.w("[cmshow][ScriptTask][BKInitSpriteTask]", 2, ((StringBuilder)localObject).toString());
    }
    return str;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Object localObject = (IApolloManagerService)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all");
      boolean bool = CmShowAioMatcherImpl.judgeSupported(a(), 1);
      JSONObject localJSONObject2;
      if (bool)
      {
        localJSONObject2 = BKScriptUtils.a(d(), this, true, null, true);
        JSONObject localJSONObject3 = BKScriptUtils.a(c(), this, false, null, true);
        if ((((IApolloManagerService)localObject).getCmShowStatus(d()) != 2) && (!a()))
        {
          JSONObject localJSONObject4 = BKScriptUtils.a(d(), this, true);
          if (localJSONObject4 != null) {
            localJSONObject2.put("pet", localJSONObject4);
          }
        }
        if ((((IApolloManagerService)localObject).getCmShowStatus(c()) != 2) && (!a()))
        {
          localObject = BKScriptUtils.a(c(), this, false);
          if (localObject != null) {
            localJSONObject3.put("pet", localObject);
          }
        }
        localJSONArray.put(localJSONObject2);
        localJSONArray.put(localJSONObject3);
      }
      else
      {
        localJSONObject2 = BKScriptUtils.a(d(), this, true, null, true);
        if ((((IApolloManagerService)localObject).getCmShowStatus(d()) != 2) && (!a()))
        {
          localObject = BKScriptUtils.a(d(), this, true);
          if (localObject != null) {
            localJSONObject2.put("pet", localObject);
          }
        }
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("sprites", localJSONArray);
      return localJSONObject1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][ScriptTask][BKInitSpriteTask]", 1, "[getSpriteJsParam],", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.script.task.BKInitSpriteTask
 * JD-Core Version:    0.7.0.1
 */