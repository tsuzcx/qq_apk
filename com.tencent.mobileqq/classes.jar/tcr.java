import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class tcr
  implements Runnable
{
  public tcr(NotificationActivity paramNotificationActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("SecResEntry", -1);
    if ((i == -1) || ((i ^ 0x12) != this.jdField_a_of_type_Int))
    {
      localEditor.putInt("SecResEntry", this.jdField_a_of_type_Int ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.putInt("SecCacheTime", this.b);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tcr
 * JD-Core Version:    0.7.0.1
 */