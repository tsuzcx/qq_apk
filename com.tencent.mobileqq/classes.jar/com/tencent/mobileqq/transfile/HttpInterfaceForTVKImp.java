package com.tencent.mobileqq.transfile;

import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.BaseApplication;
import java.security.InvalidParameterException;
import java.util.HashMap;

public class HttpInterfaceForTVKImp
  extends HttpInterfaceForTVK
{
  public static final String TAG = "HttpInterfaceForTVKImp";
  private boolean bComPleted;
  private int errorCode;
  public String mErrDesc;
  public int mHttpCode;
  private HttpInterfaceForTVKImp.NetEngineResponseListener mINetEngineListener = new HttpInterfaceForTVKImp.NetEngineResponseListener(this, null);
  private Object obj = new Object();
  private int result;
  
  protected int downLoadSync(String arg1, String paramString2)
  {
    this.bComPleted = false;
    if ((??? == null) || (paramString2 == null)) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HttpInterfaceForTVKImp", 0, "downLoadSync, url = " + ??? + ", filePath = " + paramString2);
    }
    HttpNetReq localHttpNetReq;
    try
    {
      localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = this.mINetEngineListener;
      localHttpNetReq.mReqUrl = ???;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = paramString2;
      localHttpNetReq.mMsgId = String.valueOf(System.currentTimeMillis());
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if (!(??? instanceof QQAppInterface)) {
        throw new InvalidParameterException("can't get AppInterface");
      }
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HttpInterfaceForTVKImp", 0, "downLoadSync, setp 1", ???);
      }
    }
    for (;;)
    {
      synchronized (this.obj)
      {
        try
        {
          if (!this.bComPleted)
          {
            this.obj.wait(600000L);
            continue;
          }
          ???.put("param_isSuccess", "1");
        }
        catch (InterruptedException paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HttpInterfaceForTVKImp", 0, "downLoadSync, setp 2", paramString2);
          }
          ??? = new HashMap();
          if (this.result != 0) {
            break label295;
          }
        }
        ???.put("param_ErrorCode", String.valueOf(this.errorCode));
        ???.put("param_ErrDesc", this.mErrDesc);
        ???.put("param_HttpCode", String.valueOf(this.mHttpCode));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "HttpInterfaceForTVKImp", true, 0L, 0L, ???, "");
        return this.result;
        ((IHttpEngineService)((QQAppInterface)???).getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      }
      label295:
      ???.put("param_isSuccess", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpInterfaceForTVKImp
 * JD-Core Version:    0.7.0.1
 */