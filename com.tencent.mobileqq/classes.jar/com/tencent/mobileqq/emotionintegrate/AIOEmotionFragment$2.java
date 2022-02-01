package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class AIOEmotionFragment$2
  implements ShareActionSheet.OnItemClickListener
{
  AIOEmotionFragment$2(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.a.a.dismiss();
    int i = paramActionSheetItem.action;
    this.a.a(i, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.2
 * JD-Core Version:    0.7.0.1
 */