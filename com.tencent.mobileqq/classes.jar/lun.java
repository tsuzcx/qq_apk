import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lun
  implements AdapterView.OnItemClickListener
{
  public lun(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Mgy == null) {}
    do
    {
      return;
      paramAdapterView = (lul)paramView.getTag();
      if (paramAdapterView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiMembersVideoUI", 2, "onItemClick-->holder is null");
    return;
    if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() > 8) && ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2)))
    {
      this.a.jdField_a_of_type_Mgy.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, paramInt, true);
      return;
    }
    this.a.jdField_a_of_type_Mgy.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lun
 * JD-Core Version:    0.7.0.1
 */