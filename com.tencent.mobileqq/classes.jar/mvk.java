import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class mvk
{
  static int jdField_a_of_type_Int = -1;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  public static final mvl a;
  public static boolean a;
  public static int b;
  private static Boolean b;
  public static int c;
  private static Boolean c;
  
  static
  {
    jdField_a_of_type_Mvl = new mvl();
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  public static float a(TextView paramTextView)
  {
    return paramTextView.getPaint().measureText((String)paramTextView.getText());
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int == -1)
    {
      jdField_a_of_type_Int = a("8.4.10");
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = 660;
      }
    }
    return jdField_a_of_type_Int;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 3000: 
      return 1;
    }
    return 10;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int a(String paramString)
  {
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramString.split("\\.");
        if (arrayOfString.length > 0)
        {
          j = Integer.valueOf(arrayOfString[0]).intValue() * 10000 + 0;
          int i = j;
          if (arrayOfString.length > 1) {
            i = j + Integer.valueOf(arrayOfString[1]).intValue() * 100;
          }
          j = i;
          if (arrayOfString.length > 2)
          {
            j = Integer.valueOf(arrayOfString[2]).intValue();
            j = i + j;
          }
          return j;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("UITools", 1, "strVersionToInt, Exception, version[" + paramString + "]", localException);
        }
        return 0;
      }
      int j = 0;
    }
  }
  
  public static SharedPreferences a(VideoAppInterface paramVideoAppInterface)
  {
    return paramVideoAppInterface.getApp().getSharedPreferences(paramVideoAppInterface.getCurrentAccountUin() + "qav_SP", 0);
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = ((BitmapDrawable)paramContext.getResources().getDrawable(paramInt)).getBitmap();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, String paramString, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap localBitmap;
    try
    {
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = paramBitmap;
      if (localBitmap == null) {
        break label190;
      }
      localObject = new Canvas(localBitmap);
      if (((Canvas)localObject).getDensity() != paramBitmap.getDensity()) {
        ((Canvas)localObject).setDensity(paramBitmap.getDensity());
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setColor(Color.parseColor(paramString));
      paramString = new RectF(0.0F, 0.0F, i, j);
      if (paramBoolean) {
        ((Canvas)localObject).drawRoundRect(paramString, i / 2, j / 2, localPaint);
      } else {
        ((Canvas)localObject).drawRect(paramString, localPaint);
      }
    }
    catch (OutOfMemoryError paramString)
    {
      localObject = paramBitmap;
      if (!QLog.isColorLevel()) {
        break label190;
      }
    }
    QLog.d("UITools", 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(paramString));
    return paramBitmap;
    Object localObject = localBitmap;
    label190:
    return localObject;
  }
  
  public static Drawable a(float paramFloat, Context paramContext)
  {
    int i = AIOUtils.dp2px(paramFloat, paramContext.getResources());
    paramContext = new GradientDrawable();
    paramContext.setShape(1);
    paramContext.setColor(Color.parseColor("#4C000000"));
    paramContext.setSize(i, i);
    return paramContext;
  }
  
  public static String a(long paramLong)
  {
    String str = "00:00";
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      l1 = paramLong % 60L;
      l2 = paramLong / 60L;
      paramLong = l2 / 60L;
      l2 %= 60L;
      if (paramLong > 0L) {
        str = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l1) });
      }
    }
    else
    {
      return str;
    }
    return String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
  }
  
  public static String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString)) {
      localObject2 = localObject1;
    }
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return localObject2;
              Object localObject3 = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject3 = ((Card)localObject3).getCardInfo();
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  localObject1 = localObject2;
                  if (!((BusinessCard)localObject3).mobilesNum.isEmpty()) {
                    localObject1 = (String)((BusinessCard)localObject3).mobilesNum.get(0);
                  }
                }
              }
              localObject2 = localObject1;
            } while (!TextUtils.isEmpty((CharSequence)localObject1));
            paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
            localObject2 = localObject1;
          } while (paramQQAppInterface == null);
          i = paramQQAppInterface.d();
          if ((i == 9) || (i == 8) || (i == 4)) {
            break;
          }
          localObject2 = localObject1;
        } while (i != 2);
        localObject2 = localObject1;
      } while (!paramQQAppInterface.m());
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      localObject2 = localObject1;
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.mobileNo;
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    String str = anvx.a(2131715226);
    String[] arrayOfString = paramString.split(":");
    int k;
    int i;
    if (arrayOfString.length == 3)
    {
      k = Integer.valueOf(arrayOfString[0]).intValue();
      j = Integer.valueOf(arrayOfString[1]).intValue();
      i = Integer.valueOf(arrayOfString[2]).intValue();
    }
    for (;;)
    {
      if ((k > 0) || (j > 0) || (i > 0))
      {
        paramString = str;
        if (k > 0) {
          paramString = str + k + anvx.a(2131715224);
        }
        str = paramString;
        if (j > 0) {
          str = paramString + j + anvx.a(2131715223);
        }
        paramString = str;
        if (i > 0) {
          paramString = str + i + anvx.a(2131715222);
        }
        return paramString;
        if (arrayOfString.length == 2)
        {
          j = Integer.valueOf(arrayOfString[0]).intValue();
          i = Integer.valueOf(arrayOfString[1]).intValue();
          k = 0;
        }
      }
      else
      {
        return str + paramString;
      }
      i = 0;
      k = 0;
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaLangBoolean = new Boolean(false);
    bhhr.a(BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).edit().putBoolean("has_show_svip_dialog", false));
  }
  
  public static void a(int paramInt)
  {
    String str;
    if (paramInt == 1)
    {
      str = "grid_enable_switch";
      if (paramInt != 1) {
        break label50;
      }
      jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      bhhr.a(BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).edit().putInt(str, 0));
      return;
      str = "slide_enable_switch";
      break;
      label50:
      jdField_c_of_type_Int = 0;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (lzr.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    label667:
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
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException3);
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
        if (lzr.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
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
          break label498;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException4);
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
        if (lzr.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
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
          break label541;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException5);
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
          break label582;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException6);
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
          break label624;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException1);
        i = 4;
        bool2 = false;
        continue;
        bool1 = bool2;
        continue;
      }
      if ((!bool2) && (lzr.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
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
            break label667;
          }
          QLog.e("UITools", 2, "openPermissionActivity e = " + localException2);
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
        QLog.w("UITools", 1, "请求相机权限, which[" + i + "], openSuccess[" + bool1 + "]");
        return;
      }
      label498:
      j = 0;
      label541:
      label582:
      label624:
      bool1 = false;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = bhhr.a(paramContext);
      SharedPreferences.Editor localEditor = paramContext.edit();
      localEditor.putBoolean("qav_random_speakeron", false);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "qav_random_speakeron:" + paramContext.getBoolean("qav_random_speakeron", false));
      }
    }
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UITools", 2, "SetAccText: " + paramString);
      }
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    paramView.setFocusable(true);
    paramView.setContentDescription(paramString);
  }
  
  public static void a(View paramView, String paramString, int paramInt)
  {
    if (jdField_a_of_type_Boolean)
    {
      String str = paramString;
      if (paramInt == 2) {
        str = paramString.replace(paramView.getResources().getString(2131695116), anvx.a(2131715225));
      }
      if (QLog.isColorLevel()) {
        QLog.i("UITools", 2, "SetAccText with avtype:" + str + " avtype:" + paramInt);
      }
      paramView.setFocusable(true);
      paramView.setContentDescription(str);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = a(paramVideoAppInterface).edit();
    paramVideoAppInterface.putBoolean("qav_UserGuide_for_voiceSticker", false);
    paramVideoAppInterface.commit();
  }
  
  public static void a(String paramString)
  {
    a(paramString, lbz.a().a().d);
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UITools", 2, String.format("doScreenShareReport, tag[%s], fromType[%s]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    bdla.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor;
    if (paramBoolean)
    {
      jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
      localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).edit();
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (String str = "press_speak_first_guider";; str = "press_speak_second_guider")
    {
      bhhr.a(localEditor.putBoolean(str, true));
      return;
      jdField_c_of_type_JavaLangBoolean = Boolean.valueOf(true);
      break;
    }
  }
  
  public static boolean a()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2")) {
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
        return false;
      }
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 1)
    {
      if (jdField_b_of_type_Int == -1) {
        jdField_b_of_type_Int = BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).getInt("grid_enable_switch", 1);
      }
      if (jdField_b_of_type_Int != 1) {}
    }
    do
    {
      return true;
      return false;
      if (jdField_c_of_type_Int == -1) {
        jdField_c_of_type_Int = BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).getInt("slide_enable_switch", 1);
      }
    } while (jdField_c_of_type_Int == 1);
    return false;
  }
  
  public static boolean a(Activity paramActivity)
  {
    return (lzr.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR")) || (lzr.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (lzr.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (lzr.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.a(0) == 1) {
      return true;
    }
    return a(paramVideoAppInterface).getBoolean("qav_UserGuide_for_voiceSticker", true);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    String str = paramString1;
    if (paramString1.startsWith("+")) {
      str = paramString1.substring(1);
    }
    paramString1 = paramString2;
    if (paramString2.startsWith("+")) {
      paramString1 = paramString2.substring(1);
    }
    return str.equals(paramString1);
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jdField_b_of_type_JavaLangBoolean == null) {
        jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).getBoolean("press_speak_first_guider", false));
      }
      return jdField_b_of_type_JavaLangBoolean.booleanValue();
    }
    if (jdField_c_of_type_JavaLangBoolean == null) {
      jdField_c_of_type_JavaLangBoolean = Boolean.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).getBoolean("press_speak_second_guider", false));
    }
    return jdField_c_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static float b(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 3;
    case 3000: 
      return 2;
    case 1: 
      return 1;
    }
    return 7;
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static boolean b()
  {
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      jdField_a_of_type_JavaLangBoolean = new Boolean(false);
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("UITools", 4).getBoolean("has_show_svip_dialog", true));
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static int c(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    default: 
      i = -1;
    case 1: 
    case 10: 
      return i;
    case 3: 
      return 0;
    case 2: 
      return 3000;
    }
    return 1011;
  }
  
  public static int d(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      i = 3;
    case 3: 
    case 100: 
      return i;
    case 4: 
      return 4;
    case 2: 
      return 2;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mvk
 * JD-Core Version:    0.7.0.1
 */