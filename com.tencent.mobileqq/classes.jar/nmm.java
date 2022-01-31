import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class nmm
  extends Handler
{
  nmm(nml paramnml, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    this.a.a(this.a.jdField_a_of_type_Int, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nmm
 * JD-Core Version:    0.7.0.1
 */