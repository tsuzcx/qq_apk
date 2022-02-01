package com.tencent.mobileqq.listentogether;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.together.TogetherOperationHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.aio.media.aio_media.PersonalSetting;
import tencent.aio.media.aio_media.ReqMediaOperation;
import tencent.aio.media.aio_media.ReqReportDownloadFail;
import tencent.aio.media.aio_media.ReqRoomOperation;
import tencent.aio.media.aio_media.ReqShareTrans;
import tencent.aio.media.aio_media.ReqShareTransCheck;
import tencent.aio.media.aio_media.ReqSongExtendedInfo;
import tencent.aio.media.aio_media.ReqSongPlayShowInfo;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspCreateRoom;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.RspMediaOperation;
import tencent.aio.media.aio_media.RspReportDownloadFail;
import tencent.aio.media.aio_media.RspRoomOperation;
import tencent.aio.media.aio_media.RspShareTrans;
import tencent.aio.media.aio_media.RspShareTransCheck;
import tencent.aio.media.aio_media.RspSongExtendedInfo;
import tencent.aio.media.aio_media.RspSongPlayShowInfo;
import tencent.aio.media.aio_media.Song;
import tencent.aio.media.aio_media.SongExtendedReqParam;
import tencent.aio.media.aio_media.TypeMusic;

