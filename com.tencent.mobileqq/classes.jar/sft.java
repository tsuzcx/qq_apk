import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.util.VersionUtils;

public class sft
  implements View.OnClickListener
{
  public sft(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a)
    {
      if (VersionUtils.e()) {
        this.a.startActivity(new Intent("android.settings.SETTINGS"));
      }
    }
    else {
      return;
    }
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sft
 * JD-Core Version:    0.7.0.1
 */