import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class nhs
{
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Throwable paramString) {}
    return 0L;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramQQAppInterface == null) || (paramMessage == null) || (paramMessage.msgtype != -5008)) {}
    label167:
    label555:
    for (;;)
    {
      return null;
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if (!(paramQQAppInterface instanceof MessageForArkApp)) {}
      }
      for (MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramQQAppInterface;; localMessageForArkApp = null) {
        for (;;)
        {
          if ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null) || (!"com.tencent.avgame".equals(localMessageForArkApp.ark_app_message.appName)) || (!"invite".equals(localMessageForArkApp.ark_app_message.appView))) {
            break label555;
          }
          int j = paramMessage.istroop;
          String str = paramMessage.frienduin;
          try
          {
            paramQQAppInterface = new JSONObject(localMessageForArkApp.ark_app_message.metaList);
            if (paramQQAppInterface.has("invite"))
            {
              paramQQAppInterface = paramQQAppInterface.getJSONObject("invite");
              if ((paramQQAppInterface == null) || (!paramQQAppInterface.has("extra"))) {
                break label344;
              }
              paramQQAppInterface = paramQQAppInterface.getJSONObject("extra");
              if ((paramQQAppInterface == null) || (!paramQQAppInterface.has("jump_url"))) {
                break label349;
              }
            }
            label344:
            label349:
            for (paramQQAppInterface = paramQQAppInterface.getString("jump_url");; paramQQAppInterface = null)
            {
              localQQAppInterface = paramQQAppInterface;
              if ((localQQAppInterface == null) || (!localQQAppInterface.startsWith("mqqapi://avgame/join_room"))) {
                break label406;
              }
              paramQQAppInterface = localQQAppInterface.split("\\?");
              if (paramQQAppInterface.length != 2) {
                break label376;
              }
              paramQQAppInterface = paramQQAppInterface[1];
              if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 0)) {
                break label406;
              }
              String[] arrayOfString = paramQQAppInterface.split("&");
              int i = 0;
              localObject1 = null;
              paramQQAppInterface = null;
              for (;;)
              {
                localObject3 = localObject1;
                localObject2 = paramQQAppInterface;
                if (i >= arrayOfString.length) {
                  break label412;
                }
                localObject2 = arrayOfString[i];
                if (((String)localObject2).split("=").length != 2) {
                  break label548;
                }
                int k = ((String)localObject2).indexOf("=");
                localObject3 = ((String)localObject2).substring(0, k);
                localObject2 = ((String)localObject2).substring(k + 1);
                if ((!"room".equals(localObject3)) || (!TextUtils.isDigitsOnly((CharSequence)localObject2))) {
                  break;
                }
                paramQQAppInterface = (QQAppInterface)localObject2;
                i += 1;
              }
              paramQQAppInterface = null;
              break;
              paramQQAppInterface = null;
              break label167;
            }
          }
          catch (Throwable paramQQAppInterface)
          {
            for (;;)
            {
              Object localObject1;
              Object localObject3;
              Object localObject2;
              if (QLog.isColorLevel()) {
                QLog.i("AVGameUtils", 2, "getAVGameIntentFromArkMessage", paramQQAppInterface);
              }
              QQAppInterface localQQAppInterface = null;
              continue;
              label376:
              paramQQAppInterface = null;
              continue;
              if (("uin".equals(localObject3)) && (TextUtils.isDigitsOnly((CharSequence)localObject2)))
              {
                localObject1 = localObject2;
                continue;
                localObject3 = null;
                localObject2 = null;
                if (QLog.isDevelopLevel()) {
                  QLog.i("AVGameUtils", 4, "getAVGameIntentFromArkMessage, room[" + (String)localObject2 + "], uin[" + (String)localObject3 + "], jump[" + localQQAppInterface + "], json[" + localMessageForArkApp.ark_app_message.metaList + "]");
                }
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
                  break;
                }
                paramQQAppInterface = AvGameLoadingActivity.a(false, j, str, (String)localObject2, 0);
                paramQQAppInterface.setClass(BaseApplicationImpl.getApplication(), PublicFragmentActivity.class);
                paramQQAppInterface.addFlags(268435456);
                paramQQAppInterface.putExtra("public_fragment_class", AvGameLoadingActivity.class.getName());
                ngj.a(paramQQAppInterface, paramMessage);
                return paramQQAppInterface;
              }
            }
          }
        }
      }
    }
  }
  
  public static Bitmap a(String paramString)
  {
    String str = mzu.c() + paramString;
    if (bhmi.b(str))
    {
      Object localObject = BaseApplicationImpl.sImageCache.get(str);
      if ((localObject != null) && ((localObject instanceof Bitmap))) {
        return (Bitmap)localObject;
      }
      try
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inScaled = false;
        localObject = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
        BaseApplicationImpl.sImageCache.put(str, localObject);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("AVGameUtils", 1, "getBitmap error " + paramString + localThrowable.getMessage());
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameUtils", 2, "getImageBitmap fail: " + localThrowable);
    }
    return null;
  }
  
  public static StateListDrawable a(Resources paramResources, String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString2 = a(paramString1);
    if (paramString2 != null) {}
    for (paramString2 = new BitmapDrawable(paramResources, paramString2);; paramString2 = null)
    {
      Bitmap localBitmap = a(paramString1);
      paramString1 = localObject;
      if (localBitmap != null) {
        paramString1 = new BitmapDrawable(paramResources, localBitmap);
      }
      paramResources = new StateListDrawable();
      paramResources.addState(new int[] { 16842919 }, paramString1);
      paramResources.addState(new int[] { 16842908 }, paramString2);
      paramResources.addState(new int[] { 16842910 }, paramString2);
      paramResources.addState(new int[0], paramString2);
      return paramResources;
    }
  }
  
  public static String a(long paramLong)
  {
    String str2 = String.valueOf(paramLong);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.length() < 9) {
        str1 = "000000000".substring(0, 9 - str2.length()) + str2;
      }
    }
    return str1;
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  public static void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (lzq.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    label666:
    for (;;)
    {
      try
      {
        paramActivity.startActivity(localIntent);
        j = 1;
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException3);
        j = 1;
        bool1 = false;
        continue;
      }
      int i = j;
      boolean bool2 = bool1;
      if (!bool1)
      {
        i = j;
        bool2 = bool1;
        if (lzq.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        i = 2;
        bool2 = true;
      }
      catch (Exception localException4)
      {
        if (!QLog.isColorLevel()) {
          break label497;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException4);
        i = 2;
        bool2 = false;
        continue;
      }
      int j = i;
      boolean bool1 = bool2;
      if (!bool2)
      {
        j = i;
        bool1 = bool2;
        if (lzq.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          i = 3;
          localIntent = new Intent();
          localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
          localIntent.addFlags(268435456);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool2 = true;
      }
      catch (Exception localException5)
      {
        if (!QLog.isColorLevel()) {
          break label540;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException5);
        bool2 = false;
        continue;
      }
      j = i;
      bool1 = bool2;
      if (!bool2) {
        localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool1 = true;
        j = i;
      }
      catch (Exception localException6)
      {
        if (!QLog.isColorLevel()) {
          break label581;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException6);
        bool1 = false;
        j = i;
        continue;
      }
      i = j;
      bool2 = bool1;
      if (!bool1) {
        localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      }
      try
      {
        localIntent.setData(Uri.fromParts("package", (String)localObject, null));
        paramActivity.startActivity(localIntent);
        i = 4;
        bool2 = true;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          break label623;
        }
        QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException1);
        i = 4;
        bool2 = false;
        continue;
        bool1 = bool2;
        continue;
      }
      if ((!bool2) && (lzq.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
      {
        i = 5;
        localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          paramActivity.startActivity((Intent)localObject);
          bool1 = true;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label666;
          }
          QLog.e("AVGameUtils", 2, "openPermissionActivity e = " + localException2);
          bool1 = false;
          continue;
        }
        if (!bool1)
        {
          localObject = new Intent(paramActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("hide_left_button", false);
          ((Intent)localObject).putExtra("show_right_close_button", false);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, "https://view.yutu.qq.com/yutu/activity/3857.html", 524288L, (Intent)localObject, false, -1);
          i = 6;
        }
        QLog.w("AVGameUtils", 1, "请求相机权限, which[" + i + "], openSuccess[" + bool1 + "]");
        return;
      }
      label497:
      j = 0;
      label540:
      label581:
      label623:
      bool1 = false;
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    return (lzq.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR")) || (lzq.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (lzq.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (lzq.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhs
 * JD-Core Version:    0.7.0.1
 */