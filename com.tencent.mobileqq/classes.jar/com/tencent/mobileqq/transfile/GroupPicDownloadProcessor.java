package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPicDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.PicDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  long jdField_c_of_type_Long;
  byte[] jdField_c_of_type_ArrayOfByte;
  boolean q = true;
  
  public GroupPicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Long;
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.PicDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.e;
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_b_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            b("proUrl", "picResp.protocolType = " + paramRichProtoReq.jdField_a_of_type_Int);
          }
          if (paramRichProtoReq.jdField_a_of_type_Int == 1)
          {
            this.h = true;
            c(true);
          }
          for (;;)
          {
            i += 1;
            break;
            this.h = false;
            c(false);
          }
        }
        d();
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    String str;
    Object localObject1;
    if (!paramBoolean)
    {
      str = "Q.richmedia." + RichMediaUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) + "." + RichMediaUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("id:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject1).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject1).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d(str, 1, ((StringBuilder)localObject1).toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) || (this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    label285:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label1015;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 65537) {
        break label1007;
      }
      str = "actGroupPicSmallDownV1";
      l1 = (System.nanoTime() - this.k) / 1000000L;
      localObject1 = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo != null) {
        break label1043;
      }
      i = 0;
      label478:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l2 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailDesc", "" + this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_inQueueCost", "" + this.p);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromDns", "" + this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromSave", "" + this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encryptRollback", "" + this.jdField_g_of_type_Boolean + ",decryptErrorMsg:" + this.jdField_g_of_type_JavaLangString);
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_g_of_type_Boolean) {
        break label1054;
      }
      localObject1 = "1";
      label705:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.h) {
        break label1062;
      }
      localObject1 = "1";
      label734:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && (((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder != null))
      {
        localObject1 = (HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder).jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label1070;
      }
      i = 1;
      label812:
      if (i != 0)
      {
        i = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", String.valueOf(i));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).putAll(this.jdField_a_of_type_JavaUtilHashMap);
      if (!paramBoolean) {
        break label1075;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, l1, this.jdField_a_of_type_Long, (HashMap)localObject1, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label1007:
      str = "actGroupPicDownloadV1";
      break label285;
      label1015:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 65537) {}
      for (str = "actDiscussPicSmallDown";; str = "actDiscussPicDown") {
        break;
      }
      label1043:
      i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
      break label478;
      label1054:
      localObject1 = "0";
      break label705;
      label1062:
      localObject1 = "0";
      break label734;
      label1070:
      i = 0;
      break label812;
      label1075:
      if (this.jdField_j_of_type_Int != -9527) {
        ((HashMap)localObject1).remove("param_rspHeader");
      }
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      ((HashMap)localObject1).put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, l1, 0L, (HashMap)localObject1, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
  }
  
  public void ap_()
  {
    super.ap_();
    o();
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    this.jdField_a_of_type_Boolean = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPicDownReq localGroupPicDownReq = new RichProto.RichProtoReq.GroupPicDownReq();
    localGroupPicDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localGroupPicDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localGroupPicDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localGroupPicDownReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localGroupPicDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localGroupPicDownReq.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    localGroupPicDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
    localGroupPicDownReq.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Long);
    if (paramBoolean)
    {
      localGroupPicDownReq.jdField_c_of_type_Int = 0;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_pic_dw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localGroupPicDownReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (c()) {
        break label189;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label189:
    do
    {
      return;
      localGroupPicDownReq.jdField_c_of_type_Int = 1;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localRichProtoReq.toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (FileUtils.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label190;
      }
      String str2 = d(str1);
      if (str2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString = str2;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream != null) || (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean)) {
        break label233;
      }
      b(9302, a(new Exception("no output stream")));
      d();
      i = -1;
      return i;
    }
    b(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label190:
    b(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label233:
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.q = bool;
        try
        {
          this.jdField_c_of_type_ArrayOfByte = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
          this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long;
          if (this.jdField_c_of_type_ArrayOfByte != null) {
            break;
          }
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString)));
          d();
          return -1;
        }
        catch (Exception localException)
        {
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString)));
          d();
        }
      }
    }
    return -1;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    HttpNetReq localHttpNetReq = new HttpNetReq();
    if (paramBoolean) {}
    int i;
    for (String str = "https://"; (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_b_of_type_JavaLangString != null); str = "http://")
    {
      str = str + this.jdField_b_of_type_JavaLangString;
      localHttpNetReq.jdField_g_of_type_Boolean = false;
      localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      str = a(a(str + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = str;
      localHttpNetReq.jdField_f_of_type_Boolean = paramBoolean;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile.a();
      localHttpNetReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean) {
        localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
      }
      localHttpNetReq.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      localHttpNetReq.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localHttpNetReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      localHttpNetReq.k = true;
      localHttpNetReq.jdField_a_of_type_Long = 0L;
      localHttpNetReq.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      i = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
      if (i != 4) {
        break label725;
      }
      localHttpNetReq.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
      localHttpNetReq.jdField_b_of_type_Long = 0L;
      localHttpNetReq.jdField_j_of_type_Boolean = false;
      localObject = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-";
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject);
      label362:
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      a(localHttpNetReq, str);
      localHttpNetReq.l = false;
      localHttpNetReq.jdField_d_of_type_Boolean = true;
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      localHttpNetReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        localHttpNetReq.jdField_c_of_type_Int = 0;
      }
      str = null;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        str = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + str + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long + " downOffset:" + localHttpNetReq.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_f_of_type_Boolean + ",isEncryptPic:" + this.e + ",isEncryptRollbackReq:" + this.jdField_g_of_type_Boolean);
      if (d()) {
        break label887;
      }
      return;
    }
    Object localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    str = str + ((ServerAddr)localObject).jdField_a_of_type_JavaLangString;
    if (((ServerAddr)localObject).jdField_a_of_type_Int != 80) {
      str = str + ":" + ((ServerAddr)localObject).jdField_a_of_type_Int;
    }
    for (;;)
    {
      FMTSrvAddrProvider.a().a().a(str, 2);
      localHttpNetReq.jdField_g_of_type_Boolean = true;
      localHttpNetReq.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
      break;
      label725:
      if ((i == 3) || (i == 2))
      {
        localHttpNetReq.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
        localHttpNetReq.jdField_b_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Int - 1);
        localHttpNetReq.jdField_j_of_type_Boolean = false;
        localObject = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-" + localHttpNetReq.jdField_b_of_type_Long;
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject);
        break label362;
      }
      localHttpNetReq.jdField_b_of_type_Long = 0L;
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-");
      break label362;
      label887:
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
      n();
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
      return;
    }
  }
  
  String d(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      localObject = paramString;
    }
    try
    {
      if (paramString.startsWith("/")) {
        localObject = paramString.substring(1);
      }
      if ((localObject != null) && (!((String)localObject).equals("null")) && (!((String)localObject).startsWith("http://"))) {}
      do
      {
        do
        {
          do
          {
            return null;
          } while ((localObject == null) || (((String)localObject).length() <= 0) || (!((String)localObject).contains("?")));
          i = ((String)localObject).indexOf("?");
        } while ((i < 0) || (i >= ((String)localObject).length() - 1));
        localObject = ((String)localObject).substring(i + 1).split("\\&");
      } while (localObject == null);
      paramString = null;
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].startsWith("pic=")) {
          paramString = localObject[i].substring(4);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = paramString;
      }
    }
    return paramString;
  }
  
  protected void n()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.q) {
        break label72;
      }
      if (i == 2) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDd");
  }
  
  void o()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_JavaLangString;
    Object localObject1;
    int i;
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals("")))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
        c(false);
        return;
      }
      localObject1 = InnerDns.a().a("gchat.qpic.cn", 1000);
      if (!StringUtil.a((String)localObject1))
      {
        this.jdField_c_of_type_Boolean = true;
        i = 1;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((ServerAddr)localObject2).jdField_a_of_type_Int = d();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        this.jdField_a_of_type_Boolean = true;
        this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
        c(false);
        return;
        localObject2 = FMTSrvAddrProvider.a().a().a(2);
        if (QLog.isColorLevel()) {
          QLog.d("PttIpSaver", 2, "get PIC_GROUP_IP:" + (String)localObject2);
        }
        if (StringUtil.a((String)localObject2)) {
          break label305;
        }
        this.jdField_d_of_type_Boolean = true;
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("http://")) {
          localObject1 = ((String)localObject2).substring("http://".length(), ((String)localObject2).length());
        }
        if (((String)localObject1).endsWith("/"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          i = 1;
        }
      }
      else
      {
        for (this.jdField_c_of_type_Int = 2;; this.jdField_c_of_type_Int = 1)
        {
          b(false);
          return;
        }
      }
      i = 1;
      continue;
      label305:
      i = 0;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */