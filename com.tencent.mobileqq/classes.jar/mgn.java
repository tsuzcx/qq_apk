import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class mgn
  implements AdapterView.OnItemClickListener
{
  public mgn(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramAdapterView = (ldr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView = new Intent(this.a, QQBrowserActivity.class);
      paramAdapterView = String.valueOf(paramAdapterView.a);
      String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      if (paramAdapterView.equals(str)) {}
      for (paramAdapterView = "https://qvideo.qq.com/mobile/client/level/detail.html?_bid=2176&uin=" + str;; paramAdapterView = "https://qvideo.qq.com/mobile/client/level/pk.html?_bid=2176&my=" + str + "&pk=" + paramAdapterView)
      {
        paramView.putExtra("url", paramAdapterView);
        paramView.putExtra("uin", str);
        paramView.putExtra("portraitOnly", true);
        paramView.putExtra("hide_more_button", true);
        paramView.putExtra("hide_operation_bar", true);
        paramView.putExtra("isShowAd", false);
        this.a.startActivity(paramView);
        axqy.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_member", "Clk_people", 0, 0, "" + this.a.jdField_a_of_type_ComTencentAvVideoController.a, "" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "", "");
        return;
      }
    }
    paramAdapterView = (ldr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersListviewAvtivity", 2, "onItemClick # mRelationUinStr = " + this.a.jdField_a_of_type_JavaLangString + " # memberUin = " + String.valueOf(paramAdapterView.a));
    }
    paramView = new Intent();
    paramView.setAction("tencent.video.v2q.GaudioOpenTroopCard");
    paramView.putExtra("troopUin", this.a.jdField_a_of_type_JavaLangString);
    paramView.putExtra("memberUin", String.valueOf(paramAdapterView.a));
    paramView.putExtra("uinType", this.a.jdField_a_of_type_Int);
    paramView.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mgn
 * JD-Core Version:    0.7.0.1
 */