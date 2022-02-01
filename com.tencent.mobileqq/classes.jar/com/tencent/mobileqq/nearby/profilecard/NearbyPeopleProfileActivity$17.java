package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

class NearbyPeopleProfileActivity$17
  extends NearbyCardObserver
{
  NearbyPeopleProfileActivity$17(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString)
  {
    if (NearbyPeopleProfileActivity.access$500(this.a) != null)
    {
      if (NearbyPeopleProfileActivity.access$300(this.a) == null) {
        return;
      }
      NearbyPeopleProfileActivity.access$300(this.a).charm = paramInt3;
      NearbyPeopleProfileActivity.access$300(this.a).charmLevel = paramInt4;
      NearbyPeopleProfileActivity.access$300(this.a).curThreshold = paramInt5;
      NearbyPeopleProfileActivity.access$300(this.a).nextThreshold = paramInt6;
      NearbyPeopleProfileActivity.access$500(this.a).a(NearbyPeopleProfileActivity.access$300(this.a));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetCharmNotify() uin=");
        ((StringBuilder)localObject).append(this.a.app.getCurrentAccountUin());
        QLog.d("Charm", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = StringUtil.a(paramString, "<head>", "</head>");
      paramString = StringUtil.a(paramString, "<body>", "</body>");
      if (this.a.isResume()) {
        QQUtils.a(this.a, (String)localObject, paramString, paramInt3 - paramInt1).show();
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (NearbyPeopleProfileActivity.access$400(this.a) != null) {
      NearbyPeopleProfileActivity.access$400(this.a).a(paramString, paramInt);
    }
    this.a.mSchoolNameValidState = paramInt;
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Object> paramList, List<String> paramList1)
  {
    if (NearbyPeopleProfileActivity.access$500(this.a) != null) {
      NearbyPeopleProfileActivity.access$500(this.a).a(paramBoolean, paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ongetShowLove ");
    ((StringBuilder)localObject).append("issuccess = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" uin = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" canChat = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(" can ShowLove = ");
    ((StringBuilder)localObject).append(paramBoolean3);
    ((StringBuilder)localObject).append("sig:");
    ((StringBuilder)localObject).append(paramArrayOfByte);
    ((StringBuilder)localObject).append(paramString);
    DatingUtil.c("profileCard", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.a;
    if (((NearbyPeopleProfileActivity)localObject).mHandler != null)
    {
      this.a.mHandler.removeMessages(204);
      this.a.mHandler.sendEmptyMessage(205);
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        DatingUtil.c(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "onGetShowLoveLimit , can chat, someting is wrong" });
        NearbyPeopleProfileActivity.access$500(this.a).l();
      }
      else if (paramBoolean3)
      {
        if (NearbyPeopleProfileActivity.access$300(this.a) != null)
        {
          paramArrayOfByte = NearbyPeopleProfileActivity.access$300(this.a).uin;
          paramArrayOfByte = NearbyPeopleProfileActivity.access$300(this.a).nickname;
          int i = NearbyPeopleProfileActivity.access$300(this.a).gender;
          ProfileCardUtil.a(this.a.allinone);
          QLog.d("NearbyPeopleProfileActivity", 1, "ShowLoveEditorActivity 已在725下架");
        }
      }
      else
      {
        paramArrayOfByte = NearbyPeopleProfileActivity.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cant show love, wording is ");
        localStringBuilder.append(paramString);
        DatingUtil.c(paramArrayOfByte, new Object[] { localStringBuilder.toString() });
        paramArrayOfByte = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte = ((Activity)localObject).getResources().getString(2131699192);
        }
        DatingUtil.a(this.a, paramArrayOfByte);
      }
    }
    else {
      DatingUtil.a((Activity)localObject, ((Activity)localObject).getString(2131699191));
    }
    this.a.waitingForSayhelloLimit = false;
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (UpdatePhotoList.HeadInfo)paramObject;
    if (QLog.isColorLevel()) {
      if (paramObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateNearbyPeopleAuthVideo , uint32_headid = ");
        localStringBuilder.append(paramObject.uint32_headid.get());
        localStringBuilder.append(", str_headurl = ");
        localStringBuilder.append(paramObject.str_headurl.get());
        localStringBuilder.append(", str_video_url = ");
        localStringBuilder.append(paramObject.str_video_url.get());
        QLog.d("NearbyPeopleProfileActivity", 2, localStringBuilder.toString());
      }
      else
      {
        QLog.d("NearbyPeopleProfileActivity", 2, "onUpdateNearbyPeopleAuthVideo , headInfo is null");
      }
    }
    paramObject = NearbyPeopleProfileActivity.access$300(this.a).vSeed;
    long l = NearbyPeopleProfileActivity.access$300(this.a).feedPreviewTime;
    if (this.a.mTinyId > 0L)
    {
      NearbyProfileUtil.a(this.a.mCardHandler, this.a.app, this.a.mTinyId, null, this.a.fetchFromType, paramObject, l, true, this.a.allinone.likeSource, NearbyPeopleProfileActivity.isFromTribe(this.a.from), NearbyPeopleProfileActivity.access$100(this.a), NearbyPeopleProfileActivity.access$000(this.a));
      return;
    }
    if (!StringUtil.a(this.a.allinone.uin)) {
      NearbyProfileUtil.a(this.a.mCardHandler, this.a.app, 0L, this.a.allinone.uin, this.a.fetchFromType, paramObject, l, true, this.a.allinone.likeSource, NearbyPeopleProfileActivity.isFromTribe(this.a.from), NearbyPeopleProfileActivity.access$100(this.a), NearbyPeopleProfileActivity.access$000(this.a));
    }
  }
  
  public void a(boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)paramObject;
    if ((localNearbyPeopleCard != null) && ((localNearbyPeopleCard.tinyId == 0L) || (localNearbyPeopleCard.tinyId != this.a.mTinyId)) && (TextUtils.isEmpty(localNearbyPeopleCard.uin)) && ((localNearbyPeopleCard.nowId == 0L) || (localNearbyPeopleCard.nowId != NearbyPeopleProfileActivity.access$100(this.a)))) {
      return;
    }
    this.a.dismissWaittingDialog();
    if (!NearbyPeopleProfileActivity.access$900(this.a)) {
      return;
    }
    paramObject = ProfilePerformanceReport.a;
    if ((paramObject != null) && (paramObject.a())) {
      paramObject.b(6);
    }
    if ((localNearbyPeopleCard != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tinyid=");
      localStringBuilder.append(localNearbyPeopleCard.tinyId);
      localStringBuilder.append(", uin=");
      localStringBuilder.append(localNearbyPeopleCard.uin);
      localStringBuilder.append(", nickname=");
      localStringBuilder.append(localNearbyPeopleCard.nickname);
      localStringBuilder.append(", gender=");
      localStringBuilder.append(localNearbyPeopleCard.gender);
      localStringBuilder.append(", age=");
      localStringBuilder.append(localNearbyPeopleCard.age);
      localStringBuilder.append(", birthday=");
      localStringBuilder.append(localNearbyPeopleCard.birthday);
      localStringBuilder.append(", constellation=");
      localStringBuilder.append(localNearbyPeopleCard.constellation);
      localStringBuilder.append(", distance=");
      localStringBuilder.append(localNearbyPeopleCard.distance);
      localStringBuilder.append(", timeDiff=");
      localStringBuilder.append(localNearbyPeopleCard.timeDiff);
      localStringBuilder.append(", photoInfoes=");
      localStringBuilder.append(localNearbyPeopleCard.picInfo);
      localStringBuilder.append(", videoDetails=");
      localStringBuilder.append(localNearbyPeopleCard.videoDetails);
      localStringBuilder.append(", commonLabelString=");
      localStringBuilder.append(localNearbyPeopleCard.commonLabelString);
      localStringBuilder.append(", hiWanInfo=");
      localStringBuilder.append(localNearbyPeopleCard.hiWanInfo);
      localStringBuilder.append(", videoInfo=");
      localStringBuilder.append(localNearbyPeopleCard.videoInfo);
      localStringBuilder.append(", photoInfo_length=");
      paramObject = localNearbyPeopleCard.picList;
      String str = "null";
      if (paramObject == null) {
        paramObject = "null";
      } else {
        paramObject = Integer.valueOf(localNearbyPeopleCard.picList.size());
      }
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", likeCount=");
      localStringBuilder.append(localNearbyPeopleCard.likeCount);
      localStringBuilder.append(",likeCountInc=");
      localStringBuilder.append(localNearbyPeopleCard.likeCountInc);
      localStringBuilder.append(", oldPhotoCount=");
      localStringBuilder.append(localNearbyPeopleCard.oldPhotoCount);
      localStringBuilder.append(", dateInfo=");
      localStringBuilder.append(localNearbyPeopleCard.dateInfo);
      localStringBuilder.append(", dateInfo_length=");
      if (localNearbyPeopleCard.dateInfo == null) {
        paramObject = "null";
      } else {
        paramObject = Integer.valueOf(localNearbyPeopleCard.dateInfo.length);
      }
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", xuanYan=");
      localStringBuilder.append(localNearbyPeopleCard.xuanYan);
      localStringBuilder.append(", xuanYan_length=");
      if (localNearbyPeopleCard.xuanYan == null) {
        paramObject = str;
      } else {
        paramObject = Integer.valueOf(localNearbyPeopleCard.xuanYan.length);
      }
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", maritalStatus=");
      localStringBuilder.append(localNearbyPeopleCard.maritalStatus);
      localStringBuilder.append(", job=");
      localStringBuilder.append(localNearbyPeopleCard.job);
      localStringBuilder.append(", charm=");
      localStringBuilder.append(localNearbyPeopleCard.charm);
      localStringBuilder.append(",level=");
      localStringBuilder.append(localNearbyPeopleCard.charmLevel);
      localStringBuilder.append(",next=");
      localStringBuilder.append(localNearbyPeopleCard.nextThreshold);
      localStringBuilder.append(", company=");
      localStringBuilder.append(localNearbyPeopleCard.company);
      localStringBuilder.append(", college=");
      localStringBuilder.append(localNearbyPeopleCard.college);
      localStringBuilder.append(", hometownCountry=");
      localStringBuilder.append(localNearbyPeopleCard.hometownCountry);
      localStringBuilder.append(", hometownProvice=");
      localStringBuilder.append(localNearbyPeopleCard.hometownProvice);
      localStringBuilder.append(", hometownCity=");
      localStringBuilder.append(localNearbyPeopleCard.hometownCity);
      localStringBuilder.append(", hometownDistrict=");
      localStringBuilder.append(localNearbyPeopleCard.hometownDistrict);
      localStringBuilder.append(", bVoted=");
      localStringBuilder.append(localNearbyPeopleCard.bVoted);
      localStringBuilder.append(", feedPreviewTime=");
      localStringBuilder.append(localNearbyPeopleCard.feedPreviewTime);
      localStringBuilder.append(", qzoneFeed=");
      localStringBuilder.append(localNearbyPeopleCard.qzoneFeed);
      localStringBuilder.append(", qzoneName=");
      localStringBuilder.append(localNearbyPeopleCard.qzoneName);
      localStringBuilder.append(", qzonePicUrl_1=");
      localStringBuilder.append(localNearbyPeopleCard.qzonePicUrl_1);
      localStringBuilder.append(", qzonePicUrl_2=");
      localStringBuilder.append(localNearbyPeopleCard.qzonePicUrl_2);
      localStringBuilder.append(", qzonePicUrl_3=");
      localStringBuilder.append(localNearbyPeopleCard.qzonePicUrl_3);
      localStringBuilder.append(", isPhotoUseCache=");
      localStringBuilder.append(localNearbyPeopleCard.isPhotoUseCache);
      localStringBuilder.append(", switchQzone=");
      localStringBuilder.append(localNearbyPeopleCard.switchQzone);
      localStringBuilder.append(", switchHobby=");
      localStringBuilder.append(localNearbyPeopleCard.switchHobby);
      localStringBuilder.append(", uiShowControl=");
      localStringBuilder.append(localNearbyPeopleCard.uiShowControl);
      localStringBuilder.append(", userFlag=");
      localStringBuilder.append(localNearbyPeopleCard.userFlag);
      localStringBuilder.append(", strProfileUrl=");
      localStringBuilder.append(localNearbyPeopleCard.strProfileUrl);
      localStringBuilder.append(", strVoteLimitedNotice=");
      localStringBuilder.append(localNearbyPeopleCard.strVoteLimitedNotice);
      localStringBuilder.append(", bHaveVotedCnt=");
      localStringBuilder.append(localNearbyPeopleCard.bHaveVotedCnt);
      localStringBuilder.append(", bAvailVoteCnt=");
      localStringBuilder.append(localNearbyPeopleCard.bAvailVoteCnt);
      localStringBuilder.append(", hasStory=");
      localStringBuilder.append(localNearbyPeopleCard.mHasStory);
      paramObject = new StringBuilder();
      paramObject.append("NearbyPeopleProfileActivity.onNearbyCardDownload(), isSuccess: ");
      paramObject.append(paramBoolean1);
      paramObject.append(", card = ");
      paramObject.append(localStringBuilder.toString());
      QLog.d("Q.nearby_people_card.", 2, paramObject.toString());
    }
    if ((paramBoolean1) && (localNearbyPeopleCard != null))
    {
      this.a.mUin = localNearbyPeopleCard.uin;
      paramObject = this.a;
      paramBoolean1 = true;
      paramObject.mHasFetchedProfile = true;
      paramObject.handleNearbyProfileCard(localNearbyPeopleCard, false, paramBoolean2);
      this.a.refreshStrangerFace();
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onNearbyCardDownload: likeCount=");
        paramObject.append(localNearbyPeopleCard.likeCount);
        paramObject.append(", bHaveVotedCnt=");
        paramObject.append(localNearbyPeopleCard.bHaveVotedCnt);
        paramObject.append(", bAvailVoteCnt=");
        paramObject.append(localNearbyPeopleCard.bAvailVoteCnt);
        paramObject.append(", bVoted=");
        paramObject.append(localNearbyPeopleCard.bVoted);
        QLog.d("NearbyLikeLimitManager", 2, paramObject.toString());
      }
      ((INearbyLikeLimitManager)this.a.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(localNearbyPeopleCard.getSafetyUin(), false);
      if (TextUtils.equals(localNearbyPeopleCard.getSafetyUin(), this.a.app.getCurrentAccountUin()))
      {
        if ((localNearbyPeopleCard.videoInfo == null) || (TextUtils.isEmpty(localNearbyPeopleCard.videoInfo.d)) || (TextUtils.isEmpty(localNearbyPeopleCard.videoInfo.a))) {
          paramBoolean1 = false;
        }
        SharedPreUtils.a(this.a, paramBoolean1);
      }
      ((INearbyCardManager)this.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a(localNearbyPeopleCard.nowId);
      return;
    }
    if (!paramBoolean2) {
      this.a.showToast(HardCodeUtil.a(2131707273));
    }
  }
  
  public void a(boolean paramBoolean1, Object paramObject, boolean paramBoolean2, String paramString)
  {
    paramObject = (NearbyPeopleCard)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onEditNearbyProfileCard");
    }
    if ((paramObject != null) && (paramObject.tinyId != this.a.mTinyId) && ((paramObject.uin == null) || (!paramObject.uin.equals(this.a.allinone.uin)))) {
      return;
    }
    if ((this.a.mMode != 1) && (this.a.mMode != 2)) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.a.mPicInfo.size() > 1) {
        this.a.mHasNewPhoto = true;
      }
      NearbyPeopleProfileActivity.access$1008(this.a);
      if (this.a.isFaceInfoChange)
      {
        this.a.mCardHandler.a(true);
        this.a.isFaceInfoChange = false;
      }
      this.a.getSharedPreferences("nearby_callback", 4).edit().putInt("nearby_now_edit_profile_code_int", 0);
    }
    this.a.editNearbyProfileCardResult(paramBoolean1, paramObject, paramBoolean2, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = (INearbyLikeLimitManager)this.a.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      if (NearbyPeopleProfileActivity.access$500(this.a) != null) {
        NearbyPeopleProfileActivity.access$500(this.a).h();
      }
      if ((this.a.mMode != 1) && (paramString.a()) && (!this.a.isHasRequestShowPayFirstTip) && (NearbyPeopleProfileActivity.isFromTribe(this.a.from)))
      {
        paramString = this.a;
        paramString.isHasRequestShowPayFirstTip = true;
        paramString = new ImageView(paramString);
        paramString.setScaleType(ImageView.ScaleType.FIT_XY);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        this.a.voteTipDrawable = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/zan.png", (URLDrawable.URLDrawableOptions)localObject);
        if (this.a.voteTipDrawable.getStatus() == 1)
        {
          localObject = this.a;
          ((NearbyPeopleProfileActivity)localObject).showVoteUpdateDialog(paramString, ((NearbyPeopleProfileActivity)localObject).voteTipDrawable);
          return;
        }
        this.a.voteTipDrawable.setURLDrawableListener(new NearbyPeopleProfileActivity.17.1(this, paramString));
        this.a.voteTipDrawable.startDownload();
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((NearbyPeopleProfileActivity.access$300(this.a) != null) && (!TextUtils.isEmpty(NearbyPeopleProfileActivity.access$300(this.a).uin)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (Utils.a(paramString2, paramString1)) {
        return;
      }
      if ((Utils.a(paramString2, NearbyPeopleProfileActivity.access$300(this.a).uin)) && (Utils.a(paramString1, this.a.app.getCurrentAccountUin())))
      {
        if (!paramBoolean)
        {
          paramString1 = this.a;
          paramString1.showToast(paramString1.getResources().getString(2131693371));
          paramString1 = NearbyPeopleProfileActivity.access$300(this.a);
          paramString1.likeCount -= 1;
          NearbyPeopleProfileActivity.access$300(this.a).bVoted = 0;
          paramString1 = NearbyPeopleProfileActivity.access$300(this.a);
          paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt + paramInt1));
          NearbyPeopleProfileActivity.access$500(this.a).h();
          return;
        }
        if (paramInt2 == 1)
        {
          paramString1 = NearbyPeopleProfileActivity.access$300(this.a);
          paramString1.likeCount += paramInt1;
          NearbyPeopleProfileActivity.access$300(this.a).bVoted = 1;
          paramString1 = NearbyPeopleProfileActivity.access$300(this.a);
          paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt - paramInt1));
          if (NearbyPeopleProfileActivity.access$300(this.a).bAvailVoteCnt < 0) {
            NearbyPeopleProfileActivity.access$300(this.a).bAvailVoteCnt = 0;
          }
          NearbyPeopleProfileActivity.access$500(this.a).h();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, List<Object> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onSetPersonalInterestTags");
    }
    if (paramBoolean)
    {
      this.a.dismissWaittingDialog();
      this.a.showToast(2, HardCodeUtil.a(2131707278));
      return;
    }
    this.a.dismissWaittingDialog();
    paramString1 = this.a;
    paramList = new StringBuilder();
    paramList.append(HardCodeUtil.a(2131707269));
    paramList.append(paramString2);
    paramString1.showToast(1, paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.17
 * JD-Core Version:    0.7.0.1
 */