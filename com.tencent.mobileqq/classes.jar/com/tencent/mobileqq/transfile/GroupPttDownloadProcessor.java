package com.tencent.mobileqq.transfile;

import atpa;
import atpb;
import auco;
import aucp;
import audb;
import awqx;
import awrn;
import axaf;
import axoo;
import axow;
import axpy;
import axqf;
import axqh;
import axro;
import axrr;
import axrs;
import axsp;
import axsq;
import axte;
import axtt;
import axub;
import axuh;
import axvo;
import axvt;
import axvy;
import axyg;
import axyk;
import axyv;
import axzb;
import axzm;
import bace;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;

public class GroupPttDownloadProcessor
  extends axoo
  implements axrs, Runnable
{
  protected axaf a;
  private axvy jdField_a_of_type_Axvy;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  byte[] jdField_a_of_type_ArrayOfByte;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  String jdField_e_of_type_JavaLangString;
  String f;
  private String k;
  
  public GroupPttDownloadProcessor(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Axaf = ((axaf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_j_of_type_Int == -9527)
    {
      bool1 = bool2;
      if (this.jdField_i_of_type_JavaLangString != null) {
        if ((!this.jdField_i_of_type_JavaLangString.equals("T_203")) && (!this.jdField_i_of_type_JavaLangString.equals("H_400_-5103017")))
        {
          bool1 = bool2;
          if (!this.jdField_i_of_type_JavaLangString.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_k_of_type_JavaLangString != null)
        {
          boolean bool = a();
          if (bool)
          {
            if (i != 0)
            {
              if (!this.jdField_d_of_type_Boolean) {
                continue;
              }
              axpy.a().a().a(0);
            }
            this.jdField_k_of_type_JavaLangString = null;
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
        axpy.a().a(16, this.jdField_k_of_type_JavaLangString);
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
  
  private void f(int paramInt)
  {
    boolean bool = true;
    String str = "DiscussPTTDirectUrl";
    try
    {
      if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      awrn localawrn = awrn.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localawrn.a(null, str, bool, 0L, 0L, localHashMap, null);
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void o()
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
        Object localObject2 = axpy.a().a();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = axpy.a().a().a(0);
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
            break label347;
          }
          QLog.e("SPD", 4, "directDownloadIfCan no ip error " + localMessageForPtt.directUrl);
          i = 1;
          break;
        }
        if (this.jdField_j_of_type_Boolean) {
          localObject2 = "http://grouptalk.c2c.qq.com";
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan ipStr: " + (String)localObject1);
          }
          localObject1 = (String)localObject2 + localMessageForPtt.directUrl;
          this.jdField_k_of_type_JavaLangString = ((String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan for GroupPtt: " + (String)localObject1);
          }
          b((String)localObject1);
          this.jdField_d_of_type_Axow.a();
          ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
          j = 1;
          i = 1;
          break;
          if (((String)localObject1).endsWith("/")) {
            localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          } else {
            localObject2 = localObject1;
          }
        }
      }
      f(2);
      return;
      label347:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int);
  }
  
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaxsp instanceof axro));
      paramaxsp = (axro)paramaxsp;
      paramaxsp.jdField_a_of_type_Long += paramaxsq.jdField_c_of_type_Long;
    } while (0L != paramaxsp.jdField_b_of_type_Long);
    paramaxsq.jdField_c_of_type_Long = 0L;
    paramaxsq = "bytes=" + paramaxsp.jdField_a_of_type_Long + "-";
    paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axzb)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyg.toString());
        }
        this.jdField_i_of_type_Boolean = paramaxyg.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_i_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if (paramaxyg.jdField_c_of_type_Int == 0)
        {
          this.jdField_b_of_type_JavaLangString = paramaxyg.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = paramaxyg.jdField_a_of_type_JavaLangString;
          if ((g()) && (paramaxyg.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramaxyg.jdField_a_of_type_JavaUtilArrayList);
            }
          }
          for (;;)
          {
            h();
            i += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_a_of_type_JavaUtilArrayList;
          }
        }
        d();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (axtt.b(this.jdField_j_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    label59:
    long l1;
    boolean bool;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      localObject = this.jdField_d_of_type_Axow.a(1) + ";" + this.jdField_a_of_type_Axow.a(2) + ";" + this.jdField_b_of_type_Axow.a(3) + ";" + this.jdField_c_of_type_Axow.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_i_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(aucp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Boolean)));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.jdField_k_of_type_JavaLangString == null) {
          break label386;
        }
        bool = true;
        label298:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label392;
      }
      awrn.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label386:
    label392:
    do
    {
      l();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      audb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Axvy, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      return;
      i = 1;
      break label59;
      bool = false;
      break label298;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_i_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Axsp instanceof axro))
      {
        localObject = axub.a(((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((axuh)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      awrn.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.jdField_j_of_type_Int != -9527) || (this.jdField_i_of_type_JavaLangString == null));
    int i = 0;
    if (this.jdField_i_of_type_JavaLangString.equals("T_203"))
    {
      i = 1;
      label549:
      if (i == 0) {
        break label797;
      }
      if (this.jdField_e_of_type_Long > this.jdField_d_of_type_Long) {
        if (!this.jdField_c_of_type_Boolean) {
          break label799;
        }
      }
    }
    label797:
    label799:
    for (Object localObject = "actGroupPTTOutOfTime";; localObject = "actDiscussionPTTOutOfTime")
    {
      HashMap localHashMap = new HashMap();
      long l3 = System.currentTimeMillis() / 1000L;
      l1 = (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long) / 86400L;
      long l2 = (l3 - this.jdField_d_of_type_Long) / 86400L;
      l3 = (l3 - this.jdField_e_of_type_Long) / 86400L;
      localHashMap.put("MsgOff", String.valueOf(l1));
      localHashMap.put("PttOff", String.valueOf(l3));
      localHashMap.put("OutOfTimeReason", String.valueOf(i));
      localHashMap.put("param_FailCode", String.valueOf(l2));
      awrn.a(BaseApplication.getContext()).a(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject = (axvy)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", axte.a(((axvy)localObject).jdField_a_of_type_Int, ((axvy)localObject).jdField_b_of_type_Int), 0, "", "", "", "8.2.6");
      break;
      if (!this.jdField_i_of_type_JavaLangString.equals("H_400_-5103017")) {
        break label549;
      }
      i = 16;
      break label549;
      break;
    }
  }
  
  public void aU_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Axvy.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aU_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 1)
    {
      i = 3;
      axte.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Axvt.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Axvt.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      if (!g()) {
        break label145;
      }
      f();
    }
    label145:
    do
    {
      return;
      i = 2;
      break;
      if (aucp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        o();
      }
    } while (this.jdField_k_of_type_JavaLangString != null);
    f();
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 1) {
      return "actGrpPttDown";
    }
    return "actDisscusPttDown";
  }
  
  void b(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.contains("voice_codec="))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localObject = paramString + "&voice_codec=" + ((MessageForPtt)localObject).voiceType;
    }
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = this;
    localaxro.jdField_a_of_type_JavaLangString = ((String)localObject);
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localaxro.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.h;
    localaxro.jdField_a_of_type_Axrs = this;
    localaxro.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localaxro.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    localaxro.jdField_g_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxro.f = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
    localaxro.jdField_a_of_type_Long = 0L;
    localaxro.k = true;
    localaxro.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_k_of_type_JavaLangString != null)
    {
      localaxro.jdField_c_of_type_Long = 60000L;
      localaxro.jdField_c_of_type_Int = 0;
    }
    localaxro.l = true;
    localaxro.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Axvt.jdField_c_of_type_Long + " downOffset:" + localaxro.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Axsp = localaxro;
    n();
    this.jdField_a_of_type_Axrr.a(localaxro);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
    String str = this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bace.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Axvy = ((axvy)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Axvt.h == null) || (!bace.c(this.jdField_a_of_type_Axvt.jdField_i_of_type_JavaLangString)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_Axvt.h = a("group", str, j);
        label241:
        this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Axvt.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_Axvt.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_Axvt.f, this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Axvt.jdField_c_of_type_Long;
      this.f = this.jdField_a_of_type_Axvt.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Axvt.f + "  uuid:" + this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
      this.jdField_a_of_type_Axvt.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa != null)
    {
      atpb localatpb = new atpb();
      localatpb.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa.a(localatpb);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Axvt.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Axvt.h;
    }
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa != null)
    {
      localObject = new atpb();
      ((atpb)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atpa.a((atpb)localObject);
      return;
    }
    d(2003);
  }
  
  void f()
  {
    d(2001);
    g();
  }
  
  void g()
  {
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = new axyg();
    axyk localaxyk = new axyk();
    localaxyk.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
    localaxyk.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyk.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_d_of_type_JavaLangString;
    localaxyk.f = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxyk.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.f);
    localaxyk.jdField_a_of_type_JavaLangString = this.f;
    localaxyk.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localaxyk.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localaxyk.jdField_b_of_type_Int = this.jdField_a_of_type_Axvt.jdField_g_of_type_Int;
    localaxyg.jdField_a_of_type_Axzn = this;
    localaxyg.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyk);
    localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  void h()
  {
    this.jdField_b_of_type_Axow.a();
    Object localObject = null;
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    axuh localaxuh;
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localaxuh = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((localaxuh.jdField_a_of_type_Boolean) && (!localaxuh.jdField_a_of_type_JavaLangString.startsWith("[")))
      {
        str = "[" + localaxuh.jdField_a_of_type_JavaLangString + "]";
        localObject = str;
        if (localaxuh.jdField_a_of_type_Int != 80) {
          localObject = str + ":" + localaxuh.jdField_a_of_type_Int;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    for (;;)
    {
      axpy.a().a().a((String)localObject, 0);
      str = "http://" + (String)localObject;
      b(str + this.jdField_a_of_type_JavaLangString);
      return;
      str = localaxuh.jdField_a_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_JavaLangString != null) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Axsp != null) && ((this.jdField_a_of_type_Axsp instanceof axro)))
    {
      if (this.jdField_c_of_type_Boolean) {
        ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
  }
  
  public void onResp(axsq paramaxsq)
  {
    boolean bool2 = true;
    Object localObject;
    axqh localaxqh;
    boolean bool1;
    if (this.jdField_k_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_Axow;
      localaxqh = this.jdField_a_of_type_Axqf.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (paramaxsq.jdField_a_of_type_Int != 0) {
        break label201;
      }
      bool1 = true;
      label40:
      a((axow)localObject, paramaxsq, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramaxsq.jdField_a_of_type_Int != 0) {
        break label206;
      }
      bool1 = bool2;
      label72:
      b("onHttpResp", bool1);
      this.jdField_a_of_type_Long = paramaxsq.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Axsp != null) {
        this.jdField_a_of_type_Axsp.jdField_a_of_type_Axrt = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramaxsq.jdField_b_of_type_Long + paramaxsq.jdField_a_of_type_Axsp.jdField_a_of_type_Long);
      }
      localaxqh.jdField_d_of_type_JavaLangString = ((String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (paramaxsq.jdField_a_of_type_Int != 0) {
        break label211;
      }
      e();
      if (this.jdField_k_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Axsp = null;
      return;
      localObject = this.jdField_b_of_type_Axow;
      localaxqh = this.jdField_a_of_type_Axqf.a;
      break;
      label201:
      bool1 = false;
      break label40;
      label206:
      bool1 = false;
      break label72;
      label211:
      if (this.jdField_k_of_type_JavaLangString != null)
      {
        b(false);
      }
      else
      {
        if ((paramaxsq.jdField_b_of_type_Int == 9364) && (this.l < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_Axsp = null;
          this.l += 1;
          m();
          f();
          return;
        }
        d();
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Axsp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_k_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Axrr.b(this.jdField_a_of_type_Axsp);
      this.jdField_a_of_type_Axsp = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */