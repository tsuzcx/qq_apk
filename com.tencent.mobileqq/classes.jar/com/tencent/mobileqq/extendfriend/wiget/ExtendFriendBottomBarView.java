package com.tencent.mobileqq.extendfriend.wiget;

import aepi;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import azqs;
import bdbk;
import bdhj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;
import mww;

public class ExtendFriendBottomBarView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private ArrayList<ImageView> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  
  public ExtendFriendBottomBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendBottomBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendBottomBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131560933, this);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = aepi.a(66.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363380));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(mww.a);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTranslationY(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363384));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setTranslationY(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367553));
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount())
    {
      localObject = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
      ((ImageView)localObject).setVisibility(8);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
    }
    ImageView localImageView = (ImageView)findViewById(2131362826);
    Object localObject = localImageView.getDrawable();
    if ((localObject instanceof SkinnableBitmapDrawable)) {}
    for (localObject = ((SkinnableBitmapDrawable)localObject).mutate2();; localObject = ((Drawable)localObject).mutate())
    {
      ((Drawable)localObject).setColorFilter(-16578534, PorterDuff.Mode.SRC_ATOP);
      localImageView.setImageDrawable((Drawable)localObject);
      return;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, "showBottomBar ");
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
    if (this.c)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E2E", "0X8009E2E", 0, 0, "", "", "", "");
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, "hideBottomBar ");
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
    if (this.c)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
  }
  
  void a(View paramView)
  {
    if (!this.c) {
      if (Build.VERSION.SDK_INT < 24) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(paramView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130850260);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.c = true;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, String.format("updateUinList uinList=%s", new Object[] { paramList }));
    }
    if (paramList != null)
    {
      int j = paramList.size();
      if (j > 0)
      {
        int k = this.jdField_a_of_type_JavaUtilArrayList.size();
        int i = 0;
        if (i < k)
        {
          ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          String str;
          if (i < j)
          {
            str = (String)paramList.get(i);
            label87:
            if (TextUtils.isEmpty(str)) {
              break label140;
            }
            Drawable localDrawable = bdhj.a(true);
            localImageView.setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str, 4, localDrawable, localDrawable));
            localImageView.setVisibility(0);
          }
          for (;;)
          {
            i += 1;
            break;
            str = null;
            break label87;
            label140:
            localImageView.setVisibility(8);
          }
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!this.jdField_a_of_type_Boolean) {
        b();
      }
    }
    do
    {
      return;
      if ((!this.jdField_a_of_type_Boolean) && (paramBoolean)) {
        c();
      }
      if ((this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
        b();
      }
    } while (this.jdField_a_of_type_Boolean == paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView
 * JD-Core Version:    0.7.0.1
 */