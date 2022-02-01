package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;

class GuildFileBubbleModel$3
  implements Runnable
{
  GuildFileBubbleModel$3(GuildFileBubbleModel paramGuildFileBubbleModel, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    FileManagerUtil.g(this.a);
    if (FileUtil.b(this.a.strLargeThumPath)) {
      GuildFileBubbleModel.a(this.this$0).getFileManagerDataCenter().c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */