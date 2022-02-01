package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyFragment$initEditTextView$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "charSequence", "", "i", "", "i1", "i2", "onTextChanged", "s", "start", "before", "count", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveReadyFragment$initEditTextView$1
  implements TextWatcher
{
  public void afterTextChanged(@NotNull Editable paramEditable)
  {
    Intrinsics.checkParameterIsNotNull(paramEditable, "editable");
    int i;
    if (((CharSequence)paramEditable.toString()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      LiveReadyFragment.l(this.a).postValue(Boolean.valueOf(true));
      return;
    }
    LiveReadyFragment.l(this.a).postValue(Boolean.valueOf(false));
  }
  
  public void beforeTextChanged(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "charSequence");
  }
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment.initEditTextView.1
 * JD-Core Version:    0.7.0.1
 */