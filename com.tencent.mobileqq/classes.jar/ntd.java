import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ntd
  implements View.OnClickListener
{
  ntd(ntc paramntc, oag paramoag, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
    localIntent.putExtra("lat", this.jdField_a_of_type_Oag.g);
    localIntent.putExtra("lon", this.jdField_a_of_type_Oag.f);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localIntent.putExtra("loc", this.jdField_a_of_type_JavaLangString);
    }
    ((BaseActivity)this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
    bdll.b(this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangString, "", "", "");
    ntc.a(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_Oag.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntd
 * JD-Core Version:    0.7.0.1
 */