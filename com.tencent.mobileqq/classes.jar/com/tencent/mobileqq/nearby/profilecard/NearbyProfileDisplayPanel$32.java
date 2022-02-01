package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.now.NowSmallVideoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$32
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyProfileDisplayPanel$32(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bundle = [");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.i("NearbyProfileDisplayPanel", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      QQToast.makeText(this.a.e, 1, HardCodeUtil.a(2131905203), 1).show();
      return;
    }
    paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("ret_code: ");
    paramArrayOfByte.append(paramBundle.ret_code.get());
    paramArrayOfByte.append(", err_msg: ");
    paramArrayOfByte.append(paramBundle.err_msg.get().toStringUtf8());
    QLog.i("NearbyProfileDisplayPanel", 1, paramArrayOfByte.toString());
    paramInt = paramBundle.ret_code.get();
    paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
    if (paramInt != 0)
    {
      if (!TextUtils.isEmpty(paramArrayOfByte))
      {
        paramBundle = this.a.e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramArrayOfByte);
        QQToast.makeText(paramBundle, 1, localStringBuilder.toString(), 1).show();
      }
      else
      {
        QQToast.makeText(this.a.e, 1, HardCodeUtil.a(2131905117), 1).show();
      }
    }
    else
    {
      this.a.e.updateProfile();
      paramArrayOfByte = this.a;
      paramArrayOfByte.T ^= true;
      paramBundle = this.a.e;
      if (this.a.T) {
        paramArrayOfByte = HardCodeUtil.a(2131905219);
      } else {
        paramArrayOfByte = HardCodeUtil.a(2131905126);
      }
      QQToast.makeText(paramBundle, 2, paramArrayOfByte, 1).show();
      ((NowSmallVideoHandler)this.a.e.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(this.a.T), this.a.f.uin });
      this.a.c(1, 60);
    }
    if (!this.a.H()) {
      return;
    }
    if ((!this.a.T) && (this.a.h.getChildAt(2).getVisibility() != 0))
    {
      paramArrayOfByte = (Button)this.a.h.getChildAt(1).findViewById(2131448897);
      paramArrayOfByte.setTextColor(this.a.e.getResources().getColor(2131168041));
      paramArrayOfByte.setBackgroundDrawable(this.a.e.getResources().getDrawable(2130847156));
    }
    if (this.a.T)
    {
      paramArrayOfByte = (Button)this.a.h.getChildAt(1).findViewById(2131448897);
      paramArrayOfByte.setTextColor(this.a.e.getResources().getColor(2131168043));
      paramArrayOfByte.setBackgroundDrawable(this.a.e.getResources().getDrawable(2130847157));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.32
 * JD-Core Version:    0.7.0.1
 */