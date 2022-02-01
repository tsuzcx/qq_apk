package cooperation.qqfav;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public final class QfavHelper
  implements Consts
{
  private static final AtomicBoolean a = new AtomicBoolean(false);
  private static SharedPreferences b;
  
  public static SharedPreferences a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = paramContext.getSharedPreferences("shared_prefs_qfav", 4);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static FileManagerEntity a(Bundle paramBundle, String paramString, int paramInt)
  {
    if (paramBundle == null) {
      return null;
    }
    String str1 = paramBundle.getString("key_fav_file_forward_cid");
    String str2 = paramBundle.getString("key_fav_file_forward_uuid");
    byte[] arrayOfByte = paramBundle.getByteArray("key_fav_file_forward_md5");
    String str3 = paramBundle.getString("key_fav_file_forward_name");
    long l = paramBundle.getLong("key_fav_file_forward_file_size", 0L);
    paramBundle = paramBundle.getString("forward_filepath");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      if (arrayOfByte == null) {
        return null;
      }
      return FileManagerUtil.a(str1, str2, paramBundle, str3, l, HexUtil.bytes2HexStr(arrayOfByte), paramString, paramInt);
    }
    return null;
  }
  
  public static FileManagerEntity a(FavFileInfo paramFavFileInfo, String paramString, int paramInt)
  {
    if (paramFavFileInfo == null) {
      return null;
    }
    String str1 = paramFavFileInfo.b;
    String str2 = paramFavFileInfo.c;
    String str3 = paramFavFileInfo.d;
    long l = paramFavFileInfo.f;
    String str4 = paramFavFileInfo.h;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      if (paramFavFileInfo.t == null) {
        return null;
      }
      return FileManagerUtil.a(str1, str2, str4, str3, l, paramFavFileInfo.t, paramString, paramInt);
    }
    return null;
  }
  
  public static ClassLoader a()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    Object localObject1 = null;
    try
    {
      localObject2 = PluginStatic.getOrCreateClassLoader((Context)localObject2, "qqfav.apk");
      localObject1 = localObject2;
      BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject2);
      return localObject2;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception =");
      localStringBuilder.append(QLog.getStackTraceString(localException));
      QLog.i("qqfavQfavHelper#getClassLoader", 1, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  public static Object a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      try
      {
        localObject = Class.forName(paramString);
      }
      catch (Exception paramString)
      {
        break label132;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      label12:
      StringBuilder localStringBuilder;
      label132:
      break label12;
    }
    localObject = a();
    if (localObject != null) {
      localObject = ((ClassLoader)localObject).loadClass(paramString);
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("className =");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",cls == null");
      QLog.i("qqfavQfavHelper#createInstance", 1, localStringBuilder.toString());
    }
    paramArrayOfClass = ((Class)localObject).getDeclaredConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
    if (paramArrayOfClass == null)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("className =");
      paramArrayOfObject.append(paramString);
      paramArrayOfObject.append(",retObj == null");
      QLog.i("qqfavQfavHelper#createInstance", 4, paramArrayOfObject.toString());
    }
    return paramArrayOfClass;
    paramArrayOfClass = new StringBuilder();
    paramArrayOfClass.append("Exception =");
    paramArrayOfClass.append(QLog.getStackTraceString(paramString));
    QLog.i("qqfavQfavHelper#createInstance", 1, paramArrayOfClass.toString());
    return null;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    return (AppRuntime)a("com.qqfav.QfavAppInterface", new Class[] { BaseApplicationImpl.class, String.class }, new Object[] { paramBaseApplicationImpl, "qqfav" });
  }
  
  public static void a(Context paramContext, FavFileInfo paramFavFileInfo, int paramInt)
  {
    paramContext = new Bundle();
    paramContext.putLong("download_fav_id", paramFavFileInfo.a);
    paramContext.putInt("thumb_format", paramInt);
    QfavPluginProxyService.a().a("com.tencent.qqfav", 3, paramContext);
  }
  
  public static void a(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getApplication();
    }
    try
    {
      new QfavHelper.4((Context)localObject, paramOnPluginInstallListener).start();
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      if (paramOnPluginInstallListener != null) {
        try
        {
          paramOnPluginInstallListener.onInstallError("qqfav.apk", -1);
          return;
        }
        catch (RemoteException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramBoolean1, paramString2, paramBoolean2, 2131889172);
  }
  
  @TargetApi(9)
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    QQToast localQQToast = new QQToast(paramContext);
    localQQToast.setDuration(2000);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    Object localObject;
    if (paramBoolean1)
    {
      localQQToast.setType(2);
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      localQQToast.setToastMsg(paramInt);
      paramString2 = a(paramContext);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pref_first_collection_");
      ((StringBuilder)localObject).append(paramString1);
      if (!paramString2.getBoolean(((StringBuilder)localObject).toString(), true)) {
        break label676;
      }
    }
    try
    {
      localObject = paramContext.getString(2131889217);
      if (paramBoolean2) {
        paramString2 = paramContext.getString(2131889211);
      } else {
        paramString2 = paramContext.getString(2131889216);
      }
      paramString2 = DialogUtil.a(paramContext, 230, (String)localObject, paramString2, 2131887648, 2131889215, new QfavHelper.1(), null);
      if (paramContext != BaseApplicationImpl.getContext()) {
        break label719;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (Build.VERSION.SDK_INT >= 26)
        {
          paramString2.getWindow().setType(2038);
        }
        else if (Build.VERSION.SDK_INT > 24)
        {
          paramString2.getWindow().setType(2003);
        }
        else
        {
          paramString2.getWindow().setType(2005);
          break label719;
        }
      }
      else {
        paramString2.getWindow().setType(2003);
      }
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        label676:
        continue;
        paramInt = 1;
        continue;
        paramInt = 0;
        continue;
        int i = 1;
      }
    }
    if ((paramInt != 0) && (Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(paramContext)))
    {
      i = 0;
      if ((paramInt != 0) && (i == 0))
      {
        paramString2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        paramString2.addFlags(268435456);
        BaseApplicationImpl.getApplication().startActivity(paramString2);
      }
      else
      {
        paramString2.setMessageCount(null).show();
        if (9 > Build.VERSION.SDK_INT)
        {
          paramString2 = a(paramContext).edit();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("pref_first_collection_");
          ((StringBuilder)localObject).append(paramString1);
          paramString2.putBoolean(((StringBuilder)localObject).toString(), false).commit();
        }
        else
        {
          paramString2 = a(paramContext).edit();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("pref_first_collection_");
          ((StringBuilder)localObject).append(paramString1);
          paramString2.putBoolean(((StringBuilder)localObject).toString(), false).apply();
        }
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("First collection guide shown. Uin=");
          paramString2.append(MsfSdkUtils.getShortUin(paramString1));
          paramString2.append(", flag=");
          localObject = a(paramContext);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("pref_first_collection_");
          localStringBuilder.append(paramString1);
          paramString2.append(((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true));
          QLog.d("qqfav", 2, paramString2.toString());
          break label676;
          paramString2 = new StringBuilder();
          paramString2.append("First collection guide error. Uin=");
          paramString2.append(MsfSdkUtils.getShortUin(paramString1));
          paramString2.append(", flag=");
          localObject = a(paramContext);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("pref_first_collection_");
          localStringBuilder.append(paramString1);
          paramString2.append(((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true));
          QLog.e("qqfav", 1, paramString2.toString());
          break label676;
          localQQToast.setType(1);
          localQQToast.setToastIcon(QQToast.getIconRes(1));
          if (paramString2 == null) {
            localQQToast.setToastMsg(2131889173);
          } else {
            localQQToast.setToastMsg(paramString2);
          }
        }
      }
      localQQToast.show(paramContext.getResources().getDimensionPixelSize(2131299920) - (int)(paramContext.getResources().getDisplayMetrics().density * 5.0F));
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<FavFileInfo> paramList, String paramString, int paramInt)
  {
    if (paramList != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FavFileInfo localFavFileInfo = (FavFileInfo)paramList.next();
        FileManagerEntity localFileManagerEntity = a(localFavFileInfo, paramString, paramInt);
        if (localFileManagerEntity == null) {
          return;
        }
        localFileManagerEntity.strThumbPath = localFavFileInfo.a();
        localFileManagerEntity.strMiddleThumPath = localFavFileInfo.l;
        localFileManagerEntity.strLargeThumPath = localFavFileInfo.n;
        paramQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, paramString, paramInt, 0);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavNeedReupload", i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppRuntime.getAccount());
    localStringBuilder.append("QfavNeedReupload");
    if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "reuploadQfavItems: flag=true");
      }
      localObject = new Intent("com.tencent.mobileqq.ACTION_QFAVIPC_BROADCAST");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("nOperation", 5);
      QfavPluginProxyReceiver.a(paramAppRuntime, (Intent)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "reuploadQfavItems: flag=false");
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 3);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 7);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    paramIntent.setFlags(paramIntent.getFlags() & 0xFBFFFFFF & 0xDFFFFFFF);
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if (paramIntent == null) {
      paramIntent = new Intent();
    } else {
      paramIntent = new Intent(paramIntent);
    }
    paramIntent.putExtra("nOperation", 2);
    paramIntent.putExtra("bShowProgress", paramBoolean);
    paramIntent.putExtra("begin", System.currentTimeMillis());
    QfavUtil.a(paramString);
    if (!QfavRequestQueue.a().b())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openPluginActivityForResult need pending data.");
        ((StringBuilder)localObject).append(paramIntent.toString());
        QLog.d("qqfav", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = QfavRequestQueue.a().c();
      if ((localObject == null) && (QLog.isColorLevel())) {
        QLog.d("qqfav", 2, "openPluginActivityForResult pending data error.");
      }
      paramIntent.putExtra("pendingData", (byte[])localObject);
    }
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static boolean a(Context paramContext, long paramLong, Boolean paramBoolean, Bundle paramBundle)
  {
    QfavPluginProxyService.c();
    paramContext = paramBundle;
    if (paramBundle == null) {
      paramContext = new Bundle();
    }
    paramContext.putLong("reqTimestamp", paramLong);
    paramContext.putBoolean("localEnd", paramBoolean.booleanValue());
    QfavPluginProxyService.a().a("com.tencent.qqfav", 2, paramContext);
    return true;
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle)
  {
    QfavPluginProxyService.c();
    paramContext = paramBundle;
    if (paramBundle == null) {
      paramContext = new Bundle();
    }
    paramContext.putBoolean("bool_refresh_list", true);
    QfavPluginProxyService.a().a("com.tencent.qqfav", 2, paramContext);
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("lId", paramLong);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 9);
    localIntent.putExtra("lId", paramLong1);
    localIntent.putExtra("custom_fav_id", paramLong1);
    localIntent.putExtra("moveToGroupAction", true);
    localIntent.putExtra("custom_group_id", paramLong2);
    localIntent.putExtra("mov_to_group", true);
    localIntent.putExtra("custom_without_callback", true);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("lId", paramLong);
    localIntent.putExtra("backUpFavData", paramArrayOfByte);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong, long[] paramArrayOfLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("imagefilepre", true);
    localIntent.putExtra("lId", paramLong);
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0)) {
      localIntent.putExtra("imagefileids", paramArrayOfLong);
    }
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    return (paramChatMessage != null) && ((QQMapConstants.c.equals(paramChatMessage.ark_app_message.appName)) || ("com.tencent.structmsg".equals(paramChatMessage.ark_app_message.appName)) || ("com.tencent.miniapp_01".equals(paramChatMessage.ark_app_message.appName)));
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (a.get()) {
      return true;
    }
    Object localObject2 = new QfavHelper.2();
    if (paramBoolean) {
      ??? = a;
    }
    synchronized (localObject2)
    {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new QfavHelper.3((Runnable)localObject2));
      localObject2 = a;
      if (??? == localObject2) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("qqfav", 2, "wait(IS_PLUGININSTALLED) qqfav.apk");
          }
          a.wait(5000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("qqfav.apk, IS_PLUGININSTALLED = ");
        ((StringBuilder)???).append(a);
        QLog.i("qqfav", 2, ((StringBuilder)???).toString());
      }
      return a.get();
    }
  }
  
  public static boolean b()
  {
    return a.get();
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":qqfav"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 11);
    localIntent.putExtra("lId", paramLong);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static byte[] b(boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("bPublicAccount", paramBoolean);
      localObject = ((JSONObject)localObject).toString().getBytes();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      label27:
      break label27;
    }
    QLog.i("qqfav", 2, "publicAccountLinkBizData: JSONException error");
    return null;
  }
  
  public static ArrayList<byte[]> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("isLongVideo", true);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localObject = ((JSONObject)localObject).toString().getBytes();
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper
 * JD-Core Version:    0.7.0.1
 */