import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class mev
  implements AdapterView.OnItemClickListener
{
  public mev(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Mru == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      met localmet = (met)paramView.getTag();
      if (localmet == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiMembersVideoUI", 2, "onItemClick-->holder is null");
        }
      }
      else if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() > 8) && ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2))) {
        this.a.jdField_a_of_type_Mru.a(localmet.jdField_a_of_type_Long, localmet.jdField_a_of_type_Int, paramInt, true);
      } else {
        this.a.jdField_a_of_type_Mru.a(localmet.jdField_a_of_type_Long, localmet.jdField_a_of_type_Int, paramInt, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mev
 * JD-Core Version:    0.7.0.1
 */