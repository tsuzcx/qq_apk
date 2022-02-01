package com.tencent.mobileqq.colornote.data;

import aqcv;
import com.tencent.mobileqq.persistence.EntityManager;

public class ColorNoteProxy$2
  implements Runnable
{
  public ColorNoteProxy$2(aqcv paramaqcv, ColorNote paramColorNote) {}
  
  public void run()
  {
    if (aqcv.a(this.this$0) != null) {
      aqcv.a(this.this$0).remove(this.a);
    }
    aqcv.a(this.this$0, 2, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteProxy.2
 * JD-Core Version:    0.7.0.1
 */