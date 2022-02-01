package cooperation.qqfav.forward;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardDataWireReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardDataWireRspBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardGroupReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardGroupRspBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardOfflineFileReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardOfflineFileRspBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ReqBody;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QfavFileForwardHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public QfavFileForwardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private oidb_cmd0xd68.ForwardDataWireReqBody a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong)
  {
    oidb_cmd0xd68.ForwardDataWireReqBody localForwardDataWireReqBody = new oidb_cmd0xd68.ForwardDataWireReqBody();
    localForwardDataWireReqBody.uint64_dst_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
    localForwardDataWireReqBody.uint32_src_svcid.set(236);
    localForwardDataWireReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardDataWireReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localForwardDataWireReqBody.bytes_src_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localForwardDataWireReqBody.uint32_client_type.set(2);
    localForwardDataWireReqBody.cid.set(paramString4);
    localForwardDataWireReqBody.str_file_name.set(paramString5);
    localForwardDataWireReqBody.uint64_file_size.set(paramLong);
    boolean bool = FileUtil.b(paramString1);
    if ((TextUtils.isEmpty(paramString5)) && (bool))
    {
      localForwardDataWireReqBody.str_file_name.set(FileUtil.g(paramString1));
      localForwardDataWireReqBody.uint64_file_size.set(FileUtil.f(paramString1));
    }
    return localForwardDataWireReqBody;
  }
  
  private oidb_cmd0xd68.ForwardGroupReqBody a(long paramLong1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong2)
  {
    oidb_cmd0xd68.ForwardGroupReqBody localForwardGroupReqBody = new oidb_cmd0xd68.ForwardGroupReqBody();
    localForwardGroupReqBody.uint64_group_code.set(paramLong1);
    localForwardGroupReqBody.uint32_app_id.set(AppSetting.d());
    localForwardGroupReqBody.uint32_src_bus_id.set(236);
    localForwardGroupReqBody.bytes_dst_folder_id.set(ByteStringMicro.copyFrom("/".getBytes()));
    localForwardGroupReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardGroupReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localForwardGroupReqBody.bytes_src_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString3 = localForwardGroupReqBody.str_file_name;
    paramString2 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString2 = "";
    }
    paramString3.set(paramString2);
    localForwardGroupReqBody.uint64_file_size.set(paramLong2);
    localForwardGroupReqBody.cid.set(paramString4);
    if (!TextUtils.isEmpty(paramString1)) {
      localForwardGroupReqBody.str_local_path.set(paramString1);
    }
    return localForwardGroupReqBody;
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramFromServiceMsg.getResultCode() != 1000) {
        return null;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QfavFileForwardHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
    }
    if (paramToServiceMsg.uint32_result.get() == 0)
    {
      if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
        return null;
      }
      return paramToServiceMsg;
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xd68.RspBody paramRspBody)
  {
    if (paramRspBody.forward_group_rsp == null) {
      return;
    }
    long l = ((Long)paramToServiceMsg.getAttribute("sessionId")).longValue();
    paramToServiceMsg = this.a.getFileManagerDataCenter().a(l);
    if (paramToServiceMsg == null)
    {
      QLog.e("QfavFileForwardHandler", 4, "handleGroupRsp fileManagerEntity is null");
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a, Long.parseLong(paramToServiceMsg.peerUin));
    if (localTroopFileTransferManager != null)
    {
      ForwardOrderManager.a().a(this.a, paramToServiceMsg.msgSeq);
      String str = new String(paramRspBody.forward_group_rsp.bytes_save_file_path.get().toByteArray());
      localTroopFileTransferManager.a(l, UUID.fromString(paramToServiceMsg.strTroopFileUuid), null, paramRspBody.forward_group_rsp.int32_ret_code.get(), str, paramRspBody.forward_group_rsp.str_ret_msg.get());
    }
  }
  
  private oidb_cmd0xd68.ForwardOfflineFileReqBody b(long paramLong1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong2)
  {
    oidb_cmd0xd68.ForwardOfflineFileReqBody localForwardOfflineFileReqBody = new oidb_cmd0xd68.ForwardOfflineFileReqBody();
    localForwardOfflineFileReqBody.uint64_dst_uin.set(paramLong1);
    localForwardOfflineFileReqBody.uint32_src_svcid.set(236);
    localForwardOfflineFileReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardOfflineFileReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localForwardOfflineFileReqBody.bytes_src_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localForwardOfflineFileReqBody.uint32_client_type.set(2);
    localForwardOfflineFileReqBody.cid.set(paramString4);
    paramString2 = localForwardOfflineFileReqBody.str_file_name;
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "";
    }
    paramString2.set(paramString1);
    localForwardOfflineFileReqBody.uint64_file_size.set(paramLong2);
    return localForwardOfflineFileReqBody;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, oidb_cmd0xd68.RspBody paramRspBody)
  {
    if (paramRspBody.forward_offline_rsp == null) {
      return;
    }
    long l = ((Long)paramToServiceMsg.getAttribute("sessionId")).longValue();
    paramToServiceMsg = this.a.getFileManagerDataCenter().a(l);
    if (paramToServiceMsg == null) {
      return;
    }
    int j = paramRspBody.forward_offline_rsp.int32_ret_code.get();
    Object localObject = paramRspBody.forward_offline_rsp.str_ret_msg.get();
    int i;
    if (j == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (paramToServiceMsg.status != 2)
      {
        paramToServiceMsg.status = 1005;
        this.a.getFileManagerDataCenter().c(paramToServiceMsg);
      }
      paramRspBody = new StringBuilder();
      paramRspBody.append("Id[");
      paramRspBody.append(paramToServiceMsg.nSessionId);
      paramRspBody.append("]wk,handleOfflineRsp-->failed ret_code:");
      paramRspBody.append(j);
      QLog.e("QfavFileForwardHandler", 1, paramRspBody.toString());
      this.a.getFileManagerNotifyCenter().a(paramToServiceMsg.uniseq, paramToServiceMsg.nSessionId, paramToServiceMsg.peerUin, paramToServiceMsg.peerType, 15, null, j, (String)localObject);
      return;
    }
    paramToServiceMsg.Uuid = new String(paramRspBody.forward_offline_rsp.bytes_uuid.get().toByteArray());
    paramToServiceMsg.setCloudType(1);
    paramToServiceMsg.status = 1;
    paramToServiceMsg.isReaded = false;
    paramToServiceMsg.bSend = true;
    paramToServiceMsg.fProgress = 0.0F;
    paramToServiceMsg.bOnceSuccess = true;
    this.a.getFileManagerDataCenter().a();
    this.a.getFileManagerDataCenter().c(paramToServiceMsg);
    paramToServiceMsg.status = 2;
    FileManagerUtil.b(paramToServiceMsg.nSessionId);
    paramRspBody = new StringBuilder();
    paramRspBody.append("=_= ^ [CS Replay]->[CC] Id[");
    paramRspBody.append(paramToServiceMsg.nSessionId);
    paramRspBody.append("]sendFavFile2Offline onSucceed, entity thumbSize(");
    paramRspBody.append(paramToServiceMsg.imgHeight);
    paramRspBody.append(":");
    paramRspBody.append(paramToServiceMsg.imgWidth);
    paramRspBody.append(")");
    QLog.i("QfavFileForwardHandler", 2, paramRspBody.toString());
    if (paramToServiceMsg.peerType == 3000)
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("=_= ^ [Disc Feed]sendDiscFileFeed[");
      paramRspBody.append(paramToServiceMsg.nSessionId);
      paramRspBody.append("]");
      QLog.i("QfavFileForwardHandler", 2, paramRspBody.toString());
      this.a.getFileTransferHandler().a(paramToServiceMsg.nSessionId, paramToServiceMsg.peerUin, this.a.getCurrentAccountUin(), paramToServiceMsg.fileName, paramToServiceMsg.fileSize, paramToServiceMsg.Uuid, paramToServiceMsg.uniseq, paramToServiceMsg.msgUid, null);
    }
    else
    {
      paramRspBody = paramToServiceMsg.peerUin.replace("+", "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^ [Offline CC]sendC2COfflineFileMsg[");
      ((StringBuilder)localObject).append(paramToServiceMsg.nSessionId);
      ((StringBuilder)localObject).append("]");
      QLog.i("QfavFileForwardHandler", 2, ((StringBuilder)localObject).toString());
      this.a.getFileTransferHandler().a(paramRspBody, paramToServiceMsg, null);
    }
    this.a.getFileManagerNotifyCenter().a(paramToServiceMsg, 10, "");
    paramRspBody = new FileManagerReporter.FileAssistantReportData();
    paramRspBody.b = "send_file_suc";
    paramRspBody.c = 1;
    FileManagerReporter.a(this.a.getCurrentAccountUin(), paramRspBody);
    FileManagerUtil.a(this.a, paramToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, oidb_cmd0xd68.RspBody paramRspBody)
  {
    if (paramRspBody.forward_data_wire_rsp == null) {
      return;
    }
    long l = ((Long)paramToServiceMsg.getAttribute("sessionId")).longValue();
    Object localObject = new String(paramRspBody.forward_data_wire_rsp.bytes_uuid.get().toByteArray());
    paramToServiceMsg = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramToServiceMsg.OnSessionComplete(l, 0, -999);
      return;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(l);
    paramRspBody = this.a.getMessageFacade().d(i).a(l);
    if (paramRspBody == null) {
      return;
    }
    paramRspBody.serverPath = ((String)localObject);
    paramRspBody.nOpType = 1;
    paramRspBody.bIsSended = true;
    paramRspBody.bIsTransfering = false;
    if (paramRspBody.entityID != 0L)
    {
      localObject = this.a.getFileManagerDataCenter().a(paramRspBody.entityID);
      if (localObject != null)
      {
        ((FileManagerEntity)localObject).status = 1;
        ((FileManagerEntity)localObject).Uuid = paramRspBody.serverPath;
      }
    }
    if (paramToServiceMsg.a(paramRspBody)) {
      paramToServiceMsg.b(paramRspBody);
    }
  }
  
  public void a(int paramInt, long paramLong1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong2, long paramLong3)
  {
    oidb_cmd0xd68.ReqBody localReqBody = new oidb_cmd0xd68.ReqBody();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        localReqBody.forward_data_wire_req.set(a(paramString1, paramString2, paramString3, paramArrayOfByte, paramString4, paramString5, paramLong2));
      }
      else
      {
        localReqBody.forward_offline_req.set(b(paramLong1, paramString1, paramString2, paramString3, paramArrayOfByte, paramString4, paramString5, paramLong2));
      }
    }
    else {
      localReqBody.forward_group_req.set(a(paramLong1, paramString1, paramString2, paramString3, paramArrayOfByte, paramString4, paramString5, paramLong2));
    }
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(3432);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(paramInt);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = createToServiceMsg("OidbSvc.0xd68");
    paramString2.putWupBuffer(paramString1.toByteArray());
    paramString2.addAttribute("sessionId", Long.valueOf(paramLong3));
    sendPbReq(paramString2);
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity, long paramLong)
  {
    String str2 = paramFileManagerEntity.strFavFileId;
    if (TextUtils.isEmpty(str2))
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("forward ");
      paramFileManagerEntity.append(paramInt);
      paramFileManagerEntity.append(" strFavFileId is Empty!");
      QLog.e("QfavFileForwardHandler", 2, paramFileManagerEntity.toString());
      return;
    }
    String str1 = str2.substring(0, str2.indexOf('/'));
    str2 = str2.substring(str2.indexOf('/'));
    a(paramInt, paramLong, paramFileManagerEntity.getFilePath(), str1, str2, HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5), paramFileManagerEntity.strFavId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId);
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2)
  {
    String str2 = paramFileManagerEntity.strFavFileId;
    String str1 = str2.substring(0, str2.indexOf('/'));
    str2 = str2.substring(str2.indexOf('/'));
    a(paramInt, paramLong1, paramFileManagerEntity.getFilePath(), str1, str2, HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5), paramFileManagerEntity.strFavId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramLong2);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QfavOnlineFileForwardObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QfavFileForwardHandler", 4, "onReceive");
    }
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd=");
      localStringBuilder.append(str);
      QLog.i("QfavFileForwardHandler", 4, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("data length =");
      localStringBuilder.append(((byte[])paramObject).length);
      QLog.i("QfavFileForwardHandler", 4, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (str.compareTo("OidbSvc.0xd68") == 0)
    {
      paramFromServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (paramFromServiceMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QfavFileForwardHandler", 2, "onReceive: ssoPkg parse failed");
        }
        return;
      }
      paramObject = new oidb_cmd0xd68.RspBody();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        int i = paramFromServiceMsg.uint32_service_type.get();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            c(paramToServiceMsg, paramObject);
            return;
          }
          b(paramToServiceMsg, paramObject);
          return;
        }
        a(paramToServiceMsg, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("cmd=");
    paramToServiceMsg.append(str);
    QLog.e("QfavFileForwardHandler", 4, paramToServiceMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.forward.QfavFileForwardHandler
 * JD-Core Version:    0.7.0.1
 */