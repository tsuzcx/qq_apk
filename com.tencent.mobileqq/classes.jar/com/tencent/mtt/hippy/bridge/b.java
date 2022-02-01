package com.tencent.mtt.hippy.bridge;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngine.ModuleListener;
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
  private StringBuilder j;
  private boolean k = false;
  private String l;
  private int m;
  private HippyThirdPartyAdapter n;
  
  public b(HippyEngineContext paramHippyEngineContext, HippyBundleLoader paramHippyBundleLoader, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2, HippyThirdPartyAdapter paramHippyThirdPartyAdapter)
  {
    this.a = paramHippyEngineContext;
    this.b = paramHippyBundleLoader;
    this.f = paramInt1;
    this.g = paramBoolean1;
    this.k = paramBoolean2;
    this.l = paramString;
    this.m = paramInt2;
    this.n = paramHippyThirdPartyAdapter;
    this.j = new StringBuilder(1024);
  }
  
  private void a(int paramInt, String paramString, HippyRootView paramHippyRootView)
  {
    if (UIThreadUtils.isOnUiThread())
    {
      if (this.i != null) {
        this.i.onInitialized(paramInt, paramString, paramHippyRootView);
      }
      return;
    }
    UIThreadUtils.runOnUiThread(new b.5(this, paramInt, paramString, paramHippyRootView));
  }
  
  public void a()
  {
    this.d = false;
    this.i = null;
    if (this.e != null)
    {
      this.e.removeMessages(10);
      this.e.removeMessages(11);
      this.e.removeMessages(12);
      this.e.sendEmptyMessage(13);
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
      a(-150, "load module error. HippyBridge not initialized", paramHippyRootView);
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
      if ((this.i != null) && (this.i.onJsException(paramHippyJsException))) {
        this.i = null;
      }
      return;
    }
    UIThreadUtils.runOnUiThread(new b.4(this, paramHippyJsException));
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
    if (this.a != null) {
      this.a.handleException(new HippyJsException(paramString1, paramString2));
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
    if ((this.d) && (this.a != null) && (this.a.getModuleManager() != null))
    {
      HippyModuleManager localHippyModuleManager = this.a.getModuleManager();
      if (localHippyModuleManager != null) {
        localHippyModuleManager.callNatives(c.a(paramString1, paramString2, paramString3, paramHippyArray));
      }
    }
  }
  
  String b()
  {
    HippyMap localHippyMap1 = new HippyMap();
    HippyMap localHippyMap3 = DimensionsUtil.getDimensions(-1, -1, this.a.getGlobalConfigs().getContext(), false);
    Object localObject = "";
    String str1 = "";
    String str2 = "";
    HippyMap localHippyMap2 = new HippyMap();
    if ((this.a.getGlobalConfigs() != null) && (this.a.getGlobalConfigs().getDeviceAdapter() != null)) {
      this.a.getGlobalConfigs().getDeviceAdapter().reviseDimensionIfNeed(this.a.getGlobalConfigs().getContext(), localHippyMap3, false, false);
    }
    localHippyMap1.pushMap("Dimensions", localHippyMap3);
    if (this.n != null)
    {
      localObject = this.n.getPackageName();
      str1 = this.n.getPageUrl();
      str2 = this.n.getAppVersion();
      localHippyMap2.pushJSONObject(this.n.getExtraData());
    }
    localHippyMap3 = new HippyMap();
    localHippyMap3.pushString("OS", "android");
    localHippyMap3.pushString("PackageName", (String)localObject);
    localHippyMap3.pushInt("APILevel", Build.VERSION.SDK_INT);
    localHippyMap1.pushMap("Platform", localHippyMap3);
    localHippyMap3 = new HippyMap();
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    localHippyMap3.pushString("url", (String)localObject);
    localHippyMap3.pushString("appVersion", str2);
    localHippyMap3.pushMap("extra", localHippyMap2);
    localHippyMap1.pushMap("tkd", localHippyMap3);
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
    Context localContext = null;
    Object localObject;
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 10: 
          this.a.getStartTimeMonitor().startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_INIT_BRIDGE);
          paramMessage = (Callback)paramMessage.obj;
          try
          {
            localContext = this.a.getGlobalConfigs().getContext();
            if (this.f != 2) {
              continue;
            }
            bool1 = true;
            if (this.g) {
              continue;
            }
            bool2 = true;
            this.c = new HippyBridgeImpl(localContext, this, bool1, bool2, this.k, this.l);
            this.c.initJSBridge(b(), new b.1(this, this.e, paramMessage), this.m);
          }
          catch (Throwable localThrowable)
          {
            boolean bool1;
            boolean bool2;
            this.d = false;
            paramMessage.callback(Boolean.valueOf(false), localThrowable);
            continue;
          }
          return true;
        }
      }
      catch (Throwable paramMessage)
      {
        String str;
        continue;
        continue;
      }
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      if (paramMessage.arg2 > 0)
      {
        localObject = this.a.getInstance(paramMessage.arg2);
        if ((localObject == null) || (((HippyRootView)localObject).getTimeMonitor() == null)) {
          continue;
        }
        ((HippyRootView)localObject).getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_LOAD_BUNDLE);
        continue;
        paramMessage = (HippyBundleLoader)paramMessage.obj;
        if ((!this.d) || (paramMessage == null))
        {
          a(-150, "load module error. HippyBridge mIsInit:" + this.d + ", loader:" + paramMessage, null);
          return true;
        }
        str = paramMessage.getBundleUniKey();
        if ((paramMessage != null) && (this.h != null) && (!TextUtils.isEmpty(str)) && (this.h.contains(str)))
        {
          a(-700, "repeat load module. loader.getBundleUniKey=" + str, (HippyRootView)localObject);
          return true;
        }
        if (!TextUtils.isEmpty(str))
        {
          if (this.h == null) {
            this.h = new ArrayList();
          }
          this.h.add(str);
          paramMessage.load(this.c, new b.2(this, this.e, (HippyRootView)localObject));
          break label668;
        }
        a(-500, "can not load module. loader.getBundleUniKey=null", null);
        break label668;
        if (!this.d) {
          return true;
        }
        switch (paramMessage.arg2)
        {
        }
      }
    }
    for (;;)
    {
      this.j.setLength(0);
      str = ArgumentUtils.objectToJsonOpt(paramMessage.obj, this.j);
      if (TextUtils.equals((CharSequence)localObject, "loadInstance"))
      {
        this.c.callFunction((String)localObject, str, new b.3(this, this.e, Message.obtain(paramMessage), (String)localObject));
        break label673;
        if (!(paramMessage.obj instanceof HippyMap)) {
          break label675;
        }
        int i1 = ((HippyMap)paramMessage.obj).getInt("id");
        localObject = this.a.getInstance(i1);
        if ((localObject == null) || (((HippyRootView)localObject).getTimeMonitor() == null)) {
          break label675;
        }
        ((HippyRootView)localObject).getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RUN_BUNDLE);
        break label675;
      }
      else
      {
        this.c.callFunction((String)localObject, str, null);
        break label673;
        this.c.destroy(null);
        return true;
        localObject = null;
        break;
        return false;
        label668:
        return true;
        continue;
      }
      label673:
      return true;
      label675:
      localObject = "loadInstance";
      continue;
      localObject = "resumeInstance";
      continue;
      localObject = "pauseInstance";
      continue;
      localObject = "destroyInstance";
      continue;
      localObject = "callBack";
      continue;
      localObject = "callJsModule";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b
 * JD-Core Version:    0.7.0.1
 */