import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;

public class ofz
  extends WebChromeClient
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  
  private String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("data:")) {
      return paramContext.getString(2131693412);
    }
    try
    {
      paramContext = new URL(paramString).getHost();
      return paramContext;
    }
    catch (MalformedURLException paramContext) {}
    return paramString;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    VipWebViewReportLog.a(paramConsoleMessage);
    Object localObject2;
    if (((this.jdField_a_of_type_Boolean) && (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)) || (QLog.isColorLevel())) {
      localObject2 = "";
    }
    for (;;)
    {
      try
      {
        if (paramConsoleMessage.messageLevel() != null) {
          localObject2 = "" + "messageLevel =" + paramConsoleMessage.messageLevel().toString();
        }
        localObject1 = localObject2;
        if (paramConsoleMessage.sourceId() != null) {
          localObject1 = (String)localObject2 + ", sourceId=" + paramConsoleMessage.sourceId();
        }
        localObject2 = localObject1;
        if (paramConsoleMessage.lineNumber() != 0) {
          localObject2 = (String)localObject1 + ", lineNumber=" + paramConsoleMessage.lineNumber();
        }
        localObject1 = localObject2;
        if (paramConsoleMessage.message() != null) {
          localObject1 = (String)localObject2 + ", message=" + paramConsoleMessage.message();
        }
        if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
          continue;
        }
        if ((System.currentTimeMillis() - this.jdField_a_of_type_Long > 60000L) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))
        {
          QLog.e("WEBVIEWCHECK", 1, "CustomWebChromeClient onConsoleMessage:" + (String)localObject1);
          this.jdField_a_of_type_JavaLangString = ((String)localObject1);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
      }
      catch (Exception paramConsoleMessage)
      {
        Object localObject1;
        paramConsoleMessage.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        break label357;
      }
      return true;
      if ((System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))
      {
        QLog.d("WEBVIEWCHECK", 2, "CustomWebChromeClient onConsoleMessage:" + (String)localObject1);
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
    label357:
    return false;
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(localContext, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694399, new oga(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(localContext.getString(2131690667), localContext.getResources().getColor(2131165381), new ogd(this, paramJsResult, localContext));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new oge(this, paramJsResult, localContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      this.jdField_a_of_type_Int += 1;
      return true;
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramString1 = paramWebView.getContext();
    if (((paramString1 instanceof Activity)) && (!((Activity)paramString1).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(paramString1, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131693411);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131690600, new ogj(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1.getString(2131690667), paramString1.getResources().getColor(2131165381), new ogk(this, paramJsResult, paramString1));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new ogc(this, paramJsResult, paramString1));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return true;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690599, new ogb(this, paramJsResult));
      }
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Context localContext = paramWebView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()) && ((!(paramWebView instanceof CustomWebView)) || (!((CustomWebView)paramWebView).isPaused)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(localContext, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694399, new ogf(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(localContext.getString(2131690667), localContext.getResources().getColor(2131165381), new ogg(this, paramJsResult, localContext));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new ogi(this, paramJsResult, localContext));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return true;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690697, new ogh(this, paramJsResult));
      }
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    paramJsPromptResult.cancel();
    return true;
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofz
 * JD-Core Version:    0.7.0.1
 */