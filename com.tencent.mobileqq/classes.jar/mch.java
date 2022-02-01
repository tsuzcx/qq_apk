import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

public abstract class mch
  extends OrientationEventListener
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private Configuration jdField_a_of_type_AndroidContentResConfiguration;
  private Display jdField_a_of_type_AndroidViewDisplay;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  public boolean a;
  private int jdField_b_of_type_Int = -25;
  private boolean jdField_b_of_type_Boolean;
  
  public mch(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResConfiguration = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_b_of_type_Boolean = mtj.g(paramContext);
    a();
  }
  
  private void a()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.jdField_a_of_type_Int >= 5) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
    if (this.jdField_a_of_type_AndroidContentResConfiguration.orientation == 1)
    {
      if ((i == 0) || (i == 2)) {
        bool1 = true;
      }
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
    }
    for (;;)
    {
      QLog.i("Orientation", 1, "checkNaturalOrientation, rotation[" + i + "], orientation[" + this.jdField_a_of_type_AndroidContentResConfiguration.orientation + "], naturalPortrait[" + this.jdField_a_of_type_JavaLangBoolean + "], tryCnt[" + this.jdField_a_of_type_Int);
      return;
      if (this.jdField_a_of_type_AndroidContentResConfiguration.orientation == 2)
      {
        if (i != 1)
        {
          bool1 = bool2;
          if (i != 3) {}
        }
        else
        {
          bool1 = true;
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
      }
      else
      {
        this.jdField_a_of_type_Int += 1;
      }
    }
  }
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      this.jdField_b_of_type_Int = paramInt;
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int < 0) {
        this.jdField_b_of_type_Int = 0;
      }
    } while ((paramInt - this.jdField_b_of_type_Int < 20) && (paramInt - this.jdField_b_of_type_Int > -20) && (!this.jdField_a_of_type_Boolean));
    int i = paramInt;
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaLangBoolean == null) {
        a();
      }
      if (this.jdField_a_of_type_JavaLangBoolean != null)
      {
        j = paramInt;
        if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {}
      }
      else
      {
        j = paramInt - 90;
      }
      i = j;
      if (j < 0) {
        i = j + 360;
      }
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = llc.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90;; paramInt = llc.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90)
    {
      j = paramInt;
      if (paramInt > 360) {
        j = paramInt % 360;
      }
      i -= j;
      paramInt = i;
      if (i < 0) {
        paramInt = i + 360;
      }
      this.jdField_b_of_type_Int = paramInt;
      if ((paramInt <= 314) && (paramInt >= 45)) {
        break;
      }
      a(0, this.jdField_a_of_type_Boolean);
      return;
    }
    if ((paramInt > 44) && (paramInt < 135))
    {
      a(90, this.jdField_a_of_type_Boolean);
      return;
    }
    if ((paramInt > 134) && (paramInt < 225))
    {
      a(180, this.jdField_a_of_type_Boolean);
      return;
    }
    a(270, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mch
 * JD-Core Version:    0.7.0.1
 */