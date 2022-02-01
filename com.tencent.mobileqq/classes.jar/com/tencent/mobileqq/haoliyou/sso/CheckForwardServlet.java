package com.tencent.mobileqq.haoliyou.sso;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.ServerApi.ErrorInfo;
import com.tencent.mobileqq.bigbrother.ServerApi.RspDownloadCheckRecmd;
import com.tencent.mobileqq.bigbrother.ServerApi.RspJumpCheckRecmd;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig.Config;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.CheckShareExtensionRsp;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.RspBody;
import tencent.im.oidb.jump_url_check.jump_url_check.RspJumpUrlCheckRecmd;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CheckForwardServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive with code: ");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
      QLog.d("CheckForwardServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramIntent.getStringExtra("CMD");
    int i;
    if ("OidbSvc.0xc78_1".equals(localObject1)) {
      i = 1;
    } else if ("QQApkSvc.check_jump_url".equals(localObject1)) {
      i = 2;
    } else if ("QQApkSvc.check_download_apk".equals(localObject1)) {
      i = 3;
    } else if ("QQApkSvc.check_jump_apk".equals(localObject1)) {
      i = 4;
    } else {
      i = 0;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("ext_info", paramIntent.getStringExtra("ext_info"));
    ((Bundle)localObject1).putInt("req_id", paramIntent.getIntExtra("req_id", 0));
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        Object localObject2 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject2).getInt() - 4];
        ((ByteBuffer)localObject2).get(paramFromServiceMsg);
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                bool1 = bool2;
              }
              else
              {
                localObject2 = new ServerApi.RspJumpCheckRecmd();
                ((ServerApi.RspJumpCheckRecmd)localObject2).mergeFrom(paramFromServiceMsg);
                ((Bundle)localObject1).putInt("jump", ((ServerApi.RspJumpCheckRecmd)localObject2).jump_method.get());
                paramFromServiceMsg = (ServerApi.ErrorInfo)((ServerApi.RspJumpCheckRecmd)localObject2).err_info.get();
                bool1 = bool2;
                if (paramFromServiceMsg != null)
                {
                  ((Bundle)localObject1).putInt("err_code", paramFromServiceMsg.err_code.get());
                  ((Bundle)localObject1).putString("err_msg", paramFromServiceMsg.err_msg.get());
                  bool1 = bool2;
                }
              }
            }
            else
            {
              localObject2 = new ServerApi.RspDownloadCheckRecmd();
              ((ServerApi.RspDownloadCheckRecmd)localObject2).mergeFrom(paramFromServiceMsg);
              ((Bundle)localObject1).putBoolean("allow_download", ((ServerApi.RspDownloadCheckRecmd)localObject2).check_pass.get());
              paramFromServiceMsg = (ServerApi.ErrorInfo)((ServerApi.RspDownloadCheckRecmd)localObject2).err_info.get();
              bool1 = bool2;
              if (paramFromServiceMsg != null)
              {
                ((Bundle)localObject1).putInt("err_code", paramFromServiceMsg.err_code.get());
                ((Bundle)localObject1).putString("err_msg", paramFromServiceMsg.err_msg.get());
                ((Bundle)localObject1).putString("jump_url", paramFromServiceMsg.jump_url.get());
                bool1 = bool2;
              }
            }
          }
          else
          {
            localObject2 = new jump_url_check.RspJumpUrlCheckRecmd();
            ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).mergeFrom(paramFromServiceMsg);
            ((Bundle)localObject1).putInt("err_code", ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).err_code.get());
            ((Bundle)localObject1).putString("err_msg", ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).err_msg.get());
            ((Bundle)localObject1).putBoolean("can_jump", ((jump_url_check.RspJumpUrlCheckRecmd)localObject2).can_jump.get());
            bool1 = bool2;
          }
        }
        else
        {
          localObject2 = new oidb_sso.OIDBSSOPkg();
          ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg);
          if (((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get() != 0) {
            break label686;
          }
          bool1 = true;
          if (bool1)
          {
            paramFromServiceMsg = new oidb_cmd0xc78.RspBody();
            paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray());
            paramFromServiceMsg = (oidb_cmd0xc78.CheckShareExtensionRsp)paramFromServiceMsg.check_share_extension_rsp.get();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onreceive result: ");
              ((StringBuilder)localObject2).append(paramFromServiceMsg.result.get());
              ((StringBuilder)localObject2).append(", jump: ");
              ((StringBuilder)localObject2).append(paramFromServiceMsg.jump_result.get());
              QLog.i("CheckForwardServlet", 2, ((StringBuilder)localObject2).toString());
            }
            ((Bundle)localObject1).putInt("result", paramFromServiceMsg.result.get());
            ((Bundle)localObject1).putInt("jump_result", paramFromServiceMsg.jump_result.get());
            ((Bundle)localObject1).putString("jump_url", paramFromServiceMsg.jump_url.get());
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.e("CheckForwardServlet", 1, paramFromServiceMsg, new Object[0]);
        bool1 = false;
      }
      notifyObserver(paramIntent, i, bool1, (Bundle)localObject1, CheckForwardObserver.class);
      return;
      label686:
      bool1 = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("CMD");
    paramPacket.setSSOCommand(str);
    if (str.equals("QQApkSvc.check_jump_url")) {
      paramPacket.setTimeout(10000L);
    } else if (str.equals("QQApkSvc.check_download_apk")) {
      paramPacket.setTimeout(((TeleScreenConfig.Config)QConfigManager.a().a(416)).a);
    } else if (str.equals("QQApkSvc.check_jump_apk")) {
      paramPacket.setTimeout(((TeleScreenConfig.Config)QConfigManager.a().a(416)).b);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend with cmd: ");
      localStringBuilder.append(str);
      QLog.d("CheckForwardServlet", 2, localStringBuilder.toString());
    }
    paramPacket.putSendData(WupUtil.a(paramIntent.getByteArrayExtra("RequestBytes")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet
 * JD-Core Version:    0.7.0.1
 */