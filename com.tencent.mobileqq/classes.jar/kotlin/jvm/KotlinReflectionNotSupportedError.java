package kotlin.jvm;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/KotlinReflectionNotSupportedError;", "Ljava/lang/Error;", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public class KotlinReflectionNotSupportedError
  extends Error
{
  public KotlinReflectionNotSupportedError()
  {
    super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
  }
  
  public KotlinReflectionNotSupportedError(@Nullable String paramString)
  {
    super(paramString);
  }
  
  public KotlinReflectionNotSupportedError(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public KotlinReflectionNotSupportedError(@Nullable Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.KotlinReflectionNotSupportedError
 * JD-Core Version:    0.7.0.1
 */