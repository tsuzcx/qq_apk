package cooperation.vip.manager;

import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LoveZoneInfoHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.util.ProtocolUtils;

public class CheckLoveStateRequestManager
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
    return new CheckLoveStateRequestManager.1(this, paramIntent);
  }
  
  public void a(long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("currentUin", paramLong);
    b(localIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = a();
    if (paramIntent != null)
    {
      paramIntent = (LoveZoneInfoHandler)paramIntent.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER);
      if (paramIntent != null)
      {
        int i;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        } else {
          i = -1;
        }
        boolean bool = false;
        if (i == 1000)
        {
          paramFromServiceMsg = (sweet_pair_check_rsp)ProtocolUtils.decode(paramFromServiceMsg.getWupBuffer(), "getPairState");
          if (paramFromServiceMsg != null)
          {
            sweet_rsp_comm localsweet_rsp_comm = paramFromServiceMsg.rsp_comm;
            if (localsweet_rsp_comm != null)
            {
              if (localsweet_rsp_comm.retcode == 0) {
                bool = true;
              }
              paramIntent.a(bool, paramFromServiceMsg);
              return;
            }
          }
        }
        paramIntent.a(false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.CheckLoveStateRequestManager
 * JD-Core Version:    0.7.0.1
 */