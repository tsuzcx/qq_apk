package com.tencent.mobileqq.winkpublish.part;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PublishLabelPart$10
  implements Observer<HashMap<String, LocalMediaInfo>>
{
  PublishLabelPart$10(PublishLabelPart paramPublishLabelPart) {}
  
  public void a(@Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PublishLabelPart.a, 1, new Object[] { "onChanged... localMediaInfoHashMap:", paramHashMap });
    }
    PublishLabelPart.a(this.a).a(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.10
 * JD-Core Version:    0.7.0.1
 */