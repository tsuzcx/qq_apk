package com.tencent.mobileqq.webviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import org.json.JSONObject;

public abstract interface WebUiUtils$WebTitleBarInterface
  extends WebUiBaseInterface
{
  public abstract long a();
  
  public abstract View a();
  
  public abstract void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener);
  
  public abstract void a(JSONObject paramJSONObject);
  
  public abstract int b();
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface
 * JD-Core Version:    0.7.0.1
 */