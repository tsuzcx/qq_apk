package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.util.SoDependencyUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class SoLoaderServiceImpl$2$1
  implements OnLoadListener
{
  SoLoaderServiceImpl$2$1(SoLoaderServiceImpl.2 param2) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if ((paramInt == 12) && (this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mLoadItems != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mLoadItems.isEmpty())) {
      try
      {
        Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mLoadItems.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = ((LoadParam.LoadItem)localIterator.next()).name;
          Object localObject2 = paramLoadExtResult.getSoLoadPath((String)localObject1);
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("soName: ");
            localStringBuilder.append((String)localObject1);
            QLog.i("SoLoadWidget.SoloadServiceImpl", 2, localStringBuilder.toString());
          }
          localObject1 = SoDependencyUtil.a(new File((String)localObject2));
          if (!((List)localObject1).isEmpty())
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("<<<soDep: ");
                localStringBuilder.append((String)localObject2);
                QLog.i("SoLoadWidget.SoloadServiceImpl", 2, localStringBuilder.toString());
              }
              localObject2 = SoLoaderServiceImpl.access$100(this.a.this$0, (String)localObject2, null);
              SoLoaderServiceImpl.access$200(this.a.this$0, (LoadParam)localObject2, this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener);
            }
          }
          else if (this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener != null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener.onLoadResult(paramInt, paramLoadExtResult);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener.onLoadResult(paramInt, paramLoadExtResult);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SoLoadWidget.SoloadServiceImpl", 1, localThrowable.toString());
        if (this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener == null) {
          return;
        }
      }
    } else if (this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener.onLoadResult(paramInt, paramLoadExtResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.2.1
 * JD-Core Version:    0.7.0.1
 */