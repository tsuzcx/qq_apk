package com.tencent.mobileqq.together;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat.CmdAIOMediaHeartbeatReq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.aio.media.VideoWriteReply;
import tencent.aio.media.VideoWriteRequest;
import tencent.aio.media.aio_media.DynamicInfo;
import tencent.aio.media.aio_media.ReqCreateRoom;
import tencent.aio.media.aio_media.ReqGetDynamicInfo;
import tencent.aio.media.aio_media.ReqLatestPlayingState;
import tencent.aio.media.aio_media.RspGetDynamicInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;

public class TogetherOperationHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public TogetherOperationHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private aio_media.RspLatestPlayingState a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new aio_media.RspLatestPlayingState();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        return paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "parseResBdy, success=" + paramFromServiceMsg.isSuccess() + " code=" + paramFromServiceMsg.getResultCode());
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (("QQAIOMediaSvc.create_room".equals(paramFromServiceMsg.getServiceCmd())) && (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) == 1)) {}
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, new Object[] { "handleOperateTogetherWatchRsp isSuccess:", Boolean.valueOf(bool2), " errorCode:", Integer.valueOf(paramFromServiceMsg.getResultCode()) });
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    if (bool2) {}
    for (;;)
    {
      try
      {
        VideoWriteReply localVideoWriteReply = new VideoWriteReply();
        localVideoWriteReply.mergeFrom((byte[])paramObject);
        if (!localVideoWriteReply.errmsg.has()) {
          continue;
        }
        paramToServiceMsg = localVideoWriteReply.errmsg.get();
        if (!localVideoWriteReply.jumpUrl.has()) {
          continue;
        }
        paramFromServiceMsg = localVideoWriteReply.jumpUrl.get();
        int i = localVideoWriteReply.result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherOperationHandler", 2, new Object[] { "handleOperateTogetherWatchRsp errorTip:", paramToServiceMsg, " errorCode:", Integer.valueOf(i), " jumpURL=", paramFromServiceMsg });
        }
        localBundle.putString("error_msg", paramToServiceMsg);
        localBundle.putInt("error_code", i);
        localBundle.putString("jump_url", paramFromServiceMsg);
        if (i != 0) {
          continue;
        }
        bool1 = true;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TogetherOperationHandler", 2, "InvalidProtocolBufferMicroException");
        bool1 = bool2;
        continue;
      }
      notifyUI(4, bool1, localBundle);
      return;
      paramToServiceMsg = "";
      continue;
      paramFromServiceMsg = "";
      continue;
      boolean bool1 = false;
      continue;
      localBundle.putInt("error_code", paramFromServiceMsg.getResultCode());
      bool1 = bool2;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (("QQAIOMediaSvc.heartbeat".equals(paramFromServiceMsg.getServiceCmd())) && (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) == 1)) {}
  }
  
  public long a(int paramInt1, int paramInt2, String paramString)
  {
    long l = SystemClock.elapsedRealtime();
    CmdAIOMediaHeartbeatReq localCmdAIOMediaHeartbeatReq = new CmdAIOMediaHeartbeatReq();
    localCmdAIOMediaHeartbeatReq.enum_aio_type.set(paramInt2);
    localCmdAIOMediaHeartbeatReq.enum_media_type.set(paramInt1);
    localCmdAIOMediaHeartbeatReq.uint64_id.set(Long.valueOf(paramString).longValue());
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQAIOMediaSvc.heartbeat");
    localToServiceMsg.putWupBuffer(localCmdAIOMediaHeartbeatReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", paramInt1);
    localToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", paramInt2);
    localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString);
    localToServiceMsg.extraData.putLong("KEY_TS", l);
    sendPbReq(localToServiceMsg);
    return l;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherOperationHandler", 2, "getFakePanelData");
      }
      aio_media.ReqGetDynamicInfo localReqGetDynamicInfo = new aio_media.ReqGetDynamicInfo();
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.getCurrentAccountUin(), "QQAIOMediaSvc.get_dynamic_info");
      localToServiceMsg.putWupBuffer(localReqGetDynamicInfo.toByteArray());
      localToServiceMsg.setTimeout(30000L);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherOperationHandler", 2, "getFakePanelData, exception", localNumberFormatException);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "getPlayingState, service=" + paramInt1 + ",sessionType= " + paramInt2 + ", uin=" + paramString + ", by=" + paramInt3);
    }
    try
    {
      aio_media.ReqLatestPlayingState localReqLatestPlayingState = new aio_media.ReqLatestPlayingState();
      localReqLatestPlayingState.enum_aio_type.set(paramInt2);
      localReqLatestPlayingState.uint64_id.set(Long.valueOf(paramString).longValue());
      localReqLatestPlayingState.uint32_version.set(2);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.getCurrentAccountUin(), "QQAIOMediaSvc.get_latest_playing_state");
      localToServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", paramInt1);
      localToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", paramInt2);
      localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString);
      localToServiceMsg.extraData.putInt("KEY_REFRESH_SESSION_BY", paramInt3);
      localToServiceMsg.putWupBuffer(localReqLatestPlayingState.toByteArray());
      localToServiceMsg.setTimeout(30000L);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherOperationHandler", 2, "getPlayingState, exception", paramString);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "reqCreateRoom, service=" + paramInt1 + ",sessionType= " + paramInt2 + ", uin=" + paramString1 + ", songId=" + paramString2 + ", from=" + paramInt3);
    }
    try
    {
      aio_media.ReqCreateRoom localReqCreateRoom = new aio_media.ReqCreateRoom();
      localReqCreateRoom.enum_aio_type.set(paramInt2);
      localReqCreateRoom.uint64_id.set(Long.valueOf(paramString1).longValue());
      if (!TextUtils.isEmpty(paramString2)) {
        localReqCreateRoom.str_song_id.set(paramString2);
      }
      localReqCreateRoom.enum_media_type.set(paramInt1);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.getCurrentAccountUin(), "QQAIOMediaSvc.create_room");
      localToServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", paramInt1);
      localToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", paramInt2);
      localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString1);
      localToServiceMsg.extraData.putInt("KEY_FROM", paramInt3);
      if (!TextUtils.isEmpty(paramString2)) {
        localToServiceMsg.extraData.putString("KEY_SONG_ID", paramString2);
      }
      localToServiceMsg.putWupBuffer(localReqCreateRoom.toByteArray());
      localToServiceMsg.setTimeout(30000L);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherOperationHandler", 2, "getPlayingState, exception", paramString1);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "operateTogetherWatch");
    }
    long l2 = -1L;
    long l1;
    VideoWriteRequest localVideoWriteRequest;
    try
    {
      l1 = Long.parseLong(paramString4);
      if (l1 == -1L) {
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e("TogetherOperationHandler", 2, "operateTogetherWatch, exception", localNumberFormatException);
          l1 = l2;
        }
      }
      localVideoWriteRequest = new VideoWriteRequest();
      localVideoWriteRequest.categoryId.set(paramInt1);
      if (paramInt3 != 1) {
        break label276;
      }
    }
    l2 = l1;
    if (paramInt3 == 2) {}
    for (;;)
    {
      if (l2 != -1L) {
        localVideoWriteRequest.gid.set(l2);
      }
      if (l1 != -1L) {
        localVideoWriteRequest.targetUin.set(l1);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localVideoWriteRequest.matchId.set(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localVideoWriteRequest.roomTitle.set(paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localVideoWriteRequest.roomCover.set(paramString3);
      }
      localVideoWriteRequest.operType.set(paramInt2);
      paramString1 = new ToServiceMsg("mobileqq.service", this.a.getCurrentAccountUin(), "QQAIOMediaSvc.VideoWrite");
      paramString1.putWupBuffer(localVideoWriteRequest.toByteArray());
      paramString1.setTimeout(30000L);
      paramString1.extraData.putInt("KEY_SESSION_TYPE", paramInt3);
      paramString1.extraData.putString("KEY_SESSION_UIN", paramString4);
      paramString1.extraData.putInt("KEY_FROM", paramInt4);
      sendPbReq(paramString1);
      return;
      label276:
      l2 = -1L;
      break;
      l1 = -1L;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("QQAIOMediaSvc.get_latest_playing_state");
      this.allowCmdSet.add("QQAIOMediaSvc.get_dynamic_info");
      this.allowCmdSet.add("QQAIOMediaSvc.create_room");
      this.allowCmdSet.add("QQAIOMediaSvc.heartbeat");
      this.allowCmdSet.add("QQAIOMediaSvc.VideoWrite");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TogetherObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))) {}
    Object localObject1;
    int i;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          if (!"QQAIOMediaSvc.get_latest_playing_state".equals(paramFromServiceMsg.getServiceCmd())) {
            break label194;
          }
          if (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) != 1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState serviceType is listener");
        return;
        localObject1 = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if ((localObject1 != null) && (((aio_media.RspLatestPlayingState)localObject1).enum_media_type.has())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState is null or type is empty");
      return;
      i = ((aio_media.RspLatestPlayingState)localObject1).enum_media_type.get();
      localObject2 = ((TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(i);
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState receive type= " + i);
    return;
    ((TogetherParser)localObject2).a(paramToServiceMsg, (aio_media.RspLatestPlayingState)localObject1);
    for (;;)
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      label194:
      if ("QQAIOMediaSvc.get_dynamic_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherOperationHandler", 2, new Object[] { "Rsp CMD_GET_FAKE_DATA, isSuccess=", Boolean.valueOf(paramFromServiceMsg.isSuccess()) });
        }
        if (paramFromServiceMsg.isSuccess())
        {
          localObject1 = new aio_media.RspGetDynamicInfo();
          Object localObject3;
          Long localLong;
          try
          {
            ((aio_media.RspGetDynamicInfo)localObject1).mergeFrom((byte[])paramObject);
            TogetherControlManager.a(this.a).b();
            if (!((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_music_info.has()) {
              break label489;
            }
            localObject2 = new TogetherEntryData();
            ((TogetherEntryData)localObject2).b = 1001;
            ((TogetherEntryData)localObject2).jdField_a_of_type_Boolean = true;
            ((TogetherEntryData)localObject2).f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_music_info.get()).uint32_user_num.get();
            localObject3 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_music_info.get()).rpt_uint64_uins.get();
            ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localLong = (Long)((Iterator)localObject3).next();
              ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
          QLog.d("TogetherOperationHandler", 2, "InvalidProtocolBufferMicroException");
          continue;
          TogetherControlManager.a(this.a).a((TogetherEntryData)localObject2);
          label489:
          if (((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_video_info.has())
          {
            localObject2 = new TogetherEntryData();
            ((TogetherEntryData)localObject2).b = 1002;
            ((TogetherEntryData)localObject2).jdField_a_of_type_Boolean = true;
            ((TogetherEntryData)localObject2).f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_video_info.get()).uint32_user_num.get();
            localObject3 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_video_info.get()).rpt_uint64_uins.get();
            ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localLong = (Long)((Iterator)localObject3).next();
              ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            TogetherControlManager.a(this.a).a((TogetherEntryData)localObject2);
          }
          if (((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_ksing_info.has())
          {
            localObject2 = new TogetherEntryData();
            ((TogetherEntryData)localObject2).b = 1003;
            ((TogetherEntryData)localObject2).jdField_a_of_type_Boolean = true;
            ((TogetherEntryData)localObject2).f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_ksing_info.get()).uint32_user_num.get();
            localObject3 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_ksing_info.get()).rpt_uint64_uins.get();
            ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localLong = (Long)((Iterator)localObject3).next();
              ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            TogetherControlManager.a(this.a).a((TogetherEntryData)localObject2);
          }
          if (((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_play_info.has())
          {
            localObject2 = new TogetherEntryData();
            ((TogetherEntryData)localObject2).b = 1004;
            ((TogetherEntryData)localObject2).jdField_a_of_type_Boolean = true;
            ((TogetherEntryData)localObject2).f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_play_info.get()).uint32_user_num.get();
            localObject3 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).msg_play_info.get()).rpt_uint64_uins.get();
            ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject3).size());
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localLong = (Long)((Iterator)localObject3).next();
              ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            TogetherControlManager.a(this.a).a((TogetherEntryData)localObject2);
          }
          if (((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).rpt_dynamic_info.has())
          {
            Iterator localIterator = ((aio_media.RspGetDynamicInfo)localInvalidProtocolBufferMicroException.get()).rpt_dynamic_info.get().iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (aio_media.DynamicInfo)localIterator.next();
              if ((localObject3 != null) && (((aio_media.DynamicInfo)localObject3).int32_media_type.get() == 16))
              {
                localObject2 = new TogetherEntryData();
                ((TogetherEntryData)localObject2).b = 1005;
                ((TogetherEntryData)localObject2).jdField_a_of_type_Boolean = true;
                ((TogetherEntryData)localObject2).f = ((aio_media.DynamicInfo)localObject3).uint32_user_num.get();
                localObject3 = ((aio_media.DynamicInfo)localObject3).rpt_uint64_uins.get();
                ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject3).size());
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localLong = (Long)((Iterator)localObject3).next();
                  ((TogetherEntryData)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
                }
                TogetherControlManager.a(this.a).a((TogetherEntryData)localObject2);
              }
            }
          }
          notifyUI(3, true, null);
        }
      }
      else if ("QQAIOMediaSvc.VideoWrite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherOperationHandler
 * JD-Core Version:    0.7.0.1
 */