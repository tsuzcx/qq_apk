package com.tencent.mobileqq.winkpublish.part;

import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

class PublishTitlePart$1
  implements Observer<Boolean>
{
  PublishTitlePart$1(PublishTitlePart paramPublishTitlePart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (PublishTitlePart.a(this.a) != null) {
      PublishTitlePart.a(this.a).setEnabled(paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishTitlePart.1
 * JD-Core Version:    0.7.0.1
 */