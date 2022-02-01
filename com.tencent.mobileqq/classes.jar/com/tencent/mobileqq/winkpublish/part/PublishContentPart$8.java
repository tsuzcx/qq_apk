package com.tencent.mobileqq.winkpublish.part;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.winkpublish.view.edittext.ExtendEditText;
import com.tencent.qphone.base.util.QLog;

class PublishContentPart$8
  implements Observer<PublishContentPart.ContentSet>
{
  PublishContentPart$8(PublishContentPart paramPublishContentPart) {}
  
  public void a(@Nullable PublishContentPart.ContentSet paramContentSet)
  {
    if (!TextUtils.isEmpty(paramContentSet.a))
    {
      QLog.d(PublishContentPart.a, 4, new Object[] { "onChanged... text:", paramContentSet.a });
      this.a.n = paramContentSet.a;
      paramContentSet.a = this.a.a(paramContentSet.a);
      this.a.p = paramContentSet.a.length();
      this.a.h.setText(paramContentSet.a);
      ExtendEditText localExtendEditText = this.a.h;
      int i;
      if (paramContentSet.b < paramContentSet.a.length()) {
        i = paramContentSet.b;
      } else {
        i = paramContentSet.a.length();
      }
      localExtendEditText.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishContentPart.8
 * JD-Core Version:    0.7.0.1
 */