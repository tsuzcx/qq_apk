package com.tencent.mobileqq.filemanager.util;

import atut;
import bgmg;
import java.io.File;

public final class FileManagerUtil$3
  implements Runnable
{
  public void run()
  {
    Object localObject2 = atut.a().b();
    Object localObject1 = atut.a().c();
    File localFile = new File((String)localObject2);
    if (!bgmg.a((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!bgmg.a((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(atut.a().b() + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.3
 * JD-Core Version:    0.7.0.1
 */