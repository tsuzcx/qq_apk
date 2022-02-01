package com.tencent.xweb.xwalk;

import java.io.File;

class d$49
  implements Runnable
{
  d$49(d paramd, String paramString) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    File localFile = new File(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    u.a(new File[] { localFile }, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.49
 * JD-Core Version:    0.7.0.1
 */