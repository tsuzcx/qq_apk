package com.tencent.mobileqq.simpleui;

import QC.Concise;
import QC.UniBusinessItem;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.qvip.QVipSimpleThemeConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vip.JceProtocol;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0xed1.oidb_0xed1.ReqBody;
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
    ThemeFontAdapter.d();
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
    int j;
    String str;
    boolean bool4;
    boolean bool5;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      j = 1;
      str = paramToServiceMsg.extraData.getString("uin", "");
      bool4 = false;
      bool5 = false;
      i = SimpleUIUtil.f();
      if (!QLog.isColorLevel()) {
        break label755;
      }
    }
    label599:
    label752:
    label755:
    for (StringBuilder localStringBuilder = new StringBuilder(1024);; localStringBuilder = null)
    {
      if (j != 0)
      {
        paramFromServiceMsg = (byte[])paramObject;
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        boolean bool6;
        boolean bool3;
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
          paramToServiceMsg = paramFromServiceMsg;
          if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
            break label599;
          }
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          try
          {
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
            {
              paramToServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
              j = paramToServiceMsg.uint32_simple_ui_switch.get();
              int k = paramToServiceMsg.uint32_flag_study_mode_switch.get();
              if (paramToServiceMsg.uint32_flag_kid_mode_switch.has())
              {
                i = paramToServiceMsg.uint32_flag_kid_mode_switch.get();
                QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "studyFlag:", Integer.valueOf(k), " kidModeFlag:", Integer.valueOf(i) });
                if ((k != 1) && (i != 1)) {
                  continue;
                }
                bool1 = true;
                if (j != 1) {
                  continue;
                }
                bool2 = true;
                j = SimpleUIUtil.f();
                if ((!bool2) || (!bool1)) {
                  break label752;
                }
                bool2 = false;
                j = 0;
                QLog.e("SimpleUILog.SimpleUIHandler", 1, "[KidMode] both true");
                bool6 = true;
                SimpleUIProtocolUtil.a(str, bool2, 2);
                SimpleUIProtocolUtil.a(str, j, 2);
                StudyModeManager.a(bool1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                bool5 = bool2;
                bool4 = bool1;
                i = j;
                bool1 = bool4;
                bool2 = bool5;
                bool3 = bool6;
                if (localStringBuilder != null)
                {
                  localStringBuilder.append(String.format("suc=%b %s", new Object[] { Boolean.valueOf(bool6), str }));
                  bool3 = bool6;
                  bool2 = bool5;
                  bool1 = bool4;
                  i = j;
                }
                bool4 = bool1;
                bool1 = bool2;
                bool2 = bool4;
                j = i;
                if ((QLog.isColorLevel()) && (localStringBuilder != null))
                {
                  localStringBuilder.append("; bSwitch = ").append(bool1).append("; bPref = ").append(j);
                  QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqGetSimpleUISwitch %s", new Object[] { localStringBuilder.toString() }));
                }
                notifyUI(1, bool3, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), str });
                return;
                j = 0;
                break;
                paramFromServiceMsg = paramFromServiceMsg;
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            paramToServiceMsg.printStackTrace();
            continue;
            i = 0;
            continue;
            bool1 = false;
            continue;
            bool2 = false;
            continue;
            bool4 = false;
            bool5 = false;
            bool6 = false;
            j = i;
            continue;
          }
        }
        if (localStringBuilder != null)
        {
          localStringBuilder.append("fail pkg.bytes is null");
          bool1 = false;
          bool2 = false;
          bool3 = false;
          continue;
          if (localStringBuilder != null)
          {
            if (paramToServiceMsg != null) {
              break label642;
            }
            paramToServiceMsg = "pkg=null";
          }
          for (;;)
          {
            localStringBuilder.append(String.format("fail %s", new Object[] { paramToServiceMsg }));
            bool1 = false;
            bool2 = false;
            bool3 = false;
            break;
            if (paramToServiceMsg.uint32_result.has()) {
              paramToServiceMsg = Integer.valueOf(paramToServiceMsg.uint32_result.get());
            } else {
              paramToServiceMsg = "no result";
            }
          }
          bool6 = false;
          bool3 = bool6;
          j = i;
          bool2 = bool5;
          bool1 = bool4;
          if (localStringBuilder != null)
          {
            localStringBuilder.append(String.format("fail resultCode=%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
            bool3 = bool6;
            j = i;
            bool2 = bool5;
            bool1 = bool4;
          }
        }
        else
        {
          bool1 = false;
          bool2 = false;
          bool3 = false;
        }
      }
    }
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
    finally {}
  }
  
  public static void a(boolean paramBoolean, int paramInt, BusinessObserver paramBusinessObserver)
  {
    JceProtocol localJceProtocol = new JceProtocol("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniSet", "stReq", "rsp");
    UniSetReq localUniSetReq = new UniSetReq();
    localUniSetReq.stLogin = JceProtocol.a();
    localUniSetReq.stUniBusinessItem = new UniBusinessItem();
    localUniSetReq.stUniBusinessItem.appid = 307;
    localUniSetReq.stUniBusinessItem.itemid = Integer.decode(SimpleUIUtil.a(paramInt)).intValue();
    localUniSetReq.stConcise = new Concise();
    Concise localConcise = localUniSetReq.stConcise;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localConcise.isSwitch = paramInt;
      localJceProtocol.a("uniSet", localUniSetReq, new UniSetRsp(), paramBusinessObserver, false);
      return;
    }
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
    if (bool != paramBoolean) {}
    do
    {
      return true;
      if (!paramBoolean) {
        return false;
      }
    } while (!paramString.equals(str));
    return false;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2;
    boolean bool3;
    boolean bool5;
    int i;
    boolean bool4;
    long l;
    String str;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      bool3 = paramToServiceMsg.extraData.getBoolean("switch");
      bool5 = paramToServiceMsg.extraData.getBoolean("studyModeSwitch");
      i = paramToServiceMsg.extraData.getInt("pref");
      bool4 = paramToServiceMsg.extraData.getBoolean("switchElsePref");
      l = paramToServiceMsg.extraData.getLong("reqTs");
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!QLog.isColorLevel()) {
        break label738;
      }
    }
    label293:
    label713:
    label738:
    for (StringBuilder localStringBuilder = new StringBuilder(1024);; localStringBuilder = null)
    {
      KidModeServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", 0, null);
      boolean bool1;
      if (bool2)
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
          do
          {
            for (;;)
            {
              paramFromServiceMsg.printStackTrace();
              continue;
              bool2 = false;
              bool1 = bool2;
              if (localStringBuilder != null)
              {
                localStringBuilder.append("fail pkg.bytes is null");
                bool1 = bool2;
              }
            }
            bool2 = false;
            bool1 = bool2;
          } while (localStringBuilder == null);
          if (paramToServiceMsg != null) {
            break label647;
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            if (localStringBuilder != null) {
              localStringBuilder.append(String.format("suc=%b bSwitch=%b bPref=%d [%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
            }
            bool1 = bool2;
            if (bool2)
            {
              StudyModeManager.a(bool5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              SimpleUIProtocolUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), bool3, 3);
              SimpleUIProtocolUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, 3);
              bool1 = bool2;
            }
            if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
              QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqSetSimpleUISwitch %s", new Object[] { localStringBuilder.toString() }));
            }
            if (QLog.isColorLevel()) {
              QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "handleReqSetSimpleUISwitch: ts:", Long.valueOf(l), ", mReqTs: ", Long.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) });
            }
            if (l == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
            {
              if (bool1) {
                break label713;
              }
              bool2 = a(false, "211", SimpleUIUtil.a(), true, SimpleUIUtil.a(SimpleUIUtil.f()));
              if (!bool2) {
                a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
              }
              if (QLog.isColorLevel()) {
                QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqSetSimpleUISwitch revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool2) }));
              }
            }
          }
        }
      }
      for (;;)
      {
        notifyUI(3, bool1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(bool4), Integer.valueOf(5) });
        if (l != 0L) {
          notifyUI(2, bool1, new Object[] { Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool4), str, Long.valueOf(l) });
        }
        return;
        bool2 = false;
        break;
        paramToServiceMsg = "pkg=null";
        for (;;)
        {
          localStringBuilder.append(String.format("fail %s", new Object[] { paramToServiceMsg }));
          bool1 = bool2;
          break;
          if (paramToServiceMsg.uint32_result.has()) {
            paramToServiceMsg = Integer.valueOf(paramToServiceMsg.uint32_result.get());
          } else {
            paramToServiceMsg = "no result";
          }
        }
        if (localStringBuilder != null) {
          localStringBuilder.append(String.format("fail resultCode=%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
        }
        bool1 = false;
        break label293;
        a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
      }
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
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("reqSetSimpleUISwitch [%b,%d,%b] uin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), localObject1 }));
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3793);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
        if (!paramBoolean1) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        int i;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SimpleUILog.SimpleUIHandler", 1, "reqSetSimpleUISwitch ex", localException);
        return paramLong;
      }
      localObject2 = new oidb_0xed1.ReqBody();
      ((oidb_0xed1.ReqBody)localObject2).uint32_simple_mode.set(i);
      ((oidb_0xed1.ReqBody)localObject2).uint32_learn_mode.set(j);
      localObject2 = ((oidb_0xed1.ReqBody)localObject2).toByteArray();
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject2));
      localObject2 = createToServiceMsg("OidbSvc.0xed1_SimpleUI");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).extraData.putBoolean("studyModeSwitch", paramBoolean3);
      ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean1);
      ((ToServiceMsg)localObject2).extraData.putInt("pref", paramInt);
      ((ToServiceMsg)localObject2).extraData.putBoolean("switchElsePref", paramBoolean2);
      ((ToServiceMsg)localObject2).extraData.putLong("reqTs", paramLong);
      sendPbReq((ToServiceMsg)localObject2);
      return paramLong;
      i = 0;
      if (paramBoolean3) {
        j = 1;
      }
    }
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
      ((oidb_0x5eb.ReqBody)localObject).uint32_simple_ui_switch.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_simple_ui_pref.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_flag_study_mode_switch.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_flag_kid_mode_switch.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_SimpleUI", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", str);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramLong);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    int i;
    if (paramBoolean5) {
      if (localBaseActivity != null)
      {
        AtomicInteger localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
        if (!paramBoolean2) {
          break label72;
        }
        i = 1;
        localAtomicInteger.set(i);
        this.b.set(paramInt);
        localAtomicInteger = this.c;
        if (!paramBoolean3) {
          break label78;
        }
        paramInt = 1;
        label56:
        localAtomicInteger.set(paramInt);
        VasH5PayUtil.a(localBaseActivity, QVipSimpleThemeConfig.a(), 1);
      }
    }
    label72:
    label78:
    do
    {
      return;
      i = 0;
      break;
      paramInt = 0;
      break label56;
      ((ModeSwitchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).a(this.b.get(), 1);
      a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
      notifyUI(3, paramBoolean1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(paramBoolean4), Integer.valueOf(5) });
      if ((localBaseActivity != null) && ((localBaseActivity instanceof GeneralSettingActivity))) {
        ((GeneralSettingActivity)localBaseActivity).a(1, SimpleUIUtil.f(), false, true);
      }
    } while (localBaseActivity == null);
    QQToast.a(localBaseActivity, 1, "付费失败", 0).a();
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {
      return false;
    }
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = a(paramBoolean, SimpleUIUtil.a(paramInt));
    if (bool2) {}
    for (boolean bool1 = a(false, "212", paramBoolean, true, SimpleUIUtil.a(paramInt));; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onGetSimpleUISwtichLogin [%b,%b] cur=%s needChange=%b start=%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), localObject, Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      int i;
      if (bool1)
      {
        localObject = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
        if (paramBoolean)
        {
          i = 1;
          a((AtomicInteger)localObject, i, this.b, paramInt, null, -2147483648);
        }
      }
      for (;;)
      {
        return bool1;
        i = 0;
        break;
        a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, null, -2147483648);
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramInt, paramBoolean2, false);
  }
  
  public boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {
      return false;
    }
    Object localObject = SimpleUIUtil.a(paramInt);
    boolean bool = a(paramBoolean1, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("startSwitchSimpleUI [%b,%s,%b] needSwitch=%b", new Object[] { Boolean.valueOf(paramBoolean1), localObject, Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool) }));
    }
    int i;
    label116:
    int j;
    if (bool)
    {
      bool = a(true, "211", paramBoolean1, paramBoolean2, (String)localObject);
      if (!bool) {
        break label212;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      if (!paramBoolean1) {
        break label200;
      }
      i = 1;
      AtomicInteger localAtomicInteger1 = this.b;
      AtomicInteger localAtomicInteger2 = this.c;
      if (!paramBoolean3) {
        break label206;
      }
      j = 1;
      label136:
      a((AtomicInteger)localObject, i, localAtomicInteger1, paramInt, localAtomicInteger2, j);
      this.jdField_a_of_type_Boolean = paramBoolean2;
    }
    for (;;)
    {
      return bool;
      long l = ((SimpleUIHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(paramBoolean1, paramInt, paramBoolean2, paramBoolean3, System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      bool = true;
      break;
      label200:
      i = 0;
      break label116;
      label206:
      j = 0;
      break label136;
      label212:
      a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, -2147483648, this.b, -2147483648, this.c, -2147483648);
    }
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
    if (paramBoolean3) {
      if (bool) {
        if (paramBoolean2) {
          localObject1 = "2920";
        }
      }
    }
    for (;;)
    {
      QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("doSwitchTheme needCallback=%b dst=[%b,%s][cur,pre,to]=[%s,%s,%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString2, str, localObject2, localObject1 }));
      if (str.equals(localObject1))
      {
        return false;
        localObject1 = "1103";
        continue;
        if (paramBoolean2)
        {
          localObject1 = paramString2;
          continue;
        }
        localObject1 = localObject2;
        continue;
        if (paramBoolean2) {
          localObject1 = paramString2;
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean1) {}
        for (paramString2 = new SimpleUIHandler.SimpleUIThemeSwitchCallback(this);; paramString2 = new SimpleUIHandler.EmptyThemeSwitchCallback(this)) {
          return ThemeSwitcher.a((QQAppInterface)localObject2, (String)localObject1, paramString1, paramString2);
        }
      }
      localObject1 = paramString2;
    }
  }
  
  public void b()
  {
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
    for (;;)
    {
      a(bool, this.b.get(), new SimpleUIHandler.1(this, l));
      return;
      bool = false;
    }
  }
  
  public void c()
  {
    if (a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger) != -2147483648) {}
    boolean bool1 = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    boolean bool2 = SimpleUIUtil.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onPostThemeChanged bSimpleSwitch=%b isSimpleMode=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
    if (bool1 != bool2) {
      QLog.e("SimpleUILog.SimpleUIHandler", 1, String.format("onPostThemeChanged switch inconsistent [%b,%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
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
    if (TextUtils.equals("OidbSvc.0x5eb_SimpleUI", paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!TextUtils.equals("OidbSvc.0xed1_SimpleUI", paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler
 * JD-Core Version:    0.7.0.1
 */