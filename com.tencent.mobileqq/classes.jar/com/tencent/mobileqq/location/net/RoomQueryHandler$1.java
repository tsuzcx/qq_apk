package com.tencent.mobileqq.location.net;

import android.os.Handler;
import avxi;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoomQueryHandler$1
  implements Runnable
{
  public RoomQueryHandler$1(avxi paramavxi, int paramInt, String paramString) {}
  
  public void run()
  {
    if (avxi.a(this.this$0).get())
    {
      QLog.d("RoomQueryHandler", 1, new Object[] { "run: invoked. stop old loop query ", " uinType: ", Integer.valueOf(this.jdField_a_of_type_Int), " sessionUin: ", this.jdField_a_of_type_JavaLangString });
      return;
    }
    avxi.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    avxi.a(this.this$0).postDelayed(this, avxi.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.RoomQueryHandler.1
 * JD-Core Version:    0.7.0.1
 */