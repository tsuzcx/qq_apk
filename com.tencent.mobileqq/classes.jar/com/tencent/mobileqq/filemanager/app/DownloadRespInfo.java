package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
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
  public long a;
  public ByteStringMicro a;
  public String a;
  public List<String> a;
  public short a;
  public String b;
  public List<String> b;
  public short b;
  public String c = null;
  public String d = null;
  public String e = null;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i = null;
  
  public DownloadRespInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_Short = 0;
    this.jdField_b_of_type_JavaUtilList = null;
  }
  
  public static void a(DownloadRespInfo paramDownloadRespInfo, cmd0x346.ApplyDownloadRsp paramApplyDownloadRsp, boolean paramBoolean, String paramString)
  {
    if (paramDownloadRespInfo == null) {
      break label4;
    }
    label4:
    while (paramApplyDownloadRsp == null) {
      return;
    }
    if (paramApplyDownloadRsp.int32_ret_code.has()) {
      paramDownloadRespInfo.jdField_a_of_type_Long = paramApplyDownloadRsp.int32_ret_code.get();
    }
    if (paramApplyDownloadRsp.str_ret_msg.has()) {
      paramDownloadRespInfo.jdField_a_of_type_JavaLangString = paramApplyDownloadRsp.str_ret_msg.get();
    }
    cmd0x346.DownloadInfo localDownloadInfo;
    if (paramApplyDownloadRsp.msg_download_info.has())
    {
      localDownloadInfo = (cmd0x346.DownloadInfo)paramApplyDownloadRsp.msg_download_info.get();
      if (localDownloadInfo.bytes_download_key.has()) {
        paramDownloadRespInfo.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = localDownloadInfo.bytes_download_key.get();
      }
      if (!localDownloadInfo.str_download_ip.has()) {
        break label534;
      }
      paramDownloadRespInfo.jdField_b_of_type_JavaLangString = localDownloadInfo.str_download_ip.get();
      label120:
      if (localDownloadInfo.uint32_port.has()) {
        paramDownloadRespInfo.jdField_a_of_type_Short = ((short)localDownloadInfo.uint32_port.get());
      }
      if (!paramBoolean) {
        break label571;
      }
      if (localDownloadInfo.bytes_media_platform_download_key.has())
      {
        paramDownloadRespInfo.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = localDownloadInfo.bytes_media_platform_download_key.get();
        paramDownloadRespInfo.c = String.format("/asn.com/qqdownloadftnv5?ver=0&filetype=4001&openid=%s&rkey=%s", new Object[] { paramString, HexUtil.bytes2HexStr(paramDownloadRespInfo.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toByteArray()) });
      }
    }
    for (;;)
    {
      if (localDownloadInfo.str_cookie.has()) {
        paramDownloadRespInfo.d = ("FTN5K=" + localDownloadInfo.str_cookie.get());
      }
      if ((localDownloadInfo.rpt_str_downloadip_list.has()) && (localDownloadInfo.rpt_str_downloadip_list.get().size() > 0)) {
        paramDownloadRespInfo.jdField_a_of_type_JavaUtilList = localDownloadInfo.rpt_str_downloadip_list.get();
      }
      if (localDownloadInfo.str_https_download_domain.has()) {
        paramDownloadRespInfo.h = localDownloadInfo.str_https_download_domain.get();
      }
      if (localDownloadInfo.uint32_https_port.has()) {
        paramDownloadRespInfo.jdField_b_of_type_Short = ((short)localDownloadInfo.uint32_https_port.get());
      }
      if (localDownloadInfo.str_download_dns.has()) {
        paramDownloadRespInfo.i = localDownloadInfo.str_download_dns.get();
      }
      if ((localDownloadInfo.str_downloadipv6_list.has()) && (localDownloadInfo.str_downloadipv6_list.get().size() > 0)) {
        paramDownloadRespInfo.jdField_b_of_type_JavaUtilList = localDownloadInfo.str_downloadipv6_list.get();
      }
      if (!paramApplyDownloadRsp.msg_file_info.has()) {
        break;
      }
      paramApplyDownloadRsp = (cmd0x346.FileInfo)paramApplyDownloadRsp.msg_file_info.get();
      if (paramApplyDownloadRsp.str_file_name.has())
      {
        paramDownloadRespInfo.e = paramApplyDownloadRsp.str_file_name.get();
        paramDownloadRespInfo.e = FileManagerUtil.a(paramDownloadRespInfo.e);
      }
      paramDownloadRespInfo.f = FileHttpUtils.a(paramApplyDownloadRsp.bytes_10m_md5.get().toByteArray());
      QLog.i("DownloadRespInfo", 1, "file md5:" + paramDownloadRespInfo.f);
      paramDownloadRespInfo.g = FileHttpUtils.a(paramApplyDownloadRsp.bytes_sha.get().toByteArray());
      QLog.i("DownloadRespInfo", 1, "file sha:" + paramDownloadRespInfo.g);
      return;
      label534:
      if (localDownloadInfo.str_download_domain.has())
      {
        paramDownloadRespInfo.jdField_b_of_type_JavaLangString = localDownloadInfo.str_download_domain.get();
        break label120;
      }
      QLog.i("DownloadRespInfo", 1, "handleDownloadResp: has neither ip nor domain");
      break label120;
      label571:
      if (localDownloadInfo.str_download_url.has()) {
        paramDownloadRespInfo.c = localDownloadInfo.str_download_url.get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.DownloadRespInfo
 * JD-Core Version:    0.7.0.1
 */