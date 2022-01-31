package cooperation.qzone.webviewwrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import andz;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.build.IWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import java.util.ArrayList;

public class QzoneWebViewBaseBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public static final WebAccelerateHelper.CommonJsPluginFactory a;
  protected Intent a;
  private QzoneWebViewBaseBuilder.WebviewStatusListener jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder$WebviewStatusListener;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWebprocessWebAccelerateHelper$CommonJsPluginFactory = new andz();
  }
  
  public QzoneWebViewBaseBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected WebAccelerateHelper.CommonJsPluginFactory a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return jdField_a_of_type_ComTencentMobileqqWebprocessWebAccelerateHelper$CommonJsPluginFactory;
    }
    return new WebAccelerateHelper.CommonJsPluginFactory();
  }
  
  public void a() {}
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
  }
  
  public final void a(AppInterface paramAppInterface)
  {
    super.b(paramAppInterface);
    e();
  }
  
  public void a(QzoneWebViewBaseBuilder.WebviewStatusListener paramWebviewStatusListener)
  {
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder$WebviewStatusListener = paramWebviewStatusListener;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.c(paramString);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(new QZoneWebViewPlugin());
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneWebViewBaseBuilder", 2, "loadUrl in shouldOverrideUrlLoading url=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
  
  public void b()
  {
    super.u();
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder$WebviewStatusListener != null) {}
    try
    {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewBaseBuilder$WebviewStatusListener.a();
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void c()
  {
    super.v();
  }
  
  public void c_()
  {
    super.y();
  }
  
  public void d()
  {
    try
    {
      super.w();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder
 * JD-Core Version:    0.7.0.1
 */