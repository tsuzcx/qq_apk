package cooperation.qzone.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class QZoneConnectProcessor
{
  private static final String TAG = "QZonePluginManger";
  private static QZoneConnectProcessor sInstance;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private volatile boolean mProcessing;
  private LinkedList<QZoneConnectProcessor.WrappedServiceConnection> mQueue = new LinkedList();
  
  public static QZoneConnectProcessor get()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QZoneConnectProcessor();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void processInner(QZoneConnectProcessor.WrappedServiceConnection paramWrappedServiceConnection)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInner, " + paramWrappedServiceConnection + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = QZoneConnectProcessor.WrappedServiceConnection.access$100(paramWrappedServiceConnection).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, paramWrappedServiceConnection, 1);
        return;
      }
      catch (SecurityException paramWrappedServiceConnection) {}
    } while (!QLog.isColorLevel());
    QLog.i("QZonePluginManger", 2, "processInner", paramWrappedServiceConnection);
  }
  
  private void processInnerDelay(QZoneConnectProcessor.WrappedServiceConnection paramWrappedServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "processInnerDelay. " + paramInt + ", " + paramWrappedServiceConnection);
    }
    this.mHandler.postDelayed(new QZoneConnectProcessor.1(this, paramWrappedServiceConnection), paramInt);
  }
  
  public void cancel(ServiceConnection paramServiceConnection)
  {
    synchronized (this.mQueue)
    {
      Iterator localIterator = this.mQueue.iterator();
      while (localIterator.hasNext())
      {
        QZoneConnectProcessor.WrappedServiceConnection localWrappedServiceConnection = (QZoneConnectProcessor.WrappedServiceConnection)localIterator.next();
        if (QZoneConnectProcessor.WrappedServiceConnection.access$000(localWrappedServiceConnection) == paramServiceConnection) {
          QZoneConnectProcessor.WrappedServiceConnection.access$100(localWrappedServiceConnection).unbindService(localWrappedServiceConnection);
        }
      }
      return;
    }
  }
  
  public void process(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new QZoneConnectProcessor.WrappedServiceConnection(this, paramServiceConnection, ???, paramInt);
    if (this.mProcessing)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZonePluginManger", 2, "queue");
      }
      synchronized (this.mQueue)
      {
        this.mQueue.offer(paramServiceConnection);
        return;
      }
    }
    this.mProcessing = true;
    processInner(paramServiceConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneConnectProcessor
 * JD-Core Version:    0.7.0.1
 */