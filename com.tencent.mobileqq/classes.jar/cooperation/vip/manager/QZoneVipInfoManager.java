package cooperation.vip.manager;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QZoneVipInfoManager
{
  private static QZoneVipInfoManager a;
  private static Object b = new Object();
  private SharedPreferences c;
  private volatile boolean d;
  private int e;
  private String f;
  private String g;
  
  private QZoneVipInfoManager()
  {
    int i = 0;
    this.d = false;
    this.e = -1;
    this.f = null;
    this.g = null;
    Object localObject = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    }
    this.c = ((BaseApplicationImpl)localObject).getSharedPreferences("QZONE_VIP_INFO", i);
    localObject = this.c;
    if (localObject != null) {
      ((SharedPreferences)localObject).registerOnSharedPreferenceChangeListener(new QZoneVipInfoManager.1(this));
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 0, 1);
      }
    }
    return i;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    int j = paramInt3 - paramInt2 + 1;
    paramInt3 = i;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            paramInt3 = 0;
          } else {
            paramInt3 = 15;
          }
        }
        else {
          paramInt3 = 7;
        }
      }
      else {
        paramInt3 = 3;
      }
    }
    if (paramInt3 == 0) {
      return 0;
    }
    return paramInt1 >> paramInt2 & paramInt3;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 & (1 << paramInt3) - 1 | paramInt2 << paramInt3 | -1 << paramInt4 + 1 & paramInt1;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static QZoneVipInfoManager a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          a = new QZoneVipInfoManager();
        }
      }
    }
    return a;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_vip_info_bitmap_pre");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, "cm", 2, 1);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Intent localIntent = new Intent();
      String str = paramActivity.getResources().getString(2131915164);
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
      localIntent.putExtra("aid", paramString2);
      localIntent.putExtra("source", paramString3);
      localIntent.putExtra("viptype", paramInt1);
      localIntent.putExtra("success_tips", str);
      localIntent.putExtra("month", paramInt2);
      localIntent.putExtra("direct_go", true);
      QzonePluginProxyActivity.launchPluingActivityForResult(paramActivity, paramString1, localIntent, -1, null, false, null, true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnSubThread(new QZoneVipInfoManager.3(paramQQAppInterface));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.e >= 0) && (!paramBoolean)) {
      return;
    }
    if (this.c != null)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime != null)
      {
        this.e = this.c.getInt(a(localAppRuntime.getAccount()), 0);
        this.f = this.c.getString(b(localAppRuntime.getAccount()), null);
        this.g = this.c.getString(c(localAppRuntime.getAccount()), null);
      }
    }
  }
  
  public static boolean a(Activity paramActivity, int paramInt, String paramString)
  {
    QLog.d("QZoneVipInfoManager", 1, new Object[] { "onPetBrandClick petId = ", Integer.valueOf(paramInt) });
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    int i;
    if ((localAppRuntime instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localAppRuntime;
      localObject1 = (IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      localObject2 = ((IApolloManagerService)localObject1).getPetInfo(paramInt);
      i = ((IApolloManagerService)localObject1).getPetCategory((JSONObject)localObject2);
      localObject1 = ((IApolloManagerService)localObject1).getPetBrandClickActionUrl((JSONObject)localObject2);
    }
    else
    {
      localObject1 = null;
      i = 0;
      localQQAppInterface = null;
    }
    String str;
    int j;
    if (paramString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        if (i != 1) {
          localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPetNameplateHostUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aiozhu");
        } else {
          localObject2 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetNameplateHostUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1111154994&_mvid=&_path=pages%2Findex%2Findex&_vt=3&via=2016_70&_sig=1128350863&src=10001&roleId=%7BroleId%7D");
        }
      }
      str = "0";
      j = 0;
    }
    else
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        if (i != 1) {
          localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPetNameplateGuestUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aioke");
        } else {
          localObject2 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetNameplateGuestUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1111154994&_mvid=&_path=pages%2Findex%2Findex&_vt=3&via=2016_70&_sig=1128350863&src=10001&roleId=%7BroleId%7D");
        }
      }
      str = "1";
      j = 1;
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return false;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).contains("{pet_id}")) {
      localObject1 = ((String)localObject2).replace("{pet_id}", String.valueOf(paramInt));
    }
    Object localObject2 = localObject1;
    if (((String)localObject1).contains("%7BroleId%7D")) {
      localObject2 = ((String)localObject1).replace("%7BroleId%7D", String.valueOf(paramInt));
    }
    localObject1 = localObject2;
    if (((String)localObject2).contains("{uin}")) {
      localObject1 = ((String)localObject2).replace("{uin}", paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onPetBrandClick petId = ");
      paramString.append(paramInt);
      paramString.append(" petCategory = ");
      paramString.append(i);
      paramString.append(" from = ");
      paramString.append(j);
      paramString.append(" reserve = ");
      paramString.append(str);
      paramString.append(" jumpUrl = ");
      paramString.append((String)localObject1);
      QLog.i("QZoneVipInfoManager", 2, paramString.toString());
    }
    if (localQQAppInterface != null) {
      paramString = JumpParser.a((QQAppInterface)localAppRuntime, paramActivity, (String)localObject1);
    } else {
      paramString = null;
    }
    boolean bool;
    if (paramString != null) {
      bool = paramString.a();
    } else {
      bool = a(paramActivity, (String)localObject1);
    }
    ReportController.b(null, "dc00898", "", "", "", "", j, 0, str, "", "", "");
    if (bool) {
      paramActivity = "0";
    } else {
      paramActivity = "1";
    }
    ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145_2(localQQAppInterface, "3006", "aiopetpaiClick", String.valueOf(i), String.valueOf(paramInt), paramActivity, new String[] { String.valueOf(j) });
    return bool;
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVipInfoManager", 1, new Object[] { "onPetClick petId = ", Integer.valueOf(paramInt) });
    }
    if ((paramActivity != null) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject1 = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      Object localObject2 = ((IApolloManagerService)localObject1).getPetInfo(paramInt);
      int j = ((IApolloManagerService)localObject1).getPetCategory((JSONObject)localObject2);
      localObject2 = ((IApolloManagerService)localObject1).getPetClickActionUrl((JSONObject)localObject2);
      String str;
      int i;
      if (paramString.equals(paramQQAppInterface.getAccount()))
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          if (j != 1) {
            localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIODefaultPetHostUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aiozhu");
          } else {
            localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetHostUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1111154994&_mvid=&_path=pages%2Findex%2Findex&_vt=3&via=2016_70&_sig=1128350863&src=10001&roleId=%7BroleId%7D");
          }
        }
        str = "0";
        i = 0;
      }
      else
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          if (j != 1) {
            localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIODefaultPetGuestUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aioke");
          } else {
            localObject1 = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOMiniGamePetGuestUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1111154994&_mvid=&_path=pages%2Findex%2Findex&_vt=3&via=2016_70&_sig=1128350863&src=10001&roleId=%7BroleId%7D");
          }
        }
        str = "1";
        i = 1;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("QZoneVipInfoManager", 1, "onPetClick error! jumpUrl is null!");
        return false;
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
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onPetClick petId = ");
        paramString.append(paramInt);
        paramString.append(" petCategory = ");
        paramString.append(j);
        paramString.append(" from = ");
        paramString.append(i);
        paramString.append(" reserve = ");
        paramString.append(str);
        paramString.append(" jumpUrl = ");
        paramString.append((String)localObject2);
        QLog.i("QZoneVipInfoManager", 2, paramString.toString());
      }
      paramString = JumpParser.a(paramQQAppInterface, paramActivity, (String)localObject2);
      boolean bool;
      if (paramString != null) {
        bool = paramString.a();
      } else {
        bool = a(paramActivity, (String)localObject2);
      }
      if (bool) {
        paramActivity = "0";
      } else {
        paramActivity = "1";
      }
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145_2(paramQQAppInterface, "3006", "aiopetClick", String.valueOf(j), String.valueOf(paramInt), paramActivity, new String[] { String.valueOf(i) });
      return bool;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onPetClick error! activity = ");
    ((StringBuilder)localObject1).append(paramActivity);
    ((StringBuilder)localObject1).append(", app = ");
    ((StringBuilder)localObject1).append(paramQQAppInterface);
    ((StringBuilder)localObject1).append(", uin = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.e("QZoneVipInfoManager", 1, ((StringBuilder)localObject1).toString());
    return false;
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramActivity.startActivity(localIntent);
      return true;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("jumpToH5 activity = null or url = null , url = ");
    paramActivity.append(paramString);
    QLog.e("QZoneVipInfoManager", 1, paramActivity.toString());
    return false;
  }
  
  public static int b(int paramInt)
  {
    return a(paramInt, 0, 1);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 2, 5);
      }
    }
    return i;
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_vip_info_personalized_vip_pre");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    String str2 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPreviewPayUrl", "https://h5.qzone.qq.com/v2/vip/show/previewDialog?_wv=16781315&_wwv=13&actionId={actionId}&type={type}");
    if (URLUtil.isNetworkUrl(str2))
    {
      String str1 = str2;
      if (str2.contains("{actionId}")) {
        str1 = str2.replace("{actionId}", paramString1);
      }
      paramString1 = str1;
      if (str1.contains("{type}")) {
        paramString1 = str1.replace("{type}", paramString2);
      }
      paramString2 = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("hide_left_button", true);
      paramString2.putExtra("show_right_close_button", false);
      paramString2.putExtra("flag_show_loading_dialog", true);
      paramString2.putExtra("show_close_btn", false);
      paramString2.putExtra("finish_animation_none", true);
      paramString2.putExtra("fragmentStyle", 2);
      paramString2.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramActivity.startActivity(paramString2);
      return;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      paramActivity = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramActivity, str2);
      if (paramActivity != null)
      {
        paramActivity.a();
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("aio jumpToH5PreviewAction error jumpAction = null , url = ");
      paramActivity.append(str2);
      QLog.e("QZoneVipInfoManager", 1, paramActivity.toString());
    }
  }
  
  public static boolean b(Activity paramActivity, String paramString)
  {
    QLog.d("QZoneVipInfoManager", 1, "onSuperYellowBrandClick");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = a().b() + 1;
    String str1;
    String str2;
    if (paramString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
    {
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowQZSVIPNameplateHostUrl", "https://h5.qzone.qq.com/limishow/mall?_wv=131072&_fv=0&_wwv=128&_wvx=10&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMjEifQ%3D%3D");
      str2 = "0";
    }
    else
    {
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowQZSVIPNameplateGuestUrl", "https://h5.qzone.qq.com/limishow/mall?_wv=131072&_fv=0&_wwv=128&_wvx=10&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMjEifQ%3D%3D");
      str2 = "1";
    }
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    String str3 = str1;
    if (str1.contains("{uin}")) {
      str3 = str1.replace("{uin}", paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onSuperYellowBrandClick from = ");
      paramString.append(i);
      paramString.append(" reserve = ");
      paramString.append(str2);
      paramString.append(" jumpUrl = ");
      paramString.append(str3);
      QLog.i("QZoneVipInfoManager", 2, paramString.toString());
    }
    ReportController.b(null, "dc00898", "", "", "", "", i, 0, str2, "", "", "");
    return a(paramActivity, str3);
  }
  
  public static int c(int paramInt)
  {
    return a(paramInt, 2, 5);
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 7, 8);
      }
    }
    return i;
  }
  
  public static int c(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_vip_info_custom_diamond_url_pre");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = a(paramInt1, paramInt2, 9, 12);
      }
    }
    return i;
  }
  
  public static int d(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean d(int paramInt)
  {
    return a(paramInt, 6, 6) != 0;
  }
  
  public static int e(int paramInt)
  {
    return a(paramInt, 7, 8);
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 6) {
        i = a(paramInt1, paramInt2, 14, 16);
      }
    }
    return i;
  }
  
  public static int e(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int f(int paramInt)
  {
    return a(paramInt, 9, 12);
  }
  
  public static int f(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 17, 20);
      }
    }
    return i;
  }
  
  public static int f(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int g(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 26, 29);
      }
    }
    return i;
  }
  
  public static int g(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void g()
  {
    a(false);
  }
  
  public static boolean g(int paramInt)
  {
    return a(paramInt, 13, 13) != 0;
  }
  
  public static int h(int paramInt)
  {
    return a(paramInt, 14, 16);
  }
  
  public static int h(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 30, 30);
      }
    }
    return i;
  }
  
  private void h()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        this.d = true;
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (localAppRuntime != null)
        {
          ((SharedPreferences.Editor)localObject).putInt(a(localAppRuntime.getAccount()), this.e);
          ((SharedPreferences.Editor)localObject).putString(b(localAppRuntime.getAccount()), this.f);
          ((SharedPreferences.Editor)localObject).putString(c(localAppRuntime.getAccount()), this.g);
          ((SharedPreferences.Editor)localObject).commit();
        }
      }
    }
  }
  
  public static int i(int paramInt)
  {
    return a(paramInt, 17, 20);
  }
  
  public static boolean j(int paramInt)
  {
    return a(paramInt, 21, 21) != 0;
  }
  
  public static boolean k(int paramInt)
  {
    return a(paramInt, 22, 22) != 0;
  }
  
  public static boolean l(int paramInt)
  {
    return a(paramInt, 23, 23) != 0;
  }
  
  public static boolean m(int paramInt)
  {
    return a(paramInt, 24, 24) != 0;
  }
  
  public static boolean n(int paramInt)
  {
    return a(paramInt, 25, 25) != 0;
  }
  
  public static int o(int paramInt)
  {
    return a(paramInt, 26, 29);
  }
  
  public static int p(int paramInt)
  {
    return a(paramInt, 30, 30);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      g();
      this.e = a(this.e, paramInt);
      h();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info)
  {
    a(true);
    this.e = a(this.e, paramInt1);
    this.e = b(this.e, paramInt2);
    paramInt1 = this.e;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt3 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = a(paramInt1, bool1);
    if (paramstar_info != null)
    {
      this.e = c(this.e, paramstar_info.iStarStatus);
      this.e = d(this.e, paramstar_info.iStarLevel);
      paramInt1 = this.e;
      if (paramstar_info.isAnnualVip != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.e = b(paramInt1, bool1);
      paramInt1 = this.e;
      if (paramstar_info.isHighStarVip != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.e = e(paramInt1, bool1);
    }
    if (paramcombine_diamond_info != null)
    {
      this.e = e(this.e, paramcombine_diamond_info.iShowType);
      this.e = f(this.e, paramcombine_diamond_info.iVipLevel);
      paramInt1 = this.e;
      if (paramcombine_diamond_info.isAnnualVip != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.e = c(paramInt1, bool1);
      paramInt1 = this.e;
      bool1 = bool2;
      if (paramcombine_diamond_info.isAnnualVipEver != 0) {
        bool1 = true;
      }
      this.e = d(paramInt1, bool1);
    }
    paramstar_info = new Intent("com.tencent.qq.syncQzoneVipInfoAction");
    paramcombine_diamond_info = new Bundle();
    paramcombine_diamond_info.putInt("com.tencent.qq.syncQzoneVipInfoStr", this.e);
    paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoPersonalized", this.f);
    paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoCustomDiamondUrl", this.g);
    paramstar_info.putExtras(paramcombine_diamond_info);
    BaseApplicationImpl.getContext().sendBroadcast(paramstar_info);
    h();
  }
  
  public int b()
  {
    g();
    return b(this.e);
  }
  
  public boolean c()
  {
    return b() == 2;
  }
  
  public int d()
  {
    g();
    return c(this.e);
  }
  
  public boolean e()
  {
    g();
    return d(this.e);
  }
  
  public String f()
  {
    g();
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.QZoneVipInfoManager
 * JD-Core Version:    0.7.0.1
 */