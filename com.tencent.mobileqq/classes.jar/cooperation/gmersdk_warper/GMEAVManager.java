package cooperation.gmersdk_warper;

import android.content.Context;
import android.util.Log;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam.Builder;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.av.sig.QAVAuthBuffer;
import com.tencent.qphone.base.util.QLog;

public class GMEAVManager
{
  private static String f = "LimixiuAVManager";
  private static GMEAVManager h;
  AVContext a = null;
  GMEAVManager.EnterRoomCallback b = null;
  GMEAVManager.RoomInfoListener c = null;
  GMEAVManager.AppInfo d = null;
  String e = null;
  private Context g = null;
  private AVRoomMulti.EventListener i = new GMEAVManager.1(this);
  
  private GMEAVManager(Context paramContext)
  {
    this.g = paramContext;
    this.e = "user";
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    byte[] arrayOfByte = QAVAuthBuffer.a().genAuthBuffer(Integer.parseInt(this.d.a), Integer.parseInt(paramString), this.d.c, Integer.parseInt(this.d.b), this.d.d, 1800, -1);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).auth(-1L, arrayOfByte).avControlRole("user").autoCreateRoom(true).videoRecvMode(0).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public static GMEAVManager a(Context paramContext)
  {
    if (h == null) {
      try
      {
        if (h == null) {
          h = new GMEAVManager(paramContext);
        }
      }
      finally {}
    }
    return h;
  }
  
  private AVContext.StartParam c()
  {
    GMEAVEngineStartParams localGMEAVEngineStartParams = new GMEAVEngineStartParams();
    localGMEAVEngineStartParams.sdkAppId = Integer.parseInt(this.d.a);
    localGMEAVEngineStartParams.accountType = this.d.b;
    localGMEAVEngineStartParams.appIdAt3rd = this.d.a;
    localGMEAVEngineStartParams.identifier = this.d.c;
    localGMEAVEngineStartParams.engineCtrlType = 2;
    localGMEAVEngineStartParams.a = Integer.valueOf(this.d.f).intValue();
    localGMEAVEngineStartParams.b = Long.valueOf(this.d.g).longValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStartParams|param.sdkAppId=");
    localStringBuilder.append(localGMEAVEngineStartParams.sdkAppId);
    localStringBuilder.append(", param.accountType=");
    localStringBuilder.append(localGMEAVEngineStartParams.accountType);
    localStringBuilder.append(", param.appIdAt3rd=");
    localStringBuilder.append(localGMEAVEngineStartParams.appIdAt3rd);
    localStringBuilder.append(", param.identifier=");
    localStringBuilder.append(localGMEAVEngineStartParams.identifier);
    localStringBuilder.append(", param.engineCtrlType=");
    localStringBuilder.append(localGMEAVEngineStartParams.engineCtrlType);
    localStringBuilder.append(", param.nGameID=");
    localStringBuilder.append(localGMEAVEngineStartParams.a);
    localStringBuilder.append(", param.lGameRoomID=");
    localStringBuilder.append(localGMEAVEngineStartParams.b);
    QLog.i("AVManager", 1, localStringBuilder.toString());
    return localGMEAVEngineStartParams;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    AVChannelManager.setIMChannelType(1);
    com.tencent.TMG.utils.SoUtil.customLibPath = TMG_Downloader.a();
    int j = 0;
    AVLoggerChooser.setUseImsdk(false);
    if (this.a == null) {
      this.a = AVContext.createInstance(this.g, false);
    }
    Object localObject = this.a;
    if (localObject == null)
    {
      if (AVContext.getSoExtractError() != 0) {
        j = AVContext.getSoExtractError();
      } else {
        j = 1101;
      }
    }
    else
    {
      ((AVContext)localObject).setAppVersion(this.d.e);
      this.a.start(c(), null, paramAVCallback);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startContext|ret=");
    ((StringBuilder)localObject).append(j);
    QLog.i("AVManager", 1, ((StringBuilder)localObject).toString());
    if (j != 0) {
      paramAVCallback.onComplete(j, "internal error.");
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, GMEAVManager.EnterRoomCallback paramEnterRoomCallback)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.b = paramEnterRoomCallback;
    paramEnterRoomCallback = this.a;
    if (paramEnterRoomCallback == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      paramString = this.b;
      if (paramString != null) {
        paramString.a(1101, "context not started.");
      }
      return;
    }
    paramEnterRoomCallback.getAudioCtrl().startTRAEService();
    QLog.e("AVManager", 1, "enterRoom| try enter room implement!!!!!!!!!");
    this.a.enterRoom(this.i, a(paramString, paramBoolean1, paramBoolean2, paramInt));
  }
  
  public boolean a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((AVContext)localObject).getAudioCtrl();
    } else {
      localObject = null;
    }
    boolean bool = false;
    int j;
    if (localObject != null) {
      j = ((AVAudioCtrl)localObject).getMicState();
    } else {
      j = 0;
    }
    if (j != 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((AVContext)localObject).getAudioCtrl();
    } else {
      localObject = null;
    }
    boolean bool = false;
    int j;
    if (localObject != null) {
      j = ((AVAudioCtrl)localObject).getSpeakerState();
    } else {
      j = 0;
    }
    if (j != 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVManager
 * JD-Core Version:    0.7.0.1
 */