package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public final class NearbyUtilsReal
{
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
    if (paramStringBuilder == null) {
      paramStringBuilder = new StringBuilder(20);
    } else {
      paramStringBuilder.setLength(0);
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int k = paramVarArgs.length;
      int i = 0;
      int j = 1;
      while (i < k)
      {
        Object localObject = paramVarArgs[i];
        if (j == 0) {
          paramStringBuilder.append(paramString);
        } else {
          j = 0;
        }
        paramStringBuilder.append(localObject);
        i += 1;
      }
    }
    return paramStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i = 0;
    boolean bool;
    if (paramInt != 2)
    {
      if (paramInt != 4) {
        bool = false;
      } else {
        bool = QLog.isDevelopLevel();
      }
    }
    else {
      bool = QLog.isColorLevel();
    }
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(paramString2);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        while (i < j)
        {
          paramString2 = paramVarArgs[i];
          localStringBuilder.append(",");
          localStringBuilder.append(paramString2);
          i += 1;
        }
      }
      if ((paramInt == 4) && (QLog.isDevelopLevel()))
      {
        QLog.i(paramString1, 4, localStringBuilder.toString());
        return;
      }
      if ((paramInt == 2) && (QLog.isColorLevel())) {
        QLog.i(paramString1, 2, localStringBuilder.toString());
      }
    }
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
      try
      {
        paramEditText.setSelection(str.length());
        return;
      }
      catch (Exception paramEditText)
      {
        QLog.e("NearbyUtils", 1, " truncateEditText error", paramEditText);
      }
    }
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    paramTextView.setGravity(16);
    paramTextView.setIncludeFontPadding(false);
    paramTextView.setCompoundDrawablePadding(AIOUtils.b(2.0F, paramTextView.getContext().getResources()));
    paramTextView.setPadding(AIOUtils.b(4.0F, paramTextView.getContext().getResources()), 0, AIOUtils.b(4.0F, paramTextView.getContext().getResources()), 0);
    paramTextView.setText(paramString);
    paramTextView.setTextColor(paramInt2);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, AIOUtils.b(8.0F, paramTextView.getContext().getResources()), AIOUtils.b(10.0F, paramTextView.getContext().getResources()));
      paramTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    paramTextView.setBackgroundDrawable(BizTroopUtil.a(paramTextView.getContext().getResources(), paramInt1));
    paramTextView.setTextSize(1, 10.0F);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("targetUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|type:");
      localStringBuilder.append(paramInt);
      QLog.d("NearbyUtils", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new NearbyUtilsReal.1(paramString, paramInt, paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", str, "talk_safety_check", paramString1, 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("report talk check: action=");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append(", toUin=");
      paramQQAppInterface.append(str);
      QLog.d("nearby.bindphone", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(INearbyAppInterface paramINearbyAppInterface, String paramString, int paramInt)
  {
    String str;
    if (paramInt > 0) {
      str = String.valueOf(paramInt);
    } else {
      str = "";
    }
    paramInt = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramINearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    ReportController.b(null, "dc00899", "grp_lbs", "", "home", paramString, 0, 0, str, String.valueOf(paramInt), "", "");
    if (QLog.isColorLevel())
    {
      paramINearbyAppInterface = new StringBuilder();
      paramINearbyAppInterface.append("reportHomeEvent: actionName=");
      paramINearbyAppInterface.append(paramString);
      paramINearbyAppInterface.append(",d1[tabType]=");
      paramINearbyAppInterface.append(str);
      paramINearbyAppInterface.append(", d2[gender]=");
      paramINearbyAppInterface.append(paramInt);
      QLog.d("NearbyUtils", 2, paramINearbyAppInterface.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        localStringBuilder.append(",");
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
      localStringBuilder.append(paramString);
      localStringBuilder.append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        localStringBuilder.append(",");
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
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 14) {
      return "1";
    }
    if (paramInt == 15) {
      return "2";
    }
    if (paramInt == 16) {
      return "3";
    }
    return "4";
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public static boolean c()
  {
    return BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby") instanceof INearbyAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUtilsReal
 * JD-Core Version:    0.7.0.1
 */