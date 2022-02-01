package com.tencent.mobileqq.qwallet.hb.aio.impl;

import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;

class TroopUnclaimedHbList$HbListItem
  extends FrameLayout
{
  Context jdField_a_of_type_AndroidContentContext;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  QQWalletTroopHbItem jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletTroopHbItem;
  
  public TroopUnclaimedHbList$HbListItem(TroopUnclaimedHbList paramTroopUnclaimedHbList, @NonNull Context paramContext, QQWalletTroopHbItem paramQQWalletTroopHbItem)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletTroopHbItem = paramQQWalletTroopHbItem;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramTroopUnclaimedHbList = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramTroopUnclaimedHbList.width = -2;
    paramTroopUnclaimedHbList.height = -2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    if (!SimpleUIUtil.a()) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(R.drawable.aq);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    paramTroopUnclaimedHbList = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramTroopUnclaimedHbList.width = ScreenUtil.dip2px(29.0F);
    paramTroopUnclaimedHbList.height = ScreenUtil.dip2px(29.0F);
    paramTroopUnclaimedHbList.gravity = 1;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramTroopUnclaimedHbList = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramTroopUnclaimedHbList.width = ScreenUtil.dip2px(28.0F);
    paramTroopUnclaimedHbList.height = ScreenUtil.dip2px(28.0F);
    paramTroopUnclaimedHbList.gravity = 17;
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = FaceDrawable.getUserFaceDrawable(TroopUnclaimedHbList.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplTroopUnclaimedHbList), String.valueOf(paramRedPackGrapInfo.lUin), (byte)3);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletTroopHbItem;
    if (localObject != null)
    {
      ((QQWalletTroopHbItem)localObject).a(paramRedPackGrapInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletTroopHbItem.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = ScreenUtil.dip2px(11.5F);
        localLayoutParams.gravity = 16;
        ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplQQWalletTroopHbItem.a((FrameLayout)localObject, paramRedPackGrapInfo, new TroopUnclaimedHbList.HbListItem.1(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TroopUnclaimedRedPacketList", 2, "red packet item layout is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.HbListItem
 * JD-Core Version:    0.7.0.1
 */