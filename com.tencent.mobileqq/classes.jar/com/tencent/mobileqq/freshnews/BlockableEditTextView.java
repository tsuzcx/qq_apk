package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.widget.EditText;
import auyr;
import auys;
import auyt;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public class BlockableEditTextView
  extends EditText
{
  int jdField_a_of_type_Int = -1;
  private boolean jdField_a_of_type_Boolean;
  int b = -1;
  private int c = 0;
  
  public BlockableEditTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setEditableFactory(TroopBarPublishUtils.a);
    if (Build.VERSION.SDK_INT >= 11) {
      setCustomSelectionActionModeCallback(new auyr(this));
    }
    addTextChangedListener(new auys(this));
  }
  
  private boolean a()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (getEditableText() == null) {
      return false;
    }
    auyt[] arrayOfauyt = (auyt[])getEditableText().getSpans(i, j, auyt.class);
    if ((arrayOfauyt != null) && (arrayOfauyt.length > 0) && ((arrayOfauyt[0] instanceof auyt)))
    {
      i = getEditableText().getSpanEnd(arrayOfauyt[0]);
      j = getEditableText().getSpanStart(arrayOfauyt[0]);
      if ((j >= 0) && (i > j)) {
        return false;
      }
    }
    return true;
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    if ((a()) || (Build.VERSION.SDK_INT >= 11)) {
      super.onCreateContextMenu(paramContextMenu);
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (getEditableText() == null) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          auyt[] arrayOfauyt;
          do
          {
            return;
            arrayOfauyt = (auyt[])getEditableText().getSpans(paramInt1, paramInt2, auyt.class);
          } while ((arrayOfauyt == null) || (arrayOfauyt.length <= 0));
          i = getEditableText().getSpanEnd(arrayOfauyt[0]);
          j = getEditableText().getSpanStart(arrayOfauyt[0]);
        } while ((i <= j) || (j < 0));
        if ((paramInt1 == j) && (paramInt2 == j) && (this.jdField_a_of_type_Boolean))
        {
          setSelection(i);
          return;
        }
      } while ((this.c <= 0) || ((paramInt1 >= i) && (paramInt2 >= i)) || ((paramInt1 <= j) && (paramInt2 <= j)));
      if ((paramInt1 <= j) && (paramInt2 <= i))
      {
        setSelection(paramInt1, j);
        return;
      }
      if ((paramInt1 >= j) && (paramInt2 <= i))
      {
        setSelection(j);
        return;
      }
      if ((paramInt1 >= j) && (paramInt2 >= i))
      {
        setSelection(i, paramInt2);
        return;
      }
    } while ((paramInt1 > j) || (paramInt2 < i));
    setSelection(paramInt1, j);
  }
  
  public void setBlockFront(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setEditStatus(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.BlockableEditTextView
 * JD-Core Version:    0.7.0.1
 */