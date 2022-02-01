package com.tencent.mobileqq.graytip;

import android.content.Intent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerDoubleClickListener;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class UniteGrayTipItemBuilder$2
  implements EmojiStickerManager.StickerDoubleClickListener
{
  UniteGrayTipItemBuilder$2(UniteGrayTipItemBuilder paramUniteGrayTipItemBuilder) {}
  
  public void a(View paramView)
  {
    String str = IndividuationUrlHelper.a("aioEmojiStickerDetail");
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent != null)
    {
      localViewParent = localViewParent.getParent();
      if ((localViewParent instanceof ChatXListView)) {
        EmojiStickerManager.w = ((ChatXListView)localViewParent).getPositionForView(paramView);
      }
    }
    paramView = new Intent(this.a.a.getApp(), QQBrowserActivity.class);
    paramView.setFlags(268435456);
    int i = 1;
    paramView.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.b(this.a.a.getApp(), str, -1L, paramView, false, -1);
    if (EmojiStickerManager.a().h != 0) {
      if (EmojiStickerManager.a().h == 1) {
        i = 2;
      } else if (EmojiStickerManager.a().h == 3000) {
        i = 3;
      } else {
        i = -1;
      }
    }
    VasWebviewUtil.a(this.a.a.getCurrentUin(), "Stick", "ClickDetail", String.valueOf(i), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */