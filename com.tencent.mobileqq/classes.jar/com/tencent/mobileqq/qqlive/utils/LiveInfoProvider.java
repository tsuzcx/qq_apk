package com.tencent.mobileqq.qqlive.utils;

import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomTag;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceAddressInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceFrameInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceStreamInfo;
import com.tencent.qlive.iliveMetricsSvr.nano.DataItem;
import com.tencent.qlive.iliveMetricsSvr.nano.GetRealTimeMetricsRsp;
import com.tencent.qlive.iliveMetricsSvr.nano.IliveInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.roomAccess.nano.AVInfo;
import com.tencent.qqlive.roomAccess.nano.Address;
import com.tencent.qqlive.roomAccess.nano.DesignatedStreamInfo;
import com.tencent.qqlive.roomAccess.nano.EnterRoomReply;
import com.tencent.qqlive.roomAccess.nano.Frame;
import com.tencent.qqlive.roomAccess.nano.OpenSdkUrl;
import com.tencent.qqlive.roomAccess.nano.RichTitleElement;
import com.tencent.qqlive.roomAccess.nano.RoomInfo;
import com.tencent.qqlive.roomAccess.nano.RoomRichTitle;
import com.tencent.qqlive.roomAccess.nano.Stream;
import com.tencent.qqlive.roomAccess.nano.UserInfo;
import java.util.ArrayList;
import java.util.List;

public class LiveInfoProvider
{
  public static LiveInfo a(EnterRoomReply paramEnterRoomReply)
  {
    LiveInfo localLiveInfo = new LiveInfo();
    localLiveInfo.userFlag = paramEnterRoomReply.f;
    Object localObject = new LiveRoomInfo();
    if (paramEnterRoomReply.d != null)
    {
      ((LiveRoomInfo)localObject).roomId = paramEnterRoomReply.d.a;
      ((LiveRoomInfo)localObject).ownerId = paramEnterRoomReply.d.b;
      ((LiveRoomInfo)localObject).roomName = paramEnterRoomReply.d.d;
      ((LiveRoomInfo)localObject).roomLogo = paramEnterRoomReply.d.c;
      ((LiveRoomInfo)localObject).programId = paramEnterRoomReply.d.i;
      ((LiveRoomInfo)localObject).giftFlag = paramEnterRoomReply.d.g;
      ((LiveRoomInfo)localObject).goodsFlag = paramEnterRoomReply.d.h;
      ((LiveRoomInfo)localObject).roomType = paramEnterRoomReply.d.e;
      ((LiveRoomInfo)localObject).enterRoomSystemNotice = paramEnterRoomReply.d.j;
      if ((paramEnterRoomReply.d.f != null) && (paramEnterRoomReply.d.f.a != null))
      {
        RichTitleElement[] arrayOfRichTitleElement = paramEnterRoomReply.d.f.a;
        int j = arrayOfRichTitleElement.length;
        int i = 0;
        while (i < j)
        {
          RichTitleElement localRichTitleElement = arrayOfRichTitleElement[i];
          RoomTag localRoomTag = new RoomTag();
          localRoomTag.type = localRichTitleElement.a;
          localRoomTag.text = localRichTitleElement.b;
          localRoomTag.url = localRichTitleElement.c;
          ((LiveRoomInfo)localObject).tags.add(localRoomTag);
          i += 1;
        }
      }
    }
    else
    {
      QLog.e("LiveInfoProvider", 1, "parseLiveAudienceLiveInfo roomInfo is null");
    }
    localLiveInfo.roomInfo = ((LiveRoomInfo)localObject);
    localObject = new LiveAnchorInfo();
    if (paramEnterRoomReply.e != null)
    {
      ((LiveAnchorInfo)localObject).uid = paramEnterRoomReply.e.a;
      ((LiveAnchorInfo)localObject).nickName = paramEnterRoomReply.e.c;
      ((LiveAnchorInfo)localObject).explicitId = paramEnterRoomReply.e.d;
      ((LiveAnchorInfo)localObject).headUrl = paramEnterRoomReply.e.e;
      ((LiveAnchorInfo)localObject).businessUid = paramEnterRoomReply.e.h;
      ((LiveAnchorInfo)localObject).initialClientType = paramEnterRoomReply.e.g;
      ((LiveAnchorInfo)localObject).imsdkTinyId = paramEnterRoomReply.e.f;
      ((LiveAnchorInfo)localObject).wechatPub = paramEnterRoomReply.e.i;
      ((LiveAnchorInfo)localObject).sex = paramEnterRoomReply.e.b;
    }
    localLiveInfo.anchorInfo = ((LiveAnchorInfo)localObject);
    localObject = new LiveWatchMediaInfo();
    if (paramEnterRoomReply.g != null)
    {
      ((LiveWatchMediaInfo)localObject).mVideoStatus = com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus.values()[paramEnterRoomReply.g.a];
      ((LiveWatchMediaInfo)localObject).mRtmpUrl = "";
      ((LiveWatchMediaInfo)localObject).mRtmpUrlHigh = "";
      ((LiveWatchMediaInfo)localObject).mRtmpUrlLow = "";
      ((LiveWatchMediaInfo)localObject).mRtmpUrlLowest = "";
      if (paramEnterRoomReply.g.f != null)
      {
        ((LiveWatchMediaInfo)localObject).mRtmpUrl = paramEnterRoomReply.g.f.a;
        ((LiveWatchMediaInfo)localObject).mRtmpUrlHigh = paramEnterRoomReply.g.f.b;
        ((LiveWatchMediaInfo)localObject).mRtmpUrlLow = paramEnterRoomReply.g.f.c;
        ((LiveWatchMediaInfo)localObject).mRtmpUrlLowest = paramEnterRoomReply.g.f.d;
      }
      if (paramEnterRoomReply.g.g != null) {
        ((LiveWatchMediaInfo)localObject).mHLSUrl = paramEnterRoomReply.g.g.a;
      }
      if (paramEnterRoomReply.g.h != null)
      {
        ((LiveWatchMediaInfo)localObject).mFlvUrl = paramEnterRoomReply.g.h.a;
        ((LiveWatchMediaInfo)localObject).mFlvUrlHigh = paramEnterRoomReply.g.h.b;
        ((LiveWatchMediaInfo)localObject).mFlvUrlLow = paramEnterRoomReply.g.h.c;
        ((LiveWatchMediaInfo)localObject).mFlvUrlLowest = paramEnterRoomReply.g.h.d;
      }
      ((LiveWatchMediaInfo)localObject).sig = paramEnterRoomReply.g.c;
      ((LiveWatchMediaInfo)localObject).sigTimeOut = paramEnterRoomReply.g.d;
      ((LiveWatchMediaInfo)localObject).mSdkType = paramEnterRoomReply.g.b;
      if (paramEnterRoomReply.g.i != null)
      {
        a(paramEnterRoomReply.g.i, (LiveWatchMediaInfo)localObject);
        if (paramEnterRoomReply.g.i.b == 1) {
          ((LiveWatchMediaInfo)localObject).forceSwitch = true;
        }
      }
    }
    localLiveInfo.watchMediaInfo = ((LiveWatchMediaInfo)localObject);
    return localLiveInfo;
  }
  
