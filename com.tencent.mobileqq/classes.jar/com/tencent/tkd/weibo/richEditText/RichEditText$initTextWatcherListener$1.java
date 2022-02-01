package com.tencent.tkd.weibo.richEditText;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.tkd.weibo.richEditText.span.RichSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/richEditText/RichEditText$initTextWatcherListener$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class RichEditText$initTextWatcherListener$1
  implements TextWatcher
{
  public void afterTextChanged(@NotNull Editable paramEditable)
  {
    Intrinsics.checkParameterIsNotNull(paramEditable, "s");
  }
  
  public void beforeTextChanged(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "s");
    paramCharSequence = (RichSpan[])this.a.getText().getSpans(paramInt1, paramInt2 + paramInt1, RichSpan.class);
    Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "selectedSpan");
    if (paramCharSequence.length == 0) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (((paramInt2 ^ 0x1) != 0) && (this.a.getText().getSpanStart(paramCharSequence[0]) == paramInt1) && (this.a.getText().getSpanEnd(paramCharSequence[0]) == this.a.getSelectionEnd())) {
      this.a.getText().removeSpan(paramCharSequence[0]);
    }
  }
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    int i;
    if (paramCharSequence != null) {
      i = paramCharSequence.length();
    } else {
      i = 0;
    }
    Object localObject = this.a.a();
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(i));
    }
    int j = k;
    if (paramCharSequence != null)
    {
      j = k;
      if (paramInt2 == 0)
      {
        j = k;
        if (i > paramInt1)
        {
          j = k;
          if (paramCharSequence.charAt(paramInt1) == '@')
          {
            j = k;
            if (paramInt3 == 1) {
              j = 1;
            }
          }
        }
      }
    }
    if (j != 0)
    {
      paramCharSequence = this.a.a();
      if (paramCharSequence != null) {
        paramCharSequence = (Unit)paramCharSequence.invoke();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.RichEditText.initTextWatcherListener.1
 * JD-Core Version:    0.7.0.1
 */