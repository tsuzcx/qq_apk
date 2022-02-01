import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.1;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.2;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.3;
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
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

public class ofx
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
  public static final String e;
  private static List<String> e;
  public static final String f;
  private static List<String> f;
  public static String g;
  public static final String h;
  public long a;
  public BroadcastReceiver a;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  public QQAppInterface a;
  FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new ofz(this);
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  public List<EcShopData> a;
  private Map<String, EcShopData> jdField_a_of_type_JavaUtilMap;
  public Set<String> a;
  private oga jdField_a_of_type_Oga;
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
    jdField_d_of_type_JavaUtilList = new ArrayList();
    jdField_e_of_type_JavaUtilList = new ArrayList();
    jdField_f_of_type_JavaUtilList = new ArrayList();
    jdField_f_of_type_JavaUtilList.add("3046055438");
    jdField_f_of_type_JavaUtilList.add("2711679534");
  }
  
  public ofx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3" };
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ofy(this);
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
      this.jdField_a_of_type_Oga = new oga(this);
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
      Object localObject1 = paramContext.getResources().getDrawable(2130839547);
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
        return paramContext.getResources().getDrawable(2130846950);
      }
    }
    return paramContext.getResources().getDrawable(2130846950);
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
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(bcgw parambcgw)
  {
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    if (parambcgw == null) {
      return localAdInfo;
    }
    if (!StringUtil.isEmpty(parambcgw.X)) {
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantManager", 2, "adinfo<<<<<<<<<<<<<" + parambcgw.X);
      }
    }
    for (;;)
    {
      try
      {
        parambcgw = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(parambcgw.X)));
        return parambcgw;
      }
      catch (JSONException parambcgw)
      {
        parambcgw.printStackTrace();
        parambcgw = localAdInfo;
        continue;
      }
      Object localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
      if (!StringUtil.isEmpty(parambcgw.r)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).advertiser_id.set(Long.parseLong(parambcgw.r));
      }
      if (!StringUtil.isEmpty(parambcgw.N)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_image_name.set(parambcgw.N);
      }
      if (!StringUtil.isEmpty(parambcgw.O)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_logo.set(parambcgw.O);
      }
      Object localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
      if (!StringUtil.isEmpty(parambcgw.F)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_url.set(parambcgw.F);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).media_duration.set(parambcgw.i);
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_file_size.set(parambcgw.j);
      if (!StringUtil.isEmpty(parambcgw.U)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).tencent_video_id.set(parambcgw.U);
      }
      qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo localDisplayInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
      localDisplayInfo.advertiser_info.set((MessageMicro)localObject1);
      localDisplayInfo.video_info.set((MessageMicro)localObject2);
      localDisplayInfo.mini_program_type.set(parambcgw.f);
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
      if (!StringUtil.isEmpty(parambcgw.s)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).aid.set(Long.parseLong(parambcgw.s));
      }
      if (!StringUtil.isEmpty(parambcgw.D)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).traceid.set(parambcgw.D);
      }
      if (!StringUtil.isEmpty(parambcgw.E)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).via.set(parambcgw.E);
      }
      if (!StringUtil.isEmpty(parambcgw.A)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).product_id.set(parambcgw.A);
      }
      if (!StringUtil.isEmpty(parambcgw.z)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).noco_id.set(Long.parseLong(parambcgw.z));
      }
      if (!StringUtil.isEmpty(parambcgw.V)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).view_id.set(parambcgw.V);
      }
      localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
      if (!StringUtil.isEmpty(parambcgw.q)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.set(parambcgw.q);
      }
      if (!StringUtil.isEmpty(parambcgw.B)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.set(parambcgw.B);
      }
      if (!StringUtil.isEmpty(parambcgw.w)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).effect_url.set(parambcgw.w);
      }
      if (!StringUtil.isEmpty(parambcgw.y)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).landing_page_report_url.set(parambcgw.y);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.set((MessageMicro)localObject2);
      if (!StringUtil.isEmpty(parambcgw.P)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).negative_feedback_url.set(parambcgw.P);
      }
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
      if (!StringUtil.isEmpty(parambcgw.K)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_click_monitor_url.set(Arrays.asList(parambcgw.K.split("\\|")));
      }
      if (!StringUtil.isEmpty(parambcgw.L)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_exposure_monitor_url.set(Arrays.asList(parambcgw.L.split("\\|")));
      }
      if (!StringUtil.isEmpty(parambcgw.R)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).sdk_click_monitor_url.set(Arrays.asList(parambcgw.R.split("\\|")));
      }
      if (!StringUtil.isEmpty(parambcgw.Q)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).sdk_exposure_monitor_url.set(Arrays.asList(parambcgw.Q.split("\\|")));
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).thirdparty_monitor_urls.set((MessageMicro)localObject2);
      localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
      if (!StringUtil.isEmpty(parambcgw.x)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).landing_page.set(parambcgw.x);
      }
      if (!StringUtil.isEmpty(parambcgw.u)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).canvas_json.set(parambcgw.u);
      }
      ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).dest_type.set(parambcgw.jdField_d_of_type_Int);
      if (!StringUtil.isEmpty(parambcgw.S)) {
        ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).universal_link.set(parambcgw.S);
      }
      qq_ad_get.QQAdGetRsp.AdInfo.AppInfo localAppInfo = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
      if (!StringUtil.isEmpty(parambcgw.H)) {
        localAppInfo.customized_invoke_url.set(parambcgw.H);
      }
      if (!StringUtil.isEmpty(parambcgw.t)) {
        localAppInfo.pkg_download_schema.set(parambcgw.t);
      }
      if (!StringUtil.isEmpty(parambcgw.G)) {
        localAppInfo.app_name.set(parambcgw.G);
      }
      if (!StringUtil.isEmpty(parambcgw.I)) {
        localAppInfo.app_package_name.set(parambcgw.I);
      }
      if (!StringUtil.isEmpty(parambcgw.J)) {
        localAppInfo.pkg_url.set(parambcgw.J);
      }
      if (!StringUtil.isEmpty(parambcgw.A)) {
        localAppInfo.android_app_id.set(parambcgw.A);
      }
      if (!StringUtil.isEmpty(parambcgw.C)) {
        localAppInfo.channel_id.set(parambcgw.C);
      }
      localAppInfo.app_score_num.set(parambcgw.k);
      localAppInfo.download_num.set(parambcgw.l);
      localAdInfo.product_type.set(parambcgw.e);
      localAdInfo.display_info.set(localDisplayInfo);
      localAdInfo.report_info.set((MessageMicro)localObject1);
      localAdInfo.dest_info.set((MessageMicro)localObject2);
      localAdInfo.app_info.set(localAppInfo);
      if (!StringUtil.isEmpty(parambcgw.T)) {
        localAdInfo.ext_json.set(parambcgw.T);
      }
      parambcgw = localAdInfo;
    }
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    bcgw localbcgw = null;
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
              localObject1 = (bcgw)((Iterator)localObject2).next();
              if ((localObject1 instanceof bckr))
              {
                localObject1 = ((bckr)localObject1).a;
                if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
                  break label1050;
                }
                localObject1 = ((ArrayList)localObject1).iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localbcgw = (bcgw)((Iterator)localObject1).next();
                } while (!(localbcgw instanceof bcme));
                paramMessageRecord = a(localbcgw);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof bckt))
      {
        localObject1 = a((bckt)localObject1);
        label167:
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
            break label167;
          }
          paramMessageRecord = paramMessageRecord.metaList;
          localObject1 = localObject2;
          if (StringUtil.isEmpty(paramMessageRecord)) {
            break label167;
          }
          paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("gdt");
          localObject1 = localObject2;
          if (paramMessageRecord == null) {
            break label167;
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
              return (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject2));
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
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(ogr.a(((JSONObject)localObject2).optJSONArray("api_click_monitor_url")));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(ogr.a(((JSONObject)localObject2).optJSONArray("api_exposure_monitor_url")));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.sdk_click_monitor_url.set(ogr.a(((JSONObject)localObject2).optJSONArray("sdk_click_monitor_url")));
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.thirdparty_monitor_urls.sdk_exposure_monitor_url.set(ogr.a(((JSONObject)localObject2).optJSONArray("sdk_exposure_monitor_url")));
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
            label1040:
            break label1040;
          }
          paramMessageRecord = paramMessageRecord;
          localObject1 = localbcgw;
          paramMessageRecord.printStackTrace();
          return localObject1;
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = (RecentUser)paramQQAppInterface.findRecentUser(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.delRecentUser(paramString);
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
    Object localObject2 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if ((localObject2 == null) || (localObject1 == null)) {
      return false;
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      localObject2 = (RecentUser)((anuz)localObject1).findRecentUserByUin(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      EcShopData localEcShopData = a();
      if (localEcShopData != null)
      {
        ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
        ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        ((anuz)localObject1).saveRecentUser((BaseRecentUser)localObject2);
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
      localObject2 = (RecentUser)((anuz)localObject1).findRecentUser(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
      if (localObject2 != null) {
        ((anuz)localObject1).delRecentUser((BaseRecentUser)localObject2);
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
    //   4: ldc_w 938
    //   7: getstatic 127	ofx:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   10: invokestatic 941	ofx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/util/List;)Z
    //   13: ifeq +61 -> 74
    //   16: getstatic 127	ofx:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 299 2 0
    //   25: istore_2
    //   26: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +40 -> 69
    //   32: ldc_w 361
    //   35: iconst_2
    //   36: new 44	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 943
    //   46: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_2
    //   50: invokevirtual 946	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 948
    //   56: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 366	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: iload_2
    //   73: ireturn
    //   74: getstatic 131	ofx:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   77: aload_1
    //   78: invokeinterface 299 2 0
    //   83: istore_2
    //   84: goto -58 -> 26
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramQQAppInterface	QQAppInterface
    //   0	93	1	paramString	String
    //   25	59	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	26	87	finally
    //   26	69	87	finally
    //   74	84	87	finally
  }
  
  /* Error */
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_2
    //   3: invokeinterface 954 1 0
    //   8: ifne +114 -> 122
    //   11: aload_0
    //   12: sipush 245
    //   15: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 956	ajyg
    //   21: ldc_w 958
    //   24: iconst_2
    //   25: anewarray 157	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 960
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_1
    //   37: aastore
    //   38: invokevirtual 963	ajyg:a	(Ljava/lang/String;[Ljava/lang/String;)Lorg/json/JSONArray;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +103 -> 146
    //   46: iload_3
    //   47: aload_0
    //   48: invokevirtual 968	org/json/JSONArray:length	()I
    //   51: if_icmpge +22 -> 73
    //   54: aload_2
    //   55: aload_0
    //   56: iload_3
    //   57: invokevirtual 970	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   60: invokeinterface 139 2 0
    //   65: pop
    //   66: iload_3
    //   67: iconst_1
    //   68: iadd
    //   69: istore_3
    //   70: goto -24 -> 46
    //   73: iconst_1
    //   74: istore 4
    //   76: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +40 -> 119
    //   82: ldc_w 361
    //   85: iconst_2
    //   86: new 44	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 972
    //   96: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 974
    //   106: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 366	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: iload 4
    //   121: ireturn
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_0
    //   125: iconst_0
    //   126: istore 4
    //   128: aload_0
    //   129: invokevirtual 975	java/lang/Throwable:printStackTrace	()V
    //   132: iload 4
    //   134: ireturn
    //   135: astore_0
    //   136: iconst_1
    //   137: istore 4
    //   139: goto -11 -> 128
    //   142: astore_0
    //   143: goto -15 -> 128
    //   146: iconst_0
    //   147: istore 4
    //   149: goto -73 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramQQAppInterface	QQAppInterface
    //   0	152	1	paramString	String
    //   0	152	2	paramList	List<String>
    //   1	69	3	m	int
    //   74	74	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	42	124	java/lang/Throwable
    //   46	66	135	java/lang/Throwable
    //   76	119	142	java/lang/Throwable
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
  
  /* Error */
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc_w 1055
    //   7: getstatic 129	ofx:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   10: invokestatic 941	ofx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/util/List;)Z
    //   13: ifeq +61 -> 74
    //   16: getstatic 129	ofx:jdField_e_of_type_JavaUtilList	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 299 2 0
    //   25: istore_2
    //   26: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +40 -> 69
    //   32: ldc_w 361
    //   35: iconst_2
    //   36: new 44	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1057
    //   46: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_2
    //   50: invokevirtual 946	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 948
    //   56: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 366	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: ldc 2
    //   71: monitorexit
    //   72: iload_2
    //   73: ireturn
    //   74: getstatic 131	ofx:jdField_f_of_type_JavaUtilList	Ljava/util/List;
    //   77: aload_1
    //   78: invokeinterface 299 2 0
    //   83: istore_2
    //   84: goto -58 -> 26
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramQQAppInterface	QQAppInterface
    //   0	93	1	paramString	String
    //   25	59	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	26	87	finally
    //   26	69	87	finally
    //   74	84	87	finally
  }
  
  public static boolean b(String paramString)
  {
    return "1".equals(paramString);
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
    //   6: getfield 181	ofx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 1091	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   12: invokevirtual 1097	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 904
    //   20: iconst_0
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc_w 1099
    //   28: aconst_null
    //   29: invokevirtual 1103	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   32: astore_2
    //   33: new 44	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 1105
    //   43: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: astore 4
    //   48: aload_2
    //   49: ifnonnull +178 -> 227
    //   52: iconst_0
    //   53: istore_1
    //   54: ldc_w 361
    //   57: iconst_2
    //   58: aload 4
    //   60: iload_1
    //   61: invokevirtual 1108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 920	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: getfield 148	ofx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   74: astore 4
    //   76: aload 4
    //   78: monitorenter
    //   79: aload_0
    //   80: aload_2
    //   81: putfield 192	ofx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   84: aload_0
    //   85: getfield 192	ofx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   88: ifnonnull +16 -> 104
    //   91: aload_0
    //   92: new 124	java/util/ArrayList
    //   95: dup
    //   96: bipush 16
    //   98: invokespecial 1110	java/util/ArrayList:<init>	(I)V
    //   101: putfield 192	ofx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   104: aload 4
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 190	ofx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   111: astore_2
    //   112: aload_2
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 190	ofx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   118: invokeinterface 1113 1 0
    //   123: aload_0
    //   124: getfield 192	ofx:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   127: invokeinterface 725 1 0
    //   132: astore 4
    //   134: aload 4
    //   136: invokeinterface 730 1 0
    //   141: ifeq +120 -> 261
    //   144: aload 4
    //   146: invokeinterface 734 1 0
    //   151: checkcast 904	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   154: astore 5
    //   156: aload_0
    //   157: getfield 190	ofx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   160: aload 5
    //   162: getfield 1116	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   165: aload 5
    //   167: invokeinterface 1120 3 0
    //   172: pop
    //   173: goto -39 -> 134
    //   176: astore 4
    //   178: aload_2
    //   179: monitorexit
    //   180: aload 4
    //   182: athrow
    //   183: astore 4
    //   185: aload_3
    //   186: astore_2
    //   187: ldc_w 361
    //   190: iconst_2
    //   191: new 44	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 1122
    //   201: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 4
    //   206: invokevirtual 1125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 1127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 1130	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   226: return
    //   227: aload_2
    //   228: invokeinterface 954 1 0
    //   233: istore_1
    //   234: goto -180 -> 54
    //   237: astore_2
    //   238: aload 4
    //   240: monitorexit
    //   241: aload_2
    //   242: athrow
    //   243: astore_2
    //   244: aload_3
    //   245: astore 4
    //   247: aload_2
    //   248: astore_3
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 1130	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   259: aload_3
    //   260: athrow
    //   261: aload_2
    //   262: monitorexit
    //   263: aload_3
    //   264: ifnull -38 -> 226
    //   267: aload_3
    //   268: invokevirtual 1130	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   271: return
    //   272: astore_3
    //   273: aload_2
    //   274: astore 4
    //   276: goto -27 -> 249
    //   279: astore 4
    //   281: aload 5
    //   283: astore_3
    //   284: goto -99 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	ofx
    //   53	181	1	m	int
    //   237	5	2	localObject2	Object
    //   243	31	2	localObject3	Object
    //   15	253	3	localObject4	Object
    //   272	1	3	localObject5	Object
    //   283	1	3	localEcShopData1	EcShopData
    //   176	5	4	localObject7	Object
    //   183	56	4	localException1	Exception
    //   245	30	4	localObject8	Object
    //   279	1	4	localException2	Exception
    //   3	279	5	localEcShopData2	EcShopData
    // Exception table:
    //   from	to	target	type
    //   114	134	176	finally
    //   134	173	176	finally
    //   178	180	176	finally
    //   261	263	176	finally
    //   16	48	183	java/lang/Exception
    //   54	79	183	java/lang/Exception
    //   107	114	183	java/lang/Exception
    //   180	183	183	java/lang/Exception
    //   227	234	183	java/lang/Exception
    //   241	243	183	java/lang/Exception
    //   79	104	237	finally
    //   104	107	237	finally
    //   238	241	237	finally
    //   16	48	243	finally
    //   54	79	243	finally
    //   107	114	243	finally
    //   180	183	243	finally
    //   227	234	243	finally
    //   241	243	243	finally
    //   5	16	272	finally
    //   187	218	272	finally
    //   5	16	279	java/lang/Exception
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
      n = ugf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject1).mUin);
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
          m += ((abwp)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
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
    amxz localamxz;
    if (paramQQAppInterface != null)
    {
      localObject1 = str;
      if (!TextUtils.isEmpty(paramString))
      {
        localamxz = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        localObject1 = str;
        if ((localamxz != null) && (!akmb.a(paramQQAppInterface))) {
          break label109;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localamxz.a(paramString, true);
        if (localObject1 == null) {
          break label124;
        }
        localObject1 = ((PublicAccountInfo)localObject1).name;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label121;
        }
        paramQQAppInterface = ugf.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface == null) {
          break label121;
        }
        localObject1 = paramQQAppInterface.name;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label119;
        }
        return paramString;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = localamxz.b(paramString);
        continue;
      }
      label109:
      Object localObject2 = localamxz.b(paramString);
      continue;
      label119:
      return localObject2;
      label121:
      continue;
      label124:
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
        localObject2 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      } while (localObject2 == null);
      this.jdField_e_of_type_Boolean = paramBoolean;
      Object localObject2 = (RecentUser)((anuz)localObject1).findRecentUserByUin(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      ((anuz)localObject1).saveRecentUser((BaseRecentUser)localObject2);
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
          localObject = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          String str = this.jdField_a_of_type_ArrayOfJavaLangString[1];
          if (!bool2) {
            break label701;
          }
          paramContext = "1";
          label374:
          str = bjnd.a(str, "has_reddot", paramContext);
          if (localObject != null) {
            break label708;
          }
          paramContext = "0";
          label394:
          localObject = bjnd.a(str, "gender", paramContext);
          localBundle.putInt("PUSH_TASK_ID", localSharedPreferences.getInt("PUSH_TASK_ID", 0));
          localBundle.putString("str_ecshop_diy", localSharedPreferences.getString("str_ecshop_diy", ""));
          localBundle.putInt("PUSH_TASK_TYPE", localSharedPreferences.getInt("PUSH_TASK_TYPE", 0));
          localBundle.putString("PUSH_TASK_INFO", localSharedPreferences.getString("PUSH_TASK_INFO", ""));
          localBundle.putLong("PUSH_RECEIVE_TIME", localSharedPreferences.getLong("PUSH_RECEIVE_TIME", 0L));
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
            paramContext = bjnd.a((String)localObject, "jumpUrl", localSharedPreferences.getString("PUSH_JUMP_URL", ""));
          }
          if (!this.jdField_d_of_type_Boolean) {
            break label720;
          }
        }
        label701:
        label708:
        label720:
        for (Object localObject = String.valueOf(localSharedPreferences.getInt("FOLDER_MSG_TYPE", -1));; localObject = "0")
        {
          paramContext = bjnd.a(bjnd.a(paramContext, "type", (String)localObject), "taskType", String.valueOf(localSharedPreferences.getInt("PUSH_TASK_TYPE", 0)));
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
          paramContext = akla.a(paramContext.uin, paramContext.getType());
          paramContext = akla.a().a(paramContext);
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
          break label374;
          paramContext = String.valueOf(((Friends)localObject).gender);
          break label394;
        }
      }
    }
  }
  
  public void a(bcgw parambcgw, Activity paramActivity)
  {
    if (parambcgw == null) {
      return;
    }
    try
    {
      Object localObject = new GdtAd(a(parambcgw));
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.jdField_c_of_type_Int = 1;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)localObject);
      localParams.jdField_a_of_type_Boolean = b(parambcgw.Y);
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
      paramActivity.putString("big_brother_ref_source_key", ugf.b(parambcgw.ab));
      localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
      GdtHandler.a(localParams);
      return;
    }
    catch (Throwable parambcgw)
    {
      QLog.e("EcShopAssistantManager", 1, "enterGDTVideoActivity throw an exception: " + parambcgw);
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
        ??? = (ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18);
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
        this.jdField_a_of_type_JavaUtilSet = bfza.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
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
        if ((((RecentUser)localObject4).getType() == 1008) && (uaw.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
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
          if ((!uaw.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(jdField_g_of_type_JavaLangString)))
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
          localObject4 = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if ((localObject4 != null) && (((amxz)localObject4).c(((EcShopData)localObject2).mUin) != null))
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
  
  public boolean a(bcgw parambcgw, Activity paramActivity)
  {
    if (parambcgw == null) {
      return false;
    }
    Object localObject2;
    if (((parambcgw.a instanceof AbsShareMsg)) && (((AbsShareMsg)parambcgw.a).mStructMsgItemLists != null)) {
      localObject2 = (bcgw)((AbsShareMsg)parambcgw.a).mStructMsgItemLists.get(0);
    }
    for (;;)
    {
      try
      {
        if (((localObject2 instanceof bcgx)) && (((bcgw)localObject2).jdField_c_of_type_Int == 1))
        {
          Object localObject1 = new GdtAd(a((bcgw)localObject2));
          if (!"2711679534".equals(((bcgw)localObject2).ab)) {
            break label230;
          }
          bool = false;
          localObject2 = new GdtHandler.Params();
          ((GdtHandler.Params)localObject2).jdField_c_of_type_Int = 1;
          ((GdtHandler.Params)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
          ((GdtHandler.Params)localObject2).jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)localObject1);
          ((GdtHandler.Params)localObject2).jdField_a_of_type_Boolean = b(parambcgw.Y);
          ((GdtHandler.Params)localObject2).jdField_b_of_type_Boolean = bool;
          ((GdtHandler.Params)localObject2).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
          ((GdtHandler.Params)localObject2).jdField_b_of_type_JavaLangClass = ShopCanvasFragment.class;
          localObject1 = ((GdtHandler.Params)localObject2).jdField_a_of_type_AndroidOsBundle;
          paramActivity = (Activity)localObject1;
          if (localObject1 == null) {
            paramActivity = new Bundle();
          }
          paramActivity.putString("big_brother_ref_source_key", ugf.b(parambcgw.ab));
          ((GdtHandler.Params)localObject2).jdField_a_of_type_AndroidOsBundle = paramActivity;
          GdtHandler.a((GdtHandler.Params)localObject2);
          return true;
        }
        return false;
      }
      catch (Exception parambcgw)
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
    return ((jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_JavaUtilList.contains(paramString))) || (uaw.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
  }
  
  public List<RecentShopParcel> b()
  {
    if (!this.jdField_f_of_type_Boolean) {
      f();
    }
    amxz localamxz = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    SharedPreferences localSharedPreferences = a();
    ArrayList localArrayList = new ArrayList();
    EcShopData localEcShopData;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label404;
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
    label404:
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
          break label208;
        }
        localObject = ((JSONObject)localObject).getJSONArray("shopButton");
        if (!QLog.isColorLevel()) {
          break label239;
        }
        QLog.i("EcShopAssistantManager", 2, "shopButton info found:" + ((JSONArray)localObject).toString());
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        String str;
        int n;
        if (!QLog.isColorLevel()) {
          break label208;
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
        label208:
        return;
        QLog.d("EcShopAssistantManager", 2, "banner json config file is not existed path=" + jdField_a_of_type_JavaLangString);
        return;
        label239:
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
    bgoj localbgoj = ((bgog)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if (localbgoj != null)
    {
      Object localObject2 = aqyy.a("VIP_shop_assit_cfg", "https://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localbgoj.a((String)localObject2) == null)
      {
        Object localObject1 = new File(jdField_a_of_type_JavaLangString);
        localObject2 = new bgoe((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l1 = ((File)localObject1).lastModified();
          ((bgoe)localObject2).i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l1).longValue() != ((bgoe)localObject2).i) {
            ((bgoe)localObject2).m = true;
          }
        }
        ((bgoe)localObject2).j = true;
        ((bgoe)localObject2).p = false;
        localObject1 = new Bundle();
        localbgoj.a((bgoe)localObject2, this.jdField_a_of_type_Oga, (Bundle)localObject1);
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
        anuz localanuz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        Object localObject = localanuz.getRecentList(false);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((1008 == localRecentUser.getType()) && (uaw.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)))
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
            localanuz.delRecentUser(localRecentUser);
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
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(11);
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
      localObject2 = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
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
        if ((l2 <= i1) || (l2 >= i2) || (((amxz)localObject2).a(Long.valueOf(l1)))) {
          break label571;
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
            break label501;
          }
          localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
          label314:
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
      label370:
      if (n >= m) {
        break label576;
      }
      if (!String.valueOf(l1).equals(((EcShopData)((List)localObject1).get(n)).mUin)) {}
    }
    label543:
    label571:
    label576:
    for (localObject1 = (EcShopData)((List)localObject1).get(n);; localObject1 = null)
    {
      if (((l2 < i1) || (l2 > i2) || (((amxz)localObject2).a(Long.valueOf(l1)))) && (localObject1 != null))
      {
        b(((EcShopData)localObject1).mUin);
        m = 0;
        break;
        n += 1;
        break label370;
      }
      if (localObject1 != null)
      {
        m = 1;
        localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
        break;
        label501:
        if ((m == 0) || (!QLog.isColorLevel())) {
          break label314;
        }
        QLog.i("EcShopAssistantManager", 2, "show ad ,puin=" + jdField_g_of_type_JavaLangString);
        break label314;
        ((ogr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(88)).a(134246436, null, null, null, null, this.jdField_b_of_type_Long, false);
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
      this.jdField_a_of_type_Oga = null;
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofx
 * JD-Core Version:    0.7.0.1
 */