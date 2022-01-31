import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.AppInfo;

public class sje
  implements View.OnClickListener
{
  public sje(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    oidb_0xaf4.AppInfo localAppInfo;
    if ((localObject1 instanceof oidb_0xaf4.AppInfo))
    {
      localAppInfo = (oidb_0xaf4.AppInfo)localObject1;
      localObject1 = localAppInfo.url.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label40;
      }
    }
    label40:
    label460:
    for (;;)
    {
      return;
      long l = localAppInfo.appid.get();
      int i = localAppInfo.push_red_point.get();
      Object localObject2;
      if ((((String)localObject1).startsWith("http")) || (((String)localObject1).startsWith("https")))
      {
        localObject2 = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ChatSettingForTroop.a(this.a, (String)localObject1, l, i));
        ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        this.a.startActivity((Intent)localObject2);
        if (i != 0)
        {
          localAppInfo.push_red_point.set(0);
          ((TextView)paramView.findViewById(2131368496)).setVisibility(8);
        }
        if ((this.a.d != 1) && (!this.a.a.isMember)) {
          continue;
        }
        TroopReportor.a("Grp_app_new", "grpData_admin", "app_clk", 0, 0, new String[] { this.a.a.troopUin, TroopReportor.a(this.a.a), String.valueOf(l) });
        paramView = "";
        if (l != 0L) {
          break label422;
        }
        paramView = "app_clk";
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramView)) {
          break label460;
        }
        TroopReportor.a("Grp_app_new", "grpData_admin", paramView, 0, 0, new String[] { this.a.a.troopUin, TroopReportor.a(this.a.a) });
        return;
        if (!((String)localObject1).startsWith("mqqapi")) {
          break;
        }
        localObject2 = ChatSettingForTroop.a(this.a, (String)localObject1, l, i);
        localObject1 = localObject2;
        if (l == 1105981808L)
        {
          localObject1 = TroopStoryUtil.a(this.a.getIntent(), (String)localObject2, null);
          StoryReportor.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        }
        localObject2 = new Intent(this.a, JumpActivity.class);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.a.startActivity((Intent)localObject2);
        break;
        if (l == 1L) {
          paramView = "clk_file";
        } else if (l == 2L) {
          paramView = "clk_album";
        } else if (l == 1101236949L) {
          paramView = "clk_notice";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sje
 * JD-Core Version:    0.7.0.1
 */