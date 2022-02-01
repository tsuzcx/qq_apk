package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
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
  protected String b;
  protected Map<VideoInfo, Stream<VideoInfo>> b;
  
  public VideoItem(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public VideoItem.VideoViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560776, paramViewGroup, false);
    VideoItem.VideoViewHolder localVideoViewHolder = new VideoItem.VideoViewHolder(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localVideoViewHolder.hashCode()) });
    }
    b(localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localVideoViewHolder);
    b(localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView, localVideoViewHolder);
    b(localVideoViewHolder.b, localVideoViewHolder);
    b(localVideoViewHolder.c, localVideoViewHolder);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localVideoViewHolder;
  }
  
  protected SimpleObserver<ImageInfo> a(ImageInfo paramImageInfo)
  {
    return new VideoItem.1(this, paramImageInfo);
  }
  
  protected SimpleObserver<VideoInfo> a(VideoInfo paramVideoInfo)
  {
    return new VideoItem.2(this, paramVideoInfo);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (VideoInfo)localIterator.next();
        localObject = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          ((Stream)localObject).cancel();
        }
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      super.a(paramInt, paramBoolean);
    }
    do
    {
      Object localObject;
      Stream localStream;
      do
      {
        do
        {
          return;
        } while (paramInt != 1);
        localObject = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
        }
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localObject = (VideoInfo)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((VideoInfo)localObject).c), ", type=", Integer.valueOf(((VideoInfo)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((VideoInfo)localObject).d;
      ((VideoInfo)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((VideoInfo)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, ImageItem.ImageViewHolder paramImageViewHolder)
  {
    VideoInfo localVideoInfo = (VideoInfo)paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase;
    switch (paramView.getId())
    {
    case 2131368482: 
    default: 
    case 2131368479: 
    case 2131368483: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(paramImageViewHolder);
        return;
      } while (localVideoInfo.g != 2);
      paramImageViewHolder.b.setVisibility(4);
      a(localVideoInfo);
      return;
    }
    InputMethodUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localVideoInfo.c), ", path=", localVideoInfo.f });
    }
    a(localVideoInfo);
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    paramImageInfo = (VideoInfo)paramImageInfo;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = paramImageInfo.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramImageInfo))) {
      this.jdField_b_of_type_JavaUtilMap.put(paramImageInfo, localStream1);
    }
    Stream localStream2 = paramImageInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramImageInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramImageInfo, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = paramImageInfo.d;
        paramImageInfo.a = System.currentTimeMillis();
        localStream1.subscribe(a(paramImageInfo));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramImageInfo.d;
    this.jdField_a_of_type_Boolean = true;
    paramImageInfo.a = System.currentTimeMillis();
    localStream2.subscribe(a(paramImageInfo));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", paramVideoInfo.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    paramVideoInfo = new Intent();
    paramVideoInfo.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    paramVideoInfo.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(paramVideoInfo);
  }
  
  protected void a(ImageItem.ImageViewHolder paramImageViewHolder, ImageInfo paramImageInfo, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramImageViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramImageViewHolder.c.setVisibility(0);
      paramImageViewHolder.b.setVisibility(4);
      paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      paramImageViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (paramImageInfo.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramImageInfo.e, paramImageInfo.d);
        paramImageViewHolder.b.setVisibility(4);
        paramImageViewHolder.c.setVisibility(4);
        return;
      }
    } while (paramImageInfo.e != 100);
    paramImageViewHolder.a();
    return;
    paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    paramImageViewHolder.b.setVisibility(0);
    paramImageViewHolder.c.setVisibility(4);
  }
  
  public void d(EditItemInfoBase paramEditItemInfoBase)
  {
    super.d(paramEditItemInfoBase);
    paramEditItemInfoBase = (VideoInfo)paramEditItemInfoBase;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      paramEditItemInfoBase = (Stream)this.jdField_b_of_type_JavaUtilMap.get(paramEditItemInfoBase);
      if (paramEditItemInfoBase != null) {
        paramEditItemInfoBase.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem
 * JD-Core Version:    0.7.0.1
 */