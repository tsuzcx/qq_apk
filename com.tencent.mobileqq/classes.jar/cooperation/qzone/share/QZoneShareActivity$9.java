package cooperation.qzone.share;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import cooperation.qzone.RDMEtraMsgCollector;

class QZoneShareActivity$9
  implements View.OnClickListener
{
  QZoneShareActivity$9(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneShareActivity.simpleClassname, paramView);
    this.this$0.hideKeyboardAndEmo(false);
    paramView = new Intent();
    paramView.putExtra("param_only_friends", true);
    paramView.putExtra("param_min", 1);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this.this$0, paramView, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.9
 * JD-Core Version:    0.7.0.1
 */