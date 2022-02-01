package com.tencent.tkd.weibo.richEditText;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/richEditText/RichEditText$initTextWaterListener$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class RichEditText$initTextWaterListener$1
  implements TextWatcher
{
  public void afterTextChanged(@NotNull Editable paramEditable)
  {
    Intrinsics.checkParameterIsNotNull(paramEditable, "s");
  }
  
  public void beforeTextChanged(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "s");
  }
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    if (paramCharSequence != null) {}
    for (int i = paramCharSequence.length();; i = 0)
    {
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
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.RichEditText.initTextWaterListener.1
 * JD-Core Version:    0.7.0.1
 */