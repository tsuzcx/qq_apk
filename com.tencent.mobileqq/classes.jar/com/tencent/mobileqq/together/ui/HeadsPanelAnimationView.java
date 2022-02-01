package com.tencent.mobileqq.together.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.List;

public class HeadsPanelAnimationView
{
  RelativeLayout a;
  List<ImageView> b;
  ImageView c;
  ImageView d;
  ImageView e;
  Handler f;
  List<String> g = new ArrayList();
  List<String> h = new ArrayList();
  ImageView i;
  volatile boolean j;
  Handler.Callback k = new HeadsPanelAnimationView.3(this);
  private int l;
  
  public HeadsPanelAnimationView()
  {
    Object localObject = BaseApplicationImpl.getContext();
    this.f = new Handler(Looper.getMainLooper(), this.k);
    this.l = AIOUtils.b(4.0F, ((Context)localObject).getResources());
    this.b = new ArrayList();
    this.a = ((RelativeLayout)View.inflate((Context)localObject, 2131627880, null));
    this.c = ((ImageView)this.a.findViewById(2131434879));
    this.d = ((ImageView)this.a.findViewById(2131434880));
    this.e = ((ImageView)this.a.findViewById(2131434881));
    int m = 0;
    while (m < this.a.getChildCount())
    {
      localObject = (ImageView)this.a.getChildAt(m);
      ((ImageView)localObject).setVisibility(8);
      this.b.add(localObject);
      m += 1;
    }
    this.a.setVisibility(8);
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (a(this.h, paramArrayList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MatchViewHolder", 0, "updateData return for same data");
        }
        return;
      }
      if (this.f.hasMessages(1)) {
        this.f.removeMessages(1);
      }
      this.g.clear();
      this.g.addAll(paramArrayList);
      this.h.clear();
      this.h.addAll(paramArrayList);
      int n = this.g.size();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateData _ infoListSize = ");
        ((StringBuilder)localObject).append(n);
        QLog.d("MatchViewHolder", 0, ((StringBuilder)localObject).toString());
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int m;
      if (n > 0) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0)
      {
        this.a.setVisibility(0);
        int i1 = this.b.size();
        m = 0;
        while (m < i1)
        {
          ImageView localImageView = (ImageView)this.b.get(m);
          if (m < n) {
            localObject = (String)paramArrayList.get(m);
          } else {
            localObject = null;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (localQQAppInterface != null)
            {
              Drawable localDrawable = ImageUtil.a(true);
              localObject = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
              localDrawable = localImageView.getDrawable();
              if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
                ((FaceDrawable)localDrawable).cancel();
              }
              localImageView.setImageDrawable((Drawable)localObject);
              localImageView.setVisibility(0);
            }
            else
            {
              localImageView.setImageDrawable(ImageUtil.a(true));
              localImageView.setVisibility(0);
            }
          }
          else {
            localImageView.setVisibility(8);
          }
          m += 1;
        }
        if (n > 3)
        {
          paramArrayList = (String)this.g.get(3);
          if (localQQAppInterface != null)
          {
            localObject = ImageUtil.a(true);
            FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramArrayList, 4, (Drawable)localObject, (Drawable)localObject);
          }
          this.f.sendEmptyMessageDelayed(1, 5000L);
        }
      }
      else
      {
        this.a.setVisibility(8);
      }
      return;
    }
    QLog.e("MatchViewHolder", 0, "updateData _ uins is null ");
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setUinList uins = ");
        localStringBuilder.append(paramArrayList);
        QLog.d("MatchViewHolder", 0, localStringBuilder.toString());
      }
      if (this.f.hasMessages(2)) {
        this.f.removeMessages(2);
      }
      paramArrayList = Message.obtain(this.f, 2, paramArrayList);
      this.f.sendMessage(paramArrayList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MatchViewHolder", 0, "setUinList uins = 0");
    }
  }
  
  boolean a(List<String> paramList1, List<String> paramList2)
  {
    int n = paramList1.size();
    int m = paramList2.size();
    boolean bool2 = true;
    boolean bool1 = true;
    if (n == m)
    {
      if (n > 0)
      {
        m = 0;
        for (;;)
        {
          bool2 = bool1;
          if (m >= n) {
            break;
          }
          String str1 = (String)paramList1.get(m);
          String str2 = (String)paramList2.get(m);
          bool2 = bool1;
          if (!TextUtils.isEmpty(str1))
          {
            bool2 = bool1;
            if (!str1.equals(str2)) {
              bool2 = false;
            }
          }
          m += 1;
          bool1 = bool2;
        }
      }
    }
    else {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      paramList1 = new StringBuilder();
      paramList1.append("checkListEqual _ result = ");
      paramList1.append(bool2);
      QLog.d("MatchViewHolder", 0, paramList1.toString());
    }
    return bool2;
  }
  
  public void b()
  {
    this.f.removeCallbacksAndMessages(null);
  }
  
  void c()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      return;
    }
    this.j = true;
    Object localObject2 = this.i;
    if (localObject2 != null)
    {
      ((ImageView)localObject2).clearAnimation();
      this.a.removeView(this.i);
    }
    localObject2 = BaseApplicationImpl.getContext();
    this.i = new ImageView((Context)localObject2);
    int m = AIOUtils.b(1.0F, ((Context)localObject2).getResources());
    this.i.setPadding(m, m, m, m);
    this.i.setBackgroundResource(2130846596);
    localObject2 = new RelativeLayout.LayoutParams(this.c.getWidth(), this.c.getHeight());
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131434879);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131434879);
    this.a.addView(this.i, (ViewGroup.LayoutParams)localObject2);
    try
    {
      localObject2 = (String)this.g.remove(this.g.size() - 1);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("startAnimation targetUin = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("MatchViewHolder", 0, ((StringBuilder)localObject3).toString());
      }
      this.g.add(0, localObject2);
      Object localObject3 = ImageUtil.a(true);
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, (String)localObject2, 4, (Drawable)localObject3, (Drawable)localObject3);
      this.i.setImageDrawable((Drawable)localObject1);
      localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject1).setDuration(500);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      ((ScaleAnimation)localObject1).setAnimationListener(new HeadsPanelAnimationView.1(this));
      this.i.startAnimation((Animation)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
    }
  }
  
  public void d()
  {
    Handler localHandler = this.f;
    if ((localHandler != null) && (localHandler.hasMessages(1))) {
      this.f.removeMessages(1);
    }
  }
  
  public void e()
  {
    Handler localHandler = this.f;
    if ((localHandler != null) && (!localHandler.hasMessages(1))) {
      this.f.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  void f()
  {
    int m = this.c.getWidth();
    int i1 = AIOUtils.b(5.0F, BaseApplicationImpl.getContext().getResources());
    Object localObject1 = this.e;
    int n = 0;
    float f1 = m - i1;
    Object localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { 0.0F, f1 });
    Object localObject3 = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 1.0F, 0.0F });
    long l1 = 300;
    ((ObjectAnimator)localObject2).setDuration(l1);
    ((ObjectAnimator)localObject3).setDuration(l1);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
    localObject3 = new HeadsPanelAnimationView.2(this, (AnimatorSet)localObject1);
    localObject2 = new ArrayList();
    m = 0;
    while (m < 2)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, f1, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(l1);
      localTranslateAnimation.setFillAfter(true);
      ((List)localObject2).add(localTranslateAnimation);
      m += 1;
    }
    ((TranslateAnimation)((List)localObject2).get(0)).setAnimationListener((Animation.AnimationListener)localObject3);
    m = n;
    while (m < 2)
    {
      localObject3 = (ImageView)this.b.get(m);
      ((ImageView)localObject3).clearAnimation();
      ((ImageView)localObject3).startAnimation((Animation)((List)localObject2).get(m));
      m += 1;
    }
    ((AnimatorSet)localObject1).start();
  }
  
  public void g()
  {
    b();
    this.f = null;
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.HeadsPanelAnimationView
 * JD-Core Version:    0.7.0.1
 */