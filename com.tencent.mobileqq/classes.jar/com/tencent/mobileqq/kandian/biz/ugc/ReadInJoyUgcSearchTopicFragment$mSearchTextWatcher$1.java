package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyUgcSearchTopicFragment$mSearchTextWatcher$1", "Landroid/text/TextWatcher;", "oldLength", "", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyUgcSearchTopicFragment$mSearchTextWatcher$1
  implements TextWatcher
{
  private int b;
  
  public void afterTextChanged(@NotNull Editable paramEditable)
  {
    Intrinsics.checkParameterIsNotNull(paramEditable, "s");
    int m = paramEditable.length();
    int i = this.b;
    int k = 1;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (m > 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i ^ j) != 0)
    {
      Drawable[] arrayOfDrawable = ReadInJoyUgcSearchTopicFragment.b(this.a).getCompoundDrawables();
      if (m > 0)
      {
        Drawable localDrawable = this.a.getResources().getDrawable(2130839736);
        localDrawable.setBounds(0, 0, ViewUtils.dpToPx(16.0F), ViewUtils.dpToPx(16.0F));
        arrayOfDrawable[2] = localDrawable;
      }
      else
      {
        arrayOfDrawable[2] = ((Drawable)null);
      }
      ReadInJoyUgcSearchTopicFragment.b(this.a).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
    this.b = m;
    ReadInJoyUgcSearchTopicFragment.a(this.a, paramEditable.toString());
    if (((CharSequence)paramEditable).length() > 0) {
      i = k;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ReadInJoyLogicEngine.a().g(ReadInJoyUgcSearchTopicFragment.d(this.a));
      return;
    }
    ReadInJoyUgcSearchTopicFragment.e(this.a).setVisibility(4);
  }
  
  public void beforeTextChanged(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "s");
  }
  
  public void onTextChanged(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "s");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment.mSearchTextWatcher.1
 * JD-Core Version:    0.7.0.1
 */