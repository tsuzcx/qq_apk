package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPlayOperationViewModel
  extends QRouteApi
{
  public static final int FEED_TYPE_RECORD_LIVE_VIDEO_FEED = 1;
  public static final int FEED_TYPE_RECORD_STORY_VIDEO_FEED = 3;
  public static final int FEED_TYPE_RECORD_VIDEO_FEED = 2;
  public static final int TRANSPARENT = 0;
  public static final int TYPE_CHANG = 6;
  public static final int TYPE_PIC = 4;
  public static final int WHITE_BGK = 1;
  
  public abstract void destroy();
  
  public abstract AppInterface getApp();
  
  public abstract String getExtraInfo();
  
  public abstract boolean getIsAggregation();
  
  public abstract boolean getIsCanJump();
  
  public abstract boolean getIsFollow();
  
  public abstract boolean getIsLiked();
  
  public abstract boolean getIsLocal();
  
  public abstract boolean getIsMine();
  
  public abstract boolean getIsRecord();
  
  public abstract int getLikes();
  
  public abstract String getNickName();
  
  public abstract int getOperatorMode();
  
  public abstract String getRecordTime();
  
  public abstract String getRecordTitle();
  
  public abstract String getVideoSrc();
  
  public abstract int getWatchCount();
  
  public abstract View getmBinding();
  
  public abstract View getmHeadBinding();
  
  public abstract void hideCommentsWidget();
  
  public abstract void hideHead();
  
  public abstract IPlayOperationViewModel init(View paramView, AppInterface paramAppInterface);
  
  public abstract void initCommentsWidget();
  
  public abstract boolean isDialogShow();
  
  public abstract boolean isJubaoDialogShow();
  
  public abstract void onClickClose(View paramView);
  
  public abstract void onClickFollow(View paramView);
  
  public abstract void onClickHeader(View paramView);
  
  public abstract void onClickLabelJump(View paramView);
  
  public abstract void onClickLike(View paramView);
  
  public abstract void onClickMore(View paramView);
  
  public abstract void onClickNickName(View paramView);
  
  public abstract void onClickPublishComment(View paramView);
  
  public abstract void onClickShare(View paramView);
  
  public abstract void parseShortVideoVideoLabel(Object paramObject);
  
  public abstract boolean queryVideoState(long paramLong);
  
  public abstract void release();
  
  public abstract void reshowOperaView();
  
  public abstract void setAgeAndGender(int paramInt1, int paramInt2);
  
  public abstract void setAggregation(boolean paramBoolean);
  
  public abstract void setApp(AppInterface paramAppInterface);
  
  public abstract void setCanJump(boolean paramBoolean);
  
  public abstract void setCommentsCount(long paramLong);
  
  public abstract void setCurrentAnchorUin(long paramLong);
  
  public abstract void setDialogShow(boolean paramBoolean);
  
  public abstract void setExtraInfo(String paramString);
  
  public abstract void setFeedType(int paramInt);
  
  public abstract void setFollow(boolean paramBoolean);
  
  public abstract void setHeadBinding(View paramView);
  
  public abstract void setHeadInfoMaskWhiteMode();
  
  public abstract void setHeadUrl(String paramString);
  
  public abstract void setIsMine(boolean paramBoolean);
  
  public abstract void setJubaoDialogShow(boolean paramBoolean);
  
  public abstract void setLiked(boolean paramBoolean);
  
  public abstract void setLikes(int paramInt);
  
  public abstract void setLocal(boolean paramBoolean);
  
  public abstract void setNickName(String paramString);
  
  public abstract void setOnCloseListener(Object paramObject);
  
  public abstract void setOnCommentClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOpenRoomHeadUrl(String paramString);
  
  public abstract void setOperatorMode(int paramInt);
  
  public abstract void setRecord(boolean paramBoolean);
  
  public abstract void setRecordTime(String paramString);
  
  public abstract void setRecordTitle(String paramString);
  
  public abstract void setTopOperationBkg(int paramInt);
  
  public abstract void setVideoPageSource(int paramInt);
  
  public abstract void setVideoSrc(String paramString);
  
  public abstract void setWatchCount(int paramInt);
  
  public abstract void setmBinding(View paramView);
  
  public abstract void setmHeadBinding(View paramView);
  
  public abstract void showIfCan(boolean paramBoolean);
  
  public abstract void updateShowInfo(VideoData paramVideoData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
 * JD-Core Version:    0.7.0.1
 */