package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CopyableThrowable;", "T", "", "", "createCopy", "()Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@ExperimentalCoroutinesApi
public abstract interface CopyableThrowable<T extends Throwable,  extends CopyableThrowable<T>>
{
  @Nullable
  public abstract T createCopy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CopyableThrowable
 * JD-Core Version:    0.7.0.1
 */