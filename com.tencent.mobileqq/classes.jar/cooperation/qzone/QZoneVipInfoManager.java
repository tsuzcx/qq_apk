package cooperation.qzone;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import amme;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bdla;
import bheh;
import bhey;
import blrb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QZoneVipInfoManager
{
  private static final String KEY_VIP_INFO_PRE = "key_vip_info_pre";
  public static final String SP_NAME = "QZONE_VIP_INFO";
  public static final String TAG = "QZoneVipInfoManager";
  private static Object lock = new Object();
  private static QZoneVipInfoManager mInstance;
  private String mCustomDimanondUrl;
  private volatile boolean mIsCurrentProcessWrite;
  private int mOwnerBitMap = -1;
  private String mPersonalizedYellowVipUrl;
  private SharedPreferences mSharedPreference;
  
  private QZoneVipInfoManager()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      this.mSharedPreference = localBaseApplicationImpl.getSharedPreferences("QZONE_VIP_INFO", i);
      if (this.mSharedPreference != null) {
        this.mSharedPreference.registerOnSharedPreferenceChangeListener(new QZoneVipInfoManager.1(this));
      }
      return;
    }
  }
  
  public static void cmJumpToYellowPlayDialog(Activity paramActivity, String paramString1, String paramString2)
  {
    jumpToYellowPayDialog(paramActivity, paramString1, paramString2, "cm", 2, 1);
  }
  
  private String generateBitMapKey(String paramString)
  {
    return "key_vip_info_bitmap_pre" + paramString;
  }
  
  private String generateCustomDiamondUrlKey(String paramString)
  {
    return "key_vip_info_custom_diamond_url_pre" + paramString;
  }
  
  private String generatePersonalizedVipKey(String paramString)
  {
    return "key_vip_info_personalized_vip_pre" + paramString;
  }
  
  public static int getComDiamondLevel(int paramInt)
  {
    return getVipBitMap(paramInt, 17, 20);
  }
  
  public static int getComDiamondType(int paramInt)
  {
    return getVipBitMap(paramInt, 14, 16);
  }
  
  public static QZoneVipInfoManager getInstance()
  {
    if (mInstance == null) {}
    synchronized (lock)
    {
      if (mInstance == null) {
        mInstance = new QZoneVipInfoManager();
      }
      return mInstance;
    }
  }
  
  public static int getLoveVipDiamondLevel(int paramInt)
  {
    return getVipBitMap(paramInt, 30, 30);
  }
  
  public static int getStarLevel(int paramInt)
  {
    return getVipBitMap(paramInt, 9, 12);
  }
  
  public static int getStarStatus(int paramInt)
  {
    return getVipBitMap(paramInt, 7, 8);
  }
  
  public static int getUnionVipLevel(int paramInt)
  {
    return getVipBitMap(paramInt, 26, 29);
  }
  
  private static int getVipBitMap(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt3 - paramInt2 + 1)
    {
    default: 
      paramInt3 = 0;
    }
    while (paramInt3 == 0)
    {
      return 0;
      paramInt3 = 1;
      continue;
      paramInt3 = 3;
      continue;
      paramInt3 = 7;
      continue;
      paramInt3 = 15;
    }
    return paramInt1 >> paramInt2 & paramInt3;
  }
  
  public static int getVipLevel(int paramInt)
  {
    return getVipBitMap(paramInt, 2, 5);
  }
  
  public static int getVipType(int paramInt)
  {
    return getVipBitMap(paramInt, 0, 1);
  }
  
  public static boolean isAnnualVip(int paramInt)
  {
    return getVipBitMap(paramInt, 6, 6) != 0;
  }
  
  public static boolean isAnnualVipEver(int paramInt)
  {
    return getVipBitMap(paramInt, 22, 22) != 0;
  }
  
  public static boolean isComDiamondAnnualVip(int paramInt)
  {
    return getVipBitMap(paramInt, 21, 21) != 0;
  }
  
  public static boolean isCustomDiamondUser(int paramInt)
  {
    return getVipBitMap(paramInt, 24, 24) != 0;
  }
  
  public static boolean isHighStarVip(int paramInt)
  {
    return getVipBitMap(paramInt, 23, 23) != 0;
  }
  
  public static boolean isStarAnnualVip(int paramInt)
  {
    return getVipBitMap(paramInt, 13, 13) != 0;
  }
  
  public static boolean isUnionVip(int paramInt)
  {
    return getVipBitMap(paramInt, 25, 25) != 0;
  }
  
  public static boolean jumpToH5(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("QZoneVipInfoManager", 1, "jumpToH5 activity = null or url = null , url = " + paramString);
      return false;
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
    paramActivity.startActivity(localIntent);
    return true;
  }
  
  public static void jumpToH5PreviewAction(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    String str = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPreviewPayUrl", "https://h5.qzone.qq.com/v2/vip/show/previewDialog?_wv=16781315&_wwv=13&actionId={actionId}&type={type}");
    if (URLUtil.isNetworkUrl(str)) {
      if (!str.contains("{actionId}")) {
        break label207;
      }
    }
    label207:
    for (paramString1 = str.replace("{actionId}", paramString1);; paramString1 = str)
    {
      str = paramString1;
      if (paramString1.contains("{type}")) {
        str = paramString1.replace("{type}", paramString2);
      }
      paramString1 = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
      paramString1.putExtra("url", str);
      paramString1.putExtra("hide_left_button", true);
      paramString1.putExtra("show_right_close_button", false);
      paramString1.putExtra("flag_show_loading_dialog", true);
      paramString1.putExtra("show_close_btn", false);
      paramString1.putExtra("finish_animation_none", true);
      paramString1.putExtra("fragmentStyle", 2);
      paramString1.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramActivity.startActivity(paramString1);
      return;
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break;
      }
      paramActivity = bhey.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramActivity, str);
      if (paramActivity != null)
      {
        paramActivity.a();
        return;
      }
      QLog.e("QZoneVipInfoManager", 1, "aio jumpToH5PreviewAction error jumpAction = null , url = " + str);
      return;
    }
  }
  
  public static void jumpToYellowPayDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Intent localIntent = new Intent();
    String str = paramActivity.getResources().getString(2131717535);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString2);
    localIntent.putExtra("source", paramString3);
    localIntent.putExtra("viptype", paramInt1);
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("month", paramInt2);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, -1, null, false, null, true);
  }
  
  private void loadFromSp()
  {
    loadFromSp(false);
  }
  
  private void loadFromSp(boolean paramBoolean)
  {
    if ((this.mOwnerBitMap >= 0) && (!paramBoolean)) {}
    AppRuntime localAppRuntime;
    do
    {
      do
      {
        return;
      } while (this.mSharedPreference == null);
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    this.mOwnerBitMap = this.mSharedPreference.getInt(generateBitMapKey(localAppRuntime.getAccount()), 0);
    this.mPersonalizedYellowVipUrl = this.mSharedPreference.getString(generatePersonalizedVipKey(localAppRuntime.getAccount()), null);
    this.mCustomDimanondUrl = this.mSharedPreference.getString(generateCustomDiamondUrlKey(localAppRuntime.getAccount()), null);
  }
  
  public static boolean onPetBrandClick(Activity paramActivity, int paramInt, String paramString)
  {
    QLog.d("QZoneVipInfoManager", 1, new Object[] { "onPetBrandClick petId = ", Integer.valueOf(paramInt) });
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    Object localObject1;
    int i;
    if ((localAppRuntime instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localAppRuntime;
      localObject1 = (amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
      localObject2 = ((amme)localObject1).a(paramInt);
      i = ((amme)localObject1).a((JSONObject)localObject2);
    }
    for (Object localObject2 = ((amme)localObject1).b((JSONObject)localObject2);; localObject2 = null)
    {
      int k;
      String str2;
      int j;
      String str1;
      if (paramString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
      {
        k = 0;
        str2 = "0";
        localObject1 = localObject2;
        j = k;
        str1 = str2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          switch (i)
          {
          default: 
            localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPetNameplateHostUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aiozhu");
            str1 = str2;
            j = k;
          }
        }
      }
      while (TextUtils.isEmpty((CharSequence)localObject1))
      {
        return false;
        localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetNameplateHostUrl", "mqqapi://miniapp/open?_atype=1&_mappid=1110761090&_mvid=&_vt=3&referer=2200&via=2016_70&_sig=3078374443&roleId=%7BroleId%7D");
        j = k;
        str1 = str2;
        continue;
        k = 1;
        str2 = "1";
        localObject1 = localObject2;
        j = k;
        str1 = str2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          switch (i)
          {
          default: 
            localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPetNameplateGuestUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aioke");
            j = k;
            str1 = str2;
            break;
          case 1: 
            localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetNameplateGuestUrl", "mqqapi://miniapp/open?_atype=1&_mappid=1110761090&_mvid=&_vt=3&referer=2200&via=2016_70&_sig=3078374443&roleId=%7BroleId%7D");
            j = k;
            str1 = str2;
          }
        }
      }
      localObject2 = localObject1;
      if (((String)localObject1).contains("{pet_id}")) {
        localObject2 = ((String)localObject1).replace("{pet_id}", String.valueOf(paramInt));
      }
      localObject1 = localObject2;
      if (((String)localObject2).contains("%7BroleId%7D")) {
        localObject1 = ((String)localObject2).replace("%7BroleId%7D", String.valueOf(paramInt));
      }
      localObject2 = localObject1;
      if (((String)localObject1).contains("{uin}")) {
        localObject2 = ((String)localObject1).replace("{uin}", paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVipInfoManager", 2, "onPetBrandClick petId = " + paramInt + " petCategory = " + i + " from = " + j + " reserve = " + str1 + " jumpUrl = " + (String)localObject2);
      }
      if (localQQAppInterface != null) {}
      for (paramString = bhey.a((QQAppInterface)localAppRuntime, paramActivity, (String)localObject2);; paramString = null)
      {
        boolean bool;
        if (paramString != null)
        {
          bool = paramString.a();
          bdla.b(null, "dc00898", "", "", "", "", j, 0, str1, "", "", "");
          if (!bool) {
            break label593;
          }
        }
        label593:
        for (paramActivity = "0";; paramActivity = "1")
        {
          blrb.a(localQQAppInterface, "3006", "aiopetpaiClick", String.valueOf(i), String.valueOf(paramInt), paramActivity, new String[] { String.valueOf(j) });
          return bool;
          bool = jumpToH5(paramActivity, (String)localObject2);
          break;
        }
      }
      localQQAppInterface = null;
      i = 0;
    }
  }
  
  public static boolean onPetClick(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVipInfoManager", 1, new Object[] { "onPetClick petId = ", Integer.valueOf(paramInt) });
    }
    if ((paramActivity == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("QZoneVipInfoManager", 1, "onPetClick error! activity = " + paramActivity + ", app = " + paramQQAppInterface + ", uin = " + paramString);
      return false;
    }
    Object localObject1 = (amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    Object localObject2 = ((amme)localObject1).a(paramInt);
    int j = ((amme)localObject1).a((JSONObject)localObject2);
    localObject1 = ((amme)localObject1).a((JSONObject)localObject2);
    String str;
    int i;
    if (paramString.equals(paramQQAppInterface.getAccount()))
    {
      str = "0";
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label564;
      }
      switch (j)
      {
      default: 
        localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIODefaultPetHostUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aiozhu");
        i = 0;
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("QZoneVipInfoManager", 1, "onPetClick error! jumpUrl is null!");
        return false;
        localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetHostUrl", "mqqapi://miniapp/open?_atype=1&_mappid=1110761090&_mvid=&_vt=3&referer=2200&via=2016_70&_sig=3078374443&roleId=%7BroleId%7D");
        i = 0;
        continue;
        str = "1";
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          switch (j)
          {
          default: 
            localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIODefaultPetGuestUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aioke");
            i = 1;
            break;
          case 1: 
            localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetGuestUrl", "mqqapi://miniapp/open?_atype=1&_mappid=1110761090&_mvid=&_vt=3&referer=2200&via=2016_70&_sig=3078374443&roleId=%7BroleId%7D");
            i = 1;
            break;
          }
        }
      }
      else
      {
        localObject2 = localObject1;
        if (((String)localObject1).contains("{pet_id}")) {
          localObject2 = ((String)localObject1).replace("{pet_id}", String.valueOf(paramInt));
        }
        localObject1 = localObject2;
        if (((String)localObject2).contains("%7BroleId%7D")) {
          localObject1 = ((String)localObject2).replace("%7BroleId%7D", String.valueOf(paramInt));
        }
        localObject2 = localObject1;
        if (((String)localObject1).contains("{uin}")) {
          localObject2 = ((String)localObject1).replace("{uin}", paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVipInfoManager", 2, "onPetClick petId = " + paramInt + " petCategory = " + j + " from = " + i + " reserve = " + str + " jumpUrl = " + (String)localObject2);
        }
        paramString = bhey.a(paramQQAppInterface, paramActivity, (String)localObject2);
        boolean bool;
        if (paramString != null)
        {
          bool = paramString.a();
          if (!bool) {
            break label551;
          }
        }
        label551:
        for (paramActivity = "0";; paramActivity = "1")
        {
          blrb.a(paramQQAppInterface, "3006", "aiopetClick", String.valueOf(j), String.valueOf(paramInt), paramActivity, new String[] { String.valueOf(i) });
          return bool;
          bool = jumpToH5(paramActivity, (String)localObject2);
          break;
        }
      }
      i = 1;
      continue;
      label564:
      i = 0;
    }
  }
  
  public static boolean onSuperYellowBrandClick(Activity paramActivity, String paramString)
  {
    QLog.d("QZoneVipInfoManager", 1, "onSuperYellowBrandClick");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = getInstance().getVipType() + 1;
    String str2;
    String str1;
    if (paramString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
    {
      str2 = "0";
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowQZSVIPNameplateHostUrl", "https://h5.qzone.qq.com/limishow/mall?_wv=131072&_fv=0&_wwv=128&_wvx=10&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMjEifQ%3D%3D");
      label63:
      if (TextUtils.isEmpty(str1)) {
        break label201;
      }
      if (!str1.contains("{uin}")) {
        break label203;
      }
    }
    label201:
    label203:
    for (paramString = str1.replace("{uin}", paramString);; paramString = str1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVipInfoManager", 2, "onSuperYellowBrandClick from = " + i + " reserve = " + str2 + " jumpUrl = " + paramString);
      }
      bdla.b(null, "dc00898", "", "", "", "", i, 0, str2, "", "", "");
      return jumpToH5(paramActivity, paramString);
      str2 = "1";
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowQZSVIPNameplateGuestUrl", "https://h5.qzone.qq.com/limishow/mall?_wv=131072&_fv=0&_wwv=128&_wvx=10&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMjEifQ%3D%3D");
      break label63;
      break;
    }
  }
  
  public static void preloadQZoneProcess(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnSubThread(new QZoneVipInfoManager.3(paramQQAppInterface));
  }
  
  public static void preloadToolProcess(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnSubThread(new QZoneVipInfoManager.2(paramQQAppInterface));
  }
  
  public static void preloadYellowPlayProcess(QQAppInterface paramQQAppInterface)
  {
    preloadQZoneProcess(paramQQAppInterface);
    preloadToolProcess(paramQQAppInterface);
  }
  
  private void saveToSp()
  {
    if (this.mSharedPreference != null)
    {
      SharedPreferences.Editor localEditor = this.mSharedPreference.edit();
      if (localEditor != null)
      {
        this.mIsCurrentProcessWrite = true;
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (localAppRuntime != null)
        {
          localEditor.putInt(generateBitMapKey(localAppRuntime.getAccount()), this.mOwnerBitMap);
          localEditor.putString(generatePersonalizedVipKey(localAppRuntime.getAccount()), this.mPersonalizedYellowVipUrl);
          localEditor.putString(generateCustomDiamondUrlKey(localAppRuntime.getAccount()), this.mCustomDimanondUrl);
          localEditor.commit();
        }
      }
    }
  }
  
  public static int setComDiamondLevel(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = setVipBitMap(paramInt1, paramInt2, 17, 20);
      }
    }
    return i;
  }
  
  public static int setComDiamondType(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 6) {
        i = setVipBitMap(paramInt1, paramInt2, 14, 16);
      }
    }
    return i;
  }
  
  public static int setIsAnnualVip(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return setVipBitMap(paramInt, i, 6, 6);
    }
  }
  
  public static int setIsAnnualVipEver(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return setVipBitMap(paramInt, i, 22, 22);
    }
  }
  
  public static int setIsComDiamondAnnualVip(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return setVipBitMap(paramInt, i, 21, 21);
    }
  }
  
  public static int setIsCustomDiamondUser(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return setVipBitMap(paramInt, i, 24, 24);
    }
  }
  
  public static int setIsHighStarVip(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return setVipBitMap(paramInt, i, 23, 23);
    }
  }
  
  public static int setIsStarAnnualVip(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return setVipBitMap(paramInt, i, 13, 13);
    }
  }
  
  public static int setIsUnionVip(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return setVipBitMap(paramInt, i, 25, 25);
    }
  }
  
  public static int setLoveVipDiamondLevel(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = setVipBitMap(paramInt1, paramInt2, 30, 30);
      }
    }
    return i;
  }
  
  public static int setStarLevel(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = setVipBitMap(paramInt1, paramInt2, 9, 12);
      }
    }
    return i;
  }
  
  public static int setStarStatus(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = setVipBitMap(paramInt1, paramInt2, 7, 8);
      }
    }
    return i;
  }
  
  public static int setUnionVipLevel(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = setVipBitMap(paramInt1, paramInt2, 26, 29);
      }
    }
    return i;
  }
  
  private static int setVipBitMap(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -1 << paramInt4 + 1 & paramInt1 | paramInt2 << paramInt3 | (1 << paramInt3) - 1 & paramInt1;
  }
  
  public static int setVipLevel(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = setVipBitMap(paramInt1, paramInt2, 2, 5);
      }
    }
    return i;
  }
  
  public static int setVipType(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = setVipBitMap(paramInt1, paramInt2, 0, 1);
      }
    }
    return i;
  }
  
  public String getCustomDimanondUrl()
  {
    loadFromSp();
    return this.mCustomDimanondUrl;
  }
  
  public String getPersonalizedYellowVipUrl()
  {
    loadFromSp();
    return this.mPersonalizedYellowVipUrl;
  }
  
  public int getQQUnionVipLevel()
  {
    loadFromSp();
    return getUnionVipLevel(this.mOwnerBitMap);
  }
  
  public int getVipLevel()
  {
    loadFromSp();
    return getVipLevel(this.mOwnerBitMap);
  }
  
  public int getVipType()
  {
    loadFromSp();
    return getVipType(this.mOwnerBitMap);
  }
  
  public boolean isAnnualVip()
  {
    loadFromSp();
    return isAnnualVip(this.mOwnerBitMap);
  }
  
  public boolean isQQUnionVip()
  {
    loadFromSp();
    return isUnionVip(this.mOwnerBitMap);
  }
  
  public boolean isSuperYellow()
  {
    return getVipType() == 2;
  }
  
  public void setVipType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      loadFromSp();
      this.mOwnerBitMap = setVipType(this.mOwnerBitMap, paramInt);
      saveToSp();
    }
  }
  
  public void updateVipInfo(int paramInt1, int paramInt2, int paramInt3, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info)
  {
    boolean bool2 = true;
    loadFromSp(true);
    this.mOwnerBitMap = setVipType(this.mOwnerBitMap, paramInt1);
    this.mOwnerBitMap = setVipLevel(this.mOwnerBitMap, paramInt2);
    paramInt1 = this.mOwnerBitMap;
    if (paramInt3 != 0)
    {
      bool1 = true;
      this.mOwnerBitMap = setIsAnnualVip(paramInt1, bool1);
      if (paramstar_info != null)
      {
        this.mOwnerBitMap = setStarStatus(this.mOwnerBitMap, paramstar_info.iStarStatus);
        this.mOwnerBitMap = setStarLevel(this.mOwnerBitMap, paramstar_info.iStarLevel);
        paramInt1 = this.mOwnerBitMap;
        if (paramstar_info.isAnnualVip == 0) {
          break label317;
        }
        bool1 = true;
        label107:
        this.mOwnerBitMap = setIsStarAnnualVip(paramInt1, bool1);
        paramInt1 = this.mOwnerBitMap;
        if (paramstar_info.isHighStarVip == 0) {
          break label323;
        }
        bool1 = true;
        label133:
        this.mOwnerBitMap = setIsHighStarVip(paramInt1, bool1);
      }
      if (paramcombine_diamond_info != null)
      {
        this.mOwnerBitMap = setComDiamondType(this.mOwnerBitMap, paramcombine_diamond_info.iShowType);
        this.mOwnerBitMap = setComDiamondLevel(this.mOwnerBitMap, paramcombine_diamond_info.iVipLevel);
        paramInt1 = this.mOwnerBitMap;
        if (paramcombine_diamond_info.isAnnualVip == 0) {
          break label329;
        }
        bool1 = true;
        label196:
        this.mOwnerBitMap = setIsComDiamondAnnualVip(paramInt1, bool1);
        paramInt1 = this.mOwnerBitMap;
        if (paramcombine_diamond_info.isAnnualVipEver == 0) {
          break label335;
        }
      }
    }
    label317:
    label323:
    label329:
    label335:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mOwnerBitMap = setIsAnnualVipEver(paramInt1, bool1);
      paramstar_info = new Intent("com.tencent.qq.syncQzoneVipInfoAction");
      paramcombine_diamond_info = new Bundle();
      paramcombine_diamond_info.putInt("com.tencent.qq.syncQzoneVipInfoStr", this.mOwnerBitMap);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoPersonalized", this.mPersonalizedYellowVipUrl);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoCustomDiamondUrl", this.mCustomDimanondUrl);
      paramstar_info.putExtras(paramcombine_diamond_info);
      BaseApplicationImpl.getContext().sendBroadcast(paramstar_info);
      saveToSp();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label107;
      bool1 = false;
      break label133;
      bool1 = false;
      break label196;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneVipInfoManager
 * JD-Core Version:    0.7.0.1
 */