import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class obn
  implements View.OnClickListener
{
  obn(obm paramobm, oji paramoji, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent((Context)this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
    localIntent.putExtra("lat", this.jdField_a_of_type_Oji.g);
    localIntent.putExtra("lon", this.jdField_a_of_type_Oji.f);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localIntent.putExtra("loc", this.jdField_a_of_type_JavaLangString);
    }
    ((BaseActivity)this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
    bdla.b(this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangString, "", "", "");
    obm.a(this.jdField_a_of_type_Obm, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obn
 * JD-Core Version:    0.7.0.1
 */