package com.tencent.ttpic.filament;

import com.tencent.ttpic.openapi.model.GLBItemJava;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FilamentFilter$4
  implements Runnable
{
  FilamentFilter$4(FilamentFilter paramFilamentFilter) {}
  
  public void run()
  {
    if (FilamentFilter.access$900(this.this$0).size() == 0)
    {
      Iterator localIterator = FilamentFilter.access$1000(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        GLBItemJava localGLBItemJava = (GLBItemJava)localIterator.next();
        byte[] arrayOfByte = FilamentFilter.access$1100(this.this$0, localGLBItemJava);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          FilamentFilter.access$900(this.this$0).put(localGLBItemJava, arrayOfByte);
        }
      }
    }
    FilamentFilter.access$1202(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter.4
 * JD-Core Version:    0.7.0.1
 */