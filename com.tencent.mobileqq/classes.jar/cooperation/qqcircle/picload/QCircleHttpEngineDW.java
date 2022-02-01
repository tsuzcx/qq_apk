package cooperation.qqcircle.picload;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import org.jetbrains.annotations.NotNull;

public class QCircleHttpEngineDW
  extends AbsPicDW
{
  private void downLoadByHttpEngine(@NotNull Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new QCircleHttpEngineDW.1(this, paramOption, paramICallBackListener);
    localHttpNetReq.mReqUrl = paramOption.getUrl();
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramOption.getLocalPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    paramOption = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramOption instanceof QQAppInterface)) {
      ((QQAppInterface)paramOption).getNetEngine(0).sendReq(localHttpNetReq);
    }
  }
  
  public void handlerDownLoad(Option paramOption, AbsPicDW.ICallBackListener paramICallBackListener)
  {
    downLoadByHttpEngine(paramOption, paramICallBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleHttpEngineDW
 * JD-Core Version:    0.7.0.1
 */