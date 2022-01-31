import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class swo
  implements Runnable
{
  public swo(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void run()
  {
    boolean bool = this.a.app.p();
    this.a.runOnUiThread(new swp(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swo
 * JD-Core Version:    0.7.0.1
 */