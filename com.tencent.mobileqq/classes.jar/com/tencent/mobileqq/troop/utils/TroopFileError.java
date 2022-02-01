package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
    DialogUtil.a(paramContext, 230, paramContext.getResources().getString(2131697614), paramContext.getResources().getString(2131697615), 2131697668, 2131697299, local2, local2).show();
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
    try
    {
      int i = paramContext.getResources().getDimensionPixelSize(2131299168);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new TroopFileError.1(paramContext, paramInt, paramString, i));
        return;
      }
      QQToast.a(paramContext, paramInt, paramString, 0).b(i);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("TroopFileError", 1, "showTipsToast error!", paramContext);
    }
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
    if (paramQQAppInterface != null)
    {
      if (paramInt2 == 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("reportSimpleError==> troopUin:");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(",filename:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",status:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",errorCode:");
        localStringBuilder.append(paramInt2);
        QLog.e("TroopFileError", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = (TroopFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b(new TroopFileError.SimpleErrorInfo(paramString, paramLong, paramInt1, paramInt2));
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isAllRequestFinished())
    {
      if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips())
      {
        ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(paramQQAppInterface);
        return;
      }
      a(paramContext, paramString, paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    if ((paramQQAppInterface != null) && (paramSimpleErrorInfo != null))
    {
      if (paramSimpleErrorInfo.jdField_a_of_type_Int == 0) {
        return;
      }
      paramQQAppInterface = (TroopFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b(paramSimpleErrorInfo);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    WeakReference localWeakReference = a;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ThreadManagerV2.executeOnSubThread(new TroopFileError.3(paramQQAppInterface, (TroopFileError.TroopFileErrorObserver)a.get()));
      a = null;
    }
    a = new WeakReference(paramTroopFileErrorObserver);
    paramQQAppInterface.addObserver(paramTroopFileErrorObserver);
  }
  
  public static void a(TroopFileError.SimpleErrorInfo paramSimpleErrorInfo, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramSimpleErrorInfo != null)
    {
      if (paramContext == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramSimpleErrorInfo.jdField_b_of_type_JavaLangString))
      {
        a(paramContext, paramSimpleErrorInfo.jdField_b_of_type_JavaLangString, 1);
        return;
      }
      String str2 = TroopFileUtils.a(paramSimpleErrorInfo.jdField_a_of_type_JavaLangString);
      String str1 = null;
      int j = paramSimpleErrorInfo.jdField_a_of_type_Int;
      int i = 0;
      if ((j != -139) && (j != -138))
      {
        if (j != -136)
        {
          if (j != 1) {
            switch (j)
            {
            default: 
              switch (j)
              {
              default: 
                switch (j)
                {
                default: 
                  switch (j)
                  {
                  default: 
                    switch (j)
                    {
                    default: 
                      switch (j)
                      {
                      default: 
                        switch (j)
                        {
                        default: 
                          switch (j)
                          {
                          default: 
                            break;
                          case 706: 
                            if (!TextUtils.isEmpty(paramSimpleErrorInfo.jdField_b_of_type_JavaLangString)) {
                              str1 = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
                            } else {
                              str1 = a(paramQQAppInterface, 2131697396);
                            }
                            break;
                          case 705: 
                            str1 = a(paramQQAppInterface, 2131697395);
                            break;
                          case 704: 
                            str1 = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
                            break;
                          case 703: 
                            str1 = a(paramQQAppInterface, 2131697393);
                            break;
                          case 702: 
                            str1 = a(paramQQAppInterface, 2131697394);
                            break;
                          case 701: 
                            str1 = a(paramQQAppInterface, 2131697392);
                          }
                          break;
                        case 605: 
                          str1 = a(paramQQAppInterface, 2131697388);
                          break;
                        case 604: 
                          str1 = a(paramQQAppInterface, 2131697389);
                          break;
                        case 603: 
                          str1 = a(paramQQAppInterface, 2131697391);
                          break;
                        case 602: 
                          str1 = a(paramQQAppInterface, 2131697390);
                          break;
                        case 601: 
                          str1 = a(paramQQAppInterface, 2131697387);
                          break;
                        case 600: 
                          str1 = a(paramQQAppInterface, 2131697386);
                        }
                        break;
                      case 505: 
                        str1 = a(paramQQAppInterface, 2131697787);
                        i = 2;
                        break;
                      case 504: 
                        str1 = a(paramQQAppInterface, 2131697785);
                        break;
                      case 503: 
                        str1 = a(paramQQAppInterface, 2131697786, new Object[] { str2 });
                        break;
                      case 502: 
                        str1 = a(paramQQAppInterface, 2131697784, new Object[] { str2 });
                        break;
                      }
                      str1 = a(paramQQAppInterface, 2131697783);
                      break;
                    case 403: 
                      str1 = a(paramQQAppInterface, 2131697315, new Object[] { str2 });
                      break;
                    case 402: 
                      str1 = a(paramQQAppInterface, 2131697313);
                      break;
                    case 401: 
                      str1 = a(paramQQAppInterface, 2131697314);
                    }
                    break;
                  case 309: 
                    str1 = a(paramQQAppInterface, 2131697329, new Object[] { str2 });
                    break;
                  case 308: 
                    str1 = a(paramQQAppInterface, 2131697328);
                    break;
                  case 306: 
                    str1 = a(paramQQAppInterface, 2131697332);
                    break;
                  case 302: 
                    str1 = a(paramQQAppInterface, 2131697331, new Object[] { str2 });
                    break;
                  case 301: 
                    str1 = a(paramQQAppInterface, 2131697330, new Object[] { str2 });
                  }
                  break;
                case 210: 
                  str1 = a(paramQQAppInterface, 2131697807);
                  ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
                  break;
                case 208: 
                  str1 = a(paramQQAppInterface, 2131697692);
                  break;
                case 207: 
                case 209: 
                  str1 = a(paramQQAppInterface, 2131697779);
                  break;
                case 206: 
                  str1 = a(paramQQAppInterface, 2131697800, new Object[] { str2 });
                  break;
                case 205: 
                  str1 = a(paramQQAppInterface, 2131697801, new Object[] { str2 });
                  break;
                case 204: 
                  str1 = a(paramQQAppInterface, 2131697802, new Object[] { str2 });
                  break;
                case 202: 
                  str1 = a(paramQQAppInterface, 2131697742, new Object[] { str2 });
                  break;
                case 201: 
                  str1 = a(paramQQAppInterface, 2131697805, new Object[] { str2 });
                }
                break;
              case 107: 
                a(paramContext, paramLong);
                break;
              case 106: 
                str1 = a(paramQQAppInterface, 2131697616);
                break;
              case 105: 
                if (TroopFileInfo.FileStatus.a(paramSimpleErrorInfo.jdField_b_of_type_Int)) {
                  str1 = a(paramQQAppInterface, 2131697799, new Object[] { str2 });
                } else {
                  str1 = a(paramQQAppInterface, 2131697327, new Object[] { str2 });
                }
                break;
              }
              break;
            case 101: 
              str1 = a(paramQQAppInterface, 2131697692);
              break;
            }
          } else {
            str1 = a(paramQQAppInterface, 2131697779);
          }
        }
        else {
          str1 = a(paramQQAppInterface, 2131697372);
        }
        i = 1;
      }
      else
      {
        str1 = a(paramQQAppInterface, 2131697373);
      }
      if ((paramSimpleErrorInfo.jdField_a_of_type_Int != 602) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 604) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 605))
      {
        if ((paramSimpleErrorInfo.jdField_a_of_type_Int != 601) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 605) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 802) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 604) && (paramSimpleErrorInfo.jdField_a_of_type_Int != 702))
        {
          a(paramContext, str1, i);
          return;
        }
        a(paramQQAppInterface, paramContext, str1, i);
        return;
      }
      if (BaseActivity.sTopActivity != null) {
        ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    paramQQAppInterface.removeObserver(paramTroopFileErrorObserver);
    paramQQAppInterface = a;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.get() == paramTroopFileErrorObserver)) {
      a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError
 * JD-Core Version:    0.7.0.1
 */