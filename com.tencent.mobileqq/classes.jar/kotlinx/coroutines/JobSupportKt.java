package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class JobSupportKt
{
  private static final Symbol COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY");
  private static final Symbol COMPLETING_RETRY;
  @JvmField
  @NotNull
  public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
  private static final Empty EMPTY_ACTIVE = new Empty(true);
  private static final Empty EMPTY_NEW;
  private static final int FALSE = 0;
  private static final int RETRY = -1;
  private static final Symbol SEALED;
  private static final Symbol TOO_LATE_TO_CANCEL;
  private static final int TRUE = 1;
  
  static
  {
    COMPLETING_RETRY = new Symbol("COMPLETING_RETRY");
    TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL");
    SEALED = new Symbol("SEALED");
    EMPTY_NEW = new Empty(false);
  }
  
  @Nullable
  public static final Object boxIncomplete(@Nullable Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof Incomplete)) {
      localObject = new IncompleteStateBox((Incomplete)paramObject);
    }
    return localObject;
  }
  
  @Nullable
  public static final Object unboxState(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof IncompleteStateBox)) {
      localObject1 = null;
    } else {
      localObject1 = paramObject;
    }
    Object localObject2 = (IncompleteStateBox)localObject1;
    Object localObject1 = paramObject;
    if (localObject2 != null)
    {
      localObject2 = ((IncompleteStateBox)localObject2).state;
      localObject1 = paramObject;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobSupportKt
 * JD-Core Version:    0.7.0.1
 */