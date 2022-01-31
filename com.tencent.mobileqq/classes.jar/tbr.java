import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.MakeVideoActivity;
import java.util.List;

public class tbr
  implements SurfaceHolder.Callback
{
  public tbr(MakeVideoActivity paramMakeVideoActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.a.jdField_a_of_type_AndroidHardwareCamera != null) {
          this.a.jdField_a_of_type_AndroidHardwareCamera.release();
        }
        paramSurfaceHolder = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
        if (MakeVideoActivity.a(this.a, this.a))
        {
          int j = Camera.getNumberOfCameras();
          if (j < 1) {
            return;
          }
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          i = 0;
          if (i < j)
          {
            Camera.getCameraInfo(i, localCameraInfo);
            if (localCameraInfo.facing != 1) {
              break label339;
            }
            this.a.jdField_a_of_type_AndroidHardwareCamera = Camera.open(1);
            Object localObject1 = this.a.jdField_a_of_type_AndroidHardwareCamera.getParameters();
            this.a.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(MakeVideoActivity.a(this.a).getHolder());
            Object localObject2 = ((Camera.Parameters)localObject1).getSupportedFocusModes();
            if (((List)localObject2).contains("continuous-video"))
            {
              ((Camera.Parameters)localObject1).setFocusMode("continuous-video");
              localObject2 = ((Camera.Parameters)localObject1).getSupportedPreviewSizes();
              localObject2 = MakeVideoActivity.a(this.a, (List)localObject2, paramSurfaceHolder.getWidth(), paramSurfaceHolder.getHeight());
              if (localObject2 != null) {
                ((Camera.Parameters)localObject1).setPreviewSize(((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height);
              }
              this.a.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)localObject1);
              this.a.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(90);
              this.a.jdField_a_of_type_AndroidHardwareCamera.startPreview();
              localObject1 = ((Camera.Parameters)localObject1).getSupportedVideoSizes();
              localObject1 = MakeVideoActivity.a(this.a, (List)localObject1, paramSurfaceHolder.getWidth(), paramSurfaceHolder.getHeight());
              if (localObject1 == null) {
                break label339;
              }
              this.a.f = ((Camera.Size)localObject1).width;
              this.a.g = ((Camera.Size)localObject1).height;
              break label339;
            }
            if (!((List)localObject2).contains("auto")) {
              continue;
            }
            ((Camera.Parameters)localObject1).setFocusMode("auto");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramSurfaceHolder)
      {
        Log.e(this.a.jdField_a_of_type_JavaLangString, paramSurfaceHolder.toString());
      }
      label339:
      i += 1;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.a.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      paramSurfaceHolder.removeCallback(this);
      this.a.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
      this.a.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.a.jdField_a_of_type_AndroidHardwareCamera.lock();
      this.a.jdField_a_of_type_AndroidHardwareCamera.release();
      this.a.jdField_a_of_type_AndroidHardwareCamera = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbr
 * JD-Core Version:    0.7.0.1
 */