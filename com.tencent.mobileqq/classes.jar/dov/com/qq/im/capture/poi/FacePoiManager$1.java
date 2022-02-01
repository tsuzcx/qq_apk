package dov.com.qq.im.capture.poi;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper.LocationPermissionCallback;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;

class FacePoiManager$1
  implements LocationPermissionHelper.LocationPermissionCallback
{
  public void onGetLocation()
  {
    this.a.a = new FacePoiManager.1.1(this, "NewStoryTakeVideoActivity");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.poi.FacePoiManager.1
 * JD-Core Version:    0.7.0.1
 */