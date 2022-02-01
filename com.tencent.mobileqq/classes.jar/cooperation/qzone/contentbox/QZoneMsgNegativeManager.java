package cooperation.qzone.contentbox;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class QZoneMsgNegativeManager
  implements Manager, BusinessObserver
{
  public static final String TAG = "QZoneMsgNegativeManager";
  public static final int TYPE_GUIDE_NEGATIVE = 0;
  private WeakReference<QQAppInterface> mAppRef;
  
  public QZoneMsgNegativeManager(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
  
  public QQAppInterface getApp()
  {
    WeakReference localWeakReference = this.mAppRef;
    if (localWeakReference != null) {
      return (QQAppInterface)localWeakReference.get();
    }
    return null;
  }
  
  public void onDestroy() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      QZLog.e("QZoneMsgNegativeManager", "onReceive isSuccess == false");
    }
  }
  
  public void sendRequest(QZoneMsgNegativeRequest paramQZoneMsgNegativeRequest)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return;
    }
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), QZoneCommonServlet.class);
    localQzoneCommonIntent.setRequest(paramQZoneMsgNegativeRequest);
    localQzoneCommonIntent.setObserver(this);
    localQQAppInterface.startServlet(localQzoneCommonIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgNegativeManager
 * JD-Core Version:    0.7.0.1
 */