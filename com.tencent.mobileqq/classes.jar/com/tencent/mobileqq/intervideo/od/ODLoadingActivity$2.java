package com.tencent.mobileqq.intervideo.od;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.IVPluginManager;
import com.tencent.mobileqq.intervideo.impl.Shadow;
import java.util.concurrent.Callable;

class ODLoadingActivity$2
  implements Callable<IVPluginManager>
{
  ODLoadingActivity$2(ODLoadingActivity paramODLoadingActivity, String paramString) {}
  
  public IVPluginManager a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    return Shadow.b(this.b, this.a, localQQAppInterface.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity.2
 * JD-Core Version:    0.7.0.1
 */