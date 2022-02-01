package com.tencent.mobileqq.profile.like;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class PraiseAnimation
  extends AnimateUtils.AnimationAdapter
{
  int a = 0;
  int b = 0;
  public View c;
  public Drawable[] d;
  public Drawable e;
  public boolean f = false;
  public FloatViewBuilderFactory g;
  public SparseArray<Pair<Point, Integer>> h = new SparseArray();
  
  public static Animation a(Animation.AnimationListener paramAnimationListener, float paramFloat1, float paramFloat2)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(-1);
    localScaleAnimation.setDuration(750L);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setDuration(750L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new PraiseAnimation.1());
    return localAnimationSet;
  }
  
  public void a(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout, Bitmap paramBitmap, PraiseManager.OnPraiseLoadListener paramOnPraiseLoadListener, int paramInt1, boolean paramBoolean, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (SimpleUIUtil.e())
    {
      if (QLog.isColorLevel()) {
        QLog.i("PraiseManager", 2, "doZanAnim, SimpleUIMode is open now");
      }
      paramHeartLayout.a(paramBitmap, paramFloat1, paramFloat2);
      return;
    }
    PraiseManager localPraiseManager = (PraiseManager)paramQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
    if ((paramBoolean) && (localPraiseManager.c.get(Integer.valueOf(paramInt1)) == null))
    {
      localPraiseManager.a(paramOnPraiseLoadListener);
      this.h.put(paramInt1, new Pair(new Point((int)paramFloat1, (int)paramFloat2), Integer.valueOf(paramInt2)));
    }
    paramOnPraiseLoadListener = localPraiseManager.a(paramInt1, paramBoolean, "from_nearby_people");
    if (paramOnPraiseLoadListener != null)
    {
      if ((paramInt2 == 2) && (paramOnPraiseLoadListener.j != null))
      {
        if (this.g != null)
        {
          paramHeartLayout.a(paramOnPraiseLoadListener, paramOnPraiseLoadListener.j, paramQQAppInterface, this.g.a(paramInt2, paramHeartLayout.d), paramFloat1 - DisplayUtil.a(paramHeartLayout.getContext(), 20.0F), paramFloat2 - DisplayUtil.a(paramHeartLayout.getContext(), 120.0F), DisplayUtil.a(paramHeartLayout.getContext(), 75.0F), DisplayUtil.a(paramHeartLayout.getContext(), 65.0F));
          return;
        }
        paramHeartLayout.a(paramOnPraiseLoadListener, paramOnPraiseLoadListener.j, paramFloat1, paramFloat2);
        return;
      }
      paramHeartLayout.a(paramOnPraiseLoadListener, paramOnPraiseLoadListener.h, paramFloat1, paramFloat2);
      return;
    }
    if (!paramBoolean) {
      paramHeartLayout.a(paramBitmap, paramFloat1, paramFloat2);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable, Resources paramResources)
  {
    Drawable localDrawable2 = this.e;
    Drawable localDrawable1;
    if (paramBoolean2)
    {
      localDrawable1 = ImageUtil.a(localDrawable2, paramResources.getColor(2131166312));
    }
    else
    {
      localDrawable1 = localDrawable2;
      if (paramBoolean1) {
        localDrawable1 = ImageUtil.a(localDrawable2, paramResources.getColor(2131166315));
      }
    }
    paramResources = this.d;
    if (paramResources == null)
    {
      this.d = new Drawable[] { paramDrawable, localDrawable1 };
      return;
    }
    paramResources[0] = paramDrawable;
    paramResources[1] = localDrawable1;
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.a % 2 == 0)
    {
      int i = this.b;
      paramAnimation = this.d;
      this.b = ((i + 1) % paramAnimation.length);
      View localView = this.c;
      if ((localView instanceof ImageView)) {
        ((ImageView)localView).setImageDrawable(paramAnimation[this.b]);
      } else {
        localView.setBackgroundDrawable(paramAnimation[this.b]);
      }
    }
    this.a += 1;
    if (this.a / 2 >= PraiseConfigHelper.c)
    {
      this.c.clearAnimation();
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseAnimation
 * JD-Core Version:    0.7.0.1
 */