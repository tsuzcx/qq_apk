package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;

public class SpecifyRedPkgViewHolder
  extends VipRedPkgViewHolder
{
  public SpecifyRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("专属红包");
    return false;
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder != null)
    {
      if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.d() == null) {
        return;
      }
      int i = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.d().getVisibility();
      int j = 0;
      if (i != 0) {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.d().setVisibility(0);
      }
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(0);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.d().addView(localLinearLayout);
      Object localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 25.0F);
      int k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() <= 1) {}
      do
      {
        i = 0;
        break label282;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 3)) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() < 5));
      i = -DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F);
      break label282;
      i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      label282:
      while ((j < 5) && (j < this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size()))
      {
        long l = ((Long)this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.get(j)).longValue();
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localLinearLayout.addView((View)localObject);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 33.0F);
        localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 33.0F);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
        if (j > 0) {
          localLayoutParams.leftMargin = i;
        }
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, String.valueOf(l), (byte)4));
        ((ImageView)localObject).setBackgroundResource(R.drawable.am);
        ((ImageView)localObject).setPadding(k, k, k, k);
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.SpecifyRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */