package com.tencent.mobileqq.transfile;

import airv;
import airw;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.ReqStoryPic;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.wstt.SSCM.SSCM;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.HashMap;

public class StoryUploadProcessor
  extends BaseUploadProcessor
{
  public static String a;
  private long jdField_a_of_type_Long;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private long jdField_b_of_type_Long;
  public String b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  public String m;
  public String n;
  private String o = "Q.qqstory.publish.upload";
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.StoryUploadProcessor";
  }
  
  public StoryUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = this;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = paramTransferRequest.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_JavaLangString = this.o + ".StoryUploadProcessor";
  }
  
  public static int a(int paramInt)
  {
    return 95000000 + paramInt;
  }
  
  private int a(String paramString)
  {
    String str = com.tencent.biz.qqstory.utils.FileUtils.a(paramString);
    long l1 = 0L;
    try
    {
      l2 = Long.valueOf(str.substring(0, str.indexOf("_"))).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.c(jdField_a_of_type_JavaLangString, "exception", localException);
      }
      if (l1 <= 0L) {
        break label173;
      }
      long l2 = (System.currentTimeMillis() - l1) / 24L / 60L / 60L / 1000L;
      l1 = l2;
      if (l2 <= 30L) {
        break label166;
      }
      l1 = 30L;
      return (int)(l1 + 999000L);
    }
    l2 = com.tencent.biz.qqstory.utils.FileUtils.b(QQStoryConstant.jdField_c_of_type_JavaLangString);
    SLog.e(jdField_a_of_type_JavaLangString, "orig file create time:%d, flag file create time:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((l2 == 0L) || ((l1 > 0L) && (l2 > l1)))
    {
      SLog.e(jdField_a_of_type_JavaLangString, "your file delete by software %s", new Object[] { paramString });
      return 940017;
    }
    label166:
    label173:
    return 9071;
  }
  
  private String c()
  {
    return String.format("sdcard free size:%d, upload dir exist:%b ", new Object[] { Long.valueOf(com.tencent.biz.qqstory.utils.FileUtils.a()), Boolean.valueOf(com.tencent.mobileqq.utils.FileUtils.a(QQStoryConstant.jdField_c_of_type_JavaLangString)) });
  }
  
  public static void q()
  {
    Bosses.get().postLightWeightJob(new airw(), 0);
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.q - paramLong;
    if (!this.d) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.q, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.i) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
      return;
    }
    int j = this.jdField_m_of_type_Int;
    int i;
    label59:
    String str;
    label82:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.jdField_m_of_type_Int = (i | j);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int != 196610) {
        break label226;
      }
      str = "actStoryPicUpload";
      this.l = System.currentTimeMillis();
      l = (System.nanoTime() - this.k) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_sessionKey", "null");
      if (!paramBoolean) {
        break label299;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int != 196609) {
        break label247;
      }
      StoryReportor.b("publish_story", "publish_video", 0, 0, new String[] { String.valueOf(this.q), String.valueOf(this.l - this.jdField_b_of_type_Long), StoryReportor.a(BaseApplication.getContext()), this.n });
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break label59;
      label226:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int != 196609) {
        break;
      }
      str = "actStoryVideoUpload";
      break label82;
      label247:
      StoryReportor.b("publish_story", "publish_thumbnail", 0, 0, new String[] { String.valueOf(this.q), String.valueOf(this.l - this.jdField_b_of_type_Long), StoryReportor.a(BaseApplication.getContext()) });
      continue;
      label299:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int == 196609) {
        StoryReportor.b("publish_story", "publish_video", 0, a(this.jdField_j_of_type_Int), new String[] { String.valueOf(this.q), String.valueOf(this.l - this.jdField_b_of_type_Long), StoryReportor.a(BaseApplication.getContext()), this.jdField_j_of_type_JavaLangString });
      } else {
        StoryReportor.b("publish_story", "publish_thumbnail", 0, a(this.jdField_j_of_type_Int), new String[] { String.valueOf(this.q), String.valueOf(this.l - this.jdField_b_of_type_Long), StoryReportor.a(BaseApplication.getContext()), this.jdField_j_of_type_JavaLangString });
      }
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void an_()
  {
    SLog.d(jdField_a_of_type_JavaLangString, "send file %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i });
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    airv localairv = new airv(this, SystemClock.uptimeMillis());
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int == 196610)
    {
      i = 34;
      qqstory_bhd_upload_pic.ReqStoryPic localReqStoryPic = new qqstory_bhd_upload_pic.ReqStoryPic();
      localReqStoryPic.platform.set(2);
      localReqStoryPic.tojpg.set(0);
      localReqStoryPic.version.set(ByteStringMicro.copyFromUtf8("7.6.3"));
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = localReqStoryPic.toByteArray();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Int = i;
      try
      {
        if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getHttpconn_sig_session() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getHttpconn_sig_session().length;
          this.jdField_c_of_type_ArrayOfByte = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getHttpconn_sig_session(), 0, this.jdField_c_of_type_ArrayOfByte, 0, j);
        }
        if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getSessionKey() != null)
        {
          j = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getSessionKey().length;
          this.jdField_b_of_type_ArrayOfByte = new byte[j];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getSessionKey(), 0, this.jdField_b_of_type_ArrayOfByte, 0, j);
        }
        if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length == 0) || (this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length == 0)) {
          HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i, (int)this.r, this.jdField_a_of_type_ArrayOfByte, localairv, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte, false);
        int j = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        SLog.c(jdField_a_of_type_JavaLangString, "Transaction submit RetCode:" + j + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.g + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + i);
        if (j != 0)
        {
          a(j, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
        }
        return;
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int == 196609) {
        i = 37;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int == 327681) {
        i = 57;
      }
    }
  }
  
  public void ap_()
  {
    super.ap_();
    SLog.d(jdField_a_of_type_JavaLangString, "start upload %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i });
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!e()))
    {
      b(940006, "make md5 fail");
      d();
      return;
    }
    if (!NetworkUtils.a(QQStoryContext.a().a()))
    {
      b(880001, "no network");
      d();
      return;
    }
    an_();
  }
  
  public int b()
  {
    SLog.d(jdField_a_of_type_JavaLangString, "resume %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i });
    f();
    return 0;
  }
  
  public int c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
    if (TextUtils.isEmpty(str))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      b(a(str), c() + "sendFile not exist " + str);
      d();
      return -1;
    }
    if (!localFile.canRead())
    {
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l;
    this.q = l;
    SLog.a(jdField_a_of_type_JavaLangString, "upload file size %d, file %s", Long.valueOf(this.q), str);
    if (l <= 0L)
    {
      b(a(str), c() + "sendFile size empty " + str);
      d();
      return -1;
    }
    return super.c();
  }
  
  public void d()
  {
    super.d();
    d(1005);
    SLog.d(jdField_a_of_type_JavaLangString, "error errCode:%d,errDesc:%s, %s", new Object[] { Integer.valueOf(this.jdField_j_of_type_Int), this.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i });
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = a(this.jdField_j_of_type_Int);
      localSendResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public void e()
  {
    super.e();
    d(1003);
    SLog.d(jdField_a_of_type_JavaLangString, "success path:%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i });
    UpCallBack.SendResult localSendResult;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int != 196610) {
        break label91;
      }
    }
    for (localSendResult.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;; localSendResult.jdField_b_of_type_JavaLangString = this.n)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      return;
      label91:
      localSendResult.jdField_c_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StoryUploadProcessor
 * JD-Core Version:    0.7.0.1
 */