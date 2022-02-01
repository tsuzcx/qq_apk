package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QFileMultiSaveReq
{
  public ChatMessage a;
  private QQAppInterface b;
  private QFileSaveReqUiCallback c;
  private QFileSaveModel d;
  
  public QFileMultiSaveReq(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.b = paramQQAppInterface;
    this.a = paramChatMessage;
    this.d = QFileSaveModel.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    QFileSaveModel localQFileSaveModel = this.d;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.g();
    }
    return 0L;
  }
  
  public void a(QFileSaveReqUiCallback paramQFileSaveReqUiCallback)
  {
    this.c = paramQFileSaveReqUiCallback;
    paramQFileSaveReqUiCallback = this.d;
    if (paramQFileSaveReqUiCallback != null) {
      paramQFileSaveReqUiCallback.a(this.c);
    }
  }
  
  public void a(String paramString, QFileMultiSaveReq.ISaveFileCallBack paramISaveFileCallBack)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      if (paramISaveFileCallBack != null) {
        paramISaveFileCallBack.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramISaveFileCallBack));
  }
  
  public String b()
  {
    QFileSaveModel localQFileSaveModel = this.d;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.f();
    }
    return "";
  }
  
  public QFileControlReq c()
  {
    QFileSaveModel localQFileSaveModel = this.d;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.e();
    }
    return null;
  }
  
  public String d()
  {
    QFileSaveModel localQFileSaveModel = this.d;
    if (localQFileSaveModel != null) {
      return localQFileSaveModel.c();
    }
    return "";
  }
  
  public boolean e()
  {
    return FileUtils.fileExistsAndNotEmpty(d());
  }
  
  public boolean f()
  {
    QFileSaveModel localQFileSaveModel = this.d;
    if (localQFileSaveModel != null) {
      localQFileSaveModel.d();
    }
    return false;
  }
  
  public void g()
  {
    Object localObject = this.d;
    boolean bool;
    if (localObject != null) {
      bool = ((QFileSaveModel)localObject).a();
    } else {
      bool = false;
    }
    if (!bool)
    {
      QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
      localObject = this.c;
      if (localObject != null) {
        ((QFileSaveReqUiCallback)localObject).a(false);
      }
    }
  }
  
  public void h()
  {
    Object localObject = this.d;
    boolean bool;
    if (localObject != null) {
      bool = ((QFileSaveModel)localObject).b();
    } else {
      bool = false;
    }
    if (!bool)
    {
      QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
      localObject = this.c;
      if (localObject != null) {
        ((QFileSaveReqUiCallback)localObject).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq
 * JD-Core Version:    0.7.0.1
 */