package com.tencent.qapmsdk.base.breadcrumbreflect;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/breadcrumbreflect/AthenaReflect;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AthenaReflect
{
  public static final AthenaReflect.Companion Companion = new AthenaReflect.Companion(null);
  private static final String TAG = "QAPM_base_AthenaReflect";
  private static Method athenaGenerateEvent;
  private static Object athenaInstance;
  private static boolean isBreadCrumb;
  
  @JvmStatic
  @NotNull
  public static final String getBreadCrumbId(int paramInt, @Nullable AthenaInfo paramAthenaInfo)
  {
    return Companion.getBreadCrumbId(paramInt, paramAthenaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.breadcrumbreflect.AthenaReflect
 * JD-Core Version:    0.7.0.1
 */