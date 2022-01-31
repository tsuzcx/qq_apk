import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class mnz
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mny> jdField_a_of_type_JavaLangRefWeakReference;
  
  mnz(String paramString, mny parammny)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammny);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mny localmny = (mny)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmny != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mny.a(localmny);
    lcg.c(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mnz
 * JD-Core Version:    0.7.0.1
 */