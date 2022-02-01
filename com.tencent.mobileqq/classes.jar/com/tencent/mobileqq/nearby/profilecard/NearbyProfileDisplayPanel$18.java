package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.NowSmallVideoHandler;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class NearbyProfileDisplayPanel$18
  implements NowShortVideoProtoManager.Callback
{
  NearbyProfileDisplayPanel$18(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      localObject = new oidb_0xada.RspBody();
      try
      {
        ((oidb_0xada.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (((oidb_0xada.RspBody)localObject).busi_buf.has())
        {
          paramBundle = new ilive_new_anchor_follow_interface.FollowActionRsp();
          paramBundle.mergeFrom(((oidb_0xada.RspBody)localObject).busi_buf.get().toByteArray());
          if (paramBundle.ret.has())
          {
            paramInt = paramBundle.ret.get();
            if (paramInt != 0) {}
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        boolean bool;
        label160:
        label478:
        paramArrayOfByte = "";
        paramInt = 0;
      }
    }
    try
    {
      ((NearbyCardManager)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramArrayOfByte = this.a;
      if (NearbyProfileDisplayPanel.a(this.a)) {
        break label478;
      }
      bool = true;
      NearbyProfileDisplayPanel.a(paramArrayOfByte, bool);
      NearbyProfileDisplayPanel.a(this.a, 1, 60);
      paramArrayOfByte = "";
      paramInt = 1;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        paramArrayOfByte = "";
        paramInt = 1;
      }
      break label160;
    }
    if (paramInt != 0)
    {
      ((NearbyCardManager)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      this.a.a.a();
      paramBundle = this.a.a;
      if (NearbyProfileDisplayPanel.a(this.a)) {}
      for (paramArrayOfByte = HardCodeUtil.a(2131707386);; paramArrayOfByte = HardCodeUtil.a(2131707323))
      {
        for (;;)
        {
          QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
          if (!TextUtils.isEmpty(NearbyProfileDisplayPanel.a(this.a).uin)) {
            ((NowSmallVideoHandler)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(NearbyProfileDisplayPanel.a(this.a)), NearbyProfileDisplayPanel.a(this.a).uin });
          }
          if ((!NearbyProfileDisplayPanel.a(this.a)) && (NearbyProfileDisplayPanel.a(this.a).getChildAt(2).getVisibility() != 0))
          {
            paramArrayOfByte = (Button)NearbyProfileDisplayPanel.a(this.a).getChildAt(1).findViewById(2131380726);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167066));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845814));
          }
          if (NearbyProfileDisplayPanel.a(this.a))
          {
            paramArrayOfByte = (Button)NearbyProfileDisplayPanel.a(this.a).getChildAt(1).findViewById(2131380726);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167068));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845815));
          }
          return;
          bool = false;
          break;
          paramArrayOfByte = paramBundle.msg.get();
          try
          {
            QLog.i("NearbyProfileDisplayPanel", 1, "follow, followRsp.ret=" + paramBundle.ret.get() + ",errMsg=" + paramArrayOfByte);
            paramInt = 0;
          }
          catch (InvalidProtocolBufferMicroException paramBundle)
          {
            for (;;)
            {
              paramInt = 0;
            }
            paramArrayOfByte = "";
            paramInt = 0;
          }
        }
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, followRsp.ret not has ");
        break label663;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, rspBody.busi_buf not has ");
        break label663;
        paramBundle.printStackTrace();
        break label160;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, errorCode=" + paramInt);
        break label663;
      }
    }
    Object localObject = this.a.a;
    paramBundle = paramArrayOfByte;
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      paramBundle = HardCodeUtil.a(2131707371);
    }
    QQToast.a((Context)localObject, 1, paramBundle, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.18
 * JD-Core Version:    0.7.0.1
 */