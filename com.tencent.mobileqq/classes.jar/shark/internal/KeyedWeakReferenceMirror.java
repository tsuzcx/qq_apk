package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.ValueHolder.ReferenceHolder;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/KeyedWeakReferenceMirror;", "", "referent", "Lshark/ValueHolder$ReferenceHolder;", "key", "", "description", "watchDurationMillis", "", "retainedDurationMillis", "(Lshark/ValueHolder$ReferenceHolder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getDescription", "()Ljava/lang/String;", "hasReferent", "", "getHasReferent", "()Z", "isRetained", "getKey", "getReferent", "()Lshark/ValueHolder$ReferenceHolder;", "getRetainedDurationMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWatchDurationMillis", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class KeyedWeakReferenceMirror
{
  @NotNull
  public static final KeyedWeakReferenceMirror.Companion a = new KeyedWeakReferenceMirror.Companion(null);
  private final boolean b;
  private final boolean c;
  @NotNull
  private final ValueHolder.ReferenceHolder d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  @Nullable
  private final Long g;
  @Nullable
  private final Long h;
  
  public KeyedWeakReferenceMirror(@NotNull ValueHolder.ReferenceHolder paramReferenceHolder, @NotNull String paramString1, @NotNull String paramString2, @Nullable Long paramLong1, @Nullable Long paramLong2)
  {
    this.d = paramReferenceHolder;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong1;
    this.h = paramLong2;
    long l = this.d.b();
    boolean bool2 = true;
    if (l != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    paramReferenceHolder = this.h;
    boolean bool1 = bool2;
    if (paramReferenceHolder != null) {
      if (paramReferenceHolder == null) {
        bool1 = bool2;
      } else if (paramReferenceHolder.longValue() != -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.c = bool1;
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  public final boolean b()
  {
    return this.c;
  }
  
  @NotNull
  public final ValueHolder.ReferenceHolder c()
  {
    return this.d;
  }
  
  @NotNull
  public final String d()
  {
    return this.e;
  }
  
  @NotNull
  public final String e()
  {
    return this.f;
  }
  
  @Nullable
  public final Long f()
  {
    return this.g;
  }
  
  @Nullable
  public final Long g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.KeyedWeakReferenceMirror
 * JD-Core Version:    0.7.0.1
 */