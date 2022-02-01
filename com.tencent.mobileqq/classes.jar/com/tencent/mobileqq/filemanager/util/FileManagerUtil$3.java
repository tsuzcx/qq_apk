package com.tencent.mobileqq.filemanager.util;

import aumo;
import bhmi;
import java.io.File;

public final class FileManagerUtil$3
  implements Runnable
{
  public void run()
  {
    Object localObject2 = aumo.a().b();
    Object localObject1 = aumo.a().c();
    File localFile = new File((String)localObject2);
    if (!bhmi.a((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!bhmi.a((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(aumo.a().b() + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.3
 * JD-Core Version:    0.7.0.1
 */