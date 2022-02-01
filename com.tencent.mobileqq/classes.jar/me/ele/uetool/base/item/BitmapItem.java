package me.ele.uetool.base.item;

import android.graphics.Bitmap;

public class BitmapItem
  extends Item
{
  private Bitmap bitmap;
  private String name;
  
  public BitmapItem(String paramString, Bitmap paramBitmap)
  {
    this.name = paramString;
    this.bitmap = paramBitmap;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isValid()
  {
    return this.bitmap != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.base.item.BitmapItem
 * JD-Core Version:    0.7.0.1
 */