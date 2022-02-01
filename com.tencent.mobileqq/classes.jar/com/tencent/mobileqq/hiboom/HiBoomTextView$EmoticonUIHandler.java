package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import java.lang.ref.WeakReference;

class HiBoomTextView$EmoticonUIHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    HiBoomTextView.EmoticonHolder localEmoticonHolder = (HiBoomTextView.EmoticonHolder)paramMessage.obj;
    if (localEmoticonHolder == null) {
      return;
    }
    HiBoomTextView localHiBoomTextView = (HiBoomTextView)HiBoomTextView.EmoticonHolder.a(localEmoticonHolder).get();
    if (localHiBoomTextView != null)
    {
      if (HiBoomTextView.a(localHiBoomTextView) == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 257)
      {
        if (i != 259) {
          return;
        }
        if (localHiBoomTextView != null)
        {
          if (HiBoomTextView.a(localHiBoomTextView) == null) {
            return;
          }
          if ((localHiBoomTextView.getVisibility() != 0) || (localEmoticonHolder == null) || (HiBoomTextView.a(localHiBoomTextView) != HiBoomTextView.EmoticonHolder.a(localEmoticonHolder)) || (localHiBoomTextView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$BitmapLocker.a() != HiBoomTextView.EmoticonHolder.a(localEmoticonHolder)) || (HiBoomTextView.a(localHiBoomTextView).currentFrameIndex() != HiBoomTextView.EmoticonHolder.b(localEmoticonHolder)) || (HiBoomTextView.a(localHiBoomTextView) == null) || (!HiBoomTextView.a(localHiBoomTextView).equals(HiBoomTextView.EmoticonHolder.a(localEmoticonHolder)))) {
            return;
          }
          localHiBoomTextView.invalidate();
          boolean bool1;
          if ((HiBoomTextView.b(localHiBoomTextView)) && (!HiBoomTextView.c(localHiBoomTextView)) && (HiBoomTextView.c())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          boolean bool2 = bool1;
          if (bool1)
          {
            paramMessage = HiBoomTextView.a(localHiBoomTextView);
            if (paramMessage.nextFrame())
            {
              int j = paramMessage.getFrameDelay();
              long l = System.currentTimeMillis() - HiBoomTextView.EmoticonHolder.b(localEmoticonHolder);
              i = j;
              if (l > 0L) {
                i = (int)(j - l);
              }
              if (i <= 1) {
                sendMessage(obtainMessage(257, HiBoomTextView.EmoticonHolder.a(localHiBoomTextView)));
              } else {
                sendMessageDelayed(obtainMessage(257, HiBoomTextView.EmoticonHolder.a(localHiBoomTextView)), i);
              }
              bool2 = true;
            }
            else
            {
              HiBoomTextView.a(localHiBoomTextView, true);
              HiBoomTextView.b(localHiBoomTextView, false);
              if (localHiBoomTextView.d()) {
                localHiBoomTextView.a(true);
              }
              bool2 = false;
            }
          }
          if (localHiBoomTextView.d()) {
            return;
          }
          HiBoomTextView.b(localHiBoomTextView, bool2);
        }
      }
      else if ((localHiBoomTextView.getVisibility() == 0) && (HiBoomTextView.jdField_a_of_type_AndroidOsHandler != null))
      {
        HiBoomTextView.jdField_a_of_type_AndroidOsHandler.obtainMessage(258, HiBoomTextView.EmoticonHolder.a(localHiBoomTextView)).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.EmoticonUIHandler
 * JD-Core Version:    0.7.0.1
 */