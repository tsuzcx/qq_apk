package cooperation.qzone;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;

public class QzoneIPCClient
{
  public static final String ACTION_PUT_CONFIG = "put_config";
  public static final String NAME = "QzoneIPCClientModule";
  public static final String TAG = "QzoneIPCClient";
  private static QzoneIPCClient mInstance;
  private QIPCModule serverCallbackModule = new QzoneIPCClient.1(this, "QzoneIPCClientModule");
  
  private QzoneIPCClient()
  {
    QIPCClientHelper.getInstance().register(this.serverCallbackModule);
  }
  
  public static QzoneIPCClient getInstance()
  {
    if (mInstance == null) {}
    try
    {
      mInstance = new QzoneIPCClient();
      return mInstance;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCClient
 * JD-Core Version:    0.7.0.1
 */