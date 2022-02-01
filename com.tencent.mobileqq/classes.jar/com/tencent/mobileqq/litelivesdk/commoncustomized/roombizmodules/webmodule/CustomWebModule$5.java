package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;

class CustomWebModule$5
  implements Observer<ContentLoadedEvent>
{
  CustomWebModule$5(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable ContentLoadedEvent paramContentLoadedEvent)
  {
    if ((paramContentLoadedEvent != null) && (paramContentLoadedEvent.mContentLoaded))
    {
      CustomWebModule.c(this.a, paramContentLoadedEvent.mContentLoaded);
      if (CustomWebModule.a(this.a)) {
        CustomWebModule.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.5
 * JD-Core Version:    0.7.0.1
 */