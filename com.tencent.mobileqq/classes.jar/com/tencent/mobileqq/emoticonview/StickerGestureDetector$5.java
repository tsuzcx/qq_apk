package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class StickerGestureDetector$5
  implements DialogInterface.OnClickListener
{
  StickerGestureDetector$5(StickerGestureDetector paramStickerGestureDetector) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$0.mContext.getString(2131916948);
    VasH5PayUtil.a(this.this$0.mContext, "mvip.g.a.bq_tz", 3, "1450000515", "CJCLUBT", paramDialogInterface, "", false, true);
    if (this.this$0.mBaseChatPie != null)
    {
      paramInt = -1;
      if (EmojiStickerManager.a().h == 0) {
        paramInt = 1;
      } else if (EmojiStickerManager.a().h == 1) {
        paramInt = 2;
      } else if (EmojiStickerManager.a().h == 3000) {
        paramInt = 3;
      }
      VasWebviewUtil.a(this.this$0.mBaseChatPie.d.getCurrentUin(), "Stick", "ClickSVIPTip", String.valueOf(paramInt), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGestureDetector.5
 * JD-Core Version:    0.7.0.1
 */