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

public class SoLoaderLogic
{
  private static HashMap<String, SoLoadInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, AsyncFailInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static Set<String> jdField_a_of_type_JavaUtilSet = new SoLoaderLogic.2();
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
    int i = a(paramSoLoadInfo.soPathToLoad, paramLoadItem);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadConfigSo] res=");
      localStringBuilder.append(i);
      localStringBuilder.append(",filePath=");
      localStringBuilder.append(paramSoLoadInfo.soPathToLoad);
      QLog.d("SoLoadWidget.SoLoaderLogic", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, this.jdField_a_of_type_JavaLangString, paramSoLoadInfo.soPathToLoad, paramLoadItem);
    if (i == 0)
    {
      SoDataUtil.a(paramLoadItem, paramSoLoadInfo.soPathToLoad);
      SoLoadUtils.a(paramLoadItem, paramSoLoadInfo);
      SoLoadUtils.b(paramLoadItem.name);
      return i;
    }
    if (b(paramLoadItem)) {
      return 0;
    }
    return i;
  }
  
  private int a(@NonNull SoLoadInfo paramSoLoadInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo = a(paramSoLoadInfo);
    int j = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.curCode;
    if (j == 0) {
      return a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo);
    }
    int i = j;
    if (j == 2)
    {
      i = j;
      if (a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem)) {
        i = 0;
      }
    }
    return i;
  }
  
  private int a(String paramString, LoadParam.LoadItem paramLoadItem)
  {
    if ((!new File(paramString).exists()) && (b(paramString))) {
      return 5;
    }
    if ((paramLoadItem.lops.flag & 0x1) != 0)
    {
      if (((paramLoadItem.lops.flag & 0x2) != 0) && (!jdField_a_of_type_JavaUtilSet.contains(paramLoadItem.name)))
      {
        paramString = paramLoadItem.lops;
        paramString.flag &= 0xFFFFFFFD;
      }
      return 0;
    }
    try
    {
      System.load(paramString);
      paramString = paramLoadItem.lops;
      paramString.flag |= 0x2;
      if (b()) {
        jdField_a_of_type_JavaUtilHashMap.put(paramLoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo);
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      this.jdField_a_of_type_JavaLangString = SoDataUtil.a(paramString);
      QLog.e("SoLoadWidget.SoLoaderLogic", 1, this.jdField_a_of_type_JavaLangString);
      if ((paramString instanceof UnsatisfiedLinkError)) {
        return 12;
      }
    }
    return 6;
  }
  
  private LoadExtResult a(int paramInt)
  {
    String str;
    if (paramInt == 6) {
      str = this.jdField_a_of_type_JavaLangString;
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.failDetail)) {
      str = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.failDetail;
    } else {
      str = null;
    }
    return a(paramInt, str);
  }
  
  private LoadExtResult a(int paramInt, String paramString)
  {
    int i = 1;
    this.jdField_a_of_type_Boolean = true;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
    long l3 = ((LoadParam)localObject1).mReportSeq;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ver=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer());
    SoReportUtil.a((LoadParam)localObject1, l3, ((StringBuilder)localObject2).toString(), "load.item.load", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, paramInt, paramString);
    localObject2 = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.lops);
    int j;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC))
    {
      localObject1 = (AsyncFailInfo)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = new AsyncFailInfo();
      }
      boolean bool = NetworkUtil.isNetSupport(MobileQQ.sMobileQQ);
      l3 = NetConnInfoCenter.getServerTimeMillis();
      j = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[onLoadResult]AsyncFailInfo:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(",name:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
        ((StringBuilder)localObject1).append(",isNetSupport:");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(",curTime=");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(",netType=");
        ((StringBuilder)localObject1).append(j);
        QLog.i("SoLoadWidget.SoLoaderLogic", 2, ((StringBuilder)localObject1).toString());
      }
      if (bool)
      {
        paramString.lastFailCode = paramInt;
        paramString.netType = j;
        paramString.lastFailTime = l3;
        paramString.lastSubFailCode = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.subErrCode;
        jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, paramString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType == LoadParam.CALL_TYPE_SYNC) {
      ((LoadExtResult)localObject2).failInfo = ((AsyncFailInfo)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name));
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener;
    if (paramString != null) {
      paramString.onLoadResult(paramInt, (LoadExtResult)localObject2);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.isFirstlyLoad) {
      i = 3;
    } else if (!this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.isNeedDownload) {
      i = 2;
    }
    if (!LoadParam.isCloseReport(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name;
      j = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(l1 - l2);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.subErrCode);
      localStringBuilder.append("");
      ReportController.b(null, "dc00899", "SoLoad", "", "resSingle", paramString, j, paramInt, (String)localObject1, (String)localObject3, (String)localObject4, localStringBuilder.toString());
    }
    return localObject2;
  }
  
  private SoLoadInfo a(SoLoadInfo paramSoLoadInfo)
  {
    Object localObject = paramSoLoadInfo;
    if (paramSoLoadInfo == null)
    {
      paramSoLoadInfo = SoLoadInfo.sDefault;
      localObject = paramSoLoadInfo;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSoLoadInfo is null");
        ((StringBuilder)localObject).append(new Exception());
        QLog.e("SoLoadWidget.SoLoaderLogic", 2, ((StringBuilder)localObject).toString());
        localObject = paramSoLoadInfo;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo = ((SoLoadInfo)localObject);
    return localObject;
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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.ver);
      localStringBuilder.append("_");
      localStringBuilder.append(this.c);
      localStringBuilder.append("_");
      localStringBuilder.append(this.d);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("_");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.testFlag);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLoadItem.lops.flag);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      paramLoadItem = new StringBuilder();
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      paramLoadItem.append(MobileQQ.processName);
      paramLoadItem.append("_");
      paramLoadItem.append(SoDataUtil.a(paramString2));
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("[testNoExist] skey=");
        paramString2.append(localStringBuilder);
        paramString2.append(",step=");
        paramString2.append(paramLoadItem);
        QLog.i("SoLoadWidget.SoLoaderLogic", 2, paramString2.toString());
      }
      SoReportUtil.a(localStringBuilder.toString(), "qqwallet", "SoLoadNotExist", paramLoadItem.toString(), null, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.testFlag, paramString1);
    }
  }
  
  private boolean a()
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name))
    {
      this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo = a((SoLoadInfo)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo;
      if (localObject != null) {
        ((SoLoadInfo)localObject).isFirstlyLoad = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.lops;
      ((LoadOptions)localObject).flag |= 0x2;
      return true;
    }
    return false;
  }
  
  private boolean a(LoadParam.LoadItem paramLoadItem)
  {
    String str = paramLoadItem.lops.getOldSoPath();
    boolean bool3 = TextUtils.isEmpty(str);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (new File(str).exists())
      {
        int i = a(str, paramLoadItem);
        paramLoadItem = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
        SoReportUtil.a(paramLoadItem, paramLoadItem.mReportSeq, null, "load.item.load.oldpath", null, i, null);
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
    paramLoadParam = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
    SoReportUtil.a(paramLoadParam, paramLoadParam.mReportSeq, null, "load.item.start", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, 0, null);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.soDetailInfo.relatedFileInfo == null) {
      return true;
    }
    return !TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.rFileFolder);
  }
  
  private boolean b(LoadParam.LoadItem paramLoadItem)
  {
    boolean bool3 = paramLoadItem.lops.isLoadLastSuccWhenFail;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      String str = SoDataUtil.a(paramLoadItem);
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramLoadItem);
        paramLoadItem = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
        SoReportUtil.a(paramLoadItem, paramLoadItem.mReportSeq, null, "load.item.load.last", null, i, null);
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
    new GetSoLoadInfoTaskAsync(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem).a(new SoLoaderLogic.1(this));
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mCallType != LoadParam.CALL_TYPE_SYNC))
    {
      a(8, paramString);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ver=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer());
      SoReportUtil.a(null, localStringBuilder.toString(), "SoLoadModule", "SoLoadSingle", "Exception", this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, 2, paramString);
    }
    SoCrashInfo.a(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoLoadInfo.getVer(), 0);
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.name;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem.soFileName;
    bool1 = bool2;
    if (!TextUtils.isEmpty(str1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str2))
      {
        bool1 = bool2;
        if (paramString.contains(str2)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderLogic
 * JD-Core Version:    0.7.0.1
 */