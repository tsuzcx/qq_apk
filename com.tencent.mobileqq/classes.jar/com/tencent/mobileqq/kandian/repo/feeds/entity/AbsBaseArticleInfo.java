package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArkAppFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.FirstFrameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.WaterFallPic;
import com.tencent.mobileqq.kandian.repo.video.IVideoCardUIModel;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.MultiBiuSameContent;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tencent.im.oidb.search.RequestSearchWord.Rcmd;

public abstract class AbsBaseArticleInfo
  extends Entity
  implements Parcelable, IVideoCardUIModel, Cloneable, Comparable<AbsBaseArticleInfo>
{
  public static final long SUBSCRIBE_RECOMMEND_SEQ = -3L;
  public static final String TABLE_NAME = "ArticleInfo";
  private static final String TAG = "AbsBaseArticleInfo";
  public static final long TOPIC_RECOMMEND_SEQ = -2L;
  public String adReportCommonData;
  public String aioShareUrl;
  @notColumn
  public ArticleInsertInfo articleInsertInfo = new ArticleInsertInfo();
  public int articleStyle = 0;
  @notColumn
  public ArticleViewModel articleViewModel;
  public String avatar;
  public boolean bindShowFollowButton = false;
  public int busiType = 1;
  public long businessId = 0L;
  public String businessName = "";
  public String businessNamePrefix = "";
  public String businessUrl = "";
  public byte[] bytesBusiData;
  public int clickArea;
  public String clickJumpTarget;
  @notColumn
  public List<VideoColumnInfo> columnEntrances;
  public byte[] columnEntrancesBytes;
  public int columnStyle;
  public String commentBtnJumpUrl;
  public String commentId;
  public String commentJumpUrl;
  public String commentShareUrl;
  public int commentSrc;
  public String content;
  @notColumn
  public int curHeight = 0;
  public String dtReportBackendInfo = "";
  public int dtReportContentType = 5;
  @notColumn
  public FamilyCommentInfo familyCommentInfo;
  public byte[] familyCommentInfoByte;
  @notColumn
  public int feedsFirstExposurePos = -1;
  @notColumn
  private FirstFrameInfo firstFrameInfo;
  public String galleryReprotExdData;
  public String gifCoverUrl;
  public boolean hasAwesome = false;
  @notColumn
  public boolean hasBeenInsertIntoList = false;
  @notColumn
  public boolean hasInsertAnimated = false;
  @notColumn
  public boolean hasPlayFeedsDataPreloaded;
  @notColumn
  public boolean hasRequestFollowStatus;
  public boolean hasWalletIcon;
  @notColumn
  public boolean hintFlag = false;
  @notColumn
  public HotWordInfo hotWordInfo;
  public byte[] hotWordInfoListBytes;
  public int iconHeight;
  public String iconUrl;
  public int iconWith;
  public String innerUniqueID;
  @notColumn
  public String inserSeqNo;
  @notColumn
  public RIJFeedsInsertAction insertAction;
  public String interfaceData;
  public boolean isAccountShown = false;
  public int isCardJumpUrlAvailable = 0;
  public int isCloseDislike = 0;
  public boolean isColumnAnimationPlay = false;
  public boolean isExtraBiuExpanded;
  public boolean isForbidReprint = false;
  @notColumn
  public boolean isNeeaRealExposureFilter;
  @notColumn
  public boolean isNeedShowBtnWhenFollowed;
  @notColumn
  public boolean isPublicAccountFollowed = false;
  public boolean isShowColumnAnimation = false;
  public int isShowFollowButton = 0;
  @notColumn
  public boolean isShowFreeNetFlow;
  @notColumn
  public boolean isShowGif;
  @notColumn
  public boolean isShowRecommendList;
  public int isSuperTop = 0;
  public boolean isSuperTopic = false;
  @notColumn
  public boolean isTwoItem = false;
  public boolean isUseGif;
  public boolean isWatchLater;
  @notColumn
  public int itemViewType = -1;
  public String jumpUrl;
  @notColumn
  public boolean like;
  public int mAbandonRepeatFlag;
  public int mAccountLess;
  @notColumn
  public int mAdScene;
  public long mAlgorithmGroup = -1L;
  public long mAlgorithmID = -1L;
  @notColumn
  public ArkAppFeedsInfo mArkAppFeedsInfo;
  public byte[] mArkAppFeedsInfoBytes;
  public String mArticleContentUrl = "";
  public String mArticleFriendLikeText;
  public long mArticleID = -1L;
  public String mArticleSubscriptColor;
  public String mArticleSubscriptText;
  public int mArticleType = 0;
  @notColumn
  private URL mCacheVideoURL;
  public String mCardJumpUrl;
  public long mChannelID = -1L;
  public String mChannelInfoDisplayName;
  public int mChannelInfoId = -1;
  public String mChannelInfoName;
  public int mChannelInfoType = -1;
  public long mCircleId;
  public long mCommentCount = -1L;
  public int mCommentIconType = 0;
  public byte[] mCommentInfoBytes;
  @notColumn
  public List<articlesummary.CommentInfo> mCommentsObj;
  @notColumn
  public int mCurrentX;
  public String mDianDianLabelIconUrl;
  public String mDianDianLabelText;
  public String mDiskLikeInfoString;
  @notColumn
  public ArrayList<DislikeInfo> mDislikeInfos;
  public byte[] mExtraBiuBriefBytes;
  @notColumn
  public ExtraBiuBriefInfo mExtraBiuBriefInfo;
  public String mFeedCookie;
  public long mFeedId = 0L;
  @notColumn
  public long mFeedIndexInGroup;
  public int mFeedType = 0;
  public String mFirstPagePicUrl = "";
  public String mGWCommonData;
  @notColumn
  public galleryFeeds.GalleryFeedsInfo mGalleryFeedsInfo;
  public int mGalleryPicNumber = 0;
  @notColumn
  public long mGroupCount;
  @notColumn
  public long mGroupId = -1L;
  @notColumn
  public List<AbsBaseArticleInfo> mGroupSubArticleList;
  @notColumn
  public URL mHeaderIconUrl;
  public int mIsDispTimestamp = 0;
  public int mIsGallery = 0;
  @notColumn
  public boolean mIsGalleryChannel;
  @notColumn
  public boolean mIsInPolymeric;
  public boolean mIsPolymericGallery = false;
  public int mIsShowSearchord = 0;
  public String mJsonPictureList;
  public String mJsonVideoList;
  @notColumn
  public int mJumpType = 0;
  @notColumn
  public KandianLiveInfo mKdLiveInfo;
  public byte[] mKdLiveInfoBytes;
  @notColumn
  public List<articlesummary.ChannelInfo> mLabelListObj;
  public byte[] mLableListInfoBytes;
  public long mMergeVideoId;
  @notColumn
  private IVideoCardUIModel mModel;
  public byte[] mMultiBiuSameListBytes;
  @notColumn
  public List<articlesummary.MultiBiuSameContent> mMultiBiuSameListObj;
  public byte[] mNewPackInfoBytes;
  @notColumn
  public NewPolymericInfo mNewPolymericInfo;
  public String mOriginalUrl = "";
  public boolean mPUinIsActive = true;
  public byte[] mPackInfoBytes;
  @notColumn
  public articlesummary.PackInfo mPackInfoObj;
  @notColumn
  public articlesummary.PartnerAccountInfo mPartnerAccountInfo;
  public byte[] mPartnerAccountInfoBytes;
  @notColumn
  public URL[] mPictures;
  @notColumn
  public PolymericInfo mPolymericInfo;
  @notColumn
  public URL mPolymericSmallVideoCoverUrl;
  @notColumn
  public volatile TemplateBean mProteusTemplateBean;
  public long mRecommendFollowId;
  public byte[] mRecommendFollowInfoBytes;
  @notColumn
  public RecommendFollowInfos mRecommendFollowInfos;
  public long mRecommendSeq = -1L;
  public long mRecommendTime = -1L;
  public String mRecommentdReason = "";
  @notColumn
  public String mRefreshTime = "0";
  public String mReportCommonData;
  @notColumn
  public int mResolvedFeedType;
  public String mSearchWordSessionId;
  public String mSearchWordTitle;
  public ArrayList<RequestSearchWord.Rcmd> mSearchWords = new ArrayList();
  public byte[] mServerContext;
  public int mShareCount = 0;
  public boolean mShowBigPicture = false;
  @notColumn
  public VideoColumnInfo mSimpleVideoColumnInfo;
  public byte[] mSimpleVideoColumnInfoBytes;
  @notColumn
  public URL mSinglePicture;
  @notColumn
  public SmallMiniGameInfo mSmallMiniGameInfo;
  @notColumn
  public SocializeFeedsInfo mSocialFeedInfo;
  public byte[] mSocialFeedInfoByte;
  public String mStrCircleId;
  public int mStrategyId;
  @notColumn
  public List<AbsBaseArticleInfo> mSubArticleList;
  public byte[] mSubArticleListBytes;
  @notColumn
  public List<articlesummary.ArticleSummary> mSubSummaryListObj;
  public String mSubscribeID = "";
  public byte[] mSubscribeInfoBytes;
  @notColumn
  public articlesummary.SubscribeInfo mSubscribeInfoObj;
  public String mSubscribeName = "";
  public String mSummary = "";
  @notColumn
  public String mThirdVideoURL;
  @notColumn
  public long mThirdVideoURLExpireTime;
  public long mTime = -1L;
  public String mTitle = "";
  public String mTopicPicInfo = "";
  public double mTopicPicWHRatio = 0.0D;
  @notColumn
  public TopicRecommendFeedsInfo mTopicRecommendFeedsInfo;
  public byte[] mTopicRecommendFeedsInfoByte;
  public int mVideoAdsJumpType;
  public String mVideoAdsJumpUrl;
  public int mVideoAdsSource;
  public String mVideoArticleSubsColor;
  public String mVideoArticleSubsText;
  @notColumn
  public VideoColumnInfo mVideoColumnInfo;
  public byte[] mVideoColumnInfoBytes;
  public int mVideoCommentCount;
  @notColumn
  public URL mVideoCoverUrl;
  @notColumn
  public articlesummary.VideoDownloadBarInfo mVideoDownloadBarInfo;
  public byte[] mVideoDownloadBarInfoBytes;
  @notColumn
  public int mVideoDuration;
  @notColumn
  public int mVideoJsonHeight;
  @notColumn
  public int mVideoJsonWidth;
  public String mVideoLogoUrl;
  public int mVideoPlayCount = 0;
  public int mVideoType = 0;
  @notColumn
  public String mVideoVid;
  public byte[] mWeishiUGInfo;
  @notColumn
  public long mXGFileSize;
  public String miniAppMovieName;
  public String miniProgramName;
  public String miniRowKey;
  public String msgBoxBriefContent;
  public String msgBoxBriefPreFix;
  public int msgBoxBriefPreFixType;
  @notColumn
  public ArrayList<MultiBiuSameContent> multiBiuSameContentList;
  @notColumn
  public MultiVideoColumnInfo multiVideoColumnInfo;
  public byte[] multiVideoColumnInfoBytes;
  @notColumn
  public boolean needShowFollwedButton = false;
  public String nickName;
  public String oldCommentId;
  @notColumn
  public ArticlePatchStatus patchStatus = new ArticlePatchStatus();
  @notColumn
  public String preloadAvatarUrl;
  public String proteusItemsData;
  @notColumn
  public PTSComposer ptsComposer;
  @notColumn
  public PTSItemData ptsItemData;
  public byte[] ptsItemDataBytes;
  public String ptsLitePageName;
  @notColumn
  public boolean ptsRoundCornerCard = false;
  @notColumn
  public boolean ptsSpecialCard = false;
  public long publishUin;
  public String qzoneShareUrl;
  public String rawkey;
  public int recommendedFlag = 0;
  @notColumn
  public int reqSource;
  public ArrayList<RichTitleInfo> richTitleInfoList;
  @notColumn
  public ScripCmsInfo scripCmsInfo;
  public byte[] scripCmsInfoByte;
  public boolean showBreathAnimation = false;
  public int showFollowButtonType = 1;
  @notColumn
  public int showMyFollowText = 0;
  public String smallGameData;
  @notColumn
  public List<articlesummary.SRTUniversalID> srtUniversalID;
  public byte[] srtUniversalIDBytesList;
  public String subscriptBgColor;
  public int subscriptLocation;
  public int subscriptType;
  public String subscriptWording;
  public String subscriptWordingColor;
  public String tags;
  public String thirdAction;
  public String thirdIcon;
  public String thirdName;
  @notColumn
  public String thirdUin;
  @notColumn
  public String thirdUinName;
  @notColumn
  public String titleWithTopicJson;
  public long uin;
  public String unioChann;
  public boolean unowned;
  public String upIconUrl;
  public String vIconUrl;
  public int videoJumpChannelID = -1;
  public String videoJumpChannelName = "";
  public int videoJumpChannelType = -1;
  public String videoReportInfo;
  public String viewRowkey;
  @notColumn
  public WaterFallPic waterFallPic;
  public String wechatShareUrl;
  @notColumn
  public articlesummary.WeishiUGInfo weishiUGInfo;
  
  private void ensureFirstFrameInfoNonNull()
  {
    if (this.firstFrameInfo == null) {
      this.firstFrameInfo = new FirstFrameInfo();
    }
  }
  
  private IVideoCardUIModel getLazyModelInner()
  {
    if (this.mModel == null) {
      this.mModel = getLazyModel();
    }
    return this.mModel;
  }
  
  public AbsBaseArticleInfo clone()
  {
    try
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)super.clone();
      return localAbsBaseArticleInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ArticleInfo CloneNotSupportedException e= ");
        localStringBuilder.append(localCloneNotSupportedException);
        QLog.d("AbsBaseArticleInfo", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public int compareTo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l1 = this.mTime;
    long l2 = paramAbsBaseArticleInfo.mTime;
    if (l1 == l2) {
      return 0;
    }
    if (l1 < l2) {
      return -1;
    }
    return 1;
  }
  
  public String getCardJumpUrl()
  {
    return this.mCardJumpUrl;
  }
  
  public int getCommentCount()
  {
    return getLazyModelInner().getCommentCount();
  }
  
  public int getFirstFrameHeight()
  {
    ensureFirstFrameInfoNonNull();
    return this.firstFrameInfo.d();
  }
  
  public URL getFirstFrameUrl()
  {
    ensureFirstFrameInfoNonNull();
    URL localURL = this.firstFrameInfo.a();
    if (localURL != null) {
      return localURL;
    }
    return getVideoCoverURL();
  }
  
  public int getFirstFrameWidth()
  {
    ensureFirstFrameInfoNonNull();
    return this.firstFrameInfo.c();
  }
  
  public String getInnerUniqueID()
  {
    return getLazyModelInner().getInnerUniqueID();
  }
  
  protected abstract IVideoCardUIModel getLazyModel();
  
  public abstract PTSComposer.IPTSUpdateDataListener getPTSUpdateDataListener();
  
  public JSONObject getProteusItemData()
  {
    Object localObject = this.proteusItemsData;
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("AbsBaseArticleInfo", 2, localJSONException, new Object[0]);
      }
    }
    return null;
  }
  
  public String getShareUrl()
  {
    return getLazyModelInner().getShareUrl();
  }
  
  public String getSubscribeName()
  {
    return getLazyModelInner().getSubscribeName();
  }
  
  public String getSubscribeUin()
  {
    return getLazyModelInner().getSubscribeUin();
  }
  
  public URL getVideoCoverURL()
  {
    if (this.mCacheVideoURL == null) {
      this.mCacheVideoURL = getLazyModelInner().getVideoCoverURL();
    }
    return this.mCacheVideoURL;
  }
  
  public URL getVideoCoverUrlWithSmartCut(boolean paramBoolean)
  {
    return getLazyModelInner().getVideoCoverUrlWithSmartCut(paramBoolean);
  }
  
  public URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2)
  {
    return getLazyModelInner().getVideoCoverWithSmartCut(paramInt1, paramInt2);
  }
  
  public int getVideoDuration()
  {
    return getLazyModelInner().getVideoDuration();
  }
  
  public int getVideoHeight()
  {
    return getLazyModelInner().getVideoHeight();
  }
  
  public String getVideoVid()
  {
    return getLazyModelInner().getVideoVid();
  }
  
  public int getVideoWidth()
  {
    return getLazyModelInner().getVideoWidth();
  }
  
  public boolean hasChannelInfo()
  {
    return (this.mChannelInfoId != -1) && (!TextUtils.isEmpty(this.mChannelInfoName)) && (this.mChannelInfoType != -1) && (!TextUtils.isEmpty(this.mChannelInfoDisplayName));
  }
  
  public boolean hasFamilyCommentIcon()
  {
    FamilyCommentInfo localFamilyCommentInfo = this.familyCommentInfo;
    return (localFamilyCommentInfo != null) && (localFamilyCommentInfo.a());
  }
  
  public boolean hasFirstFramePreload()
  {
    ensureFirstFrameInfoNonNull();
    return this.firstFrameInfo.b();
  }
  
  public boolean hasSearchWordInfo()
  {
    return (!TextUtils.isEmpty(this.mSearchWordTitle)) && (this.mSearchWords.size() != 0);
  }
  
  public void invalidateProteusTemplateBean()
  {
    this.mProteusTemplateBean = null;
  }
  
  public boolean isPGCShortContent()
  {
    SocializeFeedsInfo localSocializeFeedsInfo = this.mSocialFeedInfo;
    boolean bool = true;
    if ((localSocializeFeedsInfo == null) || (localSocializeFeedsInfo.t == null) || (!this.mSocialFeedInfo.t.f))
    {
      if (this.mArticleType == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isSocialFeed()
  {
    SocializeFeedsInfo localSocializeFeedsInfo = this.mSocialFeedInfo;
    return (localSocializeFeedsInfo != null) && (localSocializeFeedsInfo.c != null);
  }
  
  public boolean isSubscriptFeed()
  {
    articlesummary.SubscribeInfo localSubscribeInfo = this.mSubscribeInfoObj;
    return (localSubscribeInfo != null) && (localSubscribeInfo.uint32_is_subscribed.has()) && (this.mSubscribeInfoObj.uint32_is_subscribed.get() == 1);
  }
  
  public boolean isVideoItemForAdJump()
  {
    return (this.mVideoAdsJumpType == 1) && (!TextUtils.isEmpty(this.mVideoAdsJumpUrl));
  }
  
  public boolean isVideoItemForCommonUrlJump()
  {
    return (this.mVideoAdsJumpType == 3) && (!TextUtils.isEmpty(this.mVideoAdsJumpUrl));
  }
  
  public boolean isVideoItemForWeishiJump()
  {
    return this.mVideoAdsJumpType == 2;
  }
  
  public boolean isWormhole()
  {
    return this.mFeedType == 55;
  }
  
  public void setFirstFrameHeight(int paramInt)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.b(paramInt);
  }
  
  public void setFirstFrameUrl(URL paramURL)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.a(paramURL);
  }
  
  public void setFirstFrameWidth(int paramInt)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.a(paramInt);
  }
  
  public void setHasFirstFramePreload(boolean paramBoolean)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.a(paramBoolean);
  }
  
  public String toProteusOnlineString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProteusOnlineArticleInfo = {\nmArticleID = ");
    localStringBuilder.append(this.mArticleID);
    localStringBuilder.append(", \nmArticleContentUrl = ");
    localStringBuilder.append(this.mArticleContentUrl);
    localStringBuilder.append(", \nmRecommendSeq = ");
    localStringBuilder.append(this.mRecommendSeq);
    localStringBuilder.append(", \nmTitle = ");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append("\nmFeedsType = ");
    localStringBuilder.append(this.mFeedType);
    localStringBuilder.append("\nmRowKey = ");
    localStringBuilder.append(this.innerUniqueID);
    localStringBuilder.append("\nmFirstPagePicUrl = ");
    localStringBuilder.append(this.mFirstPagePicUrl);
    localStringBuilder.append("\nmJsonPictureList = ");
    localStringBuilder.append(this.mJsonPictureList);
    localStringBuilder.append("\nmJsonVideoList = ");
    localStringBuilder.append(this.mJsonVideoList);
    localStringBuilder.append("\nproteusItemData = ");
    localStringBuilder.append(this.proteusItemsData);
    localStringBuilder.append("\nmNewPolymericInfo = ");
    localStringBuilder.append(this.mNewPolymericInfo);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
  
  public String toSString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseArticleInfo{mArticleID=");
    localStringBuilder.append(this.mArticleID);
    localStringBuilder.append(", mTitle='");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSummary='");
    localStringBuilder.append(this.mSummary);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFirstPagePicUrl='");
    localStringBuilder.append(this.mFirstPagePicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mOriginalUrl='");
    localStringBuilder.append(this.mOriginalUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticleContentUrl='");
    localStringBuilder.append(this.mArticleContentUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTime=");
    localStringBuilder.append(this.mTime);
    localStringBuilder.append(", mCommentCount=");
    localStringBuilder.append(this.mCommentCount);
    localStringBuilder.append(", mShareCount=");
    localStringBuilder.append(this.mShareCount);
    localStringBuilder.append(", mCommentShareUrl=");
    localStringBuilder.append(this.commentShareUrl);
    localStringBuilder.append(", mSubscribeID='");
    localStringBuilder.append(this.mSubscribeID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSubscribeName='");
    localStringBuilder.append(this.mSubscribeName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecommendTime=");
    localStringBuilder.append(this.mRecommendTime);
    localStringBuilder.append(", mChannelID=");
    localStringBuilder.append(this.mChannelID);
    localStringBuilder.append(", mRecommendSeq=");
    localStringBuilder.append(this.mRecommendSeq);
    localStringBuilder.append(", mShowBigPicture=");
    localStringBuilder.append(this.mShowBigPicture);
    localStringBuilder.append(", mAlgorithmID=");
    localStringBuilder.append(this.mAlgorithmID);
    localStringBuilder.append(", mAlgorithmGroup=");
    localStringBuilder.append(this.mAlgorithmGroup);
    localStringBuilder.append(", mRecommentdReason='");
    localStringBuilder.append(this.mRecommentdReason);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJsonVideoList='");
    localStringBuilder.append(this.mJsonVideoList);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJsonPictureList='");
    localStringBuilder.append(this.mJsonPictureList);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAbandonRepeatFlag=");
    localStringBuilder.append(this.mAbandonRepeatFlag);
    localStringBuilder.append(", mArticleSubscriptText='");
    localStringBuilder.append(this.mArticleSubscriptText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticleSubscriptColor='");
    localStringBuilder.append(this.mArticleSubscriptColor);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticleFriendLikeText='");
    localStringBuilder.append(this.mArticleFriendLikeText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStrategyId=");
    localStringBuilder.append(this.mStrategyId);
    localStringBuilder.append(", mTopicPicWHRatio=");
    localStringBuilder.append(this.mTopicPicWHRatio);
    localStringBuilder.append(", mTopicPicInfo='");
    localStringBuilder.append(this.mTopicPicInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdIcon='");
    localStringBuilder.append(this.thirdIcon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdName='");
    localStringBuilder.append(this.thirdName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdAction='");
    localStringBuilder.append(this.thirdAction);
    localStringBuilder.append('\'');
    localStringBuilder.append(", busiType=");
    localStringBuilder.append(this.busiType);
    localStringBuilder.append(", innerUniqueID='");
    localStringBuilder.append(this.innerUniqueID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoType=");
    localStringBuilder.append(this.mVideoType);
    localStringBuilder.append(", mChannelInfoId=");
    localStringBuilder.append(this.mChannelInfoId);
    localStringBuilder.append(", mChannelInfoName='");
    localStringBuilder.append(this.mChannelInfoName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mChannelInfoType=");
    localStringBuilder.append(this.mChannelInfoType);
    localStringBuilder.append(", mChannelInfoDisplayName='");
    localStringBuilder.append(this.mChannelInfoDisplayName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommentIconType=");
    localStringBuilder.append(this.mCommentIconType);
    localStringBuilder.append(", mServerContext=");
    localStringBuilder.append(Arrays.toString(this.mServerContext));
    localStringBuilder.append(", mDiskLikeInfoString='");
    localStringBuilder.append(this.mDiskLikeInfoString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSocialFeedInfoByte=");
    localStringBuilder.append(Arrays.toString(this.mSocialFeedInfoByte));
    localStringBuilder.append(", mTopicRecommendFeedsInfoByte=");
    localStringBuilder.append(Arrays.toString(this.mTopicRecommendFeedsInfoByte));
    localStringBuilder.append(", mFeedId=");
    localStringBuilder.append(this.mFeedId);
    localStringBuilder.append(", mFeedType=");
    localStringBuilder.append(this.mFeedType);
    localStringBuilder.append(", mCircleId=");
    localStringBuilder.append(this.mCircleId);
    localStringBuilder.append(", mStrCircleId='");
    localStringBuilder.append(this.mStrCircleId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPUinIsActive=");
    localStringBuilder.append(this.mPUinIsActive);
    localStringBuilder.append(", mIsDispTimestamp=");
    localStringBuilder.append(this.mIsDispTimestamp);
    localStringBuilder.append(", mIsGallery=");
    localStringBuilder.append(this.mIsGallery);
    localStringBuilder.append(", mGalleryPicNumber=");
    localStringBuilder.append(this.mGalleryPicNumber);
    localStringBuilder.append(", mCommentInfoBytes=");
    localStringBuilder.append(Arrays.toString(this.mCommentInfoBytes));
    localStringBuilder.append(", mPackInfoBytes=");
    localStringBuilder.append(Arrays.toString(this.mPackInfoBytes));
    localStringBuilder.append(", mSubscribeInfoBytes=");
    localStringBuilder.append(Arrays.toString(this.mSubscribeInfoBytes));
    localStringBuilder.append(", mVideoPlayCount=");
    localStringBuilder.append(this.mVideoPlayCount);
    localStringBuilder.append(", mLableListInfoBytes=");
    localStringBuilder.append(Arrays.toString(this.mLableListInfoBytes));
    localStringBuilder.append(", videoJumpChannelID=");
    localStringBuilder.append(this.videoJumpChannelID);
    localStringBuilder.append(", videoJumpChannelType=");
    localStringBuilder.append(this.videoJumpChannelType);
    localStringBuilder.append(", videoJumpChannelName='");
    localStringBuilder.append(this.videoJumpChannelName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", businessId=");
    localStringBuilder.append(this.businessId);
    localStringBuilder.append(", businessName='");
    localStringBuilder.append(this.businessName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", businessUrl='");
    localStringBuilder.append(this.businessUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", businessNamePrefix='");
    localStringBuilder.append(this.businessNamePrefix);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAccountLess=");
    localStringBuilder.append(this.mAccountLess);
    localStringBuilder.append(", publishUin=");
    localStringBuilder.append(this.publishUin);
    localStringBuilder.append(", interfaceData='");
    localStringBuilder.append(this.interfaceData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", galleryReprotExdData='");
    localStringBuilder.append(this.galleryReprotExdData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleStyle=");
    localStringBuilder.append(this.articleStyle);
    localStringBuilder.append(", proteusItemsData='");
    localStringBuilder.append(this.proteusItemsData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArkAppFeedsInfo=");
    localStringBuilder.append(this.mArkAppFeedsInfo);
    localStringBuilder.append(", mArkAppFeedsInfoBytes=");
    localStringBuilder.append(Arrays.toString(this.mArkAppFeedsInfoBytes));
    localStringBuilder.append(", mDislikeInfos=");
    localStringBuilder.append(this.mDislikeInfos);
    localStringBuilder.append(", like=");
    localStringBuilder.append(this.like);
    localStringBuilder.append(", mPictures=");
    localStringBuilder.append(Arrays.toString(this.mPictures));
    localStringBuilder.append(", mSinglePicture=");
    localStringBuilder.append(this.mSinglePicture);
    localStringBuilder.append(", mVideoCoverUrl=");
    localStringBuilder.append(this.mVideoCoverUrl);
    localStringBuilder.append(", mVideoVid='");
    localStringBuilder.append(this.mVideoVid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoDuration=");
    localStringBuilder.append(this.mVideoDuration);
    localStringBuilder.append(", mVideoJsonWidth=");
    localStringBuilder.append(this.mVideoJsonWidth);
    localStringBuilder.append(", mVideoJsonHeight=");
    localStringBuilder.append(this.mVideoJsonHeight);
    localStringBuilder.append(", mXGFileSize=");
    localStringBuilder.append(this.mXGFileSize);
    localStringBuilder.append(", mThirdVideoURL='");
    localStringBuilder.append(this.mThirdVideoURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mThirdVideoURLExpireTime=");
    localStringBuilder.append(this.mThirdVideoURLExpireTime);
    localStringBuilder.append(", thirdUin='");
    localStringBuilder.append(this.thirdUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thirdUinName='");
    localStringBuilder.append(this.thirdUinName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommentsObj=");
    localStringBuilder.append(this.mCommentsObj);
    localStringBuilder.append(", mPackInfoObj=");
    localStringBuilder.append(this.mPackInfoObj);
    localStringBuilder.append(", mPolymericInfo=");
    localStringBuilder.append(this.mPolymericInfo);
    localStringBuilder.append(", mIsInPolymeric=");
    localStringBuilder.append(this.mIsInPolymeric);
    localStringBuilder.append(", mSubscribeInfoObj=");
    localStringBuilder.append(this.mSubscribeInfoObj);
    localStringBuilder.append(", mGroupId=");
    localStringBuilder.append(this.mGroupId);
    localStringBuilder.append(", mGroupCount=");
    localStringBuilder.append(this.mGroupCount);
    localStringBuilder.append(", mFeedIndexInGroup=");
    localStringBuilder.append(this.mFeedIndexInGroup);
    localStringBuilder.append(", mHeaderIconUrl=");
    localStringBuilder.append(this.mHeaderIconUrl);
    localStringBuilder.append(", mSocialFeedInfo=");
    localStringBuilder.append(this.mSocialFeedInfo);
    localStringBuilder.append(", mLabelListObj=");
    localStringBuilder.append(this.mLabelListObj);
    localStringBuilder.append(", mTopicRecommendFeedsInfo=");
    localStringBuilder.append(this.mTopicRecommendFeedsInfo);
    localStringBuilder.append(", isNeedShowBtnWhenFollowed=");
    localStringBuilder.append(this.isNeedShowBtnWhenFollowed);
    localStringBuilder.append(", feedsFirstExposurePos=");
    localStringBuilder.append(this.feedsFirstExposurePos);
    localStringBuilder.append(", mSubArticleListBytes=");
    localStringBuilder.append(Arrays.toString(this.mSubArticleListBytes));
    localStringBuilder.append(", mSubSummaryListObj=");
    localStringBuilder.append(this.mSubSummaryListObj);
    localStringBuilder.append(", mSubArticleList=");
    localStringBuilder.append(this.mSubArticleList);
    localStringBuilder.append(", mMergeVideoId=");
    localStringBuilder.append(this.mMergeVideoId);
    localStringBuilder.append(", mGroupSubArticleList=");
    localStringBuilder.append(this.mGroupSubArticleList);
    localStringBuilder.append(", mVideoCommentCount=");
    localStringBuilder.append(this.mVideoCommentCount);
    localStringBuilder.append(", mProteusTemplateBean=");
    localStringBuilder.append(this.mProteusTemplateBean);
    localStringBuilder.append(", mVideoArticleSubsText='");
    localStringBuilder.append(this.mVideoArticleSubsText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoArticleSubsColor='");
    localStringBuilder.append(this.mVideoArticleSubsColor);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoAdsJumpUrl='");
    localStringBuilder.append(this.mVideoAdsJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoAdsJumpType=");
    localStringBuilder.append(this.mVideoAdsJumpType);
    localStringBuilder.append(", mVideoAdsSource=");
    localStringBuilder.append(this.mVideoAdsSource);
    localStringBuilder.append(", mVideoLogoUrl=");
    localStringBuilder.append(this.mVideoLogoUrl);
    localStringBuilder.append(", titleWithTopicJson=");
    localStringBuilder.append(this.titleWithTopicJson);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo
 * JD-Core Version:    0.7.0.1
 */