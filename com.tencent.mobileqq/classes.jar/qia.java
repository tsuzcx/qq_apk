import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.7;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
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
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.FeedsReportData;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReportInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReqBody;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.RspBody;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportReq;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportResp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReqBody;
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

public class qia
  extends qhj
{
  static int jdField_a_of_type_Int = 42105;
  private SparseArray<WeakReference<qic>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public qia(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
  }
  
  public qia(EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    super(null, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
  }
  
  private int a()
  {
    switch (NetworkUtil.getSystemNetwork(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private Pair<String, Integer> a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new Pair("OidbSvc.0x80a", Integer.valueOf(2058));
    case 8: 
    case 23: 
    case 24: 
      return new Pair("OidbSvc.0xc42", Integer.valueOf(3138));
    case 9: 
      return new Pair("OidbSvc.0xc43", Integer.valueOf(3139));
    }
    return new Pair("OidbSvc.0xc44", Integer.valueOf(3140));
  }
  
  public static ReadInJoyUserInfoModule a()
  {
    Object localObject = pnn.a();
    if (localObject == null) {
      return null;
    }
    localObject = (pvp)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject == null) {
      return null;
    }
    return ((pvp)localObject).a().a();
  }
  
  private ToServiceMsg a(List<ReportInfo> paramList)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(a((ReportInfo)localIterator.next()));
      }
      QLog.d("UserOperationModule", 1, "[make64eReqBody] " + paramList);
    }
    localReqBody.rpt_report_info.set(localArrayList);
    return qxp.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private ToServiceMsg a(List<ReportInfo> paramList, String paramString)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("feedsPreload expose report, size = ").append(paramList.size()).append("\n");
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        ReportInfo localReportInfo1 = (ReportInfo)localIterator.next();
        oidb_cmd0x64e.ReportInfo localReportInfo = new oidb_cmd0x64e.ReportInfo();
        localReportInfo.uint64_uin.set(localReportInfo1.mUin);
        localReportInfo.enum_operation.set(localReportInfo1.mOperation);
        localReportInfo.uint64_source_article_id.set(localReportInfo1.mSourceArticleId);
        Object localObject = localReportInfo.bytes_inner_id;
        if (localReportInfo1.mInnerId != null)
        {
          paramList = localReportInfo1.mInnerId;
          label160:
          ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramList));
          localReportInfo.uint32_algorithm_id.set(localReportInfo1.mAlgorithmId);
          localObject = localReportInfo.bytes_gw_common_data;
          if (localReportInfo1.mGWCommonData == null) {
            break label338;
          }
          paramList = localReportInfo1.mGWCommonData;
          label203:
          ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramList));
        }
        for (;;)
        {
          try
          {
            localObject = localStringBuilder.append("feedsPreload reportInfo, uin = ").append(localReportInfo1.mUin).append(", operation = ").append(localReportInfo1.mOperation).append(", articleID = ").append(localReportInfo1.mSourceArticleId).append(", rowKey = ").append(localReportInfo1.mInnerId).append(", gwCommonData = ");
            if (localReportInfo1.mGWCommonData == null) {
              continue;
            }
            paramList = localReportInfo1.mGWCommonData;
            ((StringBuilder)localObject).append(paramList).append(", algorithmID = ").append(localReportInfo1.mAlgorithmId).append("\n");
          }
          catch (Exception paramList)
          {
            label338:
            QLog.d("UserOperationModule", 1, "makeFeedsPreloadReportPkg, e = ", paramList);
            continue;
          }
          localArrayList.add(localReportInfo);
          break;
          paramList = "";
          break label160;
          paramList = "";
          break label203;
          paramList = "";
        }
      }
      localStringBuilder.append("preloadReqInfo = ").append(paramString).append("\n");
      QLog.d("UserOperationModule", 1, new Object[] { localStringBuilder });
    }
    localReqBody.rpt_report_info.set(localArrayList);
    paramList = localReqBody.bytes_pre_load_req_info;
    if (paramString != null) {}
    for (;;)
    {
      paramList.set(ByteStringMicro.copyFromUtf8(paramString));
      return qxp.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
      paramString = "";
    }
  }
  
  private String a(oidb_cmd0x80a.KDEventReportReq paramKDEventReportReq)
  {
    JSONObject localJSONObject1;
    if (paramKDEventReportReq != null) {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("event_id", paramKDEventReportReq.event_id.get() + "");
        localJSONObject1.put("event_name", paramKDEventReportReq.event_name.get());
        localJSONObject1.put("version", paramKDEventReportReq.version.get() + "");
        Object localObject = paramKDEventReportReq.att_list.get();
        if (localObject == null) {
          break label243;
        }
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
            continue;
            return null;
          }
        }
      }
      catch (JSONException paramKDEventReportReq)
      {
        paramKDEventReportReq.printStackTrace();
      }
    }
    if (paramKDEventReportReq.length() > 0) {
      localJSONObject1.put("att_list", paramKDEventReportReq);
    }
    label243:
    paramKDEventReportReq = localJSONObject1.toString();
    return paramKDEventReportReq;
  }
  
  private oidb_cmd0x64e.ReportInfo a(ReportInfo paramReportInfo)
  {
    oidb_cmd0x64e.ReportInfo localReportInfo = new oidb_cmd0x64e.ReportInfo();
    a(localReportInfo);
    a(localReportInfo, paramReportInfo);
    b(localReportInfo, paramReportInfo);
    c(localReportInfo, paramReportInfo);
    return localReportInfo;
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      rao.a.a().a(paramInt1, paramString1, paramString2, paramInt2, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new UserOperationModule.6(this, paramInt1, paramString1, paramString2, paramInt2, paramBoolean));
  }
  
  private void a(oidb_cmd0x64e.ReportInfo paramReportInfo)
  {
    String str = pqh.a();
    if (!TextUtils.isEmpty(str)) {}
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
  
  private void a(oidb_cmd0x64e.ReportInfo paramReportInfo, ReportInfo paramReportInfo1)
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
  
  private void a(oidb_cmd0x80a.RspBody paramRspBody)
  {
    if ((paramRspBody.uint64_delete_kdtab_num_redpnt.has()) && (paramRspBody.uint64_delete_kdtab_num_redpnt.get() == 1L))
    {
      QLog.d("UserOperationModule", 1, "notify to clear msgbox redpnt !");
      QQAppInterface localQQAppInterface = pnn.a();
      if (localQQAppInterface != null) {
        ((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).q();
      }
    }
    if (paramRspBody.uint64_should_hide_kdtab_num_redpnt.has()) {
      if (paramRspBody.uint64_should_hide_kdtab_num_redpnt.get() != 0L) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      bmhv.a("sp_msg_box_80a_enable_receive", Boolean.valueOf(bool));
      QLog.d("UserOperationModule", 1, "receive hide msgbox redpnt flag , canShow : " + bool);
      return;
    }
  }
  
  private int b()
  {
    switch (NetworkUtil.getSystemNetwork(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 1;
  }
  
  private ToServiceMsg b(List<ReportInfo> paramList)
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
          localReportInfo.mFolderStatus = prp.jdField_a_of_type_Int;
        }
        localReportInfo1.enum_op_source.set(3);
        localReportInfo1.uint32_folder_status.set(localReportInfo.mFolderStatus);
        localReportInfo1.enum_operation.set(localReportInfo.mOperation);
        localReportInfo1.bytes_device_id.set(ByteStringMicro.copyFromUtf8(pqh.a()));
        localArrayList.add(localReportInfo1);
      }
    }
    localReqBody.rpt_report_info.set(localArrayList);
    return qxp.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private void b(oidb_cmd0x64e.ReportInfo paramReportInfo, ReportInfo paramReportInfo1)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = paramReportInfo1.mFeedsReportData;
    if (localObject != null)
    {
      paramReportInfo1 = new oidb_cmd0x64e.FeedsReportData();
      paramReportInfo1.uint64_feeds_id.set(((rqf)localObject).jdField_a_of_type_Long);
      paramReportInfo1.uint64_publish_uin.set(((rqf)localObject).jdField_b_of_type_Long);
      paramReportInfo1.uint32_like_total_count.set(((rqf)localObject).jdField_a_of_type_Int);
      paramReportInfo1.uint32_comment_total_count.set(((rqf)localObject).jdField_b_of_type_Int);
      ArrayList localArrayList2 = new ArrayList();
      if ((((rqf)localObject).jdField_a_of_type_JavaUtilList != null) && (!((rqf)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = ((rqf)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList2.add((Long)((Iterator)localObject).next());
        }
        paramReportInfo1.rpt_like_uin_list.set(localArrayList2);
      }
      localArrayList1.add(paramReportInfo1);
      paramReportInfo.rpt_feeds_report_data_list.set(localArrayList1);
    }
  }
  
  private void b(oidb_cmd0x80a.RspBody paramRspBody)
  {
    if (paramRspBody.uint64_uin.has()) {}
    for (long l = paramRspBody.uint64_uin.get();; l = 0L)
    {
      if ((paramRspBody.rsp_kd_event_report_resp.has()) && (paramRspBody.rsp_kd_event_report_resp.get() != null))
      {
        if (((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).condParams.has()) {
          SPEventReportSwitch.a(((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).condParams.get());
        }
        if ((((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).unit_reset.has()) && (((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).unit_reset.get() == 1)) {
          TaskManager.getInstance().reset();
        }
        if (QLog.isColorLevel()) {
          QLog.d("UserOperationModule", 2, "handle0x80aPushEffectEvent, uin:" + l + ";rspKDEventReportResp.result:" + ((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).result.get() + ";rspKDEventReportResp.err_msg" + ((oidb_cmd0x80a.KDEventReportResp)paramRspBody.rsp_kd_event_report_resp.get()).err_msg.get());
        }
      }
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      i = paramFromServiceMsg.getResultCode();
      if (i != 1000) {
        break label190;
      }
      paramFromServiceMsg = null;
      if (paramObject == null) {}
    }
    else
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (Exception paramFromServiceMsg)
      {
        label71:
        paramToServiceMsg = null;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
      if (paramToServiceMsg == null) {
        break label228;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramFromServiceMsg)
    {
      break label95;
      break label71;
    }
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer success");
      }
    }
    label95:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer merge fail ", paramFromServiceMsg);
          }
          continue;
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.d("UserOperationModule", 2, " handleSetKandianTopToServer data == null");
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
      } while (!QLog.isColorLevel());
      paramFromServiceMsg = new StringBuilder().append("handleSetKandianTopToServer failed ");
      if (paramToServiceMsg != null) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error_msg.get();; paramToServiceMsg = "null")
      {
        QLog.d("UserOperationModule", 2, paramToServiceMsg);
        return;
      }
    }
    label190:
    QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer " + i);
  }
  
  private void c(oidb_cmd0x64e.ReportInfo paramReportInfo, ReportInfo paramReportInfo1)
  {
    rqg localrqg = paramReportInfo1.mVideoExtraRepoerData;
    if (localrqg != null)
    {
      paramReportInfo.enum_network_type.set(b());
      paramReportInfo.operator_platform.set(3);
      if (localrqg.jdField_b_of_type_Boolean) {
        paramReportInfo.whether_click_in.set(localrqg.jdField_a_of_type_Boolean);
      }
      if (localrqg.jdField_a_of_type_Int != -1) {
        paramReportInfo.enum_jumpway_which.set(localrqg.jdField_a_of_type_Int);
      }
      if (localrqg.jdField_b_of_type_Int != -1) {
        paramReportInfo.enum_in_onetree_source.set(localrqg.jdField_b_of_type_Int);
      }
      if (localrqg.c != -1) {
        paramReportInfo.enum_in_videochannel_source.set(localrqg.c);
      }
      if (localrqg.d != -1) {
        paramReportInfo.uint32_current_video_time.set(localrqg.d);
      }
      if (localrqg.e != -1) {
        paramReportInfo.uint32_video_duration.set(localrqg.e);
      }
      if ((paramReportInfo1.mOpSource == 5) && (localrqg.f != -1)) {
        paramReportInfo.uint32_onetree_video_from_type.set(localrqg.f);
      }
    }
  }
  
  private void c(oidb_cmd0x80a.RspBody paramRspBody)
  {
    if ((paramRspBody.AIOPulseMaxCnt.has()) && (paramRspBody.firstScnRedPntPulseMaxCnt.has()) && (paramRspBody.leftBtmRedPntPulseMaxCnt.has()))
    {
      long l1 = paramRspBody.leftBtmRedPntPulseMaxCnt.get();
      long l2 = paramRspBody.firstScnRedPntPulseMaxCnt.get();
      long l3 = paramRspBody.AIOPulseMaxCnt.get();
      bmhv.a(pkh.a(), l1, l2, l3);
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      i = paramFromServiceMsg.getResultCode();
      if (i != 1000) {
        break label394;
      }
      paramFromServiceMsg = null;
      if (paramObject == null) {}
    }
    else
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (Exception paramFromServiceMsg)
      {
        label71:
        paramToServiceMsg = null;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
      if (paramToServiceMsg == null) {
        break label432;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramFromServiceMsg)
    {
      break label273;
      break label71;
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer success");
      }
      paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      l = paramToServiceMsg.getInt();
      paramToServiceMsg.get();
      i = paramToServiceMsg.getShort();
      j = paramToServiceMsg.getShort();
      k = paramToServiceMsg.getShort();
      m = paramToServiceMsg.getShort();
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer, request success, tlvCount = " + i + " uin:" + l + " type:" + j + " length:" + k + " value:" + m);
      }
      paramToServiceMsg = (KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (m == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer server no set,upload local ");
        }
        bool = paramToServiceMsg.d();
        if (bool) {
          paramToServiceMsg.c(bool);
        }
      }
    }
    label273:
    while (!QLog.isColorLevel())
    {
      do
      {
        int m;
        do
        {
          for (;;)
          {
            long l;
            int j;
            int k;
            boolean bool;
            return;
            if (QLog.isColorLevel()) {
              QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer merge fail ", paramFromServiceMsg);
            }
            continue;
            paramToServiceMsg = paramFromServiceMsg;
            if (QLog.isColorLevel())
            {
              QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer data == null");
              paramToServiceMsg = paramFromServiceMsg;
            }
          }
          if (m == 1)
          {
            paramToServiceMsg.a(false, true);
            return;
          }
        } while (m != 2);
        paramToServiceMsg.a(true, true);
        return;
      } while (!QLog.isColorLevel());
      paramFromServiceMsg = new StringBuilder().append("handleGetKandianTopFromServer failed ");
      if (paramToServiceMsg != null) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error_msg.get();; paramToServiceMsg = "null")
      {
        QLog.d("UserOperationModule", 2, paramToServiceMsg);
        return;
      }
    }
    label394:
    QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer " + i);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x80a.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      b(paramToServiceMsg);
      c(paramToServiceMsg);
      if ((paramToServiceMsg.lastRecvMsgDuration.has()) && (paramToServiceMsg.lastSendMsgDuration.has())) {
        bmhv.a((int)paramToServiceMsg.lastRecvMsgDuration.get(), (int)paramToServiceMsg.lastSendMsgDuration.get());
      }
      if ((paramToServiceMsg.pulseTimerDuration.has()) && (paramToServiceMsg.pulseTimerDuration.get() != 12345678L)) {
        pwb.a().b((int)paramToServiceMsg.pulseTimerDuration.get());
      }
      if (paramToServiceMsg.leftBtmRedCntMaxForExitAIO.has()) {
        bmhv.e((int)paramToServiceMsg.leftBtmRedCntMaxForExitAIO.get());
      }
      if ((paramToServiceMsg.uint64_main_video_tab_red.has()) && (paramToServiceMsg.uint64_main_video_tab_red.get() > 0L)) {
        ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(new KandianRedDotInfo("kandian_video_tab_reddot_info"));
      }
      if (paramToServiceMsg.uint64_scroll_interval_time.has()) {
        pwo.jdField_a_of_type_Long = paramToServiceMsg.uint64_scroll_interval_time.get();
      }
      if (paramToServiceMsg.uint64_scroll_all_time.has()) {
        pwo.jdField_b_of_type_Long = paramToServiceMsg.uint64_scroll_all_time.get();
      }
      if (paramToServiceMsg.uint64_chat_aio_time.has()) {
        pwb.c = paramToServiceMsg.uint64_chat_aio_time.get();
      }
      if (paramToServiceMsg.force_top_daily_red_day_offset.has())
      {
        QLog.d("UserOperationModule", 2, "daily settop offset : " + paramToServiceMsg.force_top_daily_red_day_offset.get());
        com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager.DailySetTopInfo.settopOffset = paramToServiceMsg.force_top_daily_red_day_offset.get();
      }
      if (paramToServiceMsg.idle_push_wake_param.has()) {
        uwl.a(paramToServiceMsg.idle_push_wake_param.get());
      }
      if (paramToServiceMsg.msg_srt_rule_list.has()) {
        pkd.a().a(paramToServiceMsg.msg_srt_rule_list.get());
      }
      a(paramToServiceMsg);
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "handle0x80aPushEffectEvent, result=" + i);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qxp.a(paramFromServiceMsg, paramObject, new oidb_cmd0x64e.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "handleUserOperationReport, result=" + i);
    }
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = (Boolean)paramToServiceMsg.getAttribute("is_feeds_preload_expose");
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.booleanValue())) {}
    }
    try
    {
      long l = paramToServiceMsg.extraData.getLong("sendtimekey");
      l = System.currentTimeMillis() - l;
      QLog.d("UserOperationModule", 1, new Object[] { "feedsPreload 0x64e, result = ", Integer.valueOf(i), ", cost = ", Long.valueOf(l) });
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        qkt.a(bool, l, i);
        return;
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("UserOperationModule", 1, "handle0x64eUserOperationReport e = ", paramToServiceMsg);
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qxp.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "handle0x886UserOperationReport, result=" + i);
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qxp.a(paramFromServiceMsg, paramObject, new oidb_cmd0xde0.RspBody());
    QLog.d("UserOperationModule", 1, "handleUserActionReport ret : " + i);
  }
  
  public void a() {}
  
  public void a(int paramInt1, String paramString1, int paramInt2, List<oidb_cmd0x80a.AttributeList> paramList, String paramString2, int paramInt3)
  {
    oidb_cmd0x80a.ReqBody localReqBody = new oidb_cmd0x80a.ReqBody();
    long l = Long.valueOf(pkh.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.uint32_app_bitmap.set(3);
    Object localObject = localReqBody.uint32_is_concise_mode;
    int i;
    if (bdfk.b())
    {
      i = 1;
      ((PBUInt32Field)localObject).set(i);
      localReqBody.uint32_privacy_status.set(uve.b());
      if (!bmhv.m()) {
        break label223;
      }
      localReqBody.uint32_kandian_mode.set(3);
    }
    for (;;)
    {
      localObject = new oidb_cmd0x80a.KDEventReportReq();
      if (paramInt1 != -1) {
        ((oidb_cmd0x80a.KDEventReportReq)localObject).event_id.set(paramInt1);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        ((oidb_cmd0x80a.KDEventReportReq)localObject).event_name.set(paramString1);
      }
      if ((paramList != null) && (!paramList.isEmpty())) {
        ((oidb_cmd0x80a.KDEventReportReq)localObject).att_list.set(paramList);
      }
      if (paramInt2 >= 0) {
        ((oidb_cmd0x80a.KDEventReportReq)localObject).version.set(paramInt2);
      }
      localReqBody.req_kd_event_report_req.set((MessageMicro)localObject);
      TaskManager.getInstance().accept(a((oidb_cmd0x80a.KDEventReportReq)localObject));
      a(qxp.a(paramString2, paramInt3, 0, localReqBody.toByteArray()));
      return;
      i = 0;
      break;
      label223:
      if (bmhv.l()) {
        localReqBody.uint32_kandian_mode.set(2);
      } else {
        localReqBody.uint32_kandian_mode.set(1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    Pair localPair = a(paramInt);
    a(paramInt, paramString, -1, paramList, (String)localPair.first, ((Integer)localPair.second).intValue());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x64e")) {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x80a"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x480_9"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x4ff_9"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886"))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x978"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc22"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xde0"));
    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "getKandianTopFromServer begin...");
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[9];
      PkgTools.DWord2Byte(paramString, 0, l);
      paramString[4] = 0;
      PkgTools.Word2Byte(paramString, 5, (short)1);
      PkgTools.DWordTo2Bytes(paramString, 7, jdField_a_of_type_Int);
      paramString = qxp.a("OidbSvc.0x480_9", 1152, 9, paramString);
      paramString.extraData.putBoolean("reqFromReadinjoyHandler", true);
      a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("UserOperationModule", 2, "send_oidb_0x480_9 error", paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UserOperationModule", 2, "setKandianTopToServer value=" + paramInt);
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[13];
      PkgTools.DWord2Byte(paramString, 0, l);
      paramString[4] = 0;
      PkgTools.Word2Byte(paramString, 5, (short)1);
      PkgTools.DWordTo2Bytes(paramString, 7, jdField_a_of_type_Int);
      PkgTools.Word2Byte(paramString, 9, (short)2);
      PkgTools.Word2Byte(paramString, 11, (short)paramInt);
      paramString = qxp.a("OidbSvc.0x4ff_9", 1279, 9, paramString);
      paramString.extraData.putBoolean("reqFromReadinjoyHandler", true);
      a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("UserOperationModule", 2, "setKandianTopToServer ex", paramString);
    }
  }
  
  public void a(String paramString1, long paramLong, boolean paramBoolean, String paramString2, qie paramqie, int paramInt)
  {
    a(paramString1, String.valueOf(paramLong), paramBoolean, paramString2, paramqie, paramInt);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, qie paramqie)
  {
    a(paramString1, paramString2, paramBoolean, paramString3, paramqie, 2);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, qie paramqie, int paramInt)
  {
    a(paramString1, paramString2, paramBoolean, paramString3, paramqie, paramInt, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, qie paramqie, int paramInt, boolean paramBoolean2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "[request0x978] follow uin:" + paramString2 + ", isFollow:" + paramBoolean1);
    }
    Object localObject2 = new oidb_cmd0x978.OneFollowOperationInfo();
    try
    {
      ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint64_dst_uin.set(Long.valueOf(paramString2).longValue());
      ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint32_op_account_type.set(paramInt);
      localObject1 = new oidb_cmd0x978.ReqFollowOperationPara();
      PBEnumField localPBEnumField = ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).op_type;
      paramInt = i;
      if (paramBoolean1) {
        paramInt = 1;
      }
      localPBEnumField.set(paramInt);
      ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).rpt_follow_operation_info.add((MessageMicro)localObject2);
      localObject2 = new oidb_cmd0x978.ReqBody();
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        ((oidb_cmd0x978.ReqBody)localObject2).uint64_uin.set(Long.valueOf(paramString1).longValue());
        ((oidb_cmd0x978.ReqBody)localObject2).msg_req_follow_para.set((MessageMicro)localObject1);
        Object localObject1 = qxp.a("OidbSvc.0x978", 2424, 0, ((oidb_cmd0x978.ReqBody)localObject2).toByteArray());
        paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramqie));
        ((ToServiceMsg)localObject1).addAttribute("distUin", paramString2);
        ((ToServiceMsg)localObject1).addAttribute("callbackSeq", Integer.valueOf(paramInt));
        ((ToServiceMsg)localObject1).addAttribute("selfUin", paramString1);
        ((ToServiceMsg)localObject1).addAttribute("avatarUrl", paramString3);
        ((ToServiceMsg)localObject1).addAttribute("isBlackSceneTip", Boolean.valueOf(paramBoolean2));
        a((ToServiceMsg)localObject1);
        return;
        localNumberFormatException1 = localNumberFormatException1;
        localNumberFormatException1.printStackTrace();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          localNumberFormatException2.printStackTrace();
        }
      }
    }
  }
  
  public void a(ArrayList<qey> paramArrayList, qid paramqid, int paramInt)
  {
    a(paramArrayList, true, paramqid, paramInt);
  }
  
  protected void a(ArrayList<qey> paramArrayList, boolean paramBoolean, qic paramqic, int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "batch0x978, followList = " + paramArrayList + ", isFollow = " + paramBoolean + ", callback = " + paramqic + ", refer = " + paramInt);
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    oidb_cmd0x978.ReqFollowOperationPara localReqFollowOperationPara = new oidb_cmd0x978.ReqFollowOperationPara();
    Object localObject = localReqFollowOperationPara.op_type;
    if (paramBoolean) {
      i = 1;
    }
    ((PBEnumField)localObject).set(i);
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (qey)paramArrayList.get(i);
      oidb_cmd0x978.OneFollowOperationInfo localOneFollowOperationInfo = new oidb_cmd0x978.OneFollowOperationInfo();
      localOneFollowOperationInfo.uint64_dst_uin.set(Long.valueOf(((qey)localObject).jdField_a_of_type_Long).longValue());
      localOneFollowOperationInfo.uint32_op_account_type.set(((qey)localObject).jdField_a_of_type_Int);
      localReqFollowOperationPara.rpt_follow_operation_info.add(localOneFollowOperationInfo);
      i += 1;
    }
    paramArrayList = new oidb_cmd0x978.ReqBody();
    paramArrayList.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue());
    paramArrayList.msg_req_follow_para.set(localReqFollowOperationPara);
    paramArrayList.uint32_refer.set(paramInt);
    paramArrayList = qxp.a("OidbSvc.0x978", 2424, 0, paramArrayList.toByteArray());
    paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramqic));
    paramArrayList.addAttribute("callbackSeq", Integer.valueOf(paramInt));
    paramArrayList.addAttribute("selfUin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    paramArrayList.addAttribute("isBatch", Boolean.valueOf(true));
    a(paramArrayList);
  }
  
  public void a(List<ReportInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, paramList.toString());
    }
    a(a(paramList));
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    paramList = a(paramList, paramString);
    paramList.getAttributes().put("is_feeds_preload_expose", Boolean.valueOf(true));
    a(paramList);
  }
  
  public void a(rjm paramrjm, Context paramContext)
  {
    ThreadManager.executeOnSubThread(new UserOperationModule.7(this, paramrjm, paramContext));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("callbackSeq")).intValue();
    Object localObject1;
    boolean bool1;
    label62:
    Object localObject2;
    label84:
    boolean bool2;
    label109:
    oidb_cmd0x978.RspBody localRspBody;
    if (paramToServiceMsg.getAttribute("distUin") != null)
    {
      localObject1 = (String)paramToServiceMsg.getAttribute("distUin");
      if (paramToServiceMsg.getAttribute("isBatch") == null) {
        break label195;
      }
      bool1 = ((Boolean)paramToServiceMsg.getAttribute("isBatch")).booleanValue();
      if (paramToServiceMsg.getAttribute("avatarUrl") == null) {
        break label201;
      }
      localObject2 = (String)paramToServiceMsg.getAttribute("avatarUrl");
      if (paramToServiceMsg.getAttribute("isBlackSceneTip") == null) {
        break label209;
      }
      bool2 = ((Boolean)paramToServiceMsg.getAttribute("isBlackSceneTip")).booleanValue();
      paramToServiceMsg = (qic)((WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).get();
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      localRspBody = new oidb_cmd0x978.RspBody();
      i = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
      QLog.d("UserOperationModule", 2, "handle 978resp  retCode : " + i);
      if (paramToServiceMsg != null) {
        break label215;
      }
    }
    label195:
    label201:
    label209:
    label215:
    do
    {
      do
      {
        return;
        localObject1 = "";
        break;
        bool1 = false;
        break label62;
        localObject2 = "";
        break label84;
        bool2 = false;
        break label109;
        if (i != 0) {
          break label611;
        }
      } while (!localRspBody.msg_rsp_follow_op_result.has());
      int j = ((oidb_cmd0x978.OneFollowOperationResult)((oidb_cmd0x978.RspFollowOperationResult)localRspBody.msg_rsp_follow_op_result.get()).rpt_follow_operation_result.get().get(0)).uint32_guide_type.get();
      QLog.i("UserOperationModule", 1, "handle 978resp  guideType : " + j);
      if (j != 0) {
        ThreadManager.getUIHandler().post(new UserOperationModule.1(this, (String)localObject2, (String)localObject1, j, bool2));
      }
      paramFromServiceMsg = (oidb_cmd0x978.RspFollowOperationResult)localRspBody.msg_rsp_follow_op_result.get();
      if (((oidb_cmd0x978.RspFollowOperationResult)paramFromServiceMsg.get()).op_type.get() == 2) {
        ThreadManager.getUIHandler().post(new UserOperationModule.2(this, (String)localObject1));
      }
    } while (!paramFromServiceMsg.rpt_follow_operation_result.has());
    if (bool1)
    {
      paramObject = new ArrayList(paramFromServiceMsg.rpt_follow_operation_result.get().size());
      localObject1 = paramFromServiceMsg.rpt_follow_operation_result.get().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0x978.OneFollowOperationResult)((Iterator)localObject1).next();
        long l = ((oidb_cmd0x978.OneFollowOperationResult)localObject2).uint64_dst_uin.get();
        i = ((oidb_cmd0x978.OneFollowOperationResult)localObject2).uint32_op_account_type.get();
        if (((oidb_cmd0x978.OneFollowOperationResult)localObject2).enum_follow_status.get() == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          paramObject.add(new qey(l, i, bool1));
          break;
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new UserOperationModule.3(this, paramObject, paramFromServiceMsg, paramToServiceMsg));
      return;
    }
    paramFromServiceMsg = paramFromServiceMsg.rpt_follow_operation_result.get().iterator();
    while (paramFromServiceMsg.hasNext())
    {
      paramObject = (oidb_cmd0x978.OneFollowOperationResult)paramFromServiceMsg.next();
      if (TextUtils.equals(String.valueOf(paramObject.uint64_dst_uin.get()), (CharSequence)localObject1))
      {
        pvj.a().b(Long.valueOf((String)localObject1).longValue(), paramObject.enum_follow_status.get());
        this.jdField_a_of_type_AndroidOsHandler.post(new UserOperationModule.4(this, paramToServiceMsg, (String)localObject1, paramObject));
        return;
      }
    }
    label611:
    this.jdField_a_of_type_AndroidOsHandler.post(new UserOperationModule.5(this, bool1, paramToServiceMsg, i, (String)localObject1));
  }
  
  public void b(ArrayList<qey> paramArrayList, qid paramqid, int paramInt)
  {
    a(paramArrayList, false, paramqid, paramInt);
  }
  
  public void b(List<ReportInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, new Object[] { paramList });
    }
    a(b(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qia
 * JD-Core Version:    0.7.0.1
 */