package com.tencent.tkd.topicsdk.imagecompress;

import android.content.Context;
import android.os.Handler;
import java.io.File;
import java.io.IOException;

class Luban$1
  implements Runnable
{
  Luban$1(Luban paramLuban, Context paramContext, InputStreamProvider paramInputStreamProvider) {}
  
  public void run()
  {
    try
    {
      Luban.a(this.this$0).sendMessage(Luban.a(this.this$0).obtainMessage(1));
      File localFile = Luban.a(this.this$0, this.a, this.b);
      Luban.a(this.this$0).sendMessage(Luban.a(this.this$0).obtainMessage(0, localFile));
      return;
    }
    catch (IOException localIOException)
    {
      Luban.a(this.this$0).sendMessage(Luban.a(this.this$0).obtainMessage(2, localIOException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Luban.1
 * JD-Core Version:    0.7.0.1
 */