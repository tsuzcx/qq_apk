package com.tencent.richmediabrowser.presenter.video;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.model.video.VideoModel;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.EmptyDrawable;
import com.tencent.richmediabrowser.view.video.VideoView;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPresenter
  extends BrowserBasePresenter
{
  private static final String TAG = "VideoPresenter";
  public ConcurrentHashMap<Integer, Drawable> mActiveThumbDrawable = new ConcurrentHashMap();
  public VideoModel videoModel;
  private VideoView videoView;
  
  public static Drawable getCoverDrawable(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCoverDrawable():  getDrawable Exception, coverUrl=");
        localStringBuilder.append(paramString);
        localStringBuilder.append("exception = ");
        localStringBuilder.append(localException.getMessage());
        localIBrowserLog.d("VideoPresenter", 4, localStringBuilder.toString());
      }
    }
    return localEmptyDrawable;
  }
  
  public void dealVideoAutoPlay(String paramString, boolean paramBoolean)
  {
    paramString = getItem(paramString);
    if ((paramString != null) && ((paramString.baseData instanceof VideoData)))
    {
      VideoData localVideoData = (VideoData)paramString.baseData;
      localVideoData.isAutoPlay = paramBoolean;
      paramString.baseData = localVideoData;
      updateItem(paramString);
    }
  }
  
  public void dealVideoMutePlay(String paramString, boolean paramBoolean)
  {
    paramString = getItem(paramString);
    if ((paramString != null) && ((paramString.baseData instanceof VideoData)))
    {
      VideoData localVideoData = (VideoData)paramString.baseData;
      localVideoData.isMutePlay = paramBoolean;
      paramString.baseData = localVideoData;
      updateItem(paramString);
    }
  }
  
  public void downloadVideo(VideoData paramVideoData)
  {
    if ((paramVideoData != null) && (!TextUtils.isEmpty(paramVideoData.url)) && (this.mainBrowserPresenter.getParamsBuilder().a() != null)) {
      this.mainBrowserPresenter.getParamsBuilder().a().c(paramVideoData.url);
    }
  }
  
  public VideoData getCurrentVideoData()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 2)) {
      return (VideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public boolean isAutoPlay(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof VideoData))) {
      return ((VideoData)localRichMediaBrowserInfo.baseData).isAutoPlay;
    }
    return false;
  }
  
  public boolean isAutoPlay(String paramString)
  {
    paramString = getItem(paramString);
    if ((paramString != null) && ((paramString.baseData instanceof VideoData))) {
      return ((VideoData)paramString.baseData).isAutoPlay;
    }
    return false;
  }
  
  public boolean isMutePlay(String paramString)
  {
    paramString = getItem(paramString);
    if ((paramString != null) && ((paramString.baseData instanceof VideoData))) {
      return ((VideoData)paramString.baseData).isMutePlay;
    }
    return false;
  }
  
  public void loadVideoCover(int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    Object localObject = getItem(paramInt3);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 2))
    {
      localObject = (VideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (((VideoData)localObject).coverDrawable != null)
      {
        paramImageView.setImageDrawable(((VideoData)localObject).coverDrawable);
        this.mActiveThumbDrawable.put(Integer.valueOf(paramInt3), ((VideoData)localObject).coverDrawable);
        return;
      }
      if (!TextUtils.isEmpty(((VideoData)localObject).coverUrl))
      {
        localObject = getCoverDrawable(((VideoData)localObject).coverUrl, paramInt1, paramInt2);
        this.mActiveThumbDrawable.put(Integer.valueOf(paramInt3), localObject);
        paramImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("VideoPresenter", 4, "loadVideoCover error");
    }
  }
  
  public void notifyProgress(String paramString, int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramString);
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof VideoData)))
    {
      VideoData localVideoData = (VideoData)localRichMediaBrowserInfo.baseData;
      localVideoData.status = 1;
      localVideoData.progress = paramInt;
      localRichMediaBrowserInfo.baseData = localVideoData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((this.videoView != null) && (localRichMediaBrowserInfo.baseData != null) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(localRichMediaBrowserInfo.baseData.id)) && (paramString.equals(localRichMediaBrowserInfo.baseData.id))) {
      this.videoView.updateUI();
    }
  }
  
  public void notifyResult(String paramString, int paramInt)
  {
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("notifyResult id = ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" ,result = ");
    ((StringBuilder)localObject2).append(paramInt);
    ((IBrowserLog)localObject1).d("VideoPresenter", 4, ((StringBuilder)localObject2).toString());
    localObject1 = getItem(paramString);
    if ((localObject1 != null) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof VideoData)))
    {
      localObject2 = (VideoData)((RichMediaBrowserInfo)localObject1).baseData;
      ((VideoData)localObject2).status = 0;
      ((VideoData)localObject2).progress = 0;
      ((VideoData)localObject2).errorCode = paramInt;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      updateItem((RichMediaBrowserInfo)localObject1);
    }
    localObject1 = getSelectedItem();
    if ((this.videoView != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(((RichMediaBrowserInfo)localObject1).baseData.id)) && (paramString.equals(((RichMediaBrowserInfo)localObject1).baseData.id))) {
      this.videoView.updateUI();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.videoView;
    if (localObject != null) {
      ((VideoView)localObject).onDestroy();
    }
    this.mActiveThumbDrawable.clear();
    localObject = getCurrentVideoData();
    if ((localObject != null) && (((VideoData)localObject).status == 1) && (!TextUtils.isEmpty(((VideoData)localObject).url)) && (this.mainBrowserPresenter.getParamsBuilder().a() != null)) {
      this.mainBrowserPresenter.getParamsBuilder().a().d(((VideoData)localObject).url);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    VideoView localVideoView = this.videoView;
    if (localVideoView != null) {
      localVideoView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    VideoView localVideoView = this.videoView;
    if (localVideoView != null) {
      localVideoView.onResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    VideoView localVideoView = this.videoView;
    if (localVideoView != null) {
      localVideoView.onStop();
    }
  }
  
  public void setBrowserModel(IBaseModelBuilder paramIBaseModelBuilder)
  {
    if ((paramIBaseModelBuilder instanceof VideoModel)) {
      this.videoModel = ((VideoModel)paramIBaseModelBuilder);
    }
  }
  
  public void setBrowserView(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.setBrowserView(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof VideoView)) {
      this.videoView = ((VideoView)paramIBaseViewBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.video.VideoPresenter
 * JD-Core Version:    0.7.0.1
 */