package com.tencent.mobileqq.education.request.respone;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/respone/IStudyResponse;", "", "decode", "", "buffer", "", "getBuffer", "getErrorCode", "", "getErrorInfo", "", "getErrorMsg", "qq-education-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IStudyResponse
{
  @Nullable
  public abstract byte[] a();
  
  public abstract int b();
  
  @Nullable
  public abstract String c();
  
  @Nullable
  public abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.respone.IStudyResponse
 * JD-Core Version:    0.7.0.1
 */