package com.tencent.open.wadl;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class WadlJsBridgeResCallback
  implements WadlResCallBack
{
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  IJsCallBack jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack;
  String jdField_a_of_type_JavaLangString = null;
  
  public WadlJsBridgeResCallback(IJsCallBack paramIJsCallBack)
  {
    this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack = paramIJsCallBack;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void b(String paramString)
  {
    WLog.c("WadlJsBridgeResCallback", "doJsCallBack loadJs=" + paramString);
    try
    {
      WebView localWebView = this.jdField_a_of_type_ComTencentOpenBusinessBaseIJsCallBack.getWebview();
      if (localWebView != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new WadlJsBridgeResCallback.1(this, localWebView, paramString));
      }
      return;
    }
    catch (Exception paramString)
    {
      WLog.a("WadlJsBridgeResCallback", "doJsCallback exception", paramString);
    }
  }
  
  public void a(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null))
    {
      WLog.a("WadlJsBridgeResCallback", "onWadlResStatusChanged error wadlResult is null");
      return;
    }
    int i = WadlJsBridgeUtil.a(paramWadlResult.b);
    WLog.c("WadlJsBridgeResCallback", "onWadlResStatusChanged:" + paramWadlResult + ",localStatus:" + i);
    switch (i)
    {
    default: 
      WLog.a("WadlJsBridgeResCallback", "download status not response!");
      return;
    }
    paramWadlResult = WadlJsBridgeUtil.b(paramWadlResult).toString();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (paramWadlResult = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadResProcess'," + paramWadlResult + ");}void(0);";; paramWadlResult = "javascript:" + this.jdField_a_of_type_JavaLangString + "(" + paramWadlResult + ")")
    {
      b(paramWadlResult);
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    WLog.c("WadlJsBridgeResCallback", "onQueryResCallback params:" + paramArrayList);
    JSONArray localJSONArray;
    if (paramArrayList != null) {
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(WadlJsBridgeUtil.b((WadlResult)paramArrayList.next()));
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        WLog.a("WadlJsBridgeResCallback", "onQueryCallback exception:" + paramArrayList.getMessage());
      }
    }
    b("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.queryAllDownloadRes',{\"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeResCallback
 * JD-Core Version:    0.7.0.1
 */