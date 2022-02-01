package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

class ActionLivenessState$6
  implements YTPoseDetectInterface.PoseDetectOnFrame
{
  ActionLivenessState$6(ActionLivenessState paramActionLivenessState) {}
  
  public void onCanReflect()
  {
    ActionLivenessState.access$902(this.this$0, YTPoseDetectInterface.getActReflectData());
  }
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    paramString2 = YtSDKStats.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pose state ");
    localStringBuilder.append(paramInt);
    paramString2.reportInfo(localStringBuilder.toString());
    paramString2 = ActionLivenessState.access$200();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("YTPoseDetectInterface.poseDetect.onFailed: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" s: ");
    localStringBuilder.append(paramString1);
    YtLogger.d(paramString2, localStringBuilder.toString());
    ActionLivenessState.access$808(this.this$0);
    ActionLivenessState.access$800(this.this$0);
  }
  
  public void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject1 = ActionLivenessState.access$200();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("收到视频上传通知，帧数：");
    ((StringBuilder)localObject2).append(paramArrayOfByte.length);
    ((StringBuilder)localObject2).append(" 每帧width：");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" 每帧height: ");
    ((StringBuilder)localObject2).append(paramInt2);
    YtLogger.d((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!ActionLivenessState.access$1000(this.this$0).isEncodingStarted())
    {
      YtLogger.d(ActionLivenessState.access$200(), "??Start encoder");
      localObject1 = ActionLivenessState.access$200();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("codec info: rotatedWith: ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("rotatedHeight: ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" bitrate: ");
      ((StringBuilder)localObject2).append(ActionLivenessState.access$1100(this.this$0));
      ((StringBuilder)localObject2).append(" framerate");
      ((StringBuilder)localObject2).append(ActionLivenessState.access$1200(this.this$0));
      ((StringBuilder)localObject2).append(" iframeinterval");
      ((StringBuilder)localObject2).append(ActionLivenessState.access$1300(this.this$0));
      YtLogger.i((String)localObject1, ((StringBuilder)localObject2).toString());
      ActionLivenessState.access$1000(this.this$0).startEncoding(paramInt1, paramInt2, new File(ActionLivenessState.access$1400(this.this$0)), ActionLivenessState.access$1100(this.this$0), ActionLivenessState.access$1200(this.this$0), ActionLivenessState.access$1300(this.this$0));
    }
    localObject1 = ActionLivenessState.access$200();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("action framesize:");
    ((StringBuilder)localObject2).append(paramArrayOfByte.length);
    YtLogger.d((String)localObject1, ((StringBuilder)localObject2).toString());
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localObject1 = ActionLivenessState.access$200();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Rotate yuv size");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("x");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" rotate:");
      ((StringBuilder)localObject2).append(YtFSM.getInstance().getContext().currentRotateState);
      YtLogger.d((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = new YuvImage(paramArrayOfByte[i], 17, paramInt1, paramInt2, null);
      ActionLivenessState.access$1000(this.this$0).queueFrame((YuvImage)localObject1);
      ActionLivenessState.access$1000(this.this$0).encode();
      i += 1;
    }
    if (!ActionLivenessState.access$700(this.this$0))
    {
      YTPoseDetectInterface.reset();
      return;
    }
    ActionLivenessState.access$1000(this.this$0).stopEncoding();
    localObject2 = null;
    paramArrayOfByte = null;
    localObject1 = localObject2;
    try
    {
      localObject3 = new FileInputStream(new File(ActionLivenessState.access$1400(this.this$0)));
      localObject1 = localObject2;
      if (((FileInputStream)localObject3).available() != 0)
      {
        localObject1 = localObject2;
        paramArrayOfByte = new byte[((FileInputStream)localObject3).available()];
      }
      localObject1 = paramArrayOfByte;
      ((FileInputStream)localObject3).read(paramArrayOfByte);
      localObject1 = paramArrayOfByte;
      ((FileInputStream)localObject3).close();
    }
    catch (Exception paramArrayOfByte)
    {
      localObject2 = ActionLivenessState.access$200();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Failed fetch action video ");
      ((StringBuilder)localObject3).append(paramArrayOfByte.getLocalizedMessage());
      YtLogger.e((String)localObject2, ((StringBuilder)localObject3).toString());
      paramArrayOfByte = (byte[][])localObject1;
    }
    ActionLivenessState.access$1500(this.this$0).put("frames", paramArrayOfByte);
    ActionLivenessState.access$1600(this.this$0).put("mediacodec_color_format", Integer.valueOf(ActionLivenessState.access$1000(this.this$0).getColorFormat()));
    if (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE)
    {
      YTPoseDetectInterface.getBestImage(new ActionLivenessState.6.1(this), true);
      return;
    }
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      YTPoseDetectInterface.getBestImage(new ActionLivenessState.6.2(this), true);
    }
  }
  
  public void onSuccess(int paramInt)
  {
    ActionLivenessState.access$102(this.this$0, "");
    if (paramInt == 1)
    {
      localObject = ActionLivenessState.access$200();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Detect pose with sequence ");
      localStringBuilder.append(ActionLivenessState.access$300(this.this$0).length);
      YtLogger.d((String)localObject, localStringBuilder.toString());
      if (YtFSM.getInstance().getContext().baseFunctionListener != null) {
        YtFSM.getInstance().getContext().baseFunctionListener.detectActionDone(ActionLivenessState.access$400(this.this$0));
      }
      localObject = this.this$0;
      if (ActionLivenessState.access$600((ActionLivenessState)localObject, ActionLivenessState.access$300((ActionLivenessState)localObject), ActionLivenessState.access$500(this.this$0) + 1))
      {
        localObject = ActionLivenessState.access$200();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("start check pose: ");
        localStringBuilder.append(ActionLivenessState.access$400(this.this$0));
        YtLogger.i((String)localObject, localStringBuilder.toString());
      }
      else
      {
        YtLogger.i(ActionLivenessState.access$200(), "action seq all done");
        ActionLivenessState.access$702(this.this$0, true);
      }
    }
    else if (paramInt == -4)
    {
      localObject = ActionLivenessState.access$200();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Act failed ");
      localStringBuilder.append(paramInt);
      YtLogger.w((String)localObject, localStringBuilder.toString());
      ActionLivenessState.access$102(this.this$0, "fl_act_light_not_right");
    }
    else if (paramInt == -5)
    {
      localObject = ActionLivenessState.access$200();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Act failed ");
      localStringBuilder.append(paramInt);
      YtLogger.w((String)localObject, localStringBuilder.toString());
      ActionLivenessState.access$102(this.this$0, "fl_act_screen_shaking");
    }
    else if ((paramInt != -1) && (paramInt != 0))
    {
      localObject = ActionLivenessState.access$200();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Act failed ");
      localStringBuilder.append(paramInt);
      YtLogger.w((String)localObject, localStringBuilder.toString());
    }
    Object localObject = YtSDKStats.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pose state ");
    localStringBuilder.append(paramInt);
    ((YtSDKStats)localObject).reportInfo(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.6
 * JD-Core Version:    0.7.0.1
 */