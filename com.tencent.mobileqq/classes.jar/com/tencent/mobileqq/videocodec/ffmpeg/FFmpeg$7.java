package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;

class FFmpeg$7
  extends BroadcastReceiver
{
  FFmpeg$7(FFmpeg paramFFmpeg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      if ((this.this$0.ffmpegExecuteAsyncTask != null) && (!this.this$0.ffmpegExecuteAsyncTask.isProcessCompleted()))
      {
        this.this$0.mIsFFmpegingCloseScreen = true;
        SLog.d("FFmpegCmd", "屏幕灭屏了，FFmpeg还在执行当中");
      }
    }
    else if ((paramContext.equals("android.intent.action.SCREEN_ON")) && (this.this$0.mIsFFmpegingCloseScreen))
    {
      paramContext = this.this$0;
      paramContext.mIsFFmpegingCloseScreen = false;
      if ((paramContext.mCurrentCommandUnit != null) && (this.this$0.mLastTaskResult != -9999) && (this.this$0.mCurrentCommandUnit.callback != null))
      {
        if (this.this$0.mLastTaskResult == 1)
        {
          paramContext = HardCodeUtil.a(2131704599);
          this.this$0.mCurrentCommandUnit.callback.onSuccess(paramContext);
          this.this$0.mCurrentCommandUnit.callback.onFinish(true);
          SLog.d("FFmpegCmd", paramContext);
        }
        else
        {
          paramContext = HardCodeUtil.a(2131704598);
          this.this$0.mCurrentCommandUnit.callback.onFailure(paramContext);
          this.this$0.mCurrentCommandUnit.callback.onFinish(false);
          SLog.d("FFmpegCmd", paramContext);
        }
        this.this$0.mLastTaskResult = -9999;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg.7
 * JD-Core Version:    0.7.0.1
 */