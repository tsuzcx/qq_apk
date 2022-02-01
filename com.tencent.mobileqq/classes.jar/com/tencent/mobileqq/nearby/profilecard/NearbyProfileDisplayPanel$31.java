package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

class NearbyProfileDisplayPanel$31
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyProfileDisplayPanel$31(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
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
      QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707384), 1).a();
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
        paramBundle = this.a.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramArrayOfByte);
        QQToast.a(paramBundle, 1, localStringBuilder.toString(), 1).a();
      }
      else
      {
        QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707292), 1).a();
      }
    }
    else
    {
      this.a.a.updateProfile();
      paramArrayOfByte = this.a;
      NearbyProfileDisplayPanel.a(paramArrayOfByte, NearbyProfileDisplayPanel.b(paramArrayOfByte) ^ true);
      paramBundle = this.a.a;
      if (NearbyProfileDisplayPanel.b(this.a)) {
        paramArrayOfByte = HardCodeUtil.a(2131707401);
      } else {
        paramArrayOfByte = HardCodeUtil.a(2131707301);
      }
      QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
      ((NowSmallVideoHandler)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(NearbyProfileDisplayPanel.b(this.a)), NearbyProfileDisplayPanel.a(this.a).uin });
      NearbyProfileDisplayPanel.a(this.a, 1, 60);
    }
    if ((!NearbyProfileDisplayPanel.b(this.a)) && (NearbyProfileDisplayPanel.a(this.a).getChildAt(2).getVisibility() != 0))
    {
      paramArrayOfByte = (Button)NearbyProfileDisplayPanel.a(this.a).getChildAt(1).findViewById(2131379994);
      paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167089));
      paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845687));
    }
    if (NearbyProfileDisplayPanel.b(this.a))
    {
      paramArrayOfByte = (Button)NearbyProfileDisplayPanel.a(this.a).getChildAt(1).findViewById(2131379994);
      paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167091));
      paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845688));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.31
 * JD-Core Version:    0.7.0.1
 */