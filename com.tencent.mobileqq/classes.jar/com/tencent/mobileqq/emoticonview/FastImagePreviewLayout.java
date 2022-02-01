package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FastImagePreviewLayout
  extends LinearLayout
{
  public static final long SHOW_TIMEOUT = 2000L;
  static String TAG = "FastImagePreviewLayout";
  final String CACHE_IMAGE = "/tencent/zebra/cache/";
  Context context;
  float density;
  URLDrawable fastImgDrawable = null;
  MqqHandler mHandler;
  long mPicTimeInterval = 0L;
  
  public FastImagePreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.density = this.context.getResources().getDisplayMetrics().density;
  }
  
  public void queryFastImage()
  {
    ThreadManager.getSubThreadHandler().post(new FastImagePreviewLayout.2(this));
  }
  
  public void removeFastImage(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "removeFastImage called");
    }
    setVisibility(8);
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      setAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      startAnimation(localAlphaAnimation);
      localAlphaAnimation.setAnimationListener(new FastImagePreviewLayout.1(this));
      return;
    }
    removeAllViews();
  }
  
  public void setHandler(MqqHandler paramMqqHandler)
  {
    this.mHandler = paramMqqHandler;
  }
  
  public void showFastImage()
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFastImage called, path = ");
      localStringBuilder.append(PlusPanelUtils.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    removeAllViews();
    Object localObject = inflate(this.context, 2131624096, null);
    ((ImageView)((View)localObject).findViewById(2131432798)).setImageDrawable(this.fastImgDrawable);
    addView((View)localObject);
    setVisibility(0);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    setAnimation((Animation)localObject);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FastImagePreviewLayout
 * JD-Core Version:    0.7.0.1
 */