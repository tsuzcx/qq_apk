package com.tencent.mobileqq.msgbackup.authentication;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp.Builder;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp.Builder;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp.Builder;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ConfirmQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ConfirmQrRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.GetQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.GetQrRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.QueryStateReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.QueryStateRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.RejectQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ReqBody;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.RspBody;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.UserData;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.VerifyTokenReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetDecryptKeyReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetDecryptKeyRsp;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetEncrptkeyReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.GetEncryptKeyRsp;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.ReqBody;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class MsgBackupAuthHandler
  extends BusinessHandler
{
  public MsgBackupAuthHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(String paramString, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    Object localObject1;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.uint32_result.has()))
    {
      int j = paramOIDBSSOPkg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyReq result=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject1).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject1 = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcde.RspBody();
      try
      {
        paramOIDBSSOPkg.mergeFrom((byte[])localObject1);
      }
      catch (Exception localException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
      }
      if (paramOIDBSSOPkg.get_decrypt_key_rsp.has())
      {
        Object localObject2 = (oidb_cmd0xcde.GetDecryptKeyRsp)paramOIDBSSOPkg.get_decrypt_key_rsp.get();
        if (((oidb_cmd0xcde.GetDecryptKeyRsp)localObject2).dncrypt_key.has())
        {
          localObject2 = ((oidb_cmd0xcde.GetDecryptKeyRsp)localObject2).dncrypt_key.get().toStringUtf8();
          MsgBackupManager.e.put(paramString, localObject2);
          if (QLog.isDevelopLevel())
          {
            paramString = new StringBuilder();
            paramString.append("GetDecryptKeyReq decryptKey=");
            paramString.append((String)localObject2);
            paramString.append("encrytKey = ");
            paramString.append(paramOIDBSSOPkg.get_encrypt_key_rsp);
            QLog.d("MsgBackup.MsgBackupAuthHandler", 4, paramString.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyRsp has no dncrypt_key!");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyRsp has no get_decrypt_key_rsp!");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyRsp error ");
    }
  }
  
  private void a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.uint32_result.has()))
    {
      int j = paramOIDBSSOPkg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        paramOIDBSSOPkg = new StringBuilder();
        paramOIDBSSOPkg.append("handle OidbSvc.0xcdd|OIDBSSOPke. processRejectQrRsp result=");
        paramOIDBSSOPkg.append(j);
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, paramOIDBSSOPkg.toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if (i == 0)
    {
      notifyUI(5, true, null);
      return;
    }
    notifyUI(5, false, null);
  }
  
  private void b(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    Object localObject;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.uint32_result.has()))
    {
      int j = paramOIDBSSOPkg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handle OidbSvc.0xcdd|OIDBSSOPke. processQueryStateRsp result=");
        ((StringBuilder)localObject).append(j);
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcdd.RspBody();
      try
      {
        paramOIDBSSOPkg.mergeFrom((byte[])localObject);
      }
      catch (Exception localException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
      }
      if (paramOIDBSSOPkg.query_state_rsp.has())
      {
        MsgBackupQryStateRsp.Builder localBuilder = new MsgBackupQryStateRsp.Builder();
        paramOIDBSSOPkg = (oidb_cmd0xcdd.QueryStateRsp)paramOIDBSSOPkg.query_state_rsp.get();
        if (paramOIDBSSOPkg.state.has())
        {
          i = paramOIDBSSOPkg.state.get();
          localBuilder.a(i);
          if (i == 2)
          {
            if (paramOIDBSSOPkg.token.has()) {
              localBuilder.a(paramOIDBSSOPkg.token.get().toStringUtf8());
            }
            if (paramOIDBSSOPkg.encrypt_key.has()) {
              localBuilder.b(paramOIDBSSOPkg.encrypt_key.get().toStringUtf8());
            }
            if (paramOIDBSSOPkg.user_data.has()) {
              localBuilder.a(a((oidb_cmd0xcdd.UserData)paramOIDBSSOPkg.user_data.get()));
            }
            if (paramOIDBSSOPkg.biz_type.has()) {
              localBuilder.b(paramOIDBSSOPkg.biz_type.get());
            }
          }
        }
        notifyUI(4, true, localBuilder.a());
        return;
      }
      notifyUI(4, false, null);
    }
  }
  
  private void c(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.uint32_result.has()))
    {
      int j = paramOIDBSSOPkg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        paramOIDBSSOPkg = new StringBuilder();
        paramOIDBSSOPkg.append("handle OidbSvc.0xcdd|OIDBSSOPke. processVerifyTokenRsp result=");
        paramOIDBSSOPkg.append(j);
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, paramOIDBSSOPkg.toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if (i == 0)
    {
      notifyUI(3, true, null);
      return;
    }
    notifyUI(3, false, null);
  }
  
  private void d(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    Object localObject1;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.uint32_result.has()))
    {
      int j = paramOIDBSSOPkg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp result=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject1).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject1 = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcde.RspBody();
      try
      {
        paramOIDBSSOPkg.mergeFrom((byte[])localObject1);
      }
      catch (Exception localException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
      }
      if (paramOIDBSSOPkg.get_encrypt_key_rsp.has())
      {
        paramOIDBSSOPkg = (oidb_cmd0xcde.GetEncryptKeyRsp)paramOIDBSSOPkg.get_encrypt_key_rsp.get();
        Object localObject2;
        if (paramOIDBSSOPkg.encrypt_key.has())
        {
          localObject2 = paramOIDBSSOPkg.encrypt_key.get().toStringUtf8();
          MsgBackupManager.c = (String)localObject2;
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("GetEncryptKeyRsp encryptKey=");
            localStringBuilder.append((String)localObject2);
            QLog.d("MsgBackup.MsgBackupAuthHandler", 4, localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp has no encrypt_key!");
        }
        if (paramOIDBSSOPkg.file_meta.has())
        {
          paramOIDBSSOPkg = paramOIDBSSOPkg.file_meta.get().toStringUtf8();
          MsgBackupManager.b = paramOIDBSSOPkg;
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("GetEncryptKeyRsp fileMeta=");
            ((StringBuilder)localObject2).append(paramOIDBSSOPkg);
            QLog.d("MsgBackup.MsgBackupAuthHandler", 4, ((StringBuilder)localObject2).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp has no file_meta!");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp has no get_encrypt_key_rsp!");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp error ");
    }
  }
  
  private void e(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    Object localObject1;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.uint32_result.has()))
    {
      int j = paramOIDBSSOPkg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle OidbSvc.0xcdd|OIDBSSOPke. processConfirmQrRsp result=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject1).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject1 = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcdd.RspBody();
      try
      {
        paramOIDBSSOPkg.mergeFrom((byte[])localObject1);
      }
      catch (Exception localException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
      }
      if (paramOIDBSSOPkg.confirm_qr_rsp.has())
      {
        Object localObject2 = new MsgBackupConfirmQrRsp.Builder();
        paramOIDBSSOPkg = (oidb_cmd0xcdd.ConfirmQrRsp)paramOIDBSSOPkg.confirm_qr_rsp.get();
        if (paramOIDBSSOPkg.token.has()) {
          ((MsgBackupConfirmQrRsp.Builder)localObject2).a(paramOIDBSSOPkg.token.get().toStringUtf8());
        }
        if (paramOIDBSSOPkg.encrypt_key.has()) {
          ((MsgBackupConfirmQrRsp.Builder)localObject2).b(paramOIDBSSOPkg.encrypt_key.get().toStringUtf8());
        }
        if (paramOIDBSSOPkg.user_data.has()) {
          ((MsgBackupConfirmQrRsp.Builder)localObject2).a(a((oidb_cmd0xcdd.UserData)paramOIDBSSOPkg.user_data.get()));
        }
        if (paramOIDBSSOPkg.biz_type.has()) {
          ((MsgBackupConfirmQrRsp.Builder)localObject2).a(paramOIDBSSOPkg.biz_type.get());
        }
        paramOIDBSSOPkg = ((MsgBackupConfirmQrRsp.Builder)localObject2).a();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("processGetQrRsp getQrResponse= ");
          ((StringBuilder)localObject2).append(paramOIDBSSOPkg);
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject2).toString());
        }
        MsgBackupReporter.a();
        MsgBackupReporter.a.c = true;
        MsgBackupReporter.a.d = 0;
        notifyUI(2, true, paramOIDBSSOPkg);
      }
    }
    else
    {
      MsgBackupReporter.a();
      MsgBackupReporter.a.c = false;
      MsgBackupReporter.a.d = i;
      notifyUI(2, false, Integer.valueOf(i));
    }
  }
  
  private void f(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    int i;
    Object localObject1;
    if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.uint32_result.has()))
    {
      int j = paramOIDBSSOPkg.uint32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle OidbSvc.0xcdd|OIDBSSOPke. processGetQrRsp result=");
        ((StringBuilder)localObject1).append(j);
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject1).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if ((i == 0) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      localObject1 = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      paramOIDBSSOPkg = new oidb_cmd0xcdd.RspBody();
      try
      {
        paramOIDBSSOPkg.mergeFrom((byte[])localObject1);
      }
      catch (Exception localException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localException.getMessage(), localException);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("MsgBackup.MsgBackupAuthHandler", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
      }
      if (paramOIDBSSOPkg.get_qr_rsp.has())
      {
        Object localObject2 = new MsgBackupGetQrRsp.Builder();
        paramOIDBSSOPkg = (oidb_cmd0xcdd.GetQrRsp)paramOIDBSSOPkg.get_qr_rsp.get();
        if (paramOIDBSSOPkg.qr_sig.has()) {
          ((MsgBackupGetQrRsp.Builder)localObject2).a(paramOIDBSSOPkg.qr_sig.get().toStringUtf8());
        }
        if (paramOIDBSSOPkg.token.has()) {
          ((MsgBackupGetQrRsp.Builder)localObject2).b(paramOIDBSSOPkg.token.get().toStringUtf8());
        }
        if (paramOIDBSSOPkg.encrypt_key.has()) {
          ((MsgBackupGetQrRsp.Builder)localObject2).c(paramOIDBSSOPkg.encrypt_key.get().toStringUtf8());
        }
        if (paramOIDBSSOPkg.user_data.has()) {
          ((MsgBackupGetQrRsp.Builder)localObject2).a(a((oidb_cmd0xcdd.UserData)paramOIDBSSOPkg.user_data.get()));
        }
        if (paramOIDBSSOPkg.biz_type.has()) {
          ((MsgBackupGetQrRsp.Builder)localObject2).a(paramOIDBSSOPkg.biz_type.get());
        }
        paramOIDBSSOPkg = ((MsgBackupGetQrRsp.Builder)localObject2).a();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("processGetQrRsp getQrResponse= ");
          ((StringBuilder)localObject2).append(paramOIDBSSOPkg);
          QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject2).toString());
        }
        MsgBackupReporter.a();
        MsgBackupReporter.a.c = true;
        MsgBackupReporter.a.d = 0;
        notifyUI(1, true, paramOIDBSSOPkg);
      }
    }
    else
    {
      MsgBackupReporter.a();
      MsgBackupReporter.a.c = false;
      MsgBackupReporter.a.d = i;
      notifyUI(1, false, Integer.valueOf(i));
    }
  }
  
  public MsgBackupUserData a(oidb_cmd0xcdd.UserData paramUserData)
  {
    MsgBackupUserData.Builder localBuilder = new MsgBackupUserData.Builder();
    if (paramUserData.ip.has()) {
      localBuilder.a(paramUserData.ip.get().toStringUtf8());
    }
    if (paramUserData.port.has()) {
      localBuilder.a(paramUserData.port.get());
    }
    if (paramUserData.ssid.has()) {
      localBuilder.b(paramUserData.ssid.get().toStringUtf8());
    }
    if (paramUserData.bssid.has()) {
      localBuilder.c(paramUserData.bssid.get().toStringUtf8());
    }
    return localBuilder.a();
  }
  
  public void a()
  {
    Object localObject1 = new oidb_cmd0xcde.ReqBody();
    Object localObject2 = new oidb_cmd0xcde.GetEncrptkeyReq();
    ((oidb_cmd0xcde.ReqBody)localObject1).get_encrypt_key_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3294);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcde.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xcde");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(MsgBackupUserData paramMsgBackupUserData, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getQrRequest called: userdata = ");
      ((StringBuilder)localObject).append(paramMsgBackupUserData);
      ((StringBuilder)localObject).append(", ispush = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject).toString());
    }
    oidb_cmd0xcdd.ReqBody localReqBody = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.GetQrReq localGetQrReq = new oidb_cmd0xcdd.GetQrReq();
    localGetQrReq.push.set(paramBoolean);
    oidb_cmd0xcdd.UserData localUserData = new oidb_cmd0xcdd.UserData();
    localUserData.ip.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.a()));
    localUserData.port.set(paramMsgBackupUserData.b());
    Object localObject = paramMsgBackupUserData.c();
    PBBytesField localPBBytesField = localUserData.ssid;
    if (localObject == null) {
      localObject = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localObject = paramMsgBackupUserData.d();
    localPBBytesField = localUserData.bssid;
    if (localObject == null) {
      localObject = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localUserData.platform.set(paramMsgBackupUserData.e());
    localGetQrReq.user_data.set(localUserData);
    localGetQrReq.biz_type.set(paramInt);
    localReqBody.get_qr_req.set(localGetQrReq);
    paramMsgBackupUserData = new oidb_sso.OIDBSSOPkg();
    paramMsgBackupUserData.uint32_command.set(3293);
    paramMsgBackupUserData.uint32_result.set(0);
    paramMsgBackupUserData.uint32_service_type.set(1);
    paramMsgBackupUserData.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xcdd");
    ((ToServiceMsg)localObject).putWupBuffer(paramMsgBackupUserData.toByteArray());
    ((ToServiceMsg)localObject).addAttribute("MsgBackup_request_type", Integer.valueOf(1));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(MsgBackupUserData paramMsgBackupUserData, String paramString, int paramInt)
  {
    oidb_cmd0xcdd.ReqBody localReqBody = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.ConfirmQrReq localConfirmQrReq = new oidb_cmd0xcdd.ConfirmQrReq();
    localConfirmQrReq.qr_sig.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new oidb_cmd0xcdd.UserData();
    paramString.ip.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.a()));
    paramString.port.set(paramMsgBackupUserData.b());
    if (paramMsgBackupUserData.c() != null) {
      paramString.ssid.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.c()));
    }
    if (paramMsgBackupUserData.d() != null) {
      paramString.bssid.set(ByteStringMicro.copyFromUtf8(paramMsgBackupUserData.d()));
    }
    paramString.platform.set(paramMsgBackupUserData.e());
    localConfirmQrReq.user_data.set(paramString);
    localConfirmQrReq.biz_type.set(paramInt);
    localReqBody.confirm_qr_req.set(localConfirmQrReq);
    paramMsgBackupUserData = new oidb_sso.OIDBSSOPkg();
    paramMsgBackupUserData.uint32_command.set(3293);
    paramMsgBackupUserData.uint32_result.set(0);
    paramMsgBackupUserData.uint32_service_type.set(2);
    paramMsgBackupUserData.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString = createToServiceMsg("OidbSvc.0xcdd");
    paramString.putWupBuffer(paramMsgBackupUserData.toByteArray());
    sendPbReq(paramString);
  }
  
  public void a(String paramString)
  {
    Object localObject = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.VerifyTokenReq localVerifyTokenReq = new oidb_cmd0xcdd.VerifyTokenReq();
    localVerifyTokenReq.token.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_cmd0xcdd.ReqBody)localObject).verify_token_req.set(localVerifyTokenReq);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(3293);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(3);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcdd.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xcdd");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.RejectQrReq localRejectQrReq = new oidb_cmd0xcdd.RejectQrReq();
    localRejectQrReq.qr_sig.set(ByteStringMicro.copyFromUtf8(paramString));
    localRejectQrReq.biz_type.set(paramInt);
    ((oidb_cmd0xcdd.ReqBody)localObject).reject_qr_req.set(localRejectQrReq);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(3293);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(5);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcdd.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xcdd");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(String paramString)
  {
    Object localObject1 = new oidb_cmd0xcde.ReqBody();
    Object localObject2 = new oidb_cmd0xcde.GetDecryptKeyReq();
    ((oidb_cmd0xcde.GetDecryptKeyReq)localObject2).file_meta.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_cmd0xcde.ReqBody)localObject1).get_decrypt_key_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3294);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(2);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcde.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xcde");
    ((ToServiceMsg)localObject1).extraData.putString("req_key_file_meta", paramString);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(15000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void c(String paramString)
  {
    Object localObject = new oidb_cmd0xcdd.ReqBody();
    oidb_cmd0xcdd.QueryStateReq localQueryStateReq = new oidb_cmd0xcdd.QueryStateReq();
    localQueryStateReq.qr_sig.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_cmd0xcdd.ReqBody)localObject).query_state_req.set(localQueryStateReq);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(3293);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(4);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcdd.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xcdd");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xcdd");
      this.allowCmdSet.add("OidbSvc.0xcde");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return MsgBackupObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MsgBackupAuthHandler cmd=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject).append(", isSuccess = ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject).append(", resultcode = ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.d("MsgBackup.MsgBackupAuthHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("MsgBackup.MsgBackupAuthHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if (("OidbSvc.0xcdd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0xcde".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
    {
      int i;
      if (paramFromServiceMsg.isSuccess())
      {
        localObject = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        }
        catch (Exception paramObject)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, paramObject.getMessage(), paramObject);
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          QLog.w("MsgBackup.MsgBackupAuthHandler", 4, paramObject.getMessage(), paramObject);
        }
        paramObject = localObject;
        i = paramObject.uint32_service_type.get();
        if ("OidbSvc.0xcdd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          if (i == 1)
          {
            f(paramObject);
            return;
          }
          if (i == 2)
          {
            e(paramObject);
            return;
          }
          if (i == 3)
          {
            c(paramObject);
            return;
          }
          if (i == 4)
          {
            b(paramObject);
            return;
          }
          if (i == 5) {
            a(paramObject);
          }
        }
        else if ("OidbSvc.0xcde".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          if (i == 1)
          {
            d(paramObject);
            return;
          }
          if (i == 2) {
            a(paramToServiceMsg.extraData.getString("req_key_file_meta"), paramObject);
          }
        }
      }
      else
      {
        paramToServiceMsg = paramToServiceMsg.getAttribute("MsgBackup_request_type");
        if ((paramToServiceMsg instanceof Integer))
        {
          i = ((Integer)paramToServiceMsg).intValue();
          if ("OidbSvc.0xcdd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
          {
            if (i == 1) {
              f(null);
            }
          }
          else {
            "OidbSvc.0xcde".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthHandler
 * JD-Core Version:    0.7.0.1
 */