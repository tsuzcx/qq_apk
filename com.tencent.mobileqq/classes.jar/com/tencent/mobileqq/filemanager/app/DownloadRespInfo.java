package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;

public class DownloadRespInfo
{
  public long a = 0L;
  public String b = null;
  public ByteStringMicro c = null;
  public String d = null;
  public short e = 0;
  public String f = null;
  public String g = null;
  public String h = null;
  public List<String> i = null;
  public String j = null;
  public String k = null;
  public String l = null;
  public String m = null;
  public short n = 0;
  public List<String> o = null;
  
  public static void a(DownloadRespInfo paramDownloadRespInfo, cmd0x346.ApplyDownloadRsp paramApplyDownloadRsp, boolean paramBoolean, String paramString)
  {
    if (paramDownloadRespInfo == null) {
      return;
    }
    if (paramApplyDownloadRsp == null) {
      return;
    }
    if (paramApplyDownloadRsp.int32_ret_code.has()) {
      paramDownloadRespInfo.a = paramApplyDownloadRsp.int32_ret_code.get();
    }
    if (paramApplyDownloadRsp.str_ret_msg.has()) {
      paramDownloadRespInfo.b = paramApplyDownloadRsp.str_ret_msg.get();
    }
    if (paramApplyDownloadRsp.msg_download_info.has())
    {
      cmd0x346.DownloadInfo localDownloadInfo = (cmd0x346.DownloadInfo)paramApplyDownloadRsp.msg_download_info.get();
      if (localDownloadInfo.bytes_download_key.has()) {
        paramDownloadRespInfo.c = localDownloadInfo.bytes_download_key.get();
      }
      if (localDownloadInfo.str_download_ip.has()) {
        paramDownloadRespInfo.d = localDownloadInfo.str_download_ip.get();
      } else if (localDownloadInfo.str_download_domain.has()) {
        paramDownloadRespInfo.d = localDownloadInfo.str_download_domain.get();
      } else {
        QLog.i("DownloadRespInfo", 1, "handleDownloadResp: has neither ip nor domain");
      }
      if (localDownloadInfo.uint32_port.has()) {
        paramDownloadRespInfo.e = ((short)localDownloadInfo.uint32_port.get());
      }
      if (paramBoolean)
      {
        if (localDownloadInfo.bytes_media_platform_download_key.has())
        {
          paramDownloadRespInfo.c = localDownloadInfo.bytes_media_platform_download_key.get();
          paramDownloadRespInfo.f = String.format("/asn.com/qqdownloadftnv5?ver=0&filetype=4001&openid=%s&rkey=%s", new Object[] { paramString, HexUtil.bytes2HexStr(paramDownloadRespInfo.c.toByteArray()) });
        }
      }
      else if (localDownloadInfo.str_download_url.has()) {
        paramDownloadRespInfo.f = localDownloadInfo.str_download_url.get();
      }
      if (localDownloadInfo.str_cookie.has())
      {
        paramString = new StringBuilder();
        paramString.append("FTN5K=");
        paramString.append(localDownloadInfo.str_cookie.get());
        paramDownloadRespInfo.g = paramString.toString();
      }
      if ((localDownloadInfo.rpt_str_downloadip_list.has()) && (localDownloadInfo.rpt_str_downloadip_list.get().size() > 0)) {
        paramDownloadRespInfo.i = localDownloadInfo.rpt_str_downloadip_list.get();
      }
      if (localDownloadInfo.str_https_download_domain.has()) {
        paramDownloadRespInfo.l = localDownloadInfo.str_https_download_domain.get();
      }
      if (localDownloadInfo.uint32_https_port.has()) {
        paramDownloadRespInfo.n = ((short)localDownloadInfo.uint32_https_port.get());
      }
      if (localDownloadInfo.str_download_dns.has()) {
        paramDownloadRespInfo.m = localDownloadInfo.str_download_dns.get();
      }
      if ((localDownloadInfo.str_downloadipv6_list.has()) && (localDownloadInfo.str_downloadipv6_list.get().size() > 0)) {
        paramDownloadRespInfo.o = localDownloadInfo.str_downloadipv6_list.get();
      }
    }
    if (paramApplyDownloadRsp.msg_file_info.has())
    {
      paramApplyDownloadRsp = (cmd0x346.FileInfo)paramApplyDownloadRsp.msg_file_info.get();
      if (paramApplyDownloadRsp.str_file_name.has())
      {
        paramDownloadRespInfo.h = paramApplyDownloadRsp.str_file_name.get();
        paramDownloadRespInfo.h = QQFileManagerUtil.n(paramDownloadRespInfo.h);
      }
      paramDownloadRespInfo.j = FileHttpUtils.a(paramApplyDownloadRsp.bytes_10m_md5.get().toByteArray());
      paramString = new StringBuilder();
      paramString.append("file md5:");
      paramString.append(paramDownloadRespInfo.j);
      QLog.i("DownloadRespInfo", 1, paramString.toString());
      paramDownloadRespInfo.k = FileHttpUtils.a(paramApplyDownloadRsp.bytes_sha.get().toByteArray());
      paramApplyDownloadRsp = new StringBuilder();
      paramApplyDownloadRsp.append("file sha:");
      paramApplyDownloadRsp.append(paramDownloadRespInfo.k);
      QLog.i("DownloadRespInfo", 1, paramApplyDownloadRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.DownloadRespInfo
 * JD-Core Version:    0.7.0.1
 */