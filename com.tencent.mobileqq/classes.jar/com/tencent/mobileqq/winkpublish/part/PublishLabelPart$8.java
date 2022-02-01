package com.tencent.mobileqq.winkpublish.part;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;

class PublishLabelPart$8
  implements Observer<ArrayList<LabelInfo>>
{
  PublishLabelPart$8(PublishLabelPart paramPublishLabelPart) {}
  
  public void a(@Nullable ArrayList<LabelInfo> paramArrayList)
  {
    QLog.d(PublishLabelPart.a, 1, new Object[] { "onChanged... labelInfos:", paramArrayList.toString() });
    if (PublishLabelPart.j(this.a) != null) {
      if (paramArrayList.size() > 0)
      {
        if (PublishLabelPart.j(this.a).getVisibility() != 0) {
          PublishLabelPart.j(this.a).setVisibility(0);
        }
      }
      else if (PublishLabelPart.j(this.a).getVisibility() != 8) {
        PublishLabelPart.j(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.8
 * JD-Core Version:    0.7.0.1
 */