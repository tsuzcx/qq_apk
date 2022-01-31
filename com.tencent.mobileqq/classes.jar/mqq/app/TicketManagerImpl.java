package mqq.app;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.request.WtloginHelper;

public class TicketManagerImpl
  implements TicketManager
{
  private static final int FAIL_NOT_PSKEY_DOMAIN = -5;
  private static final int FAIL_SDK_EXCEPTION = -4;
  private static final int FAIL_TICKET_NULL = -2;
  private static final int FAIL_TICKET_SIG_NULL = -3;
  private static final int FAIL_UIN_NONE = -1;
  private static final String TAG = "TicketManager";
  private HashMap<String, String> mAlterTicketsMap = new HashMap();
  private final AppRuntime mApp;
  private ArrayList<TicketManagerListener> mTicketListeners = new ArrayList();
  private WtloginHelper mWtLoginHelper;
  
  public TicketManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mWtLoginHelper = new WtloginHelper(BaseApplication.getContext(), this);
    this.mWtLoginHelper.SetMsfTransportFlag(1);
    oicq.wlogin_sdk.tools.util.LOGCAT_OUT = false;
  }
  
  private void reportGetTicketResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public Ticket GetLocalTicket(String paramString, int paramInt)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, paramInt);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.d("TicketManager", 1, "cannot getLocalTicket from helper " + paramString.toString());
    }
    return null;
  }
  
  public Ticket GetPskey(String paramString, long paramLong, String[] paramArrayOfString, WtTicketPromise paramWtTicketPromise)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetPskey(paramString, paramLong, paramArrayOfString, paramWtTicketPromise);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.d("TicketManager", 1, "cannot getpskey from helper " + paramString.toString());
    }
    return null;
  }
  
  public Ticket GetSkey(String paramString, long paramLong, WtTicketPromise paramWtTicketPromise)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetSkey(paramString, paramLong, paramWtTicketPromise);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.d("TicketManager", 1, "cannot getskey from helper " + paramString.toString());
    }
    return null;
  }
  
  public Ticket GetTicket(String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise, Bundle paramBundle)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetTicket(paramString, paramLong, paramInt, paramWtTicketPromise, paramBundle);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.d("TicketManager", 1, "cannot getticket from helper " + paramString.toString());
    }
    return null;
  }
  
  public String getA2(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 64);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "A2", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, a!");
          return HexUtil.bytes2HexStr((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, A2, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, A2, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "A2", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("A2")))) {
        continue;
      }
      reportGetTicketResult(true, "A2", paramString, i);
      return (String)this.mAlterTicketsMap.get("A2");
      QLog.d("TicketManager", 1, "get ticket failed, A2, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, A2, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public byte[] getDA2(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 33554432);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "da2", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, da!");
          return localObject;
        }
        QLog.d("TicketManager", 1, "get ticket failed, da2, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, da2, exception: " + localException.toString());
        int i = -4;
        continue;
      }
      reportGetTicketResult(false, "da2", paramString, i);
      return null;
      QLog.d("TicketManager", 1, "get ticket failed, da2, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, da2, uin is empty!");
      i = -1;
    }
  }
  
  public String getPskey(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        QLog.d("TicketManager", 1, "domain: " + paramString2);
        Ticket localTicket = this.mWtLoginHelper.GetLocalTicket(paramString1, 16L, 1048576);
        if ((localTicket == null) || (localTicket._pskey_map == null)) {
          continue;
        }
        paramString2 = (byte[])localTicket._pskey_map.get(paramString2);
        if (paramString2 != null)
        {
          reportGetTicketResult(true, "PSKEY", paramString1, 0);
          QLog.d("TicketManager", 1, "get ticket succ, ps!");
          return new String(paramString2);
        }
        QLog.d("TicketManager", 1, "get ticket failed, PSKEY, sig is null");
        i = -3;
      }
      catch (Exception paramString2)
      {
        QLog.d("TicketManager", 1, "get ticket failed, PSKEY, exception: " + paramString2.toString());
        int i = -4;
        continue;
      }
      reportGetTicketResult(false, "PSKEY", paramString1, i);
      return null;
      QLog.d("TicketManager", 1, "get ticket failed, PSKEY, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, PSKEY, uin is empty!");
      i = -1;
    }
  }
  
  public String getPt4Token(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        QLog.d("TicketManager", 1, "domain: " + paramString2);
        Ticket localTicket = this.mWtLoginHelper.GetLocalTicket(paramString1, 16L, 1048576);
        if (localTicket == null) {
          continue;
        }
        paramString2 = localTicket.getPt4Token(paramString2);
        if (paramString2 != null)
        {
          reportGetTicketResult(true, "PT4TOKEN", paramString1, 0);
          QLog.d("TicketManager", 1, "get ticket succ, pt!");
          return paramString2;
        }
        QLog.d("TicketManager", 1, "get ticket failed, PT4TOKEN, expired");
        i = -3;
      }
      catch (Exception paramString2)
      {
        QLog.d("TicketManager", 1, "get ticket failed, PT4TOKEN, exception: " + paramString2.toString());
        int i = -4;
        continue;
      }
      reportGetTicketResult(false, "PT4TOKEN", paramString1, i);
      return null;
      QLog.d("TicketManager", 1, "get ticket failed, PT4TOKEN, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, PT4TOKEN, uin is empty!");
      i = -1;
    }
  }
  
  public String getSkey(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 4096);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "SKEY", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, sk!");
          return new String((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, SKEY, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, SKEY, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "SKEY", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("skey")))) {
        continue;
      }
      reportGetTicketResult(true, "SKEY", paramString, i);
      return (String)this.mAlterTicketsMap.get("skey");
      QLog.d("TicketManager", 1, "get ticket failed, SKEY, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, SKEY, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public byte[] getSt(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, paramInt, 128);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "st", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, st!");
          return localObject;
        }
        QLog.d("TicketManager", 1, "get ticket failed, st, sig is null");
        paramInt = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, st, exception: " + localException.toString());
        paramInt = -4;
        continue;
      }
      reportGetTicketResult(false, "st", paramString, paramInt);
      return null;
      QLog.d("TicketManager", 1, "get ticket failed, st, ticket is null");
      paramInt = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, st, uin is empty!");
      paramInt = -1;
    }
  }
  
  public byte[] getStkey(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, paramInt, 128);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig_key;
        if (localObject != null)
        {
          reportGetTicketResult(true, "stKey", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, stKey!");
          return localObject;
        }
        QLog.d("TicketManager", 1, "get ticket failed, stKey, sig is null");
        paramInt = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, stKey, exception: " + localException.toString());
        paramInt = -4;
        continue;
      }
      reportGetTicketResult(false, "stKey", paramString, paramInt);
      return null;
      QLog.d("TicketManager", 1, "get ticket failed, stKey, ticket is null");
      paramInt = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, stKey, uin is empty!");
      paramInt = -1;
    }
  }
  
  public String getStweb(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 32);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "STWEB", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, st!");
          return HexUtil.bytes2HexStr((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, STWEB, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, STWEB, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "STWEB", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("stweb")))) {
        continue;
      }
      reportGetTicketResult(true, "STWEB", paramString, i);
      return (String)this.mAlterTicketsMap.get("stweb");
      QLog.d("TicketManager", 1, "get ticket failed, STWEB, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, STWEB, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  public String getSuperkey(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 1048576);
        if (localObject == null) {
          continue;
        }
        localObject = ((Ticket)localObject)._sig;
        if (localObject != null)
        {
          reportGetTicketResult(true, "SUPERKEY", paramString, 0);
          QLog.d("TicketManager", 1, "get ticket succ, su!");
          return new String((byte[])localObject);
        }
        QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, sig is null");
        i = -3;
      }
      catch (Exception localException)
      {
        QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, exception: " + localException.toString());
        int i = -4;
        continue;
        reportGetTicketResult(false, "SUPERKEY", paramString, i);
      }
      if ((this.mApp == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())) || (TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("superkey")))) {
        continue;
      }
      reportGetTicketResult(true, "SUPERKEY", paramString, i);
      return (String)this.mAlterTicketsMap.get("superkey");
      QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, ticket is null");
      i = -2;
      continue;
      QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, uin is empty!");
      i = -1;
    }
    return null;
  }
  
  @Deprecated
  public String getVkey(String paramString)
  {
    return null;
  }
  
  public void onDestroy() {}
  
  public void registTicketManagerListener(TicketManagerListener paramTicketManagerListener)
  {
    try
    {
      if (!this.mTicketListeners.contains(paramTicketManagerListener)) {
        this.mTicketListeners.add(paramTicketManagerListener);
      }
      return;
    }
    catch (Throwable paramTicketManagerListener)
    {
      paramTicketManagerListener.printStackTrace();
    }
  }
  
  public void reloadCache(Context paramContext)
  {
    QLog.d("TicketManager", 1, "reload ticket cache");
    if (this.mWtLoginHelper == null) {
      this.mWtLoginHelper = new WtloginHelper(paramContext, true);
    }
    while ((this.mTicketListeners != null) && (this.mTicketListeners.size() > 0))
    {
      paramContext = this.mTicketListeners.iterator();
      while (paramContext.hasNext()) {
        ((TicketManagerListener)paramContext.next()).onTicketRefreshed();
      }
      this.mWtLoginHelper.RefreshMemorySig();
    }
  }
  
  public int sendRPCData(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("uin", paramString1);
      localNewIntent.putExtra("cmd", paramString2);
      localNewIntent.putExtra("busBuf", paramArrayOfByte);
      localNewIntent.putExtra("timeout", paramInt);
      localNewIntent.putExtra("wtsdkseq", paramLong);
      localNewIntent.putExtra("action", 2203);
      this.mApp.getServletContainer().forward(this.mApp, localNewIntent);
      return 0;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public void setAlterTicket(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (this.mApp == null)) {}
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    do
    {
      return;
      QLog.d("TicketManager", 1, "set alter tickets for " + MsfSdkUtils.getShortUin(this.mApp.getAccount()));
      str1 = (String)paramHashMap.get("uin");
      str2 = (String)paramHashMap.get("A2");
      str3 = (String)paramHashMap.get("vkey");
      str4 = (String)paramHashMap.get("skey");
      str5 = (String)paramHashMap.get("stweb");
      paramHashMap = (String)paramHashMap.get("superkey");
    } while ((this.mApp == null) || (this.mApp.getAccount() == null) || (!this.mApp.getAccount().equals(str1)));
    this.mAlterTicketsMap.put("A2", str2);
    this.mAlterTicketsMap.put("vkey", str3);
    this.mAlterTicketsMap.put("skey", str4);
    this.mAlterTicketsMap.put("stweb", str5);
    this.mAlterTicketsMap.put("superkey", paramHashMap);
  }
  
  public void unregistTicketManagerListener(TicketManagerListener paramTicketManagerListener)
  {
    try
    {
      if (this.mTicketListeners.contains(paramTicketManagerListener)) {
        this.mTicketListeners.remove(paramTicketManagerListener);
      }
      return;
    }
    catch (Throwable paramTicketManagerListener)
    {
      paramTicketManagerListener.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.TicketManagerImpl
 * JD-Core Version:    0.7.0.1
 */