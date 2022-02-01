package com.tencent.mobileqq.util.privacy.handler;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class IJSPackageInfoHandler$DefaultImpls
{
  @NotNull
  public static BusinessData a(IJSPackageInfoHandler paramIJSPackageInfoHandler, @Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramIJSPackageInfoHandler = new StringBuilder();
      paramIJSPackageInfoHandler.append("getParams ");
      paramIJSPackageInfoHandler.append(paramString);
      QLog.d("IJSPackageInfoHandler", 1, paramIJSPackageInfoHandler.toString());
    }
    if (paramString != null)
    {
      paramString = new JSONObject(paramString);
      paramIJSPackageInfoHandler = paramString.optString("packageName", "");
      paramString = paramString.optString("businessName", "");
      Intrinsics.checkExpressionValueIsNotNull(paramIJSPackageInfoHandler, "packageName");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "businessName");
      return new BusinessData(paramIJSPackageInfoHandler, paramString);
    }
    return BusinessData.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.handler.IJSPackageInfoHandler.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */