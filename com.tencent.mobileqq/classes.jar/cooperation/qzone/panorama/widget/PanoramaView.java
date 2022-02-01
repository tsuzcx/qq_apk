package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.apollo.GLTextureView;
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
    if (this.builder == null) {}
    for (;;)
    {
      return;
      this.builder.setRenderMode(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.builder.setOpenGyroscopeSensor(false);
      }
      while ((this.gyroscopeSensorController != null) && (this.builder.isOpenGyroscopeSensor()))
      {
        this.gyroscopeSensorController.registerGyroscopeListener();
        return;
        this.builder.setOpenGyroscopeSensor(true);
      }
    }
  }
  
  public void changeRotate(float paramFloat1, float paramFloat2)
  {
    if (this.panoramaRenderer != null) {
      this.panoramaRenderer.setRotate(paramFloat1, paramFloat2);
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
      if (this.gyroscopeSensorController != null) {
        this.gyroscopeSensorController.unregisterGyroscopeListener();
      }
      if (this.panoramaRenderer != null) {
        this.panoramaRenderer.onRecycled();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.panoramaRenderer != null) && (this.builder != null))
    {
      this.builder.setTextureChange(true);
      super.onResume();
      if ((this.gyroscopeSensorController != null) && (this.builder.isOpenGyroscopeSensor())) {
        this.gyroscopeSensorController.registerGyroscopeListener();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */