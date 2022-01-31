package com.tencent.util;

import aljs;
import aljt;
import alju;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class DrawerCoverUtil
{
  public static String a;
  private static boolean a;
  
  public static void a()
  {
    jdField_a_of_type_JavaLangString = null;
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, String paramString, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "now is in drawer frame?" + paramBoolean);
    }
    if (!a(paramQQAppInterface, paramCard))
    {
      ThreadManager.getUIHandler().post(new aljs(paramRandomCoverView, paramString));
      a();
    }
    do
    {
      return;
      if (!b(paramQQAppInterface, paramCard)) {
        c(paramQQAppInterface, paramCard);
      }
      paramQQAppInterface = paramQQSettingMeListener.a(paramCard.strDrawerCardUrl);
      a(paramCard.strDrawerCardUrl);
      if (paramQQAppInterface != null) {
        break;
      }
      paramQQAppInterface = ProfileCardUtil.a(paramBaseActivity, paramCard.strDrawerCardUrl);
      paramString = new BitmapFactory.Options();
      paramString.inPreferredConfig = Bitmap.Config.RGB_565;
      paramString = BitmapManager.a(paramQQAppInterface, paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[personal card] fileName:" + paramQQAppInterface + " bitmap:" + paramString);
    }
    ThreadManager.getUIHandler().post(new aljt(paramBaseActivity, paramString, paramRandomCoverView, paramBoolean, paramQQSettingMeListener, paramCard));
    return;
    ThreadManager.getUIHandler().post(new alju(paramRandomCoverView, paramQQAppInterface, paramBoolean));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.a(2);
    if (localCardHandler == null) {}
    do
    {
      return;
      byte b = (byte)SharedPreUtils.al(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
      byte[] arrayOfByte1 = null;
      byte[] arrayOfByte2 = null;
      if (0 == 0)
      {
        arrayOfByte1 = new byte[1];
        arrayOfByte1[0] = 0;
      }
      if (0 == 0)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      long l = paramCard.feedPreviewTime;
      localCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.c(), 0, l, (byte)1, 0L, 0L, arrayOfByte1, "", 0L | 1L | 0x4 | 0x8 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800 | 0x2000, 10004, arrayOfByte2, b);
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.", 2, "fetch profilecard info failure from cache,restart to fetch from net");
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaLangString != null;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    boolean bool = true;
    paramQQAppInterface = ProfileCardUtil.a(paramQQAppInterface, paramCard.lCurrentStyleId, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[check cardTemplate]lCurrentStyleId:" + paramCard.lCurrentStyleId + " backgroundUrl:" + paramCard.strDrawerCardUrl + " templateRet:" + paramCard.templateRet);
    }
    if ((paramCard.lCurrentStyleId <= 0L) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramCard.strDrawerCardUrl)) || (paramCard.templateRet != 0)) {
      bool = false;
    }
    return bool;
  }
  
  public static void b()
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    return ProfileCardUtil.a(paramQQAppInterface.getApp(), paramCard.strDrawerCardUrl);
  }
  
  public static void c()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    File localFile = new File(ProfileCardUtil.a(paramQQAppInterface.getApplication(), paramCard.strDrawerCardUrl));
    paramCard = new DownloadTask(paramCard.strDrawerCardUrl, localFile);
    paramCard.f = "profileCardDownload";
    paramCard.e = "VIP_profilecard";
    return DownloaderFactory.a(paramCard, paramQQAppInterface) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil
 * JD-Core Version:    0.7.0.1
 */