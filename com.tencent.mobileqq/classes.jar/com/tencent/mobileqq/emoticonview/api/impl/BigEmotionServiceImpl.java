package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class BigEmotionServiceImpl
  implements IBigEmotionService
{
  public void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    EmojiHomeUiPlugin.openEmojiDetailPage(paramContext, paramIEmoticonMainPanelApp, paramString1, 8, paramString2, paramBoolean1, paramIntent, paramBoolean2);
  }
  
  public void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, String paramString3)
  {
    paramString1 = new Intent();
    if (paramBoolean3)
    {
      paramString1.putExtra("emoji_to_dressup", true);
    }
    else
    {
      if ((paramInt2 & 0x1) != 0) {
        paramBoolean3 = true;
      } else {
        paramBoolean3 = false;
      }
      paramString1.putExtra("emoji_is_original", paramBoolean3);
      paramString1.putExtra("emoji_author_id", EmoticonRecDressup.getEmotionRecommend(paramString3, true).authorId);
    }
    EmojiHomeUiPlugin.openEmojiDetailPage(paramContext, paramIEmoticonMainPanelApp, paramIEmoticonMainPanelApp.getAccount(), 8, String.valueOf(paramString3), paramBoolean1, paramString1, paramBoolean2);
  }
  
  public void openQQBrowserWithoutAD(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    paramIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.b(paramContext, paramString, -1L, paramIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.BigEmotionServiceImpl
 * JD-Core Version:    0.7.0.1
 */