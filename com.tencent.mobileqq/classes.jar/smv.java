import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;

public class smv
  extends BroadcastReceiver
{
  public smv(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("login".equals(paramIntent.getStringExtra("status")))
    {
      this.a.a.a(9, 2);
      this.a.a.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("loginInfo");
      this.a.a.c = paramIntent.getStringExtra("loginAppId");
      this.a.a.jdField_b_of_type_Int = paramIntent.getIntExtra("appType", -1);
      this.a.a.d = paramIntent.getStringExtra("bannerTips");
      this.a.a.a = paramIntent.getLongExtra("subappid", 1L);
      this.a.a.a(-1, null);
      return;
    }
    this.a.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smv
 * JD-Core Version:    0.7.0.1
 */