package com.tencent.qav.channel;

import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class VideoChannelImpl
  extends VideoChannelBase
{
  private static VideoChannelImpl jdField_a_of_type_ComTencentQavChannelVideoChannelImpl;
  private int jdField_a_of_type_Int;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public static VideoChannelImpl a()
  {
    if (jdField_a_of_type_ComTencentQavChannelVideoChannelImpl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQavChannelVideoChannelImpl == null) {
        jdField_a_of_type_ComTencentQavChannelVideoChannelImpl = new VideoChannelImpl();
      }
      return jdField_a_of_type_ComTencentQavChannelVideoChannelImpl;
    }
    finally {}
  }
  
  protected long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    }
    return l;
  }
  
  protected void a()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 5);
    localNewIntent.putExtra("app_id", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void a(long paramLong, byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 7);
    localNewIntent.putExtra("uin", paramLong);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    int i = 0;
    if ((paramAppRuntime instanceof AppInterface)) {
      i = ((AppInterface)paramAppRuntime).getAppid();
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = i;
  }
  
  protected void f(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 6);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void g(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 1);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void h(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 2);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void i(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 3);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
  
  protected void j(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), VideoChannelServlet.class);
    localNewIntent.putExtra("req_type", 4);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.jdField_a_of_type_MqqAppAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelImpl
 * JD-Core Version:    0.7.0.1
 */