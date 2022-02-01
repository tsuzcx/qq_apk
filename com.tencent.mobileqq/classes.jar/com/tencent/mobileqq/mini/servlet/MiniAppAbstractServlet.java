package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import arbw;
import bhjl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class MiniAppAbstractServlet
  extends MSFServlet
{
  public static final String EXTRA_TIMEOUT = "timeout";
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_APP_STORE_GET_APP_LIST_TYPE = "key_app_store_get_app_list_type";
  public static final String KEY_CMD_NAME = "key_cmd_name";
  public static final String KEY_DATA = "key_data";
  public static final String KEY_LANG = "key_lang";
  public static final String KEY_LINK = "key_link";
  public static final String KEY_LINK_TYPE = "key_link_type";
  public static final String KEY_NUM = "key_num";
  public static final String KEY_PAGE = "key_page";
  public static final String KEY_REPORT_DATA = "reportData";
  private static final String KEY_SSO_CMD_START_TIME_MILLIS = "key_sso_cmd_start_time_millis";
  public static final String KEY_UIN = "key_uin";
  public static final String KEY_VERSION = "key_version";
  public static final String KEY_WITH_CREDENTIAL = "key_with_credential";
  public static final String TAG = "MiniAppAbstractServlet";
  private MiniAppConfig miniAppConfig;
  protected int observerId;
  private String page;
  private boolean shouldPerformDCReport = true;
  
  private void reportSSOResult(Intent paramIntent, int paramInt1, String paramString, int paramInt2)
  {
    MiniAppConfig localMiniAppConfig;
    String str2;
    String str1;
    String str3;
    if (this.shouldPerformDCReport)
    {
      localMiniAppConfig = this.miniAppConfig;
      str2 = this.page;
      if (paramIntent == null) {
        break label87;
      }
      str1 = paramIntent.getStringExtra("traceid");
      str3 = MiniReportManager.getAppType(this.miniAppConfig);
      if ((paramIntent == null) || (!paramIntent.hasExtra("key_sso_cmd_start_time_millis"))) {
        break label93;
      }
    }
    label87:
    label93:
    for (long l = System.currentTimeMillis() - paramIntent.getLongExtra("key_sso_cmd_start_time_millis", System.currentTimeMillis());; l = 0L)
    {
      MiniReportManager.reportEventType(localMiniAppConfig, paramInt1, str2, str1, paramString, paramInt2, str3, l, null);
      return;
      str1 = null;
      break;
    }
  }
  
  protected void doReport(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str;
    int i;
    if (paramFromServiceMsg != null)
    {
      str = paramFromServiceMsg.getServiceCmd();
      if (paramFromServiceMsg == null) {
        break label105;
      }
      i = paramFromServiceMsg.getResultCode();
      label19:
      reportSSOResult(paramIntent, 601, str, i);
      if (paramFromServiceMsg != null)
      {
        str = paramFromServiceMsg.getServiceCmd();
        if (paramIntent == null) {
          break label110;
        }
      }
    }
    label105:
    label110:
    for (paramIntent = paramIntent.getStringExtra("traceid");; paramIntent = null)
    {
      QLog.i("miniapp-cmd", 1, "receive response cmd=" + str + " resultCode=" + paramFromServiceMsg.getResultCode() + " traceId=" + paramIntent);
      return;
      str = null;
      break;
      i = 0;
      break label19;
    }
  }
  
  protected String getTraceId()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte) {}
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg == null) {
          continue;
        }
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bhjl.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        localBundle.putString("key_appid", String.valueOf(paramFromServiceMsg.getAppId()));
        long l = localStQWebRsp.retCode.get();
        if (l != 0L) {
          continue;
        }
        onProcessData(paramIntent, localBundle, localStQWebRsp.busiBuff.get().toByteArray());
        reportSSOResult(paramIntent, 599, paramFromServiceMsg.getServiceCmd(), (int)l);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("MiniAppAbstractServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppAbstractServlet", 2, "onReceive. " + MiniAppObserver.getCmdByObserverId(this.observerId) + " failed: " + paramFromServiceMsg.getBusinessFailCode() + "  errMsg:" + paramFromServiceMsg.getBusinessFailMsg());
        localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
        localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppAbstractServlet", 2, "onReceive. inform  resultcode fail.");
        notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
      QLog.d("MiniAppAbstractServlet", 2, "onReceive. " + MiniAppObserver.getCmdByObserverId(this.observerId) + " failed : retCode: " + localStQWebRsp.retCode.get() + "  errMsg:" + localStQWebRsp.errMsg.get().toStringUtf8());
    }
  }
  
  @CallSuper
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = null;
    int i = arbw.a("MiniAppMsfTimeoutValue", 10000);
    if (paramPacket != null) {
      paramPacket.setTimeout(i);
    }
    for (paramPacket = paramPacket.toMsg();; paramPacket = null)
    {
      String str1;
      String str2;
      if ((this.shouldPerformDCReport) && (paramPacket != null))
      {
        str1 = paramPacket.getServiceCmd();
        str2 = paramIntent.getStringExtra("key_appid");
        this.page = paramIntent.getStringExtra("key_page");
        paramIntent.putExtra("key_sso_cmd_start_time_millis", System.currentTimeMillis());
        if ((!TextUtils.isEmpty(str2)) && (!"0000000000".equals(str2))) {
          break label178;
        }
        this.miniAppConfig = MiniProgramReportHelper.miniAppConfigForPreload();
      }
      for (;;)
      {
        MiniReportManager.reportEventType(this.miniAppConfig, 600, this.page, null, str1, 0);
        if (paramPacket != null)
        {
          str1 = paramPacket.getServiceCmd();
          paramPacket = localObject;
          if (paramIntent != null) {
            paramPacket = paramIntent.getStringExtra("traceid");
          }
          QLog.i("miniapp-cmd", 1, "send request cmd=" + str1 + " traceId=" + paramPacket);
        }
        return;
        label178:
        MiniAppInfo localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = str2;
        this.miniAppConfig = new MiniAppConfig(localMiniAppInfo);
        this.miniAppConfig.launchParam = new LaunchParam();
        this.miniAppConfig.launchParam.miniAppId = str2;
      }
    }
  }
  
  public void setShouldPerformDCReport(boolean paramBoolean)
  {
    this.shouldPerformDCReport = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
 * JD-Core Version:    0.7.0.1
 */