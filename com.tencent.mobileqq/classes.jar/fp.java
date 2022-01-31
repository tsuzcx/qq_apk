import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETTextView;
import java.lang.ref.WeakReference;

public class fp
  extends Handler
{
  public fp(Looper paramLooper)
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
        paramMessage = (fq)paramMessage.obj;
      } while (paramMessage == null);
      i = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      int j = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      if ((ETTextView.a() != null) && ((ETTextView.a().getWidth() < i) || (ETTextView.a().getHeight() < j)))
      {
        ETTextView.a().recycle();
        ETTextView.a(null);
      }
      if (ETTextView.a() == null)
      {
        ETTextView.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = ETEngine.getInstanceForAnimation();
        ??? = paramMessage.jdField_a_of_type_Fh.a(localETEngine, false);
        if (??? != null) {
          ((ETDecoration)???).gotoFrame(paramMessage.jdField_a_of_type_Int);
        }
        paramMessage.jdField_a_of_type_Fh.a(localETEngine, ETTextView.a(), (ETDecoration)???, true);
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
      synchronized (ETTextView.a((ETTextView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        if ((localBitmap.isRecycled()) || (((ETTextView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Long != paramMessage.jdField_a_of_type_Long)) {
          break label303;
        }
        localBitmap.eraseColor(0);
        localETEngine.native_cloneBitmap(ETTextView.a(), localBitmap);
        i = 1;
        if (i == 0) {
          break;
        }
        ETTextView.a().obtainMessage(1, paramMessage).sendToTarget();
        return;
        ETTextView.a().eraseColor(0);
      }
      if (ETTextView.a() == null) {
        break;
      }
      ETTextView.a().recycle();
      ETTextView.a(null);
      return;
      label303:
      i = 0;
      continue;
      label308:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     fp
 * JD-Core Version:    0.7.0.1
 */