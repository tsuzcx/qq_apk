package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.commonsdk.cache.QQLruCache;
import java.lang.ref.WeakReference;

final class HiBoomTextView$4
  extends Handler
{
  HiBoomTextView$4(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    HiBoomTextView.EmoticonHolder localEmoticonHolder;
    int i;
    ETEngine localETEngine;
    Object localObject1;
    switch (???.what)
    {
    case 259: 
    default: 
    case 258: 
      do
      {
        do
        {
          return;
          localEmoticonHolder = (HiBoomTextView.EmoticonHolder)???.obj;
        } while (localEmoticonHolder == null);
        i = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getWidth();
        int j = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getHeight();
        if ((HiBoomTextView.a() != null) && ((HiBoomTextView.a().getWidth() < i) || (HiBoomTextView.a().getHeight() < j)))
        {
          HiBoomTextView.a().recycle();
          HiBoomTextView.a(null);
        }
        if (HiBoomTextView.a() != null) {
          break;
        }
        HiBoomTextView.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = HiBoomFont.a().b;
        String str = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder) + HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getId() + HiBoomTextView.EmoticonHolder.a(localEmoticonHolder) + HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getSize();
        localObject1 = (EMEmoticon)HiBoomTextView.a().get(str);
        ??? = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = EMEmoticon.createEmoticon(localETEngine, HiBoomTextView.EmoticonHolder.a(localEmoticonHolder), HiBoomTextView.EmoticonHolder.a(localEmoticonHolder), HiBoomTextView.EmoticonHolder.a(localEmoticonHolder));
          ??? = (Message)localObject1;
          if (localObject1 != null)
          {
            HiBoomTextView.a().put(str, localObject1);
            ??? = (Message)localObject1;
          }
        }
      } while (??? == null);
      ???.gotoFrame(HiBoomTextView.EmoticonHolder.b(localEmoticonHolder));
      ???.drawFrame(HiBoomTextView.a());
      localObject1 = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder);
      if (HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).get() == null) {
        break;
      }
    }
    for (;;)
    {
      synchronized (((HiBoomTextView)HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).get()).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker)
      {
        if ((((Bitmap)localObject1).isRecycled()) || (HiBoomTextView.a((HiBoomTextView)HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).get()) != HiBoomTextView.EmoticonHolder.a(localEmoticonHolder))) {
          break label417;
        }
        ((Bitmap)localObject1).eraseColor(0);
        localETEngine.native_cloneBitmap(HiBoomTextView.a(), (Bitmap)localObject1);
        i = 1;
        if (i == 0) {
          break;
        }
        new Message().what = 259;
        HiBoomTextView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$EmoticonUIHandler.obtainMessage(259, localEmoticonHolder).sendToTarget();
        return;
        HiBoomTextView.a().eraseColor(0);
      }
      if (HiBoomTextView.a() == null) {
        break;
      }
      HiBoomTextView.a().recycle();
      HiBoomTextView.a(null);
      return;
      label417:
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.4
 * JD-Core Version:    0.7.0.1
 */