import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCreateUGCTopicHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.ReqBody;
import tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.RspBody;

public class qir
  extends qii
{
  public qir(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    oidb_cmd0xc16.ReqBody localReqBody = new oidb_cmd0xc16.ReqBody();
    Object localObject1 = "";
    if (paramTopicInfo != null)
    {
      long l = paramTopicInfo.b();
      localReqBody.uint64_uin.set(l);
      Object localObject2 = paramTopicInfo.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = paramTopicInfo.b();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      String str = paramTopicInfo.d();
      localObject3 = str;
      if (str == null) {
        localObject3 = "";
      }
      str = paramTopicInfo.c();
      paramTopicInfo = str;
      if (str == null) {
        paramTopicInfo = "";
      }
      localReqBody.bytes_topic_title.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localReqBody.bytes_topic_desc.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localReqBody.bytes_topic_pic_url.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      localReqBody.bytes_topic_cover_pic_url.set(ByteStringMicro.copyFromUtf8(paramTopicInfo));
      localObject1 = "uin:" + l + "  title:" + (String)localObject1 + "  des:" + (String)localObject2 + " headUrl:" + (String)localObject3 + " coerUrl:" + paramTopicInfo;
    }
    QLog.d("RIJCreateUGCTopicHandler", 1, " request0xc16CreateTopic, " + (String)localObject1);
    paramTopicInfo = qxp.a("OidbSvc.0xc16", 3094, 0, localReqBody.toByteArray());
    this.jdField_a_of_type_Qep.a(paramTopicInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc16.RspBody localRspBody = new oidb_cmd0xc16.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
    long l = 0L;
    paramToServiceMsg = "";
    if (localRspBody.uint64_topic_id.has()) {
      l = localRspBody.uint64_topic_id.get();
    }
    if (localRspBody.bytes_topic_url.has()) {
      paramToServiceMsg = localRspBody.bytes_topic_url.get().toStringUtf8();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJCreateUGCTopicHandler.1(this, i, l, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qir
 * JD-Core Version:    0.7.0.1
 */