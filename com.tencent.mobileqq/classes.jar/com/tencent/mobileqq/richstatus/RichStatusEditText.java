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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.ClickableImageSpan;
import mqq.os.MqqHandler;

public class RichStatusEditText
  extends EditText
{
  private static float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new RichStatusEditText.1(this);
  private RichStatusEditText.RichStatusEditListener jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener = null;
  private ClickableImageSpan jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = null;
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
      ClickableImageSpan localClickableImageSpan = a(i, true, false);
      paramInt = i;
      if (localClickableImageSpan != null)
      {
        RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener;
        paramInt = i;
        if (localRichStatusEditListener != null)
        {
          paramInt = i;
          if (!localRichStatusEditListener.a(localClickableImageSpan)) {
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
  
  private ClickableImageSpan a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = a();
    int j = getText().length();
    int i = 0;
    localObject1 = (ClickableImageSpan[])((Spannable)localObject1).getSpans(0, j, ClickableImageSpan.class);
    while (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      j = a().getSpanStart(localObject2);
      int k = a().getSpanEnd(localObject2);
      if ((paramInt > j) && (paramInt < k)) {
        return localObject2;
      }
      if ((paramBoolean1) && (paramInt == j)) {
        return localObject2;
      }
      if ((paramBoolean2) && (paramInt == k)) {
        return localObject2;
      }
      i += 1;
    }
    return null;
  }
  
  private ClickableImageSpan a(ClickableImageSpan paramClickableImageSpan)
  {
    if (paramClickableImageSpan != null) {
      paramClickableImageSpan.setSelected(this);
    }
    return paramClickableImageSpan;
  }
  
  private void a()
  {
    ClickableImageSpan localClickableImageSpan = this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan;
    if (localClickableImageSpan != null)
    {
      localClickableImageSpan.setDisselected(this);
      this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ClickableImageSpan[] arrayOfClickableImageSpan = (ClickableImageSpan[])a().getSpans(paramInt1, paramInt2 + paramInt1, ClickableImageSpan.class);
    paramInt1 = 0;
    while (paramInt1 < arrayOfClickableImageSpan.length)
    {
      ClickableImageSpan localClickableImageSpan = arrayOfClickableImageSpan[paramInt1];
      RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener;
      if (localRichStatusEditListener != null) {
        localRichStatusEditListener.a(localClickableImageSpan);
      }
      if (localClickableImageSpan == this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan) {
        this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = null;
      }
      a().removeSpan(localClickableImageSpan);
      paramInt1 += 1;
    }
  }
  
  private int b(int paramInt, float paramFloat1, float paramFloat2)
  {
    ClickableImageSpan localClickableImageSpan1 = a(paramInt, false, true);
    ClickableImageSpan localClickableImageSpan2 = a(paramInt, true, false);
    int j;
    int i;
    if (localClickableImageSpan1 != null)
    {
      j = a().getSpanEnd(localClickableImageSpan1);
      if (paramInt != j) {
        return paramInt;
      }
      if ((j != getText().length()) && (localClickableImageSpan2 == null))
      {
        i = 0;
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        getText().insert(j, " ");
        i = 1;
      }
      int k = getOffsetForPosition(getTextSize() * jdField_a_of_type_Float + paramFloat1, paramFloat2);
      if (i != 0)
      {
        getText().replace(j, j + 1, "");
        this.jdField_a_of_type_Boolean = true;
      }
      if (k == j) {
        return k - 1;
      }
    }
    if (localClickableImageSpan2 != null)
    {
      i = a().getSpanStart(localClickableImageSpan2);
      if (paramInt != i) {
        return paramInt;
      }
      if ((i != 0) && (localClickableImageSpan1 == null))
      {
        j = getOffsetForPosition(paramFloat1 - getTextSize() * jdField_a_of_type_Float, paramFloat2);
        if (j == i) {
          return j + 1;
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        getText().insert(i, " ");
        j = getOffsetForPosition(paramFloat1 - getTextSize() * jdField_a_of_type_Float, paramFloat2);
        getText().replace(i, i + 1, "");
        this.jdField_a_of_type_Boolean = true;
        if (j - 1 == i) {
          return j;
        }
      }
    }
    return paramInt;
  }
  
  public RichStatusEditText.IntRange a(int paramInt)
  {
    int j = getText().length();
    if ((paramInt >= 0) && (paramInt <= j))
    {
      Object localObject1 = a();
      int i = 0;
      localObject1 = (ImageSpan[])((Spannable)localObject1).getSpans(0, j, ImageSpan.class);
      int i2 = localObject1.length;
      int k = 0;
      while (i < i2)
      {
        Object localObject2 = localObject1[i];
        int i1 = a().getSpanStart(localObject2);
        int m = a().getSpanEnd(localObject2);
        int n;
        if ((m <= paramInt) && (m > k))
        {
          n = j;
        }
        else
        {
          m = k;
          n = j;
          if (i1 >= paramInt)
          {
            m = k;
            n = j;
            if (i1 < j)
            {
              n = i1;
              m = k;
            }
          }
        }
        i += 1;
        k = m;
        j = n;
      }
      return new RichStatusEditText.IntRange(k, j);
    }
    return new RichStatusEditText.IntRange(j, j);
  }
  
  public void a(Context paramContext)
  {
    addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(ClickableImageSpan paramClickableImageSpan1, ClickableImageSpan paramClickableImageSpan2)
  {
    if (paramClickableImageSpan1 == this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan) {
      this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = paramClickableImageSpan2;
    }
    int i = a().getSpanStart(paramClickableImageSpan1);
    int j = a().getSpanEnd(paramClickableImageSpan1);
    if (i != -1)
    {
      if (j == -1) {
        return;
      }
      a(paramClickableImageSpan1, false, false);
      setSpan(paramClickableImageSpan2, i, j);
    }
  }
  
  public void a(ClickableImageSpan paramClickableImageSpan, boolean paramBoolean1, boolean paramBoolean2)
  {
    RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener;
    if ((localRichStatusEditListener != null) && (paramBoolean2)) {
      localRichStatusEditListener.a(paramClickableImageSpan);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan == paramClickableImageSpan) {
      this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = null;
    }
    if (!paramBoolean1)
    {
      a().removeSpan(paramClickableImageSpan);
      return;
    }
    int i = a().getSpanStart(paramClickableImageSpan);
    int j = a().getSpanEnd(paramClickableImageSpan);
    a().removeSpan(paramClickableImageSpan);
    if (i != -1) {
      getText().replace(i, j, "", 0, 0);
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan != null)
      {
        paramInt = a().getSpanStart(this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan);
        a(this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan, true, true);
        this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = null;
        setSelection(paramInt);
        setCursorVisible(true);
        return true;
      }
      if (getSelectionStart() != getSelectionEnd())
      {
        a(getSelectionStart(), getSelectionEnd() - getSelectionStart());
        return super.onKeyDown(paramInt, paramKeyEvent);
      }
      ClickableImageSpan localClickableImageSpan = a(getSelectionStart(), false, true);
      if (localClickableImageSpan != null)
      {
        if (localClickableImageSpan.isEnable())
        {
          this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = a(localClickableImageSpan);
          setCursorVisible(false);
        }
        return true;
      }
    }
    else if ((paramInt == 21) && (paramKeyEvent.getAction() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan != null)
      {
        setCursorVisible(true);
        paramInt = a().getSpanStart(this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan);
        setSelection(paramInt, paramInt);
        a();
        return true;
      }
    }
    else if ((paramInt == 22) && (paramKeyEvent.getAction() == 0) && (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan != null))
    {
      setCursorVisible(true);
      paramInt = a().getSpanEnd(this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan);
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
    int j = 1;
    int i;
    Object localObject;
    if ((paramInt1 != paramInt2) && (((ClickableImageSpan[])a().getSpans(Math.min(paramInt1, paramInt2), Math.max(paramInt1, paramInt2), ClickableImageSpan.class)).length != 0))
    {
      i = j;
      if (paramInt1 == 0)
      {
        i = j;
        if (paramInt2 == getText().length())
        {
          localObject = a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Int = ((RichStatusEditText.IntRange)localObject).jdField_a_of_type_Int;
          this.b = ((RichStatusEditText.IntRange)localObject).b;
          i = j;
        }
      }
    }
    else
    {
      if ((paramInt1 == paramInt2) && (paramInt1 == 0))
      {
        localObject = a(0, true, false);
        if (localObject != null)
        {
          RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener;
          if ((localRichStatusEditListener != null) && (!localRichStatusEditListener.a((ClickableImageSpan)localObject)))
          {
            i = j;
            break label147;
          }
        }
      }
      i = 0;
    }
    label147:
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
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    super.onSelectionChanged(paramInt1, paramInt2);
    return;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    Object localObject;
    if ((isFocused()) && (getSelectionEnd() == getSelectionStart()) && ((k == 0) || (k == 2) || (k == 3) || (k == 1)))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int j = getOffsetForPosition(f1, f2);
      int i = j;
      if (j != -1) {
        i = a(j, f1, f2);
      }
      int m = 0;
      localObject = a(i, false, false);
      if (k == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan != null) {
          a();
        }
        this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = ((ClickableImageSpan)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan != null) {
          setCursorVisible(false);
        }
      }
      else if ((k == 1) || (k == 3))
      {
        setCursorVisible(true);
      }
      if ((localObject == null) && (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan != null)) {
        paramMotionEvent.setAction(3);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan;
      if (localObject != null)
      {
        boolean bool = ((ClickableImageSpan)localObject).onTouch(this, paramMotionEvent);
        if (k != 1)
        {
          m = bool;
          if (k != 3) {}
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan = null;
          m = bool;
        }
      }
      if (k == 1)
      {
        localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getHandler(EditActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(4));
        }
      }
      if (m != 0) {
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    if (k == 1)
    {
      localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getHandler(EditActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(4));
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performLongClick()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTextClickableImageSpan != null) {
      return true;
    }
    return super.performLongClick();
  }
  
  public void setEditListener(RichStatusEditText.RichStatusEditListener paramRichStatusEditListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener = paramRichStatusEditListener;
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