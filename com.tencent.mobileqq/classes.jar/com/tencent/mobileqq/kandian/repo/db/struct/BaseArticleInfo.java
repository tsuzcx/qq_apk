package com.tencent.mobileqq.kandian.repo.db.struct;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.ArkAppFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ShortWithLongContentUtil;
import com.tencent.mobileqq.kandian.repo.feeds.api.IVideoCardUIModelFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ExtraBiuBriefInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.pts.PTSParcelableUtil;
import com.tencent.mobileqq.kandian.repo.video.IVideoCardUIModel;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.MultiBiuSameContent;
import tencent.im.oidb.articlesummary.articlesummary.NewPackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

@Deprecated
public class BaseArticleInfo
  extends AbsBaseArticleInfo
{
  public static final Parcelable.Creator<BaseArticleInfo> CREATOR = ;
  private static final String TAG = "Q.readinjoy.BaseArticleInfo";
  @notColumn
  private PTSComposer.IPTSUpdateDataListener ptsUpdateDataListener = new BaseArticleInfo.1(this);
  
  public BaseArticleInfo() {}
  
  public BaseArticleInfo(Parcel paramParcel)
  {
    readFromParcel(this, paramParcel);
  }
  
  private void convertToPB()
  {
    if (this.mSocialFeedInfo != null) {
      this.mSocialFeedInfoByte = this.mSocialFeedInfo.a();
    }
    if (this.mVideoColumnInfo != null) {
      this.mVideoColumnInfoBytes = this.mVideoColumnInfo.a();
    }
    if (this.mSimpleVideoColumnInfo != null) {
      this.mSimpleVideoColumnInfoBytes = this.mSimpleVideoColumnInfo.a();
    }
    if (this.mNewPolymericInfo != null) {
      this.mNewPackInfoBytes = this.mNewPolymericInfo.a();
    }
    if (this.mRecommendFollowInfos != null) {
      this.mRecommendFollowInfoBytes = this.mRecommendFollowInfos.a();
    }
    if (this.hotWordInfo != null) {
      this.hotWordInfoListBytes = this.hotWordInfo.a();
    }
  }
  
  private String getPartnerAccountInfoStr()
  {
    if (this.mPartnerAccountInfo != null) {
      return String.format("{uin: %d, head jump url: %s, reason: %s, icon_url: %s, display: %d}", new Object[] { Long.valueOf(this.mPartnerAccountInfo.uint64_uin.get()), this.mPartnerAccountInfo.bytes_head_jump_url.get().toStringUtf8(), this.mPartnerAccountInfo.bytes_recommend_reason.get().toStringUtf8(), this.mPartnerAccountInfo.bytes_v_icon_url.get().toStringUtf8(), Integer.valueOf(this.mPartnerAccountInfo.uint32_is_account_display.get()) });
    }
    return null;
  }
  
  private void handleFeedsTypeInOldVersionDatabaseForGalleryCard()
  {
    if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.c == 1) && ((this.mSocialFeedInfo.jdField_a_of_type_Int == 9) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 3) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 8)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("rewrite feedstype for gallery card articleinfo = ");
        localStringBuilder.append(toString());
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, localStringBuilder.toString());
      }
      if (this.mFeedType == 1)
      {
        if (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) {
          this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = new BiuInfo();
        }
        if ((this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b == null) || (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue() != 23))
        {
          this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b = new Long(23L);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu gallery card");
          }
        }
      }
      else if ((this.mFeedType == 6) || (this.mFeedType == 7) || (this.mFeedType == 8) || (this.mFeedType == 9) || (this.mFeedType == 12))
      {
        this.mFeedType = 23;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for gallery card");
        }
      }
    }
  }
  
  private void handleFeedsTypeInOldVersionDatabaseForNewPolymericInfo()
  {
    if ((this.mNewPolymericInfo != null) && (this.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null) && (this.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() > 1))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("rewrite feedstype for new pack card articleinfo = ");
        localStringBuilder.append(toString());
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, localStringBuilder.toString());
      }
      if ((this.mFeedType != 24) && (this.mFeedType != 29))
      {
        this.mFeedType = 24;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for new pack card");
        }
      }
    }
  }
  
  private void handleFeedsTypeInOldVersionDatabaseForQACard()
  {
    if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("rewrite feedstype for wenda article articleinfo = ");
        localStringBuilder.append(toString());
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, localStringBuilder.toString());
      }
      if ((this.mFeedType == 1) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b != null) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
      {
        if ((this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 3) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue() != 21))
        {
          this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b = Long.valueOf(21L);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu question card");
          }
        }
        else if ((this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 4) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue() != 22))
        {
          this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b = Long.valueOf(22L);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu answer card");
          }
        }
      }
      else if ((this.mFeedType != 1) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)) {
        if ((this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 3) && (this.mFeedType != 21))
        {
          this.mFeedType = 21;
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for question card");
          }
        }
        else if ((this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 4) && (this.mFeedType != 22))
        {
          this.mFeedType = 22;
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for answer card");
          }
        }
      }
    }
  }
  
  private void handlePBValueFromStream1()
  {
    this.mCommentsObj = RIJPBFieldUtils.a(this.mCommentInfoBytes, articlesummary.CommentInfo.class);
    this.mMultiBiuSameListObj = RIJPBFieldUtils.a(this.mMultiBiuSameListBytes, articlesummary.MultiBiuSameContent.class);
    if (this.mMultiBiuSameListObj != null) {
      this.multiBiuSameContentList = MultiBiuSameContentUtils.a(this.mMultiBiuSameListObj);
    }
    this.mPackInfoObj = ((articlesummary.PackInfo)RIJPBFieldUtils.a(this.mPackInfoBytes, new articlesummary.PackInfo()));
    if (this.mPackInfoObj != null)
    {
      this.mGroupId = RIJPBFieldUtils.a(this.mPackInfoObj.uint64_pack_id);
      this.mPolymericInfo = PolymericInfo.a(this.mPackInfoObj);
    }
    this.mSubscribeInfoObj = ((articlesummary.SubscribeInfo)RIJPBFieldUtils.a(this.mSubscribeInfoBytes, new articlesummary.SubscribeInfo()));
    Object localObject = (articlesummary.SocializeFeedsInfo)RIJPBFieldUtils.a(this.mSocialFeedInfoByte, new articlesummary.SocializeFeedsInfo());
    if (localObject != null) {
      this.mSocialFeedInfo = SocializeFeedsInfoUtils.a((articlesummary.SocializeFeedsInfo)localObject);
    }
    localObject = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(this.mVideoColumnInfoBytes, new articlesummary.VideoColumnInfo());
    if (localObject != null) {
      this.mVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)localObject);
    }
    localObject = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(this.multiVideoColumnInfoBytes, new articlesummary.VideoColumnInfo());
    if (localObject != null) {
      this.multiVideoColumnInfo = MultiVideoColumnInfo.a((articlesummary.VideoColumnInfo)localObject);
    }
    localObject = (articlesummary.KdLiveInfo)RIJPBFieldUtils.a(this.mKdLiveInfoBytes, new articlesummary.KdLiveInfo());
    if (localObject != null) {
      this.mKdLiveInfo = KandianLiveInfo.a((articlesummary.KdLiveInfo)localObject);
    }
    localObject = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(this.mSimpleVideoColumnInfoBytes, new articlesummary.VideoColumnInfo());
    if (localObject != null) {
      this.mSimpleVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)localObject);
    }
    localObject = (articlesummary.ScripCmsInfo)RIJPBFieldUtils.a(this.scripCmsInfoByte, new articlesummary.ScripCmsInfo());
    if (localObject != null) {
      this.scripCmsInfo = ScripCmsInfo.a((articlesummary.ScripCmsInfo)localObject);
    }
    localObject = (articlesummary.FamilyCommentInfo)RIJPBFieldUtils.a(this.familyCommentInfoByte, new articlesummary.FamilyCommentInfo());
    if (localObject != null) {
      this.familyCommentInfo = FamilyCommentInfo.a((articlesummary.FamilyCommentInfo)localObject);
    }
  }
  
  private void handlePBValueFromStream2()
  {
    this.mLabelListObj = RIJPBFieldUtils.a(this.mLableListInfoBytes, articlesummary.ChannelInfo.class);
    Object localObject = (articlesummary.TopicRecommendFeedsInfo)RIJPBFieldUtils.a(this.mTopicRecommendFeedsInfoByte, new articlesummary.TopicRecommendFeedsInfo());
    if (localObject != null) {
      this.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a((articlesummary.TopicRecommendFeedsInfo)localObject);
    }
    localObject = (articlesummary.ArkAppFeedsInfo)RIJPBFieldUtils.a(this.mArkAppFeedsInfoBytes, new articlesummary.ArkAppFeedsInfo());
    if (localObject != null) {
      this.mArkAppFeedsInfo = ArkAppFeedsInfo.a((articlesummary.ArkAppFeedsInfo)localObject);
    }
    this.mSubSummaryListObj = RIJPBFieldUtils.a(this.mSubArticleListBytes, articlesummary.ArticleSummary.class);
    if ((this.mSubSummaryListObj != null) && (this.mSubSummaryListObj.size() > 0))
    {
      localObject = new ArrayList(this.mSubSummaryListObj.size());
      Iterator localIterator = this.mSubSummaryListObj.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)localIterator.next(), (int)this.mChannelID, 0, null));
      }
      this.mSubArticleList = ((List)localObject);
    }
    localObject = (articlesummary.NewPackInfo)RIJPBFieldUtils.a(this.mNewPackInfoBytes, new articlesummary.NewPackInfo());
    if (localObject != null) {
      this.mNewPolymericInfo = NewPolymericInfo.a((articlesummary.NewPackInfo)localObject);
    }
    localObject = (articlesummary.RecommendFollowInfos)RIJPBFieldUtils.a(this.mRecommendFollowInfoBytes, new articlesummary.RecommendFollowInfos());
    if (localObject != null) {
      this.mRecommendFollowInfos = RecommendFollowInfos.a((articlesummary.RecommendFollowInfos)localObject);
    }
    localObject = (articlesummary.HotWordInfo)RIJPBFieldUtils.a(this.hotWordInfoListBytes, new articlesummary.HotWordInfo());
    if (localObject != null) {
      this.hotWordInfo = HotWordInfo.a((articlesummary.HotWordInfo)localObject);
    }
    localObject = (articlesummary.AggregatedList)RIJPBFieldUtils.a(this.mExtraBiuBriefBytes, new articlesummary.AggregatedList());
    if (localObject != null) {
      this.mExtraBiuBriefInfo = ExtraBiuBriefInfo.a((articlesummary.AggregatedList)localObject);
    }
    handlerFeedsTypeInOldVersionDatabase();
    this.mGalleryFeedsInfo = ((galleryFeeds.GalleryFeedsInfo)RIJPBFieldUtils.a(this.bytesBusiData, new galleryFeeds.GalleryFeedsInfo()));
    this.mVideoDownloadBarInfo = ((articlesummary.VideoDownloadBarInfo)RIJPBFieldUtils.a(this.mVideoDownloadBarInfoBytes, new articlesummary.VideoDownloadBarInfo()));
    this.mPartnerAccountInfo = ((articlesummary.PartnerAccountInfo)RIJPBFieldUtils.a(this.mPartnerAccountInfoBytes, new articlesummary.PartnerAccountInfo()));
    this.srtUniversalID = RIJPBFieldUtils.a(this.srtUniversalIDBytesList, articlesummary.SRTUniversalID.class);
    this.weishiUGInfo = ((articlesummary.WeishiUGInfo)RIJPBFieldUtils.a(this.mWeishiUGInfo, new articlesummary.WeishiUGInfo()));
    ShortWithLongContentUtil.a(this);
  }
  
  public static Parcelable.Creator<BaseArticleInfo> makeArticleInfoCreator()
  {
    return new BaseArticleInfo.2();
  }
  
  private void readArkAppFeedsInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramAbsBaseArticleInfo.mArkAppFeedsInfoBytes = null;
      return;
    }
    paramAbsBaseArticleInfo.mArkAppFeedsInfoBytes = new byte[i];
    paramParcel.readByteArray(paramAbsBaseArticleInfo.mArkAppFeedsInfoBytes);
    paramParcel = new articlesummary.ArkAppFeedsInfo();
    try
    {
      paramParcel.mergeFrom(paramAbsBaseArticleInfo.mArkAppFeedsInfoBytes);
      paramAbsBaseArticleInfo.mArkAppFeedsInfo = ArkAppFeedsInfo.a(paramParcel);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel)
    {
      paramParcel.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "convertPBToInfo arkAppFeedsInfo failed.");
      }
      paramAbsBaseArticleInfo.mArkAppFeedsInfo = null;
    }
  }
  
  private void readCommentInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.mCommentInfoBytes = null;
      return;
    }
    paramAbsBaseArticleInfo.mCommentInfoBytes = new byte[i];
    if (i > 0) {
      paramParcel.readByteArray(paramAbsBaseArticleInfo.mCommentInfoBytes);
    }
  }
  
  private void readExtraBiuBrief(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.mExtraBiuBriefBytes = null;
      return;
    }
    if (i > 0)
    {
      paramAbsBaseArticleInfo.mExtraBiuBriefBytes = new byte[i];
      paramParcel.readByteArray(paramAbsBaseArticleInfo.mExtraBiuBriefBytes);
    }
  }
  
  private void readFromParcel(BaseArticleInfo paramBaseArticleInfo, Parcel paramParcel)
  {
    paramBaseArticleInfo.mArticleID = paramParcel.readLong();
    paramBaseArticleInfo.mTitle = paramParcel.readString();
    paramBaseArticleInfo.mSummary = paramParcel.readString();
    paramBaseArticleInfo.mFirstPagePicUrl = paramParcel.readString();
    paramBaseArticleInfo.mOriginalUrl = paramParcel.readString();
    paramBaseArticleInfo.mArticleContentUrl = paramParcel.readString();
    paramBaseArticleInfo.mTime = paramParcel.readLong();
    paramBaseArticleInfo.mCommentCount = paramParcel.readLong();
    paramBaseArticleInfo.mSubscribeID = paramParcel.readString();
    paramBaseArticleInfo.mSubscribeName = paramParcel.readString();
    paramBaseArticleInfo.mRecommendTime = paramParcel.readLong();
    paramBaseArticleInfo.mChannelID = paramParcel.readLong();
    paramBaseArticleInfo.mRecommendSeq = paramParcel.readLong();
    int i = paramParcel.readByte();
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramBaseArticleInfo.mShowBigPicture = bool1;
    paramBaseArticleInfo.mStrategyId = paramParcel.readInt();
    paramBaseArticleInfo.articleStyle = paramParcel.readInt();
    paramBaseArticleInfo.interfaceData = paramParcel.readString();
    paramBaseArticleInfo.galleryReprotExdData = paramParcel.readString();
    paramBaseArticleInfo.mAlgorithmID = paramParcel.readLong();
    paramBaseArticleInfo.mArticleFriendLikeText = paramParcel.readString();
    paramBaseArticleInfo.mTopicPicWHRatio = paramParcel.readDouble();
    paramBaseArticleInfo.mTopicPicInfo = paramParcel.readString();
    readPictureInfo(paramBaseArticleInfo, paramParcel);
    paramBaseArticleInfo.mVideoCoverUrl = RIJConvertString2URL.a(paramParcel.readString());
    paramBaseArticleInfo.mVideoVid = paramParcel.readString();
    paramBaseArticleInfo.mVideoDuration = paramParcel.readInt();
    paramBaseArticleInfo.mCommentIconType = paramParcel.readInt();
    readServeContext(paramBaseArticleInfo, paramParcel);
    readCommentInfo(paramBaseArticleInfo, paramParcel);
    readPackInfo(paramBaseArticleInfo, paramParcel);
    paramBaseArticleInfo.postRead();
    paramBaseArticleInfo.mCircleId = paramParcel.readLong();
    paramBaseArticleInfo.mStrCircleId = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramBaseArticleInfo.mPUinIsActive = bool1;
    readSubscribeInfo(paramBaseArticleInfo, paramParcel);
    paramBaseArticleInfo.mFeedType = paramParcel.readInt();
    paramBaseArticleInfo.mFeedId = paramParcel.readLong();
    readSocialFeedInfo(paramBaseArticleInfo, paramParcel);
    paramBaseArticleInfo.innerUniqueID = paramParcel.readString();
    paramBaseArticleInfo.businessId = paramParcel.readLong();
    paramBaseArticleInfo.businessName = paramParcel.readString();
    paramBaseArticleInfo.businessUrl = paramParcel.readString();
    paramBaseArticleInfo.businessNamePrefix = paramParcel.readString();
    readTopicRecommendFeedsInfo(paramBaseArticleInfo, paramParcel);
    readArkAppFeedsInfo(paramBaseArticleInfo, paramParcel);
    paramBaseArticleInfo.publishUin = paramParcel.readLong();
    paramBaseArticleInfo.mMergeVideoId = paramParcel.readLong();
    paramBaseArticleInfo.mVideoCommentCount = paramParcel.readInt();
    paramBaseArticleInfo.proteusItemsData = paramParcel.readString();
    paramBaseArticleInfo.mAccountLess = paramParcel.readInt();
    paramBaseArticleInfo.mVideoArticleSubsText = paramParcel.readString();
    paramBaseArticleInfo.mVideoArticleSubsColor = paramParcel.readString();
    paramBaseArticleInfo.mVideoAdsJumpUrl = paramParcel.readString();
    paramBaseArticleInfo.mVideoAdsJumpType = paramParcel.readInt();
    paramBaseArticleInfo.mVideoAdsSource = paramParcel.readInt();
    paramBaseArticleInfo.videoReportInfo = paramParcel.readString();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramBaseArticleInfo.isTwoItem = bool1;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramBaseArticleInfo.isSuperTopic = bool1;
    readNewPackInfo(paramBaseArticleInfo, paramParcel);
    readRecommendFollowInfo(paramBaseArticleInfo, paramParcel);
    paramBaseArticleInfo.mRecommendFollowId = paramParcel.readLong();
    paramBaseArticleInfo.gifCoverUrl = paramParcel.readString();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramBaseArticleInfo.isUseGif = bool1;
    readExtraBiuBrief(paramBaseArticleInfo, paramParcel);
    readMultiBiuSameList(paramBaseArticleInfo, paramParcel);
    paramBaseArticleInfo.mIsGallery = paramParcel.readInt();
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    paramBaseArticleInfo.mIsGalleryChannel = bool1;
    readHotWordInfo(paramBaseArticleInfo, paramParcel);
    this.busiType = paramParcel.readInt();
    paramBaseArticleInfo.mGWCommonData = paramParcel.readString();
    paramBaseArticleInfo.mReportCommonData = paramParcel.readString();
    paramBaseArticleInfo.recommendedFlag = paramParcel.readInt();
    ShortWithLongContentUtil.a(paramBaseArticleInfo);
    readPtsItemData(paramBaseArticleInfo, paramParcel);
  }
  
  private void readHotWordInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.hotWordInfoListBytes = null;
      return;
    }
    if (i > 0)
    {
      paramAbsBaseArticleInfo.hotWordInfoListBytes = new byte[i];
      paramParcel.readByteArray(paramAbsBaseArticleInfo.hotWordInfoListBytes);
    }
  }
  
  private void readMultiBiuSameList(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.mMultiBiuSameListBytes = null;
      return;
    }
    if (i > 0)
    {
      paramAbsBaseArticleInfo.mMultiBiuSameListBytes = new byte[i];
      paramParcel.readByteArray(paramAbsBaseArticleInfo.mMultiBiuSameListBytes);
    }
  }
  
  private void readNewPackInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.mNewPackInfoBytes = null;
      return;
    }
    paramAbsBaseArticleInfo.mNewPackInfoBytes = new byte[i];
    if (i > 0) {
      paramParcel.readByteArray(paramAbsBaseArticleInfo.mNewPackInfoBytes);
    }
  }
  
  private void readPackInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.mPackInfoBytes = null;
      return;
    }
    paramAbsBaseArticleInfo.mPackInfoBytes = new byte[i];
    if (i > 0) {
      paramParcel.readByteArray(paramAbsBaseArticleInfo.mPackInfoBytes);
    }
  }
  
  private void readPictureInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    if (j > 0)
    {
      paramAbsBaseArticleInfo.mPictures = new URL[j];
      int i = 0;
      while (i < j)
      {
        paramAbsBaseArticleInfo.mPictures[i] = RIJConvertString2URL.a(paramParcel.readString());
        i += 1;
      }
    }
    paramAbsBaseArticleInfo.mSinglePicture = RIJConvertString2URL.a(paramParcel.readString());
  }
  
  private void readPtsItemData(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i > 0)
    {
      paramAbsBaseArticleInfo.ptsItemDataBytes = new byte[i];
      paramParcel.readByteArray(paramAbsBaseArticleInfo.ptsItemDataBytes);
      paramAbsBaseArticleInfo.ptsItemData = ((PTSItemData)PTSParcelableUtil.a(paramAbsBaseArticleInfo.ptsItemDataBytes, PTSItemData.CREATOR));
      return;
    }
    paramAbsBaseArticleInfo.ptsItemDataBytes = null;
    paramAbsBaseArticleInfo.ptsItemData = null;
  }
  
  private void readRecommendFollowInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramAbsBaseArticleInfo.mRecommendFollowInfoBytes = null;
      return;
    }
    paramAbsBaseArticleInfo.mRecommendFollowInfoBytes = new byte[i];
    paramParcel.readByteArray(paramAbsBaseArticleInfo.mRecommendFollowInfoBytes);
  }
  
  private void readServeContext(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.mServerContext = null;
      return;
    }
    paramAbsBaseArticleInfo.mServerContext = new byte[i];
    if (i > 0) {
      paramParcel.readByteArray(paramAbsBaseArticleInfo.mServerContext);
    }
  }
  
  private void readSocialFeedInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramAbsBaseArticleInfo.mSocialFeedInfoByte = null;
      return;
    }
    paramAbsBaseArticleInfo.mSocialFeedInfoByte = new byte[i];
    paramParcel.readByteArray(paramAbsBaseArticleInfo.mSocialFeedInfoByte);
    paramParcel = new articlesummary.SocializeFeedsInfo();
    try
    {
      paramParcel.mergeFrom(paramAbsBaseArticleInfo.mSocialFeedInfoByte);
      paramAbsBaseArticleInfo.mSocialFeedInfo = SocializeFeedsInfoUtils.a(paramParcel);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel)
    {
      QLog.e("Q.readinjoy.BaseArticleInfo", 1, "createFromParcel: ", paramParcel);
      paramAbsBaseArticleInfo.mSocialFeedInfo = null;
    }
  }
  
  private void readSubscribeInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramAbsBaseArticleInfo.mSubscribeInfoBytes = null;
      return;
    }
    paramAbsBaseArticleInfo.mSubscribeInfoBytes = new byte[i];
    if (i > 0) {
      paramParcel.readByteArray(paramAbsBaseArticleInfo.mSubscribeInfoBytes);
    }
  }
  
  private void readTopicRecommendFeedsInfo(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramAbsBaseArticleInfo.mTopicRecommendFeedsInfoByte = null;
      return;
    }
    paramAbsBaseArticleInfo.mTopicRecommendFeedsInfoByte = new byte[i];
    paramParcel.readByteArray(paramAbsBaseArticleInfo.mTopicRecommendFeedsInfoByte);
    paramParcel = new articlesummary.TopicRecommendFeedsInfo();
    try
    {
      paramParcel.mergeFrom(paramAbsBaseArticleInfo.mTopicRecommendFeedsInfoByte);
      paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a(paramParcel);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel)
    {
      QLog.e("Q.readinjoy.BaseArticleInfo", 1, "createFromParcel: ", paramParcel);
      paramAbsBaseArticleInfo.mSocialFeedInfo = null;
    }
  }
  
  private void setPublishUinBySubscribeId()
  {
    if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null)) {
      this.publishUin = this.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
    }
    if ((this.mNewPolymericInfo != null) && (this.mNewPolymericInfo.jdField_a_of_type_Boolean) && (this.publishUin == 0L) && ((this.mNewPolymericInfo.jdField_a_of_type_Int == 6) || (this.mNewPolymericInfo.jdField_a_of_type_Int == 11))) {
      try
      {
        this.publishUin = Long.parseLong(this.mSubscribeID);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("新聚合卡片帐号pgc类uin解析失败，e = ");
        localStringBuilder.append(localException);
        localStringBuilder.append(" articleID = ");
        localStringBuilder.append(this.mArticleID);
        localStringBuilder.append(" mSubscribeID = ");
        localStringBuilder.append(this.mSubscribeID);
        QLog.e("Q.readinjoy.BaseArticleInfo", 2, localStringBuilder.toString());
      }
    }
  }
  
  private <T extends MessageMicro<T>> byte[] toByteArrayOrNull(T paramT)
  {
    if (paramT != null) {
      return paramT.toByteArray();
    }
    return null;
  }
  
  private void writeByteArrayDataToParcel(@NotNull byte[] paramArrayOfByte, @NotNull Parcel paramParcel)
  {
    int i;
    if (paramArrayOfByte == null) {
      i = -1;
    } else {
      i = paramArrayOfByte.length;
    }
    paramParcel.writeInt(i);
    if (i > 0) {
      paramParcel.writeByteArray(paramArrayOfByte);
    }
  }
  
  private void writeByteDataToParcel(boolean paramBoolean, @NotNull Parcel paramParcel)
  {
    paramParcel.writeByte((byte)paramBoolean);
  }
  
  private void writePictureToParcel(@NotNull Parcel paramParcel)
  {
    Object localObject = this.mPictures;
    int j = 0;
    int i;
    if (localObject != null) {
      i = this.mPictures.length;
    } else {
      i = 0;
    }
    paramParcel.writeInt(i);
    localObject = this.mPictures;
    String str = "";
    if (localObject != null)
    {
      URL[] arrayOfURL = this.mPictures;
      int k = arrayOfURL.length;
      i = j;
      while (i < k)
      {
        localObject = arrayOfURL[i];
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = ((URL)localObject).toString();
        }
        paramParcel.writeString((String)localObject);
        i += 1;
      }
    }
    localObject = str;
    if (this.mSinglePicture != null) {
      if (this.mSinglePicture.getProtocol().equals("pubaccountimage")) {
        localObject = this.mSinglePicture.getFile();
      } else {
        localObject = this.mSinglePicture.toString();
      }
    }
    paramParcel.writeString((String)localObject);
  }
  
  private void writeStringToParcel(@NotNull String paramString, @NotNull Parcel paramParcel)
  {
    if (paramString == null) {
      paramString = "";
    }
    paramParcel.writeString(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected IVideoCardUIModel getLazyModel()
  {
    return ((IVideoCardUIModelFactory)QRoute.api(IVideoCardUIModelFactory.class)).createModel(this);
  }
  
  public PTSComposer.IPTSUpdateDataListener getPTSUpdateDataListener()
  {
    return this.ptsUpdateDataListener;
  }
  
  public String getTableName()
  {
    return "ArticleInfo";
  }
  
  @VisibleForTesting
  void handlerFeedsTypeInOldVersionDatabase()
  {
    handleFeedsTypeInOldVersionDatabaseForQACard();
    handleFeedsTypeInOldVersionDatabaseForNewPolymericInfo();
    handleFeedsTypeInOldVersionDatabaseForGalleryCard();
  }
  
  protected void postRead()
  {
    handlePBValueFromStream1();
    handlePBValueFromStream2();
    PBRepeatMessageField localPBRepeatMessageField = RIJPBFieldUtils.a(this.columnEntrancesBytes, articlesummary.VideoColumnInfo.class);
    if (localPBRepeatMessageField != null) {
      this.columnEntrances = VideoColumnInfo.a(localPBRepeatMessageField);
    }
    if ((this.ptsItemDataBytes != null) && (this.ptsItemDataBytes.length > 0)) {
      this.ptsItemData = ((PTSItemData)PTSParcelableUtil.a(this.ptsItemDataBytes, PTSItemData.CREATOR));
    }
    if (!TextUtils.isEmpty(this.smallGameData)) {
      this.mSmallMiniGameInfo = SmallMiniGameInfo.a(this.smallGameData);
    }
  }
  
  protected void prewrite()
  {
    this.mCommentInfoBytes = RIJPBFieldUtils.a(this.mCommentsObj, articlesummary.CommentInfo.class);
    this.mMultiBiuSameListBytes = RIJPBFieldUtils.a(this.mMultiBiuSameListObj, articlesummary.MultiBiuSameContent.class);
    this.mPackInfoBytes = toByteArrayOrNull(this.mPackInfoObj);
    this.mSubArticleListBytes = toByteArrayOrNull(this.mSubscribeInfoObj);
    if (this.mTopicRecommendFeedsInfo != null) {
      this.mTopicRecommendFeedsInfoByte = this.mTopicRecommendFeedsInfo.a().toByteArray();
    }
    if (this.mArkAppFeedsInfo != null) {
      this.mArkAppFeedsInfoBytes = toByteArrayOrNull(this.mArkAppFeedsInfo.a());
    }
    this.mLableListInfoBytes = RIJPBFieldUtils.a(this.mLabelListObj, articlesummary.ChannelInfo.class);
    this.mSubArticleListBytes = RIJPBFieldUtils.a(this.mSubSummaryListObj, articlesummary.ArticleSummary.class);
    setPublishUinBySubscribeId();
    if (this.mExtraBiuBriefInfo != null) {
      this.mExtraBiuBriefBytes = this.mExtraBiuBriefInfo.a();
    }
    this.mVideoDownloadBarInfoBytes = toByteArrayOrNull(this.mVideoDownloadBarInfo);
    this.mPartnerAccountInfoBytes = toByteArrayOrNull(this.mPartnerAccountInfo);
    if ((this.columnEntrances != null) && (this.columnEntrances.size() > 0))
    {
      PBRepeatMessageField localPBRepeatMessageField = PBField.initRepeatMessage(articlesummary.VideoColumnInfo.class);
      Iterator localIterator = this.columnEntrances.iterator();
      while (localIterator.hasNext()) {
        localPBRepeatMessageField.add(((VideoColumnInfo)localIterator.next()).a());
      }
      this.columnEntrancesBytes = RIJPBFieldUtils.a(localPBRepeatMessageField);
    }
    if (this.ptsItemData != null) {
      this.ptsItemDataBytes = PTSParcelableUtil.a(this.ptsItemData);
    }
    convertToPB();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseArticleInfo{mArticleID=");
    localStringBuilder.append(this.mArticleID);
    localStringBuilder.append("\n, mRecommendSeq=");
    localStringBuilder.append(this.mRecommendSeq);
    localStringBuilder.append("\n, mTitle=");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append("\n, mSummary=");
    localStringBuilder.append(this.mSummary);
    localStringBuilder.append("\n, mPUinIsActive=");
    localStringBuilder.append(this.mPUinIsActive);
    localStringBuilder.append("\n, mFeedType=");
    localStringBuilder.append(this.mFeedType);
    localStringBuilder.append("\n, mResolvedFeedType=");
    localStringBuilder.append(this.mResolvedFeedType);
    localStringBuilder.append("\n, mRowKey=");
    localStringBuilder.append(this.innerUniqueID);
    localStringBuilder.append("\n, icon_url=");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append("\n, icon_with=");
    localStringBuilder.append(this.iconWith);
    localStringBuilder.append("\n, icon_height=");
    localStringBuilder.append(this.iconHeight);
    localStringBuilder.append("\n, uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("\n, nick_name=");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append("\n, comment_id=");
    localStringBuilder.append(this.oldCommentId);
    localStringBuilder.append("\n, content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append("\n, jump_url=");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append("\n, isUseGif=");
    localStringBuilder.append(this.isUseGif);
    localStringBuilder.append("\n, mFirstPagePicUrl= ");
    localStringBuilder.append(this.mFirstPagePicUrl);
    localStringBuilder.append("\n, mJsonPictureList= ");
    localStringBuilder.append(this.mJsonPictureList);
    localStringBuilder.append("\n, mJsonVideoList= ");
    localStringBuilder.append(this.mJsonVideoList);
    localStringBuilder.append("\n, proteusItemsData= ");
    localStringBuilder.append(this.proteusItemsData);
    localStringBuilder.append("\n, mNewPolymericInfo= ");
    localStringBuilder.append(this.mNewPolymericInfo);
    localStringBuilder.append("\n, mFeedId=");
    long l;
    if (this.mSocialFeedInfo != null) {
      l = this.mSocialFeedInfo.jdField_a_of_type_Long;
    } else {
      l = 0L;
    }
    localStringBuilder.append(l);
    localStringBuilder.append("\n, isShowRecommendList= ");
    localStringBuilder.append(this.isShowRecommendList);
    localStringBuilder.append("\n, isPGCShortContent= ");
    localStringBuilder.append(isPGCShortContent());
    localStringBuilder.append("\n, isAccountShown= ");
    localStringBuilder.append(this.isAccountShown);
    localStringBuilder.append("\n, mSocialFeedInfo= ");
    localStringBuilder.append(this.mSocialFeedInfo);
    localStringBuilder.append("\n, mExtraBiuLevel= ");
    localStringBuilder.append(BaseArticleInfoKt.d(this));
    localStringBuilder.append("\n, mArticleContentUrl= ");
    localStringBuilder.append(this.mArticleContentUrl);
    localStringBuilder.append("\n, isCardJumpUrlAvailable= ");
    localStringBuilder.append(this.isCardJumpUrlAvailable);
    localStringBuilder.append("\n, mCardJumpUrl= ");
    localStringBuilder.append(this.mCardJumpUrl);
    localStringBuilder.append("\n, commentBtnJumpUrl= ");
    localStringBuilder.append(this.commentBtnJumpUrl);
    localStringBuilder.append("\n, mPartnerAccountInfo= ");
    localStringBuilder.append(getPartnerAccountInfoStr());
    localStringBuilder.append("\n, comment_jump_url= ");
    localStringBuilder.append(this.commentJumpUrl);
    localStringBuilder.append("\n, adReportCommonData= ");
    localStringBuilder.append(this.adReportCommonData);
    localStringBuilder.append("\n, isForbidReprint=");
    localStringBuilder.append(this.isForbidReprint);
    localStringBuilder.append("\n, isShowFollowButton=");
    localStringBuilder.append(this.isShowFollowButton);
    localStringBuilder.append("\n, titleWithTopicJson=");
    localStringBuilder.append(this.titleWithTopicJson);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    prewrite();
    paramParcel.writeLong(this.mArticleID);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSummary);
    paramParcel.writeString(this.mFirstPagePicUrl);
    paramParcel.writeString(this.mOriginalUrl);
    paramParcel.writeString(this.mArticleContentUrl);
    paramParcel.writeLong(this.mTime);
    paramParcel.writeLong(this.mCommentCount);
    paramParcel.writeString(this.mSubscribeID);
    paramParcel.writeString(this.mSubscribeName);
    paramParcel.writeLong(this.mRecommendTime);
    paramParcel.writeLong(this.mChannelID);
    paramParcel.writeLong(this.mRecommendSeq);
    writeByteDataToParcel(this.mShowBigPicture, paramParcel);
    paramParcel.writeInt(this.mStrategyId);
    paramParcel.writeInt(this.articleStyle);
    paramParcel.writeString(this.interfaceData);
    paramParcel.writeString(this.galleryReprotExdData);
    paramParcel.writeLong(this.mAlgorithmID);
    paramParcel.writeString(this.mArticleFriendLikeText);
    paramParcel.writeDouble(this.mTopicPicWHRatio);
    paramParcel.writeString(this.mTopicPicInfo);
    writePictureToParcel(paramParcel);
    String str;
    if (this.mVideoCoverUrl != null) {
      str = this.mVideoCoverUrl.toString();
    } else {
      str = "";
    }
    paramParcel.writeString(str);
    writeStringToParcel(this.mVideoVid, paramParcel);
    paramParcel.writeInt(this.mVideoDuration);
    paramParcel.writeInt(this.mCommentIconType);
    writeByteArrayDataToParcel(this.mServerContext, paramParcel);
    writeByteArrayDataToParcel(this.mCommentInfoBytes, paramParcel);
    writeByteArrayDataToParcel(this.mPackInfoBytes, paramParcel);
    paramParcel.writeLong(this.mCircleId);
    paramParcel.writeString(this.mStrCircleId);
    writeByteDataToParcel(this.mPUinIsActive, paramParcel);
    writeByteArrayDataToParcel(this.mSubscribeInfoBytes, paramParcel);
    paramParcel.writeInt(this.mFeedType);
    paramParcel.writeLong(this.mFeedId);
    writeByteArrayDataToParcel(this.mSocialFeedInfoByte, paramParcel);
    paramParcel.writeString(this.innerUniqueID);
    paramParcel.writeLong(this.businessId);
    writeStringToParcel(this.businessName, paramParcel);
    writeStringToParcel(this.businessUrl, paramParcel);
    writeStringToParcel(this.businessNamePrefix, paramParcel);
    writeByteArrayDataToParcel(this.mTopicRecommendFeedsInfoByte, paramParcel);
    writeByteArrayDataToParcel(this.mArkAppFeedsInfoBytes, paramParcel);
    paramParcel.writeLong(this.publishUin);
    paramParcel.writeLong(this.mMergeVideoId);
    paramParcel.writeInt(this.mVideoCommentCount);
    paramParcel.writeString(this.proteusItemsData);
    paramParcel.writeInt(this.mAccountLess);
    writeStringToParcel(this.mVideoArticleSubsText, paramParcel);
    writeStringToParcel(this.mVideoArticleSubsColor, paramParcel);
    writeStringToParcel(this.mVideoAdsJumpUrl, paramParcel);
    paramParcel.writeInt(this.mVideoAdsJumpType);
    paramParcel.writeInt(this.mVideoAdsSource);
    paramParcel.writeString(this.videoReportInfo);
    writeByteDataToParcel(this.isTwoItem, paramParcel);
    writeByteDataToParcel(this.isSuperTopic, paramParcel);
    writeByteArrayDataToParcel(this.mNewPackInfoBytes, paramParcel);
    writeByteArrayDataToParcel(this.mRecommendFollowInfoBytes, paramParcel);
    paramParcel.writeLong(this.mRecommendFollowId);
    paramParcel.writeString(this.gifCoverUrl);
    writeByteDataToParcel(this.isUseGif, paramParcel);
    writeByteArrayDataToParcel(this.mExtraBiuBriefBytes, paramParcel);
    writeByteArrayDataToParcel(this.mMultiBiuSameListBytes, paramParcel);
    paramParcel.writeInt(this.mIsGallery);
    writeByteDataToParcel(this.mIsGalleryChannel, paramParcel);
    writeByteArrayDataToParcel(this.hotWordInfoListBytes, paramParcel);
    paramParcel.writeInt(this.busiType);
    writeStringToParcel(this.mGWCommonData, paramParcel);
    writeStringToParcel(this.mReportCommonData, paramParcel);
    paramParcel.writeInt(this.recommendedFlag);
    writeByteArrayDataToParcel(this.ptsItemDataBytes, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo
 * JD-Core Version:    0.7.0.1
 */