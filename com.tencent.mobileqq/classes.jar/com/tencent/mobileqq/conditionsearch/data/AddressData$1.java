package com.tencent.mobileqq.conditionsearch.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class AddressData$1
  implements Runnable
{
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("条件搜素配置文件存在不同code对应相同name的问题！！！ name = ");
      localStringBuilder.append(this.a);
      QQToast.makeText(localBaseApplicationImpl, localStringBuilder.toString(), 1).show();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.AddressData.1
 * JD-Core Version:    0.7.0.1
 */