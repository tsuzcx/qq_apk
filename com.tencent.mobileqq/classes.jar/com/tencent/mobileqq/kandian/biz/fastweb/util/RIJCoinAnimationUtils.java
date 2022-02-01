package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/util/RIJCoinAnimationUtils;", "", "()V", "COIN_SUCCESS_SCENE", "", "SUCCESS_ANIMATION_URL", "", "TAG", "THREE_CLICK_LOADING_ANIMATION_URL", "THREE_CLICK_LOADING_SCENE", "THREE_CLICK_SUCCESS_ANIMATION_URL", "THREE_CLICK_SUCCESS_SCENE", "animationLoop", "getAnimationLoop", "()I", "setAnimationLoop", "(I)V", "animationScene", "getAnimationScene", "setAnimationScene", "currentView", "Landroid/view/View;", "getCurrentView", "()Landroid/view/View;", "setCurrentView", "(Landroid/view/View;)V", "downloadListener", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "getDownloadListener", "()Lcom/tencent/image/URLDrawable$URLDrawableListener;", "setDownloadListener", "(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V", "addApngListener", "", "drawable", "Lcom/tencent/image/URLDrawable;", "cleanLastFrame", "destroy", "doAnimation", "doAnimationFinishActions", "doApngAnimation", "coinView", "url", "sceneType", "doFailActions", "downloadApngAnimation", "width", "height", "finishAnimation", "getLoopCounts", "refresh3Click", "refreshCoinUI", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCoinAnimationUtils
{
  public static final RIJCoinAnimationUtils a = new RIJCoinAnimationUtils();
  @Nullable
  private static View b;
  private static int c = -1;
  private static int d = 1;
  @NotNull
  private static URLDrawable.URLDrawableListener e = (URLDrawable.URLDrawableListener)new RIJCoinAnimationUtils.downloadListener.1();
  
  private final void a(URLDrawable paramURLDrawable)
  {
    try
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if (((paramURLDrawable instanceof ApngDrawable)) && (((ApngDrawable)paramURLDrawable).getImage() != null))
      {
        paramURLDrawable = ((ApngDrawable)paramURLDrawable).getImage();
        Intrinsics.checkExpressionValueIsNotNull(paramURLDrawable, "apngDrawable.image");
        paramURLDrawable = paramURLDrawable.getCurrentFrame();
        if (paramURLDrawable != null)
        {
          paramURLDrawable.eraseColor(0);
          return;
        }
      }
    }
    catch (Exception paramURLDrawable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanLastFrame error!  msg=");
      localStringBuilder.append(paramURLDrawable);
      QLog.d("RIJCoinAnimationUtils", 1, localStringBuilder.toString());
    }
  }
  
  private final void b(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof ApngDrawable)) {
      ((ApngDrawable)paramURLDrawable).setOnPlayRepeatListener((ApngDrawable.OnPlayRepeatListener)RIJCoinAnimationUtils.addApngListener.1.a);
    }
  }
  
  private final void c(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      Object localObject = b;
      if (((localObject instanceof ImageView)) && (paramURLDrawable != null))
      {
        if (localObject != null)
        {
          localObject = (ImageView)localObject;
          ((ImageView)localObject).setVisibility(0);
          a(paramURLDrawable);
          ((ImageView)localObject).setImageDrawable((Drawable)paramURLDrawable);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
      }
    }
    QLog.d("RIJCoinAnimationUtils", 1, "doAnimation error!");
  }
  
  private final int f()
  {
    int i;
    if (c == 2) {
      i = 3;
    } else {
      i = 1;
    }
    d = i;
    return d;
  }
  
  private final void g()
  {
    ThreadManager.getUIHandler().post((Runnable)RIJCoinAnimationUtils.refreshCoinUI.1.a);
  }
  
  private final void h()
  {
    int i = c;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        e();
        RIJ3ClickUtils.a.a(true);
        return;
      }
      RIJ3ClickUtils.a.b();
      return;
    }
    g();
  }
  
  private final void i()
  {
    if (c != 3) {
      return;
    }
    e();
  }
  
  @Nullable
  public final View a()
  {
    return b;
  }
  
  public final void a(@Nullable View paramView, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (paramView != null) {
      try
      {
        c = paramInt;
        b = paramView;
        a(paramString, paramView.getWidth(), paramView.getHeight());
        return;
      }
      catch (Exception paramView)
      {
        paramString = new StringBuilder();
        paramString.append("doSuccessAnimation error! msg=");
        paramString.append(paramView);
        QLog.d("RIJCoinAnimationUtils", 1, paramString.toString());
      }
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a((Drawable)new ColorDrawable(7));
    localApngOptions.b(paramInt1);
    localApngOptions.c(paramInt2);
    localApngOptions.a(f());
    localApngOptions.a(e);
    c(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, localApngOptions));
  }
  
  public final int b()
  {
    return c;
  }
  
  public final int c()
  {
    return d;
  }
  
  public final void d()
  {
    View localView = b;
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  public final void e()
  {
    ThreadManager.getUIHandler().post((Runnable)RIJCoinAnimationUtils.refresh3Click.1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJCoinAnimationUtils
 * JD-Core Version:    0.7.0.1
 */