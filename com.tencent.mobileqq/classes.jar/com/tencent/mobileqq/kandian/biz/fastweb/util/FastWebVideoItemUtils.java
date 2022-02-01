package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class FastWebVideoItemUtils
{
  private static Bundle a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Bundle localBundle = new Bundle();
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1)
    {
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramAbsBaseArticleInfo.mSubscribeID);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramAbsBaseArticleInfo.mSubscribeName);
    }
    else if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
    {
      if (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a);
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a);
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", ((StringBuilder)localObject).toString());
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaLangString);
      if (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)) {
        localBundle.putString("VIDEO_URL", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
      }
    }
    else
    {
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramAbsBaseArticleInfo.thirdUin);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramAbsBaseArticleInfo.thirdUinName);
    }
    if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
    {
      localBundle.putString("VIDEO_H5_URL", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle.putString("VIDEO_CREATE_TIME", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
    }
    else
    {
      localBundle.putString("VIDEO_H5_URL", paramAbsBaseArticleInfo.mArticleContentUrl);
      localBundle.putString("VIDEO_CREATE_TIME", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(paramAbsBaseArticleInfo.mTime, true));
    }
    localBundle.putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
    localBundle.putString("VIDEO_WIDTH", String.valueOf(paramVideoPlayParam.jdField_c_of_type_Int));
    localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramVideoPlayParam.jdField_d_of_type_Int));
    localBundle.putString("VIDEO_VID", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    localBundle.putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
    localBundle.putString("VIDEO_TITLE", paramAbsBaseArticleInfo.mTitle);
    localBundle.putString("VIDEO_SUMMARY", paramAbsBaseArticleInfo.mTitle);
    if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
    {
      localBundle.putString("VIDEO_ARTICLE_ID", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_FEED_ID", paramAbsBaseArticleInfo.mFeedId);
      localBundle.putInt("VIDEO_FEED_TYPE", paramAbsBaseArticleInfo.mFeedType);
      localBundle.putString("VIDEO_TITLE", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
    }
    else
    {
      localBundle.putString("VIDEO_ARTICLE_ID", paramAbsBaseArticleInfo.innerUniqueID);
      localBundle.putString("VIDEO_TITLE", paramAbsBaseArticleInfo.mTitle);
    }
    boolean bool;
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle.putString("VIDEO_RECOMMEND_REASON", paramAbsBaseArticleInfo.mRecommentdReason);
    localBundle.putBoolean("isFromKandian", true);
    localBundle.putLong("channelID", paramAbsBaseArticleInfo.mChannelID);
    localBundle.putLong("algorithmID", paramAbsBaseArticleInfo.mAlgorithmID);
    localBundle.putString("innderId", paramAbsBaseArticleInfo.innerUniqueID);
    localBundle.putLong("strategyId", paramAbsBaseArticleInfo.mStrategyId);
    localBundle.putInt("interactionType", TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true);
    localBundle.putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
    localBundle.putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
    localBundle.putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
    localBundle.putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_g_of_type_JavaLangString);
    localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_f_of_type_Int);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("TINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
    ((Bundle)localObject).putInt("PREVIEW_START_POSI", VideoPlayUtils.a(0, paramVideoPlayParam.jdField_b_of_type_Int));
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_c_of_type_Int);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_d_of_type_Int);
    ((Bundle)localObject).putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
    ((Bundle)localObject).putString("source_puin", paramAbsBaseArticleInfo.mSubscribeID);
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1)
    {
      ((Bundle)localObject).putString("ACCOUNT_UIN", paramAbsBaseArticleInfo.mSubscribeID);
      ((Bundle)localObject).putString("ACCOUNT_NAME", paramAbsBaseArticleInfo.mSubscribeName);
    }
    else
    {
      ((Bundle)localObject).putString("ACCOUNT_UIN", paramAbsBaseArticleInfo.thirdUin);
      ((Bundle)localObject).putString("ACCOUNT_NAME", paramAbsBaseArticleInfo.thirdUinName);
    }
    ((Bundle)localObject).putInt("TYPE", paramVideoPlayParam.jdField_f_of_type_Int);
    ((Bundle)localObject).putString("ARTICLE_ID", paramAbsBaseArticleInfo.innerUniqueID);
    ((Bundle)localObject).putInt("layout_item", 5);
    ((Bundle)localObject).putBoolean("video_url_load", false);
    ((Bundle)localObject).putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putString("detail_url", paramAbsBaseArticleInfo.mArticleContentUrl);
    ((Bundle)localObject).putString("video_url", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("title", paramAbsBaseArticleInfo.mTitle);
    ((Bundle)localObject).putString("req_create_time", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(paramAbsBaseArticleInfo.mTime));
    ((Bundle)localObject).putString("brief_key", paramAbsBaseArticleInfo.mTitle);
    ((Bundle)localObject).putInt("req_type", 140);
    localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject)).getBytes());
    return localBundle;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://puui.qpic.cn/qqvideo_ori/0/");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_496_280/0");
    localObject = ((StringBuilder)localObject).toString();
    RIJJumpUtils.a(paramString1, paramString3, paramString2, paramString4, new FastWebVideoItemUtils.1());
    return localObject;
  }
  
  public static void a(Activity paramActivity, VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("open full play activity, articleID : ");
      ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject1).append(", playPosition : ");
      ((StringBuilder)localObject1).append(paramVideoPlayParam.jdField_d_of_type_Long);
      ((StringBuilder)localObject1).append(",vid : ");
      ((StringBuilder)localObject1).append(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = a(paramVideoPlayParam, paramAbsBaseArticleInfo);
    if (paramVideoPlayParam.jdField_f_of_type_Int == 2)
    {
      localObject2 = ThirdVideoManager.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("VIDEO_THIRD_VID_URL", ((VideoUrlInfo)localObject2).a);
        ((Bundle)localObject1).putLong("VIDEO_THIRD_VID_URL_TIME", ((VideoUrlInfo)localObject2).b);
      }
    }
    int i = 1;
    ((Bundle)localObject1).putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
    ((Bundle)localObject1).putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
    ((Bundle)localObject1).putInt("VIDEO_FROM_TYPE", 10);
    Object localObject2 = new Intent(paramActivity, VideoFeedsPlayActivity.class);
    ((Intent)localObject2).addFlags(536870912);
    if (BaseApplicationImpl.sProcessId != 1)
    {
      ((Bundle)localObject1).putBoolean("param_needSmooth", VideoVolumeControl.getInstance().needSmoothVideo());
      VideoVolumeControl.getInstance().setDynamicPauseReceive(true);
      ((Bundle)localObject1).putBoolean("param_needAlertInXg", VideoAutoPlayController.isAllowPlayInXgNetwork());
    }
    if (paramVideoPlayParam.jdField_f_of_type_Int == 6) {
      ((Bundle)localObject1).putParcelable("VIDEO_ARTICLE_INFO_FOR_BIU", paramAbsBaseArticleInfo);
    }
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    if ((1 != paramAbsBaseArticleInfo.mVideoType) && (0L != paramAbsBaseArticleInfo.mChannelID)) {
      i = 9091;
    }
    ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramAbsBaseArticleInfo.mJsonVideoList);
    int j = 0;
    try
    {
      boolean bool = MultiVideoConfigHandler.a(((Bundle)localObject1).getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(((Bundle)localObject1).getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(((Bundle)localObject1).getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(((Bundle)localObject1).getString("VIDEO_TIME")).intValue());
      j = bool;
    }
    catch (Exception paramVideoPlayParam)
    {
      label355:
      break label355;
    }
    if (j != 0)
    {
      paramVideoPlayParam = new Intent();
      paramVideoPlayParam.putExtras((Bundle)localObject1);
      MultiVideoHelper.a(paramActivity, paramVideoPlayParam, i);
      paramActivity.overridePendingTransition(2130772023, 2130772025);
      return;
    }
    paramActivity.startActivityForResult((Intent)localObject2, i);
    paramActivity.overridePendingTransition(2130772112, 2130772113);
  }
  
  public static void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_Long = paramAbsBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_e_of_type_Long = paramAbsBaseArticleInfo.mXGFileSize;
    localVideoPlayParam.h = paramAbsBaseArticleInfo.thirdUin;
    localVideoPlayParam.i = paramAbsBaseArticleInfo.thirdUinName;
    localVideoPlayParam.k = paramAbsBaseArticleInfo.mSubscribeID;
    localVideoPlayParam.jdField_g_of_type_Int = paramAbsBaseArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_g_of_type_Long = paramAbsBaseArticleInfo.mAlgorithmID;
    ReadInJoyVideoReportData localReadInJoyVideoReportData = new ReadInJoyVideoReportData();
    localReadInJoyVideoReportData.a = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    localReadInJoyVideoReportData.jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
    localVideoPlayParam.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.mVideoVid;
    localVideoPlayParam.jdField_f_of_type_Int = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.jdField_c_of_type_Int = paramAbsBaseArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.jdField_d_of_type_Int = paramAbsBaseArticleInfo.mVideoJsonHeight;
    localReadInJoyVideoReportData.jdField_b_of_type_Int = paramAbsBaseArticleInfo.busiType;
    localVideoPlayParam.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mVideoDuration;
    String str;
    if (paramAbsBaseArticleInfo.mVideoCoverUrl == null) {
      str = null;
    } else {
      str = paramAbsBaseArticleInfo.mVideoCoverUrl.getFile();
    }
    localVideoPlayParam.jdField_b_of_type_JavaLangString = str;
    localVideoPlayParam.j = paramAbsBaseArticleInfo.innerUniqueID;
    localReadInJoyVideoReportData.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.mVideoVid;
    localVideoPlayParam.a = localReadInJoyVideoReportData;
    localVideoPlayParam.jdField_d_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdIcon;
    localVideoPlayParam.jdField_e_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdName;
    localVideoPlayParam.jdField_f_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdAction;
    new ReportInfo.VideoExtraRepoerData().a = 409409;
    a(paramActivity, localVideoPlayParam, paramAbsBaseArticleInfo);
  }
  
  public static void a(List<BaseData> paramList, String paramString, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (BaseData)paramList.next();
      if ((localObject instanceof ProteusItemData))
      {
        localObject = (ProteusItemData)localObject;
        if (((ProteusItemData)localObject).z == 3) {
          a(((ProteusItemData)localObject).c, paramString, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("mVideoJsonWidth");
        int j = paramJSONObject.getInt("mVideoJsonHeight");
        String str = paramJSONObject.getString("mVideoVid");
        int k = paramJSONObject.getInt("busiType");
        paramJSONObject = paramJSONObject.getString("mVideoCoverUrl");
        BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
        localBaseArticleInfo.mVideoJsonWidth = i;
        localBaseArticleInfo.mVideoJsonHeight = j;
        localBaseArticleInfo.mVideoVid = str;
        localBaseArticleInfo.busiType = k;
        localBaseArticleInfo.mVideoCoverUrl = RIJConvertString2URL.a(paramJSONObject);
        localBaseArticleInfo.mArticleContentUrl = paramAbsBaseArticleInfo.mArticleContentUrl;
        localBaseArticleInfo.mTitle = paramAbsBaseArticleInfo.mTitle;
        paramJSONObject = new JSONObject();
        if (paramFastWebArticleInfo != null)
        {
          localBaseArticleInfo.thirdIcon = paramFastWebArticleInfo.jdField_g_of_type_JavaLangString;
          localBaseArticleInfo.thirdName = paramFastWebArticleInfo.jdField_e_of_type_JavaLangString;
          localBaseArticleInfo.thirdUin = String.valueOf(paramFastWebArticleInfo.jdField_e_of_type_Long);
          if (paramFastWebArticleInfo.a())
          {
            paramJSONObject = "2";
            paramJSONObject = RIJTransMergeKanDianReport.a(paramActivity, paramAbsBaseArticleInfo, 0, paramJSONObject);
            localBaseArticleInfo.innerUniqueID = paramFastWebArticleInfo.j;
          }
        }
        else
        {
          paramJSONObject.put("video_rowkey", str);
          ReportUtil.a(paramAbsBaseArticleInfo, "0X800898F", paramJSONObject.toString());
          a(paramActivity, localBaseArticleInfo);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("handleVideoClick error! msg=");
        paramActivity.append(paramJSONObject);
        QLog.d("FastWebVideoItemUtils", 1, paramActivity.toString());
        return;
      }
      paramJSONObject = "1";
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2)
  {
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramJSONObject.put("mVideoJsonWidth", paramInt1);
        paramJSONObject.put("mVideoJsonHeight", paramInt2);
        paramJSONObject.put("mVideoCoverUrl", paramString);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramString = new StringBuilder();
        paramString.append("updateVideoInfo error! msg=");
        paramString.append(paramJSONObject);
        QLog.d("FastWebVideoItemUtils", 1, paramString.toString());
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    try
    {
      paramJSONObject.put("articleImageUrl", paramString1);
      paramJSONObject.put("play_icon", "video_play_icon");
      paramJSONObject.put("style_ID", "ReadInjoy_article_video_cell");
      paramJSONObject.put("lineup", "0");
      paramJSONObject.put("vedio_rowkey", paramString2);
      paramJSONObject.put("mVideoVid", paramString2);
      paramJSONObject.put("busiType", paramInt3);
      a(paramJSONObject, paramString1, paramInt1, paramInt2);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramString1 = new StringBuilder();
      paramString1.append("insertDynamicData error! msg=");
      paramString1.append(paramJSONObject);
      QLog.d("FastWebVideoItemUtils", 1, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebVideoItemUtils
 * JD-Core Version:    0.7.0.1
 */