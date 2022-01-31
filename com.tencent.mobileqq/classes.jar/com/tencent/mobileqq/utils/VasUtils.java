package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import ajsl;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public final class VasUtils
{
  private static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VasUtils";
    jdField_a_of_type_Int = 1000;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
    if (paramQQAppInterface != null)
    {
      boolean bool = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
          return 22;
        }
        return 5;
      }
      if (bool)
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_QQVIP) == 1) {
          return 21;
        }
        return 4;
      }
    }
    return 1;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1 + File.separator + paramString2);
    if (!localFile.exists()) {
      return 1;
    }
    try
    {
      System.load(paramString1 + File.separator + paramString2);
      return 0;
    }
    catch (Throwable paramString1)
    {
      QLog.e("VasFont", 1, "loadLibrary error: " + paramString1.getMessage());
      localFile.delete();
    }
    return 2;
  }
  
  public static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    return a(paramString, false, false, paramURLDrawableListener, paramDrawable);
  }
  
  public static Drawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject1 = paramDrawable;
    Object localObject2;
    Object localObject3;
    if (paramDrawable == null)
    {
      localObject2 = localObject5;
      localObject3 = paramDrawable;
    }
    for (;;)
    {
      try
      {
        localObject1 = new ColorDrawable(-1513240);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable = URLDrawable.URLDrawableOptions.obtain();
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mFailedDrawable = ((Drawable)localObject1);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mLoadingDrawable = ((Drawable)localObject1);
        if (!paramBoolean1) {
          continue;
        }
      }
      catch (Exception paramURLDrawableListener)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getIPSiteDrawable error url = " + paramString + "error msg = " + paramURLDrawableListener);
        localObject1 = localObject3;
        paramDrawable = (Drawable)localObject2;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        try
        {
          paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IPSITE_GAME_IMAGE", paramString), paramDrawable);
        }
        catch (Exception paramDrawable)
        {
          localObject2 = localObject5;
          localObject3 = localObject1;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "getIPSiteDrawable error = " + paramDrawable);
          paramDrawable = localObject4;
        }
        continue;
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
        continue;
        return paramDrawable;
        if (paramDrawable != null) {
          continue;
        }
      }
      try
      {
        paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IP_SITE_ROUND_IMAGE", paramString), paramDrawable);
        if (paramDrawable != null)
        {
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          if (paramDrawable.getTag() == null)
          {
            localObject2 = paramDrawable;
            localObject3 = localObject1;
            paramDrawable.setTag(Integer.valueOf(0));
          }
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          paramDrawable.setURLDrawableListener(paramURLDrawableListener);
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          paramDrawable.setAutoDownload(true);
        }
      }
      catch (Exception paramDrawable)
      {
        localObject2 = localObject5;
        localObject3 = localObject1;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getIPSiteDrawable error = " + paramDrawable);
        paramDrawable = localObject4;
      }
    }
    return localObject1;
  }
  
  public static SpannableString a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split(" ");
      paramString = new SpannableString(paramString);
      int i = 0;
      while (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        if (a(str))
        {
          int k = i - 1;
          int j = 0;
          while (k >= 0)
          {
            j = j + arrayOfString[k].length() + 1;
            k -= 1;
          }
          k = str.length();
          paramString.setSpan(new ForegroundColorSpan(-15550475), j, k + j, 33);
        }
        i += 1;
      }
      return paramString;
    }
    return new SpannableString("");
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "vas_so" + File.separator;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    ((BaseActivity)paramContext).runOnUiThread(new ajsl(paramContext, paramString));
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    MqqHandler localMqqHandler = paramAppInterface.getHandler(ChatActivity.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshAIO");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), jdField_a_of_type_Int);
    }
    paramAppInterface = paramAppInterface.getHandler(ChatHistoryBubbleListForTroopFragment.class);
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refresh troop history");
      }
      paramAppInterface.removeMessages(16711697);
      paramAppInterface.sendMessageDelayed(paramAppInterface.obtainMessage(16711697), jdField_a_of_type_Int);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    int i3 = 1;
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    int i;
    int j;
    label51:
    int k;
    label65:
    int m;
    label80:
    int n;
    label95:
    int i1;
    label110:
    int i2;
    label125:
    boolean bool;
    if (localGameCenterManagerImp != null)
    {
      if (localGameCenterManagerImp.a("100005.100001") == -1) {
        break label263;
      }
      i = 1;
      if (i != 0)
      {
        if (localGameCenterManagerImp.a("100005.100003") == -1) {
          break label268;
        }
        j = 1;
        if (localGameCenterManagerImp.a("100005.100002") == -1) {
          break label273;
        }
        k = 1;
        if (localGameCenterManagerImp.a("100005.100006") == -1) {
          break label278;
        }
        m = 1;
        if (localGameCenterManagerImp.a("100005.100018") == -1) {
          break label284;
        }
        n = 1;
        if (localGameCenterManagerImp.a("100005.100020") == -1) {
          break label290;
        }
        i1 = 1;
        if (localGameCenterManagerImp.a("100005.100021") == -1) {
          break label296;
        }
        i2 = 1;
        bool = ((FontManager)paramQQAppInterface.getManager(41)).a;
        if (!bool) {
          break label312;
        }
        if (localGameCenterManagerImp.a("100005.100011") == -1) {
          break label302;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label158:
      if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0))) {
        if (localGameCenterManagerImp.a("100005") == -1) {
          break label307;
        }
      }
      label263:
      label268:
      label273:
      label278:
      label284:
      label290:
      label296:
      label302:
      label307:
      for (i = i3;; i = 0)
      {
        if (i != 0) {
          ((RedTouchManager)paramQQAppInterface.getManager(35)).b("100005");
        }
        return;
        i = 0;
        break;
        j = 0;
        break label51;
        k = 0;
        break label65;
        m = 0;
        break label80;
        n = 0;
        break label95;
        i1 = 0;
        break label110;
        i2 = 0;
        break label125;
        i = 0;
        break label158;
      }
      label312:
      i = 0;
    }
  }
  
  private static boolean a(String paramString)
  {
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo fail zipPath = " + paramString1 + " dstPath = " + paramString2);
    }
    for (;;)
    {
      return false;
      if (!new File(paramString1).exists())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo fail src file not exists");
        return false;
      }
      String str = paramString2 + File.separator + "unzip_temp/";
      try
      {
        FileUtils.a(paramString1, str, false);
        paramString1 = new File(str + paramString3);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "unCompressSo tempfile = " + paramString1.getAbsolutePath());
        }
        if (!paramString1.exists())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo fail so file not exists");
          return false;
        }
      }
      catch (IOException paramString1)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo IOException: ", paramString1);
        return false;
      }
      paramString2 = paramString2 + File.separator + paramString3;
      paramString3 = new File(paramString2);
      boolean bool;
      if (paramString3.exists())
      {
        bool = paramString3.delete();
        QLog.d(jdField_a_of_type_JavaLangString, 1, "unCompressSo so already exists, delete old so result = " + bool);
      }
      while (bool)
      {
        bool = paramString1.renameTo(paramString3);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "unCompressSo rename temp so to real path result = " + bool + "realpath = " + paramString2);
        return bool;
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasUtils
 * JD-Core Version:    0.7.0.1
 */