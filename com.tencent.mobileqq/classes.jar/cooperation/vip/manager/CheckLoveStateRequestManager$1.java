package cooperation.vip.manager;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_check_req;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;

class CheckLoveStateRequestManager$1
  extends QzoneExternalRequest
{
  CheckLoveStateRequestManager$1(CheckLoveStateRequestManager paramCheckLoveStateRequestManager, Intent paramIntent) {}
  
  public String getCmdString()
  {
    return "SweetQzoneService.getPairState";
  }
  
  public JceStruct getReq()
  {
    sweet_pair_check_req localsweet_pair_check_req = new sweet_pair_check_req();
    Object localObject = this.a;
    if (localObject != null)
    {
      long l = ((Intent)localObject).getLongExtra("currentUin", -1L);
      localObject = new sweet_req_comm();
      ((sweet_req_comm)localObject).opuin = l;
      ((sweet_req_comm)localObject).uin = l;
      ((sweet_req_comm)localObject).loveuin = 0L;
      ((sweet_req_comm)localObject).qua = QUA.getQUA3();
      ((sweet_req_comm)localObject).pf = 1;
      ((sweet_req_comm)localObject).src = 3;
      localsweet_pair_check_req.req_comm = ((sweet_req_comm)localObject);
    }
    return localsweet_pair_check_req;
  }
  
  public String uniKey()
  {
    return "getPairState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.CheckLoveStateRequestManager.1
 * JD-Core Version:    0.7.0.1
 */