package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorRingConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.app.MobileQQ;

public class VasResourceCheckUtil
{
  public static final String a;
  public static Handler b;
  public static Handler.Callback c = new VasResourceCheckUtil.2();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".VasResourceCheck/temp.json");
    a = localStringBuilder.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (localObject != null)
    {
      FileUtils.delete(((BubbleManager)localObject).a().getAbsolutePath(), false);
      ((BubbleManager)localObject).a();
    }
    localObject = (IFontManagerService)paramQQAppInterface.getRuntimeService(IFontManagerService.class, "");
    if (localObject != null)
    {
      FileUtils.delete(((IFontManagerService)localObject).getFontBaseDir().getAbsolutePath(), false);
      ((IFontManagerService)localObject).getFontBaseDir();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    if (localObject != null)
    {
      FileUtils.delete(((AvatarPendantManager)localObject).d().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).d();
      FileUtils.delete(((AvatarPendantManager)localObject).e().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).e();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(".emotionsm");
    localObject = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString()));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    FileUtils.delete(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir().getParentFile(), "app_mobileqq_theme");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(AppConstants.PATH_SYSTEM_BACKGROUND);
    paramQQAppInterface.append("resource");
    paramQQAppInterface = new File(paramQQAppInterface.toString());
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(ColorRingConstants.a);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    FileUtils.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    QQToast.makeText(paramActivity, HardCodeUtil.a(2131913258), 0).show();
    paramActivity.finish();
    if (b == null) {
      b = new Handler(c);
    }
    paramActivity = new DownloadTask(paramString, new File(a));
    ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload(paramActivity, new VasResourceCheckUtil.1(paramQQAppInterface), null);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasResourceCheckUtil
 * JD-Core Version:    0.7.0.1
 */