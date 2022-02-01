package de.robv.android.xposed;

import android.app.AndroidAppHelper;
import android.content.Context;
import android.os.Build.VERSION;
import com.taobao.android.dexposed.XC_MethodHook;
import com.taobao.android.dexposed.XC_MethodHook.Unhook;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.Runtime;
import com.tencent.qa.apphook.GalileoHookManager;
import com.tencent.qa.apphook.util.emulator.DetectAndroidEmulator;
import com.tencent.yahfa.apphook.YahfaHookManager;
import de.robv.android.xposed.callbacks.IXUnhook;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.method.ArtMethod;
import me.weishu.reflection.Reflection;

public class DexposedBridge
{
  public static final ClassLoader BOOT_CLASSLOADER = ;
  private static final Object[] EMPTY_ARRAY = new Object[0];
  private static final String TAG = "DexposedBridge";
  private static final ArrayList<IXUnhook> allUnhookCallbacks = new ArrayList();
  private static final Map<Member, DexposedBridge.CopyOnWriteSortedSet<XC_MethodHook>> hookedMethodCallbacks = new HashMap();
  private static boolean mIsAndroidEmulator = false;
  private static boolean mIsEpic = false;
  
  static
  {
    try
    {
      if (Build.VERSION.SDK_INT > 19) {
        System.loadLibrary("epic");
      }
      for (;;)
      {
        Reflection.unseal(AndroidAppHelper.currentApplication());
        return;
        if (Build.VERSION.SDK_INT <= 14) {
          break;
        }
        System.loadLibrary("dexposed");
      }
      throw new RuntimeException("unsupported api level: " + Build.VERSION.SDK_INT);
    }
    catch (Throwable localThrowable)
    {
      Logger.log("DexposedBridge", localThrowable);
      return;
    }
  }
  
  private static boolean checkMember(Member paramMember)
  {
    if ((paramMember instanceof Method)) {}
    while ((paramMember instanceof Constructor)) {
      return true;
    }
    if (paramMember.getDeclaringClass().isInterface())
    {
      Logger.e("DexposedBridge", "Cannot hook interfaces: " + paramMember.toString());
      return false;
    }
    if (Modifier.isAbstract(paramMember.getModifiers()))
    {
      Logger.e("DexposedBridge", "Cannot hook abstract methods: " + paramMember.toString());
      return false;
    }
    Logger.e("DexposedBridge", "Only methods and constructors can be hooked: " + paramMember.toString());
    return false;
  }
  
  public static XC_MethodHook.Unhook findAndHookMethod(Class<?> arg0, String paramString, Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if ((i == 0) || (!(paramVarArgs[(i - 1)] instanceof XC_MethodHook))) {
      throw new IllegalArgumentException("no callback defined");
    }
    XC_MethodHook localXC_MethodHook = (XC_MethodHook)paramVarArgs[(paramVarArgs.length - 1)];
    Method localMethod = XposedHelpers.findMethodExact(???, paramString, paramVarArgs);
    if (!checkMember(localMethod)) {
      return null;
    }
    if (mIsEpic)
    {
      if (Build.VERSION.SDK_INT > 19)
      {
        paramString = hookMethod(localMethod, localXC_MethodHook);
        synchronized (allUnhookCallbacks)
        {
          allUnhookCallbacks.add(paramString);
          return paramString;
        }
      }
      if (Build.VERSION.SDK_INT >= 28)
      {
        if ((Modifier.isPrivate(localMethod.getModifiers())) && (Modifier.isStatic(localMethod.getModifiers())))
        {
          Logger.e("DexposedBridge", "Android 9.0 Version and private and static method use GalileoHookManager");
          return GalileoHookManager.findAndHookMethod(???, paramString, paramVarArgs);
        }
        return YahfaHookManager.findAndHookMethod(???, paramString, paramVarArgs);
      }
    }
    else
    {
      if ((mIsAndroidEmulator) && (Modifier.isPrivate(localMethod.getModifiers())) && (!Modifier.isStatic(localMethod.getModifiers())))
      {
        Logger.e("DexposedBridge", "AndroidEmulator private not static method use YahfaHookManager");
        return YahfaHookManager.findAndHookMethod(???, paramString, paramVarArgs);
      }
      if ((Build.VERSION.SDK_INT > 19) && (Build.VERSION.SDK_INT < 27))
      {
        Logger.e("DexposedBridge", "use GalileoHookManager");
        return GalileoHookManager.findAndHookMethod(???, paramString, paramVarArgs);
      }
      if (Build.VERSION.SDK_INT >= 27)
      {
        if ((Modifier.isPublic(localMethod.getModifiers())) || (Modifier.isProtected(localMethod.getModifiers()))) {
          return YahfaHookManager.findAndHookMethod(???, paramString, paramVarArgs);
        }
        if (Modifier.isPrivate(localMethod.getModifiers())) {
          return GalileoHookManager.findAndHookMethod(???, paramString, paramVarArgs);
        }
      }
    }
    paramString = hookMethod(localMethod, localXC_MethodHook);
    synchronized (allUnhookCallbacks)
    {
      allUnhookCallbacks.add(paramString);
      return paramString;
    }
  }
  