public class ListenTogetherHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListenTogetherManager jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
  
  public ListenTogetherHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager = ((ListenTogetherManager)paramQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER));
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    long l3 = System.currentTimeMillis() - paramLong1;
    long l2 = l1 * 1000L - paramLong2;
    if (l2 > l3) {}
    int i;
    for (l1 = l3 / 2L;; l1 = l3 / 2L)
    {
      i = 2;
      break label87;
      if (l2 >= -500L) {
        break;
      }
    }
    if (l2 < 0L)
    {
      l1 = 0L;
      i = 3;
    }
    else
    {
      l1 = l2;
      i = 1;
    }
    label87:
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.handler", 2, String.format("calcuSeekInterval, t1: %s, t2: %s, requestInterval: %s, serverInterval: %s, reportType: %s, interval: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(l1) }));
    }
    ThreadManager.getSubThreadHandler().post(new ListenTogetherHandler.1(this, l2, l3, i, l1));
    return l1;
  }
  
  public static List<MusicInfo> a(List<aio_media.Song> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        MusicInfo localMusicInfo = MusicInfo.a((aio_media.Song)paramList.get(i));
        if (localMusicInfo != null) {
          localArrayList.add(localMusicInfo);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private List<MusicInfo> a(aio_media.TypeMusic paramTypeMusic, long paramLong1, long paramLong2)
  {
    if (paramTypeMusic != null)
    {
      long l = paramTypeMusic.int32_progress_seek.get();
      List localList = a(paramTypeMusic.rpt_msg_song_list.get());
      paramTypeMusic = localList;
      if (localList != null)
      {
        paramTypeMusic = localList;
        if (localList.size() > 0)
        {
          paramTypeMusic = (MusicInfo)localList.get(0);
          paramLong2 = a(paramLong2, paramLong1);
          if (paramLong2 > 0L) {
            paramTypeMusic.jdField_a_of_type_Long = (l + paramLong2);
          } else {
            paramTypeMusic.jdField_a_of_type_Long = l;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handler seek: ");
          localStringBuilder.append(paramTypeMusic.jdField_a_of_type_Long);
          localStringBuilder.append(" currentTime: ");
          localStringBuilder.append(System.currentTimeMillis());
          QLog.i("ListenTogether.Seek", 1, localStringBuilder.toString());
          paramTypeMusic.b = SystemClock.elapsedRealtime();
          paramTypeMusic.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
          paramTypeMusic = localList;
          if (QLog.isColorLevel())
          {
            QLog.d("ListenTogether.handler", 2, String.format("parseTypeMusic, seek: %s, serverTime: %s, interval: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
            return localList;
          }
        }
      }
    }
    else
    {
      paramTypeMusic = null;
    }
    return paramTypeMusic;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    try
    {
      aio_media.ReqMediaOperation localReqMediaOperation = new aio_media.ReqMediaOperation();
      localReqMediaOperation.enum_aio_type.set(paramInt1);
      localReqMediaOperation.uint64_id.set(Long.valueOf(paramString).longValue());
      localReqMediaOperation.enum_operation.set(paramInt2);
      if (paramInt2 == 4) {
        localReqMediaOperation.enum_play_mode.set(paramInt3);
      } else if (paramInt2 == 3) {
        localReqMediaOperation.enum_cut_type.set(paramInt3);
      }
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.media_operation");
      localToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", paramInt1);
      localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString);
      localToServiceMsg.extraData.putInt("KEY_OPERATOR", paramInt2);
      localToServiceMsg.extraData.putInt("KEY_OPVALUE", paramInt3);
      localToServiceMsg.putWupBuffer(localReqMediaOperation.toByteArray());
      localToServiceMsg.setTimeout(30000L);
      sendPbReq(localToServiceMsg);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ListenTogether.handler", 1, "getSongExtendedInfo, exception", localNumberFormatException);
      ListenTogetherManager localListenTogetherManager;
      if (paramInt2 == 1)
      {
        localListenTogetherManager = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
        if (localListenTogetherManager != null) {
          localListenTogetherManager.c(false, paramInt1, paramString);
        }
      }
      else if (paramInt2 == 2)
      {
        localListenTogetherManager = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
        if (localListenTogetherManager != null) {
          localListenTogetherManager.b(false, paramInt1, paramString);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.handler", 2, String.format("reqMediaOperator, sessionType: %s, uin: %s, operatorType: %s opValue: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    try
    {
      aio_media.ReqRoomOperation localReqRoomOperation = new aio_media.ReqRoomOperation();
      localReqRoomOperation.enum_aio_type.set(paramInt1);
      localReqRoomOperation.uint64_id.set(Long.valueOf(paramString).longValue());
      localReqRoomOperation.enum_room_operation.set(paramInt2);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.room_operation");
      localToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", paramInt1);
      localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString);
      localToServiceMsg.extraData.putInt("KEY_OPERATOR", paramInt2);
      localToServiceMsg.extraData.putInt("KEY_REFRESH_SESSION_BY", paramInt3);
      localToServiceMsg.putWupBuffer(localReqRoomOperation.toByteArray());
      sendPbReq(localToServiceMsg);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ListenTogether.handler", 1, "reqRoomOperation, exception", localNumberFormatException);
      ListenTogetherManager localListenTogetherManager = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      if (localListenTogetherManager != null) {
        if (paramInt2 == 1) {
          localListenTogetherManager.b(false, new ListenTogetherSession(paramInt1, paramString), paramInt3);
        } else if ((paramInt2 == 2) || (paramInt2 == 3)) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, new ListenTogetherSession(paramInt1, paramString), paramInt2, true);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.handler", 2, String.format("reqRoomOperation, sessionType: %s, uin: %s, operatorType: %s, by: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramToServiceMsg != null) {
      i = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
    } else {
      i = -1;
    }
    String str2 = "";
    String str1;
    if (paramToServiceMsg != null) {
      str1 = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
    } else {
      str1 = "";
    }
    int j;
    if (paramToServiceMsg != null) {
      j = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
    } else {
      j = -1;
    }
    long l1;
    ListenTogetherSession localListenTogetherSession;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      l1 = System.currentTimeMillis();
      if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null) {
        l1 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
      }
      localListenTogetherSession = new ListenTogetherSession(i, str1);
      if ((!paramFromServiceMsg.isSuccess()) || (!localListenTogetherSession.a())) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new aio_media.RspLatestPlayingState();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        if (paramFromServiceMsg != null) {
          try
          {
            k = paramFromServiceMsg.uint32_result.get();
          }
          catch (Exception paramToServiceMsg)
          {
            bool = false;
            break label603;
          }
        } else {
          k = -1;
        }
        if (k == 0)
        {
          try
          {
            if (paramToServiceMsg.enum_media_type.get() != 1) {
              return;
            }
            long l2 = paramFromServiceMsg.uint64_svr_time.get();
            localListenTogetherSession.h = paramToServiceMsg.enum_aio_state.get();
            paramFromServiceMsg = (aio_media.TypeMusic)paramToServiceMsg.msg_music.get();
            try
            {
              localListenTogetherSession.jdField_a_of_type_JavaUtilList = a(paramFromServiceMsg, l2, l1);
              localListenTogetherSession.jdField_c_of_type_Boolean = ((aio_media.TypeMusic)paramToServiceMsg.msg_music.get()).bool_allow_member_start.get();
              localListenTogetherSession.jdField_d_of_type_Boolean = ((aio_media.TypeMusic)paramToServiceMsg.msg_music.get()).bool_allow_member_add.get();
              localListenTogetherSession.jdField_c_of_type_Int = ((aio_media.TypeMusic)paramToServiceMsg.msg_music.get()).enum_play_mode.get();
              localListenTogetherSession.jdField_c_of_type_Long = l2;
              localListenTogetherSession.f = String.valueOf(paramToServiceMsg.uint64_create_uin.get());
              if (!TextUtils.isEmpty(localListenTogetherSession.f)) {
                localListenTogetherSession.g = ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, i, localListenTogetherSession.f);
              }
              localListenTogetherSession.i = paramToServiceMsg.enum_user_state.get();
              localListenTogetherSession.jdField_b_of_type_Int = paramToServiceMsg.msg_personal_setting.uint32_theme_id.get();
              if (i == 1)
              {
                i = paramToServiceMsg.uint32_joined_num.get();
                k = 0;
              }
              else
              {
                if (!paramToServiceMsg.enum_c2c_join_state.has()) {
                  break label740;
                }
                i = paramToServiceMsg.enum_c2c_join_state.get();
                break label743;
              }
              localListenTogetherSession.jdField_a_of_type_JavaLangString = localListenTogetherSession.a(i, k);
              localListenTogetherSession.jdField_a_of_type_Int = paramToServiceMsg.enum_joined_aio_type.get();
              localListenTogetherSession.jdField_b_of_type_JavaLangString = String.valueOf(paramToServiceMsg.uint64_joined_id.get());
              localListenTogetherSession.jdField_b_of_type_Boolean = paramToServiceMsg.bool_joined_is_creater.get();
              localListenTogetherSession.jdField_d_of_type_Long = paramToServiceMsg.uint64_aio_identification.get();
              bool = true;
            }
            catch (Exception paramToServiceMsg) {}
            bool = true;
          }
          catch (Exception paramToServiceMsg) {}
        }
        else
        {
          paramToServiceMsg = str2;
          if (paramFromServiceMsg != null) {
            paramToServiceMsg = str2;
          }
          bool = false;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          if (paramFromServiceMsg.bytes_errmsg.get() != null) {
            paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
          }
          QLog.d("ListenTogether.handler", 1, String.format("handleGetPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(k), paramToServiceMsg }));
        }
        catch (Exception paramToServiceMsg)
        {
          int k;
          boolean bool;
          break label600;
        }
        paramToServiceMsg = paramToServiceMsg;
      }
      label600:
      label603:
      QLog.d("ListenTogether.handler", 1, "handleGetPlayingState exception", paramToServiceMsg);
      break label619;
      bool = false;
      label619:
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(bool, localListenTogetherSession, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("handleGetPlayingState, isSuccess: %s, session: %s, by: %s", new Object[] { Boolean.valueOf(bool), localListenTogetherSession, Integer.valueOf(j) }));
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null)
      {
        paramToServiceMsg = null;
        if ((!TextUtils.isEmpty(str1)) && (i != -1)) {
          paramToServiceMsg = new ListenTogetherSession(i, str1);
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, paramToServiceMsg, -1);
      }
      QLog.d("ListenTogether.handler", 1, "handleGetPlayingState, req == null || resp == null || data == null");
      return;
      label740:
      i = -1;
      label743:
      k = i;
      i = 0;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if (paramToServiceMsg != null) {
      bool1 = paramToServiceMsg.extraData.getBoolean("KEY_REQ_LYRIC");
    } else {
      bool1 = false;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    int m;
    String str;
    int k;
    Object localObject1;
    int j;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      m = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
      str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      k = -1;
      localObject1 = localObject2;
      j = k;
    }
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          localObject1 = localObject2;
          j = k;
          aio_media.RspSongExtendedInfo localRspSongExtendedInfo = new aio_media.RspSongExtendedInfo();
          localObject1 = localObject2;
          j = k;
          localRspSongExtendedInfo.mergeFrom((byte[])paramObject);
          localObject1 = localObject2;
          j = k;
          paramFromServiceMsg = (aio_media.ResultInfo)localRspSongExtendedInfo.msg_result.get();
          i = k;
          if (paramFromServiceMsg != null)
          {
            localObject1 = localObject2;
            j = k;
            i = paramFromServiceMsg.uint32_result.get();
          }
          paramFromServiceMsg = localObject3;
          j = i;
          if (i != 0) {
            break label413;
          }
          localObject1 = localObject2;
          j = i;
          paramFromServiceMsg = a(localRspSongExtendedInfo.rpt_msg_song_list.get());
          if (paramFromServiceMsg != null)
          {
            localObject1 = paramFromServiceMsg;
            j = i;
            if (paramFromServiceMsg.size() != 0) {
              break label521;
            }
          }
          localObject1 = paramFromServiceMsg;
          j = i;
          paramFromServiceMsg = new ArrayList();
          try
          {
            paramObject = paramToServiceMsg.extraData.getStringArrayList("KEY_REQ_MUSIC_ID_LIST");
            paramToServiceMsg = paramFromServiceMsg;
            if (paramObject != null)
            {
              paramObject = paramObject.iterator();
              paramToServiceMsg = paramFromServiceMsg;
              if (paramObject.hasNext())
              {
                paramToServiceMsg = (String)paramObject.next();
                localObject1 = new MusicInfo();
                ((MusicInfo)localObject1).jdField_a_of_type_JavaLangString = paramToServiceMsg;
                paramFromServiceMsg.add(localObject1);
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("handleGetSongExtendedInfo, empty list, build musicInfo: ");
                ((StringBuilder)localObject1).append(paramToServiceMsg);
                QLog.d("ListenTogether.handler", 1, ((StringBuilder)localObject1).toString());
                continue;
              }
            }
            bool2 = true;
            paramFromServiceMsg = paramToServiceMsg;
          }
          catch (Exception paramToServiceMsg)
          {
            continue;
          }
        }
        else
        {
          localObject1 = localObject2;
          j = k;
          QLog.d("ListenTogether.handler", 1, String.format("handleGetSongExtendedInfo, rsp is failed", new Object[0]));
          paramFromServiceMsg = localObject3;
          j = k;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        i = j;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        QLog.d("ListenTogether.handler", 1, "handleGetSongExtendedInfo", paramToServiceMsg);
        j = i;
      }
      label413:
      boolean bool2 = false;
      int i = j;
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("handleGetSongExtendedInfo, sessionType: %s, uin: %s, isSuccess: %s, result: %s, musicList: %s", new Object[] { Integer.valueOf(m), str, Boolean.valueOf(bool2), Integer.valueOf(i), paramFromServiceMsg }));
      }
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(bool2, paramFromServiceMsg, bool1);
      }
      return;
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(false, null, bool1);
      }
      QLog.d("ListenTogether.handler", 1, "handleGetSongExtendedInfo, req == null || resp == null || data == null");
      return;
      label521:
      paramToServiceMsg = paramFromServiceMsg;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
    String str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
    int m = paramToServiceMsg.extraData.getInt("KEY_OPERATOR");
    int n = paramToServiceMsg.extraData.getInt("KEY_OPVALUE");
    int j;
    int i;
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      j = -1;
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg = new aio_media.RspMediaOperation();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
          i = j;
          if (paramToServiceMsg == null) {
            break label446;
          }
          i = paramToServiceMsg.uint32_result.get();
          break label446;
        }
        QLog.d("ListenTogether.handler", 1, String.format("handleMediaOperation, rsp fail, sessionType: %s, uin: %s, operatorType: %s", new Object[] { Integer.valueOf(k), str, Integer.valueOf(m) }));
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("ListenTogether.handler", 1, String.format("handleMediaOperation exception, sessionType: %s, uin: %s, operatorType: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(k), str, Integer.valueOf(m) }), paramToServiceMsg);
      }
      bool = false;
      i = j;
    }
    for (;;)
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      if (paramToServiceMsg != null) {
        if (m == 1) {
          paramToServiceMsg.c(bool, k, str);
        } else if (m == 2) {
          paramToServiceMsg.b(bool, k, str);
        } else if (m == 3) {
          paramToServiceMsg.d(bool, k, str);
        } else if (m == 4) {
          paramToServiceMsg.a(bool, k, str, n);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("handleMediaOperation, result: %s, sessionType: %s, uin: %s, operatorType: %s, opValue: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), str, Integer.valueOf(m), Integer.valueOf(n) }));
      }
      return;
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      if (paramToServiceMsg != null) {
        if (m == 1) {
          paramToServiceMsg.c(false, k, str);
        } else if (m == 2) {
          paramToServiceMsg.b(false, k, str);
        } else if (m == 3) {
          paramToServiceMsg.d(false, k, str);
        } else if (m == 4) {
          paramToServiceMsg.a(false, k, str, n);
        }
      }
      QLog.d("ListenTogether.handler", 1, "handleMediaOperation, req == null || resp == null || data == null");
      return;
      label446:
      j = i;
      if (i != 0) {
        break;
      }
      bool = true;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = -1;
    int i;
    if (paramToServiceMsg != null) {
      i = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
    } else {
      i = -1;
    }
    String str = "";
    Object localObject;
    if (paramToServiceMsg != null) {
      localObject = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
    } else {
      localObject = "";
    }
    int j;
    if (paramToServiceMsg != null) {
      j = paramToServiceMsg.extraData.getInt("KEY_OPERATOR");
    } else {
      j = -1;
    }
    int k;
    if (paramToServiceMsg != null) {
      k = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
    } else {
      k = -1;
    }
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      localObject = new ListenTogetherSession(i, (String)localObject);
      if ((paramFromServiceMsg.isSuccess()) && (((ListenTogetherSession)localObject).a()))
      {
        try
        {
          paramToServiceMsg = new aio_media.RspRoomOperation();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
          i = m;
          if (paramFromServiceMsg == null) {
            break label447;
          }
          i = paramFromServiceMsg.uint32_result.get();
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.d("ListenTogether.handler", 1, "handleReqRoomOperation exception", paramToServiceMsg);
        }
        paramToServiceMsg = str;
        if (paramFromServiceMsg != null)
        {
          paramToServiceMsg = str;
          if (paramFromServiceMsg.bytes_errmsg.get() != null) {
            paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
          }
        }
        QLog.d("ListenTogether.handler", 1, String.format("handleReqRoomOperation, result = %s, errTips = %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
      }
    }
    for (boolean bool = false;; bool = true)
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      if (paramToServiceMsg != null) {
        if (j == 1) {
          paramToServiceMsg.b(bool, (ListenTogetherSession)localObject, k);
        } else if ((j == 2) || (j == 3)) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(bool, (ListenTogetherSession)localObject, j, true);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("handleReqRoomOperation, isSuccess: %s, session: %s, operationType: %s", new Object[] { Boolean.valueOf(bool), localObject, Integer.valueOf(j) }));
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null)
      {
        paramFromServiceMsg = null;
        paramToServiceMsg = paramFromServiceMsg;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i != -1) {
            paramToServiceMsg = new ListenTogetherSession(i, (String)localObject);
          }
        }
        if (j == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, paramToServiceMsg, k);
          return;
        }
        if ((j == 2) || (j == 3)) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, paramToServiceMsg, j, true);
        }
      }
      return;
      label447:
      if (i != 0) {
        break;
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str2 = "";
    String str1;
    if (paramToServiceMsg != null) {
      str1 = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
    } else {
      str1 = "";
    }
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      Object localObject = null;
      if (paramFromServiceMsg.isSuccess()) {
        try
        {
          paramToServiceMsg = new aio_media.RspSongPlayShowInfo();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
          if (paramFromServiceMsg != null) {
            i = paramFromServiceMsg.uint32_result.get();
          } else {
            i = -1;
          }
          if (i == 0)
          {
            try
            {
              i = paramToServiceMsg.uint32_join_num.get();
              try
              {
                paramObject = paramToServiceMsg.rpt_uint64_join_uins.get();
                paramToServiceMsg = localObject;
                if (paramObject != null)
                {
                  paramToServiceMsg = localObject;
                  if (paramObject.size() > 0)
                  {
                    paramFromServiceMsg = new ArrayList();
                    try
                    {
                      paramToServiceMsg = paramObject.iterator();
                      while (paramToServiceMsg.hasNext()) {
                        paramFromServiceMsg.add(String.valueOf((Long)paramToServiceMsg.next()));
                      }
                      paramToServiceMsg = paramFromServiceMsg;
                    }
                    catch (Exception paramToServiceMsg)
                    {
                      break label209;
                    }
                  }
                }
                bool = true;
              }
              catch (Exception paramToServiceMsg)
              {
                paramFromServiceMsg = null;
                label209:
                bool = true;
                break label293;
              }
              paramToServiceMsg = str2;
            }
            catch (Exception paramToServiceMsg)
            {
              bool = true;
            }
          }
          else
          {
            if (paramFromServiceMsg != null)
            {
              paramToServiceMsg = str2;
              if (paramFromServiceMsg.bytes_errmsg.get() != null) {
                paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
              }
            }
            QLog.d("ListenTogether.handler", 1, String.format("handleGetGroupJoinedUsers, result = %s, errTips = %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
          }
        }
        catch (Exception paramToServiceMsg)
        {
          bool = false;
          paramFromServiceMsg = null;
          i = 0;
          label293:
          QLog.d("ListenTogether.handler", 1, "handleGetGroupJoinedUsers exception", paramToServiceMsg);
          paramToServiceMsg = paramFromServiceMsg;
          break label316;
        }
      }
      paramToServiceMsg = null;
      boolean bool = false;
      int i = 0;
      label316:
      if (bool) {
        notifyUI(17, true, new Object[] { str1, Integer.valueOf(i), paramToServiceMsg });
      } else {
        notifyUI(17, false, new Object[] { str1 });
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("handleGetGroupJoinedUsers, isSuccess: %s, joinedNum: %s, joinedUinList: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramToServiceMsg }));
      }
      return;
    }
    if (!TextUtils.isEmpty(str1)) {
      notifyUI(17, false, new Object[] { str1 });
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = "";
    int i = -1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      paramFromServiceMsg = new aio_media.RspReportDownloadFail();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (aio_media.ResultInfo)paramFromServiceMsg.msg_result.get();
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.uint32_result.get();
        }
        if (paramFromServiceMsg != null) {
          paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
        }
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
        if (i != 0) {
          break label151;
        }
        bool = true;
        paramFromServiceMsg.a(bool, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, new Object[] { Integer.valueOf(-1), "" });
      return;
      label151:
      boolean bool = false;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) != 1) {
      return;
    }
    int k = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE", -1);
    Object localObject = paramToServiceMsg.extraData;
    String str1 = "";
    localObject = ((Bundle)localObject).getString("KEY_SESSION_UIN", "");
    int m = paramToServiceMsg.extraData.getInt("KEY_FROM", -1);
    String str2 = paramToServiceMsg.extraData.getString("KEY_SONG_ID", "");
    boolean bool2;
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new aio_media.RspCreateRoom();
      boolean bool1;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        int j = paramFromServiceMsg.uint32_result.get();
        if (j == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        paramToServiceMsg = str1;
        i = j;
        if (bool1) {
          break label211;
        }
        try
        {
          paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
          bool2 = bool1;
          i = j;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          i = j;
        }
        QLog.d("ListenTogether.handler", 1, "handleReqCreateRoom ex", paramToServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = 0;
        bool1 = false;
      }
      paramToServiceMsg = str1;
      bool2 = bool1;
    }
    else
    {
      label211:
      paramToServiceMsg = "";
      i = 0;
      bool2 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.handler", 2, String.format("handleReqCreateRoom sessionType=%d uin=%s from=%d songId=%s res=%d wording=%s", new Object[] { Integer.valueOf(k), MobileQQ.getShortUinStr((String)localObject), Integer.valueOf(m), str2, Integer.valueOf(i), paramToServiceMsg }));
    }
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool2, k, (String)localObject, paramToServiceMsg, m, str2);
  }
  
  /* Error */
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 248	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: astore 11
    //   6: iconst_m1
    //   7: istore 4
    //   9: aload 11
    //   11: ldc_w 641
    //   14: iconst_m1
    //   15: invokevirtual 644	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   18: iconst_1
    //   19: if_icmpeq +4 -> 23
    //   22: return
    //   23: aload_1
    //   24: getfield 248	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   27: ldc 250
    //   29: iconst_m1
    //   30: invokevirtual 644	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   33: istore 8
    //   35: aload_1
    //   36: getfield 248	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   39: astore 12
    //   41: ldc_w 332
    //   44: astore 11
    //   46: aload 12
    //   48: ldc_w 258
    //   51: ldc_w 332
    //   54: invokevirtual 647	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 12
    //   59: aload_1
    //   60: getfield 248	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: ldc_w 674
    //   66: lconst_0
    //   67: invokevirtual 678	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   70: lstore 9
    //   72: aload_2
    //   73: invokevirtual 347	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   76: ifeq +124 -> 200
    //   79: new 680	com/tencent/trpcprotocol/qqAioMedia/heartbeat/heartbeat/CmdAIOMediaHeartbeatRsp
    //   82: dup
    //   83: invokespecial 681	com/tencent/trpcprotocol/qqAioMedia/heartbeat/heartbeat/CmdAIOMediaHeartbeatRsp:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 354	[B
    //   92: checkcast 354	[B
    //   95: invokevirtual 682	com/tencent/trpcprotocol/qqAioMedia/heartbeat/heartbeat/CmdAIOMediaHeartbeatRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: pop
    //   99: aload_1
    //   100: getfield 683	com/tencent/trpcprotocol/qqAioMedia/heartbeat/heartbeat/CmdAIOMediaHeartbeatRsp:msg_result	Ltencent/aio/media/aio_media$ResultInfo;
    //   103: invokevirtual 367	tencent/aio/media/aio_media$ResultInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: checkcast 364	tencent/aio/media/aio_media$ResultInfo
    //   109: astore_2
    //   110: aload_1
    //   111: getfield 686	com/tencent/trpcprotocol/qqAioMedia/heartbeat/heartbeat/CmdAIOMediaHeartbeatRsp:interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 374	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: istore 7
    //   119: iload 4
    //   121: istore 5
    //   123: aload_2
    //   124: ifnull +15 -> 139
    //   127: aload_2
    //   128: getfield 371	tencent/aio/media/aio_media$ResultInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 374	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: istore 5
    //   136: goto +3 -> 139
    //   139: iload 5
    //   141: istore 4
    //   143: aload 11
    //   145: astore_1
    //   146: iload 7
    //   148: istore 6
    //   150: aload_2
    //   151: ifnull +55 -> 206
    //   154: iload 5
    //   156: istore 4
    //   158: aload_2
    //   159: getfield 497	tencent/aio/media/aio_media$ResultInfo:bytes_errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   162: invokevirtual 502	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   165: invokevirtual 507	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   168: astore_1
    //   169: iload 5
    //   171: istore 4
    //   173: iload 7
    //   175: istore 6
    //   177: goto +29 -> 206
    //   180: astore_1
    //   181: iconst_0
    //   182: istore 6
    //   184: ldc 57
    //   186: iconst_1
    //   187: ldc_w 688
    //   190: aload_1
    //   191: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: aload 11
    //   196: astore_1
    //   197: goto +9 -> 206
    //   200: iconst_0
    //   201: istore 6
    //   203: aload 11
    //   205: astore_1
    //   206: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +39 -> 248
    //   212: ldc 57
    //   214: iconst_2
    //   215: ldc_w 690
    //   218: iconst_3
    //   219: anewarray 61	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: iload 6
    //   226: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: iload 4
    //   234: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: aload_1
    //   241: aastore
    //   242: invokestatic 78	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   245: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: iload 4
    //   250: ifne +44 -> 294
    //   253: aload_0
    //   254: bipush 24
    //   256: iconst_1
    //   257: iconst_4
    //   258: anewarray 61	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: iload 8
    //   265: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: aload 12
    //   273: aastore
    //   274: dup
    //   275: iconst_2
    //   276: lload 9
    //   278: invokestatic 67	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: aastore
    //   282: dup
    //   283: iconst_3
    //   284: iload 6
    //   286: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: invokevirtual 624	com/tencent/mobileqq/listentogether/ListenTogetherHandler:notifyUI	(IZLjava/lang/Object;)V
    //   293: return
    //   294: aload_0
    //   295: bipush 24
    //   297: iconst_0
    //   298: iconst_5
    //   299: anewarray 61	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: iload 8
    //   306: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: aload 12
    //   314: aastore
    //   315: dup
    //   316: iconst_2
    //   317: lload 9
    //   319: invokestatic 67	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   322: aastore
    //   323: dup
    //   324: iconst_3
    //   325: iload 4
    //   327: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: dup
    //   332: iconst_4
    //   333: aload_1
    //   334: aastore
    //   335: invokevirtual 624	com/tencent/mobileqq/listentogether/ListenTogetherHandler:notifyUI	(IZLjava/lang/Object;)V
    //   338: return
    //   339: astore_1
    //   340: iload 7
    //   342: istore 6
    //   344: goto -160 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	ListenTogetherHandler
    //   0	347	1	paramToServiceMsg	ToServiceMsg
    //   0	347	2	paramFromServiceMsg	FromServiceMsg
    //   0	347	3	paramObject	Object
    //   7	319	4	i	int
    //   121	49	5	j	int
    //   148	195	6	k	int
    //   117	224	7	m	int
    //   33	272	8	n	int
    //   70	248	9	l	long
    //   4	200	11	localObject1	Object
    //   39	274	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   87	119	180	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	136	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   158	169	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public long a(int paramInt, String paramString)
  {
    return ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(1, paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, 1, 0);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, 4, paramInt2);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(1, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    try
    {
      aio_media.ReqReportDownloadFail localReqReportDownloadFail = new aio_media.ReqReportDownloadFail();
      localReqReportDownloadFail.enum_aio_type.set(paramInt);
      localReqReportDownloadFail.uint64_id.set(Long.parseLong(paramString1));
      localReqReportDownloadFail.str_song_id.set(paramString2);
      localReqReportDownloadFail.bytes_song_name.set(ByteStringMicro.copyFromUtf8(paramString3));
      localReqReportDownloadFail.bytes_song_url.set(ByteStringMicro.copyFromUtf8(paramString4));
      paramString2 = new ArrayList();
      paramString3 = paramList.iterator();
      while (paramString3.hasNext()) {
        paramString2.add(ByteStringMicro.copyFromUtf8((String)paramString3.next()));
      }
      localReqReportDownloadFail.rpt_bytes_singer.set(paramString2);
      paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.report_download_fail");
      paramString2.extraData.putString("uin", paramString1);
      paramString2.extraData.putInt("uintype", paramInt);
      paramString2.putWupBuffer(localReqReportDownloadFail.toByteArray());
      sendPbReq(paramString2);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("checkAndShowAioShareMusic()-> request = ");
        paramString1.append(paramString2.toString());
        QLog.d("ListenTogether.handler", 2, paramString1.toString());
        return;
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(int paramInt, String paramString, List<MusicExtendedReqParam> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("getSongExtendedInfo, sessionType: %s, uin: %s, musicList: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramList }));
      }
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        aio_media.ReqSongExtendedInfo localReqSongExtendedInfo = new aio_media.ReqSongExtendedInfo();
        localReqSongExtendedInfo.enum_aio_type.set(paramInt);
        localReqSongExtendedInfo.uint64_id.set(Long.valueOf(paramString).longValue());
        ArrayList localArrayList2 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MusicExtendedReqParam localMusicExtendedReqParam = (MusicExtendedReqParam)paramList.next();
          aio_media.SongExtendedReqParam localSongExtendedReqParam = new aio_media.SongExtendedReqParam();
          localSongExtendedReqParam.str_song_id.set(localMusicExtendedReqParam.jdField_a_of_type_JavaLangString);
          localSongExtendedReqParam.bool_need_lyric.set(localMusicExtendedReqParam.jdField_b_of_type_Boolean);
          localSongExtendedReqParam.bool_need_url.set(localMusicExtendedReqParam.jdField_a_of_type_Boolean);
          localArrayList2.add(localSongExtendedReqParam);
          localArrayList1.add(localMusicExtendedReqParam.jdField_a_of_type_JavaLangString);
        }
        localReqSongExtendedInfo.rpt_msg_song_list.set(localArrayList2);
        paramList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.get_song_extended_info");
        paramList.extraData.putInt("KEY_SESSION_TYPE", paramInt);
        paramList.extraData.putString("KEY_SESSION_UIN", paramString);
        paramList.extraData.putBoolean("KEY_REQ_LYRIC", paramBoolean);
        paramList.extraData.putStringArrayList("KEY_REQ_MUSIC_ID_LIST", localArrayList1);
        paramList.putWupBuffer(localReqSongExtendedInfo.toByteArray());
        paramList.setTimeout(30000L);
        sendPbReq(paramList);
        return;
      }
      catch (NumberFormatException paramString)
      {
        paramList = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
        if (paramList != null) {
          paramList.a(false, null, paramBoolean);
        }
        QLog.d("ListenTogether.handler", 1, "getSongExtendedInfo, exception", paramString);
        return;
      }
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
    if (paramList != null) {
      paramList.a(false, null, paramBoolean);
    }
    QLog.d("ListenTogether.handler", 1, String.format("getSongExtendedInfo, sessionType = %s, uin = %s, musicReaList is empty!", new Object[] { Integer.valueOf(paramInt), paramString }));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = new aio_media.RspShareTransCheck();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = (aio_media.ResultInfo)paramFromServiceMsg.msg_result.get();
        int i;
        if (paramObject != null) {
          i = paramObject.uint32_result.get();
        } else {
          i = -1;
        }
        paramToServiceMsg = "";
        if (i == 0)
        {
          paramObject = new JSONObject();
          paramObject.put("isSuccess", true);
          paramObject.put("enum_aio_state", paramFromServiceMsg.enum_aio_state.get());
          paramObject.put("enum_media_type", paramFromServiceMsg.enum_media_type.get());
          paramObject.put("bool_show_icon", paramFromServiceMsg.bool_show_icon.get());
          paramObject.put("str_song_id", paramFromServiceMsg.str_song_id.get());
          paramObject.put("uint32_duration", paramFromServiceMsg.uint32_duration.get());
          paramObject.put("uint64_create_uin", paramFromServiceMsg.uint64_create_uin.get());
          paramObject.put("bool_song_existed", paramFromServiceMsg.bool_song_existed.get());
          paramObject.put("bool_allow_member_start", paramFromServiceMsg.bool_allow_member_start.get());
          paramObject.put("bool_allow_member_add", paramFromServiceMsg.bool_allow_member_add.get());
          if (!TextUtils.isEmpty(QQMusicPlayService.b())) {
            paramToServiceMsg = QQMusicPlayService.b();
          }
          paramObject.put("current_song_id", paramToServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(true, paramObject);
          return;
        }
        if (QLog.isColorLevel())
        {
          if (paramObject != null) {
            paramToServiceMsg = paramObject.bytes_errmsg.get().toStringUtf8();
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleCheckAndShowAioShareMusic() result = ");
          paramFromServiceMsg.append(i);
          paramFromServiceMsg.append(" errMsg = ");
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("AioShareMusicListenTogether.handler", 2, paramFromServiceMsg.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      label349:
      break label349;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ListenTogether.handler", 2, String.format("getGroupJoinedUsers, groupUin is empty!", new Object[0]));
      return;
    }
    try
    {
      aio_media.ReqSongPlayShowInfo localReqSongPlayShowInfo = new aio_media.ReqSongPlayShowInfo();
      localReqSongPlayShowInfo.uint64_id.set(Long.valueOf(paramString).longValue());
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.get_play_show_info");
      localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString);
      localToServiceMsg.putWupBuffer(localReqSongPlayShowInfo.toByteArray());
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ListenTogether.handler", 1, "getGroupJoinedUsers, exception", localNumberFormatException);
      notifyUI(17, false, new Object[] { paramString });
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" checkAndShowAioShareMusic（） jsonObject = ");
        ((StringBuilder)localObject1).append(paramJSONObject);
        QLog.d("ListenTogether.handler", 2, ((StringBuilder)localObject1).toString());
      }
      int j = paramJSONObject.getInt("enum_aio_type");
      Object localObject1 = paramJSONObject.getString("uint64_id");
      int i = paramJSONObject.getInt("uint32_share_appid");
      Object localObject2 = paramJSONObject.getString("bytes_song_name");
      String str = paramJSONObject.getString("bytes_song_url");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rpt_bytes_singer");
      paramJSONObject = new aio_media.ReqShareTransCheck();
      paramJSONObject.enum_aio_type.set(j);
      paramJSONObject.uint64_id.set(Long.parseLong((String)localObject1));
      paramJSONObject.uint32_share_appid.set(i);
      paramJSONObject.bytes_song_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramJSONObject.bytes_song_url.set(ByteStringMicro.copyFromUtf8(str));
      localObject2 = new ArrayList();
      i = 0;
      while (i < localJSONArray.length())
      {
        ((List)localObject2).add(ByteStringMicro.copyFromUtf8(localJSONArray.getJSONObject(i).getString("singer")));
        i += 1;
      }
      paramJSONObject.rpt_bytes_singer.set((List)localObject2);
      localObject2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.share_trans_check");
      ((ToServiceMsg)localObject2).extraData.putString("uin", (String)localObject1);
      ((ToServiceMsg)localObject2).extraData.putInt("uintype", j);
      ((ToServiceMsg)localObject2).putWupBuffer(paramJSONObject.toByteArray());
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label275:
      break label275;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, 2, 0);
  }
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, 3, paramInt2);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    try
    {
      if (!paramFromServiceMsg.isSuccess()) {
        break label175;
      }
      aio_media.RspShareTrans localRspShareTrans = new aio_media.RspShareTrans();
      localRspShareTrans.mergeFrom((byte[])paramObject);
      j = paramToServiceMsg.extraData.getInt("uintype");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      paramObject = paramToServiceMsg.extraData.getString("aio_share_song_id");
      paramToServiceMsg = (aio_media.ResultInfo)localRspShareTrans.msg_result.get();
      if (paramToServiceMsg == null) {
        break label231;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        int j;
        label175:
        continue;
        int i = -1;
        continue;
        paramToServiceMsg = "";
      }
    }
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(true, new Object[] { Integer.valueOf(j), paramFromServiceMsg, paramObject });
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(i), paramToServiceMsg });
      return;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(-1), "" });
      return;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(-1), "" });
      return;
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      int j = paramJSONObject.getInt("enum_aio_type");
      String str1 = paramJSONObject.getString("uint64_id");
      int i = paramJSONObject.getInt("uint32_share_appid");
      Object localObject2 = paramJSONObject.getString("bytes_song_name");
      String str4 = paramJSONObject.getString("bytes_song_url");
      boolean bool = paramJSONObject.getBoolean("bool_cut_song");
      String str2 = paramJSONObject.getString("str_song_id");
      int k = paramJSONObject.getInt("uint32_duration");
      Object localObject1 = paramJSONObject.getString("uint64_sharer_uin");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rpt_bytes_singer");
      String str3 = paramJSONObject.getString("bytes_cover");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" startAioShareMusic（） jsonStr = ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("ListenTogether.handler", 2, localStringBuilder.toString());
      }
      paramJSONObject = new aio_media.ReqShareTrans();
      paramJSONObject.enum_aio_type.set(j);
      paramJSONObject.uint64_id.set(Long.parseLong(str1));
      paramJSONObject.uint32_share_appid.set(i);
      paramJSONObject.bytes_song_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramJSONObject.bytes_song_url.set(ByteStringMicro.copyFromUtf8(str4));
      localObject2 = new ArrayList();
      i = 0;
      while (i < localJSONArray.length())
      {
        ((List)localObject2).add(ByteStringMicro.copyFromUtf8(localJSONArray.getJSONObject(i).getString("singer")));
        i += 1;
      }
      paramJSONObject.str_song_id.set(str2);
      paramJSONObject.rpt_bytes_singer.set((List)localObject2);
      paramJSONObject.bool_cut_song.set(bool);
      paramJSONObject.uint32_duration.set(k);
      paramJSONObject.uint64_sharer_uin.set(Long.parseLong((String)localObject1));
      paramJSONObject.bytes_cover.set(ByteStringMicro.copyFromUtf8(str3));
      localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.share_trans");
      ((ToServiceMsg)localObject1).extraData.putString("uin", str1);
      ((ToServiceMsg)localObject1).extraData.putInt("uintype", j);
      ((ToServiceMsg)localObject1).extraData.putString("aio_share_song_id", str2);
      ((ToServiceMsg)localObject1).putWupBuffer(paramJSONObject.toByteArray());
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label387:
      break label387;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(-1), "" });
  }
  
  public void c(int paramInt, String paramString)
  {
    b(paramInt, paramString, 2, 0);
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    b(paramInt1, paramString, 1, paramInt2);
  }
  
  public void d(int paramInt, String paramString)
  {
    b(paramInt, paramString, 3, 0);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ListenTogetherObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("QQAIOMediaSvc.get_latest_playing_state".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (1 == paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE")) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else
    {
      if ("QQAIOMediaSvc.get_song_extended_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.media_operation".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.get_play_show_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.share_trans_check".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.share_trans".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.report_download_fail".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.create_room".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQAIOMediaSvc.heartbeat".equals(paramFromServiceMsg.getServiceCmd())) {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHandler
 * JD-Core Version:    0.7.0.1
 */