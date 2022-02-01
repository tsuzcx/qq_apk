package com.tencent.tkd.topicsdk.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/LimitWordEditText$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class LimitWordEditText$1
  implements TextWatcher
{
  public void afterTextChanged(@Nullable Editable paramEditable) {}
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = this.a.getCountChangeListener();
      if (paramCharSequence != null) {
        paramCharSequence = (Unit)paramCharSequence.invoke(Integer.valueOf(0));
      }
      this.a.getCountView().setText((CharSequence)String.valueOf(this.a.getCountLimit()));
      return;
    }
    Object localObject = this.a.getCountChangeListener();
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(paramCharSequence.length()));
    }
    this.a.getCountView().setText((CharSequence)String.valueOf(this.a.getCountLimit() - paramCharSequence.length()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.LimitWordEditText.1
 * JD-Core Version:    0.7.0.1
 */