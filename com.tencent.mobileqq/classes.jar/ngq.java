import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class ngq
  implements View.OnClickListener
{
  ngq(nfr paramnfr, nms paramnms) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent((Context)this.jdField_a_of_type_Nfr.a.get(), ScannerActivity.class);
    paramView.putExtra("from", this.jdField_a_of_type_Nfr.a.getClass().getName());
    paramView.putExtra("finishAfterSucc", true);
    ((BaseActivity)this.jdField_a_of_type_Nfr.a.get()).startActivity(paramView);
    nfr.a(this.jdField_a_of_type_Nfr, this.jdField_a_of_type_Nms.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngq
 * JD-Core Version:    0.7.0.1
 */