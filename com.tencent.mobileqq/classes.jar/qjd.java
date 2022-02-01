import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJSearchUGCTopicHandler.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqBody;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqSearchTopicInfo;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspBody;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspSearchTopicResult;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.SearchInfo;

public class qjd
  extends qii
{
  public qjd(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbde.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    paramObject = new ArrayList();
    if (i == 0)
    {
      QLog.d("RIJSearchUGCTopicHandler", 2, "handle0xbdeGetTopicList: result OK");
      Iterator localIterator = paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_search_info_list.get().iterator();
      while (localIterator.hasNext()) {
        paramObject.add(((oidb_cmd0xbde.SearchInfo)localIterator.next()).bytes_key.get().toStringUtf8());
      }
      paramFromServiceMsg.addAll(qxm.e(paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_tag_info_list.get()));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJSearchUGCTopicHandler.1(this, paramObject, paramFromServiceMsg));
      return;
      QLog.d("RIJSearchUGCTopicHandler", 2, "handle0xbdeGetTopicList: failed, result: " + i);
    }
  }
  
  public void a(String paramString)
  {
    oidb_cmd0xbde.ReqBody localReqBody = new oidb_cmd0xbde.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      oidb_cmd0xbde.SearchInfo localSearchInfo = new oidb_cmd0xbde.SearchInfo();
      localSearchInfo.bytes_key.set(ByteStringMicro.copyFromUtf8(paramString));
      paramString = new oidb_cmd0xbde.ReqSearchTopicInfo();
      paramString.rpt_msg_search_info_list.add(localSearchInfo);
      localReqBody.uint32_query_mode.set(1);
      localReqBody.msg_req_search_tag_info.set(paramString);
    }
    paramString = qxp.a("OidbSvc.0xbde", 3038, 0, localReqBody.toByteArray());
    this.jdField_a_of_type_Qep.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjd
 * JD-Core Version:    0.7.0.1
 */