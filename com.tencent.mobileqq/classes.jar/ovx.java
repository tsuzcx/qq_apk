import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ovx
{
  private long jdField_a_of_type_Long;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final ovw jdField_a_of_type_Ovw;
  @Nullable
  private owa jdField_a_of_type_Owa;
  private final boolean jdField_a_of_type_Boolean;
  
  public ovx(@NotNull ovw paramovw, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_Ovw = paramovw;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    }
  }
  
  @NotNull
  public final ovw a()
  {
    return this.jdField_a_of_type_Ovw;
  }
  
  @Nullable
  public final owa a()
  {
    return this.jdField_a_of_type_Owa;
  }
  
  public void a()
  {
    a("onStop");
  }
  
  protected final void a(@NotNull String paramString)
  {
    ovy localovy = this.jdField_a_of_type_Ovw.a();
    if (localovy != null)
    {
      localovy.a("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
      return;
    }
    Log.d("Step(" + this.jdField_a_of_type_JavaLangString + ')', paramString);
  }
  
  public final void a(@Nullable owa paramowa)
  {
    this.jdField_a_of_type_Owa = paramowa;
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
    this.jdField_a_of_type_Ovw.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovx
 * JD-Core Version:    0.7.0.1
 */