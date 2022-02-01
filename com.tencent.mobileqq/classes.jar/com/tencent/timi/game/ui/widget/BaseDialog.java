package com.tencent.timi.game.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BaseDialog
  extends ReportDialog
  implements LifecycleOwner
{
  private final List<DialogListener> a = new CopyOnWriteArrayList();
  private boolean b = false;
  private int c = 0;
  private View d;
  protected Context e;
  private LifecycleRegistry f;
  
  public BaseDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = paramContext;
    this.f = new LifecycleRegistry(this);
  }
  
  private boolean a()
  {
    Context localContext = this.e;
    if ((localContext instanceof Activity))
    {
      boolean bool2 = ((Activity)localContext).isFinishing();
      boolean bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 17)
      {
        if ((!bool2) && (!((Activity)this.e).isDestroyed())) {
          return false;
        }
        bool1 = true;
      }
      return bool1;
    }
    return false;
  }
  
  private void b()
  {
    if ((this.c != 0) && (getWindow() != null))
    {
      if (getWindow().getDecorView().getSystemUiVisibility() != this.c) {
        getWindow().getDecorView().setSystemUiVisibility(this.c);
      }
      View localView = this.d;
      if (localView != null)
      {
        int i = localView.getSystemUiVisibility();
        int j = this.c;
        if (i != j) {
          this.d.setSystemUiVisibility(j);
        }
      }
    }
  }
  
  public void a(DialogListener paramDialogListener)
  {
    this.a.add(paramDialogListener);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DialogListener localDialogListener = (DialogListener)((Iterator)localObject).next();
        if (localDialogListener != null) {
          localDialogListener.c(this);
        }
      }
    }
  }
  
  public void dismiss()
  {
    if (a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getContext());
      ((StringBuilder)localObject).append(" is finishing, can't dismiss");
      Logger.c("BaseDialog", ((StringBuilder)localObject).toString());
      return;
    }
    if (isShowing())
    {
      super.dismiss();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getContext());
      ((StringBuilder)localObject).append(" not showing, can't dismiss");
      Logger.c("BaseDialog", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DialogListener localDialogListener = (DialogListener)((Iterator)localObject).next();
        if (localDialogListener != null) {
          localDialogListener.b(this);
        }
      }
    }
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.f;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.f.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      b();
    }
  }
  
  public void setContentView(@NonNull View paramView)
  {
    this.d = paramView;
    super.setContentView(paramView);
  }
  
  public void show()
  {
    if (a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getContext());
      ((StringBuilder)localObject).append("show() is destroyed, can't show");
      Logger.c("BaseDialog", ((StringBuilder)localObject).toString());
      return;
    }
    if ((this.c != 0) && (getWindow() != null)) {
      getWindow().setFlags(8, 8);
    }
    super.show();
    if ((this.c != 0) && (getWindow() != null))
    {
      b();
      getWindow().clearFlags(8);
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DialogListener localDialogListener = (DialogListener)((Iterator)localObject).next();
        if (localDialogListener != null) {
          localDialogListener.a(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseDialog
 * JD-Core Version:    0.7.0.1
 */