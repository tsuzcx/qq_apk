import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class pnw
  implements View.OnAttachStateChangeListener
{
  pnw(pnh parampnh, pgd parampgd, VideoView paramVideoView, pny parampny, BroadcastReceiver paramBroadcastReceiver) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    rqj localrqj = this.jdField_a_of_type_Pgd.a();
    pnx localpnx = new pnx(this);
    localrqj.b(localpnx);
    paramView.setTag(2131375323, localpnx);
    paramView = new IntentFilter();
    paramView.addAction("android.media.VOLUME_CHANGED_ACTION");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_Pny.a(false);
    rqj localrqj = this.jdField_a_of_type_Pgd.a();
    paramView = (rpx)paramView.getTag(2131375323);
    if (paramView != null) {
      localrqj.c(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnw
 * JD-Core Version:    0.7.0.1
 */