package dov.com.qq.im.ae.play;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import java.util.concurrent.Executor;

public class UrlConHttpClient
  implements IHttpClient
{
  private static final String TAG = UrlConHttpClient.class.getSimpleName();
  private IResponseListener mResponseListener;
  
  private void errorResponse(int paramInt, String paramString1, String paramString2)
  {
    if (this.mResponseListener != null) {
      this.mResponseListener.response(paramInt, 1, paramString1, paramString2);
    }
  }
  
  public void download(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    LogUtils.i(TAG, "开始下载文件:" + paramString2);
    if (TextUtils.isEmpty(paramString2))
    {
      LogUtils.e(TAG, "downUrl 无效：" + paramString2);
      return;
    }
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.2(this, paramString2, paramString3, paramInt, paramString1));
  }
  
  public void get(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      LogUtils.e(TAG, "url 无效：" + paramString2);
      return;
    }
    LogUtils.i(TAG, "GET 请求：" + paramString2);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.1(this, paramString2, paramInt, paramString1));
  }
  
  public void post(int paramInt, String paramString1, String paramString2) {}
  
  public void setResponseListener(IResponseListener paramIResponseListener)
  {
    LogUtils.i(TAG, "setResponseListener ");
    this.mResponseListener = paramIResponseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.UrlConHttpClient
 * JD-Core Version:    0.7.0.1
 */