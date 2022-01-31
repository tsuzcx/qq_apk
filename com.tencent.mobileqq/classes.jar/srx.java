import android.os.Message;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import mqq.os.MqqHandler;

public class srx
  extends MqqHandler
{
  public srx(FontSettingActivity paramFontSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (16711697 == paramMessage.what)
    {
      FontSettingManager.a(this.a, FontSettingActivity.a(this.a), false);
      this.a.c = true;
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srx
 * JD-Core Version:    0.7.0.1
 */