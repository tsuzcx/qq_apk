package com.tencent.mobileqq.hotpic;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class HotVideoData$HotVideoGetUrlResult
{
  public int a;
  public String a;
  public ArrayList<ServerAddr> a;
  public boolean a;
  public String b;
  public String c;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localServerAddr.mIp);
      if (localServerAddr.port != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localServerAddr.port);
      }
      localStringBuilder.append("/");
    }
    for (;;)
    {
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
      if (!this.c.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.c);
      if (!this.c.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
  }
  
  public void a(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp)
  {
    int i = 0;
    StringBuilder localStringBuilder;
    if (HotVideoData.access$000())
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramShortVideoDownResp.mIpList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
      if (paramShortVideoDownResp.result != 0) {
        break label200;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onBusiProtoResp() cdn ---- mIpListSize:");
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label189;
        }
      }
    }
    for (;;)
    {
      QLog.d("HotVideoData", 2, i + " mHostType:" + paramShortVideoDownResp.mHostType + " domain:" + paramShortVideoDownResp.mDomain + " url:" + paramShortVideoDownResp.mUrl);
      QLog.d("HotVideoData", 2, "onBusiProtoResp() cdn ---- downResp.previewMd5:" + HexUtil.bytes2HexStr(paramShortVideoDownResp.md5));
      this.b = paramShortVideoDownResp.mUrl;
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramShortVideoDownResp.mIpv6List;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        break;
      }
      break;
      label189:
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    label200:
    this.jdField_a_of_type_Boolean = false;
    if (-5100026 == paramShortVideoDownResp.errCode)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 安全打击");
      }
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705646);
      return;
    }
    if ((-9527 == paramShortVideoDownResp.errCode) && ((paramShortVideoDownResp.errStr.equals("H_400_-5103017")) || (paramShortVideoDownResp.errStr.equals("H_400_-5103059"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + paramShortVideoDownResp.errCode);
      }
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705647);
      return;
    }
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlResult
 * JD-Core Version:    0.7.0.1
 */