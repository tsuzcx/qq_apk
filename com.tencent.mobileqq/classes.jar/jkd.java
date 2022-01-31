import android.os.Handler;
import android.os.Message;
import com.tencent.av.AVLog;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.opengl.effects.EffectsRenderController;

public class jkd
  extends CameraObserver
{
  public jkd(EffectsRenderController paramEffectsRenderController) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    AVLog.c(EffectsRenderController.jdField_a_of_type_JavaLangString, "onAfterOpenCamera: " + paramBoolean + "|" + paramInt);
    if (paramBoolean) {
      this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4).sendToTarget();
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    AVLog.c(EffectsRenderController.jdField_a_of_type_JavaLangString, "onAfterReopenCamera: " + paramBoolean);
    if (paramBoolean) {
      this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkd
 * JD-Core Version:    0.7.0.1
 */