package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SignatureEnhancementBuilder$ClassEnhancementBuilder
{
  @NotNull
  private final String className;
  
  public SignatureEnhancementBuilder$ClassEnhancementBuilder(String paramString)
  {
    this.className = localObject;
  }
  
  public final void function(@NotNull String paramString, @NotNull Function1<? super SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    Map localMap = SignatureEnhancementBuilder.access$getSignatures$p(this.this$0);
    paramString = new SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder(this, paramString);
    paramFunction1.invoke(paramString);
    paramString = paramString.build();
    localMap.put(paramString.getFirst(), paramString.getSecond());
  }
  
  @NotNull
  public final String getClassName()
  {
    return this.className;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder
 * JD-Core Version:    0.7.0.1
 */