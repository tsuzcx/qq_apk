package com.tencent.mobileqq.cmshow.crossengine;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineHelper;", "", "()V", "TAG", "", "isEngineReady", "", "addOnScreenViewIfNeed", "", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "container", "Landroid/view/ViewGroup;", "doAddOnScreenView", "initDebugRes", "initEngineRes", "loadListener", "Lcom/tencent/mobileqq/apollo/utils/CrossEngineResManager$LoadListener;", "isEngineResReady", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEEngineHelper
{
  public static final CEEngineHelper a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineHelper = new CEEngineHelper();
  }
  
  private final void a() {}
  
  private final void b(Scene paramScene, ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("add CrossEngine onScreenView from ");
    ((StringBuilder)localObject).append(paramScene);
    QLog.i("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, ((StringBuilder)localObject).toString());
    localObject = CECMShowOffscreenEngine.a.a();
    if (localObject != null) {
      localObject = ((ICMShowView)localObject).getView();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("add CrossEngine onScreenView from ");
      paramViewGroup.append(paramScene);
      paramViewGroup.append(", fail, onScreenView null");
      QLog.i("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, paramViewGroup.toString());
      return;
    }
    if (((View)localObject).getParent() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add CrossEngine onScreenView to ");
      localStringBuilder.append(paramScene);
      localStringBuilder.append(" root view: ");
      localStringBuilder.append(paramViewGroup);
      QLog.w("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, localStringBuilder.toString());
      try
      {
        paramViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(100, 100));
        return;
      }
      catch (Throwable paramViewGroup)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add CrossEngine onScreenView to ");
        ((StringBuilder)localObject).append(paramScene);
        ((StringBuilder)localObject).append(" root view exception:");
        QLog.e("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, ((StringBuilder)localObject).toString(), paramViewGroup);
        return;
      }
    }
    paramScene = new StringBuilder();
    paramScene.append("CrossEngine onScreenView parent:");
    paramScene.append(((View)localObject).getParent());
    QLog.i("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, paramScene.toString());
  }
  
  public final void a(@Nullable CrossEngineResManager.LoadListener paramLoadListener)
  {
    if (jdField_a_of_type_Boolean)
    {
      if (paramLoadListener != null) {
        paramLoadListener.a(0);
      }
      return;
    }
    a();
    CrossEngineResManager.a((CrossEngineResManager.LoadListener)new CEEngineHelper.initEngineRes.1(paramLoadListener));
  }
  
  public final void a(@NotNull Scene paramScene, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramScene, "scene");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    if ((CMShowPlatform.a.b(paramScene)) && (CmShowWnsUtils.x()) && (!CECMShowOffscreenEngine.a.a())) {
      CECMShowOffscreenEngine.a.a((Function2)new CEEngineHelper.addOnScreenViewIfNeed.1(paramScene, paramViewGroup));
    }
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper
 * JD-Core Version:    0.7.0.1
 */