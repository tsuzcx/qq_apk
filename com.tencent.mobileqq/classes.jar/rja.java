import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class rja
  implements View.OnClickListener
{
  public rja(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQStoryBasicSettingsActivity.class);
    this.a.startActivity(paramView);
    StoryReportor.a("browse_friend_settings", "clk_set", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rja
 * JD-Core Version:    0.7.0.1
 */