package com.tencent.trtc;

import android.os.Bundle;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class WXTRTCCloud$10
  implements Runnable
{
  WXTRTCCloud$10(WXTRTCCloud paramWXTRTCCloud, TRTCStatistics paramTRTCStatistics) {}
  
  public void run()
  {
    Object localObject6 = this;
    String str4 = String.format("%d%%|%d%%", new Object[] { Integer.valueOf(((10)localObject6).a.appCpu), Integer.valueOf(((10)localObject6).a.systemCpu) });
    Object localObject1 = TXCStatus.b("18446744073709551615", 10001);
    Object localObject2 = ((10)localObject6).a.localArray.iterator();
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TRTCStatistics.TRTCLocalStatistics)((Iterator)localObject2).next();
      if (((TRTCStatistics.TRTCLocalStatistics)localObject3).streamType == 0)
      {
        j = ((TRTCStatistics.TRTCLocalStatistics)localObject3).width;
        k = ((TRTCStatistics.TRTCLocalStatistics)localObject3).height;
        m = ((TRTCStatistics.TRTCLocalStatistics)localObject3).frameRate;
        n = ((TRTCStatistics.TRTCLocalStatistics)localObject3).videoBitrate;
        i1 = ((TRTCStatistics.TRTCLocalStatistics)localObject3).audioBitrate;
        i2 = WXTRTCCloud.access$4400(((10)localObject6).b, ((10)localObject6).a.rtt, ((10)localObject6).a.upLoss);
        if (WXTRTCCloud.access$4500(((10)localObject6).b) == 1)
        {
          i = TXCStatus.c("18446744073709551615", 4006);
          if (m > 0)
          {
            double d = i * 10 / m / 10.0F;
            Double.isNaN(d);
            i = (int)(d + 0.5D);
          }
        }
        else
        {
          i = 0;
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("CPU_USAGE", str4);
        ((Bundle)localObject3).putInt("VIDEO_WIDTH", j);
        ((Bundle)localObject3).putInt("VIDEO_HEIGHT", k);
        ((Bundle)localObject3).putInt("VIDEO_FPS", m);
        ((Bundle)localObject3).putInt("VIDEO_GOP", i);
        ((Bundle)localObject3).putInt("NET_SPEED", i1 + n);
        ((Bundle)localObject3).putInt("VIDEO_BITRATE", n);
        ((Bundle)localObject3).putInt("AUDIO_BITRATE", i1);
        ((Bundle)localObject3).putString("AUDIO_PLAY_INFO", "");
        ((Bundle)localObject3).putString("SERVER_IP", (String)localObject1);
        ((Bundle)localObject3).putInt("NET_QUALITY_LEVEL", i2);
        if (WXTRTCCloud.access$4200(((10)localObject6).b) != null)
        {
          localObject4 = (ITXLivePushListener)WXTRTCCloud.access$4200(((10)localObject6).b).get();
          if (localObject4 != null) {
            ((ITXLivePushListener)localObject4).onNetStatus((Bundle)localObject3);
          }
        }
      }
    }
    String str3 = "AUDIO_BITRATE";
    String str1 = "NET_QUALITY_LEVEL";
    String str2 = "VIDEO_BITRATE";
    Object localObject4 = "SERVER_IP";
    localObject2 = "";
    Object localObject3 = "AUDIO_PLAY_INFO";
    Iterator localIterator = ((10)localObject6).a.remoteArray.iterator();
    Object localObject5 = localObject1;
    while (localIterator.hasNext())
    {
      Object localObject7 = (TRTCStatistics.TRTCRemoteStatistics)localIterator.next();
      i1 = ((TRTCStatistics.TRTCRemoteStatistics)localObject7).streamType;
      localObject1 = ((TRTCStatistics.TRTCRemoteStatistics)localObject7).userId;
      i2 = ((TRTCStatistics.TRTCRemoteStatistics)localObject7).width;
      int i3 = ((TRTCStatistics.TRTCRemoteStatistics)localObject7).height;
      int i4 = ((TRTCStatistics.TRTCRemoteStatistics)localObject7).frameRate;
      int i5 = ((TRTCStatistics.TRTCRemoteStatistics)localObject7).videoBitrate;
      int i6 = ((TRTCStatistics.TRTCRemoteStatistics)localObject7).audioBitrate;
      int i7 = WXTRTCCloud.access$4600(((10)localObject6).b, ((10)localObject6).a.rtt, ((TRTCStatistics.TRTCRemoteStatistics)localObject7).finalLoss);
      localObject6 = WXTRTCCloud.access$4700(((10)localObject6).b).getUser((String)localObject1);
      if (localObject6 != null)
      {
        if (i1 != 0)
        {
          if (i1 == 1) {
            break label555;
          }
          if (i1 == 2) {}
        }
        else
        {
          i = 2;
          break label557;
        }
        i = 7;
        break label557;
        label555:
        i = 3;
        label557:
        k = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject6).userID, 2007);
        m = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject6).userID, 6010, i);
        j = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject6).userID, 6011, i);
        n = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject6).userID, 6012, i);
        i = j;
        j = n;
      }
      else
      {
        k = 0;
        m = 0;
        i = 0;
        j = 0;
      }
      localObject7 = new Bundle();
      ((Bundle)localObject7).putString("CPU_USAGE", str4);
      ((Bundle)localObject7).putInt("VIDEO_WIDTH", i2);
      ((Bundle)localObject7).putInt("VIDEO_HEIGHT", i3);
      ((Bundle)localObject7).putInt("VIDEO_FPS", i4);
      ((Bundle)localObject7).putInt("NET_SPEED", i6 + i5);
      ((Bundle)localObject7).putInt(str2, i5);
      ((Bundle)localObject7).putInt(str3, i6);
      ((Bundle)localObject7).putInt("AUDIO_CACHE", k);
      ((Bundle)localObject7).putInt("VIDEO_CACHE", m);
      ((Bundle)localObject7).putInt("V_SUM_CACHE_SIZE", i);
      ((Bundle)localObject7).putInt("V_DEC_CACHE_SIZE", j);
      ((Bundle)localObject7).putString((String)localObject3, (String)localObject2);
      ((Bundle)localObject7).putString((String)localObject4, localObject5);
      ((Bundle)localObject7).putInt(str1, i7);
      if (i1 == 2)
      {
        localObject6 = this;
        if (WXTRTCCloud.access$300(((10)localObject6).b).keySet().contains(localObject1))
        {
          localObject1 = (WeakReference)WXTRTCCloud.access$300(((10)localObject6).b).get(localObject1);
          break label869;
        }
      }
      else
      {
        localObject6 = this;
        if (WXTRTCCloud.access$200(((10)localObject6).b).keySet().contains(localObject1))
        {
          localObject1 = (WeakReference)WXTRTCCloud.access$200(((10)localObject6).b).get(localObject1);
          break label869;
        }
      }
      localObject1 = null;
      label869:
      if (localObject1 != null)
      {
        localObject1 = (ITXLivePlayListener)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          ((ITXLivePlayListener)localObject1).onNetStatus((Bundle)localObject7);
        }
      }
      localObject6 = this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.10
 * JD-Core Version:    0.7.0.1
 */