package com.tencent.mobileqq.kandian.biz.biu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeWatcher;
import com.tencent.mobileqq.kandian.base.view.widget.text.ISpan;
import com.tencent.mobileqq.kandian.biz.ugc.TopicSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class BiuEditText
  extends EditText
{
  private TextWatcher a;
  private boolean b = true;
  private boolean c = true;
  
  public BiuEditText(Context paramContext)
  {
    super(paramContext);
    d();
    b();
  }
  
  public BiuEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
    b();
  }
  
  private int a(int paramInt)
  {
    Editable localEditable = getEditableText();
    int j = 0;
    if (localEditable == null) {
      return 0;
    }
    ISpan[] arrayOfISpan = (ISpan[])localEditable.getSpans(0, getText().length(), ISpan.class);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getValidSelPosForRichText spans num : ");
      localStringBuilder.append(arrayOfISpan.length);
      QLog.d("BiuEditText", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (!this.b) && (arrayOfISpan.length != 0) && ((arrayOfISpan[0] instanceof TopicSpan))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return localEditable.getSpanEnd(arrayOfISpan[0]);
    }
    int k = arrayOfISpan.length;
    int i = j;
    while (i < k)
    {
      localEditable = arrayOfISpan[i];
      j = getText().getSpanStart(localEditable);
      int m = getText().getSpanEnd(localEditable);
      if ((j + 1 <= paramInt) && (m >= paramInt)) {
        return m;
      }
      i += 1;
    }
    return paramInt;
  }
  
  private String a(int paramInt1, int paramInt2, ISpan[] paramArrayOfISpan)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getValidSelPosForRichText startCalPos :");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" endCalPos :");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("BiuEditText", 2, ((StringBuilder)localObject).toString());
    }
    ISpan[] arrayOfISpan = a(paramArrayOfISpan);
    Editable localEditable = getEditableText();
    paramArrayOfISpan = new StringBuilder();
    paramArrayOfISpan.append("");
    int i = 0;
    paramArrayOfISpan.append(localEditable.subSequence(paramInt1, localEditable.getSpanStart(arrayOfISpan[0])));
    paramArrayOfISpan = paramArrayOfISpan.toString();
    while (i < arrayOfISpan.length)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramArrayOfISpan);
      ((StringBuilder)localObject).append(localEditable.subSequence(localEditable.getSpanStart(arrayOfISpan[i]), localEditable.getSpanEnd(arrayOfISpan[i])));
      localObject = ((StringBuilder)localObject).toString();
      paramInt1 = localEditable.getSpanEnd(arrayOfISpan[i]);
      paramArrayOfISpan = (ISpan[])localObject;
      if (i < arrayOfISpan.length - 1)
      {
        paramArrayOfISpan = new StringBuilder();
        paramArrayOfISpan.append((String)localObject);
        paramInt1 = localEditable.getSpanEnd(arrayOfISpan[i]);
        int j = i + 1;
        paramArrayOfISpan.append(localEditable.subSequence(paramInt1, localEditable.getSpanStart(arrayOfISpan[j])));
        paramArrayOfISpan = paramArrayOfISpan.toString();
        paramInt1 = localEditable.getSpanStart(arrayOfISpan[j]);
      }
      i += 1;
    }
    Object localObject = paramArrayOfISpan;
    if (paramInt1 < paramInt2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramArrayOfISpan);
      ((StringBuilder)localObject).append(localEditable.subSequence(paramInt1, paramInt2));
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        return false;
      }
      if (getSelectionStart() != getSelectionEnd()) {
        return false;
      }
      bool1 = bool2;
      if (c())
      {
        bool1 = bool2;
        if (!this.b)
        {
          bool1 = bool2;
          if (!this.c) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private ISpan[] a(@NotNull ISpan[] paramArrayOfISpan)
  {
    ISpan[] arrayOfISpan = new ISpan[paramArrayOfISpan.length];
    Editable localEditable = getEditableText();
    paramArrayOfISpan = Arrays.asList(paramArrayOfISpan);
    Collections.sort(paramArrayOfISpan, new BiuEditText.2(this, localEditable));
    return (ISpan[])paramArrayOfISpan.toArray(arrayOfISpan);
  }
  
  private void b()
  {
    setOnKeyListener(new BiuEditText.1(this));
  }
  
  private boolean c()
  {
    Editable localEditable = getEditableText();
    int i = 0;
    if (localEditable == null) {
      return false;
    }
    TopicSpan[] arrayOfTopicSpan = (TopicSpan[])localEditable.getSpans(0, localEditable.length(), TopicSpan.class);
    int j = arrayOfTopicSpan.length;
    boolean bool = false;
    while (i < j)
    {
      TopicSpan localTopicSpan = arrayOfTopicSpan[i];
      if (getSelectionStart() == localEditable.getSpanEnd(localTopicSpan)) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  private void d()
  {
    this.a = new DeleteAsAWholeWatcher();
    addTextChangedListener(this.a);
  }
  
  private boolean e()
  {
    if (getSelectionStart() == getSelectionEnd()) {
      return false;
    }
    Object localObject = getEditableText();
    if (localObject == null) {
      return false;
    }
    localObject = (ISpan[])((Editable)localObject).getSpans(getSelectionStart(), getSelectionEnd(), ISpan.class);
    if (localObject.length == 0) {
      return false;
    }
    ((ClipboardManager)getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a(getSelectionStart(), getSelectionEnd(), (ISpan[])localObject)));
    setSelection(getSelectionEnd());
    return true;
  }
  
  public void a()
  {
    TextWatcher localTextWatcher = this.a;
    if (localTextWatcher != null) {
      removeTextChangedListener(localTextWatcher);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if ("com.sogou.inputmethod.expression".equals(paramString)) {
      return true;
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    setSelection(a(paramInt1), a(paramInt2));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelectionChanged start : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" end : ");
      localStringBuilder.append(paramInt2);
      QLog.d("BiuEditText", 2, localStringBuilder.toString());
    }
    DeleteAsAWholeWatcher.a(this, paramInt1, paramInt2);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if ((paramInt == 16908321) && (e())) {
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.BiuEditText
 * JD-Core Version:    0.7.0.1
 */