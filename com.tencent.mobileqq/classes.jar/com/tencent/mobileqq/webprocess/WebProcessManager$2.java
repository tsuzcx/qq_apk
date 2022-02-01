package com.tencent.mobileqq.webprocess;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class WebProcessManager$2
  extends BabyQObserver
{
  WebProcessManager$2(WebProcessManager paramWebProcessManager) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    int j = -1;
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if ((paramObject instanceof Bundle))
      {
        paramObject = (Bundle)paramObject;
        j = paramObject.getInt("ad_bbq_code", -1);
        i = j;
        if (j == 0)
        {
          paramObject = paramObject.getString("ad_bbq_message");
          Object localObject = BaseApplicationImpl.getApplication().getRuntime();
          i = j;
          if ((localObject instanceof QQAppInterface))
          {
            localObject = (BabyQHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
            i = j;
            if (localObject != null)
            {
              ((BabyQHandler)localObject).c(paramObject);
              i = j;
            }
          }
        }
      }
    }
    paramObject = new Intent("com.tencent.mobileqq.babyq.added");
    paramObject.setPackage(BaseApplicationImpl.getApplication().getPackageName());
    paramObject.putExtra("result", i);
    BaseApplicationImpl.getApplication().sendBroadcast(paramObject);
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("babyq observer return result=");
      paramObject.append(i);
      QLog.d("WebProcessManager", 2, paramObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.2
 * JD-Core Version:    0.7.0.1
 */