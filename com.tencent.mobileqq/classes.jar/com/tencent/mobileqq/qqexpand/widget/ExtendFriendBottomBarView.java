package com.tencent.mobileqq.qqexpand.widget;

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
import com.tencent.av.utils.UITools;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendBottomBarView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
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
    inflate(paramContext, 2131561066, this);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = DisplayUtil.a(getContext(), 66.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363718));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTranslationY(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363722));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setTranslationY(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368074));
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount())
    {
      localObject = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
      ((ImageView)localObject).setVisibility(8);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
    }
    ImageView localImageView = (ImageView)findViewById(2131362978);
    Object localObject = localImageView.getDrawable();
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      localObject = ((SkinnableBitmapDrawable)localObject).mutate2();
    } else {
      localObject = ((Drawable)localObject).mutate();
    }
    ((Drawable)localObject).setColorFilter(-16578534, PorterDuff.Mode.SRC_ATOP);
    localImageView.setImageDrawable((Drawable)localObject);
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
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X8009E2E", "0X8009E2E", 0, 0, "", "", "", "");
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
    if (!this.c)
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(paramView);
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      paramView.b(paramView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130851328);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.c = true;
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, View paramView)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
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
        while (i < k)
        {
          ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          String str;
          if (i < j) {
            str = (String)paramList.get(i);
          } else {
            str = null;
          }
          if (!TextUtils.isEmpty(str))
          {
            localImageView.setImageDrawable(((IColdPalaceUtils)QRoute.api(IColdPalaceUtils.class)).getFaceHeadDrawable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, str));
            localImageView.setVisibility(0);
          }
          else
          {
            localImageView.setVisibility(8);
          }
          i += 1;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
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
    else
    {
      if ((!this.jdField_a_of_type_Boolean) && (paramBoolean)) {
        c();
      }
      if ((this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
        b();
      }
      if (this.jdField_a_of_type_Boolean != paramBoolean) {
        this.jdField_a_of_type_Boolean = paramBoolean;
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendBottomBarView
 * JD-Core Version:    0.7.0.1
 */