package com.tencent.mobileqq.vip;

import com.qq.taf.jce.JceStruct;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vip/AbsProtocol$JceIntercept;", "", "servantName", "", "cmd", "funcName", "block", "Lkotlin/Function1;", "Lcom/qq/taf/jce/JceStruct;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "getCmd", "()Ljava/lang/String;", "getFuncName", "getServantName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AbsProtocol$JceIntercept
{
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Function1<JceStruct, JceStruct> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final Function1<JceStruct, JceStruct> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof JceIntercept))
      {
        paramObject = (JceIntercept)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.b, paramObject.b)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (!Intrinsics.areEqual(this.jdField_a_of_type_KotlinJvmFunctionsFunction1, paramObject.jdField_a_of_type_KotlinJvmFunctionsFunction1))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.b;
      if (localObject == null) {
        break label95;
      }
      j = localObject.hashCode();
      label37:
      localObject = this.c;
      if (localObject == null) {
        break label100;
      }
    }
    label95:
    label100:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "JceIntercept(servantName=" + this.jdField_a_of_type_JavaLangString + ", cmd=" + this.b + ", funcName=" + this.c + ", block=" + this.jdField_a_of_type_KotlinJvmFunctionsFunction1 + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AbsProtocol.JceIntercept
 * JD-Core Version:    0.7.0.1
 */