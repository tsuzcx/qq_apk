package cooperation.qzone.webviewplugin.personalize;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class QZonePersonalizePlugin$1
  extends BroadcastReceiver
{
  QZonePersonalizePlugin$1(QZonePersonalizePlugin paramQZonePersonalizePlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("intent is: ");
      if (paramIntent == null) {
        paramContext = "null";
      } else {
        paramContext = "not null";
      }
      ((StringBuilder)localObject).append(paramContext);
      QLog.d("QZonePersonalizePlugin", 4, ((StringBuilder)localObject).toString());
    }
    if ((paramIntent != null) && ("QZoneCardPreDownload".equals(paramIntent.getAction())))
    {
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("QZoneCardPreDownload js receive setting action");
        paramContext.append(paramIntent.getAction());
        QLog.d("QZoneCardLogic.QZonePersonalizePlugin", 4, paramContext.toString());
      }
      paramContext = paramIntent.getExtras();
      paramIntent = "";
      if (paramContext != null)
      {
        paramIntent = paramContext.getString("result");
        paramContext = paramContext.getString("cardurl");
      }
      else
      {
        paramContext = "";
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QZoneCardPreDownload js receive cardurl:");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("\n dowonload result:");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("QZoneCardLogic.QZonePersonalizePlugin", 4, ((StringBuilder)localObject).toString());
      }
      if (this.this$0.mRuntime == null) {
        return;
      }
      if (this.this$0.mRuntime.a() == null) {
        return;
      }
      paramIntent = this.this$0.mRuntime.a();
      if (paramIntent != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("window.QzFeedDressJSInterface.onReceive({type:\"cardurl\",data:\"");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("\"});window.QzFeedDressJSInterface.onReceive({type:\"result\",data:\"success\"});");
        paramIntent.callJs(((StringBuilder)localObject).toString());
      }
    }
    else if ((paramIntent != null) && ("action_facade_qzone2js".equals(paramIntent.getAction())))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        int i = paramIntent.getInt("ret");
        paramContext = paramIntent.getString("imgDir");
        paramIntent = paramIntent.getString("imgNameList");
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("receive ret:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("|imgDir:");
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append("|imgNameList:");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("QZonePersonalizePlugin", 4, ((StringBuilder)localObject).toString());
        }
        if (this.this$0.mRuntime == null) {
          return;
        }
        if (this.this$0.mRuntime.a() == null) {
          return;
        }
        if (i == 0)
        {
          localObject = this.this$0;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("window.QzAvatarDressJSInterface.onReceive({type:\"result\",data:\"success\",imgDir:\"");
          localStringBuilder.append(paramContext);
          localStringBuilder.append("\",imgNameList:\"");
          localStringBuilder.append(paramIntent);
          localStringBuilder.append("\"});");
          ((QZonePersonalizePlugin)localObject).callJs(localStringBuilder.toString());
          return;
        }
        this.this$0.callJs("window.QzAvatarDressJSInterface.onReceive({type:\"result\",data:\"fail\"});");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin.1
 * JD-Core Version:    0.7.0.1
 */