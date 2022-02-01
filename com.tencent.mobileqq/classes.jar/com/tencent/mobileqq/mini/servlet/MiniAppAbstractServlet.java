package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
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
  public static final String KEY_CODE = "key_code";
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
  protected int observerId = 0;
  private String page;
  private boolean shouldPerformDCReport = true;
  
  private void reportSSOResult(Intent paramIntent, int paramInt1, String paramString, int paramInt2)
  {
    if (this.shouldPerformDCReport)
    {
      MiniAppConfig localMiniAppConfig = this.miniAppConfig;
      String str2 = this.page;
      String str1;
      if (paramIntent != null) {
        str1 = paramIntent.getStringExtra("traceid");
      } else {
        str1 = null;
      }
      String str3 = MiniReportManager.getAppType(this.miniAppConfig);
      long l;
      if ((paramIntent != null) && (paramIntent.hasExtra("key_sso_cmd_start_time_millis"))) {
        l = System.currentTimeMillis() - paramIntent.getLongExtra("key_sso_cmd_start_time_millis", System.currentTimeMillis());
      } else {
        l = 0L;
      }
      MiniReportManager.reportEventType(localMiniAppConfig, paramInt1, str2, str1, paramString, paramInt2, str3, l, null);
    }
  }
  
  protected void doReport(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramFromServiceMsg != null) {
      localObject1 = paramFromServiceMsg.getServiceCmd();
    } else {
      localObject1 = null;
    }
    int i;
    if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    } else {
      i = 0;
    }
    reportSSOResult(paramIntent, 601, (String)localObject1, i);
    if (paramFromServiceMsg != null)
    {
      String str = paramFromServiceMsg.getServiceCmd();
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getStringExtra("traceid");
      }
      paramIntent = new StringBuilder();
      paramIntent.append("receive response cmd=");
      paramIntent.append(str);
      paramIntent.append(" resultCode=");
      paramIntent.append(paramFromServiceMsg.getResultCode());
      paramIntent.append(" traceId=");
      paramIntent.append((String)localObject1);
      QLog.i("miniapp-cmd", 1, paramIntent.toString());
    }
  }
  
  protected String getTraceId()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append(System.currentTimeMillis() % 1000L);
    localStringBuilder.append("_");
    localStringBuilder.append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte) {}
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        Object localObject;
        if (bool)
        {
          localObject = new PROTOCAL.StQWebRsp();
          ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          localBundle.putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject).Seq.get());
          localBundle.putLong("retCode", ((PROTOCAL.StQWebRsp)localObject).retCode.get());
          localBundle.putString("errMsg", ((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
          localBundle.putString("key_appid", String.valueOf(paramFromServiceMsg.getAppId()));
          long l = ((PROTOCAL.StQWebRsp)localObject).retCode.get();
          if (l == 0L)
          {
            onProcessData(paramIntent, localBundle, ((PROTOCAL.StQWebRsp)localObject).busiBuff.get().toByteArray());
          }
          else
          {
            notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReceive. ");
            localStringBuilder.append(MiniAppObserver.getCmdByObserverId(this.observerId));
            localStringBuilder.append(" failed : retCode: ");
            localStringBuilder.append(((PROTOCAL.StQWebRsp)localObject).retCode.get());
            localStringBuilder.append("  errMsg:");
            localStringBuilder.append(((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
            QLog.d("MiniAppAbstractServlet", 2, localStringBuilder.toString());
          }
          reportSSOResult(paramIntent, 599, paramFromServiceMsg.getServiceCmd(), (int)l);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onReceive. ");
            ((StringBuilder)localObject).append(MiniAppObserver.getCmdByObserverId(this.observerId));
            ((StringBuilder)localObject).append(" failed: ");
            ((StringBuilder)localObject).append(paramFromServiceMsg.getBusinessFailCode());
            ((StringBuilder)localObject).append("  errMsg:");
            ((StringBuilder)localObject).append(paramFromServiceMsg.getBusinessFailMsg());
            QLog.d("MiniAppAbstractServlet", 2, ((StringBuilder)localObject).toString());
          }
          localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
          localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
          notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppAbstractServlet", 2, "onReceive. inform  resultcode fail.");
        }
        notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localThrowable);
      localStringBuilder.append("onReceive error");
      QLog.e("MiniAppAbstractServlet", 1, localStringBuilder.toString());
      notifyObserver(paramIntent, this.observerId, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  @CallSuper
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = MiniAppConfProcessor.a("MiniAppMsfTimeoutValue", 10000);
    Object localObject = null;
    if (paramPacket != null)
    {
      paramPacket.setTimeout(i);
      paramPacket = paramPacket.toMsg();
    }
    else
    {
      paramPacket = null;
    }
    String str1;
    if ((this.shouldPerformDCReport) && (paramPacket != null))
    {
      str1 = paramPacket.getServiceCmd();
      String str2 = paramIntent.getStringExtra("key_appid");
      this.page = paramIntent.getStringExtra("key_page");
      paramIntent.putExtra("key_sso_cmd_start_time_millis", System.currentTimeMillis());
      if ((!TextUtils.isEmpty(str2)) && (!"0000000000".equals(str2)))
      {
        MiniAppInfo localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = str2;
        this.miniAppConfig = new MiniAppConfig(localMiniAppInfo);
        this.miniAppConfig.launchParam = new LaunchParam();
        this.miniAppConfig.launchParam.miniAppId = str2;
      }
      else
      {
        this.miniAppConfig = MiniProgramReportHelper.miniAppConfigForPreload();
      }
      MiniReportManager.reportEventType(this.miniAppConfig, 600, this.page, null, str1, 0);
    }
    if (paramPacket != null)
    {
      str1 = paramPacket.getServiceCmd();
      paramPacket = localObject;
      if (paramIntent != null) {
        paramPacket = paramIntent.getStringExtra("traceid");
      }
      paramIntent = new StringBuilder();
      paramIntent.append("send request cmd=");
      paramIntent.append(str1);
      paramIntent.append(" traceId=");
      paramIntent.append(paramPacket);
      QLog.i("miniapp-cmd", 1, paramIntent.toString());
    }
  }
  
  public void setShouldPerformDCReport(boolean paramBoolean)
  {
    this.shouldPerformDCReport = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
 * JD-Core Version:    0.7.0.1
 */