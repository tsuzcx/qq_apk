import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class mny
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mnx> jdField_a_of_type_JavaLangRefWeakReference;
  
  mny(String paramString, mnx parammnx)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammnx);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mnx localmnx = (mnx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmnx != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mnx.a(localmnx);
    lbc.c(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mny
 * JD-Core Version:    0.7.0.1
 */