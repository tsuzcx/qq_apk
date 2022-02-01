package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.HtmlOffline.MyWebResourceResponse;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.adapter.WebRenderAdapter;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ReadInJoyWebRenderEngine
{
  public static int c = 0;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public static int g = 4;
  public static int h = 5;
  private static volatile boolean i = false;
  private static volatile ReadInJoyWebRenderEngine s;
  private static final Object t = new Object();
  private static final LRULinkedHashMap<String, ReadInJoyWebRenderEngine.RenderHtmlData> u = new LRULinkedHashMap(4);
  private static final LRULinkedHashMap<String, ReadInJoyWebRenderEngine.RenderHtmlData> v = new LRULinkedHashMap(4);
  private static boolean x = false;
  protected int a = 1;
  protected final ReadInJoyWebRenderStateMachineScheduler b = new ReadInJoyWebRenderStateMachineScheduler(new ReadInJoyWebRenderEngine.1(this));
  private boolean j = true;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private boolean q = false;
  private boolean r = false;
  private long w;
  private ViolaInstance y;
  
  public static ReadInJoyWebRenderEngine a()
  {
    if (s == null) {
      s = new ReadInJoyWebRenderEngine();
    }
    return s;
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "[notifyLibLoad], ret:", Integer.valueOf(paramInt) });
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      a(paramString, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, LoadLibCallback paramLoadLibCallback)
  {
    try
    {
      if (i)
      {
        if (paramLoadLibCallback != null) {
          paramLoadLibCallback.onFinish(h);
        }
        return;
      }
      ViolaSDKManager.getInstance().postOnThreadPool(new ReadInJoyWebRenderEngine.3(paramLoadLibCallback, paramString));
      return;
    }
    finally {}
  }
  
  public static ReadInJoyWebRenderEngine.RenderHtmlData b(String paramString)
  {
    boolean bool = AppSetting.h;
    ReadInJoyWebRenderEngine.RenderHtmlData localRenderHtmlData = null;
    Object localObject1;
    if (!bool)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("native_render  getRenderHtmlData url : ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("viola.ReadInJoyWebRenderEngine", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      synchronized (t)
      {
        localObject1 = (ReadInJoyWebRenderEngine.RenderHtmlData)u.get(paramString);
        if (localObject1 != null)
        {
          if (!((ReadInJoyWebRenderEngine.RenderHtmlData)localObject1).a()) {
            break label136;
          }
          paramString = localRenderHtmlData;
          return paramString;
        }
        localRenderHtmlData = (ReadInJoyWebRenderEngine.RenderHtmlData)v.get(paramString);
        if (localRenderHtmlData == null) {
          break label141;
        }
        paramString = localRenderHtmlData;
        if (localRenderHtmlData.a()) {
          break label141;
        }
        return paramString;
      }
      return null;
      label136:
      paramString = (String)localObject1;
      continue;
      label141:
      paramString = null;
    }
  }
  
  public static void d()
  {
    if (!ReadInJoyHelper.V(ReadInJoyUtils.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [getWebRenderConfig], is:", Boolean.valueOf(false) });
      }
    }
    else if (!i) {
      a("preload");
    } else if (QLog.isColorLevel()) {
      QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [sLoadEngineLibDone], is:", Boolean.valueOf(true) });
    }
    if (ViolaAccessHelper.b()) {
      ViolaAccessHelper.a();
    }
  }
  
  public static void e() {}
  
  public static boolean f()
  {
    File localFile = new File(ReadInjoyWebRenderSoLoader.a(), "libviola.so");
    if ((i) && (localFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(true) });
      }
      return true;
    }
    RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, 2);
    a("other ");
    if (QLog.isColorLevel()) {
      QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(false) });
    }
    return false;
  }
  
  private void h()
  {
    this.k = "";
    this.o = "";
    this.p = "";
    this.n = "";
    this.m = "";
  }
  
  public int a(Bundle paramBundle)
  {
    RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, 9);
    this.a = 11;
    return -1;
  }
  
  public int b(Bundle paramBundle)
  {
    Uri.parse(this.k).getQueryParameter("_prenr");
    if ((!this.r) && (b(this.k) != null))
    {
      this.a = 10;
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 1, "native_render doCreateLoopStep_Check has url cache");
      }
    }
    else
    {
      this.a = 4;
    }
    return 0;
  }
  
  public void b()
  {
    ViolaInstance localViolaInstance = this.y;
    if (localViolaInstance != null)
    {
      localViolaInstance.destroy();
      this.y = null;
    }
    this.j = true;
  }
  
  @Deprecated
  public int c(Bundle paramBundle)
  {
    return 0;
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  @Deprecated
  public int d(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int e(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int f(Bundle paramBundle)
  {
    return 0;
  }
  
  public int g(Bundle paramBundle)
  {
    Object localObject = this.k.replace("_pbid", "_bid");
    if (SwiftOfflineDataUtils.a((String)localObject))
    {
      localObject = SwiftOfflineDataUtils.b((String)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject).b))) {
        this.o = ((SwiftOfflineDataUtils.OfflineData)localObject).b;
      }
    }
    else
    {
      localObject = HtmlOffline.b(this.l, this.k);
      if (localObject == null) {}
    }
    try
    {
      int i1 = ((HtmlOffline.MyWebResourceResponse)localObject).b.available();
      if (i1 == 0) {
        break label122;
      }
      byte[] arrayOfByte = new byte[i1];
      if (i1 != ((HtmlOffline.MyWebResourceResponse)localObject).b.read(arrayOfByte)) {
        break label122;
      }
      this.o = new String(arrayOfByte, "utf-8");
    }
    catch (IOException localIOException)
    {
      label116:
      break label116;
    }
    return a(paramBundle);
    label122:
    if (TextUtils.isEmpty(this.o))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_GetHtml mHtmlOffline is empty");
      }
      RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, 7);
      return a(paramBundle);
    }
    this.a = 8;
    return 0;
  }
  
  public int h(Bundle paramBundle)
  {
    this.p = "true;";
    Object localObject1 = "<!--native-render-->";
    String str2 = "<!--native-data-render-->";
    String str1 = "renderData";
    Object localObject2 = localObject1;
    String str3 = str2;
    String str4 = str1;
    if (paramBundle != null)
    {
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.a))) {
        localObject1 = paramBundle.getString(WebRenderAdapter.a);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.e))) {
        str1 = paramBundle.getString(WebRenderAdapter.e);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.c))) {
        str2 = paramBundle.getString(WebRenderAdapter.c);
      }
      localObject2 = localObject1;
      str3 = str2;
      str4 = str1;
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.d)))
      {
        this.p = paramBundle.getString(WebRenderAdapter.d);
        str4 = str1;
        str3 = str2;
        localObject2 = localObject1;
      }
    }
    this.o = this.o.replaceFirst(localObject2, this.n);
    paramBundle = this.o;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("var ");
    ((StringBuilder)localObject1).append(str4);
    ((StringBuilder)localObject1).append(" = ");
    ((StringBuilder)localObject1).append(this.p);
    ((StringBuilder)localObject1).append(";");
    this.o = paramBundle.replaceFirst(str3, ((StringBuilder)localObject1).toString());
    this.a = 9;
    return 0;
  }
  
  public int i(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(this.o)) {
      if (this.q) {
        v.put(this.k, new ReadInJoyWebRenderEngine.RenderHtmlData(this.o, "utf-8", 1800000L));
      } else {
        u.put(this.k, new ReadInJoyWebRenderEngine.RenderHtmlData(this.o, "utf-8"));
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("native_render one result total cost[");
      paramBundle.append(System.currentTimeMillis() - this.w);
      paramBundle.append(" ms]");
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, paramBundle.toString());
    }
    RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, 8);
    RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, 12, System.currentTimeMillis() - this.w);
    h();
    b();
    this.a = 1;
    return -1;
  }
  
  public int j(Bundle paramBundle)
  {
    RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, 3);
    h();
    b();
    this.a = 1;
    return -1;
  }
  
  public int k(Bundle paramBundle)
  {
    h();
    b();
    this.a = 1;
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine
 * JD-Core Version:    0.7.0.1
 */