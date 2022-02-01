package cooperation.qqreader;

import cooperation.qqreader.utils.Log;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class QRBridgeUtil$3
  implements WtTicketPromise
{
  QRBridgeUtil$3(String paramString) {}
  
  public void Done(Ticket paramTicket)
  {
    if (paramTicket != null)
    {
      Log.d("QRBridgeUtil", "preGetKeyInPreloadService : Done");
      paramTicket = (byte[])paramTicket._pskey_map.get(this.a);
      if (paramTicket != null) {
        QRBridgeUtil.access$000().put(this.a, new String(paramTicket));
      }
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    Log.d("QRBridgeUtil", "preGetKeyInPreloadService failed " + paramErrMsg);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    Log.d("QRBridgeUtil", "preGetKeyInPreloadService timeout!" + paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.3
 * JD-Core Version:    0.7.0.1
 */