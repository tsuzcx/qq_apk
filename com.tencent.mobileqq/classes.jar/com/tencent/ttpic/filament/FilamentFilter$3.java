package com.tencent.ttpic.filament;

import com.tencent.ttpic.openapi.model.GLBItemJava;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FilamentFilter$3
  implements Runnable
{
  FilamentFilter$3(FilamentFilter paramFilamentFilter) {}
  
  public void run()
  {
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.IO.tag);
    if (FilamentFilter.access$900(this.this$0).size() == 0)
    {
      Iterator localIterator = FilamentFilter.access$1000(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        GLBItemJava localGLBItemJava = (GLBItemJava)localIterator.next();
        byte[] arrayOfByte = FilamentUtil.decryptGlb(localGLBItemJava.path);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          FilamentFilter.access$900(this.this$0).put(localGLBItemJava, arrayOfByte);
        }
      }
    }
    FilamentFilter.access$1102(this.this$0, true);
    FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.IO.tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter.3
 * JD-Core Version:    0.7.0.1
 */