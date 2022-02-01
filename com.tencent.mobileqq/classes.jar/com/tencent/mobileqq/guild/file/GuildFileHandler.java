package com.tencent.mobileqq.guild.file;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyDownloadReq;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyDownloadRsp;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyPreviewReq;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyPreviewRsp;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyUploadReq;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyUploadRsp;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ChannelInfo;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.DownloadInfo;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.FileInfo;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ReqBody;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.RspBody;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.UploadCompletedReq;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.UploadCompletedRsp;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GuildFileHandler
  extends BusinessHandler
  implements IGuildFileHandler
{
  private static int f;
  private HashMap<Integer, IGuildUploadReqCallback> a = new HashMap();
  private HashMap<Integer, IGuildUploadSuccReqCallback> b = new HashMap();
  private HashMap<Integer, IGuildDownloadReqCallback> c = new HashMap();
  private HashMap<Integer, IGuildPreviewThumbReqCallback> d = new HashMap();
  private HashMap<Integer, IGuildPreviewThumbReqCallback> e = new HashMap();
  
  public GuildFileHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(int paramInt, IGuildDownloadReqCallback paramIGuildDownloadReqCallback, boolean paramBoolean, UFTGuildDownloadRsp paramUFTGuildDownloadRsp)
  {
    if (paramIGuildDownloadReqCallback != null) {
      paramIGuildDownloadReqCallback.a(paramBoolean, paramUFTGuildDownloadRsp);
    }
    if (this.c.containsKey(Integer.valueOf(paramInt))) {
      this.c.remove(Integer.valueOf(paramInt));
    }
  }
  
  private void a(int paramInt, IGuildUploadReqCallback paramIGuildUploadReqCallback, boolean paramBoolean, UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    paramIGuildUploadReqCallback.a(paramBoolean, paramUFTGuildUploadRsp);
    this.a.remove(Integer.valueOf(paramInt));
  }
  
  private void a(int paramInt, IGuildUploadSuccReqCallback paramIGuildUploadSuccReqCallback, boolean paramBoolean, UFTGuildUploadSuccRsp paramUFTGuildUploadSuccRsp)
  {
    paramIGuildUploadSuccReqCallback.a(paramBoolean, paramUFTGuildUploadSuccRsp);
    this.b.remove(Integer.valueOf(paramInt));
  }
  
  private void a(int paramInt, boolean paramBoolean, IGuildPreviewThumbReqCallback paramIGuildPreviewThumbReqCallback, UFTGuildPreviewThumbRsp paramUFTGuildPreviewThumbRsp)
  {
    if (paramIGuildPreviewThumbReqCallback != null) {
      paramIGuildPreviewThumbReqCallback.a(paramBoolean, paramUFTGuildPreviewThumbRsp);
    }
    this.d.remove(Integer.valueOf(paramInt));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramToServiceMsg.extraData.getString("sub_cmd");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case -697887301: 
        if (str.equals("sub_cmd_upload_file_succ_request")) {
          i = 1;
        }
        break;
      case -921257497: 
        if (str.equals("sub_cmd_preview_video_thumb_request")) {
          i = 2;
        }
        break;
      case -1203026233: 
        if (str.equals("sub_cmd_preview_image_thumb_request")) {
          i = 3;
        }
        break;
      case -1406441274: 
        if (str.equals("sub_cmd_upload_file_request")) {
          i = 0;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            g(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private boolean a(UFTGuildPreviewThumbReq paramUFTGuildPreviewThumbReq, IGuildPreviewThumbReqCallback paramIGuildPreviewThumbReqCallback, String paramString)
  {
    if (paramUFTGuildPreviewThumbReq != null)
    {
      if (paramIGuildPreviewThumbReqCallback == null) {
        return false;
      }
      paramIGuildPreviewThumbReqCallback = new oidb_0xfc2.ReqBody();
      paramIGuildPreviewThumbReqCallback.msg_cmd.set(1100);
      paramIGuildPreviewThumbReqCallback.msg_bus_type.set(paramUFTGuildPreviewThumbReq.c());
      Object localObject = new oidb_0xfc2.ChannelInfo();
      ((oidb_0xfc2.ChannelInfo)localObject).uint64_guild_id.set(Long.parseLong(paramUFTGuildPreviewThumbReq.e()));
      ((oidb_0xfc2.ChannelInfo)localObject).uint64_channel_id.set(Long.parseLong(paramUFTGuildPreviewThumbReq.d()));
      paramIGuildPreviewThumbReqCallback.msg_channel_info.set((MessageMicro)localObject);
      paramIGuildPreviewThumbReqCallback.msg_terminal_type.set(2);
      localObject = new oidb_0xfc2.ApplyPreviewReq();
      ((oidb_0xfc2.ApplyPreviewReq)localObject).str_fileid.set(paramUFTGuildPreviewThumbReq.b());
      paramIGuildPreviewThumbReqCallback.msg_apply_preview_req.set((MessageMicro)localObject);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(4034);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIGuildPreviewThumbReqCallback.toByteArray()));
      paramIGuildPreviewThumbReqCallback = createToServiceMsg("OidbSvcTrpcTcp.0xfc2_0");
      paramIGuildPreviewThumbReqCallback.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      paramIGuildPreviewThumbReqCallback.extraData.putInt("seq", paramUFTGuildPreviewThumbReq.a());
      paramIGuildPreviewThumbReqCallback.extraData.putString("guildId", paramUFTGuildPreviewThumbReq.e());
      paramIGuildPreviewThumbReqCallback.extraData.putString("channelId", paramUFTGuildPreviewThumbReq.d());
      paramIGuildPreviewThumbReqCallback.extraData.putString("sub_cmd", paramString);
      sendPbReq(paramIGuildPreviewThumbReqCallback);
      return true;
    }
    return false;
  }
  
  private void b(int paramInt, boolean paramBoolean, IGuildPreviewThumbReqCallback paramIGuildPreviewThumbReqCallback, UFTGuildPreviewThumbRsp paramUFTGuildPreviewThumbRsp)
  {
    if (paramIGuildPreviewThumbReqCallback != null) {
      paramIGuildPreviewThumbReqCallback.a(paramBoolean, paramUFTGuildPreviewThumbRsp);
    }
    this.e.remove(Integer.valueOf(paramInt));
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramToServiceMsg.extraData.getString("sub_cmd");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      int i = -1;
      if ((str.hashCode() == 452858527) && (str.equals("sub_cmd_download_file_request"))) {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("seq");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    boolean bool2 = this.c.containsKey(Integer.valueOf(i));
    boolean bool1 = true;
    if ((bool2) && (this.c.get(Integer.valueOf(i)) != null))
    {
      paramToServiceMsg = (IGuildDownloadReqCallback)this.c.get(Integer.valueOf(i));
      if (paramObject == null)
      {
        a(i, paramToServiceMsg, false, null);
        return;
      }
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        if (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() != 0)
        {
          a(i, paramToServiceMsg, false, null);
          return;
        }
        oidb_0xfc2.RspBody localRspBody = new oidb_0xfc2.RspBody();
        if ((((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)) {
          try
          {
            localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.i("GuildFileHandler", 2, paramFromServiceMsg.toString());
            a(i, paramToServiceMsg, false, null);
            return;
          }
        }
        paramObject = new UFTGuildDownloadRsp();
        paramObject.a(paramFromServiceMsg);
        paramObject.b(str);
        paramObject.a(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get());
        paramObject.c(((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get());
        paramObject.b(localRspBody.msg_bus_type.get());
        paramFromServiceMsg = (oidb_0xfc2.ApplyDownloadRsp)localRspBody.msg_apply_download_rsp.get();
        paramObject.d(paramFromServiceMsg.msg_file_info.str_fileid.get());
        paramObject.a(ByteStringMicro.copyFrom(paramFromServiceMsg.msg_download_info.bytes_download_key.get().toByteArray()));
        paramObject.a(paramFromServiceMsg.msg_file_info.uint64_size.get());
        paramObject.e(paramFromServiceMsg.msg_file_info.str_name.get());
        paramObject.a(paramFromServiceMsg.msg_download_info.msg_out_addr.get());
        paramObject.b(paramFromServiceMsg.msg_download_info.msg_inner_addr.get());
        paramObject.c(paramFromServiceMsg.msg_download_info.msg_out_addr_ipv6.get());
        paramObject.f(paramFromServiceMsg.msg_download_info.str_download_domain.get());
        paramObject.g(paramFromServiceMsg.msg_download_info.str_download_url.get());
        paramObject.h(paramFromServiceMsg.msg_download_info.str_cookie.get());
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        label466:
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleDownloadFileRequest. guildId: ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          ((StringBuilder)localObject).append(", channelId: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("GuildFileHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
        a(i, paramToServiceMsg, false, null);
        return;
      }
    }
    try
    {
      paramObject.i(new String(paramFromServiceMsg.msg_file_info.bytes_md5.get().toByteArray(), "utf-8"));
    }
    catch (Exception paramFromServiceMsg)
    {
      break label466;
    }
    QLog.e("GuildFileHandler", 1, "downloadFileRspInfo getMd5 failed");
    paramObject.i("");
    if (paramObject.a() != 0) {
      bool1 = false;
    }
    a(i, paramToServiceMsg, bool1, paramObject);
    return;
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleDownloadFileRequest seq not find seq = ");
    paramToServiceMsg.append(i);
    QLog.e("GuildFileHandler", 1, paramToServiceMsg.toString());
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("seq");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    boolean bool2 = this.a.containsKey(Integer.valueOf(i));
    boolean bool1 = true;
    if ((bool2) && (this.a.get(Integer.valueOf(i)) != null))
    {
      paramToServiceMsg = (IGuildUploadReqCallback)this.a.get(Integer.valueOf(i));
      if (paramObject == null)
      {
        a(i, paramToServiceMsg, false, null);
        return;
      }
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        if (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() != 0)
        {
          a(i, paramToServiceMsg, false, null);
          return;
        }
        oidb_0xfc2.RspBody localRspBody = new oidb_0xfc2.RspBody();
        if ((((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)) {
          try
          {
            localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.i("GuildFileHandler", 2, paramFromServiceMsg.toString());
            a(i, paramToServiceMsg, false, null);
            return;
          }
        }
        paramObject = new UFTGuildUploadRsp();
        paramObject.a(paramFromServiceMsg);
        paramObject.b(str);
        paramObject.a(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get());
        paramObject.c(((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get());
        paramObject.b(localRspBody.msg_bus_type.get());
        paramFromServiceMsg = (oidb_0xfc2.ApplyUploadRsp)localRspBody.msg_apply_upload_rsp.get();
        paramObject.d(paramFromServiceMsg.str_fileid.get());
        paramObject.a(paramFromServiceMsg.bytes_upload_key.get().toByteArray());
        paramObject.a(paramFromServiceMsg.bool_file_exist.get());
        paramObject.c(paramFromServiceMsg.uint32_pack_size.get());
        paramObject.e(paramFromServiceMsg.str_upload_domain.get());
        paramObject.a(paramFromServiceMsg.msg_out_addr.get());
        paramObject.b(paramFromServiceMsg.msg_out_addr.get());
        paramObject.c(paramFromServiceMsg.msg_out_addr_ipv6.get());
        if (paramObject.a() != 0) {
          bool1 = false;
        }
        a(i, paramToServiceMsg, bool1, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleSendFileRequest. guildId: ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          ((StringBuilder)localObject).append(", channelId: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("GuildFileHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
        a(i, paramToServiceMsg, false, null);
        return;
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleUploadFileRequest seq not find seq = ");
    paramToServiceMsg.append(i);
    QLog.e("GuildFileHandler", 1, paramToServiceMsg.toString());
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("seq");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    boolean bool2 = this.b.containsKey(Integer.valueOf(i));
    boolean bool1 = true;
    if ((bool2) && (this.b.get(Integer.valueOf(i)) != null))
    {
      paramToServiceMsg = (IGuildUploadSuccReqCallback)this.b.get(Integer.valueOf(i));
      if (paramObject == null)
      {
        a(i, paramToServiceMsg, false, null);
        return;
      }
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        if (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() != 0)
        {
          a(i, paramToServiceMsg, false, null);
          return;
        }
        oidb_0xfc2.RspBody localRspBody = new oidb_0xfc2.RspBody();
        if ((((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)) {
          try
          {
            localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.i("GuildFileHandler", 2, paramFromServiceMsg.toString());
            a(i, paramToServiceMsg, false, null);
            return;
          }
        }
        paramObject = new UFTGuildUploadSuccRsp();
        paramObject.a(paramFromServiceMsg);
        paramObject.b(str);
        paramObject.a(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get());
        paramObject.c(((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get());
        paramObject.b(localRspBody.msg_bus_type.get());
        paramFromServiceMsg = (oidb_0xfc2.FileInfo)((oidb_0xfc2.UploadCompletedRsp)localRspBody.msg_upload_completed_rsp.get()).msg_file_info.get();
        paramObject.d(paramFromServiceMsg.str_fileid.get());
        paramObject.e(paramFromServiceMsg.str_name.get());
        paramObject.a(paramFromServiceMsg.uint64_size.get());
        paramObject.a(paramFromServiceMsg.bytes_sha.get().toByteArray());
        paramObject.b(paramFromServiceMsg.bytes_md5.get().toByteArray());
        paramObject.c(paramFromServiceMsg.uint32_danger_level.get());
        paramObject.b(paramFromServiceMsg.int64_upload_time.get());
        paramObject.c(paramFromServiceMsg.int64_save_time.get());
        if (paramObject.a() != 0) {
          bool1 = false;
        }
        a(i, paramToServiceMsg, bool1, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleSendFileRequest. guildId: ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          ((StringBuilder)localObject).append(", channelId: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("GuildFileHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
        a(i, paramToServiceMsg, false, null);
        return;
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleUploadFileSuccRequest seq not find seq = ");
    paramToServiceMsg.append(i);
    QLog.e("GuildFileHandler", 1, paramToServiceMsg.toString());
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("seq");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    boolean bool2 = this.d.containsKey(Integer.valueOf(i));
    boolean bool1 = true;
    if ((bool2) && (this.d.get(Integer.valueOf(i)) != null))
    {
      paramToServiceMsg = (IGuildPreviewThumbReqCallback)this.d.get(Integer.valueOf(i));
      if (paramObject == null)
      {
        a(i, false, paramToServiceMsg, null);
        return;
      }
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        int j = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (j != 0)
        {
          a(i, false, paramToServiceMsg, null);
          return;
        }
        oidb_0xfc2.RspBody localRspBody = new oidb_0xfc2.RspBody();
        if ((((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)) {
          try
          {
            localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.i("GuildFileHandler", 2, paramFromServiceMsg.toString());
            a(i, false, paramToServiceMsg, null);
            return;
          }
        }
        paramObject = new UFTGuildPreviewThumbRsp();
        paramObject.a(paramFromServiceMsg);
        paramObject.b(str);
        paramObject.a(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get());
        paramObject.c(((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get());
        paramObject.b(localRspBody.msg_bus_type.get());
        paramFromServiceMsg = (oidb_0xfc2.DownloadInfo)((oidb_0xfc2.ApplyPreviewRsp)localRspBody.msg_apply_preview_rsp.get()).msg_download_info.get();
        paramObject.a(ByteStringMicro.copyFrom(paramFromServiceMsg.bytes_download_key.get().toByteArray()));
        paramObject.a(paramFromServiceMsg.msg_out_addr.get());
        paramObject.b(paramFromServiceMsg.msg_inner_addr.get());
        paramObject.c(paramFromServiceMsg.msg_out_addr_ipv6.get());
        paramObject.d(paramFromServiceMsg.str_download_domain.get());
        paramObject.e(paramFromServiceMsg.str_download_url.get());
        paramObject.f(paramFromServiceMsg.str_cookie.get());
        if (j != 0) {
          bool1 = false;
        }
        a(i, bool1, paramToServiceMsg, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handlePreviewVideoThumbRequest. guildId: ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          ((StringBuilder)localObject).append(", channelId: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("GuildFileHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
        a(i, false, paramToServiceMsg, null);
        return;
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handlePreviewVideoThumbRequest seq not find seq = ");
    paramToServiceMsg.append(i);
    QLog.e("GuildFileHandler", 1, paramToServiceMsg.toString());
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("seq");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    boolean bool2 = this.e.containsKey(Integer.valueOf(i));
    boolean bool1 = true;
    if ((bool2) && (this.e.get(Integer.valueOf(i)) != null))
    {
      paramToServiceMsg = (IGuildPreviewThumbReqCallback)this.e.get(Integer.valueOf(i));
      if (paramObject == null)
      {
        b(i, false, paramToServiceMsg, null);
        return;
      }
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        int j = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (j != 0)
        {
          b(i, false, paramToServiceMsg, null);
          return;
        }
        oidb_0xfc2.RspBody localRspBody = new oidb_0xfc2.RspBody();
        if ((((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)) {
          try
          {
            localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.i("GuildFileHandler", 2, paramFromServiceMsg.toString());
            a(i, false, paramToServiceMsg, null);
            return;
          }
        }
        paramObject = new UFTGuildPreviewThumbRsp();
        paramObject.a(paramFromServiceMsg);
        paramObject.b(str);
        paramObject.a(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get());
        paramObject.c(((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get());
        paramObject.b(localRspBody.msg_bus_type.get());
        paramFromServiceMsg = (oidb_0xfc2.DownloadInfo)((oidb_0xfc2.ApplyPreviewRsp)localRspBody.msg_apply_preview_rsp.get()).msg_download_info.get();
        paramObject.a(ByteStringMicro.copyFrom(paramFromServiceMsg.bytes_download_key.get().toByteArray()));
        paramObject.a(paramFromServiceMsg.msg_out_addr.get());
        paramObject.b(paramFromServiceMsg.msg_inner_addr.get());
        paramObject.c(paramFromServiceMsg.msg_out_addr_ipv6.get());
        paramObject.d(paramFromServiceMsg.str_download_domain.get());
        paramObject.e(paramFromServiceMsg.str_download_url.get());
        paramObject.f(paramFromServiceMsg.str_cookie.get());
        if (j != 0) {
          bool1 = false;
        }
        b(i, bool1, paramToServiceMsg, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handlePreviewVideoThumbRequest. guildId: ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          ((StringBuilder)localObject).append(", channelId: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("GuildFileHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
        b(i, false, paramToServiceMsg, null);
        return;
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handlePreviewVideoThumbRequest seq not find seq = ");
    paramToServiceMsg.append(i);
    QLog.e("GuildFileHandler", 1, paramToServiceMsg.toString());
  }
  
  public void a(UFTGuildDownloadReq paramUFTGuildDownloadReq, IGuildDownloadReqCallback paramIGuildDownloadReqCallback)
  {
    if (paramUFTGuildDownloadReq == null) {
      return;
    }
    Object localObject1 = new oidb_0xfc2.ReqBody();
    ((oidb_0xfc2.ReqBody)localObject1).msg_cmd.set(1200);
    ((oidb_0xfc2.ReqBody)localObject1).msg_bus_type.set(paramUFTGuildDownloadReq.b());
    Object localObject2 = new oidb_0xfc2.ChannelInfo();
    ((oidb_0xfc2.ChannelInfo)localObject2).uint64_guild_id.set(Long.parseLong(paramUFTGuildDownloadReq.c()));
    ((oidb_0xfc2.ChannelInfo)localObject2).uint64_channel_id.set(Long.parseLong(paramUFTGuildDownloadReq.d()));
    ((oidb_0xfc2.ReqBody)localObject1).msg_channel_info.set((MessageMicro)localObject2);
    ((oidb_0xfc2.ReqBody)localObject1).msg_terminal_type.set(2);
    localObject2 = new oidb_0xfc2.ApplyDownloadReq();
    ((oidb_0xfc2.ApplyDownloadReq)localObject2).str_fileid.set(paramUFTGuildDownloadReq.e());
    ((oidb_0xfc2.ApplyDownloadReq)localObject2).uint32_support_encrypt.set(paramUFTGuildDownloadReq.f());
    ((oidb_0xfc2.ReqBody)localObject1).msg_apply_download_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(4034);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xfc2.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvcTrpcTcp.0xfc2_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("seq", paramUFTGuildDownloadReq.a());
    ((ToServiceMsg)localObject1).extraData.putString("guildId", paramUFTGuildDownloadReq.c());
    ((ToServiceMsg)localObject1).extraData.putString("channelId", paramUFTGuildDownloadReq.d());
    ((ToServiceMsg)localObject1).extraData.putString("sub_cmd", "sub_cmd_download_file_request");
    this.c.put(Integer.valueOf(paramUFTGuildDownloadReq.a()), paramIGuildDownloadReqCallback);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(UFTGuildPreviewThumbReq paramUFTGuildPreviewThumbReq, IGuildPreviewThumbReqCallback paramIGuildPreviewThumbReqCallback)
  {
    if (a(paramUFTGuildPreviewThumbReq, paramIGuildPreviewThumbReqCallback, "sub_cmd_preview_video_thumb_request")) {
      this.d.put(Integer.valueOf(paramUFTGuildPreviewThumbReq.a()), paramIGuildPreviewThumbReqCallback);
    }
  }
  
  public void a(UFTGuildUploadReq paramUFTGuildUploadReq, IGuildUploadReqCallback paramIGuildUploadReqCallback)
  {
    if (paramUFTGuildUploadReq == null) {
      return;
    }
    Object localObject1 = new oidb_0xfc2.ReqBody();
    ((oidb_0xfc2.ReqBody)localObject1).msg_cmd.set(1700);
    ((oidb_0xfc2.ReqBody)localObject1).msg_bus_type.set(paramUFTGuildUploadReq.b());
    Object localObject2 = new oidb_0xfc2.ChannelInfo();
    ((oidb_0xfc2.ChannelInfo)localObject2).uint64_guild_id.set(Long.parseLong(paramUFTGuildUploadReq.c()));
    ((oidb_0xfc2.ChannelInfo)localObject2).uint64_channel_id.set(Long.parseLong(paramUFTGuildUploadReq.d()));
    ((oidb_0xfc2.ReqBody)localObject1).msg_channel_info.set((MessageMicro)localObject2);
    ((oidb_0xfc2.ReqBody)localObject1).msg_terminal_type.set(2);
    localObject2 = new oidb_0xfc2.ApplyUploadReq();
    ((oidb_0xfc2.ApplyUploadReq)localObject2).uint64_file_size.set(paramUFTGuildUploadReq.e());
    ((oidb_0xfc2.ApplyUploadReq)localObject2).str_file_name.set(paramUFTGuildUploadReq.f());
    ((oidb_0xfc2.ApplyUploadReq)localObject2).uint32_content_type.set(paramUFTGuildUploadReq.h());
    ((oidb_0xfc2.ApplyUploadReq)localObject2).bytes_md5.set(ByteStringMicro.copyFrom(paramUFTGuildUploadReq.i()));
    ((oidb_0xfc2.ApplyUploadReq)localObject2).bytes_sha.set(ByteStringMicro.copyFrom(paramUFTGuildUploadReq.j()));
    ((oidb_0xfc2.ReqBody)localObject1).msg_apply_upload_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(4034);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xfc2.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvcTrpcTcp.0xfc2_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("seq", paramUFTGuildUploadReq.a());
    ((ToServiceMsg)localObject1).extraData.putString("guildId", paramUFTGuildUploadReq.c());
    ((ToServiceMsg)localObject1).extraData.putString("channelId", paramUFTGuildUploadReq.d());
    ((ToServiceMsg)localObject1).extraData.putString("sub_cmd", "sub_cmd_upload_file_request");
    this.a.put(Integer.valueOf(paramUFTGuildUploadReq.a()), paramIGuildUploadReqCallback);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(UFTGuildUploadSuccReq paramUFTGuildUploadSuccReq, IGuildUploadSuccReqCallback paramIGuildUploadSuccReqCallback)
  {
    if (paramUFTGuildUploadSuccReq != null)
    {
      if (paramIGuildUploadSuccReqCallback == null) {
        return;
      }
      Object localObject1 = new oidb_0xfc2.ReqBody();
      ((oidb_0xfc2.ReqBody)localObject1).msg_cmd.set(800);
      ((oidb_0xfc2.ReqBody)localObject1).msg_bus_type.set(paramUFTGuildUploadSuccReq.b());
      ((oidb_0xfc2.ReqBody)localObject1).msg_terminal_type.set(2);
      Object localObject2 = new oidb_0xfc2.ChannelInfo();
      ((oidb_0xfc2.ChannelInfo)localObject2).uint64_guild_id.set(Long.parseLong(paramUFTGuildUploadSuccReq.c()));
      ((oidb_0xfc2.ChannelInfo)localObject2).uint64_channel_id.set(Long.parseLong(paramUFTGuildUploadSuccReq.d()));
      ((oidb_0xfc2.ReqBody)localObject1).msg_channel_info.set((MessageMicro)localObject2);
      localObject2 = new oidb_0xfc2.UploadCompletedReq();
      ((oidb_0xfc2.UploadCompletedReq)localObject2).str_fileid.set(paramUFTGuildUploadSuccReq.e());
      ((oidb_0xfc2.UploadCompletedReq)localObject2).uint64_random.set(paramUFTGuildUploadSuccReq.f());
      ((oidb_0xfc2.ReqBody)localObject1).msg_upload_completed_req.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(4034);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xfc2.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvcTrpcTcp.0xfc2_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("seq", paramUFTGuildUploadSuccReq.a());
      ((ToServiceMsg)localObject1).extraData.putString("guildId", paramUFTGuildUploadSuccReq.c());
      ((ToServiceMsg)localObject1).extraData.putString("channelId", paramUFTGuildUploadSuccReq.d());
      ((ToServiceMsg)localObject1).extraData.putString("sub_cmd", "sub_cmd_upload_file_succ_request");
      this.b.put(Integer.valueOf(paramUFTGuildUploadSuccReq.a()), paramIGuildUploadSuccReqCallback);
      sendPbReq((ToServiceMsg)localObject1);
    }
  }
  
  public void b(UFTGuildPreviewThumbReq paramUFTGuildPreviewThumbReq, IGuildPreviewThumbReqCallback paramIGuildPreviewThumbReqCallback)
  {
    if (a(paramUFTGuildPreviewThumbReq, paramIGuildPreviewThumbReqCallback, "sub_cmd_preview_image_thumb_request")) {
      this.e.put(Integer.valueOf(paramUFTGuildPreviewThumbReq.a()), paramIGuildPreviewThumbReqCallback);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xfc2_0");
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xfc2_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildFileObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.clear();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("GuildFileHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (str.equals("OidbSvcTrpcTcp.0xfc2_0"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equals("OidbSvcTrpcTcp.0xfc2_1")) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildFileHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.GuildFileHandler
 * JD-Core Version:    0.7.0.1
 */