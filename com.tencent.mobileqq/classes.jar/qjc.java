import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJSearchUGCTagsHandler.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.SearchInfo;

public class qjc
  extends qii
{
  public qjc(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(long paramLong)
  {
    Object localObject = new oidb_cmd0xb83.ReqRecommendTagInfo();
    ((oidb_cmd0xb83.ReqRecommendTagInfo)localObject).uint64_topic_id.set(paramLong);
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    localReqBody.msg_req_recommend_tag_info.set((MessageMicro)localObject);
    localObject = qxp.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray());
    this.jdField_a_of_type_Qep.a((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xb83.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    if (i == 0)
    {
      QLog.d("RIJSearchUGCTagsHandler", 1, "handle0xb83GetKeywordList result OK");
      paramObject = qxm.d(paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_tag_info_list.get());
      paramToServiceMsg = qxm.d(paramToServiceMsg.msg_rsp_recommend_tag_info.rpt_msg_tag_info_list.get());
      paramFromServiceMsg.addAll(paramObject);
      paramFromServiceMsg.addAll(paramToServiceMsg);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJSearchUGCTagsHandler.1(this, paramFromServiceMsg));
      return;
      QLog.d("RIJSearchUGCTagsHandler", 2, "handle0xb83GetKeywordList: failed, result: " + i);
    }
  }
  
  public void a(String paramString)
  {
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      oidb_cmd0xb83.SearchInfo localSearchInfo = new oidb_cmd0xb83.SearchInfo();
      localSearchInfo.bytes_key.set(ByteStringMicro.copyFromUtf8(paramString));
      paramString = new oidb_cmd0xb83.ReqSearchTagInfo();
      paramString.rpt_msg_search_info_list.add(localSearchInfo);
      localReqBody.msg_req_search_tag_info.set(paramString);
    }
    for (;;)
    {
      paramString = qxp.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray());
      this.jdField_a_of_type_Qep.a(paramString);
      return;
      paramString = new oidb_cmd0xb83.ReqRecommendTagInfo();
      localReqBody.msg_req_recommend_tag_info.set(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjc
 * JD-Core Version:    0.7.0.1
 */