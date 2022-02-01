package com.tencent.mobileqq.winkpublish.part;

import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.winkpublish.view.FSSwitch;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishJurisdictionViewModel;

class PublishJurisdictionPart$6
  implements Observer<Boolean>
{
  PublishJurisdictionPart$6(PublishJurisdictionPart paramPublishJurisdictionPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((PublishJurisdictionPart.e(this.a) != null) && (PublishJurisdictionPart.f(this.a) != null))
    {
      if (paramBoolean.booleanValue())
      {
        PublishJurisdictionPart.e(this.a).setVisibility(0);
        PublishJurisdictionPart.f(this.a).setVisibility(8);
        PublishJurisdictionPart.g(this.a).setCityRecommendationCheck(true);
        ((PublishSharePart)this.a.E().a(PublishSharePart.class.getName())).c(true);
        return;
      }
      PublishJurisdictionPart.e(this.a).setVisibility(8);
      PublishJurisdictionPart.f(this.a).setVisibility(0);
      PublishJurisdictionPart.g(this.a).setSwitchChecked(false);
      PublishJurisdictionPart.g(this.a).setCityRecommendationCheck(false);
      PublishJurisdictionPart.a(this.a).e();
      ((PublishSharePart)this.a.E().a(PublishSharePart.class.getName())).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishJurisdictionPart.6
 * JD-Core Version:    0.7.0.1
 */