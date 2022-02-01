package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract interface IPostCreatePluginChecker
{
  public abstract boolean a(Intent paramIntent, CopyOnWriteArrayList<WebViewPlugin> paramCopyOnWriteArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.IPostCreatePluginChecker
 * JD-Core Version:    0.7.0.1
 */