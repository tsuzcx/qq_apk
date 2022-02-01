package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.Nullable;

public abstract class KotlinClassFinder$Result
{
  @Nullable
  public final KotlinJvmBinaryClass toKotlinJvmBinaryClass()
  {
    boolean bool = this instanceof KotlinClassFinder.Result.KotlinClass;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    } else {
      localObject1 = this;
    }
    KotlinClassFinder.Result.KotlinClass localKotlinClass = (KotlinClassFinder.Result.KotlinClass)localObject1;
    Object localObject1 = localObject2;
    if (localKotlinClass != null) {
      localObject1 = localKotlinClass.getKotlinJvmBinaryClass();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result
 * JD-Core Version:    0.7.0.1
 */