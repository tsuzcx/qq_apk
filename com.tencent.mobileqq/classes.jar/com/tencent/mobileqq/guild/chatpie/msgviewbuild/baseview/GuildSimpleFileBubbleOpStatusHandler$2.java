package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GuildSimpleFileBubbleOpStatusHandler$2
  implements ActionSheet.OnButtonClickListener
{
  GuildSimpleFileBubbleOpStatusHandler$2(GuildSimpleFileBubbleOpStatusHandler paramGuildSimpleFileBubbleOpStatusHandler, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      this.b.b.getFileManagerEngine().b(this.a.nSessionId);
    }
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildSimpleFileBubbleOpStatusHandler.2
 * JD-Core Version:    0.7.0.1
 */