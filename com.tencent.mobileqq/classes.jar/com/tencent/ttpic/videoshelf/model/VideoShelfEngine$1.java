package com.tencent.ttpic.videoshelf.model;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.baseutils.thread.HandlerThreadTag;
import com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.model.processor.PagVideoShelfProcessor;
import com.tencent.view.FilterContext;

class VideoShelfEngine$1
  implements Handler.Callback
{
  VideoShelfEngine$1(VideoShelfEngine paramVideoShelfEngine) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 108: 
      VideoShelfEngine.access$702(this.this$0, true);
      VideoShelfEngine.access$900(this.this$0);
      return false;
    case 107: 
      if (VideoShelfEngine.access$700(this.this$0)) {
        VideoShelfEngine.access$300(this.this$0).onCancelCompleted();
      } else {
        VideoShelfEngine.access$300(this.this$0).onCompleted();
      }
      VideoShelfEngine.access$702(this.this$0, false);
      VideoShelfEngine.access$400(this.this$0).removeCallbacksAndMessages(null);
      HandlerThreadManager.getInstance().destroyHandlerThread(HandlerThreadTag.VIDEO_SHELF_SAVE);
      return false;
    case 106: 
      VideoShelfEngine.access$000(this.this$0).destroyEgl();
      return false;
    case 105: 
      VideoShelfEngine.access$900(this.this$0);
      return false;
    case 104: 
      if (VideoShelfEngine.access$700(this.this$0))
      {
        VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(105);
        return false;
      }
      VideoShelfEngine.access$800(this.this$0);
      if ((VideoShelfEngine.access$100(this.this$0) != null) && (VideoShelfEngine.access$100(this.this$0).updateFrameCursor()))
      {
        VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(102);
        return false;
      }
      VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(105);
      return false;
    case 103: 
      VideoShelfEngine.access$600(this.this$0);
      VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(104);
      return false;
    case 102: 
      if ((VideoShelfEngine.access$100(this.this$0) != null) && (VideoShelfEngine.access$100(this.this$0).getProgress() >= 100)) {
        VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(105);
      }
      if (VideoShelfEngine.access$500(this.this$0) < 0)
      {
        VideoShelfEngine.access$300(this.this$0).onError(-1, 0, "decode error");
        VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(105);
        return false;
      }
      VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(103);
      return false;
    case 101: 
      int i;
      if (VideoShelfEngine.access$200(this.this$0)) {
        i = 0;
      } else {
        i = VideoShelfEngine.access$100(this.this$0).isPrepareInit();
      }
      if ((VideoShelfEngine.access$100(this.this$0) != null) && (i <= 0))
      {
        VideoShelfEngine.access$300(this.this$0).onStartGenerate();
        if (VideoShelfEngine.access$300(this.this$0) != null) {
          VideoShelfEngine.access$300(this.this$0).onProgress(1);
        }
        this.this$0.init();
        VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(102);
        return false;
      }
      VideoShelfEngine.access$300(this.this$0).onError(-1, i, "file not exit or app version is low.");
      VideoShelfEngine.access$400(this.this$0).sendEmptyMessage(105);
      return false;
    }
    VideoShelfEngine.access$002(this.this$0, new FilterContext());
    VideoShelfEngine.access$000(this.this$0).usecurruntContext();
    if ((VideoShelfEngine.access$100(this.this$0) instanceof PagVideoShelfProcessor)) {
      VideoShelfEngine.access$100(this.this$0).setParam("PagVideoShelfProcessor_1", VideoShelfEngine.access$000(this.this$0));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.VideoShelfEngine.1
 * JD-Core Version:    0.7.0.1
 */