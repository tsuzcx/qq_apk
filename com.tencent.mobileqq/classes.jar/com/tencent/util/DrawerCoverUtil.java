package com.tencent.util;

import amgr;
import amgs;
import amgt;
import amgu;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.UpSideDownDrawable;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;

public class DrawerCoverUtil
{
  public static String a;
  private static boolean a;
  
  public static void a()
  {
    jdField_a_of_type_JavaLangString = null;
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, boolean paramBoolean)
  {
    long l = paramCard.lCurrentBgId;
    Object localObject = (Boolean)ProfileCardManager.a.get(Long.valueOf(l));
    int i;
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      i = 1;
      ProfileCardManager.a.remove(Long.valueOf(l));
    }
    for (;;)
    {
      localObject = paramQQSettingMeListener.a(paramCard.strDrawerCardUrl);
      a(paramCard.strDrawerCardUrl);
      if ((localObject == null) || (i != 0))
      {
        if ((l == 160L) || (l == 1600L)) {}
        for (paramQQAppInterface = ProfileCardUtil.a(paramBaseActivity, paramCard.strDrawerCardUrl);; paramQQAppInterface = ProfileCardManager.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId))
        {
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = BitmapManager.a(paramQQAppInterface, (BitmapFactory.Options)localObject);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "[personal card] fileName:" + paramQQAppInterface + " bitmap:" + localObject);
            }
            ThreadManager.getUIHandler().post(new amgt(paramBaseActivity, (Bitmap)localObject, paramRandomCoverView, paramBoolean, paramQQSettingMeListener, paramCard));
          }
          return;
        }
      }
      ThreadManager.getUIHandler().post(new amgu(paramRandomCoverView, (UpSideDownDrawable)localObject, paramBoolean));
      return;
      i = 0;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, String paramString, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "now is in drawer frame?" + paramBoolean);
    }
    if (!a(paramQQAppInterface, paramCard))
    {
      ThreadManager.getUIHandler().post(new amgr(paramRandomCoverView, paramString));
      a();
      return;
    }
    if (!b(paramQQAppInterface, paramCard))
    {
      if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L))
      {
        c(paramQQAppInterface, paramCard);
        a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean);
        return;
      }
      ((VasExtensionManager)paramQQAppInterface.getManager(234)).a.a(paramQQAppInterface, "card." + paramCard.lCurrentBgId);
      ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(new amgs(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean));
      return;
    }
    a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.a(2);
    if (localCardHandler == null) {}
    do
    {
      return;
      byte b = (byte)SharedPreUtils.aj(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
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
    if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L)) {
      return ProfileCardUtil.a(paramQQAppInterface.getApp(), paramCard.strDrawerCardUrl);
    }
    return new File(ProfileCardManager.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId)).exists();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil
 * JD-Core Version:    0.7.0.1
 */