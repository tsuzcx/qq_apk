package com.tencent.mobileqq.nearby.now;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.HashMap;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IStoryPlayController
  extends QRouteApi
{
  public abstract void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void doOnDestroy();
  
  public abstract void doOnPause();
  
  public abstract void doOnResume();
  
  public abstract Object getAdapter();
  
  public abstract Object getBasePlayListDataModel();
  
  public abstract Context getContext();
  
  public abstract int getCurrentIndex();
  
  public abstract int getCurrentMediaType();
  
  public abstract int getFirstShowIndex();
  
  public abstract HashMap<Integer, Object> getItemListeners();
  
  public abstract int getOldState();
  
  public abstract Object getStuffContainerView();
  
  public abstract String getValue(String paramString);
  
  public abstract Object getVideoPlayer();
  
  public abstract void handleDeviceNavChange();
  
  public abstract void hideRootCover();
  
  public abstract IStoryPlayController init(Context paramContext, Object paramObject1, Object paramObject2, Bundle paramBundle, Object paramObject3, AppInterface paramAppInterface, ActCallBack paramActCallBack);
  
  public abstract void initReporterFeedType();
  
  public abstract void initialize(Bundle paramBundle);
  
  public abstract boolean isIsMultiProgressBar();
  
  public abstract boolean isMultiProgressBar();
  
  public abstract boolean isNeedRepeat();
  
  public abstract boolean isRefreshCurrentItem();
  
  public abstract void loadCoverImage(ImageView paramImageView, String paramString, Object paramObject);
  
  public abstract void onFillData(Object paramObject1, VideoData paramVideoData, boolean paramBoolean, Object paramObject2);
  
  public abstract void onFillData(Object paramObject1, VideoData paramVideoData, boolean paramBoolean1, Object paramObject2, boolean paramBoolean2);
  
  public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract void onPagerItemClick(View paramView);
  
  public abstract void onViewConstruct(LayoutInflater paramLayoutInflater, Object paramObject1, Object paramObject2);
  
  public abstract void prepare(boolean paramBoolean, RelativeLayout paramRelativeLayout, VideoData paramVideoData, Object paramObject);
  
  public abstract void prepare(boolean paramBoolean1, RelativeLayout paramRelativeLayout, VideoData paramVideoData, Object paramObject, boolean paramBoolean2);
  
  public abstract void returnBack();
  
  public abstract void setCurrentIndex(int paramInt);
  
  public abstract void setCurrentMediaType(int paramInt);
  
  public abstract void setFirstShowIndex(int paramInt);
  
  public abstract void setIsMultiProgressBar(boolean paramBoolean);
  
  public abstract void setNeedRepeat(boolean paramBoolean);
  
  public abstract void setOldState(int paramInt);
  
  public abstract void setVideoPlayer(Object paramObject);
  
  public abstract void startPlayVideo(int paramInt);
  
  public abstract void updateVideoLabelState();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.IStoryPlayController
 * JD-Core Version:    0.7.0.1
 */