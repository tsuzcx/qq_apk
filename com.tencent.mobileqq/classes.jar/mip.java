import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mip
  implements View.OnClickListener
{
  public mip(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onClick(View paramView)
  {
    if (this.a.g()) {
      return;
    }
    QLog.d(this.a.d, 1, "onClick R.id.qav_btn_accept_video");
    mtq.b(bdee.h((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()), this.a.jdField_a_of_type_ComTencentAvVideoController.a().C);
    this.a.e();
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ap = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mip
 * JD-Core Version:    0.7.0.1
 */