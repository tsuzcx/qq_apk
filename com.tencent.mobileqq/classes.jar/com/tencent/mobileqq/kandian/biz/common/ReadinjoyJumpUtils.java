package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager.ImgStruct;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadinjoyJumpUtils
{
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (RIJFeedsType.c(paramAbsBaseArticleInfo)) {
        return 3;
      }
      if (RIJFeedsType.a(paramAbsBaseArticleInfo)) {
        return 2;
      }
      return 0;
    }
    throw new NullPointerException("article info is null");
  }
  
  public static Intent a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramContext = new Intent(paramContext, VideoFeedsPlayActivity.class);
    paramContext.addFlags(536870912);
    paramContext.putExtra("VIDEO_THIRD_ICON", paramAbsBaseArticleInfo.thirdIcon);
    paramContext.putExtra("VIDEO_THIRD_NAME", paramAbsBaseArticleInfo.thirdName);
    paramContext.putExtra("VIDEO_THIRD_ACTION", paramAbsBaseArticleInfo.thirdAction);
    paramContext.putExtra("VIDEO_THIRD_URL", paramAbsBaseArticleInfo.mThirdVideoURL);
    paramContext.putExtra("VIDEO_THRID_URL_EXPIRE_TIME", paramAbsBaseArticleInfo.mThirdVideoURLExpireTime);
    paramContext.putExtra("VIDEO_ARTICLE_ID", paramAbsBaseArticleInfo.innerUniqueID);
    paramContext.putExtra("VIDEO_ARTICLE_BUSITYPE", paramAbsBaseArticleInfo.busiType);
    paramContext.putExtra("VIDEO_VID", paramAbsBaseArticleInfo.mVideoVid);
    paramContext.putExtra("VIDEO_WIDTH", String.valueOf(paramAbsBaseArticleInfo.mVideoJsonWidth));
    paramContext.putExtra("VIDEO_HEIGHT", String.valueOf(paramAbsBaseArticleInfo.mVideoJsonHeight));
    paramContext.putExtra("VIDEO_TIME", String.valueOf(paramAbsBaseArticleInfo.mVideoDuration));
    paramContext.putExtra("VIDEO_TITLE", paramAbsBaseArticleInfo.mTitle);
    paramContext.putExtra("VIDEO_COVER", paramAbsBaseArticleInfo.mVideoCoverUrl.getFile());
    paramContext.putExtra("VIDEO_H5_URL", paramAbsBaseArticleInfo.mArticleContentUrl);
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_NAME", paramAbsBaseArticleInfo.mSubscribeName);
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_UIN", paramAbsBaseArticleInfo.publishUin);
    paramContext.putExtra("VIDEO_SUBS_TEXT", paramAbsBaseArticleInfo.mVideoArticleSubsText);
    paramContext.putExtra("VIDEO_SUBS_COLOR", paramAbsBaseArticleInfo.mVideoArticleSubsColor);
    int i = paramAbsBaseArticleInfo.busiType;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    paramContext.putExtra("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    paramContext.putExtra("video_url_load", false);
    paramContext.putExtra("image_url_remote", paramAbsBaseArticleInfo.getVideoCoverURL().getFile());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAbsBaseArticleInfo.mArticleContentUrl);
    localStringBuilder.append("&sourcefrom=0");
    paramContext.putExtra("detail_url", localStringBuilder.toString());
    paramContext.putExtra("video_url", paramAbsBaseArticleInfo.getVideoVid());
    paramContext.putExtra("title", paramAbsBaseArticleInfo.mTitle);
    paramContext.putExtra("req_create_time", ReadInJoyTimeUtils.INSTANCE.getDateTimeString(paramAbsBaseArticleInfo.mTime));
    paramContext.putExtra("brief_key", paramAbsBaseArticleInfo.mTitle);
    paramContext.putExtra("KEY_VIDEO_JSON_LIST", paramAbsBaseArticleInfo.mJsonVideoList);
    return paramContext;
  }
  
  public static void a(Intent paramIntent)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject == null) {
      return;
    }
    KandianRedDotInfo localKandianRedDotInfo = ((KandianMergeManager)((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).e();
    if (localKandianRedDotInfo == null)
    {
      QLog.d("ReadinjoyJumpActivity", 2, "redDot info is null");
      return;
    }
    localObject = localKandianRedDotInfo.getMessageRecord();
    int j;
    if ((localObject instanceof MessageForStructing)) {
      try
      {
        localObject = (MessageForStructing)localObject;
        if ((((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mExtraData)))
        {
          localObject = new JSONObject(((MessageForStructing)localObject).structingMsg.mExtraData);
          j = ((JSONObject)localObject).getInt("jump_content_page");
          label148:
          label150:
          try
          {
            localObject = ((JSONObject)localObject).optString("channel_id", "0");
          }
          catch (Exception localException2) {}
        }
      }
      catch (Exception localException3)
      {
        j = 0;
      }
    }
    try
    {
      i = Integer.valueOf((String)localObject).intValue();
    }
    catch (Exception localException4)
    {
      ArrayList localArrayList;
      break label148;
    }
    try
    {
      paramIntent.putExtra("arg_channel_cover_id", i);
    }
    catch (Exception localException5)
    {
      break label150;
    }
    int i = 0;
    int k = j;
    int m = i;
    if (j == 0)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("push disallow jump content page, id : ");
        ((StringBuilder)localObject).append(localKandianRedDotInfo.articleIDList);
        QLog.d("ReadinjoyJumpActivity", 1, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Exception localException1) {}
      i = 0;
      localException3.printStackTrace();
      QLog.d("ReadinjoyJumpActivity", 2, "parse jump info config value error !");
      k = j;
      m = i;
      break label252;
      QLog.d("ReadinjoyJumpActivity", 2, "redPntMsg is null!");
      k = 0;
      m = 0;
    }
    label252:
    localArrayList = localKandianRedDotInfo.articleIDList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramIntent.putExtra("jump_article_param_ids", (Serializable)localArrayList.get(0));
      paramIntent.putExtra("jump_activity_launch_from", 0);
      paramIntent.putExtra("jump_activity_launch_channel_id", m);
    }
    paramIntent = new StringBuilder();
    paramIntent.append("add lock screen jump intent, ids :  ");
    paramIntent.append(localArrayList);
    paramIntent.append(" channelID:");
    paramIntent.append(m);
    paramIntent.append(" jumpType:");
    paramIntent.append(k);
    QLog.d("ReadinjoyJumpActivity", 1, paramIntent.toString());
  }
  
  public static Intent b(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.a(paramAbsBaseArticleInfo.mArticleContentUrl, paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo))
    {
      localObject1 = ReadInJoyLogicEngine.a().d();
      if (localObject1 != null) {
        ((FastWebModule)localObject1).a(paramAbsBaseArticleInfo.mArticleContentUrl, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID), paramAbsBaseArticleInfo.mSubscribeID, 1, null);
      }
      paramContext = new Intent(paramContext, FastWebActivity.class);
      paramContext.putExtra("fast_web_article_info", paramAbsBaseArticleInfo);
      paramContext.putExtra("fast_web_from_channel_id", paramAbsBaseArticleInfo.mChannelID);
      paramContext.putExtra("is_native_fast_web", true);
      return paramContext;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramAbsBaseArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo))
    {
      localObject1 = localObject2;
      if (!RIJItemViewTypeUtils.z(paramAbsBaseArticleInfo)) {
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.v.g.get(0)).c;
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
    localObject1 = localObject2;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAbsBaseArticleInfo))
    {
      localObject1 = localObject2;
      if (NetworkUtil.isWifiConnected(null))
      {
        if (((String)localObject2).contains("?"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("&");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("?");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("acttype=42");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    localBundle.putString("url", (String)localObject1);
    localBundle.putBoolean("hide_operation_bar", true);
    localBundle.putString("from", String.valueOf(53));
    localBundle.putString("subscribename", paramAbsBaseArticleInfo.mSubscribeName);
    localBundle.putString("row_key", paramAbsBaseArticleInfo.innerUniqueID);
    localBundle.putLong("articleid", paramAbsBaseArticleInfo.mArticleID);
    localBundle.putLong("recommendSeq", paramAbsBaseArticleInfo.mRecommendSeq);
    localBundle.putInt("channelid", (int)paramAbsBaseArticleInfo.mChannelID);
    localBundle.putInt("strategyid", paramAbsBaseArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramAbsBaseArticleInfo.mAlgorithmID);
    localBundle.putInt("articalChannelId", 9);
    localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
    localBundle.putBoolean("ip_connect", ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect());
    long l = System.currentTimeMillis();
    localBundle.putLong("startOpenPageTime", l);
    localBundle.putLong("click_time", l);
    localBundle.putLong("available_memory", DeviceInfoUtil.r());
    localBundle.putBoolean("preload_tool_white_list", RIJWebSearchUtils.a());
    localObject2 = new Intent(paramContext, ReadInJoyArticleDetailActivity.class);
    localObject1 = PreloadManager.d((String)localObject1);
    paramContext = (Context)localObject1;
    if (localObject1 == null) {
      paramContext = "";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD);
    ((StringBuilder)localObject1).append(paramContext);
    if ((FileUtils.fileExistsAndNotEmpty(((StringBuilder)localObject1).toString())) && (PreloadManager.a().f(paramContext) != null))
    {
      localBundle.putString("read_in_joy_from_cache", paramContext);
      if (!ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID))
      {
        paramAbsBaseArticleInfo = PreloadManager.a();
        if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5))
        {
          paramContext = paramAbsBaseArticleInfo.a(paramContext);
          if ((paramContext != null) && (paramContext.size() > 0)) {
            localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramContext.get(0)).a);
          } else {
            localBundle.putString("preload_iamge_url", null);
          }
        }
        else
        {
          paramContext = paramAbsBaseArticleInfo.a(paramContext);
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            ThreadManager.post(new ReadinjoyJumpUtils.1(paramAbsBaseArticleInfo, (PreloadManager.ImgStruct)paramContext.get(0)), 5, null, false);
            if (paramContext.size() > 1) {
              localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramContext.get(1)).a);
            } else {
              localBundle.putString("preload_iamge_url", null);
            }
          }
        }
      }
    }
    ((Intent)localObject2).putExtras(localBundle);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadinjoyJumpUtils
 * JD-Core Version:    0.7.0.1
 */