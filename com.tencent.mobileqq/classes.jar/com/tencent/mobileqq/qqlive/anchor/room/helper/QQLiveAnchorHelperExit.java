package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.pbexit_heart_list_room.nano.LeaveLiveRoomReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.ShutLiveReq;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.EndNewReq;

public class QQLiveAnchorHelperExit
{
  public static void a(IQQLiveSDK paramIQQLiveSDK, String paramString, LeaveLiveRoomReq paramLeaveLiveRoomReq, ExitRoomCallback paramExitRoomCallback)
  {
    if (paramIQQLiveSDK == null)
    {
      QLog.e("QQLiveAnchor_Exit", 1, "callLeaveLiveReq, liveSDK is null");
      if (paramExitRoomCallback != null) {
        paramExitRoomCallback.onComplete(-1, "liveSDK is null");
      }
      return;
    }
    paramIQQLiveSDK = (IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module");
    if (paramIQQLiveSDK == null)
    {
      QLog.e("QQLiveAnchor_Exit", 1, "callLeaveLiveReq, ssoModule is null");
      if (paramExitRoomCallback != null) {
        paramExitRoomCallback.onComplete(-1, "ssoModule is null");
      }
      return;
    }
    try
    {
      paramIQQLiveSDK.a("trpc.qlive.ilive_room_broadcast_svr.RoomBroadcast", "LeaveLiveRoom", MessageNano.toByteArray(paramLeaveLiveRoomReq), new QQLiveAnchorHelperExit.1(paramExitRoomCallback));
      return;
    }
    catch (Throwable paramIQQLiveSDK)
    {
      QLog.e("QQLiveAnchor_Exit", 1, paramIQQLiveSDK, new Object[0]);
      if (paramExitRoomCallback != null) {
        paramExitRoomCallback.onComplete(-1, paramIQQLiveSDK.getMessage());
      }
    }
  }
  
  public static void a(IQQLiveSDK paramIQQLiveSDK, String paramString, ShutLiveReq paramShutLiveReq, ExitRoomCallback paramExitRoomCallback)
  {
    if (paramIQQLiveSDK == null)
    {
      QLog.e("QQLiveAnchor_Exit", 1, "callShutLiveReq, liveSDK is null");
      if (paramExitRoomCallback != null) {
        paramExitRoomCallback.onComplete(-1, "liveSdk is null");
      }
      return;
    }
    paramIQQLiveSDK = (IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module");
    if (paramIQQLiveSDK == null)
    {
      QLog.e("QQLiveAnchor_Exit", 1, "callShutLiveReq, ssoModule is null");
      if (paramExitRoomCallback != null) {
        paramExitRoomCallback.onComplete(-1, "ssoModule is null");
      }
      return;
    }
    try
    {
      paramIQQLiveSDK.a("trpc.qlive.ilive_room_play.RoomPlay", "ShutLive", MessageNano.toByteArray(paramShutLiveReq), new QQLiveAnchorHelperExit.2(paramExitRoomCallback));
      return;
    }
    catch (Throwable paramIQQLiveSDK)
    {
      QLog.e("QQLiveAnchor_Exit", 1, paramIQQLiveSDK, new Object[0]);
      if (paramExitRoomCallback != null) {
        paramExitRoomCallback.onComplete(-1, paramIQQLiveSDK.getMessage());
      }
    }
  }
  
  public static void a(IQQLiveSDK paramIQQLiveSDK, String paramString, EndNewReq paramEndNewReq, ExitRoomCallback paramExitRoomCallback)
  {
    if ((paramIQQLiveSDK != null) && (paramExitRoomCallback != null))
    {
      paramIQQLiveSDK = (IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module");
      if (paramIQQLiveSDK == null)
      {
        QLog.e("QQLiveAnchor_Exit", 1, "callEndNewReq, ssoModule is null");
        if (paramExitRoomCallback != null) {
          paramExitRoomCallback.onComplete(-1, "ssoModule is null");
        }
        return;
      }
      try
      {
        paramIQQLiveSDK.a("trpc.qlive.media_logic4opensdk.MediaLogic", "EndNew", MessageNano.toByteArray(paramEndNewReq), new QQLiveAnchorHelperExit.3(paramExitRoomCallback));
        return;
      }
      catch (Throwable paramIQQLiveSDK)
      {
        QLog.e("QQLiveAnchor_Exit", 1, paramIQQLiveSDK, new Object[0]);
        if (paramExitRoomCallback != null) {
          paramExitRoomCallback.onComplete(-1, paramIQQLiveSDK.getMessage());
        }
        return;
      }
    }
    QLog.e("QQLiveAnchor_Exit", 1, "callEndNewReq, something is null");
    if (paramExitRoomCallback != null) {
      paramExitRoomCallback.onComplete(-1, "params null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperExit
 * JD-Core Version:    0.7.0.1
 */