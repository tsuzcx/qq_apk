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
import com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat.CmdAIOMediaHeartbeatRsp;
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
    int i;
    if (l2 > l3)
    {
      l1 = l3 / 2L;
      i = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("calcuSeekInterval, t1: %s, t2: %s, requestInterval: %s, serverInterval: %s, reportType: %s, interval: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(l1) }));
      }
      ThreadManager.getSubThreadHandler().post(new ListenTogetherHandler.1(this, l2, l3, i, l1));
      return l1;
      if (l2 < -500L)
      {
        l1 = l3 / 2L;
        i = 2;
      }
      else if (l2 < 0L)
      {
        l1 = 0L;
        i = 3;
      }
      else
      {
        i = 1;
        l1 = l2;
      }
    }
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
    List localList = null;
    long l;
    if (paramTypeMusic != null)
    {
      l = paramTypeMusic.int32_progress_seek.get();
      localList = a(paramTypeMusic.rpt_msg_song_list.get());
      if ((localList != null) && (localList.size() > 0))
      {
        paramTypeMusic = (MusicInfo)localList.get(0);
        paramLong2 = a(paramLong2, paramLong1);
        if (paramLong2 <= 0L) {
          break label181;
        }
      }
    }
    label181:
    for (paramTypeMusic.jdField_a_of_type_Long = (l + paramLong2);; paramTypeMusic.jdField_a_of_type_Long = l)
    {
      QLog.i("ListenTogether.Seek", 1, "handler seek: " + paramTypeMusic.jdField_a_of_type_Long + " currentTime: " + System.currentTimeMillis());
      paramTypeMusic.b = SystemClock.elapsedRealtime();
      paramTypeMusic.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("parseTypeMusic, seek: %s, serverTime: %s, interval: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      return localList;
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        localReqMediaOperation = new aio_media.ReqMediaOperation();
        localReqMediaOperation.enum_aio_type.set(paramInt1);
        localReqMediaOperation.uint64_id.set(Long.valueOf(paramString).longValue());
        localReqMediaOperation.enum_operation.set(paramInt2);
        if (paramInt2 != 4) {
          continue;
        }
        localReqMediaOperation.enum_play_mode.set(paramInt3);
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
        aio_media.ReqMediaOperation localReqMediaOperation;
        QLog.d("ListenTogether.handler", 1, "getSongExtendedInfo, exception", localNumberFormatException);
        if (paramInt2 != 1) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.c(false, paramInt1, paramString);
        continue;
        if ((paramInt2 != 2) || (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager == null)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, paramInt1, paramString);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("reqMediaOperator, sessionType: %s, uin: %s, operatorType: %s opValue: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      return;
      if (paramInt2 == 3) {
        localReqMediaOperation.enum_cut_type.set(paramInt3);
      }
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
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, String.format("reqRoomOperation, sessionType: %s, uin: %s, operatorType: %s, by: %d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.d("ListenTogether.handler", 1, "reqRoomOperation, exception", localNumberFormatException);
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null) {
          if (paramInt2 == 1) {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new ListenTogetherSession(paramInt1, paramString), paramInt3);
          } else if ((paramInt2 == 2) || (paramInt2 == 3)) {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, new ListenTogetherSession(paramInt1, paramString), paramInt2, true);
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    String str;
    if (paramToServiceMsg != null)
    {
      i = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
      if (paramToServiceMsg == null) {
        break label123;
      }
      str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      label30:
      if (paramToServiceMsg == null) {
        break label131;
      }
    }
    label131:
    for (int j = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");; j = -1)
    {
      if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null)) {
        break label137;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null)
      {
        paramFromServiceMsg = null;
        paramToServiceMsg = paramFromServiceMsg;
        if (!TextUtils.isEmpty(str))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i != -1) {
            paramToServiceMsg = new ListenTogetherSession(i, str);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, paramToServiceMsg, -1);
      }
      QLog.d("ListenTogether.handler", 1, "handleGetPlayingState, req == null || resp == null || data == null");
      return;
      i = -1;
      break;
      label123:
      str = "";
      break label30;
    }
    label137:
    long l1 = System.currentTimeMillis();
    if (paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null) {
      l1 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
    }
    bool3 = false;
    boolean bool2 = false;
    ListenTogetherSession localListenTogetherSession = new ListenTogetherSession(i, str);
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (!localListenTogetherSession.a()) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramToServiceMsg = new aio_media.RspLatestPlayingState();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
          if (paramFromServiceMsg != null)
          {
            k = paramFromServiceMsg.uint32_result.get();
            if (k != 0) {
              continue;
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int k;
          long l2;
          int m;
          bool1 = bool3;
          QLog.d("ListenTogether.handler", 1, "handleGetPlayingState exception", paramToServiceMsg);
          continue;
        }
        try
        {
          if (paramToServiceMsg.enum_media_type.get() != 1) {
            break;
          }
          l2 = paramFromServiceMsg.uint64_svr_time.get();
          localListenTogetherSession.h = paramToServiceMsg.enum_aio_state.get();
          localListenTogetherSession.jdField_a_of_type_JavaUtilList = a((aio_media.TypeMusic)paramToServiceMsg.msg_music.get(), l2, l1);
          localListenTogetherSession.jdField_c_of_type_Boolean = ((aio_media.TypeMusic)paramToServiceMsg.msg_music.get()).bool_allow_member_start.get();
          localListenTogetherSession.jdField_d_of_type_Boolean = ((aio_media.TypeMusic)paramToServiceMsg.msg_music.get()).bool_allow_member_add.get();
          localListenTogetherSession.jdField_c_of_type_Int = ((aio_media.TypeMusic)paramToServiceMsg.msg_music.get()).enum_play_mode.get();
          localListenTogetherSession.jdField_c_of_type_Long = l2;
          localListenTogetherSession.f = String.valueOf(paramToServiceMsg.uint64_create_uin.get());
          if (!TextUtils.isEmpty(localListenTogetherSession.f)) {
            localListenTogetherSession.g = ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, i, localListenTogetherSession.f);
          }
          localListenTogetherSession.i = paramToServiceMsg.enum_user_state.get();
          localListenTogetherSession.jdField_b_of_type_Int = paramToServiceMsg.msg_personal_setting.uint32_theme_id.get();
          k = 0;
          m = 0;
          if (i == 1)
          {
            k = paramToServiceMsg.uint32_joined_num.get();
            i = m;
            localListenTogetherSession.jdField_a_of_type_JavaLangString = localListenTogetherSession.a(k, i);
            localListenTogetherSession.jdField_a_of_type_Int = paramToServiceMsg.enum_joined_aio_type.get();
            localListenTogetherSession.jdField_b_of_type_JavaLangString = String.valueOf(paramToServiceMsg.uint64_joined_id.get());
            localListenTogetherSession.jdField_b_of_type_Boolean = paramToServiceMsg.bool_joined_is_creater.get();
            localListenTogetherSession.jdField_d_of_type_Long = paramToServiceMsg.uint64_aio_identification.get();
            bool1 = true;
            if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(bool1, localListenTogetherSession, j);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ListenTogether.handler", 2, String.format("handleGetPlayingState, isSuccess: %s, session: %s, by: %s", new Object[] { Boolean.valueOf(bool1), localListenTogetherSession, Integer.valueOf(j) }));
            return;
            k = -1;
            continue;
          }
          if (paramToServiceMsg.enum_c2c_join_state.has())
          {
            i = paramToServiceMsg.enum_c2c_join_state.get();
          }
          else
          {
            i = -1;
            continue;
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.bytes_errmsg.get() == null)) {
              break label732;
            }
            paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
          }
        }
        catch (Exception paramToServiceMsg)
        {
          bool1 = true;
          continue;
          paramToServiceMsg = "";
        }
      }
      QLog.d("ListenTogether.handler", 1, String.format("handleGetPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(k), paramToServiceMsg }));
      bool1 = false;
    }
  }
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +55 -> 56
    //   4: aload_1
    //   5: getfield 245	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   8: ldc_w 524
    //   11: invokevirtual 528	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   14: istore 8
    //   16: aload_1
    //   17: ifnull +11 -> 28
    //   20: aload_2
    //   21: ifnull +7 -> 28
    //   24: aload_3
    //   25: ifnonnull +37 -> 62
    //   28: aload_0
    //   29: getfield 30	com/tencent/mobileqq/listentogether/ListenTogetherHandler:jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager	Lcom/tencent/mobileqq/listentogether/ListenTogetherManager;
    //   32: ifnull +14 -> 46
    //   35: aload_0
    //   36: getfield 30	com/tencent/mobileqq/listentogether/ListenTogetherHandler:jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager	Lcom/tencent/mobileqq/listentogether/ListenTogetherManager;
    //   39: iconst_0
    //   40: aconst_null
    //   41: iload 8
    //   43: invokevirtual 531	com/tencent/mobileqq/listentogether/ListenTogetherManager:a	(ZLjava/util/List;Z)V
    //   46: ldc 55
    //   48: iconst_1
    //   49: ldc_w 533
    //   52: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: return
    //   56: iconst_0
    //   57: istore 8
    //   59: goto -43 -> 16
    //   62: iconst_0
    //   63: istore 7
    //   65: aload_1
    //   66: getfield 245	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   69: ldc 247
    //   71: invokevirtual 330	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   74: istore 6
    //   76: aload_1
    //   77: getfield 245	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   80: ldc 255
    //   82: invokevirtual 334	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 12
    //   87: aconst_null
    //   88: astore 11
    //   90: aconst_null
    //   91: astore 10
    //   93: iconst_m1
    //   94: istore 4
    //   96: aload 10
    //   98: astore 9
    //   100: iload 4
    //   102: istore 5
    //   104: aload_2
    //   105: invokevirtual 357	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   108: ifeq +383 -> 491
    //   111: aload 10
    //   113: astore 9
    //   115: iload 4
    //   117: istore 5
    //   119: new 535	tencent/aio/media/aio_media$RspSongExtendedInfo
    //   122: dup
    //   123: invokespecial 536	tencent/aio/media/aio_media$RspSongExtendedInfo:<init>	()V
    //   126: astore_2
    //   127: aload 10
    //   129: astore 9
    //   131: iload 4
    //   133: istore 5
    //   135: aload_2
    //   136: aload_3
    //   137: checkcast 364	[B
    //   140: checkcast 364	[B
    //   143: invokevirtual 537	tencent/aio/media/aio_media$RspSongExtendedInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   146: pop
    //   147: aload 10
    //   149: astore 9
    //   151: iload 4
    //   153: istore 5
    //   155: aload_2
    //   156: getfield 538	tencent/aio/media/aio_media$RspSongExtendedInfo:msg_result	Ltencent/aio/media/aio_media$ResultInfo;
    //   159: invokevirtual 377	tencent/aio/media/aio_media$ResultInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   162: checkcast 374	tencent/aio/media/aio_media$ResultInfo
    //   165: astore_3
    //   166: aload_3
    //   167: ifnull +309 -> 476
    //   170: aload 10
    //   172: astore 9
    //   174: iload 4
    //   176: istore 5
    //   178: aload_3
    //   179: getfield 381	tencent/aio/media/aio_media$ResultInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   182: invokevirtual 384	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   185: istore 4
    //   187: iload 4
    //   189: ifne +343 -> 532
    //   192: aload 10
    //   194: astore 9
    //   196: iload 4
    //   198: istore 5
    //   200: aload_2
    //   201: getfield 539	tencent/aio/media/aio_media$RspSongExtendedInfo:rpt_msg_song_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   204: invokevirtual 148	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   207: invokestatic 150	com/tencent/mobileqq/listentogether/ListenTogetherHandler:a	(Ljava/util/List;)Ljava/util/List;
    //   210: astore_2
    //   211: aload_2
    //   212: ifnull +14 -> 226
    //   215: aload_2
    //   216: astore_3
    //   217: aload_2
    //   218: invokeinterface 111 1 0
    //   223: ifne +259 -> 482
    //   226: new 102	java/util/ArrayList
    //   229: dup
    //   230: invokespecial 105	java/util/ArrayList:<init>	()V
    //   233: astore_3
    //   234: aload_3
    //   235: astore 9
    //   237: iload 4
    //   239: istore 5
    //   241: aload_1
    //   242: getfield 245	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   245: ldc_w 541
    //   248: invokevirtual 545	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +229 -> 482
    //   256: aload_3
    //   257: astore 9
    //   259: iload 4
    //   261: istore 5
    //   263: aload_1
    //   264: invokeinterface 549 1 0
    //   269: astore_1
    //   270: aload_3
    //   271: astore 9
    //   273: iload 4
    //   275: istore 5
    //   277: aload_1
    //   278: invokeinterface 554 1 0
    //   283: ifeq +199 -> 482
    //   286: aload_3
    //   287: astore 9
    //   289: iload 4
    //   291: istore 5
    //   293: aload_1
    //   294: invokeinterface 558 1 0
    //   299: checkcast 72	java/lang/String
    //   302: astore_2
    //   303: aload_3
    //   304: astore 9
    //   306: iload 4
    //   308: istore 5
    //   310: new 119	com/tencent/mobileqq/listentogether/data/MusicInfo
    //   313: dup
    //   314: invokespecial 559	com/tencent/mobileqq/listentogether/data/MusicInfo:<init>	()V
    //   317: astore 10
    //   319: aload_3
    //   320: astore 9
    //   322: iload 4
    //   324: istore 5
    //   326: aload 10
    //   328: aload_2
    //   329: putfield 560	com/tencent/mobileqq/listentogether/data/MusicInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   332: aload_3
    //   333: astore 9
    //   335: iload 4
    //   337: istore 5
    //   339: aload_3
    //   340: aload 10
    //   342: invokeinterface 126 2 0
    //   347: pop
    //   348: aload_3
    //   349: astore 9
    //   351: iload 4
    //   353: istore 5
    //   355: ldc 55
    //   357: iconst_1
    //   358: new 159	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 562
    //   368: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_2
    //   372: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: goto -111 -> 270
    //   384: astore_1
    //   385: iload 5
    //   387: istore 4
    //   389: ldc 55
    //   391: iconst_1
    //   392: ldc_w 564
    //   395: aload_1
    //   396: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +53 -> 455
    //   405: ldc 55
    //   407: iconst_2
    //   408: ldc_w 566
    //   411: iconst_5
    //   412: anewarray 59	java/lang/Object
    //   415: dup
    //   416: iconst_0
    //   417: iload 6
    //   419: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: dup
    //   424: iconst_1
    //   425: aload 12
    //   427: aastore
    //   428: dup
    //   429: iconst_2
    //   430: iload 7
    //   432: invokestatic 498	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   435: aastore
    //   436: dup
    //   437: iconst_3
    //   438: iload 4
    //   440: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   443: aastore
    //   444: dup
    //   445: iconst_4
    //   446: aload 9
    //   448: aastore
    //   449: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   452: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: aload_0
    //   456: getfield 30	com/tencent/mobileqq/listentogether/ListenTogetherHandler:jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager	Lcom/tencent/mobileqq/listentogether/ListenTogetherManager;
    //   459: ifnull -404 -> 55
    //   462: aload_0
    //   463: getfield 30	com/tencent/mobileqq/listentogether/ListenTogetherHandler:jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager	Lcom/tencent/mobileqq/listentogether/ListenTogetherManager;
    //   466: iload 7
    //   468: aload 9
    //   470: iload 8
    //   472: invokevirtual 531	com/tencent/mobileqq/listentogether/ListenTogetherManager:a	(ZLjava/util/List;Z)V
    //   475: return
    //   476: iconst_m1
    //   477: istore 4
    //   479: goto -292 -> 187
    //   482: iconst_1
    //   483: istore 7
    //   485: aload_3
    //   486: astore 9
    //   488: goto -89 -> 399
    //   491: aload 10
    //   493: astore 9
    //   495: iload 4
    //   497: istore 5
    //   499: ldc 55
    //   501: iconst_1
    //   502: ldc_w 568
    //   505: iconst_0
    //   506: anewarray 59	java/lang/Object
    //   509: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   512: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iconst_m1
    //   516: istore 4
    //   518: aload 11
    //   520: astore 9
    //   522: goto -123 -> 399
    //   525: astore_1
    //   526: aload_2
    //   527: astore 9
    //   529: goto -140 -> 389
    //   532: aconst_null
    //   533: astore_3
    //   534: iconst_0
    //   535: istore 7
    //   537: goto -52 -> 485
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	ListenTogetherHandler
    //   0	540	1	paramToServiceMsg	ToServiceMsg
    //   0	540	2	paramFromServiceMsg	FromServiceMsg
    //   0	540	3	paramObject	Object
    //   94	423	4	i	int
    //   102	396	5	j	int
    //   74	344	6	k	int
    //   63	473	7	bool1	boolean
    //   14	457	8	bool2	boolean
    //   98	430	9	localObject1	Object
    //   91	401	10	localMusicInfo	MusicInfo
    //   88	431	11	localObject2	Object
    //   85	341	12	str	String
    // Exception table:
    //   from	to	target	type
    //   104	111	384	java/lang/Exception
    //   119	127	384	java/lang/Exception
    //   135	147	384	java/lang/Exception
    //   155	166	384	java/lang/Exception
    //   178	187	384	java/lang/Exception
    //   200	211	384	java/lang/Exception
    //   241	252	384	java/lang/Exception
    //   263	270	384	java/lang/Exception
    //   277	286	384	java/lang/Exception
    //   293	303	384	java/lang/Exception
    //   310	319	384	java/lang/Exception
    //   326	332	384	java/lang/Exception
    //   339	348	384	java/lang/Exception
    //   355	381	384	java/lang/Exception
    //   499	515	384	java/lang/Exception
    //   217	226	525	java/lang/Exception
    //   226	234	525	java/lang/Exception
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    j = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
    str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
    k = paramToServiceMsg.extraData.getInt("KEY_OPERATOR");
    m = paramToServiceMsg.extraData.getInt("KEY_OPVALUE");
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null)
      {
        if (k != 1) {
          break label89;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.c(false, j, str);
      }
      for (;;)
      {
        QLog.d("ListenTogether.handler", 1, "handleMediaOperation, req == null || resp == null || data == null");
        return;
        label89:
        if (k == 2) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, j, str);
        } else if (k == 3) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.d(false, j, str);
        } else if (k == 4) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, j, str, m);
        }
      }
    }
    bool = false;
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        paramToServiceMsg = new aio_media.RspMediaOperation();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        if (paramToServiceMsg == null) {
          continue;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (i != 0) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        QLog.d("ListenTogether.handler", 1, String.format("handleMediaOperation exception, sessionType: %s, uin: %s, operatorType: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(j), str, Integer.valueOf(k) }), paramToServiceMsg);
        continue;
        if (k != 2) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(bool, j, str);
        continue;
        if (k != 3) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.d(bool, j, str);
        continue;
        if (k != 4) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(bool, j, str, m);
        continue;
        bool = false;
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null)
      {
        if (k != 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.c(bool, j, str);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ListenTogether.handler", 2, String.format("handleMediaOperation, result: %s, sessionType: %s, uin: %s, operatorType: %s, opValue: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), str, Integer.valueOf(k), Integer.valueOf(m) }));
      return;
      i = -1;
      continue;
      QLog.d("ListenTogether.handler", 1, String.format("handleMediaOperation, rsp fail, sessionType: %s, uin: %s, operatorType: %s", new Object[] { Integer.valueOf(j), str, Integer.valueOf(k) }));
      i = -1;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j;
    label30:
    label46:
    int k;
    if (paramToServiceMsg != null)
    {
      j = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
      if (paramToServiceMsg == null) {
        break label137;
      }
      localObject = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      if (paramToServiceMsg == null) {
        break label145;
      }
      i = paramToServiceMsg.extraData.getInt("KEY_OPERATOR");
      if (paramToServiceMsg == null) {
        break label151;
      }
      k = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
      label62:
      if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null)) {
        break label182;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null)
      {
        paramFromServiceMsg = null;
        paramToServiceMsg = paramFromServiceMsg;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (j != -1) {
            paramToServiceMsg = new ListenTogetherSession(j, (String)localObject);
          }
        }
        if (i != 1) {
          break label157;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, paramToServiceMsg, k);
      }
    }
    label137:
    label145:
    label151:
    label157:
    while ((i != 2) && (i != 3))
    {
      return;
      j = -1;
      break;
      localObject = "";
      break label30;
      i = -1;
      break label46;
      k = -1;
      break label62;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, paramToServiceMsg, i, true);
    return;
    label182:
    bool2 = false;
    localObject = new ListenTogetherSession(j, (String)localObject);
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (!((ListenTogetherSession)localObject).a()) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new aio_media.RspRoomOperation();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        if (paramToServiceMsg == null) {
          continue;
        }
        j = paramToServiceMsg.uint32_result.get();
        if (j != 0) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("ListenTogether.handler", 1, "handleReqRoomOperation exception", paramToServiceMsg);
        bool1 = bool2;
        continue;
        if ((i != 2) && (i != 3)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(bool1, (ListenTogetherSession)localObject, i, true);
        continue;
        paramToServiceMsg = "";
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null)
      {
        if (i != 1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(bool1, (ListenTogetherSession)localObject, k);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ListenTogether.handler", 2, String.format("handleReqRoomOperation, isSuccess: %s, session: %s, operationType: %s", new Object[] { Boolean.valueOf(bool1), localObject, Integer.valueOf(i) }));
      return;
      j = -1;
      continue;
      if ((paramToServiceMsg == null) || (paramToServiceMsg.bytes_errmsg.get() == null)) {
        continue;
      }
      paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
      QLog.d("ListenTogether.handler", 1, String.format("handleReqRoomOperation, result = %s, errTips = %s", new Object[] { Integer.valueOf(j), paramToServiceMsg }));
      bool1 = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    if (paramToServiceMsg != null)
    {
      str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null)) {
        break label60;
      }
      if (!TextUtils.isEmpty(str)) {
        notifyUI(17, false, new Object[] { str });
      }
    }
    label402:
    for (;;)
    {
      return;
      str = "";
      break;
      label60:
      bool1 = false;
      bool2 = false;
      i = 0;
      int k = 0;
      j = 0;
      paramToServiceMsg = null;
      localObject = null;
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        paramToServiceMsg = new aio_media.RspSongPlayShowInfo();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        if (paramFromServiceMsg != null)
        {
          i = paramFromServiceMsg.uint32_result.get();
          if (i != 0) {
            break label320;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          label220:
          i = j;
          label314:
          label320:
          label345:
          paramFromServiceMsg = localObject;
          bool1 = bool2;
        }
      }
      try
      {
        i = paramToServiceMsg.uint32_join_num.get();
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = true;
        i = j;
        paramFromServiceMsg = localObject;
        break label220;
      }
      try
      {
        paramFromServiceMsg = paramToServiceMsg.rpt_uint64_join_uins.get();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
          break label450;
        }
        paramToServiceMsg = new ArrayList();
        try
        {
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          while (paramFromServiceMsg.hasNext()) {
            paramToServiceMsg.add(String.valueOf((Long)paramFromServiceMsg.next()));
          }
          QLog.d("ListenTogether.handler", 1, "handleGetGroupJoinedUsers exception", paramToServiceMsg);
        }
        catch (Exception paramObject)
        {
          bool1 = true;
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = true;
        paramFromServiceMsg = localObject;
        break label220;
        paramToServiceMsg = "";
        break label345;
        paramToServiceMsg = null;
        break label314;
      }
      paramToServiceMsg = paramFromServiceMsg;
      if (bool1) {
        notifyUI(17, true, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label402;
        }
        QLog.d("ListenTogether.handler", 2, String.format("handleGetGroupJoinedUsers, isSuccess: %s, joinedNum: %s, joinedUinList: %s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), paramToServiceMsg }));
        return;
        i = -1;
        break;
        bool1 = true;
        for (;;)
        {
          break;
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.bytes_errmsg.get() == null)) {
            break label443;
          }
          paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
          QLog.d("ListenTogether.handler", 1, String.format("handleGetGroupJoinedUsers, result = %s, errTips = %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
          paramToServiceMsg = null;
          bool1 = false;
          i = k;
        }
        notifyUI(17, false, new Object[] { str });
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, new Object[] { Integer.valueOf(-1), "" });
      return;
    }
    paramToServiceMsg = new aio_media.RspReportDownloadFail();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        if (paramToServiceMsg != null)
        {
          i = paramToServiceMsg.uint32_result.get();
          if (paramToServiceMsg == null) {
            break label144;
          }
          paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
          if (i != 0) {
            break label151;
          }
          bool = true;
          paramFromServiceMsg.a(bool, new Object[] { Integer.valueOf(i), paramToServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      int i = -1;
      continue;
      label144:
      paramToServiceMsg = "";
      continue;
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
    String str1 = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN", "");
    int m = paramToServiceMsg.extraData.getInt("KEY_FROM", -1);
    String str2 = paramToServiceMsg.extraData.getString("KEY_SONG_ID", "");
    boolean bool1 = false;
    int j = 0;
    int i;
    boolean bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new aio_media.RspCreateRoom();
      i = j;
      bool2 = bool1;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = j;
        bool2 = bool1;
        paramToServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        i = j;
        bool2 = bool1;
        j = paramToServiceMsg.uint32_result.get();
        if (j != 0) {
          break label269;
        }
        bool1 = true;
        if (bool1) {
          break label297;
        }
        i = j;
        bool2 = bool1;
        paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.d("ListenTogether.handler", 1, "handleReqCreateRoom ex", paramToServiceMsg);
          bool1 = bool2;
          paramToServiceMsg = "";
          continue;
          paramToServiceMsg = "";
        }
      }
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.handler", 2, String.format("handleReqCreateRoom sessionType=%d uin=%s from=%d songId=%s res=%d wording=%s", new Object[] { Integer.valueOf(k), MobileQQ.getShortUinStr(str1), Integer.valueOf(m), str2, Integer.valueOf(i), paramToServiceMsg }));
      }
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool1, k, str1, paramToServiceMsg, m, str2);
      return;
      label269:
      bool1 = false;
      break;
      label297:
      i = 0;
      paramToServiceMsg = "";
      bool1 = false;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) != 1) {
      return;
    }
    int n = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE", -1);
    String str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN", "");
    long l = paramToServiceMsg.extraData.getLong("KEY_TS", 0L);
    int i = -1;
    int m = 0;
    int k;
    int j;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new CmdAIOMediaHeartbeatRsp();
      k = m;
      j = i;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        k = m;
        j = i;
        paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        k = m;
        j = i;
        m = paramToServiceMsg.interval.get();
        if (paramFromServiceMsg == null) {
          continue;
        }
        k = m;
        j = i;
        i = paramFromServiceMsg.uint32_result.get();
        if (paramFromServiceMsg == null) {
          continue;
        }
        k = m;
        j = i;
        paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();
        j = i;
        i = m;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = k;
        QLog.d("ListenTogether.handler", 1, "handleReqHeartBeat ex", paramToServiceMsg);
        paramToServiceMsg = "";
        continue;
        notifyUI(24, false, new Object[] { Integer.valueOf(n), str, Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.handler", 2, String.format("handleReqHeartBeat interval=%d errCode=%d errWording=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg }));
      }
      if (j == 0)
      {
        notifyUI(24, true, new Object[] { Integer.valueOf(n), str, Long.valueOf(l), Integer.valueOf(i) });
        return;
        i = -1;
        continue;
        paramToServiceMsg = "";
      }
      else
      {
        i = 0;
        paramToServiceMsg = "";
        j = -1;
      }
    }
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
    do
    {
      aio_media.ReqReportDownloadFail localReqReportDownloadFail;
      try
      {
        localReqReportDownloadFail = new aio_media.ReqReportDownloadFail();
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
      }
      catch (NumberFormatException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.report_download_fail");
      paramString2.extraData.putString("uin", paramString1);
      paramString2.extraData.putInt("uintype", paramInt);
      paramString2.putWupBuffer(localReqReportDownloadFail.toByteArray());
      sendPbReq(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("ListenTogether.handler", 2, "checkAndShowAioShareMusic()-> request = " + paramString2.toString());
  }
  
  public void a(int paramInt, String paramString, List<MusicExtendedReqParam> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null, paramBoolean);
      }
      QLog.d("ListenTogether.handler", 1, String.format("getSongExtendedInfo, sessionType = %s, uin = %s, musicReaList is empty!", new Object[] { Integer.valueOf(paramInt), paramString }));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.handler", 2, String.format("getSongExtendedInfo, sessionType: %s, uin: %s, musicList: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramList }));
    }
    ArrayList localArrayList1;
    aio_media.ReqSongExtendedInfo localReqSongExtendedInfo;
    try
    {
      localArrayList1 = new ArrayList();
      localReqSongExtendedInfo = new aio_media.ReqSongExtendedInfo();
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
    }
    catch (NumberFormatException paramString)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null, paramBoolean);
      }
      QLog.d("ListenTogether.handler", 1, "getSongExtendedInfo, exception", paramString);
      return;
    }
    paramList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.get_song_extended_info");
    paramList.extraData.putInt("KEY_SESSION_TYPE", paramInt);
    paramList.extraData.putString("KEY_SESSION_UIN", paramString);
    paramList.extraData.putBoolean("KEY_REQ_LYRIC", paramBoolean);
    paramList.extraData.putStringArrayList("KEY_REQ_MUSIC_ID_LIST", localArrayList1);
    paramList.putWupBuffer(localReqSongExtendedInfo.toByteArray());
    paramList.setTimeout(30000L);
    sendPbReq(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    int i;
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess())
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
          return;
        }
        paramToServiceMsg = new aio_media.RspShareTransCheck();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (aio_media.ResultInfo)paramToServiceMsg.msg_result.get();
        if (paramFromServiceMsg != null)
        {
          i = paramFromServiceMsg.uint32_result.get();
          if (i != 0) {
            break;
          }
          paramFromServiceMsg = new JSONObject();
          paramFromServiceMsg.put("isSuccess", true);
          paramFromServiceMsg.put("enum_aio_state", paramToServiceMsg.enum_aio_state.get());
          paramFromServiceMsg.put("enum_media_type", paramToServiceMsg.enum_media_type.get());
          paramFromServiceMsg.put("bool_show_icon", paramToServiceMsg.bool_show_icon.get());
          paramFromServiceMsg.put("str_song_id", paramToServiceMsg.str_song_id.get());
          paramFromServiceMsg.put("uint32_duration", paramToServiceMsg.uint32_duration.get());
          paramFromServiceMsg.put("uint64_create_uin", paramToServiceMsg.uint64_create_uin.get());
          paramFromServiceMsg.put("bool_song_existed", paramToServiceMsg.bool_song_existed.get());
          paramFromServiceMsg.put("bool_allow_member_start", paramToServiceMsg.bool_allow_member_start.get());
          paramFromServiceMsg.put("bool_allow_member_add", paramToServiceMsg.bool_allow_member_add.get());
          if (!TextUtils.isEmpty(QQMusicPlayService.b())) {
            break label271;
          }
          paramToServiceMsg = "";
          paramFromServiceMsg.put("current_song_id", paramToServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(true, paramFromServiceMsg);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
        return;
      }
      i = -1;
      continue;
      label271:
      paramToServiceMsg = QQMusicPlayService.b();
    }
    if (QLog.isColorLevel()) {
      if (paramFromServiceMsg == null) {
        break label347;
      }
    }
    label347:
    for (paramToServiceMsg = paramFromServiceMsg.bytes_errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      QLog.d("AioShareMusicListenTogether.handler", 2, "handleCheckAndShowAioShareMusic() result = " + i + " errMsg = " + paramToServiceMsg);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
      return;
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, " checkAndShowAioShareMusic（） jsonObject = " + paramJSONObject);
      }
      int j = paramJSONObject.getInt("enum_aio_type");
      String str1 = paramJSONObject.getString("uint64_id");
      int i = paramJSONObject.getInt("uint32_share_appid");
      Object localObject = paramJSONObject.getString("bytes_song_name");
      String str2 = paramJSONObject.getString("bytes_song_url");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rpt_bytes_singer");
      paramJSONObject = new aio_media.ReqShareTransCheck();
      paramJSONObject.enum_aio_type.set(j);
      paramJSONObject.uint64_id.set(Long.parseLong(str1));
      paramJSONObject.uint32_share_appid.set(i);
      paramJSONObject.bytes_song_name.set(ByteStringMicro.copyFromUtf8((String)localObject));
      paramJSONObject.bytes_song_url.set(ByteStringMicro.copyFromUtf8(str2));
      localObject = new ArrayList();
      i = 0;
      while (i < localJSONArray.length())
      {
        ((List)localObject).add(ByteStringMicro.copyFromUtf8(localJSONArray.getJSONObject(i).getString("singer")));
        i += 1;
      }
      paramJSONObject.rpt_bytes_singer.set((List)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQAIOMediaSvc.share_trans_check");
      ((ToServiceMsg)localObject).extraData.putString("uin", str1);
      ((ToServiceMsg)localObject).extraData.putInt("uintype", j);
      ((ToServiceMsg)localObject).putWupBuffer(paramJSONObject.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false, null);
    }
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
    int i;
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess())
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(-1), "" });
          return;
        }
        aio_media.RspShareTrans localRspShareTrans = new aio_media.RspShareTrans();
        localRspShareTrans.mergeFrom((byte[])paramObject);
        int j = paramToServiceMsg.extraData.getInt("uintype");
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
        paramObject = paramToServiceMsg.extraData.getString("aio_share_song_id");
        paramToServiceMsg = (aio_media.ResultInfo)localRspShareTrans.msg_result.get();
        if (paramToServiceMsg != null)
        {
          i = paramToServiceMsg.uint32_result.get();
          if (paramToServiceMsg == null) {
            break label200;
          }
          paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
          if (i != 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(true, new Object[] { Integer.valueOf(j), paramFromServiceMsg, paramObject });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(-1), "" });
        return;
      }
      i = -1;
      continue;
      label200:
      paramToServiceMsg = "";
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(i), paramToServiceMsg });
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
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.handler", 2, " startAioShareMusic（） jsonStr = " + paramJSONObject.toString());
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
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b(false, new Object[] { Integer.valueOf(-1), "" });
    }
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return ListenTogetherObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        return;
        if (!"QQAIOMediaSvc.get_latest_playing_state".equals(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
      } while (1 != paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE"));
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
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
    } while (!"QQAIOMediaSvc.heartbeat".equals(paramFromServiceMsg.getServiceCmd()));
    j(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHandler
 * JD-Core Version:    0.7.0.1
 */