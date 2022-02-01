package cooperation.liveroom;

import android.os.IBinder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class LiveRoomPluginInstaller$MyOnPluginInstallListener
  implements OnPluginInstallListener
{
  private String from;
  
  public LiveRoomPluginInstaller$MyOnPluginInstallListener(LiveRoomPluginInstaller paramLiveRoomPluginInstaller, String paramString)
  {
    this.from = paramString;
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LiveRoomPluginInstaller", 2, "LiveRoom install begin");
    }
    LiveRoomHelper.report(this.from, "install", "begin", NetConnInfoCenter.getServerTimeMillis() - LiveRoomHelper.startTime);
    if (LiveRoomPluginInstaller.access$100(this.this$0)) {
      ((OnPluginInstallListener)LiveRoomPluginInstaller.access$200(this.this$0).get()).onInstallBegin(paramString);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LiveRoom install progress:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" of ");
      localStringBuilder.append(paramInt2);
      QLog.i("LiveRoomPluginInstaller", 2, localStringBuilder.toString());
    }
    if (LiveRoomPluginInstaller.access$100(this.this$0)) {
      ((OnPluginInstallListener)LiveRoomPluginInstaller.access$200(this.this$0).get()).onInstallDownloadProgress(paramString, paramInt1, paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    LiveRoomPluginInstaller.access$002(this.this$0, false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LiveRoom install error:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("LiveRoomPluginInstaller", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.from;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error");
    localStringBuilder.append(paramInt);
    LiveRoomHelper.report((String)localObject, "install", localStringBuilder.toString(), NetConnInfoCenter.getServerTimeMillis() - LiveRoomHelper.startTime);
    LiveRoomHelper.doReport();
    if (LiveRoomPluginInstaller.access$100(this.this$0)) {
      ((OnPluginInstallListener)LiveRoomPluginInstaller.access$200(this.this$0).get()).onInstallError(paramString, paramInt);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomPluginInstaller", 2, "LiveRoom install finish");
    }
    LiveRoomHelper.report(this.from, "install", "finish", NetConnInfoCenter.getServerTimeMillis() - LiveRoomHelper.startTime);
    LiveRoomHelper.doReport();
    if (LiveRoomPluginInstaller.access$100(this.this$0)) {
      ((OnPluginInstallListener)LiveRoomPluginInstaller.access$200(this.this$0).get()).onInstallFinish(paramString);
    }
    LiveRoomPluginLoader.preLoadPlugin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginInstaller.MyOnPluginInstallListener
 * JD-Core Version:    0.7.0.1
 */