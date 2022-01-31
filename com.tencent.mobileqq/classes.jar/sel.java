import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;

public class sel
  extends ViewPager.SimpleOnPageChangeListener
{
  public sel(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    if ((this.a.d == 1) || (this.a.a.isMember))
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "slide_head", 0, 0, new String[] { this.a.a.troopUin, TroopReportor.a(this.a.a) });
      return;
    }
    String str2 = this.a.a.troopUin;
    if (this.a.a.isMember) {}
    for (String str1 = "1";; str1 = "0")
    {
      TroopReportor.a("Grp_set_new", "grpData_visitor", "slide_head", 0, 0, new String[] { str2, str1 });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sel
 * JD-Core Version:    0.7.0.1
 */