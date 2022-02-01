import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.1;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.2;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.6;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.7;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopCanvasFragment;
import com.tencent.biz.pubaccount.ecshopassit.ShopVideoCeilingFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class onq
  implements Manager
{
  public static int a;
  public static final String a;
  public static HashMap<String, String> a;
  public static boolean a;
  public static final String b;
  public static HashMap<String, Long> b;
  public static List<String> b;
  public static String c;
  public static List<String> c;
  public static String d;
  private static List<String> d;
  public static int e;
  public static final String e;
  private static List<String> e;
  public static int f;
  public static final String f;
  private static List<String> f;
  public static String g;
  public static final String h;
  public long a;
  public BroadcastReceiver a;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  public QQAppInterface a;
  FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new ons(this);
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  public List<EcShopData> a;
  private Map<String, EcShopData> jdField_a_of_type_JavaUtilMap;
  public Set<String> a;
  private ont jdField_a_of_type_Ont;
  public String[] a;
  public int b;
  public long b;
  public final Object b;
  public boolean b;
  public int c;
  private long c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e;
  public boolean f;
  private boolean g;
  private boolean h;
  public String i;
  public String j;
  public String k;
  private String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "shop_assit_banner_json.txt";
    jdField_b_of_type_JavaLangString = AppConstants.SDCARD_PATH + ".shop_assit/image/";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Int = 600000;
    jdField_e_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";
    jdField_f_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_jd_conf.json";
    jdField_a_of_type_Boolean = true;
    jdField_h_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsoluteFile() + File.separator + "animConfig/red_packet.png";
    jdField_e_of_type_Int = 102636;
    jdField_f_of_type_Int = 102632;
    jdField_d_of_type_JavaUtilList = new ArrayList();
    jdField_e_of_type_JavaUtilList = new ArrayList();
    jdField_f_of_type_JavaUtilList = new ArrayList();
    jdField_f_of_type_JavaUtilList.add("3046055438");
    jdField_f_of_type_JavaUtilList.add("2711679534");
  }
  
  public onq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3" };
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new onr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.l = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
      ThreadManager.post(new EcShopAssistantManager.1(this), 5, null, true);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener);
      this.jdField_a_of_type_Ont = new ont(this);
      return;
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 1: 
      return 1;
    case 3000: 
      return 2;
    }
    return 3;
  }
  
  public static int a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      int m = a(new JSONObject(paramString));
      return m;
    }
    catch (Exception paramString)
    {
      QLog.e("EcShopAssistantManager", 1, paramString, new Object[0]);
    }
    return -1;
  }
  
  public static int a(JSONObject paramJSONObject)
  {
    int n = 1;
    int m;
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("ext");
        if (paramJSONObject == null) {
          continue;
        }
        paramJSONObject = paramJSONObject.optJSONArray("exp_map");
        if (paramJSONObject != null) {
          continue;
        }
        return -1;
      }
      catch (Exception paramJSONObject)
      {
        Object localObject;
        int i1;
        boolean bool;
        QLog.e("EcShopAssistantManager", 1, paramJSONObject, new Object[0]);
        return -1;
        m = 0;
        continue;
      }
      if (m >= paramJSONObject.length()) {
        continue;
      }
      localObject = paramJSONObject.optJSONObject(m);
      i1 = ((JSONObject)localObject).optInt("key");
      localObject = ((JSONObject)localObject).optString("value");
      if (i1 == jdField_f_of_type_Int)
      {
        if ("1".equals(localObject)) {
          return n;
        }
        bool = "2".equals(localObject);
        if (!bool) {
          continue;
        }
        return 2;
      }
      m += 1;
    }
    return m;
  }
  
  public static SharedPreferences a()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("ecshop_sp" + str1, 0);
  }
  
  public static Drawable a(Context paramContext)
  {
    if (!TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
    {
      Object localObject1 = paramContext.getResources().getDrawable(2130839568);
      Object localObject2 = jdField_d_of_type_JavaLangString.split("/");
      localObject2 = jdField_b_of_type_JavaLangString + localObject2[(localObject2.length - 1)];
      String str = jdField_d_of_type_JavaLangString;
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_icon", str, (String)localObject2), (Drawable)localObject1, (Drawable)localObject1);
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return paramContext.getResources().getDrawable(2130847047);
      }
    }
    return paramContext.getResources().getDrawable(2130847047);
  }
  
  public static String a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if (((jdField_c_of_type_JavaUtilList != null) && (jdField_c_of_type_JavaUtilList.contains(paramString1))) || ((!b(paramQQAppInterface, paramString1)) || (TextUtils.isEmpty(paramString2)) || (!paramString2.contains("qq.com")) || (paramString2.contains("&g_tk=")))) {
      return paramString2;
    }
    paramQQAppInterface = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getCurrentAccountUin());
    StringBuilder localStringBuilder = new StringBuilder(paramString2);
    if (paramString2.contains("?")) {}
    for (paramString1 = "&g_tk=";; paramString1 = "?g_tk=")
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(String.valueOf(TroopUtils.getBknBySkey(paramQQAppInterface)));
      return localStringBuilder.toString();
    }
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(bdnu parambdnu)
  {
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    if (parambdnu == null) {
      return localAdInfo;
    }
    if (!StringUtil.isEmpty(parambdnu.X)) {
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantManager", 2, "adinfo<<<<<<<<<<<<<" + parambdnu.X);
      }
    }
    for (;;)
    {
      try
      {
        parambdnu = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(parambdnu.X)));
        return parambdnu;
      }
      catch (JSONException parambdnu)
      {
        parambdnu.printStackTrace();
        parambdnu = localAdInfo;
        continue;
      }
      Object localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
      if (!StringUtil.isEmpty(parambdnu.r)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).advertiser_id.set(Long.parseLong(parambdnu.r));
      }
      if (!StringUtil.isEmpty(parambdnu.N)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_image_name.set(parambdnu.N);
      }
      if (!StringUtil.isEmpty(parambdnu.O)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_logo.set(parambdnu.O);
      }
      Object localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
      if (!StringUtil.isEmpty(parambdnu.F)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_url.set(parambdnu.F);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).media_duration.set(parambdnu.i);
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_file_size.set(parambdnu.j);
      if (!StringUtil.isEmpty(parambdnu.U)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).tencent_video_id.set(parambdnu.U);
      }
      qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo localDisplayInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
      localDisplayInfo.advertiser_info.set((MessageMicro)localObject1);
      localDisplayInfo.video_info.set((MessageMicro)localObject2);
      localDisplayInfo.mini_program_type.set(parambdnu.jdField_f_of_type_Int);
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
      if (!StringUtil.isEmpty(parambdnu.s)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).aid.set(Long.parseLong(parambdnu.s));
      }
      if (!StringUtil.isEmpty(parambdnu.D)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).traceid.set(parambdnu.D);
      }
      if (!StringUtil.isEmpty(parambdnu.E)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).via.set(parambdnu.E);
      }
      if (!StringUtil.isEmpty(parambdnu.A)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).product_id.set(parambdnu.A);
      }
      if (!StringUtil.isEmpty(parambdnu.z)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).noco_id.set(Long.parseLong(parambdnu.z));
      }
      if (!StringUtil.isEmpty(parambdnu.V)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).view_id.set(parambdnu.V);
      }
      localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
      if (!StringUtil.isEmpty(parambdnu.q)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.set(parambdnu.q);
      }
      if (!StringUtil.isEmpty(parambdnu.B)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.set(parambdnu.B);
      }
      if (!StringUtil.isEmpty(parambdnu.w)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).effect_url.set(parambdnu.w);
      }
      if (!StringUtil.isEmpty(parambdnu.y)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).landing_page_report_url.set(parambdnu.y);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.set((MessageMicro)localObject2);
      if (!StringUtil.isEmpty(parambdnu.P)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).negative_feedback_url.set(parambdnu.P);
      }
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
      if (!StringUtil.isEmpty(parambdnu.K)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_click_monitor_url.set(Arrays.asList(parambdnu.K.split("\\|")));
      }
      if (!StringUtil.isEmpty(parambdnu.L)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_exposure_monitor_url.set(Arrays.asList(parambdnu.L.split("\\|")));
      }
      if (!StringUtil.isEmpty(parambdnu.R)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).sdk_click_monitor_url.set(Arrays.asList(parambdnu.R.split("\\|")));
      }
      if (!StringUtil.isEmpty(parambdnu.Q)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).sdk_exposure_monitor_url.set(Arrays.asList(parambdnu.Q.split("\\|")));
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).thirdparty_monitor_urls.set((MessageMicro)localObject2);
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
      if (!StringUtil.isEmpty(parambdnu.x)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).landing_page.set(parambdnu.x);
      }
      if (!StringUtil.isEmpty(parambdnu.u)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).canvas_json.set(parambdnu.u);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).dest_type.set(parambdnu.jdField_d_of_type_Int);
      if (!StringUtil.isEmpty(parambdnu.S)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).universal_link.set(parambdnu.S);
      }
      qq_ad_get.QQAdGetRsp.AdInfo.AppInfo localAppInfo = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
      if (!StringUtil.isEmpty(parambdnu.H)) {
        localAppInfo.customized_invoke_url.set(parambdnu.H);
      }
      if (!StringUtil.isEmpty(parambdnu.t)) {
        localAppInfo.pkg_download_schema.set(parambdnu.t);
      }
      if (!StringUtil.isEmpty(parambdnu.G)) {
        localAppInfo.app_name.set(parambdnu.G);
      }
      if (!StringUtil.isEmpty(parambdnu.I)) {
        localAppInfo.app_package_name.set(parambdnu.I);
      }
      if (!StringUtil.isEmpty(parambdnu.J)) {
        localAppInfo.pkg_url.set(parambdnu.J);
      }
      if (!StringUtil.isEmpty(parambdnu.A)) {
        localAppInfo.android_app_id.set(parambdnu.A);
      }
      if (!StringUtil.isEmpty(parambdnu.C)) {
        localAppInfo.channel_id.set(parambdnu.C);
      }
      localAppInfo.app_score_num.set(parambdnu.k);
      localAppInfo.download_num.set(parambdnu.l);
      localAdInfo.product_type.set(parambdnu.jdField_e_of_type_Int);
      localAdInfo.display_info.set(localDisplayInfo);
      localAdInfo.report_info.set((MessageMicro)localObject1);
      localAdInfo.dest_info.set((MessageMicro)localObject2);
      localAdInfo.app_info.set(localAppInfo);
      if (!StringUtil.isEmpty(parambdnu.T)) {
        localAdInfo.ext_json.set(parambdnu.T);
      }
      parambdnu = localAdInfo;
    }
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    bdnu localbdnu = null;
    Object localObject3 = null;
    Object localObject1;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      localObject1 = localObject2;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = ((StructMsgForGeneralShare)paramMessageRecord).mStructMsgItemLists;
        localObject1 = localObject2;
        if (paramMessageRecord != null)
        {
          localObject1 = localObject2;
          if (!paramMessageRecord.isEmpty())
          {
            localObject2 = paramMessageRecord.iterator();
            paramMessageRecord = localObject3;
            localObject1 = paramMessageRecord;
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (bdnu)((Iterator)localObject2).next();
              if ((localObject1 instanceof bdrp))
              {
                localObject1 = ((bdrp)localObject1).a;
                if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
                  break label1053;
                }
                localObject1 = ((ArrayList)localObject1).iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localbdnu = (bdnu)((Iterator)localObject1).next();
                } while (!(localbdnu instanceof bdte));
                paramMessageRecord = a(localbdnu);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      if (((localObject1 instanceof bdrr)) || ((localObject1 instanceof bdsf)))
      {
        localObject1 = a((bdnu)localObject1);
        label171:
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (!(paramMessageRecord instanceof MessageForArkApp));
        try
        {
          paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
          localObject1 = localObject2;
          if (paramMessageRecord == null) {
            break label171;
          }
          paramMessageRecord = paramMessageRecord.metaList;
          localObject1 = localObject2;
          if (StringUtil.isEmpty(paramMessageRecord)) {
            break label171;
          }
          paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("gdt");
          localObject1 = localObject2;
          if (paramMessageRecord == null) {
            break label171;
          }
          localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
        }
        catch (Exception paramMessageRecord)
        {
          try
          {
            localObject2 = paramMessageRecord.optJSONObject("adInfo");
            if (localObject2 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("EcShopAssistantManager", 2, "ark adinfo<<<<<<<<<<<<<" + localObject2);
              }
              return (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject2));
            }
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.aid.set(Long.parseLong(paramMessageRecord.optString("aid")));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.traceid.set(paramMessageRecord.optString("traceid"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.exposure_url.set(paramMessageRecord.optString("apurl"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.view_id.set(paramMessageRecord.optString("view_id"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.via.set(paramMessageRecord.optString("via"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.noco_id.set(paramMessageRecord.optInt("noco_id"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.product_id.set(paramMessageRecord.optString("product_id"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.effect_url.set(paramMessageRecord.optString("effect_url"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.landing_page_report_url.set(paramMessageRecord.optString("landing_page_report_url"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.landing_page.set(paramMessageRecord.optString("landing_page"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.advertiser_info.corporate_image_name.set(paramMessageRecord.optString("corporate_image_name"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.advertiser_info.corporate_logo.set(paramMessageRecord.optString("corporate_logo"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.advertiser_info.advertiser_id.set(paramMessageRecord.optInt("advertiser_id"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.video_url.set(paramMessageRecord.optString("video_url"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.creative_size.set(paramMessageRecord.optInt("creative_size"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.mini_program_type.set(paramMessageRecord.optInt("mini_program_type"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.tencent_video_id.set(paramMessageRecord.optString("tencent_video_id"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.canvas_json.set(paramMessageRecord.optString("canvas_json"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.customized_invoke_url.set(paramMessageRecord.optString("customized_invoke_url"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.app_score_num.set(paramMessageRecord.optInt("app_score_num"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.download_num.set(paramMessageRecord.optInt("download_num"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.pkg_url.set(paramMessageRecord.optString("pkgurl"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.channel_id.set(paramMessageRecord.optString("subordinate_product_id"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).product_type.set(paramMessageRecord.optInt("product_type"));
            localObject2 = paramMessageRecord.optJSONObject("thirdparty_monitor_urls");
            if (localObject2 != null)
            {
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(ook.a(((JSONObject)localObject2).optJSONArray("api_click_monitor_url")));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(ook.a(((JSONObject)localObject2).optJSONArray("api_exposure_monitor_url")));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.sdk_click_monitor_url.set(ook.a(((JSONObject)localObject2).optJSONArray("sdk_click_monitor_url")));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.sdk_exposure_monitor_url.set(ook.a(((JSONObject)localObject2).optJSONArray("sdk_exposure_monitor_url")));
            }
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.trace_info.view_id.set(paramMessageRecord.optString("view_id"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.negative_feedback_url.set(paramMessageRecord.optString("neg_feedback"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.media_duration.set(paramMessageRecord.optInt("media_duration"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).display_info.video_info.video_file_size.set(paramMessageRecord.optInt("video_file_size"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.universal_link.set(paramMessageRecord.optString("universal_link"));
            ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).dest_info.dest_type.set(paramMessageRecord.optInt("dest_type"));
            paramMessageRecord = paramMessageRecord.optString("ext");
            if (!StringUtil.isEmpty(paramMessageRecord))
            {
              paramMessageRecord = new JSONObject(URLDecoder.decode(paramMessageRecord));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).ext_json.set(paramMessageRecord.optString("sdk_data"));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.app_package_name.set(paramMessageRecord.optString("pkg_name"));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info.app_name.set(paramMessageRecord.optString("appname"));
            }
            return localObject1;
          }
          catch (Exception paramMessageRecord)
          {
            label1043:
            break label1043;
          }
          paramMessageRecord = paramMessageRecord;
          localObject1 = localbdnu;
          paramMessageRecord.printStackTrace();
          return localObject1;
        }
      }
    }
  }
  
  public static void a(RelativeLayout paramRelativeLayout, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    ThreadManagerV2.excute(new EcShopAssistantManager.6(paramQQAppInterface, paramContext, paramRelativeLayout), 32, null, true);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = (RecentUser)paramQQAppInterface.findRecentUser(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.delRecentUser(paramString);
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (Build.VERSION.SDK_INT < 23) {
          return;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          if (!(paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare)) {
            break;
          }
          paramMessageRecord = ((StructMsgForGeneralShare)paramMessageRecord.structingMsg).getStructMsgItemLists();
          if ((paramMessageRecord == null) || (paramMessageRecord.isEmpty())) {
            break;
          }
          m = a(((bdnu)paramMessageRecord.get(0)).X);
          if (m == -1) {
            break;
          }
          paramMessageRecord = opd.a();
          if (paramMessageRecord == null) {
            break;
          }
          paramMessageRecord = paramMessageRecord.a;
          PreloadManager.a().c(paramMessageRecord.jdField_d_of_type_JavaLangString, null);
          if (paramMessageRecord.jdField_a_of_type_Int != 1) {
            break;
          }
          localObject = paramMessageRecord.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label239;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          PreloadManager.a().c((String)localEntry.getValue(), null);
          continue;
        }
        if (!(paramMessageRecord instanceof MessageForArkApp)) {
          break label292;
        }
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("EcShopAssistantManager", 1, paramMessageRecord, new Object[0]);
        return;
      }
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord != null)
      {
        paramMessageRecord = paramMessageRecord.metaList;
        if (!StringUtil.isEmpty(paramMessageRecord))
        {
          paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("gdt");
          if (paramMessageRecord != null)
          {
            m = a(paramMessageRecord.optJSONObject("adInfo"));
            continue;
            label239:
            paramMessageRecord = paramMessageRecord.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
            while (paramMessageRecord.hasNext())
            {
              localObject = (Map.Entry)paramMessageRecord.next();
              PreloadManager.a().c((String)((Map.Entry)localObject).getValue(), null);
            }
          }
        }
      }
      label292:
      int m = -1;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h();
      return;
    }
    finally {}
  }
  
  public static void a(StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 23) {
        return;
      }
      if ((paramStructMsgForGeneralShare.message instanceof MessageForStructing))
      {
        opa localopa = opd.a();
        if ((localopa != null) && (b(localopa.a, paramStructMsgForGeneralShare.message)))
        {
          List localList = paramStructMsgForGeneralShare.getStructMsgItemLists();
          if ((localList != null) && (localList.size() > 0))
          {
            bdnu localbdnu = (bdnu)localList.get(0);
            bdsf localbdsf = new bdsf();
            if (localbdsf.a(localbdnu, localopa.a))
            {
              localList.clear();
              localList.add(localbdsf);
              ((MessageForStructing)paramStructMsgForGeneralShare.message).bDynicMsg = true;
              return;
            }
          }
        }
      }
    }
    catch (Exception paramStructMsgForGeneralShare)
    {
      QLog.e("EcShopAssistantManager", 1, paramStructMsgForGeneralShare, new Object[0]);
    }
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h();
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if ((localObject2 == null) || (localObject1 == null)) {
      return false;
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      localObject2 = (RecentUser)((aoxz)localObject1).findRecentUserByUin(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      EcShopData localEcShopData = a();
      if (localEcShopData != null)
      {
        ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
        ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        ((aoxz)localObject1).saveRecentUser((BaseRecentUser)localObject2);
        QLog.d("EcShopAssistantManager", 2, "update ecshop folder...");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      return true;
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      break;
      localObject2 = (RecentUser)((aoxz)localObject1).findRecentUser(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
      if (localObject2 != null) {
        ((aoxz)localObject1).delRecentUser((BaseRecentUser)localObject2);
      }
      QLog.d("EcShopAssistantManager", 2, "del ecshop folder...");
    }
  }
  
  /* Error */
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc_w 1067
    //   7: getstatic 133	onq:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   10: invokestatic 1070	onq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/util/List;)Z
    //   13: ifeq +60 -> 73
    //   16: getstatic 133	onq:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 362 2 0
    //   25: istore_2
    //   26: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +39 -> 68
    //   32: ldc 252
    //   34: iconst_2
    //   35: new 44	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 1072
    //   45: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_2
    //   49: invokevirtual 1075	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1077
    //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 421	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: ldc 2
    //   70: monitorexit
    //   71: iload_2
    //   72: ireturn
    //   73: getstatic 137	onq:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   76: aload_1
    //   77: invokeinterface 362 2 0
    //   82: istore_2
    //   83: goto -57 -> 26
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramQQAppInterface	QQAppInterface
    //   0	92	1	paramString	String
    //   25	58	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	26	86	finally
    //   26	68	86	finally
    //   73	83	86	finally
  }
  
  /* Error */
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_2
    //   3: invokeinterface 986 1 0
    //   8: ifne +113 -> 121
    //   11: aload_0
    //   12: getstatic 1082	com/tencent/mobileqq/app/QQManagerFactory:QWALLET_CONFIG_MANAGER	I
    //   15: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 1084	aktz
    //   21: ldc_w 1086
    //   24: iconst_2
    //   25: anewarray 163	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 1088
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_1
    //   37: aastore
    //   38: invokevirtual 1091	aktz:a	(Ljava/lang/String;[Ljava/lang/String;)Lorg/json/JSONArray;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +102 -> 145
    //   46: iload_3
    //   47: aload_0
    //   48: invokevirtual 275	org/json/JSONArray:length	()I
    //   51: if_icmpge +22 -> 73
    //   54: aload_2
    //   55: aload_0
    //   56: iload_3
    //   57: invokevirtual 1093	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   60: invokeinterface 145 2 0
    //   65: pop
    //   66: iload_3
    //   67: iconst_1
    //   68: iadd
    //   69: istore_3
    //   70: goto -24 -> 46
    //   73: iconst_1
    //   74: istore 4
    //   76: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +39 -> 118
    //   82: ldc 252
    //   84: iconst_2
    //   85: new 44	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 1095
    //   95: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 1097
    //   105: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 421	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iload 4
    //   120: ireturn
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_0
    //   124: iconst_0
    //   125: istore 4
    //   127: aload_0
    //   128: invokevirtual 1098	java/lang/Throwable:printStackTrace	()V
    //   131: iload 4
    //   133: ireturn
    //   134: astore_0
    //   135: iconst_1
    //   136: istore 4
    //   138: goto -11 -> 127
    //   141: astore_0
    //   142: goto -15 -> 127
    //   145: iconst_0
    //   146: istore 4
    //   148: goto -72 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramQQAppInterface	QQAppInterface
    //   0	151	1	paramString	String
    //   0	151	2	paramList	List<String>
    //   1	69	3	m	int
    //   74	73	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	42	123	java/lang/Throwable
    //   46	66	134	java/lang/Throwable
    //   76	118	141	java/lang/Throwable
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    boolean bool = false;
    EcShopData localEcShopData;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(localEcShopData);
      }
      if (localEcShopData != null) {
        bool = paramEntityManager.remove(localEcShopData);
      }
      QLog.d("EcShopAssistantManager", 2, "removeEcShopData puin: " + paramString);
      if (this.jdField_f_of_type_Boolean)
      {
        paramEntityManager = new Intent("action_on_shop_msg_receive");
        paramEntityManager.putParcelableArrayListExtra("datas", (ArrayList)b());
        BaseApplicationImpl.getContext().sendBroadcast(paramEntityManager);
      }
      return bool;
      paramEntityManager = finally;
      throw paramEntityManager;
    }
  }
  
  public static int b()
  {
    int n = 0;
    String str = DeviceInfoUtil.getIMSI();
    int m = n;
    if (!TextUtils.isEmpty(str))
    {
      m = n;
      if (str.length() > 5)
      {
        m = n;
        if (str.startsWith("460"))
        {
          str = str.substring(3, 5);
          if ((!str.equals("00")) && (!str.equals("02")) && (!str.equals("04")) && (!str.equals("07"))) {
            break label88;
          }
          m = 1;
        }
      }
    }
    label88:
    do
    {
      return m;
      if ((str.equals("01")) || (str.equals("06")) || (str.equals("09"))) {
        return 2;
      }
      if ((str.equals("03")) || (str.equals("05"))) {
        return 3;
      }
      m = n;
    } while (!str.equals("20"));
    return 4;
  }
  
  private static void b(Bitmap paramBitmap, Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ThreadManagerV2.getUIHandlerV2().post(new EcShopAssistantManager.7(paramContext, paramRelativeLayout, paramBitmap));
  }
  
  /* Error */
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc_w 1186
    //   7: getstatic 135	onq:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   10: invokestatic 1070	onq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/util/List;)Z
    //   13: ifeq +60 -> 73
    //   16: getstatic 135	onq:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 362 2 0
    //   25: istore_2
    //   26: invokestatic 416	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +39 -> 68
    //   32: ldc 252
    //   34: iconst_2
    //   35: new 44	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 1188
    //   45: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_2
    //   49: invokevirtual 1075	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1077
    //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 421	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: ldc 2
    //   70: monitorexit
    //   71: iload_2
    //   72: ireturn
    //   73: getstatic 137	onq:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   76: aload_1
    //   77: invokeinterface 362 2 0
    //   82: istore_2
    //   83: goto -57 -> 26
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramQQAppInterface	QQAppInterface
    //   0	92	1	paramString	String
    //   25	58	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	26	86	finally
    //   26	68	86	finally
    //   73	83	86	finally
  }
  
  public static boolean b(String paramString)
  {
    return "1".equals(paramString);
  }
  
  private static boolean b(opb paramopb, MessageRecord paramMessageRecord)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      long l2 = localSimpleDateFormat.parse(paramopb.jdField_a_of_type_JavaLangString).getTime();
      long l1 = localSimpleDateFormat.parse(paramopb.jdField_b_of_type_JavaLangString).getTime();
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantManager", 2, "beginTime = " + l2 + " endTime = " + l1 + " msgTime = " + paramMessageRecord.time);
      }
      if (paramMessageRecord.time * 1000L > l2)
      {
        l2 = paramMessageRecord.time;
        if (l2 * 1000L < l1) {
          return true;
        }
      }
    }
    catch (Exception paramopb)
    {
      QLog.e("EcShopAssistantManager", 1, paramopb, new Object[0]);
    }
    return false;
  }
  
  private void c(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, 1008) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      h();
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("is_update_ec_shop_assist", paramBoolean).commit();
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("is_update_ec_shop_assist", true);
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 187	onq:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 1259	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   12: invokevirtual 1265	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 1033
    //   20: iconst_0
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc_w 1267
    //   28: aconst_null
    //   29: invokevirtual 1271	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   32: astore_2
    //   33: new 44	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 1273
    //   43: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: astore 4
    //   48: aload_2
    //   49: ifnonnull +176 -> 225
    //   52: iconst_0
    //   53: istore_1
    //   54: ldc 252
    //   56: iconst_2
    //   57: aload 4
    //   59: iload_1
    //   60: invokevirtual 1276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 1049	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_0
    //   70: getfield 154	onq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   73: astore 4
    //   75: aload 4
    //   77: monitorenter
    //   78: aload_0
    //   79: aload_2
    //   80: putfield 198	onq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   83: aload_0
    //   84: getfield 198	onq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   87: ifnonnull +16 -> 103
    //   90: aload_0
    //   91: new 130	java/util/ArrayList
    //   94: dup
    //   95: bipush 16
    //   97: invokespecial 1278	java/util/ArrayList:<init>	(I)V
    //   100: putfield 198	onq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   103: aload 4
    //   105: monitorexit
    //   106: aload_0
    //   107: getfield 196	onq:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   110: astore_2
    //   111: aload_2
    //   112: monitorenter
    //   113: aload_0
    //   114: getfield 196	onq:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   117: invokeinterface 1279 1 0
    //   122: aload_0
    //   123: getfield 198	onq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   126: invokeinterface 773 1 0
    //   131: astore 4
    //   133: aload 4
    //   135: invokeinterface 778 1 0
    //   140: ifeq +119 -> 259
    //   143: aload 4
    //   145: invokeinterface 782 1 0
    //   150: checkcast 1033	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   153: astore 5
    //   155: aload_0
    //   156: getfield 196	onq:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   159: aload 5
    //   161: getfield 1282	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   164: aload 5
    //   166: invokeinterface 1286 3 0
    //   171: pop
    //   172: goto -39 -> 133
    //   175: astore 4
    //   177: aload_2
    //   178: monitorexit
    //   179: aload 4
    //   181: athrow
    //   182: astore 4
    //   184: aload_3
    //   185: astore_2
    //   186: ldc 252
    //   188: iconst_2
    //   189: new 44	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 1288
    //   199: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 1291	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   207: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 1293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_3
    //   217: ifnull +7 -> 224
    //   220: aload_3
    //   221: invokevirtual 1296	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   224: return
    //   225: aload_2
    //   226: invokeinterface 986 1 0
    //   231: istore_1
    //   232: goto -178 -> 54
    //   235: astore_2
    //   236: aload 4
    //   238: monitorexit
    //   239: aload_2
    //   240: athrow
    //   241: astore_2
    //   242: aload_3
    //   243: astore 4
    //   245: aload_2
    //   246: astore_3
    //   247: aload 4
    //   249: ifnull +8 -> 257
    //   252: aload 4
    //   254: invokevirtual 1296	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   257: aload_3
    //   258: athrow
    //   259: aload_2
    //   260: monitorexit
    //   261: aload_3
    //   262: ifnull -38 -> 224
    //   265: aload_3
    //   266: invokevirtual 1296	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   269: return
    //   270: astore_3
    //   271: aload_2
    //   272: astore 4
    //   274: goto -27 -> 247
    //   277: astore 4
    //   279: aload 5
    //   281: astore_3
    //   282: goto -98 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	onq
    //   53	179	1	m	int
    //   235	5	2	localObject2	Object
    //   241	31	2	localObject3	Object
    //   15	251	3	localObject4	Object
    //   270	1	3	localObject5	Object
    //   281	1	3	localEcShopData1	EcShopData
    //   175	5	4	localObject7	Object
    //   182	55	4	localException1	Exception
    //   243	30	4	localObject8	Object
    //   277	1	4	localException2	Exception
    //   3	277	5	localEcShopData2	EcShopData
    // Exception table:
    //   from	to	target	type
    //   113	133	175	finally
    //   133	172	175	finally
    //   177	179	175	finally
    //   259	261	175	finally
    //   16	48	182	java/lang/Exception
    //   54	78	182	java/lang/Exception
    //   106	113	182	java/lang/Exception
    //   179	182	182	java/lang/Exception
    //   225	232	182	java/lang/Exception
    //   239	241	182	java/lang/Exception
    //   78	103	235	finally
    //   103	106	235	finally
    //   236	239	235	finally
    //   16	48	241	finally
    //   54	78	241	finally
    //   106	113	241	finally
    //   179	182	241	finally
    //   225	232	241	finally
    //   239	241	241	finally
    //   5	16	270	finally
    //   186	216	270	finally
    //   5	16	277	java/lang/Exception
  }
  
  private void h()
  {
    ThreadManager.executeOnSubThread(new EcShopAssistantManager.2(this));
  }
  
  private void i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        m = 1;
        if (m != 0) {
          g();
        }
        return;
      }
      int m = 0;
    }
  }
  
  public int a()
  {
    int m;
    int n;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      m = 0;
      n = m;
      if (!localIterator.hasNext()) {
        break label119;
      }
      localObject1 = (EcShopData)localIterator.next();
      n = uuc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject1).mUin);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localObject2 == null) {
        break label124;
      }
    }
    label119:
    label124:
    for (Object localObject1 = ((QQMessageFacade)localObject2).getLastMessage(((EcShopData)localObject1).mUin, n);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
        if (localObject2 != null) {
          m += ((acmw)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        }
      }
      for (;;)
      {
        break;
        n = 0;
        return n;
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int m;
    int n;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        m = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          n = paramQQAppInterface.getConversationFacade().a(str, 1008);
          if (n <= 0) {
            break label98;
          }
        }
        else
        {
          return m;
        }
      }
      else
      {
        return 0;
      }
    }
    for (;;)
    {
      m += n;
      break;
      label98:
      n = 0;
    }
  }
  
  public EcShopData a()
  {
    Object localObject3 = null;
    i();
    Object localObject4 = this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject3;
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(0);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public EcShopData a(String paramString)
  {
    i();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      ??? = localEcShopData;
      if (localEcShopData == null)
      {
        localEcShopData = new EcShopData();
        localEcShopData.mUin = paramString;
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        ??? = localEcShopData;
        if (localQQMessageFacade != null)
        {
          paramString = localQQMessageFacade.getDraftSummaryInfo(paramString, 1008);
          ??? = localEcShopData;
          if (paramString != null)
          {
            localEcShopData.mLastDraftTime = paramString.getTime();
            ??? = localEcShopData;
          }
        }
      }
      return ???;
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "";
    Object localObject1 = str;
    aoan localaoan;
    if (paramQQAppInterface != null)
    {
      localObject1 = str;
      if (!TextUtils.isEmpty(paramString))
      {
        localaoan = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        localObject1 = str;
        if ((localaoan != null) && (!alht.a(paramQQAppInterface))) {
          break label110;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localaoan.a(paramString, true);
        if (localObject1 == null) {
          break label125;
        }
        localObject1 = ((PublicAccountInfo)localObject1).name;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label122;
        }
        paramQQAppInterface = uuc.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface == null) {
          break label122;
        }
        localObject1 = paramQQAppInterface.name;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label120;
        }
        return paramString;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = localaoan.b(paramString);
        continue;
      }
      label110:
      Object localObject2 = localaoan.b(paramString);
      continue;
      label120:
      return localObject2;
      label122:
      continue;
      label125:
      localObject2 = "";
    }
  }
  
  public List<EcShopData> a()
  {
    int n = 0;
    i();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          m = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(m);
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          ??? = new StringBuilder().append("getAllEcShopAssitData size: ");
          if (localArrayList == null)
          {
            m = n;
            QLog.d("EcShopAssistantManager", 2, m);
            return localArrayList;
          }
        }
        else
        {
          m = 0;
        }
      }
      int m = localObject2.size();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EcShopData localEcShopData;
    do
    {
      return;
      localEcShopData = a();
    } while (localEcShopData == null);
    a(localEcShopData.mLastMsgTime);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putLong("last_read_time", paramLong).commit();
    this.jdField_c_of_type_Long = paramLong;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      h();
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      } while (localObject2 == null);
      this.jdField_e_of_type_Boolean = paramBoolean;
      Object localObject2 = (RecentUser)((aoxz)localObject1).findRecentUserByUin(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      ((aoxz)localObject1).saveRecentUser((BaseRecentUser)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    } while (localObject1 == null);
    ((MqqHandler)localObject1).sendEmptyMessage(1009);
  }
  
  public void a(Intent paramIntent, Context paramContext, int paramInt)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      return;
    }
    Bundle localBundle;
    if (paramIntent.getExtras() == null)
    {
      localBundle = new Bundle();
      localBundle.putParcelableArrayList("datas", (ArrayList)b());
      if (!TextUtils.isEmpty(this.j)) {
        localBundle.putString("ad_logo", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        localBundle.putString("ad_jump", this.k);
      }
      if (this.jdField_b_of_type_Long != 0L) {
        localBundle.putLong("ad_id", this.jdField_b_of_type_Long);
      }
      this.jdField_f_of_type_Boolean = true;
      localBundle.putBoolean("is_tab_show", this.jdField_b_of_type_Boolean);
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (!"com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      localBundle.putBoolean("is_tool_exist", bool1);
      localBundle.putLong("click_time", System.currentTimeMillis());
      localBundle.putStringArray("urls", this.jdField_a_of_type_ArrayOfJavaLangString);
      SharedPreferences localSharedPreferences = a();
      if (localSharedPreferences.getBoolean("folder_tab_red", false)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        boolean bool2;
        if (paramInt >= 0)
        {
          bool2 = bool1;
          if (paramInt > 0) {
            bool2 = true;
          }
          label255:
          localBundle.putBoolean("hasUnread", bool2);
          localBundle.putLong("last_read_folder", localSharedPreferences.getLong("last_read_folder", 0L));
          localBundle.putLong("latest_time", localSharedPreferences.getLong("latest_time", 0L));
          localBundle.putInt("unReadNum", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getUnreadMsgsNum());
          localBundle.putBoolean("isDefaultTheme", ThemeUtil.isDefaultOrDIYTheme(false));
          localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          String str = this.jdField_a_of_type_ArrayOfJavaLangString[1];
          if (!bool2) {
            break label702;
          }
          paramContext = "1";
          label375:
          str = bkyp.a(str, "has_reddot", paramContext);
          if (localObject != null) {
            break label709;
          }
          paramContext = "0";
          label395:
          localObject = bkyp.a(str, "gender", paramContext);
          localBundle.putInt("PUSH_TASK_ID", localSharedPreferences.getInt("PUSH_TASK_ID", 0));
          localBundle.putString("str_ecshop_diy", localSharedPreferences.getString("str_ecshop_diy", ""));
          localBundle.putInt("PUSH_TASK_TYPE", localSharedPreferences.getInt("PUSH_TASK_TYPE", 0));
          localBundle.putString("PUSH_TASK_INFO", localSharedPreferences.getString("PUSH_TASK_INFO", ""));
          localBundle.putLong("PUSH_RECEIVE_TIME", localSharedPreferences.getLong("PUSH_RECEIVE_TIME", 0L));
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
            paramContext = bkyp.a((String)localObject, "jumpUrl", localSharedPreferences.getString("PUSH_JUMP_URL", ""));
          }
          if (!this.jdField_d_of_type_Boolean) {
            break label721;
          }
        }
        label702:
        label709:
        label721:
        for (Object localObject = String.valueOf(localSharedPreferences.getInt("FOLDER_MSG_TYPE", -1));; localObject = "0")
        {
          paramContext = bkyp.a(bkyp.a(paramContext, "type", (String)localObject), "taskType", String.valueOf(localSharedPreferences.getInt("PUSH_TASK_TYPE", 0)));
          paramIntent.putExtra("bundle", localBundle);
          paramIntent.putExtra("url", paramContext);
          return;
          localBundle = paramIntent.getExtras();
          break;
          bool2 = bool1;
          if (paramContext == null) {
            break label255;
          }
          paramContext = (RecentUser)paramContext.findRecentUser(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
          bool2 = bool1;
          if (paramContext == null) {
            break label255;
          }
          paramContext = algs.a(paramContext.uin, paramContext.getType());
          paramContext = algs.a().a(paramContext);
          bool2 = bool1;
          if (paramContext == null) {
            break label255;
          }
          bool2 = bool1;
          if (paramContext.mUnreadNum <= 0) {
            break label255;
          }
          bool2 = true;
          break label255;
          paramContext = "0";
          break label375;
          paramContext = String.valueOf(((Friends)localObject).gender);
          break label395;
        }
      }
    }
  }
  
  public void a(bdnu parambdnu, Activity paramActivity)
  {
    if (parambdnu == null) {
      return;
    }
    try
    {
      Object localObject = new GdtAd(a(parambdnu));
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.jdField_c_of_type_Int = 1;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)localObject);
      localParams.jdField_a_of_type_Boolean = b(parambdnu.Y);
      localParams.jdField_b_of_type_Boolean = false;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localParams.jdField_b_of_type_JavaLangClass = ShopCanvasFragment.class;
      localParams.jdField_a_of_type_JavaLangClass = ShopVideoCeilingFragment.class;
      localParams.jdField_c_of_type_Boolean = true;
      localObject = localParams.jdField_a_of_type_AndroidOsBundle;
      paramActivity = (Activity)localObject;
      if (localObject == null) {
        paramActivity = new Bundle();
      }
      paramActivity.putString("big_brother_ref_source_key", uuc.b(parambdnu.ab));
      localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
      GdtHandler.a(localParams);
      return;
    }
    catch (Throwable parambdnu)
    {
      QLog.e("EcShopAssistantManager", 1, "enterGDTVideoActivity throw an exception: " + parambdnu);
    }
  }
  
  public void a(EcShopData paramEcShopData)
  {
    if ((paramEcShopData == null) || (TextUtils.isEmpty(paramEcShopData.mUin))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramEcShopData.mUin, paramEcShopData);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramEcShopData);
          m = 0;
          if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label285;
          }
          EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(m);
          if (Math.max(paramEcShopData.mLastMsgTime, paramEcShopData.mLastDraftTime) <= Math.max(localEcShopData.mLastMsgTime, localEcShopData.mLastDraftTime)) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(m, paramEcShopData);
          m = 1;
          if (m == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramEcShopData);
          }
        }
        ??? = (ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
        if (paramEcShopData.getStatus() == 1000)
        {
          ((ProxyManager)???).addMsgQueue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
          QLog.d("EcShopAssistantManager", 2, "saveEcShopData(db&cache) puin: " + paramEcShopData.mUin + ", status: " + paramEcShopData.getStatus());
          return;
          paramEcShopData = finally;
          throw paramEcShopData;
          m += 1;
        }
      }
      ((ProxyManager)???).addMsgQueue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
      continue;
      label285:
      int m = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.l = paramQQAppInterface.getAccount();
      Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences(this.l, 0);
      this.jdField_g_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_show_in_msg", true);
      this.jdField_h_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_deleted", false);
      this.jdField_c_of_type_Long = ((SharedPreferences)localObject2).getLong("last_read_time", 0L);
      Object localObject3 = a();
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilSet = bhhs.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
        if (this.jdField_a_of_type_JavaUtilSet == null)
        {
          this.jdField_a_of_type_JavaUtilSet = new HashSet();
          if (c())
          {
            c(false);
            localObject2 = paramQQAppInterface.getMessageFacade();
            if (localObject2 == null) {
              return;
            }
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
              QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).getLastMessage(localEcShopData.mUin, 1008);
              if ((paramQQAppInterface.getConversationFacade().a(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.jdField_c_of_type_Long)) {
                a(localMessage.frienduin, paramQQAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return;
    }
    QLog.d("EcShopAssistantManager", 2, "addMsgToAssist puin: " + paramMessageRecord.senderuin);
    SharedPreferences localSharedPreferences = a();
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    if ((!TextUtils.isEmpty(str)) && (str.equals(jdField_g_of_type_JavaLangString)))
    {
      localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
      jdField_g_of_type_JavaLangString = null;
    }
    EcShopData localEcShopData = a(str);
    localEcShopData.mImgInfo = "";
    if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {}
    for (localEcShopData.mLastMsgTime = paramMessageRecord.time;; localEcShopData.mLastMsgTime = l1)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(localEcShopData.mUin, 1008);
      if (localMessage != null)
      {
        long l2 = localMessage.time;
        if (l2 > localEcShopData.mLastMsgTime) {
          localEcShopData.mLastMsgTime = l2;
        }
        if (l2 > a().getLong("latest_time", 0L)) {
          localSharedPreferences.edit().putLong("latest_time", l2).commit();
        }
      }
      a(localEcShopData);
      a(paramMessageRecord, str);
      if (this.jdField_h_of_type_Boolean) {
        a(false);
      }
      a(paramQQAppInterface, str);
      a(l1);
      a(str);
      if ((localSharedPreferences == null) || (TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", "")))) {
        break;
      }
      localSharedPreferences.edit().putString("PUSH_JUMP_URL", "").commit();
      return;
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      Intent localIntent = new Intent("action_on_shop_msg_receive");
      localIntent.putParcelableArrayListExtra("datas", (ArrayList)b());
      if ((!TextUtils.isEmpty(paramString)) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().isChatting()) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getCurrChatUin())))) {
        localIntent.putExtra("uin", paramString);
      }
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    paramString.mLastDraftTime = paramLong;
    a(paramString);
    a(null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("EcShopAssistantManager", 2, "refreshSettings.... paUin: " + paramString1 + ", src: " + paramString2);
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ??? = paramString2.getRecentList(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
        {
          ((ArrayList)localObject2).add(localObject4);
          QLog.d("EcShopAssistantManager", 2, "add to ecshop folder puin: " + ((RecentUser)localObject4).uin + ", size: " + ((ArrayList)localObject2).size());
        }
      }
    }
    i();
    Object localObject5;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (EcShopData)((Iterator)localObject4).next();
          if ((!uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(jdField_g_of_type_JavaLangString)))
          {
            ((ArrayList)localObject1).add(localObject5);
            QLog.d("EcShopAssistantManager", 2, "remove form ecshop folder puin: " + ((EcShopData)localObject5).mUin);
          }
        }
      }
    }
    QLog.d("EcShopAssistantManager", 2, "toRecentUser size: " + ((ArrayList)localObject1).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(((EcShopData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((EcShopData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((EcShopData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a((EcShopData)localObject4);
          paramString2.delRecentUser((BaseRecentUser)???);
          a(((RecentUser)???).uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EcShopData)((Iterator)localObject1).next();
        ??? = (RecentUser)paramString2.findRecentUserByUin(((EcShopData)localObject2).mUin, 1008);
        ((RecentUser)???).uin = ((EcShopData)localObject2).mUin;
        ((RecentUser)???).setType(1008);
        ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
        ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
        if (a(paramString1, ((EcShopData)localObject2).mUin))
        {
          localObject4 = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
          if ((localObject4 != null) && (((aoan)localObject4).c(((EcShopData)localObject2).mUin) != null))
          {
            paramString2.saveRecentUser((BaseRecentUser)???);
            QLog.d("EcShopAssistantManager", 2, "add to msgtab puin: " + ((EcShopData)localObject2).mUin);
          }
        }
      }
    }
    paramString2 = a();
    if (paramString2 != null) {
      a(paramString2.mLastMsgTime);
    }
    if (paramString1 != null) {
      paramString1.close();
    }
    a(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("ec_shop_assist_deleted", paramBoolean).commit();
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("init_ec_shop_assist", true);
  }
  
  public boolean a(bdnu parambdnu, Activity paramActivity)
  {
    if (parambdnu == null) {
      return false;
    }
    Object localObject2;
    if (((parambdnu.a instanceof AbsShareMsg)) && (((AbsShareMsg)parambdnu.a).mStructMsgItemLists != null)) {
      localObject2 = (bdnu)((AbsShareMsg)parambdnu.a).mStructMsgItemLists.get(0);
    }
    for (;;)
    {
      try
      {
        if (((localObject2 instanceof bdnv)) && (((bdnu)localObject2).jdField_c_of_type_Int == 1))
        {
          Object localObject1 = new GdtAd(a((bdnu)localObject2));
          if (!"2711679534".equals(((bdnu)localObject2).ab)) {
            break label230;
          }
          bool = false;
          localObject2 = new GdtHandler.Params();
          ((GdtHandler.Params)localObject2).jdField_c_of_type_Int = 1;
          ((GdtHandler.Params)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
          ((GdtHandler.Params)localObject2).jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)localObject1);
          ((GdtHandler.Params)localObject2).jdField_a_of_type_Boolean = b(parambdnu.Y);
          ((GdtHandler.Params)localObject2).jdField_b_of_type_Boolean = bool;
          ((GdtHandler.Params)localObject2).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
          ((GdtHandler.Params)localObject2).jdField_b_of_type_JavaLangClass = ShopCanvasFragment.class;
          localObject1 = ((GdtHandler.Params)localObject2).jdField_a_of_type_AndroidOsBundle;
          paramActivity = (Activity)localObject1;
          if (localObject1 == null) {
            paramActivity = new Bundle();
          }
          paramActivity.putString("big_brother_ref_source_key", uuc.b(parambdnu.ab));
          ((GdtHandler.Params)localObject2).jdField_a_of_type_AndroidOsBundle = paramActivity;
          GdtHandler.a((GdtHandler.Params)localObject2);
          return true;
        }
        return false;
      }
      catch (Exception parambdnu)
      {
        return false;
      }
      return false;
      label230:
      boolean bool = true;
    }
  }
  
  public boolean a(String paramString)
  {
    return ((jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_JavaUtilList.contains(paramString))) || (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
  }
  
  public List<RecentShopParcel> b()
  {
    if (!this.jdField_f_of_type_Boolean) {
      f();
    }
    aoan localaoan = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    SharedPreferences localSharedPreferences = a();
    ArrayList localArrayList = new ArrayList();
    EcShopData localEcShopData;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label405;
        }
        localEcShopData = (EcShopData)localIterator.next();
        if ((TextUtils.isEmpty(localEcShopData.mUin)) || (!localEcShopData.mUin.equals(jdField_g_of_type_JavaLangString))) {
          break;
        }
        localObject3 = new RecentShopParcel();
        ((RecentShopParcel)localObject3).jdField_a_of_type_JavaLangString = localEcShopData.mUin;
        ((RecentShopParcel)localObject3).jdField_b_of_type_JavaLangString = localSharedPreferences.getString("ad_nick", "");
        ((RecentShopParcel)localObject3).jdField_d_of_type_JavaLangString = localSharedPreferences.getString("ad_title", "");
        ((RecentShopParcel)localObject3).jdField_e_of_type_JavaLangString = localEcShopData.mImgInfo;
        if (localSharedPreferences.getBoolean("ad_cert", false))
        {
          ((RecentShopParcel)localObject3).jdField_a_of_type_Int = 0;
          ((RecentShopParcel)localObject3).jdField_b_of_type_Int = 0;
          ((RecentShopParcel)localObject3).jdField_c_of_type_Int = 1;
          localArrayList.add(localObject3);
        }
      }
      ((RecentShopParcel)localObject3).jdField_a_of_type_Int = 0;
    }
    Object localObject3 = new RecentItemEcShop(localEcShopData);
    ((RecentItemEcShop)localObject3).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext());
    RecentShopParcel localRecentShopParcel = new RecentShopParcel();
    localRecentShopParcel.jdField_a_of_type_JavaLangString = localEcShopData.mUin;
    localRecentShopParcel.jdField_b_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEcShopData.mUin);
    localRecentShopParcel.jdField_c_of_type_JavaLangString = ((RecentItemEcShop)localObject3).mShowTime;
    localRecentShopParcel.jdField_d_of_type_JavaLangString = String.valueOf(((RecentItemEcShop)localObject3).mLastMsg);
    localRecentShopParcel.jdField_e_of_type_JavaLangString = localEcShopData.mImgInfo;
    PublicAccountInfo localPublicAccountInfo = localObject2.c(localEcShopData.mUin);
    if ((localPublicAccountInfo != null) && (localPublicAccountInfo.certifiedGrade > 0L)) {}
    for (localRecentShopParcel.jdField_a_of_type_Int = 0;; localRecentShopParcel.jdField_a_of_type_Int = 0)
    {
      localRecentShopParcel.jdField_b_of_type_Int = ((RecentItemEcShop)localObject3).mUnreadNum;
      localRecentShopParcel.jdField_c_of_type_Int = 0;
      localRecentShopParcel.jdField_a_of_type_Long = ((RecentItemEcShop)localObject3).getLastMsgTime();
      localRecentShopParcel.jdField_b_of_type_Long = localEcShopData.mLastDraftTime;
      localArrayList.add(localRecentShopParcel);
      break;
    }
    label405:
    return localArrayList;
  }
  
  public void b()
  {
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      localObject = FileUtils.readFileContent((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      int m;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("shopFolderName")) {
          jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("shopFolderName");
        }
        if (((JSONObject)localObject).has("shopFolderIcon")) {
          jdField_d_of_type_JavaLangString = ((JSONObject)localObject).getString("shopFolderIcon");
        }
        if (!((JSONObject)localObject).has("shopButton")) {
          break label206;
        }
        localObject = ((JSONObject)localObject).getJSONArray("shopButton");
        if (!QLog.isColorLevel()) {
          break label236;
        }
        QLog.i("EcShopAssistantManager", 2, "shopButton info found:" + ((JSONArray)localObject).toString());
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        String str;
        int n;
        if (!QLog.isColorLevel()) {
          break label206;
        }
        QLog.d("EcShopAssistantManager", 2, "parse banner config fail", localException);
      }
      if (m < ((JSONArray)localObject).length())
      {
        localJSONObject = (JSONObject)((JSONArray)localObject).get(m);
        str = localJSONObject.getString("url");
        n = localJSONObject.getInt("id");
        this.jdField_a_of_type_ArrayOfJavaLangString[(n - 1)] = str;
        m += 1;
      }
      else
      {
        label206:
        return;
        QLog.d("EcShopAssistantManager", 2, "banner json config file is not existed path=" + jdField_a_of_type_JavaLangString);
        return;
        label236:
        m = 0;
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramQQAppInterface.getConversationFacade().a(str, 1008) > 0) {
            paramQQAppInterface.getConversationFacade().a(str, 1008, false);
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    ThreadManager.post(new EcShopAssistantManager.3(this, paramString), 5, null, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    a().edit().putBoolean("folder_tab_show", this.jdField_b_of_type_Boolean).commit();
  }
  
  public boolean b()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = a().getLong("last_stay_folder", 0L);
      l2 = this.jdField_d_of_type_Int * 1000 * 60 * 60;
    } while ((System.currentTimeMillis() - l1 >= l2 * 24L) || (!this.jdField_b_of_type_Boolean));
    if (QLog.isColorLevel()) {
      QLog.i("EcShopAssistantManager", 2, "lastEnterShop:" + l1 + ",dayLimit:" + this.jdField_d_of_type_Int);
    }
    return true;
  }
  
  public void c()
  {
    bhyt localbhyt = ((bhyq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (localbhyt != null)
    {
      Object localObject2 = asdi.a("VIP_shop_assit_cfg", "https://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localbhyt.a((String)localObject2) == null)
      {
        Object localObject1 = new File(jdField_a_of_type_JavaLangString);
        localObject2 = new bhyo((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l1 = ((File)localObject1).lastModified();
          ((bhyo)localObject2).i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l1).longValue() != ((bhyo)localObject2).i) {
            ((bhyo)localObject2).m = true;
          }
        }
        ((bhyo)localObject2).j = true;
        ((bhyo)localObject2).p = false;
        localObject1 = new Bundle();
        localbhyt.a((bhyo)localObject2, this.jdField_a_of_type_Ont, (Bundle)localObject1);
      }
    }
  }
  
  public void d()
  {
    for (;;)
    {
      try
      {
        i();
        aoxz localaoxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        Object localObject = localaoxz.getRecentList(false);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((1008 == localRecentUser.getType()) && (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)))
        {
          EcShopData localEcShopData = a(localRecentUser.uin);
          localEcShopData.mLastDraftTime = localRecentUser.lastmsgdrafttime;
          localEcShopData.mLastMsgTime = localRecentUser.lastmsgtime;
          if (localEcShopData.mLastMsgTime == 0L)
          {
            QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(localEcShopData.mUin, 1008);
            if (localMessage != null)
            {
              l1 = localMessage.time;
              localEcShopData.mLastMsgTime = l1;
            }
          }
          else
          {
            a(localEcShopData);
            localaoxz.delRecentUser(localRecentUser);
            a(localEcShopData.mUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            continue;
          }
          long l1 = localEcShopData.mLastMsgTime;
        }
      }
      catch (Exception localException)
      {
        QLog.d("EcShopAssistantManager", 1, "initEcShopAssist fail msg:" + localException.getMessage());
        return;
      }
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localPublicAccountHandler != null) {
      localPublicAccountHandler.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("init_ec_shop_assist", false).commit();
  }
  
  public void e()
  {
    if (a()) {
      d();
    }
    a();
  }
  
  void f()
  {
    Object localObject1 = a();
    int m;
    Object localObject2;
    SharedPreferences localSharedPreferences;
    boolean bool;
    long l1;
    int i1;
    int i2;
    long l2;
    int n;
    if (localObject1 == null)
    {
      m = 0;
      localObject2 = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      localSharedPreferences = a();
      bool = localSharedPreferences.getBoolean("is_ad_added", false);
      l1 = localSharedPreferences.getLong("ad_puin", 0L);
      this.jdField_b_of_type_Long = localSharedPreferences.getLong("ad_id", 0L);
      jdField_g_of_type_JavaLangString = String.valueOf(l1);
      this.j = localSharedPreferences.getString("ad_icon_url", null);
      this.k = localSharedPreferences.getString("ad_url", null);
      i1 = localSharedPreferences.getInt("ad_start", 0);
      i2 = localSharedPreferences.getInt("ad_end", 0);
      l2 = System.currentTimeMillis() / 1000L;
      if ((!bool) && (localSharedPreferences.contains("ad_id")) && (m > 0))
      {
        if ((l2 <= i1) || (l2 >= i2) || (((aoan)localObject2).a(Long.valueOf(l1)))) {
          break label572;
        }
        localObject2 = new EcShopData();
        ((EcShopData)localObject2).mUin = String.valueOf(l1);
        ((EcShopData)localObject2).mImgInfo = localSharedPreferences.getString("ad_pics", null);
        n = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((n >= m) || (n >= 2))
        {
          a((EcShopData)localObject2);
          m = 1;
          localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
          if ((m != 0) || (!localSharedPreferences.getBoolean("is_ad_added", false))) {
            break label502;
          }
          localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
          label315:
          if (m != 0) {
            break label543;
          }
          jdField_g_of_type_JavaLangString = "";
          return;
          m = ((List)localObject1).size();
          break;
        }
        ((EcShopData)localObject2).mLastMsgTime = (((EcShopData)((List)localObject1).get(n)).mLastMsgTime - 1L);
        n += 1;
      }
    }
    if (bool)
    {
      n = 0;
      label371:
      if (n >= m) {
        break label577;
      }
      if (!String.valueOf(l1).equals(((EcShopData)((List)localObject1).get(n)).mUin)) {}
    }
    label543:
    label572:
    label577:
    for (localObject1 = (EcShopData)((List)localObject1).get(n);; localObject1 = null)
    {
      if (((l2 < i1) || (l2 > i2) || (((aoan)localObject2).a(Long.valueOf(l1)))) && (localObject1 != null))
      {
        b(((EcShopData)localObject1).mUin);
        m = 0;
        break;
        n += 1;
        break label371;
      }
      if (localObject1 != null)
      {
        m = 1;
        localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
        break;
        label502:
        if ((m == 0) || (!QLog.isColorLevel())) {
          break label315;
        }
        QLog.i("EcShopAssistantManager", 2, "show ad ,puin=" + jdField_g_of_type_JavaLangString);
        break label315;
        ((ook)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134246436, null, null, null, null, this.jdField_b_of_type_Long, false);
        return;
      }
      m = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {
        this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(BaseApplicationImpl.getContext());
      }
      label27:
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
      }
      this.jdField_a_of_type_Ont = null;
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onq
 * JD-Core Version:    0.7.0.1
 */