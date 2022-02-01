import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public abstract class pnq
{
  @NotNull
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  @NotNull
  private pnr jdField_a_of_type_Pnr;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public pnq(@NotNull pnr parampnr, @NotNull String paramString)
  {
    this.jdField_a_of_type_Pnr = parampnr;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public pnr a()
  {
    return this.jdField_a_of_type_Pnr;
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
    this.jdField_a_of_type_Pnr.a(this, paramBoolean);
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
  
  public boolean b()
  {
    return this.b;
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
 * Qualified Name:     pnq
 * JD-Core Version:    0.7.0.1
 */