package com.tencent.mobileqq.winkpublish.part;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkpublish.model.DynamicArrayList;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PublishMediaPart$2
  implements Observer<HashMap<String, LocalMediaInfo>>
{
  PublishMediaPart$2(PublishMediaPart paramPublishMediaPart) {}
  
  public void a(@Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PublishMediaPart.a, 1, new Object[] { "onChanged... localMediaInfoHashMap:", paramHashMap });
    }
    if (paramHashMap != null) {
      try
      {
        if (paramHashMap.size() > 0)
        {
          DynamicArrayList localDynamicArrayList = PublishMediaPart.h(this.a).g;
          if (localDynamicArrayList == null) {
            return;
          }
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramHashMap.get(localDynamicArrayList.get(0));
          if (localLocalMediaInfo != null)
          {
            if (AlbumUtil.b(localLocalMediaInfo))
            {
              PublishMediaPart.a(this.a, localLocalMediaInfo);
              return;
            }
            PublishMediaPart.a(this.a, paramHashMap, localDynamicArrayList, localLocalMediaInfo);
            return;
          }
        }
      }
      catch (Exception paramHashMap)
      {
        QLog.e(PublishMediaPart.a, 1, paramHashMap, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishMediaPart.2
 * JD-Core Version:    0.7.0.1
 */