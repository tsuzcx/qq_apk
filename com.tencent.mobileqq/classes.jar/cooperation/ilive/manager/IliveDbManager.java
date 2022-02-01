package cooperation.ilive.manager;

import MQQ.QqLiveMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bluv;
import blvm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class IliveDbManager
{
  public static final String KEY_DRAWER_PLUS_TEXT = "drawer_plus_text";
  public static final String KEY_DRAWER_SHOP_JUMP_SCHEME = "drawer_shop_jump_scheme";
  public static final String KEY_DRAWER_TRACE_INFO = "drawer_trace_info";
  public static final String KEY_IS_QQ_Live_PGC = "is_show_anchor_entrance";
  public static final String KEY_IS_SHOW_SHOP = "is_show_shop";
  public static final String KEY_PLUGIN_LAST_USE_DATA = "ilive_plugin_last_use";
  public static final String KEY_PLUGIN_NEW_DATA = "ilive_plugin_new_data";
  public static final String KEY_SHOP_PIC_URL = "key_shop_pic_url";
  public static final String KEY_SHOP_TITLE = "key_shop_title";
  public static final String SP_TABLE_QQ_Live_PGC = "qq_vas_ilive";
  private static final String TAG = "IliveFileDbManager";
  public static final int TYPE_PLUGIN_LAST_USE_DATA = 2;
  public static final int TYPE_PLUGIN_NEW_DATA = 1;
  public static final int TYPE_SHOP_ICON = 2;
  public static final int TYPE_SHOP_TITLE = 1;
  public static final int TYPE_SWITCH_LIVE_ENTRANCE = 1;
  public static final int TYPE_SWITCH_QQ_SHOW_SHOP = 2;
  
  private static String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("IliveFileDbManager", 4, "getCurrentUin = " + localAppRuntime.getAccount());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static String getILiveEnterInfo(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).getString(str, "");
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "get sp key:" + str + " value = " + (String)localObject);
      }
      return localObject;
      str = "key_shop_title";
      continue;
      str = "key_shop_pic_url";
    }
  }
  
  public static bluv getIliveConfigBean(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).getString(str, "");
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "getIliveConfigBean get sp key:" + str + " json value = " + (String)localObject);
      }
      return bluv.a((String)localObject);
      str = "ilive_plugin_new_data";
      continue;
      str = "ilive_plugin_last_use";
    }
  }
  
  public static String getIliveDrawerData(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    paramString = paramString + "_" + getCurrentUin();
    localObject = ((SharedPreferences)localObject).getString(paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("IliveFileDbManager", 1, "getIliveDrawerData sp key:" + paramString + " value = " + (String)localObject);
    }
    return localObject;
  }
  
  public static int getIliveSwitch(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      str = str + "_" + getCurrentUin();
      paramInt = localSharedPreferences.getInt(str, 0);
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "get sp key:" + str + " value = " + paramInt);
      }
      return paramInt;
      str = "is_show_anchor_entrance";
      continue;
      str = "is_show_shop";
    }
  }
  
  public static boolean saveIliveConfigBean(int paramInt, bluv parambluv)
  {
    if (parambluv == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      parambluv = bluv.a(parambluv);
      boolean bool = localSharedPreferences.edit().putString(str, parambluv).commit();
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "saveIliveConfigBean set sp key:" + str + " json value = " + parambluv);
      }
      return bool;
      str = "ilive_plugin_new_data";
      continue;
      str = "ilive_plugin_last_use";
    }
  }
  
  public static void saveIliveData(int paramInt, QqLiveMsg paramQqLiveMsg)
  {
    QLog.i("IliveFileDbManager", 1, "saveIliveData isQQLivePgc = " + paramInt + " qqLiveMsg = " + paramQqLiveMsg);
    saveIliveSwitch(1, paramInt);
    if ((paramQqLiveMsg != null) || ((paramQqLiveMsg != null) && (!TextUtils.isEmpty(paramQqLiveMsg.anchorUrl)) && (!TextUtils.isEmpty(paramQqLiveMsg.viewerUrl))))
    {
      saveIliveSwitch(2, paramQqLiveMsg.isShopEntrance);
      saveIlivePluginConfig(paramQqLiveMsg);
      IlivePreDownloadManager.getInstance().preloadPluginConfig(paramQqLiveMsg.isPreload);
    }
    if (paramQqLiveMsg != null)
    {
      saveIliveDrawerData("drawer_plus_text", paramQqLiveMsg.plus_text);
      saveIliveDrawerData("drawer_shop_jump_scheme", paramQqLiveMsg.recomm_room_schema);
      saveIliveDrawerShoppingInfo(paramQqLiveMsg);
    }
  }
  
  public static boolean saveIliveDrawerData(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    paramString1 = paramString1 + "_" + getCurrentUin();
    boolean bool = localSharedPreferences.edit().putString(paramString1, paramString2).commit();
    if (QLog.isColorLevel()) {
      QLog.d("IliveFileDbManager", 1, "saveIliveDrawerData sp key:" + paramString1 + " value = " + paramString2);
    }
    return bool;
  }
  
  private static boolean saveIliveDrawerShoppingInfo(QqLiveMsg paramQqLiveMsg)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4).edit();
    if (TextUtils.isEmpty(paramQqLiveMsg.ShopText))
    {
      str = "";
      localEditor.putString("key_shop_title", str);
      if (!TextUtils.isEmpty(paramQqLiveMsg.ShopPicUrl)) {
        break label124;
      }
    }
    label124:
    for (String str = "";; str = paramQqLiveMsg.ShopPicUrl)
    {
      localEditor.putString("key_shop_pic_url", str);
      boolean bool = localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "set sp key:shop_drawer_enter value = " + paramQqLiveMsg.ShopText + "  " + paramQqLiveMsg.ShopPicUrl);
      }
      return bool;
      str = paramQqLiveMsg.ShopText;
      break;
    }
  }
  
  private static void saveIlivePluginConfig(QqLiveMsg paramQqLiveMsg)
  {
    if (paramQqLiveMsg == null) {
      return;
    }
    bluv localbluv = new bluv();
    localbluv.jdField_a_of_type_Boolean = blvm.c();
    localbluv.c = paramQqLiveMsg.anchorUrl;
    localbluv.d = paramQqLiveMsg.anchorUrlMd5;
    localbluv.jdField_a_of_type_JavaLangString = paramQqLiveMsg.viewerUrl;
    localbluv.b = paramQqLiveMsg.viewerUrlMd5;
    QLog.e("IliveFileDbManager", 1, "saveIlivePluginConfig anchorMd5 = " + localbluv.d + " mWatchPluginMd5 = " + localbluv.b);
    saveIliveConfigBean(1, localbluv);
  }
  
  public static boolean saveIliveSwitch(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      str = str + "_" + getCurrentUin();
      boolean bool = localSharedPreferences.edit().putInt(str, paramInt2).commit();
      if (QLog.isColorLevel()) {
        QLog.d("IliveFileDbManager", 1, "set sp key:" + str + " value = " + paramInt2);
      }
      return bool;
      str = "is_show_anchor_entrance";
      continue;
      str = "is_show_shop";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.manager.IliveDbManager
 * JD-Core Version:    0.7.0.1
 */