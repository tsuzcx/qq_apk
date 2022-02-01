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
  private static volatile ReadInJoyWebRenderEngine jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderEngine;
  private static final LRULinkedHashMap<String, ReadInJoyWebRenderEngine.RenderHtmlData> jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static volatile boolean jdField_a_of_type_Boolean = false;
  public static int b;
  private static final LRULinkedHashMap<String, ReadInJoyWebRenderEngine.RenderHtmlData> jdField_b_of_type_ComTencentUtilLRULinkedHashMap;
  public static int c;
  public static int d;
  public static int e;
  private static boolean jdField_e_of_type_Boolean;
  public static int f;
  public static int g = 5;
  protected int a;
  private long jdField_a_of_type_Long;
  protected final ReadInJoyWebRenderStateMachineScheduler a;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(4);
    jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(4);
    jdField_e_of_type_Boolean = false;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = 2;
    jdField_e_of_type_Int = 3;
    jdField_f_of_type_Int = 4;
  }
  
  public ReadInJoyWebRenderEngine()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderStateMachineScheduler = new ReadInJoyWebRenderStateMachineScheduler(new ReadInJoyWebRenderEngine.1(this));
  }
  
  public static ReadInJoyWebRenderEngine.RenderHtmlData a(String paramString)
  {
    boolean bool = AppSetting.g;
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
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = (ReadInJoyWebRenderEngine.RenderHtmlData)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
        if (localObject1 != null)
        {
          if (!((ReadInJoyWebRenderEngine.RenderHtmlData)localObject1).a()) {
            break label136;
          }
          paramString = localRenderHtmlData;
          return paramString;
        }
        localRenderHtmlData = (ReadInJoyWebRenderEngine.RenderHtmlData)jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
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
  
  public static ReadInJoyWebRenderEngine a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderEngine == null) {
      jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderEngine = new ReadInJoyWebRenderEngine();
    }
    return jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyWebRenderEngine;
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
      if (jdField_a_of_type_Boolean)
      {
        if (paramLoadLibCallback != null) {
          paramLoadLibCallback.onFinish(g);
        }
        return;
      }
      ViolaSDKManager.getInstance().postOnThreadPool(new ReadInJoyWebRenderEngine.3(paramLoadLibCallback, paramString));
      return;
    }
    finally {}
  }
  
  public static void b()
  {
    if (!ReadInJoyHelper.t(ReadInJoyUtils.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [getWebRenderConfig], is:", Boolean.valueOf(false) });
      }
    }
    else if (!jdField_a_of_type_Boolean) {
      a("preload");
    } else if (QLog.isColorLevel()) {
      QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [sLoadEngineLibDone], is:", Boolean.valueOf(true) });
    }
    if (ViolaAccessHelper.a()) {
      ViolaAccessHelper.a();
    }
  }
  
  public static boolean b()
  {
    File localFile = new File(ReadInjoyWebRenderSoLoader.a(), "libviola.so");
    if ((jdField_a_of_type_Boolean) && (localFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(true) });
      }
      return true;
    }
    RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, 2);
    a("other ");
    if (QLog.isColorLevel()) {
      QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(false) });
    }
    return false;
  }
  
  public static void c() {}
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public int a(Bundle paramBundle)
  {
    RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, 9);
    this.jdField_a_of_type_Int = 11;
    return -1;
  }
  
  public void a()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null)
    {
      localViolaInstance.destroy();
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = null;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b(Bundle paramBundle)
  {
    Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("_prenr");
    if ((!this.jdField_d_of_type_Boolean) && (a(this.jdField_a_of_type_JavaLangString) != null))
    {
      this.jdField_a_of_type_Int = 10;
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 1, "native_render doCreateLoopStep_Check has url cache");
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 4;
    }
    return 0;
  }
  
  @Deprecated
  public int c(Bundle paramBundle)
  {
    return 0;
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
    Object localObject = this.jdField_a_of_type_JavaLangString.replace("_pbid", "_bid");
    if (SwiftOfflineDataUtils.a((String)localObject))
    {
      localObject = SwiftOfflineDataUtils.a((String)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject).jdField_b_of_type_JavaLangString))) {
        this.jdField_e_of_type_JavaLangString = ((SwiftOfflineDataUtils.OfflineData)localObject).jdField_b_of_type_JavaLangString;
      }
    }
    else
    {
      localObject = HtmlOffline.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (localObject == null) {}
    }
    try
    {
      int i = ((HtmlOffline.MyWebResourceResponse)localObject).a.available();
      if (i == 0) {
        break label122;
      }
      byte[] arrayOfByte = new byte[i];
      if (i != ((HtmlOffline.MyWebResourceResponse)localObject).a.read(arrayOfByte)) {
        break label122;
      }
      this.jdField_e_of_type_JavaLangString = new String(arrayOfByte, "utf-8");
    }
    catch (IOException localIOException)
    {
      label116:
      break label116;
    }
    return a(paramBundle);
    label122:
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_GetHtml mHtmlOffline is empty");
      }
      RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, 7);
      return a(paramBundle);
    }
    this.jdField_a_of_type_Int = 8;
    return 0;
  }
  
  public int h(Bundle paramBundle)
  {
    this.jdField_f_of_type_JavaLangString = "true;";
    Object localObject1 = "<!--native-render-->";
    String str2 = "<!--native-data-render-->";
    String str1 = "renderData";
    Object localObject2 = localObject1;
    String str3 = str2;
    String str4 = str1;
    if (paramBundle != null)
    {
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.jdField_a_of_type_JavaLangString))) {
        localObject1 = paramBundle.getString(WebRenderAdapter.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.jdField_e_of_type_JavaLangString))) {
        str1 = paramBundle.getString(WebRenderAdapter.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.jdField_c_of_type_JavaLangString))) {
        str2 = paramBundle.getString(WebRenderAdapter.jdField_c_of_type_JavaLangString);
      }
      localObject2 = localObject1;
      str3 = str2;
      str4 = str1;
      if (!TextUtils.isEmpty(paramBundle.getString(WebRenderAdapter.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_f_of_type_JavaLangString = paramBundle.getString(WebRenderAdapter.jdField_d_of_type_JavaLangString);
        str4 = str1;
        str3 = str2;
        localObject2 = localObject1;
      }
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.replaceFirst(localObject2, this.jdField_d_of_type_JavaLangString);
    paramBundle = this.jdField_e_of_type_JavaLangString;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("var ");
    ((StringBuilder)localObject1).append(str4);
    ((StringBuilder)localObject1).append(" = ");
    ((StringBuilder)localObject1).append(this.jdField_f_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(";");
    this.jdField_e_of_type_JavaLangString = paramBundle.replaceFirst(str3, ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_Int = 9;
    return 0;
  }
  
  public int i(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      if (this.jdField_c_of_type_Boolean) {
        jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new ReadInJoyWebRenderEngine.RenderHtmlData(this.jdField_e_of_type_JavaLangString, "utf-8", 1800000L));
      } else {
        jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(this.jdField_a_of_type_JavaLangString, new ReadInJoyWebRenderEngine.RenderHtmlData(this.jdField_e_of_type_JavaLangString, "utf-8"));
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("native_render one result total cost[");
      paramBundle.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      paramBundle.append(" ms]");
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, paramBundle.toString());
    }
    RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, 8);
    RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, 12, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    d();
    a();
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
  
  public int j(Bundle paramBundle)
  {
    RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, 3);
    d();
    a();
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
  
  public int k(Bundle paramBundle)
  {
    d();
    a();
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine
 * JD-Core Version:    0.7.0.1
 */