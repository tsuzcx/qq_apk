import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class pya
  implements View.OnAttachStateChangeListener
{
  pya(pxl parampxl, ppu paramppu, VideoView paramVideoView, pyc parampyc, BroadcastReceiver paramBroadcastReceiver) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    sel localsel = this.jdField_a_of_type_Ppu.a();
    pyb localpyb = new pyb(this);
    localsel.b(localpyb);
    paramView.setTag(2131376187, localpyb);
    paramView = new IntentFilter();
    paramView.addAction("android.media.VOLUME_CHANGED_ACTION");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_Pyc.a(false);
    sel localsel = this.jdField_a_of_type_Ppu.a();
    paramView = (sdz)paramView.getTag(2131376187);
    if (paramView != null) {
      localsel.c(paramView);
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
 * Qualified Name:     pya
 * JD-Core Version:    0.7.0.1
 */