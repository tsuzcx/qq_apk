package com.tencent.mobileqq.transfile;

import aweh;
import awei;
import awtj;
import awtk;
import awtw;
import azmj;
import azmz;
import azwd;
import bamr;
import bamy;
import baoc;
import baoj;
import baol;
import baps;
import bapv;
import bapw;
import bapy;
import baqv;
import baqw;
import bark;
import basb;
import basj;
import basp;
import batw;
import baub;
import baug;
import bawo;
import baws;
import baxd;
import baxj;
import baxu;
import bdcs;
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
  extends bamr
  implements bapw, bapy, Runnable
{
  protected azwd a;
  private baug jdField_a_of_type_Baug;
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
  
  public GroupPttDownloadProcessor(batw parambatw, baub parambaub)
  {
    super(parambatw, parambaub);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Azwd = ((azwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
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
              baoc.a().a().a(0);
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
        baoc.a().a(16, this.jdField_l_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      azmz localazmz = azmz.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localazmz.a(null, str, bool, 0L, 0L, localHashMap, null);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int);
  }
  
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv == null) || (parambaqw == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambaqv instanceof baps));
      parambaqv = (baps)parambaqv;
      parambaqv.jdField_a_of_type_Long += parambaqw.jdField_c_of_type_Long;
    } while (0L != parambaqv.jdField_b_of_type_Long);
    parambaqw.jdField_c_of_type_Long = 0L;
    parambaqw = "bytes=" + parambaqv.jdField_a_of_type_Long + "-";
    parambaqv.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
  }
  
  public void a(baqw parambaqw)
  {
    this.jdField_a_of_type_Barz.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(parambaqw, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString);
  }
  
  public void a(bawo parambawo, baxd parambaxd)
  {
    this.jdField_a_of_type_Bawo = null;
    if (parambaxd != null)
    {
      int i = 0;
      while (i < parambaxd.jdField_a_of_type_JavaUtilList.size())
      {
        parambawo = (baxj)parambaxd.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambawo.toString());
        }
        this.i = parambawo.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Bamy, parambawo);
        if (parambawo.jdField_c_of_type_Int == 0)
        {
          this.jdField_b_of_type_JavaLangString = parambawo.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambawo.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = a(parambawo.jdField_b_of_type_JavaUtilArrayList, parambawo.jdField_a_of_type_JavaUtilArrayList);
          if (this.jdField_b_of_type_JavaLangString != null)
          {
            parambawo = new basp();
            parambawo.b = true;
            parambawo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilArrayList.add(parambawo);
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
    if ((!paramBoolean) && (basb.b(this.jdField_j_of_type_Int))) {
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
      localObject = this.jdField_d_of_type_Bamy.a(1) + ";" + this.jdField_a_of_type_Bamy.a(2) + ";" + this.jdField_b_of_type_Bamy.a(3) + ";" + this.jdField_c_of_type_Bamy.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(awtk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Boolean)));
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
      azmz.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label393:
    label399:
    do
    {
      l();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      awtw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Baug, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
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
      if ((this.jdField_a_of_type_Baqv instanceof baps))
      {
        localObject = basj.a(((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((basp)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b(false, l1);
      azmz.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      azmz.a(BaseApplication.getContext()).a(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject = (baug)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", bark.a(((baug)localObject).jdField_a_of_type_Int, ((baug)localObject).jdField_b_of_type_Int), 0, "", "", "", "8.3.3");
      break;
      if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) {
        break label563;
      }
      i = 16;
      break label563;
      break;
    }
  }
  
  public void aS_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Baug.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aS_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int == 1) {}
    for (int i = 3;; i = 2)
    {
      bark.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Baub.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Baub.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      f();
      return;
    }
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int == 1) {
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
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = this;
    localbaps.jdField_a_of_type_Bapy = this;
    localbaps.jdField_a_of_type_JavaLangString = ((String)localObject);
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbaps.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.h;
    localbaps.jdField_a_of_type_Bapw = this;
    localbaps.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localbaps.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
    localbaps.jdField_g_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    localbaps.f = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
    localbaps.jdField_a_of_type_Long = 0L;
    localbaps.k = true;
    localbaps.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localbaps.jdField_c_of_type_Long = 60000L;
      localbaps.jdField_c_of_type_Int = 0;
    }
    localbaps.l = true;
    localbaps.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Baub.jdField_c_of_type_Long + " downOffset:" + localbaps.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Baqv = localbaps;
    n();
    this.jdField_a_of_type_Bapv.a(localbaps);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Baub.toString());
    String str = this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bdcs.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Baug = ((baug)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Baub.h == null) || (!bdcs.c(this.jdField_a_of_type_Baub.i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_Baub.h = a("group", str, j);
        label241:
        this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Baub.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_Baub.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_Baub.f, this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Baub.jdField_c_of_type_Long;
      this.f = this.jdField_a_of_type_Baub.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Baub.f + "  uuid:" + this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
      this.jdField_a_of_type_Baub.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Aweh != null)
    {
      awei localawei = new awei();
      localawei.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Baub.jdField_a_of_type_Aweh.a(localawei);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Baub.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Baub.h;
    }
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Aweh != null)
    {
      localObject = new awei();
      ((awei)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Baub.jdField_a_of_type_Aweh.a((awei)localObject);
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
    this.jdField_a_of_type_Bamy.a();
    bawo localbawo = new bawo();
    baws localbaws = new baws();
    localbaws.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString;
    localbaws.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
    localbaws.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_d_of_type_JavaLangString;
    localbaws.f = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    localbaws.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.f);
    localbaws.jdField_a_of_type_JavaLangString = this.f;
    localbaws.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbaws.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localbaws.jdField_b_of_type_Int = this.jdField_a_of_type_Baub.jdField_g_of_type_Int;
    localbawo.jdField_a_of_type_Baxv = this;
    localbawo.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localbawo.jdField_a_of_type_JavaUtilList.add(localbaws);
    localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bamy);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbawo.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bawo = localbawo;
    baxu.a(localbawo);
  }
  
  void h()
  {
    this.jdField_b_of_type_Bamy.a();
    Object localObject = null;
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    basp localbasp;
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localbasp = (basp)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((localbasp.jdField_a_of_type_Boolean) && (!localbasp.jdField_a_of_type_JavaLangString.startsWith("[")))
      {
        str = "[" + localbasp.jdField_a_of_type_JavaLangString + "]";
        localObject = str;
        if (localbasp.jdField_a_of_type_Int != 80) {
          localObject = str + ":" + localbasp.jdField_a_of_type_Int;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    for (;;)
    {
      baoc.a().a().a((String)localObject, 0);
      str = "http://" + (String)localObject;
      b(str + this.jdField_a_of_type_JavaLangString);
      return;
      str = localbasp.jdField_a_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_JavaLangString != null) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Baqv != null) && ((this.jdField_a_of_type_Baqv instanceof baps)))
    {
      if (this.jdField_c_of_type_Boolean) {
        ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString);
  }
  
  public void onResp(baqw parambaqw)
  {
    Object localObject;
    baol localbaol;
    boolean bool;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_Bamy;
      localbaol = this.jdField_a_of_type_Baoj.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (parambaqw.jdField_a_of_type_Int != 0) {
        break label233;
      }
      bool = true;
      label37:
      a((bamy)localObject, parambaqw, bool);
      localObject = new StringBuilder().append(" result:");
      if (parambaqw.jdField_a_of_type_Int != 0) {
        break label238;
      }
      bool = true;
      label67:
      b("onHttpResp", bool);
      this.jdField_a_of_type_Long = parambaqw.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Baqv != null) {
        this.jdField_a_of_type_Baqv.jdField_a_of_type_Bapx = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambaqw.jdField_b_of_type_Long + parambaqw.jdField_a_of_type_Baqv.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambaqw.jdField_c_of_type_Long;
      localbaol.jdField_d_of_type_JavaLangString = ((String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (parambaqw.jdField_a_of_type_Int != 0) {
        break label243;
      }
      e();
      this.jdField_a_of_type_Barz.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      a(parambaqw, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString);
      if (this.jdField_l_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Baqv = null;
      return;
      localObject = this.jdField_b_of_type_Bamy;
      localbaol = this.jdField_a_of_type_Baoj.a;
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
        if ((parambaqw.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_Baqv = null;
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
    if (this.jdField_a_of_type_Baqv != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_l_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Bapv.b(this.jdField_a_of_type_Baqv);
      this.jdField_a_of_type_Baqv = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */