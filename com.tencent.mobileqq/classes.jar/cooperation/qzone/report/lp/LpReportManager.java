package cooperation.qzone.report.lp;

import amim;
import amin;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class LpReportManager
{
  public static final String BASE = "LpReport.";
  private static final int DC00518_SUBTALBE = 48;
  public static final int DC02453_SUBTABLE = 32;
  private static final String TAG = "LpReport.LpReportManager";
  private static LpReportManager lpReportManager;
  private static long startTime = ;
  private LpReportInfos storedClicks = new LpReportInfos();
  
  public static boolean fileExists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static LpReportManager getInstance()
  {
    if (lpReportManager == null) {}
    try
    {
      if (lpReportManager == null) {
        lpReportManager = new LpReportManager();
      }
      return lpReportManager;
    }
    finally {}
  }
  
  private void report(int paramInt)
  {
    if ((paramInt == 1) && (QzoneConfig.getInstance().getConfig("ClientReport", "LpReportImediagely", 0) == 1)) {}
    synchronized (this.storedClicks)
    {
      if (!LpReportUtils.meetCondition(this.storedClicks, startTime)) {
        return;
      }
      if (this.storedClicks.isEmpty()) {
        return;
      }
    }
    synchronized (this.storedClicks)
    {
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
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private void report(int paramInt, LpReportInfo paramLpReportInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramLpReportInfo == null) {
      QLog.e("LpReport.LpReportManager", 1, "info=null");
    }
    for (;;)
    {
      return;
      if ((paramBoolean1) && (!LpReportUtils.isNeedReport()))
      {
        LpReportUtils.showToast(paramLpReportInfo, false);
        if (QLog.isColorLevel()) {
          QLog.i("LpReport.LpReportManager", 4, "未被抽中：subtype:" + paramInt + " info:" + LpReportUtils.transMapToString(paramLpReportInfo.toMap()));
        }
      }
      else
      {
        LpReportUtils.showToast(paramLpReportInfo, true);
        if (QLog.isColorLevel()) {
          QLog.i("LpReport.LpReportManager", 4, "isReportNow:" + paramBoolean2 + " subtype:" + paramInt + " isReportNow:" + paramBoolean2 + " info:" + LpReportUtils.transMapToString(paramLpReportInfo.toMap()));
        }
        synchronized (this.storedClicks)
        {
          this.storedClicks.addInfo(paramInt, paramLpReportInfo);
          if (!paramBoolean2)
          {
            if (!LpReportUtils.meetCondition(this.storedClicks, startTime)) {
              continue;
            }
            startReportImediately(3);
          }
        }
      }
    }
    startReportImediately(1);
  }
  
  private void reportAsync(int paramInt, LpReportInfo paramLpReportInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new amim(this, paramInt, paramLpReportInfo, paramBoolean1, paramBoolean2));
      return;
    }
    report(paramInt, paramLpReportInfo, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC001831(LpReportInfo_dc01831 paramLpReportInfo_dc01831, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(13, paramLpReportInfo_dc01831, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC00321(LpReportInfo_dc00321 paramLpReportInfo_dc00321, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(5, paramLpReportInfo_dc00321, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC00420(LpReportInfo_dc00420 paramLpReportInfo_dc00420, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(1, paramLpReportInfo_dc00420, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC00518(LpReportInfo_dc00518 paramLpReportInfo_dc00518, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(48, paramLpReportInfo_dc00518, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC01245(LpReportInfo_dc01245 paramLpReportInfo_dc01245, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(7, paramLpReportInfo_dc01245, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC01500(LpReportInfo_dc01500 paramLpReportInfo_dc01500, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(8, paramLpReportInfo_dc01500, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC01691(LpReportInfo_DC01691 paramLpReportInfo_DC01691, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(11, paramLpReportInfo_DC01691, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC01796(LpReportInfo_DC01796 paramLpReportInfo_DC01796)
  {
    reportAsync(12, paramLpReportInfo_DC01796, false, false);
  }
  
  public void reportToDC02216(LpReportInfo_dc02216 paramLpReportInfo_dc02216, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(40, paramLpReportInfo_dc02216, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC02293(LpReportInfo_DC02293 paramLpReportInfo_DC02293)
  {
    reportAsync(21, paramLpReportInfo_DC02293, false, false);
  }
  
  public void reportToDC02349(LpReportInfo_dc02349 paramLpReportInfo_dc02349, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(22, paramLpReportInfo_dc02349, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC02467(LpReportInfo_dc02467 paramLpReportInfo_dc02467, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(29, paramLpReportInfo_dc02467, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC02543(LpReportInfo_DC02543 paramLpReportInfo_DC02543)
  {
    reportAsync(32, paramLpReportInfo_DC02543, false, false);
  }
  
  public void reportToDC02727(LpReportInfo_dc02727 paramLpReportInfo_dc02727, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(35, paramLpReportInfo_dc02727, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC02795(LpReportInfo_dc02795 paramLpReportInfo_dc02795, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(39, paramLpReportInfo_dc02795, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC02880(LpReportInfo_dc02880 paramLpReportInfo_dc02880, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(43, paramLpReportInfo_dc02880, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC02910(LpreportInfo_dc02910 paramLpreportInfo_dc02910, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(42, paramLpreportInfo_dc02910, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC03179(LpReport_dc03179 paramLpReport_dc03179, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(45, paramLpReport_dc03179, paramBoolean1, paramBoolean2);
  }
  
  public void reportToDC03208(LpReport_Retention_dc03208 paramLpReport_Retention_dc03208, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(47, paramLpReport_Retention_dc03208, paramBoolean1, paramBoolean2);
  }
  
  public void reportToPF00064(LpReportInfo_pf00064 paramLpReportInfo_pf00064)
  {
    reportToPF00064(paramLpReportInfo_pf00064, true, false);
  }
  
  public void reportToPF00064(LpReportInfo_pf00064 paramLpReportInfo_pf00064, boolean paramBoolean1, boolean paramBoolean2)
  {
    reportAsync(0, paramLpReportInfo_pf00064, paramBoolean1, paramBoolean2);
  }
  
  public void startReportImediately(int paramInt)
  {
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new amin(this, paramInt));
      return;
    }
    report(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportManager
 * JD-Core Version:    0.7.0.1
 */