package com.tencent.rtmp;

import com.tencent.liteav.basic.util.h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class TXLivePusherImpl$15
  implements Runnable
{
  TXLivePusherImpl$15(TXLivePusherImpl paramTXLivePusherImpl, String paramString) {}
  
  public void run()
  {
    Object localObject = new File(this.a).getParentFile();
    String str = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(String.format("TXUGCCover_%s.jpg", new Object[] { str }));
    localObject = localStringBuilder.toString();
    h.a(this.a, (String)localObject);
    TXLivePusherImpl.a(this.b, this.a, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.15
 * JD-Core Version:    0.7.0.1
 */