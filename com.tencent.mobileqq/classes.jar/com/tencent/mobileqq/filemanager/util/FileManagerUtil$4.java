package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

final class FileManagerUtil$4
  implements Runnable
{
  public void run()
  {
    Object localObject2 = FMSettings.a().b();
    Object localObject1 = FMSettings.a().c();
    File localFile = new File((String)localObject2);
    if (!FileUtils.a((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!FileUtils.a((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(FMSettings.a().b() + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.4
 * JD-Core Version:    0.7.0.1
 */