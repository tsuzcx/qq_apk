import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.PoiTab;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class kki
  implements AdapterView.OnItemClickListener
{
  public kki(PoiMapActivity.PoiTab paramPoiTab, PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.a(paramInt, true);
    int i = this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.a.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.e != paramInt) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.a[paramInt].a(-1, false);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kki
 * JD-Core Version:    0.7.0.1
 */