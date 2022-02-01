package com.tencent.mobileqq.vas.trooppobing;

import android.graphics.Bitmap;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.image.Utils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PobingDecoder$BitmapsCache
  implements Sizeable
{
  public int a;
  public HashMap<Integer, Bitmap> a = new HashMap();
  public int b;
  public HashMap<Integer, String> b = new HashMap();
  
  public String a(int paramInt)
  {
    String str2 = (String)this.b.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public int getByteSize()
  {
    Iterator localIterator = this.a.values().iterator();
    for (int i = 0; localIterator.hasNext(); i = Utils.getBitmapSize((Bitmap)localIterator.next()) + i) {}
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache
 * JD-Core Version:    0.7.0.1
 */