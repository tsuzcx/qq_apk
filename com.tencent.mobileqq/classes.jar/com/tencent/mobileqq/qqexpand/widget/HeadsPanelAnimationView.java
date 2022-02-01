package com.tencent.mobileqq.qqexpand.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.List;

public class HeadsPanelAnimationView
{
  RelativeLayout a;
  List<ImageView> b = new ArrayList();
  ImageView c;
  ImageView d;
  Handler e = new Handler(Looper.getMainLooper(), this.k);
  List<String> f = new ArrayList();
  List<String> g = new ArrayList();
  int h = 1;
  ImageView i;
  volatile boolean j;
  Handler.Callback k = new HeadsPanelAnimationView.1(this);
  
  public HeadsPanelAnimationView(int paramInt)
  {
    this.h = paramInt;
    a(paramInt);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = b(paramInt);
    int m = 0;
    if (!bool) {
      return false;
    }
    Object localObject = BaseApplicationImpl.getContext();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            this.a = ((RelativeLayout)View.inflate((Context)localObject, 2131627439, null));
            this.c = ((ImageView)this.a.findViewById(2131434879));
            this.d = ((ImageView)this.a.findViewById(2131434884));
          }
        }
        else
        {
          this.a = ((RelativeLayout)View.inflate((Context)localObject, 2131627445, null));
          this.c = ((ImageView)this.a.findViewById(2131434879));
          this.d = ((ImageView)this.a.findViewById(2131434880));
        }
      }
      else
      {
        this.a = ((RelativeLayout)View.inflate((Context)localObject, 2131627446, null));
        this.c = ((ImageView)this.a.findViewById(2131434879));
        this.d = ((ImageView)this.a.findViewById(2131434880));
      }
    }
    else
    {
      this.a = ((RelativeLayout)View.inflate((Context)localObject, 2131627430, null));
      this.c = ((ImageView)this.a.findViewById(2131434879));
      this.d = ((ImageView)this.a.findViewById(2131434883));
    }
    localObject = this.d;
    if (localObject != null) {
      ((ImageView)localObject).setLayerType(1, null);
    }
    localObject = this.a;
    if ((localObject != null) && (((RelativeLayout)localObject).getChildCount() > 0))
    {
      paramInt = m;
      while (paramInt < this.a.getChildCount())
      {
        localObject = this.a.getChildAt(paramInt);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          ((ImageView)localObject).setVisibility(8);
          this.b.add(localObject);
        }
        paramInt += 1;
      }
      this.a.setVisibility(8);
    }
    return true;
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (a(this.g, paramArrayList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MatchViewHolder", 0, "updateData return for same data");
        }
        return;
      }
      if (this.e.hasMessages(1)) {
        this.e.removeMessages(1);
      }
      this.f.clear();
      this.f.addAll(paramArrayList);
      this.g.clear();
      this.g.addAll(paramArrayList);
      int n = this.f.size();
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
              localObject = Util.a(localQQAppInterface, (String)localObject);
              ((FaceDrawable)localObject).mutate();
              Drawable localDrawable = localImageView.getDrawable();
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
        if (n > this.b.size())
        {
          paramArrayList = this.f;
          paramArrayList = (String)paramArrayList.get(paramArrayList.size() - 1);
          if (localQQAppInterface != null) {
            Util.a(localQQAppInterface, paramArrayList);
          }
          this.e.sendEmptyMessageDelayed(1, 3000L);
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
  
  private boolean b(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 4);
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
      if (this.e.hasMessages(2)) {
        this.e.removeMessages(2);
      }
      paramArrayList = Message.obtain(this.e, 2, paramArrayList);
      this.e.sendMessage(paramArrayList);
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
    this.e.removeCallbacksAndMessages(null);
  }
  
  void c()
  {
    if ((this.c != null) && (this.d != null))
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
      this.i.setLayerType(1, null);
      int m = this.h;
      if ((m != 2) && (m != 3)) {
        m = AIOUtils.b(1.0F, ((Context)localObject2).getResources());
      } else {
        m = AIOUtils.b(2.0F, ((Context)localObject2).getResources());
      }
      this.i.setPadding(m, m, m, m);
      this.i.setBackgroundResource(2130846597);
      localObject2 = new RelativeLayout.LayoutParams(this.c.getWidth(), this.c.getHeight());
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131434879);
      ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131434879);
      this.a.addView(this.i, (ViewGroup.LayoutParams)localObject2);
      if (this.f.size() > 0) {
        try
        {
          localObject2 = (String)this.f.remove(this.f.size() - 1);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startAnimation targetUin = ");
            localStringBuilder.append((String)localObject2);
            QLog.d("MatchViewHolder", 0, localStringBuilder.toString());
          }
          this.f.add(0, localObject2);
          localObject1 = Util.a((AppInterface)localObject1, (String)localObject2);
          ((FaceDrawable)localObject1).mutate();
          this.i.setImageDrawable((Drawable)localObject1);
        }
        catch (Exception localException)
        {
          QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
          return;
        }
      }
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(500);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setAnimationListener(new HeadsPanelAnimationView.2(this));
      this.i.startAnimation(localScaleAnimation);
      return;
    }
    QLog.d("MatchViewHolder", 0, "startAnimation headFirst headLast null");
  }
  
  void d()
  {
    int i1 = this.c.getWidth();
    Object localObject1 = BaseApplicationImpl.getContext();
    int m = i1 - ((Context)localObject1).getResources().getDimensionPixelSize(2131298956);
    int n = this.h;
    if (n == 2) {
      m = ((Context)localObject1).getResources().getDimensionPixelSize(2131298964);
    }
    for (n = ((Context)localObject1).getResources().getDimensionPixelSize(2131298962);; n = ((Context)localObject1).getResources().getDimensionPixelSize(2131298965))
    {
      n = i1 - n;
      break label102;
      if (n != 3) {
        break;
      }
      m = ((Context)localObject1).getResources().getDimensionPixelSize(2131298967);
    }
    n = m;
    label102:
    localObject1 = this.d;
    i1 = 0;
    Object localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { 0.0F, m });
    Object localObject3 = ObjectAnimator.ofFloat(this.d, "alpha", new float[] { 1.0F, 0.0F });
    long l = 300;
    ((ObjectAnimator)localObject2).setDuration(l);
    ((ObjectAnimator)localObject3).setDuration(l);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
    localObject3 = new HeadsPanelAnimationView.3(this, (AnimatorSet)localObject1);
    localObject2 = new ArrayList();
    if (this.b.size() > 1)
    {
      m = 0;
      while (m < this.b.size() - 1)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, n, 0.0F, 0.0F);
        localTranslateAnimation.setDuration(l);
        localTranslateAnimation.setFillAfter(true);
        ((List)localObject2).add(localTranslateAnimation);
        m += 1;
      }
      ((TranslateAnimation)((List)localObject2).get(0)).setAnimationListener((Animation.AnimationListener)localObject3);
      m = i1;
      while (m < this.b.size() - 1)
      {
        localObject3 = (ImageView)this.b.get(m);
        ((ImageView)localObject3).clearAnimation();
        ((ImageView)localObject3).startAnimation((Animation)((List)localObject2).get(m));
        m += 1;
      }
    }
    ((AnimatorSet)localObject1).start();
  }
  
  public void e()
  {
    b();
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.HeadsPanelAnimationView
 * JD-Core Version:    0.7.0.1
 */