package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.ApolloLottieAnim;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;

public class HippyLottieView
  extends FrameLayout
  implements HippyViewBase
{
  public static final String a;
  private DiniFlyAnimationView b;
  private ApolloLottieAnim c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/{LOTTIE_ZIP_HASHCODE}");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
  }
  
  public HippyLottieView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(getContext()).inflate(2131629625, this);
    this.b = ((DiniFlyAnimationView)findViewById(2131437754));
  }
  
  public void a()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView postDraw");
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void a(HippyMap paramHippyMap)
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView init");
    if (this.b != null) {
      a();
    }
  }
  
  public void b()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView destroy");
    DiniFlyAnimationView localDiniFlyAnimationView = this.b;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.destroyDrawingCache();
    }
  }
  
  public void c()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView play");
    f();
    DiniFlyAnimationView localDiniFlyAnimationView = this.b;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void d()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView resume");
    DiniFlyAnimationView localDiniFlyAnimationView = this.b;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.resumeAnimation();
    }
  }
  
  public void e()
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView pause");
    DiniFlyAnimationView localDiniFlyAnimationView = this.b;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.pauseAnimation();
    }
  }
  
  public void f()
  {
    if (this.b != null)
    {
      if (!TextUtils.isEmpty(this.d)) {
        this.b.setAnimationFromUrl(this.d);
      }
      this.b.setMinFrame(this.e);
      this.b.setMaxFrame(this.f);
      this.b.setRepeatCount(this.g);
      this.b.setSpeed(this.h);
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void setEndFrame(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setFitFullScreenXY()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.b;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.setFitFullScreenXY();
    }
  }
  
  public void setFrame(int paramInt)
  {
    QLog.d("HippyLottieView", 1, "HippyLottieView setFrame");
    DiniFlyAnimationView localDiniFlyAnimationView = this.b;
    if (localDiniFlyAnimationView != null) {
      localDiniFlyAnimationView.setFrame(paramInt);
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setRepeatCount(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setSpeed(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setSrc(String paramString)
  {
    this.d = paramString;
  }
  
  public void setStartFrame(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setZipSrc(@NotNull String paramString)
  {
    if (this.c == null) {
      this.c = new ApolloLottieAnim(null, getContext());
    }
    try
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.hashCode());
      localStringBuilder.append("");
      localObject = ((String)localObject).replace("{LOTTIE_ZIP_HASHCODE}", localStringBuilder.toString());
      if (this.c.a((String)localObject))
      {
        this.c.a(getContext(), this.b, (String)localObject, true);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.hashCode());
      ((StringBuilder)localObject).append("");
      localObject = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/{LOTTIE_ZIP_HASHCODE}.zip".replace("{LOTTIE_ZIP_HASHCODE}", ((StringBuilder)localObject).toString());
      this.c.a(this.b, paramString, (String)localObject, true);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setZipSrc Exception:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("HippyLottieView", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyLottieView
 * JD-Core Version:    0.7.0.1
 */