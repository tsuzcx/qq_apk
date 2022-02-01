package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager.OnGetSoInfoListener;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoLoadUtils;

class GetSoLoadInfoTaskAsync$2
  implements SoConfigManager.OnGetSoInfoListener
{
  GetSoLoadInfoTaskAsync$2(GetSoLoadInfoTaskAsync paramGetSoLoadInfoTaskAsync, String paramString, SoCrashInfo paramSoCrashInfo, LoadParam.LoadItem paramLoadItem) {}
  
  public void a(int paramInt, SoInfo paramSoInfo)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync.a(paramSoInfo))
    {
      GetSoLoadInfoTaskAsync.a(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync, 2);
      return;
    }
    if ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync.a.ver, this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoCrashInfo.b()))
    {
      paramSoInfo = this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync;
      paramSoInfo.c = "runcrash";
      GetSoLoadInfoTaskAsync.a(paramSoInfo, 8);
      return;
    }
    SoLoadUtils.c(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
    GetSoLoadInfoTaskAsync.a(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync.2
 * JD-Core Version:    0.7.0.1
 */