package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.mobileqq.soload.util.SoReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GetSoLoadInfoTaskAsync
  extends AbsGetSoLoadInfoTask
{
  private static final Map<String, List<OnGetSoLoadInfoListener>> a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public GetSoLoadInfoTaskAsync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
  }
  
  private void a(int paramInt)
  {
    SoLoadInfo localSoLoadInfo = a(paramInt);
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      Object localObject3 = (List)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
      jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
      if (localObject3 != null)
      {
        ??? = ((List)localObject3).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (OnGetSoLoadInfoListener)((Iterator)???).next();
          if (localObject3 != null) {
            ((OnGetSoLoadInfoListener)localObject3).onGetLoadInfo(localSoLoadInfo);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void a(OnSoGetPathListener paramOnSoGetPathListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.relatedFileInfo != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.relatedFileInfo.url;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.relatedFileInfo.md5;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
        bool = true;
      } else {
        bool = false;
      }
      SoLoadUtils.a(str1, str2, bool, paramOnSoGetPathListener);
    }
  }
  
  private void a(LoadParam.LoadItem paramLoadItem)
  {
    paramLoadItem = SoLoadUtils.a(paramLoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo);
    boolean bool2 = a(paramLoadItem);
    boolean bool3 = a(paramLoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo);
    boolean bool1;
    if (((this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.lops.flag & 0x4) != 0) && (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleConfig] soExist=");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",rfolderOk=");
      localStringBuilder.append(bool3);
      localStringBuilder.append(",isWeak:");
      localStringBuilder.append(bool1);
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = (bool2 ^ true);
    if (!bool2)
    {
      b(new GetSoLoadInfoTaskAsync.3(this, bool3, bool1, paramLoadItem));
      return;
    }
    a(bool3, bool1, paramLoadItem, paramLoadItem.mSoPath, paramLoadItem.mSoCRC, 1);
  }
  
  private void a(LoadParam.LoadItem paramLoadItem, SoInfo paramSoInfo)
  {
    if (!a(paramSoInfo))
    {
      a(2);
      return;
    }
    paramSoInfo = SoLoadUtils.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.ver);
    if ((paramSoInfo != null) && (paramSoInfo.c()))
    {
      if (QLog.isColorLevel())
      {
        paramLoadItem = new StringBuilder();
        paramLoadItem.append("[handleConfig] InLoadCrashProtectMode, crashInfo=");
        paramLoadItem.append(paramSoInfo);
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, paramLoadItem.toString());
      }
      this.c = "loadcrash";
      a(8);
      return;
    }
    if ((paramSoInfo != null) && (paramSoInfo.f()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleConfig] isNeedReqForCrash, crashInfo=");
        ((StringBuilder)localObject).append(paramSoInfo);
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.ver;
      SoConfigManager.a().a(paramLoadItem.name, paramSoInfo, new GetSoLoadInfoTaskAsync.2(this, (String)localObject, paramSoInfo, paramLoadItem));
      return;
    }
    a(paramLoadItem);
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (a(paramString2, paramLong, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo, paramInt))
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_JavaLangString = paramString2;
      a(0);
      return;
    }
    a(10);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, SoLocalInfo paramSoLocalInfo, String paramString, long paramLong, int paramInt)
  {
    if (paramBoolean1)
    {
      a(paramSoLocalInfo.mRFileFolder, paramString, paramLong, paramInt);
      return;
    }
    if (paramBoolean2)
    {
      a(null);
      a(null, paramString, paramLong, paramInt);
      return;
    }
    a(new GetSoLoadInfoTaskAsync.4(this, paramString, paramLong, paramInt));
  }
  
  private boolean a(OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      Object localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getKey();
        if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name)))
        {
          ((List)localEntry.getValue()).add(paramOnGetSoLoadInfoListener);
          return true;
        }
      }
      localObject = new LinkedList();
      ((List)localObject).add(paramOnGetSoLoadInfoListener);
      jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, localObject);
      return false;
    }
    for (;;)
    {
      throw paramOnGetSoLoadInfoListener;
    }
  }
  
  private void b(OnSoGetPathListener paramOnSoGetPathListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo != null)
      {
        String str1 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.url;
        String str2 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.md5;
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
          bool = true;
        } else {
          bool = false;
        }
        SoLoadUtils.a(str1, str2, bool, paramOnSoGetPathListener);
      }
      SoReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq, null, "load.item.download.start", null, 0, null);
    }
  }
  
  public void a(OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "not main process get loadInfo by IPC");
      }
      SoLoadUtils.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem, paramOnGetSoLoadInfoListener);
      return;
    }
    if (a(paramOnGetSoLoadInfoListener))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "insert into same req list");
      }
      return;
    }
    SoReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq, null, "load.item.getconfig.start", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, 0, null);
    SoConfigManager.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, new GetSoLoadInfoTaskAsync.1(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync
 * JD-Core Version:    0.7.0.1
 */