package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.multisave.QFileControlCallback;
import com.tencent.mobileqq.filemanager.multisave.QFileControlReq;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class QFileMultiControlManager$2
  extends BizTroopObserver
{
  QFileMultiControlManager$2(QFileMultiControlManager paramQFileMultiControlManager) {}
  
  public void onTroopFileStatusUpdate(Object paramObject)
  {
    Object localObject1 = (TroopFileStatusInfo)paramObject;
    if (localObject1 == null) {}
    QFileControlReq localQFileControlReq;
    do
    {
      do
      {
        return;
        paramObject = ((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long + "";
        localObject2 = ((TroopFileStatusInfo)localObject1).e;
        localQFileControlReq = this.a.a("1", paramObject, (String)localObject2);
      } while (localQFileControlReq == null);
      switch (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while (localQFileControlReq.a() == null);
    Object localObject2 = new Bundle();
    int i = (int)((float)((TroopFileStatusInfo)localObject1).d * 1.0F / ((float)((TroopFileStatusInfo)localObject1).c * 1.0F) * 100.0F);
    localQFileControlReq.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is finish. fileId[" + (String)localObject2 + "]");
    if (localQFileControlReq.a() != null)
    {
      localObject2 = new Bundle();
      boolean bool = FileUtils.b(((TroopFileStatusInfo)localObject1).a);
      localQFileControlReq.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
    }
    this.a.b(localQFileControlReq);
    return;
    QLog.i("QFileMultiControlManager<QFile>", 1, "troop file download is stop. fileId[" + (String)localObject2 + "]");
    if (localQFileControlReq.a() != null)
    {
      localObject1 = new Bundle();
      localQFileControlReq.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
    }
    this.a.b(localQFileControlReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMultiControlManager.2
 * JD-Core Version:    0.7.0.1
 */