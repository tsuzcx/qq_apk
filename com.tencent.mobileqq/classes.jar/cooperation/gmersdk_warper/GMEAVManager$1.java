package cooperation.gmersdk_warper;

import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti.AVCustomData;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.qphone.base.util.QLog;

class GMEAVManager$1
  implements AVRoomMulti.EventListener
{
  GMEAVManager$1(GMEAVManager paramGMEAVManager) {}
  
  public void onCameraSettingNotify(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onDisableAudioIssue() {}
  
  public void onEndpointsUpdateInfo(int paramInt, String[] paramArrayOfString)
  {
    QLog.i("AVManager", 1, String.format("onEndpointsUpdateInfo|eventid=%d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.a.c != null) {
      this.a.c.a(paramInt, paramArrayOfString);
    }
  }
  
  public void onEnterRoomComplete(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mRoomEventListener.onEnterRoomComplete| result = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString);
    QLog.i("AVManager", 1, localStringBuilder.toString());
    if (paramInt != 0) {
      this.a.a.getAudioCtrl().stopTRAEService();
    }
    if (this.a.b != null) {
      this.a.b.a(paramInt, paramString);
    }
  }
  
  public void onExitRoomComplete()
  {
    QLog.i("AVManager", 1, "mRoomEventListener.onExitRoomComplete");
    this.a.a.getAudioCtrl().stopTRAEService();
    if (this.a.c != null) {
      this.a.c.a();
    }
  }
  
  public void onHwStateChangeNotify(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void onPrivilegeDiffNotify(int paramInt) {}
  
  public void onRecvCustomData(AVRoomMulti.AVCustomData paramAVCustomData, String paramString) {}
  
  public void onRoomDisconnect(int paramInt, String paramString)
  {
    if (this.a.c != null) {
      this.a.c.a(paramInt, paramString);
    }
  }
  
  public void onRoomEvent(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void onSemiAutoRecvCameraVideo(String[] paramArrayOfString)
  {
    QLog.i("AVManager", 1, String.format("onSemiAutoRecvCameraVideo", new Object[0]));
    if (this.a.c != null) {
      this.a.c.a(paramArrayOfString);
    }
  }
  
  public void onSemiAutoRecvMediaFileVideo(String[] paramArrayOfString) {}
  
  public void onSemiAutoRecvScreenVideo(String[] paramArrayOfString) {}
  
  public void onSwitchRoomComplete(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVManager.1
 * JD-Core Version:    0.7.0.1
 */