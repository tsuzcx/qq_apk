package com.tencent.mobileqq.winkpublish.part;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkpublish.adapter.PublishPoiAdapter;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishPoiViewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PublishLbsPart$7
  implements Observer<HashMap<String, LocalMediaInfo>>
{
  PublishLbsPart$7(PublishLbsPart paramPublishLbsPart) {}
  
  public void a(@Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    QLog.d(PublishLbsPart.a, 1, "onChanged... localMediaInfoHashMap");
    if ((paramHashMap != null) && (paramHashMap.size() > 0) && (PublishLbsPart.j(this.a)))
    {
      PublishLbsPart.a(this.a, true);
      PublishLbsPart.b(this.a).a(paramHashMap, true);
      return;
    }
    PublishLbsPart.a(this.a).a();
    PublishLbsPart.c(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.7
 * JD-Core Version:    0.7.0.1
 */