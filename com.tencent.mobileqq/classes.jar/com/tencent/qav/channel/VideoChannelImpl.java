package com.tencent.qav.channel;

import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class VideoChannelImpl
  extends VideoChannelBase
{
  private static VideoChannelImpl a;
  private AppRuntime b;
  private int c;
  
  public static VideoChannelImpl c()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VideoChannelImpl();
        }
      }
      finally {}
    }
    return a;
  }
  
  protected long a()
  {
    AppRuntime localAppRuntime = this.b;
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  protected void a(long paramLong, byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 7);
    localNewIntent.putExtra("uin", paramLong);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.b.startServlet(localNewIntent);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    int i;
    if ((paramAppRuntime instanceof AppInterface)) {
      i = ((AppInterface)paramAppRuntime).getAppid();
    } else {
      i = 0;
    }
    this.b = paramAppRuntime;
    this.c = i;
  }
  
  protected void b()
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 5);
    localNewIntent.putExtra("app_id", this.c);
    this.b.startServlet(localNewIntent);
  }
  
  protected void f(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 6);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.b.startServlet(localNewIntent);
  }
  
  protected void g(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 1);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.b.startServlet(localNewIntent);
  }
  
  protected void h(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 2);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.b.startServlet(localNewIntent);
  }
  
  protected void i(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 3);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.b.startServlet(localNewIntent);
  }
  
  protected void j(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.b.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 4);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.b.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelImpl
 * JD-Core Version:    0.7.0.1
 */