package com.tencent.mobileqq.flashshow.widgets.comment.dialog;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public class SafeDialog
  extends BaseDialog
{
  protected WeakReference<Context> n;
  
  public SafeDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.n = new WeakReference(paramContext);
  }
  
  public boolean m()
  {
    Context localContext = (Context)this.n.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  public long n()
  {
    WeakReference localWeakReference = this.n;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((Context)this.n.get()).hashCode();
    }
    return 0L;
  }
  
  public void show()
  {
    if (m()) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.dialog.SafeDialog
 * JD-Core Version:    0.7.0.1
 */