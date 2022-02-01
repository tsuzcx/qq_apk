package com.tencent.mobileqq.nearby.now.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IShortVideoCommentsView
  extends QRouteApi
{
  public abstract void addLoadingErrorView(Object paramObject);
  
  public abstract boolean canPlayNext();
  
  public abstract AppInterface getApp();
  
  public abstract View getPlayerView();
  
  public abstract Comments getmComments();
  
  public abstract ImageView getmEmptyCloseBtn();
  
  public abstract void init(Object paramObject, VideoData paramVideoData);
  
  public abstract void initLocationView();
  
  public abstract void initRecorderInfoView();
  
  public abstract boolean isScrollTop();
  
  public abstract void jump2Report(Comments.Comment paramComment);
  
  public abstract void onActivityCreated(Comments paramComments, int paramInt);
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onCreate();
  
  public abstract View onCreateView();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void reportBindPhoneAction(AppInterface paramAppInterface, String paramString);
  
  public abstract void scrollToComment();
  
  public abstract void scrollToTop();
  
  public abstract void setApp(AppInterface paramAppInterface);
  
  public abstract void setPlayerView(View paramView);
  
  public abstract void setVideoData(VideoData paramVideoData);
  
  public abstract void setmComments(Comments paramComments);
  
  public abstract void setmEmptyCloseBtn(ImageView paramImageView);
  
  public abstract void showBindPhone(String paramString);
  
  public abstract void showBottomeArea();
  
  public abstract void showComment();
  
  public abstract void showDelAndReportSheet(Comments.Comment paramComment);
  
  public abstract void showDelSheet(Comments.Comment paramComment);
  
  public abstract void showEmptyCloseBtn();
  
  public abstract void showReportSheet(Comments.Comment paramComment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
 * JD-Core Version:    0.7.0.1
 */