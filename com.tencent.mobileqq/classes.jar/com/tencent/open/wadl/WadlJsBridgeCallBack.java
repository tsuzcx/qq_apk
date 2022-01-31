package com.tencent.open.wadl;

import aljs;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.smtt.sdk.WebView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlProxyServiceCallBackInterface;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class WadlJsBridgeCallBack
  implements WadlProxyServiceCallBackInterface
{
  public static String a;
  protected final int a;
  protected long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IJsCallBack jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlJsBridgeCallBack";
  }
  
  public WadlJsBridgeCallBack(boolean paramBoolean, IJsCallBack paramIJsCallBack)
  {
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack = paramIJsCallBack;
  }
  
  private void a()
  {
    if ((System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L) || (this.jdField_b_of_type_Boolean))
    {
      localObject = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put(WadlJsBridgeUtil.a((WadlResult)localIterator.next()));
      }
      localObject = ((JSONArray)localObject).toString();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack.getJsCallbackMethod())) {
        break label137;
      }
    }
    label137:
    for (Object localObject = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + (String)localObject + ");}void(0);";; localObject = "javascript:" + this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack.getJsCallbackMethod() + "(" + (String)localObject + ")")
    {
      b((String)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    WadlProxyServiceUtil.a().c(0, paramString);
  }
  
  private void b(String paramString)
  {
    WLog.b(jdField_a_of_type_JavaLangString, "doJsCallBack loadJs=" + paramString);
    try
    {
      WebView localWebView = this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack.getWebview();
      if (localWebView != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new aljs(this, localWebView, paramString));
      }
      return;
    }
    catch (Exception paramString)
    {
      WLog.a(jdField_a_of_type_JavaLangString, "doJsCallback exception", paramString);
    }
  }
  
  private void c(WadlResult paramWadlResult)
  {
    if (paramWadlResult != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WadlResult localWadlResult = (WadlResult)localIterator.next();
        if ((localWadlResult.a != null) && (paramWadlResult.a != null) && (TextUtils.equals(localWadlResult.a.jdField_a_of_type_JavaLangString, paramWadlResult.a.jdField_a_of_type_JavaLangString))) {
          localWadlResult.d = paramWadlResult.d;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramWadlResult);
      }
      if (paramWadlResult.d == 100) {
        this.jdField_b_of_type_Boolean = true;
      }
      return;
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WadlResult localWadlResult = (WadlResult)localIterator.next();
        if ((localWadlResult.a != null) && (TextUtils.equals(localWadlResult.a.jdField_a_of_type_JavaLangString, paramString))) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void a(WadlResult paramWadlResult)
  {
    if ((paramWadlResult != null) && (this.jdField_a_of_type_Boolean))
    {
      paramWadlResult = WadlJsBridgeUtil.a(paramWadlResult).toString();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack.getJsCallbackMethod())) {
        break label65;
      }
    }
    label65:
    for (paramWadlResult = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + paramWadlResult + ");}void(0);";; paramWadlResult = "javascript:" + this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack.getJsCallbackMethod() + "(" + paramWadlResult + ")")
    {
      b(paramWadlResult);
      return;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        ToastUtil.a().a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      WLog.a(jdField_a_of_type_JavaLangString, "showToast>>>", paramString);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    WLog.b(jdField_a_of_type_JavaLangString, "onQueryCallback params:" + paramArrayList);
    JSONArray localJSONArray;
    if (paramArrayList != null) {
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(WadlJsBridgeUtil.a((WadlResult)paramArrayList.next()));
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        WLog.a(jdField_a_of_type_JavaLangString, "onQueryCallback exception:" + paramArrayList.getMessage());
      }
    }
    b("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + "1" + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public void b(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null))
    {
      WLog.a(jdField_a_of_type_JavaLangString, "onWadlTaskStatusChanged error wadlResult is null");
      return;
    }
    WLog.b(jdField_a_of_type_JavaLangString, "onWadlTaskStatusChanged:" + paramWadlResult);
    WadlParams localWadlParams = paramWadlResult.a;
    String str = localWadlParams.jdField_a_of_type_JavaLangString;
    int i = WadlJsBridgeUtil.a(paramWadlResult.b);
    WadlJsBridgeCall.b(localWadlParams.jdField_a_of_type_JavaLangString);
    switch (i)
    {
    default: 
      WLog.a(jdField_a_of_type_JavaLangString, "download status not response!");
      return;
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 10: 
    case 13: 
    case 20: 
      c(str);
      a(paramWadlResult);
      return;
    case -2: 
      c(str);
      a(paramWadlResult);
      i = WadlJsBridgeUtil.b(paramWadlResult.c);
      paramWadlResult = WadlJsBridgeUtil.a(i);
      if (!TextUtils.isEmpty(paramWadlResult)) {
        a(paramWadlResult);
      }
      a(str, i);
      return;
    }
    c(paramWadlResult);
    a();
  }
  
  public void b(ArrayList paramArrayList)
  {
    WLog.b(jdField_a_of_type_JavaLangString, "onQueryCallbackVia params:" + paramArrayList);
    JSONArray localJSONArray;
    if (paramArrayList != null) {
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(WadlJsBridgeUtil.a((WadlResult)paramArrayList.next()));
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        WLog.a(jdField_a_of_type_JavaLangString, "onQueryCallbackVia exception:" + paramArrayList.getMessage());
      }
    }
    b("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadActionByVia',{\"guid\": " + "1" + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack
 * JD-Core Version:    0.7.0.1
 */