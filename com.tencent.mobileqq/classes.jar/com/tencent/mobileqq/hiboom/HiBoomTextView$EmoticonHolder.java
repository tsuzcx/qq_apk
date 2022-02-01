package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import java.lang.ref.WeakReference;

class HiBoomTextView$EmoticonHolder
{
  private Bitmap a = null;
  private long b = -1L;
  private String c = null;
  private ETFont d = null;
  private int e = 0;
  private int f = 0;
  private long g = 0L;
  private WeakReference<HiBoomTextView> h;
  
  static EmoticonHolder a(HiBoomTextView paramHiBoomTextView)
  {
    EmoticonHolder localEmoticonHolder = null;
    if (paramHiBoomTextView != null)
    {
      localEmoticonHolder = new EmoticonHolder();
      localEmoticonHolder.b = HiBoomTextView.c(paramHiBoomTextView);
      localEmoticonHolder.c = HiBoomTextView.d(paramHiBoomTextView);
      localEmoticonHolder.d = new ETFont(0, null, 0.0F);
      localEmoticonHolder.d.copy(HiBoomTextView.e(paramHiBoomTextView));
      localEmoticonHolder.a = paramHiBoomTextView.d.a();
      localEmoticonHolder.e = HiBoomTextView.f(paramHiBoomTextView);
      localEmoticonHolder.f = HiBoomTextView.g(paramHiBoomTextView).currentFrameIndex();
      localEmoticonHolder.h = new WeakReference(paramHiBoomTextView);
      localEmoticonHolder.g = System.currentTimeMillis();
    }
    return localEmoticonHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.EmoticonHolder
 * JD-Core Version:    0.7.0.1
 */