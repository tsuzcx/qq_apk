package com.tencent.tkd.topicsdk.mediaselector;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k=1, mv={1, 1, 16})
public final class BottomSelectorLayout$addCountChangeTextView$$inlined$addTextChangedListener$1
  implements TextWatcher
{
  public BottomSelectorLayout$addCountChangeTextView$$inlined$addTextChangedListener$1(BottomSelectorLayout paramBottomSelectorLayout) {}
  
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    if (Integer.parseInt(String.valueOf(paramEditable)) < 0)
    {
      BottomSelectorLayout.a(this.a).setTextColor(Color.parseColor("#F44837"));
      return;
    }
    BottomSelectorLayout.a(this.a).setTextColor(Color.parseColor("#AAAAAA"));
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addCountChangeTextView..inlined.addTextChangedListener.1
 * JD-Core Version:    0.7.0.1
 */