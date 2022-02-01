package com.tencent.youtu.sdkkitframework.common;

import android.media.AudioRecord;

class YtVideoEncoder$2
  implements Runnable
{
  YtVideoEncoder$2(YtVideoEncoder paramYtVideoEncoder) {}
  
  public void run()
  {
    YtVideoEncoder.access$102(this.this$0, AudioRecord.getMinBufferSize(YtVideoEncoder.access$200(this.this$0), 16, 2));
    int i = Math.min(16384, YtVideoEncoder.access$100(this.this$0) * 2);
    YtVideoEncoder.access$302(this.this$0, new AudioRecord(1, YtVideoEncoder.access$200(this.this$0), 16, 2, i));
    YtLogger.i(YtVideoEncoder.access$400(), "Audio recorder init :" + YtVideoEncoder.access$300(this.this$0).getState());
    byte[] arrayOfByte = new byte[2048];
    YtVideoEncoder.access$300(this.this$0).startRecording();
    while (!YtVideoEncoder.access$500(this.this$0)) {
      if (YtVideoEncoder.access$300(this.this$0).read(arrayOfByte, 0, arrayOfByte.length) > 0) {
        this.this$0.encodeAudioData(arrayOfByte);
      }
    }
    YtLogger.d(YtVideoEncoder.access$400(), "Audio push last buffer");
    YtVideoEncoder.access$300(this.this$0).stop();
    YtVideoEncoder.access$300(this.this$0).release();
    YtVideoEncoder.access$302(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder.2
 * JD-Core Version:    0.7.0.1
 */