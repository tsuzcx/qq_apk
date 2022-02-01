import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class meh
  implements View.OnClickListener
{
  meh(meg parammeg) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    mej localmej = (mej)paramView.getTag();
    if (meg.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bdla.b(null, "CliOper", "", "", "0X8009E26", "0X8009E26", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMemberListCtrl", 2, "onItemClick # mRelationUinStr = " + this.a.jdField_a_of_type_Long + " # memberUin = " + String.valueOf(localmej.jdField_a_of_type_Long));
    }
    meg.a(this.a).getCurrentAccountUin();
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.GaudioOpenTroopCard");
    localIntent.putExtra("troopUin", String.valueOf(this.a.jdField_a_of_type_Long));
    localIntent.putExtra("memberUin", String.valueOf(localmej.jdField_a_of_type_Long));
    if (this.a.jdField_a_of_type_Int == 1) {
      i = 1000;
    }
    for (;;)
    {
      localIntent.putExtra("uinType", i);
      localIntent.setPackage(meg.a(this.a).getApplication().getPackageName());
      meg.a(this.a).getApp().sendBroadcast(localIntent);
      break;
      if (this.a.jdField_a_of_type_Int == 2) {
        i = 1004;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     meh
 * JD-Core Version:    0.7.0.1
 */