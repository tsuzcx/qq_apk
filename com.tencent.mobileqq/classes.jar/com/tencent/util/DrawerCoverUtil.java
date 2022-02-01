package com.tencent.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
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
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static CallBacker a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, String paramString, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "now is in drawer frame?" + paramBoolean);
    }
    if (!a(paramQQAppInterface, paramCard))
    {
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.1(paramRandomCoverView, paramString));
      a();
    }
    for (;;)
    {
      return null;
      if (!b(paramQQAppInterface, paramCard))
      {
        if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (ProfileCardTemplate.a(paramCard.lCurrentStyleId)))
        {
          c(paramQQAppInterface, paramCard);
          a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean);
        }
        else
        {
          ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramQQAppInterface, "card." + paramCard.lCurrentBgId);
          paramString = (IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
          paramBaseActivity = new DrawerCoverUtil.2(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean, paramString);
          paramString.addWeakCallback(paramBaseActivity);
          return paramBaseActivity;
        }
      }
      else {
        a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean);
      }
    }
  }
  
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
        if ((l == 160L) || (l == 1600L) || (ProfileCardTemplate.a(paramCard.lCurrentStyleId))) {}
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
            ThreadManager.getUIHandler().post(new DrawerCoverUtil.3(paramBaseActivity, (Bitmap)localObject, paramRandomCoverView, paramBoolean, paramQQSettingMeListener, paramCard));
          }
          return;
        }
      }
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.4(paramRandomCoverView, (UpSideDownDrawable)localObject, paramBoolean));
      return;
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localCardHandler == null) {}
    do
    {
      return;
      byte b = (byte)SharedPreUtils.X(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
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
      localCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentUin(), 0, l, (byte)1, 0L, 0L, arrayOfByte1, "", 0L | 1L | 0x4 | 0x8 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800 | 0x2000, 10004, arrayOfByte2, b);
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
    paramQQAppInterface = ProfileCardUtil.a(paramQQAppInterface, paramCard.lCurrentStyleId, true);
    boolean bool = SimpleUIUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[check cardTemplate]lCurrentStyleId:" + paramCard.lCurrentStyleId + " backgroundUrl:" + paramCard.strDrawerCardUrl + " templateRet:" + paramCard.templateRet + " isSimpleUI:" + bool);
    }
    if (bool) {}
    do
    {
      return false;
      if (ProfileCardTemplate.a(paramCard.lCurrentStyleId)) {
        return true;
      }
    } while ((paramCard.lCurrentStyleId <= 0L) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramCard.strDrawerCardUrl)) || (paramCard.templateRet != 0));
    return true;
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
    if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (ProfileCardTemplate.a(paramCard.lCurrentStyleId))) {
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
    Object localObject = new File(ProfileCardUtil.a(paramQQAppInterface.getApplication(), paramCard.strDrawerCardUrl));
    localObject = new DownloadTask(paramCard.strDrawerCardUrl, (File)localObject);
    ((DownloadTask)localObject).f = "profileCardDownload";
    ((DownloadTask)localObject).e = "VIP_profilecard";
    int i = DownloaderFactory.a((DownloadTask)localObject, paramQQAppInterface);
    if (i == 0) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("DIYProfileTemplate.DrawerCover", 1, "download error:" + i);
    }
    for (;;)
    {
      return false;
      QLog.e("DIYProfileTemplate.DrawerCover", 1, "download {" + paramCard.strDrawerCardUrl + "} error:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil
 * JD-Core Version:    0.7.0.1
 */