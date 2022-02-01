package com.tencent.mobileqq.kandian.biz.pts.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LocalInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJJsonUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.comment.RIJMedalUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentSocialOperation;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.item.TripleProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialAvatarClickListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialAvatarClickListener.SocialAvatarData;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AnswerDetailInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BuluoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ExtraBiuBriefInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.GalleryPGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.IconWordingInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LocationInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackVideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PrivacyShowInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.VideoFeedsUtil;
import com.tencent.mobileqq.kandian.repo.video.entity.GameLiveInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.search.RequestSearchWord.Rcmd;

public class Util
{
  static void A(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = BaseApplicationImpl.getContext();
    boolean bool = g(paramAbsBaseArticleInfo);
    int i = 1;
    if ((bool) && (localObject != null))
    {
      paramJSONObject.put("id_topic_recommend_header", new JSONObject());
      TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
      JSONObject localJSONObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localTopicRecommendInfo.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(" ");
      localStringBuilder.append(localTopicRecommendInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("topic_name", localStringBuilder.toString());
      paramJSONObject.put("id_topic_name", localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("topic_avator_url", localTopicRecommendInfo.jdField_d_of_type_JavaLangString);
      paramJSONObject.put("id_topic_avator", localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("biu_time_text", String.format(((Context)localObject).getString(2131718064), new Object[] { ReadInJoyHelper.b(localTopicRecommendInfo.jdField_b_of_type_Int) }));
      paramJSONObject.put("id_topic_recommend_biu_time", localJSONObject);
      localObject = new JSONObject();
      if (((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int != 1) {
        i = 0;
      }
      int j;
      if (i != 0) {
        j = 2131715768;
      } else {
        j = 2131715758;
      }
      ((JSONObject)localObject).put("button_status", HardCodeUtil.a(j));
      if (i != 0) {
        paramAbsBaseArticleInfo = "1";
      } else {
        paramAbsBaseArticleInfo = "0";
      }
      ((JSONObject)localObject).put("selected_status", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_follow_button", localObject);
      paramJSONObject.put("id_header_line", new JSONObject());
      return;
    }
    QLog.d("Util", 1, "bindTopicPackHeader failed, not topicInfo.");
  }
  
  static void B(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!g(paramAbsBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicTimeAndReason failed, not topicInfo.");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    if ((RIJFeedsType.k(paramAbsBaseArticleInfo)) || (RIJFeedsType.n(paramAbsBaseArticleInfo))) {
      if (paramAbsBaseArticleInfo.mTime > 0L) {
        localStringBuilder1.append(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(paramAbsBaseArticleInfo.mRecommendTime, true));
      } else {
        localStringBuilder1.append("刚刚");
      }
    }
    if (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      if (localStringBuilder1.length() > 0) {
        localStringBuilder1.append(" ");
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString))
      {
        localStringBuilder1.append(paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString);
      }
      else if (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0) != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(ReadInJoyHelper.a(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
        localStringBuilder2.append("人参与");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    paramAbsBaseArticleInfo = new JSONObject();
    paramAbsBaseArticleInfo.put("biu_time_text", HardCodeUtil.a(2131715765));
    paramJSONObject.put("id_topic_recommend_biu_time", paramAbsBaseArticleInfo);
  }
  
  static void C(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null))
    {
      a(paramAbsBaseArticleInfo, paramJSONObject, true);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("article_large_imge_url", paramAbsBaseArticleInfo.mFirstPagePicUrl);
      paramJSONObject.put("id_article_large_imge", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("article_small_imge_url", paramAbsBaseArticleInfo.mFirstPagePicUrl);
      paramJSONObject.put("id_article_small_imge", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("text", paramAbsBaseArticleInfo.mSubscribeName);
      paramJSONObject.put("id_subcribe_name", localObject1);
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length > 0))
      {
        if ((paramAbsBaseArticleInfo.mPictures.length >= 1) && (paramAbsBaseArticleInfo.mPictures[0] != null)) {
          localObject1 = paramAbsBaseArticleInfo.mPictures[0];
        } else {
          localObject1 = paramAbsBaseArticleInfo.mSinglePicture;
        }
        Object localObject5 = null;
        if (localObject1 != null) {
          localObject1 = ((URL)localObject1).getFile();
        } else {
          localObject1 = null;
        }
        if ((paramAbsBaseArticleInfo.mPictures.length >= 2) && (paramAbsBaseArticleInfo.mPictures[1] != null)) {
          localObject2 = paramAbsBaseArticleInfo.mPictures[1];
        } else {
          localObject2 = paramAbsBaseArticleInfo.mSinglePicture;
        }
        if (localObject2 != null) {
          localObject3 = ((URL)localObject2).getFile();
        } else {
          localObject3 = null;
        }
        URL localURL;
        if ((paramAbsBaseArticleInfo.mPictures.length >= 3) && (paramAbsBaseArticleInfo.mPictures[2] != null)) {
          localURL = paramAbsBaseArticleInfo.mPictures[2];
        } else {
          localURL = paramAbsBaseArticleInfo.mSinglePicture;
        }
        localObject2 = localObject3;
        localObject4 = localObject1;
        paramAbsBaseArticleInfo = localObject5;
        if (localURL != null)
        {
          paramAbsBaseArticleInfo = localURL.getFile();
          localObject2 = localObject3;
          localObject4 = localObject1;
        }
      }
      else
      {
        localObject3 = JSONUtils.a(paramAbsBaseArticleInfo.mJsonPictureList, "pictures");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() >= 3))
        {
          localObject1 = ((JSONArray)localObject3).optJSONObject(0);
          if (localObject1 == null) {
            localObject1 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
          } else {
            localObject1 = ((JSONObject)localObject1).optString("picture");
          }
          localObject2 = ((JSONArray)localObject3).optJSONObject(1);
          if (localObject2 == null) {
            localObject2 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
          } else {
            localObject2 = ((JSONObject)localObject2).optString("picture");
          }
          localObject3 = ((JSONArray)localObject3).optJSONObject(2);
          if (localObject3 == null) {
            paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mFirstPagePicUrl;
          } else {
            paramAbsBaseArticleInfo = ((JSONObject)localObject3).optString("picture");
          }
          localObject4 = localObject1;
        }
        else
        {
          localObject2 = "";
          localObject4 = localObject2;
          paramAbsBaseArticleInfo = localObject4;
        }
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("multi_img_url1", localObject4);
      paramJSONObject.put("id_multi_img_1", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("multi_img_url2", localObject2);
      paramJSONObject.put("id_multi_img_2", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("multi_img_url3", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_multi_img_3", localObject1);
      return;
    }
    QLog.d("Util", 1, "bindCommonInfo, info or outData is null.");
  }
  
  public static void D(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    ae(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  static void E(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("url", RIJJumpUtils.a(paramAbsBaseArticleInfo, paramAbsBaseArticleInfo.mArticleContentUrl));
    new JSONObject();
    Object localObject1 = paramAbsBaseArticleInfo.mFirstPagePicUrl;
    String str2 = "article_large_imge_url";
    paramJSONObject.put("article_large_imge_url", localObject1);
    paramJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
    localObject1 = paramAbsBaseArticleInfo.mTitle;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    String str1 = "artilce_title_text";
    if (!bool) {
      paramJSONObject.put("artilce_title_text", localObject1);
    }
    if (paramAbsBaseArticleInfo.getVideoDuration() > 0) {
      paramJSONObject.put("video_play_duration", UITools.a(paramAbsBaseArticleInfo.getVideoDuration()));
    }
    int i = paramAbsBaseArticleInfo.getVideoDuration();
    localObject1 = "subcribe_name_text";
    if (i <= 0) {
      paramJSONObject.put("subcribe_name_text", paramAbsBaseArticleInfo.mSubscribeName);
    }
    F(paramAbsBaseArticleInfo, paramJSONObject);
    D(paramAbsBaseArticleInfo, paramJSONObject);
    if ((paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
    {
      ArrayList localArrayList1 = new ArrayList();
      Object localObject2 = new JSONArray();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localIterator.next();
        if (localPackArticleInfo != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("style_ID", localPackArticleInfo.i);
          new JSONObject();
          localJSONObject.put(str2, localPackArticleInfo.jdField_c_of_type_JavaLangString);
          if (localPackArticleInfo.jdField_c_of_type_Int == 1)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(localPackArticleInfo.jdField_d_of_type_Int);
            ((StringBuilder)localObject3).append(HardCodeUtil.a(2131715757));
            localJSONObject.put("gallery_cnt", ((StringBuilder)localObject3).toString());
          }
          localJSONObject.put("rowkey", localPackArticleInfo.g);
          localArrayList1.add(localPackArticleInfo.g);
          localJSONObject.put((String)localObject1, localPackArticleInfo.jdField_f_of_type_JavaLangString);
          localJSONObject.put("subscribe_id", localPackArticleInfo.jdField_e_of_type_JavaLangString);
          localJSONObject.put(str1, localPackArticleInfo.jdField_a_of_type_JavaLangString);
          if (RIJJumpUtils.a(localPackArticleInfo.jdField_d_of_type_JavaLangString)) {
            localObject3 = RIJJumpUtils.a(localPackArticleInfo.jdField_d_of_type_JavaLangString, localPackArticleInfo, paramAbsBaseArticleInfo);
          } else {
            localObject3 = localPackArticleInfo.jdField_d_of_type_JavaLangString;
          }
          BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
          localBaseArticleInfo.mArticleContentUrl = localPackArticleInfo.jdField_d_of_type_JavaLangString;
          localBaseArticleInfo.mSubscribeName = localPackArticleInfo.jdField_f_of_type_JavaLangString;
          localBaseArticleInfo.mSubscribeID = localPackArticleInfo.jdField_e_of_type_JavaLangString;
          localBaseArticleInfo.mTitle = localPackArticleInfo.jdField_a_of_type_JavaLangString;
          if (localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo != null)
          {
            localJSONObject.put("video_play_duration", UITools.a(localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int));
            localBaseArticleInfo.mVideoDuration = localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int;
            localBaseArticleInfo.busiType = localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Int;
            localBaseArticleInfo.mVideoVid = localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString;
            localBaseArticleInfo.mVideoJsonWidth = localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Int;
            localBaseArticleInfo.mVideoJsonHeight = localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_c_of_type_Int;
            try
            {
              localBaseArticleInfo.mVideoCoverUrl = new URL(localPackArticleInfo.jdField_c_of_type_JavaLangString);
            }
            catch (MalformedURLException localMalformedURLException)
            {
              localMalformedURLException.printStackTrace();
              QLog.d("Util", 2, localMalformedURLException.getMessage());
            }
          }
          if ((paramAbsBaseArticleInfo.isPGCShortContent()) && (localPackArticleInfo.jdField_e_of_type_Int == 1)) {
            localJSONObject.put("image_type_text", HardCodeUtil.a(2131715772));
          }
          localArrayList2.add(localBaseArticleInfo);
          localJSONObject.put("url", localObject3);
          ((JSONArray)localObject2).put(localJSONObject);
          Object localObject3 = localObject2;
          if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)) {
            localObject3 = RIJJsonUtils.a((JSONArray)localObject2, new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).getJSONArray("remoteDatas"));
          }
          localObject2 = localObject3;
        }
      }
      paramJSONObject.put("jump_url", paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_d_of_type_JavaLangString);
      paramJSONObject.put("datas", localObject2);
      paramAbsBaseArticleInfo.mGroupSubArticleList = localArrayList2;
      paramJSONObject.put("all_rowkey", localArrayList1.toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindDynamicCommonInfo polymetric card : ");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      ((StringBuilder)localObject1).append(", packType : ");
      ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int);
      QLog.d("Util", 1, ((StringBuilder)localObject1).toString());
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("bindDynamicCommonInfo : ");
    paramAbsBaseArticleInfo.append(paramJSONObject.toString());
    QLog.d("Util", 1, paramAbsBaseArticleInfo.toString());
  }
  
  static void F(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mGalleryPicNumber);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715751));
      paramJSONObject.put("gallery_cnt", ((StringBuilder)localObject).toString());
      ArrayList localArrayList = new ArrayList();
      if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length > 0))
      {
        QLog.d("Util", 1, new Object[] { "bindTripleImageData, mPictures length = ", Integer.valueOf(paramAbsBaseArticleInfo.mPictures.length) });
        i = 0;
      }
      while (i < paramAbsBaseArticleInfo.mPictures.length)
      {
        if (paramAbsBaseArticleInfo.mPictures[i] == null) {
          localObject = paramAbsBaseArticleInfo.mSinglePicture;
        } else {
          localObject = paramAbsBaseArticleInfo.mPictures[i];
        }
        if (localObject != null) {
          localArrayList.add(((URL)localObject).getFile());
        }
        i += 1;
        continue;
        JSONArray localJSONArray = JSONUtils.a(paramAbsBaseArticleInfo.mJsonPictureList, "pictures");
        QLog.d("Util", 1, new Object[] { "bindTripleImageData, info.mJsonPictureList = ", paramAbsBaseArticleInfo.mJsonPictureList });
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          break label405;
        }
        i = 0;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.optJSONObject(i);
          if (localObject == null) {
            localObject = paramAbsBaseArticleInfo.mFirstPagePicUrl;
          } else {
            localObject = ((JSONObject)localObject).optString("picture");
          }
          localArrayList.add(localObject);
          i += 1;
        }
      }
      int j;
      for (int i = 0; i < localArrayList.size(); i = j)
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("gallery_triple_img_url_");
        j = i + 1;
        paramAbsBaseArticleInfo.append(j);
        localObject = paramAbsBaseArticleInfo.toString();
        if (TextUtils.isEmpty((CharSequence)localArrayList.get(i))) {
          paramAbsBaseArticleInfo = "";
        } else {
          paramAbsBaseArticleInfo = (String)localArrayList.get(i);
        }
        QLog.d("Util", 1, new Object[] { "bindTripleImageData, key = ", localObject, ", value = ", paramAbsBaseArticleInfo });
        paramJSONObject.put((String)localObject, paramAbsBaseArticleInfo);
      }
      return;
      label405:
      QLog.d("Util", 1, "bindTripleImageData, json picture list is empty.");
      return;
    }
    QLog.d("Util", 1, "bindTripleImageData, info is null or outData is null.");
  }
  
  static void G(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (j(paramAbsBaseArticleInfo))
    {
      if (((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) && (!RIJSocialBottomViewAladdinConfig.a())) {
        return;
      }
      SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
      int j = localSocializeFeedsInfo.jdField_b_of_type_Int;
      int k = localSocializeFeedsInfo.jdField_d_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramAbsBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(j), " commentCount = ", Integer.valueOf(k) });
      }
      boolean bool = h(paramAbsBaseArticleInfo);
      H(paramAbsBaseArticleInfo, paramJSONObject);
      String str2 = "like_count";
      paramJSONObject.put("like_count", "");
      if (bool) {
        str1 = "like_selected_state";
      } else {
        str1 = "selected_state";
      }
      if (localSocializeFeedsInfo.jdField_c_of_type_Int == 1) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      paramJSONObject.put(str1, localObject);
      String str1 = str2;
      if (bool) {
        str1 = "like_text";
      }
      Object localObject = ReadInJoyHelper.b(j);
      int i;
      if (bool) {
        i = 2131715770;
      } else {
        i = 2131715746;
      }
      str2 = HardCodeUtil.a(i);
      if (j <= 0) {
        localObject = str2;
      }
      paramJSONObject.put(str1, localObject);
      if (bool) {
        str1 = "comment_text";
      } else {
        str1 = "comment_count";
      }
      localObject = ReadInJoyHelper.b(k);
      str2 = HardCodeUtil.a(2131715766);
      if (k <= 0) {
        localObject = str2;
      }
      paramJSONObject.put(str1, localObject);
      a(paramAbsBaseArticleInfo, paramJSONObject, localSocializeFeedsInfo, bool);
      paramJSONObject.put("setArticleInfo", paramAbsBaseArticleInfo);
      b(paramJSONObject, paramAbsBaseArticleInfo);
      localObject = HardCodeUtil.a(2131715705);
      if (bool) {
        str1 = "share_text";
      } else {
        str1 = "share_title";
      }
      paramJSONObject.put(str1, localObject);
      localObject = new JSONObject();
      if (bool) {
        str1 = "id_social_bottom_style_a";
      } else {
        str1 = "id_social_bottom";
      }
      paramJSONObject.put(str1, localObject);
      c(paramJSONObject, paramAbsBaseArticleInfo);
      if (localSocializeFeedsInfo.jdField_c_of_type_Int == 0) {
        paramAbsBaseArticleInfo = "cancel_like";
      } else {
        paramAbsBaseArticleInfo = "click_like";
      }
      paramJSONObject.put("dt_like_btn_actionId", paramAbsBaseArticleInfo);
    }
  }
  
  public static void H(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    articlesummary.PartnerAccountInfo localPartnerAccountInfo = paramAbsBaseArticleInfo.mPartnerAccountInfo;
    String str1 = "1";
    String str2 = "已添加";
    if (localPartnerAccountInfo != null)
    {
      if (paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.get() != 1) {
        str2 = "稍后看";
      }
      if (paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.get() != 1) {
        str1 = "0";
      }
      paramJSONObject.put("watch_later_text", str2);
      paramJSONObject.put("watch_later_selected", str1);
      return;
    }
    if (!paramAbsBaseArticleInfo.isWatchLater) {
      str2 = "稍后看";
    }
    if (!paramAbsBaseArticleInfo.isWatchLater) {
      str1 = "0";
    }
    paramJSONObject.put("watch_later_text", str2);
    paramJSONObject.put("watch_later_selected", str1);
  }
  
  static void I(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) {
        return;
      }
      Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
      int i = 0;
      int j;
      if (localObject != null)
      {
        i = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        j = ((SocializeFeedsInfo)localObject).jdField_f_of_type_Int;
        QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramAbsBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(i), " biuCount = ", Integer.valueOf(j) });
      }
      else
      {
        j = 0;
      }
      if ((i > 0) || (j > 0))
      {
        paramJSONObject.put("id_social_separator_line", new JSONObject());
        paramJSONObject.put("id_social_data_wrapper", new JSONObject());
        if (i > 0)
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append(ReadInJoyHelper.b(i));
          paramAbsBaseArticleInfo.append(HardCodeUtil.a(2131715770));
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
          localObject = new JSONObject();
          paramJSONObject.put("social_data_like", paramAbsBaseArticleInfo);
          paramJSONObject.put("id_social_data_like", localObject);
        }
        if ((i > 0) && (j > 0)) {
          paramJSONObject.put("id_social_data_dot", new JSONObject());
        }
        if (j > 0)
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append(ReadInJoyHelper.b(j));
          paramAbsBaseArticleInfo.append("Biu");
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
          localObject = new JSONObject();
          ((JSONObject)localObject).put("social_data_biu", paramAbsBaseArticleInfo);
          paramJSONObject.put("id_social_data_biu", localObject);
        }
      }
    }
  }
  
  static void J(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if (((localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList != null) && (localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() > 0) && ((localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() != 1) || ((!TextUtils.isEmpty(((BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment)) && (!TextUtils.equals(((BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, ":")) && (!TextUtils.equals(((BiuCommentInfo)localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment, "："))))) || (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString)))
      {
        JSONObject localJSONObject = new JSONObject();
        long l = 0L;
        if (localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
          l = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        }
        localJSONObject.put("pre_account_uin", String.valueOf(l));
        if ((RIJBaseItemViewType.d(paramAbsBaseArticleInfo)) && (d(paramAbsBaseArticleInfo))) {
          localJSONObject.put("feeds_pre_account_uin", String.valueOf(l));
        }
        paramJSONObject.put("id_biu_comment", localJSONObject);
      }
    }
  }
  
  static void K(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)
      {
        UGCFeedsInfo localUGCFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo;
        if (((CmpCtxt.c(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo))) || (RIJFeedsType.a(localUGCFeedsInfo)) || (!TextUtils.isEmpty(localUGCFeedsInfo.jdField_a_of_type_JavaLangString))) {
          paramJSONObject.put("id_article_comment", new JSONObject());
        }
      }
    }
  }
  
  static void L(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_middle_body_wrapper", new JSONObject());
  }
  
  static void M(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_summary", new JSONObject());
  }
  
  static void N(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAbsBaseArticleInfo != null)
    {
      localJSONObject.put("pre_account_uin", String.valueOf(paramAbsBaseArticleInfo.mSubscribeID));
      if ((RIJBaseItemViewType.d(paramAbsBaseArticleInfo)) && (d(paramAbsBaseArticleInfo))) {
        localJSONObject.put("feeds_pre_account_uin", String.valueOf(paramAbsBaseArticleInfo.mSubscribeID));
      }
    }
    paramJSONObject.put("id_article_comment", localJSONObject);
  }
  
  static void O(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (ArticleInfoHelper.a(paramAbsBaseArticleInfo)) {
      return;
    }
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      paramJSONObject.put("id_middle_body_content", new JSONObject());
    }
  }
  
  static void P(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (ArticleInfoHelper.a(paramAbsBaseArticleInfo)) {
      return;
    }
    if (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)) {
      paramJSONObject.put("id_middle_body_content", new JSONObject());
    }
  }
  
  static void Q(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!RIJItemViewTypeUtils.y(paramAbsBaseArticleInfo))
    {
      paramJSONObject.put("id_middle_body_content", new JSONObject());
      if (paramAbsBaseArticleInfo.mFeedType == 30) {
        paramJSONObject.remove("id_summary");
      }
    }
  }
  
  static void R(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (ArticleInfoHelper.a(paramAbsBaseArticleInfo)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void S(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.businessName)) && (!paramAbsBaseArticleInfo.isSuperTopic))
    {
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_topic_tag", new JSONObject());
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.businessNamePrefix))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_topic_pre", "topic_pre_image");
        paramJSONObject.put("id_capsule_topic_pre", localJSONObject);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("capsule_topic_name", RIJStringUtils.a(paramAbsBaseArticleInfo.businessName, a(paramAbsBaseArticleInfo)));
      paramJSONObject.put("id_capsule_topic_name", localJSONObject);
    }
  }
  
  static void T(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if (localSocializeFeedsInfo.h == 1)
      {
        if ((RIJBaseItemViewType.d(paramAbsBaseArticleInfo)) && (!i(paramAbsBaseArticleInfo)))
        {
          paramAbsBaseArticleInfo.bindShowFollowButton = false;
          return;
        }
        paramJSONObject.put("button_status", HardCodeUtil.a(2131715745));
        paramJSONObject.put("selected_status", "0");
        paramAbsBaseArticleInfo.bindShowFollowButton = true;
        paramAbsBaseArticleInfo.showFollowButtonType = 1;
        return;
      }
      if (localSocializeFeedsInfo.h == 2)
      {
        if (b(paramAbsBaseArticleInfo))
        {
          new JSONObject();
          paramJSONObject.put("button_status", HardCodeUtil.a(2131715769));
          paramJSONObject.put("selected_status", "1");
          paramAbsBaseArticleInfo.bindShowFollowButton = true;
          paramAbsBaseArticleInfo.showFollowButtonType = 2;
          return;
        }
        paramAbsBaseArticleInfo.bindShowFollowButton = false;
        return;
      }
      paramAbsBaseArticleInfo.bindShowFollowButton = false;
    }
  }
  
  static void U(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo;
      if (paramAbsBaseArticleInfo != null) {
        if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_d_of_type_JavaLangString)))
        {
          paramJSONObject.put("id_super_topic", new JSONObject());
          JSONObject localJSONObject = new JSONObject();
          if (TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_c_of_type_JavaLangString)) {
            paramAbsBaseArticleInfo.jdField_c_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/kan/images/super_wenda_default.png";
          }
          localJSONObject.put("super_topic_avator_url", paramAbsBaseArticleInfo.jdField_c_of_type_JavaLangString);
          paramJSONObject.put("id_super_topic_avator", localJSONObject);
          if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.n))
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("super_topic_button_title", paramAbsBaseArticleInfo.n);
            paramJSONObject.put("id_super_topic_button", localJSONObject);
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("super_topic_name", paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString);
          paramJSONObject.put("id_super_topic_name", localJSONObject);
          localJSONObject = new JSONObject();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(ComponentSocialOperation.a(paramAbsBaseArticleInfo.jdField_b_of_type_Int));
          localStringBuilder.append(HardCodeUtil.a(2131715764));
          localStringBuilder.append(ComponentSocialOperation.a(paramAbsBaseArticleInfo.jdField_a_of_type_Int));
          localStringBuilder.append(HardCodeUtil.a(2131715771));
          localJSONObject.put("super_topic_subname", localStringBuilder.toString());
          paramJSONObject.put("id_super_topic_subname", localJSONObject);
          if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_e_of_type_JavaLangString))
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("super_topic_hot_icon_url", paramAbsBaseArticleInfo.jdField_e_of_type_JavaLangString);
            paramJSONObject.put("id_super_topic_hot_icon", localJSONObject);
          }
        }
        else if (QLog.isColorLevel())
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("bindSuperTopic something is null,wendaInfo.wendaUrl=");
          paramJSONObject.append(paramAbsBaseArticleInfo.jdField_d_of_type_JavaLangString);
          paramJSONObject.append(",wendaInfo.questionDes=");
          paramJSONObject.append(paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString);
          QLog.i("Util", 2, paramJSONObject.toString());
        }
      }
    }
  }
  
  public static void V(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!BaseArticleInfoKt.d(paramAbsBaseArticleInfo)) {
        return;
      }
      paramJSONObject.put("id_pack_bottom", new JSONObject());
      paramJSONObject.put("id_pack_bottom_separator_line", new JSONObject());
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("pack_bottom_imageview", "qqreadinjoy_kandian_down_arrow.png");
      paramJSONObject.put("id_pack_bottom_imageview", paramAbsBaseArticleInfo);
    }
  }
  
  static void W(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo;
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_common_tag", new JSONObject());
      JSONObject localJSONObject;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_a_of_type_JavaLangString))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_pre_url", paramAbsBaseArticleInfo.jdField_a_of_type_JavaLangString);
        paramJSONObject.put("id_capsule_common_pre", localJSONObject);
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_name", paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("id_capsule_common_name", localJSONObject);
      }
    }
  }
  
  static void X(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo == null) {
        return;
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo;
      int i = paramAbsBaseArticleInfo.jdField_a_of_type_Int;
      long l = paramAbsBaseArticleInfo.jdField_a_of_type_Long;
      if ((((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin() == l) && (i != 0))
      {
        paramJSONObject.put("id_capsule", new JSONObject());
        paramJSONObject.put("id_capsule_privacy_tag", new JSONObject());
        paramAbsBaseArticleInfo = "";
        if (i == 1)
        {
          paramAbsBaseArticleInfo = HardCodeUtil.a(2131715762);
          localObject = "readinjoy_privacy_vis_some.png";
        }
        else if (i == 2)
        {
          paramAbsBaseArticleInfo = HardCodeUtil.a(2131715747);
          localObject = "readinjoy_privacy_vis_self.png";
        }
        else
        {
          localObject = "";
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("capsule_privacy_pre", localObject);
        paramJSONObject.put("id_capsule_privacy_pre", localJSONObject);
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("capsule_privacy_name", paramAbsBaseArticleInfo);
        paramJSONObject.put("id_capsule_privacy_name", localObject);
      }
    }
  }
  
  public static void Y(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo == null) {
        return;
      }
      LocationInfo localLocationInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo;
      if ((!TextUtils.isEmpty(localLocationInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localLocationInfo.jdField_b_of_type_JavaLangString)))
      {
        paramJSONObject.put("id_capsule", new JSONObject());
        paramJSONObject.put("id_capsule_lbs_tag", new JSONObject());
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("capsule_lbs_pre_url", localLocationInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("id_capsule_lbs_pre", localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_lbs_name", RIJStringUtils.a(localLocationInfo.jdField_a_of_type_JavaLangString, a(paramAbsBaseArticleInfo)));
        paramJSONObject.put("id_capsule_lbs_name", localJSONObject);
      }
    }
  }
  
  public static void Z(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_socialize_recommend_follow", new JSONObject());
  }
  
  private static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int j = b(paramAbsBaseArticleInfo);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    j = 48 / i;
    QLog.d("Util", 1, new Object[] { "getCapsuleMaxStrLen, count = ", Integer.valueOf(i), "len = ", Integer.valueOf(j) });
    return j;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l;
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_e_of_type_Int > 0)) {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_e_of_type_Int;
    } else {
      l = paramAbsBaseArticleInfo.mTime;
    }
    Object localObject1;
    if (l > 0L) {
      localObject1 = ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(l, true);
    } else {
      localObject1 = HardCodeUtil.a(2131715753);
    }
    boolean bool = RIJBaseItemViewType.d(paramAbsBaseArticleInfo);
    String str = " ";
    Object localObject2;
    if ((bool) && (!f(paramAbsBaseArticleInfo)))
    {
      localObject2 = "";
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" ");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if ((paramAbsBaseArticleInfo.mFeedType == 32) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo.jdField_d_of_type_JavaLangString)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" · ");
      ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo.jdField_d_of_type_JavaLangString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) && ((RIJBaseItemViewType.a(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.j(paramAbsBaseArticleInfo)))) {
        localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_JavaLangString;
      } else if (paramAbsBaseArticleInfo.mSocialFeedInfo != null) {
        localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_JavaLangString;
      } else {
        localObject1 = "";
      }
    }
    Object localObject3 = localObject2;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramAbsBaseArticleInfo = str;
        } else {
          paramAbsBaseArticleInfo = "";
        }
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo);
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject3 = ((StringBuilder)localObject3).toString();
      }
    }
    return RIJStringUtils.a((String)localObject3, 36);
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null) {
      try
      {
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.interfaceData))
        {
          paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.interfaceData).optString("jump_url", "");
          return paramAbsBaseArticleInfo;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("buildJump2VideoSchema error!  msg=");
        localStringBuilder.append(paramAbsBaseArticleInfo);
        QLog.e("Util", 1, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "div");
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("style", "font-size:18px;line-height: 25px; width:351rpx;color: #242424;-webkit-line-clamp:2");
    localJSONObject1.put("attrs", localJSONObject2);
    return localJSONObject1;
  }
  
  public static JSONObject a(RichTitleInfo paramRichTitleInfo, boolean paramBoolean)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "a");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("href", paramRichTitleInfo.jdField_d_of_type_JavaLangString);
    ((JSONObject)localObject).put("style", "color: #40A0FF;");
    localJSONObject1.put("attrs", localObject);
    localObject = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "text");
    if (paramBoolean) {
      localJSONObject2.put("text", RIJStringUtils.a(paramRichTitleInfo.jdField_c_of_type_JavaLangString, 16));
    } else {
      localJSONObject2.put("text", paramRichTitleInfo.jdField_c_of_type_JavaLangString);
    }
    ((JSONArray)localObject).put(localJSONObject2);
    localJSONObject1.put("children", localObject);
    return localJSONObject1;
  }
  
  public static JSONObject a(RichTitleInfo paramRichTitleInfo, boolean paramBoolean1, boolean paramBoolean2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "text");
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("class", "div_class");
    if (paramBoolean1) {
      localObject1 = "color: #999999;";
    } else {
      localObject1 = "color: #262626";
    }
    Object localObject2 = localObject1;
    if (paramBoolean2)
    {
      localObject2 = localObject1;
      if (!l(paramAbsBaseArticleInfo)) {
        localObject2 = "color: #ffffff;";
      }
    }
    localJSONObject2.put("style", localObject2);
    localJSONObject1.put("attrs", localJSONObject2);
    paramAbsBaseArticleInfo = new JSONArray();
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("type", "text");
    ((JSONObject)localObject1).put("text", paramRichTitleInfo.jdField_a_of_type_JavaLangString);
    paramAbsBaseArticleInfo.put(localObject1);
    localJSONObject1.put("children", paramAbsBaseArticleInfo);
    return localJSONObject1;
  }
  
  public static void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramViewBase != null)
    {
      if (paramIReadInJoyModel == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null))
      {
        if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser == null) {
          return;
        }
        long l = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        paramIReadInJoyModel = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_nickname");
        if (RIJBaseItemViewType.d(localAbsBaseArticleInfo)) {
          paramIReadInJoyModel = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_feeds_nickname");
        }
        if (paramIReadInJoyModel != null) {
          paramIReadInJoyModel.a(l);
        }
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], outData is null.");
      return;
    }
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], info is null");
      return;
    }
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mGroupSubArticleList;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.size() > 0)) {
      paramInt = 0;
    }
    while (paramInt < paramAbsBaseArticleInfo.size())
    {
      Object localObject = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.get(paramInt);
      if (localObject == null)
      {
        QLog.i("Util", 1, "[bindSmallVideo], item articleInfo is null.");
      }
      else
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("style_ID", "ReadInjoy_pack_long_video_cell");
          localObject = (NewPolymericInfo.PackArticleInfo)((AbsBaseArticleInfo)localObject).mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
          localJSONObject.put("article_large_imge_url", RIJSmartCropUtils.a(((NewPolymericInfo.PackArticleInfo)localObject).jdField_c_of_type_JavaLangString, Utils.dp2px(165.0D), Utils.dp2px(293.0D)));
          if (((NewPolymericInfo.PackArticleInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo != null) {
            localJSONObject.put("video_play_duration", UITools.a(((NewPolymericInfo.PackArticleInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int));
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[bindSmallVideo], item = ");
          ((StringBuilder)localObject).append(localJSONObject);
          QLog.i("Util", 1, ((StringBuilder)localObject).toString());
          paramJSONArray.put(localJSONObject);
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[bindSmallVideo], e = ");
          ((StringBuilder)localObject).append(localException);
          QLog.e("Util", 1, ((StringBuilder)localObject).toString());
        }
        catch (JSONException localJSONException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[bindSmallVideo], e = ");
          ((StringBuilder)localObject).append(localJSONException);
          QLog.e("Util", 1, ((StringBuilder)localObject).toString());
        }
      }
      paramInt += 1;
      continue;
      QLog.i("Util", 1, "[bindSmallVideo], dataList is empty.");
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptText))
    {
      if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
      {
        paramJSONObject.put("id_info_operate_parent", new JSONObject());
        paramJSONObject.put("id_large_cell_container", new JSONObject());
        JSONObject localJSONObject1 = new JSONObject(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdExtInfo);
        try
        {
          if (localJSONObject1.has("AdsIconText"))
          {
            Object localObject;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("detail ad  bindSubscriptText adInconText:");
              ((StringBuilder)localObject).append(localJSONObject1.optString("AdsIconText"));
              QLog.d("Util", 2, ((StringBuilder)localObject).toString());
            }
            if (!TextUtils.isEmpty(localJSONObject1.optString("AdsIconText")))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("info_status_text", localJSONObject1.optString("AdsIconText"));
              ((JSONObject)localObject).put("info_status_text_color", paramAbsBaseArticleInfo.mArticleSubscriptColor);
              paramJSONObject.put("id_info_status", localObject);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("info_status_text", a(paramAbsBaseArticleInfo.mArticleSubscriptText));
      localJSONObject2.put("info_status_text_color", paramAbsBaseArticleInfo.mArticleSubscriptColor);
      paramJSONObject.put("id_info_status", localJSONObject2);
    }
    b(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  @VisibleForTesting
  static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, SocializeFeedsInfo paramSocializeFeedsInfo, boolean paramBoolean)
  {
    if (RIJSocialBottomViewAladdinConfig.b())
    {
      boolean bool = paramSocializeFeedsInfo.a();
      String str3 = "0.5";
      if ((bool) && ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)))
      {
        int j = 1;
        i = j;
        if (!RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo))
        {
          i = j;
          if (ArticleInfoHelper.b(paramAbsBaseArticleInfo)) {
            i = 0;
          }
        }
        if (i == 0)
        {
          str2 = "0";
          str1 = "0.5";
          break label83;
        }
      }
      String str2 = "1";
      String str1 = "1.0";
      label83:
      if ((paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo != null) && (paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo.jdField_a_of_type_Int != 0)) {
        str1 = str3;
      }
      paramJSONObject.put("biu_alpha", str1);
      paramJSONObject.put("biu_enable", str2);
      if (paramBoolean) {
        str1 = "biu_count_style_a";
      } else {
        str1 = "biu_count";
      }
      int i = paramSocializeFeedsInfo.jdField_f_of_type_Int;
      if (i > 0) {
        paramJSONObject.put(str1, ReadInJoyHelper.b(i));
      } else {
        paramJSONObject.put(str1, "Biu");
      }
      paramJSONObject.put("dt_rowkey_biu", paramAbsBaseArticleInfo.innerUniqueID);
      paramJSONObject.put("dt_content_type_biu", paramAbsBaseArticleInfo.dtReportContentType);
      paramJSONObject.put("dt_channel_id_biu", paramAbsBaseArticleInfo.mChannelID);
      paramJSONObject.put("dt_backend_info_biu", paramAbsBaseArticleInfo.dtReportBackendInfo);
    }
  }
  
  static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, Long paramLong)
  {
    new JSONObject();
    paramJSONObject.put("info_avator_uin", paramLong);
    if (paramAbsBaseArticleInfo != null) {
      c(paramJSONObject, paramAbsBaseArticleInfo);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.vIconUrl);
      StringBuilder localStringBuilder;
      if (!bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("icon_v_url");
        paramJSONObject.put(localStringBuilder.toString(), paramAbsBaseArticleInfo.vIconUrl);
        return;
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.upIconUrl))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("icon_v_url");
        paramJSONObject.put(localStringBuilder.toString(), paramAbsBaseArticleInfo.upIconUrl);
        return;
      }
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("[bindVIcon] e = ");
      paramJSONObject.append(paramAbsBaseArticleInfo);
      QLog.e("Util", 1, paramJSONObject.toString());
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null) && (paramAbsBaseArticleInfo.richTitleInfoList != null))
    {
      if (paramAbsBaseArticleInfo.richTitleInfoList.size() <= 0) {
        return;
      }
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if (paramString2.equalsIgnoreCase("nodes")) {
          localJSONArray.put(a());
        }
        boolean bool = ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID);
        Iterator localIterator = paramAbsBaseArticleInfo.richTitleInfoList.iterator();
        while (localIterator.hasNext())
        {
          RichTitleInfo localRichTitleInfo = (RichTitleInfo)localIterator.next();
          if (!TextUtils.isEmpty(localRichTitleInfo.jdField_c_of_type_JavaLangString)) {
            localJSONArray.put(a(localRichTitleInfo, paramBoolean));
          }
          if (!TextUtils.isEmpty(localRichTitleInfo.jdField_a_of_type_JavaLangString)) {
            localJSONArray.put(a(localRichTitleInfo, bool, paramBoolean, paramAbsBaseArticleInfo));
          }
        }
        paramJSONObject.put(paramString1, 2);
        paramJSONObject.put(paramString2, localJSONArray);
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.e("Util", 2, paramAbsBaseArticleInfo.getMessage());
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str = paramAbsBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID);
    if (paramBoolean)
    {
      if (bool) {
        paramAbsBaseArticleInfo = "#999999";
      } else {
        paramAbsBaseArticleInfo = "#262626";
      }
      localJSONObject.put("title_text_color", paramAbsBaseArticleInfo);
    }
    localJSONObject.put("article_title_text_line_space", "0");
    paramJSONObject.put("id_artilce_title", localJSONObject);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean, String paramString)
  {
    String str = paramAbsBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID);
    if (paramBoolean)
    {
      if (bool) {
        paramAbsBaseArticleInfo = "#999999";
      } else {
        paramAbsBaseArticleInfo = "#262626";
      }
      localJSONObject.put("title_text_color", paramAbsBaseArticleInfo);
    }
    else
    {
      localJSONObject.put("title_text_color", "#ffffff");
    }
    localJSONObject.put("article_title_text_line_space", paramString);
    paramJSONObject.put("id_artilce_title", localJSONObject);
  }
  
  static void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_comment_edit", new JSONObject());
    paramJSONObject.put("id_comment_edit_label", new JSONObject());
  }
  
  public static void a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null) {}
    try
    {
      paramJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
      paramJSONObject.put("channel_id", paramAbsBaseArticleInfo.mChannelID);
      paramJSONObject.put("puin", paramAbsBaseArticleInfo.getSubscribeUin());
      if (paramAbsBaseArticleInfo == null) {
        break label252;
      }
      if (paramAbsBaseArticleInfo.proteusItemsData == null) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addProteusDynamicData");
      ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.proteusItemsData);
      QLog.d("Util", 2, ((StringBuilder)localObject1).toString());
      localObject1 = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
      Iterator localIterator = ((JSONObject)localObject1).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = ((JSONObject)localObject1).opt(str);
        if (localObject2 != null) {
          paramJSONObject.put(str, localObject2);
        }
        a(paramJSONObject, str, localObject2);
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      label160:
      break label160;
    }
    QLog.d("Util", 2, "addProteusDynamicData", (Throwable)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addProteusDynamicData | ");
    ((StringBuilder)localObject1).append(paramJSONObject.toString());
    QLog.d("Util", 1, ((StringBuilder)localObject1).toString());
    ac(paramAbsBaseArticleInfo, paramJSONObject);
    if (paramAbsBaseArticleInfo.mSubArticleList != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.iterator();
      while (paramAbsBaseArticleInfo.hasNext()) {
        a(paramJSONObject, (AbsBaseArticleInfo)paramAbsBaseArticleInfo.next());
      }
    }
    label252:
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      b(paramJSONObject, paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("Util", 1, "bindSpecialData, e = ", paramJSONObject);
    }
  }
  
  public static boolean a(View paramView)
  {
    boolean bool1 = paramView instanceof ProteusItemView;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = ((ProteusItemView)paramView).a();
    if (localObject == null) {
      return false;
    }
    localObject = ((TemplateBean)localObject).getStyleName();
    boolean bool3 = "ReadInJoy_auto_video_cell_no_padding".equalsIgnoreCase((String)localObject);
    float f = ReadInJoyDisplayUtils.a(paramView);
    bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (f >= 80.0F) {
        bool1 = true;
      }
    }
    paramView = new StringBuilder();
    paramView.append("ptsCardCanPlay! styleName=");
    paramView.append((String)localObject);
    paramView.append(" percent=");
    paramView.append(f);
    QLog.d("Util", 2, paramView.toString());
    return bool1;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)) {
      return new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).has("module_bottom_name");
    }
    return false;
  }
  
  static void aa(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    new JSONObject();
    paramJSONObject.put("social_header_fold", "social_header_fold");
  }
  
  public static void ab(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = new JSONObject();
    if (paramAbsBaseArticleInfo.hasAwesome)
    {
      if (AwesomeCommentInfo.jdField_c_of_type_Int == 1)
      {
        ((JSONObject)localObject).put("icon_awesome_url", paramAbsBaseArticleInfo.iconUrl);
        ((JSONObject)localObject).put("icon_jump_url", paramAbsBaseArticleInfo.jumpUrl);
        if (paramAbsBaseArticleInfo.iconHeight != 0) {
          ((JSONObject)localObject).put("icon_awesome_wh_rate", paramAbsBaseArticleInfo.iconWith / paramAbsBaseArticleInfo.iconHeight);
        }
        paramJSONObject.put("id_icon_awesome", localObject);
      }
      if (AwesomeCommentInfo.jdField_c_of_type_Int == 2)
      {
        localObject = new AwesomeCommentInfo();
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_JavaLangString = paramAbsBaseArticleInfo.rawkey;
        ((AwesomeCommentInfo)localObject).jdField_b_of_type_Int = paramAbsBaseArticleInfo.iconHeight;
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_Int = paramAbsBaseArticleInfo.iconWith;
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_Long = paramAbsBaseArticleInfo.uin;
        ((AwesomeCommentInfo)localObject).jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.iconUrl;
        ((AwesomeCommentInfo)localObject).jdField_d_of_type_JavaLangString = paramAbsBaseArticleInfo.nickName;
        ((AwesomeCommentInfo)localObject).jdField_e_of_type_JavaLangString = paramAbsBaseArticleInfo.avatar;
        ((AwesomeCommentInfo)localObject).jdField_f_of_type_JavaLangString = paramAbsBaseArticleInfo.oldCommentId;
        ((AwesomeCommentInfo)localObject).jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.jumpUrl;
        ((AwesomeCommentInfo)localObject).g = paramAbsBaseArticleInfo.content;
        ((AwesomeCommentInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("awesomeCommentInfo", localObject);
        paramJSONObject.put("id_awesomeview_mutlilines", localJSONObject);
      }
      if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.iconUrl)) && ((AwesomeCommentInfo.jdField_c_of_type_Int == 1) || (AwesomeCommentInfo.jdField_c_of_type_Int == 2))) {
        AwesomeCommentInfo.a(paramAbsBaseArticleInfo, "0X8009B76", RIJBaseItemViewType.a(paramAbsBaseArticleInfo, 0), NativeAwesomeCommentView.a());
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("bindAwesomeCommentInfo: ");
      paramAbsBaseArticleInfo.append(paramJSONObject);
      QLog.d("Util", 2, paramAbsBaseArticleInfo.toString());
    }
  }
  
  static void ac(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    for (;;)
    {
      boolean bool1;
      String str;
      try
      {
        bool1 = ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID);
        paramJSONObject.optString("style_ID");
        boolean bool2 = TextUtils.isEmpty(paramJSONObject.optString("article_main_body_text"));
        str = "#999999";
        if (bool2) {
          break label81;
        }
        if (!bool1) {
          break label74;
        }
        paramAbsBaseArticleInfo = "#999999";
        paramJSONObject.put("article_main_body_text_color", paramAbsBaseArticleInfo);
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        return;
      }
      paramJSONObject.put("readable_title_text_color", paramAbsBaseArticleInfo);
      return;
      label74:
      paramAbsBaseArticleInfo = "#737373";
      continue;
      label81:
      if (bool1) {
        paramAbsBaseArticleInfo = str;
      } else {
        paramAbsBaseArticleInfo = "#262626";
      }
    }
  }
  
  public static void ad(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject2;
    Object localObject1;
    double d1;
    if (paramAbsBaseArticleInfo != null)
    {
      if (!(paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      localObject2 = null;
      localObject1 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getLocationInfoPos(paramAbsBaseArticleInfo);
      if (localObject1 == null) {
        d1 = 0.0D;
      } else {
        d1 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getADDistanceByPos((double[])localObject1, BaseApplicationImpl.getContext());
      }
      paramAbsBaseArticleInfo = ((AdvertisementInfo)paramAbsBaseArticleInfo).mLocalInfo;
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bindAdPositionInfoNew localInfo ->");
        ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo);
        QLog.d("Util", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        str2 = paramAbsBaseArticleInfo.h;
        localObject1 = paramAbsBaseArticleInfo.jdField_c_of_type_JavaLangString;
        str1 = paramAbsBaseArticleInfo.jdField_f_of_type_JavaLangString;
        String str3 = paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString;
        int i = ParseUtil.a(str2, 3000);
        str2 = "";
        if (d1 <= 0.0D)
        {
          d1 = 0.0D;
          paramAbsBaseArticleInfo = "";
        }
        else
        {
          d1 = Math.ceil(d1);
          paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject2;
        }
        localObject2 = new StringBuilder();
        if (d1 == 0.0D) {
          break label388;
        }
        double d2 = i;
        if (d1 > d2) {
          break label388;
        }
        if (d1 < 1000.0D)
        {
          ((StringBuilder)localObject2).append((int)d1);
          ((StringBuilder)localObject2).append('m');
          paramAbsBaseArticleInfo = ((StringBuilder)localObject2).toString();
        }
        else
        {
          if (d1 >= d2) {
            break label385;
          }
          long l = Math.round(d1 / 1000.0D);
          if (l < 1000L)
          {
            ((StringBuilder)localObject2).append(l);
            ((StringBuilder)localObject2).append("km");
          }
          else
          {
            ((StringBuilder)localObject2).append("999km");
          }
          paramAbsBaseArticleInfo = ((StringBuilder)localObject2).toString();
        }
        if ((TextUtils.isEmpty((CharSequence)localObject1) ^ true))
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("ad_Location", paramAbsBaseArticleInfo);
          ((JSONObject)localObject2).put("ad_Location_content", localObject1);
          ((JSONObject)localObject2).put("ad_url", str3);
          paramAbsBaseArticleInfo = new JSONObject();
          paramAbsBaseArticleInfo.put("ad_Location", localObject2);
          paramJSONObject.put("id_view_ad_locationView", paramAbsBaseArticleInfo);
        }
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        return;
      }
      label385:
      continue;
      label388:
      localObject1 = str1;
      paramAbsBaseArticleInfo = str2;
    }
  }
  
  public static void ae(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mPartnerAccountInfo != null))
    {
      if (!paramAbsBaseArticleInfo.isAccountShown) {
        return;
      }
      paramJSONObject.put("info_avator_uin", paramAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get());
      c(paramJSONObject, paramAbsBaseArticleInfo);
      paramJSONObject.put("partner_nickname_text", RIJStringUtils.a(ReadInJoyUserInfoModule.a()));
      paramJSONObject.put("partner_info_text", RIJStringUtils.a(paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_recommend_reason.get().toStringUtf8(), 36));
      T(paramAbsBaseArticleInfo, paramJSONObject);
      v(paramAbsBaseArticleInfo, paramJSONObject);
      String str1 = "";
      String str2 = str1;
      if (RIJItemViewTypeUtils.A(paramAbsBaseArticleInfo))
      {
        if (paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.has()) {
          str1 = paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.get().toStringUtf8();
        }
        str2 = str1;
        if (TextUtils.isEmpty(str1))
        {
          str2 = str1;
          if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) {
            str2 = OnSocialAvatarClickListener.a(paramAbsBaseArticleInfo, RIJBaseItemViewType.a(paramAbsBaseArticleInfo)).jdField_a_of_type_JavaLangString;
          }
        }
        paramJSONObject.put("partner_head_jump_url", str2);
        paramJSONObject.put("partner_jump_url", str2);
      }
      int i = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo);
      paramJSONObject.put("account_expose_card", i);
      QLog.d("Util", 1, new Object[] { "bindPartnerInfo, partner_head_jump_url = ", str2, " proteusItemsData=", paramAbsBaseArticleInfo.proteusItemsData, "  partner_jump_url=", paramAbsBaseArticleInfo.mArticleContentUrl, " ,account_expose_card=", Integer.valueOf(i) });
    }
  }
  
  public static void af(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSearchWordTitle)) {
      paramJSONObject.remove(TripleProteusItem.jdField_a_of_type_JavaLangString);
    } else {
      paramJSONObject.put(TripleProteusItem.jdField_a_of_type_JavaLangString, paramAbsBaseArticleInfo.mSearchWordTitle);
    }
    int j = paramAbsBaseArticleInfo.mSearchWords.size();
    int i = 0;
    while (i < j)
    {
      RequestSearchWord.Rcmd localRcmd = (RequestSearchWord.Rcmd)paramAbsBaseArticleInfo.mSearchWords.get(i);
      if (localRcmd != null)
      {
        paramJSONObject.put(TripleProteusItem.b[i], localRcmd.word.get().toStringUtf8());
        paramJSONObject.put(TripleProteusItem.jdField_a_of_type_ArrayOfJavaLangString[i], localRcmd.jmp_url.get());
      }
      else
      {
        paramJSONObject.remove(TripleProteusItem.b[i]);
        paramJSONObject.remove(TripleProteusItem.jdField_a_of_type_ArrayOfJavaLangString[i]);
      }
      i += 1;
    }
  }
  
  public static void ag(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_e_of_type_JavaLangString))
      {
        paramJSONObject.put("live_hot_icon_url", "https://pub.idqqimg.com/pc/misc/files/20191127/0be49e55346742bd847bcef3941ec4d4.png");
        paramJSONObject.put("live_hot_text", paramAbsBaseArticleInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramAbsBaseArticleInfo.jdField_a_of_type_Int == 0)
      {
        paramJSONObject.put("live_status_bg_url", "https://pub.idqqimg.com/pc/misc/files/20191127/d3d83721dfe84278a19c8927e2253f10.png");
        paramJSONObject.put("live_status_text", HardCodeUtil.a(2131717947));
      }
      else
      {
        paramJSONObject.put("live_status_icon_url", "https://pub.idqqimg.com/pc/misc/files/20191127/b7e14064b3d1417788352c8a47d1e85a.gif");
        paramJSONObject.put("live_status_bg_url", "https://pub.idqqimg.com/pc/misc/files/20191127/84cf4158acb64cc0a7bf1d3a8f1b9d27.png");
        paramJSONObject.put("live_status_text", HardCodeUtil.a(2131717948));
      }
      paramJSONObject.put("live_show", "1");
    }
  }
  
  public static void ah(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject.put("pgc_video_content_play_icon", "ReadInJoy/rij_play_icon.png");
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public static void ai(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject.put("pgc_video_content_audio_icon", "video_audio_mute");
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public static void aj(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject.put("pgc_video_content_title", paramAbsBaseArticleInfo.mTitle);
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public static void ak(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a != null) && (paramJSONObject != null)) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(VideoFeedsHelper.c((int)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a.jdField_a_of_type_Long));
        localStringBuilder.append("播放");
        paramJSONObject.put("pgc_video_content_play_count", localStringBuilder.toString());
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public static void al(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a != null) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject.put("pgc_video_content_duration", VideoFeedsHelper.a(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a.jdField_a_of_type_Int * 1000L));
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public static void am(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a != null) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject.put("pgc_video_content_vid", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a.jdField_e_of_type_JavaLangString);
        paramJSONObject.put("pgc_video_content_cover", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a.jdField_d_of_type_JavaLangString);
        paramJSONObject.put("pgc_video_content_busitype", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a.jdField_b_of_type_Int);
        return;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
  }
  
  public static void an(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.columnEntrances != null) && (paramAbsBaseArticleInfo.columnEntrances.size() > 0))
    {
      paramAbsBaseArticleInfo.isShowColumnAnimation = true;
      paramAbsBaseArticleInfo = (VideoColumnInfo)paramAbsBaseArticleInfo.columnEntrances.get(0);
      if (paramAbsBaseArticleInfo.jdField_a_of_type_Int != 0)
      {
        paramJSONObject.put("column_tips", "栏目");
        paramJSONObject.put("column_name", paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("readinjoy_column_icon", paramAbsBaseArticleInfo.jdField_c_of_type_JavaLangString);
        paramJSONObject.put("readinjoy_column_arrow", "readinjoy_column_arrow");
      }
    }
  }
  
  static void ao(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null) {
      try
      {
        paramJSONObject.put("pgc_video_rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.e("Util", 2, paramAbsBaseArticleInfo.getMessage());
      }
    }
  }
  
  public static void ap(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null)) {
      try
      {
        if (paramAbsBaseArticleInfo.mVideoDuration != 0) {
          paramJSONObject.put("video_bottom_duration", ReadInJoyDisplayUtils.a(paramAbsBaseArticleInfo.mVideoDuration));
        }
        if (paramAbsBaseArticleInfo.mVideoPlayCount != 0) {
          paramJSONObject.put("video_bottom_play_count", VideoFeedsUtil.b(paramAbsBaseArticleInfo.mVideoPlayCount));
        }
        if (paramAbsBaseArticleInfo.mVideoCommentCount != 0)
        {
          paramJSONObject.put("video_bottom_comment_count", VideoFeedsUtil.b(paramAbsBaseArticleInfo.mVideoCommentCount));
          return;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.e("Util", 1, paramAbsBaseArticleInfo.getMessage());
      }
    }
  }
  
  public static void aq(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject.put("article_model", paramAbsBaseArticleInfo);
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.e("Util", 2, paramAbsBaseArticleInfo.getMessage());
      }
    }
  }
  
  private static void ar(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i = paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int;
    boolean bool = RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo);
    String str = "poly_gallery";
    Object localObject = "";
    if ((!bool) && (!RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo)))
    {
      if ((i != 27) && ((i != 18) || (paramAbsBaseArticleInfo.isPGCShortContent())) && (i != 31) && ((!RIJFeedsType.h(paramAbsBaseArticleInfo)) || (RIJFeedsType.d(paramAbsBaseArticleInfo))))
      {
        if (i == 52)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mGalleryPicNumber);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131702449));
          paramAbsBaseArticleInfo = ((StringBuilder)localObject).toString();
        }
        else if (((i == 48) || (i == 49)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131702506));
          paramAbsBaseArticleInfo = ((StringBuilder)localObject).toString();
        }
        else
        {
          str = "";
          paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
        }
      }
      else
      {
        paramAbsBaseArticleInfo = BaseApplicationImpl.getContext().getString(2131717749);
        str = "poly_article";
      }
    }
    else
    {
      paramAbsBaseArticleInfo = BaseApplicationImpl.getContext().getString(2131718062);
      str = "poly_topic";
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo))
    {
      paramJSONObject.put("corner_text", paramAbsBaseArticleInfo);
      paramJSONObject.put("corner_icon", str);
    }
  }
  
  private static void as(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((ReadInJoyLogicEngine.a().a(null)) && ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)))
    {
      paramAbsBaseArticleInfo = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mAdExtInfo)) {
        return;
      }
    }
    try
    {
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.mAdExtInfo);
      double d1 = paramAbsBaseArticleInfo.getDouble("latitude");
      double d2 = paramAbsBaseArticleInfo.getDouble("longitude");
      paramAbsBaseArticleInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_feed_ad_distance");
      if (paramAbsBaseArticleInfo != null)
      {
        if (paramAbsBaseArticleInfo.mLocation == null) {
          return;
        }
        double d3 = paramAbsBaseArticleInfo.mLocation.mLat02;
        double d4 = paramAbsBaseArticleInfo.mLocation.mLon02;
        if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D))
        {
          if (d2 < 0.0D) {
            return;
          }
          d1 = TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
          paramAbsBaseArticleInfo = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).distance2String(d1);
          paramJSONObject.put("id_ad_position_container", new JSONObject());
          paramJSONObject.put("ad_position", paramAbsBaseArticleInfo);
        }
      }
      return;
    }
    catch (Exception paramAbsBaseArticleInfo) {}
  }
  
  private static int b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int j;
    if (paramAbsBaseArticleInfo != null)
    {
      int i;
      if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.businessName)) && (!paramAbsBaseArticleInfo.isSuperTopic)) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        j = i;
        Object localObject;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo != null)
        {
          localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo;
          j = i;
          if (!TextUtils.isEmpty(((LocationInfo)localObject).jdField_a_of_type_JavaLangString))
          {
            j = i;
            if (!TextUtils.isEmpty(((LocationInfo)localObject).jdField_b_of_type_JavaLangString)) {
              j = i + 1;
            }
          }
        }
        i = j;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo != null)
        {
          localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo;
          int k = ((PrivacyShowInfo)localObject).jdField_a_of_type_Int;
          long l = ((PrivacyShowInfo)localObject).jdField_a_of_type_Long;
          i = j;
          if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin() == l)
          {
            i = j;
            if (k != 0) {
              i = j + 1;
            }
          }
        }
        j = i;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo != null)
        {
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo;
          j = i;
          if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_c_of_type_JavaLangString))
          {
            j = i;
            if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.jdField_d_of_type_JavaLangString)) {
              j = i + 1;
            }
          }
        }
      }
    }
    else
    {
      j = 0;
    }
    QLog.d("Util", 1, new Object[] { "getCapsuleCount = ", Integer.valueOf(j) });
    return j;
  }
  
  private static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSinglePicture != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (!paramAbsBaseArticleInfo.mNewPolymericInfo.b))
    {
      String str = paramAbsBaseArticleInfo.mSinglePicture.getFile();
      Object localObject = ReadInJoyDisplayUtils.f();
      str = RIJSmartCropUtils.a(str, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      paramAbsBaseArticleInfo.mSinglePicture = RIJConvertString2URL.a(str);
      paramAbsBaseArticleInfo.mNewPolymericInfo.b = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" handled url = ");
        ((StringBuilder)localObject).append(str);
        QLog.e("ComponentContentBigImageVideo", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (paramAbsBaseArticleInfo.mSinglePicture != null) {
      return paramAbsBaseArticleInfo.mSinglePicture.getFile();
    }
    return "";
  }
  
  private static JSONObject b()
  {
    return new JSONObject();
  }
  
  public static void b(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramViewBase != null)
    {
      if (paramIReadInJoyModel == null) {
        return;
      }
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      ReadInjoyTextView localReadInjoyTextView = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_pack_bottom_label");
      paramViewBase = paramViewBase.findViewBaseByName("id_pack_bottom");
      if ((localReadInjoyTextView != null) && (paramViewBase != null))
      {
        if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) && (BaseArticleInfoKt.d(paramIReadInJoyModel)))
        {
          long l = paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("%s还biu了");
          localStringBuilder.append(paramIReadInJoyModel.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList.size());
          localStringBuilder.append(HardCodeUtil.a(2131715763));
          localReadInjoyTextView.a(localStringBuilder.toString(), l);
          localReadInjoyTextView.setVisibility(0);
          paramViewBase.setVisibility(0);
          return;
        }
        paramViewBase.setVisibility(8);
      }
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
  {
    if ((paramAbsBaseArticleInfo.mGroupSubArticleList != null) && (paramAbsBaseArticleInfo.mGroupSubArticleList.size() > 0))
    {
      Iterator localIterator = paramAbsBaseArticleInfo.mGroupSubArticleList.iterator();
      while (localIterator.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        paramInt = localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int;
        if (RIJFeedsType.d(localAbsBaseArticleInfo)) {
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_gallery");
        } else {
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_img");
        }
        boolean bool = RIJFeedsType.b(localAbsBaseArticleInfo);
        paramAbsBaseArticleInfo = "#999999";
        Object localObject;
        if (bool)
        {
          localJSONObject.put("article_large_imge_url", b(localAbsBaseArticleInfo));
          if (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))
          {
            localJSONObject.put("id_play_text_container", new JSONObject());
            localJSONObject.put("id_layout_bottom_cover", new JSONObject());
            localJSONObject.put("id_play_text_icon", new JSONObject());
            if (CUKingCardUtils.a() == 1)
            {
              localJSONObject.put("play_text", HardCodeUtil.a(2131702446));
            }
            else if (localAbsBaseArticleInfo.mXGFileSize > 0L)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(VideoFeedsHelper.b(localAbsBaseArticleInfo.mXGFileSize));
              ((StringBuilder)localObject).append(HardCodeUtil.a(2131702499));
              localJSONObject.put("play_text", ((StringBuilder)localObject).toString());
            }
            else
            {
              localJSONObject.put("play_text", HardCodeUtil.a(2131702531));
            }
          }
          else
          {
            localJSONObject.put("id_play_icon", new JSONObject());
          }
          if (k(localAbsBaseArticleInfo)) {
            localJSONObject.put("artilce_title_text", ((NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
          }
          if (!ReadInJoyLogicEngine.a().a(localAbsBaseArticleInfo.mArticleID)) {
            paramAbsBaseArticleInfo = "#000000";
          }
          localJSONObject.put("title_text_color", paramAbsBaseArticleInfo);
        }
        else
        {
          if (k(localAbsBaseArticleInfo))
          {
            localObject = RIJPreParseData.a(((NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_JavaLangString, true, true);
            if (localObject != null) {
              localJSONObject.put("article_large_imge_url", ((URL)localObject).getFile());
            }
          }
          ar(localAbsBaseArticleInfo, localJSONObject);
          as(localAbsBaseArticleInfo, localJSONObject);
          if (k(localAbsBaseArticleInfo)) {
            localJSONObject.put("artilce_title_text", ((NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
          }
          if (!ReadInJoyLogicEngine.a().a(localAbsBaseArticleInfo.mArticleID)) {
            paramAbsBaseArticleInfo = "#000000";
          }
          localJSONObject.put("title_text_color", paramAbsBaseArticleInfo);
        }
        paramJSONArray.put(localJSONObject);
      }
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      if (paramAbsBaseArticleInfo.subscriptLocation != 0)
      {
        QLog.d("Util", 2, "bindBottomSuscriptInfo | not the right position");
        return;
      }
      paramJSONObject.put("mark_text", paramAbsBaseArticleInfo.subscriptWording);
      paramJSONObject.put("corner_mark", paramAbsBaseArticleInfo.subscriptType);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.subscriptWordingColor)) {
        paramJSONObject.put("mark_color", paramAbsBaseArticleInfo.subscriptWordingColor);
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.subscriptBgColor)) {
        paramJSONObject.put("mark_backgroundcolor", paramAbsBaseArticleInfo.subscriptBgColor);
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("bindBottomSuscriptInfo | outData : ");
      paramAbsBaseArticleInfo.append(paramJSONObject.toString());
      QLog.d("Util", 2, paramAbsBaseArticleInfo.toString());
    }
  }
  
  static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (DailyModeConfigHandler.a((int)paramAbsBaseArticleInfo.mChannelID)) {
      return;
    }
    if (paramAbsBaseArticleInfo.isCloseDislike == 1) {
      return;
    }
    if (a(paramAbsBaseArticleInfo))
    {
      QLog.d("Util", 1, "[bindDislikeButtonForChannel] new bottom bar has dislike btn, so return");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (RIJBaseItemViewType.d(paramAbsBaseArticleInfo))
    {
      localJSONObject.put("dislike_img", "dislike_img");
      paramJSONObject.put("id_bottom_dislike_button_style_a", localJSONObject);
      return;
    }
    if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID))
    {
      if ((!RIJFeedsType.I(paramAbsBaseArticleInfo)) && (!RIJFeedsType.z(paramAbsBaseArticleInfo)))
      {
        localJSONObject.put("feeds_dislike_icon", "feedback_more");
        localJSONObject.put("bottom_dislike_img", "feedback_more");
        paramJSONObject.put(paramString, localJSONObject);
      }
    }
    else
    {
      localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
      localJSONObject.put("bottom_dislike_img", "feeds_dislike");
      paramJSONObject.put(paramString, localJSONObject);
    }
  }
  
  static void b(JSONObject paramJSONObject)
  {
    boolean bool = ((Boolean)RIJSPUtils.a("kd_topic_recommend_card_jump_switch", Boolean.valueOf(false))).booleanValue();
    QLog.d("Util", 1, new Object[] { "bindTopicRecommendCardJumpWrapper, isJumpSwitchOn = ", Boolean.valueOf(bool) });
    if (bool) {
      paramJSONObject.put("id_jump_wrapper", new JSONObject());
    }
  }
  
  @VisibleForTesting
  static void b(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((RIJSocialBottomViewAladdinConfig.c()) && (!RIJSocialBottomViewAladdinConfig.b()))
    {
      int i = paramAbsBaseArticleInfo.mShareCount;
      if (i > 0) {
        paramAbsBaseArticleInfo = ReadInJoyHelper.b(i);
      } else {
        paramAbsBaseArticleInfo = HardCodeUtil.a(2131715705);
      }
      paramJSONObject.put("share_count_style_a", paramAbsBaseArticleInfo);
    }
  }
  
  private static void b(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (("guide_card_type".equals(paramString)) && ("1".equals(String.valueOf(paramObject))))
    {
      QLog.d("Util", 1, "bindSpecialData, show flow guide separator.");
      paramJSONObject.put("flow_guide_separator_color", "#f2f2f2");
    }
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAbsBaseArticleInfo != null) {
      bool1 = paramAbsBaseArticleInfo.needShowFollwedButton;
    } else {
      bool1 = false;
    }
    if (!bool1)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.isNeedShowBtnWhenFollowed)
        {
          bool1 = bool2;
          if (RIJBaseItemViewType.d(paramAbsBaseArticleInfo)) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      if (paramAbsBaseArticleInfo.subscriptLocation != 1)
      {
        QLog.d("Util", 2, "bindTopSuscriptInfo | not the right position");
        return;
      }
      paramJSONObject.put("top_mark_text", paramAbsBaseArticleInfo.subscriptWording);
      paramJSONObject.put("top_corner_mark", paramAbsBaseArticleInfo.subscriptType);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.subscriptWordingColor)) {
        paramJSONObject.put("top_mark_color", paramAbsBaseArticleInfo.subscriptWordingColor);
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.subscriptBgColor)) {
        paramJSONObject.put("top_mark_backgroundcolor", paramAbsBaseArticleInfo.subscriptBgColor);
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("bindTopSuscriptInfo | outData : ");
      paramAbsBaseArticleInfo.append(paramJSONObject.toString());
      QLog.d("Util", 2, paramAbsBaseArticleInfo.toString());
    }
  }
  
  static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    new JSONObject();
    String str = paramString;
    if (paramAbsBaseArticleInfo != null)
    {
      str = paramString;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString)) {
          str = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString;
        }
      }
    }
    paramJSONObject.put("biu_tips_text", str);
  }
  
  public static void c(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramJSONObject.put("dt_rowkey", paramAbsBaseArticleInfo.innerUniqueID);
    paramJSONObject.put("dt_content_type", paramAbsBaseArticleInfo.dtReportContentType);
    paramJSONObject.put("dt_channel_id", paramAbsBaseArticleInfo.mChannelID);
    paramJSONObject.put("dt_backend_info", paramAbsBaseArticleInfo.dtReportBackendInfo);
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mChannelID != 70L) && (RIJItemViewTypeUtils.k(paramAbsBaseArticleInfo));
  }
  
  public static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("info_source_text", a(paramAbsBaseArticleInfo.mSubscribeName));
      paramJSONObject.put("id_info_source", localJSONObject);
      boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.vIconUrl);
      if (!bool)
      {
        paramJSONObject.put("icon_v_url", paramAbsBaseArticleInfo.vIconUrl);
        return;
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.upIconUrl))
      {
        paramJSONObject.put("icon_v_url", paramAbsBaseArticleInfo.upIconUrl);
        return;
      }
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("bindSourceText error! msg=");
      paramJSONObject.append(paramAbsBaseArticleInfo);
      QLog.d("Util", 1, paramJSONObject.toString());
    }
  }
  
  static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    if (ArticleInfoHelper.a(paramAbsBaseArticleInfo)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    paramAbsBaseArticleInfo = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramAbsBaseArticleInfo = HardCodeUtil.a(2131715755);
    }
    localJSONObject.put("read_article", paramAbsBaseArticleInfo);
    paramJSONObject.put("id_read_article", localJSONObject);
    paramJSONObject.put("id_read_article_wrapper", new JSONObject());
  }
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mChannelID != 70L) && (RIJBaseItemViewType.e(paramAbsBaseArticleInfo));
  }
  
  public static void e(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramAbsBaseArticleInfo = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getADPosition(paramAbsBaseArticleInfo, BaseApplicationImpl.getContext(), "latitude", "longitude");
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad_Location", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_view_ad_coordinateView", localJSONObject);
    }
  }
  
  public static void e(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo != null))
    {
      Object localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo.jdField_b_of_type_JavaLangString;
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("artilce_title_text", localObject1);
      if (ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID)) {
        localObject1 = "#999999";
      } else {
        localObject1 = "#000000";
      }
      ((JSONObject)localObject2).put("title_text_color", localObject1);
      paramJSONObject.put("id_artilce_title", localObject2);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo.jdField_c_of_type_JavaLangString)) {
        localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo.jdField_c_of_type_JavaLangString;
      } else {
        localObject1 = "";
      }
      ((JSONObject)localObject2).put("summary_text", localObject1);
      paramJSONObject.put("id_summary", localObject2);
      int i = 12;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("article_small_imge_url", RIJSmartCropUtils.a(paramString, Utils.rp2px(114.0D), Utils.rp2px(87.0D)));
        paramJSONObject.put("id_article_small_imge", localObject1);
        i = 7;
      }
      int j = i;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.l))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("info_status_text", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.l);
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.m)) {
          paramString = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.m;
        } else {
          paramString = "#fe6c6c";
        }
        ((JSONObject)localObject1).put("info_status_text_color", paramString);
        ((JSONObject)localObject1).put("setBorderColorString", paramString);
        paramJSONObject.put("id_info_status", localObject1);
        j = i - 3;
      }
      localObject2 = new StringBuilder();
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo.jdField_a_of_type_Int > 0) {
        paramString = ReadInJoyHelper.a(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo.jdField_a_of_type_Int, 990000L, "99万", "0");
      } else {
        paramString = "0";
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.j))
      {
        localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.j;
        paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject1;
        if (((String)localObject1).length() > j)
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append(((String)localObject1).substring(0, j - 1));
          paramAbsBaseArticleInfo.append("...");
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
        }
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
        ((StringBuilder)localObject2).append("的回答 · ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("赞同");
      }
      else
      {
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("赞同");
      }
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("nickname_text", ((StringBuilder)localObject2).toString());
      paramJSONObject.put("id_nickname", paramAbsBaseArticleInfo);
    }
  }
  
  public static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.interfaceData)) && (paramAbsBaseArticleInfo.interfaceData.contains("ReadInJoy_auto_video_cell_no_padding"));
  }
  
  public static void f(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("article_model", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_view_AdBanner", localJSONObject);
    }
  }
  
  private static boolean f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool1 = paramAbsBaseArticleInfo instanceof BaseArticleInfo;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    String str;
    if (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) {
      str = "ugcShowPostTimeLabel";
    } else if (RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo)) {
      str = "commentShowPostTimeLabel";
    } else if (RIJItemViewTypeUtils.d(paramAbsBaseArticleInfo)) {
      str = "biuShowPostTimeLabel";
    } else if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo)) {
      str = "pgcShowPostTimeLabel";
    } else if ((RIJItemViewTypeUtils.i(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo)) && (!RIJBaseItemViewType.c(paramAbsBaseArticleInfo))) {
      str = "partnerShowPostTimeLabel";
    } else if (RIJItemViewTypeUtils.j(paramAbsBaseArticleInfo)) {
      str = "liveSingleCardShowPostTimeLabel";
    } else if (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo)) {
      str = "wechatVideoCardShowPostTimeLabel";
    } else if (RIJBaseItemViewType.c(paramAbsBaseArticleInfo)) {
      str = "HotSearchCardShowPostTimeLabel";
    } else {
      str = "";
    }
    if (!c(paramAbsBaseArticleInfo))
    {
      bool1 = bool2;
      if (!RIJItemViewTypeUtils.i(paramAbsBaseArticleInfo)) {}
    }
    else
    {
      bool1 = bool2;
      if (Aladdin.getConfig(297).getIntegerFromString(str, 0) == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void g(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (DailyModeConfigHandler.a((int)paramAbsBaseArticleInfo.mChannelID)) {
      return;
    }
    if (paramAbsBaseArticleInfo.isCloseDislike == 1) {
      return;
    }
    localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
    paramJSONObject.put("id_dislike_button", localJSONObject);
  }
  
  private static boolean g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  public static void h(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.hasFamilyCommentIcon()))
    {
      j(paramAbsBaseArticleInfo, paramJSONObject);
      return;
    }
    i(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  private static boolean h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo)) || (RIJBaseItemViewType.d(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo));
  }
  
  public static void i(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    long l2 = paramAbsBaseArticleInfo.mCommentCount;
    long l1 = 0L;
    if (l2 > 0L) {
      l1 = paramAbsBaseArticleInfo.mCommentCount;
    } else if (paramAbsBaseArticleInfo.mVideoCommentCount > 0) {
      l1 = paramAbsBaseArticleInfo.mVideoCommentCount;
    }
    if (!ReadInJoyHelper.a(paramAbsBaseArticleInfo, l1)) {
      return;
    }
    if (l1 > 99990000L)
    {
      localStringBuilder.append("9999万+");
    }
    else if (l1 > 10000L)
    {
      double d = l1;
      Double.isNaN(d);
      d /= 10000.0D;
      localStringBuilder.append(new DecimalFormat("0.0").format(d));
      localStringBuilder.append("万");
    }
    else
    {
      localStringBuilder.append(l1);
    }
    if (paramAbsBaseArticleInfo.mFeedType != 39) {
      localStringBuilder.append("评论");
    } else {
      localStringBuilder.append("人在玩");
    }
    localJSONObject.put("article_comment_num", localStringBuilder.toString());
    paramJSONObject.put("id_comment_num", localJSONObject);
  }
  
  private static boolean i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool1 = paramAbsBaseArticleInfo instanceof BaseArticleInfo;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    String str;
    if (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) {
      str = "ugcShowFollowBtn";
    } else if (RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo)) {
      str = "commentShowFollowBtn";
    } else if (RIJItemViewTypeUtils.d(paramAbsBaseArticleInfo)) {
      str = "biuShowFollowBtn";
    } else if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo)) {
      str = "pgcShowFollowBtn";
    } else if ((RIJItemViewTypeUtils.i(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo)) && (!RIJBaseItemViewType.c(paramAbsBaseArticleInfo))) {
      str = "partnerShowFollowBtn";
    } else if (RIJItemViewTypeUtils.j(paramAbsBaseArticleInfo)) {
      str = "liveSingleCardShowFollowBtn";
    } else if (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo)) {
      str = "wechatVideoCardShowFollowBtn";
    } else if (RIJBaseItemViewType.c(paramAbsBaseArticleInfo)) {
      str = "HotSearchCardShowFollowBtn";
    } else {
      str = "";
    }
    if (!c(paramAbsBaseArticleInfo))
    {
      bool1 = bool2;
      if (!RIJItemViewTypeUtils.i(paramAbsBaseArticleInfo)) {}
    }
    else
    {
      bool1 = bool2;
      if (Aladdin.getConfig(297).getIntegerFromString(str, 0) == 1)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.isShowFollowButton == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  static void j(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.familyCommentInfo == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString))
      {
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString)) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("family_icon_url", paramAbsBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("family_jump_schema", paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString);
        if (paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
          localJSONObject.put("family_icon_wh_rate", paramAbsBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int / paramAbsBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int);
        }
        paramJSONObject.put("id_img_family_icon", localJSONObject);
      }
    }
  }
  
  private static boolean j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("Util", 2, "info == null");
      return false;
    }
    if (paramAbsBaseArticleInfo.mSocialFeedInfo == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info == ");
      localStringBuilder.append(paramAbsBaseArticleInfo);
      QLog.d("Util", 2, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  static void k(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
      return;
    }
    Object localObject = new JSONObject();
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
      ((JSONObject)localObject).put("info_avator_uin", l1);
      ((JSONObject)localObject).put("article_model", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_info_avator", localObject);
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("nickname_text", RIJStringUtils.a(paramAbsBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_nickname", localObject);
    paramJSONObject.put("id_view_nickname", new JSONObject());
    JSONObject localJSONObject = new JSONObject();
    localObject = HardCodeUtil.a(2131715752);
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int > 0) {
      localObject = ReadInJoyHelper.a(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_comment_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("comment_count", "");
    paramJSONObject.put("id_comment_button", localObject);
    localJSONObject = new JSONObject();
    localObject = HardCodeUtil.a(2131715761);
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int > 0) {
      localObject = ReadInJoyHelper.a(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_like_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("like_count", "");
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int == 1) {
      ((JSONObject)localObject).put("selected_state", "1");
    } else {
      ((JSONObject)localObject).put("selected_state", "0");
    }
    paramJSONObject.put("id_like_button", localObject);
    paramJSONObject.put("id_share_button", new JSONObject());
    paramJSONObject.put("id_img_biu_right", new JSONObject());
    paramJSONObject.put("id_biu_separator", new JSONObject());
    paramJSONObject.put("id_view_comment", new JSONObject());
    paramJSONObject.put("id_view_like", new JSONObject());
    paramJSONObject.put("id_view_share", new JSONObject());
    paramJSONObject.put("id_img_biu_bottom", new JSONObject());
    c(paramJSONObject, paramAbsBaseArticleInfo);
  }
  
  private static boolean k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    List localList = paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localList != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  static void l(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a()))
    {
      new JSONObject();
      paramJSONObject.put("star_postmark", "readinjoy_star_postmark.png");
    }
  }
  
  private static boolean l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)) {
        return false;
      }
      try
      {
        boolean bool = TextUtils.equals("ReadInJoy_double_video_cell_no_padding", new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).optString("style_ID", ""));
        return bool;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isNoPaddingDoubleCard] e = ");
        localStringBuilder.append(paramAbsBaseArticleInfo);
        QLog.e("Util", 1, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  static void m(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.mDianDianLabelIconUrl)) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mDianDianLabelText)))
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject.put("id_label_wrapper", localJSONObject);
      paramJSONObject.put("id_label_header", localJSONObject);
      paramJSONObject.put("id_label_separator_line", localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("label_icon_url", paramAbsBaseArticleInfo.mDianDianLabelIconUrl);
      paramJSONObject.put("id_label_icon", localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("label_text", paramAbsBaseArticleInfo.mDianDianLabelText);
      paramJSONObject.put("id_label_text", localJSONObject);
    }
  }
  
  public static void n(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_separator", new JSONObject());
  }
  
  public static void o(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = paramAbsBaseArticleInfo.multiBiuSameContentList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramAbsBaseArticleInfo = new JSONObject();
      localObject = ((List)localObject).iterator();
      int i = 1;
      while (((Iterator)localObject).hasNext())
      {
        MultiBiuSameContent localMultiBiuSameContent = (MultiBiuSameContent)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMultiBiuSameContent.jdField_a_of_type_Long);
        localStringBuilder.append("");
        localStringBuilder.append(i);
        paramAbsBaseArticleInfo.put(localStringBuilder.toString(), localMultiBiuSameContent.jdField_a_of_type_Long);
        i += 1;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("uin_list", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_friends_biu", localObject);
      paramJSONObject.put("id_friends_biu_wrapper", new JSONObject());
      paramJSONObject.put("id_friends_biu_separator_line", new JSONObject());
    }
  }
  
  static void p(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if (1 == ((SocializeFeedsInfo)localObject).l)
      {
        paramAbsBaseArticleInfo = ((SocializeFeedsInfo)localObject).jdField_f_of_type_JavaLangString;
        localObject = ((SocializeFeedsInfo)localObject).g;
        if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          JSONObject localJSONObject = b();
          localJSONObject.put("jump_channel_bar_url", paramAbsBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_bar", localJSONObject);
          paramAbsBaseArticleInfo = b();
          paramAbsBaseArticleInfo.put("jump_channel_name", localObject);
          paramJSONObject.put("id_jump_channel_name", paramAbsBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_separator", b());
        }
      }
    }
  }
  
  static void q(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if (paramAbsBaseArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo != null) {
        RIJMedalUtils.a(paramJSONObject, paramAbsBaseArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo);
      }
    }
  }
  
  static void r(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (RIJBaseItemViewType.d(paramAbsBaseArticleInfo))
    {
      if (d(paramAbsBaseArticleInfo))
      {
        paramJSONObject.put("id_social_header_padding_view", localJSONObject);
        return;
      }
      paramJSONObject.put("id_feeds_social_header_wrapper", localJSONObject);
      paramJSONObject.put("id_feeds_social_header", localJSONObject);
      return;
    }
    paramJSONObject.put("id_social_header_wrapper", localJSONObject);
    paramJSONObject.put("id_social_header", localJSONObject);
  }
  
  public static void s(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    new JSONObject();
    paramJSONObject.put("nickname_text", RIJStringUtils.a(paramAbsBaseArticleInfo.mSubscribeName));
    c(paramJSONObject, paramAbsBaseArticleInfo);
  }
  
  static void t(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_JavaLangString))
    {
      localJSONObject.put("short_content_desc_text", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_JavaLangString);
      paramJSONObject.put("id_description_label", localJSONObject);
    }
  }
  
  static void u(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser == null) {
        return;
      }
      String str = ReadInJoyUserInfoModule.a();
      new JSONObject();
      paramJSONObject.put("nickname_text", RIJStringUtils.a(str));
      c(paramJSONObject, paramAbsBaseArticleInfo);
    }
  }
  
  static void v(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    String str = a(paramAbsBaseArticleInfo);
    if (!TextUtils.isEmpty(str)) {
      paramJSONObject.put("biu_time_text", str);
    }
    x(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public static void w(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramJSONObject.put("header_extra_info", Aladdin.getConfig(393).getString("comment_social_header_description", ""));
  }
  
  public static void x(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i;
    if ((RIJBaseItemViewType.d(paramAbsBaseArticleInfo)) && (!b(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.h == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramAbsBaseArticleInfo.showMyFollowText = 1;
      paramJSONObject.put("user_desc_follow_text", HardCodeUtil.a(2131718134));
      return;
    }
    paramAbsBaseArticleInfo.showMyFollowText = 0;
    c(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  static void y(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo == null) {
        return;
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo;
      paramJSONObject.put("id_account_card_container", b());
      paramJSONObject.put("id_cmp_account_card", b());
      JSONObject localJSONObject = b();
      localJSONObject.put("cmp_account_card_avator", paramAbsBaseArticleInfo.jdField_b_of_type_JavaLangString);
      paramJSONObject.put("id_cmp_account_card_avator", localJSONObject);
      localJSONObject = b();
      localJSONObject.put("cmp_account_card_name", paramAbsBaseArticleInfo.jdField_a_of_type_JavaLangString);
      paramJSONObject.put("id_cmp_account_card_name", localJSONObject);
      localJSONObject = b();
      localJSONObject.put("cmp_account_card_desc", paramAbsBaseArticleInfo.jdField_c_of_type_JavaLangString);
      paramJSONObject.put("id_cmp_account_card_desc", localJSONObject);
    }
  }
  
  static void z(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    boolean bool = g(paramAbsBaseArticleInfo);
    int i = 1;
    if (!bool)
    {
      QLog.d("Util", 1, "bindTopicRecommendHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    Object localObject1 = new JSONObject();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.businessNamePrefix);
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.businessName);
    ((JSONObject)localObject1).put("topic_name", ((StringBuilder)localObject2).toString());
    paramJSONObject.put("id_topic_name", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("topic_avator_url", ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString);
    paramJSONObject.put("id_topic_avator", localObject1);
    B(paramAbsBaseArticleInfo, paramJSONObject);
    if ((RIJFeedsType.j(paramAbsBaseArticleInfo)) || (RIJFeedsType.m(paramAbsBaseArticleInfo)))
    {
      localObject2 = new JSONObject();
      if (((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int != 1) {
        i = 0;
      }
      int j;
      if (i != 0) {
        j = 2131715756;
      } else {
        j = 2131715750;
      }
      ((JSONObject)localObject2).put("button_status", HardCodeUtil.a(j));
      if (i != 0) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ((JSONObject)localObject2).put("selected_status", localObject1);
      paramJSONObject.put("id_follow_button", localObject2);
    }
    paramJSONObject.put("id_header_line", new JSONObject());
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("topic_name_only", paramAbsBaseArticleInfo.businessName);
    paramJSONObject.put("id_topic_name_only", localObject1);
    paramJSONObject.put("id_topic_more", new JSONObject());
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("topic_pre", paramAbsBaseArticleInfo.businessNamePrefix);
    paramJSONObject.put("id_topic_pre", localObject1);
    paramAbsBaseArticleInfo = new JSONObject();
    paramAbsBaseArticleInfo.put("topic_arrow_img", "topic_arrow_image");
    paramJSONObject.put("id_topic_arrow_img", paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.Util
 * JD-Core Version:    0.7.0.1
 */