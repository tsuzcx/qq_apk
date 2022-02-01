package com.tencent.mobileqq.multimsg.save;

import android.os.Handler;
import android.os.Message;
import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FileSaveRunnable
  implements Runnable
{
  private File a;
  private File b;
  private Handler c;
  private FileSaveResult d;
  private boolean e;
  
  public FileSaveRunnable(File paramFile1, File paramFile2, Handler paramHandler, FileSaveResult paramFileSaveResult, boolean paramBoolean)
  {
    this.a = paramFile1;
    this.b = paramFile2;
    this.c = paramHandler;
    this.d = paramFileSaveResult;
    this.e = paramBoolean;
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      if (this.e)
      {
        localObject1 = this.b;
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("PictureSaveRunnable", 2, "desFile exist");
          }
          localObject1 = this.c.obtainMessage(3);
          ((Message)localObject1).obj = this.d;
          this.c.sendMessage((Message)localObject1);
          return;
        }
      }
      int j = 1;
      int k = 0;
      try
      {
        if (this.b != null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("FileSaveRunnable run savePhotoToSysAlbum...destFile=");
            ((StringBuilder)localObject1).append(this.b);
            QLog.i("PictureSaveRunnable", 2, ((StringBuilder)localObject1).toString());
          }
          if (!this.b.getParentFile().exists())
          {
            boolean bool = this.b.getParentFile().mkdir();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("FileSaveRunnable run savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=");
              ((StringBuilder)localObject1).append(bool);
              QLog.i("PictureSaveRunnable", 2, ((StringBuilder)localObject1).toString());
            }
          }
        }
        if ((this.b != null) && (FileUtil.a(this.a, this.b)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("PictureSaveRunnable", 2, "savePhotoToSysAlbum...");
          }
          ImageUtil.a(BaseApplicationImpl.getApplication(), this.b);
          ImageUtil.b(BaseApplicationImpl.getContext(), this.b.getAbsolutePath());
          i = 1;
          break label397;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PictureSaveRunnable", 2, "copyFile error");
        }
        this.d.c = 10004;
        this.d.d = FileSaveErrorInfo.a(this.d.c);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("save exception = ");
          ((StringBuilder)localObject3).append(localException.getMessage());
          QLog.e("PictureSaveRunnable", 2, ((StringBuilder)localObject3).toString());
        }
        localObject2 = this.d;
        ((FileSaveResult)localObject2).c = 10005;
        ((FileSaveResult)localObject2).d = FileSaveErrorInfo.a(((FileSaveResult)localObject2).c);
      }
      int i = 0;
      label397:
      if (i == 0) {
        j = 2;
      }
      localObject2 = this.d;
      if (i != 0) {
        i = k;
      } else {
        i = -1;
      }
      ((FileSaveResult)localObject2).b = i;
      localObject2 = this.c.obtainMessage(j);
      ((Message)localObject2).obj = this.d;
      this.c.sendMessage((Message)localObject2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureSaveRunnable", 2, "save file fail");
    }
    Object localObject2 = this.c.obtainMessage(2);
    Object localObject3 = this.d;
    ((FileSaveResult)localObject3).c = 10003;
    ((FileSaveResult)localObject3).d = FileSaveErrorInfo.a(((FileSaveResult)localObject3).c);
    ((Message)localObject2).obj = this.d;
    this.c.sendMessage((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */