import android.content.Context;
import android.view.Display;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.qphone.base.util.QLog;

class mca
  extends mef
{
  public mca(mbw parammbw, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    try
    {
      i = (this.a.jdField_a_of_type_AndroidViewDisplay.getRotation() * 90 + paramInt) % 360;
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b(i);
      }
      if (this.a.jdField_a_of_type_Mcb != null) {
        this.a.jdField_a_of_type_Mcb.a(paramInt, paramBoolean);
      }
      if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramInt);
      }
      this.a.g = paramInt;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("SmallScreenVideoController", 2, "onVideoOrientationChanged e = " + localException);
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mca
 * JD-Core Version:    0.7.0.1
 */