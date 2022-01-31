package cooperation.qzone.widget;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class FastAnimationDrawable$InvalidationHandler
  extends Handler
{
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public FastAnimationDrawable$InvalidationHandler(FastAnimationDrawable paramFastAnimationDrawable, Drawable paramDrawable)
  {
    super(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDrawable);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (Drawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramMessage != null) {
      paramMessage.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.FastAnimationDrawable.InvalidationHandler
 * JD-Core Version:    0.7.0.1
 */