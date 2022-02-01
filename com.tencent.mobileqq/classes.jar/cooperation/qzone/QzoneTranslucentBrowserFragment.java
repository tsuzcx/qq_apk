package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bmvr;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.smtt.sdk.WebView;

public class QzoneTranslucentBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private boolean a = true;
  
  private int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static QzoneTranslucentBrowserFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new QzoneTranslucentBrowserFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout != null) && (getHostActivity() != null))
    {
      ImageView localImageView = new ImageView(getHostActivity());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = a(11.5F);
      localLayoutParams.rightMargin = a(15.0F);
      localLayoutParams.addRule(11);
      paramRelativeLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageDrawable(getResources().getDrawable(2130848596));
      localImageView.setOnClickListener(new bmvr(this));
    }
  }
  
  public void activityFinish()
  {
    super.activityFinish();
    if (getHostActivity() != null) {
      getHostActivity().setResult(-1);
    }
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    if (this.mUIStyleHandler != null) {
      this.mUIStyleHandler.d = true;
    }
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    if (this.intent != null)
    {
      int j = this.intent.getIntExtra("CONTENT_BACKGROUND_COLOR", 0);
      this.contentView.setBackgroundColor(j);
      this.a = this.intent.getBooleanExtra("show_close_btn", true);
    }
    return i;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (this.a) {
      a(this.contentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */