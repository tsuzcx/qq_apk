package cooperation.qzone.panorama.widget;

import cooperation.qzone.panorama.controller.GyroscopeSensorController.SensorChangeListener;

class PanoramaView$2
  implements GyroscopeSensorController.SensorChangeListener
{
  PanoramaView$2(PanoramaView paramPanoramaView) {}
  
  public void onSensorChange(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.this$0.changeRotate(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView.2
 * JD-Core Version:    0.7.0.1
 */