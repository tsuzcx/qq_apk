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
  protected WebUiUtils.WebTitleBarInterface b;
  
  public WebTitleBarProxy(@NonNull WebUiUtils.WebTitleBarInterface paramWebTitleBarInterface)
  {
    this.b = paramWebTitleBarInterface;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    this.b.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramOnClickListener, paramAPICallback);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.b.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    this.b.d(paramBoolean);
  }
  
  public void e(boolean paramBoolean)
  {
    this.b.e(paramBoolean);
  }
  
  public void f(boolean paramBoolean)
  {
    this.b.f(paramBoolean);
  }
  
  public View l()
  {
    return this.b.l();
  }
  
  public int m()
  {
    return this.b.m();
  }
  
  public View n()
  {
    return this.b.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.proxy.WebTitleBarProxy
 * JD-Core Version:    0.7.0.1
 */