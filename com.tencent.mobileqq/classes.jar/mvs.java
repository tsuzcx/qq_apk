import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class mvs
  implements View.OnClickListener
{
  mvs(mut parammut, nbu paramnbu) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent((Context)this.jdField_a_of_type_Mut.a.get(), ScannerActivity.class);
    paramView.putExtra("from", this.jdField_a_of_type_Mut.a.getClass().getName());
    paramView.putExtra("finishAfterSucc", true);
    ((BaseActivity)this.jdField_a_of_type_Mut.a.get()).startActivity(paramView);
    mut.a(this.jdField_a_of_type_Mut, this.jdField_a_of_type_Nbu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvs
 * JD-Core Version:    0.7.0.1
 */