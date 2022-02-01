package com.tencent.mobileqq.webview.swift.proxy;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import org.json.JSONObject;

public class WebTitleBarProxy
  implements WebUiUtils.WebTitleBarInterface
{
  protected WebUiUtils.WebTitleBarInterface a;
  
  public WebTitleBarProxy(@NonNull WebUiUtils.WebTitleBarInterface paramWebTitleBarInterface)
  {
    this.a = paramWebTitleBarInterface;
  }
  
  public int a()
  {
    return this.a.a();
  }
  
  public View a()
  {
    return this.a.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    this.a.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramOnClickListener, paramAPICallback);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public View b()
  {
    return this.a.b();
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    this.a.d(paramBoolean);
  }
  
  public void e(boolean paramBoolean)
  {
    this.a.e(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.proxy.WebTitleBarProxy
 * JD-Core Version:    0.7.0.1
 */