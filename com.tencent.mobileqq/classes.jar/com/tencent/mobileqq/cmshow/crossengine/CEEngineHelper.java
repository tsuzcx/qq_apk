package com.tencent.mobileqq.cmshow.crossengine;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineHelper;", "", "()V", "TAG", "", "isEngineReady", "", "addOnScreenViewIfNeed", "", "scenes", "", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "container", "Landroid/view/ViewGroup;", "doAddOnScreenView", "initDebugRes", "initEngineRes", "loadListener", "Lcom/tencent/mobileqq/apollo/utils/CrossEngineResManager$LoadListener;", "isEngineResReady", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEEngineHelper
{
  public static final CEEngineHelper a = new CEEngineHelper();
  private static boolean b;
  
  private final void a(ViewGroup paramViewGroup)
  {
    QLog.i("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, "add CrossEngine onScreenView");
    Object localObject = CECMShowOffscreenEngine.a.a();
    if (localObject != null) {
      localObject = ((ICMShowView)localObject).getView();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.i("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, "add CrossEngine onScreenView, fail, onScreenView null");
      return;
    }
    if (((View)localObject).getParent() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add CrossEngine onScreenView to root view: ");
      localStringBuilder.append(paramViewGroup);
      QLog.w("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, localStringBuilder.toString());
      try
      {
        ((View)localObject).setAlpha(0.0F);
        paramViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(100, 100));
        return;
      }
      catch (Throwable paramViewGroup)
      {
        QLog.e("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, "add CrossEngine onScreenView to root view exception:", paramViewGroup);
        return;
      }
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("CrossEngine onScreenView parent:");
    paramViewGroup.append(((View)localObject).getParent());
    QLog.i("[cmshow][CECMShowOffscreenEngine][CEEngineHelper]", 1, paramViewGroup.toString());
  }
  
  private final void b() {}
  
  public final void a(@Nullable CrossEngineResManager.LoadListener paramLoadListener)
  {
    if (b)
    {
      if (paramLoadListener != null) {
        paramLoadListener.a(0);
      }
      return;
    }
    b();
    CrossEngineResManager.a((CrossEngineResManager.LoadListener)new CEEngineHelper.initEngineRes.1(paramLoadListener));
  }
  
  public final void a(@NotNull List<? extends Scene> paramList, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "scenes");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Scene localScene = (Scene)paramList.next();
      if (CMShowPlatform.a.b(localScene))
      {
        i = 1;
        break label57;
      }
    }
    int i = 0;
    label57:
    if ((i != 0) && (!CECMShowOffscreenEngine.a.b())) {
      CECMShowOffscreenEngine.a.a((Function2)new CEEngineHelper.addOnScreenViewIfNeed.1(paramViewGroup));
    }
  }
  
  public final boolean a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper
 * JD-Core Version:    0.7.0.1
 */