package com.tencent.mobileqq.tianshu.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.tianshu.api.IRedTouchTempApi;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.BaseActivity;
import mqq.os.MqqHandler;

public class RedTouchTempApiImpl
  implements IRedTouchTempApi
{
  public static final String LEBA_APNG_DIR = "leba/apng/";
  public static final String PATH_SPLIT = "/";
  private static final String TAG = "RedTouchTempApiImpl";
  
  private void startTextAnim(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, AtomicBoolean paramAtomicBoolean)
  {
    if ((paramTextView1 == null) || (paramTextView2 == null))
    {
      QLog.e("RedTouchTempApiImpl", 1, "startTextAnim, but text view is null");
      return;
    }
    Context localContext = paramTextView2.getContext();
    Animation localAnimation1 = AnimationUtils.loadAnimation(localContext, 2130772088);
    Animation localAnimation2 = AnimationUtils.loadAnimation(localContext, 2130772089);
    if (paramAtomicBoolean.get())
    {
      paramAtomicBoolean = AnimationUtils.loadAnimation(localContext, 2130772088);
      paramTextView2.setVisibility(0);
      paramTextView3.setVisibility(0);
      paramTextView1.startAnimation(localAnimation2);
      paramTextView2.startAnimation(localAnimation1);
      paramTextView3.startAnimation(paramAtomicBoolean);
      return;
    }
    paramAtomicBoolean = AnimationUtils.loadAnimation(localContext, 2130772089);
    paramTextView1.setVisibility(0);
    paramTextView1.startAnimation(localAnimation1);
    paramTextView2.startAnimation(localAnimation2);
    paramTextView3.startAnimation(paramAtomicBoolean);
  }
  
  public URLDrawable getApngDrawable(Context paramContext, String paramString)
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130845632);
    if (paramContext == null)
    {
      QLog.e("RedTouchTempApiImpl", 1, "apngUrl is empty");
      return URLDrawable.getDrawable("", localDrawable, localDrawable);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RedTouchTempApiImpl", 1, "apngUrl is empty");
      return URLDrawable.getDrawable("", localDrawable, localDrawable);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_use_cache", false);
    Object localObject = paramString.split("/");
    localObject = localObject[(localObject.length - 1)];
    paramContext = new File(paramContext.getFilesDir() + "leba/apng/", (String)localObject);
    File localFile = paramContext.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return VasApngUtil.getApngDrawable(paramContext.getAbsolutePath(), paramString, localDrawable, new int[] { 39 }, (String)localObject, localBundle);
  }
  
  public Bitmap getDefaultFaceBitmap()
  {
    return ImageUtil.a(true);
  }
  
  public Drawable getFaceDrawable(Context paramContext, String paramString)
  {
    if ((paramContext instanceof BaseActivity)) {}
    for (paramContext = (QQAppInterface)((BaseActivity)paramContext).waitAppRuntime();; paramContext = null)
    {
      if (paramContext != null)
      {
        paramContext = FaceDrawable.getFaceDrawable(paramContext, 1, 4, paramString);
        if (paramContext != null) {
          return paramContext;
        }
      }
      return null;
    }
  }
  
  public void onProcessAddRedPoint(View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131380895);
    if (paramView != null) {
      paramView.setVisibility(0);
    }
  }
  
  public void removeLebaIconAnim(ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    if ((paramImageView2 == null) || (paramImageView1 == null) || (paramTextView2 == null) || (paramTextView1 == null))
    {
      QLog.e("RedTouchTempApiImpl", 1, "removeLebaIconAnim, but leba view is null");
      return;
    }
    Runnable localRunnable = (Runnable)paramImageView1.getTag();
    if (localRunnable == null)
    {
      QLog.e("RedTouchTempApiImpl", 1, "removeLebaIconAnim, but no anim is start");
      return;
    }
    ThreadManager.getUIHandler().removeCallbacks(localRunnable);
    paramImageView2.clearAnimation();
    paramImageView1.clearAnimation();
    paramImageView1.setTag(null);
    paramImageView1.setVisibility(8);
    paramImageView2.setVisibility(0);
    paramTextView2.setVisibility(8);
    paramTextView3.setVisibility(8);
    paramTextView1.setVisibility(0);
    ApngImage.pauseByTag(39);
  }
  
  public void startLebaIconAnim(ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if ((paramImageView2 == null) || (paramImageView1 == null))
    {
      QLog.e("RedTouchTempApiImpl", 1, "startLebaIconAnim but image view is null");
      return;
    }
    if (paramImageView1.getTag() != null)
    {
      QLog.e("RedTouchTempApiImpl", 1, "icon anim is started");
      return;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    Context localContext = paramImageView2.getContext();
    Animation localAnimation1 = AnimationUtils.loadAnimation(localContext, 2130772088);
    Animation localAnimation2 = AnimationUtils.loadAnimation(localContext, 2130772089);
    Animation localAnimation3 = AnimationUtils.loadAnimation(localContext, 2130772090);
    Animation localAnimation4 = AnimationUtils.loadAnimation(localContext, 2130772091);
    paramTextView4 = new RedTouchTempApiImpl.1(this, localAnimation1, paramImageView1, localContext, paramString, paramTextView2, paramBoolean, paramTextView3, localAnimation2, paramImageView2, paramTextView4, paramTextView1);
    localAnimation1.setAnimationListener(paramTextView4);
    localAnimation2.setAnimationListener(paramTextView4);
    paramTextView4 = ThreadManager.getUIHandler();
    if (localAtomicBoolean.get()) {}
    for (long l = paramLong1;; l = paramLong2)
    {
      paramImageView2 = new RedTouchTempApiImpl.2(this, localAtomicBoolean, paramImageView1, paramImageView2, localAnimation2, localAnimation3, localAnimation1, localAnimation4, paramBoolean, paramTextView1, paramTextView2, paramTextView3, paramLong2, paramLong1, paramTextView4);
      paramTextView4.postDelayed(paramImageView2, l);
      paramImageView1.setTag(paramImageView2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchTempApiImpl
 * JD-Core Version:    0.7.0.1
 */