package com.tencent.mobileqq.emoticonview;

import android.graphics.drawable.Drawable;

public abstract interface EmoticonCallback
{
  public abstract void delete();
  
  public abstract void emoticonMall();
  
  public abstract void onHidePopup(EmoticonInfo paramEmoticonInfo);
  
  public abstract boolean onLongClick(EmoticonInfo paramEmoticonInfo);
  
  public abstract void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable);
  
  public abstract void send();
  
  public abstract void send(EmoticonInfo paramEmoticonInfo);
  
  public abstract void setting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonCallback
 * JD-Core Version:    0.7.0.1
 */