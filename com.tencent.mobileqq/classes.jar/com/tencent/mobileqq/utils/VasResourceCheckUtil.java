package com.tencent.mobileqq.utils;

import akgq;
import akgr;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
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
    jdField_a_of_type_JavaLangString = AppConstants.aJ + ".VasResourceCheck/temp.json";
    jdField_a_of_type_AndroidOsHandler$Callback = new akgr();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(43);
    if (localObject != null)
    {
      FileUtils.a(((BubbleManager)localObject).a().getAbsolutePath(), false);
      ((BubbleManager)localObject).a();
    }
    localObject = (FontManager)paramQQAppInterface.getManager(41);
    if (localObject != null)
    {
      FileUtils.a(((FontManager)localObject).a().getAbsolutePath(), false);
      ((FontManager)localObject).a();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(45);
    if (localObject != null)
    {
      FileUtils.a(((AvatarPendantManager)localObject).a().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).a();
      FileUtils.a(((AvatarPendantManager)localObject).b().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).b();
    }
    localObject = new File(AppConstants.aJ + ".emotionsm");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    FileUtils.a(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    localObject = new File(AppConstants.aJ + "theme_pkg");
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
    paramQQAppInterface = new File(AppConstants.bx);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(AppConstants.aJ + "sysyem_background/resource");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(AppConstants.aJ + "rbt");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.a(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    QQToast.a(paramActivity, "进入个性化素材检查流程", 0).a();
    paramActivity.finish();
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandler$Callback);
    }
    paramActivity = new DownloadTask(paramString, new File(jdField_a_of_type_JavaLangString));
    ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1).a(paramActivity, new akgq(paramQQAppInterface), null);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasResourceCheckUtil
 * JD-Core Version:    0.7.0.1
 */