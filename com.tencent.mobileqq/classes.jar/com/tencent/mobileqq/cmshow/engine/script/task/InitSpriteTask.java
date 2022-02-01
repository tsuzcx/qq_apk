package com.tencent.mobileqq.cmshow.engine.script.task;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptHelper;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class InitSpriteTask
  extends AbsScriptTask
{
  private String a;
  
  public InitSpriteTask(@NonNull IApolloResManager paramIApolloResManager)
  {
    super(paramIApolloResManager);
  }
  
  public Script a()
  {
    String str = c().toString();
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
      QLog.w("[cmshow][ScriptTask][InitSpriteTask]", 2, ((StringBuilder)localObject).toString());
    }
    return ScriptHelper.a.b(str);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public InitSpriteTask c(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  protected JSONObject c()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Object localObject = (IApolloManagerService)ApolloUtilImpl.getQQApp().getRuntimeService(IApolloManagerService.class, "all");
      boolean bool = CmShowAioMatcherImpl.judgeSupported(e(), 1);
      JSONObject localJSONObject2;
      if (bool)
      {
        localJSONObject2 = ScriptUtils.a(g(), this, true, null, true);
        JSONObject localJSONObject3 = ScriptUtils.a(f(), this, false, null, true);
        if ((((IApolloManagerService)localObject).getCmShowStatus(g()) != 2) && (!h()))
        {
          JSONObject localJSONObject4 = ScriptUtils.a(g(), this, true);
          if (localJSONObject4 != null) {
            localJSONObject2.put("pet", localJSONObject4);
          }
        }
        if ((((IApolloManagerService)localObject).getCmShowStatus(f()) != 2) && (!h()))
        {
          localObject = ScriptUtils.a(f(), this, false);
          if (localObject != null) {
            localJSONObject3.put("pet", localObject);
          }
        }
        localJSONArray.put(localJSONObject2);
        localJSONArray.put(localJSONObject3);
      }
      else
      {
        localJSONObject2 = ScriptUtils.a(g(), this, true, null, true);
        if ((((IApolloManagerService)localObject).getCmShowStatus(g()) != 2) && (!h()))
        {
          localObject = ScriptUtils.a(g(), this, true);
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
      QLog.e("[cmshow][ScriptTask][InitSpriteTask]", 1, "[getSpriteJsParam],", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask
 * JD-Core Version:    0.7.0.1
 */