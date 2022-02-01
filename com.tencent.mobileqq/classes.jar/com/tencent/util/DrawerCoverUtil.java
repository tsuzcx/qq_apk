package com.tencent.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
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
  private static boolean b = false;
  
  public static CallBacker a(QBaseActivity paramQBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, String paramString, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("now is in drawer frame?");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.profilecard.", 2, localStringBuilder.toString());
    }
    if (!a(paramQQAppInterface, paramCard))
    {
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.1(paramRandomCoverView, paramString));
      a();
    }
    else if (!b(paramQQAppInterface, paramCard))
    {
      if ((paramCard.lCurrentBgId != 160L) && (paramCard.lCurrentBgId != 1600L) && (!ProfileTemplateApi.isDiyTemplateStyleID(paramCard.lCurrentStyleId)))
      {
        paramString = ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("card.");
        localStringBuilder.append(paramCard.lCurrentBgId);
        paramString.a(paramQQAppInterface, localStringBuilder.toString());
        paramString = (IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
        paramQBaseActivity = new DrawerCoverUtil.2(paramQBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean, paramString);
        paramString.addWeakCallback(paramQBaseActivity);
        return paramQBaseActivity;
      }
      c(paramQQAppInterface, paramCard);
      a(paramQBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean);
    }
    else
    {
      a(paramQBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramQQSettingMeListener, paramBoolean);
    }
    return null;
  }
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(QBaseActivity paramQBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, boolean paramBoolean)
  {
    long l = paramCard.lCurrentBgId;
    Object localObject = (Boolean)ProfileCardManager.a.get(Long.valueOf(l));
    int i;
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      i = 1;
      ProfileCardManager.a.remove(Long.valueOf(l));
    }
    else
    {
      i = 0;
    }
    localObject = paramQQSettingMeListener.a(paramCard.strDrawerCardUrl);
    a(paramCard.strDrawerCardUrl);
    if ((localObject != null) && (i == 0))
    {
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.4(paramRandomCoverView, (UpSideDownDrawable)localObject, paramBoolean));
      return;
    }
    if ((l != 160L) && (l != 1600L) && (!ProfileTemplateApi.isDiyTemplateStyleID(paramCard.lCurrentStyleId))) {
      paramQQAppInterface = ProfileCardManager.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId);
    } else {
      paramQQAppInterface = ProfileCardUtil.c(paramCard.strDrawerCardUrl);
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
    localObject = BitmapManager.a(paramQQAppInterface, (BitmapFactory.Options)localObject);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[personal card] fileName:");
        localStringBuilder.append(paramQQAppInterface);
        localStringBuilder.append(" bitmap:");
        localStringBuilder.append(localObject);
        QLog.d("Q.profilecard.", 2, localStringBuilder.toString());
      }
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.3(paramQBaseActivity, (Bitmap)localObject, paramRandomCoverView, paramBoolean, paramQQSettingMeListener, paramCard));
    }
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    paramQQAppInterface = ProfileCardTemplateUtil.a(paramCard.lCurrentStyleId, true);
    boolean bool = SimpleUIUtil.e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[check cardTemplate]lCurrentStyleId:");
      localStringBuilder.append(paramCard.lCurrentStyleId);
      localStringBuilder.append(" backgroundUrl:");
      localStringBuilder.append(paramCard.strDrawerCardUrl);
      localStringBuilder.append(" templateRet:");
      localStringBuilder.append(paramCard.templateRet);
      localStringBuilder.append(" isSimpleUI:");
      localStringBuilder.append(bool);
      QLog.d("Q.profilecard.", 2, localStringBuilder.toString());
    }
    if (bool) {
      return false;
    }
    if (ProfileTemplateApi.isDiyTemplateStyleID(paramCard.lCurrentStyleId)) {
      return true;
    }
    if ((paramCard.lCurrentStyleId > 0L) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramCard.strDrawerCardUrl))) {
      return paramCard.templateRet == 0;
    }
    return false;
  }
  
  public static boolean b()
  {
    return a != null;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    if ((paramCard.lCurrentBgId != 160L) && (paramCard.lCurrentBgId != 1600L) && (!ProfileTemplateApi.isDiyTemplateStyleID(paramCard.lCurrentStyleId))) {
      return new File(ProfileCardManager.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId)).exists();
    }
    return ProfileCardUtil.b(paramCard.strDrawerCardUrl);
  }
  
  public static boolean c()
  {
    return b;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    Object localObject = new File(ProfileCardUtil.c(paramCard.strDrawerCardUrl));
    localObject = new DownloadTask(paramCard.strDrawerCardUrl, (File)localObject);
    ((DownloadTask)localObject).L = "profileCardDownload";
    ((DownloadTask)localObject).K = "VIP_profilecard";
    int i = DownloaderFactory.a((DownloadTask)localObject, paramQQAppInterface);
    if (i == 0) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("download error:");
      paramQQAppInterface.append(i);
      QLog.e("DIYProfileTemplate.DrawerCover", 1, paramQQAppInterface.toString());
    }
    else
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("download {");
      paramQQAppInterface.append(paramCard.strDrawerCardUrl);
      paramQQAppInterface.append("} error:");
      paramQQAppInterface.append(i);
      QLog.e("DIYProfileTemplate.DrawerCover", 1, paramQQAppInterface.toString());
    }
    return false;
  }
  
  public static void d()
  {
    b = true;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localCardHandler == null) {
      return;
    }
    byte b1 = (byte)SharedPreUtils.am(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
    long l = paramCard.feedPreviewTime;
    localCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentUin(), 0, l, (byte)1, 0L, 0L, new byte[] { 0 }, "", 11837L, 10004, new byte[] { 0 }, b1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "fetch profilecard info failure from cache,restart to fetch from net");
    }
  }
  
  public static void e()
  {
    b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil
 * JD-Core Version:    0.7.0.1
 */