package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"to898", "", "tValue", "", "from", "", "revFlag1", "revFlag4", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ReportHelperKt
{
  @JvmOverloads
  public static final void a(@NotNull String paramString)
  {
    a(paramString, 0, null, null, 14, null);
  }
  
  @JvmOverloads
  public static final void a(@NotNull String paramString, int paramInt)
  {
    a(paramString, paramInt, null, null, 12, null);
  }
  
  @JvmOverloads
  public static final void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    a(paramString1, paramInt, paramString2, null, 8, null);
  }
  
  @JvmOverloads
  public static final void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tValue");
    Intrinsics.checkParameterIsNotNull(paramString2, "revFlag1");
    Intrinsics.checkParameterIsNotNull(paramString3, "revFlag4");
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, paramInt, 0, paramString2, "", paramString3, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.ReportHelperKt
 * JD-Core Version:    0.7.0.1
 */