import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class nvi
  extends beaa
  implements beay
{
  private String a;
  
  public nvi(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView, String paramString)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
    this.a = paramString;
  }
  
  public void a()
  {
    super.doOnResume();
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onResume");
  }
  
  public void b()
  {
    super.doOnPause();
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onPause");
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageWebViewBuilder", 2, "[bindJavaScript]");
    }
    paramArrayList.add(new QWalletPayJsPlugin());
    paramArrayList.add(new PayJsPlugin());
    paramArrayList.add(new QWalletCommonJsPlugin());
    paramArrayList.add(new QWalletBluetoothJsPlugin());
    paramArrayList.add(new sxe());
    paramArrayList.add(new atdu());
    paramArrayList.add(new UiApiPlugin());
    paramArrayList.add(new SensorAPIJavaScript());
    paramArrayList.add(new atcu());
    paramArrayList.add(new MediaApiPlugin());
    paramArrayList.add(new VasCommonJsPlugin());
    paramArrayList.add(new bdut());
    paramArrayList.add(new QWalletMixJsPlugin());
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
  }
  
  public void c()
  {
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onDestroy");
    nvk.a().a(this.mWebview, this.a);
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onWebViewReady()
  {
    super.onWebViewReady();
  }
  
  public void preInitWebviewPlugin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvi
 * JD-Core Version:    0.7.0.1
 */