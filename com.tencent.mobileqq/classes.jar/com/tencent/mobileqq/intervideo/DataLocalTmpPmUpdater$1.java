package com.tencent.mobileqq.intervideo;

import java.io.File;
import java.util.concurrent.Callable;

class DataLocalTmpPmUpdater$1
  implements Callable<File>
{
  DataLocalTmpPmUpdater$1(DataLocalTmpPmUpdater paramDataLocalTmpPmUpdater) {}
  
  public File a()
  {
    if (DataLocalTmpPmUpdater.a(this.a).exists()) {
      return DataLocalTmpPmUpdater.a(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.DataLocalTmpPmUpdater.1
 * JD-Core Version:    0.7.0.1
 */