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
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class qzb
  extends qxr
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int e;
  
  public qzb(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131313119));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131313196));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private Bundle a(qht paramqht, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label107:
    boolean bool;
    label278:
    label289:
    int i;
    label374:
    Bundle localBundle2;
    if (paramqht.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramqht.jdField_f_of_type_Int != 6) {
        break label912;
      }
      localBundle1.putString("VIDEO_H5_URL", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", oby.a(((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramqht.jdField_b_of_type_Int));
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramqht.jdField_c_of_type_Int));
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramqht.jdField_d_of_type_Int));
      localBundle1.putString("VIDEO_VID", paramqht.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramqht.jdField_b_of_type_JavaLangString);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      localBundle1.putString("VIDEO_SUMMARY", paramBaseArticleInfo.mTitle);
      if (paramqht.jdField_f_of_type_Int != 6) {
        break label941;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
      localBundle1.putString("VIDEO_TITLE", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      if (paramqht.jdField_f_of_type_Int != 1) {
        break label966;
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
        break label972;
      }
      i = 0;
      localBundle1.putInt("interactionType", i);
      localBundle1.putString("VIDEO_THIRD_ICON", paramqht.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramqht.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramqht.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramqht.jdField_g_of_type_JavaLangString);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramqht.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramqht.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramqht.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramqht.jdField_b_of_type_Int);
      localBundle2.putInt("PREVIEW_START_POSI", qhv.a(0, paramqht.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramqht.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramqht.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramqht.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramqht.jdField_f_of_type_Int != 1) {
        break label977;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramqht.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramqht.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl);
      localBundle2.putString("video_url", paramqht.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", oby.a(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle2.putInt("req_type", 140);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)awuw.a(localBundle2)).getBytes());
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      return localBundle1;
      if (paramqht.jdField_f_of_type_Int == 6)
      {
        if (qoe.a((ArticleInfo)paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaLangString);
          if (qoe.q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label912:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", oby.a(paramBaseArticleInfo.mTime, true));
      break label107;
      label941:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label278;
      label966:
      bool = false;
      break label289;
      label972:
      i = 1;
      break label374;
      label977:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    qht localqht = new qht();
    localqht.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localqht.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localqht.h = paramArticleInfo.thirdUin;
    localqht.i = paramArticleInfo.thirdUinName;
    localqht.k = paramArticleInfo.mSubscribeID;
    localqht.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localqht.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    pqb localpqb = new pqb();
    localpqb.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localpqb.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    localqht.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
    localqht.jdField_f_of_type_Int = paramArticleInfo.busiType;
    localqht.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
    localqht.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
    localpqb.jdField_a_of_type_Int = paramArticleInfo.busiType;
    localqht.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
    if (paramArticleInfo.mVideoCoverUrl == null) {}
    for (String str = null;; str = paramArticleInfo.mVideoCoverUrl.getFile())
    {
      localqht.jdField_b_of_type_JavaLangString = str;
      localqht.j = paramArticleInfo.innerUniqueID;
      localpqb.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
      localqht.a = localpqb;
      localqht.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
      localqht.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
      localqht.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
      new pqh().jdField_a_of_type_Int = 409409;
      a(localqht, paramArticleInfo);
      return;
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (VideoData)paramBaseData2;
    int i = aciy.a(12.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    i = a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext()) - i - i;
    this.jdField_e_of_type_Int = (i * 280 / 496);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = i;
    paramBaseData2.mRequestHeight = this.jdField_e_of_type_Int;
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    if (TextUtils.isEmpty(paramBaseData1.jdField_a_of_type_JavaLangString))
    {
      paramBaseData1.jdField_a_of_type_JavaLangString = ("http://puui.qpic.cn/qqvideo_ori/0/" + paramBaseData1.jdField_b_of_type_JavaLangString + "_496_280/0");
      obz.a(paramBaseData1.jdField_b_of_type_JavaLangString, paramBaseData1.jdField_d_of_type_JavaLangString, paramBaseData1.jdField_c_of_type_JavaLangString, paramBaseData1.jdField_e_of_type_JavaLangString, new qzc(this, paramBaseData1));
    }
    paramBaseData2 = URLDrawable.getDrawable(rsl.a(paramBaseData1.jdField_a_of_type_JavaLangString, 4), paramBaseData2);
    if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
      paramBaseData2.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData2);
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramBaseData1);
  }
  
  public void a(qht paramqht, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramqht.jdField_d_of_type_Long + ",vid : " + paramqht.jdField_c_of_type_JavaLangString);
    }
    Bundle localBundle = a(paramqht, paramBaseArticleInfo);
    if (paramqht.jdField_f_of_type_Int == 2)
    {
      localObject = ocm.a(paramqht.jdField_c_of_type_JavaLangString);
      if (localObject != null)
      {
        localBundle.putString("VIDEO_THIRD_VID_URL", ((ocs)localObject).jdField_a_of_type_JavaLangString);
        localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((ocs)localObject).jdField_a_of_type_Long);
      }
    }
    localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
    localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
    localBundle.putInt("VIDEO_FROM_TYPE", 10);
    Object localObject = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    Intent localIntent = new Intent((Context)localObject, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    if (BaseApplicationImpl.sProcessId != 1)
    {
      localBundle.putBoolean("param_needSmooth", qji.a().d());
      qji.a().f(true);
      localBundle.putBoolean("param_needAlertInXg", pyu.e());
    }
    if (paramqht.jdField_f_of_type_Int == 6) {
      localBundle.putParcelable("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
    }
    localIntent.putExtras(localBundle);
    int i = 9091;
    if (1 == paramBaseArticleInfo.mVideoType) {
      i = 1;
    }
    for (;;)
    {
      int j = 0;
      try
      {
        boolean bool = odw.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        j = bool;
      }
      catch (Exception paramqht)
      {
        label323:
        break label323;
      }
      if (j == 0) {
        break;
      }
      paramqht = new Intent();
      paramqht.putExtras(localBundle);
      MultiVideoFragment.a((Activity)localObject, paramqht, i);
      ((Activity)localObject).overridePendingTransition(2130772010, 2130772011);
      return;
      if (0L == paramBaseArticleInfo.mChannelID) {
        i = 1;
      }
    }
    ((Activity)localObject).startActivityForResult(localIntent, i);
    ((Activity)localObject).overridePendingTransition(2130772067, 2130772068);
  }
  
  public void onClick(View paramView)
  {
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {
      paramView = "2";
    }
    for (;;)
    {
      paramView = obz.a(localContext, localArticleInfo, 0, paramView);
      try
      {
        paramView.put("vedio_rowkey", localVideoData.jdField_b_of_type_JavaLangString);
        raz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X800898F", paramView.toString());
        paramView = new ArticleInfo();
        paramView.mVideoJsonWidth = localVideoData.jdField_a_of_type_Int;
        paramView.mVideoJsonHeight = localVideoData.jdField_b_of_type_Int;
        paramView.mVideoVid = localVideoData.jdField_b_of_type_JavaLangString;
        paramView.busiType = localVideoData.jdField_c_of_type_Int;
        paramView.mVideoCoverUrl = obz.a(localVideoData.jdField_a_of_type_JavaLangString);
        paramView.mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mArticleContentUrl;
        paramView.mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mTitle;
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
 * Qualified Name:     qzb
 * JD-Core Version:    0.7.0.1
 */