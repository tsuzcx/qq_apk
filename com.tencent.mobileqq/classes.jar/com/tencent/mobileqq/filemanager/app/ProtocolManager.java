package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QQFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;

public class ProtocolManager
  implements ProtoReqManagerImpl.IProtoRespBack
{
  private static int jdField_a_of_type_Int;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  
  public ProtocolManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
  }
  
  private void a(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int i = paramProtoResp.resp.getResultCode();
    long l2 = 0L;
    Object localObject3 = null;
    boolean bool2 = true;
    Object localObject1;
    long l1;
    Object localObject2;
    boolean bool1;
    if ((i != 1002) && (paramProtoResp.resp.getResultCode() != 1013))
    {
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onForwardOfflineResponse: resp is failed[");
        ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject1).append("]");
        QLog.i("ProtocolManager", 1, ((StringBuilder)localObject1).toString());
        l1 = 0L;
        l2 = l1;
        paramProtoResp = null;
        localObject1 = paramProtoResp;
        localObject2 = localObject1;
        bool1 = false;
        i = -100002;
      }
      else
      {
        localObject1 = paramProtoResp.resp.getWupBuffer();
        paramProtoResp = new cmd0x346.RspBody();
        try
        {
          paramProtoResp.mergeFrom((byte[])localObject1);
          if (!paramProtoResp.msg_apply_forward_file_rsp.has())
          {
            QLog.i("ProtocolManager", 1, "onForwardOfflineResponse rspBody has not hasMsgApplyForwardFileRsp");
          }
          else
          {
            if (paramProtoResp.uint32_flag_use_media_platform.has())
            {
              if (paramProtoResp.uint32_flag_use_media_platform.get() == 1) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("onForwardOfflineResponse: bUseMediaPlatform ");
              ((StringBuilder)localObject1).append(bool1);
              QLog.i("ProtocolManager", 1, ((StringBuilder)localObject1).toString());
            }
            else
            {
              QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
              bool1 = false;
            }
            cmd0x346.ApplyForwardFileRsp localApplyForwardFileRsp = (cmd0x346.ApplyForwardFileRsp)paramProtoResp.msg_apply_forward_file_rsp.get();
            if (localApplyForwardFileRsp.int32_ret_code.has()) {
              i = localApplyForwardFileRsp.int32_ret_code.get();
            } else {
              i = 0;
            }
            if (localApplyForwardFileRsp.str_ret_msg.has()) {
              paramProtoResp = localApplyForwardFileRsp.str_ret_msg.get();
            } else {
              paramProtoResp = null;
            }
            if (localApplyForwardFileRsp.bytes_uuid.has()) {
              localObject1 = new String(localApplyForwardFileRsp.bytes_uuid.get().toByteArray());
            } else {
              localObject1 = null;
            }
            localObject2 = localObject3;
            if (bool1)
            {
              localObject2 = localObject3;
              if (localApplyForwardFileRsp.str_fileidcrc.has()) {
                localObject2 = localApplyForwardFileRsp.str_fileidcrc.get();
              }
            }
            if (localApplyForwardFileRsp.uint64_total_space.has()) {
              l1 = localApplyForwardFileRsp.uint64_total_space.get();
            } else {
              l1 = 0L;
            }
            if (localApplyForwardFileRsp.uint64_used_space.has()) {
              l2 = localApplyForwardFileRsp.uint64_used_space.get();
            }
            bool1 = bool2;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          l1 = 0L;
          l2 = l1;
          paramProtoResp = null;
          localObject1 = paramProtoResp;
          localObject2 = localObject1;
          bool1 = false;
          i = -100003;
        }
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onForwardOfflineResponse: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("ProtocolManager", 1, ((StringBuilder)localObject1).toString());
      l1 = 0L;
      l2 = l1;
      paramProtoResp = null;
      localObject1 = paramProtoResp;
      localObject2 = localObject1;
      bool1 = false;
      i = -100001;
    }
    if (i != 0) {
      bool1 = false;
    }
    ((ProtocolFileCallback.OnForwardOfflineResult)((ProtocolManager.CustomData)paramProtoReq.busiData).a()).a(bool1, i, paramProtoResp, (String)localObject1, (String)localObject2, l1, l2);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, ProtocolManager.CustomData paramCustomData, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = paramString;
    localProtoReq.reqBody = paramArrayOfByte;
    localProtoReq.busiData = paramCustomData;
    localProtoReq.tryTime = paramInt1;
    localProtoReq.tryCount = paramInt2;
    localProtoReq.fixScheduleCount = paramInt3;
    localProtoReq.callback = this;
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
  }
  
  private void b(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int i = paramProtoResp.resp.getResultCode();
    Object localObject1 = null;
    boolean bool = true;
    Object localObject2;
    if ((i != 1002) && (paramProtoResp.resp.getResultCode() != 1013))
    {
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onForwardOfflineToOther: resp is failed[");
        ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject1).append("]");
        QLog.i("ProtocolManager", 1, ((StringBuilder)localObject1).toString());
        paramProtoResp = null;
        localObject1 = paramProtoResp;
        bool = false;
        i = -100002;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramProtoResp);
          if (!((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.has())
          {
            QLog.i("ProtocolManager", 1, "onForwardOfflineToOther rspBody has not hasMsgApplyDownloadAbsRsp");
          }
          else
          {
            localObject2 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.get();
            if (((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.has()) {
              i = ((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.get();
            } else {
              i = 0;
            }
            if (((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.has()) {
              paramProtoResp = ((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.get();
            } else {
              paramProtoResp = null;
            }
            if (((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.has()) {
              localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.get();
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          paramProtoResp = null;
          localObject1 = paramProtoResp;
          bool = false;
          i = -100003;
        }
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onForwardOfflineToOther: resp is timeout[");
      ((StringBuilder)localObject1).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject1).append("]");
      QLog.i("ProtocolManager", 1, ((StringBuilder)localObject1).toString());
      paramProtoResp = null;
      localObject1 = paramProtoResp;
      bool = false;
      i = -100001;
    }
    if (i != 0) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onForwardOfflineToOther: return ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", retCode=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", retMsg=");
      ((StringBuilder)localObject2).append(paramProtoResp);
      QLog.d("ProtocolManager", 2, ((StringBuilder)localObject2).toString());
    }
    ((ProtocolFileCallback.OnForwardOfflineResult)((ProtocolManager.CustomData)paramProtoReq.busiData).a()).a(bool, i, paramProtoResp, (String)localObject1, null, 0L, 0L);
  }
  
  private void c(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int i = paramProtoResp.resp.getResultCode();
    int j = -100003;
    boolean bool = false;
    Object localObject2 = "";
    Object localObject1 = null;
    Object localObject3 = null;
    if ((i != 1002) && (paramProtoResp.resp.getResultCode() != 1013))
    {
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        i = -100002;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("internalForwardDiscFile: resp is failed[");
        ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject2).append("]");
        QLog.i("ProtocolManager", 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        Object localObject4 = new cmd0x345.RspBody();
        try
        {
          ((cmd0x345.RspBody)localObject4).mergeFrom(paramProtoResp);
          if (((cmd0x345.RspBody)localObject4).uint32_return_code.has()) {
            i = ((cmd0x345.RspBody)localObject4).uint32_return_code.get();
          } else {
            i = 0;
          }
          if ((!((cmd0x345.RspBody)localObject4).msg_subcmd_0x6_rsp_body.has()) && (!((cmd0x345.RspBody)localObject4).msg_subcmd_0x5_rsp_body.has()))
          {
            QLog.i("ProtocolManager", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
            i = j;
            break label434;
          }
          if (((cmd0x345.RspBody)localObject4).msg_subcmd_0x6_rsp_body.has())
          {
            localObject4 = (cmd0x345.RspBody.SubCmd0x6RspBody)((cmd0x345.RspBody)localObject4).msg_subcmd_0x6_rsp_body.get();
            if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject4).str_ret_msg.has()) {
              localObject2 = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject4).str_ret_msg.get();
            }
            localObject1 = localObject2;
            paramProtoResp = localObject3;
            if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject4).str_file_id.has())
            {
              paramProtoResp = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject4).str_file_id.get();
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = localObject2;
            paramProtoResp = localObject3;
            if (((cmd0x345.RspBody)localObject4).msg_subcmd_0x5_rsp_body.has())
            {
              localObject4 = (cmd0x345.RspBody.SubCmd0x5RspBody)((cmd0x345.RspBody)localObject4).msg_subcmd_0x5_rsp_body.get();
              if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject4).str_ret_msg.has()) {
                localObject2 = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject4).str_ret_msg.get();
              }
              localObject1 = localObject2;
              paramProtoResp = localObject3;
              if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject4).str_file_id.has())
              {
                paramProtoResp = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject4).str_file_id.get();
                localObject1 = localObject2;
              }
            }
          }
          bool = true;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          i = j;
          break label434;
        }
      }
    }
    else
    {
      i = -100001;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("internalForwardDiscFile: resp is timeout[");
      ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject2).append("]");
      QLog.i("ProtocolManager", 1, ((StringBuilder)localObject2).toString());
    }
    label434:
    localObject2 = "";
    paramProtoResp = localObject1;
    localObject1 = localObject2;
    ((ProtocolFileCallback.OnForwardOfflineResult)((ProtocolManager.CustomData)paramProtoReq.busiData).a()).a(bool, i, localObject1, paramProtoResp, null, 0L, 0L);
  }
  
  private void d(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int j = paramProtoResp.resp.getResultCode();
    int i = -100003;
    boolean bool = false;
    Object localObject1 = null;
    Object localObject2;
    if ((j != 1002) && (paramProtoResp.resp.getResultCode() != 1013))
    {
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        i = -100002;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("=_= ^! [CS Replay]handleUploadResponse: resp is failed[");
        ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject2).append("]");
        QLog.i("ProtocolManager", 1, ((StringBuilder)localObject2).toString());
        paramProtoResp = localObject1;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramProtoResp);
          if (!((cmd0x346.RspBody)localObject2).msg_apply_upload_rsp_v3.has())
          {
            QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            paramProtoResp = localObject1;
          }
          else
          {
            paramProtoResp = (cmd0x346.ApplyUploadRspV3)((cmd0x346.RspBody)localObject2).msg_apply_upload_rsp_v3.get();
            i = -1;
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          paramProtoResp = localObject1;
        }
      }
    }
    else
    {
      i = -100001;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_= ^! [CS Replay]handleUploadResponse: resp is timeout[");
      ((StringBuilder)localObject2).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject2).append("]");
      QLog.i("ProtocolManager", 1, ((StringBuilder)localObject2).toString());
      paramProtoResp = localObject1;
    }
    ((ProtocolFileCallback.OnSendLocalFileToBuddy)((ProtocolManager.CustomData)paramProtoReq.busiData).a()).a(bool, i, paramProtoResp);
  }
  
  private void e(ProtoReqManagerImpl.ProtoReq paramProtoReq, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int j = paramProtoResp.resp.getResultCode();
    int i = -100003;
    boolean bool = false;
    String str = "";
    Object localObject;
    if ((j != 1002) && (paramProtoResp.resp.getResultCode() != 1013))
    {
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        i = -100002;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleUploadSuccResponse: resp is failed[");
        ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
        ((StringBuilder)localObject).append("]");
        QLog.i("ProtocolManager", 1, ((StringBuilder)localObject).toString());
        paramProtoResp = str;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramProtoResp);
          if (!((cmd0x346.RspBody)localObject).msg_upload_succ_rsp.has())
          {
            QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
            paramProtoResp = str;
          }
          else
          {
            localObject = (cmd0x346.UploadSuccRsp)((cmd0x346.RspBody)localObject).msg_upload_succ_rsp.get();
            if (((cmd0x346.UploadSuccRsp)localObject).int32_ret_code.has()) {
              i = ((cmd0x346.UploadSuccRsp)localObject).int32_ret_code.get();
            } else {
              i = -1;
            }
            paramProtoResp = str;
            if (((cmd0x346.UploadSuccRsp)localObject).str_ret_msg.has()) {
              paramProtoResp = ((cmd0x346.UploadSuccRsp)localObject).str_ret_msg.get();
            }
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          paramProtoResp = str;
        }
      }
    }
    else
    {
      i = -100001;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUploadSuccResponse: resp is timeout[");
      ((StringBuilder)localObject).append(paramProtoResp.resp.getResultCode());
      ((StringBuilder)localObject).append("]");
      QLog.i("ProtocolManager", 1, ((StringBuilder)localObject).toString());
      paramProtoResp = str;
    }
    if (paramProtoReq.busiData != null) {
      ((ProtocolFileCallback.SetSendBuddyFileSuccessResult)((ProtocolManager.CustomData)paramProtoReq.busiData).a()).a(bool, i, paramProtoResp);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, ProtocolFileInfo paramProtocolFileInfo, int paramInt3, int paramInt4, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt2);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramProtocolFileInfo.jdField_a_of_type_Long);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramProtocolFileInfo.b.getBytes()));
    if (!TextUtils.isEmpty(paramProtocolFileInfo.c)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramProtocolFileInfo.c.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
    paramString2 = paramString1.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(paramString2));
    localSubCmd0x6ReqBody.str_file_name.set(paramProtocolFileInfo.jdField_a_of_type_JavaLangString);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramProtocolFileInfo.b);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramInt1);
      paramString1 = QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramString1, paramInt1);
      if (paramString1 != null) {
        localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramString1));
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("forwardDiscToOther : add tempinfo SessionType[");
        paramString1.append(paramInt1);
        paramString1.append("]");
        QLog.i("ProtocolManager", 2, paramString1.toString());
      }
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
    paramString1.uint32_sub_cmd.set(7);
    paramString2 = new ProtocolManager.CustomData(paramOnForwardOfflineResult);
    paramString2.a(7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, paramInt3, paramInt4, 1);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    cmd0x346.ApplyForwardFileReq localApplyForwardFileReq = new cmd0x346.ApplyForwardFileReq();
    localApplyForwardFileReq.uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin()));
    paramString1 = paramString1.replace("+", "");
    localApplyForwardFileReq.uint64_recver_uin.set(Long.parseLong(paramString1));
    localApplyForwardFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString2 = new cmd0x346.ReqBody();
    paramString2.msg_apply_forward_file_req.set(localApplyForwardFileReq);
    paramString2.uint32_cmd.set(700);
    Object localObject = paramString2.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    ((PBUInt32Field)localObject).set(i);
    paramString2.uint32_business_id.set(3);
    paramString2.uint32_client_type.set(104);
    if (paramInt1 != 0)
    {
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject).uint64_type.set(paramInt1);
      byte[] arrayOfByte = QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramString1, paramInt1);
      if (arrayOfByte != null) {
        ((cmd0x346.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      paramString2.msg_extension_req.set((MessageMicro)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("forwardOfflineFileToBuddy : add tempinfo SessionType[");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("]");
        QLog.i("ProtocolManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((!((IQFileConfigManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).isMediaPlatformEnabled()) && (!QQFileAssistantUtils.a(paramString1)))
    {
      QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform not enabled");
    }
    else
    {
      paramString2.uint32_flag_support_mediaplatform.set(1);
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        localApplyForwardFileReq.str_fileidcrc.set(paramString3);
        QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled");
      }
      else
      {
        QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled but FileIdCrc is null");
      }
    }
    paramString1 = new ProtocolManager.CustomData(paramOnForwardOfflineResult);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", paramString2.toByteArray(), paramString1, paramInt2, paramInt3, 1);
  }
  
  public void a(String paramString1, String paramString2, ProtocolFileInfo paramProtocolFileInfo, int paramInt1, int paramInt2, int paramInt3, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    cmd0x346.ApplyCopyToReq localApplyCopyToReq = new cmd0x346.ApplyCopyToReq();
    String str = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getAccount().replace("+", "");
    localApplyCopyToReq.uint64_dst_id.set(Long.parseLong(str));
    if ((paramInt1 == 106) || (paramInt1 == 102) || (paramInt1 == 104))
    {
      paramString2 = paramString2.replace("+", "");
      localApplyCopyToReq.uint64_dst_id.set(Long.parseLong(paramString2));
    }
    localApplyCopyToReq.uint32_dst_svcid.set(paramInt1);
    localApplyCopyToReq.uint64_src_uin.set(Long.parseLong(str));
    localApplyCopyToReq.uint64_file_size.set(paramProtocolFileInfo.jdField_a_of_type_Long);
    localApplyCopyToReq.str_file_name.set(paramProtocolFileInfo.jdField_a_of_type_JavaLangString);
    localApplyCopyToReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_copy_to_req.set(localApplyCopyToReq);
    paramString1.uint32_cmd.set(60100);
    paramString2 = paramString1.uint32_seq;
    paramInt1 = jdField_a_of_type_Int;
    jdField_a_of_type_Int = paramInt1 + 1;
    paramString2.set(paramInt1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramString1.toByteArray();
    paramString2 = new ProtocolManager.CustomData(paramOnForwardOfflineResult);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
  }
  
  public void a(String paramString1, String paramString2, ProtocolFileInfo paramProtocolFileInfo, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramProtocolFileInfo.b.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramProtocolFileInfo.jdField_a_of_type_Long);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramProtocolFileInfo.jdField_a_of_type_JavaLangString);
    if ((paramProtocolFileInfo.c != null) && (paramProtocolFileInfo.c.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramProtocolFileInfo.c.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new ProtocolManager.CustomData(paramOnForwardOfflineResult);
    paramString2.a(6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, ProtocolFileCallback.OnSendLocalFileToBuddy paramOnSendLocalFileToBuddy)
  {
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin());
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1700);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    ((PBUInt32Field)localObject).set(i);
    localObject = new cmd0x346.ApplyUploadReqV3();
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_sender_uin.set(l);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_recver_uin.set(Long.parseLong(paramString1));
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_file_size.set(paramLong);
    ((cmd0x346.ApplyUploadReqV3)localObject).str_file_name.set(new String(paramString3));
    ((cmd0x346.ApplyUploadReqV3)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    ((cmd0x346.ApplyUploadReqV3)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    ((cmd0x346.ApplyUploadReqV3)localObject).str_local_filepath.set(paramString2);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint32_danger_level.set(0);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_total_space.set(0L);
    localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
    localReqBody.setHasFlag(true);
    paramString1 = new ProtocolManager.CustomData(paramOnSendLocalFileToBuddy);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", localReqBody.toByteArray(), paramString1, paramInt1, paramInt2, 1);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ProtocolFileCallback.SetSendBuddyFileSuccessResult paramSetSendBuddyFileSuccessResult)
  {
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin()));
    paramString = paramString.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = new cmd0x346.ReqBody();
    paramArrayOfByte.msg_upload_succ_req.set(localUploadSuccReq);
    paramArrayOfByte.uint32_cmd.set(800);
    paramString = paramArrayOfByte.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    paramString.set(i);
    paramArrayOfByte.uint32_business_id.set(3);
    paramArrayOfByte.uint32_client_type.set(104);
    if (paramSetSendBuddyFileSuccessResult != null) {
      paramString = new ProtocolManager.CustomData(paramSetSendBuddyFileSuccessResult);
    } else {
      paramString = null;
    }
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramArrayOfByte.toByteArray(), paramString, paramInt1, paramInt2, 1);
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(paramProtoReq.ssoCmd))
    {
      a(paramProtoReq, paramProtoResp);
    }
    else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramProtoReq.ssoCmd))
    {
      b(paramProtoReq, paramProtoResp);
    }
    else if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramProtoReq.ssoCmd))
    {
      ProtocolManager.CustomData localCustomData = (ProtocolManager.CustomData)paramProtoReq.busiData;
      int i = localCustomData.a();
      if (i == 6)
      {
        c(paramProtoReq, paramProtoResp);
      }
      else if (i == 7)
      {
        c(paramProtoReq, paramProtoResp);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unspourt:");
        localStringBuilder.append(localCustomData.a());
        QLog.w("ProtocolManager", 1, localStringBuilder.toString());
      }
    }
    else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(paramProtoReq.ssoCmd))
    {
      d(paramProtoReq, paramProtoResp);
    }
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(paramProtoReq.ssoCmd)) {
      e(paramProtoReq, paramProtoResp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.ProtocolManager
 * JD-Core Version:    0.7.0.1
 */