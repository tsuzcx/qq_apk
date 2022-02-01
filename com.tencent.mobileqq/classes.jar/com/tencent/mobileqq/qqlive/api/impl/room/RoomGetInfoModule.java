package com.tencent.mobileqq.qqlive.api.impl.room;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qlive.iliveMetricsSvr.nano.GetRealTimeMetricsReq;

class RoomGetInfoModule
{
  void getRoomRealTimeInfo(long paramLong, String paramString, IQQLiveSDK paramIQQLiveSDK, GetRoomInfoCallback paramGetRoomInfoCallback)
  {
    GetRealTimeMetricsReq localGetRealTimeMetricsReq = new GetRealTimeMetricsReq();
    localGetRealTimeMetricsReq.a = paramLong;
    if (!TextUtils.isEmpty(paramString)) {
      localGetRealTimeMetricsReq.b = paramString.getBytes();
    }
    ((IQQLiveSsoModule)paramIQQLiveSDK.getExtModule("sso_module")).a("trpc.qlive.ilive_metrics_svr.IliveMetricsSvr", "GetRealTimeMetrics", MessageNano.toByteArray(localGetRealTimeMetricsReq), new RoomGetInfoModule.1(this, paramGetRoomInfoCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.RoomGetInfoModule
 * JD-Core Version:    0.7.0.1
 */