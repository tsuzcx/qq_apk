package com.tencent.mobileqq.cmshow.crossengine.script.task;

import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptHelper;
import com.tencent.mobileqq.cmshow.engine.script.task.BackgroundInitTask;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CEBackgroundInitTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/BackgroundInitTask;", "apolloResManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)V", "density", "", "buildScript", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEBackgroundInitTask
  extends BackgroundInitTask
{
  @Deprecated
  public static final CEBackgroundInitTask.Companion a = new CEBackgroundInitTask.Companion(null);
  private final float b = DeviceInfoUtil.A();
  
  public CEBackgroundInitTask(@NotNull IApolloResManager paramIApolloResManager)
  {
    super(paramIApolloResManager);
  }
  
  @NotNull
  public Script a()
  {
    String str = l();
    if (str == null) {
      str = ApolloUtilImpl.getApolloId(c());
    }
    Object localObject1 = new StringBuilder();
    if (m() == 0) {
      ((StringBuilder)localObject1).append("def/basic/skeleton/");
    }
    ((StringBuilder)localObject1).append(m());
    ((StringBuilder)localObject1).append("/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
    float f;
    if (Intrinsics.areEqual(str, "friend")) {
      f = 180.0F;
    } else {
      f = 0.0F;
    }
    Object localObject2 = StringCompanionObject.INSTANCE;
    localObject2 = new Object[8];
    localObject2[0] = str;
    localObject2[1] = str;
    localObject2[2] = localObject1;
    localObject2[3] = Float.valueOf(1.0F);
    localObject2[4] = Float.valueOf(n());
    localObject2[5] = Float.valueOf(f);
    localObject2[6] = Float.valueOf(o() * this.b);
    localObject2[7] = Float.valueOf(p() * this.b);
    str = String.format("var %s = loadBackgroundAnimation('%s', '%s', %f, %f, %f, %f, %f);", Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("buildScript: ");
      ((StringBuilder)localObject1).append(str);
      QLog.i("[cmshow][ScriptTask][CEBackgroundInitTask]", 2, ((StringBuilder)localObject1).toString());
    }
    return ScriptHelper.a.b(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.task.CEBackgroundInitTask
 * JD-Core Version:    0.7.0.1
 */