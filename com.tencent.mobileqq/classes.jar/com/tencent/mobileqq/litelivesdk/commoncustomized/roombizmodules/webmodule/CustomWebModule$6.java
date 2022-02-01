package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;

class CustomWebModule$6
  implements Observer<ContentLoadedEvent>
{
  CustomWebModule$6(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable ContentLoadedEvent paramContentLoadedEvent)
  {
    if ((paramContentLoadedEvent != null) && (paramContentLoadedEvent.mContentLoaded))
    {
      CustomWebModule.c(this.a, paramContentLoadedEvent.mContentLoaded);
      if (CustomWebModule.a(this.a)) {
        this.a.a(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.6
 * JD-Core Version:    0.7.0.1
 */