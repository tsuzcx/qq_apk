package com.tencent.tmdownloader.internal.notification;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmdownloader.TMAssistantDownloadService;

public class e
{
  public static PendingIntent a(NotifyParam paramNotifyParam)
  {
    Intent localIntent = new Intent(GlobalUtil.getInstance().getContext(), TMAssistantDownloadService.class);
    localIntent.putExtra("notification_id", paramNotifyParam.notificationTypeId);
    if (paramNotifyParam != null) {
      localIntent.putExtra("notifyParam", paramNotifyParam);
    }
    return PendingIntent.getService(GlobalUtil.getInstance().getContext(), (int)(System.currentTimeMillis() & 0xFFFFFFF), localIntent, 134217728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.e
 * JD-Core Version:    0.7.0.1
 */