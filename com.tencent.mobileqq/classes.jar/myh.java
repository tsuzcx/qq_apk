import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;

class myh
  implements Handler.Callback
{
  myh(myg parammyg) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 291) {
      switch (this.a.jdField_a_of_type_Int)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(i));
      paramMessage = this.a;
      paramMessage.jdField_a_of_type_Int += 1;
      if (this.a.jdField_a_of_type_Int == 4) {
        this.a.jdField_a_of_type_Int = 0;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(291, 1000L);
      return false;
      i = 2131696356;
      continue;
      i = 2131696357;
      continue;
      i = 2131696358;
      continue;
      i = 2131696359;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myh
 * JD-Core Version:    0.7.0.1
 */