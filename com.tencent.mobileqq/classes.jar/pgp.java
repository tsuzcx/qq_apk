import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public abstract class pgp
{
  @NotNull
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  @NotNull
  private pgq jdField_a_of_type_Pgq;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public pgp(@NotNull pgq parampgq, @NotNull String paramString)
  {
    this.jdField_a_of_type_Pgq = parampgq;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public pgq a()
  {
    return this.jdField_a_of_type_Pgq;
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
    this.jdField_a_of_type_Pgq.a(this, paramBoolean);
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
 * Qualified Name:     pgp
 * JD-Core Version:    0.7.0.1
 */