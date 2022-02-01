package de.robv.android.xposed;

import android.annotation.SuppressLint;
import android.app.ActivityThread;
import android.app.AndroidAppHelper;
import android.app.LoadedApk;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XResources;
import android.content.res.XResources.XTypedArray;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.android.internal.os.ZygoteInit;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;
import de.robv.android.xposed.callbacks.XCallback;
import de.robv.android.xposed.services.BaseService;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class XposedInit
{
  @SuppressLint({"SdCardPath"})
  private static final String BASE_DIR;
  private static final String INSTALLER_PACKAGE_NAME = "de.robv.android.xposed.installer";
  private static final String INSTANT_RUN_CLASS = "com.android.tools.fd.runtime.BootstrapApplication";
  private static final String TAG = "Xposed";
  private static final String[] XRESOURCES_CONFLICTING_PACKAGES;
  private static boolean disableResources;
  private static final String startClassName;
  private static final boolean startsSystemServer = ;
  
  static
  {
    startClassName = XposedBridge.getStartClassName();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = "/data/user_de/0/de.robv.android.xposed.installer/";; str = "/data/data/de.robv.android.xposed.installer/")
    {
      BASE_DIR = str;
      disableResources = false;
      XRESOURCES_CONFLICTING_PACKAGES = new String[] { "com.sygic.aura" };
      return;
    }
  }
  
  private static XResources cloneToXResources(XC_MethodHook.MethodHookParam paramMethodHookParam, String paramString)
  {
    Object localObject = paramMethodHookParam.getResult();
    if ((localObject == null) || ((localObject instanceof XResources)) || (Arrays.binarySearch(XRESOURCES_CONFLICTING_PACKAGES, AndroidAppHelper.currentPackageName()) == 0)) {
      return null;
    }
    localObject = (XResources)XposedBridge.cloneToSubclass(localObject, XResources.class);
    ((XResources)localObject).initObject(paramString);
    if (((XResources)localObject).isFirstLoad())
    {
      paramString = ((XResources)localObject).getPackageName();
      XC_InitPackageResources.InitPackageResourcesParam localInitPackageResourcesParam = new XC_InitPackageResources.InitPackageResourcesParam(XposedBridge.sInitPackageResourcesCallbacks);
      localInitPackageResourcesParam.packageName = paramString;
      localInitPackageResourcesParam.res = ((XResources)localObject);
      XCallback.callAll(localInitPackageResourcesParam);
    }
    paramMethodHookParam.setResult(localObject);
    return localObject;
  }
  
  static void hookResources()
  {
    if (SELinuxHelper.getAppDataFileService().checkFileExists(BASE_DIR + "conf/disable_resources"))
    {
      Log.w("Xposed", "Found " + BASE_DIR + "conf/disable_resources, not hooking resources");
      disableResources = true;
      return;
    }
    if (!XposedBridge.initXResourcesNative())
    {
      Log.e("Xposed", "Cannot hook resources");
      disableResources = true;
      return;
    }
    ThreadLocal localThreadLocal = new ThreadLocal();
    Object localObject2;
    Object localObject1;
    if (Build.VERSION.SDK_INT <= 18)
    {
      localObject2 = ActivityThread.class;
      localObject1 = Class.forName("android.app.ActivityThread$ResourcesKey");
      if (Build.VERSION.SDK_INT < 24) {
        break label227;
      }
      XposedBridge.hookAllMethods((Class)localObject2, "getOrCreateResources", new XposedInit.7((Class)localObject1));
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject1 = XposedHelpers.getOverriddenMethods(XResources.XTypedArray.class);
        XposedBridge.invalidateCallersNative((Member[])((Set)localObject1).toArray(new Member[((Set)localObject1).size()]));
      }
      XposedBridge.hookAllConstructors(TypedArray.class, new XposedInit.11());
      localObject1 = (XResources)XposedBridge.cloneToSubclass(Resources.getSystem(), XResources.class);
      ((XResources)localObject1).initObject(null);
      XposedHelpers.setStaticObjectField(Resources.class, "mSystem", localObject1);
      XResources.init(localThreadLocal);
      return;
      localObject2 = Class.forName("android.app.ResourcesManager");
      localObject1 = Class.forName("android.content.res.ResourcesKey");
      break;
      label227:
      XposedBridge.hookAllConstructors((Class)localObject1, new XposedInit.8(localThreadLocal));
      XposedBridge.hookAllMethods((Class)localObject2, "getTopLevelResources", new XposedInit.9(localThreadLocal));
      if (Build.VERSION.SDK_INT >= 19) {
        XposedBridge.hookAllMethods((Class)localObject2, "getTopLevelThemedResources", new XposedInit.10());
      }
    }
  }
  
  private static void hookXposedInstaller(ClassLoader paramClassLoader)
  {
    try
    {
      XposedHelpers.findAndHookMethod("de.robv.android.xposed.installer.XposedApp", paramClassLoader, "getActiveXposedVersion", new Object[] { XC_MethodReplacement.returnConstant(Integer.valueOf(XposedBridge.getXposedVersion())) });
      XposedHelpers.findAndHookMethod("de.robv.android.xposed.installer.XposedApp", paramClassLoader, "onCreate", new Object[] { new XposedInit.12() });
      return;
    }
    catch (Throwable paramClassLoader)
    {
      Log.e("Xposed", "Could not hook Xposed Installer", paramClassLoader);
    }
  }
  
  static void initForZygote()
  {
    Object localObject1;
    if (needsToCloseFilesForFork())
    {
      localObject1 = new XposedInit.1();
      localObject2 = XposedHelpers.findClass("com.android.internal.os.Zygote", null);
      XposedBridge.hookAllMethods((Class)localObject2, "nativeForkAndSpecialize", (XC_MethodHook)localObject1);
      XposedBridge.hookAllMethods((Class)localObject2, "nativeForkSystemServer", (XC_MethodHook)localObject1);
    }
    Object localObject2 = new HashSet(1);
    XposedHelpers.findAndHookMethod(ActivityThread.class, "handleBindApplication", new Object[] { "android.app.ActivityThread.AppBindData", new XposedInit.2((HashSet)localObject2) });
    if (Build.VERSION.SDK_INT < 21) {
      if (Build.VERSION.SDK_INT < 19)
      {
        localObject1 = "run";
        XposedHelpers.findAndHookMethod("com.android.server.ServerThread", null, (String)localObject1, new Object[] { new XposedInit.3((HashSet)localObject2) });
      }
    }
    for (;;)
    {
      XposedBridge.hookAllConstructors(LoadedApk.class, new XposedInit.5((HashSet)localObject2));
      XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", null, "getResourcesForApplication", new Object[] { ApplicationInfo.class, new XposedInit.6() });
      if (XposedHelpers.findFieldIfExists(ZygoteInit.class, "BOOT_START_TIME") != null) {
        XposedHelpers.setStaticLongField(ZygoteInit.class, "BOOT_START_TIME", XposedBridge.BOOT_START_TIME);
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localObject1 = XposedHelpers.findClass("com.android.internal.os.Zygote", null);
      }
      try
      {
        XposedHelpers.setStaticBooleanField((Class)localObject1, "isEnhancedZygoteASLREnabled", false);
        return;
      }
      catch (NoSuchFieldError localNoSuchFieldError) {}
      localObject1 = "initAndLoop";
      break;
      if (startsSystemServer) {
        XposedHelpers.findAndHookMethod(ActivityThread.class, "systemMain", new Object[] { new XposedInit.4((HashSet)localObject2) });
      }
    }
  }
  
  private static void loadModule(String paramString, ClassLoader paramClassLoader)
  {
    Log.i("Xposed", "Loading modules from " + paramString);
    if (!new File(paramString).exists())
    {
      Log.e("Xposed", "  File does not exist");
      return;
    }
    try
    {
      localObject1 = new DexFile(paramString);
      if (((DexFile)localObject1).loadClass("com.android.tools.fd.runtime.BootstrapApplication", paramClassLoader) != null)
      {
        Log.e("Xposed", "  Cannot load module, please disable \"Instant Run\" in Android Studio.");
        XposedHelpers.closeSilently((DexFile)localObject1);
        return;
      }
    }
    catch (IOException paramString)
    {
      Log.e("Xposed", "  Cannot load module", paramString);
      return;
    }
    if (((DexFile)localObject1).loadClass(XposedBridge.class.getName(), paramClassLoader) != null)
    {
      Log.e("Xposed", "  Cannot load module:");
      Log.e("Xposed", "  The Xposed API classes are compiled into the module's APK.");
      Log.e("Xposed", "  This may cause strange issues and must be fixed by the module developer.");
      Log.e("Xposed", "  For details, see: http://api.xposed.info/using.html");
      XposedHelpers.closeSilently((DexFile)localObject1);
      return;
    }
    XposedHelpers.closeSilently((DexFile)localObject1);
    localObject1 = null;
    try
    {
      paramClassLoader = new ZipFile(paramString);
      try
      {
        localObject1 = paramClassLoader.getEntry("assets/xposed_init");
        if (localObject1 != null) {
          break label206;
        }
        Log.e("Xposed", "  assets/xposed_init not found in the APK");
        XposedHelpers.closeSilently(paramClassLoader);
        return;
      }
      catch (IOException paramString) {}
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        PathClassLoader localPathClassLoader;
        BufferedReader localBufferedReader;
        paramClassLoader = (ClassLoader)localObject1;
      }
    }
    Log.e("Xposed", "  Cannot read assets/xposed_init in the APK", paramString);
    XposedHelpers.closeSilently(paramClassLoader);
    return;
    label206:
    localObject1 = paramClassLoader.getInputStream((ZipEntry)localObject1);
    localPathClassLoader = new PathClassLoader(paramString, XposedBridge.BOOTCLASSLOADER);
    localBufferedReader = new BufferedReader(new InputStreamReader((InputStream)localObject1));
    for (;;)
    {
      try
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        str = str.trim();
        if (str.isEmpty()) {
          continue;
        }
        boolean bool = str.startsWith("#");
        if (bool) {
          continue;
        }
        try
        {
          Log.i("Xposed", "  Loading class " + str);
          Class localClass = localPathClassLoader.loadClass(str);
          if (IXposedMod.class.isAssignableFrom(localClass)) {
            continue;
          }
          Log.e("Xposed", "    This class doesn't implement any sub-interface of IXposedMod, skipping it");
        }
        catch (Throwable localThrowable)
        {
          Log.e("Xposed", "    Failed to load class " + str, localThrowable);
        }
        continue;
      }
      catch (IOException localIOException)
      {
        Log.e("Xposed", "  Failed to load module from " + paramString, localIOException);
        return;
        if ((disableResources) && (IXposedHookInitPackageResources.class.isAssignableFrom(localThrowable)))
        {
          Log.e("Xposed", "    This class requires resource-related hooks (which are disabled), skipping it.");
          continue;
        }
      }
      finally
      {
        XposedHelpers.closeSilently((Closeable)localObject1);
        XposedHelpers.closeSilently(paramClassLoader);
      }
      Object localObject2 = localThrowable.newInstance();
      Object localObject3;
      if (XposedBridge.isZygote)
      {
        if ((localObject2 instanceof IXposedHookZygoteInit))
        {
          localObject3 = new IXposedHookZygoteInit.StartupParam();
          ((IXposedHookZygoteInit.StartupParam)localObject3).modulePath = paramString;
          ((IXposedHookZygoteInit.StartupParam)localObject3).startsSystemServer = startsSystemServer;
          ((IXposedHookZygoteInit)localObject2).initZygote((IXposedHookZygoteInit.StartupParam)localObject3);
        }
        if ((localObject2 instanceof IXposedHookLoadPackage)) {
          XposedBridge.hookLoadPackage(new IXposedHookLoadPackage.Wrapper((IXposedHookLoadPackage)localObject2));
        }
        if ((localObject2 instanceof IXposedHookInitPackageResources)) {
          XposedBridge.hookInitPackageResources(new IXposedHookInitPackageResources.Wrapper((IXposedHookInitPackageResources)localObject2));
        }
      }
      else if ((localObject2 instanceof IXposedHookCmdInit))
      {
        localObject3 = new IXposedHookCmdInit.StartupParam();
        ((IXposedHookCmdInit.StartupParam)localObject3).modulePath = paramString;
        ((IXposedHookCmdInit.StartupParam)localObject3).startClassName = startClassName;
        ((IXposedHookCmdInit)localObject2).initCmdApp((IXposedHookCmdInit.StartupParam)localObject3);
      }
    }
    XposedHelpers.closeSilently((Closeable)localObject1);
    XposedHelpers.closeSilently(paramClassLoader);
  }
  
  static void loadModules()
  {
    String str = BASE_DIR + "conf/modules.list";
    BaseService localBaseService = SELinuxHelper.getAppDataFileService();
    if (!localBaseService.checkFileExists(str))
    {
      Log.e("Xposed", "Cannot load any modules because " + str + " was not found");
      return;
    }
    for (Object localObject1 = XposedBridge.BOOTCLASSLOADER;; localObject1 = localObject2)
    {
      localObject2 = ((ClassLoader)localObject1).getParent();
      if (localObject2 == null) {
        break;
      }
    }
    Object localObject2 = new BufferedReader(new InputStreamReader(localBaseService.getFileInputStream(str)));
    for (;;)
    {
      str = ((BufferedReader)localObject2).readLine();
      if (str == null) {
        break;
      }
      loadModule(str, (ClassLoader)localObject1);
    }
    ((BufferedReader)localObject2).close();
  }
  
  private static boolean needsToCloseFilesForFork()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return true;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    File localFile = new File(Environment.getRootDirectory(), "lib/libandroid_runtime.so");
    try
    {
      boolean bool = XposedHelpers.fileContains(localFile, "Unable to construct file descriptor table");
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e("Xposed", "Could not check whether " + localFile + " has security patch level 5");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit
 * JD-Core Version:    0.7.0.1
 */