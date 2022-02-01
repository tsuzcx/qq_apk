package com.tencent.mobileqq.webviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import org.json.JSONObject;

public abstract interface WebUiUtils$WebTitleBarInterface
  extends WebUiBaseInterface
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback);
  
  public abstract void a(JSONObject paramJSONObject);
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e(boolean paramBoolean);
  
  public abstract void f(boolean paramBoolean);
  
  public abstract View l();
  
  public abstract int m();
  
  public abstract View n();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface
 * JD-Core Version:    0.7.0.1
 */