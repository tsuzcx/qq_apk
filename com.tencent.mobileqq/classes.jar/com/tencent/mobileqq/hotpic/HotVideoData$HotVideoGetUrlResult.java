package com.tencent.mobileqq.hotpic;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class HotVideoData$HotVideoGetUrlResult
{
  public int a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
      if (localServerAddr.jdField_a_of_type_Int != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localServerAddr.jdField_a_of_type_Int);
      }
      localStringBuilder.append("/");
    }
    for (;;)
    {
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
      if (!this.jdField_c_of_type_JavaLangString.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      if (!this.jdField_c_of_type_JavaLangString.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
  }
  
  public void a(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp)
  {
    this.jdField_a_of_type_Int = 0;
    if (paramShortVideoDownResp.jdField_a_of_type_Int == 1)
    {
      ArrayList localArrayList = InnerDns.a().a(paramShortVideoDownResp.b, 1005);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          ServerAddr localServerAddr = new ServerAddr();
          localServerAddr.jdField_a_of_type_JavaLangString = ((String)localArrayList.get(i));
          localServerAddr.jdField_a_of_type_Int = 80;
          this.jdField_a_of_type_JavaUtilArrayList.add(localServerAddr);
          i += 1;
        }
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_c_of_type_JavaLangString = paramShortVideoDownResp.b;
    }
    while (paramShortVideoDownResp.jdField_c_of_type_Int == 0)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("HotVideoData", 2, "onBusiProtoResp() cdn ---- mIpListSize:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " isDomain:" + paramShortVideoDownResp.jdField_a_of_type_Int + " domain:" + paramShortVideoDownResp.b + " url:" + paramShortVideoDownResp.jdField_c_of_type_JavaLangString);
        QLog.d("HotVideoData", 2, "onBusiProtoResp() cdn ---- downResp.previewMd5:" + HexUtil.bytes2HexStr(paramShortVideoDownResp.jdField_a_of_type_ArrayOfByte));
      }
      this.b = paramShortVideoDownResp.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramShortVideoDownResp.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_Boolean = false;
    if (-5100026 == paramShortVideoDownResp.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 安全打击");
      }
      this.jdField_a_of_type_JavaLangString = "安全打击";
      return;
    }
    if ((-9527 == paramShortVideoDownResp.d) && ((paramShortVideoDownResp.g.equals("H_400_-5103017")) || (paramShortVideoDownResp.g.equals("H_400_-5103059"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + paramShortVideoDownResp.d);
      }
      this.jdField_a_of_type_JavaLangString = "视频文件过期";
      return;
    }
    this.jdField_a_of_type_JavaLangString = "申请信令失败";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlResult
 * JD-Core Version:    0.7.0.1
 */