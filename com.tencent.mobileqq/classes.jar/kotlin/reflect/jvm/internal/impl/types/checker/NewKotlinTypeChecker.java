package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;

public abstract interface NewKotlinTypeChecker
  extends KotlinTypeChecker
{
  public static final NewKotlinTypeChecker.Companion Companion = NewKotlinTypeChecker.Companion.$$INSTANCE;
  
  @NotNull
  public abstract KotlinTypeRefiner getKotlinTypeRefiner();
  
  @NotNull
  public abstract OverridingUtil getOverridingUtil();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
 * JD-Core Version:    0.7.0.1
 */