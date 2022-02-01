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
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class sqo
  extends spi
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private int e;
  
  public sqo(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131380794));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380906));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private Bundle a(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label107:
    boolean bool;
    label278:
    label289:
    int i;
    label374:
    Bundle localBundle2;
    if (paramrwc.jdField_f_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramrwc.jdField_f_of_type_Int != 6) {
        break label909;
      }
      localBundle1.putString("VIDEO_H5_URL", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", ozr.a(((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramrwc.jdField_b_of_type_Int));
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramrwc.jdField_c_of_type_Int));
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramrwc.jdField_d_of_type_Int));
      localBundle1.putString("VIDEO_VID", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramrwc.jdField_b_of_type_JavaLangString);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      localBundle1.putString("VIDEO_SUMMARY", paramBaseArticleInfo.mTitle);
      if (paramrwc.jdField_f_of_type_Int != 6) {
        break label938;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
      localBundle1.putString("VIDEO_TITLE", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      if (paramrwc.jdField_f_of_type_Int != 1) {
        break label963;
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
        break label969;
      }
      i = 0;
      localBundle1.putInt("interactionType", i);
      localBundle1.putString("VIDEO_THIRD_ICON", paramrwc.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramrwc.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramrwc.jdField_f_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramrwc.jdField_g_of_type_JavaLangString);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramrwc.jdField_f_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramrwc.jdField_b_of_type_Int);
      localBundle2.putInt("PREVIEW_START_POSI", rwe.a(0, paramrwc.jdField_b_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramrwc.jdField_c_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramrwc.jdField_d_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramrwc.jdField_b_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramrwc.jdField_f_of_type_Int != 1) {
        break label974;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramrwc.jdField_f_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramrwc.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl);
      localBundle2.putString("video_url", paramrwc.jdField_c_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", ozr.a(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle2.putInt("req_type", 140);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)bdow.a(localBundle2)).getBytes());
      localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      return localBundle1;
      if (paramrwc.jdField_f_of_type_Int == 6)
      {
        if (sel.g(paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.a);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaLangString);
          if (sel.q((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((qyn)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.a);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label909:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", ozr.a(paramBaseArticleInfo.mTime, true));
      break label107;
      label938:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label278;
      label963:
      bool = false;
      break label289;
      label969:
      i = 1;
      break label374;
      label974:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    rwc localrwc = new rwc();
    localrwc.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localrwc.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localrwc.h = paramArticleInfo.thirdUin;
    localrwc.i = paramArticleInfo.thirdUinName;
    localrwc.k = paramArticleInfo.mSubscribeID;
    localrwc.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localrwc.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    qwv localqwv = new qwv();
    localqwv.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localqwv.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    localrwc.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
    localrwc.jdField_f_of_type_Int = paramArticleInfo.busiType;
    localrwc.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
    localrwc.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
    localqwv.jdField_a_of_type_Int = paramArticleInfo.busiType;
    localrwc.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
    if (paramArticleInfo.mVideoCoverUrl == null) {}
    for (String str = null;; str = paramArticleInfo.mVideoCoverUrl.getFile())
    {
      localrwc.jdField_b_of_type_JavaLangString = str;
      localrwc.j = paramArticleInfo.innerUniqueID;
      localqwv.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
      localrwc.a = localqwv;
      localrwc.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
      localrwc.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
      localrwc.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
      new qxb().jdField_a_of_type_Int = 409409;
      a(localrwc, paramArticleInfo);
      return;
    }
  }
  
  public void a(rwc paramrwc, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramrwc.jdField_d_of_type_Long + ",vid : " + paramrwc.jdField_c_of_type_JavaLangString);
    }
    Bundle localBundle = a(paramrwc, paramBaseArticleInfo);
    if (paramrwc.jdField_f_of_type_Int == 2)
    {
      localObject = scq.a(paramrwc.jdField_c_of_type_JavaLangString);
      if (localObject != null)
      {
        localBundle.putString("VIDEO_THIRD_VID_URL", ((scv)localObject).jdField_a_of_type_JavaLangString);
        localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((scv)localObject).b);
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
      localBundle.putBoolean("param_needSmooth", rxg.a().d());
      rxg.a().d(true);
      localBundle.putBoolean("param_needAlertInXg", rmn.d());
    }
    if (paramrwc.jdField_f_of_type_Int == 6) {
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
        boolean bool = pbn.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        j = bool;
      }
      catch (Exception paramrwc)
      {
        label323:
        break label323;
      }
      if (j == 0) {
        break;
      }
      paramrwc = new Intent();
      paramrwc.putExtras(localBundle);
      rze.a((Activity)localObject, paramrwc, i);
      ((Activity)localObject).overridePendingTransition(2130772011, 2130772012);
      return;
      if (0L == paramBaseArticleInfo.mChannelID) {
        i = 1;
      }
    }
    ((Activity)localObject).startActivityForResult(localIntent, i);
    ((Activity)localObject).overridePendingTransition(2130772068, 2130772069);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (VideoData)paramBaseData2;
    int i = agej.a(12.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    i = a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext()) - i - i;
    this.jdField_e_of_type_Int = (i * 280 / 496);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = i;
    paramBaseData2.mRequestHeight = this.jdField_e_of_type_Int;
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    if (TextUtils.isEmpty(paramBaseData1.jdField_a_of_type_JavaLangString)) {
      ozs.a(paramBaseData1.jdField_b_of_type_JavaLangString, paramBaseData1.jdField_d_of_type_JavaLangString, paramBaseData1.jdField_c_of_type_JavaLangString, paramBaseData1.jdField_e_of_type_JavaLangString, new sqp(this, paramBaseData1));
    }
    paramBaseData2 = URLDrawable.getDrawable(tye.a(paramBaseData1.jdField_a_of_type_JavaLangString, 4), paramBaseData2);
    if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
      paramBaseData2.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData2);
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
    this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramBaseData1);
  }
  
  public void onClick(View paramView)
  {
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = ozs.a(localContext, localArticleInfo, 0, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("vedio_rowkey", localVideoData.jdField_b_of_type_JavaLangString);
        ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X800898F", ((JSONObject)localObject).toString());
        localObject = new ArticleInfo();
        ((ArticleInfo)localObject).mVideoJsonWidth = localVideoData.jdField_a_of_type_Int;
        ((ArticleInfo)localObject).mVideoJsonHeight = localVideoData.jdField_b_of_type_Int;
        ((ArticleInfo)localObject).mVideoVid = localVideoData.jdField_b_of_type_JavaLangString;
        ((ArticleInfo)localObject).busiType = localVideoData.jdField_c_of_type_Int;
        ((ArticleInfo)localObject).mVideoCoverUrl = ozs.a(localVideoData.jdField_a_of_type_JavaLangString);
        ((ArticleInfo)localObject).mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mArticleContentUrl;
        ((ArticleInfo)localObject).mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mTitle;
        a((ArticleInfo)localObject);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = "1";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqo
 * JD-Core Version:    0.7.0.1
 */