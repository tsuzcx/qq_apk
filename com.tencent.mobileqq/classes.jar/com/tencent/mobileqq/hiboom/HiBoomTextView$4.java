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
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 258)
    {
      if (i != 260) {
        return;
      }
      if (HiBoomTextView.a() != null)
      {
        HiBoomTextView.a().recycle();
        HiBoomTextView.a(null);
      }
    }
    else
    {
      HiBoomTextView.EmoticonHolder localEmoticonHolder = (HiBoomTextView.EmoticonHolder)paramMessage.obj;
      if (localEmoticonHolder != null)
      {
        int k = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getWidth();
        int m = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getHeight();
        if ((HiBoomTextView.a() != null) && ((HiBoomTextView.a().getWidth() < k) || (HiBoomTextView.a().getHeight() < m)))
        {
          HiBoomTextView.a().recycle();
          HiBoomTextView.a(null);
        }
        paramMessage = HiBoomTextView.a();
        i = 0;
        int j = 0;
        if (paramMessage == null) {
          HiBoomTextView.a(Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888));
        } else {
          HiBoomTextView.a().eraseColor(0);
        }
        ETEngine localETEngine = HiBoomFont.a().b;
        paramMessage = new StringBuilder();
        paramMessage.append(HiBoomTextView.EmoticonHolder.a(localEmoticonHolder));
        paramMessage.append(HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getId());
        paramMessage.append(HiBoomTextView.EmoticonHolder.a(localEmoticonHolder));
        paramMessage.append(HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).getSize());
        String str = paramMessage.toString();
        Object localObject1 = (EMEmoticon)HiBoomTextView.a().get(str);
        paramMessage = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = EMEmoticon.createEmoticon(localETEngine, HiBoomTextView.EmoticonHolder.a(localEmoticonHolder), HiBoomTextView.EmoticonHolder.a(localEmoticonHolder), HiBoomTextView.EmoticonHolder.a(localEmoticonHolder));
          paramMessage = (Message)localObject1;
          if (localObject1 != null)
          {
            HiBoomTextView.a().put(str, localObject1);
            paramMessage = (Message)localObject1;
          }
        }
        if (paramMessage != null)
        {
          paramMessage.gotoFrame(HiBoomTextView.EmoticonHolder.b(localEmoticonHolder));
          paramMessage.drawFrame(HiBoomTextView.a());
          localObject1 = HiBoomTextView.EmoticonHolder.a(localEmoticonHolder);
          if (HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).get() != null)
          {
            paramMessage = ((HiBoomTextView)HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).get()).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker;
            i = j;
            try
            {
              if (!((Bitmap)localObject1).isRecycled())
              {
                i = j;
                if (HiBoomTextView.a((HiBoomTextView)HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).get()) == HiBoomTextView.EmoticonHolder.a(localEmoticonHolder))
                {
                  ((Bitmap)localObject1).eraseColor(0);
                  localETEngine.native_cloneBitmap(HiBoomTextView.a(), (Bitmap)localObject1);
                  i = 1;
                }
              }
            }
            finally {}
          }
          if (i != 0)
          {
            new Message().what = 259;
            HiBoomTextView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$EmoticonUIHandler.obtainMessage(259, localEmoticonHolder).sendToTarget();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.4
 * JD-Core Version:    0.7.0.1
 */