package com.tencent.qidian.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class QidianWpaWebviewPlugin$1
  extends BroadcastReceiver
{
  QidianWpaWebviewPlugin$1(QidianWpaWebviewPlugin paramQidianWpaWebviewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (ActionSheet)ActionSheetHelper.a((Activity)paramContext, null);
      paramContext.addButton(2131698255);
      paramContext.addCancelButton(2131690800);
      paramContext.setOnButtonClickListener(new QidianWpaWebviewPlugin.1.1(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.plugin.QidianWpaWebviewPlugin.1
 * JD-Core Version:    0.7.0.1
 */