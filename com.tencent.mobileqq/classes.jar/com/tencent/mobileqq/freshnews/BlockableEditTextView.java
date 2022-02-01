package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.widget.EditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public class BlockableEditTextView
  extends EditText
{
  int a = -1;
  int b = -1;
  private int c = 0;
  private boolean d = false;
  
  public BlockableEditTextView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private boolean a()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (getEditableText() == null) {
      return false;
    }
    BlockableEditTextView.BlockAble[] arrayOfBlockAble = (BlockableEditTextView.BlockAble[])getEditableText().getSpans(i, j, BlockableEditTextView.BlockAble.class);
    if ((arrayOfBlockAble != null) && (arrayOfBlockAble.length > 0) && ((arrayOfBlockAble[0] instanceof BlockableEditTextView.BlockAble)))
    {
      i = getEditableText().getSpanEnd(arrayOfBlockAble[0]);
      j = getEditableText().getSpanStart(arrayOfBlockAble[0]);
      if ((j >= 0) && (i > j)) {
        return false;
      }
    }
    return true;
  }
  
  private void b()
  {
    setEditableFactory(TroopBarPublishUtils.c);
    if (Build.VERSION.SDK_INT >= 11) {
      setCustomSelectionActionModeCallback(new BlockableEditTextView.1(this));
    }
    addTextChangedListener(new BlockableEditTextView.2(this));
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
    if (getEditableText() == null) {
      return;
    }
    BlockableEditTextView.BlockAble[] arrayOfBlockAble = (BlockableEditTextView.BlockAble[])getEditableText().getSpans(paramInt1, paramInt2, BlockableEditTextView.BlockAble.class);
    if ((arrayOfBlockAble != null) && (arrayOfBlockAble.length > 0))
    {
      int i = getEditableText().getSpanEnd(arrayOfBlockAble[0]);
      int j = getEditableText().getSpanStart(arrayOfBlockAble[0]);
      if ((i > j) && (j >= 0))
      {
        if ((paramInt1 == j) && (paramInt2 == j) && (this.d))
        {
          setSelection(i);
          return;
        }
        if ((this.c > 0) && ((paramInt1 < i) || (paramInt2 < i)) && ((paramInt1 > j) || (paramInt2 > j)))
        {
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
          if ((paramInt1 <= j) && (paramInt2 >= i)) {
            setSelection(paramInt1, j);
          }
        }
      }
    }
  }
  
  public void setBlockFront(boolean paramBoolean)
  {
    this.d = paramBoolean;
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