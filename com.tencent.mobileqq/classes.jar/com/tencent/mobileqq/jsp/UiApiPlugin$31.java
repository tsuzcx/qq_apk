package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.atomic.AtomicLong;

class UiApiPlugin$31
  extends BroadcastReceiver
{
  UiApiPlugin$31(UiApiPlugin paramUiApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (ResultReceiver)paramIntent.getParcelableExtra("receiver");
    long l = paramIntent.getLongExtra("seq", 0L);
    Bundle localBundle = new Bundle();
    localBundle.putLong("seq", l);
    if (UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() != -1L) {
      paramContext.send(-1, localBundle);
    }
    String str = paramIntent.getStringExtra("date");
    paramIntent = paramIntent.getStringExtra("id");
    Object localObject = this.a.mRuntime.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.a.mRuntime.a();
      if ((localObject != null) && (((WebView)localObject).getX5WebViewExtension() != null))
      {
        localBundle = new Bundle();
        localBundle.putString("date", str);
        localBundle.putString("id", paramIntent);
        UiApiPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
        UiApiPlugin.jdField_a_of_type_AndroidOsResultReceiver = paramContext;
        ((WebView)localObject).getX5WebViewExtension().invokeMiscMethod("uploadX5CoreLiveLog", localBundle);
        return;
      }
      paramContext.send(-2, localBundle);
      return;
    }
    paramContext.send(-2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.31
 * JD-Core Version:    0.7.0.1
 */