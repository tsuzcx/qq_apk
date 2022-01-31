package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import azmz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class EmojiHomeUiPlugin
  extends EmojiUiPlugin
{
  public static final String ACTION_OPEN_HOMEPAGE = "actOpenHomePage";
  public static final String EXTRA_KEY_IS_KANDIAN_EMOTICON = "EXTRA_KEY_IS_KANDIAN_EMOTICON";
  public static final String EXTRA_KEY_IS_SMALL_EMOTICON = "EXTRA_KEY_IS_SMALL_EMOTICON";
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
  
  public static void openEmojiAuthorPage(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
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
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 4L, localIntent, false, -1);
    if (paramInt == 3)
    {
      paramActivity.overridePendingTransition(2130771992, 0);
      return;
    }
    paramActivity.overridePendingTransition(2130771979, 0);
  }
  
  public static void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 8) && (paramInt != 4)) || (paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
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
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 4L, localIntent, false, -1);
  }
  
  public static void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    while (((paramInt != 8) && (paramInt != 4) && (paramInt != 12)) || (paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    int j = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    int i = ((BaseActivity)paramActivity).app.a().a();
    String str2 = ((BaseActivity)paramActivity).app.a().a();
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramActivity.getIntent().getStringExtra("key_emojimall_detail_chat_uin");
      i = paramActivity.getIntent().getIntExtra("key_emojimall_detail_chat_type", -1);
    }
    localIntent.putExtra("key_emojimall_detail_chat_type", i);
    localIntent.putExtra("key_emojimall_detail_chat_uin", str1);
    localIntent.putExtra("selfuin", paramString1);
    localIntent.putExtra("reqType", 6);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("emojimall_src", paramInt);
    localIntent.putExtra("emojimall_detail_id", paramString2);
    localIntent.putExtra("emojimall_qFace", paramBoolean1);
    localIntent.putExtra("emomall_new_time", j);
    localIntent.putExtra("hide_more_button", false);
    localIntent.putExtra("is_small_emoji", paramBoolean2);
    if (paramIntent != null)
    {
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", paramIntent.getBooleanExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", false));
    }
    if (paramInt == 8) {}
    for (paramInt = 40311;; paramInt = 40313)
    {
      localIntent.putExtra("individuation_url_type", paramInt);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 4L, localIntent, false, -1);
      return;
    }
  }
  
  public static void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    openEmojiDetailPage(paramActivity, paramString1, paramInt, paramString2, paramBoolean1, null, paramBoolean2);
  }
  
  public static void openEmojiDetailPage2(Activity paramActivity, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2, String paramString3)
  {
    if (paramBoolean) {}
    while (((paramInt1 != 8) && (paramInt1 != 4)) || (paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
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
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 4L, localIntent, false, -1);
  }
  
  public static void openEmojiHomePage(Activity paramActivity, String paramString, int paramInt)
  {
    openEmojiHomePage(paramActivity, paramString, paramInt, false, "");
  }
  
  public static void openEmojiHomePage(Activity paramActivity, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    int i = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
    int j = ((BaseActivity)paramActivity).app.a().a();
    String str = ((BaseActivity)paramActivity).app.a().a();
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("selfuin", paramString1);
    localIntent.putExtra("emojimall_src", paramInt);
    localIntent.putExtra("emomall_new_time", i);
    localIntent.putExtra("has_red_dot", paramBoolean);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("rec_id", paramString2);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("key_emojimall_detail_chat_type", j);
    localIntent.putExtra("key_emojimall_detail_chat_uin", str);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("individuation_url_type", reportSourceTypeOfEmoji(paramInt));
    if ((paramInt != 7) && (paramInt != 3)) {
      localIntent.putExtra("hide_left_button", true);
    }
    if (paramInt == 1) {
      localIntent.putExtra("hide_left_button", false);
    }
    if (paramInt == 9) {
      localIntent.putExtra("hide_left_button", false);
    }
    if ((paramInt == 1) || (paramInt == 3))
    {
      localIntent.putExtra("updateFlag", paramBoolean);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 2L, localIntent, true, 4001);
      return;
    }
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 2L, localIntent, false, -1);
  }
  
  public static void openEmojiHomePage2(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {
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
    if ((paramInt1 == 1) || (paramInt1 == 3))
    {
      localIntent.putExtra("updateFlag", false);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 2L, localIntent, true, 4001);
      return;
    }
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 2L, localIntent, false, -1);
  }
  
  public static void openEmosmActivity(Activity paramActivity, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.e("Q.emoji.web.EmojiUiPlugin.EmojiHomeUiPlugin", 1, "open EmosmActivity failed because selfUin is empty.srcFromType=" + paramInt + " ,hasRedDot=" + paramBoolean + " ,currentId=" + paramString2);
      return;
    }
    int i = ((BaseActivity)paramActivity).app.a().a();
    paramString1 = ((BaseActivity)paramActivity).app.a().a();
    paramString2 = new Intent(paramActivity, EmosmActivity.class);
    paramString2.putExtra("key_emojimall_detail_chat_type", i);
    paramString2.putExtra("key_emojimall_detail_chat_uin", paramString1);
    paramString2.putExtra("emojimall_src", paramInt);
    paramActivity.startActivity(paramString2);
  }
  
  public static void openSmallEmojiListPage(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    int j = paramActivity.getSharedPreferences(paramString1, 0).getInt("emosm_sp_mall_new_timestamp", -1);
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    int i = ((BaseActivity)paramActivity).app.a().a();
    String str2 = ((BaseActivity)paramActivity).app.a().a();
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramActivity.getIntent().getStringExtra("key_emojimall_detail_chat_uin");
      i = paramActivity.getIntent().getIntExtra("key_emojimall_detail_chat_type", -1);
    }
    localIntent.putExtra("key_emojimall_detail_chat_type", i);
    localIntent.putExtra("key_emojimall_detail_chat_uin", str1);
    localIntent.putExtra("selfuin", paramString1);
    localIntent.putExtra("reqType", 6);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("emojimall_src", paramInt);
    localIntent.putExtra("emomall_new_time", j);
    localIntent.putExtra("hide_more_button", false);
    localIntent.putExtra("emoji_ids", paramString2);
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, null, 4L, localIntent, false, -1);
  }
  
  public static int reportSourceTypeOfEmoji(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 5: 
    case 7: 
    default: 
      return 40300;
    case 1: 
      return 40310;
    case 6: 
    case 9: 
      return 40312;
    case 8: 
      return 40311;
    case 4: 
      return 40313;
    case 3: 
      return 40100;
    }
    return 40306;
  }
  
  public static void statisticEmojiHomePageInfo(Context paramContext, String paramString, Intent paramIntent)
  {
    HashMap localHashMap;
    long l1;
    long l2;
    long l3;
    boolean bool2;
    int k;
    boolean bool1;
    Object localObject2;
    Object localObject1;
    int i;
    int j;
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localHashMap = new HashMap();
      l1 = paramIntent.getExtras().getLong("openToOncreateGap", -1L);
      l2 = paramIntent.getExtras().getLong("openTogetKeyTimeGap", -1L);
      l3 = paramIntent.getExtras().getLong("openToFinishOrErrorGap", -1L);
      bool2 = paramIntent.getExtras().getBoolean("bNeedGetKey", false);
      k = paramIntent.getExtras().getInt("processStep", 1);
      localHashMap.put("openToOncreateGap", "" + l1);
      localHashMap.put("bNeedGetKey", "" + bool2);
      localHashMap.put("openTogetKeyTimeGap", "" + l2);
      localHashMap.put("openToFinishOrErrorGap", "" + l3);
      bool1 = true;
      localObject2 = "";
      localObject1 = "";
      i = 11200;
      j = i;
      if (k == 3)
      {
        j = paramIntent.getExtras().getInt("failcode", 0);
        localObject1 = paramIntent.getExtras().getString("errordescription");
        localObject2 = paramIntent.getExtras().getString("errorUrl");
        paramIntent = (Intent)localObject1;
        if (localObject1 == null) {
          paramIntent = "";
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localHashMap.put("errordescription", paramIntent);
        localHashMap.put("errorUrl", localObject1);
        bool1 = false;
        if (j != -4) {
          break label498;
        }
        i = 11201;
      }
    }
    for (;;)
    {
      localHashMap.put("param_FailCode", Integer.toString(i));
      localObject2 = paramIntent;
      j = i;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "statistic:openToOncreateGap:" + l1 + "openTogetKeyTimeGap:" + l2 + "bNeedGetKey:" + bool2 + "openToFinishOrErrorGap:" + l3 + "processStep:" + k + "isSuccess:" + bool1 + "errordescription:" + (String)localObject2 + "errorUrl:" + (String)localObject1 + "resultCode:" + j);
      }
      azmz.a(paramContext).a(paramString, "actOpenHomePage", bool1, 0L, 0L, localHashMap, "");
      return;
      label498:
      if (j == -12) {
        i = 11202;
      } else if (j == -6) {
        i = 11203;
      } else if (j == -11) {
        i = 11204;
      } else if (j == -13) {
        i = 11205;
      } else if (j == -14) {
        i = 11206;
      } else if (j == -2) {
        i = 11207;
      } else if (j == -7) {
        i = 11208;
      } else if (j == -5) {
        i = 11209;
      } else if (j == -9) {
        i = 11210;
      } else if (j == -8) {
        i = 11211;
      } else if (j == -15) {
        i = 11212;
      } else if (j == -1) {
        i = 11213;
      } else if (j == -3) {
        i = 11214;
      } else if (j == -10) {
        i = 11215;
      }
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
      this.activity.overridePendingTransition(0, 2130771989);
      return;
    }
    this.activity.overridePendingTransition(0, 2130771978);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin
 * JD-Core Version:    0.7.0.1
 */