package cooperation.qqcircle.hybird;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bieo;
import biur;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostGlobalInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.utils.QCircleCommonUtil;

public class QCircleHybirdFragment
  extends WebViewFragment
{
  private static final String TAG = QCircleHybirdFragment.class.getSimpleName();
  private QCircleHybirdFragment.QCircleHybirdBroadcastReceiver mReceiver;
  
  private void initPicTextTitleBarView()
  {
    this.mSwiftTitleUI.titleContainer.setBackgroundColor(-1);
    this.mSwiftTitleUI.rightViewImg.setImageResource(2130840366);
    this.mSwiftTitleUI.leftView.setBackgroundResource(2130840360);
    this.mSwiftTitleUI.rightViewImg.setVisibility(0);
  }
  
  private void registerDaTongReport()
  {
    VideoReport.addToDetectionWhitelist(getHostActivity());
    VideoReport.setPageId(getView(), "small_world_base");
    VideoReport.setPageParams(getView(), new QCircleDTParamBuilder().setPageSubclass(TAG).buildPageParams());
    QLog.i(TAG, 1, "reportDaTongRegister  subPage: " + TAG);
  }
  
  private void setWebViewBackground()
  {
    if (((this.mUIStyle.mRulesFromUrl & 0x80000) == 0L) || (getWebView().getX5WebViewExtension() != null)) {}
    for (;;)
    {
      try
      {
        getWebView().getView().setBackgroundColor(0);
        getWebView().setBackgroundColor(0);
        if (this.contentView != null) {
          this.contentView.setBackgroundColor(0);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      getWebView().setBackgroundColor(0);
    }
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    getWebView().getSettings().setDefaultTextEncodingName("utf-8");
    getWebView().getSettings().setUserAgentString(getWebView().getSettings().getUserAgentString() + " QQ_APP_Subscribe");
    if (NetworkUtil.isNetworkAvailable(getActivity())) {
      getWebView().getSettings().setCacheMode(2);
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.mProgressBarController != null)) {
      this.mUIStyleHandler.mProgressBarController.a(false);
    }
    if (!this.mUIStyle.isTransparentTitleAndClickable) {
      QCircleCommonUtil.setDefaultStatusBarColor(getActivity());
    }
    if (getActivity() != null)
    {
      this.mReceiver = new QCircleHybirdFragment.QCircleHybirdBroadcastReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_update_web_user_follow_state");
      paramBundle.addAction("action_update_web_tag_follow_state");
      getActivity().registerReceiver(this.mReceiver, paramBundle);
    }
    return i;
  }
  
  public int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    this.mUIStyleHandler.mUIStyle.mIsDisableRefreshView = false;
    this.mUIStyleHandler.mUIStyle.needHideBottomBar = true;
    this.mUIStyleHandler.mBrowserWebviewColor = QCircleCommonUtil.getDefaultThemeColor(false);
    registerDaTongReport();
    return super.doCreateLoopStep_InitData(paramBundle);
  }
  
  @TargetApi(11)
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    setWebViewBackground();
    return super.doCreateLoopStep_InitUIContent(paramBundle);
  }
  
  public void doOnBackEvent()
  {
    super.doOnBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.mReceiver != null)) {
      getActivity().unregisterReceiver(this.mReceiver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void refreshReturnPage()
  {
    if (getHostActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_refresh_return_page");
      if (getHostActivity() != null) {
        getHostActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void reloadFeedList(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_refresh_feed_list");
    localIntent.putExtra("pageType", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void reloadMainPage(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void sendNativeAuthInfoUpdateBroadcast(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_auth_info");
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("status", paramInt2);
    localIntent.putExtra("tagName", paramString);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void sendNativeTagFollowUpdateBroadcast(String paramString, int paramInt)
  {
    paramString = new Intent();
    paramString.setAction("action_update_native_tag_follow_state");
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(paramString);
    }
    reloadMainPage(QCircleHostGlobalInfo.getCurrentLoginAccount());
  }
  
  public void sendNativeUserFollowUpdateBroadcast(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_update_native_user_follow_state");
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("nick", paramString2);
    localIntent.putExtra("type", paramInt1);
    localIntent.putExtra("isDoubly", paramInt2);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
  
  public void sendReadMessageBroadcast(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_clear_message_red_poiont");
    localIntent.putExtra("createTime", paramInt);
    if (getHostActivity() != null) {
      getHostActivity().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hybird.QCircleHybirdFragment
 * JD-Core Version:    0.7.0.1
 */