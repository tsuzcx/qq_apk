package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class SoLoaderServiceImpl$3
  implements OnLoadListener
{
  SoLoaderServiceImpl$3(SoLoaderServiceImpl paramSoLoaderServiceImpl, LoadParam paramLoadParam) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized ()
    {
      Object localObject2 = (List)SoLoaderServiceImpl.access$400().get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam);
      SoLoaderServiceImpl.access$400().remove(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("load resCode=");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append(", loadExtResult=");
        ((StringBuilder)???).append(paramLoadExtResult);
        ((StringBuilder)???).append(",loadParam=");
        ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam);
        ((StringBuilder)???).append(",ls=");
        ((StringBuilder)???).append(localObject2);
        QLog.i("SoLoadWidget.SoloadServiceImpl", 2, ((StringBuilder)???).toString());
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (OnLoadListener)((Iterator)???).next();
          if (localObject2 != null) {
            ((OnLoadListener)localObject2).onLoadResult(paramInt, paramLoadExtResult);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramLoadExtResult;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */