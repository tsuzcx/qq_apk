import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;

public class mzd
  extends WebChromeClient
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  bafb jdField_a_of_type_Bafb;
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  
  private String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("data:")) {
      return paramContext.getString(2131628055);
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
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.cancel();
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
      if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
      this.jdField_a_of_type_Bafb = babr.a(localContext, 0);
      this.jdField_a_of_type_Bafb.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_Bafb.setMessage(paramString2);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131629116, new mze(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_Bafb.setNegativeButton(localContext.getString(2131624996), localContext.getResources().getColor(2131099760), new mzh(this, paramJsResult, localContext));
      }
      this.jdField_a_of_type_Bafb.setOnCancelListener(new mzi(this, paramJsResult, localContext));
      this.jdField_a_of_type_Bafb.show();
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
      if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
      this.jdField_a_of_type_Bafb = babr.a(paramString1, 0);
      this.jdField_a_of_type_Bafb.setTitle(2131628054);
      this.jdField_a_of_type_Bafb.setMessage(paramString2);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131624894, new mzn(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_Bafb.setNegativeButton(paramString1.getString(2131624996), paramString1.getResources().getColor(2131099760), new mzo(this, paramJsResult, paramString1));
      }
      for (;;)
      {
        this.jdField_a_of_type_Bafb.setOnCancelListener(new mzg(this, paramJsResult, paramString1));
        this.jdField_a_of_type_Bafb.show();
        return true;
        this.jdField_a_of_type_Bafb.setNegativeButton(2131624893, new mzf(this, paramJsResult));
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
      if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
      this.jdField_a_of_type_Bafb = babr.a(localContext, 0);
      this.jdField_a_of_type_Bafb.setTitle(a(localContext, paramString1));
      this.jdField_a_of_type_Bafb.setMessage(paramString2);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131629116, new mzj(this, paramJsResult));
      if (this.jdField_a_of_type_Int > 2) {
        this.jdField_a_of_type_Bafb.setNegativeButton(localContext.getString(2131624996), localContext.getResources().getColor(2131099760), new mzk(this, paramJsResult, localContext));
      }
      for (;;)
      {
        this.jdField_a_of_type_Bafb.setOnCancelListener(new mzm(this, paramJsResult, localContext));
        this.jdField_a_of_type_Bafb.show();
        return true;
        this.jdField_a_of_type_Bafb.setNegativeButton(2131625035, new mzl(this, paramJsResult));
      }
    }
    paramJsResult.cancel();
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    paramJsPromptResult.cancel();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzd
 * JD-Core Version:    0.7.0.1
 */