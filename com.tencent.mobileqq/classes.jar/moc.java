import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class moc
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<mob> jdField_a_of_type_JavaLangRefWeakReference;
  
  moc(String paramString, mob parammob)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammob);
  }
  
  public void handleMessage(Message paramMessage)
  {
    mob localmob = (mob)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmob != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mob.a(localmob);
    lcl.c(this.jdField_a_of_type_JavaLangString, "ITEM_DISPEAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     moc
 * JD-Core Version:    0.7.0.1
 */