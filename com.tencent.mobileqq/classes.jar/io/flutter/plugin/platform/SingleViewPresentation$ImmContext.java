package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class SingleViewPresentation$ImmContext
  extends ContextWrapper
{
  @NonNull
  private final InputMethodManager inputMethodManager;
  
  SingleViewPresentation$ImmContext(Context paramContext)
  {
    this(paramContext, null);
  }
  
  private SingleViewPresentation$ImmContext(Context paramContext, @Nullable InputMethodManager paramInputMethodManager)
  {
    super(paramContext);
    if (paramInputMethodManager != null) {}
    for (;;)
    {
      this.inputMethodManager = paramInputMethodManager;
      return;
      paramInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    }
  }
  
  public Context createDisplayContext(Display paramDisplay)
  {
    return new ImmContext(super.createDisplayContext(paramDisplay), this.inputMethodManager);
  }
  
  public Object getSystemService(String paramString)
  {
    if ("input_method".equals(paramString)) {
      return this.inputMethodManager;
    }
    return super.getSystemService(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.ImmContext
 * JD-Core Version:    0.7.0.1
 */