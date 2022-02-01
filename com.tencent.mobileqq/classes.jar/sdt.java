import android.view.View;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.List;

public class sdt
{
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private List<blpa> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<Float> b = new ArrayList();
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_Boolean) && (this.b.isEmpty()))
    {
      this.b.add(Float.valueOf(0.941F));
      this.b.add(Float.valueOf(1.0F));
      this.b.add(Float.valueOf(1.118F));
      this.b.add(Float.valueOf(1.235F));
      this.b.add(Float.valueOf(1.353F));
    }
  }
  
  private float b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return ((Float)this.b.get(paramInt)).floatValue();
    }
    return 1.0F;
  }
  
  public float a(int paramInt)
  {
    float f2 = 0.0F;
    float f1;
    if (this.jdField_a_of_type_Boolean) {
      f1 = b(paramInt);
    }
    do
    {
      do
      {
        return f1;
        f1 = f2;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      f1 = f2;
    } while (paramInt >= this.jdField_a_of_type_JavaUtilList.size());
    return ((blpa)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a();
  }
  
  public sdt a(View paramView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdt
 * JD-Core Version:    0.7.0.1
 */