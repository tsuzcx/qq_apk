package com.tencent.timi.game.component.chat.message;

import com.tencent.timi.game.tim.api.message.IMsg;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "o1", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "kotlin.jvm.PlatformType", "o2", "compare"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$sortAndNotify$1<T>
  implements Comparator<IMsg>
{
  public static final 1 a = new 1();
  
  public final int a(IMsg paramIMsg1, IMsg paramIMsg2)
  {
    return paramIMsg1.e() < paramIMsg2.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.sortAndNotify.1
 * JD-Core Version:    0.7.0.1
 */