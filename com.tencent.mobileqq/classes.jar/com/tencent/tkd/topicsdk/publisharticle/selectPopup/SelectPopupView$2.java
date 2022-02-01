package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectPopupView$2
  implements TextWatcher
{
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    int i;
    if (paramEditable != null) {
      i = paramEditable.length();
    } else {
      i = 0;
    }
    SelectPopupView.a(this.a).setText((CharSequence)String.valueOf(this.a.b() - i));
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupView.2
 * JD-Core Version:    0.7.0.1
 */