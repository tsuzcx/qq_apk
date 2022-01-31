package com.tencent.mobileqq.mini.sdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import mqq.app.AppRuntime;

final class MiniAppController$1
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (MiniAppEntityManager)((AppRuntime)localObject).getManager(330);
      if (localObject != null) {
        ((MiniAppEntityManager)localObject).checkDB();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppController.1
 * JD-Core Version:    0.7.0.1
 */