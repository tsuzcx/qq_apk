package cooperation.ilive.share;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;

class IliveShareHelper$3
  implements Runnable
{
  IliveShareHelper$3(IliveShareHelper paramIliveShareHelper) {}
  
  public void run()
  {
    QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "action_get_nick_name", null, new IliveShareHelper.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.3
 * JD-Core Version:    0.7.0.1
 */