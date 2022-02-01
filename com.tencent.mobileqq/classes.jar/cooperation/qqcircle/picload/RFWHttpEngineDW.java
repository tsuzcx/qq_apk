package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class RFWHttpEngineDW
  extends RFWAbsPicDW
{
  private void downLoadByHttpEngine(@NotNull Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new RFWHttpEngineDW.1(this, paramOption, paramICallBackListener);
    localHttpNetReq.mReqUrl = paramOption.getUrl();
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramOption.getLocalPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
  }
  
  public void handlerDownLoad(Option paramOption, RFWAbsPicDW.ICallBackListener paramICallBackListener)
  {
    downLoadByHttpEngine(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWHttpEngineDW
 * JD-Core Version:    0.7.0.1
 */