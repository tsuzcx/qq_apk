package cooperation.ilive.host;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import aaav;
import com.tencent.TMG.utils.QLog;

final class IliveEnterGroupHost$1
  implements aaav<CertifiedAccountRead.StGetMainPageRsp>
{
  IliveEnterGroupHost$1(IliveHostCallback paramIliveHostCallback) {}
  
  public void onReceive(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    QLog.i("IliveEnterGroupHost", 1, "IliveEnterGroupHost getAnchorGroupList isSuccess = " + paramBoolean);
    IliveEnterGroupHost.access$000(paramBoolean, paramStGetMainPageRsp, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.host.IliveEnterGroupHost.1
 * JD-Core Version:    0.7.0.1
 */