  public static LiveRealTimeInfo a(GetRealTimeMetricsRsp paramGetRealTimeMetricsRsp)
  {
    LiveRealTimeInfo localLiveRealTimeInfo = new LiveRealTimeInfo();
    if (paramGetRealTimeMetricsRsp.a == null) {
      return localLiveRealTimeInfo;
    }
    localLiveRealTimeInfo.roomId = paramGetRealTimeMetricsRsp.a.c;
    localLiveRealTimeInfo.programId = paramGetRealTimeMetricsRsp.a.a;
    localLiveRealTimeInfo.anchorId = paramGetRealTimeMetricsRsp.a.b;
    if (paramGetRealTimeMetricsRsp.a.d != null)
    {
      if (paramGetRealTimeMetricsRsp.a.d.length == 0) {
        return localLiveRealTimeInfo;
      }
      paramGetRealTimeMetricsRsp = paramGetRealTimeMetricsRsp.a.d;
      int j = paramGetRealTimeMetricsRsp.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramGetRealTimeMetricsRsp[i];
        RealTimeData localRealTimeData = new RealTimeData();
        localRealTimeData.isShow = localObject.d;
        if ((localObject.a >= 0) && (localObject.a < MetricsType.values().length)) {
          localRealTimeData.type = MetricsType.values()[localObject.a];
        } else {
          localRealTimeData.type = MetricsType.DEFAULT;
        }
        localRealTimeData.name = localObject.b;
        localRealTimeData.value = localObject.c;
        localLiveRealTimeInfo.items.add(localRealTimeData);
        i += 1;
      }
    }
    return localLiveRealTimeInfo;
  }
  
  private static void a(DesignatedStreamInfo paramDesignatedStreamInfo, LiveWatchMediaInfo paramLiveWatchMediaInfo)
  {
    paramLiveWatchMediaInfo.sugLevel = paramDesignatedStreamInfo.d;
    if ((paramDesignatedStreamInfo.a != null) && (paramDesignatedStreamInfo.a.length > 0))
    {
      Object localObject = paramDesignatedStreamInfo.a[0];
      if (localObject != null)
      {
        paramDesignatedStreamInfo = new ServiceStreamInfo();
        paramDesignatedStreamInfo.name = ((Stream)localObject).b;
        paramDesignatedStreamInfo.rawLevel = ((Stream)localObject).c;
        paramLiveWatchMediaInfo.mLevel = paramDesignatedStreamInfo.rawLevel;
        if (((Stream)localObject).a != null)
        {
          localObject = ((Stream)localObject).a;
          int k = localObject.length;
          int i = 0;
          while (i < k)
          {
            Address[] arrayOfAddress = localObject[i];
            ServiceFrameInfo localServiceFrameInfo = new ServiceFrameInfo();
            localServiceFrameInfo.level = arrayOfAddress.a;
            localServiceFrameInfo.definition = arrayOfAddress.c;
            if (arrayOfAddress.b != null)
            {
              arrayOfAddress = arrayOfAddress.b;
              int m = arrayOfAddress.length;
              int j = 0;
              while (j < m)
              {
                Address localAddress = arrayOfAddress[j];
                ServiceAddressInfo localServiceAddressInfo = new ServiceAddressInfo();
                localServiceAddressInfo.bitrate = localAddress.b;
                localServiceAddressInfo.url = localAddress.a;
                localServiceFrameInfo.addresses.add(localServiceAddressInfo);
                j += 1;
              }
            }
            if (localServiceFrameInfo.level == paramLiveWatchMediaInfo.sugLevel) {
              paramLiveWatchMediaInfo.sugServiceFrameInfo = localServiceFrameInfo;
            }
            paramDesignatedStreamInfo.frames.add(localServiceFrameInfo);
            i += 1;
          }
        }
        paramLiveWatchMediaInfo.serviceStreamInfo = paramDesignatedStreamInfo;
      }
    }
    if ((paramLiveWatchMediaInfo.sugServiceFrameInfo != null) && (paramLiveWatchMediaInfo.sugServiceFrameInfo.addresses.size() > 0))
    {
      paramLiveWatchMediaInfo.mUrl = ((ServiceAddressInfo)paramLiveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0)).url;
      paramLiveWatchMediaInfo.mUrlHigh = ((ServiceAddressInfo)paramLiveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0)).url;
      paramLiveWatchMediaInfo.mUrlLow = ((ServiceAddressInfo)paramLiveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0)).url;
      paramLiveWatchMediaInfo.mUrlLowest = ((ServiceAddressInfo)paramLiveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0)).url;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.LiveInfoProvider
 * JD-Core Version:    0.7.0.1
 */