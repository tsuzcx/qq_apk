package com.tencent.mobileqq.comment;

import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.comment.danmaku.api.IDanmakuDecode;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea.GetBarrageListReqBody;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea.GetBarrageListRspBody;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea.ReqBody;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea.RspBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DanmuDataServlet
  extends MSFServlet
{
  private oidb_0xdea.GetBarrageListRspBody a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getWupBuffer();
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return null;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      localObject1 = ByteBuffer.wrap((byte[])localObject1);
      Object localObject2 = new byte[((ByteBuffer)localObject1).getInt() - 4];
      ((ByteBuffer)localObject1).get((byte[])localObject2);
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])localObject2);
        int i = paramFromServiceMsg.uint32_result.get();
        localObject1 = paramFromServiceMsg.str_error_msg.get();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" oidbHeader: ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" errorStr: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseDanmuRspBody, errorStr:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("DanmuDataHolder", 2, ((StringBuilder)localObject2).toString());
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        try
        {
          localObject1 = new oidb_0xdea.RspBody();
          ((oidb_0xdea.RspBody)localObject1).mergeFrom(paramFromServiceMsg);
          paramFromServiceMsg = (oidb_0xdea.GetBarrageListRspBody)((oidb_0xdea.RspBody)localObject1).get_barrage_list_rsp.get();
          return paramFromServiceMsg;
        }
        catch (Exception paramFromServiceMsg)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseDanmuRspBody, e: ");
          ((StringBuilder)localObject1).append(paramFromServiceMsg);
          QLog.d("DanmuDataHolder", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseDanmuRspBody: mergeFrom:");
        ((StringBuilder)localObject1).append(paramFromServiceMsg);
        QLog.d("DanmuDataHolder", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void a(DanmuDataHolder.CacheHolder paramCacheHolder, oidb_0xdea.GetBarrageListRspBody paramGetBarrageListRspBody)
  {
    int i = paramGetBarrageListRspBody.int32_ret_code.get();
    Object localObject = paramGetBarrageListRspBody.str_err_msg.get();
    String str = paramGetBarrageListRspBody.str_wording.get();
    boolean bool = paramGetBarrageListRspBody.bool_is_end.get();
    int j = paramGetBarrageListRspBody.uint32_total_count.get();
    int k = paramGetBarrageListRspBody.uint32_next_start_index.get();
    List localList1 = paramGetBarrageListRspBody.rpt_comment_list.get();
    List localList2 = paramGetBarrageListRspBody.rpt_recall_del_seq_list.get();
    int m = paramGetBarrageListRspBody.uint32_last_update_time.get();
    int n = paramGetBarrageListRspBody.uint32_time_interval.get();
    if (QLog.isColorLevel())
    {
      paramGetBarrageListRspBody = new StringBuilder();
      paramGetBarrageListRspBody.append("lastUpdateTime:");
      paramGetBarrageListRspBody.append(m);
      paramGetBarrageListRspBody.append(", intervalTime:");
      paramGetBarrageListRspBody.append(n);
      paramGetBarrageListRspBody.append(", retCode:");
      paramGetBarrageListRspBody.append(i);
      paramGetBarrageListRspBody.append(", errInfo:");
      paramGetBarrageListRspBody.append((String)localObject);
      paramGetBarrageListRspBody.append(", errInfoShow:");
      paramGetBarrageListRspBody.append(str);
      paramGetBarrageListRspBody.append(", isFinish:");
      paramGetBarrageListRspBody.append(bool);
      paramGetBarrageListRspBody.append(", totalCount:");
      paramGetBarrageListRspBody.append(j);
      paramGetBarrageListRspBody.append(", nextStartIdx:");
      paramGetBarrageListRspBody.append(k);
      paramGetBarrageListRspBody.append(", danmuItemListSize:");
      paramGetBarrageListRspBody.append(localList1.size());
      paramGetBarrageListRspBody.append(", recallDeleteList:");
      paramGetBarrageListRspBody.append(localList2.toString());
      paramGetBarrageListRspBody = paramGetBarrageListRspBody.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleDanmuRspPack barrInfo:");
      ((StringBuilder)localObject).append(paramGetBarrageListRspBody);
      QLog.d("DanmuDataHolder", 2, ((StringBuilder)localObject).toString());
    }
    paramCacheHolder.a(((IDanmakuDecode)QRoute.api(IDanmakuDecode.class)).decodeCommentList(localList1, paramCacheHolder.b.b, DanmuDataHolder.a().a, DanmuDataHolder.a().b)).b(localList2).a(m).b(n).c(k).a(bool).c();
  }
  
  public static void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "1";
    String str1;
    if (paramBoolean1) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("eventSuccess", str1);
    localHashMap.put("statusCode", String.valueOf(paramInt1));
    localHashMap.put("mediaType", String.valueOf(paramInt2));
    if (paramBoolean2) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("rspValid", str1);
    localHashMap.put("errInfo", paramString);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "DanmakuRequestMonitor", paramBoolean1, 0L, 0L, localHashMap, null);
  }
  
  void a(DanmuDataHolder.CacheHolder paramCacheHolder)
  {
    if (paramCacheHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataHolder", 2, "request called, reqHolder null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("request called, param:");
      ((StringBuilder)localObject1).append(paramCacheHolder.a());
      QLog.d("DanmuDataHolder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0xdea.GetBarrageListReqBody();
    ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint64_group_code.set(paramCacheHolder.b.b);
    ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint64_barrage_seq.set(paramCacheHolder.b.a);
    ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint32_last_update_time.set(paramCacheHolder.d);
    ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint32_start_index.set(paramCacheHolder.l);
    ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint32_barrage_count.set(paramCacheHolder.m);
    int i;
    if ((paramCacheHolder.b.c != 101) && (paramCacheHolder.b.c != 103)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint32_video_start_time.set(paramCacheHolder.j);
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint32_video_end_time.set(paramCacheHolder.k);
    }
    else
    {
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint32_video_start_time.set(0);
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).uint32_video_end_time.set(0);
    }
    ((oidb_0xdea.GetBarrageListReqBody)localObject2).terminal.set(0);
    switch (paramCacheHolder.b.c)
    {
    default: 
      break;
    case 103: 
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).entrance.set(4);
      break;
    case 102: 
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).entrance.set(3);
      break;
    case 101: 
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).entrance.set(2);
      break;
    case 100: 
      ((oidb_0xdea.GetBarrageListReqBody)localObject2).entrance.set(1);
    }
    Object localObject1 = new oidb_0xdea.ReqBody();
    ((oidb_0xdea.ReqBody)localObject1).get_barrage_list_req.set((MessageMicro)localObject2);
    localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    NewIntent localNewIntent = new NewIntent(((AppRuntime)localObject2).getApp(), DanmuDataServlet.class);
    localNewIntent.putExtra("KEY_SEND_DATA", ((oidb_0xdea.ReqBody)localObject1).toByteArray());
    localNewIntent.putExtra("KEY_GROUP_UIN", paramCacheHolder.b.b);
    localNewIntent.putExtra("KEY_TOPIC_UIN", paramCacheHolder.b.a);
    ((AppRuntime)localObject2).startServlet(localNewIntent);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive:");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.d("DanmuDataHolder", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramFromServiceMsg.getResultCode();
    long l1 = paramIntent.getLongExtra("KEY_TOPIC_UIN", 0L);
    long l2 = paramIntent.getLongExtra("KEY_GROUP_UIN", 0L);
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if ((l1 != 0L) && (l2 != 0L))
    {
      paramIntent = DanmuDataHolder.a().a(l2, l1);
      localObject = DanmuDataHolder.a().a(paramIntent);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanmuDataHolder", 2, "onReceive, holder null");
        }
        if (i != 1000) {
          bool1 = false;
        }
        a(bool1, i, -1, false, "onReceive, holder null");
        return;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
      {
        paramIntent = a(paramFromServiceMsg);
        if (paramIntent != null)
        {
          a((DanmuDataHolder.CacheHolder)localObject, paramIntent);
          bool1 = true;
          break label195;
        }
      }
      bool1 = false;
      label195:
      if (i == 1000) {
        bool2 = true;
      }
      int j = ((DanmuDataHolder.CacheHolder)localObject).b.c;
      if (bool1) {
        paramIntent = "DanmuRsp Valid";
      } else {
        paramIntent = "DanmuRsp Null";
      }
      a(bool2, i, j, bool1, paramIntent);
      if (bool1)
      {
        paramFromServiceMsg = ((DanmuDataHolder.CacheHolder)localObject).a;
        DanmuDataContext localDanmuDataContext = ((DanmuDataHolder.CacheHolder)localObject).b;
        bool2 = ((DanmuDataHolder.CacheHolder)localObject).c;
        i = ((DanmuDataHolder.CacheHolder)localObject).e;
        if (((DanmuDataHolder.CacheHolder)localObject).b.d) {
          paramIntent = ((DanmuDataHolder.CacheHolder)localObject).h;
        } else {
          paramIntent = ((DanmuDataHolder.CacheHolder)localObject).i;
        }
        paramFromServiceMsg.onDanmuPullResult(localDanmuDataContext, true, bool2, i, (ArrayList)paramIntent, ((DanmuDataHolder.CacheHolder)localObject).f);
        ((DanmuDataHolder.CacheHolder)localObject).b.d = true;
      }
      else
      {
        ((DanmuDataHolder.CacheHolder)localObject).a.onDanmuPullResult(((DanmuDataHolder.CacheHolder)localObject).b, false, ((DanmuDataHolder.CacheHolder)localObject).c, ((DanmuDataHolder.CacheHolder)localObject).e, null, null);
      }
      if ((bool1) && (!((DanmuDataHolder.CacheHolder)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DanmuDataHolder", 2, "onReceive, 没有结束，接力拉取");
        }
        a((DanmuDataHolder.CacheHolder)localObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataHolder", 2, "onReceive, topicUin:0, groupUin:0");
    }
    if (i == 1000) {
      bool1 = bool3;
    } else {
      bool1 = false;
    }
    a(bool1, i, -1, false, "onReceive, topicUin:0, groupUin:0");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getByteArrayExtra("KEY_SEND_DATA");
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3562);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent));
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.h());
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = new byte[paramIntent.length + 4];
    PkgTools.dWord2Byte((byte[])localObject, 0, paramIntent.length + 4);
    PkgTools.copyData((byte[])localObject, 4, paramIntent, paramIntent.length);
    paramPacket.setSSOCommand("OidbSvc.0xdea");
    paramPacket.putSendData((byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataServlet
 * JD-Core Version:    0.7.0.1
 */