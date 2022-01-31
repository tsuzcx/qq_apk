package cooperation.comic.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import bebk;
import bedf;
import biij;
import bijh;
import bijk;
import bijl;
import bijm;
import bijw;
import bijy;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.comic.webbundle.WebBundleFragment;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class QQComicFragment
  extends WebViewFragment
{
  private bijh a;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    if (Boolean.valueOf(paramIntent.getBooleanExtra("openWithWebBundle", false)).booleanValue()) {
      localObject1 = new WebBundleFragment();
    }
    for (;;)
    {
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelable("intent", paramIntent);
      ((WebViewFragment)localObject1).setArguments((Bundle)localObject2);
      int i = paramIntent.getIntExtra("reportSourceFrom", 0);
      if (i != 0) {
        localObject2 = paramIntent.getStringExtra("url");
      }
      try
      {
        localObject2 = new URL((String)localObject2);
        biij.c = ((URL)localObject2).getPath().substring(((URL)localObject2).getPath().lastIndexOf("/") + 1);
        biij.a = i + "";
        if ((TextUtils.isEmpty(biij.a)) || ("NULL".equalsIgnoreCase(biij.a))) {
          QLog.e("WebLog_WebViewFragment", 1, "[webFragment] from is null");
        }
        for (;;)
        {
          biij.b = paramIntent.getStringExtra("reportActionFrom");
          biij.a();
          return localObject1;
          localObject1 = new QQComicFragment();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "[webFragment] from is " + biij.a);
          }
        }
        return localObject1;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  public bedf a()
  {
    return new bedf(this, 127, new bijm(this));
  }
  
  public bijh a()
  {
    if (this.jdField_a_of_type_Bijh != null) {
      return this.jdField_a_of_type_Bijh;
    }
    if ((getWebView() != null) && (getWebView().getPluginEngine() != null))
    {
      WebViewPlugin localWebViewPlugin = getWebView().getPluginEngine().a("comic");
      if ((localWebViewPlugin instanceof bijh))
      {
        this.jdField_a_of_type_Bijh = ((bijh)localWebViewPlugin);
        return this.jdField_a_of_type_Bijh;
      }
    }
    return null;
  }
  
  public String a()
  {
    return "VipComic";
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    QLog.d("WebLog_WebViewFragment", 4, "QQComicFragment onPageFinished ");
    if (bijy.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "QQComicPluginBridge sFirstInObservable is not null ");
      bijy.a.a(paramWebView.getContext());
    }
    bijy.b(new bijl(this, paramWebView));
  }
  
  public String[] a()
  {
    String[] arrayOfString = new String[4];
    Object localObject = a();
    if ((localObject != null) && (((bijh)localObject).jdField_a_of_type_Bijk != null))
    {
      localObject = ((bijh)localObject).jdField_a_of_type_Bijk.a();
      if (localObject != null)
      {
        arrayOfString[0] = ((String)((HashMap)localObject).get("page_id"));
        arrayOfString[1] = ((String)((HashMap)localObject).get("ret_id"));
        arrayOfString[2] = ((String)((HashMap)localObject).get("ext2"));
      }
    }
    return arrayOfString;
  }
  
  public boolean g()
  {
    bijh localbijh = a();
    JSONObject localJSONObject1;
    if (localbijh != null)
    {
      localbijh = (bijh)localbijh;
      localJSONObject1 = new JSONObject();
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", localbijh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      localJSONObject1.put("data", localJSONObject2);
      label52:
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "notifySecretModeChange. status=" + localbijh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      if (!TextUtils.isEmpty(localbijh.b)) {
        getWebView().callJs(localbijh.b, new String[] { localJSONObject1.toString() });
      }
      return true;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public void onClick(View paramView)
  {
    if (((paramView == this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_Bebk.d)) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Bebk.d(false);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getSharedPreferences("boodo_" + this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("private_read_red_dot", true).apply();
      }
    }
    super.onClick(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
    biij.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    biij.a(a());
  }
  
  public void onStop()
  {
    super.onStop();
    bijh localbijh = a();
    if (localbijh != null) {
      localbijh.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment
 * JD-Core Version:    0.7.0.1
 */