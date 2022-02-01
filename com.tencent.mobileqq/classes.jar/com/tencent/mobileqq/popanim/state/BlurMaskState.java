package com.tencent.mobileqq.popanim.state;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class BlurMaskState
  extends BaseState
{
  private static int jdField_a_of_type_Int = 100;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379026);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView = (URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372948);
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = (DiniFlyAnimationView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377848);
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = (QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363683);
  private boolean jdField_a_of_type_Boolean;
  private int b = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
  
  public BlurMaskState(ViewGroup paramViewGroup, StateContext paramStateContext)
  {
    super(paramViewGroup, paramStateContext);
  }
  
  public void a(BaseState paramBaseState)
  {
    QLog.d("BlurMaskState", 1, new Object[] { "mHasEverUpperAIO: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_Boolean) });
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_Boolean = false;
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramBaseState = this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.getBigDrawable(this.jdField_a_of_type_AndroidContentContext, f);
    if (paramBaseState == null) {
      return;
    }
    paramBaseState.setCallback(this.jdField_a_of_type_ComTencentImageURLImageView);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseState);
    int i = PopOutEmoticonUtil.a(this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_AndroidWidgetEditText, this.b);
    PopOutAnimViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_AndroidViewViewGroup, i);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = i;
    PopOutAnimViewHelper.a(0, new View[] { this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, this.jdField_a_of_type_AndroidWidgetLinearLayout });
    if (this.jdField_a_of_type_AndroidViewViewGroup.getParent() == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    paramBaseState = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.d = (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(paramBaseState) ^ true);
    if (this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.d) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(paramBaseState, "StickerBubble", true);
    }
    PopOutAnimViewHelper.a("0X800BBA0", this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewQQEmoticonPanelLinearLayoutHelper.hidePopupWindow();
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewQQEmoticonPanelLinearLayoutHelper.showStickerMaskOnPanel();
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.leftMargin = ((int)paramMotionEvent.getRawX() - this.jdField_a_of_type_ComTencentImageURLImageView.getWidth() / 2);
    localLayoutParams.topMargin = ((int)paramMotionEvent.getRawY() - this.b - this.jdField_a_of_type_ComTencentImageURLImageView.getHeight() - jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentImageURLImageView.requestLayout();
    return true;
  }
  
  public void b(BaseState paramBaseState)
  {
    this.jdField_a_of_type_Boolean = false;
    PopOutAnimViewHelper.a(4, new View[] { this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, this.jdField_a_of_type_AndroidWidgetLinearLayout });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.BlurMaskState
 * JD-Core Version:    0.7.0.1
 */