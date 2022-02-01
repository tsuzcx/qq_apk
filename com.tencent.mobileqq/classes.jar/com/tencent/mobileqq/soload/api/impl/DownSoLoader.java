package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.AsyncFailInfo;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.mobileqq.soload.util.SoReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class DownSoLoader
{
  private static HashMap<String, SoLoadInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, AsyncFailInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static Set<String> jdField_a_of_type_JavaUtilSet = new DownSoLoader.2();
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private OnLoadListener jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener;
  private LoadParam.LoadItem jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem;
  private LoadParam jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
  private SoLoadInfo jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo = SoLoadInfo.sDefault;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
  private int a(LoadParam.LoadItem paramLoadItem, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    int i = 0;
    int j = a(paramSoLoadInfo.soPathToLoad, paramLoadItem);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + j + ",filePath=" + paramSoLoadInfo.soPathToLoad);
    }
    boolean bool;
    if (j == 0)
    {
      bool = true;
      a(bool, this.jdField_a_of_type_JavaLangString, paramSoLoadInfo.soPathToLoad, paramLoadItem);
      if (j != 0) {
        break label116;
      }
      SoDataUtil.a(paramLoadItem, paramSoLoadInfo.soPathToLoad);
      SoLoadUtils.a(paramLoadItem, paramSoLoadInfo);
      SoLoadUtils.b(paramLoadItem.name);
      i = j;
    }
    label116:
    while (b(paramLoadItem))
    {
      return i;
      bool = false;
      break;
    }
    return j;
  }
  
  private int a(@NonNull SoLoadInfo paramSoLoadInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo = paramSoLoadInfo;
    int j = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.curCode;
    int i;
    if (j == 0) {
      i = a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo);
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (j != 2);
      i = j;
    } while (!a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem));
    return 0;
  }
  
  private int a(String paramString, LoadParam.LoadItem paramLoadItem)
  {
    int j = 0;
    int i;
    if ((!new File(paramString).exists()) && (b(paramString))) {
      i = 5;
    }
    for (;;)
    {
      return i;
      if ((paramLoadItem.lops.flag & 0x1) != 0)
      {
        i = j;
        if ((paramLoadItem.lops.flag & 0x2) != 0)
        {
          i = j;
          if (!jdField_a_of_type_JavaUtilSet.contains(paramLoadItem.name))
          {
            paramString = paramLoadItem.lops;
            paramString.flag &= 0xFFFFFFFD;
            return 0;
          }
        }
      }
      else
      {
        try
        {
          System.load(paramString);
          paramString = paramLoadItem.lops;
          paramString.flag |= 0x2;
          i = j;
          if (b())
          {
            jdField_a_of_type_JavaUtilHashMap.put(paramLoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo);
            return 0;
          }
        }
        catch (Throwable paramString)
        {
          this.jdField_a_of_type_JavaLangString = SoDataUtil.a(paramString);
          QLog.e("SoLoadWidget.DownSoLoader", 1, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    return 6;
  }
  
  private LoadExtResult a(int paramInt)
  {
    String str = null;
    if (paramInt == 6) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      return a(paramInt, str);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.failDetail)) {
        str = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.failDetail;
      }
    }
  }
  
  private LoadExtResult a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    SoReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq, "ver=" + this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer(), "load.item.load", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, paramInt, paramString);
    LoadExtResult localLoadExtResult = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.lops);
    int i;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC))
    {
      AsyncFailInfo localAsyncFailInfo = (AsyncFailInfo)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
      paramString = localAsyncFailInfo;
      if (localAsyncFailInfo == null) {
        paramString = new AsyncFailInfo();
      }
      boolean bool = NetworkUtil.d(MobileQQ.sMobileQQ);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      i = NetworkUtil.a(MobileQQ.sMobileQQ);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[onLoadResult]AsyncFailInfo:" + paramString + ",name:" + this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name + ",isNetSupport:" + bool + ",curTime=" + l3 + ",netType=" + i);
      }
      if (bool)
      {
        paramString.jdField_a_of_type_Int = paramInt;
        paramString.c = i;
        paramString.jdField_a_of_type_Long = l3;
        paramString.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.subErrCode;
        jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, paramString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType == LoadParam.CALL_TYPE_SYNC) {
      localLoadExtResult.failInfo = ((AsyncFailInfo)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener.onLoadResult(paramInt, localLoadExtResult);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.isFirstlyLoad) {
      i = 3;
    }
    for (;;)
    {
      if (!LoadParam.isCloseReport(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam)) {
        ReportController.b(null, "dc00899", "SoLoad", "", "resSingle", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType, paramInt, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer(), i + "", l1 - l2 + "", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.subErrCode + "");
      }
      return localLoadExtResult;
      if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.isNeedDownload) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public static String a(String paramString)
  {
    paramString = (SoLoadInfo)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.getVer();
  }
  
  @Deprecated
  public static List<String> a()
  {
    return new LinkedList(jdField_a_of_type_JavaUtilHashMap.keySet());
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, LoadParam.LoadItem paramLoadItem)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name).append("_").append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.ver).append("_").append(this.c).append("_").append(this.d).append("_").append(this.jdField_b_of_type_Int).append("_").append(paramBoolean).append("_").append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.testFlag).append("_").append(paramLoadItem.lops.flag).append("_").append(this.jdField_a_of_type_Int);
      paramLoadItem = new StringBuilder();
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      paramLoadItem.append(MobileQQ.processName).append("_").append(SoDataUtil.a(paramString2));
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[testNoExist] skey=" + localStringBuilder + ",step=" + paramLoadItem);
      }
      SoReportUtil.a(localStringBuilder.toString(), "qqwallet", "SoLoadNotExist", paramLoadItem.toString(), null, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.testFlag, paramString1);
    }
  }
  
  private boolean a()
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name))
    {
      this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo = ((SoLoadInfo)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name));
      if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.isFirstlyLoad = false;
      }
      LoadOptions localLoadOptions = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.lops;
      localLoadOptions.flag |= 0x2;
      return true;
    }
    return false;
  }
  
  private boolean a(LoadParam.LoadItem paramLoadItem)
  {
    boolean bool2 = false;
    String str = paramLoadItem.lops.getOldSoPath();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (new File(str).exists())
      {
        int i = a(str, paramLoadItem);
        SoReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq, null, "load.item.load.oldpath", null, i, null);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam = paramLoadParam;
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener = paramOnLoadListener;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem = ((LoadParam.LoadItem)paramLoadParam.mLoadItems.get(0));
    SoReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq, null, "load.item.start", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, 0, null);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.relatedFileInfo == null) {}
    while (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.rFileFolder)) {
      return true;
    }
    return false;
  }
  
  private boolean b(LoadParam.LoadItem paramLoadItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLoadItem.lops.isLoadLastSuccWhenFail)
    {
      String str = SoDataUtil.a(paramLoadItem);
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramLoadItem);
        SoReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mReportSeq, null, "load.item.load.last", null, i, null);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean b(String paramString)
  {
    return true;
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    b(paramLoadParam, null);
    if (a()) {
      return a(0);
    }
    return a(a(new GetSoLoadInfoTaskSync(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem).a()));
  }
  
  public void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    b(paramLoadParam, paramOnLoadListener);
    if (a())
    {
      a(0);
      return;
    }
    new GetSoLoadInfoTaskAsync(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem).a(new DownSoLoader.1(this));
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType != LoadParam.CALL_TYPE_SYNC)) {
      a(8, paramString);
    }
    for (;;)
    {
      SoCrashInfo.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer(), 0);
      return;
      SoReportUtil.a(null, "ver=" + this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer(), "SoLoadModule", "SoLoadSingle", "Exception", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, 2, paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name;
      str2 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.soFileName;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (!paramString.contains(str2)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.DownSoLoader
 * JD-Core Version:    0.7.0.1
 */