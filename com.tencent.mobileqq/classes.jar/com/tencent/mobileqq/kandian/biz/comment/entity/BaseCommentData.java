package com.tencent.mobileqq.kandian.biz.comment.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyMedalInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ActivityLevel;

public abstract class BaseCommentData
  implements Serializable
{
  public static final int MAIN_COMMENT = 1;
  public static final int SUB_COMMENT = 2;
  public static final String TAG = "BaseCommentData";
  public BaseCommentData.AccountLevelInfo accountLevelInfo;
  public long activityCfgID;
  public String activityJumpUrl;
  public oidb_cmd0xc46.ActivityLevel activityLevel;
  public String activityPicUrl;
  public int anonymous;
  public String authorComment;
  public int authorSelection;
  public String avatar;
  public String avatarPendantUrl;
  public int awesome;
  public int commentApp;
  public String commentContent;
  public String commentId;
  public List<BaseCommentData.CommentLinkData> commentLinkDataList;
  public List<BaseCommentData.CommentRptData> commentRptDataList;
  public long commentTime;
  public int contentSrc;
  public int createSrc;
  public int disLike;
  public String flowGuidePtsData;
  public String homepage;
  public int isActivity;
  public boolean isAd;
  public boolean isAnchor;
  public int isApproved;
  public boolean isAuthorBottom;
  public boolean isAuthorLike;
  public int isAuthorReply;
  public boolean isAuthorSticky;
  public boolean isBanner;
  public boolean isDelete;
  public boolean isFollowing;
  public int isStar;
  public String ksHomePage;
  public int level;
  public int like;
  public int likeCnt;
  public String mAdTxt;
  public int maxLine = 9;
  public ReadInJoyMedalInfo medalInfo;
  public List<BaseCommentData.MediaData> mediaDataList;
  public int myself;
  public String nickName;
  public String passthrough;
  public int rank;
  public String rowKey;
  public int secondMaxLine = 6;
  public String shareUrl;
  public boolean shouldShowFollowButton;
  public String styleData;
  public String uin;
  public BaseCommentData.UserIdentityIcon userIdentityIcon;
  public String userTitle;
  
  public int getCommentLevel()
  {
    if ((this instanceof CommentData)) {
      return 1;
    }
    if ((this instanceof SubCommentData)) {
      return 2;
    }
    return 0;
  }
  
  public int getCommentMediaType()
  {
    Object localObject = this.mediaDataList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (BaseCommentData.MediaData)this.mediaDataList.get(0);
      if (localObject != null) {
        return ((BaseCommentData.MediaData)localObject).e;
      }
    }
    return 0;
  }
  
  public String getWholeStringContent()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.commentContent);
    Object localObject = this.commentRptDataList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append(((BaseCommentData.CommentRptData)((Iterator)localObject).next()).a);
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean hasLinkData()
  {
    List localList = this.commentLinkDataList;
    return (localList != null) && (localList.size() > 0);
  }
  
  public boolean isActivity()
  {
    return this.isActivity == 1;
  }
  
  public boolean isAnonymous()
  {
    return this.anonymous == 1;
  }
  
  public boolean isApproved()
  {
    return this.isApproved == 1;
  }
  
  public boolean isAuthorReply()
  {
    return this.isAuthorReply == 1;
  }
  
  public boolean isAuthorSelection()
  {
    return this.authorSelection == 1;
  }
  
  public boolean isAwesome()
  {
    return this.awesome == 1;
  }
  
  public boolean isBanner()
  {
    return this.isBanner;
  }
  
  public boolean isComment()
  {
    int i = this.level;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isDisliked()
  {
    return this.disLike == 1;
  }
  
  public boolean isDynamicComment()
  {
    return (!TextUtils.isEmpty(this.styleData)) && (this.styleData.contains("style_ID"));
  }
  
  public boolean isFamilyTopEntry()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.styleData)) && (this.styleData.contains("ReadInJoy_comment_family_top_cell"))) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFamilyTopEntry ");
    localStringBuilder.append(bool);
    QLog.d("BaseCommentData", 2, localStringBuilder.toString());
    return bool;
  }
  
  public boolean isFolderCard()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.styleData)) && (this.styleData.contains("ReadInJoy_comment_bottom_fold_cell"))) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFolderCard ");
    localStringBuilder.append(bool);
    QLog.d("BaseCommentData", 2, localStringBuilder.toString());
    return bool;
  }
  
  public boolean isLiked()
  {
    return this.like == 1;
  }
  
  public boolean isMyself()
  {
    return this.myself == 1;
  }
  
  public boolean isRank()
  {
    return this.rank != 0;
  }
  
  public boolean isStar()
  {
    return this.isStar == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseCommentData{level=");
    localStringBuilder.append(this.level);
    localStringBuilder.append(", commentId='");
    localStringBuilder.append(this.commentId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentContent='");
    localStringBuilder.append(this.commentContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentTime=");
    localStringBuilder.append(this.commentTime);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", avatar='");
    localStringBuilder.append(this.avatar);
    localStringBuilder.append('\'');
    localStringBuilder.append(", homepage='");
    localStringBuilder.append(this.homepage);
    localStringBuilder.append('\'');
    localStringBuilder.append(", myself=");
    localStringBuilder.append(this.myself);
    localStringBuilder.append(", like=");
    localStringBuilder.append(this.like);
    localStringBuilder.append(", disLike=");
    localStringBuilder.append(this.disLike);
    localStringBuilder.append(", likeCnt=");
    localStringBuilder.append(this.likeCnt);
    localStringBuilder.append(", anonymous=");
    localStringBuilder.append(this.anonymous);
    localStringBuilder.append(", authorSelection=");
    localStringBuilder.append(this.authorSelection);
    localStringBuilder.append(", authorComment='");
    localStringBuilder.append(this.authorComment);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rank=");
    localStringBuilder.append(this.rank);
    localStringBuilder.append(", awesome=");
    localStringBuilder.append(this.awesome);
    localStringBuilder.append(", rowKey='");
    localStringBuilder.append(this.rowKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentSrc=");
    localStringBuilder.append(this.contentSrc);
    localStringBuilder.append(", passthrough='");
    localStringBuilder.append(this.passthrough);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAnchor=");
    localStringBuilder.append(this.isAnchor);
    localStringBuilder.append(", isDelete=");
    localStringBuilder.append(this.isDelete);
    localStringBuilder.append(", maxLine=");
    localStringBuilder.append(this.maxLine);
    localStringBuilder.append(", secondMaxLine=");
    localStringBuilder.append(this.secondMaxLine);
    localStringBuilder.append(", isStar=");
    localStringBuilder.append(this.isStar);
    localStringBuilder.append(", isApproved=");
    localStringBuilder.append(this.isApproved);
    localStringBuilder.append(", flowGuidePtsData='");
    localStringBuilder.append(this.flowGuidePtsData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", createSrc=");
    localStringBuilder.append(this.createSrc);
    localStringBuilder.append(", isActivity=");
    localStringBuilder.append(this.isActivity);
    localStringBuilder.append(", activityPicUrl='");
    localStringBuilder.append(this.activityPicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", activityJumpUrl='");
    localStringBuilder.append(this.activityJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", activityCfgID=");
    localStringBuilder.append(this.activityCfgID);
    localStringBuilder.append(", isBanner=");
    localStringBuilder.append(this.isBanner);
    localStringBuilder.append(", medalInfo=");
    localStringBuilder.append(this.medalInfo);
    localStringBuilder.append(", mediaDataList=");
    localStringBuilder.append(this.mediaDataList);
    localStringBuilder.append(", isAuthorReply=");
    localStringBuilder.append(this.isAuthorReply);
    localStringBuilder.append(", userTitle='");
    localStringBuilder.append(this.userTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAuthorLike=");
    localStringBuilder.append(this.isAuthorLike);
    localStringBuilder.append(", isFollowing=");
    localStringBuilder.append(this.isFollowing);
    localStringBuilder.append(", isAuthorSticky=");
    localStringBuilder.append(this.isAuthorSticky);
    localStringBuilder.append(", isAuthorBottom=");
    localStringBuilder.append(this.isAuthorBottom);
    localStringBuilder.append(", avatarPendantUrl='");
    localStringBuilder.append(this.avatarPendantUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ksHomePage='");
    localStringBuilder.append(this.ksHomePage);
    localStringBuilder.append('\'');
    localStringBuilder.append(", styleData='");
    localStringBuilder.append(this.styleData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountLevelInfo=");
    localStringBuilder.append(this.accountLevelInfo);
    localStringBuilder.append(", isAd=");
    localStringBuilder.append(this.isAd);
    localStringBuilder.append(", advertisementInfo=");
    localStringBuilder.append(this.mAdTxt);
    localStringBuilder.append(", commentLinkDataList=");
    localStringBuilder.append(this.commentLinkDataList);
    localStringBuilder.append(", commentRptDataList=");
    localStringBuilder.append(this.commentRptDataList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData
 * JD-Core Version:    0.7.0.1
 */