  /* Error */
  public static Object handleHookedArtMethod(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: ldc 12
    //   2: ldc 207
    //   4: invokestatic 210	com/taobao/android/dexposed/utility/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: checkcast 212	me/weishu/epic/art/method/ArtMethod
    //   11: astore_0
    //   12: getstatic 42	de/robv/android/xposed/DexposedBridge:hookedMethodCallbacks	Ljava/util/Map;
    //   15: astore 7
    //   17: aload 7
    //   19: monitorenter
    //   20: ldc 12
    //   22: new 89	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   29: ldc 214
    //   31: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 218	me/weishu/epic/art/method/ArtMethod:getExecutable	()Ljava/lang/Object;
    //   38: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 210	com/taobao/android/dexposed/utility/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: getstatic 42	de/robv/android/xposed/DexposedBridge:hookedMethodCallbacks	Ljava/util/Map;
    //   50: aload_0
    //   51: invokevirtual 218	me/weishu/epic/art/method/ArtMethod:getExecutable	()Ljava/lang/Object;
    //   54: invokeinterface 227 2 0
    //   59: checkcast 229	de/robv/android/xposed/DexposedBridge$CopyOnWriteSortedSet
    //   62: astore 6
    //   64: aload 7
    //   66: monitorexit
    //   67: aload 6
    //   69: ifnonnull +38 -> 107
    //   72: aload_0
    //   73: invokestatic 235	me/weishu/epic/art/Epic:getBackMethod	(Lme/weishu/epic/art/method/ArtMethod;)Lme/weishu/epic/art/method/ArtMethod;
    //   76: aload_1
    //   77: aload_2
    //   78: invokevirtual 239	me/weishu/epic/art/method/ArtMethod:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore 7
    //   83: aload 7
    //   85: areturn
    //   86: astore_0
    //   87: aload 7
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    //   92: astore 7
    //   94: ldc 12
    //   96: aload 7
    //   98: invokevirtual 243	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   101: invokestatic 249	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   104: invokestatic 134	com/taobao/android/dexposed/utility/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 6
    //   109: invokevirtual 252	de/robv/android/xposed/DexposedBridge$CopyOnWriteSortedSet:getSnapshot	()[Ljava/lang/Object;
    //   112: astore 6
    //   114: aload 6
    //   116: arraylength
    //   117: istore 5
    //   119: ldc 12
    //   121: new 89	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   128: ldc 254
    //   130: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload 5
    //   135: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 210	com/taobao/android/dexposed/utility/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: iload 5
    //   146: ifne +30 -> 176
    //   149: aload_0
    //   150: invokestatic 235	me/weishu/epic/art/Epic:getBackMethod	(Lme/weishu/epic/art/method/ArtMethod;)Lme/weishu/epic/art/method/ArtMethod;
    //   153: aload_1
    //   154: aload_2
    //   155: invokevirtual 239	me/weishu/epic/art/method/ArtMethod:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   158: astore 7
    //   160: aload 7
    //   162: areturn
    //   163: astore 7
    //   165: ldc 12
    //   167: aload 7
    //   169: invokestatic 249	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   172: invokestatic 257	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   175: pop
    //   176: ldc 12
    //   178: new 89	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 259
    //   188: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: arraylength
    //   193: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 210	com/taobao/android/dexposed/utility/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: new 261	de/robv/android/xposed/XC_MethodHook$MethodHookParam
    //   205: dup
    //   206: invokespecial 262	de/robv/android/xposed/XC_MethodHook$MethodHookParam:<init>	()V
    //   209: astore 7
    //   211: aload 7
    //   213: aload_0
    //   214: invokevirtual 218	me/weishu/epic/art/method/ArtMethod:getExecutable	()Ljava/lang/Object;
    //   217: checkcast 117	java/lang/reflect/Member
    //   220: putfield 266	de/robv/android/xposed/XC_MethodHook$MethodHookParam:method	Ljava/lang/reflect/Member;
    //   223: aload 7
    //   225: aload_1
    //   226: putfield 270	de/robv/android/xposed/XC_MethodHook$MethodHookParam:thisObject	Ljava/lang/Object;
    //   229: aload 7
    //   231: aload_2
    //   232: putfield 273	de/robv/android/xposed/XC_MethodHook$MethodHookParam:args	[Ljava/lang/Object;
    //   235: aload 7
    //   237: getfield 273	de/robv/android/xposed/XC_MethodHook$MethodHookParam:args	[Ljava/lang/Object;
    //   240: astore 8
    //   242: aload 8
    //   244: arraylength
    //   245: istore 4
    //   247: iconst_0
    //   248: istore_3
    //   249: iload_3
    //   250: iload 4
    //   252: if_icmpge +50 -> 302
    //   255: aload 8
    //   257: iload_3
    //   258: aaload
    //   259: astore 9
    //   261: aload 9
    //   263: ifnull +32 -> 295
    //   266: ldc 12
    //   268: new 89	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 275
    //   278: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 9
    //   283: invokevirtual 130	java/lang/Object:toString	()Ljava/lang/String;
    //   286: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 210	com/taobao/android/dexposed/utility/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: iload_3
    //   296: iconst_1
    //   297: iadd
    //   298: istore_3
    //   299: goto -50 -> 249
    //   302: iconst_0
    //   303: istore_3
    //   304: aload 6
    //   306: iload_3
    //   307: aaload
    //   308: checkcast 152	com/taobao/android/dexposed/XC_MethodHook
    //   311: aload 7
    //   313: invokevirtual 279	com/taobao/android/dexposed/XC_MethodHook:beforeHookedMethod	(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V
    //   316: aload 7
    //   318: getfield 282	de/robv/android/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   321: ifeq +143 -> 464
    //   324: iload_3
    //   325: iconst_1
    //   326: iadd
    //   327: istore_3
    //   328: aload 7
    //   330: getfield 282	de/robv/android/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   333: ifne +17 -> 350
    //   336: aload 7
    //   338: aload_0
    //   339: invokestatic 235	me/weishu/epic/art/Epic:getBackMethod	(Lme/weishu/epic/art/method/ArtMethod;)Lme/weishu/epic/art/method/ArtMethod;
    //   342: aload_1
    //   343: aload_2
    //   344: invokevirtual 239	me/weishu/epic/art/method/ArtMethod:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   347: invokevirtual 286	de/robv/android/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   350: iload_3
    //   351: iconst_1
    //   352: isub
    //   353: istore_3
    //   354: aload 7
    //   356: invokevirtual 289	de/robv/android/xposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
    //   359: astore_0
    //   360: aload 7
    //   362: invokevirtual 292	de/robv/android/xposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   365: astore_1
    //   366: aload 6
    //   368: iload_3
    //   369: aaload
    //   370: checkcast 152	com/taobao/android/dexposed/XC_MethodHook
    //   373: aload 7
    //   375: invokevirtual 295	com/taobao/android/dexposed/XC_MethodHook:afterHookedMethod	(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V
    //   378: iload_3
    //   379: iconst_1
    //   380: isub
    //   381: istore_3
    //   382: iload_3
    //   383: ifge +162 -> 545
    //   386: aload 7
    //   388: invokevirtual 298	de/robv/android/xposed/XC_MethodHook$MethodHookParam:hasThrowable	()Z
    //   391: ifeq +148 -> 539
    //   394: aload 7
    //   396: invokevirtual 292	de/robv/android/xposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   399: astore_0
    //   400: aload_0
    //   401: instanceof 300
    //   404: ifne +17 -> 421
    //   407: aload_0
    //   408: instanceof 302
    //   411: ifne +10 -> 421
    //   414: aload_0
    //   415: instanceof 304
    //   418: ifeq +110 -> 528
    //   421: aload_0
    //   422: invokevirtual 305	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   425: pop
    //   426: aload 7
    //   428: invokevirtual 292	de/robv/android/xposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   431: invokevirtual 305	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   434: aconst_null
    //   435: invokestatic 309	de/robv/android/xposed/DexposedBridge:throwNoCheck	(Ljava/lang/Throwable;Ljava/lang/Object;)V
    //   438: aconst_null
    //   439: areturn
    //   440: astore 8
    //   442: ldc 12
    //   444: aload 8
    //   446: invokestatic 249	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   449: invokestatic 134	com/taobao/android/dexposed/utility/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload 7
    //   454: aconst_null
    //   455: invokevirtual 286	de/robv/android/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   458: aload 7
    //   460: iconst_0
    //   461: putfield 282	de/robv/android/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   464: iload_3
    //   465: iconst_1
    //   466: iadd
    //   467: istore 4
    //   469: iload 4
    //   471: istore_3
    //   472: iload 4
    //   474: iload 5
    //   476: if_icmpge -148 -> 328
    //   479: iload 4
    //   481: istore_3
    //   482: goto -178 -> 304
    //   485: astore_0
    //   486: aload 7
    //   488: aload_0
    //   489: invokevirtual 313	de/robv/android/xposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   492: goto -142 -> 350
    //   495: astore_2
    //   496: ldc 12
    //   498: aload_2
    //   499: invokestatic 249	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   502: invokestatic 257	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   505: pop
    //   506: aload_1
    //   507: ifnonnull +12 -> 519
    //   510: aload 7
    //   512: aload_0
    //   513: invokevirtual 286	de/robv/android/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   516: goto -138 -> 378
    //   519: aload 7
    //   521: aload_1
    //   522: invokevirtual 313	de/robv/android/xposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   525: goto -147 -> 378
    //   528: ldc 12
    //   530: ldc_w 315
    //   533: aload_0
    //   534: invokestatic 318	com/taobao/android/dexposed/utility/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   537: aconst_null
    //   538: areturn
    //   539: aload 7
    //   541: invokevirtual 289	de/robv/android/xposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
    //   544: areturn
    //   545: goto -191 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	paramObject1	Object
    //   0	548	1	paramObject2	Object
    //   0	548	2	paramArrayOfObject	Object[]
    //   248	234	3	i	int
    //   245	235	4	j	int
    //   117	360	5	k	int
    //   62	305	6	localObject1	Object
    //   15	73	7	localObject2	Object
    //   92	5	7	localException1	java.lang.Exception
    //   158	3	7	localObject3	Object
    //   163	5	7	localException2	java.lang.Exception
    //   209	331	7	localMethodHookParam	XC_MethodHook.MethodHookParam
    //   240	16	8	arrayOfObject	Object[]
    //   440	5	8	localThrowable	Throwable
    //   259	23	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	67	86	finally
    //   87	90	86	finally
    //   72	83	92	java/lang/Exception
    //   149	160	163	java/lang/Exception
    //   304	316	440	java/lang/Throwable
    //   336	350	485	java/lang/Exception
    //   366	378	495	java/lang/Throwable
  }
  
