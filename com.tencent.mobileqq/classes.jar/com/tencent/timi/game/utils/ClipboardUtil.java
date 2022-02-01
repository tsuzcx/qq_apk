package com.tencent.timi.game.utils;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;

public final class ClipboardUtil
{
  @TargetApi(11)
  public static void a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramContext = (android.content.ClipboardManager)paramContext.getSystemService("clipboard");
      paramString = ClipData.newPlainText(null, paramString);
      ClipboardMonitor.setPrimaryClip(paramContext, paramString);
      paramContext.setPrimaryClip(paramString);
      return;
    }
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.ClipboardUtil
 * JD-Core Version:    0.7.0.1
 */