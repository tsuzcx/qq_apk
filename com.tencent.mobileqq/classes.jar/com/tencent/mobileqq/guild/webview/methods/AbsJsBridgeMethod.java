package com.tencent.mobileqq.guild.webview.methods;

import com.tencent.mobileqq.guild.webview.QQGuildJsPlugin;
import com.tencent.mobileqq.guild.webview.QQGuildJsPlugin.Method;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsJsBridgeMethod
  implements QQGuildJsPlugin.Method
{
  private JSONObject a;
  private QQGuildJsPlugin b;
  private String c;
  
  public int a(String paramString, int paramInt)
  {
    return this.a.optInt(paramString, paramInt);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.a.optString(paramString1, paramString2);
  }
  
  protected void a(Exception paramException)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("callbackId->");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" Exception:");
    ((StringBuilder)localObject).append(paramException);
    QLog.e("AbsJsBridgeMethod", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exception:");
    localStringBuilder.append(paramException.getMessage());
    ((QQGuildJsPlugin)localObject).a(str, localStringBuilder.toString());
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callbackId->");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" callbackOk");
      localStringBuilder.append(paramString);
      QLog.d("AbsJsBridgeMethod", 2, localStringBuilder.toString());
    }
    this.b.callJs(this.c, new String[] { paramString });
  }
  
  public final boolean a(QQGuildJsPlugin paramQQGuildJsPlugin, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    try
    {
      this.a = new JSONObject(paramVarArgs[0]);
      if (QLog.isColorLevel()) {
        QLog.d("AbsJsBridgeMethod", 2, new Object[] { "onJsBridge invoke, method: ", paramString3, " data: ", this.a.toString(1) });
      }
      this.b = paramQQGuildJsPlugin;
      this.c = this.a.optString("callback");
      return a(paramString1, paramString2, paramString3);
    }
    catch (JSONException paramQQGuildJsPlugin) {}
    return false;
  }
  
  protected abstract boolean a(String paramString1, String paramString2, String paramString3);
  
  public int b(String paramString)
  {
    return this.a.optInt(paramString);
  }
  
  public String c(String paramString)
  {
    return this.a.optString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.AbsJsBridgeMethod
 * JD-Core Version:    0.7.0.1
 */