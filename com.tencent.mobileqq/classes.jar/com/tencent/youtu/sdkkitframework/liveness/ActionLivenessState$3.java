package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

class ActionLivenessState$3
  implements YTPoseDetectInterface.PoseDetectOnFrame
{
  ActionLivenessState$3(ActionLivenessState paramActionLivenessState) {}
  
  public void onCanReflect()
  {
    ActionLivenessState.access$902(this.this$0, YTPoseDetectInterface.getActReflectData());
  }
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    YtLogger.d(ActionLivenessState.access$200(), "YTPoseDetectInterface.poseDetect.onFailed: " + paramInt + " s: " + paramString1);
    ActionLivenessState.access$808(this.this$0);
    if (ActionLivenessState.access$800(this.this$0) > 3) {}
  }
  
  public void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    YtLogger.d(ActionLivenessState.access$200(), "收到视频上传通知，帧数：" + paramArrayOfByte.length + " 每帧width：" + paramInt1 + " 每帧height: " + paramInt2);
    int j;
    if (YtFSM.getInstance().getContext().currentRotateState >= 5) {
      j = paramInt1;
    }
    for (int i = paramInt2;; i = paramInt1)
    {
      if (!ActionLivenessState.access$1000(this.this$0).isEncodingStarted())
      {
        YtLogger.d(ActionLivenessState.access$200(), "??Start encoder");
        ActionLivenessState.access$1000(this.this$0).startEncoding(i, j, new File(ActionLivenessState.access$1100(this.this$0)));
      }
      YtLogger.d(ActionLivenessState.access$200(), "action framesize:" + paramArrayOfByte.length);
      int k = 0;
      Object localObject;
      while (k < paramArrayOfByte.length)
      {
        YtLogger.d(ActionLivenessState.access$200(), "Rotate yuv size" + paramInt1 + "x" + paramInt2 + " rotate:" + YtFSM.getInstance().getContext().currentRotateState);
        localObject = new YuvImage(paramArrayOfByte[k], 17, i, j, null);
        ActionLivenessState.access$1000(this.this$0).queueFrame((YuvImage)localObject);
        ActionLivenessState.access$1000(this.this$0).encode();
        k += 1;
      }
      if (!ActionLivenessState.access$700(this.this$0)) {
        YTPoseDetectInterface.reset();
      }
      for (;;)
      {
        return;
        ActionLivenessState.access$1000(this.this$0).stopEncoding();
        try
        {
          localObject = new FileInputStream(new File(ActionLivenessState.access$1100(this.this$0)));
          if (((FileInputStream)localObject).available() != 0) {
            paramArrayOfByte = new byte[((FileInputStream)localObject).available()];
          }
        }
        catch (IOException paramArrayOfByte)
        {
          for (;;)
          {
            try
            {
              ((FileInputStream)localObject).read(paramArrayOfByte);
              ((FileInputStream)localObject).close();
              ActionLivenessState.access$1200(this.this$0).put("frames", paramArrayOfByte);
              ActionLivenessState.access$1300(this.this$0).put("mediacodec_color_format", Integer.valueOf(ActionLivenessState.access$1000(this.this$0).getColorFormat()));
              if (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE)
              {
                YTPoseDetectInterface.getBestImage(new ActionLivenessState.3.2(this), true);
                return;
              }
              if (YtFSM.getInstance().getWorkMode() != YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
                break;
              }
              YTPoseDetectInterface.getBestImage(new ActionLivenessState.3.3(this), true);
              return;
              paramArrayOfByte = paramArrayOfByte;
              paramArrayOfByte = null;
              continue;
            }
            catch (IOException localIOException)
            {
              continue;
            }
            paramArrayOfByte = null;
          }
        }
      }
      j = paramInt2;
    }
  }
  
  public void onSuccess(int paramInt)
  {
    if (paramInt == 1)
    {
      YtLogger.d(ActionLivenessState.access$200(), "Detect pose with sequence " + ActionLivenessState.access$300(this.this$0).length);
      if (ActionLivenessState.access$500(this.this$0, ActionLivenessState.access$300(this.this$0), ActionLivenessState.access$400(this.this$0) + 1))
      {
        ActionLivenessState.access$600(this.this$0, new ActionLivenessState.3.1(this));
        YtLogger.w(ActionLivenessState.access$200(), "start check pose: " + ActionLivenessState.access$000(this.this$0));
      }
    }
    else
    {
      return;
    }
    YtLogger.w(ActionLivenessState.access$200(), "ready to perform reflect");
    ActionLivenessState.access$702(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.3
 * JD-Core Version:    0.7.0.1
 */