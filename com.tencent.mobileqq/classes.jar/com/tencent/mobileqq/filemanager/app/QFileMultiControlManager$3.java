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
  
  protected void a(long paramLong, float paramFloat)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (QFileMultiControlManager.a(this.a).getMessageFacade().d(i).a(paramLong) == null) {
      return;
    }
    Object localObject1 = this.a;
    Object localObject2 = AppConstants.DATALINE_PC_UIN;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localObject1 = ((QFileMultiControlManager)localObject1).a("6000", (String)localObject2, localStringBuilder.toString());
    if (localObject1 != null)
    {
      localObject1 = ((QFileControlReq)localObject1).b();
      if (localObject1 != null)
      {
        i = (int)(paramFloat * 100.0F);
        localObject2 = new Bundle();
        ((QFileControlCallback)localObject1).a(0, 6000, AppConstants.DATALINE_PC_UIN, i, (Bundle)localObject2);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (QFileMultiControlManager.a(this.a).getMessageFacade().d(i).a(paramLong) == null) {
      return;
    }
    paramString = this.a;
    Object localObject1 = AppConstants.DATALINE_PC_UIN;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("");
    paramString = paramString.a("6000", (String)localObject1, ((StringBuilder)localObject2).toString());
    if ((paramString != null) && (paramString.b() != null))
    {
      localObject1 = paramString.b();
      localObject2 = new Bundle();
      ((QFileControlCallback)localObject1).a(paramBoolean, 6000, AppConstants.DATALINE_PC_UIN, (Bundle)localObject2);
    }
    if (paramString != null) {
      this.a.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMultiControlManager.3
 * JD-Core Version:    0.7.0.1
 */