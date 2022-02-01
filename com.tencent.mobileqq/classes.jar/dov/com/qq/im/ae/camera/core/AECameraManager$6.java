package dov.com.qq.im.ae.camera.core;

import bdbg;
import boiw;
import bpam;
import java.util.concurrent.atomic.AtomicInteger;

public class AECameraManager$6
  implements Runnable
{
  public AECameraManager$6(boiw paramboiw) {}
  
  public void run()
  {
    bpam.b("AECameraManager", "cameraStopPreview---ENTER");
    if (!boiw.b(this.this$0))
    {
      bpam.d("AECameraManager", "cameraStopPreview---EXIT, is not previewing");
      return;
    }
    boiw.a(this.this$0).a(false);
    boiw.a(this.this$0).set(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.6
 * JD-Core Version:    0.7.0.1
 */