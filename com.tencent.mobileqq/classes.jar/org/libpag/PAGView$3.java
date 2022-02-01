package org.libpag;

import java.util.ArrayList;
import java.util.Iterator;

class PAGView$3
  implements Runnable
{
  PAGView$3(PAGView paramPAGView) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      ArrayList localArrayList = new ArrayList(PAGView.access$600(this.this$0));
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((PAGView.PAGFlushListener)((Iterator)???).next()).onFlush();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.libpag.PAGView.3
 * JD-Core Version:    0.7.0.1
 */