import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class mdd
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mdc> jdField_a_of_type_JavaLangRefWeakReference;
  
  mdd(String paramString, mdc parammdc)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammdc);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mdc localmdc = (mdc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmdc != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mdc.a(localmdc);
    krx.c(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdd
 * JD-Core Version:    0.7.0.1
 */