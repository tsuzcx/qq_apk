package com.tencent.timi.game.component.chat.input;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.tencent.timi.game.component.chat.at.ChatAtMessageUtil;
import com.tencent.timi.game.ui.span.ExcludeInnerLineSpaceSpan;
import com.tencent.timi.game.ui.utils.ResUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/input/TimiBaseInputView$init$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiBaseInputView$init$4
  implements TextWatcher
{
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    ExcludeInnerLineSpaceSpan localExcludeInnerLineSpaceSpan = this.a.getExcludeLineSpan();
    if (localExcludeInnerLineSpaceSpan != null)
    {
      if (paramEditable != null) {
        paramEditable.removeSpan(localExcludeInnerLineSpaceSpan);
      }
      if (paramEditable != null) {
        paramEditable.setSpan(localExcludeInnerLineSpaceSpan, 0, paramEditable.length(), 33);
      }
    }
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence != null) {
      paramCharSequence = paramCharSequence.toString();
    } else {
      paramCharSequence = null;
    }
    Object localObject1 = this.a.getInputEditText();
    if (localObject1 != null)
    {
      localObject1 = ((EditText)localObject1).getText();
      if ((localObject1 != null) && ((this.a.getUserNameQQUserInfoMapIdMap().isEmpty() ^ true)))
      {
        Object localObject2 = (CharSequence)paramCharSequence;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (paramCharSequence == null) {
            Intrinsics.throwNpe();
          }
          Object localObject3 = (CharSequence)"@";
          paramInt1 = 0;
          if (StringsKt.contains$default((CharSequence)localObject2, (CharSequence)localObject3, false, 2, null))
          {
            localObject2 = ((Editable)localObject1).getSpans(0, ((Editable)localObject1).length(), ForegroundColorSpan.class);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.getSpans(0, it.length…undColorSpan::class.java)");
            localObject2 = (ForegroundColorSpan[])localObject2;
            paramInt2 = localObject2.length;
            while (paramInt1 < paramInt2)
            {
              ((Editable)localObject1).removeSpan(localObject2[paramInt1]);
              paramInt1 += 1;
            }
            this.a.getAtPosUserNameList().clear();
            localObject2 = this.a.getAtPosUserNameList();
            localObject3 = ChatAtMessageUtil.a;
            Map localMap = this.a.getUserNameQQUserInfoMapIdMap();
            localObject1 = (Spannable)localObject1;
            EditText localEditText = this.a.getInputEditText();
            if (localEditText != null) {
              paramInt1 = localEditText.getCurrentTextColor();
            } else {
              paramInt1 = ResUtils.b(2131165564);
            }
            ((List)localObject2).addAll((Collection)((ChatAtMessageUtil)localObject3).a(0, paramCharSequence, localMap, (Spannable)localObject1, paramInt1, false, null));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.init.4
 * JD-Core Version:    0.7.0.1
 */