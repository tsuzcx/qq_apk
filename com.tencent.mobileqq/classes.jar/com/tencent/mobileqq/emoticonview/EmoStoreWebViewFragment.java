package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.IndividuationUrlHelper.UrlCallback;
import com.tencent.mobileqq.webview.swift.IWebViewFragmentInitor;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import mqq.os.MqqHandler;

public class EmoStoreWebViewFragment
  extends WebViewFragment
  implements IEmoStoreWebViewFragment, IndividuationUrlHelper.UrlCallback, IWebViewFragmentInitor
{
  public static final String BUNDLE_KEY_INTENT = "intent";
  
  private boolean checkURLIsEmoStore()
  {
    String str = EmoticonStoreTabEntryUtils.processEmoStoreHomeUrl(IndividuationUrlHelper.a(getQBaseActivity(), "emoji", "", this));
    return EmoticonStoreTabEntryUtils.checkURLIsEmoStore(this.mUrl, str);
  }
  
  private void initTitleButton()
  {
    if (checkURLIsEmoStore())
    {
      getSwiftTitleUI().o.setBackgroundDrawable(new ColorDrawable(-1));
      getSwiftTitleUI().d(-16777216);
      getSwiftTitleUI().d.setTextColor(-16777216);
      getWebTitleBarInterface().a("my_emoji_clk", "", "black", false, 18, 0, new EmoStoreWebViewFragment.2(this), null);
    }
  }
  
  public static EmoStoreWebViewFragment newInstance(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new EmoStoreWebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  public void doOnEmoStorePageFinshed(Activity paramActivity)
  {
    if ((checkURLIsEmoStore()) && (paramActivity != null)) {
      paramActivity.overridePendingTransition(2130772014, 2130772018);
    }
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new EmoStoreWebViewFragment.1(this, this.webViewSurface);
  }
  
  public WebViewFragment newInstance(int paramInt, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    return newInstance(paramIntent);
  }
  
  public void reportEmoStorePageCloseClickEvent()
  {
    if (checkURLIsEmoStore()) {
      ReportController.a(null, "dc00898", "", "", "0X800B8C7", "0X800B8C7", 0, 0, "", "", "", "");
    }
  }
  
  public void update()
  {
    if (!isDestroyed()) {
      ThreadManager.getUIHandler().post(new EmoStoreWebViewFragment.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment
 * JD-Core Version:    0.7.0.1
 */