package com.tencent.timi.game.component.chat.input;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/input/TimiBaseInputView$emojiCallback$1", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "delete", "", "emoticonMall", "onHidePopup", "info", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "onLongClick", "", "onShowPopup", "oldInfo", "newInfo", "d", "Landroid/graphics/drawable/Drawable;", "send", "setting", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiBaseInputView$emojiCallback$1
  implements EmoticonCallback
{
  public void delete()
  {
    if (this.a.getInputEditText() != null) {
      this.a.j();
    }
  }
  
  public void emoticonMall() {}
  
  public void onHidePopup(@Nullable EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(@Nullable EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(@Nullable EmoticonInfo paramEmoticonInfo1, @Nullable EmoticonInfo paramEmoticonInfo2, @Nullable Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(@Nullable EmoticonInfo paramEmoticonInfo)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = Result.Companion;
        localObject2 = MobileQQ.sMobileQQ;
        localObject1 = null;
        AppRuntime localAppRuntime = ((MobileQQ)localObject2).waitAppRuntime(null);
        if (TimiBaseInputView.c(this.a) != null)
        {
          localObject2 = this.a.getInputEditText();
          if (localObject2 != null)
          {
            if (paramEmoticonInfo == null) {
              break label103;
            }
            paramEmoticonInfo.send(localAppRuntime, TimiBaseInputView.c(this.a), (EditText)localObject2, null);
            break label103;
          }
          paramEmoticonInfo = Result.constructor-impl(localObject1);
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramEmoticonInfo)
      {
        localObject1 = Result.Companion;
        paramEmoticonInfo = Result.constructor-impl(ResultKt.createFailure(paramEmoticonInfo));
        if (Result.isFailure-impl(paramEmoticonInfo)) {
          Logger.c("TimiInputView", String.valueOf(Result.exceptionOrNull-impl(paramEmoticonInfo)));
        }
        return;
      }
      label103:
      Object localObject1 = localObject2;
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.emojiCallback.1
 * JD-Core Version:    0.7.0.1
 */