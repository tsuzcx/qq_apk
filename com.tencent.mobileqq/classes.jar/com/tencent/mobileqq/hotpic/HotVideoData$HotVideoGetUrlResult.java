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
    else
    {
      if (!this.c.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.c);
      if (!this.c.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public void a(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp)
  {
    Object localObject;
    if (HotVideoData.access$000())
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramShortVideoDownResp.mIpList;
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null) {
        ((ArrayList)localObject).size();
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramShortVideoDownResp.mIpv6List;
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null) {
        ((ArrayList)localObject).size();
      }
    }
    int j = paramShortVideoDownResp.result;
    int i = 0;
    if (j == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onBusiProtoResp() cdn ---- mIpListSize:");
        ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        if (localArrayList != null) {
          i = localArrayList.size();
        }
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" mHostType:");
        ((StringBuilder)localObject).append(paramShortVideoDownResp.mHostType);
        ((StringBuilder)localObject).append(" domain:");
        ((StringBuilder)localObject).append(paramShortVideoDownResp.mDomain);
        ((StringBuilder)localObject).append(" url:");
        ((StringBuilder)localObject).append(paramShortVideoDownResp.mUrl);
        QLog.d("HotVideoData", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onBusiProtoResp() cdn ---- downResp.previewMd5:");
        ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramShortVideoDownResp.md5));
        QLog.d("HotVideoData", 2, ((StringBuilder)localObject).toString());
      }
      this.b = paramShortVideoDownResp.mUrl;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (-5100026 == paramShortVideoDownResp.errCode)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 安全打击");
      }
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705712);
      return;
    }
    if ((-9527 == paramShortVideoDownResp.errCode) && ((paramShortVideoDownResp.errStr.equals("H_400_-5103017")) || (paramShortVideoDownResp.errStr.equals("H_400_-5103059"))))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onBusiProtoResp()---- 视频文件过期errCode=");
        ((StringBuilder)localObject).append(paramShortVideoDownResp.errCode);
        QLog.d("HotVideoData", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705713);
      return;
    }
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlResult
 * JD-Core Version:    0.7.0.1
 */