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
    if ((!AssetsPmUpdater.a(this.a).exists()) || (!AssetsPmUpdater.a(this.a)))
    {
      long l = System.currentTimeMillis();
      if (!AssetsPmUpdater.a(this.a, AssetsPmUpdater.a(this.a), AssetsPmUpdater.a(this.a), AssetsPmUpdater.a(this.a).getAbsolutePath())) {
        break label111;
      }
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
    }
    while (AssetsPmUpdater.a(this.a).exists())
    {
      return AssetsPmUpdater.a(this.a);
      label111:
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.AssetsPmUpdater.1
 * JD-Core Version:    0.7.0.1
 */