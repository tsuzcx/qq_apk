package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.apollo.view.opengl.GLTextureView;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.controller.GyroscopeSensorController;
import cooperation.qzone.panorama.controller.GyroscopeSensorController.SensorChangeListener;
import cooperation.qzone.panorama.controller.PanoramaRenderer;
import cooperation.qzone.panorama.controller.TouchController;
import cooperation.qzone.panorama.util.PanoramaConfig.Builder;

public class PanoramaView
  extends GLTextureView
{
  private PanoramaConfig.Builder builder;
  private Context context;
  private GyroscopeSensorController gyroscopeSensorController;
  private OnPanoramaClickListener onPanoramaClickListener;
  private PanoramaRenderer panoramaRenderer;
  private PanoramaTouchListener panoramaTouchListener = new PanoramaView.1(this);
  private GyroscopeSensorController.SensorChangeListener sensorChangeListener = new PanoramaView.2(this);
  
  public PanoramaView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public PanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public void changeRenderMode(int paramInt)
  {
    PanoramaConfig.Builder localBuilder = this.builder;
    if (localBuilder == null) {
      return;
    }
    localBuilder.setRenderMode(paramInt);
    setRenderMode(paramInt);
    if (paramInt == 0) {
      this.builder.setOpenGyroscopeSensor(false);
    } else {
      this.builder.setOpenGyroscopeSensor(true);
    }
    if ((this.gyroscopeSensorController != null) && (this.builder.isOpenGyroscopeSensor())) {
      this.gyroscopeSensorController.registerGyroscopeListener();
    }
  }
  
  public void changeRotate(float paramFloat1, float paramFloat2)
  {
    PanoramaRenderer localPanoramaRenderer = this.panoramaRenderer;
    if (localPanoramaRenderer != null) {
      localPanoramaRenderer.setRotate(paramFloat1, paramFloat2);
    }
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.panoramaRenderer != null) && (this.builder != null))
    {
      super.onPause();
      if ((this.gyroscopeSensorController != null) && (this.builder.isOpenGyroscopeSensor())) {
        this.gyroscopeSensorController.unregisterGyroscopeListener();
      }
    }
  }
  
  public void onRecycled()
  {
    if (this.panoramaRenderer != null)
    {
      super.onPause();
      Object localObject = this.gyroscopeSensorController;
      if (localObject != null) {
        ((GyroscopeSensorController)localObject).unregisterGyroscopeListener();
      }
      localObject = this.panoramaRenderer;
      if (localObject != null) {
        ((PanoramaRenderer)localObject).onRecycled();
      }
    }
  }
  
  public void onResume()
  {
    if (this.panoramaRenderer != null)
    {
      PanoramaConfig.Builder localBuilder = this.builder;
      if (localBuilder != null)
      {
        localBuilder.setTextureChange(true);
        super.onResume();
        if ((this.gyroscopeSensorController != null) && (this.builder.isOpenGyroscopeSensor())) {
          this.gyroscopeSensorController.registerGyroscopeListener();
        }
      }
    }
  }
  
  public void setOnPanoramaClickListener(OnPanoramaClickListener paramOnPanoramaClickListener)
  {
    this.onPanoramaClickListener = paramOnPanoramaClickListener;
  }
  
  public void startShowPanorama(PanoramaConfig.Builder paramBuilder, OnPanoramaLoadingListener paramOnPanoramaLoadingListener)
  {
    if (paramBuilder == null) {
      return;
    }
    this.builder = paramBuilder;
    setEGLContextClientVersion(2);
    this.panoramaRenderer = new PanoramaRenderer(paramBuilder, paramOnPanoramaLoadingListener);
    setRenderer(this.panoramaRenderer);
    setRenderMode(paramBuilder.getRenderMode());
    if (paramBuilder.isOpenTouchMove()) {
      setOnTouchListener(new TouchController(this, this.context, this.panoramaTouchListener, paramBuilder));
    }
    this.gyroscopeSensorController = new GyroscopeSensorController(this.context, this.sensorChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */