package com.tencent.qcircle.cooperation.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;

public class QCircleConfigHelper
{
  public static boolean A()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqcircle", "qqcircle_feed_mute", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String B()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_host_product_empty_text", "生活的每一个瞬间\n都值得被记录");
  }
  
  public static String C()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_host_product_empty_jump_title", "发布第一个作品");
  }
  
  public static String D()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_host_list_empty_text", "生活的每一个瞬间\n都值得被记录");
  }
  
  public static String E()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_host_list_empty_jump_title", "发布第一个作品");
  }
  
  public static String F()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "当qqcircle_homepage_host_push_empty_text", "当你用心看这个世界\n这个世界也在用心回望你");
  }
  
  public static String G()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_host_push_empty_jump_title", "探索更多小世界");
  }
  
  public static String H()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_product_empty_text", "这个小世界尚未启动\n你的目光早已启程");
  }
  
  public static String I()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_product_empty_jump_title", "探索更多小世界");
  }
  
  public static String J()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_list_empty_text", "这个小世界尚未启动\n你的目光早已启程");
  }
  
  public static String K()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_list_empty_jump_title", "探索更多小世界");
  }
  
  public static String L()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_push_empty_text", "这个小世界尚未启动\n你的目光早已启程");
  }
  
  public static String M()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_push_empty_jump_title", "探索更多小世界");
  }
  
  public static String N()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_inmyblacklist_text", "该用户在你的\n小世界黑名单中");
  }
  
  public static String O()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_inmyblacklist_jump_title", "编辑黑名单");
  }
  
  public static String P()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_messag_empty_text", "没有你的消息\n世界从此慢慢疏离");
  }
  
  public static String Q()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_message_empty_jump_title", "探索更多小世界");
  }
  
  public static String R()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_aggreagte_empty_text", "这片沃土空空如也\n等待你来开垦");
  }
  
  public static String S()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_aggreagte_empty_jump_title", "发布第一个作品");
  }
  
  public static String T()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_detail_error_content_deleted_text", "害！来晚一步\n这个内容已下落不明");
  }
  
  public static String U()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nonet_error_text", "无法连接小世界\n检查一下网络再试吧");
  }
  
  public static String V()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_server_error_text", "网络开小差儿啦");
  }
  
  public static String W()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_works_text", "附近暂无内容\n成为这里的第一个发布者吧");
  }
  
  public static String X()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_works_jump_title", "去发布");
  }
  
  public static String Y()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_permission_text", "打开定位服务\n查看更多附近的作品");
  }
  
  public static String Z()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_permission_jump_title", "去设置");
  }
  
  public static int a(int paramInt)
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_default_show_tab_type", paramInt);
  }
  
  public static Boolean a(String paramString1, String paramString2, Boolean paramBoolean)
  {
    return Boolean.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramBoolean.booleanValue()));
  }
  
  public static Integer a(String paramString1, String paramString2, Integer paramInteger)
  {
    return Integer.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramInteger.intValue()));
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject)
  {
    String str = paramObject.getClass().getName();
    switch (str.hashCode())
    {
    default: 
      break;
    case 1195259493: 
      if (str.equals("java.lang.String")) {
        i = 1;
      }
      break;
    case 398795216: 
      if (str.equals("java.lang.Long")) {
        i = 3;
      }
      break;
    case 344809556: 
      if (str.equals("java.lang.Boolean")) {
        i = 4;
      }
      break;
    case -527879800: 
      if (str.equals("java.lang.Float")) {
        i = 2;
      }
      break;
    case -2056817302: 
      if (str.equals("java.lang.Integer")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return null;
            }
            return Boolean.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, ((Boolean)paramObject).booleanValue()));
          }
          return Long.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, ((Long)paramObject).longValue()));
        }
        return Float.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, ((Float)paramObject).floatValue()));
      }
      return QzoneConfig.getInstance().getConfig(paramString1, paramString2, (String)paramObject);
    }
    return Integer.valueOf(QzoneConfig.getInstance().getConfig(paramString1, paramString2, ((Integer)paramObject).intValue()));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, "");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramString3);
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_task_use_hippy", 1) == 1;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (TabDataHelper.isOnceFetchFromServer(RFApplication.getApplication(), RFApplication.getInstance().getAccountId())) {
      return TabDataHelper.isExtendTabShow(RFApplication.getApplication(), RFApplication.getInstance().getAccountId(), "NEW_WORLD");
    }
    boolean bool = false;
    int i;
    if (paramBoolean) {
      i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_main_tab_on_children_mode", 0);
    } else {
      i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_main_tab", 0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initQCircleTab isQQCircleMainTabEntrance:");
    localStringBuilder.append(i);
    QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    paramBoolean = bool;
    if (i == 1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static boolean aA()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_splash_transition_enable", 1) == 1;
  }
  
  public static String aB()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_user_welcome_button_text", "探索小世界");
  }
  
  public static String aC()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_user_welcome_community_num", "3200W");
  }
  
  public static boolean aD()
  {
    return a("qqcircle", "qcircle_nearby_tab_switch", Integer.valueOf(1)).intValue() == 1;
  }
  
  public static boolean aE()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_fasioncopy_support_schema", false);
  }
  
  public static int aF()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_folder_lazy_load_wait_time", 2000);
  }
  
  public static int aG()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_get_devices_for_maxduration", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      int i = 0;
      while (i < localObject.length)
      {
        if (Build.MODEL.toLowerCase().equals(localObject[i].toLowerCase())) {
          return 60000;
        }
        i += 1;
      }
    }
    return QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_get_max_video_duration", 180000);
  }
  
  public static boolean aH()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_quic_open", false);
  }
  
  public static int aI()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_publish_label_max_count", 8);
  }
  
  public static int aJ()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_all_push_page_layout_type", 1);
  }
  
  public static int aK()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_aggregation_show_paitongkuan", 1);
  }
  
  public static boolean aL()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_need_open_loginout", 1) == 1;
  }
  
  public static String aM()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_hint_in_black_list", "该用户在你的小世界黑名单中");
  }
  
  public static String aN()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_product_owner", "暂无作品");
  }
  
  public static String aO()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_product_owner", "快来分享你的生活，让大家更好的了解你");
  }
  
  public static String aP()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_product_clinet", "暂无内容");
  }
  
  public static String aQ()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_product_clinet", "他还没有发表过作品，去广场看看吧");
  }
  
  public static String aR()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_praised_owner", "赞过的作品");
  }
  
  public static String aS()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_praised_owner", "你点赞的作品都在这里，只有自己可见哦");
  }
  
  public static String aT()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_praised_client", "暂无内容");
  }
  
  public static String aU()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_praised_client", "他还没有点赞过作品，去广场看看吧");
  }
  
  public static String aV()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_praised_private", "赞过内容不可见");
  }
  
  public static String aW()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_praised_private", "该用户已将赞过列表设为私密");
  }
  
  public static String aX()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_pushed_owner", "推过的作品");
  }
  
  public static String aY()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_pushed_owner", "你推荐过的作品都会在这里，所有人可见哦");
  }
  
  public static String aZ()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_pushed_client", "暂无内容");
  }
  
  public static String aa()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_gpsinfo_text", "获取地理位置失败");
  }
  
  public static String ab()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_gpsinfo_jump_title", "点击重试");
  }
  
  public static String ac()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_get_permission_tips_text", "是否允许获取你的位置信息？\n不允许将无法查看附近的内容");
  }
  
  public static String ad()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_main_view_hint_text", "发个作品让更多人看到你");
  }
  
  public static String ae()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_hint_text", "写下想法让更多人看见你～");
  }
  
  public static int af()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_watchad_reward_money_count", 0);
  }
  
  public static boolean ag()
  {
    int i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_use_avatar", 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("use qcircle avatar:");
      localStringBuilder.append(i);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    return i == 1;
  }
  
  public static boolean ah()
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool = false;
    int i = ((QzoneConfig)localObject).getConfig("qqcircle", "qqcircle_show_invite_guide_bubble_on_profile_page", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isQQCircleShowInviteGuideBubbleOnProfilePage:");
      ((StringBuilder)localObject).append(i);
      QLog.e("QCircleConfigHelper", 1, ((StringBuilder)localObject).toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean ai()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean aj()
  {
    int i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_is_open_page_interactive_param_collect", 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQQCircleOpenPageInteractiveParamCollect:");
      localStringBuilder.append(i);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    return i == 1;
  }
  
  public static int ak()
  {
    try
    {
      int i = Integer.valueOf(a("QZoneSetting", "QCircleFriendMaxSelectCountComment", Integer.valueOf(10)).intValue()).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 10;
  }
  
  public static long al()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_getplugininfo_time", 300000);
  }
  
  public static int am()
  {
    int i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_max_crash_count", 2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SECONDARY_QQCIRCLE_DISABLE_PLUGIN:");
      localStringBuilder.append(i);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public static boolean an()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_use_qq_compose", 1) == 1;
  }
  
  public static boolean ao()
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool = false;
    if (((QzoneConfig)localObject).getConfig("qqcircle", "qqcircle_feed_share_btn_test", 0) == 1) {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getQCircleFeedShareBtnTest:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("QCircleConfigHelper", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public static boolean ap()
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool = false;
    if (((QzoneConfig)localObject).getConfig("qqcircle", "qqcircle_feed_comment_button", 0) == 1) {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getQQCircleFeedCommentBtnTest:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("QCircleConfigHelper", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public static int aq()
  {
    return a("qqcircle", "qqcircle_flow_tab_follow_button_position", Integer.valueOf(0)).intValue();
  }
  
  public static boolean ar()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_gift_wall_use_hippy", 1) == 1;
  }
  
  public static boolean as()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqcircle", "qqcircle_is_alpha_user", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean at()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_quality_sample_switch", 1) == 1;
  }
  
  public static String au()
  {
    SharedPreferences localSharedPreferences = QCircleSpUtil.a(true, true);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("qcircle_need_client_report_success_rate_cmd", "");
    }
    return "";
  }
  
  public static boolean av()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqcircle", "qqcircle_report_outbox_switch", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static String aw()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_home_guide_text", String.format("点击进入%s广场", new Object[] { bo() }));
  }
  
  public static String ax()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_home_guide_interval_hours", "0");
  }
  
  public static String ay()
  {
    String str = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_empty_comment_hint", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getQQCircleEmptyCommentHint:");
    localStringBuilder.append(str);
    QLog.i("QCircleConfigHelper", 1, localStringBuilder.toString());
    return str;
  }
  
  public static String az()
  {
    String str = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_gift_wall_url", "https://h5.qzone.qq.com/v2/wezone/pay?_wv=17301507&_wwv=1&type=gift");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getQQCircleGiftWallUrl:");
    localStringBuilder.append(str);
    QLog.i("QCircleConfigHelper", 1, localStringBuilder.toString());
    return str;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    QzoneConfig.getInstance().updateOneConfig(paramString1, paramString2, paramString3);
  }
  
  public static boolean b()
  {
    int i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_publish_save_grid_selected", 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQQCircleShowPublishSaveGridSelected:");
      localStringBuilder.append(i);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    return i == 1;
  }
  
  public static boolean b(boolean paramBoolean)
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool2 = false;
    int i = ((QzoneConfig)localObject).getConfig("qqcircle", "qqcircle_show_entrance_on_message_tab", 0);
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isQQCircleShowMessageEntrance:");
        ((StringBuilder)localObject).append(i);
        QLog.e("QCircleConfigHelper", 1, ((StringBuilder)localObject).toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (!a(paramBoolean)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String ba()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_pushed_client", "他还没有推荐过作品，去广场看看吧");
  }
  
  public static String bb()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_server_exception", "网络异常");
  }
  
  public static String bc()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_server_exception", "网络异常，下拉刷新重试");
  }
  
  public static String bd()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_img_server_exception", "https://downv6.qq.com/video_story/flashshow/empty_state_error_hint.png");
  }
  
  public static String be()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_empty_personal_feed_img", "https://downv6.qq.com/video_story/flashshow/empty_state_empty_hint.png");
  }
  
  public static String bf()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_private_personal_feed_img", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8811/empty_state/emptystate_img_authority.png");
  }
  
  public static boolean bg()
  {
    boolean bool1 = bl();
    boolean bool2 = false;
    if (!bool1)
    {
      QLog.i("QCircleConfigHelper", 2, "isNewLayerMode debug switch close");
      return false;
    }
    if (a(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())) {
      return bt();
    }
    String str1 = a("qqcircle", "qqcircle_main_view_open_float_view", "1");
    boolean bool3 = "1".equals(str1);
    String str2 = bm();
    boolean bool4 = String.valueOf(bn()).equals(str2);
    QLog.i("QCircleConfigHelper", 1, String.format("isNewLayerMode mainKey:%s, useKey:%s", new Object[] { str1, str2 }));
    bool1 = bool2;
    if (bool4)
    {
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean bh()
  {
    if (bi()) {
      return bg();
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a("qqcircle", "qqcircle_main_open_new_publish", Integer.valueOf(0)).intValue() == 1)
    {
      bool1 = bool2;
      if (bg()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean bi()
  {
    if (RFApplication.getApplication() != null)
    {
      SharedPreferences localSharedPreferences = RFApplication.getApplication().getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
      if (localSharedPreferences != null) {
        return localSharedPreferences.getBoolean("SP_KEY_OPEN_NEW_PUBLISH", false);
      }
    }
    return false;
  }
  
  public static boolean bj()
  {
    if (bk()) {
      return true;
    }
    return QzoneConfig.isDefaultWinkImageEditModeImage();
  }
  
  public static boolean bk()
  {
    return LocalMultiProcConfig.getBool("SP_KEY_OPEN_IMAGE_EDIT_MODE", false);
  }
  
  public static boolean bl()
  {
    if (RFApplication.getApplication() != null)
    {
      SharedPreferences localSharedPreferences = RFApplication.getApplication().getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
      if (localSharedPreferences != null) {
        return localSharedPreferences.getBoolean("SP_KEY_OPEN_NEW_LAYER", true);
      }
    }
    return false;
  }
  
  public static String bm()
  {
    if (bl())
    {
      QLog.i("QCircleConfigHelper", 2, "isNewLayerMode hiqct debug switch return layer mode 3");
      return String.valueOf(bn());
    }
    if (a(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()))
    {
      if (bt()) {
        return String.valueOf(bn());
      }
      return String.valueOf(1);
    }
    return a("qqcircle", "qqcircle_main_view_use_float_view", String.valueOf(bn()));
  }
  
  public static int bn()
  {
    return 3;
  }
  
  public static String bo()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_product_name", "小世界");
  }
  
  public static boolean bp()
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool = false;
    int i = ((QzoneConfig)localObject).getConfig("qqcircle", "qqcircle_show_entrance_on_drawer_tab", 0);
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isQQCircleShowDrawTabEntrance:");
        ((StringBuilder)localObject).append(i);
        QLog.e("QCircleConfigHelper", 1, ((StringBuilder)localObject).toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean bq()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_prefetch_feed_enable", 1) == 1;
  }
  
  public static long br()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_prefetch_feed_error_expired_interval", 1800);
  }
  
  public static boolean bs()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static boolean bt()
  {
    Boolean localBoolean = QCircleConfigCache.a().b();
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    boolean bool = a("qqcircle", "qqcircle_bottom_entrance_use_float_view", String.valueOf(3)).equals(String.valueOf(3));
    QCircleConfigCache.a().a(Boolean.valueOf(bool));
    return bool;
  }
  
  public static int c()
  {
    int i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_max_push_count", 10);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQQCircleMaxPushCount:");
      localStringBuilder.append(i);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public static boolean c(boolean paramBoolean)
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool2 = false;
    int i = ((QzoneConfig)localObject).getConfig("qqcircle", "qqcircle_show_entrance_on_recommend_tab", 0);
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isQQCircleShowLebaEntrance:");
      ((StringBuilder)localObject).append(i);
      QLog.e("QCircleConfigHelper", 1, ((StringBuilder)localObject).toString());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (!a(paramBoolean)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int d()
  {
    int i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_push_not_enough_value", 3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQQCircleMaxPushCount:");
      localStringBuilder.append(i);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public static boolean d(boolean paramBoolean)
  {
    return (c(paramBoolean)) && (e(paramBoolean));
  }
  
  public static String e()
  {
    String str = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_search_page_url", "https://h5.qzone.qq.com/v2/wezone/search?_wwv=8192&_wv=3&_proxy=1&show_right_cancel=1&move_web_view_top=1");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQQCircleSearchPageUrl:");
      localStringBuilder.append(str);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public static boolean e(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", "0");
    } else {
      str = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_entrance_enable", "0");
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQQCircleShowLebaBySwitchButton:");
      localStringBuilder.append(str);
      localStringBuilder.append(" isstudymode= ");
      localStringBuilder.append(paramBoolean);
      QLog.e("QCircleConfigHelper", 1, localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "1".equals(str);
  }
  
  public static int f()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static long g()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_report_interval", 10);
  }
  
  public static int h()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_report_buffer_length", 10);
  }
  
  public static long i()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_quality_report_interval", 60);
  }
  
  public static int j()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "quality_quality_report_buffer_length", 5);
  }
  
  public static int k()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_main_tab_tips_time", 2000);
  }
  
  public static long l()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_banner_interval", 10);
  }
  
  public static boolean m()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_folder_cache", 1) > 0;
  }
  
  public static int n()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_max_words_limit", 100);
  }
  
  public static int o()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_folder_cache_life_cycle", 180);
  }
  
  public static boolean p()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_transition_close_anim", 1) > 0;
  }
  
  public static boolean q()
  {
    boolean bool1 = ((INetworkUtilApi)QCircleRouteCacheManager.a().a(INetworkUtilApi.class)).isNetworkAvailable();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (((INetworkUtilApi)QCircleRouteCacheManager.a().a(INetworkUtilApi.class)).isWifi()) {
      return true;
    }
    bool1 = bool2;
    if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_should_auto_play_when_wwan", 1) == 1)
    {
      bool1 = ((INetworkUtilApi)QCircleRouteCacheManager.a().a(INetworkUtilApi.class)).is4G();
      boolean bool3 = ((INetworkUtilApi)QCircleRouteCacheManager.a().a(INetworkUtilApi.class)).is5G();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQQCircleAutoPlay is4GNetwork:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" | is5GNetwork: ");
      localStringBuilder.append(bool3);
      QLog.d("QCircleConfigHelper", 1, localStringBuilder.toString());
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String r()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_personal_data_edit_h5_url", "https://h5.qzone.qq.com/v2/wezone/addtag?_wv=3&_wwv=1&_proxy=1&addfrom=edit");
  }
  
  public static boolean s()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_barrage_enabled", 1) == 1;
  }
  
  public static boolean t()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_switch_play_video_in_works_tab", 1) == 1;
  }
  
  public static boolean u()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_verified_switch", 1) == 1;
  }
  
  public static boolean v()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_flutter_search", 1) == 1;
  }
  
  public static long w()
  {
    long l = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_qqcircle_jump_to_publish_delay_time", 2000);
    QLog.d("QCircleConfigHelper", 1, new Object[] { "getQQCircleJumpToNewPublishDelayTime... delayTime:", Long.valueOf(l) });
    return l;
  }
  
  public static String x()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_tag_medal_image_url_colour", "https://sola.gtimg.cn/aoi/sola/20200819105021_dQGv8tIe5a.png");
  }
  
  public static String y()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_achievement_icon_kol_default", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/865/profilepage_achievement/qcircle_icon_kol.png");
  }
  
  public static String z()
  {
    return QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_achievement_icon_kol_company", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/865/profilepage_achievement/qcircle_icon_kol_company.png");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.QCircleConfigHelper
 * JD-Core Version:    0.7.0.1
 */