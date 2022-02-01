package com.tencent.mobileqq.filemanager.guild;

import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

class GuildFileModel$1
  implements IUploadController
{
  GuildFileModel$1(GuildFileModel paramGuildFileModel) {}
  
  public void a()
  {
    FMToastUtil.d("点击了上传按钮");
    if (GuildFileModel.a(this.a) != null) {
      GuildFileModel.b(this.a).d();
    }
  }
  
  public void b()
  {
    FMToastUtil.d("点击了取消上传按钮");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileModel.1
 * JD-Core Version:    0.7.0.1
 */