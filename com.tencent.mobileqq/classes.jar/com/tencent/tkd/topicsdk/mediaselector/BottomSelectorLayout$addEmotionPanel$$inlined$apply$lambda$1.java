package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.comment.panel.base.listener.OnEmotionItemClickListener;
import com.tencent.tkd.comment.panel.model.Emotion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/comment/panel/model/Emotion;", "onEmotionItemClick", "com/tencent/tkd/topicsdk/mediaselector/BottomSelectorLayout$addEmotionPanel$emotionPanel$1$1"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$addEmotionPanel$$inlined$apply$lambda$1
  implements OnEmotionItemClickListener
{
  BottomSelectorLayout$addEmotionPanel$$inlined$apply$lambda$1(BottomSelectorLayout paramBottomSelectorLayout) {}
  
  public final void a(@Nullable Emotion paramEmotion)
  {
    if (paramEmotion != null)
    {
      Function1 localFunction1 = this.a.b();
      if (localFunction1 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramEmotion, "emotion");
        paramEmotion = (Unit)localFunction1.invoke(paramEmotion);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addEmotionPanel..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */