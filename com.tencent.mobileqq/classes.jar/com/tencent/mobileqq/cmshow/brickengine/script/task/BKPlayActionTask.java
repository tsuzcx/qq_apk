package com.tencent.mobileqq.cmshow.brickengine.script.task;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.cmshow.brickengine.BKScriptUtils;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/script/task/BKPlayActionTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;", "()V", "buildParams", "", "buildScript", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class BKPlayActionTask
  extends PlayActionTask
{
  @Deprecated
  public static final BKPlayActionTask.Companion a = new BKPlayActionTask.Companion(null);
  
  @NotNull
  public String a()
  {
    Object localObject2 = b();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)e()))
    {
      localObject1 = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("if (typeof ");
      localStringBuilder.append(e());
      localStringBuilder.append(" == 'function') {\n");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("    ");
      localStringBuilder.append(e());
      localStringBuilder.append("('");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("');\n");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      ((StringBuilder)localObject1).append("}");
      localObject1 = ((StringBuilder)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("buildScript: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.w("[cmshow][ScriptTask][BKPlayActionTask]", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  @NotNull
  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("model", f());
    localJSONObject.put("actionId", c());
    localJSONObject.put("taskId", e());
    localJSONObject.put("actionType", d());
    localJSONObject.put("from", f());
    localJSONObject.put("isHide", g());
    localJSONObject.put("isSender", h());
    if (a(d()))
    {
      localObject = (PlayActionTask)this;
      JSONArray localJSONArray = BKScriptUtils.a((PlayActionTask)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localJSONArray, "BKScriptUtils.getWhiteFaceSprites(this)");
      a(localJSONArray);
      localJSONObject.put("sprites", a());
      b(BKScriptUtils.b((PlayActionTask)localObject));
      localJSONObject.put("actions", b());
    }
    else
    {
      localObject = BKScriptUtils.c((PlayActionTask)this);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BKScriptUtils.getBasicActionJs(this)");
      a((JSONArray)localObject);
      localJSONObject.put("sprites", a());
    }
    boolean bool;
    if (b() == 1) {
      bool = CmShowWnsUtils.E();
    } else {
      bool = true;
    }
    if (bool)
    {
      localObject = BKScriptUtils.a((PlayActionTask)this);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableAudio: ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" in DRAWER for actionId:");
      ((StringBuilder)localObject).append(c());
      QLog.w("[cmshow][ScriptTask][BKPlayActionTask]", 1, ((StringBuilder)localObject).toString());
      localObject = null;
    }
    a((JSONObject)localObject);
    Object localObject = a();
    if (localObject != null) {
      localJSONObject.put("audio", localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)i())) {
      localJSONObject.put("extraMsg", new JSONObject(i()));
    }
    localJSONObject.put("needRecordFrame", c());
    localJSONObject.put("frameTime", Float.valueOf(a()));
    localObject = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "actionJson.toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.script.task.BKPlayActionTask
 * JD-Core Version:    0.7.0.1
 */