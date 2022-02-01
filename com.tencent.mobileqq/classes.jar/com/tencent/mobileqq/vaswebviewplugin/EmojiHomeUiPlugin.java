package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IQQMessageFacadeProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EmojiHomeUiPlugin
  extends EmojiUiPlugin
{
  public static final String ACTION_OPEN_HOMEPAGE = "actOpenHomePage";
  public static final int HOMEPAGE_RDM_EVENT_AUTHENTICATION = 11201;
  public static final int HOMEPAGE_RDM_EVENT_BAD_URL = 11202;
  public static final int HOMEPAGE_RDM_EVENT_CONNECT = 11203;
  public static final int HOMEPAGE_RDM_EVENT_FAIL_GENERAL = 11200;
  public static final int HOMEPAGE_RDM_EVENT_FILE = 11205;
  public static final int HOMEPAGE_RDM_EVENT_FILE_NOT_FOUND = 11206;
  public static final int HOMEPAGE_RDM_EVENT_FINISH = 1001;
  public static final int HOMEPAGE_RDM_EVENT_HOST_LOOKUP = 11207;
  public static final int HOMEPAGE_RDM_EVENT_IO = 11208;
  public static final int HOMEPAGE_RDM_EVENT_MANY_REQUESTS = 11212;
  public static final int HOMEPAGE_RDM_EVENT_OPENNING = 1002;
  public static final int HOMEPAGE_RDM_EVENT_PROXY_AUTH = 11209;
  public static final int HOMEPAGE_RDM_EVENT_REDIRECT_LOOP = 11210;
  public static final int HOMEPAGE_RDM_EVENT_SSL_HANDSHAKE = 11204;
  public static final int HOMEPAGE_RDM_EVENT_TIMEOUT = 11211;
  public static final int HOMEPAGE_RDM_EVENT_UNKNOWN = 11213;
  public static final int HOMEPAGE_RDM_EVENT_UNSUP_AUTH = 11214;
  public static final int HOMEPAGE_RDM_EVENT_UNSUP_SCHEME = 11215;
  public static final String TAG = "Q.emoji.web.EmojiUiPlugin.EmojiHomeUiPlugin";
  
  public static QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return null;
    }
    return (QQAppInterface)localAppRuntime;
  }
  
  public static void openEmojiAuthorPage(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("selfuin", paramString1);
      localIntent.putExtra("reqType", 6);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("emojimall_src", paramInt);
      localIntent.putExtra("emojimall_detail_id", paramString2);
      localIntent.putExtra("emomall_new_time", i);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.b(paramActivity, null, 4L, localIntent, false, -1);
      if (paramInt == 3)
      {
        paramActivity.overridePendingTransition(2130772009, 0);
        return;
      }
      paramActivity.overridePendingTransition(2130771996, 0);
    }
  }
  
  public static void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt == 8) || (paramInt == 4)) && (paramActivity != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("selfuin", paramString1);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("reqType", 6);
      localIntent.putExtra("emojimall_src", paramInt);
      localIntent.putExtra("emojimall_detail_id", paramString2);
      localIntent.putExtra("emomall_new_time", i);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.b(paramActivity, null, 4L, localIntent, false, -1);
    }
  }
  
  public static void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return;
    }
    if (((paramInt == 8) || (paramInt == 4) || (paramInt == 12)) && (paramActivity != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      QQAppInterface localQQAppInterface = getApp();
      if (localQQAppInterface == null) {
        return;
      }
      realOpenEmojiDetailPage(paramActivity, paramString1, paramInt, paramString2, paramBoolean1, paramIntent, paramBoolean2, paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1), new Intent(paramActivity, QQBrowserActivity.class), localQQAppInterface.getMessageFacade().m(), localQQAppInterface.getMessageFacade().l());
    }
  }
  
  public static void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    openEmojiDetailPage(paramActivity, paramString1, paramInt, paramString2, paramBoolean1, null, paramBoolean2);
  }
  
  public static void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return;
    }
    if (((paramInt == 8) || (paramInt == 4) || (paramInt == 12)) && ((paramContext instanceof Activity)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = paramContext.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      int j = paramIEmoticonMainPanelApp.getMessageFacade().getCurrChatType();
      paramIEmoticonMainPanelApp = paramIEmoticonMainPanelApp.getMessageFacade().getCurrChatUin();
      realOpenEmojiDetailPage((Activity)paramContext, paramString1, paramInt, paramString2, paramBoolean1, paramIntent, paramBoolean2, i, localIntent, j, paramIEmoticonMainPanelApp);
    }
  }
  
  public static void openEmojiDetailPage2(Activity paramActivity, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2, String paramString3)
  {
    if (paramBoolean) {
      return;
    }
    if (((paramInt1 == 8) || (paramInt1 == 4)) && (paramActivity != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      String str = paramString3;
      if (paramString3 == null)
      {
        str = paramActivity.getIntent().getStringExtra("key_emojimall_detail_chat_uin");
        paramInt2 = paramActivity.getIntent().getIntExtra("key_emojimall_detail_chat_type", -1);
      }
      localIntent.putExtra("key_emojimall_detail_chat_type", paramInt2);
      localIntent.putExtra("key_emojimall_detail_chat_uin", str);
      localIntent.putExtra("selfuin", paramString1);
      localIntent.putExtra("reqType", 6);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("emojimall_src", paramInt1);
      localIntent.putExtra("emojimall_detail_id", paramString2);
      localIntent.putExtra("emojimall_qFace", paramBoolean);
      localIntent.putExtra("emomall_new_time", i);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("individuation_url_type", reportSourceTypeOfEmoji(paramInt1));
      VasWebviewUtil.b(paramActivity, null, 4L, localIntent, false, -1);
    }
  }
  
  public static void openEmojiHomePage(Activity paramActivity, String paramString, int paramInt)
  {
    openEmojiHomePage(paramActivity, paramString, paramInt, false, "");
  }
  
  public static void openEmojiHomePage(Activity paramActivity, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    openEmojiHomePage(paramActivity, paramString1, paramInt, paramBoolean, paramString2, false);
  }
  
  public static void openEmojiHomePage(Activity paramActivity, String paramString1, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      QQAppInterface localQQAppInterface = getApp();
      if (localQQAppInterface == null) {
        return;
      }
      openEmojiPage(paramActivity, paramString1, paramInt, paramBoolean1, paramString2, paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1), localQQAppInterface.getMessageFacade().m(), localQQAppInterface.getMessageFacade().l(), paramBoolean2);
    }
  }
  
  public static void openEmojiHomePage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    openEmojiHomePage(paramContext, paramIEmoticonMainPanelApp, paramString1, paramInt, paramBoolean, paramString2, false);
  }
  
  public static void openEmojiHomePage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      openEmojiPage(paramContext, paramString1, paramInt, paramBoolean1, paramString2, paramContext.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1), paramIEmoticonMainPanelApp.getMessageFacade().getCurrChatType(), paramIEmoticonMainPanelApp.getMessageFacade().getCurrChatUin(), paramBoolean2);
    }
  }
  
  public static void openEmojiHomePage2(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      int i = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("selfuin", paramString1);
      localIntent.putExtra("emojimall_src", paramInt1);
      localIntent.putExtra("emomall_new_time", i);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("key_emojimall_detail_chat_type", paramInt2);
      localIntent.putExtra("key_emojimall_detail_chat_uin", paramString2);
      localIntent.putExtra("portraitOnly", true);
      if ((paramInt1 != 7) && (paramInt1 != 3)) {
        localIntent.putExtra("hide_left_button", true);
      }
      if (paramInt1 == 1) {
        localIntent.putExtra("hide_left_button", false);
      }
      localIntent.putExtra("individuation_url_type", reportSourceTypeOfEmoji(paramInt1));
      if ((paramInt1 != 1) && (paramInt1 != 3))
      {
        VasWebviewUtil.b(paramActivity, null, 2L, localIntent, false, -1);
        return;
      }
      localIntent.putExtra("updateFlag", false);
      VasWebviewUtil.b(paramActivity, null, 2L, localIntent, true, 4001);
    }
  }
  
  private static void openEmojiPage(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean1, String paramString2, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("selfuin", paramString1);
    localIntent.putExtra("emojimall_src", paramInt1);
    localIntent.putExtra("emomall_new_time", paramInt2);
    localIntent.putExtra("has_red_dot", paramBoolean1);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("rec_id", paramString2);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("key_emojimall_detail_chat_type", paramInt3);
    localIntent.putExtra("key_emojimall_detail_chat_uin", paramString3);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("individuation_url_type", reportSourceTypeOfEmoji(paramInt1));
    if (paramBoolean2) {
      localIntent.putExtra("fragmentStyle", 4);
    }
    if ((paramInt1 != 7) && (paramInt1 != 3)) {
      localIntent.putExtra("hide_left_button", true);
    }
    if (paramInt1 == 1) {
      localIntent.putExtra("hide_left_button", false);
    }
    if (paramInt1 == 9) {
      localIntent.putExtra("hide_left_button", false);
    }
    if ((paramInt1 != 1) && (paramInt1 != 3))
    {
      VasWebviewUtil.b(paramContext, null, 2L, localIntent, false, -1);
    }
    else
    {
      localIntent.putExtra("updateFlag", paramBoolean1);
      VasWebviewUtil.b(paramContext, null, 2L, localIntent, true, 4001);
    }
    if ((paramInt1 == 1) && ((paramContext instanceof Activity))) {
      ((Activity)paramContext).overridePendingTransition(2130772014, 2130772092);
    }
  }
  
  public static void openEmosmActivity(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      int i = paramIEmoticonMainPanelApp.getMessageFacade().getCurrChatType();
      paramIEmoticonMainPanelApp = paramIEmoticonMainPanelApp.getMessageFacade().getCurrChatUin();
      paramContext = new ActivityURIRequest(paramContext, "/base/activity/EmosmActivity");
      paramContext.extra().putInt("key_emojimall_detail_chat_type", i);
      paramContext.extra().putString("key_emojimall_detail_chat_uin", paramIEmoticonMainPanelApp);
      paramContext.extra().putInt("emojimall_src", paramInt);
      QRoute.startUri(paramContext);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("open EmosmActivity failed because selfUin is empty.srcFromType=");
    paramContext.append(paramInt);
    paramContext.append(" ,hasRedDot=");
    paramContext.append(paramBoolean);
    paramContext.append(" ,currentId=");
    paramContext.append(paramString2);
    QLog.e("Q.emoji.web.EmojiUiPlugin.EmojiHomeUiPlugin", 1, paramContext.toString());
  }
  
  public static void openSmallEmojiListPage(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Object localObject = getApp();
      if (localObject == null) {
        return;
      }
      int j = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      int i = ((QQAppInterface)localObject).getMessageFacade().m();
      String str = ((QQAppInterface)localObject).getMessageFacade().l();
      localObject = str;
      if (str == null)
      {
        localObject = paramActivity.getIntent().getStringExtra("key_emojimall_detail_chat_uin");
        i = paramActivity.getIntent().getIntExtra("key_emojimall_detail_chat_type", -1);
      }
      localIntent.putExtra("key_emojimall_detail_chat_type", i);
      localIntent.putExtra("key_emojimall_detail_chat_uin", (String)localObject);
      localIntent.putExtra("selfuin", paramString1);
      localIntent.putExtra("reqType", 6);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("emojimall_src", paramInt);
      localIntent.putExtra("emomall_new_time", j);
      localIntent.putExtra("hide_more_button", false);
      localIntent.putExtra("emoji_ids", paramString2);
      VasWebviewUtil.b(paramActivity, null, 4L, localIntent, false, -1);
    }
  }
  
  private static void realOpenEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, Intent paramIntent1, boolean paramBoolean2, int paramInt2, Intent paramIntent2, int paramInt3, String paramString3)
  {
    if (paramString3 == null)
    {
      paramString3 = paramActivity.getIntent().getStringExtra("key_emojimall_detail_chat_uin");
      paramInt3 = paramActivity.getIntent().getIntExtra("key_emojimall_detail_chat_type", -1);
    }
    paramIntent2.putExtra("key_emojimall_detail_chat_type", paramInt3);
    paramIntent2.putExtra("key_emojimall_detail_chat_uin", paramString3);
    paramIntent2.putExtra("selfuin", paramString1);
    paramIntent2.putExtra("reqType", 6);
    paramIntent2.putExtra("show_right_close_button", false);
    paramIntent2.putExtra("emojimall_src", paramInt1);
    paramIntent2.putExtra("emojimall_detail_id", paramString2);
    paramIntent2.putExtra("emojimall_qFace", paramBoolean1);
    paramIntent2.putExtra("emomall_new_time", paramInt2);
    paramIntent2.putExtra("hide_more_button", false);
    paramIntent2.putExtra("is_small_emoji", paramBoolean2);
    if (paramIntent1 != null)
    {
      paramIntent2.putExtras(paramIntent1);
      paramIntent2.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", paramIntent1.getBooleanExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", false));
    }
    if (paramInt1 == 8) {
      paramInt1 = 40311;
    } else {
      paramInt1 = 40313;
    }
    paramIntent2.putExtra("individuation_url_type", paramInt1);
    VasWebviewUtil.b(paramActivity, null, 4L, paramIntent2, false, -1);
  }
  
  public static int reportSourceTypeOfEmoji(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 6)
      {
        if (paramInt != 3) {
          if (paramInt == 4) {}
        }
        switch (paramInt)
        {
        default: 
          return 40300;
        case 10: 
          return 40306;
        case 8: 
          return 40311;
          return 40313;
          return 40100;
        }
      }
      return 40312;
    }
    return 40310;
  }
  
  public static void statisticEmojiHomePageInfo(Context paramContext, String paramString, Intent paramIntent)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      HashMap localHashMap = new HashMap();
      long l1 = paramIntent.getExtras().getLong("openToOncreateGap", -1L);
      long l2 = paramIntent.getExtras().getLong("openTogetKeyTimeGap", -1L);
      long l3 = paramIntent.getExtras().getLong("openToFinishOrErrorGap", -1L);
      Object localObject1 = paramIntent.getExtras();
      boolean bool1 = false;
      boolean bool2 = ((Bundle)localObject1).getBoolean("bNeedGetKey", false);
      int j = paramIntent.getExtras().getInt("processStep", 1);
      Object localObject2 = new StringBuilder();
      localObject1 = "";
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(l1);
      localHashMap.put("openToOncreateGap", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(bool2);
      localHashMap.put("bNeedGetKey", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(l2);
      localHashMap.put("openTogetKeyTimeGap", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(l3);
      localHashMap.put("openToFinishOrErrorGap", ((StringBuilder)localObject2).toString());
      int i;
      if (j == 3)
      {
        i = paramIntent.getExtras().getInt("failcode", 0);
        localObject2 = paramIntent.getExtras().getString("errordescription");
        String str = paramIntent.getExtras().getString("errorUrl");
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        if (str != null) {
          localObject1 = str;
        }
        localHashMap.put("errordescription", paramIntent);
        localHashMap.put("errorUrl", localObject1);
        if (i == -4) {
          i = 11201;
        } else if (i == -12) {
          i = 11202;
        } else if (i == -6) {
          i = 11203;
        } else if (i == -11) {
          i = 11204;
        } else if (i == -13) {
          i = 11205;
        } else if (i == -14) {
          i = 11206;
        } else if (i == -2) {
          i = 11207;
        } else if (i == -7) {
          i = 11208;
        } else if (i == -5) {
          i = 11209;
        } else if (i == -9) {
          i = 11210;
        } else if (i == -8) {
          i = 11211;
        } else if (i == -15) {
          i = 11212;
        } else if (i == -1) {
          i = 11213;
        } else if (i == -3) {
          i = 11214;
        } else if (i == -10) {
          i = 11215;
        } else {
          i = 11200;
        }
        localHashMap.put("param_FailCode", Integer.toString(i));
        localObject2 = paramIntent;
        paramIntent = (Intent)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        paramIntent = "";
        i = 11200;
        bool1 = true;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("statistic:openToOncreateGap:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append("openTogetKeyTimeGap:");
        ((StringBuilder)localObject2).append(l2);
        ((StringBuilder)localObject2).append("bNeedGetKey:");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append("openToFinishOrErrorGap:");
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append("processStep:");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("isSuccess:");
        ((StringBuilder)localObject2).append(bool1);
        ((StringBuilder)localObject2).append("errordescription:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("errorUrl:");
        ((StringBuilder)localObject2).append(paramIntent);
        ((StringBuilder)localObject2).append("resultCode:");
        ((StringBuilder)localObject2).append(i);
        QLog.i("Q.emoji.web.EmojiUiPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actOpenHomePage", bool1, 0L, 0L, localHashMap, "");
    }
  }
  
  public void OnActivityCreate()
  {
    this.mActivityType = 1;
    super.OnActivityCreate();
    if (!checkOncreateParam(getInfoIntent())) {
      this.activity.finish();
    }
  }
  
  public void doAfterFinish()
  {
    if (this.mSrcFromType == 3)
    {
      this.activity.overridePendingTransition(0, 2130772006);
      return;
    }
    this.activity.overridePendingTransition(0, 2130771995);
  }
  
  public void doBeforeFinish()
  {
    if ((this.mSrcFromType == 1) || (this.mSrcFromType == 3) || (this.mSrcFromType == 6) || (this.mSrcFromType == 9))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("openToOncreateGap", this.openToOncreateGap);
      localIntent.putExtra("openTogetKeyTimeGap", this.openTogetKeyTimeGap);
      localIntent.putExtra("openToFinishOrErrorGap", this.openToFinishOrErrorGap);
      localIntent.putExtra("bNeedGetKey", this.bNeedGetKey);
      localIntent.putExtra("processStep", this.processStep);
      localIntent.putExtra("failcode", this.failcode);
      localIntent.putExtra("errordescription", this.errordescription);
      localIntent.putExtra("errorUrl", this.errorUrl);
      this.activity.setResult(-1, localIntent);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 3L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin
 * JD-Core Version:    0.7.0.1
 */