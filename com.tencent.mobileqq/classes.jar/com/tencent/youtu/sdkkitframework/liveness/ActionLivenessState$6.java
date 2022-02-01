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
    YtSDKStats.getInstance().reportInfo("pose state " + paramInt);
    YtLogger.d(ActionLivenessState.access$200(), "YTPoseDetectInterface.poseDetect.onFailed: " + paramInt + " s: " + paramString1);
    ActionLivenessState.access$808(this.this$0);
    if (ActionLivenessState.access$800(this.this$0) > 3) {}
  }
  
  public void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    YtLogger.d(ActionLivenessState.access$200(), "收到视频上传通知，帧数：" + paramArrayOfByte.length + " 每帧width：" + paramInt1 + " 每帧height: " + paramInt2);
    if (!ActionLivenessState.access$1000(this.this$0).isEncodingStarted())
    {
      YtLogger.d(ActionLivenessState.access$200(), "??Start encoder");
      YtLogger.i(ActionLivenessState.access$200(), "codec info: rotatedWith: " + paramInt1 + "rotatedHeight: " + paramInt2 + " bitrate: " + ActionLivenessState.access$1100(this.this$0) + " framerate" + ActionLivenessState.access$1200(this.this$0) + " iframeinterval" + ActionLivenessState.access$1300(this.this$0));
      ActionLivenessState.access$1000(this.this$0).startEncoding(paramInt1, paramInt2, new File(ActionLivenessState.access$1400(this.this$0)), ActionLivenessState.access$1100(this.this$0), ActionLivenessState.access$1200(this.this$0), ActionLivenessState.access$1300(this.this$0));
    }
    YtLogger.d(ActionLivenessState.access$200(), "action framesize:" + paramArrayOfByte.length);
    int i = 0;
    Object localObject;
    while (i < paramArrayOfByte.length)
    {
      YtLogger.d(ActionLivenessState.access$200(), "Rotate yuv size" + paramInt1 + "x" + paramInt2 + " rotate:" + YtFSM.getInstance().getContext().currentRotateState);
      localObject = new YuvImage(paramArrayOfByte[i], 17, paramInt1, paramInt2, null);
      ActionLivenessState.access$1000(this.this$0).queueFrame((YuvImage)localObject);
      ActionLivenessState.access$1000(this.this$0).encode();
      i += 1;
    }
    if (!ActionLivenessState.access$700(this.this$0))
    {
      YTPoseDetectInterface.reset();
      return;
    }
    ActionLivenessState.access$1000(this.this$0).stopEncoding();
    for (;;)
    {
      try
      {
        localObject = new FileInputStream(new File(ActionLivenessState.access$1400(this.this$0)));
        if (((FileInputStream)localObject).available() == 0) {
          break label533;
        }
        paramArrayOfByte = new byte[((FileInputStream)localObject).available()];
        if (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
          break;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((FileInputStream)localObject).read(paramArrayOfByte);
          ((FileInputStream)localObject).close();
          ActionLivenessState.access$1500(this.this$0).put("frames", paramArrayOfByte);
          ActionLivenessState.access$1600(this.this$0).put("mediacodec_color_format", Integer.valueOf(ActionLivenessState.access$1000(this.this$0).getColorFormat()));
          if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
            break label503;
          }
          YTPoseDetectInterface.getBestImage(new ActionLivenessState.6.1(this), true);
          return;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        paramArrayOfByte = null;
        YtLogger.e(ActionLivenessState.access$200(), "Failed fetch action video " + localException1.getLocalizedMessage());
        continue;
      }
      label503:
      YTPoseDetectInterface.getBestImage(new ActionLivenessState.6.2(this), true);
      return;
      label533:
      paramArrayOfByte = null;
    }
  }
  
  public void onSuccess(int paramInt)
  {
    ActionLivenessState.access$102(this.this$0, "");
    if (paramInt == 1)
    {
      YtLogger.d(ActionLivenessState.access$200(), "Detect pose with sequence " + ActionLivenessState.access$300(this.this$0).length);
      if (YtFSM.getInstance().getContext().baseFunctionListener != null) {
        YtFSM.getInstance().getContext().baseFunctionListener.detectActionDone(ActionLivenessState.access$400(this.this$0));
      }
      if (ActionLivenessState.access$600(this.this$0, ActionLivenessState.access$300(this.this$0), ActionLivenessState.access$500(this.this$0) + 1)) {
        YtLogger.i(ActionLivenessState.access$200(), "start check pose: " + ActionLivenessState.access$400(this.this$0));
      }
    }
    for (;;)
    {
      YtSDKStats.getInstance().reportInfo("pose state " + paramInt);
      return;
      YtLogger.i(ActionLivenessState.access$200(), "action seq all done");
      ActionLivenessState.access$702(this.this$0, true);
      continue;
      if (paramInt == -4)
      {
        YtLogger.w(ActionLivenessState.access$200(), "Act failed " + paramInt);
        ActionLivenessState.access$102(this.this$0, "fl_act_light_not_right");
      }
      else if (paramInt == -5)
      {
        YtLogger.w(ActionLivenessState.access$200(), "Act failed " + paramInt);
        ActionLivenessState.access$102(this.this$0, "fl_act_screen_shaking");
      }
      else if ((paramInt != -1) && (paramInt != 0))
      {
        YtLogger.w(ActionLivenessState.access$200(), "Act failed " + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.6
 * JD-Core Version:    0.7.0.1
 */