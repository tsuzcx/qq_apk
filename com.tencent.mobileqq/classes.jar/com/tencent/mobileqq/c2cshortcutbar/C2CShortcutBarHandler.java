package com.tencent.mobileqq.c2cshortcutbar;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x587.oidb_0x587.ReqBody;
import tencent.im.oidb.cmd0xd51.Oidb_0xd51.AioQuickAppData;
import tencent.im.oidb.cmd0xd51.Oidb_0xd51.ReqBody;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5.App;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5.Label;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5.ReqBody;
import tencent.im.oidb.cmd0xeb5.oidb_0xeb5.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class C2CShortcutBarHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public C2CShortcutBarHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xeb5.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l2 = paramToServiceMsg.extraData.getLong("key_friend_uin");
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarHandler", 2, "handleRequestC2CShortcutAppList result = " + i);
    }
    boolean bool = false;
    paramFromServiceMsg = new ArrayList();
    if (i == 0)
    {
      int j;
      label148:
      label203:
      int k;
      if (((oidb_0xeb5.RspBody)localObject).cache_ts.has())
      {
        i = ((oidb_0xeb5.RspBody)localObject).cache_ts.get();
        C2CShortcutBarManager.a(this.a).a(Long.valueOf(l2), Long.valueOf(System.currentTimeMillis() / 1000L + i));
        if (!((oidb_0xeb5.RspBody)localObject).max_show_app_num.has()) {
          break label730;
        }
        j = ((oidb_0xeb5.RspBody)localObject).max_show_app_num.get();
        C2CShortcutBarManager.a(this.a).a(j);
        if (((oidb_0xeb5.RspBody)localObject).redpoint_cache_ts.has()) {
          ((oidb_0xeb5.RspBody)localObject).redpoint_cache_ts.get();
        }
        if (!((oidb_0xeb5.RspBody)localObject).cookies.has()) {
          break label736;
        }
        ((oidb_0xeb5.RspBody)localObject).cookies.get().toStringUtf8();
        if (!((oidb_0xeb5.RspBody)localObject).expose_id.has()) {
          break label739;
        }
        k = ((oidb_0xeb5.RspBody)localObject).expose_id.get();
        label224:
        C2CShortcutBarManager.a(this.a).a(String.valueOf(l2), k);
        if (!((oidb_0xeb5.RspBody)localObject).app.has()) {
          break label913;
        }
        paramObject = ((oidb_0xeb5.RspBody)localObject).app.get().iterator();
      }
      for (;;)
      {
        if (!paramObject.hasNext()) {
          break label857;
        }
        localObject = (oidb_0xeb5.App)paramObject.next();
        C2CShortcutAppInfo localC2CShortcutAppInfo = new C2CShortcutAppInfo();
        label315:
        long l1;
        label342:
        label369:
        int m;
        label395:
        label421:
        label447:
        label474:
        label502:
        oidb_0xeb5.Label localLabel1;
        label530:
        label557:
        label601:
        C2CShortcutAppInfo.Label localLabel;
        if (((oidb_0xeb5.App)localObject).appid.has())
        {
          paramToServiceMsg = ((oidb_0xeb5.App)localObject).appid.get();
          localC2CShortcutAppInfo.jdField_a_of_type_JavaLangString = paramToServiceMsg;
          if (!((oidb_0xeb5.App)localObject).type.has()) {
            break label752;
          }
          l1 = ((oidb_0xeb5.App)localObject).type.get();
          localC2CShortcutAppInfo.jdField_a_of_type_Long = l1;
          if (!((oidb_0xeb5.App)localObject).name.has()) {
            break label758;
          }
          paramToServiceMsg = ((oidb_0xeb5.App)localObject).name.get();
          localC2CShortcutAppInfo.b = paramToServiceMsg;
          if (!((oidb_0xeb5.App)localObject).icon.has()) {
            break label765;
          }
          paramToServiceMsg = ((oidb_0xeb5.App)localObject).icon.get();
          localC2CShortcutAppInfo.jdField_c_of_type_JavaLangString = paramToServiceMsg;
          if (!((oidb_0xeb5.App)localObject).url.has()) {
            break label772;
          }
          paramToServiceMsg = ((oidb_0xeb5.App)localObject).url.get();
          localC2CShortcutAppInfo.jdField_d_of_type_JavaLangString = paramToServiceMsg;
          if (!((oidb_0xeb5.App)localObject).desc.has()) {
            break label779;
          }
          paramToServiceMsg = ((oidb_0xeb5.App)localObject).desc.get();
          localC2CShortcutAppInfo.e = paramToServiceMsg;
          if (!((oidb_0xeb5.App)localObject).redpoint.has()) {
            break label786;
          }
          m = ((oidb_0xeb5.App)localObject).redpoint.get();
          localC2CShortcutAppInfo.jdField_a_of_type_Int = m;
          if (!((oidb_0xeb5.App)localObject).playing_num.has()) {
            break label792;
          }
          m = ((oidb_0xeb5.App)localObject).playing_num.get();
          localC2CShortcutAppInfo.jdField_c_of_type_Int = m;
          if (!((oidb_0xeb5.App)localObject).ark.has()) {
            break label798;
          }
          bool = ((oidb_0xeb5.App)localObject).ark.get();
          localC2CShortcutAppInfo.jdField_a_of_type_Boolean = bool;
          if (!((oidb_0xeb5.App)localObject).ark_label.has()) {
            break label804;
          }
          paramToServiceMsg = ((oidb_0xeb5.App)localObject).ark_label.get();
          localC2CShortcutAppInfo.g = paramToServiceMsg;
          if (!((oidb_0xeb5.App)localObject).labels.has()) {
            break label832;
          }
          localC2CShortcutAppInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          Iterator localIterator = ((oidb_0xeb5.App)localObject).labels.get().iterator();
          if (!localIterator.hasNext()) {
            break label832;
          }
          localLabel1 = (oidb_0xeb5.Label)localIterator.next();
          localLabel = new C2CShortcutAppInfo.Label();
          if (!localLabel1.string_name.has()) {
            break label811;
          }
          paramToServiceMsg = localLabel1.string_name.get();
          label652:
          localLabel.jdField_a_of_type_JavaLangString = paramToServiceMsg;
          if (!localLabel1.text_color.has()) {
            break label818;
          }
          paramToServiceMsg = localLabel1.text_color.get();
          label678:
          localLabel.jdField_c_of_type_JavaLangString = paramToServiceMsg;
          if (!localLabel1.bg_color.has()) {
            break label825;
          }
        }
        label772:
        label779:
        label786:
        label792:
        label798:
        label804:
        label811:
        label818:
        label825:
        for (paramToServiceMsg = localLabel1.bg_color.get();; paramToServiceMsg = "")
        {
          localLabel.b = paramToServiceMsg;
          localC2CShortcutAppInfo.jdField_a_of_type_JavaUtilArrayList.add(localLabel);
          break label601;
          i = 0;
          break;
          label730:
          j = 0;
          break label148;
          label736:
          break label203;
          label739:
          k = 0;
          break label224;
          paramToServiceMsg = "";
          break label315;
          label752:
          l1 = 0L;
          break label342;
          label758:
          paramToServiceMsg = "";
          break label369;
          label765:
          paramToServiceMsg = "";
          break label395;
          paramToServiceMsg = "";
          break label421;
          paramToServiceMsg = "";
          break label447;
          m = 0;
          break label474;
          m = 0;
          break label502;
          bool = false;
          break label530;
          paramToServiceMsg = "";
          break label557;
          paramToServiceMsg = "";
          break label652;
          paramToServiceMsg = "";
          break label678;
        }
        label832:
        localC2CShortcutAppInfo.jdField_d_of_type_Int = ((oidb_0xeb5.App)localObject).jump_type.get();
        paramFromServiceMsg.add(localC2CShortcutAppInfo);
      }
      label857:
      C2CShortcutBarManager.a(this.a).a(Long.valueOf(l2), paramFromServiceMsg);
      if (paramFromServiceMsg.size() > j) {
        C2CShortcutBarManager.a(this.a).a(String.valueOf(l2), paramFromServiceMsg.subList(j, paramFromServiceMsg.size()));
      }
      label913:
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarHandler", 2, "handleRequestC2CShortcutAppList maxDisplayNum = " + j + "，cacheTS = " + i + "， friendUin = " + l2 + " ，exposeId = " + k + "，shortcutAppInfoList = " + paramFromServiceMsg);
      }
      bool = true;
    }
    notifyUI(1, bool, new Object[] { Long.valueOf(l2), paramFromServiceMsg });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    boolean bool3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      bool3 = ((Boolean)paramToServiceMsg.getAttribute("is_global_open")).booleanValue();
      if (bool1)
      {
        paramFromServiceMsg = (byte[])paramObject;
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
    }
    else
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.d("C2CShortcutBarHandler", 1, "handleSetC2CSwitcherStatus()  e =", paramFromServiceMsg);
          continue;
          bool1 = false;
          continue;
          if (bool3) {
            bool2 = false;
          }
        }
      }
      if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarHandler", 2, new Object[] { "handleSetGlobalSwitcherStatus() isGlobalOpen = ", Boolean.valueOf(bool3), " isSuccess = ", Boolean.valueOf(bool1) });
      }
      paramToServiceMsg = this.a;
      if (bool1)
      {
        bool2 = bool3;
        C2CShortcutBarSwitcher.a(paramToServiceMsg, bool2);
        notifyUI(3, bool1, Boolean.valueOf(bool3));
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (bool2 = true;; bool2 = false)
    {
      bool3 = ((Boolean)paramToServiceMsg.getAttribute("is_open")).booleanValue();
      String str = (String)paramToServiceMsg.getAttribute("friend_uin");
      bool1 = bool2;
      if (bool2)
      {
        paramFromServiceMsg = (byte[])paramObject;
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.d("C2CShortcutBarHandler", 1, "handleSetC2CSwitcherStatus()  e =", paramFromServiceMsg);
          continue;
          bool1 = false;
          continue;
          if (!bool3) {
            bool2 = true;
          } else {
            bool2 = false;
          }
        }
      }
      if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
        break;
      }
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarHandler", 2, new Object[] { "handleSetSwitcherStatus() isOpen = ", Boolean.valueOf(bool3), " isSuccess =" + bool1 });
      }
      paramToServiceMsg = this.a;
      if (!bool1) {
        break label227;
      }
      bool2 = bool3;
      C2CShortcutBarSwitcher.a(paramToServiceMsg, bool2, str);
      notifyUI(2, bool1, new Object[] { str, Boolean.valueOf(bool3) });
      return;
    }
  }
  
  public void a(long paramLong)
  {
    C2CShortcutBarManager.a(this.a).a(Long.valueOf(paramLong), Long.valueOf(0L));
    notifyUI(6, true, new Object[] { Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarHandler", 2, "requestC2CShortcutAppList");
    }
    oidb_0xeb5.ReqBody localReqBody = new oidb_0xeb5.ReqBody();
    localReqBody.friend_uin.set(paramLong);
    localReqBody.aio_type.set(paramInt1);
    localReqBody.redpoint.set(paramBoolean);
    if (paramInt2 > 0) {
      localReqBody.num.set(paramInt2);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localReqBody.cookies.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    paramString = makeOIDBPkg("OidbSvc.oidb_0xeb5", 3765, 1, localReqBody.toByteArray());
    paramString.extraData.putLong("key_friend_uin", paramLong);
    sendPbReq(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    try
    {
      if (!this.a.getCurrentUin().equals(String.valueOf(paramLong2)))
      {
        QLog.d("C2CShortcutBarHandler", 1, "onPushC2CSwitcherStatusChanged() accountUin is not current user just return");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarHandler", 2, "onPushC2CSwitcherStatusChanged()");
      }
      if (paramBoolean) {
        C2CShortcutBarManager.a(this.a).a(Long.valueOf(paramLong1), Long.valueOf(0L));
      }
      C2CShortcutBarSwitcher.a(this.a, paramBoolean, String.valueOf(paramLong1));
      notifyUI(2, true, new Object[] { String.valueOf(paramLong1), Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    Object localObject = new Oidb_0xd51.ReqBody();
    ((Oidb_0xd51.ReqBody)localObject).appid.set(10002L);
    ((Oidb_0xd51.ReqBody)localObject).frd_uin.set(Long.valueOf(paramString).longValue());
    ((Oidb_0xd51.ReqBody)localObject).add_direction.set(1);
    ((Oidb_0xd51.ReqBody)localObject).ext_sns_type.set(25);
    Oidb_0xd51.AioQuickAppData localAioQuickAppData = new Oidb_0xd51.AioQuickAppData();
    PBUInt32Field localPBUInt32Field = localAioQuickAppData.uint32_switch;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      ((Oidb_0xd51.ReqBody)localObject).bytes_aio_quick_app.set(ByteStringMicro.copyFrom(localAioQuickAppData.toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarHandler", 2, new Object[] { "setSwitcherStatus() isOpen = ", Boolean.valueOf(paramBoolean), " friendUin =", paramString });
      }
      localObject = makeOIDBPkg("OidbSvc.oidb_0xd51", 3409, 15, ((Oidb_0xd51.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("is_open", Boolean.valueOf(paramBoolean));
      ((ToServiceMsg)localObject).addAttribute("friend_uin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 2;
    Object localObject2;
    Object localObject1;
    if (this.a != null)
    {
      localObject2 = this.a.getCurrentAccountUin();
      localObject1 = new oidb_0x587.ReqBody();
    }
    try
    {
      long l = Long.parseLong((String)localObject2);
      ((oidb_0x587.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
      localObject2 = ((oidb_0x587.ReqBody)localObject1).uint32_c2c_aio_shortcut_switch;
      if (paramBoolean) {
        i = 1;
      }
      ((PBUInt32Field)localObject2).set(i);
      localObject1 = makeOIDBPkg("OidbSvc.oidb_0x587", 1415, 74, ((oidb_0x587.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("is_global_open", Boolean.valueOf(paramBoolean));
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarHandler", 2, new Object[] { "setGlobalSwitcherStatus() isChecked =", Boolean.valueOf(paramBoolean) });
      }
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("C2CShortcutBarHandler", 1, "setGlobalSwitcherStatus()  e =", localException);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.oidb_0xeb5");
      this.allowCmdSet.add("OidbSvc.oidb_0xd51");
      this.allowCmdSet.add("OidbSvc.oidb_0x587");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return C2CShortcutBarObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      QLog.d("C2CShortcutBarHandler", 4, new Object[] { "onReceive() req.cmd = ", paramToServiceMsg.getServiceCmd() });
    }
    do
    {
      return;
      if ("OidbSvc.oidb_0xeb5".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.oidb_0xd51".equals(paramToServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.oidb_0x587".equals(paramToServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarHandler
 * JD-Core Version:    0.7.0.1
 */