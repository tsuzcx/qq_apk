package com.tencent.mobileqq.msf.core.auth;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.msf.service.protocol.e.h;
import com.tencent.msf.service.protocol.e.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class c
{
  static String a = "AccountSyncManager";
  static HashSet b = new HashSet();
  static HashSet c = new HashSet();
  private static final String e = "invalidPackageName";
  private static final String g = "checkSign_ReqUin";
  b d;
  private final String f = "arrtibute_uid";
  
  public c(b paramb)
  {
    this.d = paramb;
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    QLog.d(a, 2, "received accountSyncReq " + paramToServiceMsg);
    String str = this.d.n(paramToServiceMsg.getUin());
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.addAttribute(paramToServiceMsg.getServiceCmd(), str);
    localFromServiceMsg.addAttribute("cmd_sync_syncuser_service", "");
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setFromVersion((byte)0);
    try
    {
      paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w(a, 2, "send account sync resp error", paramToServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    int j = 0;
    Object localObject1 = a(BaseApplication.getContext().getPackageManager(), paramInt);
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      Object localObject2 = new String[localObject1.length];
      int i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = MD5.toMD5(localObject1[i].toCharsString()).toLowerCase();
        i += 1;
      }
      paramToServiceMsg.addAttribute("arrtibute_uid", Integer.valueOf(paramInt));
      localObject1 = new h();
      ((h)localObject1).a = new ArrayList();
      paramInt = j;
      while (paramInt < localObject2.length)
      {
        ((h)localObject1).a.add(localObject2[paramInt]);
        paramInt += 1;
      }
      localObject2 = this.d.d();
      if (localObject2 != null)
      {
        ((h)localObject1).c = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
          ((h)localObject1).c.add(localSimpleAccount.getUin());
        }
      }
      ((h)localObject1).d = 1;
      ((h)localObject1).b = paramToServiceMsg.getAppId();
      localObject2 = new UniPacket(true);
      ((UniPacket)localObject2).setServantName("t");
      ((UniPacket)localObject2).setFuncName("t");
      ((UniPacket)localObject2).put("req", localObject1);
      paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
      paramToServiceMsg.setServiceCmd("PhSigLcId.Check");
      paramToServiceMsg.addAttribute("checkSign_ReqUin", paramToServiceMsg.getUin());
      paramToServiceMsg.setUin("0");
      paramToServiceMsg.setAppId(this.d.a.sender.j());
      paramToServiceMsg.setTimeout(60000L);
      paramToServiceMsg.setMsfCommand(MsfCommand.accountTokenSyncCheckSign);
      this.d.a.sendSsoMsg(paramToServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.addAttribute(paramToServiceMsg.getServiceCmd(), "");
    localFromServiceMsg.addAttribute("cmd_sync_syncuser_service", "");
    localFromServiceMsg.setBusinessFail(paramInt, paramString);
    localFromServiceMsg.setFromVersion((byte)0);
    try
    {
      paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w(a, 2, "send account sync resp error", paramToServiceMsg);
    }
  }
  
  public static Signature[] a(PackageManager paramPackageManager, int paramInt)
  {
    try
    {
      paramPackageManager = a(paramPackageManager, paramPackageManager.getPackagesForUid(paramInt));
      return paramPackageManager;
    }
    catch (Exception paramPackageManager)
    {
      paramPackageManager.printStackTrace();
    }
    return null;
  }
  
  public static Signature[] a(PackageManager paramPackageManager, String[] paramArrayOfString)
  {
    try
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfString[i];
        try
        {
          localObject = paramPackageManager.getPackageInfo((String)localObject, 64).signatures;
          if (localObject != null)
          {
            int k = localObject.length;
            if (k > 0) {
              return localObject;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramPackageManager)
    {
      paramPackageManager.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      localUniPacket = new UniPacket(true);
      localUniPacket.decode(paramFromServiceMsg);
      paramFromServiceMsg = (i)localUniPacket.getByClass("res", new i());
      i = ((Integer)paramToServiceMsg.getAttribute("arrtibute_uid")).intValue();
      QLog.d(a, 2, i + "role " + paramFromServiceMsg.a);
      paramToServiceMsg.setUin((String)paramToServiceMsg.getAttribute("checkSign_ReqUin"));
      if (paramFromServiceMsg.a == 1)
      {
        b.add(Integer.valueOf(i));
        a(paramToServiceMsg);
      }
    }
    while (paramFromServiceMsg.getResultCode() != 1002) {
      for (;;)
      {
        UniPacket localUniPacket;
        int i;
        return;
        a(paramToServiceMsg, 2014, "signError");
        c.add(Integer.valueOf(i));
        try
        {
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_Reason", (String)paramToServiceMsg.getAttribute("invalidPackageName", ""));
          paramFromServiceMsg.put("method", "accountSync");
          if (this.d.a.getStatReporter() != null)
          {
            this.d.a.getStatReporter().a("dim.Msf.invaildAppCall", true, 0L, 0L, paramFromServiceMsg, false, false);
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.d(a, 2, "send invaild call error " + paramToServiceMsg, paramToServiceMsg);
          return;
        }
      }
    }
    a(paramToServiceMsg, 1002, "timeout");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, String[] paramArrayOfString, String paramString, int paramInt)
  {
    int j = 0;
    if (c.contains(Integer.valueOf(paramInt))) {
      return;
    }
    if (b.contains(Integer.valueOf(paramInt)))
    {
      a(paramToServiceMsg);
      return;
    }
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      if (paramArrayOfString[i].equals(paramString))
      {
        QLog.d(a, 2, "found accountSyncRequest from the same packeName application,");
        b.add(Integer.valueOf(paramInt));
        a(paramToServiceMsg);
        return;
      }
      i += 1;
    }
    paramString = "";
    String str = paramString;
    if (paramArrayOfString != null)
    {
      k = paramArrayOfString.length;
      i = j;
      for (;;)
      {
        str = paramString;
        if (i >= k) {
          break;
        }
        str = paramArrayOfString[i];
        paramString = paramString + " " + str + ";";
        i += 1;
      }
    }
    paramToServiceMsg.addAttribute("invalidPackageName", str);
    a(paramToServiceMsg, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.c
 * JD-Core Version:    0.7.0.1
 */