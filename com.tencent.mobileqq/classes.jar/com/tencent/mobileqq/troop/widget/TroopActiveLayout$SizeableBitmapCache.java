package com.tencent.mobileqq.troop.widget;

import android.graphics.Bitmap;
import com.tencent.commonsdk.cache.Sizeable;
import java.util.concurrent.ConcurrentHashMap;

class TroopActiveLayout$SizeableBitmapCache
  extends ConcurrentHashMap<Integer, Bitmap>
  implements Sizeable
{
  private int mFixSize;
  
  TroopActiveLayout$SizeableBitmapCache(int paramInt)
  {
    this.mFixSize = paramInt;
  }
  
  public int getByteSize()
  {
    return this.mFixSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopActiveLayout.SizeableBitmapCache
 * JD-Core Version:    0.7.0.1
 */