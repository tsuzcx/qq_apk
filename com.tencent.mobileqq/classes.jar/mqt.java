import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class mqt
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mqs> jdField_a_of_type_JavaLangRefWeakReference;
  
  mqt(String paramString, mqs parammqs)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammqs);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mqs localmqs = (mqs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmqs != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mqs.a(localmqs);
    lek.c(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqt
 * JD-Core Version:    0.7.0.1
 */