package com.tencent.mobileqq.transfile;

import aumy;
import aumz;
import avbu;
import avbv;
import avch;
import axqw;
import axrl;
import ayah;
import ayou;
import aypb;
import ayqf;
import ayqm;
import ayqo;
import ayrv;
import ayry;
import ayrz;
import aysb;
import aysw;
import aysx;
import aytl;
import ayua;
import ayui;
import ayuo;
import ayvv;
import aywa;
import aywf;
import ayyn;
import ayyr;
import ayzc;
import ayzi;
import ayzt;
import bbdj;
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
  extends ayou
  implements ayrz, aysb, Runnable
{
  protected ayah a;
  private aywf jdField_a_of_type_Aywf;
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
  
  public GroupPttDownloadProcessor(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Ayah = ((ayah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
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
              ayqf.a().a().a(0);
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
        ayqf.a().a(16, this.jdField_l_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      axrl localaxrl = axrl.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localaxrl.a(null, str, bool, 0L, 0L, localHashMap, null);
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
        Object localObject2 = ayqf.a().a();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ayqf.a().a().a(0);
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
          this.jdField_d_of_type_Aypb.a();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int);
  }
  
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaysw instanceof ayrv));
      paramaysw = (ayrv)paramaysw;
      paramaysw.jdField_a_of_type_Long += paramaysx.jdField_c_of_type_Long;
    } while (0L != paramaysw.jdField_b_of_type_Long);
    paramaysx.jdField_c_of_type_Long = 0L;
    paramaysx = "bytes=" + paramaysw.jdField_a_of_type_Long + "-";
    paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
  }
  
  public void a(aysx paramaysx)
  {
    a(paramaysx, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Aywa.f, this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString);
  }
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    this.jdField_a_of_type_Ayyn = null;
    if (paramayzc != null)
    {
      int i = 0;
      if (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyn = (ayzi)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyn.toString());
        }
        this.i = paramayyn.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Aypb, paramayyn);
        if (paramayyn.jdField_c_of_type_Int == 0)
        {
          this.jdField_b_of_type_JavaLangString = paramayyn.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = paramayyn.jdField_a_of_type_JavaLangString;
          if ((g()) && (paramayyn.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramayyn.jdField_a_of_type_JavaUtilArrayList);
            }
          }
          for (;;)
          {
            if (this.jdField_b_of_type_JavaLangString != null)
            {
              paramayyn = new ayuo();
              paramayyn.b = true;
              paramayyn.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              this.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
            }
            h();
            i += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_a_of_type_JavaUtilArrayList;
          }
        }
        d();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (ayua.b(this.jdField_j_of_type_Int))) {
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
      localObject = this.jdField_d_of_type_Aypb.a(1) + ";" + this.jdField_a_of_type_Aypb.a(2) + ";" + this.jdField_b_of_type_Aypb.a(3) + ";" + this.jdField_c_of_type_Aypb.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(avbv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Boolean)));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.jdField_l_of_type_JavaLangString == null) {
          break label386;
        }
        bool = true;
        label298:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label392;
      }
      axrl.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label386:
    label392:
    do
    {
      l();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      avch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Aywf, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
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
      if ((this.jdField_a_of_type_Aysw instanceof ayrv))
      {
        localObject = ayui.a(((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((ayuo)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      axrl.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.jdField_j_of_type_Int != -9527) || (this.jdField_j_of_type_JavaLangString == null));
    int i = 0;
    if (this.jdField_j_of_type_JavaLangString.equals("T_203"))
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
      axrl.a(BaseApplication.getContext()).a(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject = (aywf)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", aytl.a(((aywf)localObject).jdField_a_of_type_Int, ((aywf)localObject).jdField_b_of_type_Int), 0, "", "", "", "8.2.8");
      break;
      if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) {
        break label549;
      }
      i = 16;
      break label549;
      break;
    }
  }
  
  public void aR_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Aywf.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aR_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i;
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 1)
    {
      i = 3;
      aytl.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Aywa.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Aywa.h;
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
      if (avbv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        o();
      }
    } while (this.jdField_l_of_type_JavaLangString != null);
    f();
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 1) {
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
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this;
    localayrv.jdField_a_of_type_JavaLangString = ((String)localObject);
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localayrv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.h;
    localayrv.jdField_a_of_type_Ayrz = this;
    localayrv.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localayrv.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    localayrv.jdField_g_of_type_Int = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayrv.f = this.jdField_a_of_type_Aywa.jdField_b_of_type_Int;
    localayrv.jdField_a_of_type_Long = 0L;
    localayrv.k = true;
    localayrv.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localayrv.jdField_c_of_type_Long = 60000L;
      localayrv.jdField_c_of_type_Int = 0;
    }
    localayrv.l = true;
    localayrv.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Aywa.jdField_c_of_type_Long + " downOffset:" + localayrv.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Aysw = localayrv;
    n();
    this.jdField_a_of_type_Ayry.a(localayrv);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    String str = this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bbdj.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Aywf = ((aywf)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Aywa.h == null) || (!bbdj.c(this.jdField_a_of_type_Aywa.i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_Aywa.h = a("group", str, j);
        label241:
        this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Aywa.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_Aywa.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_Aywa.f, this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Aywa.jdField_c_of_type_Long;
      this.f = this.jdField_a_of_type_Aywa.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Aywa.f + "  uuid:" + this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
      this.jdField_a_of_type_Aywa.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy != null)
    {
      aumz localaumz = new aumz();
      localaumz.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy.a(localaumz);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Aywa.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Aywa.h;
    }
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy != null)
    {
      localObject = new aumz();
      ((aumz)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Aumy.a((aumz)localObject);
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
    this.jdField_a_of_type_Aypb.a();
    ayyn localayyn = new ayyn();
    ayyr localayyr = new ayyr();
    localayyr.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString;
    localayyr.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
    localayyr.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_d_of_type_JavaLangString;
    localayyr.f = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayyr.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.f);
    localayyr.jdField_a_of_type_JavaLangString = this.f;
    localayyr.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyr.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localayyr.jdField_b_of_type_Int = this.jdField_a_of_type_Aywa.jdField_g_of_type_Int;
    localayyn.jdField_a_of_type_Ayzu = this;
    localayyn.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localayyn.jdField_a_of_type_JavaUtilList.add(localayyr);
    localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyn.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyn = localayyn;
    ayzt.a(localayyn);
  }
  
  void h()
  {
    this.jdField_b_of_type_Aypb.a();
    Object localObject = null;
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    ayuo localayuo;
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localayuo = (ayuo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((localayuo.jdField_a_of_type_Boolean) && (!localayuo.jdField_a_of_type_JavaLangString.startsWith("[")))
      {
        str = "[" + localayuo.jdField_a_of_type_JavaLangString + "]";
        localObject = str;
        if (localayuo.jdField_a_of_type_Int != 80) {
          localObject = str + ":" + localayuo.jdField_a_of_type_Int;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    for (;;)
    {
      ayqf.a().a().a((String)localObject, 0);
      str = "http://" + (String)localObject;
      b(str + this.jdField_a_of_type_JavaLangString);
      return;
      str = localayuo.jdField_a_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_JavaLangString != null) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Aysw != null) && ((this.jdField_a_of_type_Aysw instanceof ayrv)))
    {
      if (this.jdField_c_of_type_Boolean) {
        ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
  }
  
  public void onResp(aysx paramaysx)
  {
    boolean bool2 = true;
    Object localObject;
    ayqo localayqo;
    boolean bool1;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_Aypb;
      localayqo = this.jdField_a_of_type_Ayqm.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break label224;
      }
      bool1 = true;
      label40:
      a((aypb)localObject, paramaysx, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break label229;
      }
      bool1 = bool2;
      label72:
      b("onHttpResp", bool1);
      this.jdField_a_of_type_Long = paramaysx.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Aysw != null) {
        this.jdField_a_of_type_Aysw.jdField_a_of_type_Aysa = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramaysx.jdField_b_of_type_Long + paramaysx.jdField_a_of_type_Aysw.jdField_a_of_type_Long);
      }
      localayqo.jdField_d_of_type_JavaLangString = ((String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break label234;
      }
      e();
      a(paramaysx, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Aywa.f, this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString);
      if (this.jdField_l_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aysw = null;
      return;
      localObject = this.jdField_b_of_type_Aypb;
      localayqo = this.jdField_a_of_type_Ayqm.a;
      break;
      label224:
      bool1 = false;
      break label40;
      label229:
      bool1 = false;
      break label72;
      label234:
      if (this.jdField_l_of_type_JavaLangString != null)
      {
        b(false);
      }
      else
      {
        if ((paramaysx.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_Aysw = null;
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
    if (this.jdField_a_of_type_Aysw != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_l_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Ayry.b(this.jdField_a_of_type_Aysw);
      this.jdField_a_of_type_Aysw = null;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */