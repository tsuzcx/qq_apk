package com.tencent.mobileqq.kandian.biz.gifvideo.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.AbsListView;

public class VideoPlayControlUtils$VideoCheckHandler
  extends Handler
{
  public VideoPlayControlUtils$VideoCheckHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    VideoPlayControlUtils.b((AbsListView)paramMessage[0], (AbsBaseArticleInfo)paramMessage[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoPlayControlUtils.VideoCheckHandler
 * JD-Core Version:    0.7.0.1
 */