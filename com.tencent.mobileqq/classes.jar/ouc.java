import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ouc
{
  private long jdField_a_of_type_Long;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final oub jdField_a_of_type_Oub;
  @Nullable
  private ouf jdField_a_of_type_Ouf;
  private final boolean jdField_a_of_type_Boolean;
  
  public ouc(@NotNull oub paramoub, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_Oub = paramoub;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    }
  }
  
  @NotNull
  public final oub a()
  {
    return this.jdField_a_of_type_Oub;
  }
  
  @Nullable
  public final ouf a()
  {
    return this.jdField_a_of_type_Ouf;
  }
  
  public void a()
  {
    a("onStop");
  }
  
  protected final void a(@NotNull String paramString)
  {
    oud localoud = this.jdField_a_of_type_Oub.a();
    if (localoud != null)
    {
      localoud.a("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
      return;
    }
    Log.d("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
  }
  
  public final void a(@Nullable ouf paramouf)
  {
    this.jdField_a_of_type_Ouf = paramouf;
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
    this.jdField_a_of_type_Oub.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouc
 * JD-Core Version:    0.7.0.1
 */