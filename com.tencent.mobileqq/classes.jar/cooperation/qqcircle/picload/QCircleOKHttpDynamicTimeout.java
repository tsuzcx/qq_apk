package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;

public class QCircleOKHttpDynamicTimeout
  implements Interceptor
{
  private final int MAX_TIME_OUT = 120;
  private final int TIME_OUT_INTERVAL = 15;
  private volatile int mDynamicTimeOut = 0;
  
  public int getTimeOut()
  {
    return this.mDynamicTimeOut;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    Request localRequest = paramChain.request();
    return paramChain.withReadTimeout(this.mDynamicTimeOut, TimeUnit.SECONDS).withWriteTimeout(this.mDynamicTimeOut, TimeUnit.SECONDS).proceed(localRequest);
  }
  
  public void upDateTimeOut(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      this.mDynamicTimeOut = Math.min(120, this.mDynamicTimeOut + 15);
      break label41;
      this.mDynamicTimeOut = Math.max(15, this.mDynamicTimeOut - 15);
      label41:
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("----- upDateTimeOut isTimeOut: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" currentTimeOutConfig: ");
      localStringBuilder.append(this.mDynamicTimeOut);
      RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleOKHttpDynamicTimeout
 * JD-Core Version:    0.7.0.1
 */