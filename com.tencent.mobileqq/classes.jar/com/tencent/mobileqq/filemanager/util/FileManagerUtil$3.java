package com.tencent.mobileqq.filemanager.util;

import arqx;
import bdhb;
import java.io.File;

public final class FileManagerUtil$3
  implements Runnable
{
  public void run()
  {
    Object localObject2 = arqx.a().b();
    Object localObject1 = arqx.a().c();
    File localFile = new File((String)localObject2);
    if (!bdhb.a((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!bdhb.a((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(arqx.a().b() + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.3
 * JD-Core Version:    0.7.0.1
 */