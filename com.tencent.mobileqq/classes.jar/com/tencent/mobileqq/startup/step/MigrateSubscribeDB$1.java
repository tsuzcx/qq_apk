package com.tencent.mobileqq.startup.step;

import java.io.File;
import java.util.Comparator;

class MigrateSubscribeDB$1
  implements Comparator<File>
{
  MigrateSubscribeDB$1(MigrateSubscribeDB paramMigrateSubscribeDB) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile2.lastModified() - paramFile1.lastModified();
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB.1
 * JD-Core Version:    0.7.0.1
 */