package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/Channel$Factory;", "", "()V", "BUFFERED", "", "CHANNEL_DEFAULT_CAPACITY", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "CONFLATED", "DEFAULT_BUFFER_PROPERTY_NAME", "", "OPTIONAL_CHANNEL", "RENDEZVOUS", "UNLIMITED", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class Channel$Factory
{
  public static final int BUFFERED = -2;
  private static final int CHANNEL_DEFAULT_CAPACITY = SystemPropsKt.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
  public static final int CONFLATED = -1;
  @NotNull
  public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
  public static final int OPTIONAL_CHANNEL = -3;
  public static final int RENDEZVOUS = 0;
  public static final int UNLIMITED = 2147483647;
  
  public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()
  {
    return CHANNEL_DEFAULT_CAPACITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.Channel.Factory
 * JD-Core Version:    0.7.0.1
 */