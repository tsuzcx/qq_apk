package com.tencent.richmediabrowser.model.video;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import java.io.File;

public class VideoModel
  implements IBaseModelBuilder
{
  private VideoPresenter videoPresenter;
  
  public VideoModel(IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if ((paramIBasePresenterBuilder instanceof VideoPresenter)) {
      this.videoPresenter = ((VideoPresenter)paramIBasePresenterBuilder);
    }
  }
  
  public void buildComplete() {}
  
  public void buildModel() {}
  
  public void buildParams(Intent paramIntent) {}
  
  public boolean isVideoFileExisits(VideoData paramVideoData)
  {
    if ((paramVideoData != null) && (!TextUtils.isEmpty(paramVideoData.filePath))) {
      return new File(paramVideoData.filePath).exists();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.video.VideoModel
 * JD-Core Version:    0.7.0.1
 */