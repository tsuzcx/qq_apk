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
    if (i < this.a.size())
    {
      Bitmap localBitmap = HiBoomFontDrawer.a((String)this.a.get(i));
      if (localBitmap != null) {
        GlobalImageCache.a.put(this.a.get(i), localBitmap);
      }
      for (;;)
      {
        i += 1;
        break;
        this.this$0.a.add(this.a.get(i));
      }
    }
    HiBoomFontDrawer.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.2
 * JD-Core Version:    0.7.0.1
 */