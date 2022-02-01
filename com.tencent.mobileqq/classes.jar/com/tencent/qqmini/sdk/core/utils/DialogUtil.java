package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.core.widget.AppCloseDialog;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

public class DialogUtil
{
  public static final int ALERT_DIALOG = 230;
  
  public static AppCloseDialog createAppCloseDialog(Context paramContext)
  {
    paramContext = new AppCloseDialog(paramContext, R.style.mini_sdk_MiniAppInputDialog);
    if (paramContext.getWindow() != null)
    {
      Window localWindow = paramContext.getWindow();
      localWindow.setBackgroundDrawable(new ColorDrawable(0));
      WindowManager.LayoutParams localLayoutParams = paramContext.getWindow().getAttributes();
      localWindow.setGravity(17);
      paramContext.getWindow().setAttributes(localLayoutParams);
    }
    paramContext.setContentView(R.layout.mini_sdk_app_close_dialog);
    paramContext.setTitle(null);
    paramContext.setNegativeButton(null, null);
    paramContext.setPositiveButton(null, null);
    paramContext.setBodyLayoutNoMargin();
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static MiniCustomDialog createCustomDialog(Context paramContext, int paramInt)
  {
    return createCustomDialog(paramContext, paramInt, null, null, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, null, null);
  }
  
  public static MiniCustomDialog createCustomDialog(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new MiniCustomDialog(paramContext, R.style.mini_sdk_MiniAppInputDialog);
    paramContext.setContentView(R.layout.mini_sdk_custom_dialog_temp);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static MiniCustomDialog createCustomDialog(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new MiniCustomDialog(paramContext, R.style.mini_sdk_MiniAppInputDialog);
    paramContext.setContentView(R.layout.mini_sdk_custom_dialog_temp);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static MiniCustomDialog createCustomDialog(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return createCustomDialog(paramContext, paramInt, paramString1, paramString2, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, paramOnClickListener1, paramOnClickListener2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.DialogUtil
 * JD-Core Version:    0.7.0.1
 */