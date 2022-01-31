import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility.OnShareListener;
import com.tencent.mobileqq.util.TroopReportor;

class sco
  implements TroopShareUtility.OnShareListener
{
  sco(scn paramscn) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    String str1;
    if ((this.a.a.d == 1) || (this.a.a.a.isMember))
    {
      str1 = "";
      switch (paramInt)
      {
      }
    }
    while (TextUtils.isEmpty(str1))
    {
      return;
      str1 = "share_circle";
      continue;
      str1 = "share_qq";
      continue;
      str1 = "share_qzone";
      continue;
      str1 = "share_wechat";
    }
    String str3 = this.a.a.a.troopUin;
    String str4 = TroopReportor.a(this.a.a.a);
    if (paramBoolean) {}
    for (String str2 = "0";; str2 = "1")
    {
      TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, str4, str2 });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sco
 * JD-Core Version:    0.7.0.1
 */