package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler;
import cooperation.weiyun.WeiyunSaveTipsFactory;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class TroopFileError
{
  public static WeakReference<TroopFileError.TroopFileErrorObserver> a = new WeakReference(null);
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getApplication().getResources().getString(paramInt);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramQQAppInterface, paramInt), paramVarArgs);
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    TroopFileError.2 local2 = new TroopFileError.2(paramLong);
    DialogUtil.a(paramContext, 230, paramContext.getResources().getString(2131697608), paramContext.getResources().getString(2131697609), 2131697662, 2131697280, local2, local2).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i;
    try
    {
      i = paramContext.getResources().getDimensionPixelSize(2131299166);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new TroopFileError.1(paramContext, paramInt, paramString, i));
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("TroopFileError", 1, "showTipsToast error!", paramContext);
      return;
    }
    QQToast.a(paramContext, paramInt, paramString, 0).b(i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    a(paramQQAppInterface, paramLong, 7, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, null, paramInt1, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramInt2 == 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("reportSimpleError==> troopUin:");
        localStringBuilder.append(paramLong).append(",filename:").append(paramString).append(",status:").append(paramInt1).append(",errorCode:").append(paramInt2);
        QLog.e("TroopFileError", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new TroopFileError.SimpleErrorInfo(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (ResponseHandler.a())
    {
      if (ResponseHandler.b()) {
        ResponseHandler.a(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    if ((paramQQAppInterface == null) || (paramSimpleErrorInfo == null) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramSimpleErrorInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    if ((a != null) && (a.get() != null))
    {
      paramQQAppInterface.removeObserver((BusinessObserver)a.get());
      a = null;
    }
    a = new WeakReference(paramTroopFileErrorObserver);
    paramQQAppInterface.addObserver(paramTroopFileErrorObserver);
  }
  
  public static void a(TroopFileError.SimpleErrorInfo paramSimpleErrorInfo, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramSimpleErrorInfo == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramSimpleErrorInfo.jdField_b_of_type_JavaLangString))
    {
      a(paramContext, paramSimpleErrorInfo.jdField_b_of_type_JavaLangString, 1);
      return;
    }
    String str = TroopFileUtils.a(paramSimpleErrorInfo.jdField_a_of_type_JavaLangString);
    int i;
    switch (paramSimpleErrorInfo.jdField_a_of_type_Int)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((paramSimpleErrorInfo.jdField_a_of_type_Int != 602) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 604) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 605)) {
        break label1303;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      WeiyunSaveTipsFactory.a(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = a(paramQQAppInterface, 2131697686);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697610);
      i = 0;
      continue;
      a(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697780, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697778, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697779);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697777);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697781);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131697296, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697294);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697295);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697773);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697801);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697799, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697794, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697736, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697796, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697795, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697686);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697353);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697354);
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131697313);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697309);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697311, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697312, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131697310, new Object[] { str });
      i = 0;
      continue;
      if (TroopFileInfo.FileStatus.a(paramSimpleErrorInfo.jdField_b_of_type_Int))
      {
        str = a(paramQQAppInterface, 2131697793, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131697308, new Object[] { str });
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697773);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697367);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697368);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697371);
        i = 2;
        continue;
        str = a(paramQQAppInterface, 2131697372);
        i = 1;
        continue;
        str = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697373);
        i = 1;
        continue;
        str = a(paramQQAppInterface, 2131697375);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697374);
        i = 0;
        continue;
        str = a(paramQQAppInterface, 2131697376);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(paramSimpleErrorInfo.jdField_b_of_type_JavaLangString))
        {
          str = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
          i = 0;
        }
        else
        {
          str = a(paramQQAppInterface, 2131697377);
          i = 0;
          continue;
          str = a(paramQQAppInterface, 2131697370);
          i = 2;
          continue;
          str = a(paramQQAppInterface, 2131697369);
          i = 0;
        }
      }
    }
    label1303:
    if ((paramSimpleErrorInfo.jdField_a_of_type_Int == 601) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 605) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 802) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 604) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 702))
    {
      a(paramQQAppInterface, paramContext, str, i);
      return;
    }
    a(paramContext, str, i);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    paramQQAppInterface.removeObserver(paramTroopFileErrorObserver);
    if ((a != null) && (a.get() == paramTroopFileErrorObserver)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError
 * JD-Core Version:    0.7.0.1
 */