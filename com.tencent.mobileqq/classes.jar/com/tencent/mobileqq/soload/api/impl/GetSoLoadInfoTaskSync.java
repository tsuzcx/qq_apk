package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.mobileqq.soload.util.SoReportUtil;
import com.tencent.qphone.base.util.QLog;

public class GetSoLoadInfoTaskSync
  extends AbsGetSoLoadInfoTask
{
  public GetSoLoadInfoTaskSync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
  }
  
  private SoLoadInfo b(int paramInt)
  {
    return a(paramInt);
  }
  
  @NonNull
  public SoLoadInfo a()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskSync", 2, "not main process get loadInfo sync by IPC");
      }
      return SoLoadUtils.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem);
    }
    Object localObject1 = SoConfigManager.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, null, true);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
    long l = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq;
    StringBuilder localStringBuilder = new StringBuilder().append("is64bit=");
    if (SoDataUtil.a()) {}
    for (int i = 1;; i = 0)
    {
      SoReportUtil.a((LoadParam)localObject2, l, null, "load.item.getconfig.end", i + "&v=" + a() + "&f=" + this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType, SoInfo.getReportCode((SoInfo)localObject1), null);
      if (a((SoInfo)localObject1)) {
        break;
      }
      return b(2);
    }
    localObject1 = SoLoadUtils.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.ver);
    boolean bool2;
    boolean bool3;
    if (localObject1 != null)
    {
      if (((SoCrashInfo)localObject1).c())
      {
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfig] InLoadCrashProtectMode, crashInfo=" + localObject1);
        }
        this.c = "loadcrash";
        return b(8);
      }
      if (((SoCrashInfo)localObject1).a())
      {
        if (((SoCrashInfo)localObject1).b())
        {
          if (QLog.isColorLevel()) {
            QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfig] InRunCrashProtectMode, crashInfo=" + localObject1);
          }
          this.c = "runcrash";
          return b(8);
        }
        SoLoadUtils.c(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
      }
    }
    else
    {
      localObject1 = SoLoadUtils.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo);
      bool2 = a((SoLocalInfo)localObject1);
      bool3 = a((SoLocalInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.lops.flag & 0x4) == 0) {
        break label442;
      }
    }
    label442:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfigSync] isSoExist=" + bool2 + ",isRFReady=" + bool3 + ",isWeak:" + bool1);
      }
      if (bool2) {
        break label448;
      }
      return b(3);
      if (!((SoCrashInfo)localObject1).e()) {
        break;
      }
      SoConfigManager.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, (SoCrashInfo)localObject1, null);
      break;
    }
    label448:
    if ((!bool3) && (!bool1)) {
      return b(11);
    }
    this.jdField_b_of_type_Boolean = false;
    localObject2 = ((SoLocalInfo)localObject1).c;
    if (a((String)localObject2, ((SoLocalInfo)localObject1).a, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo, 1))
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (bool3) {
        this.jdField_b_of_type_JavaLangString = ((SoLocalInfo)localObject1).f;
      }
      return b(0);
    }
    return b(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskSync
 * JD-Core Version:    0.7.0.1
 */