package cooperation.qzone;

import amtl;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class QzoneVideoSoDownloadModule
  extends QIPCModule
{
  private static QzoneVideoSoDownloadModule a;
  
  private QzoneVideoSoDownloadModule(String paramString)
  {
    super(paramString);
  }
  
  public static ResultReceiver a(QzoneVideoSoDownloadModule.DownloadResultCallback paramDownloadResultCallback)
  {
    Object localObject = new QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver(paramDownloadResultCallback);
    paramDownloadResultCallback = Parcel.obtain();
    ((QzoneVideoSoDownloadModule.QzoneVideoSoDownloadResultReceiver)localObject).writeToParcel(paramDownloadResultCallback, 0);
    paramDownloadResultCallback.setDataPosition(0);
    localObject = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramDownloadResultCallback);
    paramDownloadResultCallback.recycle();
    return localObject;
  }
  
  public static QzoneVideoSoDownloadModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QzoneVideoSoDownloadModule("QzoneVideoSoDownloadModule");
      }
      return a;
    }
    finally {}
  }
  
  private void a(ResultReceiver paramResultReceiver, int paramInt, String paramString)
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
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoSoDownloadModule", 2, "action = " + paramString);
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
      if ((NetworkUtil.g(null)) && (paramBundle != null))
      {
        paramString = (ResultReceiver)paramBundle.getParcelable("key_download_result_receiver");
        if (paramString == null)
        {
          QLog.e("QzoneVideoSoDownloadModule", 1, "receiver == null");
          return EIPCResult.createResult(-1, null);
        }
        ShortVideoResourceManager.a((QQAppInterface)localObject, new amtl(this, (QQAppInterface)localObject, paramString));
        return EIPCResult.createResult(0, new Bundle());
      }
      return EIPCResult.createResult(-1, null);
    }
    if ("action_check_avcodec_is_ok".equals(paramString))
    {
      boolean bool = VideoEnvironment.e((AppInterface)localObject);
      paramString = new Bundle();
      paramString.putBoolean("key_is_avcodec_ok", bool);
      return EIPCResult.createResult(0, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule
 * JD-Core Version:    0.7.0.1
 */