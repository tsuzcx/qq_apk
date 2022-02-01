package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GuildFileNormalBubblePauseHandler$1
  implements ActionSheet.OnButtonClickListener
{
  GuildFileNormalBubblePauseHandler$1(GuildFileNormalBubblePauseHandler paramGuildFileNormalBubblePauseHandler, long paramLong) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      this.b.b.getFileManagerEngine().b(this.a);
    }
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildFileNormalBubblePauseHandler.1
 * JD-Core Version:    0.7.0.1
 */