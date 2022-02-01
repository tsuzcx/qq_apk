import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class mfk
  implements View.OnClickListener
{
  public mfk(MultiMembersAudioUI paramMultiMembersAudioUI) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Mss == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      mfp localmfp = (mfp)paramView.getTag();
      if (localmfp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiMembersAudioUI", 2, "onItemClick-->holder is null");
        }
      }
      else
      {
        if (localmfp.c) {}
        for (int i = 7;; i = this.a.a(localmfp.jdField_a_of_type_Long))
        {
          if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 8) || ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 2))) {
            break label134;
          }
          this.a.jdField_a_of_type_Mss.a(localmfp.jdField_a_of_type_Long, localmfp.jdField_a_of_type_Int, i, true);
          break;
        }
        label134:
        this.a.jdField_a_of_type_Mss.a(localmfp.jdField_a_of_type_Long, localmfp.jdField_a_of_type_Int, i, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfk
 * JD-Core Version:    0.7.0.1
 */