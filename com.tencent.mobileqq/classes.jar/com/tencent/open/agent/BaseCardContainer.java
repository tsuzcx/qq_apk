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
  protected final int a;
  protected Context a;
  private Drawable a;
  protected Handler a;
  protected ImageView a;
  protected LinearLayout a;
  protected URLDrawableDownListener.Adapter a;
  protected URLImageView a;
  protected List<Permission> a;
  protected boolean a;
  protected int b = -1;
  
  public BaseCardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new BaseCardContainer.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new BaseCardContainer.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private Drawable a()
  {
    try
    {
      Drawable localDrawable = QQLiteStatusUtil.a(this.jdField_a_of_type_Int);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SSOLog.c("BaseCardContainer", "-->create empty drawable oom.", localOutOfMemoryError);
    }
    return null;
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject = a();
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
      URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (localURLImageView != null)
      {
        localURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        this.jdField_a_of_type_AndroidOsHandler.post(new BaseCardContainer.3(this, paramString));
      }
    }
    return paramString;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = paramString.length();
    if (j >= 8)
    {
      localObject = paramString.substring(j - 8);
    }
    else
    {
      localObject = new StringBuilder();
      i = 0;
      while (i < 8 - j)
      {
        ((StringBuilder)localObject).append("0");
        i += 1;
      }
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
    j = 0;
    int i = 2;
    while (j < 8)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(((String)localObject).substring(j, i));
      j += 2;
      i += 2;
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
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    }
    paramURLImageView = a();
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
      localURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
    }
    if (paramURLImageView != null) {
      localURLImageView.setImageDrawable(paramURLImageView);
    }
  }
  
  protected void a(String paramString)
  {
    ThreadManager.executeOnSubThread(new BaseCardContainer.6(this, paramString));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131378869));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131378870));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131367471));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer
 * JD-Core Version:    0.7.0.1
 */