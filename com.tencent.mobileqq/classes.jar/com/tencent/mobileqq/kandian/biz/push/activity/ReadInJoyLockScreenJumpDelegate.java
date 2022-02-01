package com.tencent.mobileqq.kandian.biz.push.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInjoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadinjoyJumpUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.notification.modularize.PushUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyLockScreenJumpDelegate
  extends IphoneTitleBarFragment
{
  private static int a(@NonNull Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("daily_lock_screen_param", false)) {
      return DailyModeConfigHandler.b();
    }
    return 0;
  }
  
  private static int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("jump_content_page", 0);
  }
  
  @NonNull
  public static Intent a(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 == null)
    {
      QLog.i("ReadInJoyLockScreenJump", 1, "generateIntent: app is null");
      return b(paramContext, paramInt1, paramInt2);
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    String str = a(localKandianMergeManager.c());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("generateIntent: extraInfo=");
    ((StringBuilder)localObject2).append(str);
    Log.i("ReadInJoyLockScreenJump", ((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty(str))
    {
      QLog.i("ReadInJoyLockScreenJump", 1, "generateIntent: extraInfo is null");
      return b(paramContext, paramInt1, paramInt2);
    }
    try
    {
      localObject2 = new JSONObject(str);
      int i = 0;
      if (((JSONObject)localObject2).optInt("jump_daily_channel", 0) == 1) {
        i = 1;
      }
      if (i != 0)
      {
        QLog.i("ReadInJoyLockScreenJump", 1, "getLockScreenJumpIntent: routed to daily fragment");
        return a(paramContext, paramInt1, ((KandianDailyManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).b());
      }
      i = c((JSONObject)localObject2);
      int j = b((JSONObject)localObject2);
      if ((i != 0) && (j != 0))
      {
        QLog.i("ReadInJoyLockScreenJump", 1, "generateIntent: jump to LockScreenDelegate");
        localObject1 = a(paramContext, str, paramInt1, paramInt2);
        ((Intent)localObject1).putExtra("daily_lock_screen_report_red_info", localKandianMergeManager.b());
        return localObject1;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyLockScreenJump", 1, "getLockScreenJumpIntent: ", localJSONException);
    }
    return b(paramContext, paramInt1, paramInt2);
  }
  
  public static Intent a(Context paramContext, int paramInt, KandianRedDotInfo paramKandianRedDotInfo)
  {
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", ReadInJoyDailyFragment.class.getName());
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    localIntent.setFlags(603979776);
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("daily_lock_screen_flag", true);
    localIntent.putExtra("daily_lock_screen_param", true);
    if (paramKandianRedDotInfo == null)
    {
      QLog.e("ReadInJoyLockScreenJump", 1, "getJumpDailyFragmentIntent redDotInfo is null !");
      return localIntent;
    }
    if ((TextUtils.isEmpty(paramKandianRedDotInfo.extInfo)) && (paramKandianRedDotInfo.hasArticleID()))
    {
      QLog.e("ReadInJoyLockScreenJump", 1, "getJumpDailyFragmentIntent redDotInfo.extInfo is empty !");
      localIntent.putExtra("kandian_feeds_red_pnt_info", paramKandianRedDotInfo);
      localIntent.putExtra("daily_lock_screen_report_red_info", paramKandianRedDotInfo);
      return localIntent;
    }
    localIntent.putExtra("return_scene", 1);
    try
    {
      paramContext = new JSONObject(paramKandianRedDotInfo.extInfo);
      localIntent.putExtra("daily_lock_screen_report_red_info", paramKandianRedDotInfo);
      if (a(paramContext))
      {
        a(paramContext, paramKandianRedDotInfo, localIntent);
        a(paramContext, localIntent);
        return localIntent;
      }
      if (a(paramContext) == 1)
      {
        b(paramContext, paramKandianRedDotInfo, localIntent);
        return localIntent;
      }
    }
    catch (JSONException paramContext)
    {
      QLog.e("ReadInJoyLockScreenJump", 1, "getJumpDailyFragmentIntent parse json error: ", paramContext);
    }
    return localIntent;
  }
  
  private static Intent a(@NonNull Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (ReadInJoyHelper.m())
    {
      paramContext = new Intent(paramContext, SplashActivity.class);
      paramContext.putExtra("fragment_id", 1);
      paramContext.putExtra("launch_from", 9);
      paramContext.putExtra("tab_index", FrameControllerUtil.h);
      paramContext.putExtra("open_kandian_tab_fragment", true);
      paramContext.setFlags(335544320);
      paramContext.putExtra("arg_channel_cover_id", paramInt2);
      paramContext.putExtra("kan_dian_lock_screen_flag", true);
      paramContext.putExtra("kan_dian_lock_screen_param", true);
      paramContext.putExtra("return_scene", 2);
      ReadinjoyJumpUtils.a(paramContext);
      try
      {
        a(new JSONObject(paramString), paramContext);
      }
      catch (JSONException paramString)
      {
        QLog.e("ReadInJoyLockScreenJump", 1, "generateJumpKanDianIntent launch RealKanDianTab: exception thrown", paramString);
      }
      paramString = new StringBuilder();
      paramString.append("generateJumpKanDianIntent launch RealKanDianTab, from:");
      paramString.append(paramInt1);
      QLog.d("ReadInJoyLockScreenJump", 1, paramString.toString());
      return paramContext;
    }
    paramContext = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    paramContext.putExtra("readinjoy_show_tab", 0);
    paramContext.putExtra("tab_tab_index", 0);
    paramContext.putExtra("kan_dian_lock_screen_flag", true);
    paramContext.putExtra("launch_from", 9);
    paramContext.putExtra("kan_dian_lock_screen_flag", true);
    paramContext.putExtra("kan_dian_lock_screen_param", true);
    ReadinjoyJumpUtils.a(paramContext);
    try
    {
      a(new JSONObject(paramString), paramContext);
    }
    catch (JSONException paramString)
    {
      QLog.e("ReadInJoyLockScreenJump", 1, "generateJumpKanDianIntent launch NewFeedsActivity: exception thrown", paramString);
    }
    paramString = new StringBuilder();
    paramString.append("generateJumpKanDianIntent launch NewFeedsActivity, from:");
    paramString.append(paramInt1);
    QLog.d("ReadInJoyLockScreenJump", 1, paramString.toString());
    return paramContext;
  }
  
  private static String a(@Nullable MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (paramMessageRecord.structingMsg != null) {
        return paramMessageRecord.structingMsg.mExtraData;
      }
    }
    return null;
  }
  
  private static String a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("channel_id", String.valueOf(0));
  }
  
  public static void a(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    RIJLockScreenPushReport.a((KandianRedDotInfo)paramIntent.getSerializableExtra("daily_lock_screen_report_red_info"));
    if (paramIntent.getBooleanExtra("is_from_push_component", false)) {
      PushUtil.a(paramIntent.getIntExtra("push_main_business_id", 0), paramIntent.getIntExtra("push_sub_business_id", 0), paramIntent.getIntExtra("push_id", 0), paramIntent.getStringExtra("push_trigger_info"));
    }
    int i = paramIntent.getIntExtra("jumpType", 0);
    if (a(paramActivity, paramIntent, i)) {
      return;
    }
    if (i != 2)
    {
      if (i != 3)
      {
        QLog.i("ReadInJoyLockScreenJump", 1, "handleLockScreenJumpType do nothing!");
        return;
      }
      c(paramActivity, paramIntent);
      return;
    }
    b(paramActivity, paramIntent);
  }
  
  private static void a(@NonNull Activity paramActivity, @NonNull Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("pushRowKey");
    if (TextUtils.isEmpty(str))
    {
      QLog.d("ReadInJoyLockScreenJump", 1, "lockScreenJumpFloatingWindow: open native article detail rowKey is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("floating_window_rowkey", paramIntent.getStringExtra("pushRowKey"));
    localBundle.putString("float_layer_topic_id", paramIntent.getStringExtra("topicId"));
    localBundle.putString("float_layer_article_url", paramIntent.getStringExtra("articleUrl"));
    a(paramIntent, localBundle);
    localBundle.putInt("RETURN_SCENE", paramIntent.getIntExtra("return_scene", 0));
    localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", a(paramIntent));
    if ((paramInt != 1) || (ReadInjoyFloatingWindowHelper.a(localBundle))) {
      KandianDailyReportUtils.a(32);
    }
    ReadInjoyFloatingWindowHelper.a(paramActivity, 3, paramInt, localBundle, a(paramIntent));
    paramActivity = new StringBuilder();
    paramActivity.append("jumpFloatingWindow: rowKey:");
    paramActivity.append(str);
    QLog.d("ReadInJoyLockScreenJump", 1, paramActivity.toString());
  }
  
  private static void a(@NonNull Intent paramIntent, @NonNull Bundle paramBundle)
  {
    paramBundle.putBoolean("daily_lock_screen_param", paramIntent.getBooleanExtra("daily_lock_screen_param", false));
    paramBundle.putBoolean("kan_dian_lock_screen_param", paramIntent.getBooleanExtra("kan_dian_lock_screen_param", false));
    paramBundle.putInt("daily_lock_screen_article_report_jump_type", paramIntent.getIntExtra("jumpType", 0));
  }
  
  private static void a(@NonNull JSONObject paramJSONObject, @NonNull Intent paramIntent)
  {
    paramIntent.putExtra("jumpType", b(paramJSONObject));
    paramIntent.putExtra("contentType", c(paramJSONObject));
    paramIntent.putExtra("pushRowKey", b(paramJSONObject));
    paramIntent.putExtra("articleUrl", c(paramJSONObject));
    paramIntent.putExtra("topicId", d(paramJSONObject));
    paramIntent.putExtra("push_json", paramJSONObject.toString());
  }
  
  private static void a(@NonNull JSONObject paramJSONObject, @NonNull KandianRedDotInfo paramKandianRedDotInfo, @NonNull Intent paramIntent)
  {
    int i = b(paramJSONObject);
    if (((i == 1) || (i == 0)) && (paramKandianRedDotInfo.hasArticleID())) {
      paramIntent.putExtra("kandian_feeds_red_pnt_info", paramKandianRedDotInfo);
    }
    if ((paramKandianRedDotInfo.hasArticleID()) && (paramKandianRedDotInfo.articleIDList.size() > 0)) {
      paramIntent.putExtra("daily_lock_screen_article_report_article_id", (Serializable)paramKandianRedDotInfo.articleIDList.get(0));
    }
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleLockScreenJumpViola: ");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyLockScreenJump", 1, localStringBuilder.toString());
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("push_json");
    } else {
      paramIntent = null;
    }
    if (ViolaAccessHelper.a(paramInt, paramActivity, paramIntent, false))
    {
      QLog.d("ReadInJoyLockScreenJump", 1, "jump viola url success");
      return true;
    }
    QLog.d("ReadInJoyLockScreenJump", 1, "jump viola url fail");
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needForceNotification(paramMessageRecord))
    {
      paramMessageRecord = a(paramMessageRecord);
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord);
          int i = c(paramMessageRecord);
          int j = b(paramMessageRecord);
          if (j == 3) {
            return GesturePWDUtils.isAppOnForeground(BaseApplicationImpl.getContext()) ^ true;
          }
          if (j == 2)
          {
            if (i == 2)
            {
              boolean bool = GesturePWDUtils.isAppOnForeground(BaseApplicationImpl.getContext());
              if (!bool) {
                return true;
              }
            }
            return false;
          }
        }
        catch (JSONException paramMessageRecord)
        {
          QLog.e("ReadInJoyLockScreenJump", 1, "shouldBlockLockScreenRedDot: ", paramMessageRecord);
        }
      }
    }
    return false;
  }
  
  private static boolean a(@NonNull JSONObject paramJSONObject)
  {
    int i = b(paramJSONObject);
    int j = c(paramJSONObject);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1) {
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 3) {
          return false;
        }
      }
      else
      {
        bool1 = bool2;
        if (j != 1)
        {
          if (j == 2) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private static int b(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("jumpType", 0);
  }
  
  @NonNull
  private static Intent b(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("fragment_id", 1);
    paramContext.putExtra("launch_from", paramInt1);
    paramContext.putExtra("tab_index", FrameControllerUtil.h);
    paramContext.putExtra("open_kandian_tab_fragment", true);
    paramContext.putExtra("arg_channel_cover_id", paramInt2);
    paramContext.setFlags(335544320);
    ReadinjoyJumpUtils.a(paramContext);
    return paramContext;
  }
  
  private static String b(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("push_rowkey", null);
  }
  
  private static void b(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("contentType", 0);
    StringBuilder localStringBuilder;
    if (i == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doJumpAction: openVideoFeeds, rowKey=");
      localStringBuilder.append(paramIntent.getStringExtra("pushRowKey"));
      QLog.i("ReadInJoyLockScreenJump", 1, localStringBuilder.toString());
      e(paramActivity, paramIntent);
      return;
    }
    if (i == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doJumpAction: openVideoFeeds, rowKey=");
      localStringBuilder.append(paramIntent.getStringExtra("pushRowKey"));
      QLog.i("ReadInJoyLockScreenJump", 1, localStringBuilder.toString());
      d(paramActivity, paramIntent);
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("doJumpAction: contentType: ");
    paramActivity.append(i);
    QLog.d("ReadInJoyLockScreenJump", 1, paramActivity.toString());
  }
  
  private static void b(@NonNull JSONObject paramJSONObject, @NonNull KandianRedDotInfo paramKandianRedDotInfo, @NonNull Intent paramIntent)
  {
    int i = Integer.parseInt(a(paramJSONObject));
    paramIntent.putExtra("arg_channel_cover_id", i);
    if (paramKandianRedDotInfo.hasArticleID())
    {
      paramIntent.putExtra("kandian_feeds_red_pnt_info", paramKandianRedDotInfo);
      if (paramKandianRedDotInfo.articleIDList.size() > 0)
      {
        paramIntent.putExtra("jump_article_param_ids", (Serializable)paramKandianRedDotInfo.articleIDList.get(0));
        paramIntent.putExtra("jump_activity_launch_from", 0);
        paramIntent.putExtra("jump_activity_launch_channel_id", i);
      }
    }
  }
  
  private static int c(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("contentType", 0);
  }
  
  private static String c(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("articleUrl", null);
  }
  
  private static void c(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("contentType", 0);
    int i = 4;
    if (j == 1)
    {
      i = 1;
    }
    else if (j == 2)
    {
      i = 2;
    }
    else if (j == 3)
    {
      i = 3;
    }
    else if (j != 4)
    {
      QLog.d("ReadInJoyLockScreenJump", 1, "handle lock screen floating layer unknown contentType!");
      i = -1;
    }
    a(paramActivity, paramIntent, i);
    paramActivity = new StringBuilder();
    paramActivity.append("handle lock screen floating window   businessType=");
    paramActivity.append(i);
    QLog.d("ReadInJoyLockScreenJump", 1, paramActivity.toString());
  }
  
  private static String d(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("topicId", null);
  }
  
  private static void d(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("pushRowKey");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("VIDEO_FEEDS_ANIM_ENABLE", false);
    localBundle.putInt("RETURN_SCENE", paramIntent.getIntExtra("return_scene", 0));
    localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", a(paramIntent));
    VideoFeedsHelper.a(paramActivity, localBundle, paramIntent.getStringExtra("pushRowKey"), 27);
    paramActivity = new StringBuilder();
    paramActivity.append("lockScreenJumpVideoFeedsPlayActivity: rowKey:");
    paramActivity.append(str);
    QLog.d("ReadInJoyLockScreenJump", 1, paramActivity.toString());
  }
  
  private static void e(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("pushRowKey");
    if (TextUtils.isEmpty(str1))
    {
      QLog.d("ReadInJoyLockScreenJump", 1, "jumpFastWebActivity: open native article detail rowKey is null");
      return;
    }
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent(paramActivity, FastWebActivity.class);
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    localBaseArticleInfo.innerUniqueID = str1;
    localBaseArticleInfo.mChannelID = a(paramIntent);
    String str2 = paramIntent.getStringExtra("articleUrl");
    if (!TextUtils.isEmpty(str2)) {
      localBaseArticleInfo.mArticleContentUrl = str2;
    }
    localIntent.putExtra("fast_web_article_info", localBaseArticleInfo);
    a(paramIntent, localBundle);
    localIntent.putExtras(localBundle);
    paramActivity.startActivity(localIntent);
    paramActivity = new StringBuilder();
    paramActivity.append("lockScreenJumpFastWebActivity: rowKey:");
    paramActivity.append(str1);
    paramActivity.append(" articleUrl: ");
    paramActivity.append(str2);
    QLog.d("ReadInJoyLockScreenJump", 1, paramActivity.toString());
  }
  
  protected int getContentLayoutId()
  {
    return 2131560230;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    RIJDtReportHelper.a.a(getBaseActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyLockScreenJumpDelegate
 * JD-Core Version:    0.7.0.1
 */