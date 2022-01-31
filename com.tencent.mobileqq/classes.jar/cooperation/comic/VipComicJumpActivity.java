package cooperation.comic;

import amjj;
import amjk;
import amjm;
import amjn;
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
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.StringBuilderUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.emoticon.VipComicEmoticonUploadRemoteCmd;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicRedTouchManager;
import cooperation.comic.utils.VipComicUrlHelper;
import cooperation.plugin.IPluginManager;
import eipc.EIPCClient;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class VipComicJumpActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static final String a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public WeakReferenceHandler a;
  public VipComicJumpActivity.ComicParam a;
  public IPluginManager a;
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  TextView b;
  public volatile boolean b;
  long c;
  public boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = VipComicJumpActivity.class.getName();
  }
  
  public VipComicJumpActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam = null;
  }
  
  static int a(String paramString)
  {
    if ("index".equalsIgnoreCase(paramString)) {}
    do
    {
      return 0;
      if ("fav".equalsIgnoreCase(paramString)) {
        return 1;
      }
      if ("category".equalsIgnoreCase(paramString)) {
        return 2;
      }
      if ("more".equalsIgnoreCase(paramString)) {
        return 3;
      }
    } while (!"group".equalsIgnoreCase(paramString));
    return 4;
  }
  
  public static VipComicJumpActivity.ComicParam a(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent == null) {
      return null;
    }
    VipComicJumpActivity.ComicParam localComicParam = new VipComicJumpActivity.ComicParam();
    localComicParam.jdField_a_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    localComicParam.jdField_b_of_type_Long = System.currentTimeMillis();
    if (localComicParam.jdField_a_of_type_Long <= 0L) {
      localComicParam.jdField_a_of_type_Long = localComicParam.jdField_b_of_type_Long;
    }
    localComicParam.l = paramIntent.getBooleanExtra("has_red_dot", false);
    Object localObject1 = paramIntent.getStringExtra("from_leba");
    Object localObject2 = paramIntent.getStringExtra("from_leba_mgr");
    String str = paramIntent.getStringExtra("cfrom");
    if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("fromleba")))
    {
      localComicParam.jdField_a_of_type_Int = 1006002;
      localObject1 = null;
    }
    label179:
    label439:
    label726:
    label1110:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "getFromInfoFromIntent sourceFrom = " + localComicParam.jdField_a_of_type_Int + ", extUrlParam = " + localComicParam.jdField_a_of_type_JavaLangString);
      }
      int i;
      if (localComicParam.jdField_a_of_type_Int == 1006002)
      {
        localComicParam.jdField_f_of_type_JavaLangString = "动态";
        localObject2 = VipComicRemoteCommand.a(null);
        if ((localObject2 == null) || ((localComicParam.jdField_a_of_type_Int != 1006002) && (localComicParam.jdField_a_of_type_Int != 19) && (localComicParam.jdField_a_of_type_Int != 20))) {
          break label726;
        }
        i = 1;
        label222:
        if (i == 0) {
          break label763;
        }
        i = ((Bundle)localObject2).getInt("type", -1);
        if ((i < 100) || (i > 300)) {
          break label731;
        }
        localComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
        label255:
        localComicParam.jdField_a_of_type_Amjm = new amjm();
        localComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_JavaLangString = ((Bundle)localObject2).getString("comicId");
        localComicParam.jdField_a_of_type_Amjm.jdField_b_of_type_JavaLangString = ((Bundle)localObject2).getString("sectionId");
        localComicParam.jdField_a_of_type_Amjm.jdField_c_of_type_JavaLangString = ((Bundle)localObject2).getString("pictureId");
        localComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_Int = ((Bundle)localObject2).getInt("offset", -1);
        localComicParam.jdField_a_of_type_Amjm.jdField_b_of_type_Int = ((Bundle)localObject2).getInt("type", -1);
        localComicParam.jdField_a_of_type_Amjm.jdField_c_of_type_Int = ((Bundle)localObject2).getInt("player", 2);
        localComicParam.jdField_a_of_type_Amjm.jdField_e_of_type_JavaLangString = ((Bundle)localObject2).getString("cloudUrl", "");
        if (!"com.qqcomic.activity.media.VipComicMediaPlayActivity".equals(localComicParam.jdField_b_of_type_JavaLangString)) {
          break label754;
        }
        localComicParam.jdField_a_of_type_Boolean = false;
        localComicParam.jdField_c_of_type_Boolean = ((Bundle)localObject2).getBoolean("isPlayerLocked", false);
        if (((Bundle)localObject2).getBoolean("supportMiniPlayer", false)) {
          break label742;
        }
        bool = true;
        localComicParam.jdField_e_of_type_Boolean = bool;
        if (!localComicParam.jdField_e_of_type_Boolean) {
          break label747;
        }
        localObject1 = "";
        localComicParam.jdField_a_of_type_Amjm.jdField_d_of_type_JavaLangString = a("comicDetailVideo", null, null, "1", "354", null, (String)localObject1 + "ADTAG=comic.plugin.fav&id=" + localComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        for (;;)
        {
          if (TextUtils.isEmpty(localComicParam.jdField_d_of_type_JavaLangString)) {
            localComicParam.jdField_d_of_type_JavaLangString = VipComicHelper.a();
          }
          if ((paramIntent.hasExtra("banner_fromBanner")) && (paramIntent.getBooleanExtra("banner_fromBanner", false)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VipComicJumpActivity", 2, "come from AIO Banner!");
            }
            if ((localComicParam.jdField_a_of_type_Amjm != null) && (!TextUtils.isEmpty(localComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_JavaLangString))) {
              VipComicReportUtils.a(null, "100007", "2", "40040", localComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_JavaLangString, new String[0]);
            }
          }
          return localComicParam;
          if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase("fromlebamgr")))
          {
            localComicParam.jdField_a_of_type_Int = 1006003;
            localObject1 = null;
            break;
          }
          if (!TextUtils.isEmpty(str))
          {
            localComicParam.jdField_a_of_type_Int = Integer.valueOf(str).intValue();
            localObject1 = null;
            break;
          }
          try
          {
            for (;;)
            {
              localObject1 = paramIntent.getStringExtra("options");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1110;
              }
              localObject1 = new JSONObject((String)localObject1);
              try
              {
                localComicParam.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("from");
                localComicParam.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("extUrlParam");
              }
              catch (Exception localException1) {}
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              label731:
              label742:
              label747:
              label754:
              label763:
              JSONObject localJSONObject;
              label1019:
              localObject1 = null;
            }
            localObject1 = null;
          }
        }
        localException1.printStackTrace();
        break;
        if (localComicParam.jdField_a_of_type_Int != 1006003) {
          break label179;
        }
        localComicParam.jdField_f_of_type_JavaLangString = "更多";
        break label179;
        i = 0;
        break label222;
        localComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.reader.VipComicPortraitReadingActivity";
        break label255;
        bool = false;
        break label422;
        localObject1 = "init_player=1&";
        break label439;
        localComicParam.jdField_a_of_type_Boolean = true;
        continue;
        if (localObject1 != null)
        {
          localComicParam.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
          if (!((JSONObject)localObject1).optBoolean("newInstance"))
          {
            localComicParam.jdField_d_of_type_Boolean = bool;
            if (((JSONObject)localObject1).has("url")) {
              localComicParam.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("url");
            }
          }
          try
          {
            localComicParam.jdField_c_of_type_JavaLangString = URLDecoder.decode(localComicParam.jdField_c_of_type_JavaLangString);
            if (VipComicHelper.a(localComicParam.jdField_c_of_type_JavaLangString, localComicParam.jdField_a_of_type_AndroidContentIntent)) {
              localComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
            }
            if (((JSONObject)localObject1).has("comic")) {}
            try
            {
              localJSONObject = new JSONObject(((JSONObject)localObject1).optString("comic"));
              localComicParam.jdField_a_of_type_Amjm = new amjm();
              localComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_JavaLangString = localJSONObject.optString("comicID");
              localComicParam.jdField_a_of_type_Amjm.jdField_b_of_type_JavaLangString = localJSONObject.optString("comicSectionID");
              localComicParam.jdField_a_of_type_Amjm.jdField_c_of_type_JavaLangString = localJSONObject.optString("comicPageID");
              localComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_Int = localJSONObject.optInt("comicPageOffset");
              localComicParam.jdField_a_of_type_Amjm.jdField_b_of_type_Int = localJSONObject.optInt("type");
              localComicParam.jdField_a_of_type_Boolean = localJSONObject.optBoolean("returnToDetail");
              localComicParam.jdField_a_of_type_Amjm.jdField_c_of_type_Int = localJSONObject.optInt("player", 2);
              localComicParam.jdField_a_of_type_Amjm.jdField_e_of_type_JavaLangString = localJSONObject.optString("cloudUrl", "");
              if (((JSONObject)localObject1).has("maintab")) {
                localComicParam.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("maintab");
              }
              if (((JSONObject)localObject1).has("subtab")) {
                localComicParam.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("subtab");
              }
              if (((JSONObject)localObject1).has("leftViewText"))
              {
                localComicParam.jdField_f_of_type_JavaLangString = ((JSONObject)localObject1).optString("leftViewText");
                continue;
                bool = false;
              }
            }
            catch (JSONException localJSONException)
            {
              break label1019;
            }
          }
          catch (Exception localException2)
          {
            break label833;
          }
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = VipComicNavConfigHelper.a(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.jdField_a_of_type_JavaLangString; TextUtils.isEmpty(paramString1); paramString1 = null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str2 = (String)IndividuationUrlHelper.a().get(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = VipComicUrlHelper.a(paramString1);
    }
    return b(str1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString1 = VipComicNavConfigHelper.a(paramString1);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.jdField_b_of_type_JavaLangString;; paramString1 = null)
    {
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = VipComicUrlHelper.a(paramString2);
      }
      return b(str, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
    }
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
      VipComicRemoteCommand.a((QQAppInterface)paramAppInterface);
      VipComicEmoticonUploadRemoteCmd.a((QQAppInterface)paramAppInterface);
      if (paramBoolean) {
        ThreadManager.postImmediately(new amjj((QQAppInterface)paramAppInterface), null, true);
      }
      paramAppInterface = (VipComicMqqHandler)paramAppInterface.getBusinessHandler(80);
      if (paramAppInterface != null) {
        paramAppInterface.c();
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
  
  static void a(AppRuntime paramAppRuntime, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramAppRuntime == null) || (paramComicParam == null)) {
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
      localObject1 = LebaShowListManager.a().a();
      if (localObject1 == null) {
        break label960;
      }
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (LebaViewItem)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 1113L));
    }
    label405:
    label664:
    label669:
    label822:
    label955:
    label960:
    for (int i = ((LebaViewItem)localObject2).jdField_a_of_type_Byte;; i = -1)
    {
      label119:
      label122:
      String str;
      if (i == 0)
      {
        bool1 = true;
        localObject1 = null;
        if (!bool1) {
          break label516;
        }
        localObject6 = "1113." + 100800;
        localObject5 = "1113." + 100802;
        localObject4 = "1113." + 100803;
        localObject3 = "1113." + 100804;
        localObject2 = "1113." + 100801;
        str = String.valueOf(1113);
        label254:
        if (!bool2) {
          break label669;
        }
        paramAppRuntime = (RedTouchManager)paramAppRuntime.getManager(35);
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
          break label644;
        }
        bool1 = true;
        label338:
        paramComicParam.jdField_g_of_type_Boolean = bool1;
        if ((paramAppRuntime == null) || (paramAppRuntime.iNewFlag.get() == 0)) {
          break label649;
        }
        bool1 = true;
        label359:
        paramComicParam.h = bool1;
        if ((localObject3 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() == 0)) {
          break label654;
        }
        bool1 = true;
        label382:
        paramComicParam.i = bool1;
        if ((localObject5 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() == 0)) {
          break label659;
        }
        bool1 = true;
        paramComicParam.j = bool1;
        if ((localObject4 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() == 0)) {
          break label664;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paramComicParam.k = bool1;
        if ((localObject1 != null) && (paramComicParam.l)) {
          a(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get(), ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get(), paramComicParam);
        }
        label466:
        if (!QLog.isColorLevel()) {
          break label933;
        }
        QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo end");
        return;
        bool1 = false;
        break label119;
        localObject1 = (QQComicRedTouchManager)paramAppRuntime.getManager(212);
        if (localObject1 == null) {
          break;
        }
        bool1 = ((QQComicRedTouchManager)localObject1).a(1113);
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
        break label359;
        bool1 = false;
        break label382;
        bool1 = false;
        break label405;
      }
      paramAppRuntime = new ArrayList();
      paramAppRuntime.add(str);
      paramAppRuntime.add(localObject6);
      paramAppRuntime.add(localObject2);
      paramAppRuntime.add(localObject3);
      paramAppRuntime.add(localObject5);
      paramAppRuntime.add(localObject4);
      paramAppRuntime = ((QQComicRedTouchManager)localObject1).a(paramAppRuntime);
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
        paramComicParam.jdField_g_of_type_Boolean = bool1;
        if ((paramAppRuntime == null) || (paramAppRuntime.b() == 0)) {
          break label940;
        }
        bool1 = true;
        label840:
        paramComicParam.h = bool1;
        if ((localObject3 == null) || (((RedAppInfo)localObject3).b() == 0)) {
          break label945;
        }
        bool1 = true;
        label860:
        paramComicParam.i = bool1;
        if ((localObject5 == null) || (((RedAppInfo)localObject5).b() == 0)) {
          break label950;
        }
        bool1 = true;
        label880:
        paramComicParam.j = bool1;
        if ((localObject4 == null) || (((RedAppInfo)localObject4).b() == 0)) {
          break label955;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramComicParam.k = bool1;
        if ((localObject1 == null) || (!paramComicParam.l)) {
          break label466;
        }
        a(((RedAppInfo)localObject1).a(), ((RedAppInfo)localObject1).a(), paramComicParam);
        break label466;
        break;
        bool1 = false;
        break label822;
        bool1 = false;
        break label840;
        bool1 = false;
        break label860;
        bool1 = false;
        break label880;
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramAppInterface == null) || (paramActivity == null) || (paramComicParam == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "handle param start");
    }
    Object localObject3;
    String str1;
    Object localObject2;
    Object localObject4;
    if (("com.qqcomic.activity.VipComicMainTabActivity".equals(paramComicParam.jdField_b_of_type_JavaLangString)) && (paramComicParam.jdField_d_of_type_JavaLangString == null))
    {
      i = 1;
      if ((paramComicParam.jdField_a_of_type_Int != 12) || (i == 0)) {
        break label300;
      }
      localObject3 = paramActivity.getSharedPreferences("vip_comic_file", 4);
      if (!((SharedPreferences)localObject3).getBoolean("restore_flag", false)) {
        break label300;
      }
      str1 = ((SharedPreferences)localObject3).getString("base_package", "");
      localObject2 = ((SharedPreferences)localObject3).getString("base_activity", "");
      i = ((SharedPreferences)localObject3).getInt("activity_task_id", -1);
      localObject3 = ((ActivityManager)paramActivity.getApplication().getApplicationContext().getSystemService("activity")).getRunningTasks(100);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break label300;
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
        ((Intent)localObject3).setComponent(new ComponentName(str1, (String)localObject2));
        ((Intent)localObject3).addFlags(269500416);
        try
        {
          paramActivity.startActivity((Intent)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "handle param restore stack end");
          }
          return true;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        i = 0;
        break;
      }
      label300:
      Object localObject1;
      if ("com.qqcomic.activity.VipComicMainTabActivity".equals(paramComicParam.jdField_b_of_type_JavaLangString))
      {
        a(paramAppInterface, paramComicParam);
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "handle param parse red touch end");
        }
        if (paramComicParam.m)
        {
          paramAppInterface = HtmlOffline.a(paramComicParam.jdField_g_of_type_JavaLangString, "returnIndex=true");
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("url", paramAppInterface);
          ((Intent)localObject1).putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
          ((Intent)localObject1).putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
          VipComicHelper.a(paramActivity, (Intent)localObject1, -1);
          if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "jump to comic activity page directly, url=" + paramAppInterface);
          }
          return true;
        }
        paramAppInterface = new ArrayList();
        localObject1 = new WebViewTabBarData();
        localObject2 = a("NavConfig", "首页");
        ((WebViewTabBarData)localObject1).tag = ((String)localObject2);
        ((WebViewTabBarData)localObject1).tabName = ((String)localObject2);
        j = paramActivity.getResources().getDimensionPixelSize(2131558448);
        i = j;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i = j + ImmersiveUtils.a(paramActivity);
        }
        i = (int)((i - 0.5F) / paramActivity.getResources().getDisplayMetrics().density);
        ((WebViewTabBarData)localObject1).url = a("NavConfig", "comicIndex", null, "64", "5", "", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.jdField_g_of_type_Boolean + "&_titleBarHeight=" + i);
        ((WebViewTabBarData)localObject1).tabIcon = VipComicNavConfigHelper.a("NavConfig");
        localObject2 = new WebViewTabBarData();
        localObject3 = a("FavNavConfig", "收藏");
        ((WebViewTabBarData)localObject2).tag = ((String)localObject3);
        ((WebViewTabBarData)localObject2).tabName = ((String)localObject3);
        ((WebViewTabBarData)localObject2).url = a("FavNavConfig", "comicFav", null, "", "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.h + "&_titleBarHeight=" + i);
        ((WebViewTabBarData)localObject2).tabIcon = VipComicNavConfigHelper.a("FavNavConfig");
        localObject3 = new WebViewTabBarData();
        localObject4 = a("CateNavConfig", "分类");
        ((WebViewTabBarData)localObject3).tag = ((String)localObject4);
        ((WebViewTabBarData)localObject3).tabName = ((String)localObject4);
        ((WebViewTabBarData)localObject3).url = a("CateNavConfig", "comicCategory", null, null, "1", "354", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.i + "&_titleBarHeight=" + i);
        ((WebViewTabBarData)localObject3).tabIcon = VipComicNavConfigHelper.a("CateNavConfig");
        localObject4 = new WebViewTabBarData();
        Object localObject5 = a("MoreNavConfig", "社区");
        ((WebViewTabBarData)localObject4).tag = ((String)localObject5);
        ((WebViewTabBarData)localObject4).tabName = ((String)localObject5);
        ((WebViewTabBarData)localObject4).url = a("MoreNavConfig", "comicMore", null, null, "1", "354", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.j + "&_titleBarHeight=" + i);
        ((WebViewTabBarData)localObject4).tabIcon = VipComicNavConfigHelper.a("MoreNavConfig");
        localObject5 = new WebViewTabBarData();
        String str2 = a("GroupNavConfig", "部屋");
        ((WebViewTabBarData)localObject5).tag = str2;
        ((WebViewTabBarData)localObject5).tabName = str2;
        ((WebViewTabBarData)localObject5).url = a("GroupNavConfig", "comicGroup", null, null, "1", "354", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.k + "&_titleBarHeight=" + i);
        ((WebViewTabBarData)localObject5).tabIcon = VipComicNavConfigHelper.a("GroupNavConfig");
        paramAppInterface.add(localObject1);
        paramAppInterface.add(localObject2);
        paramAppInterface.add(localObject3);
        paramAppInterface.add(localObject4);
        paramAppInterface.add(localObject5);
        i = 0;
        if (paramComicParam.jdField_d_of_type_JavaLangString == null) {
          break label1656;
        }
      }
      label1468:
      label1656:
      for (int j = a(paramComicParam.jdField_d_of_type_JavaLangString);; j = 0)
      {
        localObject1 = (WebViewTabBarData)paramAppInterface.get(j);
        ((WebViewTabBarData)localObject1).url = HtmlOffline.a(((WebViewTabBarData)localObject1).url, "isDefaultTab=1");
        if (paramComicParam.jdField_e_of_type_JavaLangString != null) {}
        try
        {
          i = Integer.parseInt(paramComicParam.jdField_e_of_type_JavaLangString);
          if ((!TextUtils.isEmpty(paramComicParam.jdField_a_of_type_JavaLangString)) && (j >= 0) && (j < paramAppInterface.size()))
          {
            localObject1 = (WebViewTabBarData)paramAppInterface.get(j);
            ((WebViewTabBarData)localObject1).url = HtmlOffline.a(((WebViewTabBarData)localObject1).url, "extUrlParam=" + URLEncoder.encode(paramComicParam.jdField_a_of_type_JavaLangString));
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("tabConfigData", paramAppInterface);
          ((Intent)localObject1).putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
          ((Intent)localObject1).putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
          ((Intent)localObject1).putExtra("key_maintab", j);
          ((Intent)localObject1).putExtra("key_subtab", i);
          if (TextUtils.isEmpty(paramComicParam.jdField_f_of_type_JavaLangString))
          {
            paramAppInterface = paramActivity.getString(2131433698);
            ((Intent)localObject1).putExtra("selfSet_leftViewText", paramAppInterface);
            if ((paramComicParam.jdField_a_of_type_Int == 1006002) || (paramComicParam.jdField_a_of_type_Int == 1006003))
            {
              if (paramComicParam.jdField_a_of_type_Int != 1006002) {
                break label1468;
              }
              i = 40400;
              ((Intent)localObject1).putExtra("individuation_url_type", i);
            }
            if (paramComicParam.jdField_d_of_type_Boolean) {
              ((Intent)localObject1).setFlags(((Intent)localObject1).getFlags() | 0x4000000 | 0x10000000);
            }
            VipComicHelper.a(paramActivity, (Intent)localObject1, -1);
            VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
            if (QLog.isColorLevel()) {
              QLog.d("QQComicDebug", 2, "handle param open main tab end");
            }
            return true;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = 0;
            continue;
            paramAppInterface = paramComicParam.jdField_f_of_type_JavaLangString;
            continue;
            i = 40401;
          }
        }
        if ("com.qqcomic.activity.VipComicTabBrowserActivity".equals(paramComicParam.jdField_b_of_type_JavaLangString))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", paramComicParam.jdField_c_of_type_JavaLangString);
          localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
          localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
          if (TextUtils.isEmpty(paramComicParam.jdField_f_of_type_JavaLangString)) {}
          for (paramAppInterface = paramActivity.getString(2131433698);; paramAppInterface = paramComicParam.jdField_f_of_type_JavaLangString)
          {
            localIntent.putExtra("selfSet_leftViewText", paramAppInterface);
            VipComicHelper.a(paramActivity, localIntent, -1);
            VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
            if (QLog.isColorLevel()) {
              QLog.d("QQComicDebug", 2, "handle param open web end");
            }
            return true;
          }
        }
        paramComicParam.jdField_f_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "handle param end");
        }
        return false;
      }
    }
  }
  
  static boolean a(String paramString, List paramList, VipComicJumpActivity.ComicParam paramComicParam)
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
                  paramComicParam.m = "redirect".equals(((JSONObject)localObject).optString("type"));
                  if (paramComicParam.m)
                  {
                    localObject = ((JSONObject)localObject).optString("link");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      break;
                    }
                    paramComicParam.m = false;
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
        paramComicParam.jdField_g_of_type_JavaLangString = localException;
        return true;
      }
    }
    label184:
    return false;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = StringBuilderUtils.a();
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
    return HtmlOffline.a(paramString1, localStringBuilder.toString());
  }
  
  void a(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramActivity == null) || (paramComicParam == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "call start plugin activity start.");
    }
    Intent localIntent = paramComicParam.jdField_a_of_type_AndroidContentIntent;
    localIntent.putExtra("begin_to_load_comic_plugin", System.currentTimeMillis());
    localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
    localIntent.putExtra("pluginFinished", this.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(paramComicParam.jdField_c_of_type_JavaLangString)) {
      localIntent.putExtra("url", paramComicParam.jdField_c_of_type_JavaLangString);
    }
    if (paramComicParam.jdField_a_of_type_Amjm != null)
    {
      localIntent.putExtra("key_comic_id", paramComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_section_id", paramComicParam.jdField_a_of_type_Amjm.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_pic_id", paramComicParam.jdField_a_of_type_Amjm.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("key_pic_offset_ratio", paramComicParam.jdField_a_of_type_Amjm.jdField_a_of_type_Int);
      localIntent.putExtra("key_type", paramComicParam.jdField_a_of_type_Amjm.jdField_b_of_type_Int);
      localIntent.putExtra("key_jump_from_out_plugin", true);
      localIntent.putExtra("key_return_to_detail", paramComicParam.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_is_player_locked", paramComicParam.jdField_c_of_type_Boolean);
      localIntent.putExtra("key_return_to_home_from_detail", paramComicParam.jdField_b_of_type_Boolean);
      localIntent.putExtra("key_is_fullscreen", paramComicParam.jdField_e_of_type_Boolean);
      localIntent.putExtra("key_video_player_type", paramComicParam.jdField_a_of_type_Amjm.jdField_c_of_type_Int);
      localIntent.putExtra("key_cloud_url", paramComicParam.jdField_a_of_type_Amjm.jdField_e_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramComicParam.jdField_a_of_type_Amjm.jdField_d_of_type_JavaLangString)) {
        localIntent.putExtra("url", paramComicParam.jdField_a_of_type_Amjm.jdField_d_of_type_JavaLangString);
      }
    }
    localIntent.putExtra("key_source_from", paramComicParam.jdField_a_of_type_Int);
    if (TextUtils.isEmpty(paramComicParam.jdField_f_of_type_JavaLangString))
    {
      localIntent.putExtra("selfSet_leftViewText", getString(2131433698));
      label341:
      if (paramComicParam.jdField_d_of_type_Boolean) {
        localIntent.addFlags(67108864);
      }
      localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label605;
      }
    }
    label605:
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("reportProcessExistFlag", i);
      localIntent.putExtra("reportLebaClick", paramComicParam.jdField_a_of_type_Long);
      localIntent.putExtra("reportJumpActivityOnCreate", paramComicParam.jdField_b_of_type_Long);
      if ((paramComicParam.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long > paramComicParam.jdField_b_of_type_Long)) {
        localIntent.putExtra("reportDownloadTime", this.jdField_a_of_type_Long - paramComicParam.jdField_b_of_type_Long);
      }
      if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long)) {
        localIntent.putExtra("reportInstallTime", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
      }
      localIntent.putExtra("reportStartPluginTime", System.currentTimeMillis());
      localIntent.putExtra("isFromJumpActivity", true);
      PluginPreloadReportUtils.HitRateHelper localHitRateHelper = PluginPreloadReportUtils.a(2);
      PreloadProcHitPluginSession localPreloadProcHitPluginSession = null;
      if (localHitRateHelper != null)
      {
        localHitRateHelper.a();
        localPreloadProcHitPluginSession = localHitRateHelper.a;
      }
      QQComicPluginBridge.a(paramActivity, localIntent, paramComicParam.jdField_b_of_type_JavaLangString, localPreloadProcHitPluginSession);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQComicDebug", 2, "call start plugin activity end.");
      return;
      localIntent.putExtra("selfSet_leftViewText", paramComicParam.jdField_f_of_type_JavaLangString);
      break label341;
    }
  }
  
  public void a(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin start");
    }
    a(this.app, false);
    ThreadManager.postImmediately(new amjk(this, this.app, paramComicParam), null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin end");
    }
  }
  
  public void a(VipComicJumpActivity.ComicParam paramComicParam, int paramInt)
  {
    if (paramComicParam == null) {
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
        localObject1 = (SVIPHandler)this.app.a(13);
        if (localObject1 == null) {
          continue;
        }
        i = ((SVIPHandler)localObject1).j();
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
        if ((paramComicParam.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long <= paramComicParam.jdField_b_of_type_Long)) {
          continue;
        }
        String str1 = this.jdField_a_of_type_Long - paramComicParam.jdField_b_of_type_Long + "";
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
      if ((paramComicParam.jdField_b_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L) || (this.jdField_c_of_type_Long <= paramComicParam.jdField_b_of_type_Long)) {
        continue;
      }
      str4 = this.jdField_c_of_type_Long - paramComicParam.jdField_b_of_type_Long + "";
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "downloadCost:" + (String)localObject1 + ", installCost:" + str2 + ", launchCost:" + str3 + ", allCost:" + str4 + ",[startTime-launchTime]=[" + paramComicParam.jdField_b_of_type_Long + "-" + this.jdField_c_of_type_Long + "]");
      }
      VipUtils.a(null, "VIPCOMIC", "0X80052CA", "0X80052CA", paramComicParam.jdField_a_of_type_Int, paramInt, new String[] { localObject2 });
      VipUtils.a(null, "VIPCOMIC", "0X8005359", "0X8005359", paramComicParam.jdField_a_of_type_Int, paramInt, new String[] { localObject1, str2, str3, str4 });
      return;
      if (i != 3) {
        continue;
      }
      localObject1 = "3";
    }
  }
  
  public void b(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramComicParam == null) {
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
      if (paramComicParam.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1000);
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
        QQComicPluginBridge.a(this);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long), "1" });
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQComicDebug", 2, "plugin is running...");
      return;
    }
  }
  
  public void c(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramComicParam == null) {
      return;
    }
    if (!paramComicParam.jdField_f_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "skip launch activity.");
      }
      finish();
      return;
    }
    a(this, paramComicParam);
    VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VipComicJumpActivity.ComicParam localComicParam = a(getIntent());
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam = localComicParam;
    if (a(this.app, this, localComicParam)) {
      finish();
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
    paramBundle.addAction("com.tencent.mobileqq.PreLoadComicProcess");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new amjn(this);
    getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate registerReceiver");
    }
    setContentView(2130971716);
    setTitle(2131437987);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375430));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363452));
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("VipComicJumpActivity onCreate mPluginManager = ");
      if (this.jdField_a_of_type_CooperationPluginIPluginManager != null) {
        break label284;
      }
    }
    label284:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()))
    {
      QLog.d("VipComicJumpActivity", 2, paramBundle);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
      VipUtils.a(null, "VIPCOMIC", "0X8005FC7", "0X8005FC7", localComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - localComicParam.jdField_b_of_type_Long) });
      paramBundle = (QQComicPreloadManager)this.app.getManager(141);
      if (paramBundle != null)
      {
        paramBundle.a(System.currentTimeMillis());
        paramBundle.b();
      }
      a(localComicParam);
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
      } while (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam == null);
      if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "do handle launch activity.");
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Boolean = true;
        c(this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_b_of_type_Long), "2" });
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
  
  protected boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_CooperationPluginIPluginManager.a("comic_plugin.apk");
    boolean bool = getIntent().getBooleanExtra("has_red_dot", false);
    int i;
    if (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam != null)
    {
      if (localObject != null) {
        break label166;
      }
      j = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_a_of_type_Int;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_b_of_type_Long;
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
    int j = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_a_of_type_Int;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_b_of_type_Long;
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
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1000);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity
 * JD-Core Version:    0.7.0.1
 */