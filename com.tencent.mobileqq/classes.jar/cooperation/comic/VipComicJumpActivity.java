package cooperation.comic;

import aieq;
import alud;
import amca;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import aozs;
import appq;
import asta;
import axlx;
import bdtg;
import bhsu;
import bhtd;
import bimc;
import bimd;
import biml;
import bimq;
import bimv;
import bimw;
import bimy;
import bimz;
import bina;
import binb;
import binc;
import bini;
import biof;
import bioj;
import bioq;
import biqn;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCClient;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nbv;
import org.json.JSONException;
import org.json.JSONObject;

public class VipComicJumpActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static final String a;
  long jdField_a_of_type_Long = 0L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bhtd a;
  public bimw a;
  public biqn a;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public volatile boolean b;
  long c;
  public boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = VipComicJumpActivity.class.getName();
  }
  
  public VipComicJumpActivity()
  {
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Bimw = null;
  }
  
  public static int a(String paramString, List<WebViewTabBarData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((WebViewTabBarData)paramList.get(i)).tag.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public static bimw a(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent == null) {
      return null;
    }
    bimw localbimw = new bimw();
    localbimw.jdField_a_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    localbimw.jdField_b_of_type_Long = System.currentTimeMillis();
    if (localbimw.jdField_a_of_type_Long <= 0L) {
      localbimw.jdField_a_of_type_Long = localbimw.jdField_b_of_type_Long;
    }
    localbimw.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("has_red_dot", false);
    Object localObject1 = paramIntent.getStringExtra("from_leba");
    Object localObject2 = paramIntent.getStringExtra("from_leba_mgr");
    String str = paramIntent.getStringExtra("cfrom");
    if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("fromleba")))
    {
      localbimw.jdField_a_of_type_Int = 1006002;
      localObject1 = null;
    }
    label180:
    label223:
    label739:
    label750:
    label755:
    label762:
    label1149:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "getFromInfoFromIntent sourceFrom = " + localbimw.jdField_a_of_type_Int + ", extUrlParam = " + localbimw.jdField_a_of_type_JavaLangString);
      }
      int i;
      if (localbimw.jdField_a_of_type_Int == 1006002)
      {
        localbimw.jdField_f_of_type_JavaLangString = MainFragment.jdField_c_of_type_JavaLangString;
        localObject2 = binb.a(null);
        if ((localObject2 == null) || ((localbimw.jdField_a_of_type_Int != 1006002) && (localbimw.jdField_a_of_type_Int != 19) && (localbimw.jdField_a_of_type_Int != 20))) {
          break label734;
        }
        i = 1;
        if (i == 0) {
          break label771;
        }
        i = ((Bundle)localObject2).getInt("type", -1);
        if ((i < 100) || (i > 300)) {
          break label739;
        }
        localbimw.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
        localbimw.jdField_a_of_type_Bimv = new bimv();
        localbimw.jdField_a_of_type_Bimv.jdField_a_of_type_JavaLangString = ((Bundle)localObject2).getString("comicId");
        localbimw.jdField_a_of_type_Bimv.jdField_b_of_type_JavaLangString = ((Bundle)localObject2).getString("sectionId");
        localbimw.jdField_a_of_type_Bimv.jdField_c_of_type_JavaLangString = ((Bundle)localObject2).getString("pictureId");
        localbimw.jdField_a_of_type_Bimv.jdField_a_of_type_Int = ((Bundle)localObject2).getInt("offset", -1);
        localbimw.jdField_a_of_type_Bimv.jdField_b_of_type_Int = ((Bundle)localObject2).getInt("type", -1);
        localbimw.jdField_a_of_type_Bimv.jdField_c_of_type_Int = ((Bundle)localObject2).getInt("player", 2);
        localbimw.jdField_a_of_type_Bimv.jdField_e_of_type_JavaLangString = ((Bundle)localObject2).getString("cloudUrl", "");
        if (!"com.qqcomic.activity.media.VipComicMediaPlayActivity".equals(localbimw.jdField_b_of_type_JavaLangString)) {
          break label762;
        }
        localbimw.jdField_a_of_type_Boolean = false;
        localbimw.jdField_c_of_type_Boolean = ((Bundle)localObject2).getBoolean("isPlayerLocked", false);
        if (((Bundle)localObject2).getBoolean("supportMiniPlayer", false)) {
          break label750;
        }
        bool = true;
        localbimw.jdField_e_of_type_Boolean = bool;
        if (!localbimw.jdField_e_of_type_Boolean) {
          break label755;
        }
        localObject1 = "";
        localbimw.jdField_a_of_type_Bimv.jdField_d_of_type_JavaLangString = a("comicDetailVideo", null, null, "1", "354", null, (String)localObject1 + "ADTAG=comic.plugin.fav&id=" + localbimw.jdField_a_of_type_Bimv.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        for (;;)
        {
          if (TextUtils.isEmpty(localbimw.jdField_d_of_type_JavaLangString)) {
            localbimw.jdField_d_of_type_JavaLangString = bimq.a();
          }
          if ((paramIntent.hasExtra("banner_fromBanner")) && (paramIntent.getBooleanExtra("banner_fromBanner", false)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VipComicJumpActivity", 2, "come from AIO Banner!");
            }
            if ((localbimw.jdField_a_of_type_Bimv != null) && (!TextUtils.isEmpty(localbimw.jdField_a_of_type_Bimv.jdField_a_of_type_JavaLangString))) {
              binc.a(null, "100007", "2", "40040", localbimw.jdField_a_of_type_Bimv.jdField_a_of_type_JavaLangString, new String[0]);
            }
          }
          return localbimw;
          if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase("fromlebamgr")))
          {
            localbimw.jdField_a_of_type_Int = 1006003;
            localObject1 = null;
            break;
          }
          if (!TextUtils.isEmpty(str))
          {
            localbimw.jdField_a_of_type_Int = Integer.valueOf(str).intValue();
            localObject1 = null;
            break;
          }
          try
          {
            for (;;)
            {
              localObject1 = paramIntent.getStringExtra("options");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1149;
              }
              localObject1 = new JSONObject((String)localObject1);
              try
              {
                localbimw.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("from");
                localbimw.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("extUrlParam");
              }
              catch (Exception localException1) {}
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              JSONObject localJSONObject;
              localObject1 = null;
            }
            localObject1 = null;
          }
        }
        localException1.printStackTrace();
        break;
        if (localbimw.jdField_a_of_type_Int != 1006003) {
          break label180;
        }
        localbimw.jdField_f_of_type_JavaLangString = alud.a(2131717103);
        break label180;
        i = 0;
        break label223;
        localbimw.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.reader.VipComicPortraitReadingActivity";
        break label256;
        bool = false;
        break label423;
        localObject1 = "init_player=1&";
        break label440;
        localbimw.jdField_a_of_type_Boolean = true;
        continue;
        if (localObject1 != null)
        {
          localbimw.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
          localbimw.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("from", 0);
          if (!((JSONObject)localObject1).optBoolean("newInstance"))
          {
            localbimw.jdField_d_of_type_Boolean = bool;
            if (((JSONObject)localObject1).has("url")) {
              localbimw.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("url");
            }
          }
          try
          {
            localbimw.jdField_c_of_type_JavaLangString = URLDecoder.decode(localbimw.jdField_c_of_type_JavaLangString);
            if (bimq.a(localbimw.jdField_c_of_type_JavaLangString, localbimw.jdField_a_of_type_AndroidContentIntent)) {
              localbimw.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
            }
            if (((JSONObject)localObject1).has("comic")) {}
            try
            {
              localJSONObject = new JSONObject(((JSONObject)localObject1).optString("comic"));
              localbimw.jdField_a_of_type_Bimv = new bimv();
              localbimw.jdField_a_of_type_Bimv.jdField_a_of_type_JavaLangString = localJSONObject.optString("comicID");
              localbimw.jdField_a_of_type_Bimv.jdField_b_of_type_JavaLangString = localJSONObject.optString("comicSectionID");
              localbimw.jdField_a_of_type_Bimv.jdField_c_of_type_JavaLangString = localJSONObject.optString("comicPageID");
              localbimw.jdField_a_of_type_Bimv.jdField_a_of_type_Int = localJSONObject.optInt("comicPageOffset");
              localbimw.jdField_a_of_type_Bimv.jdField_b_of_type_Int = localJSONObject.optInt("type");
              localbimw.jdField_a_of_type_Boolean = localJSONObject.optBoolean("returnToDetail");
              localbimw.jdField_a_of_type_Bimv.jdField_c_of_type_Int = localJSONObject.optInt("player", 2);
              localbimw.jdField_a_of_type_Bimv.jdField_e_of_type_JavaLangString = localJSONObject.optString("cloudUrl", "");
              localbimw.jdField_a_of_type_Bimv.jdField_d_of_type_JavaLangString = localJSONObject.optString("url", "");
              if (((JSONObject)localObject1).has("maintab")) {
                localbimw.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("maintab");
              }
              if (((JSONObject)localObject1).has("subtab")) {
                localbimw.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("subtab");
              }
              if (((JSONObject)localObject1).has("leftViewText"))
              {
                localbimw.jdField_f_of_type_JavaLangString = ((JSONObject)localObject1).optString("leftViewText");
                continue;
                bool = false;
              }
            }
            catch (JSONException localJSONException)
            {
              break label1058;
            }
          }
          catch (Exception localException2)
          {
            break label854;
          }
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str2 = (String)bdtg.a().get(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bioq.a(paramString1);
    }
    return b(str1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  private static String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      if (i != 0) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin before enter start");
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      MqqHandler localMqqHandler = paramAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        Message localMessage1 = localMqqHandler.obtainMessage(1134028);
        Message localMessage2 = localMqqHandler.obtainMessage(1134040);
        localMqqHandler.sendMessageDelayed(localMessage1, 1000L);
        localMqqHandler.sendMessageDelayed(localMessage2, 1000L);
      }
      binb.a((QQAppInterface)paramAppInterface);
      bini.a((QQAppInterface)paramAppInterface);
      if (paramBoolean) {
        ThreadManager.postImmediately(new VipComicJumpActivity.1((QQAppInterface)paramAppInterface), null, true);
      }
      paramAppInterface = (appq)paramAppInterface.getBusinessHandler(80);
      if (paramAppInterface != null) {
        paramAppInterface.b();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "init plugin before enter end");
      }
      return;
      paramAppInterface = new Bundle();
      paramAppInterface.putBoolean("doLoadModule", paramBoolean);
      QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "initPluginBeforeEnter", paramAppInterface);
    }
  }
  
  static void a(AppRuntime paramAppRuntime, bimw parambimw)
  {
    if ((paramAppRuntime == null) || (parambimw == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo start");
    }
    boolean bool2 = paramAppRuntime instanceof QQAppInterface;
    Object localObject1;
    Object localObject2;
    if (bool2)
    {
      localObject1 = aieq.a().a();
      if (localObject1 == null) {
        break label1017;
      }
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (aozs)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((aozs)localObject2).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (((aozs)localObject2).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId != 1113L));
    }
    label119:
    label1017:
    for (int i = ((aozs)localObject2).jdField_a_of_type_Byte;; i = -1)
    {
      label122:
      String str;
      if (i == 0)
      {
        bool1 = true;
        localObject1 = null;
        if (!bool1) {
          break label546;
        }
        localObject6 = "1113." + 100800;
        localObject5 = "1113." + 100802;
        localObject4 = "1113." + 100803;
        localObject3 = "1113." + 100804;
        localObject2 = "1113." + 100801;
        str = String.valueOf(1113);
        label254:
        if (!bool2) {
          break label699;
        }
        paramAppRuntime = (axlx)paramAppRuntime.getManager(36);
        if (paramAppRuntime == null) {
          break;
        }
        localObject1 = paramAppRuntime.a(str);
        localObject6 = paramAppRuntime.a((String)localObject6);
        localObject5 = paramAppRuntime.a((String)localObject5);
        localObject4 = paramAppRuntime.a((String)localObject4);
        localObject3 = paramAppRuntime.a((String)localObject3);
        paramAppRuntime = paramAppRuntime.a((String)localObject2);
        if ((localObject6 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject6).iNewFlag.get() == 0)) {
          break label674;
        }
        bool1 = true;
        parambimw.a("index", bool1);
        if ((paramAppRuntime == null) || (paramAppRuntime.iNewFlag.get() == 0)) {
          break label679;
        }
        bool1 = true;
        parambimw.a("fav", bool1);
        if ((localObject3 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() == 0)) {
          break label684;
        }
        bool1 = true;
        parambimw.a("category", bool1);
        if ((localObject5 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() == 0)) {
          break label689;
        }
        bool1 = true;
        parambimw.a("more", bool1);
        if ((localObject4 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() == 0)) {
          break label694;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        parambimw.a("group", bool1);
        if ((localObject1 != null) && (parambimw.jdField_g_of_type_Boolean))
        {
          a(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get(), ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get(), parambimw);
          parambimw.jdField_g_of_type_JavaLangString = a(((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get());
        }
        if (!QLog.isColorLevel()) {
          break label990;
        }
        QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo end");
        return;
        bool1 = false;
        break label119;
        localObject1 = (bioj)paramAppRuntime.getManager(213);
        if (localObject1 == null) {
          break;
        }
        bool1 = ((bioj)localObject1).a(1113);
        break label122;
        localObject6 = "100600.100001113." + 100100800;
        localObject5 = "100600.100001113." + 100100802;
        localObject4 = "100600.100001113." + 100100803;
        localObject3 = "100600.100001113." + 100100804;
        localObject2 = "100600.100001113." + 100100801;
        str = "100600.100001113";
        break label254;
        bool1 = false;
        break label338;
        bool1 = false;
        break label362;
        bool1 = false;
        break label388;
        bool1 = false;
        break label414;
      }
      paramAppRuntime = new ArrayList();
      paramAppRuntime.add(str);
      paramAppRuntime.add(localObject6);
      paramAppRuntime.add(localObject2);
      paramAppRuntime.add(localObject3);
      paramAppRuntime.add(localObject5);
      paramAppRuntime.add(localObject4);
      paramAppRuntime = ((bioj)localObject1).a(paramAppRuntime);
      if (paramAppRuntime == null) {
        break;
      }
      localObject1 = (RedAppInfo)paramAppRuntime.get(str);
      Object localObject6 = (RedAppInfo)paramAppRuntime.get(localObject6);
      Object localObject5 = (RedAppInfo)paramAppRuntime.get(localObject5);
      Object localObject4 = (RedAppInfo)paramAppRuntime.get(localObject4);
      Object localObject3 = (RedAppInfo)paramAppRuntime.get(localObject3);
      paramAppRuntime = (RedAppInfo)paramAppRuntime.get(localObject2);
      if ((localObject6 != null) && (((RedAppInfo)localObject6).b() != 0))
      {
        bool1 = true;
        parambimw.a("index", bool1);
        if ((paramAppRuntime == null) || (paramAppRuntime.b() == 0)) {
          break label997;
        }
        bool1 = true;
        parambimw.a("fav", bool1);
        if ((localObject3 == null) || (((RedAppInfo)localObject3).b() == 0)) {
          break label1002;
        }
        bool1 = true;
        parambimw.a("category", bool1);
        if ((localObject5 == null) || (((RedAppInfo)localObject5).b() == 0)) {
          break label1007;
        }
        bool1 = true;
        parambimw.a("more", bool1);
        if ((localObject4 == null) || (((RedAppInfo)localObject4).b() == 0)) {
          break label1012;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        parambimw.a("group", bool1);
        if ((localObject1 == null) || (!parambimw.jdField_g_of_type_Boolean)) {
          break label496;
        }
        a(((RedAppInfo)localObject1).a(), ((RedAppInfo)localObject1).a(), parambimw);
        parambimw.jdField_g_of_type_JavaLangString = a(((RedAppInfo)localObject1).a());
        break label496;
        break;
        bool1 = false;
        break label852;
        bool1 = false;
        break label873;
        bool1 = false;
        break label896;
        bool1 = false;
        break label919;
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, bimw parambimw)
  {
    if ((paramAppInterface == null) || (paramActivity == null) || (parambimw == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "handle param start");
    }
    Object localObject3;
    String str;
    Object localObject2;
    Object localObject4;
    if (("com.qqcomic.activity.VipComicMainTabActivity".equals(parambimw.jdField_b_of_type_JavaLangString)) && (parambimw.jdField_d_of_type_JavaLangString == null))
    {
      i = 1;
      if ((parambimw.jdField_a_of_type_Int != 12) || (i == 0)) {
        break label312;
      }
      localObject3 = paramActivity.getSharedPreferences("vip_comic_file", 4);
      if (!((SharedPreferences)localObject3).getBoolean("restore_flag", false)) {
        break label312;
      }
      str = ((SharedPreferences)localObject3).getString("base_package", "");
      localObject2 = ((SharedPreferences)localObject3).getString("base_activity", "");
      i = ((SharedPreferences)localObject3).getInt("activity_task_id", -1);
      localObject3 = ((ActivityManager)paramActivity.getApplication().getApplicationContext().getSystemService("activity")).getRunningTasks(100);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break label312;
      }
      localObject3 = ((List)localObject3).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (ActivityManager.RunningTaskInfo)((Iterator)localObject3).next();
      } while ((!((ActivityManager.RunningTaskInfo)localObject4).baseActivity.getClassName().equals(localObject2)) || (i != ((ActivityManager.RunningTaskInfo)localObject4).id));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject3 = new Intent();
        ((Intent)localObject3).setComponent(new ComponentName(str, (String)localObject2));
        ((Intent)localObject3).addFlags(269500416);
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_zz_bodong");
        try
        {
          paramActivity.startActivity((Intent)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "handle param restore stack end");
          }
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        i = 0;
        break;
      }
      label312:
      Object localObject1;
      if ("com.qqcomic.activity.VipComicMainTabActivity".equals(parambimw.jdField_b_of_type_JavaLangString))
      {
        a(paramAppInterface, parambimw);
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "handle param parse red touch end");
        }
        if (parambimw.jdField_h_of_type_Boolean)
        {
          paramAppInterface = nbv.a(parambimw.jdField_h_of_type_JavaLangString, "returnIndex=true");
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("url", paramAppInterface);
          ((Intent)localObject1).putExtra("reportSourceFrom", parambimw.jdField_a_of_type_Int);
          ((Intent)localObject1).putExtra("startOpenPageTime", parambimw.jdField_a_of_type_Long);
          bimq.a(paramActivity, (Intent)localObject1, -1);
          if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "jump to comic activity page directly, url=" + paramAppInterface);
          }
          return true;
        }
        localObject1 = new ArrayList();
        j = paramActivity.getResources().getDimensionPixelSize(2131298914);
        i = j;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i = j + ImmersiveUtils.getStatusBarHeight(paramActivity);
        }
        i = (int)((i - 0.5F) / paramActivity.getResources().getDisplayMetrics().density);
        paramAppInterface = bimz.a();
        if ((paramAppInterface != null) && (!paramAppInterface.isEmpty()))
        {
          localObject2 = paramAppInterface.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (bina)((Iterator)localObject2).next();
            localObject4 = new WebViewTabBarData();
            ((WebViewTabBarData)localObject4).tag = ((bina)localObject3).jdField_a_of_type_JavaLangString;
            ((WebViewTabBarData)localObject4).tabName = ((bina)localObject3).jdField_b_of_type_JavaLangString;
            if (TextUtils.equals(((bina)localObject3).jdField_a_of_type_JavaLangString, "index")) {}
            for (paramAppInterface = "&redDotIds=" + parambimw.jdField_g_of_type_JavaLangString;; paramAppInterface = "")
            {
              ((WebViewTabBarData)localObject4).url = nbv.a(((bina)localObject3).jdField_c_of_type_JavaLangString, "_cfrom=" + parambimw.jdField_a_of_type_Int + "&hasRedDot=" + parambimw.a(((bina)localObject3).jdField_a_of_type_JavaLangString) + "&_titleBarHeight=" + i + paramAppInterface);
              ((WebViewTabBarData)localObject4).tabIcon = bimz.a(((bina)localObject3).jdField_d_of_type_JavaLangString);
              ((ArrayList)localObject1).add(localObject4);
              break;
            }
          }
        }
        else
        {
          paramAppInterface = new WebViewTabBarData();
          paramAppInterface.tag = "index";
          paramAppInterface.tabName = alud.a(2131716883);
          paramAppInterface.url = a("comicIndex", null, "64", "5", "", null, "_cfrom=" + parambimw.jdField_a_of_type_Int + "&hasRedDot=" + parambimw.a("index") + "&_titleBarHeight=" + i + "&redDotIds=" + parambimw.jdField_g_of_type_JavaLangString);
          localObject2 = new WebViewTabBarData();
          ((WebViewTabBarData)localObject2).tag = "fav";
          ((WebViewTabBarData)localObject2).tabName = alud.a(2131716877);
          ((WebViewTabBarData)localObject2).url = a("comicFav", null, "", "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", "_cfrom=" + parambimw.jdField_a_of_type_Int + "&hasRedDot=" + parambimw.a("fav") + "&_titleBarHeight=" + i);
          localObject3 = new WebViewTabBarData();
          ((WebViewTabBarData)localObject3).tag = "category";
          ((WebViewTabBarData)localObject3).tabName = alud.a(2131716880);
          ((WebViewTabBarData)localObject3).url = a("comicCategory", null, null, "1", "354", null, "_cfrom=" + parambimw.jdField_a_of_type_Int + "&hasRedDot=" + parambimw.a("category") + "&_titleBarHeight=" + i);
          localObject4 = new WebViewTabBarData();
          ((WebViewTabBarData)localObject4).tag = "more";
          ((WebViewTabBarData)localObject4).tabName = alud.a(2131716961);
          ((WebViewTabBarData)localObject4).url = a("comicMore", null, null, "1", "354", null, "_cfrom=" + parambimw.jdField_a_of_type_Int + "&hasRedDot=" + parambimw.a("more") + "&_titleBarHeight=" + i);
          WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
          localWebViewTabBarData.tag = "group";
          localWebViewTabBarData.tabName = alud.a(2131716889);
          localWebViewTabBarData.url = a("comicGroup", null, null, "1", "354", null, "_cfrom=" + parambimw.jdField_a_of_type_Int + "&hasRedDot=" + parambimw.a("group") + "&_titleBarHeight=" + i);
          ((ArrayList)localObject1).add(paramAppInterface);
          ((ArrayList)localObject1).add(localObject2);
          ((ArrayList)localObject1).add(localObject3);
          ((ArrayList)localObject1).add(localObject4);
          ((ArrayList)localObject1).add(localWebViewTabBarData);
        }
        if (QLog.isColorLevel())
        {
          paramAppInterface = ((ArrayList)localObject1).iterator();
          while (paramAppInterface.hasNext())
          {
            localObject2 = (WebViewTabBarData)paramAppInterface.next();
            QLog.d("VipComicJumpActivity", 2, "tabBar:tabKey=" + ((WebViewTabBarData)localObject2).tag + ", tabName=" + ((WebViewTabBarData)localObject2).tabName + ", tabUrl=" + ((WebViewTabBarData)localObject2).url);
          }
        }
        i = 0;
        if (parambimw.jdField_d_of_type_JavaLangString == null) {
          break label1912;
        }
      }
      label1724:
      label1912:
      for (int j = a(parambimw.jdField_d_of_type_JavaLangString, (List)localObject1);; j = 0)
      {
        paramAppInterface = (WebViewTabBarData)((ArrayList)localObject1).get(j);
        paramAppInterface.url = nbv.a(paramAppInterface.url, "isDefaultTab=1");
        if (parambimw.jdField_e_of_type_JavaLangString != null) {}
        try
        {
          i = Integer.parseInt(parambimw.jdField_e_of_type_JavaLangString);
          if ((!TextUtils.isEmpty(parambimw.jdField_a_of_type_JavaLangString)) && (j >= 0) && (j < ((ArrayList)localObject1).size()))
          {
            paramAppInterface = (WebViewTabBarData)((ArrayList)localObject1).get(j);
            paramAppInterface.url = nbv.a(paramAppInterface.url, "extUrlParam=" + URLEncoder.encode(parambimw.jdField_a_of_type_JavaLangString));
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("tabConfigData", (Serializable)localObject1);
          ((Intent)localObject2).putExtra("reportSourceFrom", parambimw.jdField_a_of_type_Int);
          ((Intent)localObject2).putExtra("startOpenPageTime", parambimw.jdField_a_of_type_Long);
          ((Intent)localObject2).putExtra("key_maintab", j);
          ((Intent)localObject2).putExtra("tabDefaultIndex", j);
          ((Intent)localObject2).putExtra("key_subtab", i);
          if (TextUtils.isEmpty(parambimw.jdField_f_of_type_JavaLangString))
          {
            paramAppInterface = paramActivity.getString(2131690623);
            ((Intent)localObject2).putExtra("selfSet_leftViewText", paramAppInterface);
            if ((parambimw.jdField_a_of_type_Int == 1006002) || (parambimw.jdField_a_of_type_Int == 1006003))
            {
              if (parambimw.jdField_a_of_type_Int != 1006002) {
                break label1724;
              }
              i = 40400;
              ((Intent)localObject2).putExtra("individuation_url_type", i);
            }
            if (parambimw.jdField_d_of_type_Boolean) {
              ((Intent)localObject2).setFlags(((Intent)localObject2).getFlags() | 0x4000000 | 0x10000000);
            }
            bimq.a(paramActivity, (Intent)localObject2, -1);
            VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", parambimw.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - parambimw.jdField_b_of_type_Long) });
            if (QLog.isColorLevel()) {
              QLog.d("QQComicDebug", 2, "handle param open main tab end");
            }
            return true;
          }
        }
        catch (Exception paramAppInterface)
        {
          for (;;)
          {
            i = 0;
            continue;
            paramAppInterface = parambimw.jdField_f_of_type_JavaLangString;
            continue;
            i = 40401;
          }
        }
        if ("com.qqcomic.activity.VipComicTabBrowserActivity".equals(parambimw.jdField_b_of_type_JavaLangString))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("url", parambimw.jdField_c_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("reportSourceFrom", parambimw.jdField_a_of_type_Int);
          ((Intent)localObject1).putExtra("startOpenPageTime", parambimw.jdField_a_of_type_Long);
          if (TextUtils.isEmpty(parambimw.jdField_f_of_type_JavaLangString)) {}
          for (paramAppInterface = paramActivity.getString(2131690623);; paramAppInterface = parambimw.jdField_f_of_type_JavaLangString)
          {
            ((Intent)localObject1).putExtra("selfSet_leftViewText", paramAppInterface);
            bimq.a(paramActivity, (Intent)localObject1, -1);
            VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", parambimw.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - parambimw.jdField_b_of_type_Long) });
            if (QLog.isColorLevel()) {
              QLog.d("QQComicDebug", 2, "handle param open web end");
            }
            return true;
          }
        }
        parambimw.jdField_f_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "handle param end");
        }
        return false;
      }
    }
  }
  
  static boolean a(String paramString, List<String> paramList, bimw parambimw)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = null;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("msg");
        if (paramString != null)
        {
          paramList = paramList.iterator();
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label184;
            }
            localObject = (String)paramList.next();
            try
            {
              localObject = paramString.optJSONObject((String)localObject);
              if (localObject != null)
              {
                localObject = ((JSONObject)localObject).optString("content");
                if (!TextUtils.isEmpty((CharSequence)localObject))
                {
                  localObject = new JSONObject((String)localObject);
                  parambimw.jdField_h_of_type_Boolean = "redirect".equals(((JSONObject)localObject).optString("type"));
                  if (parambimw.jdField_h_of_type_Boolean)
                  {
                    localObject = ((JSONObject)localObject).optString("link");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      break;
                    }
                    parambimw.jdField_h_of_type_Boolean = false;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              QLog.e("VipComicJumpActivity", 1, "parse red mission failed", localException);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("VipComicJumpActivity", 1, "parse red failed", paramString);
          paramString = localException;
        }
        parambimw.jdField_h_of_type_JavaLangString = localException;
        return true;
      }
    }
    label184:
    return false;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = bhsu.a();
    if (!TextUtils.isEmpty(paramString7)) {
      localStringBuilder.append(paramString7);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString1.contains("_wv=")))
    {
      localStringBuilder.append("&_wv=");
      localStringBuilder.append(paramString2);
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!paramString1.contains("_wwv=")))
    {
      localStringBuilder.append("&_wwv=");
      localStringBuilder.append(paramString3);
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!paramString1.contains("_cwv=")))
    {
      localStringBuilder.append("&_cwv=");
      localStringBuilder.append(paramString4);
    }
    if ((!TextUtils.isEmpty(paramString5)) && (!paramString1.contains("_sonic_id=")) && (!paramString1.contains("_bid=")))
    {
      localStringBuilder.append("&_bid=");
      localStringBuilder.append(paramString5);
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!paramString1.contains("channel=")))
    {
      localStringBuilder.append("&channel=");
      localStringBuilder.append(paramString6);
    }
    if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(0) == '&')) {
      localStringBuilder.deleteCharAt(0);
    }
    return nbv.a(paramString1, localStringBuilder.toString());
  }
  
  void a(Activity paramActivity, bimw parambimw)
  {
    if ((paramActivity == null) || (parambimw == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "call start plugin activity start.");
    }
    Intent localIntent = parambimw.jdField_a_of_type_AndroidContentIntent;
    localIntent.putExtra("begin_to_load_comic_plugin", System.currentTimeMillis());
    localIntent.putExtra("startOpenPageTime", parambimw.jdField_a_of_type_Long);
    localIntent.putExtra("pluginFinished", this.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(parambimw.jdField_c_of_type_JavaLangString)) {
      localIntent.putExtra("url", parambimw.jdField_c_of_type_JavaLangString);
    }
    if (parambimw.jdField_a_of_type_Bimv != null)
    {
      localIntent.putExtra("key_comic_id", parambimw.jdField_a_of_type_Bimv.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_section_id", parambimw.jdField_a_of_type_Bimv.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_pic_id", parambimw.jdField_a_of_type_Bimv.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("key_pic_offset_ratio", parambimw.jdField_a_of_type_Bimv.jdField_a_of_type_Int);
      localIntent.putExtra("key_type", parambimw.jdField_a_of_type_Bimv.jdField_b_of_type_Int);
      localIntent.putExtra("key_jump_from_out_plugin", true);
      localIntent.putExtra("key_return_to_detail", parambimw.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_is_player_locked", parambimw.jdField_c_of_type_Boolean);
      localIntent.putExtra("key_return_to_home_from_detail", parambimw.jdField_b_of_type_Boolean);
      localIntent.putExtra("key_is_fullscreen", parambimw.jdField_e_of_type_Boolean);
      localIntent.putExtra("key_video_player_type", parambimw.jdField_a_of_type_Bimv.jdField_c_of_type_Int);
      localIntent.putExtra("key_cloud_url", parambimw.jdField_a_of_type_Bimv.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("key_from_out_entry", true);
      if (!TextUtils.isEmpty(parambimw.jdField_a_of_type_Bimv.jdField_d_of_type_JavaLangString)) {
        localIntent.putExtra("url", parambimw.jdField_a_of_type_Bimv.jdField_d_of_type_JavaLangString);
      }
    }
    localIntent.putExtra("key_source_from", parambimw.jdField_a_of_type_Int);
    if (TextUtils.isEmpty(parambimw.jdField_f_of_type_JavaLangString))
    {
      localIntent.putExtra("selfSet_leftViewText", getString(2131690623));
      label351:
      if (parambimw.jdField_d_of_type_Boolean) {
        localIntent.addFlags(67108864);
      }
      localIntent.putExtra("reportSourceFrom", parambimw.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label615;
      }
    }
    label615:
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("reportProcessExistFlag", i);
      localIntent.putExtra("reportLebaClick", parambimw.jdField_a_of_type_Long);
      localIntent.putExtra("reportJumpActivityOnCreate", parambimw.jdField_b_of_type_Long);
      if ((parambimw.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long > parambimw.jdField_b_of_type_Long)) {
        localIntent.putExtra("reportDownloadTime", this.jdField_a_of_type_Long - parambimw.jdField_b_of_type_Long);
      }
      if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long)) {
        localIntent.putExtra("reportInstallTime", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
      }
      localIntent.putExtra("reportStartPluginTime", System.currentTimeMillis());
      localIntent.putExtra("isFromJumpActivity", true);
      bimd localbimd = bimc.a(2);
      asta localasta = null;
      if (localbimd != null)
      {
        localbimd.a();
        localasta = localbimd.a;
      }
      biof.a(paramActivity, localIntent, parambimw.jdField_b_of_type_JavaLangString, localasta);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQComicDebug", 2, "call start plugin activity end.");
      return;
      localIntent.putExtra("selfSet_leftViewText", parambimw.jdField_f_of_type_JavaLangString);
      break label351;
    }
  }
  
  public void a(bimw parambimw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin start");
    }
    a(this.app, false);
    ThreadManager.postImmediately(new VipComicJumpActivity.2(this, this.app, parambimw), null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin end");
    }
  }
  
  public void a(bimw parambimw, int paramInt)
  {
    if (parambimw == null) {
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (this.app == null) {
          continue;
        }
        localObject1 = (amca)this.app.a(13);
        if (localObject1 == null) {
          continue;
        }
        i = ((amca)localObject1).g();
        if (i != 1) {
          continue;
        }
        localObject1 = "2";
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i;
        localException.printStackTrace();
        Object localObject2 = "1";
        continue;
        if ((parambimw.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long <= parambimw.jdField_b_of_type_Long)) {
          continue;
        }
        String str1 = this.jdField_a_of_type_Long - parambimw.jdField_b_of_type_Long + "";
        continue;
        String str4 = "0";
        continue;
        String str3 = "0";
        continue;
        String str2 = "0";
        continue;
        str1 = "0";
        continue;
        str1 = "1";
        continue;
      }
      localObject2 = localObject1;
      if (!this.jdField_a_of_type_Boolean) {
        continue;
      }
      localObject1 = "-1";
      if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long <= this.jdField_a_of_type_Long)) {
        continue;
      }
      str2 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long + "";
      if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L) || (this.jdField_c_of_type_Long <= this.jdField_b_of_type_Long)) {
        continue;
      }
      str3 = this.jdField_c_of_type_Long - this.jdField_b_of_type_Long + "";
      if ((parambimw.jdField_b_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L) || (this.jdField_c_of_type_Long <= parambimw.jdField_b_of_type_Long)) {
        continue;
      }
      str4 = this.jdField_c_of_type_Long - parambimw.jdField_b_of_type_Long + "";
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "downloadCost:" + (String)localObject1 + ", installCost:" + str2 + ", launchCost:" + str3 + ", allCost:" + str4 + ",[startTime-launchTime]=[" + parambimw.jdField_b_of_type_Long + "-" + this.jdField_c_of_type_Long + "]");
      }
      VipUtils.a(null, "VIPCOMIC", "0X80052CA", "0X80052CA", parambimw.jdField_a_of_type_Int, paramInt, new String[] { localObject2 });
      VipUtils.a(null, "VIPCOMIC", "0X8005359", "0X8005359", parambimw.jdField_a_of_type_Int, paramInt, new String[] { localObject1, str2, str3, str4 });
      return;
      if (i != 3) {
        continue;
      }
      localObject1 = "3";
    }
  }
  
  void b(bimw parambimw)
  {
    if (parambimw == null) {
      return;
    }
    Object localObject = ((ActivityManager)getApplication().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!"com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName));
    }
    for (int i = 1;; i = 0)
    {
      if (parambimw.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_Bhtd.sendEmptyMessage(1000);
      }
      this.jdField_a_of_type_Boolean = QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk");
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "plugin is not running...");
        }
        if (i == 0) {
          SystemClock.sleep(500L);
        }
        biof.a(this);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", parambimw.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - parambimw.jdField_b_of_type_Long), "1" });
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQComicDebug", 2, "plugin is running...");
      return;
    }
  }
  
  public void c(bimw parambimw)
  {
    if (parambimw == null) {
      return;
    }
    if (!parambimw.jdField_f_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "skip launch activity.");
      }
      finish();
      return;
    }
    a(this, parambimw);
    VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", parambimw.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - parambimw.jdField_b_of_type_Long) });
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    bimw localbimw = a(getIntent());
    this.jdField_a_of_type_Bimw = localbimw;
    if (a(this.app, this, localbimw)) {
      finish();
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
    paramBundle.addAction("com.tencent.mobileqq.PreLoadComicProcess");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bimy(this);
    getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate registerReceiver");
    }
    setContentView(2131562821);
    setTitle(2131721398);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369783));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369787));
    this.jdField_a_of_type_Biqn = ((biqn)this.app.getManager(27));
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("VipComicJumpActivity onCreate mPluginManager = ");
      if (this.jdField_a_of_type_Biqn != null) {
        break label284;
      }
    }
    label284:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(this.jdField_a_of_type_Biqn.isReady()))
    {
      QLog.d("VipComicJumpActivity", 2, paramBundle);
      this.jdField_a_of_type_Bhtd = new bhtd(this);
      VipUtils.a(null, "VIPCOMIC", "0X8005FC7", "0X8005FC7", localbimw.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - localbimw.jdField_b_of_type_Long) });
      paramBundle = (biml)this.app.getManager(142);
      if (paramBundle != null)
      {
        paramBundle.a(System.currentTimeMillis());
        paramBundle.b();
      }
      a(localbimw);
      return true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
      } while (this.jdField_a_of_type_Bimw == null);
      if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "do handle launch activity.");
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Boolean = true;
        c(this.jdField_a_of_type_Bimw);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.jdField_a_of_type_Bimw.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bimw.jdField_b_of_type_Long), "2" });
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QQComicDebug", 2, "skip handle launch activity.");
        continue;
        String str = paramMessage.arg1 + "%";
        paramMessage = String.valueOf(paramMessage.obj);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Biqn.a("comic_plugin.apk");
    boolean bool = getIntent().getBooleanExtra("has_red_dot", false);
    int i;
    if (this.jdField_a_of_type_Bimw != null)
    {
      if (localObject != null) {
        break label166;
      }
      j = this.jdField_a_of_type_Bimw.jdField_a_of_type_Int;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Bimw.jdField_b_of_type_Long;
      if (!this.jdField_a_of_type_Boolean) {
        break label129;
      }
      i = 0;
      if (!bool) {
        break label158;
      }
    }
    label129:
    label158:
    for (localObject = "1";; localObject = "0")
    {
      VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), "-9999", String.valueOf(i), localObject });
      return super.onBackEvent();
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break;
        }
        i = 3;
        break;
      }
      i = 4;
      break;
    }
    label166:
    int j = this.jdField_a_of_type_Bimw.jdField_a_of_type_Int;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Bimw.jdField_b_of_type_Long;
    int k = ((PluginBaseInfo)localObject).mState;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      label203:
      if (!bool) {
        break label293;
      }
    }
    label293:
    for (localObject = "1";; localObject = "0")
    {
      VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(k), String.valueOf(i), localObject });
      break;
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break label203;
        }
        i = 3;
        break label203;
      }
      i = 4;
      break label203;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bhtd != null)
    {
      this.jdField_a_of_type_Bhtd.removeMessages(1000);
      this.jdField_a_of_type_Bhtd.removeMessages(1001);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (QLog.isColorLevel()) {
        QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate unregisterReceiver");
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "VipComicJumpActivity onDestroy");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity
 * JD-Core Version:    0.7.0.1
 */