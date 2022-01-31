package com.tencent.mobileqq.olympic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import awci;
import awni;
import bdgk;
import bdin;
import bdpd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageRespInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.apache.http.util.ByteArrayBuffer;
import tencent.im.new_year_2014.PackData.Pack;
import tencent.im.new_year_2014.PackServer.GetNewPackReq;
import tencent.im.new_year_2014.PackServer.GetNewPackResp;
import tencent.im.new_year_2014.PackServer.PkgReq;
import tencent.im.new_year_2014.PackServer.PkgResp;
import tencent.im.new_year_2014.Unisso.UniSsoServerReq;
import tencent.im.new_year_2014.Unisso.UniSsoServerRsp;
import tencent.im.new_year_report.PackReport.PkgReq;
import tencent.im.new_year_report.PackReport.PkgResp;
import tencent.im.new_year_report.PackReport.Report;
import tencent.im.new_year_report.PackReport.ReportElem;

public class OlympicServlet
  extends MSFServlet
{
  private static int a;
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, paramInt, 0, 0, null, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramAppRuntime == null)
    {
      awci.b("OlympicServlet", new Object[] { "reportConfig, runtime is null" });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OlympicServlet", 2, "reportConfig,type=" + paramInt1 + ",version=" + paramInt2 + ",taskId=" + paramInt3 + ",operationType= " + paramInt4 + ", result=" + paramInt5);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), OlympicServlet.class);
    localNewIntent.putExtra("k_cmd", 3);
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_version", paramInt2);
    localNewIntent.putExtra("k_taskid", paramInt3);
    localNewIntent.putExtra("k_opt", paramInt4);
    localNewIntent.putExtra("k_code", paramInt5);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicServlet", 2, "getConfig,version=" + paramInt1 + ", offset=" + paramInt2 + ", taskId=" + paramInt3 + ",cookie=" + paramArrayOfByte1 + ",buffer=" + paramArrayOfByte2);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong, ArrayList<OlympicServlet.ReportRecord> paramArrayList1, ArrayList<OlympicServlet.ReportRecord> paramArrayList2, ArrayList<OlympicServlet.ReportRecord> paramArrayList3, ArrayList<OlympicServlet.ReportRecord> paramArrayList4, ArrayList<OlympicServlet.ReportRecord> paramArrayList5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicServlet", 2, "reportShuayishua, promotion_id=" + paramLong + ",normalList=" + paramArrayList1 + ",activeList=" + paramArrayList2 + ",emptyList=" + paramArrayList3 + ",gainList=" + paramArrayList4 + ",comboList=" + paramArrayList5);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), OlympicServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_id", (int)paramLong);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("k_normal", paramArrayList1);
    localBundle.putSerializable("k_active", paramArrayList2);
    localBundle.putSerializable("k_empty", paramArrayList3);
    localBundle.putSerializable("k_gain", paramArrayList4);
    localBundle.putSerializable("k_combo", paramArrayList5);
    localNewIntent.putExtras(localBundle);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramIntent.getIntExtra("k_cmd", -1);
    boolean bool = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("OlympicServlet", 2, "onReceive, cmd = " + j + ",success=" + bool);
    }
    label106:
    int k;
    label466:
    label627:
    int m;
    if (bool)
    {
      Object localObject1 = bdpd.b(paramFromServiceMsg.getWupBuffer());
      switch (j)
      {
      default: 
        paramFromServiceMsg = null;
      case 1: 
      case 2: 
        for (;;)
        {
          localObject1 = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            localObject1 = new Bundle();
          }
          notifyObserver(paramIntent, j, bool, (Bundle)localObject1, OlympicManager.class);
          return;
          try
          {
            paramFromServiceMsg = new Bundle();
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              Object localObject3;
              long l;
              OlympicManager localOlympicManager;
              ConfigurationService.RespGetConfigByPage localRespGetConfigByPage;
              ConfigurationService.PageRespInfo localPageRespInfo;
              Object localObject2;
              paramFromServiceMsg = null;
            }
          }
          try
          {
            i = paramIntent.getIntExtra("k_id", -1);
            localObject3 = new Unisso.UniSsoServerRsp();
            ((Unisso.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject1);
            l = ((Unisso.UniSsoServerRsp)localObject3).ret.get();
            if (QLog.isColorLevel()) {
              QLog.d("OlympicServlet", 2, "onReceive, UniSsoServerRsp.result = " + l);
            }
            if (l == 0L)
            {
              localObject1 = new PackServer.PkgResp();
              ((PackServer.PkgResp)localObject1).mergeFrom(((Unisso.UniSsoServerRsp)localObject3).rspdata.get().toByteArray());
              k = ((PackServer.PkgResp)localObject1).errcode.get();
              paramFromServiceMsg.putInt("k_code", k);
              paramFromServiceMsg.putInt("k_id", i);
              if (((PackServer.PkgResp)localObject1).grab_interval.has()) {
                paramFromServiceMsg.putLong("k_interval", ((PackServer.PkgResp)localObject1).grab_interval.get());
              }
              if (((PackServer.PkgResp)localObject1).report_active_interval.has()) {
                paramFromServiceMsg.putLong("k_active_interval", ((PackServer.PkgResp)localObject1).report_active_interval.get());
              }
              if (((PackServer.PkgResp)localObject1).report_normal_interval.has()) {
                paramFromServiceMsg.putLong("k_normal_interval", ((PackServer.PkgResp)localObject1).report_normal_interval.get());
              }
              if (k == 0)
              {
                localObject1 = (PackData.Pack)((PackServer.GetNewPackResp)((PackServer.PkgResp)localObject1).get_new_pack.get()).data.get();
                if (localObject1 != null)
                {
                  if (((PackData.Pack)localObject1).pack_id.has()) {
                    paramFromServiceMsg.putByteArray("k_pack_id", ((PackData.Pack)localObject1).pack_id.get().toByteArray());
                  }
                  if (((PackData.Pack)localObject1).business.has()) {
                    paramFromServiceMsg.putInt("k_business", ((PackData.Pack)localObject1).business.get());
                  }
                  if (((PackData.Pack)localObject1).signature.has()) {
                    paramFromServiceMsg.putByteArray("k_sig", ((PackData.Pack)localObject1).signature.get().toByteArray());
                  }
                }
              }
              continue;
            }
            bool = true;
            break label466;
            localOlympicManager = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(167);
            localRespGetConfigByPage = new ConfigurationService.RespGetConfigByPage();
            localRespGetConfigByPage.mergeFrom((byte[])localObject1);
            i = localRespGetConfigByPage.result.get();
            if (QLog.isColorLevel()) {
              QLog.i("OlympicServlet", 2, "onReceive CMD_CONFIG,rslt=" + i);
            }
            paramFromServiceMsg = new Bundle();
            if (i != 0) {}
            try
            {
              localOlympicManager.b();
              paramFromServiceMsg.putInt("k_code", 3);
              a(getAppRuntime(), 1003, 0, 0, 1, i, 0);
            }
            catch (Throwable localThrowable1) {}
            if (localRespGetConfigByPage.type.get() == 1003) {
              break;
            }
            a(getAppRuntime(), 1003, 0, 0, 1, 3, 0);
          }
          catch (Throwable localThrowable3)
          {
            break label627;
          }
          if (QLog.isColorLevel()) {
            QLog.d("OlympicServlet", 2, "", localThrowable1);
          }
          bool = false;
        }
        i = paramIntent.getIntExtra("k_version", -1);
        k = ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).version.get();
        m = paramIntent.getIntExtra("k_offset", 0);
        if (QLog.isColorLevel())
        {
          QLog.i("OlympicServlet", 2, "onReceive,reqOffset=" + m + ",reqVersion=" + i + ", rspVersion=" + k);
          break;
          label744:
          localOlympicManager.b();
          localPageRespInfo = (ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get();
          localObject2 = paramIntent.getByteArrayExtra("k_buffer");
          localObject3 = localRespGetConfigByPage.content.get().toByteArray();
          if (localObject2 == null) {
            break label1573;
          }
        }
        break;
      }
    }
    label1545:
    label1573:
    for (int i = localObject2.length;; i = 0)
    {
      Object localObject4 = new ByteArrayBuffer(i + localObject3.length);
      if (localObject2 != null) {
        ((ByteArrayBuffer)localObject4).append((byte[])localObject2, 0, localObject2.length);
      }
      ((ByteArrayBuffer)localObject4).append((byte[])localObject3, 0, localObject3.length);
      localObject3 = ((ByteArrayBuffer)localObject4).buffer();
      i = localPageRespInfo.next_offset.get();
      if (i == -1)
      {
        localObject2 = localPageRespInfo.md5.get();
        localObject4 = awni.a((byte[])localObject3);
        i = localPageRespInfo.total_size.get();
        if (QLog.isColorLevel()) {
          QLog.i("OlympicServlet", 2, "onReceive,respSize=" + i + ",md5=" + (String)localObject2 + ",md5Cal=" + (String)localObject4);
        }
        if (i == 0)
        {
          paramFromServiceMsg.putInt("k_code", 3);
        }
        else if (TextUtils.equals((CharSequence)localObject4, (CharSequence)localObject2))
        {
          localObject2 = localObject3;
          if (localPageRespInfo.compress.get() == 1) {
            localObject2 = a((byte[])localObject3);
          }
          if (localObject2 == null)
          {
            if (localPageRespInfo.report.get() == 1) {
              a(getAppRuntime(), 1003, k, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 4, 0);
            }
          }
          else
          {
            localObject3 = null;
            if (localRespGetConfigByPage.delay_time.has()) {
              localObject3 = (ArrayList)localRespGetConfigByPage.delay_time.get();
            }
            localObject2 = OlympicManager.a(new String((byte[])localObject2, "utf-8"), k, (ArrayList)localObject3);
            if (localObject2 == null)
            {
              if (localPageRespInfo.report.get() == 1) {
                a(getAppRuntime(), 1003, k, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 5, 0);
              }
            }
            else
            {
              if (localPageRespInfo.report.get() == 1) {
                a(getAppRuntime(), 1003, k, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 0, 0);
              }
              localOlympicManager.a((OlyimpicConfig)localObject2);
              paramFromServiceMsg.putParcelable("k_config", (Parcelable)localObject2);
            }
          }
        }
        else if (localPageRespInfo.report.get() == 1)
        {
          a(getAppRuntime(), 1003, k, ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get(), 1, 6, 0);
        }
      }
      else if (i != 0)
      {
        a(getAppRuntime(), k, localPageRespInfo.next_offset.get(), localPageRespInfo.task_id.get(), localPageRespInfo.cookies.get().toByteArray(), (byte[])localObject3);
        return;
      }
      do
      {
        paramFromServiceMsg.putInt("k_code", 2);
        break label1545;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramFromServiceMsg = new ConfigurationService.RespReportConfig();
        paramFromServiceMsg.mergeFrom((byte[])localObject2);
        i = paramFromServiceMsg.result.get();
        QLog.i("OlympicServlet", 2, "onReceive.CMD_REPORT.result=" + i);
        paramFromServiceMsg = null;
        break label106;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramFromServiceMsg = new Unisso.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom((byte[])localObject2);
        l = paramFromServiceMsg.ret.get();
        QLog.i("OlympicServlet", 2, "onReceive, CMD_SHUAYISHUA_REPORT.UniSsoServerRsp.result = " + l);
        if (l == 0L)
        {
          localObject2 = new PackReport.PkgResp();
          ((PackReport.PkgResp)localObject2).mergeFrom(paramFromServiceMsg.rspdata.get().toByteArray());
          i = ((PackReport.PkgResp)localObject2).retcode.get();
          paramFromServiceMsg = ((PackReport.PkgResp)localObject2).retmsg.get();
          QLog.i("OlympicServlet", 2, "onReceive, CMD_SHUAYISHUA_REPORT.errCode = " + i + ",errMsg=" + paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
        break label106;
        if (j == 2) {
          a(getAppRuntime(), 1003, 0, 0, 1, 1, 0);
        }
        paramFromServiceMsg = null;
        break label106;
        break label106;
        if ((m == 0) && (i != k)) {
          break label744;
        }
      } while ((m == 0) || (i != k));
      break label744;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = null;
    int i = paramIntent.getIntExtra("k_cmd", -1);
    Object localObject1;
    switch (i)
    {
    default: 
      localObject1 = null;
      paramIntent = (Intent)localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicServlet", 2, "onSend.cmd=" + i + ",ssoCmd=" + (String)localObject1 + ",ssoData " + paramIntent);
      }
      if ((localObject1 != null) && (paramIntent != null))
      {
        paramPacket.setSSOCommand((String)localObject1);
        paramPacket.putSendData(paramIntent);
      }
      Object localObject3;
      do
      {
        return;
        localObject1 = new Unisso.UniSsoServerReq();
        localObject2 = new PackServer.PkgReq();
        ((PackServer.PkgReq)localObject2).cmdtype.set(1);
        ((PackServer.PkgReq)localObject2).net_type.set(bdin.a(BaseApplicationImpl.sApplication));
        localObject3 = paramIntent.getStringExtra("k_uin");
        ((PackServer.PkgReq)localObject2).uin.set(Long.parseLong((String)localObject3));
        ((PackServer.PkgReq)localObject2).from_id.set(1);
        int j = a + 1;
        a = j;
        int k = paramIntent.getIntExtra("k_id", -1);
        paramIntent = new PackServer.GetNewPackReq();
        paramIntent.promotion_id.set(k);
        paramIntent.seq.set(j);
        paramIntent.signature.set(ByteStringMicro.copyFrom(((String)localObject3 + k + j).getBytes()));
        ((PackServer.PkgReq)localObject2).get_new_pack.set(paramIntent);
        ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackServer.PkgReq)localObject2).toByteArray()));
        paramIntent = bdpd.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
        localObject1 = "NY2015.get_new_pack";
        break;
        j = paramIntent.getIntExtra("k_taskid", 0);
        k = paramIntent.getIntExtra("k_offset", 0);
        int m = paramIntent.getIntExtra("k_version", 0);
        localObject1 = paramIntent.getByteArrayExtra("k_cookie");
        paramIntent = new ConfigurationService.ReqGetConfigByPage();
        localObject2 = new ConfigurationService.PageReqInfo();
        ((ConfigurationService.PageReqInfo)localObject2).task_id.set(j);
        ((ConfigurationService.PageReqInfo)localObject2).offset.set(k);
        ((ConfigurationService.PageReqInfo)localObject2).version.set(m);
        if (localObject1 != null) {
          ((ConfigurationService.PageReqInfo)localObject2).cookies.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        paramIntent.page_info.set((MessageMicro)localObject2);
        localObject1 = new ConfigurationService.DeviceInfo();
        localObject2 = new ConfigurationService.Screen();
        ((ConfigurationService.Screen)localObject2).setHasFlag(true);
        ((ConfigurationService.Screen)localObject2).model.set("");
        ((ConfigurationService.Screen)localObject2).width.set((int)bdgk.g());
        ((ConfigurationService.Screen)localObject2).height.set((int)bdgk.h());
        ((ConfigurationService.Screen)localObject2).dpi.set(bdgk.d());
        ((ConfigurationService.Screen)localObject2).multi_touch.set(bdgk.c());
        ((ConfigurationService.DeviceInfo)localObject1).setHasFlag(true);
        ((ConfigurationService.DeviceInfo)localObject1).screen = ((ConfigurationService.Screen)localObject2);
        paramIntent.device_info.set((MessageMicro)localObject1);
        paramIntent.type.set(1003);
        paramIntent = bdpd.a(paramIntent.toByteArray());
        localObject1 = "ConfigurationService.ReqGetConfigByPage";
        break;
        localObject2 = new ConfigurationService.ReqReportConfig();
        localObject1 = new ConfigurationService.ReportConfig();
        ((ConfigurationService.ReportConfig)localObject1).type.set(paramIntent.getIntExtra("k_type", -1));
        ((ConfigurationService.ReportConfig)localObject1).task_id.set(paramIntent.getIntExtra("k_taskid", -1));
        ((ConfigurationService.ReportConfig)localObject1).version.set(paramIntent.getIntExtra("k_version", -1));
        ((ConfigurationService.ReportConfig)localObject1).report_type.set(paramIntent.getIntExtra("k_opt", -1));
        ((ConfigurationService.ReportConfig)localObject1).result.set(paramIntent.getIntExtra("k_code", -1));
        ((ConfigurationService.ReqReportConfig)localObject2).config_list.add((MessageMicro)localObject1);
        localObject1 = "ConfigurationService.ReqReportConfig";
        paramIntent = bdpd.a(((ConfigurationService.ReqReportConfig)localObject2).toByteArray());
        break;
        localObject1 = new Unisso.UniSsoServerReq();
        localObject2 = new PackReport.PkgReq();
        ((PackReport.PkgReq)localObject2).promotion_id.set(paramIntent.getIntExtra("k_id", -1));
        ((PackReport.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
        long l = NetConnInfoCenter.getServerTimeMillis();
        ((PackReport.PkgReq)localObject2).seq.set(l);
        localObject3 = paramIntent.getExtras();
      } while (localObject3 == null);
      paramIntent = new ArrayList();
      Object localObject5 = (ArrayList)((Bundle)localObject3).getSerializable("k_normal");
      Object localObject6;
      PackReport.ReportElem localReportElem;
      if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
      {
        localObject4 = new PackReport.Report();
        localObject5 = ((ArrayList)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (OlympicServlet.ReportRecord)((Iterator)localObject5).next();
          localReportElem = new PackReport.ReportElem();
          localReportElem.count.set(((OlympicServlet.ReportRecord)localObject6).count);
          localReportElem.timestamp.set(((OlympicServlet.ReportRecord)localObject6).time_stamp);
          ((PackReport.Report)localObject4).elems.add(localReportElem);
        }
        ((PackReport.Report)localObject4).id.set(100L);
        paramIntent.add(localObject4);
      }
      localObject5 = (ArrayList)((Bundle)localObject3).getSerializable("k_active");
      if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
      {
        localObject4 = new PackReport.Report();
        localObject5 = ((ArrayList)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (OlympicServlet.ReportRecord)((Iterator)localObject5).next();
          localReportElem = new PackReport.ReportElem();
          localReportElem.count.set(((OlympicServlet.ReportRecord)localObject6).count);
          localReportElem.timestamp.set(((OlympicServlet.ReportRecord)localObject6).time_stamp);
          ((PackReport.Report)localObject4).elems.add(localReportElem);
        }
        ((PackReport.Report)localObject4).id.set(200L);
        paramIntent.add(localObject4);
      }
      localObject5 = (ArrayList)((Bundle)localObject3).getSerializable("k_empty");
      if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
      {
        localObject4 = new PackReport.Report();
        localObject5 = ((ArrayList)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (OlympicServlet.ReportRecord)((Iterator)localObject5).next();
          localReportElem = new PackReport.ReportElem();
          localReportElem.count.set(((OlympicServlet.ReportRecord)localObject6).count);
          localReportElem.timestamp.set(((OlympicServlet.ReportRecord)localObject6).time_stamp);
          ((PackReport.Report)localObject4).elems.add(localReportElem);
        }
        ((PackReport.Report)localObject4).id.set(300L);
        paramIntent.add(localObject4);
      }
      localObject5 = (ArrayList)((Bundle)localObject3).getSerializable("k_gain");
      if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
      {
        localObject4 = new PackReport.Report();
        localObject5 = ((ArrayList)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (OlympicServlet.ReportRecord)((Iterator)localObject5).next();
          localReportElem = new PackReport.ReportElem();
          localReportElem.count.set(((OlympicServlet.ReportRecord)localObject6).count);
          localReportElem.timestamp.set(((OlympicServlet.ReportRecord)localObject6).time_stamp);
          ((PackReport.Report)localObject4).elems.add(localReportElem);
        }
        ((PackReport.Report)localObject4).id.set(400L);
        paramIntent.add(localObject4);
      }
      Object localObject4 = (ArrayList)((Bundle)localObject3).getSerializable("k_combo");
      if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
      {
        localObject3 = new PackReport.Report();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (OlympicServlet.ReportRecord)((Iterator)localObject4).next();
          localObject6 = new PackReport.ReportElem();
          ((PackReport.ReportElem)localObject6).count.set(((OlympicServlet.ReportRecord)localObject5).count);
          ((PackReport.ReportElem)localObject6).timestamp.set(((OlympicServlet.ReportRecord)localObject5).time_stamp);
          ((PackReport.Report)localObject3).elems.add((MessageMicro)localObject6);
        }
        ((PackReport.Report)localObject3).id.set(500L);
        paramIntent.add(localObject3);
      }
      ((PackReport.PkgReq)localObject2).report.set(paramIntent);
      ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackReport.PkgReq)localObject2).toByteArray()));
      paramIntent = bdpd.a(((Unisso.UniSsoServerReq)localObject1).toByteArray());
      localObject1 = "NewYearReport.pack_report";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicServlet
 * JD-Core Version:    0.7.0.1
 */