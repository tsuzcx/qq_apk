package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.comic.ui.QQComicFragment;
import com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneTranslucentBrowserFragment;
import java.util.HashMap;

public class WebViewFragmentBuilder
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_web_fragment_map.yml", version=3)
  public static final HashMap<String, Class<? extends IWebViewFragmentInitor>> a = new HashMap();
  
  static
  {
    a.put("7", com.tencent.mobileqq.qqlive.verified.FaceVerifyWebFragment.class);
    a.put("5", com.tencent.mobileqq.nearby.verify.FaceVerifyWebFragment.class);
    a.put("4", EmoStoreWebViewFragment.class);
    a.put("3", SignatureEditFragment.class);
    a.put("2", QzoneTranslucentBrowserFragment.class);
    a.put("1", QQComicFragment.class);
  }
  
  private static WebViewFragment a(int paramInt, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentBuilder", 2, new Object[] { "createFragmentByStyle style=", Integer.valueOf(paramInt) });
    }
    Object localObject = String.valueOf(paramInt);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (a.containsKey(localObject)))
    {
      localObject = (Class)a.get(localObject);
      try
      {
        paramSwiftWebViewFragmentSupporter = ((IWebViewFragmentInitor)((Class)localObject).newInstance()).newInstance(paramInt, paramSwiftWebViewFragmentSupporter, paramWebViewTabBarData, paramIntent);
        return paramSwiftWebViewFragmentSupporter;
      }
      catch (Throwable paramSwiftWebViewFragmentSupporter)
      {
        QLog.e("WebViewFragmentBuilder", 1, "createWebViewFragment By nameSpace Fail,", paramSwiftWebViewFragmentSupporter);
      }
    }
    return null;
  }
  
  public static WebViewFragment a(SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramWebViewTabBarData.url);
    Object localObject = a(paramIntent.getIntExtra("fragmentStyle", 0), paramSwiftWebViewFragmentSupporter, paramWebViewTabBarData, paramIntent);
    if (localObject != null) {
      return localObject;
    }
    localObject = Uri.parse(paramWebViewTabBarData.url);
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentBuilder", 2, new Object[] { "createWebViewFragment uri=", localObject });
    }
    if ((((Uri)localObject).isHierarchical()) && ("4".equals(((Uri)localObject).getQueryParameter("_webviewtype"))))
    {
      paramIntent.putExtra("fragmentStyle", 1);
      paramIntent.putExtra("tabBarStyle", 1);
      paramIntent.putExtra("titleBarStyle", 1);
      paramIntent.putExtra("hide_operation_bar", true);
      paramIntent.putExtra("hide_more_button", true);
      paramIntent.putExtra("isScreenOrientationPortrait", true);
      return a(1, paramSwiftWebViewFragmentSupporter, paramWebViewTabBarData, paramIntent);
    }
    SwiftWebViewUtils.a(paramIntent);
    paramWebViewTabBarData = b(paramSwiftWebViewFragmentSupporter, paramWebViewTabBarData, paramIntent);
    if (paramWebViewTabBarData != null) {
      return paramWebViewTabBarData;
    }
    if (paramSwiftWebViewFragmentSupporter != null) {
      return paramSwiftWebViewFragmentSupporter.createFragment(paramIntent);
    }
    return WebViewFragment.newInstance(paramIntent);
  }
  
  private static WebViewFragment b(SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    if (paramWebViewTabBarData.url.contains("https://ida.webank.com/api/web/login")) {
      return a(5, paramSwiftWebViewFragmentSupporter, paramWebViewTabBarData, paramIntent);
    }
    if (paramWebViewTabBarData.url.equals("https://qlive.qq.com/pages/name-auth.html")) {
      return a(7, paramSwiftWebViewFragmentSupporter, paramWebViewTabBarData, paramIntent);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder
 * JD-Core Version:    0.7.0.1
 */