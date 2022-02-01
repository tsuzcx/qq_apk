package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class SingleViewPresentation$PresentationContext
  extends ContextWrapper
{
  private final Context flutterAppWindowContext;
  @Nullable
  private WindowManager windowManager;
  @NonNull
  private final SingleViewPresentation.WindowManagerHandler windowManagerHandler;
  
  SingleViewPresentation$PresentationContext(Context paramContext1, @NonNull SingleViewPresentation.WindowManagerHandler paramWindowManagerHandler, Context paramContext2)
  {
    super(paramContext1);
    this.windowManagerHandler = paramWindowManagerHandler;
    this.flutterAppWindowContext = paramContext2;
  }
  
  private WindowManager getWindowManager()
  {
    if (this.windowManager == null) {
      this.windowManager = this.windowManagerHandler.getWindowManager();
    }
    return this.windowManager;
  }
  
  private boolean isCalledFromAlertDialog()
  {
    boolean bool2 = false;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < arrayOfStackTraceElement.length)
      {
        bool1 = bool2;
        if (i < 11)
        {
          if ((!arrayOfStackTraceElement[i].getClassName().equals(AlertDialog.class.getCanonicalName())) || (!arrayOfStackTraceElement[i].getMethodName().equals("<init>"))) {
            break label66;
          }
          bool1 = true;
        }
      }
      return bool1;
      label66:
      i += 1;
    }
  }
  
  public Object getSystemService(String paramString)
  {
    if ("window".equals(paramString))
    {
      if (isCalledFromAlertDialog()) {
        return this.flutterAppWindowContext.getSystemService(paramString);
      }
      return getWindowManager();
    }
    return super.getSystemService(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.PresentationContext
 * JD-Core Version:    0.7.0.1
 */