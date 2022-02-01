import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class omp
{
  private long jdField_a_of_type_Long;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final omo jdField_a_of_type_Omo;
  @Nullable
  private oms jdField_a_of_type_Oms;
  private final boolean jdField_a_of_type_Boolean;
  
  public omp(@NotNull omo paramomo, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_Omo = paramomo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    }
  }
  
  @NotNull
  public final omo a()
  {
    return this.jdField_a_of_type_Omo;
  }
  
  @Nullable
  public final oms a()
  {
    return this.jdField_a_of_type_Oms;
  }
  
  public void a()
  {
    a("onStop");
  }
  
  protected final void a(@NotNull String paramString)
  {
    omq localomq = this.jdField_a_of_type_Omo.a();
    if (localomq != null)
    {
      localomq.a("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
      return;
    }
    Log.d("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
  }
  
  public final void a(@Nullable oms paramoms)
  {
    this.jdField_a_of_type_Oms = paramoms;
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
    this.jdField_a_of_type_Omo.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omp
 * JD-Core Version:    0.7.0.1
 */