package com.tencent.viola.ui.view;

import android.content.Context;
import android.widget.EditText;
import com.tencent.viola.ui.component.VInput;
import java.lang.ref.WeakReference;

public class VInputView
  extends EditText
  implements IVView<VInput>
{
  private WeakReference<VInput> mWeakReference;
  
  public VInputView(Context paramContext, String paramString)
  {
    super(paramContext);
    if ("input".equals(paramString))
    {
      setMaxLines(1);
      setSingleLine(true);
      return;
    }
    setGravity(48);
  }
  
  public void bindComponent(VInput paramVInput)
  {
    this.mWeakReference = new WeakReference(paramVInput);
  }
  
  public VInput getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VInput)localWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VInputView
 * JD-Core Version:    0.7.0.1
 */