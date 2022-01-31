package cooperation.comic.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import bazb;
import bbaq;
import bezd;
import bfab;
import bfaf;
import bfag;
import bfaq;
import bfas;
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
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class QQComicFragment
  extends WebViewFragment
{
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
        bezd.c = ((URL)localObject2).getPath().substring(((URL)localObject2).getPath().lastIndexOf("/") + 1);
        bezd.a = i + "";
        if ((TextUtils.isEmpty(bezd.a)) || ("NULL".equalsIgnoreCase(bezd.a))) {
          QLog.e("WebLog_WebViewFragment", 1, "[webFragment] from is null");
        }
        for (;;)
        {
          bezd.b = paramIntent.getStringExtra("reportActionFrom");
          bezd.a();
          return localObject1;
          localObject1 = new QQComicFragment();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "[webFragment] from is " + bezd.a);
          }
        }
        return localObject1;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  public bbaq a()
  {
    return new bbaq(this, 127, new bfag(this));
  }
  
  public bfab a()
  {
    if ((getWebView() != null) && (getWebView().getPluginEngine() != null))
    {
      WebViewPlugin localWebViewPlugin = getWebView().getPluginEngine().a("comic");
      if ((localWebViewPlugin instanceof bfab)) {
        return (bfab)localWebViewPlugin;
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
    if (bfas.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "QQComicPluginBridge sFirstInObservable is not null ");
      bfas.a.a(paramWebView.getContext());
    }
    bfas.b(new bfaf(this, paramWebView));
  }
  
  public String[] a(String paramString)
  {
    String[] arrayOfString = new String[4];
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return arrayOfString;
      try
      {
        paramString = Uri.parse(paramString);
        if ((paramString != null) && (paramString.isHierarchical()))
        {
          arrayOfString[0] = paramString.getQueryParameter("shareType");
          arrayOfString[1] = paramString.getQueryParameter("comicid");
          return arrayOfString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return arrayOfString;
  }
  
  public boolean g()
  {
    bfab localbfab = a();
    JSONObject localJSONObject1;
    if (localbfab != null)
    {
      localbfab = (bfab)localbfab;
      localJSONObject1 = new JSONObject();
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", localbfab.a.get());
      localJSONObject1.put("data", localJSONObject2);
      label52:
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "notifySecretModeChange. status=" + localbfab.a.get());
      }
      if (!TextUtils.isEmpty(localbfab.b)) {
        getWebView().callJs(localbfab.b, new String[] { localJSONObject1.toString() });
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
    if (((paramView == this.jdField_a_of_type_Bazb.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_Bazb.d)) && (this.jdField_a_of_type_Bazb.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Bazb.d(false);
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
    bezd.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    bezd.a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment
 * JD-Core Version:    0.7.0.1
 */