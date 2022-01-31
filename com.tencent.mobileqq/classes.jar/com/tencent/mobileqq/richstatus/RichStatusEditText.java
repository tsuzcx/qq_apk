package com.tencent.mobileqq.richstatus;

import ahpn;
import ahpo;
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
import com.tencent.mobileqq.widget.ClickableImageSpan;
import mqq.os.MqqHandler;

public class RichStatusEditText
  extends EditText
{
  private static float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ahpn(this);
  private RichStatusEditText.RichStatusEditListener jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener;
  private ClickableImageSpan jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan;
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
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener != null)
        {
          paramInt = i;
          if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener.a(localClickableImageSpan)) {
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
    int i = 0;
    ClickableImageSpan[] arrayOfClickableImageSpan = (ClickableImageSpan[])a().getSpans(0, getText().length(), ClickableImageSpan.class);
    while (i < arrayOfClickableImageSpan.length)
    {
      ClickableImageSpan localClickableImageSpan = arrayOfClickableImageSpan[i];
      int j = a().getSpanStart(localClickableImageSpan);
      int k = a().getSpanEnd(localClickableImageSpan);
      if ((paramInt > j) && (paramInt < k)) {
        return localClickableImageSpan;
      }
      if ((paramBoolean1) && (paramInt == j)) {
        return localClickableImageSpan;
      }
      if ((paramBoolean2) && (paramInt == k)) {
        return localClickableImageSpan;
      }
      i += 1;
    }
    return null;
  }
  
  private ClickableImageSpan a(ClickableImageSpan paramClickableImageSpan)
  {
    if (paramClickableImageSpan != null) {
      paramClickableImageSpan.b(this);
    }
    return paramClickableImageSpan;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ClickableImageSpan[] arrayOfClickableImageSpan = (ClickableImageSpan[])a().getSpans(paramInt1, paramInt1 + paramInt2, ClickableImageSpan.class);
    paramInt1 = 0;
    while (paramInt1 < arrayOfClickableImageSpan.length)
    {
      ClickableImageSpan localClickableImageSpan = arrayOfClickableImageSpan[paramInt1];
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener.a(localClickableImageSpan);
      }
      if (localClickableImageSpan == this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = null;
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
    if (localClickableImageSpan1 != null)
    {
      j = a().getSpanEnd(localClickableImageSpan1);
      if (paramInt != j) {
        return paramInt;
      }
      if ((j != getText().length()) && (localClickableImageSpan2 == null)) {
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
      if (localClickableImageSpan2 == null) {
        break;
      }
      i = a().getSpanStart(localClickableImageSpan2);
      if (paramInt != i) {
        break;
      }
      if ((i == 0) || (localClickableImageSpan1 != null))
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
  
  public ahpo a(int paramInt)
  {
    int k = getText().length();
    if ((paramInt < 0) || (paramInt > k)) {
      return new ahpo(k, k);
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
        return new ahpo(i, k);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(ClickableImageSpan paramClickableImageSpan1, ClickableImageSpan paramClickableImageSpan2)
  {
    if (paramClickableImageSpan1 == this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = paramClickableImageSpan2;
    }
    int i = a().getSpanStart(paramClickableImageSpan1);
    int j = a().getSpanEnd(paramClickableImageSpan1);
    if ((i == -1) || (j == -1)) {
      return;
    }
    a(paramClickableImageSpan1, false, false);
    setSpan(paramClickableImageSpan2, i, j);
  }
  
  public void a(ClickableImageSpan paramClickableImageSpan, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener != null) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener.a(paramClickableImageSpan);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan == paramClickableImageSpan) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = null;
    }
    if (!paramBoolean1) {
      a().removeSpan(paramClickableImageSpan);
    }
    int i;
    int j;
    do
    {
      return;
      i = a().getSpanStart(paramClickableImageSpan);
      j = a().getSpanEnd(paramClickableImageSpan);
      a().removeSpan(paramClickableImageSpan);
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null)
      {
        paramInt = a().getSpanStart(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan);
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan, true, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = null;
        setSelection(paramInt);
        setCursorVisible(true);
      }
      ClickableImageSpan localClickableImageSpan;
      do
      {
        return true;
        if (getSelectionStart() != getSelectionEnd())
        {
          a(getSelectionStart(), getSelectionEnd() - getSelectionStart());
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
        localClickableImageSpan = a(getSelectionStart(), false, true);
        if (localClickableImageSpan == null) {
          break;
        }
      } while (!localClickableImageSpan.a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = a(localClickableImageSpan);
      setCursorVisible(false);
      return true;
    }
    if ((paramInt == 21) && (paramKeyEvent.getAction() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null)
      {
        setCursorVisible(true);
        paramInt = a().getSpanStart(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan);
        setSelection(paramInt, paramInt);
        a();
        return true;
      }
    }
    else if ((paramInt == 22) && (paramKeyEvent.getAction() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null))
    {
      setCursorVisible(true);
      paramInt = a().getSpanEnd(this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan);
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
    if ((paramInt1 != paramInt2) && (((ClickableImageSpan[])a().getSpans(Math.min(paramInt1, paramInt2), Math.max(paramInt1, paramInt2), ClickableImageSpan.class)).length != 0))
    {
      if ((paramInt1 != 0) || (paramInt2 != getText().length())) {
        break label207;
      }
      localObject = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = ((ahpo)localObject).jdField_a_of_type_Int;
      this.b = ((ahpo)localObject).b;
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
        if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText$RichStatusEditListener.a((ClickableImageSpan)localObject)))
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
        a();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = ((ClickableImageSpan)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
        setCursorVisible(false);
      }
    }
    for (;;)
    {
      if ((localObject == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null)) {
        paramMotionEvent.setAction(3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null)
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan.a(this, paramMotionEvent);
        if ((k == 1) || (k == 3)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan = null;
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableImageSpan != null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatusEditText
 * JD-Core Version:    0.7.0.1
 */