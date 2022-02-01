package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog;
import java.util.ArrayList;

public class DialogUtils
{
  public static NewUpgradeDialog a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new NewUpgradeDialog(paramActivity);
    paramActivity.a(new QQText(a(paramString1), 3)).b(new QQText(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static QQCustomArkDialog a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131953338);
    localQQCustomArkDialog.a(paramContext, paramBundle);
    localQQCustomArkDialog.setTitle(paramString);
    localQQCustomArkDialog.setCanceledOnTouchOutside(false);
    localQQCustomArkDialog.setCancelable(true);
    return localQQCustomArkDialog;
  }
  
  public static QQCustomArkDialog a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131953338);
    localQQCustomArkDialog.a(paramContext, paramBundle);
    localQQCustomArkDialog.setTitle(paramString);
    localQQCustomArkDialog.setCanceledOnTouchOutside(false);
    localQQCustomArkDialog.setCancelable(true);
    if (paramInt > 0) {
      localQQCustomArkDialog.c(paramInt);
    }
    return localQQCustomArkDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramActivity, 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131624487, null);
    paramString1 = (TextView)paramActivity.findViewById(2131448996);
    String str = NewUpgradeDialog.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131901400));
      localStringBuilder.append(str);
      paramString1.setText(localStringBuilder.toString());
    }
    ((TextView)paramActivity.findViewById(2131431876)).setText(paramString2);
    localQQCustomDialog.addView(paramActivity);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131901376), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131901423), paramOnClickListener2);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624598);
    paramContext.setTitleWithEmo(new QQText(a(paramString1), 3));
    paramContext.setMessage(new QQText(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131953338);
    paramContext.setContentView(2131624623);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.d(paramString3);
    paramContext.setNegativeButton(2131887648, paramOnClickListener2);
    paramContext.setPositiveButton(2131887750, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131953338);
    paramContext.b(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131624623);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.c(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.d(paramString3);
    paramContext.setNegativeButton(2131887648, paramOnClickListener2);
    paramContext.setPositiveButton(2131887750, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131953338);
    paramContext.setContentView(2131624626);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131887648, paramOnClickListener2);
    paramContext.setPositiveButton(2131892267, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131953338);
    paramContext.setContentView(2131624626);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131887648, paramOnClickListener2);
    paramContext.setPositiveButton(2131892267, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInputAndChoose a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihInputAndChoose(paramContext, 2131953338);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131624628);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.a(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setMessageCount(paramString3);
    paramContext.a(paramArrayList);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString4);
    paramContext.setNegativeButton(2131887648, paramOnClickListener2);
    paramContext.setPositiveButton(2131887750, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomSingleButtonDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomSingleButtonDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624613);
    paramContext.a(paramString1.replace(HardCodeUtil.a(2131901429), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.a(2131901375), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.a(2131901413), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.a(2131901431), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(HardCodeUtil.a(2131901412), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.a(2131901402), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.a(2131901419), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.a(2131901426), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839787, 2131887648, paramOnClickListener2);
    paramContext.a(paramString3.replace(HardCodeUtil.a(2131901380), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.a(2131901430), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.a(2131901433), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.a(2131901377), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(HardCodeUtil.a(2131901436), QQSysFaceUtil.getFaceString(21)).replace(HardCodeUtil.a(2131901397), QQSysFaceUtil.getFaceString(18)).replace(HardCodeUtil.a(2131901378), QQSysFaceUtil.getFaceString(86)).replace(HardCodeUtil.a(2131901407), QQSysFaceUtil.getFaceString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static QQCustomArkDialogForAio b(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQCustomArkDialogForAio localQQCustomArkDialogForAio = new QQCustomArkDialogForAio(paramContext, 2131953338);
    localQQCustomArkDialogForAio.a(paramContext, paramBundle);
    localQQCustomArkDialogForAio.setTitle(paramString);
    localQQCustomArkDialogForAio.setCanceledOnTouchOutside(true);
    localQQCustomArkDialogForAio.setCancelable(true);
    return localQQCustomArkDialogForAio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtils
 * JD-Core Version:    0.7.0.1
 */