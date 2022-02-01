package com.tencent.mobileqq.colornote.api.impl;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.persistence.EntityManager;

class ColorNoteDataServiceImpl$2
  implements Runnable
{
  ColorNoteDataServiceImpl$2(ColorNoteDataServiceImpl paramColorNoteDataServiceImpl, ColorNote paramColorNote) {}
  
  public void run()
  {
    if (ColorNoteDataServiceImpl.access$100(this.this$0) != null) {
      ColorNoteDataServiceImpl.access$100(this.this$0).remove(this.a);
    }
    ColorNoteDataServiceImpl.access$200(this.this$0, 2, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */