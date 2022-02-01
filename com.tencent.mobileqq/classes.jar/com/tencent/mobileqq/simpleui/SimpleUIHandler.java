package com.tencent.mobileqq.simpleui;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SimpleUIHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  volatile boolean jdField_a_of_type_Boolean = true;
  private final AtomicInteger b = new AtomicInteger(-2147483648);
  private final AtomicInteger c = new AtomicInteger(-2147483648);
  
  public SimpleUIHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThemeFontAdapter.c();
  }
  
  private int a(AtomicInteger paramAtomicInteger)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      int i = paramAtomicInteger.get();
      return i;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    String str = paramToServiceMsg.extraData.getString("uin", "");
    int j = SimpleUIUtil.f();
    StringBuilder localStringBuilder = null;
    if (QLog.isColorLevel()) {
      localStringBuilder = new StringBuilder(1024);
    }
    if (i != 0)
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          try
          {
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            paramToServiceMsg.printStackTrace();
          }
          boolean bool1;
          boolean bool3;
          boolean bool2;
          if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
          {
            paramToServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
            j = paramToServiceMsg.uint32_simple_ui_switch.get();
            int k = paramToServiceMsg.uint32_flag_study_mode_switch.get();
            if (paramToServiceMsg.uint32_flag_kid_mode_switch.has()) {
              i = paramToServiceMsg.uint32_flag_kid_mode_switch.get();
            } else {
              i = 0;
            }
            QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "studyFlag:", Integer.valueOf(k), " kidModeFlag:", Integer.valueOf(i) });
            if ((k != 1) && (i != 1)) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            if (j == 1) {
              bool3 = true;
            } else {
              bool3 = false;
            }
            i = SimpleUIUtil.f();
            if ((bool3) && (bool1))
            {
              QLog.e("SimpleUILog.SimpleUIHandler", 1, "[KidMode] both true");
              bool3 = false;
              i = 0;
            }
            SimpleUIProtocolUtil.a(str, bool3, 2);
            SimpleUIProtocolUtil.a(str, i, 2);
            StudyModeManager.a(bool1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            bool2 = true;
          }
          else
          {
            bool2 = false;
            bool3 = false;
            bool1 = false;
            i = j;
          }
          bool6 = bool1;
          j = i;
          bool5 = bool2;
          bool4 = bool3;
          if (localStringBuilder == null) {
            break label577;
          }
          localStringBuilder.append(String.format("suc=%b %s", new Object[] { Boolean.valueOf(bool2), str }));
          bool6 = bool1;
          j = i;
          bool5 = bool2;
          bool4 = bool3;
          break label577;
        }
        if (localStringBuilder != null) {
          localStringBuilder.append("fail pkg.bytes is null");
        }
      }
      else if (localStringBuilder != null)
      {
        if (paramToServiceMsg == null) {
          paramToServiceMsg = "pkg=null";
        } else if (paramToServiceMsg.uint32_result.has()) {
          paramToServiceMsg = Integer.valueOf(paramToServiceMsg.uint32_result.get());
        } else {
          paramToServiceMsg = "no result";
        }
        localStringBuilder.append(String.format("fail %s", new Object[] { paramToServiceMsg }));
      }
    }
    else if (localStringBuilder != null)
    {
      localStringBuilder.append(String.format("fail resultCode=%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
    }
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    label577:
    if ((QLog.isColorLevel()) && (localStringBuilder != null))
    {
      localStringBuilder.append("; bSwitch = ");
      localStringBuilder.append(bool4);
      localStringBuilder.append("; bPref = ");
      localStringBuilder.append(j);
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqGetSimpleUISwitch %s", new Object[] { localStringBuilder.toString() }));
    }
    notifyUI(1, bool5, new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool6), Integer.valueOf(j), str });
  }
  
  private void a(AtomicInteger paramAtomicInteger1, int paramInt1, AtomicInteger paramAtomicInteger2, int paramInt2, AtomicInteger paramAtomicInteger3, int paramInt3)
  {
    AtomicInteger localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
    if (paramAtomicInteger1 != null) {}
    try
    {
      paramAtomicInteger1.set(paramInt1);
      if (paramAtomicInteger2 != null) {
        paramAtomicInteger2.set(paramInt2);
      }
      if (paramAtomicInteger3 != null) {
        paramAtomicInteger3.set(paramInt3);
      }
      return;
    }
    finally
    {
      label47:
      break label47;
    }
    throw paramAtomicInteger1;
  }
  
  public static void a(boolean paramBoolean, int paramInt, BusinessObserver paramBusinessObserver)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(boolean paramBoolean1, int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean2, boolean paramBoolean3)
  {
    QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "[KidMode]doSwitchSimpleMode sSimpleOpen:", Boolean.valueOf(paramBoolean1), " sSimpleThemeId:", Integer.valueOf(paramInt), " sStudyOpen:", Boolean.valueOf(paramBoolean2), " sKidOpen:", Boolean.valueOf(paramBoolean3) });
    paramBoolean3 = paramBoolean2 | paramBoolean3;
    StudyModeManager.a(paramBoolean3, paramQQAppInterface);
    ((ModeSwitchManager)paramQQAppInterface.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).b(paramBoolean3);
    paramBoolean2 = paramBoolean1;
    if (StudyModeManager.a(paramQQAppInterface, paramBoolean3, paramBoolean1)) {
      paramBoolean2 = false;
    }
    int i = SimpleUIUtil.a(String.valueOf(paramInt));
    if (i != -1)
    {
      SimpleUIProtocolUtil.a(paramQQAppInterface.getCurrentAccountUin(), paramBoolean2, 1);
      SimpleUIProtocolUtil.a(paramQQAppInterface.getCurrentAccountUin(), i, 1);
      return;
    }
    SimpleUIProtocolUtil.a(paramQQAppInterface, paramBoolean2, String.valueOf(paramInt));
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null);
    String str = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (bool != paramBoolean) {
      return true;
    }
    if (!paramBoolean) {
      return false;
    }
    return !paramString.equals(str);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("switch");
    boolean bool5 = paramToServiceMsg.extraData.getBoolean("studyModeSwitch");
    int i = paramToServiceMsg.extraData.getInt("pref");
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("switchElsePref");
    long l = paramToServiceMsg.extraData.getLong("reqTs");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel()) {
      localStringBuilder = new StringBuilder(1024);
    } else {
      localStringBuilder = null;
    }
    KidModeServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", 0, null);
    boolean bool2;
    if (bool1)
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          if (localStringBuilder != null) {
            localStringBuilder.append(String.format("suc=%b bSwitch=%b bPref=%d [%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Integer.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
          }
          bool2 = bool1;
          if (!bool1) {
            break label396;
          }
          StudyModeManager.a(bool5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          SimpleUIProtocolUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), bool3, 3);
          SimpleUIProtocolUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 3);
          bool2 = bool1;
          break label396;
        }
        if (localStringBuilder != null) {
          localStringBuilder.append("fail pkg.bytes is null");
        }
      }
      else if (localStringBuilder != null)
      {
        if (paramToServiceMsg == null) {
          paramToServiceMsg = "pkg=null";
        } else if (paramToServiceMsg.uint32_result.has()) {
          paramToServiceMsg = Integer.valueOf(paramToServiceMsg.uint32_result.get());
        } else {
          paramToServiceMsg = "no result";
        }
        localStringBuilder.append(String.format("fail %s", new Object[] { paramToServiceMsg }));
      }
      bool2 = false;
      label396:
      bool1 = bool2;
    }
    else
    {
      if (localStringBuilder != null) {
        localStringBuilder.append(String.format("fail resultCode=%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
      }
      bool1 = false;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqSetSimpleUISwitch %s", new Object[] { localStringBuilder.toString() }));
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "handleReqSetSimpleUISwitch: ts:", Long.valueOf(l), ", mReqTs: ", Long.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) });
    }
    if (l == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
    {
      if (!bool1)
      {
        bool2 = a(false, "211", SimpleUIUtil.a(), true, SimpleUIUtil.a(SimpleUIUtil.f()));
        if (!bool2) {
          a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
        }
        if (QLog.isColorLevel()) {
          QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqSetSimpleUISwitch revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool2) }));
        }
      }
      else
      {
        a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
      }
      notifyUI(3, bool1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(bool4), Integer.valueOf(5) });
    }
    if (l != 0L) {
      notifyUI(2, bool1, new Object[] { Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool4), str, Long.valueOf(l) });
    }
  }
  
  public long a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUILog.SimpleUIHandler", 2, new Object[] { "sendSwitchAndSetSimpleUI switch:", Boolean.valueOf(paramBoolean1), " prefId:", Integer.valueOf(paramInt), " bSwitchElsePref:", Boolean.valueOf(paramBoolean2), " bStudyModeSwitch", Boolean.valueOf(paramBoolean3) });
    }
    long l = System.currentTimeMillis();
    a(paramBoolean1, paramInt, new SimpleUIHandler.2(this, paramBoolean1, paramInt, paramBoolean2, paramBoolean3, l));
    return l;
  }
  
  public long a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("reqGetSimpleUISwitch uin=%s", new Object[] { str }));
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_simple_ui_switch.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_simple_ui_pref.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_flag_study_mode_switch.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_flag_kid_mode_switch.set(1);
    localObject = makeOIDBPkg("OidbSvc.0x5eb_SimpleUI", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("uin", str);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramLong);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramInt, paramBoolean2, false);
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null);
    String str = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getString("themeID");
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "1000";
    }
    if (paramBoolean3)
    {
      if (bool)
      {
        if (paramBoolean2)
        {
          localObject1 = "2920";
          break label100;
        }
        localObject1 = "1103";
        break label100;
      }
      if (!paramBoolean2)
      {
        localObject1 = localObject2;
        break label100;
      }
    }
    localObject1 = paramString2;
    label100:
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("doSwitchTheme needCallback=%b dst=[%b,%s][cur,pre,to]=[%s,%s,%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString2, str, localObject2, localObject1 }));
    if (str.equals(localObject1)) {
      return false;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean1) {
      paramString2 = new SimpleUIHandler.SimpleUIThemeSwitchCallback(this);
    } else {
      paramString2 = new SimpleUIHandler.EmptyThemeSwitchCallback(this);
    }
    return ThemeSwitcher.a((AppRuntime)localObject2, (String)localObject1, paramString1, paramString2);
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    a(bool, this.b.get(), new SimpleUIHandler.1(this, l));
  }
  
  public void c()
  {
    a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
    boolean bool1 = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    boolean bool2 = SimpleUIUtil.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onPostThemeChanged bSimpleSwitch=%b isSimpleMode=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
    if (bool1 != bool2) {
      QLog.e("SimpleUILog.SimpleUIHandler", 1, String.format("onPostThemeChanged switch inconsistent [%b,%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SimpleUIObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SimpleUIUtil.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (TextUtils.equals("OidbSvc.0x5eb_SimpleUI", paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (TextUtils.equals("OidbSvc.0xed1_SimpleUI", paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler
 * JD-Core Version:    0.7.0.1
 */