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
  private int jdField_a_of_type_Int;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new HeadsPanelAnimationView.3(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  List<ImageView> jdField_a_of_type_JavaUtilList;
  volatile boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  ImageView d;
  
  public HeadsPanelAnimationView()
  {
    Object localObject = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Int = AIOUtils.b(4.0F, ((Context)localObject).getResources());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561519, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368034));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368035));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368036));
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
    {
      localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
      ((ImageView)localObject).setVisibility(8);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (a(this.jdField_c_of_type_JavaUtilList, paramArrayList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MatchViewHolder", 0, "updateData return for same data");
        }
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramArrayList);
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.addAll(paramArrayList);
      int j = this.jdField_b_of_type_JavaUtilList.size();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateData _ infoListSize = ");
        ((StringBuilder)localObject).append(j);
        QLog.d("MatchViewHolder", 0, ((StringBuilder)localObject).toString());
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i;
      if (j > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        int k = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        while (i < k)
        {
          ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
          if (i < j) {
            localObject = (String)paramArrayList.get(i);
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
          i += 1;
        }
        if (j > 3)
        {
          paramArrayList = (String)this.jdField_b_of_type_JavaUtilList.get(3);
          if (localQQAppInterface != null)
          {
            localObject = ImageUtil.a(true);
            FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramArrayList, 4, (Drawable)localObject, (Drawable)localObject);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      return;
    }
    QLog.e("MatchViewHolder", 0, "updateData _ uins is null ");
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
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
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
      paramArrayList = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramArrayList);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MatchViewHolder", 0, "setUinList uins = 0");
    }
  }
  
  boolean a(List<String> paramList1, List<String> paramList2)
  {
    int j = paramList1.size();
    int i = paramList2.size();
    boolean bool2 = true;
    boolean bool1 = true;
    if (j == i)
    {
      if (j > 0)
      {
        i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          String str1 = (String)paramList1.get(i);
          String str2 = (String)paramList2.get(i);
          bool2 = bool1;
          if (!TextUtils.isEmpty(str1))
          {
            bool2 = bool1;
            if (!str1.equals(str2)) {
              bool2 = false;
            }
          }
          i += 1;
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
  
  void b()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject2 = this.d;
    if (localObject2 != null)
    {
      ((ImageView)localObject2).clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.d);
    }
    localObject2 = BaseApplicationImpl.getContext();
    this.d = new ImageView((Context)localObject2);
    int i = AIOUtils.b(1.0F, ((Context)localObject2).getResources());
    this.d.setPadding(i, i, i, i);
    this.d.setBackgroundResource(2130845156);
    localObject2 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131368034);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131368034);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.d, (ViewGroup.LayoutParams)localObject2);
    try
    {
      localObject2 = (String)this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("startAnimation targetUin = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("MatchViewHolder", 0, ((StringBuilder)localObject3).toString());
      }
      this.jdField_b_of_type_JavaUtilList.add(0, localObject2);
      Object localObject3 = ImageUtil.a(true);
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, (String)localObject2, 4, (Drawable)localObject3, (Drawable)localObject3);
      this.d.setImageDrawable((Drawable)localObject1);
      localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject1).setDuration(500);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      ((ScaleAnimation)localObject1).setAnimationListener(new HeadsPanelAnimationView.1(this));
      this.d.startAnimation((Animation)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
    }
  }
  
  public void c()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if ((localHandler != null) && (localHandler.hasMessages(1))) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
  }
  
  public void d()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if ((localHandler != null) && (!localHandler.hasMessages(1))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  void e()
  {
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    int k = AIOUtils.b(5.0F, BaseApplicationImpl.getContext().getResources());
    Object localObject1 = this.jdField_c_of_type_AndroidWidgetImageView;
    int j = 0;
    float f = i - k;
    Object localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { 0.0F, f });
    Object localObject3 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F });
    long l = 300;
    ((ObjectAnimator)localObject2).setDuration(l);
    ((ObjectAnimator)localObject3).setDuration(l);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
    localObject3 = new HeadsPanelAnimationView.2(this, (AnimatorSet)localObject1);
    localObject2 = new ArrayList();
    i = 0;
    while (i < 2)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, f, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(l);
      localTranslateAnimation.setFillAfter(true);
      ((List)localObject2).add(localTranslateAnimation);
      i += 1;
    }
    ((TranslateAnimation)((List)localObject2).get(0)).setAnimationListener((Animation.AnimationListener)localObject3);
    i = j;
    while (i < 2)
    {
      localObject3 = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
      ((ImageView)localObject3).clearAnimation();
      ((ImageView)localObject3).startAnimation((Animation)((List)localObject2).get(i));
      i += 1;
    }
    ((AnimatorSet)localObject1).start();
  }
  
  public void f()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidOsHandler$Callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.HeadsPanelAnimationView
 * JD-Core Version:    0.7.0.1
 */