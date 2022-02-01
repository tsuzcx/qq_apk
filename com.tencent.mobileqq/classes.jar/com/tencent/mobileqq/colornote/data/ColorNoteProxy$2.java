package com.tencent.mobileqq.colornote.data;

import com.tencent.mobileqq.persistence.EntityManager;

class ColorNoteProxy$2
  implements Runnable
{
  ColorNoteProxy$2(ColorNoteProxy paramColorNoteProxy, ColorNote paramColorNote) {}
  
  public void run()
  {
    if (ColorNoteProxy.a(this.this$0) != null) {
      ColorNoteProxy.a(this.this$0).remove(this.a);
    }
    ColorNoteProxy.a(this.this$0, 2, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteProxy.2
 * JD-Core Version:    0.7.0.1
 */