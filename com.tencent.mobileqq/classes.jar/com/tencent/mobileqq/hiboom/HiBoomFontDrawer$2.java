package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import java.util.List;
import java.util.Vector;

class HiBoomFontDrawer$2
  implements Runnable
{
  HiBoomFontDrawer$2(HiBoomFontDrawer paramHiBoomFontDrawer, List paramList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      Bitmap localBitmap = HiBoomFontDrawer.a((String)this.a.get(i));
      if (localBitmap != null) {
        GlobalImageCache.a.put(this.a.get(i), localBitmap);
      } else {
        this.this$0.a.add(this.a.get(i));
      }
      i += 1;
    }
    HiBoomFontDrawer.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.2
 * JD-Core Version:    0.7.0.1
 */