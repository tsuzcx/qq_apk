import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule$ChannelBannerInfo;", "", "(Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule;)V", "cardReportJson", "", "getCardReportJson", "()Ljava/lang/String;", "setCardReportJson", "(Ljava/lang/String;)V", "channelId", "", "getChannelId", "()I", "setChannelId", "(I)V", "dynamicJson", "getDynamicJson", "setDynamicJson", "pageName", "getPageName", "setPageName", "uniqueId", "getUniqueId", "setUniqueId", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oyb
{
  private int jdField_a_of_type_Int = -1;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @NotNull
  private String b = "";
  @NotNull
  private String c = "";
  @NotNull
  private String d = "";
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return "channelId = " + this.jdField_a_of_type_Int + ", uniqueId = " + this.jdField_a_of_type_JavaLangString + ", pageName = " + this.b + ", \n dynamicJson = " + this.c + ", \n cardReportJson = " + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyb
 * JD-Core Version:    0.7.0.1
 */