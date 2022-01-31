import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.8;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowListInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.ReqBody;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.ReqFollowPara;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.RspBody;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.RspFollowData;

public class pfw
  extends pgp
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "";
  private List<qkw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private List<qkv> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long;
  private List<qkw> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private String j = "";
  private String k = "";
  
  public pfw(AppInterface paramAppInterface, awbw paramawbw, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawbw, paramExecutorService, parampuz, paramHandler);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (Integer)paramToServiceMsg.getAttribute("attr_follow_list_type");
    QLog.i("FollowingInfoModule", 1, "[handleGetFollowMemberListFromServer] reqType=" + localObject);
    paramToServiceMsg = new oidb_cmd0x977.RspBody();
    int i = pvb.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      QLog.e("FollowingInfoModule", 1, "[handleGetFollowMemberListFromServer] result = " + i);
      if (((Integer)localObject).intValue() != 3) {}
    }
    while (!paramToServiceMsg.msg_rsp_follow_data.has())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.1(this));
      do
      {
        return;
      } while (((Integer)localObject).intValue() != 2);
      this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.2(this));
      return;
    }
    paramObject = paramToServiceMsg.msg_rsp_follow_data.msg_follow_list;
    localObject = paramObject.rpt_follow_status_info.get();
    paramFromServiceMsg = paramToServiceMsg.msg_rsp_follow_data.bytes_cookie.get().toStringUtf8();
    long l = paramToServiceMsg.msg_rsp_follow_data.uint64_total_count.get();
    if (paramToServiceMsg.msg_rsp_follow_data.uint32_is_no_more_data.get() == 0) {}
    for (boolean bool = true; paramObject.uint32_follow_list_type.get() == 3; bool = false)
    {
      paramToServiceMsg = qoa.a((Iterable)localObject, new pfx(this));
      this.j = paramFromServiceMsg;
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_b_of_type_Long = l;
      this.jdField_b_of_type_JavaUtilList.addAll(paramToServiceMsg);
      this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.4(this, paramToServiceMsg, l, bool));
      return;
    }
    if (paramObject.uint32_follow_list_type.get() == 1)
    {
      paramToServiceMsg = qoa.a((Iterable)localObject, new pfy(this));
      this.k = paramFromServiceMsg;
      this.jdField_c_of_type_Long = l;
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_c_of_type_JavaUtilList.addAll(paramToServiceMsg);
      this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.6(this, paramToServiceMsg, l, bool));
      return;
    }
    paramToServiceMsg = qoa.a((Iterable)localObject, new pfz(this));
    this.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_JavaUtilList.addAll(paramToServiceMsg);
    this.jdField_a_of_type_AndroidOsHandler.post(new FollowListInfoModule.8(this, paramToServiceMsg, l, bool));
  }
  
  public List<qkw> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowingInfoModule", 0, "[requestFollowersListFromServer] mFollowingList=" + this.jdField_a_of_type_JavaUtilList + ", mFollowingListCookie=" + this.jdField_a_of_type_JavaLangString + ", listType=" + paramInt2);
    }
    oidb_cmd0x977.ReqBody localReqBody = new oidb_cmd0x977.ReqBody();
    localReqBody.uint64_uin.set(ors.a());
    oidb_cmd0x977.ReqFollowPara localReqFollowPara = new oidb_cmd0x977.ReqFollowPara();
    localReqFollowPara.op_type.set(2);
    localReqFollowPara.uint32_req_count.set(paramInt1);
    PBBytesField localPBBytesField = localReqFollowPara.bytes_cookie;
    Object localObject;
    if (paramInt2 == 2)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqFollowPara.uint32_follow_list_type.set(paramInt2);
      localObject = localReqFollowPara.uint32_need_kd_user_info;
      if (!paramBoolean) {
        break label222;
      }
    }
    label222:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      localReqFollowPara.uint32_no_check_friends.set(1);
      localReqBody.msg_req_follow_para.set(localReqFollowPara);
      localObject = pvb.a("OidbSvc.0x977", 2423, 5, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("attr_follow_list_type", Integer.valueOf(paramInt2));
      a((ToServiceMsg)localObject);
      return;
      localObject = this.k;
      break;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x977")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pfw
 * JD-Core Version:    0.7.0.1
 */