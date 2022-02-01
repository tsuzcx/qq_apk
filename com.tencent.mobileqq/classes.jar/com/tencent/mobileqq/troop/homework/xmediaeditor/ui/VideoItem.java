package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class VideoItem
  extends ImageItem
{
  protected Map<VideoInfo, Stream<VideoInfo>> g;
  protected String h;
  
  public VideoItem(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = this.g;
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      localObject1 = this.g.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (VideoInfo)((Iterator)localObject1).next();
        localObject2 = (Stream)this.g.get(localObject2);
        if (localObject2 != null) {
          ((Stream)localObject2).cancel();
        }
      }
      this.g.clear();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      super.a(paramInt, paramBoolean);
      return;
    }
    if (paramInt == 1)
    {
      Object localObject = this.g.keySet().iterator();
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
      }
      if (((Iterator)localObject).hasNext())
      {
        localObject = (VideoInfo)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((VideoInfo)localObject).g), ", type=", Integer.valueOf(((VideoInfo)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        Stream localStream = (Stream)this.g.get(localObject);
        if (localStream != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
          }
          this.h = ((VideoInfo)localObject).e;
          ((VideoInfo)localObject).n = System.currentTimeMillis();
          localStream.subscribe(b((VideoInfo)localObject));
        }
      }
      else
      {
        this.h = null;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.f) });
        }
        if (!this.f) {
          a(0, true);
        }
      }
    }
  }
  
  public void a(View paramView, ImageItem.ImageViewHolder paramImageViewHolder)
  {
    VideoInfo localVideoInfo = (VideoInfo)paramImageViewHolder.f;
    int i = paramView.getId();
    if (i == 2131435095)
    {
      this.c.a(paramImageViewHolder);
      return;
    }
    if (i == 2131435099)
    {
      if (localVideoInfo.o == 2)
      {
        paramImageViewHolder.d.setVisibility(4);
        a(localVideoInfo);
      }
    }
    else if ((i == 2131435097) || (i == 2131435096))
    {
      InputMethodUtil.a((Activity)this.b.getContext());
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localVideoInfo.g), ", path=", localVideoInfo.r });
      }
      a(localVideoInfo);
    }
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    paramImageInfo = (VideoInfo)paramImageInfo;
    if (this.d == null) {
      this.d = new LinkedHashMap();
    }
    if (this.g == null) {
      this.g = new LinkedHashMap();
    }
    Stream localStream1 = paramImageInfo.b(this.b);
    if ((localStream1 != null) && (!this.g.containsKey(paramImageInfo))) {
      this.g.put(paramImageInfo, localStream1);
    }
    Stream localStream2 = paramImageInfo.a(this.b);
    if (!this.d.containsKey(paramImageInfo)) {
      this.d.put(paramImageInfo, localStream2);
    }
    if (localStream1 != null)
    {
      if (TextUtils.isEmpty(this.h))
      {
        this.h = paramImageInfo.e;
        paramImageInfo.n = System.currentTimeMillis();
        localStream1.subscribe(b(paramImageInfo));
      }
    }
    else if (TextUtils.isEmpty(this.e))
    {
      this.e = paramImageInfo.e;
      this.f = true;
      paramImageInfo.n = System.currentTimeMillis();
      localStream2.subscribe(b(paramImageInfo));
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (this.b.getShowType() == 0) {
      this.b.requestFocus();
    }
    QBaseActivity localQBaseActivity = (QBaseActivity)this.b.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("file_send_path", paramVideoInfo.j());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    RouteUtils.a(localQBaseActivity, localIntent, "/business/shortvideoplay");
    paramVideoInfo = new Intent();
    paramVideoInfo.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    paramVideoInfo.setPackage(localQBaseActivity.getPackageName());
    localQBaseActivity.sendBroadcast(paramVideoInfo);
  }
  
  protected void a(ImageItem.ImageViewHolder paramImageViewHolder, ImageInfo paramImageInfo, int paramInt)
  {
    if (paramInt != 0)
    {
      paramImageViewHolder.c.setVisibility(4);
      paramImageViewHolder.e.setVisibility(0);
      paramImageViewHolder.d.setVisibility(4);
      paramImageViewHolder.g.setVisibility(4);
      return;
    }
    paramImageViewHolder.c.setVisibility(0);
    paramInt = paramImageInfo.o;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        switch (paramInt)
        {
        default: 
          return;
        }
        paramImageViewHolder.g.setVisibility(0);
        paramImageViewHolder.g.setDrawStatus(1);
        paramImageViewHolder.g.setAnimProgress(paramImageInfo.l, paramImageInfo.e);
        paramImageViewHolder.d.setVisibility(4);
        paramImageViewHolder.e.setVisibility(4);
        return;
      }
      if (paramImageInfo.l == 100) {
        paramImageViewHolder.a();
      }
    }
    else
    {
      paramImageViewHolder.g.setVisibility(4);
      paramImageViewHolder.d.setVisibility(0);
      paramImageViewHolder.e.setVisibility(4);
    }
  }
  
  protected SimpleObserver<ImageInfo> b(ImageInfo paramImageInfo)
  {
    return new VideoItem.1(this, paramImageInfo);
  }
  
  protected SimpleObserver<VideoInfo> b(VideoInfo paramVideoInfo)
  {
    return new VideoItem.2(this, paramVideoInfo);
  }
  
  public VideoItem.VideoViewHolder c(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626707, paramViewGroup, false);
    VideoItem.VideoViewHolder localVideoViewHolder = new VideoItem.VideoViewHolder(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localVideoViewHolder.hashCode()) });
    }
    b(localVideoViewHolder.b, localVideoViewHolder);
    b(localVideoViewHolder.c, localVideoViewHolder);
    b(localVideoViewHolder.d, localVideoViewHolder);
    b(localVideoViewHolder.e, localVideoViewHolder);
    if (this.b.getLeftRightPadding() != 0) {
      paramViewGroup.setPadding(this.b.getLeftRightPadding(), 0, this.b.getLeftRightPadding(), 0);
    }
    return localVideoViewHolder;
  }
  
  public void d(EditItemInfoBase paramEditItemInfoBase)
  {
    super.d(paramEditItemInfoBase);
    paramEditItemInfoBase = (VideoInfo)paramEditItemInfoBase;
    Map localMap = this.g;
    if ((localMap != null) && (!localMap.isEmpty()))
    {
      paramEditItemInfoBase = (Stream)this.g.get(paramEditItemInfoBase);
      if (paramEditItemInfoBase != null) {
        paramEditItemInfoBase.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem
 * JD-Core Version:    0.7.0.1
 */