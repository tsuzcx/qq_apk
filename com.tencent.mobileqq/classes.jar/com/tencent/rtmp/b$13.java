package com.tencent.rtmp;

import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

class b$13
  implements Runnable
{
  b$13(b paramb, long paramLong) {}
  
  public void run()
  {
    if (b.g(this.b) != null) {
      b.g(this.b).onRecordProgress(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.13
 * JD-Core Version:    0.7.0.1
 */