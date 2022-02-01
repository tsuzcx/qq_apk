package com.tencent.mobileqq.hotpic;

import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;
import avmv;
import avnj;
import avnw;

public class HotVideoBlurTaskManager$1
  implements Runnable
{
  public HotVideoBlurTaskManager$1(avnj paramavnj) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = (HotVideoData)this.this$0.jdField_a_of_type_AndroidSupportV4UtilArrayMap.keyAt(0);
    avmv localavmv = (avmv)this.this$0.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localHotVideoData);
    if (localavmv.a(localHotVideoData))
    {
      Drawable localDrawable = avnw.a(this.this$0.jdField_a_of_type_AndroidContentContext, localHotVideoData);
      if ((localDrawable != null) && (localavmv.a(localHotVideoData))) {
        localavmv.b(localDrawable);
      }
      this.this$0.a(localHotVideoData);
    }
    for (;;)
    {
      this.this$0.a();
      return;
      this.this$0.a(localHotVideoData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager.1
 * JD-Core Version:    0.7.0.1
 */