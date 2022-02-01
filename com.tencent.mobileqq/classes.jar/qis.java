import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJDislikeArticleHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeParam;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.ReqBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.RspBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.UserDisLike;

public class qis
  extends qii
{
  public int a;
  public List<rpa> a;
  
  public qis(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  private oidb_cmd0x46f.DislikeParam a(roz paramroz)
  {
    oidb_cmd0x46f.DislikeParam localDislikeParam = new oidb_cmd0x46f.DislikeParam();
    localDislikeParam.uint64_articleid.set(paramroz.jdField_a_of_type_Long);
    localDislikeParam.uint32_reasonid.set(paramroz.jdField_a_of_type_Int);
    localDislikeParam.uint64_feeds_id.set(paramroz.b);
    localDislikeParam.uint64_biu_uin.set(paramroz.c);
    localDislikeParam.uint64_topic_id.set(paramroz.d);
    if ((paramroz.jdField_a_of_type_JavaLangString != null) && (paramroz.jdField_a_of_type_JavaLangString.length() > 0)) {
      localDislikeParam.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramroz.jdField_a_of_type_JavaLangString));
    }
    Object localObject1;
    Object localObject2;
    if ((paramroz.jdField_a_of_type_JavaUtilList != null) && (paramroz.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = paramroz.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localDislikeParam.rpt_uint64_tagid.add(localObject2);
      }
    }
    if ((paramroz.jdField_a_of_type_JavaUtilArrayList != null) && (paramroz.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramroz = paramroz.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramroz.hasNext())
      {
        localObject1 = (DislikeInfo)paramroz.next();
        localObject2 = new oidb_cmd0x46f.UserDisLike();
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_account_id.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).b));
        ((oidb_cmd0x46f.UserDisLike)localObject2).type.set(((DislikeInfo)localObject1).jdField_a_of_type_Int);
        ((oidb_cmd0x46f.UserDisLike)localObject2).uint64_dislike_tagid.set(((DislikeInfo)localObject1).jdField_a_of_type_Long);
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_tag_name.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).jdField_a_of_type_JavaLangString));
        localDislikeParam.rpt_user_dislike_list.add((MessageMicro)localObject2);
      }
    }
    return localDislikeParam;
  }
  
  private void a(int paramInt, List<rpa> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJDislikeArticleHandler.1(this, paramInt, paramList));
  }
  
  public void a(long paramLong, List<roz> paramList)
  {
    oidb_cmd0x46f.ReqBody localReqBody = new oidb_cmd0x46f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeParam localDislikeParam = a((roz)paramList.next());
      localReqBody.rpt_param_list.add(localDislikeParam);
    }
    paramList = qxp.a("OidbSvc.0x46f", 1135, 0, localReqBody.toByteArray());
    this.jdField_a_of_type_Qep.a(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x46f.RspBody();
    int j = 0;
    int i = 0;
    if (qxp.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      if (paramToServiceMsg.uint32_fail_count.has()) {
        i = paramToServiceMsg.uint32_fail_count.get();
      }
      j = i;
      if (!paramToServiceMsg.rpt_result_list.has()) {}
    }
    for (paramToServiceMsg = qxm.c(paramToServiceMsg.rpt_result_list.get());; paramToServiceMsg = null)
    {
      a(i, paramToServiceMsg);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qis
 * JD-Core Version:    0.7.0.1
 */