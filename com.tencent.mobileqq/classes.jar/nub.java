import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class nub
  implements View.OnClickListener
{
  nub(ntc paramntc, oag paramoag) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.jdField_a_of_type_Ntc.a.get(), ScannerActivity.class);
    localIntent.putExtra("from", this.jdField_a_of_type_Ntc.a.getClass().getName());
    localIntent.putExtra("finishAfterSucc", true);
    ((BaseActivity)this.jdField_a_of_type_Ntc.a.get()).startActivity(localIntent);
    ntc.a(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_Oag.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nub
 * JD-Core Version:    0.7.0.1
 */