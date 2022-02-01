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
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleRequestC2CShortcutAppList result = ");
      paramToServiceMsg.append(i);
      QLog.d("C2CShortcutBarHandler", 2, paramToServiceMsg.toString());
    }
    paramFromServiceMsg = new ArrayList();
    boolean bool;
    if (i == 0)
    {
      if (((oidb_0xeb5.RspBody)localObject).cache_ts.has()) {
        i = ((oidb_0xeb5.RspBody)localObject).cache_ts.get();
      } else {
        i = 0;
      }
      C2CShortcutBarManager.a(this.a).a(Long.valueOf(l2), Long.valueOf(System.currentTimeMillis() / 1000L + i));
      int j;
      if (((oidb_0xeb5.RspBody)localObject).max_show_app_num.has()) {
        j = ((oidb_0xeb5.RspBody)localObject).max_show_app_num.get();
      } else {
        j = 0;
      }
      C2CShortcutBarManager.a(this.a).a(j);
      if (((oidb_0xeb5.RspBody)localObject).redpoint_cache_ts.has()) {
        ((oidb_0xeb5.RspBody)localObject).redpoint_cache_ts.get();
      }
      if (((oidb_0xeb5.RspBody)localObject).cookies.has()) {
        ((oidb_0xeb5.RspBody)localObject).cookies.get().toStringUtf8();
      }
      int k;
      if (((oidb_0xeb5.RspBody)localObject).expose_id.has()) {
        k = ((oidb_0xeb5.RspBody)localObject).expose_id.get();
      } else {
        k = 0;
      }
      C2CShortcutBarManager.a(this.a).a(String.valueOf(l2), k);
      if (((oidb_0xeb5.RspBody)localObject).app.has())
      {
        paramObject = ((oidb_0xeb5.RspBody)localObject).app.get().iterator();
        while (paramObject.hasNext())
        {
          localObject = (oidb_0xeb5.App)paramObject.next();
          C2CShortcutAppInfo localC2CShortcutAppInfo = new C2CShortcutAppInfo();
          if (((oidb_0xeb5.App)localObject).appid.has()) {
            paramToServiceMsg = ((oidb_0xeb5.App)localObject).appid.get();
          } else {
            paramToServiceMsg = "";
          }
          localC2CShortcutAppInfo.jdField_a_of_type_JavaLangString = paramToServiceMsg;
          long l1;
          if (((oidb_0xeb5.App)localObject).type.has()) {
            l1 = ((oidb_0xeb5.App)localObject).type.get();
          } else {
            l1 = 0L;
          }
          localC2CShortcutAppInfo.jdField_a_of_type_Long = l1;
          if (((oidb_0xeb5.App)localObject).name.has()) {
            paramToServiceMsg = ((oidb_0xeb5.App)localObject).name.get();
          } else {
            paramToServiceMsg = "";
          }
          localC2CShortcutAppInfo.b = paramToServiceMsg;
          if (((oidb_0xeb5.App)localObject).icon.has()) {
            paramToServiceMsg = ((oidb_0xeb5.App)localObject).icon.get();
          } else {
            paramToServiceMsg = "";
          }
          localC2CShortcutAppInfo.jdField_c_of_type_JavaLangString = paramToServiceMsg;
          if (((oidb_0xeb5.App)localObject).url.has()) {
            paramToServiceMsg = ((oidb_0xeb5.App)localObject).url.get();
          } else {
            paramToServiceMsg = "";
          }
          localC2CShortcutAppInfo.jdField_d_of_type_JavaLangString = paramToServiceMsg;
          if (((oidb_0xeb5.App)localObject).desc.has()) {
            paramToServiceMsg = ((oidb_0xeb5.App)localObject).desc.get();
          } else {
            paramToServiceMsg = "";
          }
          localC2CShortcutAppInfo.e = paramToServiceMsg;
          int m;
          if (((oidb_0xeb5.App)localObject).redpoint.has()) {
            m = ((oidb_0xeb5.App)localObject).redpoint.get();
          } else {
            m = 0;
          }
          localC2CShortcutAppInfo.jdField_a_of_type_Int = m;
          if (((oidb_0xeb5.App)localObject).playing_num.has()) {
            m = ((oidb_0xeb5.App)localObject).playing_num.get();
          } else {
            m = 0;
          }
          localC2CShortcutAppInfo.jdField_c_of_type_Int = m;
          if (((oidb_0xeb5.App)localObject).ark.has()) {
            bool = ((oidb_0xeb5.App)localObject).ark.get();
          } else {
            bool = false;
          }
          localC2CShortcutAppInfo.jdField_a_of_type_Boolean = bool;
          if (((oidb_0xeb5.App)localObject).ark_label.has()) {
            paramToServiceMsg = ((oidb_0xeb5.App)localObject).ark_label.get();
          } else {
            paramToServiceMsg = "";
          }
          localC2CShortcutAppInfo.g = paramToServiceMsg;
          if (((oidb_0xeb5.App)localObject).labels.has())
          {
            localC2CShortcutAppInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            Iterator localIterator = ((oidb_0xeb5.App)localObject).labels.get().iterator();
            while (localIterator.hasNext())
            {
              oidb_0xeb5.Label localLabel1 = (oidb_0xeb5.Label)localIterator.next();
              C2CShortcutAppInfo.Label localLabel = new C2CShortcutAppInfo.Label();
              if (localLabel1.string_name.has()) {
                paramToServiceMsg = localLabel1.string_name.get();
              } else {
                paramToServiceMsg = "";
              }
              localLabel.jdField_a_of_type_JavaLangString = paramToServiceMsg;
              if (localLabel1.text_color.has()) {
                paramToServiceMsg = localLabel1.text_color.get();
              } else {
                paramToServiceMsg = "";
              }
              localLabel.jdField_c_of_type_JavaLangString = paramToServiceMsg;
              if (localLabel1.bg_color.has()) {
                paramToServiceMsg = localLabel1.bg_color.get();
              } else {
                paramToServiceMsg = "";
              }
              localLabel.b = paramToServiceMsg;
              localC2CShortcutAppInfo.jdField_a_of_type_JavaUtilArrayList.add(localLabel);
            }
          }
          localC2CShortcutAppInfo.jdField_d_of_type_Int = ((oidb_0xeb5.App)localObject).jump_type.get();
          paramFromServiceMsg.add(localC2CShortcutAppInfo);
        }
        C2CShortcutBarManager.a(this.a).a(Long.valueOf(l2), paramFromServiceMsg);
        if (paramFromServiceMsg.size() > j) {
          C2CShortcutBarManager.a(this.a).a(String.valueOf(l2), paramFromServiceMsg.subList(j, paramFromServiceMsg.size()));
        }
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleRequestC2CShortcutAppList maxDisplayNum = ");
        paramToServiceMsg.append(j);
        paramToServiceMsg.append("，cacheTS = ");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append("， friendUin = ");
        paramToServiceMsg.append(l2);
        paramToServiceMsg.append(" ，exposeId = ");
        paramToServiceMsg.append(k);
        paramToServiceMsg.append("，shortcutAppInfoList = ");
        paramToServiceMsg.append(paramFromServiceMsg);
        QLog.d("C2CShortcutBarHandler", 2, paramToServiceMsg.toString());
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    notifyUI(1, bool, new Object[] { Long.valueOf(l2), paramFromServiceMsg });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = false;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("is_global_open")).booleanValue();
    boolean bool1 = bool2;
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
        QLog.d("C2CShortcutBarHandler", 1, "handleSetC2CSwitcherStatus()  e =", paramFromServiceMsg);
      }
      if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarHandler", 2, new Object[] { "handleSetGlobalSwitcherStatus() isGlobalOpen = ", Boolean.valueOf(bool3), " isSuccess = ", Boolean.valueOf(bool1) });
    }
    paramToServiceMsg = this.a;
    if (bool1)
    {
      bool2 = bool3;
    }
    else
    {
      bool2 = bool4;
      if (!bool3) {
        bool2 = true;
      }
    }
    C2CShortcutBarSwitcher.a(paramToServiceMsg, bool2);
    notifyUI(3, bool1, Boolean.valueOf(bool3));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("is_open")).booleanValue();
    String str = (String)paramToServiceMsg.getAttribute("friend_uin");
    boolean bool1 = bool2;
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
        QLog.d("C2CShortcutBarHandler", 1, "handleSetC2CSwitcherStatus()  e =", paramFromServiceMsg);
      }
      if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append(" isSuccess =");
      paramToServiceMsg.append(bool1);
      QLog.d("C2CShortcutBarHandler", 2, new Object[] { "handleSetSwitcherStatus() isOpen = ", Boolean.valueOf(bool3), paramToServiceMsg.toString() });
    }
    paramToServiceMsg = this.a;
    if (bool1) {
      bool2 = bool3;
    } else if (!bool3) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    C2CShortcutBarSwitcher.a(paramToServiceMsg, bool2, str);
    notifyUI(2, bool1, new Object[] { str, Boolean.valueOf(bool3) });
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
      boolean bool = this.a.getCurrentUin().equals(String.valueOf(paramLong2));
      if (!bool)
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.a;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
      localObject1 = new oidb_0x587.ReqBody();
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong((String)localObject2);
        ((oidb_0x587.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
        localObject2 = ((oidb_0x587.ReqBody)localObject1).uint32_c2c_aio_shortcut_switch;
        if (!paramBoolean) {
          break label149;
        }
        i = 1;
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
      return;
      label149:
      int i = 2;
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return C2CShortcutBarObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.d("C2CShortcutBarHandler", 4, new Object[] { "onReceive() req.cmd = ", paramToServiceMsg.getServiceCmd() });
      return;
    }
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
    if ("OidbSvc.oidb_0x587".equals(paramToServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarHandler
 * JD-Core Version:    0.7.0.1
 */