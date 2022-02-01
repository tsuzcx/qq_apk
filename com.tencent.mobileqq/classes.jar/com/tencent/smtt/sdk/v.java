package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.m;
import java.util.Map;

class v
{
  private Context a = null;
  private Context b = null;
  private String c = null;
  private String[] d = null;
  private DexLoader e = null;
  private String f = "TbsDexOpt";
  private String g = null;
  
  public v(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, o paramo)
  {
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 != null) && ((paramContext2 != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) && (!TextUtils.isEmpty(paramString1)) && (paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      this.a = paramContext1.getApplicationContext();
      if (paramContext2.getApplicationContext() != null) {
        this.b = paramContext2.getApplicationContext();
      } else {
        this.b = paramContext2;
      }
      this.c = paramString1;
      this.d = paramArrayOfString;
      this.f = paramString2;
      if (paramo != null) {
        paramo.a("load_tbs_dex", (byte)1);
      }
      i = 0;
      while (i < this.d.length)
      {
        paramString1 = new StringBuilder();
        paramString1.append("#2 mDexFileList[");
        paramString1.append(i);
        paramString1.append("]: ");
        paramString1.append(this.d[i]);
        TbsLog.i("TbsWizard", paramString1.toString());
        i += 1;
      }
      paramString1 = new StringBuilder();
      paramString1.append("new DexLoader #2 libraryPath is ");
      paramString1.append(paramString3);
      paramString1.append(" mCallerAppContext is ");
      paramString1.append(this.a);
      paramString1.append(" dexOutPutDir is ");
      paramString1.append(paramString2);
      TbsLog.i("TbsWizard", paramString1.toString());
      this.e = new DexLoader(paramString3, this.a, this.d, paramString2, QbSdk.n);
      System.currentTimeMillis();
      a(paramContext1);
      if (paramo != null) {
        paramo.a("load_tbs_dex", (byte)2);
      }
      libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
      if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName))
      {
        paramContext2 = this.e;
        paramString1 = this.a;
        paramContext2.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[] { Context.class }, new Object[] { paramString1 });
      }
      if (QbSdk.n == null) {}
    }
    try
    {
      bool1 = TbsPVConfig.getInstance(this.a).getTbsCoreSandboxModeEnable();
    }
    catch (Throwable paramContext2)
    {
      boolean bool1;
      label404:
      boolean bool2;
      break label404;
    }
    bool1 = false;
    try
    {
      bool2 = "true".equals(String.valueOf(QbSdk.n.get("use_sandbox")));
    }
    catch (Throwable paramContext2)
    {
      paramContext2.printStackTrace();
      bool2 = false;
    }
    paramContext2 = QbSdk.n;
    if ((bool1) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramContext2.put("use_sandbox", Boolean.valueOf(bool1));
    paramContext2 = this.e;
    paramString1 = QbSdk.n;
    paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    if (paramo != null) {
      paramo.a("init_tbs", (byte)1);
    }
    int i = b(paramContext1);
    if (paramo != null) {
      paramo.a("init_tbs", (byte)2);
    }
    if (i >= 0)
    {
      TbsLog.i("TbsWizard", "construction end...");
      return;
    }
    paramContext1 = new StringBuilder();
    paramContext1.append("TbsWizard init error: ");
    paramContext1.append(i);
    paramContext1.append("; msg: ");
    paramContext1.append(this.g);
    throw new Exception(paramContext1.toString());
    paramString2 = new StringBuilder();
    paramString2.append("TbsWizard paramter error:-1callerContext:");
    paramString2.append(paramContext1);
    paramString2.append("hostcontext");
    paramString2.append(paramContext2);
    paramString2.append("isEmpty");
    paramString2.append(TextUtils.isEmpty(paramString1));
    paramString2.append("dexfileList");
    paramString2.append(paramArrayOfString);
    paramContext1 = new Exception(paramString2.toString());
    for (;;)
    {
      throw paramContext1;
    }
  }
  
  private int b(Context paramContext)
  {
    Object localObject1 = this.e;
    Object localObject2 = b.a;
    Object localObject3 = b.b;
    Object localObject4 = b.c;
    Object localObject5 = b.d;
    ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[] { Context.class, String.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, localObject5 });
    localObject2 = this.b;
    localObject1 = Integer.valueOf(44069);
    String str1;
    String str2;
    String str3;
    if ((localObject2 == null) && (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      localObject2 = this.e;
      localObject3 = Integer.TYPE;
      localObject4 = this.b;
      localObject5 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      String str4 = TbsShareManager.getHostCorePathAppDefined();
      localObject1 = ((DexLoader)localObject2).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject3, String.class, String.class }, new Object[] { paramContext, localObject4, localObject5, str1, str2, "4.3.0.169", localObject1, str3, str4 });
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initTesRuntimeEnvironment callerContext is ");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" mHostContext is ");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" mDexLoader is ");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(" mtbsInstallLocation is ");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" mDexOptPath is ");
      ((StringBuilder)localObject2).append(this.f);
      TbsLog.i("TbsWizard", ((StringBuilder)localObject2).toString());
      localObject2 = this.e;
      localObject3 = Integer.TYPE;
      localObject4 = this.b;
      localObject5 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      localObject1 = ((DexLoader)localObject2).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject3, String.class }, new Object[] { paramContext, localObject4, localObject5, str1, str2, "4.3.0.169", localObject1, str3 });
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      c();
      d();
      localObject1 = this.e;
      localObject2 = this.b;
      localObject3 = this.c;
      localObject4 = this.f;
      localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject1, localObject3, localObject4 });
    }
    int i;
    if (localObject2 == null)
    {
      i = -3;
    }
    else if ((localObject2 instanceof Integer))
    {
      i = ((Integer)localObject2).intValue();
    }
    else if ((localObject2 instanceof Throwable))
    {
      TbsCoreLoadStat.getInstance().a(this.a, 328, (Throwable)localObject2);
      i = -5;
    }
    else
    {
      i = -4;
    }
    if (i < 0)
    {
      paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext instanceof Throwable))
      {
        localObject1 = (Throwable)paramContext;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("#");
        ((StringBuilder)localObject2).append(((Throwable)localObject1).getMessage());
        ((StringBuilder)localObject2).append("; cause: ");
        ((StringBuilder)localObject2).append(((Throwable)localObject1).getCause());
        ((StringBuilder)localObject2).append("; th: ");
        ((StringBuilder)localObject2).append(localObject1);
        this.g = ((StringBuilder)localObject2).toString();
      }
      if (!(paramContext instanceof String)) {
        return i;
      }
      paramContext = (String)paramContext;
    }
    else
    {
      paramContext = null;
    }
    this.g = paramContext;
    return i;
  }
  
  private void c()
  {
    this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "4.3.0.169" });
  }
  
  private void d()
  {
    this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(44069));
  }
  
  public String a()
  {
    Object localObject1 = this.e;
    Object localObject2 = Boolean.TYPE;
    String str = null;
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { localObject2, String.class, String.class, [Ljava.lang.Class.class, [Ljava.lang.Object.class }, new Object[] { Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0] });
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    }
    if (localObject1 != null) {
      str = String.valueOf(localObject1);
    }
    localObject1 = str;
    if (str == null) {
      localObject1 = "X5 core get nothing...";
    }
    return localObject1;
  }
  
  void a(Context paramContext)
  {
    Object localObject = QbSdk.n;
    if (localObject != null)
    {
      localObject = ((Map)localObject).get("check_tbs_validity");
      if ((localObject instanceof Boolean))
      {
        bool = ((Boolean)localObject).booleanValue();
        break label38;
      }
    }
    boolean bool = true;
    label38:
    if (bool) {
      m.b(paramContext);
    }
  }
  
  public void a(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, o paramo)
  {
    this.a = paramContext1.getApplicationContext();
    if (this.b.getApplicationContext() != null) {
      this.b = this.b.getApplicationContext();
    }
    this.c = paramString1;
    this.d = paramArrayOfString;
    this.f = paramString2;
    libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
    if (QbSdk.n != null)
    {
      paramContext2 = this.e;
      paramString1 = QbSdk.n;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    }
    int i = b(paramContext1);
    if (i >= 0) {
      return;
    }
    paramContext1 = new StringBuilder();
    paramContext1.append("continueInit init error: ");
    paramContext1.append(i);
    paramContext1.append("; msg: ");
    paramContext1.append(this.g);
    throw new Exception(paramContext1.toString());
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public DexLoader b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.v
 * JD-Core Version:    0.7.0.1
 */