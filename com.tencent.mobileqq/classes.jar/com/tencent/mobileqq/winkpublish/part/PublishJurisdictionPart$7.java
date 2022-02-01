package com.tencent.mobileqq.winkpublish.part;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.winkpublish.view.FSSwitch;

class PublishJurisdictionPart$7
  implements Observer<Boolean>
{
  PublishJurisdictionPart$7(PublishJurisdictionPart paramPublishJurisdictionPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (PublishJurisdictionPart.g(this.a) != null)
    {
      PublishJurisdictionPart.g(this.a).setChecked(paramBoolean.booleanValue());
      PublishJurisdictionPart.g(this.a).setCityRecommendationCheck(paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishJurisdictionPart.7
 * JD-Core Version:    0.7.0.1
 */