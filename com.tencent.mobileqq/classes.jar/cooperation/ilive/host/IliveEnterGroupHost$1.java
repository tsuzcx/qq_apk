package cooperation.ilive.host;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;

final class IliveEnterGroupHost$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  IliveEnterGroupHost$1(IliveHostCallback paramIliveHostCallback) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("IliveEnterGroupHost getAnchorGroupList isSuccess = ");
    paramBaseRequest.append(paramBoolean);
    QLog.i("IliveEnterGroupHost", 1, paramBaseRequest.toString());
    IliveEnterGroupHost.access$000(paramBoolean, paramStGetMainPageRsp, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.IliveEnterGroupHost.1
 * JD-Core Version:    0.7.0.1
 */