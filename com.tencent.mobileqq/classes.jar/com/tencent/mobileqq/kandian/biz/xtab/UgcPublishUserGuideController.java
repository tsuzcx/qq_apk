package com.tencent.mobileqq.kandian.biz.xtab;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.UiThread;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/UgcPublishUserGuideController;", "", "parent", "Landroid/widget/FrameLayout;", "bottomMargin", "", "(Landroid/widget/FrameLayout;I)V", "context", "Landroid/content/Context;", "guidePopView", "Landroid/widget/ImageView;", "popResourceLoadListener", "com/tencent/mobileqq/kandian/biz/xtab/UgcPublishUserGuideController$popResourceLoadListener$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/UgcPublishUserGuideController$popResourceLoadListener$1;", "addGuidePopView", "", "url", "", "buildAPngDrawable", "Lcom/tencent/image/URLDrawable;", "width", "height", "calculateMarginBottom", "getPopResourceUrl", "getPopShowDuration", "", "handleLoadPopResourceSuccess", "removeGuidePopView", "shouldShowGuidePopView", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UgcPublishUserGuideController
{
  public static final UgcPublishUserGuideController.Companion a = new UgcPublishUserGuideController.Companion(null);
  private static final int g = LayoutAttrsKt.getDp(70);
  private static final int h = LayoutAttrsKt.getDp(400);
  private final Context b;
  private ImageView c;
  private final UgcPublishUserGuideController.popResourceLoadListener.1 d;
  private final FrameLayout e;
  private final int f;
  
  public UgcPublishUserGuideController(@NotNull FrameLayout paramFrameLayout, int paramInt)
  {
    this.e = paramFrameLayout;
    this.f = paramInt;
    paramFrameLayout = this.e.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramFrameLayout, "parent.context");
    this.b = paramFrameLayout;
    paramFrameLayout = Aladdin.getConfig(473).getString("pop_flag", "");
    SharedPreferences localSharedPreferences = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false);
    if ((Intrinsics.areEqual(localSharedPreferences.getString("key_show_user_guide_flag", ""), paramFrameLayout) ^ true)) {
      localSharedPreferences.edit().putBoolean("key_user_guide_pop_showed", true).putString("key_show_user_guide_flag", paramFrameLayout).apply();
    }
    this.d = new UgcPublishUserGuideController.popResourceLoadListener.1(this);
  }
  
  private final int a(int paramInt)
  {
    float f1 = paramInt;
    return this.f - (int)(f1 * 0.1376147F);
  }
  
  private final URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a((Drawable)new ColorDrawable(7));
    localApngOptions.b(paramInt1);
    localApngOptions.c(paramInt2);
    return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, localApngOptions);
  }
  
  private final void c()
  {
    RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false).edit().putBoolean("key_user_guide_pop_showed", false).apply();
    ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new UgcPublishUserGuideController.handleLoadPopResourceSuccess.1(this), e());
    PublicAccountReportUtils.a("0X800BC42", "");
  }
  
  private final boolean d()
  {
    return RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false).getBoolean("key_user_guide_pop_showed", true);
  }
  
  private final long e()
  {
    return Aladdin.getConfig(473).getLongFromString("pop_duration", 3000L);
  }
  
  private final String f()
  {
    String str = Aladdin.getConfig(473).getString("pop_url", "https://pub.idqqimg.com/pc/misc/files/20210430/98fa149141b148fba477d9b64e58cd8b.png");
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…R_GUIDE_URL, DEFAULT_URL)");
    return str;
  }
  
  @UiThread
  @JvmOverloads
  public final void a()
  {
    a(this, null, 1, null);
  }
  
  @UiThread
  @JvmOverloads
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    boolean bool = d();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addGuidePopView, shouldShowGuidePopView=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("UgcPublishUserGuideController", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool) {
      return;
    }
    if (this.c == null)
    {
      localObject = new ImageView(this.b);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      Size localSize = DisplayUtil.a(this.b);
      Intrinsics.checkExpressionValueIsNotNull(localSize, "DisplayUtil.getScreenSize(context)");
      int j = localSize.a() - g;
      int k = h;
      int i = j;
      if (j > k) {
        i = k;
      }
      j = (int)(i * 0.36F);
      paramString = a(paramString, i, j);
      if ((paramString != null) && (paramString.getStatus() == 1))
      {
        QLog.e("UgcPublishUserGuideController", 1, "pop resource memory matched");
        c();
      }
      else if (paramString != null)
      {
        paramString.setURLDrawableListener((URLDrawable.URLDrawableListener)this.d);
      }
      ((ImageView)localObject).setImageDrawable((Drawable)paramString);
      paramString = new FrameLayout.LayoutParams(i, j);
      paramString.gravity = 85;
      paramString.rightMargin = g;
      paramString.bottomMargin = a(j);
      this.e.addView((View)localObject, (ViewGroup.LayoutParams)paramString);
      this.c = ((ImageView)localObject);
    }
    paramString = this.c;
    if (paramString != null) {
      paramString.setVisibility(0);
    }
    QLog.i("UgcPublishUserGuideController", 1, "addGuidePopView, success");
  }
  
  @UiThread
  public final void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeGuidePopView, guidePopView=");
      ((StringBuilder)localObject).append(this.c);
      QLog.i("UgcPublishUserGuideController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      this.e.removeView((View)localObject);
      this.c = ((ImageView)null);
      QLog.i("UgcPublishUserGuideController", 1, "removeGuidePopView, success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.UgcPublishUserGuideController
 * JD-Core Version:    0.7.0.1
 */