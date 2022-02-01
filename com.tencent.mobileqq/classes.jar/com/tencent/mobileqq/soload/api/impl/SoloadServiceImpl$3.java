package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class SoloadServiceImpl$3
  implements OnLoadListener
{
  SoloadServiceImpl$3(SoloadServiceImpl paramSoloadServiceImpl, LoadParam paramLoadParam) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized ()
    {
      Object localObject2 = (List)SoloadServiceImpl.access$300().get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam);
      SoloadServiceImpl.access$300().remove(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoloadServiceImpl", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam + ",ls=" + localObject2);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoloadServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */