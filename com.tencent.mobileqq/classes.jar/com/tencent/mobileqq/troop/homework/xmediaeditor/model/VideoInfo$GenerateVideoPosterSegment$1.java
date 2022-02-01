package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.VideoViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  VideoInfo$GenerateVideoPosterSegment$1(VideoInfo.GenerateVideoPosterSegment paramGenerateVideoPosterSegment, VideoInfo paramVideoInfo, String paramString) {}
  
  public void run()
  {
    this.a.a(this.b);
    Object localObject1 = this.a;
    ((VideoInfo)localObject1).l = 5;
    ((VideoInfo)localObject1).o = -2147483646;
    localObject1 = (XMediaEditor)VideoInfo.GenerateVideoPosterSegment.a(this.this$0).get();
    if (localObject1 != null)
    {
      Object localObject2 = ((XMediaEditor)localObject1).findViewHolderForLayoutPosition(this.a.g);
      if ((localObject2 instanceof VideoItem.VideoViewHolder))
      {
        localObject2 = (VideoItem.VideoViewHolder)localObject2;
        if (this.a.e.equals(((VideoItem.VideoViewHolder)localObject2).g.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject2.hashCode()) });
          }
          ((VideoItem)((XMediaEditorAdapter)((XMediaEditor)localObject1).getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject2, this.a, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */