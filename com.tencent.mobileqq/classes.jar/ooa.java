import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ooa
{
  private long jdField_a_of_type_Long;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final onz jdField_a_of_type_Onz;
  @Nullable
  private ood jdField_a_of_type_Ood;
  private final boolean jdField_a_of_type_Boolean;
  
  public ooa(@NotNull onz paramonz, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_Onz = paramonz;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    }
  }
  
  @NotNull
  public final onz a()
  {
    return this.jdField_a_of_type_Onz;
  }
  
  @Nullable
  public final ood a()
  {
    return this.jdField_a_of_type_Ood;
  }
  
  public void a()
  {
    a("onStop");
  }
  
  protected final void a(@NotNull String paramString)
  {
    oob localoob = this.jdField_a_of_type_Onz.a();
    if (localoob != null)
    {
      localoob.a("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
      return;
    }
    Log.d("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
  }
  
  public final void a(@Nullable ood paramood)
  {
    this.jdField_a_of_type_Ood = paramood;
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
    this.jdField_a_of_type_Onz.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooa
 * JD-Core Version:    0.7.0.1
 */