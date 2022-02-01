package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
      this.mRuntime.d().registerReceiver(this.mReceiver, localIntentFilter);
    }
  }
  
  private void unregisterReceiver()
  {
    if (this.mReceiver != null) {
      this.mRuntime.d().unregisterReceiver(this.mReceiver);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      QLog.d("QQReaderJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if (("qqreader".equals(paramString2)) && (paramString1 != null))
    {
      if (paramString3 == null) {
        return false;
      }
      if ("addBookShelfReceiver".equals(paramString3))
      {
        addBookShelfReceiver();
        return true;
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin
 * JD-Core Version:    0.7.0.1
 */