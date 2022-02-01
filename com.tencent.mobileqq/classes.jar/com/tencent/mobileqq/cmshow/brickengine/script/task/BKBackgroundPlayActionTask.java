package com.tencent.mobileqq.cmshow.brickengine.script.task;

import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptHelper;
import com.tencent.mobileqq.cmshow.engine.script.task.BackgroundPlayActionTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/script/task/BKBackgroundPlayActionTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/BackgroundPlayActionTask;", "apolloResManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)V", "actionPath", "", "getActionPath$cmshow_impl_release", "()Ljava/lang/String;", "buildScript", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKBackgroundPlayActionTask
  extends BackgroundPlayActionTask
{
  @Deprecated
  public static final BKBackgroundPlayActionTask.Companion a = new BKBackgroundPlayActionTask.Companion(null);
  
  public BKBackgroundPlayActionTask(@NotNull IApolloResManager paramIApolloResManager)
  {
    super(paramIApolloResManager);
  }
  
  @NotNull
  public Script a()
  {
    String str1 = l();
    if (str1 == null) {
      str1 = ApolloUtilImpl.getApolloId(c());
    }
    String str2 = b();
    Object localObject1 = s();
    Object localObject2 = StringCompanionObject.INSTANCE;
    localObject2 = new Object[4];
    localObject2[0] = str1;
    localObject2[1] = str2;
    localObject2[2] = str2;
    localObject2[3] = localObject1;
    str2 = String.format("setAccessoryAnimation(%s, '%s', '%s', '%s');", Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
    localObject2 = StringCompanionObject.INSTANCE;
    localObject2 = new Object[4];
    localObject2[0] = str1;
    localObject2[1] = str1;
    localObject2[2] = Integer.valueOf(r());
    localObject2[3] = localObject1;
    str1 = String.format("if(%s){%s.setAnimation(%d, '%s', false);}", Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(str1, "java.lang.String.format(format, *args)");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str2);
    ((StringBuilder)localObject1).append("\n");
    ((StringBuilder)localObject1).append(str1);
    str1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(str1, "StringBuilder().apply(builderAction).toString()");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("buildScript: ");
    ((StringBuilder)localObject1).append(str1);
    QLog.i("[cmshow][ScriptTask][BKBackgroundPlayActionTask]", 1, ((StringBuilder)localObject1).toString());
    return ScriptHelper.a.b(str1);
  }
  
  @NotNull
  public String b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(q());
    ((StringBuilder)localObject).append("/action_background/action");
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.script.task.BKBackgroundPlayActionTask
 * JD-Core Version:    0.7.0.1
 */