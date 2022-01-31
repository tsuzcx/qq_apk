package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;

public class GroupPttDownloadProcessor
  extends BaseDownloadProcessor
  implements INetEngine.IBreakDownFix, Runnable
{
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private TransferRequest.PttDownExtraInfo jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo;
  byte[] jdField_a_of_type_ArrayOfByte;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long e;
  String f;
  String g;
  private String l;
  
  public GroupPttDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_l_of_type_JavaLangString != null)
        {
          boolean bool = e();
          if (bool)
          {
            if (i != 0)
            {
              if (!this.jdField_d_of_type_Boolean) {
                continue;
              }
              FMTSrvAddrProvider.a().a().a(0);
            }
            this.jdField_l_of_type_JavaLangString = null;
            if (!paramBoolean) {
              break label139;
            }
            f(4);
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "directDownloadIfCan error");
            }
            if (!bool) {
              break label147;
            }
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = 2005L;
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
            d();
          }
        }
        else
        {
          return;
        }
        if (this.jdField_j_of_type_Int == 9366) {
          continue;
        }
        i = 1;
        continue;
        FMTSrvAddrProvider.a().a(16, this.jdField_l_of_type_JavaLangString);
        continue;
        f(3);
      }
      finally {}
      label139:
      continue;
      label147:
      f();
    }
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_j_of_type_Int == -9527)
    {
      bool1 = bool2;
      if (this.jdField_j_of_type_JavaLangString != null) {
        if ((!this.jdField_j_of_type_JavaLangString.equals("T_203")) && (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")))
        {
          bool1 = bool2;
          if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f(int paramInt)
  {
    boolean bool = true;
    String str = "DiscussPTTDirectUrl";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localStatisticCollector.a(null, str, bool, 0L, 0L, localHashMap, null);
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void q()
  {
    int j = 0;
    MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    int i;
    if (localMessageForPtt.directUrl != null) {
      if (localMessageForPtt.directUrl.length() == 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0) {
        f(1);
      }
      label160:
      label165:
      while (j != 0)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "directDownloadIfCan pttUrl: " + localMessageForPtt.directUrl);
        }
        Object localObject2 = FMTSrvAddrProvider.a().a();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = FMTSrvAddrProvider.a().a().a(0);
          if (localObject1 == null) {
            break label160;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          this.jdField_d_of_type_Boolean = bool;
          if (localObject1 != null) {
            break label165;
          }
          if (!QLog.isDevelopLevel()) {
            break label333;
          }
          QLog.e("SPD", 4, "directDownloadIfCan no ip error " + localMessageForPtt.directUrl);
          i = 1;
          break;
        }
        if (((String)localObject1).endsWith("/")) {}
        for (localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);; localObject2 = localObject1)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan ipStr: " + (String)localObject1);
          }
          localObject1 = (String)localObject2 + localMessageForPtt.directUrl;
          this.jdField_l_of_type_JavaLangString = ((String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan for GroupPtt: " + (String)localObject1);
          }
          b((String)localObject1);
          this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
          ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
          j = 1;
          i = 1;
          break;
        }
      }
      f(2);
      return;
      label333:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int);
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.jdField_a_of_type_Long += paramNetResp.jdField_c_of_type_Long;
    } while (0L != paramNetReq.jdField_b_of_type_Long);
    paramNetResp.jdField_c_of_type_Long = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    Object localObject;
    FileMsg.StepTransInfo localStepTransInfo;
    boolean bool1;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (paramNetResp.jdField_a_of_type_Int != 0) {
        break label201;
      }
      bool1 = true;
      label40:
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.jdField_a_of_type_Int != 0) {
        break label206;
      }
      bool1 = bool2;
      label72:
      b("onHttpResp", bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      localStepTransInfo.jdField_d_of_type_JavaLangString = ((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (paramNetResp.jdField_a_of_type_Int != 0) {
        break label211;
      }
      e();
      if (this.jdField_l_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      return;
      localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a;
      break;
      label201:
      bool1 = false;
      break label40;
      label206:
      bool1 = false;
      break label72;
      label211:
      if (this.jdField_l_of_type_JavaLangString != null)
      {
        b(false);
      }
      else
      {
        if ((paramNetResp.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
          this.jdField_l_of_type_Int += 1;
          m();
          f();
          return;
        }
        d();
      }
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPttDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.e;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_j_of_type_Boolean);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_b_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          p();
          i += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    label59:
    label82:
    long l1;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label400;
      }
      localObject1 = "actGrpPttDown";
      l1 = (System.nanoTime() - this.k) / 1000000L;
      localObject2 = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Boolean)));
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.jdField_l_of_type_JavaLangString == null) {
          break label408;
        }
        bool = true;
        label314:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label414;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label400:
    label408:
    label414:
    do
    {
      l();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      return;
      i = 1;
      break label59;
      localObject1 = "actDisscusPttDown";
      break label82;
      bool = false;
      break label314;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
      {
        localObject2 = RichMediaUtil.a(((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
        if (localObject2 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.jdField_j_of_type_Int != -9527) || (this.jdField_j_of_type_JavaLangString == null));
    int i = 0;
    if (this.jdField_j_of_type_JavaLangString.equals("T_203"))
    {
      i = 1;
      label569:
      if (i == 0) {
        break label817;
      }
      if (this.e > this.jdField_d_of_type_Long) {
        if (!this.jdField_c_of_type_Boolean) {
          break label819;
        }
      }
    }
    label817:
    label819:
    for (Object localObject1 = "actGroupPTTOutOfTime";; localObject1 = "actDiscussionPTTOutOfTime")
    {
      localObject2 = new HashMap();
      long l3 = System.currentTimeMillis() / 1000L;
      l1 = (this.e - this.jdField_d_of_type_Long) / 86400L;
      long l2 = (l3 - this.jdField_d_of_type_Long) / 86400L;
      l3 = (l3 - this.e) / 86400L;
      ((HashMap)localObject2).put("MsgOff", String.valueOf(l1));
      ((HashMap)localObject2).put("PttOff", String.valueOf(l3));
      ((HashMap)localObject2).put("OutOfTimeReason", String.valueOf(i));
      ((HashMap)localObject2).put("param_FailCode", String.valueOf(l2));
      StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, 0L, 0L, (HashMap)localObject2, null);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject1 = (TransferRequest.PttDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", PttInfoCollector.a(((TransferRequest.PttDownExtraInfo)localObject1).jdField_a_of_type_Int, ((TransferRequest.PttDownExtraInfo)localObject1).jdField_b_of_type_Int), 0, "", "", "", "7.6.3");
      break;
      if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) {
        break label569;
      }
      i = 16;
      break label569;
      break;
    }
  }
  
  public void ap_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.ap_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {}
    for (int i = 3;; i = 2)
    {
      PttInfoCollector.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      if (PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        q();
      }
      if (this.jdField_l_of_type_JavaLangString == null) {
        f();
      }
      return;
    }
  }
  
  void b(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.contains("voice_codec="))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localObject = paramString + "&voice_codec=" + ((MessageForPtt)localObject).voiceType;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = ((String)localObject);
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_d_of_type_JavaLangString = this.f;
    localHttpNetReq.e = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_a_of_type_Long = 0L;
    localHttpNetReq.k = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localHttpNetReq.jdField_c_of_type_Long = 60000L;
      localHttpNetReq.jdField_c_of_type_Int = 0;
    }
    localHttpNetReq.l = false;
    localHttpNetReq.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + " FileID:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long + " downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    if (!d()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    n();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo = ((TransferRequest.PttDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.e = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h == null) || (!FileUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h = a("group", str, j);
        label241:
        this.f = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long;
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e)));
      d();
      return -1;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(localDownResult);
      return;
    }
    d(2005);
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      localObject = new DownCallBack.DownResult();
      ((DownCallBack.DownResult)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a((DownCallBack.DownResult)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    d(2001);
    o();
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (this.jdField_c_of_type_Boolean) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
  }
  
  void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPttDownReq localGroupPttDownReq = new RichProto.RichProtoReq.GroupPttDownReq();
    localGroupPttDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localGroupPttDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localGroupPttDownReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localGroupPttDownReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localGroupPttDownReq.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.jdField_g_of_type_JavaLangString);
    localGroupPttDownReq.jdField_a_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    localGroupPttDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localGroupPttDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localGroupPttDownReq.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_Int;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localGroupPttDownReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
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
  
  void p()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_b_of_type_JavaLangString != null)) {
      str = this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      FMTSrvAddrProvider.a().a().a(str, 0);
      str = "http://" + str;
      str = a(str + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      b(str);
      return;
      ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      str = localServerAddr.jdField_a_of_type_JavaLangString;
      if (localServerAddr.jdField_a_of_type_Int != 80) {
        str = str + ":" + localServerAddr.jdField_a_of_type_Int;
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_l_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */