package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bfrw;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.smtt.sdk.WebView;

public class QzoneTranslucentBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
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
    if ((paramRelativeLayout != null) && (a() != null))
    {
      ImageView localImageView = new ImageView(a());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = a(11.5F);
      localLayoutParams.rightMargin = a(15.0F);
      localLayoutParams.addRule(11);
      paramRelativeLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageDrawable(getResources().getDrawable(2130847414));
      localImageView.setOnClickListener(new bfrw(this));
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
  }
  
  public int d(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bbcj != null) {
      this.jdField_a_of_type_Bbcj.d = true;
    }
    int i = super.d(paramBundle);
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("CONTENT_BACKGROUND_COLOR", 0);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setBackgroundColor(j);
    }
    return i;
  }
  
  public void d()
  {
    super.d();
    if (a() != null) {
      a().setResult(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */