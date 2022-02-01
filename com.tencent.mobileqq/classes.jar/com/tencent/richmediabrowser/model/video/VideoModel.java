package com.tencent.richmediabrowser.model.video;

import android.graphics.drawable.Drawable;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import java.io.File;

public class VideoModel
  extends BrowserBaseModel
{
  private VideoPresenter videoPresenter;
  
  public VideoModel(BasePresenter paramBasePresenter)
  {
    if ((paramBasePresenter instanceof VideoPresenter)) {
      this.videoPresenter = ((VideoPresenter)paramBasePresenter);
    }
  }
  
  public Drawable getAnimationDrawable(VideoData paramVideoData)
  {
    return null;
  }
  
  public File getCacheFile(VideoData paramVideoData, int paramInt)
  {
    return null;
  }
  
  public int getCacheFileType(VideoData paramVideoData, String paramString)
  {
    return 0;
  }
  
  public String getURL(VideoData paramVideoData, int paramInt)
  {
    return null;
  }
  
  public boolean hasFile(VideoData paramVideoData, int paramInt)
  {
    return false;
  }
  
  public void imageDownloaded(VideoData paramVideoData, int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.video.VideoModel
 * JD-Core Version:    0.7.0.1
 */