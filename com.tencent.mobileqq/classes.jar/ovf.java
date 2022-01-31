import android.view.SurfaceHolder;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;

public class ovf
  implements IVideoViewBase.IVideoViewCallBack
{
  public ovf(TribeVideoPlugin paramTribeVideoPlugin) {}
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovf
 * JD-Core Version:    0.7.0.1
 */