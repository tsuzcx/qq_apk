import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

class obl
  implements AdapterView.OnItemClickListener
{
  obl(obj paramobj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (oji)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (this.a.jdField_a_of_type_Oat != null) {
      this.a.jdField_a_of_type_Oat.a(paramAdapterView);
    }
    this.a.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obl
 * JD-Core Version:    0.7.0.1
 */