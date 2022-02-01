package com.tencent.rtmp;

import com.tencent.liteav.basic.util.f;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class b$8
  implements Runnable
{
  b$8(b paramb, String paramString) {}
  
  public void run()
  {
    Object localObject = new File(this.a).getParentFile();
    String str = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(String.format("TXUGCCover_%s.jpg", new Object[] { str }));
    localObject = localStringBuilder.toString();
    f.a(this.a, (String)localObject);
    b.a(this.b, this.a, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.8
 * JD-Core Version:    0.7.0.1
 */