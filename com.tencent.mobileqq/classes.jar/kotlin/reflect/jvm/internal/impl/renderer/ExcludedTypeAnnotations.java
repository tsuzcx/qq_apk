package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class ExcludedTypeAnnotations
{
  public static final ExcludedTypeAnnotations INSTANCE = new ExcludedTypeAnnotations();
  @NotNull
  private static final Set<FqName> internalAnnotationsForResolve = SetsKt.setOf(new FqName[] { new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact") });
  
  @NotNull
  public final Set<FqName> getInternalAnnotationsForResolve()
  {
    return internalAnnotationsForResolve;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.ExcludedTypeAnnotations
 * JD-Core Version:    0.7.0.1
 */