package com.tencent.mobileqq.transfile;

import auna;
import aunb;
import avbw;
import avbx;
import avcj;
import axqy;
import axrn;
import ayaj;
import ayow;
import aypd;
import ayqh;
import ayqo;
import ayqq;
import ayrx;
import aysa;
import aysb;
import aysd;
import aysy;
import aysz;
import aytn;
import ayuc;
import ayuk;
import ayuq;
import ayvx;
import aywc;
import aywh;
import ayyp;
import ayyt;
import ayze;
import ayzk;
import ayzv;
import bbdx;
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
  extends ayow
  implements aysb, aysd, Runnable
{
  protected ayaj a;
  private aywh jdField_a_of_type_Aywh;
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
  
  public GroupPttDownloadProcessor(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Ayaj = ((ayaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
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
              ayqh.a().a().a(0);
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
        ayqh.a().a(16, this.jdField_l_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      axrn localaxrn = axrn.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localaxrn.a(null, str, bool, 0L, 0L, localHashMap, null);
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
        Object localObject2 = ayqh.a().a();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ayqh.a().a().a(0);
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
          this.jdField_l_of_type_JavaLangString = ((String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan for GroupPtt: " + (String)localObject1);
          }
          b((String)localObject1);
          this.jdField_d_of_type_Aypd.a();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int);
  }
  
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaysy instanceof ayrx));
      paramaysy = (ayrx)paramaysy;
      paramaysy.jdField_a_of_type_Long += paramaysz.jdField_c_of_type_Long;
    } while (0L != paramaysy.jdField_b_of_type_Long);
    paramaysz.jdField_c_of_type_Long = 0L;
    paramaysz = "bytes=" + paramaysy.jdField_a_of_type_Long + "-";
    paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
  }
  
  public void a(aysz paramaysz)
  {
    a(paramaysz, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Aywc.f, this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString, null);
  }
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    this.jdField_a_of_type_Ayyp = null;
    if (paramayze != null)
    {
      int i = 0;
      if (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyp = (ayzk)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyp.toString());
        }
        this.i = paramayyp.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Aypd, paramayyp);
        if (paramayyp.jdField_c_of_type_Int == 0)
        {
          this.jdField_b_of_type_JavaLangString = paramayyp.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = paramayyp.jdField_a_of_type_JavaLangString;
          if ((g()) && (paramayyp.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramayyp.jdField_a_of_type_JavaUtilArrayList);
            }
          }
          for (;;)
          {
            if (this.jdField_b_of_type_JavaLangString != null)
            {
              paramayyp = new ayuq();
              paramayyp.b = true;
              paramayyp.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              this.jdField_a_of_type_JavaUtilArrayList.add(paramayyp);
            }
            h();
            i += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_a_of_type_JavaUtilArrayList;
          }
        }
        d();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (ayuc.b(this.jdField_j_of_type_Int))) {
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
      localObject = this.jdField_d_of_type_Aypd.a(1) + ";" + this.jdField_a_of_type_Aypd.a(2) + ";" + this.jdField_b_of_type_Aypd.a(3) + ";" + this.jdField_c_of_type_Aypd.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(avbx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Boolean)));
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
      axrn.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label393:
    label399:
    do
    {
      b(paramBoolean, l1);
      l();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      avcj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Aywh, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
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
      if ((this.jdField_a_of_type_Aysy instanceof ayrx))
      {
        localObject = ayuk.a(((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((ayuq)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      axrn.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.jdField_j_of_type_Int != -9527) || (this.jdField_j_of_type_JavaLangString == null));
    int i = 0;
    if (this.jdField_j_of_type_JavaLangString.equals("T_203"))
    {
      i = 1;
      label556:
      if (i == 0) {
        break label804;
      }
      if (this.jdField_e_of_type_Long > this.jdField_d_of_type_Long) {
        if (!this.jdField_c_of_type_Boolean) {
          break label806;
        }
      }
    }
    label804:
    label806:
    for (Object localObject = "actGroupPTTOutOfTime";; localObject = "actDiscussionPTTOutOfTime")
    {
      HashMap localHashMap = new HashMap();
      long l4 = System.currentTimeMillis() / 1000L;
      long l2 = (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long) / 86400L;
      long l3 = (l4 - this.jdField_d_of_type_Long) / 86400L;
      l4 = (l4 - this.jdField_e_of_type_Long) / 86400L;
      localHashMap.put("MsgOff", String.valueOf(l2));
      localHashMap.put("PttOff", String.valueOf(l4));
      localHashMap.put("OutOfTimeReason", String.valueOf(i));
      localHashMap.put("param_FailCode", String.valueOf(l3));
      axrn.a(BaseApplication.getContext()).a(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject = (aywh)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", aytn.a(((aywh)localObject).jdField_a_of_type_Int, ((aywh)localObject).jdField_b_of_type_Int), 0, "", "", "", "8.3.0");
      break;
      if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) {
        break label556;
      }
      i = 16;
      break label556;
      break;
    }
  }
  
  public void aR_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Aywh.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aR_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i;
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1)
    {
      i = 3;
      aytn.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Aywc.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Aywc.h;
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
      if (avbx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        o();
      }
    } while (this.jdField_l_of_type_JavaLangString != null);
    f();
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1) {
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
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = this;
    localayrx.jdField_a_of_type_Aysd = this;
    localayrx.jdField_a_of_type_JavaLangString = ((String)localObject);
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localayrx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.h;
    localayrx.jdField_a_of_type_Aysb = this;
    localayrx.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localayrx.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
    localayrx.jdField_g_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayrx.f = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    localayrx.jdField_a_of_type_Long = 0L;
    localayrx.k = true;
    localayrx.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localayrx.jdField_c_of_type_Long = 60000L;
      localayrx.jdField_c_of_type_Int = 0;
    }
    localayrx.l = true;
    localayrx.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Aywc.jdField_c_of_type_Long + " downOffset:" + localayrx.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Aysy = localayrx;
    n();
    this.jdField_a_of_type_Aysa.a(localayrx);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Aywc.toString());
    String str = this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bbdx.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Aywh = ((aywh)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Aywc.h == null) || (!bbdx.c(this.jdField_a_of_type_Aywc.i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_Aywc.h = a("group", str, j);
        label241:
        this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Aywc.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_Aywc.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_Aywc.f, this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Aywc.jdField_c_of_type_Long;
      this.f = this.jdField_a_of_type_Aywc.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Aywc.f + "  uuid:" + this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
      this.jdField_a_of_type_Aywc.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auna != null)
    {
      aunb localaunb = new aunb();
      localaunb.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auna.a(localaunb);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Aywc.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Aywc.h;
    }
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auna != null)
    {
      localObject = new aunb();
      ((aunb)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auna.a((aunb)localObject);
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
    this.jdField_a_of_type_Aypd.a();
    ayyp localayyp = new ayyp();
    ayyt localayyt = new ayyt();
    localayyt.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString;
    localayyt.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
    localayyt.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_d_of_type_JavaLangString;
    localayyt.f = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayyt.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.f);
    localayyt.jdField_a_of_type_JavaLangString = this.f;
    localayyt.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyt.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localayyt.jdField_b_of_type_Int = this.jdField_a_of_type_Aywc.jdField_g_of_type_Int;
    localayyp.jdField_a_of_type_Ayzw = this;
    localayyp.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localayyp.jdField_a_of_type_JavaUtilList.add(localayyt);
    localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyp.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
  
  void h()
  {
    this.jdField_b_of_type_Aypd.a();
    Object localObject = null;
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    ayuq localayuq;
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localayuq = (ayuq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((localayuq.jdField_a_of_type_Boolean) && (!localayuq.jdField_a_of_type_JavaLangString.startsWith("[")))
      {
        str = "[" + localayuq.jdField_a_of_type_JavaLangString + "]";
        localObject = str;
        if (localayuq.jdField_a_of_type_Int != 80) {
          localObject = str + ":" + localayuq.jdField_a_of_type_Int;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    for (;;)
    {
      ayqh.a().a().a((String)localObject, 0);
      str = "http://" + (String)localObject;
      b(str + this.jdField_a_of_type_JavaLangString);
      return;
      str = localayuq.jdField_a_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_JavaLangString != null) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Aysy != null) && ((this.jdField_a_of_type_Aysy instanceof ayrx)))
    {
      if (this.jdField_c_of_type_Boolean) {
        ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
  }
  
  public void onResp(aysz paramaysz)
  {
    Object localObject;
    ayqq localayqq;
    boolean bool;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_Aypd;
      localayqq = this.jdField_a_of_type_Ayqo.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (paramaysz.jdField_a_of_type_Int != 0) {
        break label218;
      }
      bool = true;
      label37:
      a((aypd)localObject, paramaysz, bool);
      localObject = new StringBuilder().append(" result:");
      if (paramaysz.jdField_a_of_type_Int != 0) {
        break label223;
      }
      bool = true;
      label67:
      b("onHttpResp", bool);
      this.jdField_a_of_type_Long = paramaysz.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Aysy != null) {
        this.jdField_a_of_type_Aysy.jdField_a_of_type_Aysc = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramaysz.jdField_b_of_type_Long + paramaysz.jdField_a_of_type_Aysy.jdField_a_of_type_Long);
      }
      localayqq.jdField_d_of_type_JavaLangString = ((String)paramaysz.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (paramaysz.jdField_a_of_type_Int != 0) {
        break label228;
      }
      e();
      a(paramaysz, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Aywc.f, this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString, null);
      if (this.jdField_l_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aysy = null;
      return;
      localObject = this.jdField_b_of_type_Aypd;
      localayqq = this.jdField_a_of_type_Ayqo.a;
      break;
      label218:
      bool = false;
      break label37;
      label223:
      bool = false;
      break label67;
      label228:
      if (this.jdField_l_of_type_JavaLangString != null)
      {
        b(false);
      }
      else
      {
        if ((paramaysz.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_Aysy = null;
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
    if (this.jdField_a_of_type_Aysy != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_l_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Aysa.b(this.jdField_a_of_type_Aysy);
      this.jdField_a_of_type_Aysy = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */