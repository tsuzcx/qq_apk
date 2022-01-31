package com.tencent.richmediabrowser.view.video;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.Gallery.LayoutParams;
import java.util.concurrent.ConcurrentHashMap;

public class VideoView
  extends BrowserBaseView
  implements View.OnClickListener
{
  private static final String TAG = "VideoView";
  public VideoPresenter videoPresenter;
  
  public VideoView(Activity paramActivity, VideoPresenter paramVideoPresenter)
  {
    super(paramActivity, paramVideoPresenter);
    this.videoPresenter = paramVideoPresenter;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void clearShortVideo()
  {
    clearTheOuchCache();
  }
  
  public void clearTheOuchCache()
  {
    this.videoPresenter.mActiveThumbDrawable.clear();
  }
  
  public void dealVideoAutoPlay(String paramString, boolean paramBoolean)
  {
    this.videoPresenter.dealVideoAutoPlay(paramString, paramBoolean);
  }
  
  public void dealVideoMutePlay(String paramString, boolean paramBoolean)
  {
    this.videoPresenter.dealVideoMutePlay(paramString, paramBoolean);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof VideoView.GalleryVideoViewHolder)))
    {
      this.galleryView = ((RelativeLayout)paramView);
      paramView = ((VideoView.GalleryVideoViewHolder)paramView.getTag()).videoView;
    }
    for (;;)
    {
      paramView = new VideoView.GalleryVideoViewHolder(this);
      this.galleryView.setTag(paramView);
      return this.galleryView;
      this.galleryView = new RelativeLayout(this.mContext);
      paramView = new Gallery.LayoutParams(-1, -1);
      this.galleryView.setLayoutParams(paramView);
    }
  }
  
  public void notifyVideoUrl(long paramLong, int paramInt1, int paramInt2, String paramString, String[] paramArrayOfString) {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.videoPresenter.mActiveThumbDrawable.remove(Integer.valueOf(paramInt));
  }
  
  public void onEnterAnimationEnd()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onEnterAnimationEnd");
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onEnterAnimationStart");
    showContentView(false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.videoPresenter.getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.baseData == null)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onItemClick data is null，position = " + paramInt);
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    updateUI();
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onPause");
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onResume");
  }
  
  public void onScrollEnd(int paramInt) {}
  
  public void onScrollHalfScreenWidth()
  {
    super.onScrollHalfScreenWidth();
  }
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onStop");
    clearShortVideo();
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void updateUI()
  {
    super.updateUI();
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.video.VideoView
 * JD-Core Version:    0.7.0.1
 */