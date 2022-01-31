import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETTextView;
import java.lang.ref.WeakReference;

public class fr
  extends Handler
{
  public fr(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    ETEngine localETEngine;
    Bitmap localBitmap;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
      do
      {
        return;
        paramMessage = (fs)paramMessage.obj;
      } while (paramMessage == null);
      i = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      int j = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      if ((ETTextView.access$300() != null) && ((ETTextView.access$300().getWidth() < i) || (ETTextView.access$300().getHeight() < j)))
      {
        ETTextView.access$300().recycle();
        ETTextView.access$302(null);
      }
      if (ETTextView.access$300() == null)
      {
        ETTextView.access$302(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = ETEngine.getInstanceForAnimation();
        ??? = paramMessage.jdField_a_of_type_Fj.a(localETEngine, false);
        if (??? != null) {
          ((ETDecoration)???).gotoFrame(paramMessage.jdField_a_of_type_Int);
        }
        paramMessage.jdField_a_of_type_Fj.a(localETEngine, ETTextView.access$300(), (ETDecoration)???, true);
        if (??? != null) {
          ((ETDecoration)???).deleteDescriptor();
        }
        localBitmap = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap;
        if (paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
          break label308;
        }
      }
      break;
    }
    for (;;)
    {
      synchronized (ETTextView.access$400((ETTextView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        if ((localBitmap.isRecycled()) || (((ETTextView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get()).mMsgId != paramMessage.jdField_a_of_type_Long)) {
          break label303;
        }
        localBitmap.eraseColor(0);
        localETEngine.native_cloneBitmap(ETTextView.access$300(), localBitmap);
        i = 1;
        if (i == 0) {
          break;
        }
        ETTextView.access$500().obtainMessage(1, paramMessage).sendToTarget();
        return;
        ETTextView.access$300().eraseColor(0);
      }
      if (ETTextView.access$300() == null) {
        break;
      }
      ETTextView.access$300().recycle();
      ETTextView.access$302(null);
      return;
      label303:
      i = 0;
      continue;
      label308:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fr
 * JD-Core Version:    0.7.0.1
 */