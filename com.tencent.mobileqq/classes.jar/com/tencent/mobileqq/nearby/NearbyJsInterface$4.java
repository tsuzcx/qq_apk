package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.RspBody;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.SelfCardInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class NearbyJsInterface$4
  implements BusinessObserver
{
  NearbyJsInterface$4(NearbyJsInterface paramNearbyJsInterface, String paramString, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new oidb_sso.OIDBSSOPkg();
      }
    }
    for (;;)
    {
      int j;
      try
      {
        paramBundle = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramBundle);
        if ((paramBundle.uint32_result.has()) && (paramBundle.uint32_result.get() == 0) && (paramBundle.bytes_bodybuffer.has()) && (paramBundle.bytes_bodybuffer.get() != null))
        {
          localObject = new oidb_0x8c1.RspBody();
          ((oidb_0x8c1.RspBody)localObject).mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
          paramBundle = (oidb_0x8c1.SelfCardInfo)((oidb_0x8c1.RspBody)localObject).msg_card_info.get();
          j = 1001;
          paramInt = j;
          if (paramBundle.int32_friend_flag.has())
          {
            paramInt = paramBundle.int32_friend_flag.get();
            i = 1;
            if (paramInt != 1) {
              break label253;
            }
            break label256;
          }
          this.c.d.a(paramBundle.bytes_xml_msg.get().toByteArray(), String.valueOf(paramBundle.uint64_uin.get()), 2, paramInt);
          paramBundle = new NearbyJsInterface.MatchUserInfo(String.valueOf(paramBundle.uint64_uin.get()), paramBundle.int32_direction_flag.get());
          this.c.c.put(String.valueOf(this.a), paramBundle);
          if (this.b)
          {
            NearbyJsInterface.a(this.c, paramBundle);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      return;
      label253:
      int i = 0;
      label256:
      paramInt = j;
      if (i != 0) {
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.4
 * JD-Core Version:    0.7.0.1
 */