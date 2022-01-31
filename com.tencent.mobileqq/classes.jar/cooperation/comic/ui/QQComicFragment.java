package cooperation.comic.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import beft;
import beho;
import bimq;
import bino;
import binr;
import bins;
import bint;
import biod;
import biof;
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
  private bino a;
  
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
        bimq.c = ((URL)localObject2).getPath().substring(((URL)localObject2).getPath().lastIndexOf("/") + 1);
        bimq.a = i + "";
        if ((TextUtils.isEmpty(bimq.a)) || ("NULL".equalsIgnoreCase(bimq.a))) {
          QLog.e("WebLog_WebViewFragment", 1, "[webFragment] from is null");
        }
        for (;;)
        {
          bimq.b = paramIntent.getStringExtra("reportActionFrom");
          bimq.a();
          return localObject1;
          localObject1 = new QQComicFragment();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "[webFragment] from is " + bimq.a);
          }
        }
        return localObject1;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  public beho a()
  {
    return new beho(this, 127, new bint(this));
  }
  
  public bino a()
  {
    if (this.jdField_a_of_type_Bino != null) {
      return this.jdField_a_of_type_Bino;
    }
    if ((getWebView() != null) && (getWebView().getPluginEngine() != null))
    {
      WebViewPlugin localWebViewPlugin = getWebView().getPluginEngine().a("comic");
      if ((localWebViewPlugin instanceof bino))
      {
        this.jdField_a_of_type_Bino = ((bino)localWebViewPlugin);
        return this.jdField_a_of_type_Bino;
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
    if (biof.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "QQComicPluginBridge sFirstInObservable is not null ");
      biof.a.a(paramWebView.getContext());
    }
    biof.b(new bins(this, paramWebView));
  }
  
  public String[] a()
  {
    String[] arrayOfString = new String[4];
    Object localObject = a();
    if ((localObject != null) && (((bino)localObject).jdField_a_of_type_Binr != null))
    {
      localObject = ((bino)localObject).jdField_a_of_type_Binr.a();
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
    bino localbino = a();
    JSONObject localJSONObject1;
    if (localbino != null)
    {
      localbino = (bino)localbino;
      localJSONObject1 = new JSONObject();
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", localbino.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      localJSONObject1.put("data", localJSONObject2);
      label52:
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "notifySecretModeChange. status=" + localbino.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      if (!TextUtils.isEmpty(localbino.b)) {
        getWebView().callJs(localbino.b, new String[] { localJSONObject1.toString() });
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
    if (((paramView == this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_Beft.d)) && (this.jdField_a_of_type_Beft.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Beft.d(false);
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
    bimq.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    bimq.a(a());
  }
  
  public void onStop()
  {
    super.onStop();
    bino localbino = a();
    if (localbino != null) {
      localbino.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment
 * JD-Core Version:    0.7.0.1
 */