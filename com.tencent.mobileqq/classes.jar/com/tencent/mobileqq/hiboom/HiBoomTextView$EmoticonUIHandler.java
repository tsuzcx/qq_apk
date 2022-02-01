package com.tencent.mobileqq.hiboom;

import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import java.lang.ref.WeakReference;

class HiBoomTextView$EmoticonUIHandler
  extends Handler
{
  private void a(HiBoomTextView.EmoticonHolder paramEmoticonHolder, HiBoomTextView paramHiBoomTextView)
  {
    if (b(paramEmoticonHolder, paramHiBoomTextView))
    {
      paramHiBoomTextView.invalidate();
      boolean bool1;
      if ((HiBoomTextView.h(paramHiBoomTextView)) && (!HiBoomTextView.i(paramHiBoomTextView)) && (HiBoomTextView.d())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = c(paramEmoticonHolder, paramHiBoomTextView);
      }
      if (!paramHiBoomTextView.i()) {
        HiBoomTextView.a(paramHiBoomTextView, bool2);
      }
    }
  }
  
  private boolean b(HiBoomTextView.EmoticonHolder paramEmoticonHolder, HiBoomTextView paramHiBoomTextView)
  {
    return (paramEmoticonHolder != null) && (HiBoomTextView.c(paramHiBoomTextView) == HiBoomTextView.EmoticonHolder.g(paramEmoticonHolder)) && (paramHiBoomTextView.d.a() == HiBoomTextView.EmoticonHolder.a(paramEmoticonHolder)) && (HiBoomTextView.g(paramHiBoomTextView).currentFrameIndex() == HiBoomTextView.EmoticonHolder.e(paramEmoticonHolder)) && (HiBoomTextView.e(paramHiBoomTextView) != null) && (HiBoomTextView.e(paramHiBoomTextView).equals(HiBoomTextView.EmoticonHolder.c(paramEmoticonHolder)));
  }
  
  private boolean c(HiBoomTextView.EmoticonHolder paramEmoticonHolder, HiBoomTextView paramHiBoomTextView)
  {
    EMEmoticon localEMEmoticon = HiBoomTextView.g(paramHiBoomTextView);
    if (localEMEmoticon.nextFrame())
    {
      int j = localEMEmoticon.getFrameDelay();
      long l = System.currentTimeMillis() - HiBoomTextView.EmoticonHolder.h(paramEmoticonHolder);
      int i = j;
      if (l > 0L) {
        i = (int)(j - l);
      }
      if (i <= 1) {
        sendMessage(obtainMessage(257, HiBoomTextView.EmoticonHolder.a(paramHiBoomTextView)));
      } else {
        sendMessageDelayed(obtainMessage(257, HiBoomTextView.EmoticonHolder.a(paramHiBoomTextView)), i);
      }
      return true;
    }
    HiBoomTextView.b(paramHiBoomTextView, true);
    HiBoomTextView.a(paramHiBoomTextView, false);
    if (paramHiBoomTextView.i()) {
      paramHiBoomTextView.a(true);
    }
    return false;
  }
  
  public void handleMessage(Message paramMessage)
  {
    HiBoomTextView.EmoticonHolder localEmoticonHolder = (HiBoomTextView.EmoticonHolder)paramMessage.obj;
    if (localEmoticonHolder == null) {
      return;
    }
    HiBoomTextView localHiBoomTextView = (HiBoomTextView)HiBoomTextView.EmoticonHolder.f(localEmoticonHolder).get();
    if (localHiBoomTextView != null)
    {
      if (HiBoomTextView.g(localHiBoomTextView) == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 257)
      {
        if (i != 259) {
          return;
        }
        if (localHiBoomTextView.getVisibility() == 0) {
          a(localEmoticonHolder, localHiBoomTextView);
        }
      }
      else if ((localHiBoomTextView.getVisibility() == 0) && (HiBoomTextView.j != null))
      {
        HiBoomTextView.j.obtainMessage(258, HiBoomTextView.EmoticonHolder.a(localHiBoomTextView)).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.EmoticonUIHandler
 * JD-Core Version:    0.7.0.1
 */