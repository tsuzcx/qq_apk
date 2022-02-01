package com.tencent.mtt.hippy.bridge;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.DimensionsUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import java.util.ArrayList;

public class b
  implements Handler.Callback, HippyBridge.a, a
{
  HippyEngineContext a;
  HippyBundleLoader b;
  HippyBridge c;
  volatile boolean d = false;
  Handler e;
  int f = 1;
  boolean g = false;
  ArrayList<String> h = null;
  HippyEngine.ModuleListener i;
  private StringBuilder k;
  private boolean l = false;
  private String m;
  private int n;
  private HippyThirdPartyAdapter o;
  
  public b(HippyEngineContext paramHippyEngineContext, HippyBundleLoader paramHippyBundleLoader, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2, HippyThirdPartyAdapter paramHippyThirdPartyAdapter)
  {
    this.a = paramHippyEngineContext;
    this.b = paramHippyBundleLoader;
    this.f = paramInt1;
    this.g = paramBoolean1;
    this.l = paramBoolean2;
    this.m = paramString;
    this.n = paramInt2;
    this.o = paramHippyThirdPartyAdapter;
    this.k = new StringBuilder(1024);
  }
  
  private void a(HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView)
  {
    if (UIThreadUtils.isOnUiThread())
    {
      HippyEngine.ModuleListener localModuleListener = this.i;
      if (localModuleListener != null) {
        localModuleListener.onLoadCompleted(paramModuleLoadStatus, paramString, paramHippyRootView);
      }
    }
    else
    {
      UIThreadUtils.runOnUiThread(new b.6(this, paramModuleLoadStatus, paramString, paramHippyRootView));
    }
  }
  
  private boolean c()
  {
    int i1 = this.a.getGlobalConfigs().getContext().getResources().getConfiguration().uiMode & 0x30;
    if ((i1 != 0) && (i1 != 16)) {
      return i1 == 32;
    }
    return false;
  }
  
  public void a()
  {
    this.d = false;
    this.i = null;
    Handler localHandler = this.e;
    if (localHandler != null)
    {
      localHandler.removeMessages(10);
      this.e.removeMessages(11);
      this.e.removeMessages(12);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.d) {
      return;
    }
    Message localMessage = this.e.obtainMessage(12, 0, 2, Integer.valueOf(paramInt));
    this.e.sendMessage(localMessage);
  }
  
  public void a(int paramInt, HippyBundleLoader paramHippyBundleLoader, HippyEngine.ModuleListener paramModuleListener, HippyRootView paramHippyRootView)
  {
    if (!this.d)
    {
      this.i = paramModuleListener;
      a(HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT, "load module error. HippyBridge not initialized", paramHippyRootView);
      return;
    }
    this.i = paramModuleListener;
    paramHippyBundleLoader = this.e.obtainMessage(11, 0, paramInt, paramHippyBundleLoader);
    this.e.sendMessage(paramHippyBundleLoader);
  }
  
  public void a(Callback<Boolean> paramCallback)
  {
    this.e = new Handler(this.a.getThreadExecutor().getJsThread().getLooper(), this);
    paramCallback = this.e.obtainMessage(10, paramCallback);
    this.e.sendMessage(paramCallback);
  }
  
  public void a(HippyJsException paramHippyJsException)
  {
    if (UIThreadUtils.isOnUiThread())
    {
      HippyEngine.ModuleListener localModuleListener = this.i;
      if ((localModuleListener != null) && (localModuleListener.onJsException(paramHippyJsException))) {
        this.i = null;
      }
    }
    else
    {
      UIThreadUtils.runOnUiThread(new b.5(this, paramHippyJsException));
    }
  }
  
  public void a(Object paramObject)
  {
    if (!this.d) {
      return;
    }
    paramObject = this.e.obtainMessage(12, 0, 5, paramObject);
    this.e.sendMessage(paramObject);
  }
  
  public void a(String paramString, int paramInt, HippyMap paramHippyMap)
  {
    if (!this.d) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", paramString);
    localHippyMap.pushInt("id", paramInt);
    localHippyMap.pushMap("params", paramHippyMap);
    paramString = this.e.obtainMessage(12, 0, 1, localHippyMap);
    this.e.sendMessage(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    HippyEngineContext localHippyEngineContext = this.a;
    if (localHippyEngineContext != null) {
      localHippyEngineContext.handleException(new HippyJsException(paramString1, paramString2));
    }
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (!this.d) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("moduleName", paramString1);
    localHippyMap.pushString("methodName", paramString2);
    localHippyMap.pushObject("params", paramObject);
    paramString1 = this.e.obtainMessage(12, 0, 6, localHippyMap);
    this.e.sendMessage(paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, HippyArray paramHippyArray)
  {
    if (this.d)
    {
      Object localObject = this.a;
      if ((localObject != null) && (((HippyEngineContext)localObject).getModuleManager() != null))
      {
        localObject = this.a.getModuleManager();
        if (localObject != null) {
          ((HippyModuleManager)localObject).callNatives(c.a(paramString1, paramString2, paramString3, paramHippyArray));
        }
      }
    }
  }
  
  String b()
  {
    Object localObject3 = this.a.getGlobalConfigs().getContext();
    if ((!j) && (localObject3 == null)) {
      throw new AssertionError();
    }
    HippyMap localHippyMap1 = new HippyMap();
    Object localObject1 = DimensionsUtil.getDimensions(-1, -1, (Context)localObject3, false);
    if ((this.a.getGlobalConfigs() != null) && (this.a.getGlobalConfigs().getDeviceAdapter() != null)) {
      this.a.getGlobalConfigs().getDeviceAdapter().reviseDimensionIfNeed((Context)localObject3, (HippyMap)localObject1, false, false);
    }
    localHippyMap1.pushMap("Dimensions", (HippyMap)localObject1);
    HippyMap localHippyMap2 = new HippyMap();
    localObject1 = this.o;
    String str = "";
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((HippyThirdPartyAdapter)localObject1).getPackageName();
      localObject6 = this.o.getAppVersion();
      localObject5 = this.o.getPageUrl();
      localHippyMap2.pushJSONObject(this.o.getExtraData());
    }
    else
    {
      localObject1 = "";
      localObject6 = localObject1;
      localObject5 = localObject6;
    }
    Object localObject7 = localObject1;
    Object localObject2;
    try
    {
      PackageInfo localPackageInfo = ((Context)localObject3).getPackageManager().getPackageInfo(((Context)localObject3).getPackageName(), 0);
      localObject4 = localObject1;
      localObject7 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject7 = localObject1;
        localObject4 = localPackageInfo.packageName;
      }
      localObject7 = localObject4;
      localObject1 = localObject4;
      localObject3 = localObject6;
      if (TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject7 = localObject4;
        localObject3 = localPackageInfo.versionName;
        localObject1 = localObject4;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject3 = localObject6;
      localObject2 = localObject7;
    }
    Object localObject6 = new HippyMap();
    ((HippyMap)localObject6).pushString("OS", "android");
    if (localObject2 == null) {
      localObject4 = "";
    } else {
      localObject4 = localObject2;
    }
    ((HippyMap)localObject6).pushString("PackageName", (String)localObject4);
    if (localObject3 == null) {
      localObject4 = "";
    } else {
      localObject4 = localObject3;
    }
    ((HippyMap)localObject6).pushString("VersionName", (String)localObject4);
    ((HippyMap)localObject6).pushInt("APILevel", Build.VERSION.SDK_INT);
    ((HippyMap)localObject6).pushBoolean("NightMode", c());
    localHippyMap1.pushMap("Platform", (HippyMap)localObject6);
    localObject6 = new HippyMap();
    Object localObject4 = localObject5;
    if (localObject5 == null) {
      localObject4 = "";
    }
    ((HippyMap)localObject6).pushString("url", (String)localObject4);
    localObject4 = localObject2;
    if (localObject2 == null) {
      localObject4 = "";
    }
    ((HippyMap)localObject6).pushString("appName", (String)localObject4);
    if (localObject3 == null) {
      localObject3 = str;
    }
    ((HippyMap)localObject6).pushString("appVersion", (String)localObject3);
    ((HippyMap)localObject6).pushMap("extra", localHippyMap2);
    localHippyMap1.pushMap("tkd", (HippyMap)localObject6);
    return ArgumentUtils.objectToJson(localHippyMap1);
  }
  
  public void b(int paramInt)
  {
    if (!this.d) {
      return;
    }
    Message localMessage = this.e.obtainMessage(12, 0, 3, Integer.valueOf(paramInt));
    this.e.sendMessage(localMessage);
  }
  
  public void b(Callback<Boolean> paramCallback)
  {
    if ((!j) && (this.e == null)) {
      throw new AssertionError();
    }
    Handler localHandler = this.e;
    if (localHandler == null) {
      return;
    }
    paramCallback = localHandler.obtainMessage(13, paramCallback);
    this.e.sendMessage(paramCallback);
  }
  
  public void c(int paramInt)
  {
    if (!this.d) {
      return;
    }
    Message localMessage = this.e.obtainMessage(12, 0, 4, Integer.valueOf(paramInt));
    this.e.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 13: 
        if (this.o != null) {
          this.o.onRuntimeDestroy();
        }
        paramMessage = (Callback)paramMessage.obj;
        this.c.destroy(new b.4(this, this.e, paramMessage));
        return true;
      }
    }
    catch (Throwable paramMessage)
    {
      int i1;
      Object localObject1;
      label354:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleMessage: ");
      ((StringBuilder)localObject2).append(paramMessage.getMessage());
      LogUtils.d("HippyBridgeManagerImpl", ((StringBuilder)localObject2).toString());
      return false;
    }
    if (!this.d) {
      return true;
    }
    i1 = paramMessage.arg2;
    switch (i1)
    {
    default: 
      localObject1 = null;
      break;
    case 6: 
      localObject1 = "callJsModule";
      break;
    case 1: 
      if ((paramMessage.obj instanceof HippyMap))
      {
        i1 = ((HippyMap)paramMessage.obj).getInt("id");
        localObject1 = this.a.getInstance(i1);
        if ((localObject1 != null) && (((HippyRootView)localObject1).getTimeMonitor() != null))
        {
          ((HippyRootView)localObject1).getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RUN_BUNDLE);
          break label830;
          this.k.setLength(0);
          Object localObject3 = ArgumentUtils.objectToJsonOpt(paramMessage.obj, this.k);
          if (TextUtils.equals((CharSequence)localObject1, "loadInstance"))
          {
            this.c.callFunction((String)localObject1, (String)localObject3, new b.3(this, this.e, Message.obtain(paramMessage), (String)localObject1));
            return true;
          }
          this.c.callFunction((String)localObject1, (String)localObject3, null);
          return true;
          if (paramMessage.arg2 <= 0) {
            break label838;
          }
          localObject3 = this.a.getInstance(paramMessage.arg2);
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            if (((HippyRootView)localObject3).getTimeMonitor() != null)
            {
              ((HippyRootView)localObject3).getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_LOAD_BUNDLE);
              localObject1 = localObject3;
            }
          }
          paramMessage = (HippyBundleLoader)paramMessage.obj;
          if (!this.d)
          {
            paramMessage = HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("load module error. HippyBridge mIsInit:");
            ((StringBuilder)localObject1).append(this.d);
            a(paramMessage, ((StringBuilder)localObject1).toString(), null);
            return true;
          }
          if (paramMessage == null)
          {
            localObject1 = HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("load module error. loader:");
            ((StringBuilder)localObject3).append(paramMessage);
            a((HippyEngine.ModuleLoadStatus)localObject1, ((StringBuilder)localObject3).toString(), null);
            return true;
          }
          localObject3 = paramMessage.getBundleUniKey();
          if ((paramMessage != null) && (this.h != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (this.h.contains(localObject3)))
          {
            paramMessage = HippyEngine.ModuleLoadStatus.STATUS_REPEAT_LOAD;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("repeat load module. loader.getBundleUniKey=");
            localStringBuilder.append((String)localObject3);
            a(paramMessage, localStringBuilder.toString(), (HippyRootView)localObject1);
            return true;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (this.h == null) {
              this.h = new ArrayList();
            }
            this.h.add(localObject3);
            paramMessage.load(this.c, new b.2(this, this.e, (HippyRootView)localObject1));
            return true;
          }
          a(HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL, "can not load module. loader.getBundleUniKey=null", null);
          return true;
          this.a.getStartTimeMonitor().startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_INIT_BRIDGE);
          paramMessage = (Callback)paramMessage.obj;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.a;
        if (this.f != 2) {
          break label844;
        }
        bool1 = true;
        if (this.g) {
          break label849;
        }
        bool2 = true;
        this.c = new HippyBridgeImpl((HippyEngineContext)localObject1, this, bool1, bool2, this.l, this.m);
        this.c.initJSBridge(b(), new b.1(this, this.e, paramMessage), this.n);
        return true;
      }
      catch (Throwable localThrowable)
      {
        this.d = false;
        paramMessage.callback(Boolean.valueOf(false), localThrowable);
        return true;
      }
      return false;
      Object localObject2 = "callBack";
      break;
      localObject2 = "destroyInstance";
      break;
      localObject2 = "pauseInstance";
      break;
      localObject2 = "resumeInstance";
      break;
      label830:
      localObject2 = "loadInstance";
      break;
      label838:
      localObject2 = null;
      break label354;
      label844:
      boolean bool1 = false;
      continue;
      label849:
      boolean bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b
 * JD-Core Version:    0.7.0.1
 */