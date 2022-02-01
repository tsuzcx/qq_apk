import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class mpb
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mpa> jdField_a_of_type_JavaLangRefWeakReference;
  
  mpb(String paramString, mpa parammpa)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammpa);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mpa localmpa = (mpa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmpa != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mpa.a(localmpa);
    lbd.f(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mpb
 * JD-Core Version:    0.7.0.1
 */