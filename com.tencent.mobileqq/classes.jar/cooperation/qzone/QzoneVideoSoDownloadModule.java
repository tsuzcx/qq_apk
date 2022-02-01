package cooperation.qzone;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.DownloadResultCallback;
import eipc.EIPCResult;

public class QzoneVideoSoDownloadModule
  extends QIPCModule
{
  public static final String ACTION_CHECK_AVCODEC_IS_OK = "action_check_avcodec_is_ok";
  public static final String ACTION_DOWNLOAD_AVCODEC = "action_download_avcodec";
  public static final String KEY_DOWNLOAD_RESULT_RECEIVER = "key_download_result_receiver";
  public static final String KEY_ERROR_MESSAGE = "key_error_message";
  public static final String KEY_IS_AVCODEC_OK = "key_is_avcodec_ok";
  public static final String NAME = "QzoneVideoSoDownloadModule";
  public static final int RESULT_CODE_CONFIG_FAILED = -2;
  public static final int RESULT_CODE_DOWNLOAD_FAILED = -3;
  public static final int RESULT_CODE_FAILED = -1;
  public static final int RESULT_CODE_SUCCESS = 0;
  private static final String TAG = "QzoneVideoSoDownloadModule";
  private static QzoneVideoSoDownloadModule sInstance;
  
  private QzoneVideoSoDownloadModule(String paramString)
  {
    super(paramString);
  }
  
  public static QzoneVideoSoDownloadModule getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QzoneVideoSoDownloadModule("QzoneVideoSoDownloadModule");
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static ResultReceiver getReceiverForSending(DownloadResultCallback paramDownloadResultCallback)
  {
    Object localObject = new QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver(paramDownloadResultCallback);
    paramDownloadResultCallback = Parcel.obtain();
    ((QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver)localObject).writeToParcel(paramDownloadResultCallback, 0);
    paramDownloadResultCallback.setDataPosition(0);
    localObject = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramDownloadResultCallback);
    paramDownloadResultCallback.recycle();
    return localObject;
  }
  
  private void sendErrorMessage(ResultReceiver paramResultReceiver, int paramInt, String paramString)
  {
    if (paramResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_error_message", paramString);
      paramResultReceiver.send(paramInt, localBundle);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QzoneVideoSoDownloadModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVideoSoDownloadModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("action_download_avcodec".equals(paramString))
    {
      QLog.i("QzoneVideoSoDownloadModule", 1, "try download libavcodec");
      if ((NetworkUtil.isNetworkAvailable(null)) && (paramBundle != null))
      {
        paramString = (ResultReceiver)paramBundle.getParcelable("key_download_result_receiver");
        if (paramString == null)
        {
          QLog.e("QzoneVideoSoDownloadModule", 1, "receiver == null");
          return EIPCResult.createResult(-1, null);
        }
        ShortVideoResourceManager.b((QQAppInterface)localObject, new QzoneVideoSoDownloadModule.MyISVConfig(this, (QQAppInterface)localObject, paramString));
        return EIPCResult.createResult(0, new Bundle());
      }
      return EIPCResult.createResult(-1, null);
    }
    if ("action_check_avcodec_is_ok".equals(paramString))
    {
      boolean bool = VideoEnvironment.checkAndLoadAVCodec();
      paramString = new Bundle();
      paramString.putBoolean("key_is_avcodec_ok", bool);
      return EIPCResult.createResult(0, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule
 * JD-Core Version:    0.7.0.1
 */