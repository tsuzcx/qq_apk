package com.tencent.timi.game.team.impl.chat;

import android.view.View;
import android.widget.EditText;
import com.tencent.timi.game.component.chat.input.KeyboardUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamInputView$layoutInflated$1$onTextChanged$1$1", "Ljava/lang/Runnable;", "run", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamInputView$layoutInflated$1$onTextChanged$1$1
  implements Runnable
{
  public void run()
  {
    EditText localEditText = TeamInputView.a(this.this$0.a.a);
    if (localEditText == null) {
      Intrinsics.throwNpe();
    }
    KeyboardUtils.a((View)localEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamInputView.layoutInflated.1.onTextChanged.1.1
 * JD-Core Version:    0.7.0.1
 */