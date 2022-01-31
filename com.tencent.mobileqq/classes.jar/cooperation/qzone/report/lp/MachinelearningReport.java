package cooperation.qzone.report.lp;

import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import angj;
import angk;
import angl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class MachinelearningReport
{
  public static final String BASE = "LpReport.";
  private static final String SEPARATOR = ":";
  private static final String SP_TIME = "lastreporttime";
  private static final String TAG = "LpReport.MachinelearningReport";
  private static boolean isSampled = true;
  private static MachinelearningReport lpReportManager;
  private static long sampleValidEndTime;
  private static long sampleValidStartTime;
  private static long startTime = ;
  private boolean reportExifCameraInfo;
  private LpReportInfos storedClicks = new LpReportInfos();
  
  public MachinelearningReport()
  {
    if (QzoneConfig.getInstance().getConfig("PhotoAlbum", "MachineLearningIsPhotoTagFillUpCpuUsageShreshold", 0) == 0) {}
    for (;;)
    {
      this.reportExifCameraInfo = bool;
      return;
      bool = true;
    }
  }
  
  private void addUserInfo(LpReportInfos paramLpReportInfos)
  {
    long l = LocalMultiProcConfig.getLong4Uin("lastreporttime", 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    if (System.currentTimeMillis() - l < 604800000L) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "getHostInfo", null);
      } while (localObject == null);
      localObject = ((EIPCResult)localObject).data;
    } while (localObject == null);
    LpReport_UserInfo_dc02148 localLpReport_UserInfo_dc02148 = new LpReport_UserInfo_dc02148();
    localLpReport_UserInfo_dc02148.age = ((Bundle)localObject).getLong("age");
    localLpReport_UserInfo_dc02148.gender = ((Bundle)localObject).getLong("gender");
    localLpReport_UserInfo_dc02148.constellation = ((Bundle)localObject).getLong("constellation");
    localLpReport_UserInfo_dc02148.country = ((Bundle)localObject).getString("country");
    localLpReport_UserInfo_dc02148.province = ((Bundle)localObject).getString("province");
    localLpReport_UserInfo_dc02148.city = ((Bundle)localObject).getString("city");
    paramLpReportInfos.addInfo(18, localLpReport_UserInfo_dc02148);
    LocalMultiProcConfig.putLong4Uin("lastreporttime", System.currentTimeMillis(), BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3)
  {
    return getBeijingTimeInMillis(0, 0, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0))
    {
      localCalendar.set(1, paramInt1);
      localCalendar.set(2, paramInt2);
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static MachinelearningReport getInstance()
  {
    if (lpReportManager == null) {}
    try
    {
      if (lpReportManager == null) {
        lpReportManager = new MachinelearningReport();
      }
      return lpReportManager;
    }
    finally {}
  }
  
  public static boolean isMLReportBlackList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "MachinelearningReportSwitch", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.equals(localObject[i]))
          {
            if (QLog.isColorLevel()) {
              QLog.e("LpReport.MachinelearningReport", 2, "this subtable is in blacklist");
            }
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isMLReportWhiteList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "MachinelearningReportWhiteList", QzoneConfig.DEFAULT_MACHINELEARNING_DEFAULT_WHITE_LIST);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.equals(localObject[i]))
          {
            if (QLog.isColorLevel()) {
              QLog.e("LpReport.MachinelearningReport", 2, "this subtable is in blacklist");
            }
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static boolean isTodayTime(long paramLong)
  {
    return (sampleValidStartTime != 0L) && (sampleValidEndTime != 0L) && (paramLong >= sampleValidStartTime) && (paramLong < sampleValidEndTime);
  }
  
  public static boolean isUserNeedReport()
  {
    if (!isTodayTime(System.currentTimeMillis())) {
      userSample();
    }
    return isSampled;
  }
  
  private void report()
  {
    if (this.storedClicks.isEmpty()) {
      return;
    }
    synchronized (this.storedClicks)
    {
      addUserInfo(this.storedClicks);
      ArrayList localArrayList = this.storedClicks.getInfos();
      this.storedClicks.clear();
      startTime = SystemClock.uptimeMillis();
      ??? = new LpReportNewIntent(BaseApplicationImpl.getContext(), LpReportServlet.class);
      ((LpReportNewIntent)???).type = 33L;
      ((LpReportNewIntent)???).info = null;
      ((LpReportNewIntent)???).extra_info = null;
      ((LpReportNewIntent)???).multi_info = localArrayList;
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)???);
      return;
    }
  }
  
  private void report(int paramInt, LpReportInfo paramLpReportInfo)
  {
    if ((!isMLReportWhiteList(String.valueOf(paramInt))) && (!isUserNeedReport())) {
      if (QLog.isColorLevel()) {
        QLog.i("LpReport.MachinelearningReport", 4, "this user cannot be sampled");
      }
    }
    for (;;)
    {
      return;
      if (isMLReportBlackList(String.valueOf(paramInt)))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("LpReport.MachinelearningReport", 4, "this subtype cannot report:" + paramInt);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("LpReport.MachinelearningReport", 4, "subtype:" + paramInt + " info:" + LpReportUtils.transMapToString(paramLpReportInfo.toMap()));
      }
      synchronized (this.storedClicks)
      {
        this.storedClicks.addInfo(paramInt, paramLpReportInfo);
        if (!LpReportUtils.meetCondition(this.storedClicks, startTime)) {
          continue;
        }
        report();
        return;
      }
    }
  }
  
  private void reportAsync(int paramInt, LpReportInfo paramLpReportInfo)
  {
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new angk(this, paramInt, paramLpReportInfo));
      return;
    }
    report(paramInt, paramLpReportInfo);
  }
  
  private static void userSample()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("ClientReport", "MachinelearningReportSamples", "0:0");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains(":"))) {
      isSampled = true;
    }
    localObject = ((String)localObject).split(":");
    if (localObject.length != 2) {
      isSampled = true;
    }
    try
    {
      int i = Integer.parseInt(localObject[1]);
      int j = Integer.parseInt(localObject[0]);
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      if (l == 0L) {
        return;
      }
      String str = String.valueOf(l);
      int k = Integer.parseInt(str.substring(str.length() - localObject[1].length(), str.length()));
      if ((j < i) && (k < i) && (k >= j)) {}
      for (isSampled = true;; isSampled = false)
      {
        sampleValidStartTime = getBeijingTimeInMillis(0, 0, 0);
        sampleValidEndTime = getBeijingTimeInMillis(24, 0, 0);
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean needReportExifCameraInfo()
  {
    return this.reportExifCameraInfo;
  }
  
  public void reportToDC02151(LpReport_AlbumInfo_dc02151 paramLpReport_AlbumInfo_dc02151)
  {
    reportAsync(17, paramLpReport_AlbumInfo_dc02151);
  }
  
  public void reportToDC02153(LpReport_PicInfo_dc02153 paramLpReport_PicInfo_dc02153)
  {
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper())) {
      QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new angj(this, paramLpReport_PicInfo_dc02153));
    }
    while (paramLpReport_PicInfo_dc02153 == null) {
      return;
    }
    paramLpReport_PicInfo_dc02153.recheckIfNeed();
    reportAsync(16, paramLpReport_PicInfo_dc02153);
  }
  
  public void reportToDC02283(LpReport_TagInfo_dc02283 paramLpReport_TagInfo_dc02283)
  {
    reportAsync(20, paramLpReport_TagInfo_dc02283);
  }
  
  public void reportToDC02478(LpReport_ShuoshuoBehavior_dc02478 paramLpReport_ShuoshuoBehavior_dc02478)
  {
    reportAsync(30, paramLpReport_ShuoshuoBehavior_dc02478);
  }
  
  public void reportToDC02506(LpReport_ImgPreload_dc02506 paramLpReport_ImgPreload_dc02506)
  {
    reportAsync(31, paramLpReport_ImgPreload_dc02506);
  }
  
  public void startReportImediately()
  {
    if (!isUserNeedReport()) {
      return;
    }
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new angl(this));
      return;
    }
    report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.MachinelearningReport
 * JD-Core Version:    0.7.0.1
 */