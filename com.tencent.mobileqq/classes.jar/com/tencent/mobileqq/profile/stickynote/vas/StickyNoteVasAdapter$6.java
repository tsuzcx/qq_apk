package com.tencent.mobileqq.profile.stickynote.vas;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class StickyNoteVasAdapter$6
  implements URLDrawable.URLDrawableListener
{
  StickyNoteVasAdapter$6(StickyNoteVasAdapter paramStickyNoteVasAdapter) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.6
 * JD-Core Version:    0.7.0.1
 */