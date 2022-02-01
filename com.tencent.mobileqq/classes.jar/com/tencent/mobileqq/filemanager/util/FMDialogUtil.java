package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class FMDialogUtil
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = QBaseActivity.sTopActivity;
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
      localObject = QBaseActivity.sTopActivity;
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
    FMDialogUtil.1 local1 = new FMDialogUtil.1(paramFMDialogInterface);
    paramFMDialogInterface = new FMDialogUtil.2(paramFMDialogInterface);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMDialogUtil.3(paramContext, paramCharSequence, paramString, local1, paramFMDialogInterface));
      return;
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return;
    }
    if ((paramCharSequence instanceof String))
    {
      DialogUtil.a(paramContext, 230, paramString, (String)paramCharSequence, 2131889250, 2131889254, local1, paramFMDialogInterface).show();
      return;
    }
    if ((paramCharSequence instanceof SpannableString)) {
      DialogUtil.a(paramContext, 230, paramString, paramCharSequence, 2131889250, 2131889254, local1, paramFMDialogInterface).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil
 * JD-Core Version:    0.7.0.1
 */