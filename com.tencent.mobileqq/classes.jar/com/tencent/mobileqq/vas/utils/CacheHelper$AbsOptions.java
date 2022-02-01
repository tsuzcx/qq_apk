package com.tencent.mobileqq.vas.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/utils/CacheHelper$AbsOptions;", "", "()V", "key", "", "getKey", "()Ljava/lang/String;", "key$delegate", "Lkotlin/Lazy;", "buildObject", "genKey", "isAlive", "", "o", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class CacheHelper$AbsOptions
{
  @NotNull
  private final Lazy a = LazyKt.lazy((Function0)new CacheHelper.AbsOptions.key.2(this));
  
  @NotNull
  public abstract Object a();
  
  @NotNull
  public abstract String a();
  
  public boolean a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "o");
    return true;
  }
  
  @NotNull
  public final String b()
  {
    return (String)this.a.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.utils.CacheHelper.AbsOptions
 * JD-Core Version:    0.7.0.1
 */