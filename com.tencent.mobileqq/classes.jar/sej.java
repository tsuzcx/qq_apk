import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class sej
  implements View.OnClickListener
{
  public sej(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    paramView = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.a.a.troopUin });
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", paramView);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sej
 * JD-Core Version:    0.7.0.1
 */