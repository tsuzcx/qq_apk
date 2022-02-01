package com.tencent.tkd.comment.publisher.qq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.tkd.comment.publisher.qq.util.selectionchange.ISelectionChangeObservable;
import com.tencent.tkd.comment.publisher.qq.util.selectionchange.ISelectionChangeObserver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TKDListenFocusEditText
  extends EditText
  implements ISelectionChangeObservable
{
  private TKDListenFocusEditText.OnWindowFocusChangeListener a;
  private List<ISelectionChangeObserver> b;
  
  public TKDListenFocusEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public TKDListenFocusEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TKDListenFocusEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(ISelectionChangeObserver paramISelectionChangeObserver)
  {
    if (paramISelectionChangeObserver == null) {
      return;
    }
    if (this.b == null) {
      this.b = new LinkedList();
    }
    if (!this.b.contains(paramISelectionChangeObserver)) {
      this.b.add(paramISelectionChangeObserver);
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ISelectionChangeObserver)((Iterator)localObject).next()).a(this, paramInt1, paramInt2);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    TKDListenFocusEditText.OnWindowFocusChangeListener localOnWindowFocusChangeListener = this.a;
    if (localOnWindowFocusChangeListener != null) {
      localOnWindowFocusChangeListener.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void setWindowFocusChangeListener(TKDListenFocusEditText.OnWindowFocusChangeListener paramOnWindowFocusChangeListener)
  {
    this.a = paramOnWindowFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TKDListenFocusEditText
 * JD-Core Version:    0.7.0.1
 */