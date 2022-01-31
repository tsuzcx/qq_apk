package com.tencent.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import bhun;

public class ListenCutCopyPasteEditText
  extends EditText
{
  protected bhun a;
  
  public ListenCutCopyPasteEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenCutCopyPasteEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ListenCutCopyPasteEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected CharSequence a()
  {
    Object localObject1 = (ClipboardManager)getContext().getSystemService("clipboard");
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= ((ClipData)localObject1).getItemCount()) {
          break label87;
        }
        CharSequence localCharSequence = ((ClipData)localObject1).getItemAt(i).coerceToText(getContext());
        Object localObject2 = localCharSequence;
        if ((localCharSequence instanceof Spanned)) {
          localObject2 = localCharSequence.toString();
        }
        if (localObject2 != null)
        {
          return localObject2;
          localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
          break;
        }
        i += 1;
      }
    }
    label87:
    return null;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    case 16908320: 
    case 16908321: 
      bool = super.onTextContextMenuItem(paramInt);
      switch (paramInt)
      {
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          localObject1 = a();
          break;
          localObject1 = a();
        } while (this.a == null);
        this.a.a(this, (CharSequence)localObject1);
        return bool;
        localObject1 = a();
      } while (this.a == null);
      this.a.b(this, (CharSequence)localObject1);
      return bool;
    } while (this.a == null);
    this.a.c(this, (CharSequence)localObject1);
    return bool;
  }
  
  public void setCutCopyPasteCallback(bhun parambhun)
  {
    this.a = parambhun;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.ListenCutCopyPasteEditText
 * JD-Core Version:    0.7.0.1
 */