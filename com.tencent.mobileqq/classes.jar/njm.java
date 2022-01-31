import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class njm
  implements View.OnClickListener
{
  njm(nin paramnin, npo paramnpo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent((Context)this.jdField_a_of_type_Nin.a.get(), ScannerActivity.class);
    paramView.putExtra("from", this.jdField_a_of_type_Nin.a.getClass().getName());
    paramView.putExtra("finishAfterSucc", true);
    ((BaseActivity)this.jdField_a_of_type_Nin.a.get()).startActivity(paramView);
    nin.a(this.jdField_a_of_type_Nin, this.jdField_a_of_type_Npo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     njm
 * JD-Core Version:    0.7.0.1
 */