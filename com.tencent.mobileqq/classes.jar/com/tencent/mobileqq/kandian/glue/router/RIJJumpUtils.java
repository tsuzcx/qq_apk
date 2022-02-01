package com.tencent.mobileqq.kandian.glue.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager.ImgStruct;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.tab.IRIJTabFrame;
import com.tencent.mobileqq.kandian.base.utils.NativeWebVideoCoverGetCallback;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.DialogClick;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.DialogSettingInfo;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebArticleOptimizeUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.liveroom.LiveRoomProxyActivity;
import cooperation.qzone.util.NetworkState;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJJumpUtils
{
  public static AbsBaseArticleInfo a;
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0;
    }
    if (RIJFeedsType.a(paramAbsBaseArticleInfo))
    {
      if (paramAbsBaseArticleInfo.mVideoType == 0) {
        return 4;
      }
      return 5;
    }
    if (paramAbsBaseArticleInfo.mShowBigPicture)
    {
      if (paramAbsBaseArticleInfo.mIsGallery == 0) {
        return 2;
      }
      return 8;
    }
    if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length >= 3)) {
      return 3;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mFirstPagePicUrl)) {
      return 0;
    }
    if (paramAbsBaseArticleInfo.mIsGallery == 0) {
      return 1;
    }
    return 7;
  }
  
  private static long a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramInt != 3) && (paramInt != 5) && (paramInt != 2) && (paramInt != 7)) {
      return paramAbsBaseArticleInfo.mFeedId;
    }
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)) {
      return paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.longValue();
    }
    return 0L;
  }
  
  public static IRIJTabFrame a(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof SplashActivity))
      {
        paramContext = FrameHelperActivity.a((BaseActivity)paramContext);
        if (paramContext == null) {
          return null;
        }
        paramContext = (RIJTabFrameBase)paramContext.a(RIJXTabFrameUtils.INSTANCE.getTabFrame());
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      QLog.e("RIJJumpUtils", 1, paramContext, new Object[0]);
    }
    return null;
  }
  
  public static Integer a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null, null);
  }
  
  public static Integer a(Context paramContext, String paramString, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jumpTo: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" extraData: ");
    ((StringBuilder)localObject).append(paramBundle);
    QLog.d("RIJJumpUtils", 1, ((StringBuilder)localObject).toString());
    Integer localInteger = Integer.valueOf(-1);
    if (paramContext != null)
    {
      if (paramString == null) {
        return localInteger;
      }
      localObject = paramContext;
      if ((paramContext instanceof BasePluginActivity))
      {
        paramContext = ((BasePluginActivity)paramContext).getOutActivity();
        localObject = paramContext;
        if (paramContext == null) {
          return localInteger;
        }
      }
      paramContext = ViolaAccessHelper.c(paramString);
      if ((ViolaAccessHelper.c(paramString)) && (!TextUtils.isEmpty(paramContext)))
      {
        ViolaAccessHelper.a((Context)localObject, null, paramContext, paramBundle);
        return Integer.valueOf(12);
      }
      int i;
      if ((!paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) && (!paramString.startsWith("http://clientui.3g.qq.com/mqq/")) && (!paramString.startsWith("http://qm.qq.com/cgi-bin/")) && (!paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {
        i = 0;
      } else {
        i = 1;
      }
      if (paramString.startsWith("https://m.gamefeeds.qq.com/live.html?"))
      {
        LiveRoomProxyActivity.open((Activity)localObject, paramString, "kandian feed click");
        return Integer.valueOf(0);
      }
      if ((i == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
      {
        paramContext = new Bundle();
        paramContext.putString("url", paramString);
        paramContext.putBoolean("hide_operation_bar", true);
        paramString = new Intent((Context)localObject, QQBrowserActivity.class);
        paramString.putExtra("big_brother_source_key", a(0));
        paramString.putExtras(paramContext);
        paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        if (paramBundle != null)
        {
          paramString.putExtras(paramBundle);
          if ((paramBundle.containsKey("requestCode")) && ((localObject instanceof Activity)))
          {
            ((Activity)localObject).startActivityForResult(paramString, paramBundle.getInt("requestCode", -1));
            return Integer.valueOf(11);
          }
        }
        ((Context)localObject).startActivity(paramString);
        return Integer.valueOf(11);
      }
      paramContext = new Intent((Context)localObject, JumpActivity.class);
      paramString = Uri.parse(paramString);
      paramContext.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramContext.putExtra("big_brother_source_key", a(0));
      paramContext.setData(paramString);
      ((Context)localObject).startActivity(paramContext);
      return Integer.valueOf(0);
    }
    return localInteger;
  }
  
  public static Integer a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jumToUrl: ");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    QLog.d("RIJJumpUtils", 1, (String)localObject);
    if (TextUtils.isEmpty(paramString1)) {
      return Integer.valueOf(-1);
    }
    if (paramString1.startsWith("mqqapi:")) {}
    for (;;)
    {
      try
      {
        localObject = JumpParser.a(RIJQQAppInterfaceUtil.b(), paramContext, paramString1);
        if ((localObject == null) || (!((JumpAction)localObject).a())) {
          break label259;
        }
        if (i != 0) {
          return Integer.valueOf(9);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("jumpToUrl failed for appInterface is null, url:");
          localStringBuilder2.append(paramString1);
          localStringBuilder2.append(",error:");
          localStringBuilder2.append(localThrowable.getMessage());
          QLog.d("RIJJumpUtils", 2, localStringBuilder2.toString());
        }
      }
      if (!TextUtils.isEmpty(paramString2)) {
        try
        {
          if (WxShareHelperFromReadInjoy.getInstance().doOpenMiniProgram(paramString2, paramString3, 0)) {
            return Integer.valueOf(8);
          }
        }
        catch (Throwable paramString3)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("jumpToUrl failed for wxMiniApp, appId:");
            localStringBuilder1.append(paramString2);
            localStringBuilder1.append(",error:");
            localStringBuilder1.append(paramString3.getMessage());
            QLog.d("RIJJumpUtils", 2, localStringBuilder1.toString());
          }
        }
      }
      return b(paramContext, paramString1);
      label259:
      i = 0;
    }
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 40677)
      {
        if (DailyModeConfigHandler.c(paramInt)) {
          return "biz_src_gzh_kandiandaily";
        }
        return "biz_src_feeds_kandian";
      }
      return "biz_src_gzh_weishi";
    }
    return "biz_src_feeds_kandian";
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject3 = "";
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    Object localObject2 = ReadInJoyConstants.e;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains("uin"))
    {
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long > 0L))
      {
        localObject1 = String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
      }
      else
      {
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
          localObject1 = paramAbsBaseArticleInfo.mSubscribeID;
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("uin=");
      ((StringBuilder)localObject3).append(Base64Util.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
      localObject1 = ((String)localObject2).replace("uin=", ((StringBuilder)localObject3).toString());
    }
    localObject2 = localObject1;
    if (((String)localObject1).contains("&feedstype="))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&feedstype=");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mFeedType);
      localObject2 = ((String)localObject1).replace("&feedstype=", ((StringBuilder)localObject2).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mFeedId);
    paramAbsBaseArticleInfo = ((StringBuilder)localObject1).toString();
    QLog.d("RIJJumpUtils", 2, new Object[] { "getNewSocialSecondUrl = ", paramAbsBaseArticleInfo });
    return paramAbsBaseArticleInfo;
  }
  
  @NotNull
  private static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Object localObject2 = ReadInJoyConstants.e;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains("uin="))
    {
      localObject1 = b(paramAbsBaseArticleInfo, paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(Base64Util.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
      localObject1 = ((String)localObject2).replace("uin=", localStringBuilder.toString());
    }
    localObject2 = localObject1;
    if (((String)localObject1).contains("&feedstype="))
    {
      if (((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) || ((paramInt != 2) && (paramInt != 3) && (paramInt != 5) && (paramInt != 7)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("&feedstype=");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mFeedType);
        return ((String)localObject1).replace("&feedstype=", ((StringBuilder)localObject2).toString());
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&feedstype=");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b);
      localObject2 = ((String)localObject1).replace("&feedstype=", ((StringBuilder)localObject2).toString());
    }
    return localObject2;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if (a(paramString)) {
      return a(paramString, paramAbsBaseArticleInfo);
    }
    String str = paramString;
    if (b(paramString)) {
      str = b(paramString, paramAbsBaseArticleInfo);
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.g);
    localStringBuilder.append(Base64Util.encodeToString(paramString.getBytes(), 2));
    return localStringBuilder.toString();
  }
  
  public static String a(@NotNull String paramString, long paramLong, int paramInt)
  {
    if (paramString.isEmpty()) {
      return paramString;
    }
    Object localObject = URLUtil.a(paramString);
    if ("6".equals((String)((Map)localObject).get("target")))
    {
      String str = (String)((Map)localObject).get("v_url_base64");
      localObject = paramString;
      if (str != null)
      {
        localObject = paramString;
        if (!str.isEmpty())
        {
          localObject = Base64Util.encodeToString(Uri.parse(new String(Base64Util.decode(str, 0))).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString().getBytes("utf-8"), 2);
          return URLUtil.b(URLUtil.a(paramString, "v_url_base64"), "v_url_base64", (String)localObject);
        }
      }
    }
    else
    {
      localObject = Uri.parse(paramString).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString();
    }
    return localObject;
  }
  
  public static String a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramAbsBaseArticleInfo != null) {
      try
      {
        localObject = new StringBuilder();
        Map localMap = URLUtil.a(paramString);
        ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbsBaseArticleInfo.mChannelID);
        localStringBuilder.append("");
        ((StringBuilder)localObject).append(a(localMap, "channelID", localStringBuilder.toString()));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
        localStringBuilder.append("");
        ((StringBuilder)localObject).append(a(localMap, "strategyId", localStringBuilder.toString()));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbsBaseArticleInfo.mAlgorithmID);
        localStringBuilder.append("");
        ((StringBuilder)localObject).append(a(localMap, "algorithmID", localStringBuilder.toString()));
        ((StringBuilder)localObject).append(a(localMap, "title", paramAbsBaseArticleInfo.mTitle));
        ((StringBuilder)localObject).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(paramAbsBaseArticleInfo.mFirstPagePicUrl, "UTF-8")));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
        localStringBuilder.append("");
        ((StringBuilder)localObject).append(a(localMap, "articleID", localStringBuilder.toString()));
        ((StringBuilder)localObject).append(a(localMap, "subscribeName", paramAbsBaseArticleInfo.mSubscribeName));
        ((StringBuilder)localObject).append(a(localMap, "rowKey", paramAbsBaseArticleInfo.innerUniqueID));
        ((StringBuilder)localObject).append(a(localMap, "subscribeID", paramAbsBaseArticleInfo.mSubscribeID));
        ((StringBuilder)localObject).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramString, "UTF-8")));
        ((StringBuilder)localObject).append("&");
        ((StringBuilder)localObject).append("readinjoyNotDecodeUrl=1");
        localObject = ((StringBuilder)localObject).toString();
      }
      catch (UnsupportedEncodingException paramAbsBaseArticleInfo)
      {
        QLog.e("RIJJumpUtils", 2, paramAbsBaseArticleInfo.getMessage());
        localObject = paramString;
      }
    }
    paramString = new StringBuilder();
    paramString.append("getJumpNativeArticleScheme |  articleScheme : ");
    paramString.append((String)localObject);
    QLog.d("RIJJumpUtils", 1, paramString.toString());
    return localObject;
  }
  
  private static String a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(a(paramAbsBaseArticleInfo, paramInt1));
    paramAbsBaseArticleInfo = localStringBuilder.toString();
    paramString = paramAbsBaseArticleInfo;
    if (paramInt2 >= 0)
    {
      paramString = new StringBuilder();
      paramString.append(paramAbsBaseArticleInfo);
      paramString.append("&jumptype=");
      paramString.append(paramInt2);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public static String a(String paramString, NewPolymericInfo.PackArticleInfo paramPackArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramPackArticleInfo != null)
    {
      localObject = paramString;
      if (paramAbsBaseArticleInfo != null)
      {
        localObject = paramString;
        if (!TextUtils.isEmpty(paramPackArticleInfo.c)) {
          try
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3");
            ((StringBuilder)localObject).append("&channelID=");
            ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mChannelID);
            ((StringBuilder)localObject).append("&strategyId=");
            ((StringBuilder)localObject).append(paramPackArticleInfo.jdField_a_of_type_Int);
            ((StringBuilder)localObject).append("&algorithmID=");
            ((StringBuilder)localObject).append(paramPackArticleInfo.jdField_b_of_type_Long);
            ((StringBuilder)localObject).append("&title=");
            ((StringBuilder)localObject).append(paramPackArticleInfo.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append("&firstPagePicUrl=");
            ((StringBuilder)localObject).append(URLEncoder.encode(paramPackArticleInfo.c, "UTF-8"));
            ((StringBuilder)localObject).append("&articleID=");
            ((StringBuilder)localObject).append(paramPackArticleInfo.jdField_a_of_type_Long);
            ((StringBuilder)localObject).append("&subscribeName=");
            ((StringBuilder)localObject).append(paramPackArticleInfo.f);
            ((StringBuilder)localObject).append("&rowKey=");
            ((StringBuilder)localObject).append(paramPackArticleInfo.g);
            ((StringBuilder)localObject).append("&subscribeID=");
            ((StringBuilder)localObject).append(paramPackArticleInfo.e);
            ((StringBuilder)localObject).append("&articleContentUrl=");
            ((StringBuilder)localObject).append(URLEncoder.encode(paramString, "UTF-8"));
            ((StringBuilder)localObject).append("&readinjoyNotDecodeUrl=1");
            localObject = ((StringBuilder)localObject).toString();
          }
          catch (UnsupportedEncodingException paramPackArticleInfo)
          {
            QLog.d("RIJJumpUtils", 2, paramPackArticleInfo.getMessage());
            localObject = paramString;
          }
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("getJumpNativeArticleScheme | polymeric articleScheme : ");
    paramString.append((String)localObject);
    QLog.d("RIJJumpUtils", 1, paramString.toString());
    return localObject;
  }
  
  public static String a(String paramString, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (paramJSONObject != null)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("card_info");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            if (!str.equalsIgnoreCase("reportInfo"))
            {
              paramJSONObject = localJSONObject.getString(str);
              localStringBuilder.append("&");
              paramString = paramJSONObject;
              if (paramJSONObject.contains("&")) {
                paramString = URLEncoder.encode(paramJSONObject, "utf-8");
              }
              paramJSONObject = new StringBuilder();
              paramJSONObject.append(str);
              paramJSONObject.append("=");
              paramJSONObject.append(paramString);
              localStringBuilder.append(paramJSONObject.toString());
            }
          }
          catch (Exception paramString)
          {
            QLog.e("RIJJumpUtils", 2, paramString.getMessage());
          }
        }
      }
    }
    localStringBuilder.append("&");
    localStringBuilder.append("readinjoyNotDecodeUrl=1");
    return localStringBuilder.toString();
  }
  
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (!paramMap.containsKey(paramString1)))
    {
      paramMap = new StringBuilder();
      paramMap.append("&");
      paramMap.append(paramString1);
      paramMap.append("=");
      paramMap.append(paramString2);
      return paramMap.toString();
    }
    return "";
  }
  
  public static JSONObject a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("button", paramInt);
      localJSONObject.put("extraParams", paramString);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDialogResult error! msg=");
      localStringBuilder.append(paramString);
      QLog.e("RIJJumpUtils", 1, localStringBuilder.toString());
    }
    return localJSONObject;
  }
  
  public static void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if ((paramAbsBaseArticleInfo.mArticleContentUrl != null) && (paramAbsBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi:")))
    {
      String str = paramAbsBaseArticleInfo.mArticleContentUrl;
      localObject = str;
      if (c(str)) {
        localObject = b(str, paramAbsBaseArticleInfo);
      }
      a(paramActivity, (String)localObject);
      a(paramAbsBaseArticleInfo, paramAbsBaseArticleInfo.mArticleContentUrl);
      return;
    }
    TimeUtil.a("FastWebActivity.show");
    ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    Object localObject = new Intent(paramActivity, FastWebActivity.class);
    ((Intent)localObject).putExtra("fast_web_article_info", paramAbsBaseArticleInfo);
    paramActivity.startActivityForResult((Intent)localObject, 10922);
    paramActivity = new StringBuilder();
    paramActivity.append("startWebFastActivity, rowkey= ");
    paramActivity.append(paramAbsBaseArticleInfo.innerUniqueID);
    QLog.d("RIJJumpUtils", 1, paramActivity.toString());
    if (paramAbsBaseArticleInfo.mChannelID == 0L) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(paramAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_ENTER, 0, 0, 0), 5);
    }
  }
  
  public static void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    b(paramActivity, paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
    if (a(paramAbsBaseArticleInfo))
    {
      paramReadInJoyBaseAdapter = new Intent(paramActivity, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountImageCollectionMainActivity.class));
      paramReadInJoyBaseAdapter.putExtra("source_for_report", 9);
      ((IPublicAccountImageCollectionUtils)QRoute.api(IPublicAccountImageCollectionUtils.class)).openPublicAccountImageCollectionMainActivity(paramActivity, paramReadInJoyBaseAdapter, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID));
      return;
    }
    paramInt = paramReadInJoyBaseAdapter.a();
    long l = paramAbsBaseArticleInfo.mRecommendSeq;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramAbsBaseArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo))
    {
      localObject1 = localObject2;
      if (!RIJItemViewTypeUtils.z(paramAbsBaseArticleInfo)) {
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a.get(0)).b;
      }
    }
    localObject2 = localObject1;
    if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("from=0");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (d((String)localObject2))
    {
      b(paramActivity, (String)localObject2);
      return;
    }
    localBundle.putString("url", (String)localObject2);
    localBundle.putBoolean("hide_operation_bar", true);
    localBundle.putString("from", String.valueOf(53));
    localBundle.putString("subscribename", paramAbsBaseArticleInfo.mSubscribeName);
    localBundle.putString("row_key", paramAbsBaseArticleInfo.innerUniqueID);
    localBundle.putLong("articleid", paramAbsBaseArticleInfo.mArticleID);
    localBundle.putLong("recommendSeq", l);
    localBundle.putInt("channelid", paramInt);
    localBundle.putInt("strategyid", paramAbsBaseArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramAbsBaseArticleInfo.mAlgorithmID);
    localBundle.putInt("articalChannelId", 9);
    localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
    localBundle.putBoolean("ip_connect", ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isReadInJoyIpConnect());
    l = System.currentTimeMillis();
    localBundle.putLong("startOpenPageTime", l);
    localBundle.putLong("click_time", l);
    localBundle.putLong("available_memory", DeviceInfoUtil.e());
    localBundle.putBoolean("preload_tool_white_list", RIJWebSearchUtils.a());
    Intent localIntent = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
    localObject2 = PreloadManager.a((String)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD);
    ((StringBuilder)localObject2).append((String)localObject1);
    if ((FileUtils.fileExistsAndNotEmpty(((StringBuilder)localObject2).toString())) && (PreloadManager.a().b((String)localObject1) != null))
    {
      localBundle.putString("read_in_joy_from_cache", (String)localObject1);
      if (!paramReadInJoyBaseAdapter.a(paramInt, paramAbsBaseArticleInfo.mArticleID))
      {
        paramAbsBaseArticleInfo = PreloadManager.a();
        if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5))
        {
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.a((String)localObject1);
          if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.size() > 0)) {
            localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramAbsBaseArticleInfo.get(0)).jdField_a_of_type_JavaLangString);
          } else {
            localBundle.putString("preload_iamge_url", null);
          }
        }
        else
        {
          paramReadInJoyBaseAdapter = paramAbsBaseArticleInfo.a((String)localObject1);
          if ((paramReadInJoyBaseAdapter != null) && (paramReadInJoyBaseAdapter.size() > 0))
          {
            ThreadManager.post(new RIJJumpUtils.4(paramAbsBaseArticleInfo, (PreloadManager.ImgStruct)paramReadInJoyBaseAdapter.get(0)), 5, null, false);
            if (paramReadInJoyBaseAdapter.size() > 1) {
              localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramReadInJoyBaseAdapter.get(1)).jdField_a_of_type_JavaLangString);
            } else {
              localBundle.putString("preload_iamge_url", null);
            }
          }
        }
      }
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, 9991);
    ((IRIJWebArticleOptimizeUtil)QRoute.api(IRIJWebArticleOptimizeUtil.class)).usePendingTransition(paramActivity);
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mGalleryFeedsInfo != null) && (paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
    {
      paramAbsBaseArticleInfo = Uri.parse(paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8()).buildUpon();
      paramAbsBaseArticleInfo.appendQueryParameter("showComment", "1");
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
      a(paramContext, paramAbsBaseArticleInfo);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("jumpToGallery url=");
        paramContext.append(paramAbsBaseArticleInfo);
        QLog.e("RIJJumpUtils", 2, paramContext.toString());
      }
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    a(paramContext, paramAbsBaseArticleInfo, paramInt, false, 0, false);
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("jumpNewSocialSecondPage: ");
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo);
    ((StringBuilder)localObject1).append(" type: ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" shallNotReport: ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" from: ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" jumpType: ");
    ((StringBuilder)localObject1).append(paramInt3);
    QLog.d("RIJJumpUtils", 1, ((StringBuilder)localObject1).toString());
    if (paramContext != null)
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      a = paramAbsBaseArticleInfo;
      localObject1 = a(a(paramAbsBaseArticleInfo, paramInt1), paramAbsBaseArticleInfo, paramInt1, paramInt3);
      Bundle localBundle = new Bundle();
      if (ReadInJoyWebDataManager.a(paramAbsBaseArticleInfo))
      {
        localObject2 = ReadInJoyWebDataManager.a();
        boolean bool;
        if ((paramInt1 != 1) && (paramInt1 != 3)) {
          bool = false;
        } else {
          bool = true;
        }
        ((ReadInJoyWebDataManager)localObject2).a(paramAbsBaseArticleInfo, bool, (String)localObject1);
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("jumpNewSocialSecondPage, url:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("RIJJumpUtils", 1, ((StringBuilder)localObject2).toString());
      a(paramContext, (String)localObject1, localBundle);
      if (!paramBoolean) {
        a(paramAbsBaseArticleInfo, paramInt1, paramInt2);
      }
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean2) {
      i = 2;
    } else {
      i = 0;
    }
    a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramBoolean1, paramInt2, i);
  }
  
  @Deprecated
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramReadInJoyBaseAdapter == null) {
        return;
      }
      int j = paramReadInJoyBaseAdapter.a();
      int i;
      if (paramAbsBaseArticleInfo.hasChannelInfo()) {
        i = paramAbsBaseArticleInfo.mChannelInfoId;
      } else {
        i = 0;
      }
      int k = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true;
      paramReadInJoyBaseAdapter = RIJFeedsType.c(paramAbsBaseArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), j, i), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, i));
      long l = j;
      Object localObject1 = ReadinjoyReportUtils.b(l);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, (String)localObject1, (String)localObject1, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), j, i, k, NetworkUtil.isWifiConnected(paramContext), paramReadInJoyBaseAdapter, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject1, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), j, i, k, NetworkUtil.isWifiConnected(paramContext), paramReadInJoyBaseAdapter, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo));
      paramContext = new ArrayList();
      paramReadInJoyBaseAdapter = new ReportInfo();
      paramReadInJoyBaseAdapter.mUin = RIJQQAppInterfaceUtil.a();
      paramReadInJoyBaseAdapter.mSource = 0;
      paramReadInJoyBaseAdapter.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
      paramReadInJoyBaseAdapter.mChannelId = j;
      paramReadInJoyBaseAdapter.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
      paramReadInJoyBaseAdapter.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
      paramReadInJoyBaseAdapter.mOperation = 1;
      paramReadInJoyBaseAdapter.mServerContext = paramAbsBaseArticleInfo.mServerContext;
      paramReadInJoyBaseAdapter.mReadTimeLength = -1;
      paramReadInJoyBaseAdapter.mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
      if ((paramAbsBaseArticleInfo != null) && (!UGRuleManager.c(paramAbsBaseArticleInfo)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramAbsBaseArticleInfo))) {
        paramReadInJoyBaseAdapter.noDifferenceJump = 1;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        localObject1 = new FeedsReportData();
        ((FeedsReportData)localObject1).jdField_a_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
          ((FeedsReportData)localObject1).jdField_b_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        }
        ((FeedsReportData)localObject1).jdField_a_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        ((FeedsReportData)localObject1).jdField_b_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject2).next();
            if (localFeedsInfoUser != null) {
              ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
            }
          }
        }
        paramReadInJoyBaseAdapter.mFeedsReportData = ((FeedsReportData)localObject1);
      }
      localObject1 = ReadInJoySrtUtils.a().a();
      if (localObject1 != null) {
        paramReadInJoyBaseAdapter.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
      }
      paramContext.add(paramReadInJoyBaseAdapter);
      ReadInJoyLogicEngine.a().a(paramContext);
      RIJFeedsInsertUtil.a.b(l, paramAbsBaseArticleInfo);
    }
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    paramString = a(paramAbsBaseArticleInfo, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpTo |  scheme : ");
    localStringBuilder.append(paramString);
    QLog.d("RIJJumpUtils", 1, localStringBuilder.toString());
    a(paramAbsBaseArticleInfo, paramString);
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (!ReadInJoyChannelGuidingJumpUtils.a(paramContext, paramString)) {
        a(paramContext, paramString, null);
      }
      return;
    }
    QLog.d("RIJJumpUtils", 1, "context or scehme null");
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    a(paramContext, paramAbsBaseArticleInfo, 0, false, 0, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return;
      }
      Context localContext = paramContext;
      if ((paramContext instanceof BasePluginActivity))
      {
        paramContext = ((BasePluginActivity)paramContext).getOutActivity();
        localContext = paramContext;
        if (paramContext == null) {
          return;
        }
      }
      paramContext = new Bundle();
      paramContext.putString("url", paramString);
      paramContext.putBoolean("hide_operation_bar", true);
      paramString = new Intent(localContext, QQBrowserActivity.class);
      paramString.putExtras(paramContext);
      paramString.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131713039));
      localContext.startActivity(paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString2.contains("searchbox=$SEARCHBOX$")) {
        paramString2 = paramString2.replace("$SEARCHBOX$", "native");
      } else {
        paramString2 = URLUtil.a(paramString2, "searchbox", "native");
      }
      paramString1 = KDSearchResultFragment.a(paramContext, paramString1, URLUtil.a(URLUtil.a(paramString2, "q"), "q", paramString1));
      paramString2 = Aladdin.getConfig(313);
      if (paramString2 != null) {
        paramString1.putExtra("searchbox_style", paramString2.getIntegerFromString("SearchBox_SearchStyle", -1));
      }
      paramString2 = Aladdin.getConfig(337);
      if (paramString2 != null)
      {
        int i = paramString2.getIntegerFromString("search_ajax_switch", 0);
        paramString2 = paramString2.getString("url_prefix", "https://so.html5.qq.com/page/real").replaceAll("\\s*", "").split(",");
        paramString1.putExtra("search_ajax_switch", i);
        paramString1.putExtra("url_prefix", paramString2);
      }
      PublicFragmentActivityForTool.b(paramContext, paramString1, KDSearchResultFragment.class);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJJumpUtils", 2, "argument is empty");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString3)) {
      localBundle.putString("param", paramString3);
    }
    ViolaAccessHelper.a(paramContext, paramString1, paramString2, localBundle);
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject, RIJUserLevelDialog.DialogClick paramDialogClick)
  {
    if ((paramJSONObject != null) && (paramContext != null))
    {
      RIJUserLevelDialog.DialogSettingInfo localDialogSettingInfo = new RIJUserLevelDialog.DialogSettingInfo();
      localDialogSettingInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
      localDialogSettingInfo.b = paramJSONObject.optString("titleColor");
      localDialogSettingInfo.c = paramJSONObject.optString("text");
      localDialogSettingInfo.d = paramJSONObject.optString("textColor");
      localDialogSettingInfo.g = paramJSONObject.optString("rBtnText");
      localDialogSettingInfo.h = paramJSONObject.optString("rBtnTextColor");
      localDialogSettingInfo.e = paramJSONObject.optString("lBtnText");
      localDialogSettingInfo.f = paramJSONObject.optString("lBtnTextColor");
      localDialogSettingInfo.i = paramJSONObject.optString("extraParams");
      localDialogSettingInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAccountRIJUserLevelDialog$DialogClick = paramDialogClick;
      ReadInJoyUtils.a(paramContext, localDialogSettingInfo);
      QLog.d("RIJJumpUtils", 1, "openLevelDialog !");
      return;
    }
    QLog.d("RIJJumpUtils", 1, "showLevelDialog error! null");
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    int i;
    if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) || (RIJFeedsType.f(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)))
    {
      Object localObject2;
      String str;
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        if (paramInt1 == 1) {
          ((JSONObject)localObject1).put("feeds_source", paramAbsBaseArticleInfo.mSubscribeID);
        } else {
          ((JSONObject)localObject1).put("feeds_source", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
        }
        ((JSONObject)localObject1).put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(RIJFeedsType.a(paramAbsBaseArticleInfo));
        ((JSONObject)localObject1).put("feeds_type", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(RIJAppSetting.a());
        ((JSONObject)localObject1).put("kandian_mode", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(RIJTransMergeKanDianReport.a());
        ((JSONObject)localObject1).put("tab_source", ((StringBuilder)localObject2).toString());
        if (paramInt2 > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(paramInt2);
          ((JSONObject)localObject1).put("entry_mode", ((StringBuilder)localObject2).toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mChannelID);
        ((JSONObject)localObject1).put("channel_id", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mAlgorithmID);
        ((JSONObject)localObject1).put("algorithm_id", ((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).toString();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str = "";
      }
      if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
        localObject2 = "0X800935D";
      } else {
        localObject2 = "0X8007B64";
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils;
      long l1;
      long l2;
      Object localObject3;
      if (i != 0)
      {
        if (RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo)) {
          return;
        }
        try
        {
          localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
          l2 = paramAbsBaseArticleInfo.mFeedId;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mStrategyId);
          localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l1), (String)localObject2, (String)localObject2, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject3).toString(), str, false);
          return;
        }
        catch (Throwable paramAbsBaseArticleInfo)
        {
          paramAbsBaseArticleInfo.printStackTrace();
          return;
        }
      }
      try
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject3 = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = paramAbsBaseArticleInfo.mFeedId;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject3, (String)localObject2, (String)localObject2, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), str, false);
        return;
      }
      catch (Throwable paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramString.contains("mqqapi://readinjoy/open")) && (paramString.contains("target=4")))
      {
        paramAbsBaseArticleInfo.mJumpType = 2;
        return;
      }
      paramAbsBaseArticleInfo.mJumpType = 1;
    }
  }
  
  public static void a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ReadInJoyConstants.k);
    ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramString).getBytes(), 2));
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (paramAbsBaseArticleInfo != null) {
      paramString = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, (String)localObject, ReadinjoyReportUtils.d);
    }
    localObject = QBaseActivity.sTopActivity;
    paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
    if (localObject == null) {
      paramAbsBaseArticleInfo = BaseApplicationImpl.getContext();
    }
    ReadInJoyUtils.a(paramAbsBaseArticleInfo, paramString);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("jump2SelfPage: ");
    paramAbsBaseArticleInfo.append(paramString);
    QLog.d("RIJJumpUtils", 1, paramAbsBaseArticleInfo.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, NativeWebVideoCoverGetCallback paramNativeWebVideoCoverGetCallback)
  {
    ThreadManager.executeOnNetWorkThread(new RIJJumpUtils.3(paramString4, paramString3, paramString2, paramString1, paramNativeWebVideoCoverGetCallback));
  }
  
  public static boolean a(@NonNull Context paramContext, String paramString, int paramInt, @Nullable MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, paramInt, paramMiniAppLaunchListener);
    }
    return false;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = a(paramAbsBaseArticleInfo);
    return (i == 8) || (i == 7);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    String str = ProteusSupportUtil.a(paramAbsBaseArticleInfo);
    if ((!TextUtils.isEmpty(str)) && (paramContext != null))
    {
      if (UGRuleManager.a(str)) {
        a(paramContext, paramAbsBaseArticleInfo, str);
      } else {
        VideoFeedsHelper.a(BaseApplicationImpl.getApplication(), str);
      }
      paramContext = new StringBuilder();
      paramContext.append("tryJumpToUgUrl,title=");
      paramContext.append(paramAbsBaseArticleInfo.mTitle);
      QLog.d("RIJJumpUtils", 1, paramContext.toString());
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      paramString = URLUtil.a(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if ("1".equalsIgnoreCase((String)paramString.get("jump_android_hemera"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static Integer b(Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jumToWeb: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("RIJJumpUtils", 1, ((StringBuilder)localObject).toString());
    boolean bool = TextUtils.isEmpty(paramString);
    localObject = Integer.valueOf(12);
    if ((!bool) && (ViolaAccessHelper.c(paramString)))
    {
      ViolaAccessHelper.a(paramContext, null, ViolaAccessHelper.c(paramString), null);
      return localObject;
    }
    if (SearchUtils.a(paramString))
    {
      a(paramContext, SearchUtils.a(paramString), paramString);
      return localObject;
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("big_brother_source_key", a(0));
    if (!TextUtils.isEmpty(paramString))
    {
      ((Intent)localObject).putExtra("url", paramString);
      paramContext.startActivity((Intent)localObject);
    }
    return Integer.valueOf(11);
  }
  
  private static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo)) {
      return String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
    }
    return "";
  }
  
  private static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 6) && (paramInt != 8))
    {
      if ((paramInt != 1) && (paramInt != 3))
      {
        if ((paramInt != 2) && (paramInt != 4))
        {
          if (paramInt == 5)
          {
            paramAbsBaseArticleInfo = String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
          }
          else
          {
            if (paramInt == 7)
            {
              if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
              {
                paramAbsBaseArticleInfo = String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
                break label143;
              }
              if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID))
              {
                paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubscribeID;
                break label143;
              }
            }
            paramAbsBaseArticleInfo = "";
          }
        }
        else {
          paramAbsBaseArticleInfo = b(paramAbsBaseArticleInfo);
        }
      }
      else {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubscribeID;
      }
    }
    else {
      paramAbsBaseArticleInfo = c(paramAbsBaseArticleInfo);
    }
    label143:
    Object localObject = paramAbsBaseArticleInfo;
    if (paramAbsBaseArticleInfo == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public static String b(String paramString)
  {
    Object localObject1 = Aladdin.getConfig(199);
    Object localObject2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_schema", "");
    String str1 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_h5_android", "");
    String str2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_package_name", "");
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("${rowkey}", paramString).replace("${uin}", RIJQQAppInterfaceUtil.a());
    }
    localObject2 = str1;
    if (!TextUtils.isEmpty(str1)) {
      localObject2 = str1.replace("${rowkey}", paramString).replace("${uin}", RIJQQAppInterfaceUtil.a());
    }
    paramString = new StringBuilder();
    try
    {
      paramString.append("mqqapi://readinjoy/open?src_type=internal&target=4");
      paramString.append("&defaultURL=");
      paramString.append(URLEncoder.encode((String)localObject2, "utf-8"));
      paramString.append("&appSchema=");
      paramString.append(URLEncoder.encode((String)localObject1, "utf-8"));
      paramString.append("&appPackageName=");
      paramString.append(str2);
      paramString.append("&readinjoyNotDecodeUrl=1");
      paramString.append("&version=1");
      paramString.append("&isCancelJump=0");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNoDifferenceJumpToAppSchema schema: ");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.e("RIJJumpUtils", 1, ((StringBuilder)localObject1).toString());
      ReadInJoyHelper.g();
      paramString = paramString.toString();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNoDifferenceJumpToAppSchema UnsupportedEncodingException: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("RIJJumpUtils", 1, ((StringBuilder)localObject1).toString());
    }
    return "";
  }
  
  public static String b(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder(paramString);
        String str = paramAbsBaseArticleInfo.mVideoCoverUrl.toExternalForm();
        Map localMap = URLUtil.a(paramString);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramAbsBaseArticleInfo.busiType);
        localStringBuilder2.append("");
        localStringBuilder1.append(a(localMap, "videoType", localStringBuilder2.toString()));
        localStringBuilder1.append(a(localMap, "videoVid", paramAbsBaseArticleInfo.mVideoVid));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramAbsBaseArticleInfo.mVideoJsonWidth);
        localStringBuilder2.append("");
        localStringBuilder1.append(a(localMap, "videoWidth", localStringBuilder2.toString()));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramAbsBaseArticleInfo.mVideoJsonHeight);
        localStringBuilder2.append("");
        localStringBuilder1.append(a(localMap, "videoHeight", localStringBuilder2.toString()));
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramAbsBaseArticleInfo.mVideoDuration);
        localStringBuilder2.append("");
        localStringBuilder1.append(a(localMap, "videoDuration", localStringBuilder2.toString()));
        localStringBuilder1.append(a(localMap, "title", paramAbsBaseArticleInfo.mTitle));
        localStringBuilder1.append(a(localMap, "firstPagePicUrl", URLEncoder.encode(str, "UTF-8")));
        localStringBuilder1.append(a(localMap, "articleContentUrl", URLEncoder.encode(paramAbsBaseArticleInfo.mArticleContentUrl, "UTF-8")));
        localStringBuilder1.append(a(localMap, "subscribeName", paramAbsBaseArticleInfo.mSubscribeName));
        localStringBuilder1.append(a(localMap, "subscribeID", paramAbsBaseArticleInfo.mSubscribeID));
        localStringBuilder1.append(a(localMap, "readinjoyNotDecodeUrl", "1"));
        paramAbsBaseArticleInfo = localStringBuilder1.toString();
        return paramAbsBaseArticleInfo;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        QLog.d("RIJJumpUtils", 2, paramAbsBaseArticleInfo.getMessage());
      }
    }
    return paramString;
  }
  
  public static void b(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramActivity != null))
    {
      String str;
      if ((RIJBiuAndCommentAladdinUtils.f()) && (RIJFeedsType.R(paramAbsBaseArticleInfo))) {
        str = paramAbsBaseArticleInfo.getCardJumpUrl();
      } else {
        str = "";
      }
      if (!TextUtils.isEmpty(str))
      {
        a(paramActivity, str);
      }
      else if (paramAbsBaseArticleInfo.isPGCShortContent())
      {
        if (a(paramAbsBaseArticleInfo, paramActivity))
        {
          QLog.d("RIJJumpUtils", 1, "tryJumpToUgUrl: true");
        }
        else
        {
          QLog.d("RIJJumpUtils", 1, "short content redirectToOtherPage!");
          PGCShortContentUtils.a(paramActivity, paramAbsBaseArticleInfo);
        }
      }
      else if (RIJFeedsType.Q(paramAbsBaseArticleInfo))
      {
        VideoFeedsHelper.a(paramActivity, null, 28, paramAbsBaseArticleInfo);
      }
      else if (RIJFeedsType.S(paramAbsBaseArticleInfo))
      {
        QLog.d("RIJJumpUtils", 1, "startWebFastActivity");
        a(paramActivity, paramAbsBaseArticleInfo);
      }
      else
      {
        QLog.d("RIJJumpUtils", 1, "jumpNewSocialSecondPage");
        a(paramActivity, paramAbsBaseArticleInfo, 7, false, 0, false);
      }
      paramActivity = new StringBuilder();
      paramActivity.append("clickCommentBiuCardWrapper,jumpUrl=");
      paramActivity.append(str);
      QLog.d("RIJJumpUtils", 1, paramActivity.toString());
      return;
    }
    QLog.d("RIJJumpUtils", 1, "clickCommentBiuCardWrapper error!");
  }
  
  private static void b(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new RIJJumpUtils.5(paramActivity, paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter, paramInt));
  }
  
  public static void b(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramContext != null))
    {
      if ((paramInt == 6) && (RIJBiuAndCommentAladdinUtils.e()))
      {
        if ((paramAbsBaseArticleInfo.isCardJumpUrlAvailable == 1) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.getCardJumpUrl())))
        {
          str = paramAbsBaseArticleInfo.getCardJumpUrl();
          break label83;
        }
      }
      else if ((paramInt == 8) && (RIJBiuAndCommentAladdinUtils.g()) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.commentBtnJumpUrl)))
      {
        str = paramAbsBaseArticleInfo.commentBtnJumpUrl;
        break label83;
      }
      String str = "";
      label83:
      if (TextUtils.isEmpty(str)) {
        a(paramContext, paramAbsBaseArticleInfo, paramInt, false, 0, false);
      } else {
        a(paramContext, str);
      }
      paramContext = new StringBuilder();
      paramContext.append("clickCommentBiuCard,clickType=");
      paramContext.append(paramInt);
      paramContext.append(" ,jumpUrl=");
      paramContext.append(str);
      QLog.d("RIJJumpUtils", 1, paramContext.toString());
      return;
    }
    QLog.d("RIJJumpUtils", 1, "clickCommentBiuCard error!");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = Uri.parse(paramString);
      if (!TextUtils.isEmpty(((Uri)localObject).getPath()))
      {
        String str;
        if (((Uri)localObject).getPath().equals("/mqq/vue/wendadetail"))
        {
          localBundle = new Bundle();
          localBundle.putString("url", paramString);
          str = ((Uri)localObject).getQuery();
          localObject = "https://kandian.qq.com/viola/bundle_wendadetail.js?v_bid=3256&hideNav=1&statusColor=1";
          if (!TextUtils.isEmpty(str))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https://kandian.qq.com/viola/bundle_wendadetail.js?v_bid=3256&hideNav=1&statusColor=1");
            ((StringBuilder)localObject).append("&");
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
          }
          ViolaAccessHelper.a(paramContext, HardCodeUtil.a(2131712802), (String)localObject, localBundle, new RIJJumpUtils.1(paramContext, paramString));
          return;
        }
        if (((Uri)localObject).getPath().equals("/mqq/vue/wenda"))
        {
          localBundle = new Bundle();
          localBundle.putString("url", paramString);
          str = ((Uri)localObject).getQuery();
          localObject = "https://kandian.qq.com/viola/bundle_wenda.js?v_bid=3256&hideNav=1&statusColor=1";
          if (!TextUtils.isEmpty(str))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https://kandian.qq.com/viola/bundle_wenda.js?v_bid=3256&hideNav=1&statusColor=1");
            ((StringBuilder)localObject).append("&");
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
          }
          ViolaAccessHelper.a(paramContext, HardCodeUtil.a(2131712778), (String)localObject, localBundle, new RIJJumpUtils.2(paramContext, paramString));
          return;
        }
      }
      a(paramContext, paramString, localBundle);
    }
  }
  
  public static boolean b(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      paramString = URLUtil.a(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if ("5".equalsIgnoreCase((String)paramString.get("target"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null)) {
      return String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
    }
    return "";
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (b(paramString)) && (paramString.contains("needsconcat=1"));
  }
  
  public static boolean d(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      paramString = Uri.parse(paramString);
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString.getHost()))
      {
        bool1 = bool2;
        if (paramString.getHost().equals("kandian.qq.com"))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString.getPath())) {
            if (!paramString.getPath().equals("/mqq/vue/wendadetail"))
            {
              bool1 = bool2;
              if (!paramString.getPath().equals("/mqq/vue/wenda")) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils
 * JD-Core Version:    0.7.0.1
 */