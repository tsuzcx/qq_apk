import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class mgc
  implements View.OnClickListener
{
  mgc(mgb parammgb) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    paramView = (mge)paramView.getTag();
    if (mgb.a(this.a) == null) {
      return;
    }
    azmj.b(null, "CliOper", "", "", "0X8009E26", "0X8009E26", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMemberListCtrl", 2, "onItemClick # mRelationUinStr = " + this.a.jdField_a_of_type_Long + " # memberUin = " + String.valueOf(paramView.jdField_a_of_type_Long));
    }
    mgb.a(this.a).getCurrentAccountUin();
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.GaudioOpenTroopCard");
    localIntent.putExtra("troopUin", String.valueOf(this.a.jdField_a_of_type_Long));
    localIntent.putExtra("memberUin", String.valueOf(paramView.jdField_a_of_type_Long));
    if (this.a.jdField_a_of_type_Int == 1) {
      i = 1000;
    }
    for (;;)
    {
      localIntent.putExtra("uinType", i);
      localIntent.setPackage(mgb.a(this.a).getApplication().getPackageName());
      mgb.a(this.a).getApp().sendBroadcast(localIntent);
      return;
      if (this.a.jdField_a_of_type_Int == 2) {
        i = 1004;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mgc
 * JD-Core Version:    0.7.0.1
 */