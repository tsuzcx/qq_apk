package com.tencent.tkd.weibo.richEditText.connection;

import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/richEditText/connection/FixSharpConnectionWrapper;", "Lcom/tencent/tkd/weibo/richEditText/connection/FixDelConnectionWrapper;", "richEditText", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "connection", "Landroid/view/inputmethod/InputConnection;", "mutable", "", "(Lcom/tencent/tkd/weibo/richEditText/RichEditText;Landroid/view/inputmethod/InputConnection;Z)V", "lastComposingText", "", "getRichEditText", "()Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "commitText", "text", "", "newCursorPosition", "", "finishComposingText", "setComposingRegion", "start", "end", "setComposingText", "Companion", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class FixSharpConnectionWrapper
  extends FixDelConnectionWrapper
{
  public static final FixSharpConnectionWrapper.Companion a;
  @NotNull
  private final RichEditText jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
  private String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboRichEditTextConnectionFixSharpConnectionWrapper$Companion = new FixSharpConnectionWrapper.Companion(null);
  }
  
  public FixSharpConnectionWrapper(@NotNull RichEditText paramRichEditText, @NotNull InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
    this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText = paramRichEditText;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean commitText(@Nullable CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commitText=>text: ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(", newCursorPos: ");
    localStringBuilder.append(paramInt);
    Log.d("FixSharpConnection", localStringBuilder.toString());
    if (((Intrinsics.areEqual(paramCharSequence, "#") ^ true)) && (paramCharSequence != null) && (StringsKt.startsWith$default(paramCharSequence, (CharSequence)"#", false, 2, null) == true)) {
      return super.commitText((CharSequence)paramCharSequence.subSequence(1, paramCharSequence.length()).toString(), paramInt);
    }
    return super.commitText(paramCharSequence, paramInt);
  }
  
  public boolean finishComposingText()
  {
    Log.d("FixSharpConnection", "finishComposingText");
    return super.finishComposingText();
  }
  
  public boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    int j = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.getSelectionEnd();
    int i = 1;
    if (j >= 1)
    {
      if (this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.getText().toString().charAt(j - 1) != '#') {
        i = 0;
      }
      if (i != 0) {
        return super.setComposingRegion(paramInt2, paramInt2);
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setComposingRegion=>start: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", end: ");
    ((StringBuilder)localObject).append(paramInt2);
    Log.d("FixSharpConnection", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "richEditText.text");
    this.jdField_a_of_type_JavaLangString = ((CharSequence)localObject).subSequence(paramInt1, paramInt2).toString();
    return super.setComposingRegion(paramInt1, paramInt2);
  }
  
  public boolean setComposingText(@Nullable CharSequence paramCharSequence, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setComposingText=>text: ");
    ((StringBuilder)localObject).append(paramCharSequence);
    ((StringBuilder)localObject).append(", newCursorPos: ");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("FixSharpConnection", ((StringBuilder)localObject).toString());
    if (Intrinsics.areEqual(paramCharSequence, "#"))
    {
      commitText((CharSequence)"#", paramInt);
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("setComposingText actually=>[] on ");
      paramCharSequence.append(paramInt);
      Log.i("FixSharpConnection", paramCharSequence.toString());
      return super.setComposingText((CharSequence)"", paramInt);
    }
    int j = 1;
    if ((paramCharSequence != null) && (StringsKt.startsWith$default(paramCharSequence, (CharSequence)"#", false, 2, null) == true))
    {
      paramCharSequence = paramCharSequence.subSequence(1, paramCharSequence.length()).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setComposingText actually=>[");
      ((StringBuilder)localObject).append(paramCharSequence);
      ((StringBuilder)localObject).append("] on ");
      ((StringBuilder)localObject).append(paramInt);
      Log.i("FixSharpConnection", ((StringBuilder)localObject).toString());
      return super.setComposingText((CharSequence)paramCharSequence, paramInt);
    }
    if (paramCharSequence != null)
    {
      localObject = paramCharSequence.toString();
      if (localObject != null)
      {
        i = ((String)localObject).length();
        break label238;
      }
    }
    int i = 0;
    label238:
    if (i < this.jdField_a_of_type_JavaLangString.length()) {
      i = j;
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText.a();
    if ((i != 0) && (localObject != null))
    {
      boolean bool = super.setComposingText((CharSequence)this.jdField_a_of_type_JavaLangString, paramInt);
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("setComposingText actually=>[");
      paramCharSequence.append(this.jdField_a_of_type_JavaLangString);
      paramCharSequence.append("] on ");
      paramCharSequence.append(paramInt);
      Log.i("FixSharpConnection", paramCharSequence.toString());
      sendKeyEvent(new KeyEvent(0, 67));
      return bool;
    }
    return super.setComposingText(paramCharSequence, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.connection.FixSharpConnectionWrapper
 * JD-Core Version:    0.7.0.1
 */