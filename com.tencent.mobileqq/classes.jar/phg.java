import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.4;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.common.app.AppInterface;
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

public class phg
  extends pgp
{
  static int jdField_a_of_type_Int = 42105;
  private SparseArray<WeakReference<phh>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public phg(awgf paramawgf, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(null, paramawgf, paramExecutorService, parampuz, paramHandler);
  }
  
  public phg(AppInterface paramAppInterface, awgf paramawgf, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawgf, paramExecutorService, parampuz, paramHandler);
  }
  
  private int a()
  {
    switch (bdin.a(BaseApplication.getContext()))
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
  
  private ToServiceMsg a(List<ReportInfo> paramList)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ReportInfo localReportInfo = (ReportInfo)localIterator.next();
        oidb_cmd0x64e.ReportInfo localReportInfo1 = new oidb_cmd0x64e.ReportInfo();
        localReportInfo1.uint64_uin.set(localReportInfo.mUin);
        localReportInfo1.uint32_source.set(localReportInfo.mSource);
        localReportInfo1.operator_platform.set(3);
        if (localReportInfo.mSourceArticleId != -1L) {
          localReportInfo1.uint64_source_article_id.set(localReportInfo.mSourceArticleId);
        }
        if (localReportInfo.mChannelId != -1) {
          localReportInfo1.uint32_channel_id.set(localReportInfo.mChannelId);
        }
        if (localReportInfo.mAlgorithmId != -1) {
          localReportInfo1.uint32_algorithm_id.set(localReportInfo.mAlgorithmId);
        }
        if (localReportInfo.mStrategyId != -1) {
          localReportInfo1.uint32_strategy_id.set(localReportInfo.mStrategyId);
        }
        if (localReportInfo.mFolderStatus > 0) {
          localReportInfo1.uint32_folder_status.set(localReportInfo.mFolderStatus);
        }
        localReportInfo1.enum_operation.set(localReportInfo.mOperation);
        if ((localReportInfo.mOperation == 9) && (localReportInfo.mReadTimeLength != -1)) {
          localReportInfo1.uint32_read_time_length.set(localReportInfo.mReadTimeLength);
        }
        if ((localReportInfo.mOperation == 12) && (localReportInfo.mPlayTimeLength != -1)) {
          localReportInfo1.uint32_play_time_length.set(localReportInfo.mPlayTimeLength);
        }
        if (!TextUtils.isEmpty(localReportInfo.mCollectUrl)) {
          localReportInfo1.bytes_collect_url.set(ByteStringMicro.copyFromUtf8(localReportInfo.mCollectUrl));
        }
        if (!TextUtils.isEmpty(localReportInfo.mInnerId)) {
          localReportInfo1.bytes_inner_id.set(ByteStringMicro.copyFromUtf8(localReportInfo.mInnerId));
        }
        if (localReportInfo.mOpSource >= 0) {
          localReportInfo1.enum_op_source.set(localReportInfo.mOpSource);
        }
        if (localReportInfo.mServerContext != null) {
          localReportInfo1.bytes_server_context.set(ByteStringMicro.copyFrom(localReportInfo.mServerContext));
        }
        localReportInfo1.bool_is_gallery.set(localReportInfo.mIsGallery);
        if (localReportInfo.mGalleryReportInfo != null) {
          localReportInfo1.bytes_gallery_report_info.set(ByteStringMicro.copyFrom(localReportInfo.mGalleryReportInfo));
        }
        if (localReportInfo.mArticleLength != -1) {
          localReportInfo1.uint32_article_length.set(localReportInfo.mArticleLength);
        }
        if (localReportInfo.mReadArticleLength != -1) {
          localReportInfo1.uint32_read_article_length.set(localReportInfo.mReadArticleLength);
        }
        if (localReportInfo.mHotWord != null) {
          localReportInfo1.bytes_hot_word.set(ByteStringMicro.copyFromUtf8(localReportInfo.mHotWord));
        }
        Object localObject1 = ors.h();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        try
        {
          localReportInfo1.bytes_device_id.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          if (!TextUtils.isEmpty(localReportInfo.mSearchTagName)) {
            localReportInfo1.bytes_search_tag_name.set(ByteStringMicro.copyFromUtf8(localReportInfo.mSearchTagName));
          }
          if (localReportInfo.mColumnID != -1) {
            localReportInfo1.uint32_column_id.set(localReportInfo.mColumnID);
          }
          if (!TextUtils.isEmpty(localReportInfo.videoReportInfo)) {
            localReportInfo1.bytes_video_report_info.set(ByteStringMicro.copyFromUtf8(localReportInfo.videoReportInfo));
          }
          if (!TextUtils.isEmpty(localReportInfo.firstVideoRowkey)) {
            localReportInfo1.bytes_first_rowkey.set(ByteStringMicro.copyFromUtf8(localReportInfo.firstVideoRowkey));
          }
          localObject1 = new ArrayList();
          Object localObject2 = localReportInfo.mFeedsReportData;
          if (localObject2 != null)
          {
            localFeedsReportData = new oidb_cmd0x64e.FeedsReportData();
            localFeedsReportData.uint64_feeds_id.set(((qlv)localObject2).jdField_a_of_type_Long);
            localFeedsReportData.uint64_publish_uin.set(((qlv)localObject2).jdField_b_of_type_Long);
            localFeedsReportData.uint32_like_total_count.set(((qlv)localObject2).jdField_a_of_type_Int);
            localFeedsReportData.uint32_comment_total_count.set(((qlv)localObject2).jdField_b_of_type_Int);
            localArrayList2 = new ArrayList();
            if ((((qlv)localObject2).jdField_a_of_type_JavaUtilList != null) && (!((qlv)localObject2).jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              localObject2 = ((qlv)localObject2).jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList2.add((Long)((Iterator)localObject2).next());
              }
            }
          }
        }
        catch (Exception localException)
        {
          oidb_cmd0x64e.FeedsReportData localFeedsReportData;
          ArrayList localArrayList2;
          for (;;)
          {
            localException.printStackTrace();
          }
          localFeedsReportData.rpt_like_uin_list.set(localArrayList2);
          localException.add(localFeedsReportData);
          localReportInfo1.rpt_feeds_report_data_list.set(localException);
          qlw localqlw = localReportInfo.mVideoExtraRepoerData;
          if (localqlw != null)
          {
            localReportInfo1.enum_network_type.set(b());
            localReportInfo1.operator_platform.set(3);
            if (localqlw.jdField_b_of_type_Boolean) {
              localReportInfo1.whether_click_in.set(localqlw.jdField_a_of_type_Boolean);
            }
            if (localqlw.jdField_a_of_type_Int != -1) {
              localReportInfo1.enum_jumpway_which.set(localqlw.jdField_a_of_type_Int);
            }
            if (localqlw.jdField_b_of_type_Int != -1) {
              localReportInfo1.enum_in_onetree_source.set(localqlw.jdField_b_of_type_Int);
            }
            if (localqlw.c != -1) {
              localReportInfo1.enum_in_videochannel_source.set(localqlw.c);
            }
            if (localqlw.d != -1) {
              localReportInfo1.uint32_current_video_time.set(localqlw.d);
            }
            if (localqlw.e != -1) {
              localReportInfo1.uint32_video_duration.set(localqlw.e);
            }
            if ((localReportInfo.mOpSource == 5) && (localqlw.f != -1)) {
              localReportInfo1.uint32_onetree_video_from_type.set(localqlw.f);
            }
          }
          if (localReportInfo.replyUin != -1L) {
            localReportInfo1.uint64_reply_uin.set(localReportInfo.replyUin);
          }
          if (!TextUtils.isEmpty(localReportInfo.replyID)) {
            localReportInfo1.bytes_reply_id.set(ByteStringMicro.copyFromUtf8(localReportInfo.replyID));
          }
          if (localReportInfo.srtClickInfo != null) {
            localReportInfo1.msg_srt_click_info.set(localReportInfo.srtClickInfo);
          }
          localArrayList1.add(localReportInfo1);
        }
      }
      QLog.d("UserOperationModule", 1, "[make64eReqBody] " + paramList);
    }
    localReqBody.rpt_report_info.set(localArrayList1);
    return pvb.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
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
          label162:
          ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramList));
          localReportInfo.uint32_algorithm_id.set(localReportInfo1.mAlgorithmId);
          localObject = localReportInfo.bytes_gw_common_data;
          if (localReportInfo1.mGWCommonData == null) {
            break label341;
          }
          paramList = localReportInfo1.mGWCommonData;
          label205:
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
            label341:
            QLog.d("UserOperationModule", 1, "makeFeedsPreloadReportPkg, e = ", paramList);
            continue;
          }
          localArrayList.add(localReportInfo);
          break;
          paramList = "";
          break label162;
          paramList = "";
          break label205;
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
      return pvb.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
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
  
  private int b()
  {
    switch (bdin.a(BaseApplication.getContext()))
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
          localReportInfo.mFolderStatus = ors.d;
        }
        localReportInfo1.enum_op_source.set(3);
        localReportInfo1.uint32_folder_status.set(localReportInfo.mFolderStatus);
        localReportInfo1.enum_operation.set(localReportInfo.mOperation);
        localReportInfo1.bytes_device_id.set(ByteStringMicro.copyFromUtf8(ors.h()));
        localArrayList.add(localReportInfo1);
      }
    }
    localReqBody.rpt_report_info.set(localArrayList);
    return pvb.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      i = paramFromServiceMsg.getResultCode();
      if (i != 1000) {
        break label194;
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
        break label233;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramFromServiceMsg)
    {
      break label96;
      break label71;
    }
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer success");
      }
    }
    label96:
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
    label194:
    QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer " + i);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      i = paramFromServiceMsg.getResultCode();
      if (i != 1000) {
        break label400;
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
        break label439;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramFromServiceMsg)
    {
      break label276;
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
      paramToServiceMsg = (KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(162);
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
    label276:
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
    label400:
    QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer " + i);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x80a.RspBody();
    int i = pvb.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {
      if (!paramToServiceMsg.uint64_uin.has()) {
        break label632;
      }
    }
    label632:
    for (long l1 = paramToServiceMsg.uint64_uin.get();; l1 = 0L)
    {
      if ((paramToServiceMsg.rsp_kd_event_report_resp.has()) && (paramToServiceMsg.rsp_kd_event_report_resp.get() != null))
      {
        if (((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).condParams.has()) {
          SPEventReportSwitch.a(((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).condParams.get());
        }
        if ((((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).unit_reset.has()) && (((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).unit_reset.get() == 1)) {
          TaskManager.getInstance().reset();
        }
        if (QLog.isColorLevel()) {
          QLog.d("UserOperationModule", 2, "handle0x80aPushEffectEvent, uin:" + l1 + ";rspKDEventReportResp.result:" + ((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).result.get() + ";rspKDEventReportResp.err_msg" + ((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).err_msg.get());
        }
      }
      if ((paramToServiceMsg.AIOPulseMaxCnt.has()) && (paramToServiceMsg.firstScnRedPntPulseMaxCnt.has()) && (paramToServiceMsg.leftBtmRedPntPulseMaxCnt.has()))
      {
        l1 = paramToServiceMsg.leftBtmRedPntPulseMaxCnt.get();
        long l2 = paramToServiceMsg.firstScnRedPntPulseMaxCnt.get();
        long l3 = paramToServiceMsg.AIOPulseMaxCnt.get();
        bkbq.a(ors.a(), l1, l2, l3);
      }
      if ((paramToServiceMsg.lastRecvMsgDuration.has()) && (paramToServiceMsg.lastSendMsgDuration.has())) {
        bkbq.a((int)paramToServiceMsg.lastRecvMsgDuration.get(), (int)paramToServiceMsg.lastSendMsgDuration.get());
      }
      if ((paramToServiceMsg.pulseTimerDuration.has()) && (paramToServiceMsg.pulseTimerDuration.get() != 12345678L)) {
        oxp.a().b((int)paramToServiceMsg.pulseTimerDuration.get());
      }
      if (paramToServiceMsg.leftBtmRedCntMaxForExitAIO.has()) {
        bkbq.f((int)paramToServiceMsg.leftBtmRedCntMaxForExitAIO.get());
      }
      if ((paramToServiceMsg.uint64_main_video_tab_red.has()) && (paramToServiceMsg.uint64_main_video_tab_red.get() > 0L)) {
        ((KandianMergeManager)ors.a().getManager(162)).a(new KandianRedDotInfo("kandian_video_tab_reddot_info"));
      }
      if (paramToServiceMsg.uint64_scroll_interval_time.has()) {
        oyb.jdField_a_of_type_Long = paramToServiceMsg.uint64_scroll_interval_time.get();
      }
      if (paramToServiceMsg.uint64_scroll_all_time.has()) {
        oyb.jdField_b_of_type_Long = paramToServiceMsg.uint64_scroll_all_time.get();
      }
      if (paramToServiceMsg.uint64_chat_aio_time.has()) {
        oxp.c = paramToServiceMsg.uint64_chat_aio_time.get();
      }
      if (paramToServiceMsg.force_top_daily_red_day_offset.has())
      {
        QLog.d("UserOperationModule", 2, "daily settop offset : " + paramToServiceMsg.force_top_daily_red_day_offset.get());
        com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager.DailySetTopInfo.settopOffset = paramToServiceMsg.force_top_daily_red_day_offset.get();
      }
      if (paramToServiceMsg.idle_push_wake_param.has()) {
        tah.a(paramToServiceMsg.idle_push_wake_param.get());
      }
      if (paramToServiceMsg.msg_srt_rule_list.has()) {
        oro.a().a(paramToServiceMsg.msg_srt_rule_list.get());
      }
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handle0x80aPushEffectEvent, result=" + i);
      }
      return;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = pvb.a(paramFromServiceMsg, paramObject, new oidb_cmd0x64e.RspBody());
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
        pix.a(bool, l, i);
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
    int i = pvb.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "handle0x886UserOperationReport, result=" + i);
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = pvb.a(paramFromServiceMsg, paramObject, new oidb_cmd0xde0.RspBody());
    QLog.d("UserOperationModule", 1, "handleUserActionReport ret : " + i);
  }
  
  public void a() {}
  
  public void a(int paramInt1, String paramString1, int paramInt2, List<oidb_cmd0x80a.AttributeList> paramList, String paramString2, int paramInt3)
  {
    oidb_cmd0x80a.ReqBody localReqBody = new oidb_cmd0x80a.ReqBody();
    long l = Long.valueOf(ors.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.uint32_app_bitmap.set(3);
    Object localObject = localReqBody.uint32_is_concise_mode;
    int i;
    if (azmk.b())
    {
      i = 1;
      ((PBUInt32Field)localObject).set(i);
      localReqBody.uint32_privacy_status.set(syz.b());
      if (!bkbq.j()) {
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
      a(pvb.a(paramString2, paramInt3, 0, localReqBody.toByteArray()));
      return;
      i = 0;
      break;
      label223:
      if (bkbq.i()) {
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
      bdqa.a(paramString, 0, l);
      paramString[4] = 0;
      bdqa.a(paramString, 5, (short)1);
      bdqa.a(paramString, 7, jdField_a_of_type_Int);
      paramString = pvb.a("OidbSvc.0x480_9", 1152, 9, paramString);
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
      bdqa.a(paramString, 0, l);
      paramString[4] = 0;
      bdqa.a(paramString, 5, (short)1);
      bdqa.a(paramString, 7, jdField_a_of_type_Int);
      bdqa.a(paramString, 9, (short)2);
      bdqa.a(paramString, 11, (short)paramInt);
      paramString = pvb.a("OidbSvc.0x4ff_9", 1279, 9, paramString);
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
  
  public void a(String paramString, long paramLong, boolean paramBoolean, phj paramphj, int paramInt)
  {
    a(paramString, String.valueOf(paramLong), paramBoolean, paramphj, paramInt);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, phj paramphj)
  {
    a(paramString1, paramString2, paramBoolean, paramphj, 2);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, phj paramphj, int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "[request0x978] follow uin:" + paramString2 + ", isFollow:" + paramBoolean);
    }
    Object localObject2 = new oidb_cmd0x978.OneFollowOperationInfo();
    try
    {
      ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint64_dst_uin.set(Long.valueOf(paramString2).longValue());
      ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint32_op_account_type.set(paramInt);
      localObject1 = new oidb_cmd0x978.ReqFollowOperationPara();
      PBEnumField localPBEnumField = ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).op_type;
      paramInt = i;
      if (paramBoolean) {
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
        Object localObject1 = pvb.a("OidbSvc.0x978", 2424, 0, ((oidb_cmd0x978.ReqBody)localObject2).toByteArray());
        paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramphj));
        ((ToServiceMsg)localObject1).addAttribute("distUin", paramString2);
        ((ToServiceMsg)localObject1).addAttribute("callbackSeq", Integer.valueOf(paramInt));
        ((ToServiceMsg)localObject1).addAttribute("selfUin", paramString1);
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
  
  public void a(ArrayList<pff> paramArrayList, phi paramphi, int paramInt)
  {
    a(paramArrayList, true, paramphi, paramInt);
  }
  
  protected void a(ArrayList<pff> paramArrayList, boolean paramBoolean, phh paramphh, int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "batch0x978, followList = " + paramArrayList + ", isFollow = " + paramBoolean + ", callback = " + paramphh + ", refer = " + paramInt);
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
      localObject = (pff)paramArrayList.get(i);
      oidb_cmd0x978.OneFollowOperationInfo localOneFollowOperationInfo = new oidb_cmd0x978.OneFollowOperationInfo();
      localOneFollowOperationInfo.uint64_dst_uin.set(Long.valueOf(((pff)localObject).jdField_a_of_type_Long).longValue());
      localOneFollowOperationInfo.uint32_op_account_type.set(((pff)localObject).jdField_a_of_type_Int);
      localReqFollowOperationPara.rpt_follow_operation_info.add(localOneFollowOperationInfo);
      i += 1;
    }
    paramArrayList = new oidb_cmd0x978.ReqBody();
    paramArrayList.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue());
    paramArrayList.msg_req_follow_para.set(localReqFollowOperationPara);
    paramArrayList.uint32_refer.set(paramInt);
    paramArrayList = pvb.a("OidbSvc.0x978", 2424, 0, paramArrayList.toByteArray());
    paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramphh));
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
  
  public void a(qhl paramqhl, Context paramContext)
  {
    ThreadManager.executeOnSubThread(new UserOperationModule.4(this, paramqhl, paramContext));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("callbackSeq")).intValue();
    Object localObject1;
    boolean bool;
    label62:
    Object localObject2;
    if (paramToServiceMsg.getAttribute("distUin") != null)
    {
      localObject1 = (String)paramToServiceMsg.getAttribute("distUin");
      if (paramToServiceMsg.getAttribute("isBatch") == null) {
        break label149;
      }
      bool = ((Boolean)paramToServiceMsg.getAttribute("isBatch")).booleanValue();
      paramToServiceMsg = (phh)((WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).get();
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      localObject2 = new oidb_cmd0x978.RspBody();
      i = pvb.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
      QLog.d("UserOperationModule", 2, "handle 978resp  retCode : " + i);
      if (paramToServiceMsg != null) {
        break label155;
      }
    }
    label149:
    label155:
    do
    {
      do
      {
        return;
        localObject1 = "";
        break;
        bool = false;
        break label62;
        if (i != 0) {
          break label428;
        }
      } while (!((oidb_cmd0x978.RspBody)localObject2).msg_rsp_follow_op_result.has());
      paramFromServiceMsg = (oidb_cmd0x978.RspFollowOperationResult)((oidb_cmd0x978.RspBody)localObject2).msg_rsp_follow_op_result.get();
    } while (!paramFromServiceMsg.rpt_follow_operation_result.has());
    if (bool)
    {
      paramObject = new ArrayList(paramFromServiceMsg.rpt_follow_operation_result.get().size());
      localObject1 = paramFromServiceMsg.rpt_follow_operation_result.get().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0x978.OneFollowOperationResult)((Iterator)localObject1).next();
        long l = ((oidb_cmd0x978.OneFollowOperationResult)localObject2).uint64_dst_uin.get();
        i = ((oidb_cmd0x978.OneFollowOperationResult)localObject2).uint32_op_account_type.get();
        if (((oidb_cmd0x978.OneFollowOperationResult)localObject2).enum_follow_status.get() == 2) {}
        for (bool = true;; bool = false)
        {
          paramObject.add(new pff(l, i, bool));
          break;
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new UserOperationModule.1(this, paramObject, paramFromServiceMsg, paramToServiceMsg));
      return;
    }
    paramFromServiceMsg = paramFromServiceMsg.rpt_follow_operation_result.get().iterator();
    while (paramFromServiceMsg.hasNext())
    {
      paramObject = (oidb_cmd0x978.OneFollowOperationResult)paramFromServiceMsg.next();
      if (TextUtils.equals(String.valueOf(paramObject.uint64_dst_uin.get()), (CharSequence)localObject1))
      {
        owy.a().a(Long.valueOf((String)localObject1).longValue(), paramObject.enum_follow_status.get());
        this.jdField_a_of_type_AndroidOsHandler.post(new UserOperationModule.2(this, paramToServiceMsg, (String)localObject1, paramObject));
        return;
      }
    }
    label428:
    this.jdField_a_of_type_AndroidOsHandler.post(new UserOperationModule.3(this, bool, paramToServiceMsg, i, (String)localObject1));
  }
  
  public void b(ArrayList<pff> paramArrayList, phi paramphi, int paramInt)
  {
    a(paramArrayList, false, paramphi, paramInt);
  }
  
  public void b(List<ReportInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, new Object[] { paramList });
    }
    a(b(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     phg
 * JD-Core Version:    0.7.0.1
 */