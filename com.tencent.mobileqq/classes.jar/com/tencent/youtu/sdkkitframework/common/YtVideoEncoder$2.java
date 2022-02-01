package com.tencent.youtu.sdkkitframework.common;

import android.media.AudioRecord;

class YtVideoEncoder$2
  implements Runnable
{
  YtVideoEncoder$2(YtVideoEncoder paramYtVideoEncoder) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    YtVideoEncoder.access$102((YtVideoEncoder)localObject, AudioRecord.getMinBufferSize(YtVideoEncoder.access$200((YtVideoEncoder)localObject), 16, 2));
    int i = Math.min(16384, YtVideoEncoder.access$100(this.this$0) * 2);
    localObject = this.this$0;
    YtVideoEncoder.access$302((YtVideoEncoder)localObject, new AudioRecord(1, YtVideoEncoder.access$200((YtVideoEncoder)localObject), 16, 2, i));
    localObject = YtVideoEncoder.access$400();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Audio recorder init :");
    localStringBuilder.append(YtVideoEncoder.access$300(this.this$0).getState());
    YtLogger.i((String)localObject, localStringBuilder.toString());
    localObject = new byte[2048];
    YtVideoEncoder.access$300(this.this$0).startRecording();
    while (!YtVideoEncoder.access$500(this.this$0)) {
      if (YtVideoEncoder.access$300(this.this$0).read((byte[])localObject, 0, localObject.length) > 0) {
        this.this$0.encodeAudioData((byte[])localObject);
      }
    }
    YtLogger.d(YtVideoEncoder.access$400(), "Audio push last buffer");
    YtVideoEncoder.access$300(this.this$0).stop();
    YtVideoEncoder.access$300(this.this$0).release();
    YtVideoEncoder.access$302(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder.2
 * JD-Core Version:    0.7.0.1
 */