package com.tencent.mobileqq.cmshow.engine;

import android.content.Context;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.debug.utils.ApolloDebugUtils;
import com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine;
import com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine.CONSTANT;
import com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine;
import com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/CMShowPlatform;", "", "()V", "DISABLE", "", "ENABLE", "TAG", "", "sCESwitchMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "", "Lkotlin/collections/HashMap;", "isEngineReady", "scene", "loadEngine", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "context", "Landroid/content/Context;", "defaultRunOnCrossEngine", "useDebugSetting", "runOnCrossEngine", "runOnWhichEngine", "Lcom/tencent/mobileqq/cmshow/engine/EngineType;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMShowPlatform
{
  public static final CMShowPlatform a = new CMShowPlatform();
  private static final HashMap<Scene, Boolean> b = new HashMap();
  
  private final int a(@NotNull Scene paramScene, boolean paramBoolean)
  {
    switch (CMShowPlatform.WhenMappings.$EnumSwitchMapping$2[paramScene.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return 0;
              } while (!paramBoolean);
              return 1;
            } while (!paramBoolean);
            return 1;
          } while (!paramBoolean);
          return 1;
        } while (!paramBoolean);
        return 1;
      } while (!paramBoolean);
    }
    return 1;
  }
  
  @NotNull
  public final ICMShowEngine a(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    EngineType localEngineType = c(paramScene);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadEngine with type:");
    ((StringBuilder)localObject).append(localEngineType);
    ((StringBuilder)localObject).append(" for scene:");
    ((StringBuilder)localObject).append(paramScene);
    QLog.w("[cmshow][CMShowPlatform]", 1, ((StringBuilder)localObject).toString());
    localObject = EngineHelper.a;
    int i = CMShowPlatform.WhenMappings.$EnumSwitchMapping$0[localEngineType.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return (ICMShowEngine)new CECMShowOffscreenEngine(paramContext, paramScene);
      }
      throw new NoWhenBranchMatchedException();
    }
    return (ICMShowEngine)new BKCMShowEngine(paramContext, paramScene);
  }
  
  public final boolean a(@NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    paramScene = c(paramScene);
    int i = CMShowPlatform.WhenMappings.$EnumSwitchMapping$1[paramScene.ordinal()];
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
    if (b.containsKey(paramScene))
    {
      paramScene = b.get(paramScene);
      if (paramScene == null) {
        Intrinsics.throwNpe();
      }
      return ((Boolean)paramScene).booleanValue();
    }
    boolean bool2 = false;
    boolean bool3 = CmShowWnsUtils.a(paramScene, a(paramScene, false));
    Object localObject = paramScene.debugConfigKey();
    if (a(paramScene, true) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool1 = ApolloDebugUtils.a((String)localObject, bool1);
    if ((paramScene == Scene.AIO) || (paramScene == Scene.FRIEND_CARD))
    {
      boolean bool4 = CmShowWnsUtils.I();
      boolean bool5 = b(Scene.MEME_PLAYER);
      if ((bool4) && (bool5))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enableCrossEngineForScene current scene:");
        ((StringBuilder)localObject).append(paramScene);
        ((StringBuilder)localObject).append(", return true for memePlayer run on CE, enableByWns:");
        ((StringBuilder)localObject).append(bool3);
        QLog.w("[cmshow][CMShowPlatform]", 1, ((StringBuilder)localObject).toString());
        ((Map)b).put(paramScene, Boolean.valueOf(true));
        return true;
      }
    }
    if (!bool1)
    {
      bool1 = bool2;
      if (!bool3) {}
    }
    else
    {
      bool1 = true;
    }
    ((Map)b).put(paramScene, Boolean.valueOf(bool1));
    return bool1;
  }
  
  @Deprecated(message="will delete")
  @NotNull
  public final EngineType c(@NotNull Scene paramScene)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "$this$runOnWhichEngine");
    boolean bool = b(paramScene);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runOnWhichEngine, enable CrossEngine:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" for scene:");
    localStringBuilder.append(paramScene);
    QLog.i("[cmshow][CMShowPlatform]", 1, localStringBuilder.toString());
    if (bool) {
      return EngineType.CE;
    }
    return EngineType.BK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.CMShowPlatform
 * JD-Core Version:    0.7.0.1
 */