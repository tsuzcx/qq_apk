package com.tencent.mobileqq.winkpublish.part;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;

class PublishLabelPart$5
  implements Observer<UIStateData<List<FeedCloudMeta.StTagInfo>>>
{
  PublishLabelPart$5(PublishLabelPart paramPublishLabelPart) {}
  
  public void a(@Nullable UIStateData<List<FeedCloudMeta.StTagInfo>> paramUIStateData)
  {
    String str = paramUIStateData.f();
    if ((PublishLabelPart.a(this.a).c() != null) && (!TextUtils.isEmpty(str)))
    {
      Object localObject;
      if (!PublishLabelPart.a(this.a).c().equals(str))
      {
        if (QLog.isColorLevel())
        {
          paramUIStateData = PublishLabelPart.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onChanged... req:");
          ((StringBuilder)localObject).append(PublishLabelPart.a(this.a).c());
          ((StringBuilder)localObject).append(" rsp:");
          ((StringBuilder)localObject).append(str);
          QLog.d(paramUIStateData, 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = PublishLabelPart.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onChanged... req:");
        localStringBuilder.append(PublishLabelPart.a(this.a).c());
        localStringBuilder.append(" rsp:");
        localStringBuilder.append(str);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    int i = paramUIStateData.c();
    if (i != 0) {
      if ((i != 2) && (i != 3))
      {
        if (i == 4) {}
      }
      else
      {
        PublishLabelPart.a(this.a, paramUIStateData);
        return;
      }
    }
    PublishLabelPart.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.5
 * JD-Core Version:    0.7.0.1
 */