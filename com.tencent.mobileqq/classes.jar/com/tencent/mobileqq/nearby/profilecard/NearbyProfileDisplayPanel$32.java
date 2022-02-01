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
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.NowSmallVideoHandler;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
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

class NearbyProfileDisplayPanel$32
  implements INowShortVideoProtoManager.Callback
{
  NearbyProfileDisplayPanel$32(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Integer localInteger = Integer.valueOf(1);
    paramBundle = "";
    Object localObject2;
    Object localObject1;
    if (paramInt == 0)
    {
      localObject2 = new oidb_0xada.RspBody();
      localObject1 = paramBundle;
    }
    for (;;)
    {
      try
      {
        ((oidb_0xada.RspBody)localObject2).mergeFrom(paramArrayOfByte);
        localObject1 = paramBundle;
        if (((oidb_0xada.RspBody)localObject2).busi_buf.has())
        {
          localObject1 = paramBundle;
          paramArrayOfByte = new ilive_new_anchor_follow_interface.FollowActionRsp();
          localObject1 = paramBundle;
          paramArrayOfByte.mergeFrom(((oidb_0xada.RspBody)localObject2).busi_buf.get().toByteArray());
          localObject1 = paramBundle;
          if (paramArrayOfByte.ret.has())
          {
            localObject1 = paramBundle;
            paramInt = paramArrayOfByte.ret.get();
            if (paramInt == 0)
            {
              try
              {
                ((INearbyCardManager)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.a.a.app.getCurrentAccountUin(), localInteger);
                paramArrayOfByte = this.a;
                if (NearbyProfileDisplayPanel.b(this.a)) {
                  break label725;
                }
                bool = true;
                NearbyProfileDisplayPanel.a(paramArrayOfByte, bool);
                NearbyProfileDisplayPanel.a(this.a, 1, 60);
                paramInt = 1;
              }
              catch (InvalidProtocolBufferMicroException paramArrayOfByte)
              {
                paramInt = 1;
                continue;
              }
            }
            else
            {
              localObject1 = paramBundle;
              paramBundle = paramArrayOfByte.msg.get();
              localObject1 = paramBundle;
              localObject2 = new StringBuilder();
              localObject1 = paramBundle;
              ((StringBuilder)localObject2).append("follow, followRsp.ret=");
              localObject1 = paramBundle;
              ((StringBuilder)localObject2).append(paramArrayOfByte.ret.get());
              localObject1 = paramBundle;
              ((StringBuilder)localObject2).append(",errMsg=");
              localObject1 = paramBundle;
              ((StringBuilder)localObject2).append(paramBundle);
              localObject1 = paramBundle;
              QLog.i("NearbyProfileDisplayPanel", 1, ((StringBuilder)localObject2).toString());
              break label356;
            }
          }
          else
          {
            localObject1 = paramBundle;
            QLog.i("NearbyProfileDisplayPanel", 1, "follow, followRsp.ret not has ");
            break label356;
          }
        }
        else
        {
          localObject1 = paramBundle;
          QLog.i("NearbyProfileDisplayPanel", 1, "follow, rspBody.busi_buf not has ");
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramInt = 0;
        paramBundle = (Bundle)localObject1;
        paramArrayOfByte.printStackTrace();
        break label358;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("follow, errorCode=");
      paramArrayOfByte.append(paramInt);
      QLog.i("NearbyProfileDisplayPanel", 1, paramArrayOfByte.toString());
      label356:
      paramInt = 0;
      label358:
      if (paramInt != 0)
      {
        ((INearbyCardManager)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.a.a.app.getCurrentAccountUin(), localInteger);
        this.a.a.updateProfile();
        paramBundle = this.a.a;
        if (NearbyProfileDisplayPanel.b(this.a)) {
          paramArrayOfByte = HardCodeUtil.a(2131707411);
        } else {
          paramArrayOfByte = HardCodeUtil.a(2131707348);
        }
        QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
        if (!TextUtils.isEmpty(NearbyProfileDisplayPanel.a(this.a).uin)) {
          ((NowSmallVideoHandler)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(NearbyProfileDisplayPanel.b(this.a)), NearbyProfileDisplayPanel.a(this.a).uin });
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
      else
      {
        localObject1 = this.a.a;
        paramArrayOfByte = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          paramArrayOfByte = HardCodeUtil.a(2131707396);
        }
        QQToast.a((Context)localObject1, 1, paramArrayOfByte, 1).a();
      }
      return;
      label725:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.32
 * JD-Core Version:    0.7.0.1
 */