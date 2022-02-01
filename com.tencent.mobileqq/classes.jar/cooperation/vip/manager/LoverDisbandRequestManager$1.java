package cooperation.vip.manager;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_byebye_req;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;

class LoverDisbandRequestManager$1
  extends QzoneExternalRequest
{
  LoverDisbandRequestManager$1(LoverDisbandRequestManager paramLoverDisbandRequestManager, Intent paramIntent) {}
  
  public String getCmdString()
  {
    return "SweetQzoneService.sweet_pair_byebye";
  }
  
  public JceStruct getReq()
  {
    sweet_pair_byebye_req localsweet_pair_byebye_req = new sweet_pair_byebye_req();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      long l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("currentUin", -1L);
      long l2 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("friendUin", -1L);
      sweet_req_comm localsweet_req_comm = new sweet_req_comm();
      localsweet_req_comm.opuin = l1;
      localsweet_req_comm.uin = l1;
      localsweet_req_comm.loveuin = l2;
      localsweet_req_comm.qua = QUA.getQUA3();
      localsweet_req_comm.pf = 1;
      localsweet_req_comm.src = 3;
      localsweet_pair_byebye_req.req_comm = localsweet_req_comm;
    }
    return localsweet_pair_byebye_req;
  }
  
  public String uniKey()
  {
    return "sweet_pair_byebye";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.manager.LoverDisbandRequestManager.1
 * JD-Core Version:    0.7.0.1
 */