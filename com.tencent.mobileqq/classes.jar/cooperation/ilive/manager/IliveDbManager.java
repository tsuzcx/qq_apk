package cooperation.ilive.manager;

import MQQ.QqLiveMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveConfigBean;
import cooperation.ilive.util.IliveEntranceUtil;
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
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentUin = ");
        localStringBuilder.append(localAppRuntime.getAccount());
        QLog.i("IliveFileDbManager", 4, localStringBuilder.toString());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static String getILiveEnterInfo(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        str = "";
      } else {
        str = "key_shop_pic_url";
      }
    }
    else {
      str = "key_shop_title";
    }
    localObject = ((SharedPreferences)localObject).getString(str, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get sp key:");
      localStringBuilder.append(str);
      localStringBuilder.append(" value = ");
      localStringBuilder.append((String)localObject);
      QLog.d("IliveFileDbManager", 1, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static IliveConfigBean getIliveConfigBean(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        str = "";
      } else {
        str = "ilive_plugin_last_use";
      }
    }
    else {
      str = "ilive_plugin_new_data";
    }
    localObject = ((SharedPreferences)localObject).getString(str, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIliveConfigBean get sp key:");
      localStringBuilder.append(str);
      localStringBuilder.append(" json value = ");
      localStringBuilder.append((String)localObject);
      QLog.d("IliveFileDbManager", 1, localStringBuilder.toString());
    }
    return IliveConfigBean.a((String)localObject);
  }
  
  public static String getIliveDrawerData(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(getCurrentUin());
    paramString = localStringBuilder.toString();
    localObject = ((SharedPreferences)localObject).getString(paramString, "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIliveDrawerData sp key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" value = ");
      localStringBuilder.append((String)localObject);
      QLog.d("IliveFileDbManager", 1, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static int getIliveSwitch(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        str = "";
      } else {
        str = "is_show_shop";
      }
    }
    else {
      str = "is_show_anchor_entrance";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(getCurrentUin());
    String str = localStringBuilder.toString();
    paramInt = ((SharedPreferences)localObject).getInt(str, 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get sp key:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" value = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("IliveFileDbManager", 1, ((StringBuilder)localObject).toString());
    }
    return paramInt;
  }
  
  public static boolean saveIliveConfigBean(int paramInt, IliveConfigBean paramIliveConfigBean)
  {
    if (paramIliveConfigBean == null) {
      return false;
    }
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        str = "";
      } else {
        str = "ilive_plugin_last_use";
      }
    }
    else {
      str = "ilive_plugin_new_data";
    }
    paramIliveConfigBean = IliveConfigBean.a(paramIliveConfigBean);
    boolean bool = ((SharedPreferences)localObject).edit().putString(str, paramIliveConfigBean).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveIliveConfigBean set sp key:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" json value = ");
      ((StringBuilder)localObject).append(paramIliveConfigBean);
      QLog.d("IliveFileDbManager", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static void saveIliveData(int paramInt, QqLiveMsg paramQqLiveMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveIliveData isQQLivePgc = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" qqLiveMsg = ");
    localStringBuilder.append(paramQqLiveMsg);
    QLog.i("IliveFileDbManager", 1, localStringBuilder.toString());
    saveIliveSwitch(1, paramInt);
    if ((paramQqLiveMsg != null) && (!TextUtils.isEmpty(paramQqLiveMsg.anchorUrl)) && (!TextUtils.isEmpty(paramQqLiveMsg.viewerUrl)))
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
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(getCurrentUin());
    paramString1 = localStringBuilder.toString();
    boolean bool = ((SharedPreferences)localObject).edit().putString(paramString1, paramString2).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveIliveDrawerData sp key:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" value = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("IliveFileDbManager", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private static boolean saveIliveDrawerShoppingInfo(QqLiveMsg paramQqLiveMsg)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4).edit();
    boolean bool = TextUtils.isEmpty(paramQqLiveMsg.ShopText);
    String str = "";
    Object localObject;
    if (bool) {
      localObject = "";
    } else {
      localObject = paramQqLiveMsg.ShopText;
    }
    localEditor.putString("key_shop_title", (String)localObject);
    if (TextUtils.isEmpty(paramQqLiveMsg.ShopPicUrl)) {
      localObject = str;
    } else {
      localObject = paramQqLiveMsg.ShopPicUrl;
    }
    localEditor.putString("key_shop_pic_url", (String)localObject);
    bool = localEditor.commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set sp key:shop_drawer_enter value = ");
      ((StringBuilder)localObject).append(paramQqLiveMsg.ShopText);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramQqLiveMsg.ShopPicUrl);
      QLog.d("IliveFileDbManager", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private static void saveIlivePluginConfig(QqLiveMsg paramQqLiveMsg)
  {
    if (paramQqLiveMsg == null) {
      return;
    }
    IliveConfigBean localIliveConfigBean = new IliveConfigBean();
    localIliveConfigBean.a = IliveEntranceUtil.c();
    localIliveConfigBean.d = paramQqLiveMsg.anchorUrl;
    localIliveConfigBean.e = paramQqLiveMsg.anchorUrlMd5;
    localIliveConfigBean.b = paramQqLiveMsg.viewerUrl;
    localIliveConfigBean.c = paramQqLiveMsg.viewerUrlMd5;
    paramQqLiveMsg = new StringBuilder();
    paramQqLiveMsg.append("saveIlivePluginConfig anchorMd5 = ");
    paramQqLiveMsg.append(localIliveConfigBean.e);
    paramQqLiveMsg.append(" mWatchPluginMd5 = ");
    paramQqLiveMsg.append(localIliveConfigBean.c);
    QLog.e("IliveFileDbManager", 1, paramQqLiveMsg.toString());
    saveIliveConfigBean(1, localIliveConfigBean);
  }
  
  public static boolean saveIliveSwitch(int paramInt1, int paramInt2)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_vas_ilive", 4);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        str = "";
      } else {
        str = "is_show_shop";
      }
    }
    else {
      str = "is_show_anchor_entrance";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(getCurrentUin());
    String str = localStringBuilder.toString();
    boolean bool = ((SharedPreferences)localObject).edit().putInt(str, paramInt2).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set sp key:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" value = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("IliveFileDbManager", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.manager.IliveDbManager
 * JD-Core Version:    0.7.0.1
 */