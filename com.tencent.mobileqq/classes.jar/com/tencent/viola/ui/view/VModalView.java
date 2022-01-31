package com.tencent.viola.ui.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.tencent.viola.ui.component.VModal;
import java.lang.ref.WeakReference;

public class VModalView
  extends FrameLayout
  implements IVView<VModal>
{
  private WeakReference<VModal> mWeakReference;
  
  public VModalView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindComponent(VModal paramVModal)
  {
    this.mWeakReference = new WeakReference(paramVModal);
  }
  
  @Nullable
  public VModal getComponent()
  {
    if (this.mWeakReference != null) {
      return (VModal)this.mWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.VModalView
 * JD-Core Version:    0.7.0.1
 */