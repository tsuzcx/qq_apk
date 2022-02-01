package cooperation.qqreader.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bktq;
import bkty;
import bkvg;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqreader.host.webview.ReaderWebView;
import java.util.HashMap;
import java.util.Map;

public abstract class ReaderBaseFragment
  extends WebViewFragment
{
  protected Handler a;
  private ImageView a;
  protected boolean a;
  protected boolean b;
  
  private void b()
  {
    if (this.mUIStyleHandler.mLoadingProgressBar != null) {
      this.mUIStyleHandler.mLoadingProgressBar.setVisibility(8);
    }
  }
  
  private void c()
  {
    ViewGroup localViewGroup = (ViewGroup)this.webView.getParent().getParent();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView, 0, localLayoutParams);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.webView != null) {
        this.webView.stopLoading();
      }
      return;
    }
    doOnBackEvent();
  }
  
  protected void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  protected boolean a()
  {
    if (this.webView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.webView.getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
        return localWebViewPluginEngine.a(this.webView.getUrl(), 8589934601L, localHashMap);
      }
    }
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (((Boolean)paramMessage.obj).booleanValue())
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        c();
      }
      bktq.a().a(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView, 600L);
    }
    for (;;)
    {
      return true;
      bktq.a().a();
    }
  }
  
  public TouchWebView createCustomWebView()
  {
    return new ReaderWebView(getActivity());
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    b();
    return i;
  }
  
  public void doOnBackEvent()
  {
    if (!a()) {
      super.getActivity().finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (this.intent != null) {
      this.intent.putExtra("key_is_init_sonic_session", false);
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    super.doOnKeyDown(paramInt, paramKeyEvent);
    if (paramInt == 4) {
      a();
    }
  }
  
  public String getUAMark()
  {
    return "QQReader";
  }
  
  public void initWebView()
  {
    super.initWebView();
    Object localObject = getActivity();
    if ((localObject instanceof ReaderBaseWebActivity))
    {
      localObject = ((ReaderBaseWebActivity)localObject).a(this.webView);
      if ((localObject != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        ((bkty)localObject).a(this.jdField_a_of_type_AndroidOsHandler);
      }
    }
    this.webView.getView().setVerticalScrollBarEnabled(false);
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    super.onDetectedBlankScreen(paramString, paramInt);
    bkvg.b(getActivity(), paramInt, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.jdField_a_of_type_Boolean = false;
    bktq.a().a();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    b();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      c();
    }
    bktq.a().a(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    bktq.a().a();
  }
  
  public boolean showPreview()
  {
    this.b = true;
    this.mUIStyleHandler.canWebViewOverScroll = false;
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseFragment
 * JD-Core Version:    0.7.0.1
 */