import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class hm
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    hj localhj = (hj)paramMessage.obj;
    if (localhj == null) {}
    ETTextView localETTextView;
    do
    {
      do
      {
        do
        {
          return;
          localETTextView = (ETTextView)localhj.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localETTextView == null) || (ETTextView.access$600(localETTextView) == null));
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      } while ((!localETTextView.isViewVisible()) || (ETTextView.mCreateDecorationHandler == null));
      ETTextView.mCreateDecorationHandler.obtainMessage(2, hj.a(localETTextView)).sendToTarget();
      return;
    } while (!localETTextView.isViewVisible());
    boolean bool;
    int i;
    if ((ETTextView.access$400(localETTextView).a() == localhj.jdField_a_of_type_AndroidGraphicsBitmap) && (localETTextView.mMsgId == localhj.jdField_a_of_type_Long) && (ETTextView.access$600(localETTextView) != null) && (ETTextView.access$600(localETTextView).currentFrameIndex() == localhj.jdField_a_of_type_Int) && (localETTextView.mFont != null) && (localETTextView.mFont.equals(localhj.jdField_a_of_type_Ha.a))) {
      if ((ETTextView.access$700(localETTextView)) && (ETTextView.access$800(localETTextView)) && (ETTextView.enableAnimation) && (!ETTextView.access$900(localETTextView)))
      {
        bool = true;
        if (!bool) {
          break label388;
        }
        localETTextView.postInvalidate();
        paramMessage = ETTextView.access$600(localETTextView);
        if (!paramMessage.nextFrame()) {
          break label319;
        }
        i = paramMessage.getFrameDelay();
        int j = (int)(System.currentTimeMillis() - localhj.b);
        if (j <= 0) {
          break label385;
        }
        i -= j;
        label268:
        paramMessage = obtainMessage(0, hj.a(localETTextView));
        if (i > 1) {
          break label308;
        }
        sendMessage(paramMessage);
        label290:
        bool = true;
      }
    }
    label385:
    label388:
    for (;;)
    {
      ETTextView.access$702(localETTextView, bool);
      return;
      bool = false;
      break;
      label308:
      sendMessageDelayed(paramMessage, i);
      break label290;
      label319:
      localETTextView.shouldStartAnimation = false;
      localETTextView.postInvalidateDelayed(100L);
      if ((localETTextView.mAnimationListener != null) && (localETTextView.mFont != null)) {
        localETTextView.mAnimationListener.a(localETTextView.mMessage, localETTextView.mFont.mFontId);
      }
      bool = false;
      continue;
      QLog.e("ETTextView", 2, "this textView reused!");
      return;
      break label268;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     hm
 * JD-Core Version:    0.7.0.1
 */