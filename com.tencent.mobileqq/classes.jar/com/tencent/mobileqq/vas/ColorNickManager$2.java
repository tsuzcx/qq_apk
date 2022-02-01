package com.tencent.mobileqq.vas;

import android.os.Handler;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

class ColorNickManager$2
  implements Runnable
{
  ColorNickManager$2(ColorNickManager paramColorNickManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = new File(ColorNickManager.a(String.valueOf(this.a)));
    if (((File)localObject).exists())
    {
      localObject = ColorNickManager.a(this.this$0, (File)localObject, this.a);
      if (localObject != null)
      {
        this.this$0.d.put(Integer.valueOf(this.a), localObject);
        if (this.this$0.c != null) {
          this.this$0.c.sendEmptyMessage(258);
        }
      }
    }
    else
    {
      ColorNickManager.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.2
 * JD-Core Version:    0.7.0.1
 */