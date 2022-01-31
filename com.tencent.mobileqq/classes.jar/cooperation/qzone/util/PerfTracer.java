package cooperation.qzone.util;

import android.content.Intent;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class PerfTracer
{
  public static final String APP_ONCREATE = "App_onCreate";
  public static final String BASEFEED_SUPER_ONCREATE = "BaseFeed_super_onCreate";
  public static final String CLICK2LOADACTIVITYCREATE = "click2LoadActivityCreate";
  public static final String CLICK2LOADCOMPLETED = "click2LoadCompleted";
  public static final String ClICK2WINDOWSHOW = "click2WindowShow";
  public static final String DETAIL_INIT = "Detail_init";
  public static final String DETAIL_INITEMOVIEW = "Detail_initEmoView";
  public static final String DETAIL_ONCREATE = "Detail_onCreate";
  public static final String DETAIL_ONRESUME = "Detail_onResume";
  public static final String DETAIL_RENDER = "Detail_render";
  public static final String FRENIDFEED_GET_VIEW = "Friendfeed_getview";
  public static final String FRIENDFEED_DELAYSHOW = "FriendFeed_delayShow";
  public static final String FRIENDFEED_FRAGMENT_ONCREATE = "FriendFeed_fragement_onActivityCreated";
  public static final String FRIENDFEED_INITDATA = "FriendFeed_initData";
  public static final String FRIENDFEED_INITFAKEUI = "FriendFeed_initFakeUI";
  public static final String FRIENDFEED_INITHEADER = "FriendFeed_initHeader";
  public static final String FRIENDFEED_INITHEADER_COVER = "FriendFeed_initHeader_Cover";
  public static final String FRIENDFEED_INITUI = "FriendFeed_initUI";
  public static final String FRIENDFEED_ONCREATE = "FriendFeed_onCreate";
  public static final String FRIENDFEED_ONCREATE2WINDOWFOCUS = "FriendFeed_onCreate2WindowFocus";
  public static final String FRIENDFEED_ONRESUME = "FriendFeed_onResume";
  public static final String FRIENDFEED_PARSEINTENT = "FriendFeed_parseIntent";
  public static final String FRIENDFEED_PHOTOGUIDEBANNERSHOW = "FriendFeed_photoGuidebannerShow";
  public static final String FRIENDFEED_SUPER_ONCREATE = "FriendFeed_Super_onCreate";
  public static final String MOODLIST_INITDATA = "MoodList_initData";
  public static final String MOODLIST_INITUI = "MoodList_initUI";
  public static final String MOODLIST_ONCREATE = "MoodList_onCreate";
  public static final String MYFEED_INITDATA = "MyFeed_initData";
  public static final String MYFEED_INITUI = "MyFeed_initUI";
  public static final String MYFEED_ONCREATE = "MyFeed_onCreate";
  public static final String MYFEED_ONRESUME = "MyFeed_onResume";
  public static final String PARAM_CLICK_TIME = "click_time";
  public static final String PARAM_STARTUP_SCENEID = "startup_sceneid";
  public static final String PHOTOWALL_INITDATA = "PhotoWall_initData";
  public static final String PHOTOWALL_INITUI = "PhotoWall_initUI";
  public static final String PHOTOWALL_ONCREATE = "PhotoWall_onCreate";
  public static final String PHOTOWALL_ONRESUME = "PhotoWall_onResume";
  public static final String PRELOAD_ADV_FEED_VIEW = "Prload_advFeedView";
  public static final String PRELOAD_AVATAR = "Preload_Avatar";
  public static final String PRELOAD_CONTENT_VIEW = "Preload_contentView";
  public static final String PRELOAD_COVER = "Preload_Cover";
  public static final String PRELOAD_FEED_VIEW = "Preload_Feed_View";
  public static final String PRELOAD_FRIENDFEED_DATA = "Preload_FriendFeedData";
  public static final String PRELOAD_HEAD_VIEW = "Preload_headView";
  public static final String PRELOAD_LOAD_FRIENDFEED_CLASS = "Preload_New_FriendFeed";
  public static final String PRELOAD_LOAD_USERHOME_CLASS = "Preload_Load_UserHome_Class";
  public static final String PRELOAD_NICK_NAME = "Preload_Nick_Name";
  public static final String PRELOAD_QUNFEED_DATA = "Preload_QunFeedData";
  public static final String PRELOAD_USERHOME_LAYOUT = "Preload_UserHomeLayout";
  public static final String PUBLISHMOOD_INITDATA = "PublishMood_initData";
  public static final String PUBLISHMOOD_INITUI = "PublishMood_initUI";
  public static final String PUBLISHMOOD_ONCREATE = "PublishMood_onCreate";
  public static final String PUBLISHMOOD_ONRESUME = "PublishMood_onResume";
  public static final String PUBLISHMOOD_STATE_INIT = "PublishMood_state_init";
  public static final String QUNALBUM_INITDATA = "QunAlbum_initData";
  public static final String QUNALBUM_INITUI = "QunAlbum_initUI";
  public static final String QUNALBUM_ONCREATE = "QunAlbum_onCreate";
  public static final String QUNALBUM_ONRESUME = "QunAlbum_onResume";
  public static final String QUNALBUM_PARSEINTENT = "QunAlbum_parseIntent";
  public static final String QUNALBUM_STATE_INIT = "QunAlbum_state_init";
  public static final String QUNFEED_INITDATA = "QunFeed_initData";
  public static final String QUNFEED_INITUI = "QunFeed_initUI";
  public static final String QUNFEED_ONCREATE = "QunFeed_onCreate";
  public static final String QUNFEED_ONRESUME = "QunFeed_onResume";
  public static final String QUNFEED_PARSEINTENT = "QunFeed_parseIntent";
  public static final String QZONEALBUM_INITDATA = "QzoneAlbum_initData";
  public static final String QZONEALBUM_INITUI = "QzoneAlbum_initUI";
  public static final String QZONEALBUM_ONCREATE = "QzoneAlbum_onCreate";
  public static final String QZONEALBUM_ONRESUME = "QzoneAlbum_onResume";
  public static final String QZONEALBUM_PARSEINTENT = "QzoneAlbum_parseIntent";
  public static final String REACT_ONCREATE = "React_onCreate";
  public static final String RUNTIME_BUSINESS_ONLOGIN = "Runtime_Business_onLogin";
  public static final String RUNTIME_FIRST_INIT = "Runtime_first_init";
  public static final String RUNTIME_LOAD_LIVE_MAIN_RUNTIME = "Runtime_load_live_main_runtime";
  public static final String RUNTIME_LOAD_MAIN_RUNTIME = "Runtime_load_main_runtime";
  public static final String RUNTIME_LOAD_RUNTIME = "Runtime_load_runtime";
  public static final String RUNTIME_ONCREATE = "Runtime_onCreate";
  public static final String RUNTIME_SUPER_ONCREATE = "Runtime_super_onCreate";
  public static final String RUNTIME_VIDEO_INIT = "Runtime_Video_Init";
  public static final int STARTUP_SCENEID_ALBUM = 3;
  public static final int STARTUP_SCENEID_DETAIL = 4;
  public static final int STARTUP_SCENEID_FRIEND_FEED = 1;
  public static final int STARTUP_SCENEID_PUBLISHMOOD = 5;
  public static final int STARTUP_SCENEID_UPLOADPHOTO = 6;
  public static final int STARTUP_SCENEID_USERHOME = 2;
  private static final String TAG = "Perf.Qzone";
  public static final boolean TRACE = false;
  public static final String UPLOADPHOTO_INITDATA = "UploadPhoto_initData";
  public static final String UPLOADPHOTO_INITEMOVIEW = "UploadPhoto_initEmoView";
  public static final String UPLOADPHOTO_INITUI = "UploadPhoto_initUI";
  public static final String UPLOADPHOTO_ONCREATE = "UploadPhoto_onCreate";
  public static final String UPLOADPHOTO_ONRESUME = "UploadPhoto_onResume";
  public static final String UPLOADPHOTO_STATE_INIT = "UploadPhoto_state_init";
  public static final String USERHOME_HEADRESUME = "UserHome_Header_Resume";
  public static final String USERHOME_INITDATA = "UserHome_initData";
  public static final String USERHOME_INITHEADER = "UserHome_initHeader";
  public static final String USERHOME_INITUI = "UserHome_initUI";
  public static final String USERHOME_ONCREATE = "UserHome_onCreate";
  public static final String USERHOME_ONRESUME = "UserHome_onResume";
  public static final String USERHOME_PARSEINTENT = "UserHome_parseIntent";
  public static final String USERHOME_PERFORMREPORTRESUME = "UserHome_PerformanceReport_Resume";
  public static final String VIDEO_COMPONENT_ONCREATE = "Video_component_onCreate";
  public static final String VIDEO_COMPONENT_PRE_LAUNCH = "Video_component_pre_launch";
  public static final ConcurrentHashMap sLogs = new ConcurrentHashMap(new HashMap(8));
  
  public static void trace(String paramString1, String paramString2)
  {
    System.currentTimeMillis();
    TimeCostTrace.a("qzone_launch").b(paramString1);
    TimeCostTrace.a("qzone_launch").a(paramString2);
  }
  
  public static void traceClick2Activity(Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      return;
      l = paramIntent.getLongExtra("click_time", 0L);
    } while (l <= 0L);
    boolean bool = paramIntent.getBooleanExtra("QZoneExtra.Plugin.isloading", false);
    int i = paramIntent.getIntExtra("startup_sceneid", -1);
    TimeCostTrace.a("qzone_launch").a(l, i, bool);
    TimeCostTrace.a("qzone_launch").a("click2LoadActivityCreate", l);
    TimeCostTrace.a("qzone_launch").a("click2LoadCompleted", l);
    TimeCostTrace.a("qzone_launch").a("click2WindowShow", l);
    traceEnd("click2LoadActivityCreate");
  }
  
  public static void traceClick2Completed(PerfTracer.PerfTimeReport paramPerfTimeReport)
  {
    traceEnd("click2LoadCompleted");
    TimeCostTrace localTimeCostTrace = TimeCostTrace.a("qzone_launch");
    if (localTimeCostTrace == null) {
      return;
    }
    if ((localTimeCostTrace.a() > 0L) && (paramPerfTimeReport != null))
    {
      paramPerfTimeReport.reportPerfTime(localTimeCostTrace);
      return;
    }
    localTimeCostTrace.b();
  }
  
  public static void traceClick2Window()
  {
    traceEnd("click2WindowShow");
  }
  
  public static void traceEnd(String paramString)
  {
    trace(paramString, null);
  }
  
  public static void traceStart(String paramString)
  {
    trace(null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.util.PerfTracer
 * JD-Core Version:    0.7.0.1
 */