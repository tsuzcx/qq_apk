package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.IWebViewFragmentInitor;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

public class QzoneTranslucentBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
  implements IWebViewFragmentInitor
{
  public static final String BUNDLE_KEY_INTENT = "intent";
  public static final String CONTENT_BACKGROUND_COLOR = "CONTENT_BACKGROUND_COLOR";
  public static final String KEY_SHOW_CLOSE_BTN = "show_close_btn";
  private boolean mIsShowCloseBtn = true;
  
  private int dpToPx(float paramFloat)
  {
    return (int)(paramFloat * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void initCloseButton(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout != null) && (getHostActivity() != null))
    {
      ImageView localImageView = new ImageView(getHostActivity());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = dpToPx(11.5F);
      localLayoutParams.rightMargin = dpToPx(15.0F);
      localLayoutParams.addRule(11);
      paramRelativeLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageDrawable(getResources().getDrawable(2130848859));
      localImageView.setOnClickListener(new QzoneTranslucentBrowserFragment.2(this));
    }
  }
  
  public static QzoneTranslucentBrowserFragment newInstance(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new QzoneTranslucentBrowserFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  public void activityFinish()
  {
    super.activityFinish();
    if (getHostActivity() != null) {
      getHostActivity().setResult(-1);
    }
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QzoneTranslucentBrowserFragment.1(this, this.webViewSurface);
  }
  
  public WebViewFragment newInstance(int paramInt, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    return newInstance(paramIntent);
  }
  
  public void onInitUIContent(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    if (getUIStyleHandler() != null) {
      getUIStyleHandler().d = true;
    }
    super.onInitUIContent(paramBundle, paramWebViewKernelCallBack);
    if (this.intent != null)
    {
      int i = this.intent.getIntExtra("CONTENT_BACKGROUND_COLOR", 0);
      this.contentView.setBackgroundColor(i);
      this.mIsShowCloseBtn = this.intent.getBooleanExtra("show_close_btn", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */