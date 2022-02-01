package com.tencent.qapmsdk.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Debug.MemoryInfo;
import android.util.SparseArray;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AppInfo$Companion;", "", "()V", "TAG", "", "pid", "", "getPid", "()I", "pid$delegate", "Lkotlin/Lazy;", "processMap", "Landroid/util/SparseArray;", "getAppVersion", "context", "Landroid/content/Context;", "getPssMemory", "", "app", "Landroid/app/Application;", "pId", "hasPermissions", "", "ctx", "permissionList", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "isApkInDebug", "obtainProcessName", "obtainProcessNameByCmdline", "obtainProcessNameBySysService", "obtainProcessPackageName", "common_release"}, k=1, mv={1, 1, 15})
public final class AppInfo$Companion
{
  private final String obtainProcessNameByCmdline(int paramInt)
  {
    Object localObject = FileUtil.Companion.readOutputFromFile("/proc/" + paramInt + "/cmdline");
    if (((CharSequence)StringUtil.Companion.replaceBlank((String)localObject)).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    localObject = StringUtil.Companion.replaceBlank((String)localObject).subSequence(0, StringsKt.getLastIndex((CharSequence)localObject));
    Appendable localAppendable = (Appendable)new StringBuilder();
    int k = ((CharSequence)localObject).length();
    i = 0;
    if (i < k)
    {
      char c = ((CharSequence)localObject).charAt(i);
      if (c > 0) {}
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localAppendable.append(c);
        }
        i += 1;
        break;
      }
    }
    localObject = (CharSequence)localAppendable;
    AppInfo.access$getProcessMap$cp().put(paramInt, localObject.toString());
    return localObject.toString();
  }
  
  private final String obtainProcessNameBySysService(int paramInt, Context paramContext)
  {
    Object localObject2 = null;
    if (paramContext != null)
    {
      String str = (String)null;
      Object localObject1 = paramContext.getSystemService("activity");
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ActivityManager)) {
        paramContext = null;
      }
      paramContext = (ActivityManager)paramContext;
      if (paramContext != null)
      {
        localObject1 = paramContext.getRunningAppProcesses();
        paramContext = str;
        if (localObject1 != null) {
          localObject1 = ((Iterable)localObject1).iterator();
        }
      }
      label143:
      label146:
      for (;;)
      {
        paramContext = localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          paramContext = ((Iterator)localObject1).next();
          if (((ActivityManager.RunningAppProcessInfo)paramContext).pid != paramInt) {
            break label143;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          localObject1 = (ActivityManager.RunningAppProcessInfo)paramContext;
          paramContext = str;
          if (localObject1 != null)
          {
            paramContext = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
            AppInfo.access$getProcessMap$cp().put(paramInt, paramContext);
          }
          return paramContext;
          localObject1 = null;
          break;
        }
      }
    }
    return null;
  }
  
  @NotNull
  public final String getAppVersion(@Nullable Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
        if (paramContext != null) {
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Logger.INSTANCE.exception("QAPM_common_AppInfo", (Throwable)paramContext);
          paramContext = "";
        }
      }
    }
    return "";
  }
  
  public final int getPid()
  {
    Lazy localLazy = AppInfo.access$getPid$cp();
    Object localObject = AppInfo.Companion;
    localObject = $$delegatedProperties[0];
    return ((Number)localLazy.getValue()).intValue();
  }
  
  @JvmStatic
  public final long getPssMemory(@Nullable Application paramApplication, int paramInt)
  {
    Object localObject = null;
    if (paramApplication != null) {}
    try
    {
      paramApplication = paramApplication.getApplicationContext();
      if (paramApplication == null) {
        break label94;
      }
      paramApplication = paramApplication.getSystemService("activity");
      if ((paramApplication instanceof ActivityManager)) {
        break label127;
      }
      paramApplication = localObject;
    }
    catch (Exception paramApplication)
    {
      for (;;)
      {
        label94:
        label109:
        Logger.INSTANCE.exception("QAPM_common_AppInfo", (Throwable)paramApplication);
        continue;
        continue;
        if (paramInt == 0) {
          paramInt = 1;
        }
      }
    }
    paramApplication = (ActivityManager)paramApplication;
    if (paramApplication != null)
    {
      paramApplication = paramApplication.getProcessMemoryInfo(new int[] { paramInt });
      if (paramApplication != null)
      {
        if (paramApplication.length == 0)
        {
          paramInt = 1;
          break label130;
        }
        for (;;)
        {
          if (paramInt == 0) {
            break label109;
          }
          paramApplication = paramApplication[0];
          Intrinsics.checkExpressionValueIsNotNull(paramApplication, "myMemoryInfo[0]");
          paramInt = paramApplication.getTotalPss();
          return paramInt * 1024;
          paramApplication = null;
          break;
          paramInt = 0;
          break label130;
          paramInt = 0;
        }
      }
    }
    return 0L;
  }
  
  /* Error */
  @JvmStatic
  public final boolean hasPermissions(@Nullable Context paramContext, @NotNull String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 7
    //   9: aload_2
    //   10: ldc_w 277
    //   13: invokestatic 280	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_1
    //   17: ifnull +91 -> 108
    //   20: aload_1
    //   21: invokevirtual 281	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: astore 9
    //   26: aload 9
    //   28: ldc_w 283
    //   31: invokestatic 270	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   34: aload 9
    //   36: invokevirtual 203	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   39: astore_1
    //   40: iload 8
    //   42: istore 6
    //   44: aload_1
    //   45: ifnull +63 -> 108
    //   48: aload 9
    //   50: invokevirtual 206	android/content/Context:getPackageName	()Ljava/lang/String;
    //   53: astore 9
    //   55: ldc 143
    //   57: monitorenter
    //   58: aload_2
    //   59: arraylength
    //   60: istore 5
    //   62: iconst_0
    //   63: istore 4
    //   65: iload 4
    //   67: iload 5
    //   69: if_icmpge +73 -> 142
    //   72: aload_2
    //   73: iload 4
    //   75: aaload
    //   76: astore 10
    //   78: aload_1
    //   79: aload 10
    //   81: aload 9
    //   83: invokevirtual 287	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: istore_3
    //   87: iload_3
    //   88: ifne +23 -> 111
    //   91: iconst_1
    //   92: istore_3
    //   93: iload_3
    //   94: ifne +39 -> 133
    //   97: iload 7
    //   99: istore 6
    //   101: getstatic 292	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   104: astore_1
    //   105: ldc 143
    //   107: monitorexit
    //   108: iload 6
    //   110: ireturn
    //   111: iconst_0
    //   112: istore_3
    //   113: goto -20 -> 93
    //   116: astore 10
    //   118: getstatic 223	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   121: ldc 225
    //   123: aload 10
    //   125: invokevirtual 231	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -37 -> 93
    //   133: iload 4
    //   135: iconst_1
    //   136: iadd
    //   137: istore 4
    //   139: goto -74 -> 65
    //   142: iconst_1
    //   143: istore 6
    //   145: goto -44 -> 101
    //   148: astore_1
    //   149: ldc 143
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	Companion
    //   0	154	1	paramContext	Context
    //   0	154	2	paramArrayOfString	String[]
    //   86	44	3	i	int
    //   63	75	4	j	int
    //   60	10	5	k	int
    //   4	140	6	bool1	boolean
    //   7	91	7	bool2	boolean
    //   1	40	8	bool3	boolean
    //   24	58	9	localObject	Object
    //   76	4	10	str	String
    //   116	8	10	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   78	87	116	java/lang/Throwable
    //   58	62	148	finally
    //   78	87	148	finally
    //   101	105	148	finally
    //   118	128	148	finally
  }
  
  @JvmStatic
  public final boolean isApkInDebug(@NotNull Context paramContext)
  {
    boolean bool = false;
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      if ((i & 0x2) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      Logger.INSTANCE.exception("QAPM_common_AppInfo", paramContext);
    }
    return false;
  }
  
  @JvmStatic
  @NotNull
  public final String obtainProcessName(@Nullable Context paramContext)
  {
    String str = (String)AppInfo.access$getProcessMap$cp().get(((Companion)this).getPid());
    if (str != null) {
      if (str == null) {
        break label49;
      }
    }
    for (;;)
    {
      if (str == null) {
        break label68;
      }
      return str;
      str = ((Companion)this).obtainProcessNameByCmdline(((Companion)this).getPid());
      break;
      label49:
      str = ((Companion)this).obtainProcessNameBySysService(((Companion)this).getPid(), paramContext);
    }
    label68:
    return "";
  }
  
  @JvmStatic
  @NotNull
  public final String obtainProcessPackageName(@Nullable Context paramContext)
  {
    return (String)StringsKt.split$default((CharSequence)StringsKt.split$default((CharSequence)((Companion)this).obtainProcessName(paramContext), new String[] { "&" }, false, 0, 6, null).get(0), new String[] { ":" }, false, 0, 6, null).get(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AppInfo.Companion
 * JD-Core Version:    0.7.0.1
 */