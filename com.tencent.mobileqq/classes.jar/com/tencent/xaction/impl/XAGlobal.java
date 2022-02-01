package com.tencent.xaction.impl;

import androidx.annotation.Keep;
import com.tencent.xaction.api.util.ReflectUtil;
import com.tencent.xaction.api.util.ReflectUtil.Companion;
import com.tencent.xaction.manager.RuleManager;
import com.tencent.xaction.manager.RuleManager.Companion;
import com.tencent.xaction.manager.ViewManager;
import com.tencent.xaction.openapi.api.IXAGlobal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XAGlobal;", "Lcom/tencent/xaction/openapi/api/IXAGlobal;", "()V", "getVersion", "", "pauseAll", "", "registerAnim", "", "name", "clazzName", "registerDrawable", "s", "registerGlobalRule", "rule", "value", "", "registerTrigger", "registerView", "resumeAll", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class XAGlobal
  implements IXAGlobal
{
  @NotNull
  public String getVersion()
  {
    return "beta.0.0.0.692021-16-01/15:16:08";
  }
  
  public void pauseAll()
  {
    XAEngine.Companion.a();
  }
  
  public boolean registerAnim(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "clazzName");
    paramString2 = ReflectUtil.a.a(paramString2);
    if (paramString2 != null) {
      return XAEngine.Companion.a(paramString1, paramString2);
    }
    return false;
  }
  
  public void registerDrawable(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "s");
    Intrinsics.checkParameterIsNotNull(paramString2, "clazzName");
    XAEngine.Companion.a(paramString1, paramString2);
  }
  
  public void registerGlobalRule(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rule");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    RuleManager.Companion.a(paramString, paramObject);
  }
  
  public boolean registerTrigger(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "clazzName");
    paramString2 = ReflectUtil.a.a(paramString2);
    if (paramString2 != null) {
      return XAEngine.Companion.b(paramString1, paramString2);
    }
    return false;
  }
  
  public void registerView(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "clazzName");
    XAEngine.Companion.a().a(paramString1, paramString2);
  }
  
  public void resumeAll()
  {
    XAEngine.Companion.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XAGlobal
 * JD-Core Version:    0.7.0.1
 */