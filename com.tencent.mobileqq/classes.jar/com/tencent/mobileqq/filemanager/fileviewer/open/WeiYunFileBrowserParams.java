package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WeiYunFileBrowserParams
  extends IFileBrowserParams
{
  private WeiYunFileInfo f;
  private Context g;
  private QQAppInterface h;
  private ArrayList<WeiYunFileInfo> i;
  private FileManagerEntity j;
  
  public WeiYunFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.h = paramQQAppInterface;
    this.g = paramContext;
    this.f = paramWeiYunFileInfo;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.j = paramFileManagerEntity;
  }
  
  public void b(Bundle paramBundle) {}
  
  public boolean d()
  {
    return false;
  }
  
  public Intent i()
  {
    Object localObject1 = this.j;
    if ((localObject1 == null) && (this.f != null))
    {
      localObject1 = this.h.getFileManagerRSCenter().a(this.f.a);
      if (localObject1 == null)
      {
        localObject1 = this.h.getFileManagerDataCenter().c(this.f.a);
        if (localObject1 == null) {
          localObject1 = FileManagerUtil.a(this.f);
        }
      }
    }
    if (localObject1 == null)
    {
      QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, "");
      return new Intent(this.g, FileBrowserActivity.class);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("open a weiyun file with filebrowser, fileSessionId[");
      ((StringBuilder)localObject2).append(((FileManagerEntity)localObject1).nSessionId);
      ((StringBuilder)localObject2).append("] fileName[");
      ((StringBuilder)localObject2).append(this.f.c);
      ((StringBuilder)localObject2).append("]fileId[");
      ((StringBuilder)localObject2).append(this.f.a);
      ((StringBuilder)localObject2).append("]");
      QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject2).d(2);
    ((ForwardFileInfo)localObject2).b(10003);
    ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
    ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileName);
    ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).WeiYunFileId);
    ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).nWeiYunSrcType);
    ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileSize);
    localObject1 = new Intent(this.g, FileBrowserActivity.class);
    ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
    localObject2 = this.i;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      ((Intent)localObject1).putParcelableArrayListExtra("local_weiyun_list", this.i);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.WeiYunFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */