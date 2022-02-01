package com.tencent.viola.ui.view;

import android.content.Context;
import android.view.View;
import com.tencent.viola.ui.component.VAudio;
import java.lang.ref.WeakReference;

public class VAudioView
  extends View
  implements IVView<VAudio>
{
  private WeakReference<VAudio> mWeakReference;
  
  public VAudioView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindComponent(VAudio paramVAudio)
  {
    this.mWeakReference = new WeakReference(paramVAudio);
  }
  
  public VAudio getComponent()
  {
    if (this.mWeakReference != null) {
      return (VAudio)this.mWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VAudioView
 * JD-Core Version:    0.7.0.1
 */