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
  int jdField_a_of_type_Int = 1;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new HeadsPanelAnimationView.1(this);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  List<ImageView> jdField_a_of_type_JavaUtilList = new ArrayList();
  volatile boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  
  public HeadsPanelAnimationView(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = b(paramInt);
    int i = 0;
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
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561089, null));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368034));
            this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368039));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561095, null));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368034));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368035));
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561096, null));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368034));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368035));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561082, null));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368034));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368038));
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setLayerType(1, null);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localObject != null) && (((RelativeLayout)localObject).getChildCount() > 0))
    {
      paramInt = i;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          ((ImageView)localObject).setVisibility(8);
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        paramInt += 1;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    return true;
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
          i += 1;
        }
        if (j > this.jdField_a_of_type_JavaUtilList.size())
        {
          paramArrayList = this.jdField_b_of_type_JavaUtilList;
          paramArrayList = (String)paramArrayList.get(paramArrayList.size() - 1);
          if (localQQAppInterface != null) {
            Util.a(localQQAppInterface, paramArrayList);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
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
  
  private boolean b(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 4);
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
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject1 == null) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      Object localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if (localObject2 != null)
      {
        ((ImageView)localObject2).clearAnimation();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidWidgetImageView);
      }
      localObject2 = BaseApplicationImpl.getContext();
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView((Context)localObject2);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayerType(1, null);
      int i = this.jdField_a_of_type_Int;
      if ((i != 2) && (i != 3)) {
        i = AIOUtils.b(1.0F, ((Context)localObject2).getResources());
      } else {
        i = AIOUtils.b(2.0F, ((Context)localObject2).getResources());
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845157);
      localObject2 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131368034);
      ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131368034);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
      if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
        try
        {
          localObject2 = (String)this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startAnimation targetUin = ");
            localStringBuilder.append((String)localObject2);
            QLog.d("MatchViewHolder", 0, localStringBuilder.toString());
          }
          this.jdField_b_of_type_JavaUtilList.add(0, localObject2);
          localObject1 = Util.a((AppInterface)localObject1, (String)localObject2);
          ((FaceDrawable)localObject1).mutate();
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
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
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
      return;
    }
    QLog.d("MatchViewHolder", 0, "startAnimation headFirst headLast null");
  }
  
  void c()
  {
    int k = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    Object localObject1 = BaseApplicationImpl.getContext();
    int i = k - ((Context)localObject1).getResources().getDimensionPixelSize(2131298255);
    int j = this.jdField_a_of_type_Int;
    if (j == 2) {
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298263);
    }
    for (j = ((Context)localObject1).getResources().getDimensionPixelSize(2131298261);; j = ((Context)localObject1).getResources().getDimensionPixelSize(2131298264))
    {
      j = k - j;
      break label102;
      if (j != 3) {
        break;
      }
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298266);
    }
    j = i;
    label102:
    localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
    k = 0;
    Object localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { 0.0F, i });
    Object localObject3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F });
    long l = 300;
    ((ObjectAnimator)localObject2).setDuration(l);
    ((ObjectAnimator)localObject3).setDuration(l);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
    localObject3 = new HeadsPanelAnimationView.3(this, (AnimatorSet)localObject1);
    localObject2 = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
        localTranslateAnimation.setDuration(l);
        localTranslateAnimation.setFillAfter(true);
        ((List)localObject2).add(localTranslateAnimation);
        i += 1;
      }
      ((TranslateAnimation)((List)localObject2).get(0)).setAnimationListener((Animation.AnimationListener)localObject3);
      i = k;
      while (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        localObject3 = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
        ((ImageView)localObject3).clearAnimation();
        ((ImageView)localObject3).startAnimation((Animation)((List)localObject2).get(i));
        i += 1;
      }
    }
    ((AnimatorSet)localObject1).start();
  }
  
  public void d()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler$Callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.HeadsPanelAnimationView
 * JD-Core Version:    0.7.0.1
 */