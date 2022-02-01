package com.tencent.richmediabrowser.presenter.video;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.EmptyDrawable;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPresenter
  extends BrowserBasePresenter
{
  private static final String TAG = "VideoPresenter";
  public ConcurrentHashMap<Integer, URLDrawable> mActiveThumbDrawable = new ConcurrentHashMap();
  
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
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoPresenter", 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + "exception = " + localException.getMessage());
      }
    }
    return localEmptyDrawable;
  }
  
  public void buildPresenter() {}
  
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
  
  public void handleUnDownloadVideo(VideoData paramVideoData) {}
  
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
  
  public void loadShortVideoCover(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3) {}
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.video.VideoPresenter
 * JD-Core Version:    0.7.0.1
 */