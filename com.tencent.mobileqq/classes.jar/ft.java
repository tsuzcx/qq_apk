import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ft
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    fq localfq = (fq)paramMessage.obj;
    if (localfq == null) {}
    ETTextView localETTextView;
    do
    {
      do
      {
        do
        {
          return;
          localETTextView = (ETTextView)localfq.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localETTextView == null) || (ETTextView.a(localETTextView) == null));
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      } while ((!localETTextView.g()) || (ETTextView.jdField_a_of_type_AndroidOsHandler == null));
      ETTextView.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, fq.a(localETTextView)).sendToTarget();
      return;
    } while (!localETTextView.g());
    boolean bool;
    int i;
    if ((ETTextView.a(localETTextView).a() == localfq.jdField_a_of_type_AndroidGraphicsBitmap) && (localETTextView.jdField_a_of_type_Long == localfq.jdField_a_of_type_Long) && (ETTextView.a(localETTextView) != null) && (ETTextView.a(localETTextView).currentFrameIndex() == localfq.jdField_a_of_type_Int) && (localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(localfq.jdField_a_of_type_Fh.jdField_a_of_type_ComEtrumpMixlayoutETFont))) {
      if ((ETTextView.a(localETTextView)) && (ETTextView.b(localETTextView)) && (ETTextView.f) && (!ETTextView.c(localETTextView)))
      {
        bool = true;
        if (!bool) {
          break label388;
        }
        localETTextView.invalidate();
        paramMessage = ETTextView.a(localETTextView);
        if (!paramMessage.nextFrame()) {
          break label319;
        }
        i = paramMessage.getFrameDelay();
        int j = (int)(System.currentTimeMillis() - localfq.b);
        if (j <= 0) {
          break label385;
        }
        i -= j;
        label268:
        paramMessage = obtainMessage(0, fq.a(localETTextView));
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
      ETTextView.a(localETTextView, bool);
      return;
      bool = false;
      break;
      label308:
      sendMessageDelayed(paramMessage, i);
      break label290;
      label319:
      localETTextView.d = false;
      localETTextView.postInvalidateDelayed(100L);
      if ((localETTextView.jdField_a_of_type_Fs != null) && (localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)) {
        localETTextView.jdField_a_of_type_Fs.a(localETTextView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
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
 * Qualified Name:     ft
 * JD-Core Version:    0.7.0.1
 */