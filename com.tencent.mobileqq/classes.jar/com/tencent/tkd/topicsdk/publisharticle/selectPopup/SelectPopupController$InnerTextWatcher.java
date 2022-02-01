package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController$InnerTextWatcher;", "Landroid/text/TextWatcher;", "context", "Landroid/content/Context;", "(Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "isEnteringInValidChar", "", "onTextChanged", "before", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectPopupController$InnerTextWatcher
  implements TextWatcher
{
  @NotNull
  private final Context b;
  
  public SelectPopupController$InnerTextWatcher(Context paramContext)
  {
    this.b = localObject;
  }
  
  private final boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    int i;
    if (paramCharSequence != null) {
      i = paramCharSequence.length();
    } else {
      i = 0;
    }
    if (paramCharSequence != null)
    {
      if (i <= paramInt1) {
        return false;
      }
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1).toString();
      bool = SelectPopupController.e(this.a).matcher((CharSequence)paramCharSequence).find();
    }
    return bool;
  }
  
  @NotNull
  public final Context a()
  {
    return this.b;
  }
  
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    if ((paramEditable != null) && (SelectPopupController.a(this.a) != -1) && (SelectPopupController.b(this.a).getSelectionEnd() > SelectPopupController.a(this.a)))
    {
      paramEditable = (CharSequence)paramEditable;
      int j = SelectPopupController.a(this.a);
      int i = 1;
      paramEditable = paramEditable.subSequence(j + 1, SelectPopupController.b(this.a).getSelectionEnd()).toString();
      SelectPopupView localSelectPopupView = SelectPopupController.c(this.a);
      localSelectPopupView.b(paramEditable);
      localSelectPopupView.a(SelectPopupController.d(this.a).a(this.b, -1));
      if (((CharSequence)paramEditable).length() <= 0) {
        i = 0;
      }
      if (i != 0) {
        SelectPopupController.d(this.a).a(paramEditable, (Function1)new SelectPopupController.InnerTextWatcher.afterTextChanged.2(this));
      }
    }
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramCharSequence != null) {
      i = paramCharSequence.length();
    } else {
      i = 0;
    }
    if ((paramInt2 == 0) && (i > paramInt1) && (paramInt3 == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramCharSequence != null) && (paramCharSequence.charAt(paramInt1) == SelectPopupController.d(this.a).a())) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int j;
    if ((i != 0) && (paramCharSequence != null) && (paramCharSequence.charAt(paramInt1) == ' ')) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramInt2 != 0) && (SelectPopupController.c(this.a).isShowing())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j != 0) && (SelectPopupController.c(this.a).isShowing())) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i == 0) && (j == 0))
    {
      if (paramInt2 != 0)
      {
        SelectPopupController.a(this.a, paramInt1);
        SelectPopupController.a(this.a, false, false, 3, null);
        return;
      }
      if ((SelectPopupController.c(this.a).isShowing()) && (a(paramCharSequence, paramInt1, paramInt3))) {
        this.a.a(5);
      }
    }
    else
    {
      if (((CharSequence)SelectPopupController.c(this.a).a()).length() > 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      if (paramInt2 != 0)
      {
        paramCharSequence = SelectPopupController.d(this.a).a(SelectPopupController.c(this.a).a());
        Function3 localFunction3 = this.a.a();
        if (localFunction3 != null) {
          paramCharSequence = (Unit)localFunction3.invoke(Integer.valueOf(SelectPopupController.a(this.a)), Boolean.valueOf(true), paramCharSequence);
        }
        SelectPopupController.c(this.a).b("");
        if (i != 0)
        {
          SelectPopupController.a(this.a, paramInt1 + 1);
          SelectPopupController.b(this.a).setSelection(SelectPopupController.a(this.a) + 1);
          SelectPopupController.b(this.a, false, false, 3, null);
          SelectPopupController.a(this.a, false, false, 3, null);
        }
      }
      else
      {
        if (j != 0)
        {
          this.a.a(4);
          return;
        }
        SelectPopupController.a(this.a, paramInt1);
        SelectPopupController.b(this.a).setSelection(SelectPopupController.a(this.a) + 1);
        SelectPopupController.b(this.a, false, false, 3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController.InnerTextWatcher
 * JD-Core Version:    0.7.0.1
 */