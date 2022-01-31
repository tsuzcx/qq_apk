import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class nfs
  implements View.OnClickListener
{
  nfs(nfr paramnfr, nms paramnms, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent((Context)this.jdField_a_of_type_Nfr.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
    paramView.putExtra("lat", this.jdField_a_of_type_Nms.g);
    paramView.putExtra("lon", this.jdField_a_of_type_Nms.f);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      paramView.putExtra("loc", this.jdField_a_of_type_JavaLangString);
    }
    ((BaseActivity)this.jdField_a_of_type_Nfr.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(paramView);
    axqy.b(this.jdField_a_of_type_Nfr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.jdField_a_of_type_Nfr.jdField_a_of_type_JavaLangString, "", "", "");
    nfr.a(this.jdField_a_of_type_Nfr, this.jdField_a_of_type_Nms.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfs
 * JD-Core Version:    0.7.0.1
 */