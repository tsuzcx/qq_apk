package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.baseconfig.VideoConfig;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.VDynamicConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaVideoFeedsConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJBarrageConfigSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaSusAutoPlayConfigSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiVideoHelper
{
  public static final String a = "MultiVideoHelper";
  
  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      a(localJSONObject2);
      localJSONObject2.put("cardStyleConfig", a(297));
      localJSONObject2.put("interactAreaConfig", a(154));
      localJSONObject2.put("videoBarrageConfig", RIJBarrageConfigSp.b());
      localJSONObject1.put("aladingConfig", localJSONObject2);
    }
    catch (JSONException localJSONException)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateParamsForSeriesViola error: ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e(str, 2, localStringBuilder.toString());
    }
    localBundle.putString("param", localJSONObject1.toString());
    return localBundle;
  }
  
  public static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject;
    try
    {
      VideoConfig.a.b();
      localObject = a(paramIntent);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("stickySpeed", MultiVideoConfigHandler.a());
      localJSONObject2.put("maskLighteness", MultiVideoConfigHandler.a());
      localJSONObject2.put("topBarTitle", MultiVideoConfigHandler.a());
      localJSONObject2.put("autoPlayForLockScreen", Aladdin.getConfig(271).getIntegerFromString("auto_play", 1));
      JSONObject localJSONObject3 = a(372);
      localJSONObject3.put("rewardPrivilegeConfig", RIJUserLevelModule.getInstance().getCacheUserLevel(5));
      localJSONObject2.put("videoRewardConfig", localJSONObject3);
      localJSONObject2.put("barrageConfig", RIJBarrageConfigSp.a());
      localJSONObject2.put("videoBarrageConfig", RIJBarrageConfigSp.b());
      localJSONObject2.put("resumeEnable", VideoResumeManager.a.a());
      localJSONObject2.put("interactAreaConfig", a(154));
      a(localJSONObject2);
      localJSONObject2.put("sanlianSwitch", a());
      localJSONObject3 = new JSONObject();
      localJSONObject3.put("from", paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1));
      localJSONObject3.put("kandian_mode_new", VideoReporter.a());
      localJSONObject3.put("kandian_mode", RIJAppSetting.a());
      localJSONObject3.put("source", paramIntent.getIntExtra("key_source", -1));
      localJSONObject3.put("senceType", paramIntent.getIntExtra("RETURN_SCENE", 0));
      paramIntent = a();
      localJSONObject1.put("configModel", localObject);
      localJSONObject1.put("aladingConfig", localJSONObject2);
      localJSONObject1.put("reportConfig", localJSONObject3);
      localJSONObject1.put("dynamicAladdinConfig", VDynamicConfigHandler.b());
      localJSONObject1.put("xgAladdinConfig", VDynamicConfigHandler.a());
      localJSONObject1.put("protocolExtralParam", paramIntent);
      localJSONObject1.put("autoPlayDisable", RIJViolaSusAutoPlayConfigSp.a());
      localJSONObject1.put("userHeadUrl", b());
    }
    catch (JSONException paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "generateParamsForViola: json error ", paramIntent);
      }
    }
    localBundle.putString("param", localJSONObject1.toString());
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateParamsForViola: ");
      ((StringBuilder)localObject).append(localJSONObject1.toString());
      QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
    return localBundle;
  }
  
  public static QBaseFragment a(Context paramContext, Bundle paramBundle, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Object localObject1 = paramBundle;
    if (paramBundle == null) {
      localObject1 = new Bundle();
    }
    if (!((Bundle)localObject1).containsKey("VIDEO_FROM_TYPE")) {
      ((Bundle)localObject1).putInt("VIDEO_FROM_TYPE", 129);
    }
    ((Bundle)localObject1).putInt("is_channel", 1);
    paramBundle = new Intent();
    paramBundle.putExtras((Bundle)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelCoverId));
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append("channelId");
    ((StringBuilder)localObject1).append("=");
    ((StringBuilder)localObject1).append(paramTabChannelCoverInfo.mChannelCoverId);
    String str = ((StringBuilder)localObject1).toString();
    if (paramTabChannelCoverInfo.mChannelCoverId == 41725) {
      paramBundle = a();
    } else {
      paramBundle = a(paramBundle);
    }
    paramBundle.putBoolean("disable_color_note", true);
    paramBundle.putBoolean("disable_fps_ball", true);
    paramBundle.putBoolean("should_finish_activity", false);
    paramBundle.putBoolean("is_channel", true);
    paramBundle.putInt("channel_id", paramTabChannelCoverInfo.mChannelCoverId);
    Object localObject2 = RIJXTabFrameUtils.getChannelCoverList();
    localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = str;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          localObject1 = str;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (TabChannelCoverInfo)((Iterator)localObject2).next();
        } while ((localObject1 == null) || (((TabChannelCoverInfo)localObject1).mChannelCoverId != paramTabChannelCoverInfo.mChannelCoverId));
        paramTabChannelCoverInfo = new StringBuilder();
        paramTabChannelCoverInfo.append(str);
        paramTabChannelCoverInfo.append("&");
        paramTabChannelCoverInfo.append("is_last_index");
        paramTabChannelCoverInfo.append("=1");
        localObject1 = paramTabChannelCoverInfo.toString();
      }
    }
    return ViolaAccessHelper.a(paramContext, (String)localObject1, paramBundle);
  }
  
  public static QBaseFragment a(Context paramContext, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    return a(paramContext, null, paramTabChannelCoverInfo);
  }
  
  public static VideoInfo a(Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    if (paramBundle.getParcelable("VIDEO_OBJ") != null)
    {
      localObject1 = (VideoInfo)paramBundle.getParcelable("VIDEO_OBJ");
      VideoFeedsHelper.a((VideoInfo)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("generateRequestVideoInfo: 外部传进来的VideoInfo=");
        localStringBuilder.append(((VideoInfo)localObject1).e());
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      paramBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject1).g);
      return localObject1;
    }
    paramBundle = VideoFeedsHelper.a(paramBundle);
    VideoFeedsHelper.a(paramBundle);
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("innerGenerateRequestVideoInfo: 外部传进来的VideoInfo=");
      ((StringBuilder)localObject2).append(paramBundle.e());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return paramBundle;
  }
  
  private static String a()
  {
    try
    {
      String[] arrayOfString = Aladdin.getConfig(460).getString("rij_sanlian_switch", "0").split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = "1".equals(arrayOfString[i]);
        if (bool) {
          return "1";
        }
        i += 1;
      }
      return "0";
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException.getMessage());
    }
  }
  
  private static String a(Intent paramIntent)
  {
    String str = b(paramIntent);
    Object localObject = str;
    if (paramIntent.getExtras() != null)
    {
      localObject = str;
      if (paramIntent.getExtras().containsKey("VIDEO_ARTICLE_ID"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("&rowkey=");
        ((StringBuilder)localObject).append(paramIntent.getExtras().getString("VIDEO_ARTICLE_ID"));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private static String a(Intent paramIntent, VideoInfo paramVideoInfo)
  {
    URL localURL = paramVideoInfo.a();
    paramVideoInfo = null;
    String str = null;
    if (paramIntent == null)
    {
      paramIntent = str;
      if (localURL != null) {
        paramIntent = localURL.toString();
      }
      return paramIntent;
    }
    str = a(paramIntent.getStringExtra("VIDEO_COVER"));
    int i = paramIntent.getIntExtra("item_image_width", 0);
    int j = paramIntent.getIntExtra("item_image_height", 0);
    if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
      return a(str, i, j);
    }
    paramIntent = paramVideoInfo;
    if (localURL != null) {
      paramIntent = localURL.toString();
    }
    return paramIntent;
  }
  
  private static String a(VideoInfo paramVideoInfo, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("VIDEO_ACCOUNT_AVATAR_URL");
    } else {
      paramIntent = "";
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      return paramIntent;
    }
    return paramVideoInfo.p;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      if (paramString.startsWith("pubaccountimage:"))
      {
        String str1 = paramString.substring(paramString.indexOf(":") + 1);
        return str1;
      }
    }
    catch (Exception localException)
    {
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tryCutPubAccountImageProtocol]: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e(str2, 1, localStringBuilder.toString());
    }
    return paramString;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = "?";
    if (paramString.contains("?")) {
      str = "&";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    localStringBuilder.append("item_image_width");
    localStringBuilder.append("=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("&");
    localStringBuilder.append("item_image_height");
    localStringBuilder.append("=");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  private static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uint32_youngster_status", RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0)));
    localJSONObject.put("uint32_req_recommend_flag", VideoPlayRecommendHandler.a());
    localJSONObject.put("bytes_req_recommend_json", RIJStudyModeUtils.a());
    return localJSONObject;
  }
  
  private static JSONObject a(int paramInt)
  {
    Object localObject = Aladdin.getConfig(paramInt).getAll();
    JSONObject localJSONObject = new JSONObject();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject;
  }
  
  private static JSONObject a(Intent paramIntent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static JSONObject a(VideoInfo paramVideoInfo, Intent paramIntent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      localObject1 = Aladdin.getConfig(434).getAll();
      if (localObject1 != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localJSONObject.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue().toString());
        }
        paramJSONObject.put("videoAccountFeedsConfig", localJSONObject);
        return paramJSONObject;
      }
    }
    catch (Exception localException)
    {
      Object localObject1 = jdField_a_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addVideoFeedsConfigToJson error: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return paramJSONObject;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = a(localIntent);
    paramIntent.putInt("requestCode", paramInt);
    ViolaAccessHelper.a(paramActivity, null, a(localIntent), paramIntent, true);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = a(localIntent);
    String str = b(localIntent);
    paramIntent = str;
    if (localIntent.getExtras() != null)
    {
      paramIntent = str;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID"))
      {
        paramIntent = new StringBuilder();
        paramIntent.append(str);
        paramIntent.append("&rowkey=");
        paramIntent.append(localIntent.getExtras().getString("VIDEO_ARTICLE_ID"));
        paramIntent = paramIntent.toString();
      }
    }
    ViolaAccessHelper.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = a(localIntent);
    paramIntent = paramString;
    if (localIntent.getExtras() != null)
    {
      paramIntent = paramString;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID"))
      {
        paramIntent = new StringBuilder();
        paramIntent.append(paramString);
        paramIntent.append("&rowkey=");
        paramIntent.append(localIntent.getExtras().getString("VIDEO_ARTICLE_ID"));
        paramIntent = paramIntent.toString();
      }
    }
    ViolaAccessHelper.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    if ((a(paramAbsBaseArticleInfo)) && ((paramContext instanceof Activity))) {
      try
      {
        paramContext = VideoFeedsHelper.a((Activity)paramContext, paramAbsBaseArticleInfo.mVideoJsonWidth, paramAbsBaseArticleInfo.mVideoJsonHeight);
        paramAbsBaseArticleInfo.setFirstFrameWidth(((Integer)paramContext.first).intValue());
        paramAbsBaseArticleInfo.setFirstFrameHeight(((Integer)paramContext.second).intValue());
        paramContext = new URL(a(paramAbsBaseArticleInfo.getFirstFrameUrl().toString()));
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.jdField_a_of_type_JavaNetURL = paramContext;
        localImageRequest.jdField_b_of_type_Int = paramAbsBaseArticleInfo.getFirstFrameHeight();
        localImageRequest.jdField_a_of_type_Int = paramAbsBaseArticleInfo.getFirstFrameWidth();
        localImageRequest.jdField_b_of_type_Boolean = true;
        ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, new MultiVideoHelper.1(paramAbsBaseArticleInfo, paramContext));
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramAbsBaseArticleInfo.getMessage());
      }
    }
  }
  
  private static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    int i;
    if (Aladdin.getConfig(312).getIntegerFromString("first_frame_preload_disable", 0) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo.getFirstFrameUrl() != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mChannelID == 0L)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static String b()
  {
    try
    {
      String str1 = ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), null));
      return str1;
    }
    catch (Throwable localThrowable)
    {
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getUserHeadUrl]: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e(str2, 1, localStringBuilder.toString());
    }
    return null;
  }
  
  private static String b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("video_rowkey");
    int i = -1;
    int k = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
    Object localObject = paramIntent.getStringExtra("VIDEO_WIDTH");
    paramIntent = paramIntent.getStringExtra("VIDEO_HEIGHT");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      i = Integer.valueOf((String)localObject).intValue();
    }
    int j;
    if (TextUtils.isEmpty(paramIntent)) {
      j = 0;
    } else {
      j = Integer.valueOf(paramIntent).intValue();
    }
    if (MultiVideoConfigHandler.a(k, i, j)) {
      paramIntent = "https://viola.qq.com/js/VideoAccountFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoAccountFeeds&hideNav=1&statusColor=1&v_bid=3811&_cache_bunle=1&v_nav_immer=1";
    } else if (ViolaVideoFeedsConfigHandler.a(k)) {
      paramIntent = ViolaAccessHelper.a();
    } else {
      paramIntent = ViolaAccessHelper.a();
    }
    localObject = paramIntent;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramIntent);
      ((StringBuilder)localObject).append("&video_rowkey=");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private static JSONObject b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    paramIntent = paramIntent.getStringExtra("extralData");
    if (!TextUtils.isEmpty(paramIntent))
    {
      paramIntent = new String(Base64.decode(paramIntent.getBytes(), 0));
      try
      {
        paramIntent = new JSONObject(paramIntent);
        return paramIntent;
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramIntent.getMessage());
      }
    }
    return null;
  }
  
  private static JSONObject c(Intent paramIntent)
  {
    AnchorData localAnchorData = (AnchorData)paramIntent.getParcelableExtra("VIDEO_COMMENT_ANCHOR");
    if (localAnchorData == null) {
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = localJSONObject1.put("commentId", localAnchorData.jdField_a_of_type_JavaLangString).put("commenId", localAnchorData.jdField_a_of_type_JavaLangString).put("subCommentId", localAnchorData.jdField_b_of_type_JavaLangString);
    if (localAnchorData.jdField_b_of_type_Boolean) {
      paramIntent = "0";
    } else {
      paramIntent = "1";
    }
    localJSONObject2.put("jumpCommentType", paramIntent).put("isAwesome", localAnchorData.jdField_a_of_type_Boolean);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper
 * JD-Core Version:    0.7.0.1
 */