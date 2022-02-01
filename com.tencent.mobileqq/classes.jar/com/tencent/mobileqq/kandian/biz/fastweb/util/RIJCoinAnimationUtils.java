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
  private static int jdField_a_of_type_Int;
  @Nullable
  private static View jdField_a_of_type_AndroidViewView;
  @NotNull
  private static URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = (URLDrawable.URLDrawableListener)new RIJCoinAnimationUtils.downloadListener.1();
  public static final RIJCoinAnimationUtils a;
  private static int b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilRIJCoinAnimationUtils = new RIJCoinAnimationUtils();
    jdField_a_of_type_Int = -1;
    b = 1;
  }
  
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
  
  private final int c()
  {
    int i;
    if (jdField_a_of_type_Int == 2) {
      i = 3;
    } else {
      i = 1;
    }
    b = i;
    return b;
  }
  
  private final void c()
  {
    ThreadManager.getUIHandler().post((Runnable)RIJCoinAnimationUtils.refreshCoinUI.1.a);
  }
  
  private final void c(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      Object localObject = jdField_a_of_type_AndroidViewView;
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
  
  private final void d()
  {
    int i = jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        b();
        RIJ3ClickUtils.a.a(true);
        return;
      }
      RIJ3ClickUtils.a.b();
      return;
    }
    c();
  }
  
  private final void e()
  {
    if (jdField_a_of_type_Int != 3) {
      return;
    }
    b();
  }
  
  public final int a()
  {
    return jdField_a_of_type_Int;
  }
  
  @Nullable
  public final View a()
  {
    return jdField_a_of_type_AndroidViewView;
  }
  
  public final void a()
  {
    View localView = jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  public final void a(@Nullable View paramView, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (paramView != null) {
      try
      {
        jdField_a_of_type_Int = paramInt;
        jdField_a_of_type_AndroidViewView = paramView;
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
    localApngOptions.a(c());
    localApngOptions.a(jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
    c(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, localApngOptions));
  }
  
  public final int b()
  {
    return b;
  }
  
  public final void b()
  {
    ThreadManager.getUIHandler().post((Runnable)RIJCoinAnimationUtils.refresh3Click.1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJCoinAnimationUtils
 * JD-Core Version:    0.7.0.1
 */