package com.tencent.mobileqq.nearby;

import aevn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public final class NearbyUtils
{
  public static String a(int paramInt)
  {
    String str = "4";
    if (paramInt == 14) {
      str = "1";
    }
    do
    {
      return str;
      if (paramInt == 15) {
        return "2";
      }
    } while (paramInt != 16);
    return "3";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = Pattern.compile("\n").matcher(paramString).replaceAll("");
    paramString = Pattern.compile("^ +").matcher(paramString).replaceAll("");
    return Pattern.compile(" +$").matcher(paramString).replaceAll("");
  }
  
  public static String a(StringBuilder paramStringBuilder, String paramString, Object... paramVarArgs)
  {
    int j;
    int i;
    label32:
    Object localObject;
    if (paramStringBuilder == null)
    {
      paramStringBuilder = new StringBuilder(20);
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break label82;
      }
      j = 1;
      int k = paramVarArgs.length;
      i = 0;
      if (i >= k) {
        break label82;
      }
      localObject = paramVarArgs[i];
      if (j != 0) {
        break label76;
      }
      paramStringBuilder.append(paramString);
    }
    for (;;)
    {
      paramStringBuilder.append(localObject);
      i += 1;
      break label32;
      paramStringBuilder.setLength(0);
      break;
      label76:
      j = 0;
    }
    label82:
    return paramStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i = 0;
    boolean bool;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool = false;
    }
    StringBuilder localStringBuilder;
    while (bool)
    {
      localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(paramString2);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        for (;;)
        {
          if (i < j)
          {
            paramString2 = paramVarArgs[i];
            localStringBuilder.append(",").append(paramString2);
            i += 1;
            continue;
            bool = QLog.isColorLevel();
            break;
            bool = QLog.isDevelopLevel();
            break;
          }
        }
      }
      if ((paramInt != 4) || (!QLog.isDevelopLevel())) {
        break label142;
      }
      QLog.i(paramString1, 4, localStringBuilder.toString());
    }
    label142:
    while ((paramInt != 2) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.i(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, BindNumberActivity.class);
    localIntent.putExtra("kSrouce", 20);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(EditText paramEditText, int paramInt)
  {
    String str = paramEditText.getText().toString();
    if (str.getBytes().length > paramInt)
    {
      while (str.getBytes().length > paramInt) {
        str = str.substring(0, str.length() - 1);
      }
      paramEditText.setText(str);
      paramEditText.setSelection(str.length());
    }
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    paramTextView.setGravity(16);
    paramTextView.setIncludeFontPadding(false);
    paramTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, paramTextView.getContext().getResources()));
    paramTextView.setPadding(AIOUtils.a(4.0F, paramTextView.getContext().getResources()), 0, AIOUtils.a(4.0F, paramTextView.getContext().getResources()), 0);
    paramTextView.setText(paramString);
    paramTextView.setTextColor(paramInt2);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, AIOUtils.a(8.0F, paramTextView.getContext().getResources()), AIOUtils.a(10.0F, paramTextView.getContext().getResources()));
      paramTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    paramTextView.setBackgroundDrawable(TroopUtils.a(paramTextView.getContext().getResources(), paramInt1));
    paramTextView.setTextSize(1, 10.0F);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyUtils", 2, "targetUin:" + paramString + "|type:" + paramInt);
    }
    ThreadManager.post(new aevn(paramString, paramInt, paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", paramString2, "talk_safety_check", paramString1, 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "report talk check: action=" + paramString1 + ", toUin=" + paramString2);
      }
      return;
    }
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface, String paramString, int paramInt)
  {
    if (paramInt > 0) {}
    for (String str = String.valueOf(paramInt);; str = "")
    {
      paramInt = ((Integer)NearbySPUtil.a(paramNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", paramString, 0, 0, str, String.valueOf(paramInt), "", "");
      if (QLog.isColorLevel()) {
        QLog.d("NearbyUtils", 2, "reportHomeEvent: actionName=" + paramString + ",d1[tabType]=" + str + ", d2[gender]=" + paramInt);
      }
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i(paramString1, 4, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i("Q.nearby", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    return QLog.isDevelopLevel();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23) || (paramInt == 28) || (paramInt == 48);
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public static boolean c()
  {
    return BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby") instanceof NearbyAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUtils
 * JD-Core Version:    0.7.0.1
 */