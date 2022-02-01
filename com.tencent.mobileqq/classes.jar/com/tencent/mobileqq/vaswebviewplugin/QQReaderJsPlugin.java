package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import bifw;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;

public class QQReaderJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BROADCAST_ADD_BOOKSHELF = "com.tencent.mobileqq.jsPlugin.AddToBookShelf";
  public static final String NAMESPACE = "qqreader";
  private static final String TAG = "QQReaderJsPlugin";
  private BroadcastReceiver mReceiver;
  
  public QQReaderJsPlugin()
  {
    this.mPluginNameSpace = "qqreader";
  }
  
  private void addBookShelfReceiver()
  {
    registerReceiver();
  }
  
  private void registerReceiver()
  {
    if (this.mReceiver == null)
    {
      this.mReceiver = new QQReaderJsPlugin.1(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.jsPlugin.AddToBookShelf");
      this.mRuntime.a().registerReceiver(this.mReceiver, localIntentFilter);
    }
  }
  
  private void unregisterReceiver()
  {
    if (this.mReceiver != null) {
      this.mRuntime.a().unregisterReceiver(this.mReceiver);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQReaderJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"qqreader".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {}
    while (!"addBookShelfReceiver".equals(paramString3)) {
      return false;
    }
    addBookShelfReceiver();
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin
 * JD-Core Version:    0.7.0.1
 */