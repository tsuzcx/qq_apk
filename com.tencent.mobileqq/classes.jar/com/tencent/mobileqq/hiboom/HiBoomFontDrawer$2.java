package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import aqxd;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;
import java.util.Vector;

public class HiBoomFontDrawer$2
  implements Runnable
{
  public HiBoomFontDrawer$2(aqxd paramaqxd, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      Bitmap localBitmap = aqxd.a((String)this.a.get(i));
      if (localBitmap != null) {
        BaseApplicationImpl.sImageCache.put(this.a.get(i), localBitmap);
      }
      for (;;)
      {
        i += 1;
        break;
        this.this$0.a.add(this.a.get(i));
      }
    }
    aqxd.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.2
 * JD-Core Version:    0.7.0.1
 */