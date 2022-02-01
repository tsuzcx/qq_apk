package cooperation.vip.manager;

import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_PAIR.sweet_pair_byebye_rsp;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.util.ProtocolUtils;

public class LoverDisbandRequestManager
  extends CommonRequestManager
{
  public QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QzoneExternalRequest a(Intent paramIntent)
  {
    return new LoverDisbandRequestManager.1(this, paramIntent);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("currentUin", paramLong1);
    localIntent.putExtra("friendUin", paramLong2);
    b(localIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = (IntimateInfoHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
      paramIntent = String.valueOf(paramIntent.getLongExtra("friendUin", -1L));
      int i;
      if (paramFromServiceMsg != null) {
        i = paramFromServiceMsg.getResultCode();
      } else {
        i = -1;
      }
      if (i == 1000)
      {
        paramFromServiceMsg = (sweet_pair_byebye_rsp)ProtocolUtils.decode(paramFromServiceMsg.getWupBuffer(), "sweet_pair_byebye");
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = paramFromServiceMsg.rsp_comm;
          if (paramFromServiceMsg.retcode == 0)
          {
            ((IntimateInfoHandler)localObject).a(true, paramFromServiceMsg.retcode, paramFromServiceMsg.errmsg, paramIntent);
            return;
          }
          ((IntimateInfoHandler)localObject).a(false, paramFromServiceMsg.retcode, paramFromServiceMsg.errmsg, paramIntent);
        }
      }
      else
      {
        ((IntimateInfoHandler)localObject).a(false, -1, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.LoverDisbandRequestManager
 * JD-Core Version:    0.7.0.1
 */