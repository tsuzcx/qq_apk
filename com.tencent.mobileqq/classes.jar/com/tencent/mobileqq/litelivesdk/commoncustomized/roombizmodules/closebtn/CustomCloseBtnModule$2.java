package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;

class CustomCloseBtnModule$2
  implements Observer<ContentLoadedEvent>
{
  CustomCloseBtnModule$2(CustomCloseBtnModule paramCustomCloseBtnModule) {}
  
  public void a(@Nullable ContentLoadedEvent paramContentLoadedEvent)
  {
    if (paramContentLoadedEvent.mContentLoaded)
    {
      CustomCloseBtnModule.a(this.a).setVisibility(4);
      return;
    }
    CustomCloseBtnModule.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule.2
 * JD-Core Version:    0.7.0.1
 */