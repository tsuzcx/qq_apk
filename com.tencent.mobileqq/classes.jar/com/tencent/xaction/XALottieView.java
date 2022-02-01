package com.tencent.xaction;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XALottieView;", "Lcom/tencent/mobileqq/dinifly/DiniFlyAnimationView;", "Lcom/tencent/xaction/api/IView;", "Lcom/tencent/xaction/api/IAnim;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "mIsStop", "", "mListener", "Lcom/tencent/mobileqq/dinifly/OnCompositionLoadedListener;", "doFrame", "", "frameTimeNanos", "", "end", "load", "src", "", "imageFolderPath", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "play", "preStart", "view", "Landroid/view/View;", "AssetDelegate", "Companion", "XALottie_release"}, k=1, mv={1, 1, 16})
@Keep
public final class XALottieView
  extends DiniFlyAnimationView
  implements IAnim, IView
{
  public static final XALottieView.Companion Companion = new XALottieView.Companion(null);
  private static final String KEY_CONFIG = "config";
  private static final String KEY_IMAGE_PATH = "imagepath";
  private static final String TAG = "XALottieView";
  @Nullable
  private static MQLruCache<String, Object> mqLruCache;
  private HashMap _$_findViewCache;
  @NotNull
  private DecorView decor = (DecorView)new XALottieView.decor.1(this, (IView)this);
  private boolean mIsStop;
  private final OnCompositionLoadedListener mListener = (OnCompositionLoadedListener)new XALottieView.mListener.1(this);
  
  public XALottieView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  @Nullable
  public static final MQLruCache<String, Object> getMqLruCache()
  {
    XALottieView.Companion localCompanion = Companion;
    return mqLruCache;
  }
  
  public static final void setMqLruCache(@Nullable MQLruCache<String, Object> paramMQLruCache)
  {
    XALottieView.Companion localCompanion = Companion;
    mqLruCache = paramMQLruCache;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this._$_findViewCache;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void doFrame(long paramLong) {}
  
  public void end()
  {
    cancelAnimation();
  }
  
  @NotNull
  public DecorView getDecor()
  {
    return this.decor;
  }
  
  public final void load(@NotNull String paramString1, @Nullable String paramString2, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "src");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    try
    {
      Object localObject = FileUtil.a;
      Resources localResources = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localResources, "resources");
      paramString1 = ((FileUtil.Companion)localObject).a(localResources, paramString1, paramIXAEngine);
      if (paramString1 != null)
      {
        paramIXAEngine = new Bundle();
        localObject = getDecor().getStyle();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        paramIXAEngine.putString("key", Intrinsics.stringPlus(paramString2, Integer.valueOf(((ViewData)localObject).getId())));
        paramIXAEngine.putString("path", paramString2);
        LottieComposition.Factory.fromInputStreamWithCacheBitmap(getContext(), paramString1, getLottieDrawable(), this.mListener, paramIXAEngine, mqLruCache);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.a("XALottieView", 1, "XALottie load error!", (Throwable)paramString1);
    }
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
    this.decor = paramDecorView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XALottieView
 * JD-Core Version:    0.7.0.1
 */