package com.tencent.mobileqq.education.request.respone;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/respone/StudySSOResponse;", "Lcom/tencent/mobileqq/education/request/respone/IStudyResponse;", "errorCode", "", "errorMsg", "", "(ILjava/lang/String;)V", "businessBuffer", "", "decode", "", "buffer", "getBuffer", "getErrorCode", "getErrorMsg", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class StudySSOResponse
  implements IStudyResponse
{
  private byte[] a;
  private final int b;
  private final String c;
  
  public StudySSOResponse(int paramInt, @NotNull String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
  }
  
  public void a(@Nullable byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  @Nullable
  public byte[] a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  @Nullable
  public String c()
  {
    return this.c;
  }
  
  @Nullable
  public String d()
  {
    return IStudyResponse.DefaultImpls.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.respone.StudySSOResponse
 * JD-Core Version:    0.7.0.1
 */