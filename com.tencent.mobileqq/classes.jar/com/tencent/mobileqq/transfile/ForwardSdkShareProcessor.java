package com.tencent.mobileqq.transfile;

import aibh;
import aibi;
import aibk;
import aibm;
import aibo;
import aibr;
import aibt;
import aibu;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardConstants;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForwardSdkShareProcessor
  extends BaseTransProcessor
  implements ForwardConstants
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  private aibi jdField_a_of_type_Aibi;
  private aibr jdField_a_of_type_Aibr;
  public Context a;
  public QQAppInterface a;
  private TransferRequest.AppInfo jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String d;
  private String e;
  private String f;
  private String g;
  private String l;
  private int o;
  
  public ForwardSdkShareProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.ShareExtraInfo))
    {
      paramBaseTransFileController = (TransferRequest.ShareExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = paramBaseTransFileController.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramBaseTransFileController.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = paramBaseTransFileController.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramBaseTransFileController.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = paramBaseTransFileController.jdField_d_of_type_JavaLangString;
      this.g = paramBaseTransFileController.f;
      this.jdField_b_of_type_Long = paramBaseTransFileController.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangString = paramBaseTransFileController.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo = paramBaseTransFileController.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo;
      if (paramBaseTransFileController.jdField_c_of_type_Int != 2) {
        break label268;
      }
      this.e = paramBaseTransFileController.e;
      paramTransferRequest = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if ((paramBaseTransFileController.jdField_c_of_type_Int != 1) && (paramBaseTransFileController.jdField_c_of_type_Int != 3)) {
        break label279;
      }
      bool1 = true;
      label221:
      paramTransferRequest.set(bool1);
      paramTransferRequest = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramBaseTransFileController.jdField_c_of_type_Int != 1) {
        break label284;
      }
      bool1 = true;
      label241:
      paramTransferRequest.set(bool1);
      paramTransferRequest = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramBaseTransFileController.jdField_d_of_type_Int != 1) {
        break label289;
      }
    }
    label268:
    label279:
    label284:
    label289:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramTransferRequest.set(bool1);
      return;
      this.f = paramBaseTransFileController.e;
      break;
      bool1 = false;
      break label221;
      bool1 = false;
      break label241;
    }
  }
  
  public static TransferRequest a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    TransferRequest.ShareExtraInfo localShareExtraInfo = new TransferRequest.ShareExtraInfo();
    localShareExtraInfo.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localShareExtraInfo.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localShareExtraInfo.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localShareExtraInfo.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localShareExtraInfo.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localShareExtraInfo.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localShareExtraInfo.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localShareExtraInfo.e = paramAbsShareMsg.mContentCover;
    localShareExtraInfo.f = paramAbsShareMsg.mContentSrc;
    localShareExtraInfo.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localShareExtraInfo.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localShareExtraInfo.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo = new TransferRequest.AppInfo();
    localShareExtraInfo.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localShareExtraInfo.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localShareExtraInfo.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo.e = paramAbsShareMsg.shareData.sourceIconBig;
    localShareExtraInfo.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localShareExtraInfo.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localShareExtraInfo.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new TransferRequest();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.jdField_e_of_type_Int = 11;
    paramAbsShareMsg.jdField_e_of_type_Boolean = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localShareExtraInfo;
    return paramAbsShareMsg;
  }
  
  private void f()
  {
    if (this.jdField_o_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Aibi != null) {
      this.jdField_a_of_type_Aibi.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new aibh(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Aibi != null) {
      this.jdField_a_of_type_Aibi.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void an_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "start");
    }
    this.jdField_a_of_type_Aibi = new aibt(this);
    aibu localaibu = new aibu(this);
    this.jdField_a_of_type_Aibi.a(new aibi[] { localaibu });
    aibm localaibm = new aibm(this);
    aibk localaibk = new aibk(this);
    aibo localaibo = new aibo(this);
    if ((!localaibu.a()) && (localaibo.a())) {
      localaibu.a(new aibi[] { localaibk, localaibm });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Aibi.a();
      d(1001);
      a(1002, MessageHandler.jdField_e_of_type_Int);
      return;
      localaibu.a(new aibi[] { localaibk, localaibo });
      this.jdField_a_of_type_Aibr = new aibr(this);
      localaibo.a(new aibi[] { this.jdField_a_of_type_Aibr, localaibm });
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "resume");
    }
    if (this.k)
    {
      this.k = false;
      this.jdField_o_of_type_Boolean = false;
      an_();
    }
    return 0;
  }
  
  public int c()
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.ShareExtraInfo))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "SdkShareInfo null");
      b(9302, a(new Exception("SdkShareInfo null")));
      d();
      return -1;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "share targetUrl null");
      b(9302, a(new Exception("share targetUrl null")));
      d();
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppInfo == null)
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "mAppInfo null");
      b(9302, a(new Exception("mAppInfo null")));
      d();
      return -1;
    }
    if (!ForwardUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
    {
      String str = "err forwardType=" + this.jdField_a_of_type_Int + ",serviceType=" + this.jdField_b_of_type_Int;
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + str);
      b(9302, a(new Exception(str)));
      d();
      return -1;
    }
    return 0;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "pause");
    }
    if (!this.k)
    {
      this.k = true;
      if (this.jdField_a_of_type_Aibi != null) {
        this.jdField_a_of_type_Aibi.e();
      }
    }
  }
  
  public void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.j + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Aibi != null) {
      this.jdField_a_of_type_Aibi.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, 32768, this.j);
    d(1005);
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "56");
    localBundle.putString("intext_1", "" + this.j);
    localBundle.putString("intext_5", "" + l1);
    ReportCenter.a().a(localBundle, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
  
  public void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "OnSuccess, cost=" + l1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    ReportCenter.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor
 * JD-Core Version:    0.7.0.1
 */