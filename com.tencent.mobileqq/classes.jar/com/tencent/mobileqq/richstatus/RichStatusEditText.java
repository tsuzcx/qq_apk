package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.EditText;
import axxp;
import axxq;
import axxr;
import bejo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class RichStatusEditText
  extends EditText
{
  private static float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new axxp(this);
  private axxr jdField_a_of_type_Axxr;
  private bejo jdField_a_of_type_Bejo;
  public boolean a;
  int b = -1;
  
  public RichStatusEditText(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  public RichStatusEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  public RichStatusEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  private float a(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    return Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat) + getScrollX();
  }
  
  private int a(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  private int a(int paramInt, float paramFloat)
  {
    paramFloat = a(paramFloat);
    return getLayout().getOffsetForHorizontal(paramInt, paramFloat);
  }
  
  private int a(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = b(paramInt, paramFloat1, paramFloat2);
    paramInt = i;
    if (i == 0)
    {
      bejo localbejo = a(i, true, false);
      paramInt = i;
      if (localbejo != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_Axxr != null)
        {
          paramInt = i;
          if (!this.jdField_a_of_type_Axxr.a(localbejo)) {
            paramInt = i + 1;
          }
        }
      }
    }
    return paramInt;
  }
  
  private Spannable a()
  {
    return getText();
  }
  
  private bejo a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    bejo[] arrayOfbejo = (bejo[])a().getSpans(0, getText().length(), bejo.class);
    while (i < arrayOfbejo.length)
    {
      bejo localbejo = arrayOfbejo[i];
      int j = a().getSpanStart(localbejo);
      int k = a().getSpanEnd(localbejo);
      if ((paramInt > j) && (paramInt < k)) {
        return localbejo;
      }
      if ((paramBoolean1) && (paramInt == j)) {
        return localbejo;
      }
      if ((paramBoolean2) && (paramInt == k)) {
        return localbejo;
      }
      i += 1;
    }
    return null;
  }
  
  private bejo a(bejo parambejo)
  {
    if (parambejo != null) {
      parambejo.b(this);
    }
    return parambejo;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bejo != null)
    {
      this.jdField_a_of_type_Bejo.a(this);
      this.jdField_a_of_type_Bejo = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    bejo[] arrayOfbejo = (bejo[])a().getSpans(paramInt1, paramInt1 + paramInt2, bejo.class);
    paramInt1 = 0;
    while (paramInt1 < arrayOfbejo.length)
    {
      bejo localbejo = arrayOfbejo[paramInt1];
      if (this.jdField_a_of_type_Axxr != null) {
        this.jdField_a_of_type_Axxr.a(localbejo);
      }
      if (localbejo == this.jdField_a_of_type_Bejo) {
        this.jdField_a_of_type_Bejo = null;
      }
      a().removeSpan(localbejo);
      paramInt1 += 1;
    }
  }
  
  private int b(int paramInt, float paramFloat1, float paramFloat2)
  {
    bejo localbejo1 = a(paramInt, false, true);
    bejo localbejo2 = a(paramInt, true, false);
    int j;
    if (localbejo1 != null)
    {
      j = a().getSpanEnd(localbejo1);
      if (paramInt != j) {
        return paramInt;
      }
      if ((j != getText().length()) && (localbejo2 == null)) {
        break label276;
      }
      this.jdField_a_of_type_Boolean = false;
      getText().insert(j, " ");
    }
    label276:
    for (int i = 1;; i = 0)
    {
      int k = getOffsetForPosition(getTextSize() * jdField_a_of_type_Float + paramFloat1, paramFloat2);
      if (i != 0)
      {
        getText().replace(j, j + 1, "");
        this.jdField_a_of_type_Boolean = true;
      }
      if (k == j) {
        return k - 1;
      }
      if (localbejo2 == null) {
        break;
      }
      i = a().getSpanStart(localbejo2);
      if (paramInt != i) {
        break;
      }
      if ((i == 0) || (localbejo1 != null))
      {
        this.jdField_a_of_type_Boolean = false;
        getText().insert(i, " ");
        j = getOffsetForPosition(paramFloat1 - getTextSize() * jdField_a_of_type_Float, paramFloat2);
        getText().replace(i, i + 1, "");
        this.jdField_a_of_type_Boolean = true;
        if (j - 1 != i) {
          break;
        }
        return j;
      }
      j = getOffsetForPosition(paramFloat1 - getTextSize() * jdField_a_of_type_Float, paramFloat2);
      if (j != i) {
        break;
      }
      return j + 1;
    }
  }
  
  public axxq a(int paramInt)
  {
    int k = getText().length();
    if ((paramInt < 0) || (paramInt > k)) {
      return new axxq(k, k);
    }
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])a().getSpans(0, k, ImageSpan.class);
    int i1 = arrayOfImageSpan.length;
    int j = 0;
    int i = 0;
    int m;
    if (j < i1)
    {
      ImageSpan localImageSpan = arrayOfImageSpan[j];
      m = a().getSpanStart(localImageSpan);
      int n = a().getSpanEnd(localImageSpan);
      if ((n <= paramInt) && (n > i)) {
        i = n;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ((m >= paramInt) && (m < k))
      {
        k = m;
        continue;
        return new axxq(i, k);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(bejo parambejo1, bejo parambejo2)
  {
    if (parambejo1 == this.jdField_a_of_type_Bejo) {
      this.jdField_a_of_type_Bejo = parambejo2;
    }
    int i = a().getSpanStart(parambejo1);
    int j = a().getSpanEnd(parambejo1);
    if ((i == -1) || (j == -1)) {
      return;
    }
    a(parambejo1, false, false);
    setSpan(parambejo2, i, j);
  }
  
  public void a(bejo parambejo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Axxr != null) && (paramBoolean2)) {
      this.jdField_a_of_type_Axxr.a(parambejo);
    }
    if (this.jdField_a_of_type_Bejo == parambejo) {
      this.jdField_a_of_type_Bejo = null;
    }
    if (!paramBoolean1) {
      a().removeSpan(parambejo);
    }
    int i;
    int j;
    do
    {
      return;
      i = a().getSpanStart(parambejo);
      j = a().getSpanEnd(parambejo);
      a().removeSpan(parambejo);
    } while (i == -1);
    getText().replace(i, j, "", 0, 0);
  }
  
  public int getOffsetForPosition(float paramFloat1, float paramFloat2)
  {
    if (getLayout() == null) {
      return -1;
    }
    return a(a(paramFloat2), paramFloat1);
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    super.onCreateContextMenu(paramContextMenu);
    paramContextMenu.removeItem(16908319);
    if (getSelectionEnd() == getSelectionStart())
    {
      paramContextMenu.removeItem(16908321);
      paramContextMenu.removeItem(16908320);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (this.jdField_a_of_type_Bejo != null)
      {
        paramInt = a().getSpanStart(this.jdField_a_of_type_Bejo);
        a(this.jdField_a_of_type_Bejo, true, true);
        this.jdField_a_of_type_Bejo = null;
        setSelection(paramInt);
        setCursorVisible(true);
      }
      bejo localbejo;
      do
      {
        return true;
        if (getSelectionStart() != getSelectionEnd())
        {
          a(getSelectionStart(), getSelectionEnd() - getSelectionStart());
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
        localbejo = a(getSelectionStart(), false, true);
        if (localbejo == null) {
          break;
        }
      } while (!localbejo.a());
      this.jdField_a_of_type_Bejo = a(localbejo);
      setCursorVisible(false);
      return true;
    }
    if ((paramInt == 21) && (paramKeyEvent.getAction() == 0))
    {
      if (this.jdField_a_of_type_Bejo != null)
      {
        setCursorVisible(true);
        paramInt = a().getSpanStart(this.jdField_a_of_type_Bejo);
        setSelection(paramInt, paramInt);
        a();
        return true;
      }
    }
    else if ((paramInt == 22) && (paramKeyEvent.getAction() == 0) && (this.jdField_a_of_type_Bejo != null))
    {
      setCursorVisible(true);
      paramInt = a().getSpanEnd(this.jdField_a_of_type_Bejo);
      setSelection(paramInt, paramInt);
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.jdField_a_of_type_Boolean = false;
    Editable localEditable = getText();
    super.onRestoreInstanceState(paramParcelable);
    setText(localEditable);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    Object localObject;
    int i;
    if ((paramInt1 != paramInt2) && (((bejo[])a().getSpans(Math.min(paramInt1, paramInt2), Math.max(paramInt1, paramInt2), bejo.class)).length != 0))
    {
      if ((paramInt1 != 0) || (paramInt2 != getText().length())) {
        break label207;
      }
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = ((axxq)localObject).jdField_a_of_type_Int;
      this.b = ((axxq)localObject).b;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        if ((this.b == -1) && (this.jdField_a_of_type_Int == -1))
        {
          paramInt1 = getText().length();
          this.b = paramInt1;
          this.jdField_a_of_type_Int = paramInt1;
        }
      }
      try
      {
        setSelection(this.jdField_a_of_type_Int, this.b);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        return;
      }
      if ((paramInt1 == paramInt2) && (paramInt1 == 0))
      {
        localObject = a(0, true, false);
        if ((localObject != null) && (this.jdField_a_of_type_Axxr != null) && (!this.jdField_a_of_type_Axxr.a((bejo)localObject)))
        {
          i = 1;
          continue;
          this.jdField_a_of_type_Int = paramInt1;
          this.b = paramInt2;
          super.onSelectionChanged(paramInt1, paramInt2);
          return;
        }
      }
      i = 0;
      continue;
      label207:
      i = 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int k = paramMotionEvent.getAction();
    if ((!isFocused()) || (getSelectionEnd() != getSelectionStart()) || ((k != 0) && (k != 2) && (k != 3) && (k != 1)))
    {
      if (k == 1)
      {
        localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getHandler(EditActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(4));
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int j = getOffsetForPosition(f1, f2);
    int i = j;
    if (j != -1) {
      i = a(j, f1, f2);
    }
    Object localObject = a(i, false, false);
    if (k == 0)
    {
      if (this.jdField_a_of_type_Bejo != null) {
        a();
      }
      this.jdField_a_of_type_Bejo = ((bejo)localObject);
      if (this.jdField_a_of_type_Bejo != null) {
        setCursorVisible(false);
      }
    }
    for (;;)
    {
      if ((localObject == null) && (this.jdField_a_of_type_Bejo != null)) {
        paramMotionEvent.setAction(3);
      }
      if (this.jdField_a_of_type_Bejo != null)
      {
        bool = this.jdField_a_of_type_Bejo.a(this, paramMotionEvent);
        if ((k == 1) || (k == 3)) {
          this.jdField_a_of_type_Bejo = null;
        }
      }
      if (k == 1)
      {
        localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getHandler(EditActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(4));
        }
      }
      if (!bool) {
        break;
      }
      return true;
      if ((k == 1) || (k == 3)) {
        setCursorVisible(true);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performLongClick()
  {
    if (this.jdField_a_of_type_Bejo != null) {
      return true;
    }
    return super.performLongClick();
  }
  
  public void setEditListener(axxr paramaxxr)
  {
    this.jdField_a_of_type_Axxr = paramaxxr;
  }
  
  public void setSpan(ImageSpan paramImageSpan, int paramInt1, int paramInt2)
  {
    a().setSpan(paramImageSpan, paramInt1, paramInt2, 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatusEditText
 * JD-Core Version:    0.7.0.1
 */