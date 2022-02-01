package com.tencent.xaction;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.view.View;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XALottieView;", "Lcom/tencent/mobileqq/dinifly/DiniFlyAnimationView;", "Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/api/IAnim;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "mIsStop", "", "mListener", "Lcom/tencent/mobileqq/dinifly/OnCompositionLoadedListener;", "doFrame", "", "frameTimeNanos", "", "end", "load", "src", "", "imageFolderPath", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "play", "preStart", "view", "Landroid/view/View;", "AssetDelegate", "Companion", "XALottie_release"}, k=1, mv={1, 1, 16})
public final class XALottieView
  extends DiniFlyAnimationView
  implements IAnim, IView
{
  @Nullable
  private static MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  public static final XALottieView.Companion a;
  private final OnCompositionLoadedListener jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener = (OnCompositionLoadedListener)new XALottieView.mListener.1(this);
  @NotNull
  private DecorView jdField_a_of_type_ComTencentXactionApiBaseDecorView = (DecorView)new XALottieView.decor.1(this, (IView)this);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentXactionXALottieView$Companion = new XALottieView.Companion(null);
  }
  
  public XALottieView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public static final void setMqLruCache(@Nullable MQLruCache<String, Object> paramMQLruCache)
  {
    XALottieView.Companion localCompanion = jdField_a_of_type_ComTencentXactionXALottieView$Companion;
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache = paramMQLruCache;
  }
  
  @NotNull
  public DecorView a()
  {
    return this.jdField_a_of_type_ComTencentXactionApiBaseDecorView;
  }
  
  public final void a(@NotNull String paramString1, @Nullable String paramString2, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "src");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    for (;;)
    {
      try
      {
        if (FileUtil.a.a(paramString1))
        {
          paramIXAEngine = getResources();
          Intrinsics.checkExpressionValueIsNotNull(paramIXAEngine, "resources");
          paramString1 = paramIXAEngine.getAssets().open(FileUtil.a.a(paramString1));
        }
        else
        {
          paramString1 = FilePathUtil.a.a(paramString1, "$PARENT_ROOT", paramIXAEngine);
          paramIXAEngine = new StringBuilder();
          paramIXAEngine.append("animFile path=");
          paramIXAEngine.append(paramString1);
          QLog.b("XALottieView", 2, paramIXAEngine.toString(), null);
          paramString1 = (InputStream)new FileInputStream(paramString1);
        }
      }
      catch (Exception paramString1)
      {
        ViewData localViewData;
        QLog.a("XALottieView", 1, "XALottie load error!", (Throwable)paramString1);
        return;
      }
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "if (FileUtil.isAssertsFi…m(filePath)\n            }");
      paramIXAEngine = new Bundle();
      localViewData = a().getStyle();
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      paramIXAEngine.putString("key", Intrinsics.stringPlus(paramString2, Integer.valueOf(localViewData.getId())));
      paramIXAEngine.putString("path", paramString2);
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(getContext(), paramString1, getLottieDrawable(), this.jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener, paramIXAEngine, jdField_a_of_type_AndroidSupportV4UtilMQLruCache);
      return;
    }
  }
  
  public void doFrame(long paramLong) {}
  
  public void end()
  {
    cancelAnimation();
  }
  
  public void play()
  {
    playAnimation();
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.jdField_a_of_type_ComTencentXactionApiBaseDecorView = paramDecorView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.XALottieView
 * JD-Core Version:    0.7.0.1
 */