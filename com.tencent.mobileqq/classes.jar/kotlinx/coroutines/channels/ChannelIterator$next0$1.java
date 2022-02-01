package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"next0", "", "E", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f="Channel.kt", i={0}, l={463}, m="next", n={"$this"}, s={"L$0"})
final class ChannelIterator$next0$1
  extends ContinuationImpl
{
  Object L$0;
  int label;
  
  ChannelIterator$next0$1(ChannelIterator paramChannelIterator, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    paramObject = this.this$0;
    return ChannelIterator.DefaultImpls.next(null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelIterator.next0.1
 * JD-Core Version:    0.7.0.1
 */