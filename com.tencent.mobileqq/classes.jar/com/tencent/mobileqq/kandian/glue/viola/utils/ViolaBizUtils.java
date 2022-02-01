package com.tencent.mobileqq.kandian.glue.viola.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaBizUtils
{
  public static String a = "ViolaBizUtils";
  private static String b = "8.0.6";
  
  public static int a(ViewGroup paramViewGroup)
  {
    try
    {
      Object localObject1 = paramViewGroup.getResources();
      int i = 0;
      Object localObject2;
      while (i < paramViewGroup.getChildCount())
      {
        localObject2 = paramViewGroup.getChildAt(i);
        if ((((View)localObject2).getId() != -1) && ("navigationBarBackground".equals(((Resources)localObject1).getResourceEntryName(((View)localObject2).getId()))))
        {
          i = ((View)localObject2).getHeight();
          paramViewGroup = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("heights: ");
          ((StringBuilder)localObject1).append(i);
          QLog.d(paramViewGroup, 1, ((StringBuilder)localObject1).toString());
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramViewGroup)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getNavHeight]: ");
      ((StringBuilder)localObject2).append(paramViewGroup.getMessage());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("platform", "Android");
      localJSONObject.put("osVersion", DeviceInfoUtil.g());
      localJSONObject.put("appName", DeviceInfoUtil.e());
      localJSONObject.put("appVersion", "8.8.17.5770");
      localJSONObject.put("appVersionCode", g());
      localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      float f1 = FlexConvertUtils.getScreenHeight(BaseApplication.getContext()) / localDisplayMetrics.density;
      float f2 = FlexConvertUtils.getScreenWidth(BaseApplication.getContext()) / localDisplayMetrics.density;
      float f3 = localDisplayMetrics.density;
      localJSONObject.put("deviceWidth", Math.min(f2, f1));
      localJSONObject.put("deviceHeight", Math.max(f2, f1));
      localJSONObject.put("dpToPxRatio", f3);
      localJSONObject.put("deviceModel", Build.MODEL);
      localJSONObject.put("violaVersion", b);
      localJSONObject.put("statusBarHeight", ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
      localJSONObject.put("appID", "1");
      j = 0;
      localJSONObject.put("isDebug", 0);
      localJSONObject.put("navBarHeight", DisplayUtil.getNavigationBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
      localJSONObject.put("deviceBrand", Build.BRAND);
      localJSONObject.put("appVersionId", "8.8.17");
      LiuHaiUtils.f(QBaseActivity.sTopActivity);
      if (!LiuHaiUtils.b()) {
        break label391;
      }
      i = 1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        DisplayMetrics localDisplayMetrics;
        int j;
        continue;
        int i = 0;
      }
    }
    localJSONObject.put("isLiuHai", i);
    i = j;
    if (CUKingCardUtils.a() == 1) {
      i = 1;
    }
    localJSONObject.put("isKindCard", i);
    localJSONObject.put("netType", HttpUtil.getNetWorkType());
    localJSONObject.put("build", 102);
    if (QBaseActivity.sTopActivity != null) {
      localJSONObject.put("nowNavBarHeight", CommonSuspensionGestureLayout.a(QBaseActivity.sTopActivity) / localDisplayMetrics.density);
    }
    localJSONObject.put("androidVersion", Build.VERSION.SDK_INT);
    break label380;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "env JSONException");
    }
    label380:
    return localJSONObject.toString();
  }
  
  public static String a(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "-1";
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = OfflineEnvHelper.b(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    paramString2 = HtmlOffline.g(paramString2);
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString2);
    return ((StringBuilder)localObject).toString();
  }
  
  public static JSONObject a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("receiveNewMessage", paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      label19:
      break label19;
    }
    return new JSONObject();
  }
  
  public static JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("switchPagerRefresh", paramJSONObject);
      return localObject;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchPagerRefresh error:");
      localStringBuilder.append(paramJSONObject.getMessage());
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    return new JSONObject();
  }
  
  public static void a(BridgeModule paramBridgeModule, long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2)
  {
    a(paramBridgeModule, paramLong, paramList, paramString1, paramInt, paramString2, false);
  }
  
  public static void a(BridgeModule paramBridgeModule, long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new ViolaBizUtils.3(paramList, paramInt, paramString2, paramBoolean, paramBridgeModule, paramString1), 16, null, false);
  }
  
  public static void a(BridgeModule paramBridgeModule, @NotNull QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    RIJUgcVideoPublishManager.a(paramQQAppInterface).a(paramLong, new ViolaBizUtils.6(paramBridgeModule, paramLong, paramString));
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString)
  {
    try
    {
      ReadInJoyUserInfoModule.a(RIJQQAppInterfaceUtil.c(), new ViolaBizUtils.1(paramBridgeModule, paramString), true);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      ViolaLogUtils.e(a, paramBridgeModule.getMessage());
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramString1), null);
        if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isLiving()))
        {
          bool = true;
          paramString1 = "";
          if (localReadInJoyUserInfo != null) {
            paramString1 = localReadInJoyUserInfo.getLiveUrl();
          }
          paramBridgeModule.invokeCallJS(paramString2, new JSONObject().put("isLiving", bool).put("liveUrl", paramString1));
          return;
        }
      }
      catch (Exception paramBridgeModule)
      {
        ViolaLogUtils.e(a, paramBridgeModule.getMessage());
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject)
  {
    if ((paramBridgeModule.getViolaInstance() != null) && (paramBridgeModule.getViolaInstance().getActivity() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      localUrlJumpInfo.a = paramJSONObject.optInt("jumpType", 1);
      localUrlJumpInfo.b = paramJSONObject.optString("jumpUrl", "");
      localUrlJumpInfo.c = paramJSONObject.optString("jumpBundle", "");
      localUrlJumpInfo.d = paramJSONObject.optString("jumpSchema", "");
      localUrlJumpInfo.e = paramJSONObject.optString("clipboardInfo", "");
      localUrlJumpInfo.f = paramJSONObject.optString("commonData", "");
      VideoFeedsHelper.a(paramBridgeModule.getViolaInstance().getActivity(), localUrlJumpInfo);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      Object localObject = paramBridgeModule.getViolaInstance().getActivity();
      paramJSONObject = VideoFeedsHelper.b((Activity)localObject, paramJSONObject.optInt("width"), paramJSONObject.optInt("height"));
      float f = 750.0F / VideoFeedsHelper.c(localObject)[0];
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("x", paramJSONObject.left * f);
        ((JSONObject)localObject).put("y", paramJSONObject.top * f);
        ((JSONObject)localObject).put("width", paramJSONObject.width() * f);
        ((JSONObject)localObject).put("height", paramJSONObject.height() * f);
        paramBridgeModule.invokeJS(paramString, (JSONObject)localObject);
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        paramBridgeModule.printStackTrace();
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str1 = paramJSONObject.optString("uniqueKey");
        int i = paramJSONObject.optInt("source", 3);
        Object localObject2 = paramJSONObject.optString("feedsID", "");
        int j = paramJSONObject.optInt("feedsType", -1);
        int k = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        Object localObject3 = paramJSONObject.optString("sourceName", "");
        String str4 = paramJSONObject.optString("picUrl", "");
        long l1 = paramJSONObject.optLong("duration", -1L);
        String str5 = paramJSONObject.optString("articleID", "");
        Object localObject1 = paramJSONObject.optString("commentID");
        String str2 = paramJSONObject.optString("subCommentID");
        bool = paramJSONObject.optBoolean("isAwesome");
        int m = paramJSONObject.optInt("jumpType");
        int n = paramJSONObject.optInt("showType", 0);
        long l2 = paramJSONObject.optLong("recommendSeq", 0L);
        paramJSONObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startShowComment  uniqueKey = ");
        localStringBuilder.append(str1);
        localStringBuilder.append("source = ");
        localStringBuilder.append(i);
        localStringBuilder.append("feedsId = ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" feedsType=");
        localStringBuilder.append(j);
        localStringBuilder.append("adTag = ");
        localStringBuilder.append(k);
        localStringBuilder.append("title = ");
        localStringBuilder.append(str3);
        localStringBuilder.append("sourceName = ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("picUrl =");
        localStringBuilder.append(str4);
        localStringBuilder.append("duration = ");
        localStringBuilder.append(l1);
        localStringBuilder.append("articleId =");
        localStringBuilder.append(str5);
        QLog.d(paramJSONObject, 1, localStringBuilder.toString());
        paramJSONObject = new Bundle();
        paramJSONObject.putSerializable("commonCommentData", new CommonCommentData(str5, j, (String)localObject2, k, str3, (String)localObject3, str4, l1));
        paramJSONObject.putInt("source", i);
        paramJSONObject.putString("commentId", (String)localObject1);
        paramJSONObject.putString("subCommentId", str2);
        paramJSONObject.putBoolean("isAwesome", bool);
        paramJSONObject.putInt("jumpType", m);
        paramJSONObject.putInt("seq", paramInt);
        paramJSONObject.putLong("recommendSeq", l2);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).a = ((String)localObject1);
        ((AnchorData)localObject2).b = str2;
        ((AnchorData)localObject2).c = bool;
        str3 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("anchorData commentId:");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" ,subCommentId :");
        ((StringBuilder)localObject3).append(str2);
        QLog.d(str3, 1, ((StringBuilder)localObject3).toString());
        localObject1 = QBaseActivity.sTopActivity;
        if (n == 1)
        {
          bool = true;
          ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, null, null, null, (AnchorData)localObject2, false, bool, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, QLog.getStackTraceString(paramJSONObject));
        }
        return;
      }
      boolean bool = false;
    }
  }
  
  public static String b(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return a(str, paramString);
  }
  
  public static JSONObject b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewDidAppear", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      label19:
      break label19;
    }
    return new JSONObject();
  }
  
  public static JSONObject b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", paramInt);
      localJSONObject1.put("pageRefresh", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      label36:
      break label36;
    }
    return new JSONObject();
  }
  
  private static void b(BridgeModule paramBridgeModule, ReadInJoyUserInfo paramReadInJoyUserInfo, String paramString)
  {
    if (paramReadInJoyUserInfo == null)
    {
      QLog.e(a, 1, "[onLoadUserInfoSucceed]: userInfo is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", Long.parseLong(paramReadInJoyUserInfo.uin)).put("nickName", paramReadInJoyUserInfo.nick).put("headUrl", ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
      paramBridgeModule.invokeJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      ViolaLogUtils.e(a, paramBridgeModule.getMessage());
    }
  }
  
  public static void b(BridgeModule paramBridgeModule, JSONObject paramJSONObject)
  {
    Object localObject2 = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject2 != null)
    {
      String str1 = paramJSONObject.optString("rowkey", "");
      String str2 = paramJSONObject.optString("article_title", "");
      String str3 = paramJSONObject.optString("article_summary", "");
      String str4 = paramJSONObject.optString("first_page_url", "");
      int k = paramJSONObject.optInt("duration", 0);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramJSONObject.optString("article_url", ""));
      ((StringBuilder)localObject1).append("&sourcefrom=6");
      localObject1 = ((StringBuilder)localObject1).toString();
      int m = paramJSONObject.optInt("publishAccountUin", 0);
      String str5 = paramJSONObject.optString("publishAccountName", "");
      localObject2 = ((QQAppInterface)localObject2).getAccount();
      int i = 2;
      int j = paramJSONObject.optInt("favoriteType", 2);
      Bundle localBundle = new Bundle();
      localBundle.putInt("videoDuration", k);
      localBundle.putLong("publishAccountUin", m);
      localBundle.putString("publishAccountName", str5);
      if (paramJSONObject.optInt("busiType", 6) == 6) {
        i = 1;
      }
      localBundle.putInt("videoType", i);
      ReadInJoyAtlasManager.getInstance().doFavorite(paramBridgeModule.getViolaInstance().getActivity(), (String)localObject2, j, str1, str2, str3, str4, (String)localObject1, localBundle, true);
    }
  }
  
  public static void b(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    String str1 = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    String str2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelUploadingVideo, content=");
    localStringBuilder.append(paramJSONObject.toString());
    localStringBuilder.append(",callbackId=");
    localStringBuilder.append(paramString);
    QLog.i(str2, 1, localStringBuilder.toString());
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(j, new ViolaBizUtils.2(str1, paramJSONObject, i, paramBridgeModule, j, paramString));
    }
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("uin");
    int i = paramJSONObject.optInt("columnId");
    int j = paramJSONObject.optInt("action");
    int k = paramJSONObject.optInt("currentFollowCount");
    if (QLog.isColorLevel())
    {
      paramJSONObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onColumnAttentionStatusChange, uin=");
      localStringBuilder.append(l);
      localStringBuilder.append(" columnId=");
      localStringBuilder.append(i);
      localStringBuilder.append(" action=");
      localStringBuilder.append(j);
      localStringBuilder.append(" subscribeCount=");
      localStringBuilder.append(k);
      QLog.i(paramJSONObject, 2, localStringBuilder.toString());
    }
    if (l == RIJQQAppInterfaceUtil.c())
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(i, j, k);
      return;
    }
    paramJSONObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onColumnAttentionStatusChange current uin not equals to ");
    localStringBuilder.append(l);
    QLog.e(paramJSONObject, 1, localStringBuilder.toString());
  }
  
  public static AnchorData c(JSONObject paramJSONObject)
  {
    String str3 = paramJSONObject.optString("commentID");
    String str2 = paramJSONObject.optString("subCommentID");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramJSONObject.optString("subCommentId");
    }
    boolean bool = paramJSONObject.optBoolean("isAwesome");
    paramJSONObject = new AnchorData();
    paramJSONObject.a = str3;
    paramJSONObject.b = str1;
    paramJSONObject.c = bool;
    if (QLog.isColorLevel())
    {
      str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openTopicVideoComment anchorData commentId:");
      localStringBuilder.append(str3);
      localStringBuilder.append(" ,subCommentId :");
      localStringBuilder.append(str1);
      QLog.d(str2, 1, localStringBuilder.toString());
    }
    return paramJSONObject;
  }
  
  public static JSONObject c()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewDidDisappear", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      label19:
      break label19;
    }
    return new JSONObject();
  }
  
  public static void c(BridgeModule paramBridgeModule, JSONObject paramJSONObject)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    ArrayList localArrayList = new ArrayList();
    if (localQQAppInterface != null)
    {
      localArrayList.add(paramJSONObject.optString("rowkey", ""));
      paramBridgeModule = new ViolaBizUtils.7(paramBridgeModule, localQQAppInterface.getAccount());
      ReadInJoyAtlasManager.getInstance().getAtlasFavoriteStatus(localArrayList, paramBridgeModule);
    }
  }
  
  public static void c(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    paramJSONObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeUploadingVideo, vid=");
    localStringBuilder.append(str);
    localStringBuilder.append("pageType=");
    localStringBuilder.append(i);
    QLog.i(paramJSONObject, 1, localStringBuilder.toString());
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(j, new ViolaBizUtils.4(str, paramJSONObject, i, paramBridgeModule, j, paramString));
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    paramString = a(str, paramString);
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (new File(paramString).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static AbsBaseArticleInfo d(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("rowkey");
    String str2 = paramJSONObject.optString("title", "");
    String str3 = paramJSONObject.optString("cover", "");
    Object localObject = paramJSONObject.optString("subscribeId", "");
    long l1 = paramJSONObject.optLong("articleId", 0L);
    long l2 = paramJSONObject.optLong("feedsID", 0L);
    int i = paramJSONObject.optInt("feedsType", 0);
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    localBaseArticleInfo.innerUniqueID = str1;
    localBaseArticleInfo.mTitle = str2;
    localBaseArticleInfo.mSummary = null;
    localBaseArticleInfo.mFirstPagePicUrl = str3;
    localBaseArticleInfo.mSubscribeID = ((String)localObject);
    localBaseArticleInfo.mArticleID = l1;
    localBaseArticleInfo.mFeedId = l2;
    localBaseArticleInfo.mFeedType = i;
    localBaseArticleInfo.unioChann = paramJSONObject.optString("union_chann", "");
    localBaseArticleInfo.tags = paramJSONObject.optString("tags", "");
    localBaseArticleInfo.mAdScene = 3;
    if (!TextUtils.isEmpty(paramJSONObject.optString("vid", ""))) {
      localBaseArticleInfo.mVideoVid = paramJSONObject.optString("vid");
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString("picUrl", ""))) {
      localBaseArticleInfo.mVideoCoverUrl = RIJConvertString2URL.b(paramJSONObject.optString("picUrl"));
    }
    if (QLog.isColorLevel())
    {
      paramJSONObject = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openTopicVideoComment  uniqueKey = ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("feedsId = ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(" feedsType=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("title = ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("picUrl =");
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append("articleId =");
      ((StringBuilder)localObject).append(l1);
      QLog.d(paramJSONObject, 1, ((StringBuilder)localObject).toString());
    }
    return localBaseArticleInfo;
  }
  
  public static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      SharedPreferences localSharedPreferences = RIJSPUtils.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null)
      {
        QLog.d(a, 1, "failed to getItem");
        return null;
      }
      return localSharedPreferences.getString(paramString, null);
    }
    return null;
  }
  
  public static JSONObject d()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("switchPagerScroll", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchPagerScroll error:");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
    return new JSONObject();
  }
  
  public static void d(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    String str1 = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    String str2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseUploadingVideo, content=");
    localStringBuilder.append(paramJSONObject.toString());
    localStringBuilder.append(",callbackId=");
    localStringBuilder.append(paramString);
    QLog.i(str2, 1, localStringBuilder.toString());
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(j, new ViolaBizUtils.5(str1, paramJSONObject, i, paramBridgeModule, j, paramString));
    }
  }
  
  public static String e()
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&time=");
    localStringBuilder.append(String.valueOf(l).substring(0, 7));
    return localStringBuilder.toString();
  }
  
  public static void e(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    if (localQQAppInterface != null) {
      try
      {
        long l = paramJSONObject.optLong("uin", 0L);
        int i = 0;
        if ((l != 0L) && (l == localQQAppInterface.getLongAccountUin()))
        {
          if (RIJUgcUtils.i()) {
            i = 1;
          }
          localJSONObject.put("hasPermission", i);
        }
        else
        {
          localJSONObject.put("hasPermission", 0);
        }
        paramBridgeModule.invokeJS(paramString, localJSONObject);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramBridgeModule.invokeJS(paramString, localJSONObject);
        paramBridgeModule = a;
        paramString = new StringBuilder();
        paramString.append("BridgeModule: getReadInJoyUgcPermission");
        paramString.append(paramJSONObject.toString());
        QLog.e(paramBridgeModule, 1, paramString.toString());
        return;
      }
    }
    QLog.e(a, 1, "BridgeModule: getReadInJoyUgcPermission app is null!");
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = "1".equals(Uri.parse(paramString).getQueryParameter("supportColorBall"));
      return bool;
    }
    catch (Exception paramString)
    {
      QLog.e(a, 1, paramString.getMessage());
    }
    return false;
  }
  
  public static float[] f()
  {
    float[] arrayOfFloat = new float[3];
    Object localObject1 = null;
    Object localObject2;
    do
    {
      try
      {
        if (SplashActivity.sWeakInstance != null) {
          localObject1 = (Activity)SplashActivity.sWeakInstance.get();
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
          continue;
        }
        localObject2 = QBaseActivity.sTopActivity;
      }
      catch (Throwable localThrowable)
      {
        float f2;
        float f1;
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getTopActivitySize]: ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
        return arrayOfFloat;
      }
      localObject1 = (ViewGroup)((Activity)localObject2).getWindow().getDecorView();
      localObject2 = BaseApplication.getContext().getResources().getDisplayMetrics();
      f2 = ((ViewGroup)localObject1).getWidth() / ((DisplayMetrics)localObject2).density;
      f1 = ((ViewGroup)localObject1).getHeight() / ((DisplayMetrics)localObject2).density;
      f2 = Math.min(f2, f1);
      f1 = Math.max(f2, f1);
      arrayOfFloat[0] = f2;
      arrayOfFloat[1] = f1;
      arrayOfFloat[2] = (a((ViewGroup)localObject1) / ((DisplayMetrics)localObject2).density);
      return arrayOfFloat;
    } while (localObject2 != null);
    return arrayOfFloat;
  }
  
  private static String g()
  {
    return DeviceInfoUtil.a(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils
 * JD-Core Version:    0.7.0.1
 */