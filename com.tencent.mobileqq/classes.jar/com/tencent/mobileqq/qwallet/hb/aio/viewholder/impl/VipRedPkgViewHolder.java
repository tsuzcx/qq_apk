package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import android.widget.TextView;
import com.qwallet.temp.IIndividualRedPacket;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VipRedPkgViewHolder
  extends BaseViewHolder
{
  IIndividualRedPacket a;
  
  public VipRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComQwalletTempIIndividualRedPacket = ((IIndividualRedPacket)paramBaseQQAppInterface.getRuntimeService(IIndividualRedPacket.class));
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("会员红包");
    return false;
  }
  
  public void f()
  {
    super.f();
    if (this.h > 0) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComQwalletTempIIndividualRedPacket;
    boolean bool;
    if (localObject1 != null) {
      bool = ((IIndividualRedPacket)localObject1).isAllowShowRedpacket();
    } else {
      bool = false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
    if (bool) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006133", "0X8006133", 0, 0, (String)localObject1, "0", "", "");
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    if (bool)
    {
      if (((QQWalletRedPacketMsg)localObject2).envelopeid == 0) {
        return;
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend();
      localObject1 = new RedPacketInfo();
      ((RedPacketInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
      ((RedPacketInfo)localObject1).jdField_a_of_type_Boolean = bool;
      ((RedPacketInfo)localObject1).type = 2;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((QQWalletRedPacketMsg)localObject2).envelopeid);
      ((StringBuilder)localObject3).append("");
      ((RedPacketInfo)localObject1).templateId = ((StringBuilder)localObject3).toString();
      ((RedPacketInfo)localObject1).jdField_a_of_type_JavaLangString = ((QQWalletRedPacketMsg)localObject2).envelopeName;
      ((RedPacketInfo)localObject1).jdField_a_of_type_Int = ((QQWalletRedPacketMsg)localObject2).conftype;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("info =");
        ((StringBuilder)localObject2).append(((RedPacketInfo)localObject1).type);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(((RedPacketInfo)localObject1).templateId);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(((RedPacketInfo)localObject1).jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        QLog.d("VipRedPkgViewHolder", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (RedPacketInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getHBCustomizeBackground redPacketInfo=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("VipRedPkgViewHolder", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null)
      {
        if (((RedPacketInfo)localObject1).a())
        {
          this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
          localObject2 = new AnimationDrawable();
          localObject3 = ((RedPacketInfo)localObject1).jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            Drawable localDrawable = localObject3[i];
            if (localDrawable != null) {
              ((AnimationDrawable)localObject2).addFrame(localDrawable, ((RedPacketInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig.b);
            }
            i += 1;
          }
          if (Build.VERSION.SDK_INT < 16) {
            this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setBackgroundDrawable((Drawable)localObject2);
          } else {
            this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setBackground((Drawable)localObject2);
          }
          ((AnimationDrawable)localObject2).setOneShot(false);
          ((AnimationDrawable)localObject2).start();
          return;
        }
        if (((RedPacketInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
          localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), ((RedPacketInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap);
          if (Build.VERSION.SDK_INT < 16)
          {
            this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setBackgroundDrawable((Drawable)localObject1);
            return;
          }
          this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setBackground((Drawable)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.VipRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */