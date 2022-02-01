package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import bcef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SmallEmotionDownloadedAdapter$1
  implements View.OnClickListener
{
  SmallEmotionDownloadedAdapter$1(SmallEmotionDownloadedAdapter paramSmallEmotionDownloadedAdapter, EmoticonRecDressup paramEmoticonRecDressup) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    String str1;
    label41:
    String str3;
    if (this.val$emoticonRecDressup.hasRecommendDressup)
    {
      localIntent.putExtra("emoji_to_dressup", true);
      if (this.this$0.app != null) {
        break label221;
      }
      str1 = "";
      str3 = this.this$0.emotionPkg.epId;
      if (!this.val$emoticonRecDressup.hasRecommendDressup) {
        break label235;
      }
    }
    label221:
    label235:
    for (String str2 = "1";; str2 = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "0X8007192", null, 1, 0, 0, null, str3, str2);
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.this$0.mContext, this.this$0.app.getAccount(), 8, String.valueOf(this.this$0.emotionPkg.epId), false, localIntent, true);
      bcef.b(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.this$0.emotionPkg.epId, "2", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.this$0.emotionPkg.extraFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("emoji_is_original", bool);
        localIntent.putExtra("emoji_author_id", this.val$emoticonRecDressup.authorId);
        break;
      }
      str1 = this.this$0.app.getCurrentAccountUin();
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter.1
 * JD-Core Version:    0.7.0.1
 */