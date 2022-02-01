package com.tencent.mobileqq.soload;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import bbys;
import bbzc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LoadExtResult
  implements Serializable
{
  private int downloadSoNum;
  private int failIndex;
  public bbys failInfo;
  private boolean isFirstlyLoad = true;
  private boolean isNeedRetry;
  private Map<String, bbzc> mPathsMap = new HashMap();
  private String reportStr = "";
  int resCode;
  private int soNum;
  
  private LoadExtResult a(LoadExtResult paramLoadExtResult)
  {
    boolean bool2 = true;
    if (paramLoadExtResult == null) {
      return this;
    }
    this.soNum += paramLoadExtResult.soNum;
    this.resCode = paramLoadExtResult.resCode;
    this.downloadSoNum += paramLoadExtResult.downloadSoNum;
    if ((this.isFirstlyLoad) || (paramLoadExtResult.isFirstlyLoad)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isFirstlyLoad = bool1;
      if (!TextUtils.isEmpty(paramLoadExtResult.reportStr))
      {
        if (!TextUtils.isEmpty(this.reportStr)) {
          this.reportStr += "&";
        }
        this.reportStr += paramLoadExtResult.reportStr;
      }
      if (paramLoadExtResult.mPathsMap.size() <= 0) {
        break;
      }
      Iterator localIterator = paramLoadExtResult.mPathsMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.mPathsMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    this.failInfo = paramLoadExtResult.failInfo;
    if ((this.isNeedRetry) && (paramLoadExtResult.isNeedRetry)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.isNeedRetry = bool1;
      return this;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 3) && ((paramInt2 == -104) || (paramInt2 == -111) || (paramInt2 == -114));
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 2) && (paramInt2 == -2);
  }
  
  public static LoadExtResult create(int paramInt1, int paramInt2)
  {
    return create(paramInt1, paramInt2, null, SoLoadInfo.sDefault, LoadOptions.sDefault);
  }
  
  public static LoadExtResult create(int paramInt1, int paramInt2, String paramString, @NonNull SoLoadInfo paramSoLoadInfo, LoadOptions paramLoadOptions)
  {
    boolean bool = true;
    LoadExtResult localLoadExtResult = new LoadExtResult();
    localLoadExtResult.soNum = paramInt2;
    localLoadExtResult.resCode = paramInt1;
    if (paramSoLoadInfo.isFinishDownload)
    {
      paramInt2 = 1;
      localLoadExtResult.downloadSoNum = paramInt2;
      localLoadExtResult.isFirstlyLoad = paramSoLoadInfo.isFirstlyLoad;
      if (localLoadExtResult.resCode != 0) {
        break label206;
      }
      paramInt2 = 0;
      label58:
      localLoadExtResult.failIndex = paramInt2;
      if (((paramLoadOptions.flag & 0x4) == 0) || (paramSoLoadInfo.soDetailInfo.relatedFileInfo == null) || (!TextUtils.isEmpty(paramSoLoadInfo.rFileFolder))) {
        break label211;
      }
    }
    for (;;)
    {
      localLoadExtResult.isNeedRetry = bool;
      if (!TextUtils.isEmpty(paramString))
      {
        localLoadExtResult.reportStr = (paramString + "=" + paramInt1);
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramInt1 == 0)
        {
          localObject1 = localObject2;
          if ((paramLoadOptions.flag & 0x2) != 0) {
            localObject1 = paramSoLoadInfo.soPathToLoad;
          }
        }
        paramSoLoadInfo = new bbzc((String)localObject1, paramSoLoadInfo.rFileFolder, paramSoLoadInfo.getVer());
        localLoadExtResult.mPathsMap.put(paramString, paramSoLoadInfo);
      }
      return localLoadExtResult;
      paramInt2 = 0;
      break;
      label206:
      paramInt2 = 1;
      break label58;
      label211:
      bool = false;
    }
  }
  
  public static LoadExtResult mergeExtResult(LoadExtResult paramLoadExtResult1, LoadExtResult paramLoadExtResult2)
  {
    if (paramLoadExtResult2 == null) {
      return paramLoadExtResult1;
    }
    return paramLoadExtResult2.a(paramLoadExtResult1);
  }
  
  public long getDelayAyncTime()
  {
    if ((this.failInfo != null) && (this.failInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoadExtResult", 2, "[getDelayAyncTime]FailInfo:" + this.failInfo);
      }
      if ((!a(this.failInfo.jdField_a_of_type_Int, this.failInfo.b)) && (!b(this.failInfo.jdField_a_of_type_Int, this.failInfo.b))) {
        break label164;
      }
      int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.i("LoadExtResult", 2, "[getDelayAyncTime]curNetType:" + i);
      }
      if (this.failInfo.c == i) {}
    }
    else
    {
      return 0L;
    }
    label164:
    for (long l = 300000L;; l = 600000L) {
      return l + this.failInfo.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
    }
  }
  
  public String getRelatedFilesFolder()
  {
    Iterator localIterator = this.mPathsMap.values().iterator();
    if (localIterator.hasNext()) {
      return ((bbzc)localIterator.next()).b;
    }
    return "";
  }
  
  public String getRelatedFilesFolder(String paramString)
  {
    paramString = (bbzc)this.mPathsMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.b;
  }
  
  public int getReportCode()
  {
    int j = this.soNum;
    int k = this.resCode;
    int m = this.failIndex;
    int n = this.downloadSoNum;
    if (this.isFirstlyLoad) {}
    for (int i = 0;; i = 1) {
      return i + (n * 10 + (j * 100000 + k * 1000 + m * 100));
    }
  }
  
  public String getReportStr()
  {
    return this.reportStr;
  }
  
  public int getResultCode()
  {
    return this.resCode;
  }
  
  public String getSoLoadPath()
  {
    Iterator localIterator = this.mPathsMap.values().iterator();
    if (localIterator.hasNext()) {
      return ((bbzc)localIterator.next()).a;
    }
    return "";
  }
  
  public String getSoLoadPath(String paramString)
  {
    paramString = (bbzc)this.mPathsMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.a;
  }
  
  public String getVer()
  {
    Iterator localIterator = this.mPathsMap.values().iterator();
    if (localIterator.hasNext()) {
      return ((bbzc)localIterator.next()).c;
    }
    return "";
  }
  
  public String getVer(String paramString)
  {
    paramString = (bbzc)this.mPathsMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.c;
  }
  
  public boolean isNeedRetry(LoadParam paramLoadParam)
  {
    if (LoadParam.isCloseRetry(paramLoadParam)) {}
    while ((isSucc()) && (!this.isNeedRetry)) {
      return false;
    }
    return true;
  }
  
  public boolean isSucc()
  {
    return this.resCode == 0;
  }
  
  public void setFailIndex(int paramInt)
  {
    this.failIndex = paramInt;
  }
  
  public String toString()
  {
    return "LRes{rCode=" + this.resCode + ",isSucc=" + isSucc() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.LoadExtResult
 * JD-Core Version:    0.7.0.1
 */