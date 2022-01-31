import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class osu
  implements Handler.Callback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final osv jdField_a_of_type_Osv;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public osu(osv paramosv)
  {
    this.jdField_a_of_type_Osv = paramosv;
    this.jdField_a_of_type_AndroidOsHandler = new bfob(Looper.getMainLooper(), this);
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_Osv.a(paramBundle))
        {
        }
      }
      return;
    } while (!this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.setData(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!this.b) {
      a(paramMessage.getData());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osu
 * JD-Core Version:    0.7.0.1
 */