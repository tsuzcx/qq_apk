import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class phl
  implements View.OnAttachStateChangeListener
{
  phl(pgw parampgw, pau parampau, VideoView paramVideoView, phn paramphn, BroadcastReceiver paramBroadcastReceiver) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    ram localram = this.jdField_a_of_type_Pau.a();
    phm localphm = new phm(this);
    localram.b(localphm);
    paramView.setTag(2131374809, localphm);
    paramView = new IntentFilter();
    paramView.addAction("android.media.VOLUME_CHANGED_ACTION");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_Phn.a(false);
    ram localram = this.jdField_a_of_type_Pau.a();
    paramView = (raa)paramView.getTag(2131374809);
    if (paramView != null) {
      localram.c(paramView);
    }
    try
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("PgcShortContentProteusItem", 2, QLog.getStackTraceString(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phl
 * JD-Core Version:    0.7.0.1
 */