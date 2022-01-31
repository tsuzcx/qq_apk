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
import bbcj;
import bflu;
import bfmb;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
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
  
  private void j()
  {
    if (this.jdField_a_of_type_Bbcj.a != null) {
      this.jdField_a_of_type_Bbcj.a.setVisibility(8);
    }
  }
  
  private void k()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent().getParent();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView, 0, localLayoutParams);
  }
  
  public TouchWebView a()
  {
    return new ReaderWebView(getActivity());
  }
  
  public String a()
  {
    return "QQReader";
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    super.a(paramInt, paramKeyEvent);
    if (paramInt == 4) {
      i();
    }
  }
  
  protected void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    bflu.a().a();
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.jdField_a_of_type_Boolean = false;
    bflu.a().a();
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    j();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      k();
    }
    bflu.a().a(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public boolean a()
  {
    this.b = true;
    this.jdField_a_of_type_Bbcj.b = false;
    return super.a();
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_is_init_sonic_session", false);
    }
    return super.a(paramBundle);
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
        k();
      }
      bflu.a().a(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView, 600L);
    }
    for (;;)
    {
      return true;
      bflu.a().a();
    }
  }
  
  public int d(Bundle paramBundle)
  {
    int i = super.d(paramBundle);
    j();
    return i;
  }
  
  public void e()
  {
    super.e();
    Object localObject = getActivity();
    if ((localObject instanceof ReaderBaseWebActivity))
    {
      localObject = ((ReaderBaseWebActivity)localObject).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      if ((localObject != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        ((bfmb)localObject).a(this.jdField_a_of_type_AndroidOsHandler);
      }
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setVerticalScrollBarEnabled(false);
  }
  
  public void f()
  {
    if (!g()) {
      super.getActivity().finish();
    }
  }
  
  protected boolean g()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
        return localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934601L, localHashMap);
      }
    }
    return false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      }
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseFragment
 * JD-Core Version:    0.7.0.1
 */