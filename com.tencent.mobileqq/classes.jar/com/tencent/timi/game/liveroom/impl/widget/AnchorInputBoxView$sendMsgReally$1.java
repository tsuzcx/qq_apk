package com.tencent.timi.game.liveroom.impl.widget;

import android.widget.EditText;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AnchorInputBoxView$sendMsgReally$1", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "onFail", "", "errCode", "", "errMsg", "", "onIllegalMsg", "onSuccess", "isLocal", "", "onUserForbid", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorInputBoxView$sendMsgReally$1
  implements IQQLiveMessageCallback
{
  public void a() {}
  
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    EditText localEditText = AnchorInputBoxView.c(this.a);
    if (localEditText != null) {
      localEditText.setText((CharSequence)"");
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView.sendMsgReally.1
 * JD-Core Version:    0.7.0.1
 */