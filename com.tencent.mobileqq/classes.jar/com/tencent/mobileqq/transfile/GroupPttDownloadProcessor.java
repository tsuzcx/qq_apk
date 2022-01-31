package com.tencent.mobileqq.transfile;

import awiq;
import awir;
import awxs;
import awxt;
import awyf;
import azqs;
import azri;
import baam;
import bara;
import barh;
import basl;
import bass;
import basu;
import baub;
import baue;
import bauf;
import bauh;
import bave;
import bavf;
import bavt;
import bawk;
import baws;
import bawy;
import bayf;
import bayk;
import bayp;
import bbax;
import bbbb;
import bbbm;
import bbbs;
import bbcd;
import bdhb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
  extends bara
  implements bauf, bauh, Runnable
{
  protected baam a;
  private bayp jdField_a_of_type_Bayp;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  byte[] jdField_a_of_type_ArrayOfByte;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  String jdField_e_of_type_JavaLangString;
  String f;
  private String l;
  
  public GroupPttDownloadProcessor(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Baam = ((baam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private boolean a()
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
  
  private void b(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_l_of_type_JavaLangString != null)
        {
          boolean bool = a();
          if (bool)
          {
            if (i != 0)
            {
              if (!this.jdField_d_of_type_Boolean) {
                continue;
              }
              basl.a().a().a(0);
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
        basl.a().a(16, this.jdField_l_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      azri localazri = azri.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localazri.a(null, str, bool, 0L, 0L, localHashMap, null);
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int);
  }
  
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambave instanceof baub));
      parambave = (baub)parambave;
      parambave.jdField_a_of_type_Long += parambavf.jdField_c_of_type_Long;
    } while (0L != parambave.jdField_b_of_type_Long);
    parambavf.jdField_c_of_type_Long = 0L;
    parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-";
    parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
  }
  
  public void a(bavf parambavf)
  {
    this.jdField_a_of_type_Bawi.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(parambavf, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString);
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      while (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbbs)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        this.i = parambbax.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Barh, parambbax);
        if (parambbax.jdField_c_of_type_Int == 0)
        {
          this.jdField_b_of_type_JavaLangString = parambbax.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambbax.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = a(parambbax.jdField_b_of_type_JavaUtilArrayList, parambbax.jdField_a_of_type_JavaUtilArrayList);
          if (this.jdField_b_of_type_JavaLangString != null)
          {
            parambbax = new bawy();
            parambbax.b = true;
            parambbax.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilArrayList.add(parambbax);
          }
          h();
          i += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (bawk.b(this.jdField_j_of_type_Int))) {
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
      l1 = (System.nanoTime() - this.k) / 1000000L;
      localObject = this.jdField_d_of_type_Barh.a(1) + ";" + this.jdField_a_of_type_Barh.a(2) + ";" + this.jdField_b_of_type_Barh.a(3) + ";" + this.jdField_c_of_type_Barh.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(awxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Boolean)));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.jdField_l_of_type_JavaLangString == null) {
          break label393;
        }
        bool = true;
        label298:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label399;
      }
      b(true, l1);
      azri.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label393:
    label399:
    do
    {
      l();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      awyf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Bayp, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      return;
      i = 1;
      break label59;
      bool = false;
      break label298;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Bave instanceof baub))
      {
        localObject = baws.a(((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((bawy)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b(false, l1);
      azri.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.jdField_j_of_type_Int != -9527) || (this.jdField_j_of_type_JavaLangString == null));
    int i = 0;
    if (this.jdField_j_of_type_JavaLangString.equals("T_203"))
    {
      i = 1;
      label563:
      if (i == 0) {
        break label811;
      }
      if (this.jdField_e_of_type_Long > this.jdField_d_of_type_Long) {
        if (!this.jdField_c_of_type_Boolean) {
          break label813;
        }
      }
    }
    label811:
    label813:
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
      azri.a(BaseApplication.getContext()).a(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject = (bayp)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", bavt.a(((bayp)localObject).jdField_a_of_type_Int, ((bayp)localObject).jdField_b_of_type_Int), 0, "", "", "", "8.3.5");
      break;
      if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) {
        break label563;
      }
      i = 16;
      break label563;
      break;
    }
  }
  
  public void aP_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Bayp.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aP_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 1) {}
    for (int i = 3;; i = 2)
    {
      bavt.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Bayk.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Bayk.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      f();
      return;
    }
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 1) {
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
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_Bauh = this;
    localbaub.jdField_a_of_type_JavaLangString = ((String)localObject);
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbaub.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.h;
    localbaub.jdField_a_of_type_Bauf = this;
    localbaub.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localbaub.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    localbaub.jdField_g_of_type_Int = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbaub.f = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
    localbaub.jdField_a_of_type_Long = 0L;
    localbaub.k = true;
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localbaub.jdField_c_of_type_Long = 60000L;
      localbaub.jdField_c_of_type_Int = 0;
    }
    localbaub.l = true;
    localbaub.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Bayk.jdField_c_of_type_Long + " downOffset:" + localbaub.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bave = localbaub;
    n();
    this.jdField_a_of_type_Baue.a(localbaub);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Bayk.toString());
    String str = this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bdhb.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Bayp = ((bayp)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Bayk.h == null) || (!bdhb.c(this.jdField_a_of_type_Bayk.i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_Bayk.h = a("group", str, j);
        label241:
        this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Bayk.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_Bayk.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_Bayk.f, this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Bayk.jdField_c_of_type_Long;
      this.f = this.jdField_a_of_type_Bayk.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Bayk.f + "  uuid:" + this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
      this.jdField_a_of_type_Bayk.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq != null)
    {
      awir localawir = new awir();
      localawir.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq.a(localawir);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Bayk.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Bayk.h;
    }
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq != null)
    {
      localObject = new awir();
      ((awir)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awiq.a((awir)localObject);
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
    this.jdField_a_of_type_Barh.a();
    bbax localbbax = new bbax();
    bbbb localbbbb = new bbbb();
    localbbbb.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    localbbbb.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    localbbbb.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_d_of_type_JavaLangString;
    localbbbb.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbbbb.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.f);
    localbbbb.jdField_a_of_type_JavaLangString = this.f;
    localbbbb.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbbbb.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localbbbb.jdField_b_of_type_Int = this.jdField_a_of_type_Bayk.jdField_g_of_type_Int;
    localbbax.jdField_a_of_type_Bbce = this;
    localbbax.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localbbax.jdField_a_of_type_JavaUtilList.add(localbbbb);
    localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbbax.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  void h()
  {
    this.jdField_b_of_type_Barh.a();
    Object localObject = null;
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    bawy localbawy;
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localbawy = (bawy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((localbawy.jdField_a_of_type_Boolean) && (!localbawy.jdField_a_of_type_JavaLangString.startsWith("[")))
      {
        str = "[" + localbawy.jdField_a_of_type_JavaLangString + "]";
        localObject = str;
        if (localbawy.jdField_a_of_type_Int != 80) {
          localObject = str + ":" + localbawy.jdField_a_of_type_Int;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    for (;;)
    {
      basl.a().a().a((String)localObject, 0);
      str = "http://" + (String)localObject;
      b(str + this.jdField_a_of_type_JavaLangString);
      return;
      str = localbawy.jdField_a_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_JavaLangString != null) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Bave != null) && ((this.jdField_a_of_type_Bave instanceof baub)))
    {
      if (this.jdField_c_of_type_Boolean) {
        ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
  }
  
  public void onResp(bavf parambavf)
  {
    Object localObject;
    basu localbasu;
    boolean bool;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_Barh;
      localbasu = this.jdField_a_of_type_Bass.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label233;
      }
      bool = true;
      label37:
      a((barh)localObject, parambavf, bool);
      localObject = new StringBuilder().append(" result:");
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label238;
      }
      bool = true;
      label67:
      b("onHttpResp", bool);
      this.jdField_a_of_type_Long = parambavf.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Bave != null) {
        this.jdField_a_of_type_Bave.jdField_a_of_type_Baug = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambavf.jdField_b_of_type_Long + parambavf.jdField_a_of_type_Bave.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambavf.jdField_c_of_type_Long;
      localbasu.jdField_d_of_type_JavaLangString = ((String)parambavf.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label243;
      }
      e();
      this.jdField_a_of_type_Bawi.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      a(parambavf, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString);
      if (this.jdField_l_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bave = null;
      return;
      localObject = this.jdField_b_of_type_Barh;
      localbasu = this.jdField_a_of_type_Bass.a;
      break;
      label233:
      bool = false;
      break label37;
      label238:
      bool = false;
      break label67;
      label243:
      if (this.jdField_l_of_type_JavaLangString != null)
      {
        b(false);
      }
      else
      {
        if ((parambavf.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_Bave = null;
          this.jdField_l_of_type_Int += 1;
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
    if (this.jdField_a_of_type_Bave != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_l_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Baue.b(this.jdField_a_of_type_Bave);
      this.jdField_a_of_type_Bave = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */