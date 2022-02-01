package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import cooperation.comic.ui.QQComicFragment;
import cooperation.qqreader.ui.ReaderCommentPageFragment;
import cooperation.qqreader.ui.ReaderContentPageFragment;
import cooperation.qqreader.ui.ReaderHomeTabFragment;
import cooperation.qqreader.utils.Log;
import cooperation.qzone.QzoneTranslucentBrowserFragment;

public class WebViewFragmentBuilder
{
  public static WebViewFragment a(SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramWebViewTabBarData.url);
    int i = paramIntent.getIntExtra("fragmentStyle", 0);
    if (i == 2) {
      return QzoneTranslucentBrowserFragment.newInstance(paramIntent);
    }
    if (i == 1) {
      return QQComicFragment.a(paramIntent);
    }
    if (i == 3)
    {
      if (paramWebViewTabBarData.url.contains("signatureEdit=1")) {
        return SignatureEditFragment.a(paramIntent);
      }
      paramIntent.removeExtra("isTransparentTitle");
      if (paramSwiftWebViewFragmentSupporter != null) {
        return paramSwiftWebViewFragmentSupporter.createFragment(paramIntent);
      }
      return WebViewFragment.newInstance(paramIntent);
    }
    if (i == 4)
    {
      i = paramIntent.getIntExtra("item_type", 1);
      if ((i == 1) && (TextUtils.isDigitsOnly(paramWebViewTabBarData.tag)))
      {
        paramIntent.putExtra("key_tab_id", Integer.valueOf(paramWebViewTabBarData.tag));
        Log.d("WebViewFragmentBuilder", "tab_id =" + paramWebViewTabBarData.tag);
        return ReaderHomeTabFragment.a(paramIntent);
      }
      if (i == 4) {
        return ReaderCommentPageFragment.a(paramIntent);
      }
      return ReaderContentPageFragment.a(paramIntent);
    }
    if (i == 5) {
      return EmoStoreWebViewFragment.newInstance(paramIntent);
    }
    paramWebViewTabBarData = Uri.parse(paramWebViewTabBarData.url);
    if ((paramWebViewTabBarData.isHierarchical()) && ("4".equals(paramWebViewTabBarData.getQueryParameter("_webviewtype"))))
    {
      paramIntent.putExtra("fragmentStyle", 1);
      paramIntent.putExtra("tabBarStyle", 1);
      paramIntent.putExtra("titleBarStyle", 1);
      paramIntent.putExtra("hide_operation_bar", true);
      paramIntent.putExtra("hide_more_button", true);
      paramIntent.putExtra("isScreenOrientationPortrait", true);
      return QQComicFragment.a(paramIntent);
    }
    if (paramSwiftWebViewFragmentSupporter != null) {
      return paramSwiftWebViewFragmentSupporter.createFragment(paramIntent);
    }
    return WebViewFragment.newInstance(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder
 * JD-Core Version:    0.7.0.1
 */