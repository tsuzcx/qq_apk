package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.WebView;

public class EmoStoreWebViewFragment
  extends WebViewFragment
{
  public static final String BUNDLE_KEY_INTENT = "intent";
  
  private boolean checkURLIsEmoStore()
  {
    String str = EmoticonStoreTabEntryUtils.processEmoStoreHomeUrl(IndividuationUrlHelper.a(getActivity(), "emoji", ""));
    return EmoticonStoreTabEntryUtils.checkURLIsEmoStore(this.mUrl, str);
  }
  
  private void initTitleButton(WebBrowserViewContainer paramWebBrowserViewContainer)
  {
    if (checkURLIsEmoStore())
    {
      this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(new ColorDrawable(-1));
      this.mSwiftTitleUI.d(-16777216);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      setRightButton("my_emoji_clk", "", "black", false, 18, 0, new EmoStoreWebViewFragment.1(this), null);
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
  
  public int doCreateLoopStep_InitTitleBar(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitTitleBar(paramBundle);
    initTitleButton(this.contentView);
    return i;
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    return super.doCreateLoopStep_InitUIContent(paramBundle);
  }
  
  public void doOnEmoStorePageFinshed(Activity paramActivity)
  {
    if ((checkURLIsEmoStore()) && (paramActivity != null)) {
      paramActivity.overridePendingTransition(2130771999, 2130772003);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void reportEmoStorePageCloseClickEvent()
  {
    if (checkURLIsEmoStore()) {
      ReportController.a(null, "dc00898", "", "", "0X800B8C7", "0X800B8C7", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment
 * JD-Core Version:    0.7.0.1
 */