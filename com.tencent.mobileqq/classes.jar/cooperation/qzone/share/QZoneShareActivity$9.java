package cooperation.qzone.share;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.RDMEtraMsgCollector;

class QZoneShareActivity$9
  implements View.OnClickListener
{
  QZoneShareActivity$9(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneShareActivity.simpleClassname, paramView);
    this.this$0.hideKeyboardAndEmo(false);
    Intent localIntent = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    this.this$0.startActivityForResult(localIntent, 1000);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.9
 * JD-Core Version:    0.7.0.1
 */