package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.e;
import com.tencent.msf.service.protocol.security.f;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class b
{
  public static final String d = "grayCheck";
  private static final String i = "QQ";
  private static final String j = "MSF.C.AccountCenter";
  private static final String k = "key_account_head_";
  private static final String l = "__loginSdk_uinMapping";
  MsfCore a;
  ConcurrentHashMap b = new ConcurrentHashMap();
  public c c;
  public j e;
  public k f;
  public d g;
  int h = 0;
  private ConcurrentHashMap m = new ConcurrentHashMap();
  private ConcurrentHashMap n = new ConcurrentHashMap();
  private String o = "0";
  private String p = "key_main_account";
  
  public b(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
    paramMsfCore = MsfStore.getNativeConfigStore().getConfig(this.p);
    if (!TextUtils.isEmpty(paramMsfCore)) {
      this.o = paramMsfCore;
    }
    this.e = new j(this);
    this.f = new k(this);
    this.g = new d(this);
    this.c = new c(this);
  }
  
  private long a(String paramString, int paramInt)
  {
    paramString = l.e.GetLocalTicket(paramString, 16L, paramInt);
    if (paramString != null)
    {
      l1 = paramString._create_time * 1000L;
      if (l1 > 0L) {
        return l1;
      }
    }
    long l2;
    if ((paramInt != 64) && (paramInt != 262144) && (paramInt != 524288)) {
      l2 = System.currentTimeMillis();
    }
    for (long l1 = 21600000L;; l1 = 604800000L)
    {
      return l2 - l1;
      l2 = System.currentTimeMillis();
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    b(paramArrayList);
    if (paramArrayList.size() == 0)
    {
      String[] arrayOfString = MsfStore.getNativeConfigStore().n_getConfigList("key_account_head_");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("try load accounts ");
        ((StringBuilder)localObject).append(arrayOfString.length);
        QLog.d("MSF.C.AccountCenter", 1, ((StringBuilder)localObject).toString());
        int i2 = arrayOfString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localObject = arrayOfString[i1];
          try
          {
            localObject = a.b((String)localObject);
            ((a)localObject).c("QQ");
            paramArrayList.add(localObject);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("load account ");
              localStringBuilder.append(((a)localObject).d());
              localStringBuilder.append(" logined:");
              localStringBuilder.append(((a)localObject).n());
              QLog.d("MSF.C.AccountCenter", 2, localStringBuilder.toString());
            }
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse account error ");
            localStringBuilder.append(localThrowable.toString());
            QLog.w("MSF.C.AccountCenter", 1, localStringBuilder.toString(), localThrowable);
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    Iterator localIterator = l.e.GetAllLoginInfo().iterator();
    Object localObject1;
    if (localIterator.hasNext()) {
      localObject1 = (WloginLoginInfo)localIterator.next();
    }
    for (;;)
    {
      label618:
      try
      {
        for (;;)
        {
          localObject2 = String.valueOf(((WloginLoginInfo)localObject1).mUin);
          Object localObject3;
          if (QLog.isDevelopLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("loadAccountInfoFromWt uin: ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("MSF.C.AccountCenter", 4, ((StringBuilder)localObject3).toString());
          }
          if (l.e.IsNeedLoginWithPasswd((String)localObject2, 16L).booleanValue()) {
            break label618;
          }
          Object localObject4 = l.e.GetLocalSig((String)localObject2, 16L);
          byte[] arrayOfByte2 = WtloginHelper.GetTicketSig((WUserSigInfo)localObject4, 64);
          byte[] arrayOfByte3 = WtloginHelper.GetTicketSig((WUserSigInfo)localObject4, 262144);
          byte[] arrayOfByte1 = WtloginHelper.GetTicketSigKey((WUserSigInfo)localObject4, 262144);
          if ((localObject4 != null) && (arrayOfByte2 != null) && (arrayOfByte2.length != 0) && (arrayOfByte3 != null) && (arrayOfByte3.length != 0) && (arrayOfByte1 != null) && (arrayOfByte1.length != 0))
          {
            localObject3 = new a((String)localObject2);
            ((a)localObject3).e(arrayOfByte2);
            ((a)localObject3).h(arrayOfByte3);
            arrayOfByte2 = new byte[16];
            j.a(arrayOfByte2, 0, arrayOfByte1, arrayOfByte1.length);
            ((a)localObject3).j(arrayOfByte2);
            ((a)localObject3).b(WtloginHelper.GetTicketSig((WUserSigInfo)localObject4, 4096));
            ((a)localObject3).c(WtloginHelper.GetTicketSig((WUserSigInfo)localObject4, 32));
            i1 = 1;
            ((a)localObject3).a(true);
            ((a)localObject3).a(System.currentTimeMillis());
            long l2 = a((String)localObject2, 64);
            long l3 = a((String)localObject2, 262144);
            long l1 = l2;
            if (l2 > l3) {
              l1 = l3;
            }
            ((a)localObject3).b(l1);
            ((a)localObject3).c(a((String)localObject2, 524288));
            l2 = a((String)localObject2, 4096);
            l3 = a((String)localObject2, 32);
            ((a)localObject3).d(l2);
            l1 = l2;
            if (l2 > l3) {
              l1 = l3;
            }
            ((a)localObject3).e(l1);
            if (((WloginLoginInfo)localObject1).mLoginBitmap == 0) {
              ((a)localObject3).c("QQ");
            }
            localObject4 = new WloginSimpleInfo();
            if (l.e.GetBasicUserInfo((String)localObject2, (WloginSimpleInfo)localObject4).booleanValue())
            {
              ((a)localObject3).b(localObject4._age[0]);
              ((a)localObject3).n(((WloginSimpleInfo)localObject4)._nick);
              if (localObject4._gender[0] != 1) {
                break label675;
              }
              ((a)localObject3).c(i1);
              ((a)localObject3).a(util.buf_to_int16(((WloginSimpleInfo)localObject4)._face, 0));
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("load account from wt ");
              ((StringBuilder)localObject2).append(((a)localObject3).d());
              ((StringBuilder)localObject2).append(" logined:");
              ((StringBuilder)localObject2).append(((a)localObject3).n());
              ((StringBuilder)localObject2).append(" mLoginBitmap:");
              ((StringBuilder)localObject2).append(((WloginLoginInfo)localObject1).mLoginBitmap);
              QLog.d("MSF.C.AccountCenter", 2, ((StringBuilder)localObject2).toString());
            }
          }
          try
          {
            paramArrayList.add(localObject3);
          }
          catch (Throwable localThrowable1)
          {
            break label623;
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("load account from wt failed, because of invalid token ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.w("MSF.C.AccountCenter", 2, ((StringBuilder)localObject1).toString());
        break;
      }
      catch (Throwable localThrowable2) {}
      label623:
      if (!QLog.isColorLevel()) {
        break;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse account from wt error ");
      ((StringBuilder)localObject2).append(localThrowable2.toString());
      QLog.w("MSF.C.AccountCenter", 2, ((StringBuilder)localObject2).toString(), localThrowable2);
      break;
      return;
      label675:
      int i1 = 2;
    }
  }
  
  private void d(a parama)
  {
    try
    {
      a(parama);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      ((StringBuilder)localObject).append(" handleLoadedAccounts setKey ");
      ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(parama.d()));
      QLog.d("MSF.C.AccountCenter", 1, ((StringBuilder)localObject).toString());
      CodecWarpper.nativeSetAccountKey(parama.d(), parama.e(), parama.f(), parama.g(), parama.h(), parama.i(), parama.j(), parama.k(), parama.l(), null);
      ac.a(parama.d(), false);
      localObject = MsfStore.getNativeConfigStore();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__loginSdk_uinMapping_");
      localStringBuilder.append(parama.d());
      localObject = ((NativeConfigStore)localObject).getConfig(localStringBuilder.toString());
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.m.put(parama.d(), localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handle account ");
        ((StringBuilder)localObject).append(parama.d());
        ((StringBuilder)localObject).append(" logined:");
        ((StringBuilder)localObject).append(parama.n());
        ((StringBuilder)localObject).append(" len:");
        ((StringBuilder)localObject).append(parama.k().length);
        QLog.d("MSF.C.AccountCenter", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable parama)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse account error ");
      ((StringBuilder)localObject).append(parama.toString());
      QLog.w("MSF.C.AccountCenter", 1, ((StringBuilder)localObject).toString(), parama);
    }
  }
  
  private boolean d(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramString1 != null)
    {
      bool1 = bool3;
      if (paramString1.length() > 0)
      {
        this.n.remove(paramString1);
        NativeConfigStore localNativeConfigStore = MsfStore.getNativeConfigStore();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_account_head_");
        localStringBuilder.append(paramString1);
        localNativeConfigStore.n_removeConfig(localStringBuilder.toString());
        localNativeConfigStore = MsfStore.getNativeConfigStore();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("__loginSdk_uinMapping_");
        localStringBuilder.append(paramString1);
        localNativeConfigStore.n_removeConfig(localStringBuilder.toString());
        bool1 = bool2;
        try
        {
          bool2 = new WtloginHelper(BaseApplication.getContext()).ClearUserLoginData(paramString2, 16L).booleanValue();
          bool1 = bool2;
          paramString2 = new StringBuilder();
          bool1 = bool2;
          paramString2.append("remove storeConfig and clear wtlogin user data uin=");
          bool1 = bool2;
          paramString2.append(MsfSdkUtils.getShortUin(paramString1));
          bool1 = bool2;
          paramString2.append(" removed=");
          bool1 = bool2;
          paramString2.append(bool2);
          bool1 = bool2;
          QLog.d("MSF.C.AccountCenter", 1, paramString2.toString());
          return bool2;
        }
        catch (Throwable paramString1)
        {
          paramString2 = new StringBuilder();
          paramString2.append("del wttoken error ");
          paramString2.append(paramString1);
          QLog.d("MSF.C.AccountCenter", 1, paramString2.toString());
        }
      }
    }
    return bool1;
  }
  
  private void j()
  {
    try
    {
      Object localObject;
      if (!MsfSdkUtils.getNewAppUinStoreFile().exists())
      {
        Iterator localIterator = this.n.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          if (((a)((Map.Entry)localObject).getValue()).y().equals("QQ"))
          {
            MsfSdkUtils.addSimpleAccount(((a)((Map.Entry)localObject).getValue()).d());
            if (((a)((Map.Entry)localObject).getValue()).n()) {
              MsfSdkUtils.updateSimpleAccount(((a)((Map.Entry)localObject).getValue()).d(), true);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add simpleAccount store error ");
        ((StringBuilder)localObject).append(localException);
        QLog.d("MSF.C.AccountCenter", 2, ((StringBuilder)localObject).toString(), localException);
      }
    }
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    VerifyCodeInfo localVerifyCodeInfo = VerifyCodeInfo.getVerifyCodeInfo(paramToServiceMsg);
    String str = (String)paramToServiceMsg.getAttributes().get("to_verify_code");
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), str, localVerifyCodeInfo));
    return this.a.sendSsoMsg(paramToServiceMsg);
  }
  
  public int a(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = (byte[])paramToServiceMsg.getAttributes().get("to_login_pwd");
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), arrayOfByte, paramInt1, paramInt2, paramArrayOfByte));
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    return this.a.sendSsoMsg(paramToServiceMsg);
  }
  
  public int a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    Object localObject = (HashMap)paramToServiceMsg.getAttributes().get("to_login_token_map");
    int i1 = ((Integer)paramToServiceMsg.getAttributes().get("to_login_token_cmdhead")).intValue();
    localObject = this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), i1, (HashMap)localObject);
    paramToServiceMsg.setServiceCmd("login.chgTok");
    paramToServiceMsg.putWupBuffer((byte[])localObject);
    this.a.sendSsoMsg(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public void a()
  {
    if (this.n.size() > 0)
    {
      Iterator localIterator = this.n.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (a)this.n.get(localObject);
        if ((localObject != null) && (localObject != null) && (((a)localObject).n()) && (((a)localObject).y().equals("QQ"))) {
          try
          {
            this.a.getWtLoginCenter().a((a)localObject, false);
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("load ");
            localStringBuilder.append(MD5.toMD5(((a)localObject).d()));
            localStringBuilder.append(" set key to wt error ");
            localStringBuilder.append(localThrowable);
            QLog.d("MSF.C.AccountCenter", 1, localStringBuilder.toString(), localThrowable);
          }
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    this.h = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set time interv is ");
    localStringBuilder.append(paramInt);
    QLog.d("MSF.C.AccountCenter", 1, localStringBuilder.toString());
  }
  
  void a(a parama)
  {
    this.n.put(parama.d(), parama);
  }
  
  public void a(String paramString, long paramLong)
  {
    a locala = l(paramString);
    if (locala == null) {
      return;
    }
    locala.e(paramLong);
    m(paramString);
  }
  
  void a(String paramString, com.tencent.msf.service.protocol.security.k paramk)
  {
    b(paramString, paramk.d);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    paramString2 = l(paramString1);
    if (paramString2 == null) {
      return;
    }
    paramString2.c(paramLong);
    m(paramString1);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    a locala = l(paramString);
    if (locala == null) {
      return;
    }
    if (!Arrays.equals(locala.a(), paramArrayOfByte))
    {
      locala.a(paramArrayOfByte);
      m(paramString);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    a locala = l(paramString);
    if (locala == null) {
      return;
    }
    if (!Arrays.equals(locala.b(), paramArrayOfByte))
    {
      locala.b(paramArrayOfByte);
      locala.d(paramLong);
      m(paramString);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong)
  {
    a locala = l(paramString);
    if (locala == null) {
      return;
    }
    locala.e(paramArrayOfByte1);
    locala.h(paramArrayOfByte2);
    locala.j(paramArrayOfByte3);
    locala.b(paramLong);
    m(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    a((ArrayList)localObject);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      d((a)((Iterator)localObject).next());
    }
    if (paramBoolean) {
      j();
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = new ArrayList();
    b((ArrayList)localObject);
    localObject = ((ArrayList)localObject).iterator();
    boolean bool2;
    for (boolean bool1 = false; ((Iterator)localObject).hasNext(); bool1 = bool2)
    {
      a locala = (a)((Iterator)localObject).next();
      bool2 = bool1;
      if (locala.d().equals(paramString))
      {
        bool2 = bool1;
        if (locala.n()) {
          bool2 = true;
        }
      }
      d(locala);
    }
    return bool1;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeUser uin=");
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramString1));
    QLog.d("MSF.C.AccountCenter", 1, localStringBuilder.toString());
    d(paramString1, paramString2);
    this.a.sender.a(paramString1);
    paramString2 = new StringBuilder();
    paramString2.append("del user ");
    paramString2.append(MsfSdkUtils.getShortUin(paramString1));
    paramString2.append(" succ.");
    QLog.d("MSF.C.AccountCenter", 1, paramString2.toString());
    return true;
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    VerifyCodeInfo localVerifyCodeInfo = VerifyCodeInfo.getVerifyCodeInfo(paramToServiceMsg);
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), localVerifyCodeInfo));
    return this.a.sendSsoMsg(paramToServiceMsg);
  }
  
  public int b(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    f localf = new f();
    localf.a = l(paramToServiceMsg.getUin()).g();
    localf.b = "00".getBytes();
    localHashMap.put("RequestReFetchSid", localf);
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 6, localHashMap));
    this.a.sendSsoMsg(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public String b()
  {
    Object localObject2 = d();
    Object localObject1 = new StringBuffer();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localSimpleAccount.toStoreString());
      localStringBuilder.append(";");
      ((StringBuffer)localObject1).append(localStringBuilder.toString());
    }
    localObject2 = ((StringBuffer)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith(";")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    return localObject1;
  }
  
  void b(a parama)
  {
    long l1 = System.currentTimeMillis();
    parama.a(true);
    parama.a(l1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    ((StringBuilder)localObject).append(" storeAccount setKey ");
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(parama.d()));
    QLog.d("MSF.C.AccountCenter", 1, ((StringBuilder)localObject).toString());
    localObject = parama.d();
    byte[] arrayOfByte1 = parama.f();
    byte[] arrayOfByte2 = parama.g();
    byte[] arrayOfByte3 = parama.h();
    byte[] arrayOfByte4 = parama.i();
    byte[] arrayOfByte5 = parama.j();
    byte[] arrayOfByte6 = parama.k();
    CodecWarpper.nativeSetAccountKey((String)localObject, new byte[0], arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, new byte[0], null);
    CodecWarpper.nativeSetUseSimpleHead(parama.d(), false);
    a(parama);
    m(parama.d());
    ac.a(parama.d(), false);
  }
  
  public void b(String paramString)
  {
    try
    {
      if (!this.b.containsKey(paramString))
      {
        a locala = new a(paramString);
        this.b.put(paramString, locala);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  void b(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      this.m.put(paramString2, paramString1);
      Object localObject = MsfStore.getNativeConfigStore();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("__loginSdk_uinMapping_");
      localStringBuilder.append(paramString2);
      ((NativeConfigStore)localObject).n_setConfig(localStringBuilder.toString(), paramString1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveUinMapping src:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" real:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("MSF.C.AccountCenter", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void b(String paramString, byte[] paramArrayOfByte)
  {
    a locala = l(paramString);
    if (locala == null) {
      return;
    }
    if (!Arrays.equals(locala.c(), paramArrayOfByte))
    {
      locala.c(paramArrayOfByte);
      m(paramString);
    }
  }
  
  public int c(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = (String)paramToServiceMsg.getAttribute("to_login_changeuin");
    Object localObject2 = paramToServiceMsg.getUin();
    paramToServiceMsg.setUin((String)localObject1);
    paramToServiceMsg.addAttribute("to_login_changeuin", localObject2);
    localObject1 = new HashMap();
    localObject2 = new e();
    ((e)localObject2).b = 0;
    ((e)localObject2).a = 1;
    ((e)localObject2).c = new byte[0];
    ((HashMap)localObject1).put("RequestNameExchangeUin", localObject2);
    localObject1 = this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 13, (HashMap)localObject1);
    paramToServiceMsg.setServiceCmd("login.chguin");
    paramToServiceMsg.putWupBuffer((byte[])localObject1);
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    this.a.sendSsoMsg(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public long c(String paramString)
  {
    paramString = l(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.z();
  }
  
  a c(a parama)
  {
    a locala = l(parama.d());
    if (locala == null)
    {
      b(parama);
      return parama;
    }
    if ((parama.f() != null) && (parama.f().length > 0)) {
      locala.e(parama.f());
    }
    if ((parama.i() != null) && (parama.i().length > 0)) {
      locala.h(parama.i());
    }
    if ((parama.k() != null) && (parama.k().length > 0)) {
      locala.j(parama.k());
    }
    if ((parama.a() != null) && (parama.a().length > 0)) {
      locala.a(parama.a());
    }
    if ((parama.b() != null) && (parama.b().length > 0)) {
      locala.b(parama.b());
    }
    if ((parama.c() != null) && (parama.c().length > 0)) {
      locala.c(parama.c());
    }
    if ((parama.y() != null) && (parama.y().length() > 0)) {
      locala.c(parama.y());
    }
    b(locala);
    return locala;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.n.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((String)localIterator.next());
    }
    return localArrayList;
  }
  
  public void c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!this.o.equals(paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMainAccount from=");
      localStringBuilder.append(MsfSdkUtils.getShortUin(this.o));
      localStringBuilder.append(" to=");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString1));
      localStringBuilder.append(" src: ");
      localStringBuilder.append(paramString2);
      QLog.d("MSF.C.AccountCenter", 1, localStringBuilder.toString());
      this.o = paramString1;
      if (!"0".equals(paramString1)) {
        this.g.a(paramString1);
      }
      MsfStore.getNativeConfigStore().setConfig(this.p, this.o);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("setMainAccount: failed ");
      paramString2.append(MsfSdkUtils.getShortUin(paramString1));
      QLog.d("mqq", 2, paramString2.toString());
    }
  }
  
  public long d(String paramString)
  {
    paramString = l(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.A();
  }
  
  public ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.n.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.n.get(localObject);
      if (localObject != null) {
        localArrayList.add(((a)localObject).o());
      }
    }
    return localArrayList;
  }
  
  int e()
  {
    return this.h;
  }
  
  public long e(String paramString)
  {
    paramString = l(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.B();
  }
  
  public long f(String paramString)
  {
    paramString = l(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.C();
  }
  
  public byte[] f()
  {
    return util.get_ksid(BaseApplication.getContext());
  }
  
  public ConcurrentHashMap g()
  {
    return this.n;
  }
  
  public boolean g(String paramString)
  {
    paramString = l(paramString);
    return (paramString != null) && (paramString.n());
  }
  
  public String h()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.n.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UIN=");
      localStringBuilder.append(locala.d());
      localStringBuilder.append(",LOGINED=");
      localStringBuilder.append(locala.n());
      localStringBuilder.append(",A2=");
      localStringBuilder.append(HexUtil.bytes2HexStr(locala.f()));
      localStringBuilder.append(",D2=");
      localStringBuilder.append(HexUtil.bytes2HexStr(locala.i()));
      localStringBuilder.append(",KEY=");
      localStringBuilder.append(HexUtil.bytes2HexStr(locala.k()));
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append(";");
    }
    return localStringBuffer.toString();
  }
  
  public String h(String paramString)
  {
    return (String)this.m.get(paramString);
  }
  
  public String i()
  {
    return this.o;
  }
  
  public String i(String paramString)
  {
    Iterator localIterator = this.m.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getValue();
      if ((str.equalsIgnoreCase(paramString)) && (j(str))) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  public boolean j(String paramString)
  {
    boolean bool = false;
    try
    {
      long l1 = Long.parseLong(paramString);
      if (l1 > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public void k(String paramString)
  {
    try
    {
      if (this.o.equals(paramString))
      {
        c("0", "setNoLogin");
        this.a.stopPCActivePolling("setNoLogin");
      }
      a locala = l(paramString);
      ac.a(paramString, false);
      if (locala != null)
      {
        locala.a(false);
        m(paramString);
        CodecWarpper.nativeRemoveAccountKey(paramString);
      }
      else
      {
        QLog.w("MSF.C.AccountCenter", 1, "setAccountNoLogin can't founded any account, may be BUG");
        CodecWarpper.nativeRemoveAccountKey(paramString);
      }
      return;
    }
    finally {}
  }
  
  a l(String paramString)
  {
    return (a)this.n.get(paramString);
  }
  
  void m(String paramString)
  {
    a locala = l(paramString);
    String str = locala.p();
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("storeAccount uin:");
      localStringBuilder.append(paramString);
      QLog.d("MSF.C.AccountCenter", 4, localStringBuilder.toString());
    }
    paramString = MsfStore.getNativeConfigStore();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_account_head_");
    localStringBuilder.append(locala.d());
    paramString.n_setConfig(localStringBuilder.toString(), str);
  }
  
  public String n(String paramString)
  {
    paramString = l(paramString);
    if (paramString != null) {
      return paramString.p();
    }
    return "";
  }
  
  public void o(String paramString)
  {
    Object localObject1 = l(paramString);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Thread.currentThread().getName());
    ((StringBuilder)localObject2).append(" reloadKeys setKey ");
    ((StringBuilder)localObject2).append(MsfSdkUtils.getShortUin(((a)localObject1).d()));
    QLog.d("MSF.C.AccountCenter", 1, ((StringBuilder)localObject2).toString());
    localObject2 = ((a)localObject1).d();
    byte[] arrayOfByte1 = ((a)localObject1).f();
    byte[] arrayOfByte2 = ((a)localObject1).g();
    byte[] arrayOfByte3 = ((a)localObject1).h();
    byte[] arrayOfByte4 = ((a)localObject1).i();
    byte[] arrayOfByte5 = ((a)localObject1).j();
    localObject1 = ((a)localObject1).k();
    CodecWarpper.nativeSetAccountKey((String)localObject2, new byte[0], arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, (byte[])localObject1, new byte[0], null);
    ac.a(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.b
 * JD-Core Version:    0.7.0.1
 */