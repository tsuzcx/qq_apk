package com.tencent.mobileqq.filemanager.util;

import aptm;
import bbdx;
import java.io.File;

public final class FileManagerUtil$3
  implements Runnable
{
  public void run()
  {
    Object localObject2 = aptm.a().b();
    Object localObject1 = aptm.a().c();
    File localFile = new File((String)localObject2);
    if (!bbdx.a((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!bbdx.a((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(aptm.a().b() + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.3
 * JD-Core Version:    0.7.0.1
 */