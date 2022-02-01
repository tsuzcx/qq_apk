package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.multisave.QFileControlCallback;
import com.tencent.mobileqq.filemanager.multisave.QFileControlReq;
import com.tencent.qphone.base.util.QLog;

class QFileMultiControlManager$1
  extends FMObserver
{
  QFileMultiControlManager$1(QFileMultiControlManager paramQFileMultiControlManager) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("");
    localObject2 = ((QFileMultiControlManager)localObject1).a((String)localObject2, paramString, localStringBuilder.toString());
    localObject1 = QFileMultiControlManager.a(this.a).getFileManagerDataCenter().a(paramLong2, paramLong1, paramString, paramInt);
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((QFileControlReq)localObject2).b();
      if (localObject2 != null) {
        ((QFileControlCallback)localObject2).a(0, paramInt, paramString, (int)(((FileManagerEntity)localObject1).fProgress * 100.0F), new Bundle());
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString2 = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("");
    paramString2 = paramString2.a((String)localObject, paramString1, localStringBuilder.toString());
    localObject = QFileMultiControlManager.a(this.a).getFileManagerDataCenter().a(paramLong2, paramLong1, paramString1, paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("offline file download is finish. isSuc[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("sessionId[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    if ((paramString2 != null) && (localObject != null) && (paramString2.b() != null)) {
      paramString2.b().a(paramBoolean, paramInt1, paramString1, new Bundle());
    }
    if (paramString2 != null) {
      this.a.b(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMultiControlManager.1
 * JD-Core Version:    0.7.0.1
 */