package cooperation.qqreader.host.webview;

import android.content.Context;
import android.support.annotation.Nullable;
import becq;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public abstract class ReaderBaseWebViewPlugin
  extends WebViewPlugin
{
  private Context jdField_a_of_type_AndroidContentContext;
  private JsBridgeListener jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener;
  
  public ReaderBaseWebViewPlugin()
  {
    this.mPluginNameSpace = getNamespace();
  }
  
  public Context getContext()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.a();
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      return this.jdField_a_of_type_AndroidContentContext;
    }
    return null;
  }
  
  protected String getNamespace()
  {
    return getClass().getSimpleName();
  }
  
  @Nullable
  public ReaderWebView getWebView()
  {
    if (this.mRuntime != null) {
      return (ReaderWebView)this.mRuntime.a();
    }
    return null;
  }
  
  @Deprecated
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(getNamespace()))) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
    return handleJsRequest(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  protected abstract boolean handleJsRequest(String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  public void init(Context paramContext, JsBridgeListener paramJsBridgeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
    this.mRuntime = null;
    onCreate();
  }
  
  public void init(becq parambecq, JsBridgeListener paramJsBridgeListener)
  {
    this.mRuntime = parambecq;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
    this.jdField_a_of_type_AndroidContentContext = null;
    onCreate();
  }
  
  protected void onJsComplete(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.a(paramObject);
    }
  }
  
  protected void onJsError(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.webview.ReaderBaseWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */