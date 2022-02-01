package com.tencent.open.agent;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.SSOLog;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCardContainer
  extends RelativeLayout
{
  protected Context a;
  protected final int b;
  protected List<Permission> c;
  protected boolean d = false;
  protected int e = -1;
  protected LinearLayout f;
  protected ImageView g;
  protected URLImageView h;
  protected Handler i = new BaseCardContainer.1(this, Looper.getMainLooper());
  protected URLDrawableDownListener.Adapter j = new BaseCardContainer.2(this);
  private Drawable k;
  
  public BaseCardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.b = getResources().getDisplayMetrics().widthPixels;
    this.c = new ArrayList();
  }
  
  private URLDrawable c(String paramString)
  {
    Object localObject = getEmptyDrawable();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    try
    {
      localObject = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString = (String)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SSOLog.b("BaseCardContainer", new Object[] { "genGameUrlImg exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
      paramString = null;
    }
    if ((paramString != null) && (paramString.getStatus() == 2))
    {
      SSOLog.a("BaseCardContainer", new Object[] { "-->-->genGameUrlImg: failed" });
      paramString.restartDownload();
    }
    if ((paramString == null) || (paramString.getStatus() != 1))
    {
      URLImageView localURLImageView = this.h;
      if (localURLImageView != null)
      {
        localURLImageView.setURLDrawableDownListener(this.j);
        this.i.post(new BaseCardContainer.3(this, paramString));
      }
    }
    return paramString;
  }
  
  private Drawable getEmptyDrawable()
  {
    try
    {
      Drawable localDrawable = QQLiteStatusUtil.a(this.b);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SSOLog.c("BaseCardContainer", "-->create empty drawable oom.", localOutOfMemoryError);
    }
    return null;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int n = paramString.length();
    if (n >= 8)
    {
      localObject = paramString.substring(n - 8);
    }
    else
    {
      localObject = new StringBuilder();
      m = 0;
      while (m < 8 - n)
      {
        ((StringBuilder)localObject).append("0");
        m += 1;
      }
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
    n = 0;
    int m = 2;
    while (n < 8)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(((String)localObject).substring(n, m));
      n += 2;
      m += 2;
    }
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("android");
    localStringBuilder.append("_");
    localStringBuilder.append("ad");
    localStringBuilder.append("_");
    localStringBuilder.append("0.jpg");
    localStringBuilder.replace(0, 4, "gamead");
    paramString = localStringBuilder.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> result: ");
    ((StringBuilder)localObject).append(paramString);
    SSOLog.a("BaseCardContainer", new Object[] { ((StringBuilder)localObject).toString() });
    return localStringBuilder.toString();
  }
  
  protected abstract void a();
  
  protected void a(ImageView paramImageView, int paramInt1, int paramInt2, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("performAnim height =");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", topMargin =");
    ((StringBuilder)localObject).append(paramInt2);
    SSOLog.b("BaseCardContainer", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt2 });
    ((ValueAnimator)localObject).addUpdateListener(new BaseCardContainer.4(this, paramImageView));
    ((ValueAnimator)localObject).addListener(new BaseCardContainer.5(this, paramImageView));
    if (paramAnimatorUpdateListener != null) {
      localValueAnimator.addUpdateListener(paramAnimatorUpdateListener);
    }
    ((ValueAnimator)localObject).setDuration(300L);
    localValueAnimator.setDuration(300L);
    paramImageView = new AnimatorSet();
    paramImageView.playTogether(new Animator[] { localObject, localValueAnimator });
    paramImageView.setDuration(300L);
    paramImageView.start();
  }
  
  protected void a(URLImageView paramURLImageView, String paramString)
  {
    URLImageView localURLImageView = paramURLImageView;
    if (paramURLImageView == null) {
      localURLImageView = this.h;
    }
    paramURLImageView = getEmptyDrawable();
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramURLImageView;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramURLImageView;
    paramURLImageView = null;
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      paramURLImageView = (URLImageView)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SSOLog.b("BaseCardContainer", new Object[] { "setAdImageByURL exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
    }
    if ((paramURLImageView != null) && (paramURLImageView.getStatus() == 2)) {
      paramURLImageView.restartDownload();
    }
    if ((paramURLImageView != null) && (paramURLImageView.getStatus() == 1))
    {
      a();
      SSOLog.a("BaseCardContainer", new Object[] { "getStatus SUCCESSED: " });
      localURLImageView.setVisibility(0);
    }
    else
    {
      SSOLog.a("BaseCardContainer", new Object[] { "getStatus OTHERS: " });
      localURLImageView.setURLDrawableDownListener(this.j);
    }
    if (paramURLImageView != null) {
      localURLImageView.setImageDrawable(paramURLImageView);
    }
  }
  
  protected void b(String paramString)
  {
    ThreadManager.executeOnSubThread(new BaseCardContainer.6(this, paramString));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((LinearLayout)super.findViewById(2131447569));
    this.g = ((ImageView)super.findViewById(2131447570));
    this.h = ((URLImageView)super.findViewById(2131433977));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer
 * JD-Core Version:    0.7.0.1
 */