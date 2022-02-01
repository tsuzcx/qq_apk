package com.tencent.mobileqq.listentogether;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController$Data;", "", "type", "", "uin", "", "(ILjava/lang/String;)V", "sessionType", "getSessionType", "()I", "setSessionType", "(I)V", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "equals", "", "other", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ListenTogetherHeartBeatController$Data
{
  private int jdField_a_of_type_Int;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  
  public ListenTogetherHeartBeatController$Data(int paramInt, @NotNull String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Data)) {
      return (((Data)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (StringsKt.equals$default(((Data)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, false, 2, null));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHeartBeatController.Data
 * JD-Core Version:    0.7.0.1
 */