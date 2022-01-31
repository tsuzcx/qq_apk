import android.widget.RelativeLayout;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;

public class mie
  implements mii
{
  boolean jdField_a_of_type_Boolean = false;
  
  public mie(QavPanel paramQavPanel) {}
  
  public void a(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      mqr.a("0X800A567", 0);
    }
    if ((paramRelativeLayout instanceof QavBeautyMenuPanel)) {
      ((QavBeautyMenuPanel)paramRelativeLayout).a(paramLong, paramBoolean);
    }
  }
  
  public void b(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((paramRelativeLayout instanceof QavBeautyMenuPanel)) {
      ((QavBeautyMenuPanel)paramRelativeLayout).b(paramLong, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mie
 * JD-Core Version:    0.7.0.1
 */