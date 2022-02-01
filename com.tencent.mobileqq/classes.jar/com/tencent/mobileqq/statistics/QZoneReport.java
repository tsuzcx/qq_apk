package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneReport
{
  public static int a = 0;
  public static boolean b = false;
  private static int c = 2;
  private static int d;
  private static AtomicInteger e = new AtomicInteger(2);
  private static AtomicBoolean f;
  private static AtomicLong g;
  private static long h;
  private static int i;
  private static int j;
  private static Calendar k;
  private static QZoneReport.QzoneGetPublicMsgObserver l;
  
  static
  {
    a = 3;
    f = new AtomicBoolean(false);
    g = new AtomicLong();
    k = Calendar.getInstance();
    l = new QZoneReport.QzoneGetPublicMsgObserver();
  }
  
  public static int a()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = ((AppRuntime)localObject2).getAccount();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "qzone report with empty account");
      }
      return -1;
    }
    if (!((IPublicAccountDataManager)((AppRuntime)localObject2).getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(Long.parseLong("2290230341"))))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "haven't yet follow qzone");
      }
      return -1;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject3;
    if (h == 0L)
    {
      localObject2 = BaseApplicationImpl.getApplication().getRuntime().getPreferences();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("qzone_xp_max_req");
      c = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject3).toString(), 2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("qzone_xp_first_req");
      h = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject3).toString(), l1);
      localObject3 = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("_");
      localStringBuilder.append("qzone_xp_req_left");
      ((AtomicInteger)localObject3).set(((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), c));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("qzone_xp_req_gap");
      a = ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject3).toString(), 3);
      k.setTimeInMillis(h * 1000L);
      i = k.get(5);
      j = 0;
      f.set(false);
    }
    if ((j < 5) && (!f.get()))
    {
      localObject2 = k;
      long l2 = l1 * 1000L;
      ((Calendar)localObject2).setTimeInMillis(l2);
      if (k.get(5) != i)
      {
        h = l1;
        e.set(c);
        localObject2 = BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append("qzone_xp_req_left");
        localObject2 = ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), c);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append("qzone_xp_first_req");
        ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), h).apply();
      }
      if (e.get() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QZoneReport", 2, "left: 0");
        }
        localObject1 = k;
        ((Calendar)localObject1).set(5, ((Calendar)localObject1).get(5) + 1);
        k.set(11, 0);
        k.set(12, 0);
        k.set(13, 0);
        return (int)((k.getTimeInMillis() - l2) / 1000L);
      }
      return Math.max(0, (int)(d - l1));
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("retry: ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", sending: ");
      ((StringBuilder)localObject1).append(f.get());
      QLog.w("QZoneReport", 2, ((StringBuilder)localObject1).toString());
    }
    return -1;
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt == 1) && (b)) {
      return;
    }
    if (paramInt == 1) {
      b = true;
    }
    LpReportInfo_dc02880 localLpReportInfo_dc02880 = new LpReportInfo_dc02880(6, paramInt);
    LpReportManager.getInstance().reportToDC02880(localLpReportInfo_dc02880, false, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    RemoteHandleManager.getInstance().addWebEventListener(new QZoneReport.1(paramQQAppInterface));
    long l1 = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME", 0L);
    QLog.d("[PhotoAlbum]QZoneReport", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME lastUpdateTime:", Long.valueOf(l1) });
    RemoteHandleManager.getInstance().getSender().getTravelGroup(l1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt, String paramString)
  {
    int m = paramConfig.version.get();
    int n = SharedPreUtils.c(paramQQAppInterface.getApp(), "qzone_xp_config_version", paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneReport", 2, String.format(Locale.getDefault(), "received qzone xp Config remote version: %d, localVersion: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(n) }));
    }
    if (m != n)
    {
      paramConfig = ConfigServlet.b(paramConfig, n, paramInt);
      if (!TextUtils.isEmpty(paramConfig))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs|type: ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(",content: ");
          localStringBuilder.append(paramConfig);
          localStringBuilder.append(",version: ");
          localStringBuilder.append(m);
          QLog.i("QZoneReport", 2, localStringBuilder.toString());
        }
        try
        {
          paramInt = Math.max(0, c - e.get());
          paramConfig = new JSONObject(paramConfig);
          c = paramConfig.optInt("maxReq", 2);
          e.set(Math.max(0, c - paramInt));
          a = paramConfig.optInt("reqGap", 3);
          paramConfig = BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("_");
          localStringBuilder.append("qzone_xp_max_req");
          paramConfig = paramConfig.putInt(localStringBuilder.toString(), c);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("_");
          localStringBuilder.append("qzone_xp_req_gap");
          paramConfig = paramConfig.putInt(localStringBuilder.toString(), a);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("_");
          localStringBuilder.append("qzone_xp_req_left");
          paramConfig.putInt(localStringBuilder.toString(), e.get()).apply();
        }
        catch (JSONException paramConfig)
        {
          if (QLog.isDevelopLevel()) {
            paramConfig.printStackTrace();
          }
        }
        SharedPreUtils.a(paramQQAppInterface.getApp(), "qzone_xp_config_version", paramString, m);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneReport", 2, "config is null");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("QZoneReport", 2, "config version not updated, nothing to do");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneReport", 2, "sending");
    }
    f.set(true);
    g.set(NetConnInfoCenter.getServerTime());
    IQzoneReq localIQzoneReq = (IQzoneReq)QRoute.api(IQzoneReq.class);
    QZoneReport.QzoneGetPublicMsgObserver localQzoneGetPublicMsgObserver = l;
    long l1 = paramQQAppInterface.getLongAccountUin();
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    localIQzoneReq.sentGetPublicMsgServlet(paramQQAppInterface, localQzoneGetPublicMsgObserver, l1, str);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800915C", "0X800915C", 0, 0, "", "", "", "");
  }
  
  public static void b()
  {
    h = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QZoneReport
 * JD-Core Version:    0.7.0.1
 */