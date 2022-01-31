import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class tef
  implements Runnable
{
  public tef(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void run()
  {
    boolean bool = this.a.app.p();
    this.a.runOnUiThread(new teg(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tef
 * JD-Core Version:    0.7.0.1
 */