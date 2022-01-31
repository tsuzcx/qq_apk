import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mez
  implements View.OnClickListener
{
  public mez(MultiMembersAudioUI paramMultiMembersAudioUI) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Mrx == null) {}
    do
    {
      return;
      paramView = (mfe)paramView.getTag();
      if (paramView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MultiMembersAudioUI", 2, "onItemClick-->holder is null");
    return;
    if (paramView.c) {}
    for (int i = 7; (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 8) && ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2)); i = this.a.a(paramView.jdField_a_of_type_Long))
    {
      this.a.jdField_a_of_type_Mrx.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, i, true);
      return;
    }
    this.a.jdField_a_of_type_Mrx.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mez
 * JD-Core Version:    0.7.0.1
 */