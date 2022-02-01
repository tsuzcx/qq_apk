package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

final class IndividuationUrlHelper$1
  implements IndividuationUrlHelper.UrlCallback
{
  public void a()
  {
    int i = 0;
    if (i < IndividuationUrlHelper.a().size())
    {
      Object localObject = (SoftReference)IndividuationUrlHelper.a().get(i);
      if (localObject != null)
      {
        localObject = (IndividuationUrlHelper.IconExtendData)((SoftReference)localObject).get();
        if (localObject != null) {
          break label50;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label50:
        String str = (String)IndividuationUrlHelper.b().get(((IndividuationUrlHelper.IconExtendData)localObject).jdField_a_of_type_JavaLangString);
        if ((((IndividuationUrlHelper.IconExtendData)localObject).jdField_a_of_type_AndroidWidgetImageView != null) && (!TextUtils.isEmpty(str))) {
          ((IndividuationUrlHelper.IconExtendData)localObject).jdField_a_of_type_AndroidWidgetImageView.post(new IndividuationUrlHelper.1.1(this, (IndividuationUrlHelper.IconExtendData)localObject, str));
        }
      }
    }
    IndividuationUrlHelper.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationUrlHelper.1
 * JD-Core Version:    0.7.0.1
 */