package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.experimental.AbstractCoroutineContextElement;
import kotlin.coroutines.experimental.CoroutineContext.Key;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalContextMigration;", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Key", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ExperimentalContextMigration
  extends AbstractCoroutineContextElement
{
  public static final ExperimentalContextMigration.Key Key = new ExperimentalContextMigration.Key(null);
  @NotNull
  private final CoroutineContext context;
  
  public ExperimentalContextMigration(@NotNull CoroutineContext paramCoroutineContext)
  {
    super((CoroutineContext.Key)Key);
    this.context = paramCoroutineContext;
  }
  
  @NotNull
  public final CoroutineContext getContext()
  {
    return this.context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ExperimentalContextMigration
 * JD-Core Version:    0.7.0.1
 */