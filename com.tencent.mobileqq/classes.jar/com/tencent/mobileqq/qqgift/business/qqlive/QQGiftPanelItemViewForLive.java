package com.tencent.mobileqq.qqgift.business.qqlive;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.countdown.CountDownController;
import com.tencent.mobileqq.qqgift.countdown.CountDownInfo;
import com.tencent.mobileqq.qqgift.countdown.TimerInfo;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData.CornerIcon;
import com.tencent.mobileqq.qqgift.manager.QQGiftCountDownManager;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelItemView;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.utils.QQGiftImageUtil;
import com.tencent.mobileqq.qqgift.view.QQGiftCircleProgress;
import com.tencent.mobileqq.qqgift.view.anim.GiftCountDownAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QQGiftPanelItemViewForLive
  extends FrameLayout
  implements IQQGiftPanelItemView
{
  public Drawable a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private RelativeLayout f;
  private QQGiftPanelViewModelForLive g;
  private QQGiftCircleProgress h;
  private TextView i;
  private GiftServiceData j;
  private boolean k;
  private GiftCountDownAnimation l;
  private final Observer<TimerInfo> m = new QQGiftPanelItemViewForLive.1(this);
  
  public QQGiftPanelItemViewForLive(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQGiftPanelItemViewForLive(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQGiftPanelItemViewForLive(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    this.h = ((QQGiftCircleProgress)findViewById(2131440749));
    this.h.setBgAndProgressColor(0, getResources().getColor(2131168376), 100, getResources().getColor(2131167358));
    this.h.setmShadowColor(0);
    this.h.setStrokeWidth(2.0F);
    this.h.setProgress(0.0F);
    this.i = ((TextView)findViewById(2131448361));
    this.i.setBackgroundDrawable(getResources().getDrawable(2130847994));
    a(false);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2131627980, this);
    this.b = ((ImageView)findViewById(2131436394));
    this.f = ((RelativeLayout)findViewById(2131444973));
    this.c = ((TextView)findViewById(2131448494));
    this.d = ((TextView)findViewById(2131448492));
    this.e = ((ImageView)findViewById(2131436398));
    a();
    this.a = QQGiftImageUtil.a(getContext());
  }
  
  private void a(View paramView)
  {
    try
    {
      paramView = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.2F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.2F }) });
      paramView.setDuration(500L);
      paramView.start();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QQGiftPanelItemViewForLive", 1, paramView, new Object[0]);
    }
  }
  
  private void a(CountDownInfo paramCountDownInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[refreshCountDownProgress] progress");
      localStringBuilder.append(this.h.getProgress());
      QLog.i("QQGiftPanelItemViewForLive", 2, localStringBuilder.toString());
    }
    a(true);
    if (this.h.getProgress() == 0.0F)
    {
      f();
      float f1 = paramCountDownInfo.a(paramCountDownInfo.b, paramCountDownInfo.c);
      this.h.setProgress(f1);
      this.l = new GiftCountDownAnimation(this.h, paramCountDownInfo.c, f1);
      this.l.a();
    }
    this.i.setText(paramString);
  }
  
  private void a(GiftServiceData paramGiftServiceData, int paramInt)
  {
    boolean bool = paramGiftServiceData.i;
    if ((!this.k) && (bool))
    {
      a(this.b);
      QQGiftPanelViewModelForLive localQQGiftPanelViewModelForLive = this.g;
      if (localQQGiftPanelViewModelForLive != null) {
        localQQGiftPanelViewModelForLive.b(paramGiftServiceData, paramInt);
      }
      if ((!QQGiftCountDownManager.a(paramGiftServiceData)) || (!a(paramGiftServiceData))) {
        e();
      }
    }
    this.j = paramGiftServiceData;
    this.k = paramGiftServiceData.i;
  }
  
  private void a(String paramString1, String paramString2)
  {
    String str = paramString2;
    try
    {
      if (TextUtils.isEmpty(paramString2)) {
        str = getDefaultFreeTips();
      }
      paramString2 = str.replace("{leftTime}", paramString1);
      paramString1 = paramString2;
    }
    catch (Throwable paramString2)
    {
      QLog.e("QQGiftPanelItemViewForLive", 1, paramString2, new Object[0]);
      paramString1 = getDefaultFreeTips().replace("{leftTime}", paramString1);
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.g.f().setValue(paramString1);
      return;
    }
    this.g.f().postValue(paramString1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      f();
      this.h.setProgress(0.0F);
    }
    Object localObject = this.i;
    int i1 = 0;
    int n;
    if (paramBoolean) {
      n = 0;
    } else {
      n = 4;
    }
    ((TextView)localObject).setVisibility(n);
    localObject = this.h;
    if (paramBoolean) {
      n = i1;
    } else {
      n = 8;
    }
    ((QQGiftCircleProgress)localObject).setVisibility(n);
  }
  
  private boolean a(GiftServiceData paramGiftServiceData)
  {
    Object localObject = QQGiftCountDownManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g.i().c().a);
    localStringBuilder.append("");
    localObject = ((QQGiftCountDownManager)localObject).a(localStringBuilder.toString());
    if (localObject != null)
    {
      localObject = ((CountDownController)localObject).d();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramGiftServiceData.a);
      localStringBuilder.append("");
      paramGiftServiceData = (CountDownInfo)((Map)localObject).get(localStringBuilder.toString());
    }
    else
    {
      paramGiftServiceData = null;
    }
    return paramGiftServiceData != null;
  }
  
  private void b()
  {
    if (d())
    {
      Object localObject1 = QQGiftCountDownManager.a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.g.i().c().a);
      ((StringBuilder)localObject2).append("");
      localObject1 = ((QQGiftCountDownManager)localObject1).a(((StringBuilder)localObject2).toString());
      if (localObject1 != null)
      {
        localObject1 = ((CountDownController)localObject1).c();
        if (localObject1 != null)
        {
          localObject2 = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment((Activity)getContext());
          ((MutableLiveData)localObject1).removeObserver(this.m);
          ((MutableLiveData)localObject1).observe((LifecycleOwner)localObject2, this.m);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[observe] updateLiveData:");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.e("QQGiftPanelItemViewForLive", 1, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        QLog.e("QQGiftPanelItemViewForLive", 1, "[onAttachedToWindow] countDownCtrl is null");
      }
    }
  }
  
  private void b(GiftServiceData paramGiftServiceData)
  {
    boolean bool = c(paramGiftServiceData);
    ImageView localImageView = this.e;
    int n;
    if (bool) {
      n = 0;
    } else {
      n = 4;
    }
    localImageView.setVisibility(n);
    if (bool)
    {
      paramGiftServiceData = QQGiftImageUtil.a(paramGiftServiceData.k.a, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a);
      this.e.setImageDrawable(paramGiftServiceData);
    }
  }
  
  private void c()
  {
    if (d())
    {
      Object localObject = QQGiftCountDownManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g.i().c().a);
      localStringBuilder.append("");
      localObject = ((QQGiftCountDownManager)localObject).a(localStringBuilder.toString());
      if (localObject != null)
      {
        localObject = ((CountDownController)localObject).c();
        if (localObject != null) {
          ((MutableLiveData)localObject).removeObserver(this.m);
        }
      }
      else
      {
        QLog.e("QQGiftPanelItemViewForLive", 1, "[onDetachedFromWindow] countDownCtrl is null");
      }
    }
  }
  
  private boolean c(GiftServiceData paramGiftServiceData)
  {
    GiftServiceData.CornerIcon localCornerIcon = paramGiftServiceData.k;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCornerIcon != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramGiftServiceData.k.a))
      {
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = paramGiftServiceData.k.b;
        long l3 = paramGiftServiceData.k.c;
        bool1 = bool2;
        if (l1 >= l2)
        {
          bool1 = bool2;
          if (l1 <= l3) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d()
  {
    QQGiftPanelViewModelForLive localQQGiftPanelViewModelForLive = this.g;
    return (localQQGiftPanelViewModelForLive != null) && (localQQGiftPanelViewModelForLive.i() != null) && (this.g.i().c() != null);
  }
  
  private void e()
  {
    QQGiftPanelViewModelForLive localQQGiftPanelViewModelForLive = this.g;
    if (localQQGiftPanelViewModelForLive != null) {
      localQQGiftPanelViewModelForLive.g().setValue(Integer.valueOf(0));
    }
  }
  
  private void f()
  {
    GiftCountDownAnimation localGiftCountDownAnimation = this.l;
    if (localGiftCountDownAnimation != null) {
      localGiftCountDownAnimation.b();
    }
  }
  
  private String getDefaultFreeTips()
  {
    return getResources().getString(2131897854);
  }
  
  private void setGiftIcon(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
    RelativeLayout localRelativeLayout = this.f;
    if (this.k) {
      paramDrawable = getBgDrawable();
    } else {
      paramDrawable = null;
    }
    localRelativeLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(int paramInt)
  {
    setGiftIcon(this.a);
    QQGiftPanelViewModelForLive localQQGiftPanelViewModelForLive = this.g;
    if ((localQQGiftPanelViewModelForLive != null) && (localQQGiftPanelViewModelForLive.i() != null)) {
      this.g.i().g().a(paramInt, new QQGiftPanelItemViewForLive.ResCallback(this));
    }
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    GiftServiceData localGiftServiceData = this.j;
    if ((localGiftServiceData != null) && (localGiftServiceData.j == 1))
    {
      this.d.setText(getResources().getString(2131897848));
      return;
    }
    this.d.setText(String.format(getResources().getString(2131897849), new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public Drawable getBgDrawable()
  {
    if (this.g.r()) {
      return getResources().getDrawable(2130847984);
    }
    return getResources().getDrawable(2130847983);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAttachedToWindow] this:");
      localStringBuilder.append(hashCode());
      QLog.i("QQGiftPanelItemViewForLive", 2, localStringBuilder.toString());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(false);
    c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDetachedFromWindow] this:");
      localStringBuilder.append(hashCode());
      QLog.i("QQGiftPanelItemViewForLive", 2, localStringBuilder.toString());
    }
    f();
  }
  
  public void setIsSelected(GiftServiceData paramGiftServiceData, int paramInt)
  {
    a(paramGiftServiceData, paramInt);
    b(paramGiftServiceData);
  }
  
  public void setViewModel(QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive)
  {
    this.g = paramQQGiftPanelViewModelForLive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelItemViewForLive
 * JD-Core Version:    0.7.0.1
 */