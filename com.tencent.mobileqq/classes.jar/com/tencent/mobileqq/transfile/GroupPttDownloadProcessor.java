package com.tencent.mobileqq.transfile;

import azpp;
import azpq;
import balx;
import baly;
import bamk;
import bdll;
import bdmc;
import bduh;
import berj;
import berr;
import besx;
import bete;
import betg;
import beum;
import beuo;
import beup;
import beur;
import bevl;
import bevm;
import bewa;
import bewk;
import bews;
import bewy;
import beyb;
import beyg;
import beyl;
import bfau;
import bfay;
import bfbj;
import bfbp;
import bfca;
import bhmi;
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
  extends berj
  implements beup, beur, Runnable
{
  protected bduh a;
  private beyl jdField_a_of_type_Beyl;
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
  
  public GroupPttDownloadProcessor(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Bduh = ((bduh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17));
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_k_of_type_Int == -9527)
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
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      bdmc localbdmc = bdmc.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localbdmc.a(null, str, bool, 0L, 0L, localHashMap, null);
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
              besx.a().a().a(0);
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
        if (this.jdField_k_of_type_Int == 9366) {
          continue;
        }
        i = 1;
        continue;
        besx.a().a(16, this.jdField_l_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int);
  }
  
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambevl instanceof beum));
      parambevl = (beum)parambevl;
      parambevl.jdField_a_of_type_Long += parambevm.jdField_c_of_type_Long;
    } while (0L != parambevl.jdField_b_of_type_Long);
    parambevm.jdField_c_of_type_Long = 0L;
    parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
    parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      while (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbp)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        this.jdField_k_of_type_Boolean = parambfau.jdField_d_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_k_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Berr, parambfau);
        if (parambfau.c == 0)
        {
          this.jdField_b_of_type_JavaLangString = parambfau.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambfau.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = a(parambfau.jdField_b_of_type_JavaUtilArrayList, parambfau.jdField_a_of_type_JavaUtilArrayList);
          if (this.jdField_b_of_type_JavaLangString != null)
          {
            bewy localbewy = new bewy();
            localbewy.b = true;
            localbewy.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilArrayList.add(localbewy);
          }
          b(parambfau.jdField_a_of_type_Boolean);
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
    if ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int j = this.n;
    label59:
    long l1;
    HashMap localHashMap;
    label264:
    boolean bool;
    if (paramBoolean)
    {
      i = 2;
      this.n = (i | j);
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      localObject = this.jdField_d_of_type_Berr.a(1) + ";" + this.jdField_a_of_type_Berr.a(2) + ";" + this.jdField_b_of_type_Berr.a(3) + ";" + this.jdField_c_of_type_Berr.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(baly.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g)));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label443;
      }
      localObject = "1";
      localHashMap.put("param_isHttps", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_trans_consume", String.valueOf(this.jdField_b_of_type_Berr.a()));
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
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      bamk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.jdField_k_of_type_Int, this.jdField_a_of_type_Beyl, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      return;
      i = 1;
      break label59;
      localObject = "0";
      break label264;
      bool = false;
      break label348;
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if ((this.jdField_a_of_type_Bevl instanceof beum))
      {
        localObject = bews.a(((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((bewy)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      b(false, l1);
      bdmc.a(BaseApplication.getContext()).a(null, c(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.jdField_k_of_type_Int != -9527) || (this.jdField_j_of_type_JavaLangString == null));
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
      bdmc.a(BaseApplication.getContext()).a(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject = (beyl)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", bewa.a(((beyl)localObject).jdField_a_of_type_Int, ((beyl)localObject).jdField_b_of_type_Int), 0, "", "", "", "8.4.5");
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
    if (this.jdField_a_of_type_Beyl.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.aN_();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1) {}
    for (int i = 3;; i = 2)
    {
      bewa.a((QQAppInterface)localObject, i, false, 2);
      if (!this.jdField_a_of_type_Beyg.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_Beyg.h;
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
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_Beur = this;
    localbeum.jdField_a_of_type_JavaLangString = ((String)localObject);
    localbeum.jdField_f_of_type_Boolean = paramBoolean;
    localbeum.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbeum.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.h;
    localbeum.jdField_a_of_type_Beup = this;
    localbeum.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbeum.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    localbeum.jdField_a_of_type_Long = 0L;
    localbeum.jdField_l_of_type_Boolean = true;
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localbeum.jdField_c_of_type_Long = 60000L;
      localbeum.jdField_b_of_type_Int = 0;
    }
    localbeum.m = true;
    localbeum.jdField_d_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Beyg.jdField_c_of_type_Long + " downOffset:" + localbeum.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bevl = localbeum;
    o();
    this.jdField_a_of_type_Beuo.a(localbeum);
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Berr.a();
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bfci.jdField_a_of_type_Boolean = paramBoolean;
    String str2;
    Object localObject;
    bewy localbewy;
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
      localbewy = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((!localbewy.jdField_a_of_type_Boolean) || (localbewy.jdField_a_of_type_JavaLangString.startsWith("["))) {
        break label240;
      }
      str1 = "[" + localbewy.jdField_a_of_type_JavaLangString + "]";
      label135:
      localObject = str1;
      if (localbewy.jdField_a_of_type_Int != 80) {
        localObject = str1 + ":" + localbewy.jdField_a_of_type_Int;
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
      str1 = localbewy.jdField_a_of_type_JavaLangString;
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
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    String str = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bhmi.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      i = -1;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Beyl = ((beyl)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_Beyg.h == null) || (!bhmi.c(this.jdField_a_of_type_Beyg.i)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_Beyg.h = a("group", str, j);
        label241:
        this.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_Beyg.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_Beyg.jdField_a_of_type_Int) {
        break label422;
      }
    }
    label422:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_f_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Beyg.jdField_c_of_type_Long;
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_g_of_type_JavaLangString;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
      this.jdField_a_of_type_Beyg.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label241;
    }
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1) {
      return "actGrpPttDown";
    }
    return "actDisscusPttDown";
  }
  
  public void c(bevm parambevm)
  {
    this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(parambevm, false, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp != null)
    {
      azpq localazpq = new azpq();
      localazpq.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp.a(localazpq);
      return;
    }
    d(2005);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_Beyg.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    super.e();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_Beyg.h;
    }
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp != null)
    {
      localObject = new azpq();
      ((azpq)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azpp.a((azpq)localObject);
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
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = new bfau();
    bfay localbfay = new bfay();
    localbfay.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfay.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfay.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfay.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfay.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    b("SendRequest", " SendRequest GrpFileKey:" + this.jdField_f_of_type_JavaLangString);
    localbfay.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    localbfay.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbfay.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localbfay.jdField_b_of_type_Int = this.jdField_a_of_type_Beyg.jdField_g_of_type_Int;
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfay);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbfau.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_Bevl != null) && ((this.jdField_a_of_type_Bevl instanceof beum)))
    {
      if (this.jdField_f_of_type_Boolean) {
        ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
  }
  
  public void onResp(bevm parambevm)
  {
    Object localObject;
    betg localbetg;
    boolean bool;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_d_of_type_Berr;
      localbetg = this.jdField_a_of_type_Bete.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label234;
      }
      bool = true;
      label37:
      a((berr)localObject, parambevm, bool);
      localObject = new StringBuilder().append(" result:");
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label239;
      }
      bool = true;
      label67:
      b("onHttpResp", bool);
      this.jdField_a_of_type_Long = parambevm.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Bevl != null) {
        this.jdField_a_of_type_Bevl.jdField_a_of_type_Beuq = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambevm.jdField_b_of_type_Long + parambevm.jdField_a_of_type_Bevl.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambevm.jdField_c_of_type_Long;
      localbetg.jdField_d_of_type_JavaLangString = ((String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label244;
      }
      e();
      this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      a(parambevm, true, "actRichMediaNetMonitor_pttDown", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
      if (this.jdField_l_of_type_JavaLangString != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bevl = null;
      return;
      localObject = this.jdField_b_of_type_Berr;
      localbetg = this.jdField_a_of_type_Bete.a;
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
        if ((parambevm.jdField_b_of_type_Int == 9364) && (this.m < 3))
        {
          b("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_Bevl = null;
          this.m += 1;
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
    if (this.jdField_a_of_type_Bevl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.jdField_l_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Beuo.b(this.jdField_a_of_type_Bevl);
      this.jdField_a_of_type_Bevl = null;
    }
    f(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */