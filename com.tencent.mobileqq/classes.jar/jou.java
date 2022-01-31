import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.qphone.base.util.BaseApplication;

class jou
  implements Runnable
{
  jou(jot paramjot, long paramLong) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Jot.a.a() == this.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Jot.a.a.getApp().getApplicationContext().getSharedPreferences("qav_SP", 0).getBoolean("kick_out_self", false))) {
      this.jdField_a_of_type_Jot.a.f(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jou
 * JD-Core Version:    0.7.0.1
 */