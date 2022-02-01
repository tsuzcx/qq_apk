import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyParam;", "", "status", "", "isDarkMode", "", "avatarUrl", "", "uin", "marginBottom", "useNightMode", "logicAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isOpenPushNotify", "isDefaultOpen", "buttonId", "", "(IZLjava/lang/String;Ljava/lang/String;IZLkotlin/jvm/functions/Function3;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "()Z", "setDarkMode", "(Z)V", "getLogicAction", "()Lkotlin/jvm/functions/Function3;", "setLogicAction", "(Lkotlin/jvm/functions/Function3;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "getStatus", "setStatus", "getUin", "setUin", "getUseNightMode", "setUseNightMode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qop
{
  public static final qoq a;
  private int jdField_a_of_type_Int;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private Function3<? super Boolean, ? super Boolean, ? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction3;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @NotNull
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Qoq = new qoq(null);
  }
  
  public qop(int paramInt1, boolean paramBoolean1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2, boolean paramBoolean2, @NotNull Function3<? super Boolean, ? super Boolean, ? super Integer, Unit> paramFunction3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction3 = paramFunction3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final Function3<Boolean, Boolean, Integer, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction3;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @NotNull
  public String toString()
  {
    return "status: " + this.jdField_a_of_type_Int + " , isDarkMode: " + this.jdField_a_of_type_Boolean + " , avatarUrl: " + this.jdField_a_of_type_JavaLangString + " , marginBottom: " + this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qop
 * JD-Core Version:    0.7.0.1
 */