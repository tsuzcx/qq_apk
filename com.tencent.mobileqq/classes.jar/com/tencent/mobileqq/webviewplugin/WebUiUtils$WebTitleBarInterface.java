package com.tencent.mobileqq.webviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import org.json.JSONObject;

public abstract interface WebUiUtils$WebTitleBarInterface
  extends WebUiBaseInterface
{
  public abstract void doTransparent(JSONObject paramJSONObject);
  
  public abstract long getRulesFromUrl();
  
  public abstract int getTitleBarAlpa();
  
  public abstract int getTitleBarHeight();
  
  public abstract View getTitleBarView();
  
  public abstract void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback);
  
  public abstract void setRightButton(boolean paramBoolean);
  
  public abstract void setWarnToastVisible(boolean paramBoolean, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface
 * JD-Core Version:    0.7.0.1
 */