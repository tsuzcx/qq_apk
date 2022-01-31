package com.tencent.mobileqq.emoticonview;

import android.graphics.drawable.Drawable;

public abstract interface EmoticonCallback
{
  public abstract void a(EmoticonInfo paramEmoticonInfo);
  
  public abstract void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable);
  
  public abstract boolean a(EmoticonInfo paramEmoticonInfo);
  
  public abstract void b();
  
  public abstract void b(EmoticonInfo paramEmoticonInfo);
  
  public abstract void c();
  
  public abstract void setting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonCallback
 * JD-Core Version:    0.7.0.1
 */