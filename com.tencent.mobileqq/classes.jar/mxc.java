import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.oidb.cmd0xe37.cmd0xe37.Req0xe37;
import tencent.im.oidb.cmd0xe37.cmd0xe37.Resp0xe37;
import trpc.qq_av_together.common.WTogetherCommon.Result;
import trpc.qq_av_together.common.WTogetherCommon.RoomInfo;
import trpc.qq_av_together.common.WTogetherCommon.RoomUserInfo;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoFileReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoFileRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoStatusReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoStatusRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdCloseAvTogetherReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdCloseAvTogetherRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdGetRoomInfoReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdGetRoomInfoRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdStartAvTogetherReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdStartAvTogetherRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdSyncPlayTimeReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdSyncPlayTimeRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserEnterRoomReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserEnterRoomRsp;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserQuitRoomReq;
import trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserQuitRoomRsp;

public class mxc
  extends BusinessHandler
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "OidbSvc.0xe37_1200", "QQRTCSvc.RoomManager-StartAvTogether", "QQRTCSvc.RoomManager-CloseAvTogether", "QQRTCSvc.RoomManager-GetRoomInfo", "QQRTCSvc.RoomManager-ChangeVideoStatus", "QQRTCSvc.RoomManager-ChangeVideoFile", "QQRTCSvc.RoomManager-SyncPlayTime", "QQRTCSvc.RoomManager-UserQuitRoom", "QQRTCSvc.RoomManager-UserEnterRoom" };
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public mxc(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    WTFileInfo localWTFileInfo = (WTFileInfo)paramToServiceMsg.extraData.getParcelable("fileInfo");
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("seq");
    int k = paramToServiceMsg.extraData.getInt("retryCnt");
    boolean bool = paramToServiceMsg.extraData.getBoolean("needHttpsUrl");
    paramToServiceMsg = new cmd0xe37.Resp0xe37();
    if ((paramObject instanceof byte[])) {
      parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    }
    if (paramToServiceMsg.bytes_cmd_0x346_rsp_body.has()) {}
    for (paramToServiceMsg = paramToServiceMsg.bytes_cmd_0x346_rsp_body.get().toByteArray();; paramToServiceMsg = null)
    {
      paramObject = new mys(i, l, j, localWTFileInfo, k, bool);
      nad.a(paramFromServiceMsg.getResultCode(), paramToServiceMsg, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), paramObject);
      if ((paramObject.b) && (k < 3) && (k >= 0)) {
        a(i, l, j, localWTFileInfo, bool, k);
      }
      do
      {
        return;
        paramToServiceMsg = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.a(paramObject);
        }
        notifyUI(1, paramObject.c, paramObject);
      } while (!QLog.isDevelopLevel());
      QLog.i("WTogether.Handler", 4, "handleRequestUrlRsp, result[" + paramObject + "]");
      return;
    }
  }
  
  public static String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    ChooseFileInfo localChooseFileInfo = (ChooseFileInfo)paramToServiceMsg.extraData.getParcelable("qav_together_choose_file");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("qav_together_uin_array");
    myo localmyo = new myo(i, l);
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = localObject;
      if ((paramObject instanceof byte[])) {
        paramFromServiceMsg = new WTogetherRoomMng.CmdStartAvTogetherRsp();
      }
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localmyo.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      paramToServiceMsg = localObject;
      if (paramFromServiceMsg.room_info.has()) {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
      paramFromServiceMsg = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      if ((!localmyo.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(localmyo, 0L, 6)))
      {
        a(i, l, localChooseFileInfo, arrayOfLong, j);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      do
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("WTogether.Handler", 4, "handleStartWTogether, error", paramToServiceMsg);
          }
        }
        if ((localmyo.a) && (paramToServiceMsg == null))
        {
          localmyo.a = false;
          QLog.i("WTogether.Handler", 1, "handleStartWTogether, room info is null.");
        }
        paramFromServiceMsg.a(localmyo, localChooseFileInfo, paramToServiceMsg);
        notifyUI(2, localmyo.a, localmyo);
      } while (!QLog.isDevelopLevel());
      QLog.i("WTogether.Handler", 4, "handleStartWTogether, result[" + localmyo + "]");
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    paramToServiceMsg = new myo(i, l);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[]))) {
      paramFromServiceMsg = new WTogetherRoomMng.CmdCloseAvTogetherRsp();
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      if (paramToServiceMsg.jdField_b_of_type_Int == 1009) {
        paramToServiceMsg.a = true;
      }
      paramFromServiceMsg = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      if ((!paramToServiceMsg.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(paramToServiceMsg, 0L, 7)))
      {
        a(i, l, j);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      do
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("WTogether.Handler", 4, "handleCloseWTogether, error", paramObject);
          }
        }
        paramFromServiceMsg.a(paramToServiceMsg);
        notifyUI(3, paramToServiceMsg.a, paramToServiceMsg);
      } while (!QLog.isDevelopLevel());
      QLog.i("WTogether.Handler", 4, "handleCloseWTogether, result[" + paramToServiceMsg + "]");
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    myo localmyo = new myo(paramToServiceMsg.extraData.getInt("qav_together_from"), paramToServiceMsg.extraData.getLong("qav_together_room_id"), (ReqVideoAction)paramToServiceMsg.extraData.getParcelable("qav_together_action"));
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = localObject;
      if ((paramObject instanceof byte[])) {
        paramFromServiceMsg = new WTogetherRoomMng.CmdGetRoomInfoRsp();
      }
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localmyo.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      paramToServiceMsg = localObject;
      if (paramFromServiceMsg.room_info.has()) {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
      ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(localmyo, paramToServiceMsg);
      notifyUI(4, localmyo.a, localmyo);
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Handler", 4, "handleQueryRoomInfo, result[" + localmyo + "]");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleQueryRoomInfo, error", paramToServiceMsg);
        }
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    ReqVideoAction localReqVideoAction = (ReqVideoAction)paramToServiceMsg.extraData.getParcelable("qav_together_action");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    myo localmyo = new myo(i, l, localReqVideoAction);
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = localObject;
      if ((paramObject instanceof byte[])) {
        paramFromServiceMsg = new WTogetherRoomMng.CmdChangeVideoStatusRsp();
      }
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localmyo.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      paramToServiceMsg = localObject;
      if (paramFromServiceMsg.room_info.has()) {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
      paramFromServiceMsg = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      if ((!localmyo.a) && (j > 0) && (j < 3) && (localReqVideoAction != null) && (paramFromServiceMsg.a(localmyo, localReqVideoAction.jdField_a_of_type_Long, localReqVideoAction.jdField_a_of_type_Int)))
      {
        a(i, l, localReqVideoAction, j);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      do
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("WTogether.Handler", 4, "handleChangeVideoStatus, error", paramToServiceMsg);
          }
        }
        paramFromServiceMsg.a(localmyo, localReqVideoAction, paramToServiceMsg);
        notifyUI(5, localmyo.a, localmyo);
      } while (!QLog.isDevelopLevel());
      QLog.i("WTogether.Handler", 4, "handleChangeVideoStatus, result[" + localmyo + "]");
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    paramToServiceMsg.extraData.getLong("qav_together_seq");
    ChooseFileInfo localChooseFileInfo = (ChooseFileInfo)paramToServiceMsg.extraData.getParcelable("qav_together_choose_file");
    myo localmyo = new myo(i, l);
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = localObject;
      if ((paramObject instanceof byte[])) {
        paramFromServiceMsg = new WTogetherRoomMng.CmdChangeVideoFileRsp();
      }
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localmyo.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      paramToServiceMsg = localObject;
      if (paramFromServiceMsg.room_info.has()) {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
      ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).b(localmyo, localChooseFileInfo, paramToServiceMsg);
      notifyUI(6, localmyo.a, localmyo);
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Handler", 4, "handleChangeVideoFile, result[" + localmyo + "]");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleChangeVideoFile, error", paramToServiceMsg);
        }
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l1 = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    long l2 = paramToServiceMsg.extraData.getLong("qav_together_seq");
    myo localmyo = new myo(i, l1);
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = localObject;
      if ((paramObject instanceof byte[])) {
        paramFromServiceMsg = new WTogetherRoomMng.CmdSyncPlayTimeRsp();
      }
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localmyo.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      paramToServiceMsg = localObject;
      if (paramFromServiceMsg.room_info.has()) {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
      ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(localmyo, l2, paramToServiceMsg);
      notifyUI(7, localmyo.a, localmyo);
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Handler", 4, "handleSyncPlayInfo, result[" + localmyo + "]");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Handler", 4, "handleSyncPlayInfo, error", paramToServiceMsg);
        }
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    paramToServiceMsg = new myo(i, l);
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof byte[]))) {
      paramFromServiceMsg = new WTogetherRoomMng.CmdUserQuitRoomRsp();
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      if (paramFromServiceMsg.room_info.has()) {
        paramFromServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
      if (paramToServiceMsg.jdField_b_of_type_Int == 1009) {
        paramToServiceMsg.a = true;
      }
      paramFromServiceMsg = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      if ((!paramToServiceMsg.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(paramToServiceMsg, 0L, 10)))
      {
        b(i, l, j);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      do
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("WTogether.Handler", 4, "handleQuitRoom, error", paramObject);
          }
        }
        paramFromServiceMsg.b(paramToServiceMsg);
        notifyUI(8, paramToServiceMsg.a, paramToServiceMsg);
      } while (!QLog.isDevelopLevel());
      QLog.i("WTogether.Handler", 4, "handleQuitRoom, result[" + paramToServiceMsg + "]");
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("qav_together_from");
    long l = paramToServiceMsg.extraData.getLong("qav_together_room_id");
    int j = paramToServiceMsg.extraData.getInt("qav_together_try_count");
    myo localmyo = new myo(i, l);
    Object localObject = null;
    paramToServiceMsg = localObject;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = localObject;
      if ((paramObject instanceof byte[])) {
        paramFromServiceMsg = new WTogetherRoomMng.CmdUserEnterRoomRsp();
      }
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localmyo.a((WTogetherCommon.Result)paramFromServiceMsg.res.get());
      paramToServiceMsg = localObject;
      if (paramFromServiceMsg.room_info.has()) {
        paramToServiceMsg = (WTogetherCommon.RoomInfo)paramFromServiceMsg.room_info.get();
      }
      paramFromServiceMsg = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
      if ((!localmyo.a) && (j < 3) && (j > 0) && (paramFromServiceMsg.a(localmyo, 0L, 9)))
      {
        c(i, l, j);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      do
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("WTogether.Handler", 4, "handleEnterRoom, error", paramToServiceMsg);
          }
        }
        paramFromServiceMsg.b(localmyo, paramToServiceMsg);
        notifyUI(9, localmyo.a, localmyo);
      } while (!QLog.isDevelopLevel());
      QLog.i("WTogether.Handler", 4, "handleEnterRoom, result[" + localmyo + "], tryCnt[" + j + "]");
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    WTogetherRoomMng.CmdCloseAvTogetherReq localCmdCloseAvTogetherReq = new WTogetherRoomMng.CmdCloseAvTogetherReq();
    localCmdCloseAvTogetherReq.from.set(paramInt1);
    localCmdCloseAvTogetherReq.room_id.set(paramLong);
    localCmdCloseAvTogetherReq.client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-CloseAvTogether");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(localCmdCloseAvTogetherReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Handler", 4, "closeWTogether, from[" + paramInt1 + "], room[" + paramLong + "], tryCnt[" + paramInt2 + "]");
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, WTFileInfo paramWTFileInfo, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Handler", 4, "requestUrl, seq[" + paramInt2 + "], from[" + paramInt1 + "], roomId[" + paramLong + "], fileInfo[" + paramWTFileInfo + "], needHttpsUrl[" + paramBoolean + "], retryCnt[" + paramInt3 + "]");
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      label110:
      Object localObject2;
      Object localObject1;
      break label110;
    }
    localObject2 = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject2).uint64_uin.set(l1);
    ((cmd0x346.ApplyDownloadReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramWTFileInfo.b.getBytes()));
    if (paramBoolean) {
      ((cmd0x346.ApplyDownloadReq)localObject2).uint32_need_https_url.set(1);
    }
    if (!TextUtils.isEmpty(paramWTFileInfo.c)) {
      ((cmd0x346.ApplyDownloadReq)localObject2).str_fileid.set(paramWTFileInfo.c);
    }
    ((cmd0x346.ApplyDownloadReq)localObject2).uint32_owner_type.set(2);
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).uint32_flag_support_mediaplatform.set(1);
    ((cmd0x346.ReqBody)localObject1).msg_apply_download_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(1200);
    ((cmd0x346.ReqBody)localObject1).uint32_seq.set(paramInt2);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(4201);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    localObject2 = new cmd0x346.ExtensionReq();
    ((cmd0x346.ExtensionReq)localObject2).uint32_download_url_type.set(1);
    ((cmd0x346.ReqBody)localObject1).msg_extension_req.set((MessageMicro)localObject2);
    localObject2 = new cmd0xe37.Req0xe37();
    ((cmd0xe37.Req0xe37)localObject2).bytes_cmd_0x346_req_body.set(ByteStringMicro.copyFrom(((cmd0x346.ReqBody)localObject1).toByteArray()));
    localObject1 = makeOIDBPkg("OidbSvc.0xe37_1200", 3639, 1200, ((cmd0xe37.Req0xe37)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("qav_together_from", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putLong("qav_together_room_id", paramLong);
    ((ToServiceMsg)localObject1).extraData.putInt("seq", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putInt("retryCnt", paramInt3 + 1);
    ((ToServiceMsg)localObject1).extraData.putBoolean("needHttpsUrl", paramBoolean);
    ((ToServiceMsg)localObject1).extraData.putParcelable("fileInfo", paramWTFileInfo);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, ChooseFileInfo paramChooseFileInfo)
  {
    WTogetherRoomMng.CmdChangeVideoFileReq localCmdChangeVideoFileReq = new WTogetherRoomMng.CmdChangeVideoFileReq();
    localCmdChangeVideoFileReq.from.set(paramInt);
    localCmdChangeVideoFileReq.seq.set(paramLong2);
    localCmdChangeVideoFileReq.room_id.set(paramLong1);
    localCmdChangeVideoFileReq.video_info_req.set(paramChooseFileInfo.a());
    localCmdChangeVideoFileReq.client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-ChangeVideoFile");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong1);
    localToServiceMsg.extraData.putLong("qav_together_seq", paramLong2);
    localToServiceMsg.extraData.putParcelable("qav_together_choose_file", paramChooseFileInfo);
    localToServiceMsg.putWupBuffer(localCmdChangeVideoFileReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Handler", 4, "changeVideoFile, from[" + paramInt + "], room[" + paramLong1 + "], file[" + paramChooseFileInfo + "]");
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, myt parammyt)
  {
    if (parammyt == null) {}
    do
    {
      return;
      WTogetherRoomMng.CmdSyncPlayTimeReq localCmdSyncPlayTimeReq = new WTogetherRoomMng.CmdSyncPlayTimeReq();
      localCmdSyncPlayTimeReq.from.set(paramInt);
      localCmdSyncPlayTimeReq.room_id.set(paramLong1);
      localCmdSyncPlayTimeReq.seq.set(paramLong2);
      localCmdSyncPlayTimeReq.video_status.set(parammyt.a());
      localCmdSyncPlayTimeReq.cur_play_time.set(parammyt.a());
      localCmdSyncPlayTimeReq.cur_play_rate.set((int)(parammyt.a() * 100.0F));
      localCmdSyncPlayTimeReq.client_type.set(104);
      ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-SyncPlayTime");
      localToServiceMsg.extraData.putInt("qav_together_from", paramInt);
      localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong1);
      localToServiceMsg.extraData.putLong("qav_together_seq", paramLong2);
      localToServiceMsg.putWupBuffer(localCmdSyncPlayTimeReq.toByteArray());
      sendPbReq(localToServiceMsg);
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Handler", 4, "syncPlayInfo, from[" + paramInt + "], room[" + paramLong1 + "], seq[" + paramLong2 + "], playStateInfo[" + parammyt + "]");
  }
  
  public void a(int paramInt1, long paramLong, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong, int paramInt2)
  {
    if (paramChooseFileInfo == null) {}
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      WTogetherRoomMng.CmdStartAvTogetherReq localCmdStartAvTogetherReq = new WTogetherRoomMng.CmdStartAvTogetherReq();
      localCmdStartAvTogetherReq.from.set(paramInt1);
      localCmdStartAvTogetherReq.creator_uin.set(mrr.a((String)localObject));
      localCmdStartAvTogetherReq.room_id.set(paramLong);
      localCmdStartAvTogetherReq.client_type.set(104);
      WTogetherCommon.RoomUserInfo localRoomUserInfo = new WTogetherCommon.RoomUserInfo();
      localRoomUserInfo.role.set(1);
      localRoomUserInfo.uin.set(mrr.a((String)localObject));
      localCmdStartAvTogetherReq.users.add(localRoomUserInfo);
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
      {
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          long l = paramArrayOfLong[i];
          localObject = new WTogetherCommon.RoomUserInfo();
          ((WTogetherCommon.RoomUserInfo)localObject).role.set(0);
          ((WTogetherCommon.RoomUserInfo)localObject).uin.set(l);
          localCmdStartAvTogetherReq.users.add((MessageMicro)localObject);
          i += 1;
        }
      }
      localCmdStartAvTogetherReq.video_info_req.set(paramChooseFileInfo.a());
      localCmdStartAvTogetherReq.client_type.set(104);
      localObject = createToServiceMsg("QQRTCSvc.RoomManager-StartAvTogether");
      ((ToServiceMsg)localObject).extraData.putInt("qav_together_from", paramInt1);
      ((ToServiceMsg)localObject).extraData.putLong("qav_together_room_id", paramLong);
      ((ToServiceMsg)localObject).extraData.putParcelable("qav_together_choose_file", paramChooseFileInfo);
      ((ToServiceMsg)localObject).extraData.putInt("qav_together_try_count", paramInt2 + 1);
      ((ToServiceMsg)localObject).extraData.putLongArray("qav_together_uin_array", paramArrayOfLong);
      ((ToServiceMsg)localObject).putWupBuffer(localCmdStartAvTogetherReq.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Handler", 4, "startWTogether, from[" + paramInt1 + "], room[" + paramLong + "], chooseFile[" + paramChooseFileInfo + "]");
  }
  
  public void a(int paramInt, long paramLong, ReqVideoAction paramReqVideoAction)
  {
    WTogetherRoomMng.CmdGetRoomInfoReq localCmdGetRoomInfoReq = new WTogetherRoomMng.CmdGetRoomInfoReq();
    localCmdGetRoomInfoReq.from.set(paramInt);
    localCmdGetRoomInfoReq.room_id.set(paramLong);
    localCmdGetRoomInfoReq.client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-GetRoomInfo");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putParcelable("qav_together_action", paramReqVideoAction);
    localToServiceMsg.putWupBuffer(localCmdGetRoomInfoReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Handler", 4, "queryRoomInfo, from[" + paramInt + "], room[" + paramLong + "]");
    }
  }
  
  public void a(int paramInt1, long paramLong, ReqVideoAction paramReqVideoAction, int paramInt2)
  {
    WTogetherRoomMng.CmdChangeVideoStatusReq localCmdChangeVideoStatusReq = new WTogetherRoomMng.CmdChangeVideoStatusReq();
    localCmdChangeVideoStatusReq.from.set(paramInt1);
    localCmdChangeVideoStatusReq.room_id.set(paramLong);
    localCmdChangeVideoStatusReq.seq.set(paramReqVideoAction.jdField_a_of_type_Long);
    localCmdChangeVideoStatusReq.video_action.set(paramReqVideoAction.jdField_a_of_type_Int);
    localCmdChangeVideoStatusReq.cur_play_time.set(paramReqVideoAction.jdField_b_of_type_Long);
    localCmdChangeVideoStatusReq.cur_play_rate.set((int)(paramReqVideoAction.jdField_a_of_type_Float * 100.0F));
    localCmdChangeVideoStatusReq.video_status.set(paramReqVideoAction.jdField_b_of_type_Int);
    localCmdChangeVideoStatusReq.client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-ChangeVideoStatus");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putParcelable("qav_together_action", paramReqVideoAction);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(localCmdChangeVideoStatusReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Handler", 4, "changeVideoStatus, from[" + paramInt1 + "], room[" + paramLong + "], action[" + paramReqVideoAction + "]");
    }
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    WTogetherRoomMng.CmdUserQuitRoomReq localCmdUserQuitRoomReq = new WTogetherRoomMng.CmdUserQuitRoomReq();
    localCmdUserQuitRoomReq.from.set(paramInt1);
    localCmdUserQuitRoomReq.room_id.set(paramLong);
    localCmdUserQuitRoomReq.client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-UserQuitRoom");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(localCmdUserQuitRoomReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Handler", 4, "quitRoom, from[" + paramInt1 + "], room[" + paramLong + "]");
    }
  }
  
  public void c(int paramInt1, long paramLong, int paramInt2)
  {
    WTogetherRoomMng.CmdUserEnterRoomReq localCmdUserEnterRoomReq = new WTogetherRoomMng.CmdUserEnterRoomReq();
    localCmdUserEnterRoomReq.from.set(paramInt1);
    localCmdUserEnterRoomReq.room_id.set(paramLong);
    localCmdUserEnterRoomReq.client_type.set(104);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.RoomManager-UserEnterRoom");
    localToServiceMsg.extraData.putInt("qav_together_from", paramInt1);
    localToServiceMsg.extraData.putLong("qav_together_room_id", paramLong);
    localToServiceMsg.extraData.putInt("qav_together_try_count", paramInt2 + 1);
    localToServiceMsg.putWupBuffer(localCmdUserEnterRoomReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Handler", 4, "enterRoom, from[" + paramInt1 + "], room[" + paramLong + "]");
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return mxg.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((QLog.isColorLevel()) && (!TextUtils.equals(str, "QQRTCSvc.RoomManager-SyncPlayTime"))) {
      QLog.i("WTogether.Handler", 2, "onReceive, cmd[" + str + "]");
    }
    if ("OidbSvc.0xe37_1200".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQRTCSvc.RoomManager-StartAvTogether".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQRTCSvc.RoomManager-CloseAvTogether".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQRTCSvc.RoomManager-ChangeVideoFile".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQRTCSvc.RoomManager-ChangeVideoStatus".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQRTCSvc.RoomManager-GetRoomInfo".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQRTCSvc.RoomManager-SyncPlayTime".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQRTCSvc.RoomManager-UserQuitRoom".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQRTCSvc.RoomManager-UserEnterRoom".equals(str));
    i(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxc
 * JD-Core Version:    0.7.0.1
 */