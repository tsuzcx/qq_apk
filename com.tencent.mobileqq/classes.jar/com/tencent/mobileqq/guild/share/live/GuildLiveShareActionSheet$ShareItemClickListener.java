package com.tencent.mobileqq.guild.share.live;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class GuildLiveShareActionSheet$ShareItemClickListener
  implements ShareActionSheet.OnItemClickListener
{
  private GuildLiveShareActionSheet$ShareItemClickListener(GuildLiveShareActionSheet paramGuildLiveShareActionSheet) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    GuildLiveShareActionSheet.a(this.a).dismiss();
    GuildLiveShareActionSheet.a(this.a, paramActionSheetItem);
    this.a.a(paramActionSheetItem.action);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.live.GuildLiveShareActionSheet.ShareItemClickListener
 * JD-Core Version:    0.7.0.1
 */