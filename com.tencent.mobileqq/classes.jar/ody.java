import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountSettingFragment;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;

public class ody
  implements olr<OACProfilePb.ProfileDataRsp>
{
  public ody(AccountSettingFragment paramAccountSettingFragment) {}
  
  public void a(int paramInt, boolean paramBoolean, OACProfilePb.ProfileDataRsp paramProfileDataRsp, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      AccountSettingFragment.a(this.a, new AccountDetail(paramProfileDataRsp));
      AccountSettingFragment.a(this.a, AccountSettingFragment.a(this.a));
      AccountSettingFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ody
 * JD-Core Version:    0.7.0.1
 */