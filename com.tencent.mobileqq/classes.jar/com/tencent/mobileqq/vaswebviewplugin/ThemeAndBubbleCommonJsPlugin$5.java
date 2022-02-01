package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bgve;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

class ThemeAndBubbleCommonJsPlugin$5
  implements Runnable
{
  ThemeAndBubbleCommonJsPlugin$5(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, String paramString, File paramFile) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.downloadData(this.this$0.mRuntime.a(), this.val$joinUrl, this.val$f);
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("downResult", i);
    localMessage.setData(localBundle);
    this.this$0.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */