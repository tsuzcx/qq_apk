package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.multisave.QFileControlCallback;
import com.tencent.mobileqq.filemanager.multisave.QFileControlReq;

class QFileMultiControlManager$3
  extends DataLineObserver
{
  QFileMultiControlManager$3(QFileMultiControlManager paramQFileMultiControlManager) {}
  
  public void a(long paramLong, float paramFloat)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (QFileMultiControlManager.a(this.a).getMessageFacade().a(i).a(paramLong) == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.a.a("6000", AppConstants.DATALINE_PC_UIN, paramLong + "");
      } while (localObject == null);
      localObject = ((QFileControlReq)localObject).a();
    } while (localObject == null);
    i = (int)(100.0F * paramFloat);
    Bundle localBundle = new Bundle();
    ((QFileControlCallback)localObject).a(0, 6000, AppConstants.DATALINE_PC_UIN, i, localBundle);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (QFileMultiControlManager.a(this.a).getMessageFacade().a(i).a(paramLong) == null) {}
    do
    {
      return;
      paramString = this.a.a("6000", AppConstants.DATALINE_PC_UIN, paramLong + "");
      if ((paramString != null) && (paramString.a() != null))
      {
        QFileControlCallback localQFileControlCallback = paramString.a();
        Bundle localBundle = new Bundle();
        localQFileControlCallback.a(paramBoolean, 6000, AppConstants.DATALINE_PC_UIN, localBundle);
      }
    } while (paramString == null);
    this.a.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMultiControlManager.3
 * JD-Core Version:    0.7.0.1
 */