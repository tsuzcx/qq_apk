package com.tencent.timi.game.component.chat.input;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.text.QQTextBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/input/TimiBaseInputView$emojiEditableFactory$2$1", "Landroid/text/Editable$Factory;", "newEditable", "Landroid/text/Editable;", "source", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiBaseInputView$emojiEditableFactory$2$1
  extends Editable.Factory
{
  @NotNull
  public Editable newEditable(@Nullable CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return (Editable)new QQTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.emojiEditableFactory.2.1
 * JD-Core Version:    0.7.0.1
 */