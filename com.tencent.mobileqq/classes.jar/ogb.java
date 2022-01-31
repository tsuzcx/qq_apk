import android.opengl.EGL14;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ogb
  implements Runnable
{
  ogb(oga paramoga) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = QQStoryConstant.m + System.currentTimeMillis() + ".mp4";
    if (FileUtils.a((String)localObject)) {
      FileUtils.d((String)localObject);
    }
    QQFilterRenderManager localQQFilterRenderManager = new QQFilterRenderManager();
    localQQFilterRenderManager.b(this.a.jdField_a_of_type_Int, this.a.b);
    localQQFilterRenderManager.a(this.a.jdField_a_of_type_Int, this.a.b);
    localQQFilterRenderManager.b(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_Int, this.a.b);
    localQQFilterRenderManager.c(this.a.jdField_a_of_type_JavaUtilList);
    localQQFilterRenderManager.d(this.a.c);
    localObject = new EncodeConfig((String)localObject, this.a.jdField_a_of_type_Int, this.a.b, 3145728, 5, false, 0);
    ((EncodeConfig)localObject).d = this.a.c;
    ((EncodeConfig)localObject).a = EGL14.eglGetCurrentContext();
    HWVideoRecorder localHWVideoRecorder = new HWVideoRecorder();
    int j = this.a.c;
    if (j <= 1000)
    {
      i = j;
      if (j >= 1) {}
    }
    else
    {
      i = 20;
    }
    int i = 1000 / i;
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "startRecording");
    }
    j = this.a.jdField_a_of_type_JavaUtilList.size();
    localHWVideoRecorder.a((EncodeConfig)localObject, new ogc(this, this.a.c * (j * 2), i * 1000000, localQQFilterRenderManager, localHWVideoRecorder, localHWVideoRecorder, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogb
 * JD-Core Version:    0.7.0.1
 */