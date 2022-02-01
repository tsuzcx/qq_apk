package com.tencent.mobileqq.soload.biz.entity;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class LoadExtResult
  implements Serializable
{
  private static final int ERROR_EXCEPTION_IO = -111;
  private static final int ERROR_EXCEPTION_SOCKET = -114;
  private static final int NONE_NET = -104;
  private static final String TAG = "LoadExtResult";
  private static final long TIME_INTERVAL_NETWORK_ERROR = 300000L;
  private static final long TIME_INTERVAL_OTHER_ERROR = 600000L;
  private int downloadSoNum = 0;
  private int failIndex = 0;
  public AsyncFailInfo failInfo;
  private boolean isFirstlyLoad = true;
  private boolean isNeedRetry = false;
  private Map<String, LoadExtResult.SoRecord> mPathsMap = new HashMap();
  private String reportStr = "";
  int resCode;
  private int soNum;
  
  public static LoadExtResult create(int paramInt1, int paramInt2)
  {
    return create(paramInt1, paramInt2, null, SoLoadInfo.sDefault, LoadOptions.sDefault);
  }
  
  public static LoadExtResult create(int paramInt1, int paramInt2, String paramString, @NonNull SoLoadInfo paramSoLoadInfo, LoadOptions paramLoadOptions)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean isDownloadNetworkErr(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 3) && ((paramInt2 == -104) || (paramInt2 == -111) || (paramInt2 == -114));
  }
  
  private boolean isGetConfigNetworkErr(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 2) && (paramInt2 == -2);
  }
  
  private LoadExtResult merge(LoadExtResult paramLoadExtResult)
  {
    if (paramLoadExtResult == null) {
      return this;
    }
    this.soNum += paramLoadExtResult.soNum;
    this.resCode = paramLoadExtResult.resCode;
    this.downloadSoNum += paramLoadExtResult.downloadSoNum;
    boolean bool1 = this.isFirstlyLoad;
    boolean bool2 = false;
    if ((!bool1) && (!paramLoadExtResult.isFirstlyLoad)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.isFirstlyLoad = bool1;
    Object localObject;
    if (!TextUtils.isEmpty(paramLoadExtResult.reportStr))
    {
      if (!TextUtils.isEmpty(this.reportStr))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.reportStr);
        ((StringBuilder)localObject).append("&");
        this.reportStr = ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.reportStr);
      ((StringBuilder)localObject).append(paramLoadExtResult.reportStr);
      this.reportStr = ((StringBuilder)localObject).toString();
    }
    if (paramLoadExtResult.mPathsMap.size() > 0)
    {
      localObject = paramLoadExtResult.mPathsMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.mPathsMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    this.failInfo = paramLoadExtResult.failInfo;
    bool1 = bool2;
    if (this.isNeedRetry)
    {
      bool1 = bool2;
      if (paramLoadExtResult.isNeedRetry) {
        bool1 = true;
      }
    }
    this.isNeedRetry = bool1;
    return this;
  }
  
  public static LoadExtResult mergeExtResult(LoadExtResult paramLoadExtResult1, LoadExtResult paramLoadExtResult2)
  {
    if (paramLoadExtResult2 == null) {
      return paramLoadExtResult1;
    }
    return paramLoadExtResult2.merge(paramLoadExtResult1);
  }
  
  public long getDelayAyncTime()
  {
    Object localObject = this.failInfo;
    if ((localObject != null) && (((AsyncFailInfo)localObject).lastFailTime != 0L))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getDelayAyncTime]FailInfo:");
        ((StringBuilder)localObject).append(this.failInfo);
        QLog.i("LoadExtResult", 2, ((StringBuilder)localObject).toString());
      }
      long l;
      if ((!isDownloadNetworkErr(this.failInfo.lastFailCode, this.failInfo.lastSubFailCode)) && (!isGetConfigNetworkErr(this.failInfo.lastFailCode, this.failInfo.lastSubFailCode)))
      {
        l = 600000L;
      }
      else
      {
        int i = NetworkUtil.getNetworkType(MobileQQ.sMobileQQ);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[getDelayAyncTime]curNetType:");
          ((StringBuilder)localObject).append(i);
          QLog.i("LoadExtResult", 2, ((StringBuilder)localObject).toString());
        }
        if (this.failInfo.netType != i) {
          return 0L;
        }
        l = 300000L;
      }
      return this.failInfo.lastFailTime + l - NetConnInfoCenter.getServerTimeMillis();
    }
    return 0L;
  }
  
  public String getRelatedFilesFolder()
  {
    Iterator localIterator = this.mPathsMap.values().iterator();
    if (localIterator.hasNext()) {
      return ((LoadExtResult.SoRecord)localIterator.next()).rFileFolder;
    }
    return "";
  }
  
  public String getRelatedFilesFolder(String paramString)
  {
    paramString = (LoadExtResult.SoRecord)this.mPathsMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.rFileFolder;
  }
  
  public int getReportCode()
  {
    return this.soNum * 100000 + this.resCode * 1000 + this.failIndex * 100 + this.downloadSoNum * 10 + (this.isFirstlyLoad ^ true);
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
      return ((LoadExtResult.SoRecord)localIterator.next()).soPath;
    }
    return "";
  }
  
  public String getSoLoadPath(String paramString)
  {
    paramString = (LoadExtResult.SoRecord)this.mPathsMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.soPath;
  }
  
  public String getVer()
  {
    Iterator localIterator = this.mPathsMap.values().iterator();
    if (localIterator.hasNext()) {
      return ((LoadExtResult.SoRecord)localIterator.next()).soVer;
    }
    return "";
  }
  
  public String getVer(String paramString)
  {
    paramString = (LoadExtResult.SoRecord)this.mPathsMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.soVer;
  }
  
  public boolean isNeedRetry(LoadParam paramLoadParam)
  {
    boolean bool2 = LoadParam.isCloseRetry(paramLoadParam);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((!isSucc()) || (this.isNeedRetry)) {
      bool1 = true;
    }
    return bool1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LRes{rCode=");
    localStringBuilder.append(this.resCode);
    localStringBuilder.append(",isSucc=");
    localStringBuilder.append(isSucc());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.LoadExtResult
 * JD-Core Version:    0.7.0.1
 */