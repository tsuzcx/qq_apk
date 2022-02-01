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
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    while ((i < arrayOfStackTraceElement.length) && (i < 11))
    {
      if ((arrayOfStackTraceElement[i].getClassName().equals(AlertDialog.class.getCanonicalName())) && (arrayOfStackTraceElement[i].getMethodName().equals("<init>"))) {
        return true;
      }
      i += 1;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.PresentationContext
 * JD-Core Version:    0.7.0.1
 */