package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.view.KeyEvent;
import com.tencent.tkd.comment.panel.model.EmoJiEmotion;
import com.tencent.tkd.comment.panel.model.Emotion;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.interfaces.IEmoJiEmotion;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "emoJi", "Lcom/tencent/tkd/comment/panel/model/Emotion;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$addEmotionPanelInSelectorLayout$1
  extends Lambda
  implements Function1<Emotion, Unit>
{
  PublishArticlePage$addEmotionPanelInSelectorLayout$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(@NotNull Emotion paramEmotion)
  {
    Intrinsics.checkParameterIsNotNull(paramEmotion, "emoJi");
    if ((paramEmotion.getEmotionType() == 0) && ((paramEmotion.actualEmotion instanceof EmoJiEmotion)))
    {
      paramEmotion = paramEmotion.actualEmotion;
      if (paramEmotion != null)
      {
        Object localObject = (EmoJiEmotion)paramEmotion;
        paramEmotion = TopicSDK.a.a().a().a().a(((EmoJiEmotion)localObject).emoJiResourceId);
        if (paramEmotion != null)
        {
          RichEditText localRichEditText = PublishArticlePage.a(this.this$0);
          localObject = ((EmoJiEmotion)localObject).emoJiShowName;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "actualEmotion.emoJiShowName");
          RichEditText.a(localRichEditText, paramEmotion, (String)localObject, 0, 0, 0, 28, null);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.comment.panel.model.EmoJiEmotion");
      }
    }
    else if (paramEmotion.getEmotionType() == -1)
    {
      paramEmotion = new KeyEvent(0, 67);
      PublishArticlePage.a(this.this$0).dispatchKeyEvent(paramEmotion);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.addEmotionPanelInSelectorLayout.1
 * JD-Core Version:    0.7.0.1
 */