import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public abstract class pwy
{
  @NotNull
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  @NotNull
  private pwz jdField_a_of_type_Pwz;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public pwy(@NotNull pwz parampwz, @NotNull String paramString)
  {
    this.jdField_a_of_type_Pwz = parampwz;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public pwz a()
  {
    return this.jdField_a_of_type_Pwz;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onCreate");
    }
  }
  
  @UiThread
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pwz.a(this, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onDestroy");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onResume");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onPause");
    }
  }
  
  public void e()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onShowSelf");
    }
  }
  
  public void f()
  {
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.jdField_a_of_type_JavaLangString + ") onHideSelf");
    }
  }
  
  protected abstract void g();
  
  protected abstract void h();
  
  @NonNull
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwy
 * JD-Core Version:    0.7.0.1
 */