package dov.com.qq.im.ae.camera.core;

import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.qmcf.QmcfManager;

class AECameraManager$3
  implements Runnable
{
  AECameraManager$3(AECameraManager paramAECameraManager, AECameraManager.CameraOpenCallback paramCameraOpenCallback) {}
  
  public void run()
  {
    boolean bool = true;
    AECameraManager.access$100(this.this$0, false);
    NewFlowCameraOperator localNewFlowCameraOperator;
    if (AECameraManager.access$200(this.this$0) == 1)
    {
      AECameraManager.access$202(this.this$0, 2);
      com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.a = AECameraManager.access$200(this.this$0);
      if (AECameraManager.access$300(this.this$0) != null)
      {
        localNewFlowCameraOperator = AECameraManager.access$300(this.this$0);
        if (AECameraManager.access$200(this.this$0) != 1) {
          break label120;
        }
      }
    }
    for (;;)
    {
      localNewFlowCameraOperator.a(bool);
      AECameraManager.access$402(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(AECameraManager.access$200(this.this$0));
      AECameraManager.access$000(this.this$0, this.val$cameraOpenCallback);
      return;
      AECameraManager.access$202(this.this$0, 1);
      break;
      label120:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */