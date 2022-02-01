package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class GuildShareActionSheet$ShareItemClickListener
  implements ShareActionSheet.OnItemClickListener
{
  private GuildShareActionSheet$ShareItemClickListener(GuildShareActionSheet paramGuildShareActionSheet) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    GuildShareActionSheet.d(this.a).dismiss();
    if (GuildShareActionSheet.e(this.a) != null) {
      GuildShareActionSheet.e(this.a).c();
    }
    int i = paramActionSheetItem.action;
    GuildShareActionSheet.a(this.a, paramActionSheetItem);
    this.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.GuildShareActionSheet.ShareItemClickListener
 * JD-Core Version:    0.7.0.1
 */