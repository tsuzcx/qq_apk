package com.tencent.mobileqq.qqexpand.audio.impl;

import com.tencent.mobileqq.qqexpand.audio.IMethodCallback;

class ExpandAudioPlayerImpl$3
  implements Runnable
{
  ExpandAudioPlayerImpl$3(ExpandAudioPlayerImpl paramExpandAudioPlayerImpl, String paramString, IMethodCallback paramIMethodCallback) {}
  
  public void run()
  {
    Object localObject = ExpandAudioPlayerImpl.access$200(this.this$0, this.a);
    boolean bool = true;
    if (localObject == null)
    {
      ExpandAudioPlayerImpl.access$100(this.this$0).onAudioPlayFailed(this.a, 1, "音频文件不存在");
      this.b.setResult(true);
      return;
    }
    int i = ExpandAudioPlayerImpl.access$300(this.this$0, (String)localObject);
    localObject = this.b;
    if (i != 1) {
      bool = false;
    }
    ((IMethodCallback)localObject).setResult(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.ExpandAudioPlayerImpl.3
 * JD-Core Version:    0.7.0.1
 */