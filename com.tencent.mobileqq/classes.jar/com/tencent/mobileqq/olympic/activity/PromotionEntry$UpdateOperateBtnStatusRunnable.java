package com.tencent.mobileqq.olympic.activity;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionPath;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

class PromotionEntry$UpdateOperateBtnStatusRunnable
  implements Runnable
{
  public boolean a = false;
  ObjectAnimator b = null;
  LottieDrawable c = null;
  PromotionConfigInfo.PromotionItem d = null;
  OnCompositionLoadedListener e = null;
  private WeakReference<ImageView> f = new WeakReference(null);
  
  public void a()
  {
    Object localObject = (ImageView)this.f.get();
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(null);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.c = null;
    }
  }
  
  public void a(ImageView paramImageView, int paramInt)
  {
    if (this.b != null) {
      return;
    }
    Object localObject = this.d;
    if (localObject == null)
    {
      QLog.w(PromotionEntry.a, 1, "createShowOperateBtnAnim, promotionItem为空");
      return;
    }
    if (this.c == null)
    {
      localObject = PromotionPath.a((PromotionConfigInfo.PromotionItem)localObject);
      a((String)localObject);
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("entry.json");
        localObject = new FileInputStream(localStringBuilder.toString());
        LottieComposition.Factory.fromInputStream(paramImageView.getContext(), (InputStream)localObject, this.e);
        return;
      }
      catch (Exception paramImageView)
      {
        QLog.i(PromotionEntry.a, 1, "createShowOperateBtnAnim, 读取json失败", paramImageView);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.e = new PromotionEntry.UpdateOperateBtnStatusRunnable.1(this, paramString);
  }
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.f.get();
    if (localImageView == null) {
      return;
    }
    Object localObject;
    if (this.a)
    {
      if (localImageView.getVisibility() != 0)
      {
        localImageView.setVisibility(0);
        a(localImageView, 0);
        localObject = this.b;
        if (localObject != null) {
          ((ObjectAnimator)localObject).start();
        }
        localObject = this.c;
        if (localObject != null)
        {
          localImageView.setImageDrawable((Drawable)localObject);
          this.c.setRepeatCount(5);
          this.c.playAnimation();
        }
      }
    }
    else
    {
      localImageView.setVisibility(8);
      localObject = this.b;
      if (localObject != null) {
        ((ObjectAnimator)localObject).end();
      }
      localObject = this.c;
      if (localObject != null)
      {
        localImageView.setImageDrawable((Drawable)localObject);
        this.c.endAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable
 * JD-Core Version:    0.7.0.1
 */