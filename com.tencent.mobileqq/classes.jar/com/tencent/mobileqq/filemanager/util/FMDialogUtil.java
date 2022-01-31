package com.tencent.mobileqq.filemanager.util;

import adgs;
import adgt;
import adgu;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class FMDialogUtil
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, ((Context)localObject).getString(paramInt1), ((Context)localObject).getString(paramInt2), paramFMDialogInterface);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, paramString, ((Context)localObject).getString(paramInt), paramFMDialogInterface);
  }
  
  public static void a(Context paramContext, String paramString, CharSequence paramCharSequence, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    adgs localadgs = new adgs(paramFMDialogInterface);
    paramFMDialogInterface = new adgt(paramFMDialogInterface);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new adgu(paramCharSequence, paramContext, paramString, localadgs, paramFMDialogInterface));
    }
    do
    {
      return;
      if ((paramCharSequence instanceof String))
      {
        DialogUtil.b(paramContext, 230, paramString, (String)paramCharSequence, 2131428127, 2131428128, localadgs, paramFMDialogInterface).show();
        return;
      }
    } while (!(paramCharSequence instanceof SpannableString));
    DialogUtil.a(paramContext, 230, paramString, paramCharSequence, 2131428127, 2131428128, localadgs, paramFMDialogInterface).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil
 * JD-Core Version:    0.7.0.1
 */