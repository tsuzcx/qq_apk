package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.log.TBSLog;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.net.HttpRequestJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class StatisticReport
{
  private static final String DEBUG_EVENT_POST_URL = "https://tbsone.sparta.html5.qq.com";
  private static final String LOG_POST_URL = "https://qprostat.imtt.qq.com";
  private static final String OFFICIAL_EVENT_POST_URL = "https://tbsone.imtt.qq.com";
  private static final String TYPE_ONE_LOG_IDENTIFIER = "tbsonelog";
  private static WeakReference<Context> sContextReference;
  private static String sEventPostUrl = "https://tbsone.imtt.qq.com";
  private static String sLogUploadLock = "log.lock";
  private String mCompCode = "";
  private String mCompName = "";
  private String mDEPSCode = "";
  private String mDescription = "";
  private String mEventCode = "";
  private String mEventName = "";
  
  private StatisticReport(String paramString, int paramInt)
  {
    this.mEventName = paramString;
    this.mEventCode = (paramInt + "");
  }
  
  public static StatisticReport create(String paramString, int paramInt)
  {
    return new StatisticReport(paramString, paramInt);
  }
  
  private static int doReadUploadLock()
  {
    Object localObject = new File(TBSLog.getLogPath(), sLogUploadLock);
    if (((File)localObject).exists()) {
      try
      {
        localObject = FileUtils.readStreamToString(new FileInputStream((File)localObject), "utf-8");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return -1;
        }
        int i = Integer.parseInt((String)localObject);
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  private static void doWriteUploadLock(Context paramContext)
  {
    try
    {
      File localFile = new File(TBSLog.getLogPath(), sLogUploadLock);
      if (!localFile.exists())
      {
        if (!localFile.createNewFile()) {
          break label73;
        }
        Logging.d("Create log upload lock: ", new Object[] { localFile.getAbsolutePath() });
      }
      for (;;)
      {
        FileUtils.writeFile(StatisticInfo.getAppVersionCode(paramContext) + "", "utf-8", localFile);
        return;
        label73:
        Logging.e("Create log upload lock failed!", new Object[0]);
      }
      return;
    }
    catch (IOException paramContext)
    {
      Logging.e("Exception when write log upload lock:" + paramContext.getMessage(), new Object[0]);
      paramContext.printStackTrace();
    }
  }
  
  private String getDescriptionStr()
  {
    if (!TextUtils.isEmpty(this.mDescription)) {
      return this.mDescription.replaceAll("\r\n|\r|\n", "");
    }
    return "";
  }
  
  public static void initialize(Context paramContext)
  {
    sContextReference = new WeakReference(paramContext);
  }
  
  public static void reportLog()
  {
    for (;;)
    {
      try
      {
        Context localContext1 = (Context)sContextReference.get();
        if (localContext1 == null)
        {
          Logging.e("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Object[] { new Throwable("Null context!") });
          return;
        }
        int i = doReadUploadLock();
        if ((i > 0) && (i == StatisticInfo.getAppVersionCode(localContext1))) {
          Logging.i("Detected logs have been uploaded in this version, log report ignored.", new Object[0]);
        } else {
          StatisticExecutor.getInstance().exeSerial(new StatisticReport.3(localContext2));
        }
      }
      finally {}
    }
  }
  
  public static void shiftRepService(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "https://tbsone.sparta.html5.qq.com";; str = "https://tbsone.imtt.qq.com")
    {
      sEventPostUrl = str;
      Logging.d("Shifting to report server: " + sEventPostUrl, new Object[0]);
      return;
    }
  }
  
  public void report()
  {
    Object localObject1 = (Context)sContextReference.get();
    if (localObject1 == null) {
      Logging.e("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Object[] { new Throwable("Null context!") });
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = new HashMap();
      ((Map)localObject2).put("PROTV", Integer.valueOf(1));
      ((Map)localObject2).put("FUNC", Integer.valueOf(2));
      ((Map)localObject2).put("EVENT", this.mEventName);
      ((Map)localObject2).put("CODE", this.mEventCode + "");
      ((Map)localObject2).put("DESCRIPTION", getDescriptionStr());
      ((Map)localObject2).put("IMEI", StatisticInfo.getImei((Context)localObject1) + "");
      ((Map)localObject2).put("DEVMODEL", StatisticInfo.getDeviceModel() + "");
      ((Map)localObject2).put("CPUABI", StatisticInfo.getDeviceCpuAbi() + "");
      ((Map)localObject2).put("APPVERCODE", StatisticInfo.getAppVersionCode((Context)localObject1) + "");
      ((Map)localObject2).put("APPVERNAME", StatisticInfo.getAppVersionName((Context)localObject1) + "");
      ((Map)localObject2).put("APPPKG", ((Context)localObject1).getPackageName() + "");
      ((Map)localObject2).put("CREATETIME", System.currentTimeMillis() + "");
      ((Map)localObject2).put("APNTYPE", StatisticInfo.getApnType((Context)localObject1) + "");
      ((Map)localObject2).put("ANDROIDID", StatisticInfo.getAndroidID((Context)localObject1) + "");
      ((Map)localObject2).put("ONECODE", "1");
      ((Map)localObject2).put("ONENAME", "1.0.0");
      ((Map)localObject2).put("COMPNAME", this.mCompName);
      ((Map)localObject2).put("COMPCODE", this.mCompCode + "");
      ((Map)localObject2).put("DEPSCODE", this.mDEPSCode + "");
      ((Map)localObject2).put("SDKCODE", StatisticInfo.getSDKCodes() + "");
      ((Map)localObject2).put("MODEL", Build.MODEL);
      ((Map)localObject2).put("ADV", Build.VERSION.RELEASE);
      localObject2 = new JSONObject((Map)localObject2).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Logging.d((String)localObject2, new Object[0]);
    localObject1 = new HttpRequestJob((Context)localObject1, sEventPostUrl, "POST", null, ((String)localObject2).getBytes());
    ((HttpRequestJob)localObject1).setClient(new StatisticReport.1(this));
    ((HttpRequestJob)localObject1).start(new StatisticReport.2(this));
  }
  
  public StatisticReport setComponent(String paramString, int paramInt)
  {
    this.mCompName = paramString;
    this.mCompCode = (paramInt + "");
    return this;
  }
  
  public StatisticReport setDEPSCode(int paramInt)
  {
    this.mDEPSCode = (paramInt + "");
    return this;
  }
  
  public StatisticReport setDescription(String paramString)
  {
    this.mDescription = paramString;
    return this;
  }
  
  public StatisticReport setDescription(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("@");
    if (paramThrowable != null) {}
    for (paramString = Log.getStackTraceString(paramThrowable);; paramString = "")
    {
      this.mDescription = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport
 * JD-Core Version:    0.7.0.1
 */