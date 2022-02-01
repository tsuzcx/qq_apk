import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;

public class odf
  implements olr<OACProfilePb.ProfileDataRsp>
{
  public odf(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void a(int paramInt, boolean paramBoolean, OACProfilePb.ProfileDataRsp paramProfileDataRsp, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    paramBundle = this.a;
    paramBundle.jdField_c_of_type_Int -= 1;
    if (this.a.jdField_c_of_type_Int == 0) {
      this.a.M();
    }
    if (!paramBoolean)
    {
      if (this.a.jdField_c_of_type_Boolean)
      {
        if (this.a.jdField_a_of_type_Nzu != null)
        {
          this.a.jdField_a_of_type_Nzu.b(false);
          this.a.jdField_a_of_type_Nzu.notifyDataSetChanged();
        }
      }
      else {
        return;
      }
      this.a.d(2131694983);
      return;
    }
    paramBundle = new AccountDetail(paramProfileDataRsp);
    okn.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, paramProfileDataRsp.menu_rsp);
    this.a.a(paramBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odf
 * JD-Core Version:    0.7.0.1
 */