  private static Object handleHookedMethod(Member paramMember, int paramInt, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    DexposedBridge.AdditionalHookInfo localAdditionalHookInfo = (DexposedBridge.AdditionalHookInfo)paramObject1;
    paramObject1 = localAdditionalHookInfo.callbacks.getSnapshot();
    int j = paramObject1.length;
    if (j == 0) {
      try
      {
        paramMember = invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, paramObject2, paramArrayOfObject);
        return paramMember;
      }
      catch (InvocationTargetException paramMember)
      {
        throw paramMember.getCause();
      }
    }
    XC_MethodHook.MethodHookParam localMethodHookParam = new XC_MethodHook.MethodHookParam();
    localMethodHookParam.method = paramMember;
    localMethodHookParam.thisObject = paramObject2;
    localMethodHookParam.args = paramArrayOfObject;
    int i = 0;
    label284:
    for (;;)
    {
      try
      {
        ((XC_MethodHook)paramObject1[i]).beforeHookedMethod(localMethodHookParam);
        if (!localMethodHookParam.returnEarly) {
          continue;
        }
        i += 1;
      }
      catch (Throwable paramMember)
      {
        try
        {
          localMethodHookParam.setResult(invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, localMethodHookParam.thisObject, localMethodHookParam.args));
          paramInt = i - 1;
          paramMember = localMethodHookParam.getResult();
          paramObject2 = localMethodHookParam.getThrowable();
        }
        catch (InvocationTargetException paramMember)
        {
          try
          {
            ((XC_MethodHook)paramObject1[paramInt]).afterHookedMethod(localMethodHookParam);
            paramInt -= 1;
            if (paramInt >= 0) {
              continue;
            }
            if (localMethodHookParam.hasThrowable())
            {
              throw localMethodHookParam.getThrowable();
              paramObject2 = paramObject2;
              Logger.log("DexposedBridge", paramObject2);
              localMethodHookParam.setResult(null);
              localMethodHookParam.returnEarly = false;
              i += 1;
              if (i < j) {
                break label284;
              }
              continue;
              paramMember = paramMember;
              localMethodHookParam.setThrowable(paramMember.getCause());
            }
          }
          catch (Throwable paramArrayOfObject)
          {
            Logger.log("DexposedBridge", paramArrayOfObject);
            if (paramObject2 == null)
            {
              localMethodHookParam.setResult(paramMember);
              continue;
            }
            localMethodHookParam.setThrowable(paramObject2);
            continue;
          }
        }
        return localMethodHookParam.getResult();
        continue;
      }
      if (localMethodHookParam.returnEarly) {}
    }
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> paramClass, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredConstructors();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(hookMethod(paramClass[i], paramXC_MethodHook));
      i += 1;
    }
    return localHashSet;
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> paramClass, String paramString, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Member localMember = paramClass[i];
      if (localMember.getName().equals(paramString)) {
        localHashSet.add(hookMethod(localMember, paramXC_MethodHook));
      }
      i += 1;
    }
    return localHashSet;
  }
  
  public static XC_MethodHook.Unhook hookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    if ((!(paramMember instanceof Method)) && (!(paramMember instanceof Constructor))) {
      throw new IllegalArgumentException("only methods and constructors can be hooked");
    }
    for (;;)
    {
      DexposedBridge.CopyOnWriteSortedSet localCopyOnWriteSortedSet;
      synchronized (hookedMethodCallbacks)
      {
        localCopyOnWriteSortedSet = (DexposedBridge.CopyOnWriteSortedSet)hookedMethodCallbacks.get(paramMember);
        if (localCopyOnWriteSortedSet != null) {
          break label311;
        }
        localCopyOnWriteSortedSet = new DexposedBridge.CopyOnWriteSortedSet();
        hookedMethodCallbacks.put(paramMember, localCopyOnWriteSortedSet);
        bool = true;
        Logger.w("DexposedBridge", "hook: " + paramMember + ", newMethod ? " + bool);
        localCopyOnWriteSortedSet.add(paramXC_MethodHook);
        if (bool)
        {
          if (!Runtime.isArt()) {
            break label223;
          }
          if ((paramMember instanceof Method)) {
            Logger.w("DexposedBridge", "hook result:" + Epic.hookMethod((Method)paramMember));
          }
        }
        else
        {
          paramXC_MethodHook.getClass();
          return new XC_MethodHook.Unhook(paramXC_MethodHook, paramMember);
        }
      }
      Logger.w("DexposedBridge", "hook result:" + Epic.hookMethod((Constructor)paramMember));
      continue;
      label223:
      Logger.w("DexposedBridge", "hook: not ART");
      Class localClass = paramMember.getDeclaringClass();
      int i = XposedHelpers.getIntField(paramMember, "slot");
      Class[] arrayOfClass;
      if ((paramMember instanceof Method)) {
        arrayOfClass = ((Method)paramMember).getParameterTypes();
      }
      for (??? = ((Method)paramMember).getReturnType();; ??? = null)
      {
        hookMethodNative(paramMember, localClass, i, new DexposedBridge.AdditionalHookInfo(localCopyOnWriteSortedSet, arrayOfClass, (Class)???, null));
        break;
        arrayOfClass = ((Constructor)paramMember).getParameterTypes();
      }
      label311:
      boolean bool = false;
    }
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  public static void init(Context paramContext)
  {
    init(paramContext, false);
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    mIsEpic = paramBoolean;
    if (Build.VERSION.SDK_INT > 19)
    {
      GalileoHookManager.initAndroidHook(paramContext);
      YahfaHookManager.init(paramContext);
    }
    mIsAndroidEmulator = DetectAndroidEmulator.isAndroidEmulator();
    Logger.d("DexposedBridge", "isEmulator is " + mIsAndroidEmulator + ",mIsEpic is " + mIsEpic);
  }
  
  public static Object invokeOriginalMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      paramArrayOfObject = EMPTY_ARRAY;
    }
    for (;;)
    {
      Class[] arrayOfClass;
      Class localClass;
      if ((paramMember instanceof Method))
      {
        arrayOfClass = ((Method)paramMember).getParameterTypes();
        localClass = ((Method)paramMember).getReturnType();
        if (!Runtime.isArt()) {
          break label121;
        }
        if (!(paramMember instanceof Method)) {
          break label101;
        }
      }
      for (Object localObject = ArtMethod.of((Method)paramMember);; localObject = ArtMethod.of((Constructor)paramMember))
      {
        try
        {
          localObject = Epic.getBackMethod((ArtMethod)localObject).invoke(paramObject, paramArrayOfObject);
          return localObject;
        }
        catch (InstantiationException localInstantiationException)
        {
          label101:
          throwNoCheck(localInstantiationException, null);
        }
        if ((paramMember instanceof Constructor))
        {
          arrayOfClass = ((Constructor)paramMember).getParameterTypes();
          localClass = null;
          break;
        }
        throw new IllegalArgumentException("method must be of type Method or Constructor");
      }
      label121:
      return invokeOriginalMethodNative(paramMember, 0, arrayOfClass, localClass, paramObject, paramArrayOfObject);
    }
  }
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject);
  
  public static Object invokeSuper(Object paramObject, Member paramMember, Object... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!Runtime.isArt()) {
        i = XposedHelpers.getIntField(XposedHelpers.findMethodExact(paramObject.getClass().getSuperclass(), paramMember.getName(), ((Method)paramMember).getParameterTypes()), "slot");
      }
      paramObject = invokeSuperNative(paramObject, paramVarArgs, paramMember, paramMember.getDeclaringClass(), ((Method)paramMember).getParameterTypes(), ((Method)paramMember).getReturnType(), i);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new IllegalAccessError(paramObject.getMessage());
    }
    catch (IllegalArgumentException paramObject)
    {
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new XposedHelpers.InvocationTargetError(paramObject.getCause());
    }
  }
  
  private static native Object invokeSuperNative(Object paramObject, Object[] paramArrayOfObject, Member paramMember, Class<?> paramClass1, Class<?>[] paramArrayOfClass, Class<?> paramClass2, int paramInt);
  
  private static <T extends Throwable> void throwNoCheck(Throwable paramThrowable, Object paramObject)
  {
    throw paramThrowable;
  }
  
  /* Error */
  public static void unhookAllMethods()
  {
    // Byte code:
    //   0: getstatic 47	de/robv/android/xposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_0
    //   8: iload_0
    //   9: getstatic 47	de/robv/android/xposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   12: invokevirtual 489	java/util/ArrayList:size	()I
    //   15: if_icmpge +25 -> 40
    //   18: getstatic 47	de/robv/android/xposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   21: iload_0
    //   22: invokevirtual 492	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   25: checkcast 494	de/robv/android/xposed/callbacks/IXUnhook
    //   28: invokeinterface 497 1 0
    //   33: iload_0
    //   34: iconst_1
    //   35: iadd
    //   36: istore_0
    //   37: goto -29 -> 8
    //   40: getstatic 47	de/robv/android/xposed/DexposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   43: invokevirtual 500	java/util/ArrayList:clear	()V
    //   46: aload_1
    //   47: monitorexit
    //   48: getstatic 42	de/robv/android/xposed/DexposedBridge:hookedMethodCallbacks	Ljava/util/Map;
    //   51: astore_1
    //   52: aload_1
    //   53: monitorenter
    //   54: getstatic 42	de/robv/android/xposed/DexposedBridge:hookedMethodCallbacks	Ljava/util/Map;
    //   57: invokeinterface 501 1 0
    //   62: aload_1
    //   63: monitorexit
    //   64: invokestatic 503	com/tencent/qa/apphook/GalileoHookManager:unhookAllMethods	()V
    //   67: invokestatic 504	com/tencent/yahfa/apphook/YahfaHookManager:unhookAllMethods	()V
    //   70: return
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: aload_1
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	30	0	i	int
    //   71	4	2	localObject2	Object
    //   76	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	33	71	finally
    //   40	48	71	finally
    //   72	74	71	finally
    //   54	64	76	finally
    //   77	79	76	finally
  }
  
  public static void unhookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    Logger.i("DexposedBridge", "unhookMethod method name is " + paramMember.getName());
    synchronized (hookedMethodCallbacks)
    {
      paramMember = (DexposedBridge.CopyOnWriteSortedSet)hookedMethodCallbacks.get(paramMember);
      if (paramMember == null) {
        return;
      }
      paramMember.remove(paramXC_MethodHook);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.DexposedBridge
 * JD-Core Version:    0.7.0.1
 */