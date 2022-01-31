import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class rmu
  implements Runnable
{
  public rmu(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.getPreferences().edit();
    localEditor.putInt("LT_tip_show_times" + this.a.a.getCurrentAccountUin(), 1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmu
 * JD-Core Version:    0.7.0.1
 */