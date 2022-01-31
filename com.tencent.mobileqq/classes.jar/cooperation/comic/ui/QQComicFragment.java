package cooperation.comic.ui;

import amjy;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicHelper;
import cooperation.comic.jsp.QQComicJsPlugin;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class QQComicFragment
  extends WebViewFragment
{
  public static WebViewFragment b(Intent paramIntent)
  {
    localQQComicFragment = new QQComicFragment();
    Object localObject = new Bundle();
    ((Bundle)localObject).putParcelable("intent", paramIntent);
    localQQComicFragment.setArguments((Bundle)localObject);
    int i = paramIntent.getIntExtra("reportSourceFrom", 0);
    if (i != 0)
    {
      localObject = paramIntent.getStringExtra("url");
      try
      {
        localObject = new URL((String)localObject);
        VipComicHelper.c = ((URL)localObject).getPath().substring(((URL)localObject).getPath().lastIndexOf("/") + 1);
        VipComicHelper.a = i + "";
        if ((TextUtils.isEmpty(VipComicHelper.a)) || ("NULL".equalsIgnoreCase(VipComicHelper.a))) {
          QLog.e("WebLog_WebViewFragment", 1, "[webFragment] from is null");
        }
        for (;;)
        {
          VipComicHelper.b = paramIntent.getStringExtra("reportActionFrom");
          VipComicHelper.a();
          return localQQComicFragment;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "[webFragment] from is " + VipComicHelper.a);
          }
        }
        return localQQComicFragment;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return new SwiftBrowserComponentsProvider(this, 127, new amjy(this));
  }
  
  public QQComicJsPlugin a()
  {
    if ((a() != null) && (a().a() != null))
    {
      WebViewPlugin localWebViewPlugin = a().a().a("comic");
      if ((localWebViewPlugin instanceof QQComicJsPlugin)) {
        return (QQComicJsPlugin)localWebViewPlugin;
      }
    }
    return null;
  }
  
  public String a()
  {
    return "VipComic";
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
    QQComicJsPlugin localQQComicJsPlugin = a();
    JSONObject localJSONObject1;
    if (localQQComicJsPlugin != null)
    {
      localQQComicJsPlugin = (QQComicJsPlugin)localQQComicJsPlugin;
      localJSONObject1 = new JSONObject();
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", localQQComicJsPlugin.a.get());
      localJSONObject1.put("data", localJSONObject2);
      label52:
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "notifySecretModeChange. status=" + localQQComicJsPlugin.a.get());
      }
      if (!TextUtils.isEmpty(localQQComicJsPlugin.b)) {
        a().a(localQQComicJsPlugin.b, new String[] { localJSONObject1.toString() });
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
    if (((paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c(false);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("private_read_red_dot", true).apply();
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
    VipComicHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment
 * JD-Core Version:    0.7.0.1
 */