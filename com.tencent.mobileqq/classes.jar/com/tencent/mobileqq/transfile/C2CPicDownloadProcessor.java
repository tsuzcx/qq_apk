package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPicDownReq;
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

public class C2CPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  public C2CPicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
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
        this.jdField_j_of_type_Boolean = paramRichProtoReq.jdField_e_of_type_Boolean;
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
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + RichMediaUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) + "." + RichMediaUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) || (this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l1 = (System.nanoTime() - this.k) / 1000000L;
      localObject1 = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo != null) {
        break label898;
      }
      i = 0;
      label451:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l2 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailDesc", "" + this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_inQueueCost", "" + this.p);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromDns", "" + this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromSave", "" + this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encryptRollback", "" + this.jdField_g_of_type_Boolean + ",decryptErrorMsg:" + this.jdField_g_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_g_of_type_Boolean) {
        break label909;
      }
      localObject1 = "1";
      label677:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.h) {
        break label917;
      }
      localObject1 = "1";
      label706:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && (((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder != null))
      {
        localObject1 = (HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder).jdField_a_of_type_Long));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      if (!paramBoolean) {
        break label925;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label898:
      i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
      break label451;
      label909:
      localObject1 = "0";
      break label677;
      label917:
      localObject1 = "0";
      break label706;
      label925:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      StatisticCollector.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void ap_()
  {
    super.ap_();
    try
    {
      o();
      return;
    }
    catch (Exception localException)
    {
      b("reportFailed", ChatImageDownloader.a(localException));
    }
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    this.jdField_a_of_type_Boolean = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq = new RichProto.RichProtoReq.C2CPicDownReq();
    localC2CPicDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localC2CPicDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localC2CPicDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localC2CPicDownReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localC2CPicDownReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    localC2CPicDownReq.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_e_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localC2CPicDownReq.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localC2CPicDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1006) {
        break label312;
      }
      bool = true;
      label210:
      localC2CPicDownReq.jdField_a_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label317;
      }
      localC2CPicDownReq.jdField_c_of_type_Int = 0;
      label226:
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localC2CPicDownReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (c()) {
        break label326;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label312:
    label317:
    label326:
    do
    {
      return;
      this.jdField_e_of_type_JavaLangString = "picplatform";
      b("findDbRec", "not found");
      break;
      bool = false;
      break label210;
      localC2CPicDownReq.jdField_c_of_type_Int = 1;
      break label226;
      if (QLog.isColorLevel()) {
        b("requestStart", localRichProtoReq.toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public int c()
  {
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean))
    {
      b(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
    return 0;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (this.o) {}
    HttpNetReq localHttpNetReq;
    int i;
    label371:
    do
    {
      return;
      localHttpNetReq = new HttpNetReq();
      if (paramBoolean) {}
      for (localObject1 = "https://";; localObject1 = "http://")
      {
        if (((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) || (this.jdField_b_of_type_JavaLangString == null)) {
          break label686;
        }
        localObject1 = (String)localObject1 + this.jdField_b_of_type_JavaLangString;
        localHttpNetReq.jdField_g_of_type_Boolean = false;
        localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localObject2 = a((String)localObject1 + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject1 = a((String)localObject2, this.jdField_a_of_type_JavaUtilArrayList);
          BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
        }
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$NetFailedListener = this;
        localHttpNetReq.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localHttpNetReq.jdField_f_of_type_Boolean = paramBoolean;
        localHttpNetReq.jdField_a_of_type_Int = 0;
        localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
        localHttpNetReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean) {
          localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
        }
        localHttpNetReq.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        localHttpNetReq.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
        localHttpNetReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
        localHttpNetReq.jdField_a_of_type_Long = 0L;
        localHttpNetReq.k = true;
        i = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
        if (i != 4) {
          break label806;
        }
        localHttpNetReq.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
        localHttpNetReq.jdField_b_of_type_Long = 0L;
        localHttpNetReq.jdField_j_of_type_Boolean = false;
        localObject2 = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-";
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
        a(localHttpNetReq, (String)localObject1);
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
        localHttpNetReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Int;
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile.a();
        localHttpNetReq.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
        localHttpNetReq.l = false;
        localHttpNetReq.jdField_d_of_type_Boolean = true;
        if (this.jdField_a_of_type_Boolean) {
          localHttpNetReq.jdField_c_of_type_Long = 0L;
        }
        localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            localObject1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
          }
        }
        b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + (String)localObject1 + " uniSeq:" + localHttpNetReq.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString + ",downOffset:" + localHttpNetReq.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_f_of_type_Boolean + ",isEncryptPic:" + this.jdField_e_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_g_of_type_Boolean);
        if (!d()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
        return;
      }
    } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    label686:
    Object localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    Object localObject1 = (String)localObject1 + ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString;
    if (((ServerAddr)localObject2).jdField_a_of_type_Int != 80) {
      localObject1 = (String)localObject1 + ":" + ((ServerAddr)localObject2).jdField_a_of_type_Int;
    }
    for (;;)
    {
      FMTSrvAddrProvider.a().a().a((String)localObject1, 1);
      localHttpNetReq.jdField_g_of_type_Boolean = true;
      localHttpNetReq.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      break;
      label806:
      if ((i == 3) || (i == 2))
      {
        localHttpNetReq.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
        localHttpNetReq.jdField_b_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Int - 1);
        localHttpNetReq.jdField_j_of_type_Boolean = false;
        localObject2 = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-" + localHttpNetReq.jdField_b_of_type_Long;
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
        break label371;
      }
      localHttpNetReq.jdField_b_of_type_Long = 0L;
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-");
      break label371;
    }
  }
  
  void o()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
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
      localObject1 = InnerDns.a().a("c2cpicdw.qpic.cn", 1004);
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
        localObject2 = FMTSrvAddrProvider.a().a().a(1);
        if (QLog.isColorLevel()) {
          QLog.d("PttIpSaver", 2, "get PIC_C2C_IP:" + (String)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */