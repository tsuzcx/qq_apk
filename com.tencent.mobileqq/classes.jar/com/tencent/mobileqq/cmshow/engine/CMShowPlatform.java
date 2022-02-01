package com.tencent.mobileqq.cmshow.engine;

import android.content.Context;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine;
import com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine.CONSTANT;
import com.tencent.mobileqq.cmshow.crossengine.CECMShowEngine;
import com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine;
import com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/CMShowPlatform;", "", "()V", "DISABLE", "", "ENABLE", "TAG", "", "isEngineReady", "", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "loadEngine", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "context", "Landroid/content/Context;", "defaultRunOnCrossEngine", "runOnCrossEngine", "runOnWhichEngine", "Lcom/tencent/mobileqq/cmshow/engine/CMShowPlatform$EngineType;", "EngineType", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMShowPlatform
{
  public static final CMShowPlatform a = new CMShowPlatform();
  
  private final int a(@NotNull Scene paramScene)
  {
    int i = CMShowPlatform.WhenMappings.c[paramScene.ordinal()];
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4)) {}
    return 0;
  }
  
  private final CMShowPlatform.EngineType a(@NotNull Scene paramScene)
  {
    boolean bool = b(paramScene);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runOnWhichEngine, enable CrossEngine:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" for scene:");
    localStringBuilder.append(paramScene);
    QLog.i("[cmshow][CMShowPlatform]", 1, localStringBuilder.toString());
    if (bool) {
      return CMShowPlatform.EngineType.CE;
    }
    return CMShowPlatform.EngineType.BK;
  }
  
  @NotNull
  public final ICMShowEngine a(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    CMShowPlatform.EngineType localEngineType = a(paramScene);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadEngine with type:");
    ((StringBuilder)localObject).append(localEngineType);
    ((StringBuilder)localObject).append(" for scene:");
    ((StringBuilder)localObject).append(paramScene);
    QLog.w("[cmshow][CMShowPlatform]", 1, ((StringBuilder)localObject).toString());
    localObject = EngineHelper.a;
    int i = CMShowPlatform.WhenMappings.a[localEngineType.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        if (CmShowWnsUtils.x()) {
          return (ICMShowEngine)new CECMShowOffscreenEngine(paramContext, paramScene);
        }
        return (ICMShowEngine)new CECMShowEngine(paramContext, paramScene);
      }
      throw new NoWhenBranchMatchedException();
    }
    return (ICMShowEngine)new BKCMShowEngine(paramContext, paramScene);
  }
  
  public final boolean a(@NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    paramScene = a(paramScene);
    int i = CMShowPlatform.WhenMappings.b[paramScene.ordinal()];
    boolean bool1;
    if (i != 1)
    {
      if (i == 2)
      {
        boolean bool2 = CEEngineHelper.a.a();
        bool1 = bool2;
        if (!bool2)
        {
          CEEngineHelper.a(CEEngineHelper.a, null, 1, null);
          return bool2;
        }
      }
      else
      {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      bool1 = BKCMShowEngine.a.a();
    }
    return bool1;
  }
  
  public final boolean b(@NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "$this$runOnCrossEngine");
    return CmShowWnsUtils.a(paramScene, a(paramScene));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.CMShowPlatform
 * JD-Core Version:    0.7.0.1
 */