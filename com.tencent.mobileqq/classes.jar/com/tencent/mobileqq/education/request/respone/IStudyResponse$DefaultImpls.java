package com.tencent.mobileqq.education.request.respone;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class IStudyResponse$DefaultImpls
{
  @Nullable
  public static String a(IStudyResponse paramIStudyResponse)
  {
    StringBuffer localStringBuffer = new StringBuffer("ErrorInfo");
    localStringBuffer.append(" errorCode:");
    localStringBuffer.append(paramIStudyResponse.b());
    localStringBuffer.append(" errorMsg:");
    localStringBuffer.append(paramIStudyResponse.c());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.respone.IStudyResponse.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */