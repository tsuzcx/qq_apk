package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DatalineFileBrowserParams
  extends BaseFileBrowserParams
{
  private Context f;
  private FileManagerEntity g;
  private ArrayList<String> h;
  private boolean i;
  
  public DatalineFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramContext);
    this.f = paramContext;
    this.g = paramFileManagerEntity;
    this.i = false;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.h = paramArrayList;
  }
  
  public boolean d()
  {
    return false;
  }
  
  protected String e()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
    }
    return "";
  }
  
  protected long f()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileSize;
    }
    return 0L;
  }
  
  protected int g()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.status;
    }
    return 0;
  }
  
  protected String h()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public Intent i()
  {
    Object localObject1 = this.g;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ForwardFileOption.b((FileManagerEntity)localObject1);
    ((ForwardFileInfo)localObject2).b(10009);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
    localObject2 = this.h;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      ((Intent)localObject1).putStringArrayListExtra("Aio_SessionId_ImageList", this.h);
    }
    ((Intent)localObject1).putExtra("_from_aio_", this.i);
    return localObject1;
  }
  
  boolean k()
  {
    Object localObject = this.g;
    if (localObject == null) {
      return false;
    }
    int j = FileManagerUtil.c(((FileManagerEntity)localObject).fileName);
    if (j != 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id:");
        ((StringBuilder)localObject).append(this.g.nSessionId);
        ((StringBuilder)localObject).append(" type is:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" use old filebrowser:");
        QLog.i("FileVideo", 1, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    boolean bool = FileManagerUtil.n(this.g.strFilePath);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id:");
      ((StringBuilder)localObject).append(this.g.nSessionId);
      ((StringBuilder)localObject).append(" status:");
      ((StringBuilder)localObject).append(this.g.status);
      ((StringBuilder)localObject).append(" isLocal:");
      ((StringBuilder)localObject).append(bool);
      QLog.i("FileVideo", 1, ((StringBuilder)localObject).toString());
    }
    if (!bool) {
      return false;
    }
    return (!bool) || (this.g.status == 1) || (!this.g.isSend());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */