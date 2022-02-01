package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
final class WeakClassLoaderBox
{
  private final int identityHashCode;
  @NotNull
  private final WeakReference<ClassLoader> ref;
  @Nullable
  private ClassLoader temporaryStrongRef;
  
  public WeakClassLoaderBox(@NotNull ClassLoader paramClassLoader)
  {
    this.ref = new WeakReference(paramClassLoader);
    this.identityHashCode = System.identityHashCode(paramClassLoader);
    this.temporaryStrongRef = paramClassLoader;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof WeakClassLoaderBox)) && ((ClassLoader)this.ref.get() == (ClassLoader)((WeakClassLoaderBox)paramObject).ref.get());
  }
  
  public int hashCode()
  {
    return this.identityHashCode;
  }
  
  public final void setTemporaryStrongRef(@Nullable ClassLoader paramClassLoader)
  {
    this.temporaryStrongRef = paramClassLoader;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = (ClassLoader)this.ref.get();
    if (localObject != null)
    {
      localObject = ((ClassLoader)localObject).toString();
      if (localObject != null) {
        return localObject;
      }
    }
    return "<null>";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.WeakClassLoaderBox
 * JD-Core Version:    0.7.0.1
 */