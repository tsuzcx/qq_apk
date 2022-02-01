import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class mgp
  implements View.OnClickListener
{
  public mgp(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onClick(View paramView)
  {
    if (this.a.h()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d(this.a.d, 1, "onClick R.id.qav_btn_accept_video");
      mru.b(bhnv.h((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()), this.a.jdField_a_of_type_ComTencentAvVideoController.a().D);
      this.a.e();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().aq = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgp
 * JD-Core Version:    0.7.0.1
 */