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

class NearbyProfileDisplayPanel$19
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyProfileDisplayPanel$19(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayPanel", 2, "errorCode = [" + paramInt + "], bundle = [" + paramBundle + "]");
    }
    if (paramInt != 0) {
      QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707359), 1).a();
    }
    for (;;)
    {
      return;
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        QLog.i("NearbyProfileDisplayPanel", 1, "ret_code: " + paramBundle.ret_code.get() + ", err_msg: " + paramBundle.err_msg.get().toStringUtf8());
        paramInt = paramBundle.ret_code.get();
        paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
        if (paramInt != 0) {
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            QQToast.a(this.a.a, 1, "" + paramArrayOfByte, 1).a();
            if ((!NearbyProfileDisplayPanel.a(this.a)) && (NearbyProfileDisplayPanel.a(this.a).getChildAt(2).getVisibility() != 0))
            {
              paramArrayOfByte = (Button)NearbyProfileDisplayPanel.a(this.a).getChildAt(1).findViewById(2131380726);
              paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167066));
              paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845814));
            }
            if (!NearbyProfileDisplayPanel.a(this.a)) {
              continue;
            }
            paramArrayOfByte = (Button)NearbyProfileDisplayPanel.a(this.a).getChildAt(1).findViewById(2131380726);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167068));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845815));
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          continue;
          QQToast.a(this.a.a, 1, HardCodeUtil.a(2131707267), 1).a();
        }
        this.a.a.a();
        paramArrayOfByte = this.a;
        if (NearbyProfileDisplayPanel.a(this.a)) {
          break label524;
        }
      }
    }
    boolean bool = true;
    label413:
    NearbyProfileDisplayPanel.a(paramArrayOfByte, bool);
    paramBundle = this.a.a;
    if (NearbyProfileDisplayPanel.a(this.a)) {}
    for (paramArrayOfByte = HardCodeUtil.a(2131707376);; paramArrayOfByte = HardCodeUtil.a(2131707276))
    {
      QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
      ((NowSmallVideoHandler)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(NearbyProfileDisplayPanel.a(this.a)), NearbyProfileDisplayPanel.a(this.a).uin });
      NearbyProfileDisplayPanel.a(this.a, 1, 60);
      break;
      label524:
      bool = false;
      break label413;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.19
 * JD-Core Version:    0.7.0.1
 */