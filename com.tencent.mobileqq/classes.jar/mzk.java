import android.app.Dialog;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.List;

public class mzk
  implements bhuw
{
  public mzk(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PoiMapActivity", 2, "setOnItemClickListener" + paramInt);
    }
    paramAdapterView = (mzm)this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.get(paramInt);
    if (paramAdapterView != null)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.h = true;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(paramAdapterView);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "click_sch_result", "", "", "", "");
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mzk
 * JD-Core Version:    0.7.0.1
 */