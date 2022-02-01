package cooperation.qqreader.ui;

import abgu;
import admy;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import binq;
import bipn;
import biqq;
import birj;
import blhq;
import bmpr;
import bmrb;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ReaderContentPageFragment
  extends ReaderBaseFragment
  implements Handler.Callback
{
  private blhq jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    ReaderContentPageFragment localReaderContentPageFragment = new ReaderContentPageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localReaderContentPageFragment.setArguments(localBundle);
    return localReaderContentPageFragment;
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      if (!paramList.contains("menuItem:openWithQQBrowser")) {
        paramList.add("menuItem:openWithQQBrowser");
      }
      if (!paramList.contains("menuItem:openWithSafari")) {
        paramList.add("menuItem:openWithSafari");
      }
      if (!paramList.contains("menuItem:favorite")) {
        paramList.add("menuItem:favorite");
      }
      if (!paramList.contains("menuItem:screenLongShotShare")) {
        paramList.add("menuItem:screenLongShotShare");
      }
    } while (paramList.contains("menuItem:exposeArticle"));
    paramList.add("menuItem:exposeArticle");
  }
  
  private void b()
  {
    if (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.mSwiftTitleUI.c != null) {
      this.mSwiftTitleUI.c.setVisibility(8);
    }
    if (this.webView != null)
    {
      this.webView.goBack();
      this.webView.invalidate();
    }
  }
  
  private void c()
  {
    abgu localabgu = ensureShare();
    localabgu.a(bmrb.a(localabgu.a()));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.webView != null) {
        this.webView.stopLoading();
      }
    }
    do
    {
      return;
      if ((this.webView != null) && (this.webView.canGoBack()))
      {
        b();
        return;
      }
    } while (a());
    super.getActivity().finish();
  }
  
  public void a(ImageView paramImageView, TextView paramTextView, String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      paramTextView.setTypeface(Typeface.DEFAULT_BOLD);
      paramTextView.bringToFront();
      paramImageView.setImageResource(0);
      paramImageView.setBackgroundColor(0);
      paramImageView.setVisibility(8);
    }
    int i;
    if (paramString3 != null)
    {
      i = j;
      if (paramString3.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(paramString3);
      paramImageView.setBackgroundColor(i);
      if (paramString1 != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
        return;
      }
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (Exception paramTextView)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void a(ImageView paramImageView, TextView paramTextView, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (paramInt == 0) {
      a(paramImageView, paramTextView, paramString1, paramString2, paramString3);
    }
    for (;;)
    {
      if (paramBoolean) {
        paramImageView.setVisibility(8);
      }
      return;
      paramTextView.setVisibility(8);
      paramImageView.setVisibility(0);
      switch (paramInt)
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      default: 
        paramImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          paramImageView.setContentDescription(paramString2);
        }
        if (paramString1 == null) {
          break label193;
        }
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
        break;
        paramImageView.setImageResource(2130843831);
        continue;
        paramImageView.setImageResource(2130843830);
        continue;
        paramImageView.setImageResource(2130840291);
        continue;
        paramImageView.setImageResource(2130846955);
        continue;
        paramImageView.setImageResource(2130846965);
        continue;
        paramImageView.setImageResource(2130838911);
      }
      label193:
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public int doCreateLoopStep_InitTitleBar(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitTitleBar(paramBundle);
    paramBundle = getActivity();
    if ((paramBundle instanceof ReaderBaseWebActivity))
    {
      paramBundle = ((ReaderBaseWebActivity)paramBundle).a(this.webView);
      if ((paramBundle != null) && (this.mSwiftTitleUI.c != null)) {
        paramBundle.a(this.mSwiftTitleUI.c);
      }
    }
    return i;
  }
  
  public void doOnBackEvent() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public void initWebView()
  {
    a(this.jdField_a_of_type_Blhq);
    super.initWebView();
    if (this.intent != null)
    {
      Bundle localBundle = this.intent.getBundleExtra("theme");
      if (localBundle != null) {
        this.webView.setBackgroundColor(localBundle.getInt("readerBgColor", -1));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.mSwiftTitleUI.c)) {
      if ((this.webView != null) && (this.jdField_a_of_type_JavaLangString != null)) {
        this.webView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView) {
        a();
      } else {
        super.onClick(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.intent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Blhq.removeCallbacksAndMessages(null);
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, admy paramadmy)
  {
    if ((this.mSwiftTitleUI != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.mSwiftTitleUI.c != null)) {
      a(this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView, this.mSwiftTitleUI.c, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramOnClickListener);
    }
  }
  
  public boolean setShareUrl(String paramString)
  {
    return false;
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return false;
  }
  
  public void showActionSheet()
  {
    biqq localbiqq = (biqq)this.mComponentsProvider.a(4);
    if (localbiqq != null)
    {
      c();
      a(localbiqq.a);
      localbiqq.a(ensureShare(), this.mUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageFragment
 * JD-Core Version:    0.7.0.1
 */