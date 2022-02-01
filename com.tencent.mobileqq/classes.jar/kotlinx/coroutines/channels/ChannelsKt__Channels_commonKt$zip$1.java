package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "E", "R", "t1", "t2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k=3, mv={1, 1, 16})
final class ChannelsKt__Channels_commonKt$zip$1
  extends Lambda
  implements Function2<E, R, Pair<? extends E, ? extends R>>
{
  public static final 1 INSTANCE = new 1();
  
  ChannelsKt__Channels_commonKt$zip$1()
  {
    super(2);
  }
  
  @NotNull
  public final Pair<E, R> invoke(E paramE, R paramR)
  {
    return TuplesKt.to(paramE, paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.zip.1
 * JD-Core Version:    0.7.0.1
 */