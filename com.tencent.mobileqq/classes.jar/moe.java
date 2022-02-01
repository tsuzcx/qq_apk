import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class moe
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mod> jdField_a_of_type_JavaLangRefWeakReference;
  
  moe(String paramString, mod parammod)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammod);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mod localmod = (mod)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmod != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mod.a(localmod);
    lba.f(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     moe
 * JD-Core Version:    0.7.0.1
 */