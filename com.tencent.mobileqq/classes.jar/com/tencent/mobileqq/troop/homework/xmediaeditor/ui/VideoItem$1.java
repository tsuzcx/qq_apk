package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class VideoItem$1
  extends SimpleObserver<ImageInfo>
{
  VideoItem$1(VideoItem paramVideoItem, ImageInfo paramImageInfo) {}
  
  public void a(ImageInfo paramImageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(paramImageInfo.g), ", old status=", Integer.valueOf(paramImageInfo.o), ", result=", paramImageInfo });
    }
    paramImageInfo.o = 3;
    paramImageInfo.l = 100;
    this.b.d.remove(paramImageInfo);
    if (this.b.b != null)
    {
      Object localObject = this.b.b.findViewHolderForLayoutPosition(paramImageInfo.g);
      if ((localObject instanceof VideoItem.VideoViewHolder))
      {
        localObject = (VideoItem.VideoViewHolder)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(paramImageInfo.hashCode()), ", result hash=", Integer.valueOf(paramImageInfo.hashCode()), ", info position=", Integer.valueOf(paramImageInfo.g), ", result position=", Integer.valueOf(paramImageInfo.g), ", vh position=", Integer.valueOf(((VideoItem.VideoViewHolder)localObject).f.g), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (paramImageInfo.e.equals(((VideoItem.VideoViewHolder)localObject).g.getTag()))
        {
          ((VideoItem.VideoViewHolder)localObject).g.setVisibility(0);
          ((VideoItem.VideoViewHolder)localObject).g.setDrawStatus(1);
          ((VideoItem.VideoViewHolder)localObject).g.setAnimProgress(paramImageInfo.l, paramImageInfo.e);
        }
        this.b.c.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    TroopReportor.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - paramImageInfo.n), "");
    this.b.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.a.g), ", info old status=", Integer.valueOf(this.a.o) });
    }
    this.a.o = 2;
    this.b.d.remove(this.a);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.b.b != null)
    {
      Object localObject = this.b.b.findViewHolderForLayoutPosition(this.a.g);
      if ((localObject instanceof VideoItem.VideoViewHolder))
      {
        localObject = (VideoItem.VideoViewHolder)localObject;
        if (this.a.e.equals(((VideoItem.VideoViewHolder)localObject).g.getTag()))
        {
          ((VideoItem)((XMediaEditorAdapter)this.b.b.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject, this.a, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            QQToast.makeText(this.b.b.getContext(), HardCodeUtil.a(2131913490), 0).show();
            this.b.c.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      TroopReportor.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.a.n), "");
    }
    if (this.a.e.equals(this.b.e)) {
      this.b.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.1
 * JD-Core Version:    0.7.0.1
 */