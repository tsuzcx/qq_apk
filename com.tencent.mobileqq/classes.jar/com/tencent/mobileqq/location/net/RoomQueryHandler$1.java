package com.tencent.mobileqq.location.net;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class RoomQueryHandler$1
  implements Runnable
{
  RoomQueryHandler$1(RoomQueryHandler paramRoomQueryHandler, int paramInt, String paramString) {}
  
  public void run()
  {
    if (RoomQueryHandler.a(this.this$0).get())
    {
      QLog.d("RoomQueryHandler", 1, new Object[] { "run: invoked. stop old loop query ", " uinType: ", Integer.valueOf(this.a), " sessionUin: ", this.b });
      return;
    }
    RoomQueryHandler.a(this.this$0, this.a, this.b);
    RoomQueryHandler.b(this.this$0).postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.RoomQueryHandler.1
 * JD-Core Version:    0.7.0.1
 */