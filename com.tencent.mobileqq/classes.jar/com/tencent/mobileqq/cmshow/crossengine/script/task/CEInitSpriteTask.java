package com.tencent.mobileqq.cmshow.crossengine.script.task;

import android.text.TextUtils;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptHelper;
import com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CEInitSpriteTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/InitSpriteTask;", "apolloResManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)V", "buildScript", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEInitSpriteTask
  extends InitSpriteTask
{
  @Deprecated
  public static final CEInitSpriteTask.Companion a = new CEInitSpriteTask.Companion(null);
  
  public CEInitSpriteTask(@NotNull IApolloResManager paramIApolloResManager)
  {
    super(paramIApolloResManager);
  }
  
  @NotNull
  public Script a()
  {
    Object localObject2 = c().toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "buildParams().toString()");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)b()))
    {
      localObject1 = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("if (typeof ");
      localStringBuilder.append(b());
      localStringBuilder.append(" == 'function') {\n");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("    ");
      localStringBuilder.append(b());
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
      QLog.w("[cmshow][ScriptTask][CEInitSpriteTask]", 2, ((StringBuilder)localObject2).toString());
    }
    return ScriptHelper.a.b((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.task.CEInitSpriteTask
 * JD-Core Version:    0.7.0.1
 */