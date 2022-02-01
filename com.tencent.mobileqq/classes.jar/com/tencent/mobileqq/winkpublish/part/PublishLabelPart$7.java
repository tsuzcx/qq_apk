package com.tencent.mobileqq.winkpublish.part;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

class PublishLabelPart$7
  implements Observer<String>
{
  PublishLabelPart$7(PublishLabelPart paramPublishLabelPart) {}
  
  public void a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      PublishLabelPart.e(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.7
 * JD-Core Version:    0.7.0.1
 */