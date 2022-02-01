package com.tencent.mobileqq.filemanager.guild;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.List;

public class GuildFileModel
  extends C2CFileModel
{
  public GuildFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity, paramList, paramInt);
  }
  
  public BaseVideoBiz Q_()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null) {
      return null;
    }
    return new VideoForGuild(this.a, localFileManagerEntity);
  }
  
  public IUploadController e()
  {
    if (this.p == null) {
      this.p = new GuildFileModel.1(this);
    }
    return this.p;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    if (!QQFileManagerUtil.v(y())) {
      return null;
    }
    return super.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileModel
 * JD-Core Version:    0.7.0.1
 */