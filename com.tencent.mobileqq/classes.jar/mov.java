import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class mov
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mou> jdField_a_of_type_JavaLangRefWeakReference;
  
  mov(String paramString, mou parammou)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammou);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mou localmou = (mou)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmou != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mou.a(localmou);
    lbj.c(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mov
 * JD-Core Version:    0.7.0.1
 */