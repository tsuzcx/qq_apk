package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QQReaderJsPlugin$1
  extends BroadcastReceiver
{
  QQReaderJsPlugin$1(QQReaderJsPlugin paramQQReaderJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getExtras();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive action:");
      localStringBuilder.append(paramContext);
      QLog.d("QQReaderJsPlugin", 2, localStringBuilder.toString());
    }
    if (("com.tencent.mobileqq.jsPlugin.AddToBookShelf".equals(paramContext)) || (paramIntent != null))
    {
      paramContext = new JSONObject();
      try
      {
        paramContext.put("id", paramIntent.getString("bookId"));
        paramContext.put("nbid", paramIntent.getString("bookNewId"));
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQReaderJsPlugin", 2, paramIntent.getMessage());
        }
      }
      this.this$0.dispatchJsEvent("qqReaderCenterSucceedAddingToShelf", paramContext, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */