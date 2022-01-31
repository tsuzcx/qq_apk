package com.tencent.mobileqq.transfile;

import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;

public class JSPttUploadProcessor
  extends BaseUploadProcessor
{
  public JSPttUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!e()))
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    f();
  }
  
  private int d()
  {
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
    if ((str == null) || ("".equals(str)))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    if (str != null)
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        b(9042, a(new Exception("sendFile not exist " + str)));
        d();
        return -1;
      }
      if (!localFile.canRead())
      {
        b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.e = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a = l;
      this.q = l;
      if (l <= 0L)
      {
        b(9071, a(new Exception("file size 0 " + str)));
        d();
        return -1;
      }
    }
    return 0;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_a_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.jdField_a_of_type_Int);
    }
    localStringBuilder.append("/qqcommfileupload?ver=");
    localStringBuilder.append(100);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
    localStringBuilder.append("&filekey=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("&filesize=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("&bmd5=");
    localStringBuilder.append(MD5.toMD5(paramArrayOfByte));
    localStringBuilder.append("&range=");
    localStringBuilder.append(this.jdField_s_of_type_Long);
    localStringBuilder.append("&voice_codec=0");
    paramArrayOfByte = a(localStringBuilder.toString(), this.jdField_a_of_type_JavaUtilArrayList);
    BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    return paramArrayOfByte;
  }
  
  public void a(NetResp paramNetResp)
  {
    Object localObject1 = null;
    super.a(paramNetResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    int i = paramNetResp.jdField_c_of_type_Int;
    for (;;)
    {
      long l2;
      try
      {
        if (paramNetResp.jdField_a_of_type_Int != 0) {
          break label503;
        }
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null) {
          break label577;
        }
        l3 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != 9223372036854775807L))
        {
          a(this.b, paramNetResp, false);
          a(-9527, null, a(i, l3), this.b);
          d();
          return;
        }
        str2 = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range");
        if (str2 == null) {
          break label585;
        }
      }
      catch (Exception paramNetResp)
      {
        String str2;
        String str1;
        a(9343, AbstractImageDownloader.a(new Exception("decode unknown exception")), "", this.b);
        d();
        return;
      }
      try
      {
        i = Integer.parseInt(str2);
        l1 = i;
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          str1 = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
          localObject1 = str1;
          l2 = l1;
          if (str1 == null) {}
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      try
      {
        i = Integer.parseInt(str1);
        l2 = i;
        localObject1 = str1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        l2 = 9223372036854775807L;
        Object localObject2 = localException2;
        continue;
        b("decodeHttpResp", "from " + this.jdField_s_of_type_Long + " to " + l2 + " userReturnCode:" + l3);
        if (l2 > this.jdField_s_of_type_Long) {
          break label418;
        }
        if (this.jdField_s_of_type_Int >= 3) {
          break label458;
        }
        b("procHttpRespBody", "server offset rollback");
        this.jdField_s_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = l2;
        this.jdField_s_of_type_Long = l2;
        a(this.b, paramNetResp, true);
        if (l2 >= this.q) {
          break label498;
        }
        al_();
        return;
        a(this.b, paramNetResp, false);
        a(-9527, "", a(this.i, this.jdField_f_of_type_Int), this.b);
        d();
        return;
        e();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        a(this.b, paramNetResp, false);
        a(-9527, "no header range:" + str2 + " x-range:" + localObject1, a(this.i, this.g), this.b);
        PttInfoCollector.b(true);
        d();
        return;
      }
      label418:
      label458:
      label498:
      label503:
      if ((paramNetResp.b == 9364) && (this.jdField_l_of_type_Int < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_l_of_type_Int += 1;
        m();
        f();
        return;
      }
      a(this.b, paramNetResp, false);
      b(paramNetResp.b, paramNetResp.jdField_a_of_type_JavaLangString);
      d();
      return;
      label577:
      long l3 = 9223372036854775807L;
      continue;
      label585:
      long l1 = 9223372036854775807L;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        this.j = paramRichProtoReq.e;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.j);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (paramRichProtoReq.jdField_a_of_type_Boolean) {
            this.jdField_f_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_f_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            this.jdField_l_of_type_JavaLangString = paramRichProtoReq.b;
            this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
            this.jdField_s_of_type_Long = 0L;
            this.t = paramRichProtoReq.jdField_a_of_type_Int;
            PublicAccountH5AbilityForPtt.c(this.jdField_f_of_type_JavaLangString);
            al_();
          }
        }
        d();
      }
    }
  }
  
  public void an_()
  {
    super.an_();
    b(false);
  }
  
  public int c()
  {
    super.c();
    return d();
  }
  
  void d()
  {
    super.d();
    d(1005);
    a(false);
  }
  
  void e()
  {
    super.e();
    d(1003);
    a(true);
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PttUpReq localPttUpReq = new RichProto.RichProtoReq.PttUpReq();
    localPttUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localPttUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPttUpReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localPttUpReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPttUpReq.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localPttUpReq.b = ((int)this.q);
    localPttUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localPttUpReq.jdField_c_of_type_Int = 0;
    localPttUpReq.jdField_a_of_type_Int = 1;
    localPttUpReq.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.n;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_ptt_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPttUpReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!c())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localRichProtoReq.toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.JSPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */