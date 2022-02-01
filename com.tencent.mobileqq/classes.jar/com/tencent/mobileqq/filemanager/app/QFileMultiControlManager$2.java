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
  
  protected void a(Object paramObject)
  {
    Object localObject1 = (TroopFileStatusInfo)paramObject;
    if (localObject1 == null) {
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append(((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long);
    paramObject.append("");
    paramObject = paramObject.toString();
    Object localObject2 = ((TroopFileStatusInfo)localObject1).e;
    QFileControlReq localQFileControlReq = this.a.a("1", paramObject, (String)localObject2);
    if (localQFileControlReq != null)
    {
      switch (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int)
      {
      default: 
        return;
      case 11: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("troop file download is finish. fileId[");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("]");
        QLog.i("QFileMultiControlManager<QFile>", 1, localStringBuilder.toString());
        if (localQFileControlReq.a() != null)
        {
          localObject2 = new Bundle();
          boolean bool = FileUtils.fileExistsAndNotEmpty(((TroopFileStatusInfo)localObject1).a);
          localQFileControlReq.a().a(bool, Integer.parseInt("1"), paramObject, (Bundle)localObject2);
        }
        this.a.b(localQFileControlReq);
        return;
      case 9: 
      case 10: 
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("troop file download is stop. fileId[");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("]");
        QLog.i("QFileMultiControlManager<QFile>", 1, ((StringBuilder)localObject1).toString());
        if (localQFileControlReq.a() != null)
        {
          localObject1 = new Bundle();
          localQFileControlReq.a().a(false, Integer.parseInt("1"), paramObject, (Bundle)localObject1);
        }
        this.a.b(localQFileControlReq);
        return;
      }
      if (localQFileControlReq.a() != null)
      {
        localObject2 = new Bundle();
        int i = (int)((float)((TroopFileStatusInfo)localObject1).d * 1.0F / ((float)((TroopFileStatusInfo)localObject1).c * 1.0F) * 100.0F);
        localQFileControlReq.a().a(0, Integer.parseInt("1"), paramObject, i, (Bundle)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMultiControlManager.2
 * JD-Core Version:    0.7.0.1
 */