package com.tencent.mobileqq.winkpublish.part;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.winkpublish.model.DynamicArrayList;
import com.tencent.mobileqq.winkpublish.view.RoundCornerImageView;
import com.tencent.qphone.base.util.QLog;

class PublishMediaPart$1
  implements Observer<DynamicArrayList<String>>
{
  PublishMediaPart$1(PublishMediaPart paramPublishMediaPart) {}
  
  public void a(@Nullable DynamicArrayList<String> paramDynamicArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PublishMediaPart.a, 1, new Object[] { "onChanged... list:", paramDynamicArrayList });
    }
    if (paramDynamicArrayList != null) {}
    try
    {
      if (paramDynamicArrayList.size() == 0)
      {
        PublishMediaPart.a(this.a).setVisibility(8);
        PublishMediaPart.b(this.a).setVisibility(8);
        PublishMediaPart.c(this.a).setVisibility(8);
        PublishMediaPart.d(this.a).setVisibility(8);
        PublishMediaPart.e(this.a).setVisibility(8);
        PublishMediaPart.f(this.a).setVisibility(0);
        PublishMediaPart.g(this.a).setVisibility(0);
        return;
      }
    }
    catch (Exception paramDynamicArrayList)
    {
      QLog.e(PublishMediaPart.a, 1, paramDynamicArrayList, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishMediaPart.1
 * JD-Core Version:    0.7.0.1
 */