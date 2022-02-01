package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager.OnGetSoInfoListener;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.soload.util.SoReportUtil;

class GetSoLoadInfoTaskAsync$1
  implements SoConfigManager.OnGetSoInfoListener
{
  GetSoLoadInfoTaskAsync$1(GetSoLoadInfoTaskAsync paramGetSoLoadInfoTaskAsync) {}
  
  public void a(int paramInt, SoInfo paramSoInfo)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    LoadParam localLoadParam = this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
    long l = this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq;
    StringBuilder localStringBuilder = new StringBuilder().append("is64bit=");
    if (SoDataUtil.a()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      SoReportUtil.a(localLoadParam, l, null, "load.item.getconfig.end", paramInt + "&v=" + AbsGetSoLoadInfoTask.a() + "&f=" + this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType, SoInfo.getReportCode(paramSoInfo), null);
      GetSoLoadInfoTaskAsync.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem, paramSoInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync.1
 * JD-Core Version:    0.7.0.1
 */