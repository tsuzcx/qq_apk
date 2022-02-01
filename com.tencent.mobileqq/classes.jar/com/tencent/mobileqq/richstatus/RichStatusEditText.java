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
  private static float f = 1.0F;
  public boolean a = true;
  int b = -1;
  int c = -1;
  private ClickableImageSpan d = null;
  private RichStatusEditText.RichStatusEditListener e = null;
  private Context g;
  private TextWatcher h = new RichStatusEditText.1(this);
  
  public RichStatusEditText(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RichStatusEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RichStatusEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f1 = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f1));
  }
  
  private int a(int paramInt, float paramFloat)
  {
    paramFloat = b(paramFloat);
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
        RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.e;
        paramInt = i;
        if (localRichStatusEditListener != null)
        {
          paramInt = i;
          if (!localRichStatusEditListener.b(localClickableImageSpan)) {
            paramInt = i + 1;
          }
        }
      }
    }
    return paramInt;
  }
  
  private ClickableImageSpan a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = getSpannable();
    int j = getText().length();
    int i = 0;
    localObject1 = (ClickableImageSpan[])((Spannable)localObject1).getSpans(0, j, ClickableImageSpan.class);
    while (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      j = getSpannable().getSpanStart(localObject2);
      int k = getSpannable().getSpanEnd(localObject2);
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
    ClickableImageSpan localClickableImageSpan = this.d;
    if (localClickableImageSpan != null)
    {
      localClickableImageSpan.setDisselected(this);
      this.d = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ClickableImageSpan[] arrayOfClickableImageSpan = (ClickableImageSpan[])getSpannable().getSpans(paramInt1, paramInt2 + paramInt1, ClickableImageSpan.class);
    paramInt1 = 0;
    while (paramInt1 < arrayOfClickableImageSpan.length)
    {
      ClickableImageSpan localClickableImageSpan = arrayOfClickableImageSpan[paramInt1];
      RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.e;
      if (localRichStatusEditListener != null) {
        localRichStatusEditListener.a(localClickableImageSpan);
      }
      if (localClickableImageSpan == this.d) {
        this.d = null;
      }
      getSpannable().removeSpan(localClickableImageSpan);
      paramInt1 += 1;
    }
  }
  
  private float b(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    return Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat) + getScrollX();
  }
  
  private int b(int paramInt, float paramFloat1, float paramFloat2)
  {
    ClickableImageSpan localClickableImageSpan1 = a(paramInt, false, true);
    ClickableImageSpan localClickableImageSpan2 = a(paramInt, true, false);
    int j;
    int i;
    if (localClickableImageSpan1 != null)
    {
      j = getSpannable().getSpanEnd(localClickableImageSpan1);
      if (paramInt != j) {
        return paramInt;
      }
      if ((j != getText().length()) && (localClickableImageSpan2 == null))
      {
        i = 0;
      }
      else
      {
        this.a = false;
        getText().insert(j, " ");
        i = 1;
      }
      int k = getOffsetForPosition(getTextSize() * f + paramFloat1, paramFloat2);
      if (i != 0)
      {
        getText().replace(j, j + 1, "");
        this.a = true;
      }
      if (k == j) {
        return k - 1;
      }
    }
    if (localClickableImageSpan2 != null)
    {
      i = getSpannable().getSpanStart(localClickableImageSpan2);
      if (paramInt != i) {
        return paramInt;
      }
      if ((i != 0) && (localClickableImageSpan1 == null))
      {
        j = getOffsetForPosition(paramFloat1 - getTextSize() * f, paramFloat2);
        if (j == i) {
          return j + 1;
        }
      }
      else
      {
        this.a = false;
        getText().insert(i, " ");
        j = getOffsetForPosition(paramFloat1 - getTextSize() * f, paramFloat2);
        getText().replace(i, i + 1, "");
        this.a = true;
        if (j - 1 == i) {
          return j;
        }
      }
    }
    return paramInt;
  }
  
  private Spannable getSpannable()
  {
    return getText();
  }
  
  public RichStatusEditText.IntRange a(int paramInt)
  {
    int j = getText().length();
    if ((paramInt >= 0) && (paramInt <= j))
    {
      Object localObject1 = getSpannable();
      int i = 0;
      localObject1 = (ImageSpan[])((Spannable)localObject1).getSpans(0, j, ImageSpan.class);
      int i2 = localObject1.length;
      int k = 0;
      while (i < i2)
      {
        Object localObject2 = localObject1[i];
        int i1 = getSpannable().getSpanStart(localObject2);
        int m = getSpannable().getSpanEnd(localObject2);
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
    addTextChangedListener(this.h);
    this.g = paramContext;
  }
  
  public void a(ClickableImageSpan paramClickableImageSpan1, ClickableImageSpan paramClickableImageSpan2)
  {
    if (paramClickableImageSpan1 == this.d) {
      this.d = paramClickableImageSpan2;
    }
    int i = getSpannable().getSpanStart(paramClickableImageSpan1);
    int j = getSpannable().getSpanEnd(paramClickableImageSpan1);
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
    RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.e;
    if ((localRichStatusEditListener != null) && (paramBoolean2)) {
      localRichStatusEditListener.a(paramClickableImageSpan);
    }
    if (this.d == paramClickableImageSpan) {
      this.d = null;
    }
    if (!paramBoolean1)
    {
      getSpannable().removeSpan(paramClickableImageSpan);
      return;
    }
    int i = getSpannable().getSpanStart(paramClickableImageSpan);
    int j = getSpannable().getSpanEnd(paramClickableImageSpan);
    getSpannable().removeSpan(paramClickableImageSpan);
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
      if (this.d != null)
      {
        paramInt = getSpannable().getSpanStart(this.d);
        a(this.d, true, true);
        this.d = null;
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
          this.d = a(localClickableImageSpan);
          setCursorVisible(false);
        }
        return true;
      }
    }
    else if ((paramInt == 21) && (paramKeyEvent.getAction() == 0))
    {
      if (this.d != null)
      {
        setCursorVisible(true);
        paramInt = getSpannable().getSpanStart(this.d);
        setSelection(paramInt, paramInt);
        a();
        return true;
      }
    }
    else if ((paramInt == 22) && (paramKeyEvent.getAction() == 0) && (this.d != null))
    {
      setCursorVisible(true);
      paramInt = getSpannable().getSpanEnd(this.d);
      setSelection(paramInt, paramInt);
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.a = false;
    Editable localEditable = getText();
    super.onRestoreInstanceState(paramParcelable);
    setText(localEditable);
    this.a = true;
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i;
    Object localObject;
    if ((paramInt1 != paramInt2) && (((ClickableImageSpan[])getSpannable().getSpans(Math.min(paramInt1, paramInt2), Math.max(paramInt1, paramInt2), ClickableImageSpan.class)).length != 0))
    {
      i = j;
      if (paramInt1 == 0)
      {
        i = j;
        if (paramInt2 == getText().length())
        {
          localObject = a(this.b);
          this.b = ((RichStatusEditText.IntRange)localObject).a;
          this.c = ((RichStatusEditText.IntRange)localObject).b;
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
          RichStatusEditText.RichStatusEditListener localRichStatusEditListener = this.e;
          if ((localRichStatusEditListener != null) && (!localRichStatusEditListener.b((ClickableImageSpan)localObject)))
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
      if ((this.c == -1) && (this.b == -1))
      {
        paramInt1 = getText().length();
        this.c = paramInt1;
        this.b = paramInt1;
      }
    }
    try
    {
      setSelection(this.b, this.c);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    this.b = paramInt1;
    this.c = paramInt2;
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
        if (this.d != null) {
          a();
        }
        this.d = ((ClickableImageSpan)localObject);
        if (this.d != null) {
          setCursorVisible(false);
        }
      }
      else if ((k == 1) || (k == 3))
      {
        setCursorVisible(true);
      }
      if ((localObject == null) && (this.d != null)) {
        paramMotionEvent.setAction(3);
      }
      localObject = this.d;
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
          this.d = null;
          m = bool;
        }
      }
      if (k == 1)
      {
        localObject = ((BaseActivity)this.g).app.getHandler(EditActivity.class);
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
      localObject = ((BaseActivity)this.g).app.getHandler(EditActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(4));
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performLongClick()
  {
    if (this.d != null) {
      return true;
    }
    return super.performLongClick();
  }
  
  public void setEditListener(RichStatusEditText.RichStatusEditListener paramRichStatusEditListener)
  {
    this.e = paramRichStatusEditListener;
  }
  
  public void setSpan(ImageSpan paramImageSpan, int paramInt1, int paramInt2)
  {
    getSpannable().setSpan(paramImageSpan, paramInt1, paramInt2, 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatusEditText
 * JD-Core Version:    0.7.0.1
 */