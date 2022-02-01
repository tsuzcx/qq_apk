package com.tencent.trtc;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.trtc.impl.TRTCCloudHevcUtil;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;

class TRTCSubCloud$2
  implements Runnable
{
  TRTCSubCloud$2(TRTCSubCloud paramTRTCSubCloud, String paramString1, long paramLong1, TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt1, String paramString2, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    int i = TRTCSubCloud.access$1000(this.h);
    int m = 0;
    if (i != 0)
    {
      long l2;
      if ((TextUtils.isEmpty(this.a)) || (!this.a.equalsIgnoreCase(TRTCSubCloud.access$1100(this.h).strRoomId)))
      {
        long l1 = TRTCSubCloud.access$1200(this.h).roomId;
        l2 = this.b;
        if (l1 != l2) {}
      }
      else
      {
        TRTCSubCloud.access$1300(this.h, String.format("enter the same room[%d] again, ignore!!!", new Object[] { Long.valueOf(this.b) }));
        return;
      }
      TRTCSubCloud.access$1500(this.h, String.format("enter another room[%d] when in room[%d], exit the old room!!!", new Object[] { Long.valueOf(l2), Long.valueOf(TRTCSubCloud.access$1400(this.h).roomId) }));
      TRTCSubCloud.access$1602(this.h, true);
      this.h.exitRoom();
    }
    TRTCSubCloud.access$1700(this.h, "========================================================================================================");
    TRTCSubCloud.access$1800(this.h, "========================================================================================================");
    TRTCSubCloud.access$1900(this.h, String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", new Object[] { TXCCommonUtil.getSDKVersionStr(), f.c(), f.d() }));
    TRTCSubCloud.access$2000(this.h, "========================================================================================================");
    TRTCSubCloud.access$2100(this.h, "========================================================================================================");
    TRTCSubCloud.access$2200(this.h, String.format("enterRoom roomId:%d(%s)  userId:%s sdkAppId:%d scene:%d", new Object[] { Long.valueOf(this.b), this.a, this.c.userId, Integer.valueOf(this.c.sdkAppId), Integer.valueOf(this.d) }));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enterRoom self:");
    ((StringBuilder)localObject2).append(this.h.hashCode());
    ((StringBuilder)localObject2).append(", roomId:");
    if (this.c.roomId == -1) {
      localObject1 = this.a;
    } else {
      localObject1 = Integer.valueOf(this.c.roomId);
    }
    ((StringBuilder)localObject2).append(localObject1);
    String str1 = ((StringBuilder)localObject2).toString();
    int j = this.d;
    localObject2 = "VideoCall";
    i = j;
    Object localObject1 = localObject2;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          if (j != 3)
          {
            localObject1 = TRTCSubCloud.access$2300();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("enter room scene:%u error! default to VideoCall! ");
            ((StringBuilder)localObject3).append(this.d);
            ((StringBuilder)localObject3).append(" self:");
            ((StringBuilder)localObject3).append(this.h.hashCode());
            TXCLog.w((String)localObject1, ((StringBuilder)localObject3).toString());
          }
        }
        for (localObject1 = localObject2;; localObject1 = "AudioCall")
        {
          i = 0;
          break;
          localObject1 = "VoiceChatRoom";
          i = 1;
          break;
        }
      }
      localObject1 = "Live";
      i = j;
    }
    Object localObject3 = this.e;
    if (this.f == 20) {
      localObject2 = "Anchor";
    } else {
      localObject2 = "Audience";
    }
    Monitor.a(1, str1, String.format("bussInfo:%s, appScene:%s, role:%s, streamid:%s", new Object[] { localObject3, localObject1, localObject2, this.c.streamId }), 0);
    TXCEventRecorderProxy.a("18446744073709551615", 5001, this.b, -1L, "", 0);
    TRTCSubCloud.access$2402(this.h, 1);
    if (TRTCSubCloud.access$2500(this.h) == 0L)
    {
      localObject1 = TXCCommonUtil.getSDKVersion();
      if (localObject1.length >= 1) {
        j = localObject1[0];
      } else {
        j = 0;
      }
      int k;
      if (localObject1.length >= 2) {
        k = localObject1[1];
      } else {
        k = 0;
      }
      if (localObject1.length >= 3) {
        m = localObject1[2];
      }
      localObject1 = this.h;
      TRTCSubCloud.access$2602((TRTCSubCloud)localObject1, TRTCSubCloud.access$2700((TRTCSubCloud)localObject1, j, k, m));
    }
    TRTCSubCloud.access$2800(this.h, i);
    localObject1 = this.h;
    TRTCSubCloud.access$3100((TRTCSubCloud)localObject1, TRTCSubCloud.access$2900((TRTCSubCloud)localObject1), TRTCSubCloud.access$3000(this.h));
    localObject1 = TRTCSubCloud.access$3300(this.h).getToken(TRTCSubCloud.access$3200(this.h));
    localObject2 = this.h;
    TRTCSubCloud.access$3500((TRTCSubCloud)localObject2, TRTCSubCloud.access$3400((TRTCSubCloud)localObject2), this.c.sdkAppId, this.c.userId, this.c.userSig, (byte[])localObject1);
    localObject1 = this.c.privateMapKey;
    String str2 = "";
    if (localObject1 != null) {
      localObject1 = this.c.privateMapKey;
    } else {
      localObject1 = "";
    }
    localObject2 = this.a;
    if (localObject2 == null) {
      localObject2 = "";
    }
    str1 = this.e;
    if (str1 == null) {
      str1 = "";
    }
    if (this.c.userDefineRecordId != null) {
      localObject3 = this.c.userDefineRecordId;
    } else {
      localObject3 = "";
    }
    if (this.c.streamId != null) {
      str2 = this.c.streamId;
    }
    i = TRTCCloudHevcUtil.getEnterRoomCodecSupportValue();
    TRTCSubCloud localTRTCSubCloud = this.h;
    TRTCSubCloud.access$3900(localTRTCSubCloud, TRTCSubCloud.access$3600(localTRTCSubCloud), this.b, str1, (String)localObject1, (String)localObject2, this.f, 255, 0, this.d, TRTCSubCloud.access$3700(this.h), f.c(), f.d(), TRTCSubCloud.access$3800(this.h), (String)localObject3, str2, i);
    TRTCSubCloud.access$4002(this.h, this.f);
    TRTCSubCloud.access$4102(this.h, this.f);
    TRTCSubCloud.access$4200(this.h);
    TRTCSubCloud.access$4302(this.h, 0L);
    TRTCSubCloud.access$4400(this.h).init(this.b, this.c.userId);
    TRTCSubCloud.access$4500(this.h).strRoomId = ((String)localObject2);
    TRTCSubCloud.access$4600(this.h).sdkAppId = this.c.sdkAppId;
    TRTCSubCloud.access$4700(this.h).userSig = this.c.userSig;
    TRTCSubCloud.access$4800(this.h).privateMapKey = ((String)localObject1);
    TRTCSubCloud.access$4900(this.h).enterTime = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.2
 * JD-Core Version:    0.7.0.1
 */