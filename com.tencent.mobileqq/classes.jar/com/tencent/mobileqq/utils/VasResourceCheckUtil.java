package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorRingConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.app.MobileQQ;

public class VasResourceCheckUtil
{
  public static Handler.Callback a;
  public static Handler a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + ".VasResourceCheck/temp.json";
    jdField_a_of_type_AndroidOsHandler$Callback = new VasResourceCheckUtil.2();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (localObject != null)
    {
      FileUtils.a(((BubbleManager)localObject).a().getAbsolutePath(), false);
      ((BubbleManager)localObject).a();
    }
    localObject = (FontManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER);
    if (localObject != null)
    {
      FileUtils.a(((FontManager)localObject).a().getAbsolutePath(), false);
      ((FontManager)localObject).a();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    if (localObject != null)
    {
      FileUtils.a(((AvatarPendantManager)localObject).a().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).a();
      FileUtils.a(((AvatarPendantManager)localObject).b().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).b();
    }
    localObject = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".emotionsm"));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    FileUtils.a(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir().getParentFile(), "app_mobileqq_theme");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(AppConstants.PATH_SYSTEM_BACKGROUND + "resource");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(ColorRingConstants.jdField_a_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    QQToast.a(paramActivity, HardCodeUtil.a(2131715878), 0).a();
    paramActivity.finish();
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandler$Callback);
    }
    paramActivity = new DownloadTask(paramString, new File(jdField_a_of_type_JavaLangString));
    ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a(paramActivity, new VasResourceCheckUtil.1(paramQQAppInterface), null);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasResourceCheckUtil
 * JD-Core Version:    0.7.0.1
 */