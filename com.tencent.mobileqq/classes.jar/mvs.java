import android.os.Handler;
import android.os.Message;

class mvs
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    mvr localmvr = (mvr)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localmvr.jdField_a_of_type_Mvq.a(((mvt[])localmvr.jdField_a_of_type_ArrayOfJavaLangObject)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mvs
 * JD-Core Version:    0.7.0.1
 */