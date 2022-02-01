package com.tencent.mobileqq.winkpublish.part;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.mobileqq.winkpublish.view.FSCheckBox;

class PublishSharePart$2
  implements Observer<Boolean>
{
  PublishSharePart$2(PublishSharePart paramPublishSharePart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    PublishSharePart.b(this.a).setChecked(paramBoolean.booleanValue());
    LocalConfig.a(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishSharePart.2
 * JD-Core Version:    0.7.0.1
 */