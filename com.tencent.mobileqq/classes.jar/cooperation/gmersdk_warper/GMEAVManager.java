package cooperation.gmersdk_warper;

import android.content.Context;
import android.util.Log;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
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
  private static GMEAVManager jdField_a_of_type_CooperationGmersdk_warperGMEAVManager;
  private static String b = "LimixiuAVManager";
  private Context jdField_a_of_type_AndroidContentContext = null;
  AVContext jdField_a_of_type_ComTencentTMGSdkAVContext = null;
  private AVRoomMulti.EventListener jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener = new GMEAVManager.1(this);
  GMEAVManager.AppInfo jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo = null;
  GMEAVManager.EnterRoomCallback jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$EnterRoomCallback = null;
  GMEAVManager.RoomInfoListener jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$RoomInfoListener = null;
  String jdField_a_of_type_JavaLangString = null;
  
  private GMEAVManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "user";
  }
  
  private AVContext.StartParam a()
  {
    GMEAVEngineStartParams localGMEAVEngineStartParams = new GMEAVEngineStartParams();
    localGMEAVEngineStartParams.sdkAppId = Integer.parseInt(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.jdField_a_of_type_JavaLangString);
    localGMEAVEngineStartParams.accountType = this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.b;
    localGMEAVEngineStartParams.appIdAt3rd = this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.jdField_a_of_type_JavaLangString;
    localGMEAVEngineStartParams.identifier = this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.c;
    localGMEAVEngineStartParams.engineCtrlType = 2;
    localGMEAVEngineStartParams.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.f).intValue();
    localGMEAVEngineStartParams.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.g).longValue();
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
    localStringBuilder.append(localGMEAVEngineStartParams.jdField_a_of_type_Int);
    localStringBuilder.append(", param.lGameRoomID=");
    localStringBuilder.append(localGMEAVEngineStartParams.jdField_a_of_type_Long);
    QLog.i("AVManager", 1, localStringBuilder.toString());
    return localGMEAVEngineStartParams;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    byte[] arrayOfByte = QAVAuthBuffer.a().genAuthBuffer(Integer.parseInt(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.jdField_a_of_type_JavaLangString), Integer.parseInt(paramString), this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.c, Integer.parseInt(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.b), this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.d, 1800, -1);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).auth(-1L, arrayOfByte).avControlRole("user").autoCreateRoom(true).videoRecvMode(0).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public static GMEAVManager a(Context paramContext)
  {
    if (jdField_a_of_type_CooperationGmersdk_warperGMEAVManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationGmersdk_warperGMEAVManager == null) {
          jdField_a_of_type_CooperationGmersdk_warperGMEAVManager = new GMEAVManager(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationGmersdk_warperGMEAVManager;
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTMGSdkAVContext;
    int i;
    if (localObject != null) {
      i = ((AVContext)localObject).exitRoom();
    } else {
      i = 1003;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitRoom|ret=");
    ((StringBuilder)localObject).append(i);
    QLog.i("AVManager", 1, ((StringBuilder)localObject).toString());
    return i;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    AVChannelManager.setIMChannelType(1);
    com.tencent.TMG.utils.SoUtil.customLibPath = TMG_Downloader.a();
    int i = 0;
    AVLoggerChooser.setUseImsdk(false);
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext = AVContext.createInstance(this.jdField_a_of_type_AndroidContentContext, false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentTMGSdkAVContext;
    if (localObject == null)
    {
      if (AVContext.getSoExtractError() != 0) {
        i = AVContext.getSoExtractError();
      } else {
        i = 1101;
      }
    }
    else
    {
      ((AVContext)localObject).setAppVersion(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.e);
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startContext|ret=");
    ((StringBuilder)localObject).append(i);
    QLog.i("AVManager", 1, ((StringBuilder)localObject).toString());
    if (i != 0) {
      paramAVCallback.onComplete(i, "internal error.");
    }
  }
  
  public void a(GMEAVManager.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo = paramAppInfo;
  }
  
  public void a(GMEAVManager.RoomInfoListener paramRoomInfoListener)
  {
    this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$RoomInfoListener = paramRoomInfoListener;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, GMEAVManager.EnterRoomCallback paramEnterRoomCallback)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$EnterRoomCallback = paramEnterRoomCallback;
    paramEnterRoomCallback = this.jdField_a_of_type_ComTencentTMGSdkAVContext;
    if (paramEnterRoomCallback == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      paramString = this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$EnterRoomCallback;
      if (paramString != null) {
        paramString.a(1101, "context not started.");
      }
      return;
    }
    paramEnterRoomCallback.getAudioCtrl().startTRAEService();
    QLog.e("AVManager", 1, "enterRoom| try enter room implement!!!!!!!!!");
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.enterRoom(this.jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener, a(paramString, paramBoolean1, paramBoolean2, paramInt));
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTMGSdkAVContext;
    if (localObject != null) {
      localObject = ((AVContext)localObject).getAudioCtrl();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((AVAudioCtrl)localObject).enableMic(paramBoolean, paramEnableMicCompleteCallback);
    }
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTMGSdkAVContext;
    if (localObject != null) {
      localObject = ((AVContext)localObject).getAudioCtrl();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((AVAudioCtrl)localObject).enableSpeaker(paramBoolean, paramEnableSpeakerCompleteCallback);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTMGSdkAVContext;
    if (localObject != null) {
      localObject = ((AVContext)localObject).getAudioCtrl();
    } else {
      localObject = null;
    }
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = ((AVAudioCtrl)localObject).getMicState();
    } else {
      i = 0;
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTMGSdkAVContext;
    if (localObject != null) {
      localObject = ((AVContext)localObject).getAudioCtrl();
    } else {
      localObject = null;
    }
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = ((AVAudioCtrl)localObject).getSpeakerState();
    } else {
      i = 0;
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVManager
 * JD-Core Version:    0.7.0.1
 */