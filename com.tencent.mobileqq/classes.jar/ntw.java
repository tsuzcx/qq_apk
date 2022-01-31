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
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
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

public class ntw
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
  public static final String e;
  public static final String f;
  public static String g;
  public static final String h;
  public long a;
  public BroadcastReceiver a;
  bdbb jdField_a_of_type_Bdbb;
  bdbc jdField_a_of_type_Bdbc = new nty(this);
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  public QQAppInterface a;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  public List<EcShopData> a;
  private Map<String, EcShopData> jdField_a_of_type_JavaUtilMap;
  public Set<String> a;
  private ntz jdField_a_of_type_Ntz;
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
    jdField_b_of_type_JavaLangString = alof.aX + ".shop_assit/image/";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Int = 600000;
    jdField_e_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";
    jdField_f_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_jd_conf.json";
    jdField_a_of_type_Boolean = true;
    jdField_h_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsoluteFile() + File.separator + "animConfig/red_packet.png";
  }
  
  public ntw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3" };
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ntx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.l = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
      ThreadManager.post(new EcShopAssistantManager.1(this), 5, null, true);
      this.jdField_a_of_type_Bdbb = new bdbb(paramQQAppInterface);
      this.jdField_a_of_type_Bdbb.a(this.jdField_a_of_type_Bdbc);
      this.jdField_a_of_type_Ntz = new ntz(this);
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
      Object localObject1 = paramContext.getResources().getDrawable(2130839327);
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
        return paramContext.getResources().getDrawable(2130846584);
      }
    }
    return paramContext.getResources().getDrawable(2130846584);
  }
  
  public static String a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if ((jdField_c_of_type_JavaUtilList == null) || (!jdField_c_of_type_JavaUtilList.contains(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!paramString2.contains("qq.com")) || (paramString2.contains("&g_tk="))) {
      return paramString2;
    }
    paramQQAppInterface = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getCurrentAccountUin());
    StringBuilder localStringBuilder = new StringBuilder(paramString2);
    if (paramString2.contains("?")) {}
    for (paramString1 = "&g_tk=";; paramString1 = "?g_tk=")
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(String.valueOf(bcpx.b(paramQQAppInterface)));
      return localStringBuilder.toString();
    }
  }
  
  public static qq_ad_get.QQAdGetRsp.AdInfo a(azus paramazus)
  {
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    if (paramazus == null) {
      return localAdInfo;
    }
    Object localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
    if (!bdnn.a(paramazus.r)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).advertiser_id.set(Long.parseLong(paramazus.r));
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_image_name.set(paramazus.N);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localObject1).corporate_logo.set(paramazus.O);
    Object localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localObject2).video_url.set(paramazus.F);
    qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo localDisplayInfo = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
    localDisplayInfo.advertiser_info.set((MessageMicro)localObject1);
    localDisplayInfo.video_info.set((MessageMicro)localObject2);
    localDisplayInfo.mini_program_type.set(paramazus.f);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    if (!bdnn.a(paramazus.s)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).aid.set(Long.parseLong(paramazus.s));
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).traceid.set(paramazus.D);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).via.set(paramazus.E);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).product_id.set(paramazus.A);
    if (!bdnn.a(paramazus.z)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject2).noco_id.set(Long.parseLong(paramazus.z));
    }
    localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.set(paramazus.q);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.set(paramazus.B);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).effect_url.set(paramazus.w);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).landing_page_report_url.set(paramazus.y);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.set((MessageMicro)localObject2);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
    if (!bdnn.a(paramazus.K)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_click_monitor_url.set(Arrays.asList(paramazus.K.split("\\|")));
    }
    if (!bdnn.a(paramazus.L)) {
      ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject2).api_exposure_monitor_url.set(Arrays.asList(paramazus.L.split("\\|")));
    }
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).thirdparty_monitor_urls.set((MessageMicro)localObject2);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).landing_page.set(paramazus.x);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).canvas_json.set(paramazus.u);
    ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject2).dest_type.set(paramazus.jdField_d_of_type_Int);
    qq_ad_get.QQAdGetRsp.AdInfo.AppInfo localAppInfo = new qq_ad_get.QQAdGetRsp.AdInfo.AppInfo();
    localAppInfo.customized_invoke_url.set(paramazus.H);
    localAppInfo.pkg_download_schema.set(paramazus.t);
    localAppInfo.app_name.set(paramazus.G);
    localAppInfo.app_package_name.set(paramazus.I);
    localAppInfo.pkg_url.set(paramazus.J);
    localAppInfo.android_app_id.set(paramazus.A);
    localAppInfo.channel_id.set(paramazus.C);
    localAdInfo.product_type.set(paramazus.e);
    localAdInfo.display_info.set(localDisplayInfo);
    localAdInfo.report_info.set((MessageMicro)localObject1);
    localAdInfo.dest_info.set((MessageMicro)localObject2);
    localAdInfo.app_info.set(localAppInfo);
    return localAdInfo;
  }
  
  /* Error */
  public static qq_ad_get.QQAdGetRsp.AdInfo a(com.tencent.mobileqq.data.ChatMessage paramChatMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_0
    //   8: instanceof 594
    //   11: ifeq +158 -> 169
    //   14: aload_0
    //   15: checkcast 594	com/tencent/mobileqq/data/MessageForStructing
    //   18: getfield 598	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   21: astore_0
    //   22: aload_3
    //   23: astore_1
    //   24: aload_0
    //   25: instanceof 600
    //   28: ifeq +139 -> 167
    //   31: aload_0
    //   32: checkcast 600	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   35: getfield 603	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mStructMsgItemLists	Ljava/util/List;
    //   38: astore_0
    //   39: aload_3
    //   40: astore_1
    //   41: aload_0
    //   42: ifnull +125 -> 167
    //   45: aload_3
    //   46: astore_1
    //   47: aload_0
    //   48: invokeinterface 606 1 0
    //   53: ifne +114 -> 167
    //   56: aload_0
    //   57: invokeinterface 610 1 0
    //   62: astore_2
    //   63: aload 4
    //   65: astore_0
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: invokeinterface 615 1 0
    //   74: ifeq +93 -> 167
    //   77: aload_2
    //   78: invokeinterface 619 1 0
    //   83: checkcast 325	azus
    //   86: astore_1
    //   87: aload_1
    //   88: instanceof 621
    //   91: ifeq +61 -> 152
    //   94: aload_1
    //   95: checkcast 621	azyj
    //   98: getfield 624	azyj:a	Ljava/util/ArrayList;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +259 -> 362
    //   106: aload_1
    //   107: invokevirtual 627	java/util/ArrayList:isEmpty	()Z
    //   110: ifne +252 -> 362
    //   113: aload_1
    //   114: invokevirtual 628	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   117: astore_1
    //   118: aload_1
    //   119: invokeinterface 615 1 0
    //   124: ifeq +238 -> 362
    //   127: aload_1
    //   128: invokeinterface 619 1 0
    //   133: checkcast 325	azus
    //   136: astore_3
    //   137: aload_3
    //   138: instanceof 630
    //   141: ifeq -23 -> 118
    //   144: aload_3
    //   145: invokestatic 632	ntw:a	(Lazus;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   148: astore_0
    //   149: goto -83 -> 66
    //   152: aload_1
    //   153: instanceof 634
    //   156: ifeq +206 -> 362
    //   159: aload_1
    //   160: checkcast 634	azyl
    //   163: invokestatic 632	ntw:a	(Lazus;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   166: astore_1
    //   167: aload_1
    //   168: areturn
    //   169: aload_3
    //   170: astore_1
    //   171: aload_0
    //   172: instanceof 636
    //   175: ifeq -8 -> 167
    //   178: aload_0
    //   179: checkcast 636	com/tencent/mobileqq/data/MessageForArkApp
    //   182: getfield 640	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   185: astore_0
    //   186: aload_3
    //   187: astore_1
    //   188: aload_0
    //   189: ifnull -22 -> 167
    //   192: aload_0
    //   193: getfield 645	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   196: astore_0
    //   197: aload_3
    //   198: astore_1
    //   199: aload_0
    //   200: invokestatic 333	bdnn:a	(Ljava/lang/String;)Z
    //   203: ifne -36 -> 167
    //   206: new 647	org/json/JSONObject
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 648	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   214: ldc_w 650
    //   217: invokevirtual 654	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   220: astore_1
    //   221: new 319	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   224: dup
    //   225: invokespecial 320	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   228: astore_0
    //   229: aload_0
    //   230: getfield 578	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   233: getfield 469	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   236: getfield 410	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   239: aload_1
    //   240: ldc_w 655
    //   243: invokevirtual 658	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokestatic 343	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: invokevirtual 349	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   252: aload_0
    //   253: getfield 578	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   256: getfield 469	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   259: getfield 413	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   262: aload_1
    //   263: ldc_w 659
    //   266: invokevirtual 658	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   272: aload_0
    //   273: getfield 578	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   276: getfield 444	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   279: aload_1
    //   280: ldc_w 661
    //   283: invokevirtual 658	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: invokevirtual 360	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   289: aload_1
    //   290: ldc_w 662
    //   293: invokevirtual 654	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   296: astore_1
    //   297: aload_1
    //   298: ifnull +49 -> 347
    //   301: aload_0
    //   302: getfield 578	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   305: getfield 503	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   308: getfield 480	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   311: aload_1
    //   312: ldc_w 663
    //   315: invokevirtual 667	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   318: invokestatic 672	nup:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   321: invokevirtual 493	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   324: aload_0
    //   325: getfield 578	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   328: getfield 503	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   331: getfield 499	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   334: aload_1
    //   335: ldc_w 673
    //   338: invokevirtual 667	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   341: invokestatic 672	nup:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   344: invokevirtual 493	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   347: aload_0
    //   348: areturn
    //   349: astore_1
    //   350: aload_2
    //   351: astore_0
    //   352: aload_1
    //   353: invokevirtual 674	java/lang/Exception:printStackTrace	()V
    //   356: aload_0
    //   357: areturn
    //   358: astore_1
    //   359: goto -7 -> 352
    //   362: goto -213 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramChatMessage	com.tencent.mobileqq.data.ChatMessage
    //   23	312	1	localObject1	Object
    //   349	4	1	localException1	Exception
    //   358	1	1	localException2	Exception
    //   3	348	2	localIterator	Iterator
    //   1	197	3	localazus	azus
    //   5	59	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   178	186	349	java/lang/Exception
    //   192	197	349	java/lang/Exception
    //   199	229	349	java/lang/Exception
    //   229	297	358	java/lang/Exception
    //   301	347	358	java/lang/Exception
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
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
      if ((paramQQAppInterface.a().a(paramString, 1008) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
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
    Object localObject2 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if ((localObject2 == null) || (localObject1 == null)) {
      return false;
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      localObject2 = ((amnz)localObject1).a(alof.ae, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      EcShopData localEcShopData = a();
      if (localEcShopData != null)
      {
        ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
        ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        ((amnz)localObject1).a((RecentUser)localObject2);
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
      localObject2 = ((amnz)localObject1).b(alof.ae, 7120);
      if (localObject2 != null) {
        ((amnz)localObject1).b((RecentUser)localObject2);
      }
      QLog.d("EcShopAssistantManager", 2, "del ecshop folder...");
    }
  }
  
  private boolean a(awgf paramawgf, String paramString)
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
        bool = paramawgf.b(localEcShopData);
      }
      QLog.d("EcShopAssistantManager", 2, "removeEcShopData puin: " + paramString);
      if (this.jdField_f_of_type_Boolean)
      {
        paramawgf = new Intent("action_on_shop_msg_receive");
        paramawgf.putParcelableArrayListExtra("datas", (ArrayList)b());
        BaseApplicationImpl.getContext().sendBroadcast(paramawgf);
      }
      return bool;
      paramawgf = finally;
      throw paramawgf;
    }
  }
  
  public static int b()
  {
    int n = 0;
    String str = bdgk.b();
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
  
  private void c(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1008) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
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
    //   6: getfield 162	ntw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 884	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawgg;
    //   12: invokevirtual 890	awgg:createEntityManager	()Lawgf;
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 737
    //   20: iconst_0
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc_w 892
    //   28: aconst_null
    //   29: invokevirtual 895	awgf:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   32: astore_2
    //   33: new 44	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 897
    //   43: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: astore 4
    //   48: aload_2
    //   49: ifnonnull +178 -> 227
    //   52: iconst_0
    //   53: istore_1
    //   54: ldc_w 750
    //   57: iconst_2
    //   58: aload 4
    //   60: iload_1
    //   61: invokevirtual 900	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 757	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: getfield 129	ntw:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   74: astore 4
    //   76: aload 4
    //   78: monitorenter
    //   79: aload_0
    //   80: aload_2
    //   81: putfield 173	ntw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   84: aload_0
    //   85: getfield 173	ntw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   88: ifnonnull +16 -> 104
    //   91: aload_0
    //   92: new 626	java/util/ArrayList
    //   95: dup
    //   96: bipush 16
    //   98: invokespecial 902	java/util/ArrayList:<init>	(I)V
    //   101: putfield 173	ntw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   104: aload 4
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 171	ntw:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   111: astore_2
    //   112: aload_2
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 171	ntw:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   118: invokeinterface 905 1 0
    //   123: aload_0
    //   124: getfield 173	ntw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   127: invokeinterface 610 1 0
    //   132: astore 4
    //   134: aload 4
    //   136: invokeinterface 615 1 0
    //   141: ifeq +120 -> 261
    //   144: aload 4
    //   146: invokeinterface 619 1 0
    //   151: checkcast 737	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   154: astore 5
    //   156: aload_0
    //   157: getfield 171	ntw:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   160: aload 5
    //   162: getfield 908	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   165: aload 5
    //   167: invokeinterface 912 3 0
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
    //   187: ldc_w 750
    //   190: iconst_2
    //   191: new 44	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 914
    //   201: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 4
    //   206: invokevirtual 917	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 919	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 921	awgf:a	()V
    //   226: return
    //   227: aload_2
    //   228: invokeinterface 924 1 0
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
    //   256: invokevirtual 921	awgf:a	()V
    //   259: aload_3
    //   260: athrow
    //   261: aload_2
    //   262: monitorexit
    //   263: aload_3
    //   264: ifnull -38 -> 226
    //   267: aload_3
    //   268: invokevirtual 921	awgf:a	()V
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
    //   0	287	0	this	ntw
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
      n = syb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject1).mUin);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject2 == null) {
        break label124;
      }
    }
    label119:
    label124:
    for (Object localObject1 = ((QQMessageFacade)localObject2).a(((EcShopData)localObject1).mUin, n);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localObject2 != null) {
          m += ((abta)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
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
          n = paramQQAppInterface.a().a(str, 1008);
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
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ??? = localEcShopData;
        if (localQQMessageFacade != null)
        {
          paramString = localQQMessageFacade.a(paramString, 1008);
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
    alzl localalzl;
    if (paramQQAppInterface != null)
    {
      localObject1 = str;
      if (!TextUtils.isEmpty(paramString))
      {
        localalzl = (alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        localObject1 = str;
        if ((localalzl != null) && (!ajkl.a(paramQQAppInterface))) {
          break label109;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localalzl.a(paramString, true);
        if (localObject1 == null) {
          break label124;
        }
        localObject1 = ((PublicAccountInfo)localObject1).name;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label121;
        }
        paramQQAppInterface = syb.a(paramQQAppInterface, paramString);
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
        localObject2 = localalzl.b(paramString);
        continue;
      }
      label109:
      Object localObject2 = localalzl.b(paramString);
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
        localObject2 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      } while (localObject2 == null);
      this.jdField_e_of_type_Boolean = paramBoolean;
      Object localObject2 = ((amnz)localObject1).a(alof.ae, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      ((amnz)localObject1).a((RecentUser)localObject2);
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
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_tool_exist", bool);
      localBundle.putLong("click_time", System.currentTimeMillis());
      localBundle.putStringArray("urls", this.jdField_a_of_type_ArrayOfJavaLangString);
      SharedPreferences localSharedPreferences = a();
      if (localSharedPreferences.getBoolean("folder_tab_red", false)) {}
      for (bool = true;; bool = false)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (paramInt >= 0)
        {
          if (paramInt <= 0) {
            break label705;
          }
          bool = true;
        }
        label390:
        label685:
        label697:
        label705:
        for (;;)
        {
          label251:
          localBundle.putBoolean("hasUnread", bool);
          localBundle.putLong("last_read_folder", localSharedPreferences.getLong("last_read_folder", 0L));
          localBundle.putLong("latest_time", localSharedPreferences.getLong("latest_time", 0L));
          localBundle.putInt("unReadNum", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b());
          localBundle.putBoolean("isDefaultTheme", ThemeUtil.isDefaultOrDIYTheme(false));
          Object localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          String str = this.jdField_a_of_type_ArrayOfJavaLangString[1];
          if (bool)
          {
            paramContext = "1";
            label370:
            str = bhsz.a(str, "has_reddot", paramContext);
            if (localObject != null) {
              break label685;
            }
            paramContext = "0";
            localObject = bhsz.a(str, "gender", paramContext);
            localBundle.putInt("PUSH_TASK_ID", localSharedPreferences.getInt("PUSH_TASK_ID", 0));
            localBundle.putString("str_ecshop_diy", localSharedPreferences.getString("str_ecshop_diy", ""));
            localBundle.putInt("PUSH_TASK_TYPE", localSharedPreferences.getInt("PUSH_TASK_TYPE", 0));
            localBundle.putString("PUSH_TASK_INFO", localSharedPreferences.getString("PUSH_TASK_INFO", ""));
            localBundle.putLong("PUSH_RECEIVE_TIME", localSharedPreferences.getLong("PUSH_RECEIVE_TIME", 0L));
            paramContext = (Context)localObject;
            if (!TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
              paramContext = bhsz.a((String)localObject, "jumpUrl", localSharedPreferences.getString("PUSH_JUMP_URL", ""));
            }
            if (!this.jdField_d_of_type_Boolean) {
              break label697;
            }
          }
          for (localObject = String.valueOf(localSharedPreferences.getInt("FOLDER_MSG_TYPE", -1));; localObject = "0")
          {
            paramContext = bhsz.a(bhsz.a(paramContext, "type", (String)localObject), "taskType", String.valueOf(localSharedPreferences.getInt("PUSH_TASK_TYPE", 0)));
            paramIntent.putExtra("bundle", localBundle);
            paramIntent.putExtra("url", paramContext);
            return;
            localBundle = paramIntent.getExtras();
            break;
            if (paramContext == null) {
              break label705;
            }
            paramContext = paramContext.b(alof.ae, 7120);
            if (paramContext == null) {
              break label705;
            }
            paramContext = ajjj.a(paramContext.uin, paramContext.getType());
            paramContext = ajjj.a().a(paramContext);
            if ((paramContext == null) || (paramContext.mUnreadNum <= 0)) {
              break label705;
            }
            bool = true;
            break label251;
            paramContext = "0";
            break label370;
            paramContext = String.valueOf(((Friends)localObject).gender);
            break label390;
          }
        }
      }
    }
  }
  
  public void a(azus paramazus, Activity paramActivity)
  {
    if (paramazus == null) {
      return;
    }
    try
    {
      paramazus = new GdtAd(a(paramazus));
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.jdField_c_of_type_Int = 1;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramazus;
      localParams.jdField_a_of_type_Boolean = false;
      localParams.jdField_b_of_type_Boolean = false;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localParams.jdField_b_of_type_JavaLangClass = ShopCanvasFragment.class;
      localParams.jdField_a_of_type_JavaLangClass = ShopVideoCeilingFragment.class;
      localParams.jdField_c_of_type_Boolean = true;
      paramActivity = localParams.jdField_a_of_type_AndroidOsBundle;
      paramazus = paramActivity;
      if (paramActivity == null) {
        paramazus = new Bundle();
      }
      paramazus.putString("big_brother_ref_source_key", "biz_src_gzh_qqgw");
      localParams.jdField_a_of_type_AndroidOsBundle = paramazus;
      GdtHandler.a(localParams);
      return;
    }
    catch (Throwable paramazus)
    {
      QLog.e("EcShopAssistantManager", 1, "enterGDTVideoActivity throw an exception: " + paramazus);
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
          ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
          QLog.d("EcShopAssistantManager", 2, "saveEcShopData(db&cache) puin: " + paramEcShopData.mUin + ", status: " + paramEcShopData.getStatus());
          return;
          paramEcShopData = finally;
          throw paramEcShopData;
          m += 1;
        }
      }
      ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
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
        this.jdField_a_of_type_JavaUtilSet = bdnf.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
        if (this.jdField_a_of_type_JavaUtilSet == null)
        {
          this.jdField_a_of_type_JavaUtilSet = new HashSet();
          if (c())
          {
            c(false);
            localObject2 = paramQQAppInterface.a();
            if (localObject2 == null) {
              return;
            }
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
              QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localEcShopData.mUin, 1008);
              if ((paramQQAppInterface.a().a(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.jdField_c_of_type_Long)) {
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
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
      }
      jdField_g_of_type_JavaLangString = null;
    }
    EcShopData localEcShopData = a(str);
    localEcShopData.mImgInfo = "";
    if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {}
    for (localEcShopData.mLastMsgTime = paramMessageRecord.time;; localEcShopData.mLastMsgTime = l1)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localEcShopData.mUin, 1008);
      if (localMessage != null)
      {
        long l2 = localMessage.time;
        if (l2 > localEcShopData.mLastMsgTime) {
          localEcShopData.mLastMsgTime = l2;
        }
        if ((l2 > a().getLong("latest_time", 0L)) && (localSharedPreferences != null)) {
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
      if (TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
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
      if ((!TextUtils.isEmpty(paramString)) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())))) {
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
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ??? = paramString2.a(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (ssp.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList()))
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
          if ((!ssp.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(jdField_g_of_type_JavaLangString)))
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
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((EcShopData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((EcShopData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((EcShopData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a((EcShopData)localObject4);
          paramString2.b((RecentUser)???);
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
        ??? = paramString2.a(((EcShopData)localObject2).mUin, 1008);
        ((RecentUser)???).uin = ((EcShopData)localObject2).mUin;
        ((RecentUser)???).setType(1008);
        ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
        ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
        if (a(paramString1, ((EcShopData)localObject2).mUin))
        {
          localObject4 = (alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if ((localObject4 != null) && (((alzl)localObject4).c(((EcShopData)localObject2).mUin) != null))
          {
            paramString2.a((RecentUser)???);
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
      paramString1.a();
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
  
  public boolean a(azus paramazus, Activity paramActivity)
  {
    if (paramazus == null) {
      return false;
    }
    if (((paramazus.a instanceof AbsShareMsg)) && (((AbsShareMsg)paramazus.a).mStructMsgItemLists != null))
    {
      paramazus = (azus)((AbsShareMsg)paramazus.a).mStructMsgItemLists.get(0);
      try
      {
        if (((paramazus instanceof azut)) && (paramazus.jdField_c_of_type_Int == 1))
        {
          paramazus = new GdtAd(a(paramazus));
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.jdField_c_of_type_Int = 1;
          localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
          localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramazus;
          localParams.jdField_a_of_type_Boolean = false;
          localParams.jdField_b_of_type_Boolean = false;
          localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
          localParams.jdField_b_of_type_JavaLangClass = ShopCanvasFragment.class;
          paramActivity = localParams.jdField_a_of_type_AndroidOsBundle;
          paramazus = paramActivity;
          if (paramActivity == null) {
            paramazus = new Bundle();
          }
          paramazus.putString("big_brother_ref_source_key", "biz_src_gzh_qqgw");
          localParams.jdField_a_of_type_AndroidOsBundle = paramazus;
          GdtHandler.a(localParams);
          return true;
        }
        return false;
      }
      catch (Exception paramazus)
      {
        return false;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return ((jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_JavaUtilList.contains(paramString))) || (ssp.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
  }
  
  public List<RecentShopParcel> b()
  {
    if (!this.jdField_f_of_type_Boolean) {
      f();
    }
    alzl localalzl = (alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
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
    ((RecentItemEcShop)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext());
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
      localRecentShopParcel.jdField_a_of_type_Long = ((RecentItemEcShop)localObject3).a();
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
      localObject = bdhb.a((File)localObject);
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
          if (paramQQAppInterface.a().a(str, 1008) > 0) {
            paramQQAppInterface.a().a(str, 1008, false);
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
    beaj localbeaj = ((beag)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
    if (localbeaj != null)
    {
      Object localObject2 = apmq.a("VIP_shop_assit_cfg", "http://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localbeaj.a((String)localObject2) == null)
      {
        Object localObject1 = new File(jdField_a_of_type_JavaLangString);
        localObject2 = new beae((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l1 = ((File)localObject1).lastModified();
          ((beae)localObject2).i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l1).longValue() != ((beae)localObject2).i) {
            ((beae)localObject2).m = true;
          }
        }
        ((beae)localObject2).j = true;
        ((beae)localObject2).p = false;
        localObject1 = new Bundle();
        localbeaj.a((beae)localObject2, this.jdField_a_of_type_Ntz, (Bundle)localObject1);
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
        amnz localamnz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        Object localObject = localamnz.a(false);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((1008 == localRecentUser.getType()) && (ssp.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)))
        {
          EcShopData localEcShopData = a(localRecentUser.uin);
          localEcShopData.mLastDraftTime = localRecentUser.lastmsgdrafttime;
          localEcShopData.mLastMsgTime = localRecentUser.lastmsgtime;
          if (localEcShopData.mLastMsgTime == 0L)
          {
            QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localEcShopData.mUin, 1008);
            if (localMessage != null)
            {
              l1 = localMessage.time;
              localEcShopData.mLastMsgTime = l1;
            }
          }
          else
          {
            a(localEcShopData);
            localamnz.b(localRecentUser);
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
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
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
      localObject2 = (alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
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
        if ((l2 <= i1) || (l2 >= i2) || (((alzl)localObject2).a(Long.valueOf(l1)))) {
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
      if (((l2 < i1) || (l2 > i2) || (((alzl)localObject2).a(Long.valueOf(l1)))) && (localObject1 != null))
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
        ((nup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134246436, null, null, null, null, this.jdField_b_of_type_Long, false);
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
      if (this.jdField_a_of_type_Bdbb != null)
      {
        this.jdField_a_of_type_Bdbb.d();
        this.jdField_a_of_type_Bdbb = null;
      }
      this.jdField_a_of_type_Ntz = null;
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ntw
 * JD-Core Version:    0.7.0.1
 */