package com.tencent.mobileqq.vas;

import android.os.Handler;
import bdrv;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class ColorNickManager$2
  implements Runnable
{
  public ColorNickManager$2(bdrv parambdrv, int paramInt) {}
  
  public void run()
  {
    Object localObject = new File(bdrv.a(String.valueOf(this.a)));
    if (((File)localObject).exists())
    {
      localObject = bdrv.a(this.this$0, (File)localObject, this.a);
      if (localObject != null)
      {
        this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.a), localObject);
        if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(258);
        }
      }
      return;
    }
    bdrv.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.2
 * JD-Core Version:    0.7.0.1
 */