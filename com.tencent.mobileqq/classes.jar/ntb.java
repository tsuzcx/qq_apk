import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

class ntb
  implements bljm
{
  ntb(nsz paramnsz) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (oag)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (this.a.jdField_a_of_type_Nsj != null) {
      this.a.jdField_a_of_type_Nsj.a(paramAdapterView);
    }
    this.a.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntb
 * JD-Core Version:    0.7.0.1
 */