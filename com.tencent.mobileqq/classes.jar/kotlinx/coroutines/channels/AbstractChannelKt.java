package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ENQUEUE_FAILED", "", "ENQUEUE_FAILED$annotations", "()V", "HANDLER_INVOKED", "HANDLER_INVOKED$annotations", "OFFER_FAILED", "OFFER_FAILED$annotations", "OFFER_SUCCESS", "OFFER_SUCCESS$annotations", "POLL_FAILED", "POLL_FAILED$annotations", "RECEIVE_NULL_ON_CLOSE", "", "RECEIVE_RESULT", "RECEIVE_THROWS_ON_CLOSE", "toResult", "Lkotlinx/coroutines/channels/ValueOrClosed;", "E", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Object;", "Handler", "Lkotlin/Function1;", "", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class AbstractChannelKt
{
  @JvmField
  @NotNull
  public static final Object ENQUEUE_FAILED = new Symbol("ENQUEUE_FAILED");
  @JvmField
  @NotNull
  public static final Object HANDLER_INVOKED = new Symbol("ON_CLOSE_HANDLER_INVOKED");
  @JvmField
  @NotNull
  public static final Object OFFER_FAILED;
  @JvmField
  @NotNull
  public static final Object OFFER_SUCCESS = new Symbol("OFFER_SUCCESS");
  @JvmField
  @NotNull
  public static final Object POLL_FAILED;
  public static final int RECEIVE_NULL_ON_CLOSE = 1;
  public static final int RECEIVE_RESULT = 2;
  public static final int RECEIVE_THROWS_ON_CLOSE = 0;
  
  static
  {
    OFFER_FAILED = new Symbol("OFFER_FAILED");
    POLL_FAILED = new Symbol("POLL_FAILED");
  }
  
  private static final <E> Object toResult(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Closed))
    {
      localCompanion = ValueOrClosed.Companion;
      return ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(((Closed)paramObject).closeCause));
    }
    ValueOrClosed.Companion localCompanion = ValueOrClosed.Companion;
    return ValueOrClosed.constructor-impl(paramObject);
  }
  
  private static final <E> Object toResult(@NotNull Closed<?> paramClosed)
  {
    ValueOrClosed.Companion localCompanion = ValueOrClosed.Companion;
    return ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(paramClosed.closeCause));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannelKt
 * JD-Core Version:    0.7.0.1
 */