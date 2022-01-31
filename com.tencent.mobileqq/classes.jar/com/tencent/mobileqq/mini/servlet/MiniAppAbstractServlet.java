package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import amtb;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import bbma;
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
  
  protected void doReport(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str1;
    String str2;
    label41:
    int i;
    label50:
    long l;
    if (this.shouldPerformDCReport)
    {
      MiniAppConfig localMiniAppConfig = this.miniAppConfig;
      String str3 = this.page;
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("traceid");
        if (paramFromServiceMsg == null) {
          break label182;
        }
        str2 = paramFromServiceMsg.getServiceCmd();
        if (paramFromServiceMsg == null) {
          break label188;
        }
        i = paramFromServiceMsg.getResultCode();
        String str4 = MiniReportManager.getAppType(this.miniAppConfig);
        if ((paramIntent == null) || (!paramIntent.hasExtra("key_sso_cmd_start_time_millis"))) {
          break label193;
        }
        l = System.currentTimeMillis() - paramIntent.getLongExtra("key_sso_cmd_start_time_millis", System.currentTimeMillis());
        label87:
        MiniReportManager.reportEventType(localMiniAppConfig, 601, str3, str1, str2, i, str4, l, null);
      }
    }
    else if (paramFromServiceMsg != null)
    {
      str1 = paramFromServiceMsg.getServiceCmd();
      if (paramIntent == null) {
        break label199;
      }
    }
    label182:
    label188:
    label193:
    label199:
    for (paramIntent = paramIntent.getStringExtra("traceid");; paramIntent = null)
    {
      QLog.i("miniapp-cmd", 1, "receive response cmd=" + str1 + " resultCode=" + paramFromServiceMsg.getResultCode() + " traceId=" + paramIntent);
      return;
      str1 = null;
      break;
      str2 = null;
      break label41;
      i = 0;
      break label50;
      l = 0L;
      break label87;
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
        localStQWebRsp.mergeFrom(bbma.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        localBundle.putString("key_appid", String.valueOf(paramFromServiceMsg.getAppId()));
        if (localStQWebRsp.retCode.get() != 0L) {
          continue;
        }
        onProcessData(paramIntent, localBundle, localStQWebRsp.busiBuff.get().toByteArray());
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
    paramPacket.setTimeout(amtb.a("MiniAppMsfTimeoutValue", 8000));
    if (paramPacket != null) {}
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
          break label174;
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
        label174:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
 * JD-Core Version:    0.7.0.1
 */