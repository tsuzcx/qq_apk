import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public abstract class mbv
  extends OrientationEventListener
{
  int jdField_a_of_type_Int = -25;
  protected Context a;
  Configuration jdField_a_of_type_AndroidContentResConfiguration;
  Display jdField_a_of_type_AndroidViewDisplay;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b;
  
  public mbv(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResConfiguration = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_a_of_type_Boolean = msi.f(paramContext);
  }
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      this.jdField_a_of_type_Int = paramInt;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
    } while ((paramInt - this.jdField_a_of_type_Int < 20) && (paramInt - this.jdField_a_of_type_Int > -20) && (!this.b));
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt -= 90;
      i = paramInt;
      if (paramInt < 0) {
        i = paramInt + 360;
      }
    }
    if (this.b) {}
    for (paramInt = llq.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90;; paramInt = llq.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90)
    {
      int j = paramInt;
      if (paramInt > 360) {
        j = paramInt % 360;
      }
      i -= j;
      paramInt = i;
      if (i < 0) {
        paramInt = i + 360;
      }
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt <= 314) && (paramInt >= 45)) {
        break;
      }
      a(0, this.b);
      return;
    }
    if ((paramInt > 44) && (paramInt < 135))
    {
      a(90, this.b);
      return;
    }
    if ((paramInt > 134) && (paramInt < 225))
    {
      a(180, this.b);
      return;
    }
    a(270, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbv
 * JD-Core Version:    0.7.0.1
 */