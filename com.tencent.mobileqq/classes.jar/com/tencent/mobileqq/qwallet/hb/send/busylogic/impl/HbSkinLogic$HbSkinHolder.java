package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.SkinInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qwallet.hb.FrameAnimHelper;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class HbSkinLogic$HbSkinHolder
  implements QwAdapter.IViewHolder<HbSkinInfo>
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  
  public HbSkinLogic$HbSkinHolder(HbSkinLogic paramHbSkinLogic) {}
  
  public void a(int paramInt, View paramView, HbSkinInfo paramHbSkinInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setItemView info = ");
      ((StringBuilder)localObject).append(paramHbSkinInfo);
      QLog.d("HbSkinLogic", 2, ((StringBuilder)localObject).toString());
    }
    if (HbSkinInfo.c == paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HbSkinLogic.ItemSelectListener)((Iterator)localObject).next()).a(paramHbSkinInfo);
      }
    }
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    FrameAnimHelper.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, false);
    if ((1 != paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.is_hide_title) && ((1 == paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.is_hide_title) || (!TextUtils.isEmpty(paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.blessing)))) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.blessing);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    paramView = this.jdField_a_of_type_AndroidViewView;
    paramInt = paramHbSkinInfo.b;
    int i = 8;
    if (1 == paramInt) {
      paramInt = 8;
    } else {
      paramInt = 0;
    }
    paramView.setVisibility(paramInt);
    paramView = this.jdField_b_of_type_AndroidViewView;
    if (1 == paramHbSkinInfo.b) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    paramView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramHbSkinInfo.jdField_a_of_type_JavaLangString);
    paramView = this.jdField_c_of_type_AndroidViewView;
    if (HbSkinInfo.c == paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    paramView.setVisibility(paramInt);
    paramView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (HbSkinInfo.c == paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id) {
      paramInt = -16777216;
    } else {
      paramInt = -7829368;
    }
    paramView.setTextColor(paramInt);
    Object localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.icon == null) {
      paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(R.drawable.M);
    } else {
      paramView = new BitmapDrawable(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.icon);
    }
    ((ImageView)localObject).setBackgroundDrawable(paramView);
    paramInt = paramHbSkinInfo.b;
    paramView = null;
    if (-1 == paramInt)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(R.drawable.v);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentResResources.getDrawable(R.drawable.t));
    }
    else if (-2 == paramHbSkinInfo.b)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(R.drawable.v);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentResResources.getDrawable(R.drawable.t));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageResource(R.drawable.w);
    }
    else
    {
      if (!TextUtils.isEmpty(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.resPath))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        localObject = QWalletPicHelper.getDrawableForAIO(new File(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.resPath, "base_bg.png").toString(), HbSkinLogic.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic).getResources().getDrawable(R.drawable.t));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      }
      if (paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.animInfo == null) {}
    }
    try
    {
      new FrameAnimHelper(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, 0, false, null).a(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.animInfo);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label560:
      break label560;
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.corner != null) {
      paramView = paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.corner;
    }
    ((ImageView)localObject).setImageBitmap(paramView);
  }
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramView.getContext().getResources();
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(R.id.aQ);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(R.id.bV);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(R.id.bW);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.R));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.V));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.S));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_START);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.T));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.W));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(R.id.U));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic.HbSkinHolder
 * JD-Core Version:    0.7.0.1
 */