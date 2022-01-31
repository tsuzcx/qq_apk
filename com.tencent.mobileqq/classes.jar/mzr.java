import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.widget.AdapterView;

class mzr
  implements bhqp
{
  mzr(mzq parammzq, PoiMapActivity paramPoiMapActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Mzq.a(paramInt, true);
    int i = this.jdField_a_of_type_Mzq.jdField_a_of_type_ComTencentBizPoiMapActivity.a.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (this.jdField_a_of_type_Mzq.e != paramInt) {
        this.jdField_a_of_type_Mzq.jdField_a_of_type_ComTencentBizPoiMapActivity.a[paramInt].a(-1, false);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mzr
 * JD-Core Version:    0.7.0.1
 */