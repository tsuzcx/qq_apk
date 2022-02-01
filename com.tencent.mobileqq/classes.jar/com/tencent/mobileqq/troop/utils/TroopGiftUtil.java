package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopGiftUtil
{
  public static Intent a(Activity paramActivity, String paramString1, String paramString2)
  {
    paramString1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(paramActivity, paramString1, 14);
    paramString1.putExtra("custom_title_name", paramActivity.getString(2131697747));
    paramString1.putExtra("troop_gift_from", paramString2);
    return paramString1;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/tencent/MobileQQ/.troop/pic_effects/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".mp4");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    String str = b(paramMessageForDeliverGiftTips);
    if (paramMessageForDeliverGiftTips.isInteract()) {
      return a(str);
    }
    return a(str, paramMessageForDeliverGiftTips.animationType);
  }
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_NEW");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder;
    if (paramInt == 1)
    {
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_V");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append(File.separator);
    }
    else
    {
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_HD");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append(File.separator);
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean)
    {
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
      localStringBuffer.append(File.separator);
      localStringBuffer.append(paramString);
      localStringBuffer.append("_NEW.zip");
    }
    else if (paramInt == 1)
    {
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
      localStringBuffer.append(File.separator);
      localStringBuffer.append(paramString);
      localStringBuffer.append("_V.zip");
    }
    else
    {
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
      localStringBuffer.append(File.separator);
      localStringBuffer.append(paramString);
      localStringBuffer.append("_HD.zip");
    }
    return localStringBuffer.toString();
  }
  
  public static List<String> a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    ArrayList localArrayList = new ArrayList();
    paramMessageForDeliverGiftTips = new File(a(paramMessageForDeliverGiftTips));
    if (paramMessageForDeliverGiftTips.exists())
    {
      paramMessageForDeliverGiftTips = paramMessageForDeliverGiftTips.listFiles();
      int i = 0;
      while (i < paramMessageForDeliverGiftTips.length)
      {
        if (paramMessageForDeliverGiftTips[i].getAbsolutePath().endsWith(".png")) {
          localArrayList.add(paramMessageForDeliverGiftTips[i].getAbsolutePath());
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static JSONObject a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_NEW");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append(File.separator);
    localStringBuffer.append("info.json");
    paramString = FileUtils.readFileContent(new File(localStringBuffer.toString()));
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if (paramIntent == null) {
      return;
    }
    a(paramActivity, paramIntent.getStringExtra("troop_uin"), paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"), paramIntent.getStringExtra("troop_gift_from"), paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
      if (localObject != null)
      {
        int i;
        if (((TroopInfo)localObject).isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          i = 0;
        } else if (((TroopInfo)localObject).isAdmin()) {
          i = 1;
        } else {
          i = 2;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("");
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "exp", 0, 0, paramString1, ((StringBuilder)localObject).toString(), "", "");
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("startSendGiftActivity from:");
      paramQQAppInterface.append(paramString2);
      QLog.d("TroopMemberUtil", 2, paramQQAppInterface.toString());
    }
    paramActivity.startActivityForResult(a(paramActivity, paramString1, paramString2), 12005);
    paramActivity.overridePendingTransition(2130772011, 2130772004);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface)
  {
    a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramQQAppInterface, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    if (paramActivity == null) {
      return;
    }
    int i = 0;
    String str2;
    try
    {
      str2 = Base64.encodeToString(paramString3.getBytes("UTF-8"), 0);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      str2 = paramString3;
    }
    String str1 = null;
    if (paramQQAppInterface != null)
    {
      ITroopLinkApi localITroopLinkApi = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
      str1 = QVipGiftProcessor.a().troopGiftUrl;
      if (!TextUtils.isEmpty(str1))
      {
        ITroopLinkApi.LinkParams localLinkParams = new ITroopLinkApi.LinkParams();
        localLinkParams.a = paramString1;
        localLinkParams.c = paramString4;
        localLinkParams.b = paramString2;
        localLinkParams.e = paramString3;
        str1 = localITroopLinkApi.replaceParams(str1, localLinkParams);
      }
    }
    paramString3 = str1;
    if (TextUtils.isEmpty(str1))
    {
      paramString3 = new Bundle();
      paramString3.putString("troopUin", paramString1);
      paramString3.putString("uin", paramString2);
      paramString3.putString("name", str2);
      paramString3.putString("from", paramString4);
      paramString3.putString("_wv", "1031");
      paramString3.putString("_bid", "2204");
      paramString2 = new StringBuilder();
      paramString2.append("https://qun.qq.com/qunpay/gifts/index.html?");
      paramString2.append(HttpUtil.encodeUrl(paramString3));
      paramString3 = paramString2.toString();
    }
    paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString3);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramString4 = paramMap.entrySet().iterator();
      while (paramString4.hasNext())
      {
        paramMap = (Map.Entry)paramString4.next();
        paramString2.putExtra((String)paramMap.getKey(), (String)paramMap.getValue());
      }
    }
    paramActivity.startActivityForResult(paramString2, 13001);
    if (paramQQAppInterface != null)
    {
      paramActivity = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
      if (paramActivity != null)
      {
        if (!paramActivity.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          if (paramActivity.isAdmin()) {
            i = 1;
          } else {
            i = 2;
          }
        }
        paramActivity = new StringBuilder();
        paramActivity.append(i);
        paramActivity.append("");
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "send_page", 0, 0, paramString1, paramActivity.toString(), "", "");
      }
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("openSendTroopGiftUrl url:");
      paramActivity.append(paramString3);
      QLog.d("TroopMemberUtil", 2, paramActivity.toString());
    }
  }
  
  public static void a(File paramFile, String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      String[] arrayOfString = paramString.list();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        if ((!"__MACOSX".equalsIgnoreCase((String)localObject)) && (!((String)localObject).endsWith(".")))
        {
          String str = paramFile.getAbsolutePath().replace(".zip", "/");
          localObject = new File(paramString, (String)localObject);
          if (((File)localObject).exists())
          {
            FileUtils.copyDirectory(((File)localObject).getAbsolutePath(), str, true);
            FileUtils.deleteDirectory(paramString.getAbsolutePath());
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt >= 40003)
    {
      if (paramInt > 40005) {
        return true;
      }
      Object localObject = new File(a(paramInt));
      if (((File)localObject).exists())
      {
        long l = ((File)localObject).length();
        if ((paramInt == 40003) && (l == 827720L)) {
          return true;
        }
        if ((paramInt == 40004) && (l == 355077L)) {
          return true;
        }
        if ((paramInt == 40005) && (l == 796025L)) {
          return true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isTroopPicEffectVideoValid = false, id:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("TroopMemberUtil", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    return (paramMessageForDeliverGiftTips != null) && ((paramMessageForDeliverGiftTips.animationPackageId > 0) || (paramMessageForDeliverGiftTips.isToAll()));
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.exists())
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath());
      localStringBuffer.append(File.separator);
      localStringBuffer.append("check.ini");
      Object localObject = new File(localStringBuffer.toString());
      if (!((File)localObject).exists()) {
        return false;
      }
      for (;;)
      {
        try
        {
          localObject = FileUtils.readFileToString((File)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return false;
          }
          arrayOfString = ((String)localObject).split("&");
          if (arrayOfString != null) {
            continue;
          }
          return false;
        }
        catch (IOException paramFile)
        {
          String[] arrayOfString;
          continue;
          int i = 0;
          continue;
        }
        if (i >= arrayOfString.length) {
          continue;
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath());
        localStringBuffer.append(File.separator);
        localStringBuffer.append(arrayOfString[i].toString());
        localObject = new File(localStringBuffer.toString());
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel())
          {
            paramFile = new StringBuilder();
            paramFile.append("isAnimationPackageValid File not exist:");
            paramFile.append(((File)localObject).getName());
            QLog.e(".troop.send_giftTroopMemberUtil", 2, paramFile.toString());
          }
          return false;
        }
        i += 1;
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("TroopMemberUtil", 2, "isAnimationPackageValid IOException");
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString = a(paramString);
    } else {
      paramString = a(paramString, paramInt);
    }
    return a(new File(paramString));
  }
  
  public static boolean a(List<?> paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effect_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (paramMessageForDeliverGiftTips == null) {
      return null;
    }
    if (paramMessageForDeliverGiftTips.isToAll()) {
      return String.valueOf(paramMessageForDeliverGiftTips.exflag);
    }
    return String.valueOf(paramMessageForDeliverGiftTips.animationPackageId);
  }
  
  public static String c(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    String str = b(paramMessageForDeliverGiftTips);
    if ((QVipGiftProcessor.a().isEnable()) && (!TextUtils.isEmpty(paramMessageForDeliverGiftTips.animationPackageUrl))) {
      return paramMessageForDeliverGiftTips.animationPackageUrl;
    }
    if (paramMessageForDeliverGiftTips.isInteract())
    {
      paramMessageForDeliverGiftTips = new StringBuilder();
      paramMessageForDeliverGiftTips.append("https://pub.idqqimg.com/pc/misc/groupgift/");
      paramMessageForDeliverGiftTips.append(str);
      paramMessageForDeliverGiftTips.append("_NEW.zip");
      return paramMessageForDeliverGiftTips.toString();
    }
    if (paramMessageForDeliverGiftTips.animationType == 1)
    {
      paramMessageForDeliverGiftTips = new StringBuilder();
      paramMessageForDeliverGiftTips.append("https://pub.idqqimg.com/pc/misc/groupgift/");
      paramMessageForDeliverGiftTips.append(str);
      paramMessageForDeliverGiftTips.append("_V.zip");
      return paramMessageForDeliverGiftTips.toString();
    }
    paramMessageForDeliverGiftTips = new StringBuilder();
    paramMessageForDeliverGiftTips.append("https://pub.idqqimg.com/pc/misc/groupgift/");
    paramMessageForDeliverGiftTips.append(str);
    paramMessageForDeliverGiftTips.append("_HD.zip");
    return paramMessageForDeliverGiftTips.toString();
  }
  
  public static String d(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMessageForDeliverGiftTips));
    localStringBuilder.append("/video.mp4");
    paramMessageForDeliverGiftTips = new File(localStringBuilder.toString());
    if (paramMessageForDeliverGiftTips.exists()) {
      return paramMessageForDeliverGiftTips.getAbsolutePath();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftUtil
 * JD-Core Version:    0.7.0.1
 */