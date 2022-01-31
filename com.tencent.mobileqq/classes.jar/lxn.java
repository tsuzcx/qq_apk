import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArkAppFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArkAppFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.TopicRecommendFeedsInfo;

public final class lxn
  implements Parcelable.Creator
{
  public ArticleInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mArticleID = paramParcel.readLong();
    localArticleInfo.mTitle = paramParcel.readString();
    localArticleInfo.mSummary = paramParcel.readString();
    localArticleInfo.mFirstPagePicUrl = paramParcel.readString();
    localArticleInfo.mOriginalUrl = paramParcel.readString();
    localArticleInfo.mArticleContentUrl = paramParcel.readString();
    localArticleInfo.mTime = paramParcel.readLong();
    localArticleInfo.mCommentCount = paramParcel.readLong();
    localArticleInfo.mSubscribeID = paramParcel.readString();
    localArticleInfo.mSubscribeName = paramParcel.readString();
    localArticleInfo.mRecommendTime = paramParcel.readLong();
    localArticleInfo.mChannelID = paramParcel.readLong();
    localArticleInfo.mRecommendSeq = paramParcel.readLong();
    if (paramParcel.readByte() == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      localArticleInfo.mShowBigPicture = bool1;
      localArticleInfo.mStrategyId = paramParcel.readInt();
      localArticleInfo.articleStyle = paramParcel.readInt();
      localArticleInfo.interfaceData = paramParcel.readString();
      localArticleInfo.galleryReprotExdData = paramParcel.readString();
      localArticleInfo.mAlgorithmID = paramParcel.readLong();
      localArticleInfo.mArticleFriendLikeText = paramParcel.readString();
      localArticleInfo.mTopicPicWHRatio = paramParcel.readDouble();
      localArticleInfo.mTopicPicInfo = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      localArticleInfo.mPictures = new URL[j];
      i = 0;
      while (i < j)
      {
        localArticleInfo.mPictures[i] = ReadInJoyUtils.a(paramParcel.readString());
        i += 1;
      }
    }
    localArticleInfo.mSinglePicture = ReadInJoyUtils.a(paramParcel.readString());
    localArticleInfo.mVideoCoverUrl = ReadInJoyUtils.a(paramParcel.readString());
    localArticleInfo.mVideoVid = paramParcel.readString();
    localArticleInfo.mVideoDuration = paramParcel.readInt();
    localArticleInfo.mCommentIconType = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      localArticleInfo.mServerContext = null;
      i = paramParcel.readInt();
      if (i != -1) {
        break label651;
      }
      localArticleInfo.mCommentInfoBytes = null;
      label353:
      i = paramParcel.readInt();
      if (i != -1) {
        break label675;
      }
      localArticleInfo.mPackInfoBytes = null;
      label369:
      localArticleInfo.postRead();
      localArticleInfo.mCircleId = paramParcel.readLong();
      localArticleInfo.mStrCircleId = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label699;
      }
      bool1 = bool2;
      label403:
      localArticleInfo.mPUinIsActive = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label705;
      }
      localArticleInfo.mSubscribeInfoBytes = null;
      label426:
      localArticleInfo.mFeedType = paramParcel.readInt();
      localArticleInfo.mFeedId = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i > 0) {
        break label729;
      }
      localArticleInfo.mSocialFeedInfoByte = null;
      label459:
      localArticleInfo.innerUniqueID = paramParcel.readString();
      localArticleInfo.businessId = paramParcel.readLong();
      localArticleInfo.businessName = paramParcel.readString();
      localArticleInfo.businessUrl = paramParcel.readString();
      localArticleInfo.businessNamePrefix = paramParcel.readString();
      i = paramParcel.readInt();
      if (i > 0) {
        break label795;
      }
      localArticleInfo.mTopicRecommendFeedsInfoByte = null;
      label519:
      i = paramParcel.readInt();
      if (i > 0) {
        break label861;
      }
      localArticleInfo.mArkAppFeedsInfoBytes = null;
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          localArticleInfo.publishUin = paramParcel.readLong();
          localArticleInfo.mMergeVideoId = paramParcel.readLong();
          localArticleInfo.mVideoCommentCount = paramParcel.readInt();
          localArticleInfo.proteusItemsData = paramParcel.readString();
          localArticleInfo.mAccountLess = paramParcel.readInt();
          localArticleInfo.mVideoArticleSubsText = paramParcel.readString();
          localArticleInfo.mVideoArticleSubsColor = paramParcel.readString();
          localArticleInfo.mVideoAdsJumpUrl = paramParcel.readString();
          localArticleInfo.mVideoAdsJumpType = paramParcel.readInt();
          localArticleInfo.mVideoAdsSource = paramParcel.readInt();
          return localArticleInfo;
          localArticleInfo.mServerContext = new byte[i];
          if (i <= 0) {
            break;
          }
          paramParcel.readByteArray(localArticleInfo.mServerContext);
          break;
          label651:
          localArticleInfo.mCommentInfoBytes = new byte[i];
          if (i <= 0) {
            break label353;
          }
          paramParcel.readByteArray(localArticleInfo.mCommentInfoBytes);
          break label353;
          label675:
          localArticleInfo.mPackInfoBytes = new byte[i];
          if (i <= 0) {
            break label369;
          }
          paramParcel.readByteArray(localArticleInfo.mPackInfoBytes);
          break label369;
          label699:
          bool1 = false;
          break label403;
          label705:
          localArticleInfo.mSubscribeInfoBytes = new byte[i];
          if (i <= 0) {
            break label426;
          }
          paramParcel.readByteArray(localArticleInfo.mSubscribeInfoBytes);
          break label426;
          label729:
          localArticleInfo.mSocialFeedInfoByte = new byte[i];
          paramParcel.readByteArray(localArticleInfo.mSocialFeedInfoByte);
          oidb_cmd0x68b.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x68b.SocializeFeedsInfo();
          try
          {
            localSocializeFeedsInfo.mergeFrom(localArticleInfo.mSocialFeedInfoByte);
            localArticleInfo.mSocialFeedInfo = SocializeFeedsInfo.a(localSocializeFeedsInfo);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
          {
            localInvalidProtocolBufferMicroException1.printStackTrace();
            localArticleInfo.mSocialFeedInfo = null;
          }
        }
        break label459;
        label795:
        localArticleInfo.mTopicRecommendFeedsInfoByte = new byte[i];
        paramParcel.readByteArray(localArticleInfo.mTopicRecommendFeedsInfoByte);
        oidb_cmd0x68b.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new oidb_cmd0x68b.TopicRecommendFeedsInfo();
        try
        {
          localTopicRecommendFeedsInfo.mergeFrom(localArticleInfo.mTopicRecommendFeedsInfoByte);
          localArticleInfo.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a(localTopicRecommendFeedsInfo);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          localInvalidProtocolBufferMicroException2.printStackTrace();
          localArticleInfo.mSocialFeedInfo = null;
        }
      }
      break label519;
      label861:
      localArticleInfo.mArkAppFeedsInfoBytes = new byte[i];
      paramParcel.readByteArray(localArticleInfo.mArkAppFeedsInfoBytes);
      oidb_cmd0x68b.ArkAppFeedsInfo localArkAppFeedsInfo = new oidb_cmd0x68b.ArkAppFeedsInfo();
      try
      {
        localArkAppFeedsInfo.mergeFrom(localArticleInfo.mArkAppFeedsInfoBytes);
        localArticleInfo.mArkAppFeedsInfo = ArkAppFeedsInfo.a(localArkAppFeedsInfo);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
      {
        localInvalidProtocolBufferMicroException3.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfo", 2, "convertPBToInfo arkAppFeedsInfo failed.");
        }
        localArticleInfo.mArkAppFeedsInfo = null;
      }
    }
  }
  
  public ArticleInfo[] a(int paramInt)
  {
    return new ArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxn
 * JD-Core Version:    0.7.0.1
 */