import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class nsu
  implements AdapterView.OnItemClickListener
{
  nsu(nst paramnst, PoiMapActivity paramPoiMapActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Nst.a(paramInt, true);
    int i = this.jdField_a_of_type_Nst.jdField_a_of_type_ComTencentBizPoiMapActivity.a.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (this.jdField_a_of_type_Nst.e != paramInt) {
        this.jdField_a_of_type_Nst.jdField_a_of_type_ComTencentBizPoiMapActivity.a[paramInt].a(-1, false);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsu
 * JD-Core Version:    0.7.0.1
 */