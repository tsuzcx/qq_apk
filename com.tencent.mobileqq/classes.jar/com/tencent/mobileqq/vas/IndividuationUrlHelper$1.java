package com.tencent.mobileqq.vas;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

final class IndividuationUrlHelper$1
  implements IndividuationUrlHelper.UrlCallback
{
  private void a(Resources paramResources, IndividuationUrlHelper.IconExtendData paramIconExtendData, String paramString)
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).setVipCardDrawable(paramResources, paramIconExtendData.a, paramString);
  }
  
  public void update()
  {
    int i = 0;
    while (i < IndividuationUrlHelper.a().size())
    {
      Object localObject = (SoftReference)IndividuationUrlHelper.a().get(i);
      if (localObject != null)
      {
        localObject = (IndividuationUrlHelper.IconExtendData)((SoftReference)localObject).get();
        if (localObject != null)
        {
          String str = (String)IndividuationUrlHelper.a.get(((IndividuationUrlHelper.IconExtendData)localObject).b);
          if ((((IndividuationUrlHelper.IconExtendData)localObject).a != null) && (!TextUtils.isEmpty(str))) {
            ((IndividuationUrlHelper.IconExtendData)localObject).a.post(new IndividuationUrlHelper.1.1(this, (IndividuationUrlHelper.IconExtendData)localObject, str));
          }
        }
      }
      i += 1;
    }
    IndividuationUrlHelper.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationUrlHelper.1
 * JD-Core Version:    0.7.0.1
 */