package com.tencent.mobileqq.transfile;

import aivn;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.NearbyPeoplePicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.NearbyPeoplePicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class NearbyPeoplePhotoUploadProcessor
  extends BaseUploadProcessor
{
  public static int a;
  private Transaction a;
  public String a;
  public String b;
  private byte[] b;
  public String m;
  public String n;
  public String o;
  
  public NearbyPeoplePhotoUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = this;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = paramTransferRequest.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaLangString = paramTransferRequest.a();
  }
  
  private boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " src:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i);
    }
    Object localObject = new CompressInfo(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i, 0);
    ((CompressInfo)localObject).f = 0;
    CompressOperator.a((CompressInfo)localObject);
    if (TextUtils.isEmpty(((CompressInfo)localObject).e)) {
      d();
    }
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "personality_label start compress dst:" + ((CompressInfo)localObject).e);
      }
      if (TextUtils.equals(((CompressInfo)localObject).e, ((CompressInfo)localObject).jdField_c_of_type_JavaLangString)) {
        break;
      }
      FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      TransferRequest localTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
      localObject = ((CompressInfo)localObject).e;
      localTransferRequest.i = ((String)localObject);
      localFileMsg.jdField_c_of_type_JavaLangString = ((String)localObject);
    } while (c() != 0);
    return false;
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq.NearbyPeoplePicUpReq localNearbyPeoplePicUpReq = new RichProto.RichProtoReq.NearbyPeoplePicUpReq();
    localNearbyPeoplePicUpReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b == 22)
    {
      localRichProtoReq.jdField_a_of_type_JavaLangString = "friend_avatar_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localNearbyPeoplePicUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
      if (c()) {
        break label114;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label114:
    do
    {
      return;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "nearby_people_pic_up";
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localRichProtoReq.toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
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
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.NearbyPeoplePicUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.jdField_c_of_type_Int);
        }
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_b_of_type_ArrayOfByte = paramRichProtoReq.jdField_a_of_type_ArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.jdField_b_of_type_ArrayOfByte);
          }
          ap_();
        }
        for (;;)
        {
          i += 1;
          break;
          d();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) {}
    while ((this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    String str1;
    label100:
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      str1 = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b != 8) && (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b != 64)) {
        break label190;
      }
      str1 = "actNearbyPeoplePicUpload";
      this.l = System.currentTimeMillis();
      l = (System.nanoTime() - this.k) / 1000000L;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        break label462;
      }
      str2 = "null";
      label139:
      localHashMap.put("param_sessionKey", str2);
      if (!paramBoolean) {
        break label474;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label190:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 21)
      {
        str1 = "actFreshNewsPicUpload";
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 22)
      {
        str1 = "actFriendAvatarUpload";
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 34)
      {
        str1 = "C2BUploadFile";
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 35)
      {
        str1 = "actProfileCoverPicUpload";
        break label100;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 36) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 37) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 38) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 48))
      {
        str1 = "actBaseDynamicAvatarUpload";
        break label100;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 39) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 40) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 41))
      {
        str1 = "actNearbyDynamicAvatarUpload";
        break label100;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 50) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 51))
      {
        str1 = "actHongbaoStarPhotoUpload";
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 54)
      {
        str1 = "actCampusTopicPicUpload";
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 56)
      {
        str1 = "actPersonalityLabelPhotoUpload";
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b != 23) {
        break label100;
      }
      str1 = "actExtendFriendSoundUpload";
      break label100;
      label462:
      str2 = PkgTools.a(this.jdField_b_of_type_ArrayOfByte);
      break label139;
      label474:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void ap_()
  {
    int i = 21;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    aivn localaivn = new aivn(this, SystemClock.uptimeMillis());
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 8) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 64)) {
      i = 3;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), i, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i, (int)this.r, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, localaivn, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte);
      int j = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + j + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.g + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + i);
      }
      if (j != 0)
      {
        a(j, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 21) {
        i = 6;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 22) {
        i = 5;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 34) {
        i = 13;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b != 35) {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 36) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 37) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 38))
        {
          i = 23;
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 39) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 40) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 41))
        {
          i = 22;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 48)
        {
          i = 24;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 23)
        {
          i = 59;
          Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
          localCommFileExtReq.uint32_action_type.set(0);
          localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = localCommFileExtReq.toByteArray();
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 50) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 51))
        {
          i = 35;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 54)
        {
          i = 43;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 56)
        {
          i = 39;
        }
        else
        {
          i = -1;
        }
      }
    }
  }
  
  public void ar_()
  {
    super.ar_();
    d(1001);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.start()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 56) && (g())) {
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!e()))
    {
      d();
      return;
    }
    q();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.resume()");
    }
    f();
    q();
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
    long l = localFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l;
    this.q = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + str)));
      d();
      return -1;
    }
    return super.c();
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onError()---- errCode: " + this.jdField_j_of_type_Int + ", errDesc:" + this.jdField_j_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.jdField_j_of_type_Int;
      localSendResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, paramString);
    }
  }
  
  public void e()
  {
    super.e();
    d(1003);
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "onSuccess().");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */