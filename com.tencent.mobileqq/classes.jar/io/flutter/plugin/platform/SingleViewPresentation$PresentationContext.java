package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class SingleViewPresentation$PresentationContext
  extends ContextWrapper
{
  @Nullable
  private WindowManager windowManager;
  @NonNull
  private final SingleViewPresentation.WindowManagerHandler windowManagerHandler;
  
  SingleViewPresentation$PresentationContext(Context paramContext, @NonNull SingleViewPresentation.WindowManagerHandler paramWindowManagerHandler)
  {
    super(paramContext);
    this.windowManagerHandler = paramWindowManagerHandler;
  }
  
  private WindowManager getWindowManager()
  {
    if (this.windowManager == null) {
      this.windowManager = this.windowManagerHandler.getWindowManager();
    }
    return this.windowManager;
  }
  
  public Object getSystemService(String paramString)
  {
    if ("window".equals(paramString)) {
      return getWindowManager();
    }
    return super.getSystemService(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.PresentationContext
 * JD-Core Version:    0.7.0.1
 */