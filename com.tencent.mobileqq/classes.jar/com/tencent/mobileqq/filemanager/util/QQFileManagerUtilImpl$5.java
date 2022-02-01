package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

final class QQFileManagerUtilImpl$5
  implements Runnable
{
  public void run()
  {
    Object localObject2 = FMSettings.a().getDefaultRecvPath();
    Object localObject1 = FMSettings.a().getDefaultTmpPath();
    File localFile = new File((String)localObject2);
    if (!FileUtils.fileExists((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!FileUtils.fileExists((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FMSettings.a().getDefaultRecvPath());
    ((StringBuilder)localObject1).append(".nomedia");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.5
 * JD-Core Version:    0.7.0.1
 */