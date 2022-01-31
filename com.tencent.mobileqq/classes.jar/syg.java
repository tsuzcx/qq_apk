import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import java.util.HashMap;

public class syg
  implements Runnable
{
  public syg(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.a.getActivity() == null) {
      return;
    }
    MainFragment.a(this.a, PreferenceManager.getDefaultSharedPreferences(MainFragment.a(this.a).getApp()));
    if (MainFragment.a(this.a).getBoolean("theme_voice_setting_" + MainFragment.a(this.a).getCurrentAccountUin(), true))
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(MainFragment.a(this.a));
      localObject = ThemeUtil.getThemeInfo(this.a.getActivity(), (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).status.equals("5")) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {}
    }
    for (boolean bool = false;; bool = true)
    {
      if (MainFragment.a(this.a) != null)
      {
        if (MainFragment.a(this.a).get("消息") != null) {
          ((View)MainFragment.a(this.a).get("消息")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("联系人") != null) {
          ((View)MainFragment.a(this.a).get("联系人")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("动态") != null) {
          ((View)MainFragment.a(this.a).get("动态")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("电话") != null) {
          ((View)MainFragment.a(this.a).get("电话")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("NOW") != null) {
          ((View)MainFragment.a(this.a).get("NOW")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.a).get("看点") != null) {
          ((View)MainFragment.a(this.a).get("看点")).setSoundEffectsEnabled(bool);
        }
      }
      if (MultiMsgManager.a().a()) {
        break;
      }
      MultiMsgManager.a().a(MainFragment.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syg
 * JD-Core Version:    0.7.0.1
 */