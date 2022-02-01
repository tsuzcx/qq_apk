import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushComponentExtData;", "", "articleIds", "", "foldStatus", "algorithmId", "strategyId", "subscripts", "pushExtData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qog
{
  @JvmField
  @NotNull
  public String a;
  @JvmField
  @NotNull
  public byte[] a;
  @JvmField
  @NotNull
  public String b;
  @JvmField
  @NotNull
  public String c;
  @JvmField
  @NotNull
  public String d;
  @JvmField
  @NotNull
  public String e;
  
  public qog()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public qog(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((qog)this == paramObject) {
      return true;
    }
    Class localClass = getClass();
    if (paramObject != null) {}
    for (Object localObject = paramObject.getClass(); (Intrinsics.areEqual(localClass, localObject) ^ true); localObject = null) {
      return false;
    }
    if (paramObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.push.RIJPushComponentExtData");
    }
    localObject = (qog)paramObject;
    if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, ((qog)paramObject).jdField_a_of_type_JavaLangString) ^ true)) {
      return false;
    }
    if ((Intrinsics.areEqual(this.b, ((qog)paramObject).b) ^ true)) {
      return false;
    }
    if ((Intrinsics.areEqual(this.c, ((qog)paramObject).c) ^ true)) {
      return false;
    }
    if ((Intrinsics.areEqual(this.d, ((qog)paramObject).d) ^ true)) {
      return false;
    }
    if ((Intrinsics.areEqual(this.e, ((qog)paramObject).e) ^ true)) {
      return false;
    }
    return Arrays.equals(this.jdField_a_of_type_ArrayOfByte, ((qog)paramObject).jdField_a_of_type_ArrayOfByte);
  }
  
  public int hashCode()
  {
    return ((((this.jdField_a_of_type_JavaLangString.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode()) * 31 + this.e.hashCode()) * 31 + Arrays.hashCode(this.jdField_a_of_type_ArrayOfByte);
  }
  
  @NotNull
  public String toString()
  {
    return "RIJPushComponentExtData(articleIds=" + this.jdField_a_of_type_JavaLangString + ", foldStatus=" + this.b + ", algorithmId=" + this.c + ", strategyId=" + this.d + ", subscripts=" + this.e + ", pushExtData=" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte) + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qog
 * JD-Core Version:    0.7.0.1
 */