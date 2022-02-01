package com.tencent.mobileqq.qqlive.anchor.room.sso;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.PrepareReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.SetReq;
import com.tencent.qqlive.protobuf.iliveStreamControl.nano.GetLiveStreamsReq;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetRtmpPushUrlReq;

public class QQLiveAnchorSSO
{
  public static void a(IQQLiveSDK paramIQQLiveSDK, PrepareReq paramPrepareReq, QQLiveAnchorSSO.Callback<QQLiveAnchorDataPrepare> paramCallback)
  {
    ((IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module")).a("trpc.qlive.ilive_room_play.RoomPlay", "Prepare", MessageNano.toByteArray(paramPrepareReq), new QQLiveAnchorSSO.1(paramCallback));
  }
  
  public static void a(IQQLiveSDK paramIQQLiveSDK, SetReq paramSetReq, QQLiveAnchorSSO.Callback<QQLiveAnchorDataSet> paramCallback)
  {
    ((IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module")).a("trpc.qlive.ilive_room_play.RoomPlay", "Set", MessageNano.toByteArray(paramSetReq), new QQLiveAnchorSSO.2(paramCallback));
  }
  
  public static void a(IQQLiveSDK paramIQQLiveSDK, GetRtmpPushUrlReq paramGetRtmpPushUrlReq, QQLiveAnchorSSO.Callback<QQLiveAnchorDataPushInfo> paramCallback)
  {
    ((IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module")).a("trpc.qlive.media_logic4opensdk.MediaLogic", "GetRtmpPushUrl", MessageNano.toByteArray(paramGetRtmpPushUrlReq), new QQLiveAnchorSSO.3(paramCallback));
  }
  
  public static void a(IQQLiveSDK paramIQQLiveSDK, String paramString, GetLiveStreamsReq paramGetLiveStreamsReq, QQLiveAnchorSSO.Callback<QQLiveAnchorDataPullInfo> paramCallback)
  {
    ((IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module")).a("trpc.qlive.ilive_stream_control.StreamControl", "GetLiveStreams", MessageNano.toByteArray(paramGetLiveStreamsReq), new QQLiveAnchorSSO.4(paramString, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO
 * JD-Core Version:    0.7.0.1
 */