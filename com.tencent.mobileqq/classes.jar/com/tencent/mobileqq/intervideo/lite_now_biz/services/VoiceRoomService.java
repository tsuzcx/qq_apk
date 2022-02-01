package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import android.os.Bundle;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.AnchorAvInfo;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.EnterRoomReq;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.EnterRoomRsp;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.Extinfo;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.OpenSkdInfo;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.ProgramInfo;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.RoomInfo;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.UserInfo;
import com.tencent.component.room.protocol.pbenterroom.pbenterroom.VideoInfo;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.utils.StringUtil;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveVideoStatus;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.DefaultCustomRoomService;
import com.tencent.mobileqq.litelivesdk.utils.CookieHelper;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsFactory;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class VoiceRoomService
  extends DefaultCustomRoomService
{
  private LiveInfo a(pbenterroom.EnterRoomRsp paramEnterRoomRsp, EnterRoomInfo paramEnterRoomInfo)
  {
    paramEnterRoomInfo = new LiveInfo();
    Object localObject = new LiveRoomInfo();
    if (paramEnterRoomRsp.room_info.has())
    {
      ((LiveRoomInfo)localObject).roomId = paramEnterRoomRsp.room_info.roomid.get();
      ((LiveRoomInfo)localObject).programId = paramEnterRoomRsp.program_info.id.get();
      ((LiveRoomInfo)localObject).roomType = paramEnterRoomRsp.room_info.room_type.get();
      ((LiveRoomInfo)localObject).roomName = paramEnterRoomRsp.room_info.name.get();
      ((LiveRoomInfo)localObject).roomLogo = paramEnterRoomRsp.room_info.full_logo.get();
      ((LiveRoomInfo)localObject).goodsFlag = paramEnterRoomRsp.room_info.goods_flag.get();
    }
    paramEnterRoomInfo.roomInfo = ((LiveRoomInfo)localObject);
    localObject = new LiveAnchorInfo();
    if (paramEnterRoomRsp.anchor_info.has())
    {
      ((LiveAnchorInfo)localObject).uid = (paramEnterRoomRsp.anchor_info.userid.get() & 0xFFFFFFFF);
      ((LiveAnchorInfo)localObject).nickName = paramEnterRoomRsp.anchor_info.name.get();
      ((LiveAnchorInfo)localObject).initialClientType = paramEnterRoomRsp.anchor_info.client_type.get();
      ((LiveAnchorInfo)localObject).headUrl = paramEnterRoomRsp.anchor_info.head_url.get();
      ((LiveAnchorInfo)localObject).explicitId = paramEnterRoomRsp.anchor_info.explicit_uid.get();
      if ((paramEnterRoomRsp.anchor_info.vip_explicit_uid.has()) && (paramEnterRoomRsp.anchor_info.vip_explicit_uid.get() != 0L)) {
        ((LiveAnchorInfo)localObject).explicitId = paramEnterRoomRsp.anchor_info.vip_explicit_uid.get();
      }
      ((LiveAnchorInfo)localObject).imsdkTinyId = paramEnterRoomRsp.anchor_info.imsdk_tinyid.get();
    }
    paramEnterRoomInfo.anchorInfo = ((LiveAnchorInfo)localObject);
    localObject = new LiveWatchMediaInfo();
    if (paramEnterRoomRsp.video_info.has())
    {
      int i = paramEnterRoomRsp.video_info.video_status.get();
      if (i != 0)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              ((LiveWatchMediaInfo)localObject).mVideoStatus = LiveVideoStatus.Unknown;
            } else {
              ((LiveWatchMediaInfo)localObject).mVideoStatus = LiveVideoStatus.Stuck;
            }
          }
          else {
            ((LiveWatchMediaInfo)localObject).mVideoStatus = LiveVideoStatus.Pause;
          }
        }
        else {
          ((LiveWatchMediaInfo)localObject).mVideoStatus = LiveVideoStatus.Stop;
        }
      }
      else {
        ((LiveWatchMediaInfo)localObject).mVideoStatus = LiveVideoStatus.Start;
      }
    }
    if (paramEnterRoomRsp.sdk_info.has())
    {
      ((LiveWatchMediaInfo)localObject).sig = paramEnterRoomRsp.sdk_info.sig.get().toByteArray();
      ((LiveWatchMediaInfo)localObject).sigTimeOut = paramEnterRoomRsp.sdk_info.time.get();
      ((LiveWatchMediaInfo)localObject).mSdkType = paramEnterRoomRsp.sdk_info.mode.get();
    }
    if (paramEnterRoomRsp.av_info.has())
    {
      ((LiveWatchMediaInfo)localObject).mRtmp_url = "";
      if (paramEnterRoomRsp.rtmp_url.get().size() > 0) {
        ((LiveWatchMediaInfo)localObject).mRtmp_url = ((String)paramEnterRoomRsp.rtmp_url.get().get(0));
      }
      ((LiveWatchMediaInfo)localObject).mRtmp_url_high = "";
      ((LiveWatchMediaInfo)localObject).mRtmp_url_low = "";
      ((LiveWatchMediaInfo)localObject).mRtmp_url_lowest = "";
      if (paramEnterRoomRsp.rtmp_url.get().size() > 1) {
        ((LiveWatchMediaInfo)localObject).mRtmp_url_high = ((String)paramEnterRoomRsp.rtmp_url.get().get(1));
      }
      if (paramEnterRoomRsp.rtmp_url.get().size() > 2) {
        ((LiveWatchMediaInfo)localObject).mRtmp_url_low = ((String)paramEnterRoomRsp.rtmp_url.get().get(2));
      }
      if (paramEnterRoomRsp.rtmp_url.get().size() > 3) {
        ((LiveWatchMediaInfo)localObject).mRtmp_url_lowest = ((String)paramEnterRoomRsp.rtmp_url.get().get(3));
      }
      if (paramEnterRoomRsp.hls_url.size() > 0) {
        ((LiveWatchMediaInfo)localObject).mHLS_url = ((String)paramEnterRoomRsp.hls_url.get(0));
      }
      if (paramEnterRoomRsp.h5_url.size() > 0) {
        ((LiveWatchMediaInfo)localObject).mFlv_url = ((String)paramEnterRoomRsp.h5_url.get(0));
      }
      if (paramEnterRoomRsp.h5_url.size() > 0) {
        ((LiveWatchMediaInfo)localObject).mFlv_url_high = ((String)paramEnterRoomRsp.h5_url.get(1));
      }
      if (paramEnterRoomRsp.h5_url.size() > 0) {
        ((LiveWatchMediaInfo)localObject).mFlv_url_low = ((String)paramEnterRoomRsp.h5_url.get(2));
      }
      if (paramEnterRoomRsp.h5_url.size() > 0) {
        ((LiveWatchMediaInfo)localObject).mFlv_url_lowest = ((String)paramEnterRoomRsp.h5_url.get(3));
      }
      ((LiveWatchMediaInfo)localObject).mRtmpType = paramEnterRoomRsp.use_url.get();
      try
      {
        paramEnterRoomRsp = paramEnterRoomRsp.ext_info.get().toByteArray();
        if ((paramEnterRoomRsp != null) && (paramEnterRoomRsp.length > 0))
        {
          pbenterroom.Extinfo localExtinfo = new pbenterroom.Extinfo();
          localExtinfo.mergeFrom(paramEnterRoomRsp);
          ((LiveWatchMediaInfo)localObject).mContentType = localExtinfo.content_type.get();
        }
      }
      catch (Exception paramEnterRoomRsp)
      {
        paramEnterRoomRsp.printStackTrace();
      }
    }
    paramEnterRoomInfo.watchMediaInfo = ((LiveWatchMediaInfo)localObject);
    return paramEnterRoomInfo;
  }
  
  private void a(int paramInt, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    pbenterroom.EnterRoomReq localEnterRoomReq = new pbenterroom.EnterRoomReq();
    localEnterRoomReq.roomId.set((int)this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo.roomId);
    if (!StringUtil.isEmpty(this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo.source)) {}
    try
    {
      i = Integer.valueOf(this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo.source).intValue();
    }
    catch (Exception localException)
    {
      int i;
      label55:
      com.tencent.falco.base.libapi.log.LogInterface localLogInterface;
      StringBuilder localStringBuilder;
      break label55;
    }
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getLogger().i("AbstractCustomRoomService", "fromid is not integer", new Object[0]);
    i = 0;
    localEnterRoomReq.from_id.set(i);
    localLogInterface = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getLogger();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromid = ");
    localStringBuilder.append(i);
    localLogInterface.i("AbstractCustomRoomService", localStringBuilder.toString(), new Object[0]);
    localEnterRoomReq.enter_type.set(1);
    localEnterRoomReq.room_type.set(this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo.roomType);
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getChannel().send(16423, 1, localEnterRoomReq.toByteArray(), new VoiceRoomService.1(this, paramEnterExitRoomCallback, paramInt));
  }
  
  private void a(EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    int i = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo.extData.getInt("content_type");
    com.tencent.mobileqq.litelivesdk.utils.log.LogInterface localLogInterface = LogFactory.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("----------watchEnterRoom contentType ");
    ((StringBuilder)localObject).append(i);
    localLogInterface.c("AbstractCustomRoomService", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((Map)localObject).put("Referer", g());
    long l = System.currentTimeMillis();
    a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("room_id", String.valueOf(this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo.roomId));
    }
    catch (Exception localException)
    {
      a(System.currentTimeMillis() - l, -2, localException.getMessage());
      paramEnterExitRoomCallback.onSuccess();
    }
    String str;
    if (this.jdField_a_of_type_Boolean) {
      str = b();
    } else {
      str = a();
    }
    HttpsFactory.a().a(str, (Map)localObject, localJSONObject, new VoiceRoomService.2(this, paramEnterExitRoomCallback, l), CookieHelper.a());
  }
  
  private boolean a(pbenterroom.EnterRoomRsp paramEnterRoomRsp, EnterRoomInfo paramEnterRoomInfo)
  {
    paramEnterRoomRsp = a(paramEnterRoomRsp, paramEnterRoomInfo);
    if ((paramEnterRoomRsp != null) && (paramEnterRoomRsp.watchMediaInfo != null) && (paramEnterRoomRsp.watchMediaInfo.sig != null))
    {
      if (paramEnterRoomRsp.watchMediaInfo != null) {
        getLiveInfo().watchMediaInfo = paramEnterRoomRsp.watchMediaInfo;
      }
      if (paramEnterRoomRsp.anchorInfo != null) {
        getLiveInfo().anchorInfo = paramEnterRoomRsp.anchorInfo;
      }
      if (paramEnterRoomRsp.mediaInfo != null) {
        getLiveInfo().mediaInfo = paramEnterRoomRsp.mediaInfo;
      }
      if (paramEnterRoomRsp.roomInfo != null) {
        getLiveInfo().roomInfo = paramEnterRoomRsp.roomInfo;
      }
      return true;
    }
    return false;
  }
  
  public void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo = paramEnterRoomInfo;
    com.tencent.falco.base.libapi.log.LogInterface localLogInterface = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestEnterRoom roomInfo=");
    localStringBuilder.append(paramEnterRoomInfo.toString());
    localLogInterface.i("AbstractCustomRoomService", localStringBuilder.toString(), new Object[0]);
    a(3, paramEnterExitRoomCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.VoiceRoomService
 * JD-Core Version:    0.7.0.1
 */