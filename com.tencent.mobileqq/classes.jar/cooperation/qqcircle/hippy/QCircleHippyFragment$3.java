package cooperation.qqcircle.hippy;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bhdj;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qqcircle.events.QCircleRewardAdResultEvent;

class QCircleHippyFragment$3
  implements Runnable
{
  QCircleHippyFragment$3(QCircleHippyFragment paramQCircleHippyFragment, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.this$0.getActivity(), 230);
    localQQCustomDialog.setContentView(2131559019);
    localQQCustomDialog.setTitle(((QCircleRewardAdResultEvent)this.val$event).mToast);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(this.this$0.getActivity().getResources().getString(2131694399), new QCircleHippyFragment.3.1(this));
    localQQCustomDialog.setNegativeButton(null, null);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.hippy.QCircleHippyFragment.3
 * JD-Core Version:    0.7.0.1
 */