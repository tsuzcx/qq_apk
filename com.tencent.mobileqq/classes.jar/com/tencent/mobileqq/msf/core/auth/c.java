package com.tencent.mobileqq.msf.core.auth;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.d.j;
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
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("received accountSyncReq ");
    ((StringBuilder)localObject).append(paramToServiceMsg);
    QLog.d(str, 2, ((StringBuilder)localObject).toString());
    str = this.d.n(paramToServiceMsg.getUin());
    localObject = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    ((FromServiceMsg)localObject).addAttribute(paramToServiceMsg.getServiceCmd(), str);
    ((FromServiceMsg)localObject).addAttribute("cmd_sync_syncuser_service", "");
    ((FromServiceMsg)localObject).setMsgSuccess();
    ((FromServiceMsg)localObject).setFromVersion((byte)0);
    try
    {
      paramToServiceMsg.actionListener.onActionResult((FromServiceMsg)localObject);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w(a, 2, "send account sync resp error", paramToServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Object localObject1 = a(BaseApplication.getContext().getPackageManager(), paramInt);
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      Object localObject2 = new String[localObject1.length];
      int j = 0;
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
      paramToServiceMsg.setAppId(this.d.a.sender.m());
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
  
  /* Error */
  public static Signature[] a(PackageManager paramPackageManager, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: istore_3
    //   3: iconst_0
    //   4: istore_2
    //   5: iload_2
    //   6: iload_3
    //   7: if_icmpge +51 -> 58
    //   10: aload_1
    //   11: iload_2
    //   12: aaload
    //   13: astore 5
    //   15: aload_0
    //   16: aload 5
    //   18: bipush 64
    //   20: invokevirtual 296	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   23: getfield 302	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   26: astore 5
    //   28: aload 5
    //   30: ifnull +16 -> 46
    //   33: aload 5
    //   35: arraylength
    //   36: istore 4
    //   38: iload 4
    //   40: ifle +6 -> 46
    //   43: aload 5
    //   45: areturn
    //   46: iload_2
    //   47: iconst_1
    //   48: iadd
    //   49: istore_2
    //   50: goto -45 -> 5
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore 5
    //   62: goto -16 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramPackageManager	PackageManager
    //   0	65	1	paramArrayOfString	String[]
    //   4	46	2	i	int
    //   2	6	3	j	int
    //   36	3	4	k	int
    //   13	31	5	localObject	Object
    //   60	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	3	53	java/lang/Exception
    //   15	28	53	java/lang/Exception
    //   33	38	53	java/lang/Exception
    //   15	28	60	android/content/pm/PackageManager$NameNotFoundException
    //   33	38	60	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      Object localObject = new UniPacket(true);
      ((UniPacket)localObject).decode(paramFromServiceMsg);
      paramFromServiceMsg = (i)((UniPacket)localObject).getByClass("res", new i());
      int i = ((Integer)paramToServiceMsg.getAttribute("arrtibute_uid")).intValue();
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("role ");
      localStringBuilder.append(paramFromServiceMsg.a);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      paramToServiceMsg.setUin((String)paramToServiceMsg.getAttribute("checkSign_ReqUin"));
      if (paramFromServiceMsg.a == 1)
      {
        b.add(Integer.valueOf(i));
        a(paramToServiceMsg);
        return;
      }
      a(paramToServiceMsg, 2014, "signError");
      c.add(Integer.valueOf(i));
      try
      {
        paramFromServiceMsg = new HashMap();
        paramFromServiceMsg.put("param_Reason", (String)paramToServiceMsg.getAttribute("invalidPackageName", ""));
        paramFromServiceMsg.put("method", "accountSync");
        if (this.d.a.getStatReporter() == null) {
          return;
        }
        this.d.a.getStatReporter().a("dim.Msf.invaildAppCall", true, 0L, 0L, paramFromServiceMsg, false, false);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send invaild call error ");
        ((StringBuilder)localObject).append(paramToServiceMsg);
        QLog.d(paramFromServiceMsg, 2, ((StringBuilder)localObject).toString(), paramToServiceMsg);
        return;
      }
    }
    else if (paramFromServiceMsg.getResultCode() == 1002)
    {
      a(paramToServiceMsg, 1002, "timeout");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, String[] paramArrayOfString, String paramString, int paramInt)
  {
    if (c.contains(Integer.valueOf(paramInt))) {
      return;
    }
    if (b.contains(Integer.valueOf(paramInt)))
    {
      a(paramToServiceMsg);
      return;
    }
    int k = paramArrayOfString.length;
    int j = 0;
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        localStringBuilder.append(str);
        localStringBuilder.append(";");
        paramString = localStringBuilder.toString();
        i += 1;
      }
    }
    paramToServiceMsg.addAttribute("invalidPackageName", str);
    a(paramToServiceMsg, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.c
 * JD-Core Version:    0.7.0.1
 */