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

class BigEmotionDownloadedAdapter$2
  implements View.OnClickListener
{
  BigEmotionDownloadedAdapter$2(BigEmotionDownloadedAdapter paramBigEmotionDownloadedAdapter, EmoticonRecDressup paramEmoticonRecDressup) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    label84:
    String str1;
    label110:
    int i;
    if (this.val$emoticonRecDressup.hasRecommendDressup)
    {
      ((Intent)localObject).putExtra("emoji_to_dressup", true);
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.this$0.mContext, this.this$0.app.getAccount(), 8, String.valueOf(this.this$0.emotionPkg.epId), false, (Intent)localObject, false);
      if (this.this$0.app != null) {
        break label257;
      }
      localObject = "";
      String str2 = this.this$0.emotionPkg.epId;
      if (!this.val$emoticonRecDressup.hasRecommendDressup) {
        break label272;
      }
      str1 = "1";
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X8007192", null, 1, 0, 0, null, str2, str1);
      if ((this.this$0.emotionPkg.extraFlags & 0x1) <= 0) {
        break label279;
      }
      i = 3;
    }
    for (;;)
    {
      bcef.b(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.this$0.emotionPkg.epId, i + "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.this$0.emotionPkg.extraFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((Intent)localObject).putExtra("emoji_is_original", bool);
        ((Intent)localObject).putExtra("emoji_author_id", this.val$emoticonRecDressup.authorId);
        break;
      }
      label257:
      localObject = this.this$0.app.getCurrentAccountUin();
      break label84;
      label272:
      str1 = "2";
      break label110;
      label279:
      if (this.this$0.emotionPkg.subType == 4) {
        i = 4;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.2
 * JD-Core Version:    0.7.0.1
 */