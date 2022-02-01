package com.tencent.mobileqq.studyroom.updater;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class AssetsPmUpdater$1
  implements Callable<File>
{
  AssetsPmUpdater$1(AssetsPmUpdater paramAssetsPmUpdater) {}
  
  public File a()
  {
    if ((!AssetsPmUpdater.a(this.a).exists()) || (!AssetsPmUpdater.b(this.a)))
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a;
      if (AssetsPmUpdater.a((AssetsPmUpdater)localObject, AssetsPmUpdater.c((AssetsPmUpdater)localObject), AssetsPmUpdater.d(this.a), AssetsPmUpdater.a(this.a).getAbsolutePath()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("copy asset pm success, cost=");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        QLog.i("studyroom.AssetsPmUpdater", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
      }
    }
    if (AssetsPmUpdater.a(this.a).exists()) {
      return AssetsPmUpdater.a(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.AssetsPmUpdater.1
 * JD-Core Version:    0.7.0.1
 */