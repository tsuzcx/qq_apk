package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;
import com.tencent.qphone.base.util.QLog;

final class MiniAppUtils$4
  extends Handler
{
  MiniAppUtils$4(Looper paramLooper, Context paramContext, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.obj instanceof WebSoCgiService.WebSoCgiState))
    {
      WebSoCgiService.WebSoCgiState localWebSoCgiState = (WebSoCgiService.WebSoCgiState)paramMessage.obj;
      if (localWebSoCgiState.i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage() called with: msg = [");
        localStringBuilder.append(paramMessage);
        localStringBuilder.append("]");
        QLog.d("MiniAppUtils", 2, localStringBuilder.toString());
        MiniAppUtils.access$000(this.val$context, this.val$appId, this.val$dataCacheKey, localWebSoCgiState.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.4
 * JD-Core Version:    0.7.0.1
 */