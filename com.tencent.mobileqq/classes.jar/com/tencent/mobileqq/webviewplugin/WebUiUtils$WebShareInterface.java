package com.tencent.mobileqq.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;

public abstract interface WebUiUtils$WebShareInterface
  extends WebUiBaseInterface
{
  public abstract <T> T getShare();
  
  public abstract boolean setShareUrl(String paramString);
  
  public abstract boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface
 * JD-Core Version:    0.7.0.1
 */