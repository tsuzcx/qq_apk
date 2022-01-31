import android.view.View;
import android.widget.PopupWindow;
import java.util.List;

public class rpq
{
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private List<biam> jdField_a_of_type_JavaUtilList;
  
  public float a(int paramInt)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      f1 = f2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        f1 = ((biam)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a();
      }
    }
    return f1;
  }
  
  public rpq a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 83, 0, 0);
    }
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rpq
 * JD-Core Version:    0.7.0.1
 */