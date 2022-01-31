package com.tencent.mobileqq.hiboom;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.flashchat.FlashChatItem;

public class HiBoomItem
  extends FlashChatItem
{
  public Drawable a;
  public Drawable b;
  public int d = -1;
  public String g;
  public String h;
  
  public HiBoomItem()
  {
    this.b = 1;
  }
  
  public String toString()
  {
    return "HiBoomItem: id = " + this.a + " bgUrl = " + this.g + " cornerUrl = " + this.h + " progress = " + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomItem
 * JD-Core Version:    0.7.0.1
 */