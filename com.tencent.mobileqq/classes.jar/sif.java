import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import java.util.ArrayList;

class sif
  implements Runnable
{
  sif(sie paramsie, ArrayList paramArrayList) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_Sie.a.a.a[33];
    if (localView != null)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
        break label67;
      }
      localView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Sie.a.a.a(33, localView, this.jdField_a_of_type_JavaUtilArrayList, true, true);
      return;
      label67:
      localView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sif
 * JD-Core Version:    0.7.0.1
 */