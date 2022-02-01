package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class VideoItem$2
  extends SimpleObserver<VideoInfo>
{
  VideoItem$2(VideoItem paramVideoItem, VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(paramVideoInfo.g), ", old status=", Integer.valueOf(paramVideoInfo.o) });
    }
    this.b.g.remove(paramVideoInfo);
    this.b.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.a.g), ", old status=", Integer.valueOf(this.a.o) });
    }
    this.a.o = 2;
    this.b.g.remove(this.a);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.b.b != null)
    {
      Object localObject = this.b.b.findViewHolderForLayoutPosition(this.a.g);
      if ((localObject instanceof VideoItem.VideoViewHolder))
      {
        localObject = (VideoItem.VideoViewHolder)localObject;
        if (this.a.e.equals(((VideoItem.VideoViewHolder)localObject).g.getTag())) {
          ((VideoItem)((XMediaEditorAdapter)this.b.b.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject, this.a, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      TroopReportor.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.a.n), "");
    }
    if (this.a.e.equals(this.b.e)) {
      this.b.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.2
 * JD-Core Version:    0.7.0.1
 */