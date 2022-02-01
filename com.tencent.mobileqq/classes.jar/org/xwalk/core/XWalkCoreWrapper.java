package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.xweb.a;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.updater.Scheduler;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkCoreWrapper
{
  private static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
  public static final int INVOKE_NOTITY_FUNCTION_ID_FOR_TEST = 10001;
  public static final int INVOKE_NOTITY_FUNCTION_ID_IDKEY = 50001;
  public static final int INVOKE_NOTITY_FUNCTION_ID_KVSTAT = 50002;
  public static final int InvokeChannel_func_id_log = 30002;
  public static final int InvokeChannel_func_native_trans = 30003;
  private static final String TAG = "XWalkLib";
  private static final String WRAPPER_PACKAGE = "org.xwalk.core";
  private static ClassLoader mStandAloneClassLoader;
  private static XWalkCoreWrapper sInstance;
  private static XWalkCoreWrapper sProvisionalInstance;
  private static HashMap<String, LinkedList<XWalkCoreWrapper.ReservedAction>> sReservedActions = new HashMap();
  private static LinkedList<String> sReservedActivities = new LinkedList();
  private int mApiVersion = 8;
  private int mApkVersion;
  private Context mBridgeContext;
  private ClassLoader mBridgeLoader;
  private int mCoreStatus;
  private int mMinApiVersion;
  private Context mWrapperContext;
  ClassLoader sBridgeLoader;
  
  private XWalkCoreWrapper(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt1 > this.mApiVersion)) {
      paramInt1 = this.mApiVersion;
    }
    this.mMinApiVersion = paramInt1;
    this.mCoreStatus = 0;
    this.mWrapperContext = new XWalkContextWrapper(paramContext, XWalkEnvironment.getAvailableVersion());
    this.mApkVersion = paramInt2;
  }
  
  public static int attachXWalkCore(int paramInt)
  {
    if (!sReservedActivities.isEmpty())
    {
      if (sInstance == null)
      {
        Log.i("XWalkLib", "Attach xwalk core");
        if (paramInt == -1)
        {
          Log.i("XWalkLib", "version = -1, no xwalk");
          return 10;
        }
        sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1, paramInt);
        if (XWalkEnvironment.isDownloadMode())
        {
          sProvisionalInstance.findDownloadedCore();
          return sProvisionalInstance.mCoreStatus;
        }
        return sProvisionalInstance.mCoreStatus;
      }
      throw new AssertionError();
    }
    throw new AssertionError();
  }
  
  public static void bindNativeTrans(long paramLong)
  {
    invokeNativeChannel(null, 30003, new String[] { String.valueOf(paramLong) });
  }
  
  private boolean checkCoreApk()
  {
    if (!new File(XWalkEnvironment.getDownloadApkPath(this.mApkVersion)).exists())
    {
      Log.e("XWalkLib", "checkCoreApk apk not exists");
      this.mCoreStatus = 9;
      return false;
    }
    Log.i("XWalkLib", "XWalk checkCoreApk matched");
    return true;
  }
  
  private boolean checkCoreArchitecture()
  {
    for (;;)
    {
      try
      {
        localObject2 = new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "loadXWalkLibrary", new Class[] { Context.class, String.class });
        Object localObject1 = null;
        if (this.mBridgeContext != null)
        {
          if (Build.VERSION.SDK_INT < 17)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("/data/data/");
            ((StringBuilder)localObject1).append(this.mBridgeContext.getPackageName());
            ((StringBuilder)localObject1).append("/lib");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          bool = ((Boolean)((ReflectMethod)localObject2).invoke(new Object[] { this.mBridgeContext, localObject1 })).booleanValue();
        }
        else
        {
          if (this.mWrapperContext == null) {
            break label574;
          }
          localObject1 = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
          bool = ((Boolean)((ReflectMethod)localObject2).invoke(new Object[] { this.mWrapperContext, localObject1 })).booleanValue();
        }
        if (!bool)
        {
          h.a(191L, 1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Mismatch of CPU architecture current device abi is ");
          ((StringBuilder)localObject1).append(XWalkEnvironment.getRuntimeAbi());
          ((StringBuilder)localObject1).append(", runtime abi is ");
          ((StringBuilder)localObject1).append(XWalkEnvironment.getRuntimeAbi());
          ((StringBuilder)localObject1).append(", core detail is ");
          ((StringBuilder)localObject1).append(XWalkEnvironment.getAvailableVersionDetail());
          Log.e("XWalkLib", ((StringBuilder)localObject1).toString());
          this.mCoreStatus = 6;
          return false;
        }
        Log.i("XWalkLib", "XWalk core architecture matched");
        return true;
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e("XWalkLib", localRuntimeException.getLocalizedMessage());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("current device abi is ");
        ((StringBuilder)localObject2).append(XWalkEnvironment.getRuntimeAbi());
        ((StringBuilder)localObject2).append(", runtime abi is ");
        ((StringBuilder)localObject2).append(XWalkEnvironment.getRuntimeAbi());
        ((StringBuilder)localObject2).append(", core detail is ");
        ((StringBuilder)localObject2).append(XWalkEnvironment.getAvailableVersionDetail());
        Log.e("XWalkLib", ((StringBuilder)localObject2).toString());
        h.a(192L, 1);
        if ((localRuntimeException.getCause() instanceof UnsatisfiedLinkError))
        {
          this.mCoreStatus = 6;
          String str = localRuntimeException.getMessage();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("UnsatisfiedLinkError : ");
          ((StringBuilder)localObject2).append(str);
          Log.e("XWalkLib", ((StringBuilder)localObject2).toString());
          if (TextUtils.isEmpty(str)) {
            return false;
          }
          if (str.contains("is 64-bit instead of 32-bit"))
          {
            h.a(193L, 1);
            try
            {
              if ("true".equalsIgnoreCase(a.g("dis_abandon_when_32runtime_use_64so"))) {
                continue;
              }
              XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
              Scheduler.m();
              return false;
            }
            catch (Throwable localThrowable1)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("clear version failed , errmsg:");
              ((StringBuilder)localObject2).append(localThrowable1.getMessage());
              Log.e("XWalkLib", ((StringBuilder)localObject2).toString());
              return false;
            }
          }
          else if (localThrowable1.contains("is 32-bit instead of 64-bit"))
          {
            h.a(194L, 1);
            try
            {
              if ("true".equalsIgnoreCase(a.g("dis_abandon_when_64runtime_use_32so"))) {
                continue;
              }
              XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
              Scheduler.m();
              return false;
            }
            catch (Throwable localThrowable2)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("clear version failed , errmsg:");
              ((StringBuilder)localObject2).append(localThrowable2.getMessage());
              Log.e("XWalkLib", ((StringBuilder)localObject2).toString());
              return false;
            }
          }
          else
          {
            h.a(195L, 1);
          }
          return false;
        }
        this.mCoreStatus = 5;
        return false;
      }
      label574:
      boolean bool = false;
    }
  }
  
  private boolean checkCorePackage(String paramString)
  {
    try
    {
      this.mBridgeContext = this.mWrapperContext.createPackageContext(paramString, 3);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Created package context for ");
      localStringBuilder.append(paramString);
      Log.d("XWalkLib", localStringBuilder.toString());
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      StringBuilder localStringBuilder;
      label46:
      break label46;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" not found");
    Log.d("XWalkLib", localStringBuilder.toString());
    return false;
  }
  
  public static void dockXWalkCore()
  {
    if (sProvisionalInstance != null)
    {
      if (sInstance == null)
      {
        Log.d("XWalkLib", "Dock xwalk core");
        sInstance = sProvisionalInstance;
        sProvisionalInstance = null;
        a.a().a("DIS_INIT_XWALK_AT_LOAD", "tools", false);
        return;
      }
      throw new AssertionError();
    }
    throw new AssertionError();
  }
  
  private boolean findDownloadedCore()
  {
    this.mBridgeLoader = getBridgeLoader();
    sProvisionalInstance.initCoreBridge();
    if ((this.mBridgeLoader != null) && (checkCoreVersion()) && (checkCoreArchitecture()) && (checkCoreApk()))
    {
      if (!initLog(sProvisionalInstance)) {
        Log.e("XWalkLib", "initLog failed !");
      } else {
        Log.i("XWalkLib", "initLog success!");
      }
      Log.d("XWalkLib", "Running in downloaded mode");
      this.mCoreStatus = 1;
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mBridgeLoader set to null , prev mBridgeLoader =  ");
    localStringBuilder.append(this.mBridgeLoader);
    Log.e("XWalkLib", localStringBuilder.toString());
    this.mBridgeLoader = null;
    return false;
  }
  
  public static int getCoreStatus()
  {
    XWalkCoreWrapper localXWalkCoreWrapper = sInstance;
    if (localXWalkCoreWrapper != null) {
      return localXWalkCoreWrapper.mCoreStatus;
    }
    localXWalkCoreWrapper = sProvisionalInstance;
    if (localXWalkCoreWrapper == null) {
      return 0;
    }
    return localXWalkCoreWrapper.mCoreStatus;
  }
  
  public static XWalkCoreWrapper getInstance()
  {
    return sInstance;
  }
  
  private static ClassLoader getStandAloneClassLoader()
  {
    if ((getInstance() != null) && (getInstance().sBridgeLoader != null)) {
      return getInstance().sBridgeLoader;
    }
    ClassLoader localClassLoader = mStandAloneClassLoader;
    if (localClassLoader != null) {
      return localClassLoader;
    }
    try
    {
      mStandAloneClassLoader = i.a();
      return mStandAloneClassLoader;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getXWalkClassLoader error:");
      localStringBuilder.append(localException.getMessage());
      Log.e("XWalkLib", localStringBuilder.toString());
    }
    return null;
  }
  
  public static void handlePostInit(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Post init xwalk core in ");
    ((StringBuilder)localObject1).append(paramString);
    Log.d("XWalkLib", ((StringBuilder)localObject1).toString());
    if (!sReservedActions.containsKey(paramString)) {
      return;
    }
    localObject1 = (LinkedList)sReservedActions.get(paramString);
    while (((LinkedList)localObject1).size() != 0)
    {
      XWalkCoreWrapper.ReservedAction localReservedAction = (XWalkCoreWrapper.ReservedAction)((LinkedList)localObject1).pop();
      Object localObject2 = localReservedAction.mObject;
      int i = 0;
      if (localObject2 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Init reserved object: ");
        ((StringBuilder)localObject2).append(localReservedAction.mObject.getClass());
        Log.d("XWalkLib", ((StringBuilder)localObject2).toString());
        new ReflectMethod(localReservedAction.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
      }
      else if (localReservedAction.mClass != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Init reserved class: ");
        ((StringBuilder)localObject2).append(localReservedAction.mClass.toString());
        Log.d("XWalkLib", ((StringBuilder)localObject2).toString());
        new ReflectMethod(localReservedAction.mClass, "reflectionInit", new Class[0]).invoke(new Object[0]);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Call reserved method: ");
        ((StringBuilder)localObject2).append(localReservedAction.mMethod.toString());
        Log.d("XWalkLib", ((StringBuilder)localObject2).toString());
        localObject2 = localReservedAction.mArguments;
        if (localObject2 != null) {
          while (i < localObject2.length)
          {
            if ((localObject2[i] instanceof ReflectMethod)) {
              localObject2[i] = ((ReflectMethod)localObject2[i]).invokeWithArguments();
            }
            i += 1;
          }
        }
        localReservedAction.mMethod.invoke((Object[])localObject2);
      }
    }
    sReservedActions.remove(paramString);
    sReservedActivities.remove(paramString);
  }
  
  public static void handlePreInit(String paramString)
  {
    if (sInstance != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Pre init xwalk core in ");
    localStringBuilder.append(paramString);
    Log.d("XWalkLib", localStringBuilder.toString());
    if (sReservedActions.containsKey(paramString)) {
      sReservedActions.remove(paramString);
    } else {
      sReservedActivities.add(paramString);
    }
    sReservedActions.put(paramString, new LinkedList());
  }
  
  public static void handleRuntimeError(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("This API is incompatible with the Crosswalk runtime library:");
    localStringBuilder.append(paramException.getMessage());
    Log.e("XWalkLib", localStringBuilder.toString());
    paramException.printStackTrace();
  }
  
  public static boolean hasFeatureStatic(int paramInt)
  {
    Object localObject = invokeRuntimeChannel(getStandAloneClassLoader(), 80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  private byte[] hexStringToByteArray(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (paramString.length() % 2 == 0))
    {
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      while (i < paramString.length())
      {
        int j = Character.digit(paramString.charAt(i), 16);
        int k = Character.digit(paramString.charAt(i + 1), 16);
        arrayOfByte[(i / 2)] = ((byte)((j << 4) + k));
        i += 2;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  private void initCoreBridge()
  {
    Log.d("XWalkLib", "Init core bridge");
    new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "init", new Class[] { Context.class, Object.class }).invoke(new Object[] { this.mBridgeContext, this });
  }
  
  public static void initEmbeddedMode()
  {
    if (sInstance == null)
    {
      if (!sReservedActivities.isEmpty()) {
        return;
      }
      throw new RuntimeException("royle:downloadmode should not goto this");
    }
  }
  
  private boolean initLog(XWalkCoreWrapper paramXWalkCoreWrapper)
  {
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk runtime version not matched 153");
      return false;
    }
    Object localObject = new XWalkCoreWrapper.1(this, paramXWalkCoreWrapper);
    try
    {
      paramXWalkCoreWrapper = getBridgeClass("XWalkViewDelegate");
      localObject = ((XWalkLogMessageListener)localObject).getBridge();
      new ReflectMethod(paramXWalkCoreWrapper, "setLogCallBack", new Class[] { Object.class }).invoke(new Object[] { localObject });
      return true;
    }
    catch (RuntimeException paramXWalkCoreWrapper)
    {
      Log.d("XWalkLib", paramXWalkCoreWrapper.getLocalizedMessage());
    }
    return false;
  }
  
  private void initXWalkView()
  {
    Log.d("XWalkLib", "Init xwalk view");
    new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "init", new Class[] { Context.class, Context.class }).invoke(new Object[] { this.mBridgeContext, this.mWrapperContext });
  }
  
  public static boolean invokeNativeChannel(ClassLoader paramClassLoader, int paramInt, Object[] paramArrayOfObject)
  {
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk invokeNativeChannel runtime version not matched 153");
      return false;
    }
    try
    {
      try
      {
        invokeReflectMethod(paramClassLoader, "invokeNativeChannel", paramInt, paramArrayOfObject);
      }
      catch (Exception paramClassLoader)
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("invokeRuntimeChannel error:");
        paramArrayOfObject.append(paramClassLoader.getLocalizedMessage());
        Log.e("XWalkLib", paramArrayOfObject.toString());
        h.Q();
      }
      catch (ClassCircularityError paramClassLoader)
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("invokeRuntimeChannel error:");
        paramArrayOfObject.append(paramClassLoader.getLocalizedMessage());
        Log.e("XWalkLib", paramArrayOfObject.toString());
        h.P();
      }
      return true;
    }
    catch (RuntimeException paramClassLoader)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("invokeNativeChannel error:");
      paramArrayOfObject.append(paramClassLoader.getLocalizedMessage());
      Log.e("XWalkLib", paramArrayOfObject.toString());
      h.O();
    }
    return false;
  }
  
  private static Object invokeReflectMethod(ClassLoader paramClassLoader, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    if (paramClassLoader == null) {
      return new ReflectMethod(getInstance().getBridgeClass("XWalkViewDelegate"), paramString, new Class[] { Integer.TYPE, [Ljava.lang.Object.class }).invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
    }
    try
    {
      paramClassLoader = paramClassLoader.loadClass("org.xwalk.core.internal.XWalkViewDelegate");
      return new ReflectMethod(paramClassLoader, paramString, new Class[] { Integer.TYPE, [Ljava.lang.Object.class }).invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramString = new StringBuilder();
      paramString.append("invokeRuntimeChannel with classloader error:");
      paramString.append(paramClassLoader.getMessage());
      Log.e("XWalkLib", paramString.toString());
    }
    return null;
  }
  
  public static Object invokeRuntimeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    return invokeRuntimeChannel(null, paramInt, paramArrayOfObject);
  }
  
  private static Object invokeRuntimeChannel(ClassLoader paramClassLoader, int paramInt, Object[] paramArrayOfObject)
  {
    if (paramClassLoader == null) {
      Log.i("XWalkLib", "invokeRuntimeChannel class loader is null. may be gp version");
    }
    if (XWalkEnvironment.getAvailableVersion() < 255)
    {
      Log.d("XWalkLib", "invokeRuntimeChannel version below SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION");
      return null;
    }
    try
    {
      paramClassLoader = invokeReflectMethod(paramClassLoader, "invokeRuntimeChannel", paramInt, paramArrayOfObject);
      return paramClassLoader;
    }
    catch (Exception paramClassLoader)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("invokeRuntimeChannel error:");
      paramArrayOfObject.append(paramClassLoader.getLocalizedMessage());
      Log.e("XWalkLib", paramArrayOfObject.toString());
      h.Q();
      return null;
    }
    catch (ClassCircularityError paramClassLoader)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("invokeRuntimeChannel error:");
      paramArrayOfObject.append(paramClassLoader.getLocalizedMessage());
      Log.e("XWalkLib", paramArrayOfObject.toString());
      h.P();
      return null;
    }
    catch (RuntimeException paramClassLoader)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("invokeRuntimeChannel error:");
      paramArrayOfObject.append(paramClassLoader.getLocalizedMessage());
      Log.e("XWalkLib", paramArrayOfObject.toString());
      h.O();
    }
    return null;
  }
  
  public static void reserveReflectClass(Class<?> paramClass)
  {
    String str = (String)sReservedActivities.getLast();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Reserve class ");
    localStringBuilder.append(paramClass.toString());
    localStringBuilder.append(" to ");
    localStringBuilder.append(str);
    Log.d("XWalkLib", localStringBuilder.toString());
    ((LinkedList)sReservedActions.get(str)).add(new XWalkCoreWrapper.ReservedAction(paramClass));
  }
  
  public static void reserveReflectMethod(ReflectMethod paramReflectMethod)
  {
    String str = (String)sReservedActivities.getLast();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Reserve method ");
    localStringBuilder.append(paramReflectMethod.toString());
    localStringBuilder.append(" to ");
    localStringBuilder.append(str);
    Log.d("XWalkLib", localStringBuilder.toString());
    ((LinkedList)sReservedActions.get(str)).add(new XWalkCoreWrapper.ReservedAction(paramReflectMethod));
  }
  
  public static void reserveReflectObject(Object paramObject)
  {
    String str = (String)sReservedActivities.getLast();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Reserve object ");
    localStringBuilder.append(paramObject.getClass());
    localStringBuilder.append(" to ");
    localStringBuilder.append(str);
    Log.d("XWalkLib", localStringBuilder.toString());
    ((LinkedList)sReservedActions.get(str)).add(new XWalkCoreWrapper.ReservedAction(paramObject));
  }
  
  private boolean verifyPackageInfo(PackageInfo paramPackageInfo, String paramString1, String paramString2)
  {
    if (paramPackageInfo.signatures == null)
    {
      Log.e("XWalkLib", "No signature in package info");
      return false;
    }
    try
    {
      paramString1 = MessageDigest.getInstance(paramString1);
      paramString2 = hexStringToByteArray(paramString2);
      if (paramString2 != null)
      {
        int i = 0;
        while (i < paramPackageInfo.signatures.length)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Checking signature ");
          localStringBuilder.append(i);
          Log.d("XWalkLib", localStringBuilder.toString());
          if (!MessageDigest.isEqual(paramString1.digest(paramPackageInfo.signatures[i].toByteArray()), paramString2))
          {
            Log.e("XWalkLib", "Hash code does not match");
            i += 1;
          }
          else
          {
            Log.d("XWalkLib", "Signature passed verification");
            return true;
          }
        }
        return false;
      }
      throw new IllegalArgumentException("Invalid hash code");
    }
    catch (NoSuchAlgorithmException|NullPointerException paramPackageInfo)
    {
      label142:
      break label142;
    }
    paramPackageInfo = new IllegalArgumentException("Invalid hash algorithm");
    for (;;)
    {
      throw paramPackageInfo;
    }
  }
  
  public boolean checkCoreVersion()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[Environment] SDK:");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    Log.i("XWalkLib", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[App Version] build:24.53.595.0, api:");
    ((StringBuilder)localObject1).append(this.mApiVersion);
    ((StringBuilder)localObject1).append(", min_api:");
    ((StringBuilder)localObject1).append(this.mMinApiVersion);
    Log.i("XWalkLib", ((StringBuilder)localObject1).toString());
    try
    {
      localClass = getBridgeClass("XWalkCoreVersion");
      localObject1 = "";
    }
    catch (RuntimeException localRuntimeException1)
    {
      Class localClass;
      Object localObject2;
      label120:
      int i;
      int j;
      break label308;
    }
    try
    {
      localObject2 = (String)new ReflectField(localClass, "XWALK_BUILD_VERSION").get();
      localObject1 = localObject2;
    }
    catch (RuntimeException localRuntimeException2)
    {
      break label120;
    }
    i = ((Integer)new ReflectField(localClass, "API_VERSION").get()).intValue();
    j = ((Integer)new ReflectField(localClass, "MIN_API_VERSION").get()).intValue();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[Lib Version] build:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", api:");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", min_api:");
    ((StringBuilder)localObject2).append(j);
    Log.i("XWalkLib", ((StringBuilder)localObject2).toString());
    if ((XWalkEnvironment.isDownloadMode()) && (XWalkEnvironment.isDownloadModeUpdate()) && (!((String)localObject1).isEmpty()) && (!((String)localObject1).equals("24.53.595.0")))
    {
      this.mCoreStatus = 8;
      return false;
    }
    if (this.mMinApiVersion > i)
    {
      this.mCoreStatus = 3;
      return false;
    }
    if (this.mApiVersion < j)
    {
      this.mCoreStatus = 4;
      return false;
    }
    Log.i("XWalkLib", "XWalk core version matched");
    return true;
    label308:
    Log.e("XWalkLib", "XWalk core not found");
    this.mCoreStatus = 2;
    return false;
  }
  
  public int getApkVersion()
  {
    Object localObject = getBridgeLoader();
    if (localObject == null) {
      return 0;
    }
    try
    {
      localObject = ((ClassLoader)localObject).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
      if (localObject == null) {
        return 0;
      }
      int i = ((Integer)new ReflectField((Class)localObject, "XWALK_APK_VERSION").get()).intValue();
      return i;
    }
    catch (ClassNotFoundException|RuntimeException localClassNotFoundException) {}
    return 0;
  }
  
  public Class<?> getBridgeClass(String paramString)
  {
    try
    {
      ClassLoader localClassLoader = this.mBridgeLoader;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("org.xwalk.core.internal.");
      localStringBuilder.append(paramString);
      paramString = localClassLoader.loadClass(localStringBuilder.toString());
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      label38:
      break label38;
    }
    return null;
  }
  
  public ClassLoader getBridgeLoader()
  {
    ClassLoader localClassLoader = this.sBridgeLoader;
    if (localClassLoader != null) {
      return localClassLoader;
    }
    this.sBridgeLoader = i.b(this.mApkVersion);
    return this.sBridgeLoader;
  }
  
  public Object getBridgeObject(Object paramObject)
  {
    try
    {
      paramObject = new ReflectMethod(paramObject, "getBridge", new Class[0]).invoke(new Object[0]);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  public Class<?> getClass(String paramString)
  {
    try
    {
      paramString = this.mBridgeLoader.loadClass(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public Object getWrapperObject(Object paramObject)
  {
    try
    {
      paramObject = new ReflectMethod(paramObject, "getWrapper", new Class[0]).invoke(new Object[0]);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  public boolean hasFeature(int paramInt)
  {
    Object localObject = invokeRuntimeChannel(80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public boolean initNotifyChannnel()
  {
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk runtime version not matched 153");
      return false;
    }
    Object localObject = new XWalkCoreWrapper.2(this);
    try
    {
      Class localClass = getBridgeClass("XWalkViewDelegate");
      localObject = ((XWalkNotifyChannelListener)localObject).getBridge();
      new ReflectMethod(localClass, "setNotifyCallBackChannel", new Class[] { Object.class }).invoke(new Object[] { localObject });
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.d("XWalkLib", localRuntimeException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean isDownLoadCoreAvailable()
  {
    Object localObject = getBridgeLoader();
    if (localObject == null) {
      return false;
    }
    try
    {
      localObject = ((ClassLoader)localObject).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
      return localObject != null;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  public boolean isSharedMode()
  {
    return this.mBridgeContext != null;
  }
  
  public boolean isSupportTranslateWebSite()
  {
    Object localObject = invokeRuntimeChannel(80011, null);
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper
 * JD-Core Version:    0.7.0.1
 */