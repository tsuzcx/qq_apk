package com.tencent.mobileqq.kandian.repo.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyFromSelf;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.SPEventReportSwitch;
import com.tencent.mobileqq.kandian.glue.report.RIJUserDeviceInfoReport;
import com.tencent.mobileqq.kandian.glue.report.task.TaskManager;
import com.tencent.mobileqq.kandian.repo.account.api.BaseOx978RespCallBack;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadExposeReport;
import com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.DynamicInsertCardReport;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.FeedsReportData;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReportInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReqBody;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.RspBody;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportReq;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportResp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.RspBody;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationInfo;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationResult;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.ReqBody;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.ReqFollowOperationPara;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspBody;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@IgnoreDenyDependencyFromSelf
public class UserOperationModule
  extends ReadInJoyEngineModule
  implements IUserOperationModule
{
  public static final int APP_PUSH_BITMAP_FLAG = 1;
  public static final int KANDIAN_DAILY_BITMAP_FLAG = 2;
  static int KandianTopBit = 42105;
  public static final String REQ_FROM_READINJOY_HANDLER = "reqFromReadinjoyHandler";
  private static final String TAG = "UserOperationModule";
  private SparseArray<WeakReference<BaseOx978RespCallBack>> m978RequestCallbacks = new SparseArray();
  private AtomicInteger m978RequestSeqFactory = new AtomicInteger(0);
  
  public UserOperationModule()
  {
    super(RIJQQAppInterfaceUtil.b(), null, null, ReadInJoyMSFService.getInstance(), null);
  }
  
  public UserOperationModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void addPublicFeatureValue(oidb_cmd0x80a.KDEventReportReq paramKDEventReportReq)
  {
    Object localObject = ReadInJoyMMapKvStorage.getInstance("80aEvent");
    paramKDEventReportReq = paramKDEventReportReq.att_list.get();
    String str = ((ReadInJoyMMapKvStorage)localObject).getValeForKey("content");
    if (!TextUtils.isEmpty(str))
    {
      if ((((ReadInJoyMMapKvStorage)localObject).getExpiredTime() != 0) && (((ReadInJoyMMapKvStorage)localObject).getExpiredTime() < System.currentTimeMillis() / 1000L))
      {
        ((ReadInJoyMMapKvStorage)localObject).invalidate();
        return;
      }
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(127);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("FeatureFrameworkAttr");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(str);
      paramKDEventReportReq.add(localObject);
    }
  }
  
  private void batch0x978(ArrayList<BatchFollowModel> paramArrayList, boolean paramBoolean, BaseOx978RespCallBack paramBaseOx978RespCallBack, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("batch0x978, followList = ");
      ((StringBuilder)localObject1).append(paramArrayList);
      ((StringBuilder)localObject1).append(", isFollow = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", callback = ");
      ((StringBuilder)localObject1).append(paramBaseOx978RespCallBack);
      ((StringBuilder)localObject1).append(", refer = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("UserOperationModule", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      localObject1 = new oidb_cmd0x978.ReqFollowOperationPara();
      Object localObject2 = ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).op_type;
      if (paramBoolean) {
        i = 1;
      }
      ((PBEnumField)localObject2).set(i);
      i = 0;
      while (i < paramArrayList.size())
      {
        localObject2 = (BatchFollowModel)paramArrayList.get(i);
        oidb_cmd0x978.OneFollowOperationInfo localOneFollowOperationInfo = new oidb_cmd0x978.OneFollowOperationInfo();
        localOneFollowOperationInfo.uint64_dst_uin.set(Long.valueOf(((BatchFollowModel)localObject2).jdField_a_of_type_Long).longValue());
        localOneFollowOperationInfo.uint32_op_account_type.set(((BatchFollowModel)localObject2).jdField_a_of_type_Int);
        ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).rpt_follow_operation_info.add(localOneFollowOperationInfo);
        i += 1;
      }
      paramArrayList = new oidb_cmd0x978.ReqBody();
      paramArrayList.uint64_uin.set(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue());
      paramArrayList.msg_req_follow_para.set((MessageMicro)localObject1);
      paramArrayList.uint32_refer.set(paramInt);
      paramArrayList = ReadInJoyOidbHelper.a("OidbSvc.0x978", 2424, 0, paramArrayList.toByteArray());
      paramInt = this.m978RequestSeqFactory.incrementAndGet();
      this.m978RequestCallbacks.put(paramInt, new WeakReference(paramBaseOx978RespCallBack));
      paramArrayList.addAttribute("callbackSeq", Integer.valueOf(paramInt));
      paramArrayList.addAttribute("selfUin", this.mApp.getCurrentAccountUin());
      paramArrayList.addAttribute("isBatch", Boolean.valueOf(true));
      sendPbReq(paramArrayList);
    }
  }
  
  private oidb_cmd0x64e.ReportInfo createReportInfoForRequest(ReportInfo paramReportInfo)
  {
    oidb_cmd0x64e.ReportInfo localReportInfo = new oidb_cmd0x64e.ReportInfo();
    initDeviceInfoForReportInfo(localReportInfo);
    initBaseReportInfoForReportInfo(localReportInfo, paramReportInfo);
    initFeedsReportDataForReportInfo(localReportInfo, paramReportInfo);
    initVideoExtraRepoerDataForReportInfo(localReportInfo, paramReportInfo);
    initDynamicInsertReportDataForReportInfo(localReportInfo, paramReportInfo);
    return localReportInfo;
  }
  
  private String get80aReportReq(oidb_cmd0x80a.KDEventReportReq paramKDEventReportReq)
  {
    if (paramKDEventReportReq != null) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramKDEventReportReq.event_id.get());
        ((StringBuilder)localObject).append("");
        localJSONObject1.put("event_id", ((StringBuilder)localObject).toString());
        localJSONObject1.put("event_name", paramKDEventReportReq.event_name.get());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramKDEventReportReq.version.get());
        ((StringBuilder)localObject).append("");
        localJSONObject1.put("version", ((StringBuilder)localObject).toString());
        localObject = paramKDEventReportReq.att_list.get();
        if (localObject != null)
        {
          paramKDEventReportReq = new JSONArray();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            oidb_cmd0x80a.AttributeList localAttributeList = (oidb_cmd0x80a.AttributeList)((Iterator)localObject).next();
            if (localAttributeList != null)
            {
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("att_id", String.valueOf(localAttributeList.att_id.get()));
              localJSONObject2.put("att_name", localAttributeList.att_name.get());
              localJSONObject2.put("att_value", localAttributeList.att_value.get());
              paramKDEventReportReq.put(localJSONObject2);
            }
          }
          if (paramKDEventReportReq.length() > 0) {
            localJSONObject1.put("att_list", paramKDEventReportReq);
          }
        }
        paramKDEventReportReq = localJSONObject1.toString();
        return paramKDEventReportReq;
      }
      catch (JSONException paramKDEventReportReq)
      {
        paramKDEventReportReq.printStackTrace();
      }
    }
    return null;
  }
  
  private Pair<String, Integer> getCommandFrom(int paramInt)
  {
    if (paramInt != 8) {
      if (paramInt != 9)
      {
        if ((paramInt != 12) && (paramInt != 61))
        {
          if ((paramInt != 23) && (paramInt != 24)) {
            return new Pair("OidbSvc.0x80a", Integer.valueOf(2058));
          }
        }
        else {
          return new Pair("OidbSvc.0xc44", Integer.valueOf(3140));
        }
      }
      else {
        return new Pair("OidbSvc.0xc43", Integer.valueOf(3139));
      }
    }
    return new Pair("OidbSvc.0xc42", Integer.valueOf(3138));
  }
  
  private int getNetType()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int i = 0;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 5) {
                return 0;
              }
            }
            else {
              return 3;
            }
          }
          else {
            return 2;
          }
        }
        else {
          return 1;
        }
      }
      i = 4;
    }
    return i;
  }
  
  private int getNetTypeFor64eVideo()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int i = 0;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 5) {
                return 0;
              }
            }
            else {
              return 4;
            }
          }
          else {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      i = 1;
    }
    return i;
  }
  
  public static ReadInJoyUserInfoModule getUserInfoModule()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject == null) {
      return null;
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject == null) {
      return null;
    }
    return ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a();
  }
  
  private void handle0x64eUserOperationReport(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x64e.RspBody());
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleUserOperationReport, result=");
      paramFromServiceMsg.append(i);
      QLog.d("UserOperationModule", 2, paramFromServiceMsg.toString());
    }
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = (Boolean)paramToServiceMsg.getAttribute("is_feeds_preload_expose");
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.booleanValue())) {
        try
        {
          long l = paramToServiceMsg.extraData.getLong("sendtimekey");
          l = System.currentTimeMillis() - l;
          boolean bool = false;
          QLog.d("UserOperationModule", 1, new Object[] { "feedsPreload 0x64e, result = ", Integer.valueOf(i), ", cost = ", Long.valueOf(l) });
          if (i == 0) {
            bool = true;
          }
          FeedsPreloadExposeReport.a(bool, l, i);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.d("UserOperationModule", 1, "handle0x64eUserOperationReport e = ", paramToServiceMsg);
        }
      }
    }
  }
  
  private void handle0x80aPushEffectEvent(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x80a.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      processKDEventReportResp(paramToServiceMsg);
      updatePulseReportParams(paramToServiceMsg);
      if ((paramToServiceMsg.lastRecvMsgDuration.has()) && (paramToServiceMsg.lastSendMsgDuration.has())) {
        ReadInJoyHelper.a((int)paramToServiceMsg.lastRecvMsgDuration.get(), (int)paramToServiceMsg.lastSendMsgDuration.get());
      }
      if ((paramToServiceMsg.pulseTimerDuration.has()) && (paramToServiceMsg.pulseTimerDuration.get() != 12345678L)) {
        ReadinjoySPEventReport.a().b((int)paramToServiceMsg.pulseTimerDuration.get());
      }
      if (paramToServiceMsg.leftBtmRedCntMaxForExitAIO.has()) {
        ReadInJoyHelper.a((int)paramToServiceMsg.leftBtmRedCntMaxForExitAIO.get());
      }
      if ((paramToServiceMsg.uint64_main_video_tab_red.has()) && (paramToServiceMsg.uint64_main_video_tab_red.get() > 0L)) {
        ((KandianMergeManager)RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(new KandianRedDotInfo("kandian_video_tab_reddot_info"));
      }
      if (paramToServiceMsg.uint64_scroll_interval_time.has()) {
        com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollReportUtil.jdField_a_of_type_Long = paramToServiceMsg.uint64_scroll_interval_time.get();
      }
      if (paramToServiceMsg.uint64_scroll_all_time.has()) {
        com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollReportUtil.jdField_b_of_type_Long = paramToServiceMsg.uint64_scroll_all_time.get();
      }
      if (paramToServiceMsg.uint64_chat_aio_time.has()) {
        ReadinjoySPEventReport.c = paramToServiceMsg.uint64_chat_aio_time.get();
      }
      if (paramToServiceMsg.force_top_daily_red_day_offset.has())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("daily settop offset : ");
        paramFromServiceMsg.append(paramToServiceMsg.force_top_daily_red_day_offset.get());
        QLog.d("UserOperationModule", 2, paramFromServiceMsg.toString());
        com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager.DailySetTopInfo.settopOffset = paramToServiceMsg.force_top_daily_red_day_offset.get();
      }
      if (paramToServiceMsg.idle_push_wake_param.has()) {
        SneakyCallback.a(paramToServiceMsg.idle_push_wake_param.get());
      }
      if (paramToServiceMsg.msg_srt_rule_list.has()) {
        ReadInJoySrtUtils.a().a(paramToServiceMsg.msg_srt_rule_list.get());
      }
      processKDTabNumRedpntResp(paramToServiceMsg);
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x80aPushEffectEvent, result=");
      paramToServiceMsg.append(i);
      QLog.d("UserOperationModule", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handle0x886UserOperationReport(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x886UserOperationReport, result=");
      paramToServiceMsg.append(i);
      QLog.d("UserOperationModule", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handle0x978Resp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("callbackSeq")).intValue();
    Object localObject1;
    if (paramToServiceMsg.getAttribute("distUin") != null) {
      localObject1 = (String)paramToServiceMsg.getAttribute("distUin");
    } else {
      localObject1 = "";
    }
    boolean bool1;
    if (paramToServiceMsg.getAttribute("isBatch") != null) {
      bool1 = ((Boolean)paramToServiceMsg.getAttribute("isBatch")).booleanValue();
    } else {
      bool1 = false;
    }
    Object localObject2;
    if (paramToServiceMsg.getAttribute("avatarUrl") != null) {
      localObject2 = (String)paramToServiceMsg.getAttribute("avatarUrl");
    } else {
      localObject2 = "";
    }
    boolean bool2;
    if (paramToServiceMsg.getAttribute("isBlackSceneTip") != null) {
      bool2 = ((Boolean)paramToServiceMsg.getAttribute("isBlackSceneTip")).booleanValue();
    } else {
      bool2 = false;
    }
    paramToServiceMsg = (BaseOx978RespCallBack)((WeakReference)this.m978RequestCallbacks.get(i)).get();
    this.m978RequestCallbacks.remove(i);
    oidb_cmd0x978.RspBody localRspBody = new oidb_cmd0x978.RspBody();
    i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handle 978resp  retCode : ");
    paramFromServiceMsg.append(i);
    QLog.d("UserOperationModule", 2, paramFromServiceMsg.toString());
    if (paramToServiceMsg == null) {
      return;
    }
    if (i == 0)
    {
      if (!localRspBody.msg_rsp_follow_op_result.has()) {
        return;
      }
      int j = ((oidb_cmd0x978.OneFollowOperationResult)((oidb_cmd0x978.RspFollowOperationResult)localRspBody.msg_rsp_follow_op_result.get()).rpt_follow_operation_result.get().get(0)).uint32_guide_type.get();
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle 978resp  guideType : ");
      paramFromServiceMsg.append(j);
      QLog.i("UserOperationModule", 1, paramFromServiceMsg.toString());
      if (j != 0) {
        ThreadManager.getUIHandler().post(new UserOperationModule.1(this, (String)localObject2, (String)localObject1, j, bool2));
      }
      paramFromServiceMsg = (oidb_cmd0x978.RspFollowOperationResult)localRspBody.msg_rsp_follow_op_result.get();
      if (((oidb_cmd0x978.RspFollowOperationResult)paramFromServiceMsg.get()).op_type.get() == 2) {
        ThreadManager.getUIHandler().post(new UserOperationModule.2(this, (String)localObject1));
      }
      if (!paramFromServiceMsg.rpt_follow_operation_result.has()) {
        return;
      }
      if (bool1)
      {
        paramObject = new ArrayList(paramFromServiceMsg.rpt_follow_operation_result.get().size());
        localObject1 = paramFromServiceMsg.rpt_follow_operation_result.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (oidb_cmd0x978.OneFollowOperationResult)((Iterator)localObject1).next();
          long l = ((oidb_cmd0x978.OneFollowOperationResult)localObject2).uint64_dst_uin.get();
          i = ((oidb_cmd0x978.OneFollowOperationResult)localObject2).uint32_op_account_type.get();
          if (((oidb_cmd0x978.OneFollowOperationResult)localObject2).enum_follow_status.get() == 2) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramObject.add(new BatchFollowModel(l, i, bool1));
        }
        this.mMainThreadHandler.post(new UserOperationModule.3(this, paramObject, paramFromServiceMsg, paramToServiceMsg));
        return;
      }
      paramFromServiceMsg = paramFromServiceMsg.rpt_follow_operation_result.get().iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (oidb_cmd0x978.OneFollowOperationResult)paramFromServiceMsg.next();
        if (TextUtils.equals(String.valueOf(paramObject.uint64_dst_uin.get()), (CharSequence)localObject1))
        {
          ReadInJoyLogicEngine.a().b(Long.valueOf((String)localObject1).longValue(), paramObject.enum_follow_status.get());
          this.mMainThreadHandler.post(new UserOperationModule.4(this, paramToServiceMsg, (String)localObject1, paramObject));
          return;
        }
      }
    }
    this.mMainThreadHandler.post(new UserOperationModule.5(this, bool1, paramToServiceMsg, i, (String)localObject1));
  }
  
  private void handleGetKandianTopFromServer(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      int i = paramFromServiceMsg.getResultCode();
      if (i == 1000)
      {
        paramFromServiceMsg = null;
        if (paramObject != null)
        {
          try
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            try
            {
              paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
              paramToServiceMsg = paramFromServiceMsg;
            }
            catch (Exception paramFromServiceMsg) {}
            if (!QLog.isColorLevel()) {
              break label83;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            paramToServiceMsg = null;
          }
          QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer merge fail ", paramFromServiceMsg);
        }
        else
        {
          label83:
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer data == null");
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
        if (paramToServiceMsg != null) {
          i = paramToServiceMsg.uint32_result.get();
        }
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer success");
          }
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l = paramToServiceMsg.getInt();
          paramToServiceMsg.get();
          i = paramToServiceMsg.getShort();
          int j = paramToServiceMsg.getShort();
          int k = paramToServiceMsg.getShort();
          int m = paramToServiceMsg.getShort();
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetKandianTopFromServer, request success, tlvCount = ");
            paramToServiceMsg.append(i);
            paramToServiceMsg.append(" uin:");
            paramToServiceMsg.append(l);
            paramToServiceMsg.append(" type:");
            paramToServiceMsg.append(j);
            paramToServiceMsg.append(" length:");
            paramToServiceMsg.append(k);
            paramToServiceMsg.append(" value:");
            paramToServiceMsg.append(m);
            QLog.d("UserOperationModule", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = (KandianMergeManager)this.mApp.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
          if (m == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer server no set,upload local ");
            }
            boolean bool = paramToServiceMsg.d();
            if (bool) {
              paramToServiceMsg.c(bool);
            }
          }
          else
          {
            if (m == 1)
            {
              paramToServiceMsg.a(false, true);
              return;
            }
            if (m == 2) {
              paramToServiceMsg.a(true, true);
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetKandianTopFromServer failed ");
          if (paramToServiceMsg != null) {
            paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
          } else {
            paramToServiceMsg = "null";
          }
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("UserOperationModule", 2, paramFromServiceMsg.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetKandianTopFromServer ");
        paramToServiceMsg.append(i);
        QLog.d("UserOperationModule", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  private void handleSetKandianTopToServer(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      int i = paramFromServiceMsg.getResultCode();
      if (i == 1000)
      {
        paramFromServiceMsg = null;
        if (paramObject != null)
        {
          try
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            try
            {
              paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
              paramToServiceMsg = paramFromServiceMsg;
            }
            catch (Exception paramFromServiceMsg) {}
            if (!QLog.isColorLevel()) {
              break label83;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            paramToServiceMsg = null;
          }
          QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer merge fail ", paramFromServiceMsg);
        }
        else
        {
          label83:
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.d("UserOperationModule", 2, " handleSetKandianTopToServer data == null");
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
        if (paramToServiceMsg != null) {
          i = paramToServiceMsg.uint32_result.get();
        }
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer success");
          }
        }
        else if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleSetKandianTopToServer failed ");
          if (paramToServiceMsg != null) {
            paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
          } else {
            paramToServiceMsg = "null";
          }
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("UserOperationModule", 2, paramFromServiceMsg.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSetKandianTopToServer ");
        paramToServiceMsg.append(i);
        QLog.d("UserOperationModule", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  private void handleUserActionReportResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xde0.RspBody());
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleUserActionReport ret : ");
    paramToServiceMsg.append(i);
    QLog.d("UserOperationModule", 1, paramToServiceMsg.toString());
  }
  
  private void initBaseReportInfoForReportInfo(oidb_cmd0x64e.ReportInfo paramReportInfo, ReportInfo paramReportInfo1)
  {
    paramReportInfo.uint64_uin.set(paramReportInfo1.mUin);
    paramReportInfo.uint32_source.set(paramReportInfo1.mSource);
    paramReportInfo.operator_platform.set(3);
    if (paramReportInfo1.mSourceArticleId != -1L) {
      paramReportInfo.uint64_source_article_id.set(paramReportInfo1.mSourceArticleId);
    }
    if (paramReportInfo1.mChannelId != -1) {
      paramReportInfo.uint32_channel_id.set(paramReportInfo1.mChannelId);
    }
    if (paramReportInfo1.mAlgorithmId != -1) {
      paramReportInfo.uint32_algorithm_id.set(paramReportInfo1.mAlgorithmId);
    }
    if (paramReportInfo1.mStrategyId != -1) {
      paramReportInfo.uint32_strategy_id.set(paramReportInfo1.mStrategyId);
    }
    if (paramReportInfo1.mFolderStatus > 0) {
      paramReportInfo.uint32_folder_status.set(paramReportInfo1.mFolderStatus);
    }
    paramReportInfo.enum_operation.set(paramReportInfo1.mOperation);
    if ((paramReportInfo1.mOperation == 9) && (paramReportInfo1.mReadTimeLength != -1)) {
      paramReportInfo.uint32_read_time_length.set(paramReportInfo1.mReadTimeLength);
    }
    if ((paramReportInfo1.mOperation == 12) && (paramReportInfo1.mPlayTimeLength != -1)) {
      paramReportInfo.uint32_play_time_length.set(paramReportInfo1.mPlayTimeLength);
    }
    if (!TextUtils.isEmpty(paramReportInfo1.mCollectUrl)) {
      paramReportInfo.bytes_collect_url.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.mCollectUrl));
    }
    if (!TextUtils.isEmpty(paramReportInfo1.mInnerId)) {
      paramReportInfo.bytes_inner_id.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.mInnerId));
    }
    if (paramReportInfo1.mOpSource >= 0) {
      paramReportInfo.enum_op_source.set(paramReportInfo1.mOpSource);
    }
    if (paramReportInfo1.mServerContext != null) {
      paramReportInfo.bytes_server_context.set(ByteStringMicro.copyFrom(paramReportInfo1.mServerContext));
    }
    paramReportInfo.bool_is_gallery.set(paramReportInfo1.mIsGallery);
    if (paramReportInfo1.mGalleryReportInfo != null) {
      paramReportInfo.bytes_gallery_report_info.set(ByteStringMicro.copyFrom(paramReportInfo1.mGalleryReportInfo));
    }
    if (paramReportInfo1.mArticleLength != -1) {
      paramReportInfo.uint32_article_length.set(paramReportInfo1.mArticleLength);
    }
    if (paramReportInfo1.mReadArticleLength != -1) {
      paramReportInfo.uint32_read_article_length.set(paramReportInfo1.mReadArticleLength);
    }
    if (paramReportInfo1.mHotWord != null) {
      paramReportInfo.bytes_hot_word.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.mHotWord));
    }
    if (!TextUtils.isEmpty(paramReportInfo1.mSearchTagName)) {
      paramReportInfo.bytes_search_tag_name.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.mSearchTagName));
    }
    if (paramReportInfo1.mColumnID != -1) {
      paramReportInfo.uint32_column_id.set(paramReportInfo1.mColumnID);
    }
    if (!TextUtils.isEmpty(paramReportInfo1.videoReportInfo)) {
      paramReportInfo.bytes_video_report_info.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.videoReportInfo));
    }
    if (!TextUtils.isEmpty(paramReportInfo1.firstVideoRowkey)) {
      paramReportInfo.bytes_first_rowkey.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.firstVideoRowkey));
    }
    if (paramReportInfo1.replyUin != -1L) {
      paramReportInfo.uint64_reply_uin.set(paramReportInfo1.replyUin);
    }
    if (!TextUtils.isEmpty(paramReportInfo1.replyID)) {
      paramReportInfo.bytes_reply_id.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.replyID));
    }
    if (paramReportInfo1.srtClickInfo != null) {
      paramReportInfo.msg_srt_click_info.set(paramReportInfo1.srtClickInfo);
    }
  }
  
  private void initDeviceInfoForReportInfo(oidb_cmd0x64e.ReportInfo paramReportInfo)
  {
    String str = RIJUserDeviceInfoReport.a();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        paramReportInfo.bytes_device_id.set(ByteStringMicro.copyFromUtf8(str));
        return;
      }
      catch (Exception paramReportInfo)
      {
        paramReportInfo.printStackTrace();
      }
    }
  }
  
  private void initDynamicInsertReportDataForReportInfo(oidb_cmd0x64e.ReportInfo paramReportInfo, ReportInfo paramReportInfo1)
  {
    paramReportInfo1 = paramReportInfo1.dynamicInsertReportData;
    if (paramReportInfo1 != null)
    {
      paramReportInfo.enum_operation.set(59);
      oidb_cmd0x64e.DynamicInsertCardReport localDynamicInsertCardReport = new oidb_cmd0x64e.DynamicInsertCardReport();
      localDynamicInsertCardReport.action_type.set(paramReportInfo1.jdField_a_of_type_Int);
      localDynamicInsertCardReport.progress.set(paramReportInfo1.jdField_b_of_type_Int);
      localDynamicInsertCardReport.seq_no.set(ByteStringMicro.copyFromUtf8(paramReportInfo1.jdField_a_of_type_JavaLangString));
      localDynamicInsertCardReport.watch_time.set(paramReportInfo1.c);
      paramReportInfo.dynamic_insert_card_report.set(localDynamicInsertCardReport);
    }
  }
  
  private void initFeedsReportDataForReportInfo(oidb_cmd0x64e.ReportInfo paramReportInfo, ReportInfo paramReportInfo1)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = paramReportInfo1.mFeedsReportData;
    if (localObject != null)
    {
      paramReportInfo1 = new oidb_cmd0x64e.FeedsReportData();
      paramReportInfo1.uint64_feeds_id.set(((FeedsReportData)localObject).jdField_a_of_type_Long);
      paramReportInfo1.uint64_publish_uin.set(((FeedsReportData)localObject).jdField_b_of_type_Long);
      paramReportInfo1.uint32_like_total_count.set(((FeedsReportData)localObject).jdField_a_of_type_Int);
      paramReportInfo1.uint32_comment_total_count.set(((FeedsReportData)localObject).jdField_b_of_type_Int);
      ArrayList localArrayList2 = new ArrayList();
      if ((((FeedsReportData)localObject).jdField_a_of_type_JavaUtilList != null) && (!((FeedsReportData)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = ((FeedsReportData)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList2.add((Long)((Iterator)localObject).next());
        }
        paramReportInfo1.rpt_like_uin_list.set(localArrayList2);
      }
      localArrayList1.add(paramReportInfo1);
      paramReportInfo.rpt_feeds_report_data_list.set(localArrayList1);
    }
  }
  
  private void initVideoExtraRepoerDataForReportInfo(oidb_cmd0x64e.ReportInfo paramReportInfo, ReportInfo paramReportInfo1)
  {
    ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData = paramReportInfo1.mVideoExtraRepoerData;
    if (localVideoExtraRepoerData != null)
    {
      paramReportInfo.enum_network_type.set(getNetTypeFor64eVideo());
      paramReportInfo.operator_platform.set(3);
      if (localVideoExtraRepoerData.jdField_b_of_type_Boolean) {
        paramReportInfo.whether_click_in.set(localVideoExtraRepoerData.jdField_a_of_type_Boolean);
      }
      if (localVideoExtraRepoerData.jdField_a_of_type_Int != -1) {
        paramReportInfo.enum_jumpway_which.set(localVideoExtraRepoerData.jdField_a_of_type_Int);
      }
      if (localVideoExtraRepoerData.jdField_b_of_type_Int != -1) {
        paramReportInfo.enum_in_onetree_source.set(localVideoExtraRepoerData.jdField_b_of_type_Int);
      }
      if (localVideoExtraRepoerData.c != -1) {
        paramReportInfo.enum_in_videochannel_source.set(localVideoExtraRepoerData.c);
      }
      if (localVideoExtraRepoerData.d != -1) {
        paramReportInfo.uint32_current_video_time.set(localVideoExtraRepoerData.d);
      }
      if (localVideoExtraRepoerData.e != -1) {
        paramReportInfo.uint32_video_duration.set(localVideoExtraRepoerData.e);
      }
      if ((paramReportInfo1.mOpSource == 5) && (localVideoExtraRepoerData.f != -1)) {
        paramReportInfo.uint32_onetree_video_from_type.set(localVideoExtraRepoerData.f);
      }
    }
  }
  
  private ToServiceMsg makeFeedsPreloadReportPkg(List<ReportInfo> paramList, String paramString)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder;
    ReportInfo localReportInfo1;
    oidb_cmd0x64e.ReportInfo localReportInfo;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("feedsPreload expose report, size = ");
      localStringBuilder.append(paramList.size());
      localStringBuilder.append("\n");
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        localReportInfo1 = (ReportInfo)localIterator.next();
        localReportInfo = new oidb_cmd0x64e.ReportInfo();
        localReportInfo.uint64_uin.set(localReportInfo1.mUin);
        localReportInfo.enum_operation.set(localReportInfo1.mOperation);
        localReportInfo.uint64_source_article_id.set(localReportInfo1.mSourceArticleId);
        PBBytesField localPBBytesField = localReportInfo.bytes_inner_id;
        if (localReportInfo1.mInnerId != null) {
          paramList = localReportInfo1.mInnerId;
        } else {
          paramList = "";
        }
        localPBBytesField.set(ByteStringMicro.copyFromUtf8(paramList));
        localReportInfo.uint32_algorithm_id.set(localReportInfo1.mAlgorithmId);
        localPBBytesField = localReportInfo.bytes_gw_common_data;
        if (localReportInfo1.mGWCommonData != null) {
          paramList = localReportInfo1.mGWCommonData;
        } else {
          paramList = "";
        }
        localPBBytesField.set(ByteStringMicro.copyFromUtf8(paramList));
      }
    }
    for (;;)
    {
      try
      {
        localStringBuilder.append("feedsPreload reportInfo, uin = ");
        localStringBuilder.append(localReportInfo1.mUin);
        localStringBuilder.append(", operation = ");
        localStringBuilder.append(localReportInfo1.mOperation);
        localStringBuilder.append(", articleID = ");
        localStringBuilder.append(localReportInfo1.mSourceArticleId);
        localStringBuilder.append(", rowKey = ");
        localStringBuilder.append(localReportInfo1.mInnerId);
        localStringBuilder.append(", gwCommonData = ");
        if (localReportInfo1.mGWCommonData == null) {
          break label491;
        }
        paramList = localReportInfo1.mGWCommonData;
        localStringBuilder.append(paramList);
        localStringBuilder.append(", algorithmID = ");
        localStringBuilder.append(localReportInfo1.mAlgorithmId);
        localStringBuilder.append("\n");
      }
      catch (Exception paramList)
      {
        QLog.d("UserOperationModule", 1, "makeFeedsPreloadReportPkg, e = ", paramList);
      }
      localArrayList.add(localReportInfo);
      break;
      localStringBuilder.append("preloadReqInfo = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
      QLog.d("UserOperationModule", 1, new Object[] { localStringBuilder });
      localReqBody.rpt_report_info.set(localArrayList);
      paramList = localReqBody.bytes_pre_load_req_info;
      if (paramString == null) {
        paramString = "";
      }
      paramList.set(ByteStringMicro.copyFromUtf8(paramString));
      return ReadInJoyOidbHelper.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
      label491:
      paramList = "";
    }
  }
  
  private ToServiceMsg makeKandianActionReportPkg(List<? extends ReportInfo> paramList, int paramInt)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReportInfo localReportInfo = (ReportInfo)paramList.next();
        oidb_cmd0x64e.ReportInfo localReportInfo1 = new oidb_cmd0x64e.ReportInfo();
        localReportInfo1.uint64_uin.set(localReportInfo.mUin);
        if (localReportInfo.mSourceArticleId != -1L) {
          localReportInfo1.uint64_source_article_id.set(localReportInfo.mSourceArticleId);
        }
        if (localReportInfo.mAlgorithmId != -1) {
          localReportInfo1.uint32_algorithm_id.set(localReportInfo.mAlgorithmId);
        }
        if (localReportInfo.mStrategyId != -1) {
          localReportInfo1.uint32_strategy_id.set(localReportInfo.mStrategyId);
        }
        if (localReportInfo.mFolderStatus == 0) {
          localReportInfo.mFolderStatus = paramInt;
        }
        localReportInfo1.enum_op_source.set(localReportInfo.mOpSource);
        localReportInfo1.uint32_folder_status.set(localReportInfo.mFolderStatus);
        localReportInfo1.enum_operation.set(localReportInfo.mOperation);
        localReportInfo1.bytes_device_id.set(ByteStringMicro.copyFromUtf8(RIJUserDeviceInfoReport.a()));
        localReportInfo1.uint32_channel_id.set(localReportInfo.mChannelId);
        localArrayList.add(localReportInfo1);
      }
    }
    localReqBody.rpt_report_info.set(localArrayList);
    return ReadInJoyOidbHelper.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private ToServiceMsg makeUserOperationReportPkg(List<? extends ReportInfo> paramList)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(createReportInfoForRequest((ReportInfo)((Iterator)localObject).next()));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[make64eReqBody] ");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("UserOperationModule", 1, ((StringBuilder)localObject).toString());
    }
    localReqBody.rpt_report_info.set(localArrayList);
    return ReadInJoyOidbHelper.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private void processKDEventReportResp(oidb_cmd0x80a.RspBody paramRspBody)
  {
    long l;
    if (paramRspBody.uint64_uin.has()) {
      l = paramRspBody.uint64_uin.get();
    } else {
      l = 0L;
    }
    if ((paramRspBody.rsp_kd_event_report_resp.has()) && (paramRspBody.rsp_kd_event_report_resp.get() != null))
    {
      if (((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).condParams.has()) {
        SPEventReportSwitch.a(((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).condParams.get());
      }
      if ((((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).unit_reset.has()) && (((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).unit_reset.get() == 1)) {
        TaskManager.a().d();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handle0x80aPushEffectEvent, uin:");
        localStringBuilder.append(l);
        localStringBuilder.append(";rspKDEventReportResp.result:");
        localStringBuilder.append(((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).result.get());
        localStringBuilder.append(";rspKDEventReportResp.err_msg");
        localStringBuilder.append(((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).err_msg.get());
        QLog.d("UserOperationModule", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void processKDTabNumRedpntResp(oidb_cmd0x80a.RspBody paramRspBody)
  {
    if ((paramRspBody.uint64_delete_kdtab_num_redpnt.has()) && (paramRspBody.uint64_delete_kdtab_num_redpnt.get() == 1L))
    {
      QLog.d("UserOperationModule", 1, "notify to clear msgbox redpnt !");
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
      if (localQQAppInterface != null) {
        ((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).q();
      }
    }
    if (paramRspBody.uint64_should_hide_kdtab_num_redpnt.has())
    {
      boolean bool;
      if (paramRspBody.uint64_should_hide_kdtab_num_redpnt.get() == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      RIJSPUtils.a("sp_msg_box_80a_enable_receive", Boolean.valueOf(bool));
      paramRspBody = new StringBuilder();
      paramRspBody.append("receive hide msgbox redpnt flag , canShow : ");
      paramRspBody.append(bool);
      QLog.d("UserOperationModule", 1, paramRspBody.toString());
    }
  }
  
  private void showPushNotifyDialog(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      RIJPushNotifyManager.Companion.a().showPushNotifyDialog(paramInt1, paramString1, paramString2, paramInt2, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new UserOperationModule.6(this, paramInt1, paramString1, paramString2, paramInt2, paramBoolean));
  }
  
  private void updatePulseReportParams(oidb_cmd0x80a.RspBody paramRspBody)
  {
    if ((paramRspBody.AIOPulseMaxCnt.has()) && (paramRspBody.firstScnRedPntPulseMaxCnt.has()) && (paramRspBody.leftBtmRedPntPulseMaxCnt.has()))
    {
      long l1 = paramRspBody.leftBtmRedPntPulseMaxCnt.get();
      long l2 = paramRspBody.firstScnRedPntPulseMaxCnt.get();
      long l3 = paramRspBody.AIOPulseMaxCnt.get();
      ReadInJoyHelper.a(RIJQQAppInterfaceUtil.a(), l1, l2, l3);
    }
  }
  
  public void batchFollow(ArrayList<BatchFollowModel> paramArrayList, UserOperationModule.BatchFollowCallBack paramBatchFollowCallBack, int paramInt)
  {
    batch0x978(paramArrayList, true, paramBatchFollowCallBack, paramInt);
  }
  
  public void batchUnFollow(ArrayList<BatchFollowModel> paramArrayList, UserOperationModule.BatchFollowCallBack paramBatchFollowCallBack, int paramInt)
  {
    batch0x978(paramArrayList, false, paramBatchFollowCallBack, paramInt);
  }
  
  public void getKandianTopFromServer(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "getKandianTopFromServer begin...");
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[9];
      PkgTools.dWord2Byte(paramString, 0, l);
      paramString[4] = 0;
      PkgTools.word2Byte(paramString, 5, (short)1);
      PkgTools.dWordTo2Bytes(paramString, 7, KandianTopBit);
      paramString = ReadInJoyOidbHelper.a("OidbSvc.0x480_9", 1152, 9, paramString);
      paramString.extraData.putBoolean("reqFromReadinjoyHandler", true);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UserOperationModule", 2, "send_oidb_0x480_9 error", paramString);
      }
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x64e"))
    {
      handle0x64eUserOperationReport(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x80a"))
    {
      handle0x80aPushEffectEvent(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x480_9"))
    {
      handleGetKandianTopFromServer(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x4ff_9"))
    {
      handleSetKandianTopToServer(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886"))
    {
      handle0x886UserOperationReport(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x978"))
    {
      handle0x978Resp(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc22"))
    {
      handle0x80aPushEffectEvent(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xde0")) {
      handleUserActionReportResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void reportMixFeatureUserActionData(UserActionCollector paramUserActionCollector, Context paramContext)
  {
    ThreadManager.executeOnSubThread(new UserOperationModule.7(this, paramUserActionCollector, paramContext));
  }
  
  public void request0x64eFeedsPreloadReport(List<ReportInfo> paramList, String paramString)
  {
    paramList = makeFeedsPreloadReportPkg(paramList, paramString);
    paramList.getAttributes().put("is_feeds_preload_expose", Boolean.valueOf(true));
    sendPbReq(paramList);
  }
  
  public void request0x64eKandianActionReport(List<? extends ReportInfo> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, new Object[] { paramList });
    }
    sendPbReq(makeKandianActionReportPkg(paramList, paramInt));
  }
  
  public void request0x64eUserOperationReport(List<? extends ReportInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, paramList.toString());
    }
    sendPbReq(makeUserOperationReportPkg(paramList));
  }
  
  public void request0x80aPushEffectEvent(int paramInt1, String paramString1, int paramInt2, List<oidb_cmd0x80a.AttributeList> paramList, String paramString2, int paramInt3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void request0x80aPushEffectEvent(int paramInt, String paramString, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    Pair localPair = getCommandFrom(paramInt);
    request0x80aPushEffectEvent(paramInt, paramString, -1, paramList, (String)localPair.first, ((Integer)localPair.second).intValue());
  }
  
  public void request0x978(String paramString1, long paramLong, boolean paramBoolean, String paramString2, Ox978RespCallBack paramOx978RespCallBack, int paramInt)
  {
    request0x978(paramString1, String.valueOf(paramLong), paramBoolean, paramString2, paramOx978RespCallBack, paramInt);
  }
  
  public void request0x978(String paramString1, String paramString2, boolean paramBoolean, String paramString3, Ox978RespCallBack paramOx978RespCallBack)
  {
    request0x978(paramString1, paramString2, paramBoolean, paramString3, paramOx978RespCallBack, 2);
  }
  
  public void request0x978(String paramString1, String paramString2, boolean paramBoolean, String paramString3, Ox978RespCallBack paramOx978RespCallBack, int paramInt)
  {
    request0x978(paramString1, paramString2, paramBoolean, paramString3, paramOx978RespCallBack, paramInt, false);
  }
  
  public void request0x978(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, Ox978RespCallBack paramOx978RespCallBack, int paramInt, boolean paramBoolean2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[request0x978] follow uin:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", isFollow:");
      localStringBuilder.append(paramBoolean1);
      QLog.d("UserOperationModule", 2, localStringBuilder.toString());
    }
    Object localObject2 = new oidb_cmd0x978.OneFollowOperationInfo();
    try
    {
      ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint64_dst_uin.set(Long.valueOf(paramString2).longValue());
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      localNumberFormatException1.printStackTrace();
    }
    ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint32_op_account_type.set(paramInt);
    Object localObject1 = new oidb_cmd0x978.ReqFollowOperationPara();
    PBEnumField localPBEnumField = ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).op_type;
    paramInt = i;
    if (paramBoolean1) {
      paramInt = 1;
    }
    localPBEnumField.set(paramInt);
    ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).rpt_follow_operation_info.add((MessageMicro)localObject2);
    localObject2 = new oidb_cmd0x978.ReqBody();
    try
    {
      ((oidb_cmd0x978.ReqBody)localObject2).uint64_uin.set(Long.valueOf(paramString1).longValue());
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      localNumberFormatException2.printStackTrace();
    }
    ((oidb_cmd0x978.ReqBody)localObject2).msg_req_follow_para.set((MessageMicro)localObject1);
    localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0x978", 2424, 0, ((oidb_cmd0x978.ReqBody)localObject2).toByteArray());
    paramInt = this.m978RequestSeqFactory.incrementAndGet();
    this.m978RequestCallbacks.put(paramInt, new WeakReference(paramOx978RespCallBack));
    ((ToServiceMsg)localObject1).addAttribute("distUin", paramString2);
    ((ToServiceMsg)localObject1).addAttribute("callbackSeq", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject1).addAttribute("selfUin", paramString1);
    ((ToServiceMsg)localObject1).addAttribute("avatarUrl", paramString3);
    ((ToServiceMsg)localObject1).addAttribute("isBlackSceneTip", Boolean.valueOf(paramBoolean2));
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void setKandianTopToServer(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setKandianTopToServer value=");
      localStringBuilder.append(paramInt);
      QLog.i("UserOperationModule", 2, localStringBuilder.toString());
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[13];
      PkgTools.dWord2Byte(paramString, 0, l);
      paramString[4] = 0;
      PkgTools.word2Byte(paramString, 5, (short)1);
      PkgTools.dWordTo2Bytes(paramString, 7, KandianTopBit);
      PkgTools.word2Byte(paramString, 9, (short)2);
      PkgTools.word2Byte(paramString, 11, (short)paramInt);
      paramString = ReadInJoyOidbHelper.a("OidbSvc.0x4ff_9", 1279, 9, paramString);
      paramString.extraData.putBoolean("reqFromReadinjoyHandler", true);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UserOperationModule", 2, "setKandianTopToServer ex", paramString);
      }
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule
 * JD-Core Version:    0.7.0.1
 */