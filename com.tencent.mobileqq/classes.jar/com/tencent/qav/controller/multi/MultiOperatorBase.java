package com.tencent.qav.controller.multi;

import android.content.Context;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.QQGAudioCtrlCallback;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.channel.VideoChannelProxy;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class MultiOperatorBase
  implements QQGAudioCtrlCallback
{
  protected Context a;
  protected long b;
  protected QQGAudioCtrl c;
  protected VideoChannelInterface d;
  protected VideoChannelProxy e;
  
  public MultiOperatorBase(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramLong;
    this.d = paramVideoChannelInterface;
    this.e = new VideoChannelProxy(paramContext, paramVideoChannelInterface);
    a(paramBoolean);
  }
  
  private void a()
  {
    AVLog.c("MultiOperatorBase", "unInitGAudioCtrl");
    try
    {
      if (this.c != null)
      {
        this.c.uninit();
        this.c = null;
        return;
      }
    }
    catch (Exception localException)
    {
      AVLog.a("MultiOperatorBase", "unInitGAudioCtrl  fail.", localException);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initGAudioCtrl enableAINS:");
    localStringBuilder.append(paramBoolean);
    AVLog.c("MultiOperatorBase", localStringBuilder.toString());
    try
    {
      if (this.c == null)
      {
        this.c = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.c != null)
        {
          int i = QavCtrl.e();
          this.c.setCallback(this);
          this.c.setNetChannel(this.e);
          this.c.setAppId(AppSetting.d());
          this.c.setApType(i);
          this.c.init(this.a, this.b, 1, paramBoolean);
          ClientLogReport.instance().init(this.a, AppSetting.d());
          GAClientLogReport.instance();
          return;
        }
        AVLog.a("MultiOperatorBase", "initGAudioCtrl create instance fail.");
        return;
      }
    }
    catch (Exception localException)
    {
      AVLog.a("MultiOperatorBase", "initGAudioCtrl  fail.", localException);
      this.c = null;
    }
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    return 0L;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList) {}
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setEncodeDecodePtr, sessionType[2], clean[");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append("], isRemote[");
    ((StringBuilder)localObject1).append(paramBoolean2);
    ((StringBuilder)localObject1).append("], isMultiEngine[");
    ((StringBuilder)localObject1).append(true);
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("]");
    QLog.w("MultiOperatorBase", 1, ((StringBuilder)localObject1).toString());
    localObject1 = GraphicRenderMgr.getInstance();
    Object localObject2 = this.c;
    if (localObject2 != null)
    {
      paramLong = 0L;
      if (paramBoolean2)
      {
        if (paramBoolean1)
        {
          if (((IGraphicRender)localObject1).getDecodePtrRef() > 0) {
            ((IGraphicRender)localObject1).decreaseDecoderPtrRef();
          }
          if (((IGraphicRender)localObject1).getDecodePtrRef() == 0) {
            this.c.setProcessDecoderFrameFunctionptr(0L);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setEncodeDecodePtr, decoderPtrRef:=");
          ((StringBuilder)localObject2).append(((IGraphicRender)localObject1).getDecodePtrRef());
          QLog.w("MultiOperatorBase", 1, ((StringBuilder)localObject2).toString());
          return;
        }
        ((IGraphicRender)localObject1).increaseDecodePtrRef();
        if (((IGraphicRender)localObject1).getDecodePtrRef() >= 1)
        {
          paramLong = ((IGraphicRender)localObject1).getRecvDecoderFrameFunctionPtr();
          this.c.setProcessDecoderFrameFunctionptr(paramLong);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setEncodeDecodePtr, decoderPtrRef:=");
        ((StringBuilder)localObject2).append(((IGraphicRender)localObject1).getDecodePtrRef());
        QLog.w("MultiOperatorBase", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      if (!paramBoolean1) {
        paramLong = ((QQGAudioCtrl)localObject2).getEncodeFrameFunctionPtrFunPtr();
      }
      ((IGraphicRender)localObject1).setProcessEncodeFrameFunctionPtr(paramLong);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean b(long paramLong, int paramInt)
  {
    return false;
  }
  
  public void c(long paramLong, ArrayList<AVUserInfo> paramArrayList) {}
  
  public void j()
  {
    this.a = null;
    this.b = 0L;
    this.d = null;
    a();
  }
  
  public QQGAudioCtrl k()
  {
    return this.c;
  }
  
  public void onCheckScreenShareAvailable(int paramInt, byte[] paramArrayOfByte) {}
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2) {}
  
  public void onDetectAudioDataIssue(int paramInt) {}
  
  public void onDoubleVideoMeetingInvite(long paramLong, int paramInt1, int paramInt2) {}
  
  public void onEnterSuc(long paramLong, int paramInt1, int paramInt2) {}
  
  public void onFpsChange(int paramInt) {}
  
  public void onGAudioInvite(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onGAudioInviteResp(MavInviteData paramMavInviteData) {}
  
  public void onGAudioKickOut(long paramLong, int paramInt1, int paramInt2) {}
  
  public void onGAudioMemAllUpdate(long paramLong, ArrayList<AVUserInfo> paramArrayList, int paramInt1, int paramInt2) {}
  
  public void onGAudioMemAllUpdate(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2) {}
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void onGAudioMicSetByAdmin(long paramLong, int paramInt) {}
  
  public void onGAudioRoomDestroy(int paramInt, long paramLong) {}
  
  public void onGAudioRoomMicModeChanged(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGAudioSDKError(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void onGAudioSetMicFailed(int paramInt, ArrayList<AVUserInfo> paramArrayList) {}
  
  public void onGAudioTerminalEnterRoom(int paramInt, long paramLong, int... paramVarArgs) {}
  
  public void onGAudioUserAudioSuspectNoisy(long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void onGVideoDownloadChannelCtlChanged(byte[] paramArrayOfByte) {}
  
  public void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void onGroupChatModeChange(long paramLong, int paramInt1, int paramInt2) {}
  
  public void onGroupSecurityLimit(long paramLong1, long paramLong2, String paramString) {}
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void onHowling() {}
  
  public void onInitAIDenoiseStatus() {}
  
  public void onKickOutFail(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onKickOutSuc(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs) {}
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4) {}
  
  public void onNotifyAIDenoiseTips(boolean paramBoolean) {}
  
  public void onOpenMicFail() {}
  
  public void onPPTInOrOut(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  public void onRecSharePushEncParam(int paramInt, long paramLong, RecordParam paramRecordParam) {}
  
  public void onRemoteVideoDataComeIn(int paramInt1, long paramLong, int paramInt2) {}
  
  public void onSelfAudioVolumeChange(long paramLong) {}
  
  public void onSetMicBySelf(long paramLong) {}
  
  public void onShareOpsCallback(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5) {}
  
  public void onVideoSrcChange(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.controller.multi.MultiOperatorBase
 * JD-Core Version:    0.7.0.1
 */