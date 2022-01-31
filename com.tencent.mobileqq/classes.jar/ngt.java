import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class ngt
  implements View.OnClickListener
{
  ngt(nfu paramnfu, nmv paramnmv) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent((Context)this.jdField_a_of_type_Nfu.a.get(), ScannerActivity.class);
    paramView.putExtra("from", this.jdField_a_of_type_Nfu.a.getClass().getName());
    paramView.putExtra("finishAfterSucc", true);
    ((BaseActivity)this.jdField_a_of_type_Nfu.a.get()).startActivity(paramView);
    nfu.a(this.jdField_a_of_type_Nfu, this.jdField_a_of_type_Nmv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngt
 * JD-Core Version:    0.7.0.1
 */