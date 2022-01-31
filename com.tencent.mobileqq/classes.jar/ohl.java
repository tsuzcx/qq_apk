import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ohl
{
  private long jdField_a_of_type_Long;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final ohk jdField_a_of_type_Ohk;
  @Nullable
  private oho jdField_a_of_type_Oho;
  private final boolean jdField_a_of_type_Boolean;
  
  public ohl(@NotNull ohk paramohk, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_Ohk = paramohk;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    }
  }
  
  @NotNull
  public final ohk a()
  {
    return this.jdField_a_of_type_Ohk;
  }
  
  @Nullable
  public final oho a()
  {
    return this.jdField_a_of_type_Oho;
  }
  
  public void a()
  {
    a("onStop");
  }
  
  protected final void a(@NotNull String paramString)
  {
    ohm localohm = this.jdField_a_of_type_Ohk.a();
    if (localohm != null)
    {
      localohm.a("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
      return;
    }
    Log.d("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
  }
  
  public final void a(@Nullable oho paramoho)
  {
    this.jdField_a_of_type_Oho = paramoho;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a("onStart");
    return true;
  }
  
  public abstract boolean b();
  
  public void c()
  {
    a("onEnd, time = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
  }
  
  public final boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ohk.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohl
 * JD-Core Version:    0.7.0.1
 */