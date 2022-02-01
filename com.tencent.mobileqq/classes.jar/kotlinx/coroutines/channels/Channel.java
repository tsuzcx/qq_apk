package kotlinx.coroutines.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface Channel<E>
  extends ReceiveChannel<E>, SendChannel<E>
{
  public static final int BUFFERED = -2;
  public static final int CONFLATED = -1;
  @NotNull
  public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
  public static final Channel.Factory Factory = Channel.Factory.$$INSTANCE;
  public static final int OPTIONAL_CHANNEL = -3;
  public static final int RENDEZVOUS = 0;
  public static final int UNLIMITED = 2147483647;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.Channel
 * JD-Core Version:    0.7.0.1
 */