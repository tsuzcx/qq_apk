package com.tencent.mobileqq.transfile;

import ayxc;
import ayxd;
import azth;
import azti;
import aztu;
import bcst;
import bctj;
import bdbq;
import bdsr;
import bdsz;
import bdud;
import bduk;
import bdum;
import bdvs;
import bdvu;
import bdvv;
import bdvx;
import bdws;
import bdwt;
import bdxh;
import bdxr;
import bdxz;
import bdyf;
import bdzi;
import bdzn;
import bdzs;
import bebv;
import bebz;
import beck;
import becq;
import bedb;
import bgmg;
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
  extends bdsr
  implements bdvv, bdvx, Runnable
{
  protected bdbq a;
  private bdzs jdField_a_of_type_Bdzs;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  byte[] jdField_a_of_type_ArrayOfByte;
  long c;
  private long d;
  private long jdField_e_of_type_Long;
  String jdField_e_of_type_JavaLangString;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = true;
  private boolean g;
  private String l;
  
  public GroupPttDownloadProcessor(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Bdbq = ((bdbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
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
  
  private void f(int paramInt)
  {
    boolean bool = true;
    String str = "DiscussPTTDirectUrl";
    try
    {
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      bctj localbctj = bctj.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localbctj.a(null, str, bool, 0L, 0L, localHashMap, null);
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void f(boolean paramBoolean)
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
              if (!this.g) {
                continue;
              }
              bdud.a().a().a(0);
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
        bdud.a().a(16, this.jdField_l_of_type_JavaLangString);
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
  
  public QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int);
  }
  
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambdws instanceof bdvs));
      parambdws = (bdvs)parambdws;
      parambdws.jdField_a_of_type_Long += parambdwt.jdField_c_of_type_Long;
    } while (0L != parambdws.jdField_b_of_type_Long);
    parambdwt.jdField_c_of_type_Long = 0L;
    parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-";
    parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    if (parambeck != null)
    {
      int i = 0;
      while (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becq)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.jdField_k_of_type_Boolean = parambebv.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_k_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if (parambebv.c == 0)
        {
          this.jdField_b_of_type_JavaLangString = parambebv.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambebv.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = a(parambebv.jdField_b_of_type_JavaUtilArrayList, parambebv.jdField_a_of_type_JavaUtilArrayList);
          if (this.jdField_b_of_type_JavaLangString != null)
          {
            bdyf localbdyf = new bdyf();
            localbdyf.b = true;
            localbdyf.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilArrayList.add(localbdyf);
          }
          b(parambebv.jdField_a_of_type_Boolean);
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
    if ((!paramBoolean) && (bdxr.a(this.jdField_j_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    label59:
    long l1;
    HashMap localHashMap;
    label264:
    boolean bool;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      localObject = this.jdField_d_of_type_Bdsz.a(1) + ";" + this.jdField_a_of_type_Bdsz.a(2) + ";" + this.jdField_b_of_type_Bdsz.a(3) + ";" + this.jdField_c_of_type_Bdsz.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(azti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g)));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label443;
      }
      localObject = "1";
      localHashMap.put("param_isHttps", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_trans_consume", String.valueOf(this.jdField_b_of_type_Bdsz.a()));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.jdField_l_of_type_JavaLangString == null) {
          break label451;
        }
        bool = true;
        label348:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label457;
      }
      b(true, l1);
      bctj.a(BaseApplication.getContext()).a(null, c(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label443:
    label451:
    label457:
    do
    {
      m();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      aztu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_j_of_type_Int, this.jdField_a_of_type_Bdzs, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      return;
      i = 1;
      break label59;
      localObject = "0";
      break label264;
      bool = false;
      break label348;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Bdws instanceof bdvs))
      {
        localObject = bdxz.a(((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((bdyf)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b(false, l1);
      bctj.a(BaseApplication.getContext()).a(null, c(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.jdField_j_of_type_Int != -9527) || (this.jdField_j_of_type_JavaLangString == null));
    int i = 0;
    if (this.jdField_j_of_type_JavaLangString.equals("T_203"))
    {
      i = 1;
      label621:
      if (i == 0) {
        break label869;
      }
      if (this.jdField_e_of_type_Long > this.jdField_d_of_type_Long) {
        if (!this.jdField_f_of_type_Boolean) {
          break label871;
        }
      }
    }
    label869:
    label871:
    for (Object localObject = "actGroupPTTOutOfTime";; localObject = "actDiscussionPTTOutOfTime")
    {
      localHashMap = new HashMap();
      long l3 = System.currentTimeMillis() / 1000L;
      l1 = (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long) / 86400L;
      long l2 = (l3 - this.jdField_d_of_type_Long) / 86400L;
      l3 = (l3 - this.jdField_e_of_type_Long) / 86400L;
      localHashMap.put("MsgOff", String.valueOf(l1));
      localHashMap.put("PttOff", String.valueOf(l3));
      localHashMap.put("OutOfTimeReason", String.valueOf(i));
      localHashMap.put("param_FailCode", String.valueOf(l2));
      bctj.a(BaseApplication.getContext()).a(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject = (bdzs)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", bdxh.a(((bdzs)localObject).jdField_a_of_type_Int, ((bdzs)localObject).jdField_b_of_type_Int), 0, "", "", "", "8.4.1");
      break;
      if (!this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) {
        break label621;
      }
      i = 16;
      break label621;
      break;
    }
  }
  
  public void aN_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Bdzs.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aN_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1) {}
    for (int i = 3;; i = 2)
    {
      bdxh.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Bdzn.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Bdzn.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      f();
      return;
    }
  }
  
  void b(String paramString, boolean paramBoolean)
  {
    Object localObject = paramString;
    if (!paramString.contains("voice_codec="))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localObject = paramString + "&voice_codec=" + ((MessageForPtt)localObject).voiceType;
    }
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this;
    localbdvs.jdField_a_of_type_Bdvx = this;
    localbdvs.jdField_a_of_type_JavaLangString = ((String)localObject);
    localbdvs.jdField_f_of_type_Boolean = paramBoolean;
    localbdvs.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbdvs.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.h;
    localbdvs.jdField_a_of_type_Bdvv = this;
    localbdvs.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localbdvs.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    localbdvs.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbdvs.jdField_e_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    localbdvs.jdField_a_of_type_Long = 0L;
    localbdvs.jdField_l_of_type_Boolean = true;
    localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localbdvs.jdField_c_of_type_Long = 60000L;
      localbdvs.jdField_b_of_type_Int = 0;
    }
    localbdvs.m = true;
    localbdvs.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Bdzn.jdField_c_of_type_Long + " downOffset:" + localbdvs.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bdws = localbdvs;
    o();
    this.jdField_a_of_type_Bdvu.a(localbdvs);
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Bdsz.a();
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bedj.jdField_a_of_type_Boolean = paramBoolean;
    String str2;
    Object localObject;
    bdyf localbdyf;
    String str1;
    if (paramBoolean)
    {
      str2 = "https://";
      localObject = null;
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label249;
      }
      localbdyf = (bdyf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((!localbdyf.jdField_a_of_type_Boolean) || (localbdyf.jdField_a_of_type_JavaLangString.startsWith("["))) {
        break label240;
      }
      str1 = "[" + localbdyf.jdField_a_of_type_JavaLangString + "]";
      label135:
      localObject = str1;
      if (localbdyf.jdField_a_of_type_Int != 80) {
        localObject = str1 + ":" + localbdyf.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    for (;;)
    {
      str1 = str2 + (String)localObject;
      b(str1 + this.jdField_a_of_type_JavaLangString, paramBoolean);
      return;
      str2 = "http://";
      break;
      label240:
      str1 = localbdyf.jdField_a_of_type_JavaLangString;
      break label135;
      label249:
      if (this.jdField_b_of_type_JavaLangString != null) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    String str = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bgmg.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Bdzs = ((bdzs)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Bdzn.h == null) || (!bgmg.c(this.jdField_a_of_type_Bdzn.i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_Bdzn.h = a("group", str, j);
        label241:
        this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Bdzn.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_f_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_Bdzn.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Bdzn.jdField_c_of_type_Long;
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Bdzn.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
      this.jdField_a_of_type_Bdzn.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1) {
      return "actGrpPttDown";
    }
    return "actDisscusPttDown";
  }
  
  public void c(bdwt parambdwt)
  {
    this.jdField_a_of_type_Bedj.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(parambdwt, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc != null)
    {
      ayxd localayxd = new ayxd();
      localayxd.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc.a(localayxd);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Bdzn.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Bdzn.h;
    }
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc != null)
    {
      localObject = new ayxd();
      ((ayxd)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayxc.a((ayxd)localObject);
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
    this.jdField_a_of_type_Bdsz.a();
    bebv localbebv = new bebv();
    bebz localbebz = new bebz();
    localbebz.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbebz.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbebz.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_d_of_type_JavaLangString;
    localbebz.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbebz.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.jdField_f_of_type_JavaLangString);
    localbebz.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    localbebz.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbebz.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localbebz.jdField_b_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_g_of_type_Int;
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbebz);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_Bdws != null) && ((this.jdField_a_of_type_Bdws instanceof bdvs)))
    {
      if (this.jdField_f_of_type_Boolean) {
        ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
  }
  
  public void onResp(bdwt parambdwt)
  {
    Object localObject;
    bdum localbdum;
    boolean bool;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_Bdsz;
      localbdum = this.jdField_a_of_type_Bduk.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label234;
      }
      bool = true;
      label37:
      a((bdsz)localObject, parambdwt, bool);
      localObject = new StringBuilder().append(" result:");
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label239;
      }
      bool = true;
      label67:
      b("onHttpResp", bool);
      this.jdField_a_of_type_Long = parambdwt.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Bdws != null) {
        this.jdField_a_of_type_Bdws.jdField_a_of_type_Bdvw = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambdwt.jdField_b_of_type_Long + parambdwt.jdField_a_of_type_Bdws.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambdwt.jdField_c_of_type_Long;
      localbdum.jdField_d_of_type_JavaLangString = ((String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label244;
      }
      e();
      this.jdField_a_of_type_Bedj.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      a(parambdwt, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
      if (this.jdField_l_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdws = null;
      return;
      localObject = this.jdField_b_of_type_Bdsz;
      localbdum = this.jdField_a_of_type_Bduk.a;
      break;
      label234:
      bool = false;
      break label37;
      label239:
      bool = false;
      break label67;
      label244:
      if (this.jdField_l_of_type_JavaLangString != null)
      {
        f(false);
      }
      else
      {
        if ((parambdwt.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_Bdws = null;
          this.jdField_l_of_type_Int += 1;
          n();
          f();
          return;
        }
        d();
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Bdws != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_l_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Bdvu.b(this.jdField_a_of_type_Bdws);
      this.jdField_a_of_type_Bdws = null;
    }
    f(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */