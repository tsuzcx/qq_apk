package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.experimental.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ContextMigration;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "(Lkotlin/coroutines/experimental/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "Key", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ContextMigration
  extends AbstractCoroutineContextElement
{
  public static final ContextMigration.Key Key = new ContextMigration.Key(null);
  @NotNull
  private final CoroutineContext context;
  
  public ContextMigration(@NotNull CoroutineContext paramCoroutineContext)
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
 * Qualified Name:     kotlin.coroutines.experimental.migration.ContextMigration
 * JD-Core Version:    0.7.0.1
 */