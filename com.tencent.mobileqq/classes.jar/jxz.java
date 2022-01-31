import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class jxz
  implements AdapterView.OnItemClickListener
{
  public jxz(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity, boolean paramBoolean) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Boolean)
    {
      String str;
      if (!this.jdField_a_of_type_Boolean)
      {
        paramAdapterView = (VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramView = new Intent(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity, QQBrowserActivity.class);
        paramAdapterView = String.valueOf(paramAdapterView.a);
        str = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (paramAdapterView.equals(str))
        {
          paramAdapterView = "https://qvideo.qq.com/mobile/client/level/detail.html?_bid=2176&uin=" + str;
          paramView.putExtra("url", paramAdapterView);
          paramView.putExtra("uin", str);
          paramView.putExtra("portraitOnly", true);
          paramView.putExtra("hide_more_button", true);
          paramView.putExtra("hide_operation_bar", true);
          paramView.putExtra("isShowAd", false);
          this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.startActivity(paramView);
          ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_member", "Clk_people", 0, 0, "" + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvVideoController.a, "" + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "", "");
        }
      }
      do
      {
        return;
        paramAdapterView = "https://qvideo.qq.com/mobile/client/level/pk.html?_bid=2176&my=" + str + "&pk=" + paramAdapterView;
        break;
        paramAdapterView = (VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      } while ((paramAdapterView == null) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(String.valueOf(paramAdapterView.a))));
      paramView = new Intent();
      paramView.setAction("tencent.av.gift.SelectExtra");
      paramView.putExtra("selectUin", paramAdapterView.a);
      paramView.setPackage(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
      MultiVideoMembersListviewAvtivity.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity);
      return;
    }
    paramAdapterView = (VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersListviewAvtivity", 2, "onItemClick # mRelationUinStr = " + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaLangString + " # memberUin = " + String.valueOf(paramAdapterView.a));
    }
    paramView = new Intent();
    paramView.setAction("tencent.video.v2q.GaudioOpenTroopCard");
    paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaLangString);
    paramView.putExtra("memberUin", String.valueOf(paramAdapterView.a));
    paramView.putExtra("uinType", this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Int);
    paramView.setPackage(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxz
 * JD-Core Version:    0.7.0.1
 */