package com.tencent.timi.game.liveroom.impl.share.timishare;

import android.content.Context;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

final class TimiGameShareUtil$1
  implements ShareActionSheet.OnItemClickListener
{
  TimiGameShareUtil$1(Context paramContext, TgShareParam paramTgShareParam, ShareActionSheet.OnItemClickListener paramOnItemClickListener) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    TimiGameShareUtil.a(this.a, paramActionSheetItem, this.b);
    ShareActionSheet.OnItemClickListener localOnItemClickListener = this.c;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.onItemClick(paramActionSheetItem, paramShareActionSheet);
    }
    paramShareActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil.1
 * JD-Core Version:    0.7.0.1
 */