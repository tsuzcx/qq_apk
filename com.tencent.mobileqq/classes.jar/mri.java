import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VidUrl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class mri
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  public mri(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362730));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363006));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private Bundle a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label107:
    boolean bool;
    label256:
    label267:
    int i;
    label352:
    Bundle localBundle2;
    if (paramVideoPlayParam.jdField_e_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramVideoPlayParam.jdField_e_of_type_Int != 6) {
        break label865;
      }
      localBundle1.putString("VIDEO_H5_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_a_of_type_Int));
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramVideoPlayParam.jdField_c_of_type_Int));
      localBundle1.putString("VIDEO_VID", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      if (paramVideoPlayParam.jdField_e_of_type_Int != 6) {
        break label894;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
      localBundle1.putString("VIDEO_TITLE", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      if (paramVideoPlayParam.jdField_e_of_type_Int != 1) {
        break label919;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label925;
      }
      i = 0;
      localBundle1.putInt("interactionType", i);
      localBundle1.putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramVideoPlayParam.d);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_e_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_a_of_type_Int);
      localBundle2.putInt("PREVIEW_START_POSI", VideoPlayUtils.a(0, paramVideoPlayParam.jdField_a_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_b_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_c_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_a_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramVideoPlayParam.jdField_e_of_type_Int != 1) {
        break label930;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramVideoPlayParam.jdField_e_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl);
      localBundle2.putString("video_url", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", ReadInJoyTimeUtils.b(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(localBundle2)).getBytes());
      return localBundle1;
      if (paramVideoPlayParam.jdField_e_of_type_Int == 6)
      {
        if (ReadInJoyBaseAdapter.f((ArticleInfo)paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaLangString);
          if (ReadInJoyBaseAdapter.o((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label865:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(paramBaseArticleInfo.mTime, true));
      break label107;
      label894:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label256;
      label919:
      bool = false;
      break label267;
      label925:
      i = 1;
      break label352;
      label930:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_a_of_type_Long = paramArticleInfo.mArticleID;
    localVideoPlayParam.jdField_c_of_type_Long = paramArticleInfo.mXGFileSize;
    localVideoPlayParam.jdField_g_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localVideoPlayParam.h = paramArticleInfo.thirdUinName;
    localVideoPlayParam.j = paramArticleInfo.mSubscribeID;
    localVideoPlayParam.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_f_of_type_Long = paramArticleInfo.mAlgorithmID;
    ReadinjoyVideoReportData localReadinjoyVideoReportData = new ReadinjoyVideoReportData();
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    localVideoPlayParam.jdField_a_of_type_JavaLangString = paramArticleInfo.mVideoVid;
    localVideoPlayParam.jdField_e_of_type_Int = paramArticleInfo.busiType;
    localVideoPlayParam.jdField_b_of_type_Int = paramArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonHeight;
    localReadinjoyVideoReportData.jdField_a_of_type_Int = paramArticleInfo.busiType;
    localVideoPlayParam.jdField_a_of_type_Int = paramArticleInfo.mVideoDuration;
    if (paramArticleInfo.mVideoCoverUrl == null) {}
    for (String str = null;; str = paramArticleInfo.mVideoCoverUrl.getFile())
    {
      localVideoPlayParam.jdField_b_of_type_JavaLangString = str;
      localVideoPlayParam.i = paramArticleInfo.innerUniqueID;
      localReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = localReadinjoyVideoReportData;
      localVideoPlayParam.jdField_c_of_type_JavaLangString = paramArticleInfo.thirdIcon;
      localVideoPlayParam.d = paramArticleInfo.thirdName;
      localVideoPlayParam.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdAction;
      new ReportInfo.VideoExtraRepoerData().jdField_a_of_type_Int = 409409;
      a(localVideoPlayParam, paramArticleInfo);
      return;
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramVideoPlayParam.jdField_b_of_type_Long + ",vid : " + paramVideoPlayParam.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = a(paramVideoPlayParam, paramBaseArticleInfo);
    if (paramVideoPlayParam.jdField_e_of_type_Int == 2)
    {
      localObject = ThirdVideoManager.a(paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        localBundle.putString("VIDEO_THIRD_VID_URL", ((VidUrl)localObject).jdField_b_of_type_JavaLangString);
        localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((VidUrl)localObject).jdField_a_of_type_Long);
      }
    }
    localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
    localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
    Object localObject = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    Intent localIntent = new Intent((Context)localObject, FastWebVideoFeedsPlayActivity.class);
    if (BaseApplicationImpl.sProcessId != 1)
    {
      localBundle.putBoolean("param_needSmooth", VideoVolumeControl.a().c());
      VideoVolumeControl.a().f(true);
      localBundle.putBoolean("param_needAlertInXg", VideoAutoPlayController.e());
    }
    localIntent.putExtras(localBundle);
    if (paramVideoPlayParam.jdField_e_of_type_Int == 6) {
      localIntent.putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
    }
    int i = 9091;
    if (1 == paramBaseArticleInfo.mVideoType) {
      i = 1;
    }
    for (;;)
    {
      ((Activity)localObject).startActivityForResult(localIntent, i);
      ((Activity)localObject).overridePendingTransition(2131034194, 2131034195);
      return;
      if (0L == paramBaseArticleInfo.mChannelID) {
        i = 1;
      }
    }
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (VideoData)paramBaseData2;
    int i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    i = a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext()) - i - i;
    this.jdField_a_of_type_Int = (i * 280 / 496);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = i;
    paramBaseData2.mRequestHeight = this.jdField_a_of_type_Int;
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    if (TextUtils.isEmpty(paramBaseData1.jdField_a_of_type_JavaLangString))
    {
      paramBaseData1.jdField_a_of_type_JavaLangString = ("http://puui.qpic.cn/qqvideo_ori/0/" + paramBaseData1.jdField_b_of_type_JavaLangString + "_496_280/0");
      ReadInJoyUtils.a(paramBaseData1.jdField_b_of_type_JavaLangString, paramBaseData1.d, paramBaseData1.jdField_c_of_type_JavaLangString, paramBaseData1.jdField_e_of_type_JavaLangString, new mrj(this, paramBaseData1));
    }
    paramBaseData2 = URLDrawable.getDrawable(PubAccountHttpDownloader.a(paramBaseData1.jdField_a_of_type_JavaLangString, 4), paramBaseData2);
    if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
      paramBaseData2.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData2);
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramBaseData1);
  }
  
  public void onClick(View paramView)
  {
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
      paramView = "2";
    }
    for (;;)
    {
      paramView = ReadInJoyUtils.a(localContext, localArticleInfo, 0, paramView);
      try
      {
        paramView.put("vedio_rowkey", localVideoData.jdField_b_of_type_JavaLangString);
        ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898F", paramView.toString());
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        paramView.mVideoJsonWidth = localVideoData.jdField_a_of_type_Int;
        paramView.mVideoJsonHeight = localVideoData.jdField_b_of_type_Int;
        paramView.mVideoVid = localVideoData.jdField_b_of_type_JavaLangString;
        paramView.busiType = localVideoData.jdField_c_of_type_Int;
        paramView.mVideoCoverUrl = ReadInJoyUtils.a(localVideoData.jdField_a_of_type_JavaLangString);
        a(paramView);
        return;
        paramView = "1";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mri
 * JD-Core Version:    0.7.0.1
 */