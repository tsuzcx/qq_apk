import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class jwv
  implements Runnable
{
  public jwv(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_AndroidViewViewGroup == null) || (this.a.i == null) || (this.a.jdField_a_of_type_AndroidContentResResources == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a.c, 2, "SetTitleMaxWidth Failed --> RootView Or TitleView Or Resource is NULL");
      }
      return;
    }
    if (this.a.h == null)
    {
      i = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559755);
      this.a.i.setMaxWidth(i);
      return;
    }
    int i = this.a.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    int j = this.a.h.getWidth();
    this.a.i.setMaxWidth(i - j * 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jwv
 * JD-Core Version:    0.7.0.1
 */