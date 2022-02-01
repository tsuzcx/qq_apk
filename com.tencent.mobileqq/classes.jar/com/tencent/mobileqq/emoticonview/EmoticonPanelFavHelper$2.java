package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;

class EmoticonPanelFavHelper$2
  implements Runnable
{
  EmoticonPanelFavHelper$2(EmoticonPanelFavHelper paramEmoticonPanelFavHelper, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, boolean paramBoolean, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.val$app;
    if (localQQEmoticonMainPanelApp == null) {
      return;
    }
    this.this$0.realDoSyncFavEmoticon(this.val$isDelOverflow, localQQEmoticonMainPanelApp, this.val$sp, this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.2
 * JD-Core Version:    0.7.0.1
 */