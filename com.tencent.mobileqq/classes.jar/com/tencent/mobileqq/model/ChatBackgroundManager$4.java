package com.tencent.mobileqq.model;

import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;

class ChatBackgroundManager$4
  implements ThemeDiyStyleLogic.StyleCallBack
{
  ChatBackgroundManager$4(ChatBackgroundManager paramChatBackgroundManager) {}
  
  public int a(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    if (paramInt2 == 4) {
      GlobalImageCache.a.evictAll();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.4
 * JD-Core Version:    0.7.0.1
 */