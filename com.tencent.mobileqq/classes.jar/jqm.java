import android.content.res.Resources;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.qphone.base.util.QLog;

public class jqm
  implements Runnable
{
  public jqm(BeautySettingUi paramBeautySettingUi) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_AndroidContentResResources != null)
      {
        this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840093);
        this.a.b = this.a.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840095);
        this.a.c = this.a.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840096);
        this.a.d = this.a.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840094);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BeautySettingUi", 2, "initUI e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqm
 * JD-Core Version:    0.7.0.1
 */