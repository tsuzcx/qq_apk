package com.tencent.mobileqq.shortvideo.filter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.SLog;

class QQMovieFilter$1
  extends Handler
{
  QQMovieFilter$1(QQMovieFilter paramQQMovieFilter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handle movie filter msg, what = ");
    ((StringBuilder)localObject).append(paramMessage.what);
    SLog.i("QQMovieFilter", ((StringBuilder)localObject).toString());
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (QQMovieFilter.access$000(this.this$0) != null) {
            QQMovieFilter.access$000(this.this$0).stopMusic();
          }
        }
        else if (QQMovieFilter.access$000(this.this$0) != null)
        {
          QQMovieFilter.access$000(this.this$0).resumeMusic();
        }
      }
      else
      {
        if ((QQMovieFilter.access$000(this.this$0) != null) && (QQMovieFilter.access$000(this.this$0).getCurrentState() == 1))
        {
          SLog.i("QQMovieFilter", "DecodePlayer is preparing");
          return;
        }
        localObject = (Object[])paramMessage.obj;
        QQMovieFilter.access$102(this.this$0, (String)localObject[0]);
        paramMessage = (String)localObject[1];
        boolean bool = ((Boolean)localObject[2]).booleanValue();
        QQMovieFilter.access$202(this.this$0, ((Float)localObject[3]).floatValue());
        QQMovieFilter.access$302(this.this$0, ((Float)localObject[4]).floatValue());
        localObject = (HWDecodeListener)localObject[5];
        if (QQMovieFilter.access$000(this.this$0) == null) {
          QQMovieFilter.access$002(this.this$0, new DecodePlayer());
        }
        if (QQMovieFilter.access$400(this.this$0) != null) {
          QQMovieFilter.access$400(this.this$0).disable();
        }
        if (FileUtil.fileExistsAndNotEmpty(QQMovieFilter.access$100(this.this$0)))
        {
          QQMovieFilter.access$000(this.this$0).setFilePath(QQMovieFilter.access$100(this.this$0), paramMessage);
          QQMovieFilter.access$000(this.this$0).setRepeat(bool);
          QQMovieFilter.access$000(this.this$0).setDecodeListener((HWDecodeListener)localObject);
          paramMessage = this.this$0;
          QQMovieFilter.access$402(paramMessage, new QQMovieFilter.MovieOnFrameAvailableListener(paramMessage));
          QQMovieFilter.access$000(this.this$0).startPlay(QQMovieFilter.access$500(this.this$0), QQMovieFilter.access$400(this.this$0));
          QQMovieFilter.access$602(this.this$0, null);
          QQMovieFilter.access$000(this.this$0).setSpeedType(0);
          if (QQMovieFilter.access$700(this.this$0) != null) {
            QQMovieFilter.access$700(this.this$0).adjustVideo(VideoUtil.getHeightWidthRatioOfVideo(QQMovieFilter.access$100(this.this$0)), QQMovieFilter.access$200(this.this$0), QQMovieFilter.access$300(this.this$0));
          }
        }
        else
        {
          QQMovieFilter.access$800(this.this$0);
          QQMovieFilter.access$000(this.this$0).setFilePath("", "");
        }
      }
    }
    else
    {
      QQMovieFilter.access$800(this.this$0);
      if (QQMovieFilter.access$000(this.this$0) != null) {
        QQMovieFilter.access$000(this.this$0).setFilePath("", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMovieFilter.1
 * JD-Core Version:    0.7.0.1
 */