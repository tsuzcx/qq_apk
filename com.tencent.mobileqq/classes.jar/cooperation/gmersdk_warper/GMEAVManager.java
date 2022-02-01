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
  private static GMEAVManager jdField_a_of_type_CooperationGmersdk_warperGMEAVManager = null;
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
    QLog.i("AVManager", 1, "getStartParams|param.sdkAppId=" + localGMEAVEngineStartParams.sdkAppId + ", param.accountType=" + localGMEAVEngineStartParams.accountType + ", param.appIdAt3rd=" + localGMEAVEngineStartParams.appIdAt3rd + ", param.identifier=" + localGMEAVEngineStartParams.identifier + ", param.engineCtrlType=" + localGMEAVEngineStartParams.engineCtrlType + ", param.nGameID=" + localGMEAVEngineStartParams.jdField_a_of_type_Int + ", param.lGameRoomID=" + localGMEAVEngineStartParams.jdField_a_of_type_Long);
    return localGMEAVEngineStartParams;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    byte[] arrayOfByte = QAVAuthBuffer.a().genAuthBuffer(Integer.parseInt(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.jdField_a_of_type_JavaLangString), Integer.parseInt(paramString), this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.c, Integer.parseInt(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.b), this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.d, 1800, -1);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).auth(-1L, arrayOfByte).avControlRole("user").autoCreateRoom(true).videoRecvMode(0).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public static GMEAVManager a(Context paramContext)
  {
    if (jdField_a_of_type_CooperationGmersdk_warperGMEAVManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationGmersdk_warperGMEAVManager == null) {
        jdField_a_of_type_CooperationGmersdk_warperGMEAVManager = new GMEAVManager(paramContext);
      }
      return jdField_a_of_type_CooperationGmersdk_warperGMEAVManager;
    }
    finally {}
  }
  
  public int a()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.exitRoom();
    }
    QLog.i("AVManager", 1, "exitRoom|ret=" + i);
    return i;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    int i = 0;
    AVChannelManager.setIMChannelType(1);
    com.tencent.TMG.utils.SoUtil.customLibPath = TMG_Downloader.a();
    AVLoggerChooser.setUseImsdk(false);
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext = AVContext.createInstance(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      if (AVContext.getSoExtractError() != 0) {
        i = AVContext.getSoExtractError();
      }
    }
    for (;;)
    {
      QLog.i("AVManager", 1, "startContext|ret=" + i);
      if (i != 0) {
        paramAVCallback.onComplete(i, "internal error.");
      }
      return;
      i = 1101;
      continue;
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.setAppVersion(this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$AppInfo.e);
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
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
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      if (this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$EnterRoomCallback != null) {
        this.jdField_a_of_type_CooperationGmersdk_warperGMEAVManager$EnterRoomCallback.a(1101, "context not started.");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl().startTRAEService();
    QLog.e("AVManager", 1, "enterRoom| try enter room implement!!!!!!!!!");
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.enterRoom(this.jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener, a(paramString, paramBoolean1, paramBoolean2, paramInt));
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableMic(paramBoolean, paramEnableMicCompleteCallback);
    }
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableSpeaker(paramBoolean, paramEnableSpeakerCompleteCallback);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {}
    for (int i = localAVAudioCtrl.getMicState();; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {}
    for (int i = localAVAudioCtrl.getSpeakerState();; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVManager
 * JD-Core Version:    0.7.0.1
 */