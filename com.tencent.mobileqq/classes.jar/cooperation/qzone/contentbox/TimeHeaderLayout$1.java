package cooperation.qzone.contentbox;

import android.content.SharedPreferences;
import android.os.Handler;
import bill;

class TimeHeaderLayout$1
  implements Runnable
{
  TimeHeaderLayout$1(TimeHeaderLayout paramTimeHeaderLayout) {}
  
  public void run()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    if (!this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.contains(TimeHeaderLayout.jdField_a_of_type_JavaLangString)) {
      arrayOfBoolean[0] = bill.g();
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TimeHeaderLayout.1.1(this));
      return;
      arrayOfBoolean[0] = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(TimeHeaderLayout.jdField_a_of_type_JavaLangString, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.TimeHeaderLayout.1
 * JD-Core Version:    0.7.0.1
 */