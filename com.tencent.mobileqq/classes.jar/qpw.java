import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class qpw
  implements View.OnAttachStateChangeListener
{
  qpw(qph paramqph, qfw paramqfw, VideoView paramVideoView, qpy paramqpy, BroadcastReceiver paramBroadcastReceiver) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    szd localszd = this.jdField_a_of_type_Qfw.a();
    qpx localqpx = new qpx(this);
    localszd.b(localqpx);
    paramView.setTag(2131376198, localqpx);
    paramView = new IntentFilter();
    paramView.addAction("android.media.VOLUME_CHANGED_ACTION");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_Qpy.a(false);
    szd localszd = this.jdField_a_of_type_Qfw.a();
    paramView = (syr)paramView.getTag(2131376198);
    if (paramView != null) {
      localszd.c(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpw
 * JD-Core Version:    0.7.0.1
 */